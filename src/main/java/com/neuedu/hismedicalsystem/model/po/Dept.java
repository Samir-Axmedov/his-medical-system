package com.neuedu.hismedicalsystem.model.po;

public class Dept {
    private int uRid;
    private String deptcode;
    private String deptname;
    private String deptcat;
    private String deptclass;


    public int getuRid() {
        return uRid;
    }

    public void setuRid(int uRid) {
        this.uRid = uRid;
    }

    public String getDeptcode() {
        return deptcode;
    }

    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getDeptcat() {
        return deptcat;
    }

    public void setDeptcat(String deptcat) {
        this.deptcat = deptcat;
    }

    public String getDeptclass() {
        return deptclass;
    }

    public void setDeptclass(String deptclass) {
        this.deptclass = deptclass;
    }
}
