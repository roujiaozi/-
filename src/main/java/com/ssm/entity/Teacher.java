package com.ssm.entity;

public class Teacher {
    private String tid;
    private String tname;
    private String tsex;
    private String tage;
    private String password;

    @Override
    public String toString() {
        return "Teacher{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", tsex='" + tsex + '\'' +
                ", tage='" + tage + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Teacher() {
    }

    public Teacher(String tid, String tname, String tsex, String tage, String password) {
        this.tid = tid;
        this.tname = tname;
        this.tsex = tsex;
        this.tage = tage;
        this.password = password;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTsex() {
        return tsex;
    }

    public void setTsex(String tsex) {
        this.tsex = tsex;
    }

    public String getTage() {
        return tage;
    }

    public void setTage(String tage) {
        this.tage = tage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
