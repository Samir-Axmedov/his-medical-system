package com.neuedu.hismedicalsystem.model.po;

import java.util.Date;

public class Template_all {
    private int tempid;
    private String tempname;
    private String temptype;
    private String tempscope;
    private Date createdate;

    public int getTempid() {
        return tempid;
    }

    public void setTempid(int tempid) {
        this.tempid = tempid;
    }

    public String getTempname() {
        return tempname;
    }

    public void setTempname(String tempname) {
        this.tempname = tempname;
    }

    public String getTemptype() {
        return temptype;
    }

    public void setTemptype(String temptype) {
        this.temptype = temptype;
    }

    public String getTempscope() {
        return tempscope;
    }

    public void setTempscope(String tempscope) {
        this.tempscope = tempscope;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}