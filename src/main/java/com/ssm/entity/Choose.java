package com.ssm.entity;

public class Choose {
    private String  tid;
    private String tname;
    private String  cid;
    private String cname;
    private String  sid;

    @Override
    public String toString() {
        return "choose{" +
                "tid='" + tid + '\'' +
                ", tname='" + tname + '\'' +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                ", sid='" + sid + '\'' +
                '}';
    }

    public Choose() {
    }

    public Choose(String tid, String tname, String cid, String cname, String sid) {
        this.tid = tid;
        this.tname = tname;
        this.cid = cid;
        this.cname = cname;
        this.sid = sid;
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

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
