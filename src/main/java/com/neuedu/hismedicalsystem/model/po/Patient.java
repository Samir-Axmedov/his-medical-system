package com.neuedu.hismedicalsystem.model.po;

import java.sql.Date;
import java.util.List;

public class Patient {
    private int pid;
    private String pname;
    private boolean pgender;
    private int page;
    private Date pbirth;
    private String paddress;
    private String state;
    private int regid;

    private List<Exam> examList;

    public Patient(int pid, String pname, boolean pgender, int page, Date pbirth, String paddress) {
        this.pid = pid;
        this.pname = pname;
        this.pgender = pgender;
        this.page = page;
        this.pbirth = pbirth;
        this.paddress = paddress;
    }

    public Patient(int pid, String pname, boolean pgender, int page, Date pbirth, String paddress, String state) {
        this.pid = pid;
        this.pname = pname;
        this.pgender = pgender;
        this.page = page;
        this.pbirth = pbirth;
        this.paddress = paddress;
        this.state = state;
    }

    public Patient() {
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public boolean isPgender() {
        return pgender;
    }

    public void setPgender(boolean pgender) {
        this.pgender = pgender;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public Date getPbirth() {
        return pbirth;
    }

    public void setPbirth(Date pbirth) {
        this.pbirth = pbirth;
    }

    public String getPaddress() {
        return paddress;
    }

    public void setPaddress(String paddress) {
        this.paddress = paddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getRegid() {
        return regid;
    }

    public void setRegid(int regid) {
        this.regid = regid;
    }

    public List<Exam> getExamList() {
        return examList;
    }

    public void setExamList(List<Exam> examList) {
        this.examList = examList;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pgender=" + pgender +
                ", page=" + page +
                ", pbirth=" + pbirth +
                ", paddress='" + paddress + '\'' +
                ", state='" + state + '\'' +
                ", regid='" + regid + '\'' +
                '}';
    }
}
