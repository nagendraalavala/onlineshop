package com.perficient.onlineshop.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Product implements Serializable {
    private static final long serialVersionUID=1L;
    private String category;
    private String pdname;
    private double pdcost;
    private String pddescp;
    private  int pdquantity;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPdname() {
        return pdname;
    }

    public void setPdname(String pdname) {
        this.pdname = pdname;
    }

    public double getPdcost() {
        return pdcost;
    }

    public void setPdcost(double pdcost) {
        this.pdcost = pdcost;
    }

    public String getPddesc() {
        return pddescp;
    }

    public void setPddesc(String pddesc) {
        this.pddescp = pddesc;
    }

    public  int getPdquantity() {
        return pdquantity;
    }

    public  void setPdquantity(int pdquantity) {
        this.pdquantity = pdquantity;
    }

    public Product(String category, String pdname, double pdcost, String pddesc, int pdquantity) {
        this.category = category;
        this.pdname = pdname;
        this.pdcost = pdcost;
        this.pddescp = pddesc;
        this.pdquantity = pdquantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        id = id;
    }

    public Product()
    {

    }
}