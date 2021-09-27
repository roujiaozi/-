package com.ssm.entity;

public class Student {
    private String sid;
    private String sname;
    private int sage;
    private int profession;
    private String password;

    @Override
    public String toString() {
        return "Student{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", sage=" + sage +
                ", profession=" + profession +
                ", password='" + password + '\'' +
                '}';
    }

    public Student(String sid, String sname, int sage, int profession, String password) {
        this.sid = sid;
        this.sname = sname;
        this.sage = sage;
        this.profession = profession;
        this.password = password;
    }

    public Student() {
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getProfession() {
        return profession;
    }

    public void setProfession(int profession) {
        this.profession = profession;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
