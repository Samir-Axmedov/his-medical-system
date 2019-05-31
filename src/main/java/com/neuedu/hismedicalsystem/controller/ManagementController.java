package com.neuedu.hismedicalsystem.controller;

import com.neuedu.hismedicalsystem.model.po.*;
import com.neuedu.hismedicalsystem.model.service.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/management")
public class ManagementController {

    /**
     * constant
     */
    @Autowired
    private ConstService constService;

    @RequestMapping("/addConst")
    public void addConst(@RequestBody Constant condition) {
        try {
            constService.addConst(condition);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/delConst")
    public void delConst(@RequestBody int constid) {
        constService.delConst(constid);
    }

    @RequestMapping("/updateConst")
    public void updateConst(@RequestBody Constant condition) {
        constService.updateConst(condition);
    }

    @RequestMapping("/consts")
    public List<Constant> getConsts(@RequestBody Constant condition) {
        return constService.getConsts(condition);
    }

    /**
     * dept
     */
    @Autowired
    private DeptService deptService;

    @RequestMapping("/addDept")
    public String addDept(@RequestBody Dept dept) {
        System.out.println(dept.getDeptcode());
        try{
            deptService.addDept(dept);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delDept")
    public void delDept(String deptcode) {
        deptService.delDept(deptcode);
    }

    @RequestMapping("/updateDept")
    public void updateDept(@RequestBody Dept condition) {
        deptService.updateDept(condition);
    }

    @RequestMapping("/depts")
    public List<Dept> getDepts(@RequestBody Dept condition) {
        return deptService.getDepts(condition);
    }

    /**
     * disease
     */
    @Autowired
    private DisService disService;

    @RequestMapping("/addDis")
    public String addDis(@RequestBody Disease disease) {
        System.out.println(disease.getIcdcode());
        try {
            disService.addDis(disease);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delDis")
    public void delDis(String icdcode) {
        disService.delDis(icdcode);
    }

    @RequestMapping("/updateDis")
    public void updateDis(@RequestBody Disease condition) {
        disService.updateDis(condition);
    }

    @RequestMapping("/dis")
    public List<Disease> getDis(@RequestBody Disease condition) {
        return disService.getDis(condition);
    }

    /**
     * medicine
     */
    @Autowired
    private MedService medService;

    @RequestMapping("/addMed")
    public String addMed(@RequestBody Medicine medicine) {
        System.out.println(medicine.getItemcode());
        try {
            medService.addMed(medicine);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delMed")
    public void delMed(String itemcode) {
        medService.delMed(itemcode);
    }

    @RequestMapping("/updateMed")
    public void updateMed(@RequestBody Medicine condition) {
        medService.updateMed(condition);
    }

    @RequestMapping("/med")
    public List<Medicine> getMed(@RequestBody Medicine condition) {
        return medService.getMed(condition);
    }


    /**
     * non-medical
     */
    @Autowired
    private NonMedicService nonMedicService;

    @RequestMapping("/addNonMedic")
    public String addDept(@RequestBody NonMedic condition) {

        try {
            nonMedicService.addNonMedicItem(condition);
        } catch (Exception e) {
            e.printStackTrace();
            return "{\"result\":false}";
        }
        return "{\"result\":true}";
    }

    @RequestMapping("/delNonMedic")
    public void delNonMedic(String itemcode) {
        nonMedicService.delNonMedicItem(itemcode);
    }

    @RequestMapping("/updateNonMedic")
    public void updateNonMedic(@RequestBody NonMedic condition) {
        nonMedicService.updateNonMedicItem(condition);
    }

    @RequestMapping("/nonmedics")
    public List<NonMedic> getnonmedics(@RequestBody NonMedic condition) {
        return nonMedicService.getNonMedicItems(condition);
    }

    /**
     * rule
     */
    @Autowired
    private RuleService ruleService;

    @RequestMapping("/getRules")
    public List<Rule> getRules(String deptname) {
        return ruleService.getRules(deptname);
    }

    /**
     * shift
     */
    @Autowired
    private ShiftService shiftService;


    @RequestMapping("/shift")
    public List<Shift> getShift(Date dates, Date datee) {
        return shiftService.getShift(dates, datee);
    }

    @RequestMapping("/delShift")
    public void delShift(int shiftid) {
        shiftService.delShift(shiftid);
    }

    @RequestMapping("/delAllShift")
    public void delAllShift(@RequestBody Map<String,Object> params){
        String ids = params.get("ids").toString();
        String[] id=ids.split(",");
        shiftService.delAllShift(id);
    }

    /**
     * user
     */
    @Autowired
    private UserService userService;


    @RequestMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/updateUser")
    public void updateUser(@RequestBody User condition) {
        userService.updateUser(condition);
    }

    @RequestMapping("/deleteUser")
    public void deleteUser(String userid) {
        userService.deleteUser(userid);
    }


}
