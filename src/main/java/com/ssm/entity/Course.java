package com.ssm.entity;

public class Course {
    private String cid;
    private String cname;
    private String tid;
    private int credit;
    private String shape;
    private int remain;

    public Course() {
    }

    public Course(String cid, String cname, String tid, int credit, String shape, int remain) {
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.credit = credit;
        this.shape = shape;
        this.remain = remain;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Course{" +
                "cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", tid='" + tid + '\'' +
                ", credit=" + credit +
                ", shape='" + shape + '\'' +
                ", remain=" + remain +
                '}';
    }

    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getRemain() {
        return remain;
    }

    public void setRemain(int remain) {
        this.remain = remain;
    }
}
