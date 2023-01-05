package org.hbrs.se2.project.dtos.impl;

import org.hbrs.se2.project.dtos.ReportsDTO;
import org.springframework.stereotype.Component;
import javax.validation.constraints.NotNull;

@Component
public class ReportsDTOImpl implements  ReportsDTO{

    private int reportid;
    @NotNull
    private int companyid;
    @NotNull
    private String text;
    @NotNull
    private int studentid;

    public ReportsDTOImpl(){}

    public  ReportsDTOImpl(int companyid, int studentid, String text){
        this.companyid = companyid;
        this.studentid = studentid;
        this.text = text;
    }

    @Override
    public int getReportid() {
        return reportid;
    }

    @Override
    public int getCompanyid() {
        return companyid;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public int getStudentid() {
        return studentid;
    }

    @Override
    public void setReportid(int reportid) {
        this.reportid = reportid;
    }

    @Override
    public void setCompanyid(int companyid) {
        this.companyid = companyid;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    @Override
    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

}
