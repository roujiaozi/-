package com.ssm.entity;

public class Sassess {
    private String sid;
    private String cid;
    private String cname;
    private String tid;
    private String tname;
    private int question1;
    private int question2;
    private int question3;
    private int question4;
    private int question5;

    @Override
    public String toString() {
        return "Sassess{" +
                "sid='" + sid + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", question1=" + question1 +
                ", question2=" + question2 +
                ", question3=" + question3 +
                ", question4=" + question4 +
                ", question5=" + question5 +
                '}';
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
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

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getQuestion1() {
        return question1;
    }

    public void setQuestion1(int question1) {
        this.question1 = question1;
    }

    public int getQuestion2() {
        return question2;
    }

    public void setQuestion2(int question2) {
        this.question2 = question2;
    }

    public int getQuestion3() {
        return question3;
    }

    public void setQuestion3(int question3) {
        this.question3 = question3;
    }

    public int getQuestion4() {
        return question4;
    }

    public void setQuestion4(int question4) {
        this.question4 = question4;
    }

    public int getQuestion5() {
        return question5;
    }

    public void setQuestion5(int question5) {
        this.question5 = question5;
    }

    public Sassess(String sid, String cid, String cname, String tid, String tname, int question1, int question2, int question3, int question4, int question5) {
        this.sid = sid;
        this.cid = cid;
        this.cname = cname;
        this.tid = tid;
        this.tname = tname;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
        this.question4 = question4;
        this.question5 = question5;
    }

    public Sassess() {
    }
}
