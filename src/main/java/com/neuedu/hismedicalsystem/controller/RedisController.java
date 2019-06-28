package com.neuedu.hismedicalsystem.controller;

import com.alibaba.fastjson.JSONObject;
import com.neuedu.hismedicalsystem.model.po.User;
import com.neuedu.hismedicalsystem.model.service.UserService;
import com.neuedu.hismedicalsystem.utils.ConstantKit;
import com.neuedu.hismedicalsystem.utils.Md5TokenGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/redis")
public class RedisController {
    Logger logger = LoggerFactory.getLogger(RedisController.class);

    @Autowired
    Md5TokenGenerator tokenGenerator;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @RequestMapping("/connect")
    public String connectRedis()
    {
        //string
        redisTemplate.opsForValue().set("spring", "test");

        //hash
        Map<String, String> m = new HashMap<>();
        m.put("name", "feiyy");
        m.put("password", "123");
        redisTemplate.opsForHash().putAll("feiyy", m);

        //list
        redisTemplate.opsForList().leftPush("mylist", "item1");
        redisTemplate.opsForList().leftPush("mylist", "item2");

        //set
        redisTemplate.opsForSet().add("myset", "set1");
        redisTemplate.opsForSet().add("myset", "set2");

        //zset
        redisTemplate.opsForZSet().add("articles", "article001", 100);
        redisTemplate.opsForZSet().add("articles", "article002", 200);

        return "{\"result\":true}";
    }

    @RequestMapping("/test")
    public String testRedis() {
        //string
        redisTemplate.opsForValue().set("KeyNG", "BowDown");

        return "{\"result\":true}";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public JSONObject login(String username, String password) {

        logger.info("username:"+username+"      password:"+password);

        User user = userService.loginGetUser(username,password);

        logger.info("user:"+user);

        JSONObject result = new JSONObject();
        if (user != null) {

            Jedis jedis = new Jedis("192.168.2.130", 6379);
            jedis.auth("545166");
            String token = tokenGenerator.generate(username, password);
            jedis.set(username, token);
            //设置key生存时间，当key过期时，它会被自动删除，时间是秒
            jedis.expire(username, ConstantKit.TOKEN_EXPIRE_TIME);
            jedis.set(token, username);
            jedis.expire(token, ConstantKit.TOKEN_EXPIRE_TIME);
            Long currentTime = System.currentTimeMillis();
            jedis.set(token + username, currentTime.toString());

            //用完关闭
            jedis.close();

            result.put("status", "登录成功");
            result.put("token", token);
        } else {
            result.put("status", "登录失败");
        }

        return result;

    }
}
