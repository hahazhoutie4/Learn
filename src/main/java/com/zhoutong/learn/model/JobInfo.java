package com.zhoutong.learn.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;


public class JobInfo {
    private Integer pId;
    private Integer id;
    private String jobName;
    private String jobContent;
    private String jobSalary;
    private String cName;
    private String comPl;

    public JobInfo(Integer pId, Integer id, String jobName, String jobContent, String jobSalary, String cName, String comPl) {
        this.pId = pId;
        this.id = id;
        this.jobName = jobName;
        this.jobContent = jobContent;
        this.jobSalary = jobSalary;
        this.cName = cName;
        this.comPl = comPl;
    }

    public JobInfo() {
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobSalary() {
        return jobSalary;
    }

    public void setJobSalary(String jobSalary) {
        this.jobSalary = jobSalary;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getComPl() {
        return comPl;
    }

    public void setComPl(String comPl) {
        this.comPl = comPl;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "pId=" + pId +
                ", id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobContent='" + jobContent + '\'' +
                ", jobSalary='" + jobSalary + '\'' +
                ", cName='" + cName + '\'' +
                ", comPl='" + comPl + '\'' +
                '}';
    }
}
