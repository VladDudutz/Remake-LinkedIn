package org.hbrs.se2.project.dtos.impl;

import org.hbrs.se2.project.dtos.CompanyDTO;

import javax.validation.constraints.NotEmpty;

public class CompanyDTOImpl implements CompanyDTO {
    private int companyid;
    private int userid;
    @NotEmpty
    private String name;
    private String industry;
    private boolean banned;
    private String contactdetails;

    public CompanyDTOImpl(){}
    public CompanyDTOImpl(int userid,String name, String industy, boolean banned, String contactdetails){
        this.userid=userid;
        this.name=name;
        this.industry=industy;
        this.banned=banned;
        this.contactdetails=contactdetails;
    }
    public void setCompanyid(int id) {
        this.companyid = id;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }
    public void setContactdetails(String contactdetails) { this.contactdetails = contactdetails;}

    @Override
    public int getCompanyid() {return companyid;}
    @Override
    public int getUserid() {
        return userid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getIndustry() {
        return industry;
    }

    @Override
    public boolean getBanned() {
        return banned;
    }
    @Override
    public String getContactdetails(){return contactdetails;}
}
