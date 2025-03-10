package com.zhoutong.learn.model;

import org.springframework.stereotype.Repository;

@Repository
public class JobInfo {
    private Integer pId;
    private Integer id;
    private String jobName;
    private String jobContent;

    public JobInfo(String jobName, String jobContent, Integer pId, Integer id) {
        this.jobName = jobName;
        this.jobContent = jobContent;
        this.pId = pId;
        this.id = id;
    }

    public JobInfo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobContent() {
        return jobContent;
    }

    public void setJobContent(String jobContent) {
        this.jobContent = jobContent;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    @Override
    public String toString() {
        return "JobInfo{" +
                "pId=" + pId +
                ", id=" + id +
                ", jobName='" + jobName + '\'' +
                ", jobContent='" + jobContent + '\'' +
                '}';
    }
}
