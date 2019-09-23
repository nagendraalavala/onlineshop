package com.perficient.onlineshop.transaction;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Transaction implements Serializable {
    private static final long serialVersionUID=1L;
    private String userid;
    private String pdid;
    private String tdate;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getPdid() {
        return pdid;
    }

    public void setPdid(String pdid) {
        this.pdid = pdid;
    }

    public String getTdate() {
        return tdate;
    }

    public void setTdate(String tdate) {
        this.tdate = tdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction(String userid, String pdid, String tdate) {
        this.userid = userid;
        this.pdid = pdid;
        this.tdate = tdate;
    }

    public Transaction()
    {

    }
}
