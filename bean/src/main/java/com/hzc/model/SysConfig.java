package com.hzc.model;

import java.util.Date;

/**
 * 报名、打印准考证、考试等时间的配置，仅有一条记录
 */
public class SysConfig {
    private Integer id;

    private Date examStartTime;

    private Date examEndTime;

    private Date enrollmentStartTime;

    private Date enrollmentEndTime;

    private Date cardStartTime;

    private Date cardEndTime;

    private Date updateTime;

    private long examStartTimeL;

    private long examEndTimeL;

    private long enrollmentStartTimeL;

    private long enrollmentEndTimeL;

    private long cardStartTimeL;

    private long cardEndTimeL;

    public long getExamStartTimeL() {
        return examStartTimeL;
    }

    public void setExamStartTimeL(long examStartTimeL) {
        this.examStartTimeL = getExamStartTime().getTime();
    }

    public long getExamEndTimeL() {
        return examEndTimeL;
    }

    public void setExamEndTimeL(long examEndTimeL) {
        this.examEndTimeL = examEndTimeL;
    }

    public long getEnrollmentStartTimeL() {
        return enrollmentStartTimeL;
    }

    public void setEnrollmentStartTimeL(long enrollmentStartTimeL) {
        this.enrollmentStartTimeL = enrollmentStartTimeL;
    }

    public long getEnrollmentEndTimeL() {
        return enrollmentEndTimeL;
    }

    public void setEnrollmentEndTimeL(long enrollmentEndTimeL) {
        this.enrollmentEndTimeL = enrollmentEndTimeL;
    }

    public long getCardStartTimeL() {
        return cardStartTimeL;
    }

    public void setCardStartTimeL(long cardStartTimeL) {
        this.cardStartTimeL = cardStartTimeL;
    }

    public long getCardEndTimeL() {
        return cardEndTimeL;
    }

    public void setCardEndTimeL(long cardEndTimeL) {
        this.cardEndTimeL = cardEndTimeL;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getExamStartTime() {
        return examStartTime;
    }

    public void setExamStartTime(Date examStartTime) {
        this.examStartTime = examStartTime;
        setExamStartTimeL(examStartTime.getTime());
    }

    public Date getExamEndTime() {
        return examEndTime;
    }

    public void setExamEndTime(Date examEndTime) {
        this.examEndTime = examEndTime;
        setExamEndTimeL(examEndTime.getTime());
    }

    public Date getEnrollmentStartTime() {
        return enrollmentStartTime;
    }

    public void setEnrollmentStartTime(Date enrollmentStartTime) {
        this.enrollmentStartTime = enrollmentStartTime;
        setEnrollmentStartTimeL(enrollmentStartTime.getTime());
    }

    public Date getEnrollmentEndTime() {
        return enrollmentEndTime;
    }

    public void setEnrollmentEndTime(Date enrollmentEndTime) {
        this.enrollmentEndTime = enrollmentEndTime;
        setEnrollmentEndTimeL(enrollmentEndTime.getTime());
    }

    public Date getCardStartTime() {
        return cardStartTime;
    }

    public void setCardStartTime(Date cardStartTime) {
        this.cardStartTime = cardStartTime;
        setCardStartTimeL(cardStartTime.getTime());
    }

    public Date getCardEndTime() {
        return cardEndTime;
    }

    public void setCardEndTime(Date cardEndTime) {
        this.cardEndTime = cardEndTime;
        setCardEndTimeL(cardEndTime.getTime());
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}