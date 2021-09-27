package com.ssm.entity;

public class Tassess {
    private String tid1; //测评的人 教师1对教师进行测评
    private String cid;
    private String cname;
    private String tid;
    private String tname;
    private int question1;
    private int question2;
    private int question3;

    @Override
    public String toString() {
        return "Tassess{" +
                "tid1='" + tid1 + '\'' +
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

    public String getTid1() {
        return tid1;
    }

    public void setTid1(String tid1) {
        this.tid1 = tid1;
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

    public Tassess() {
    }

    public Tassess(String tid1, String cid, String cname, String tid, String tname, int question1, int question2, int question3, int question4, int question5) {
        this.tid1 = tid1;
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

    private int question4;
    private int question5;


}
