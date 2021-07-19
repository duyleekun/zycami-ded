/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.prime.model;

import com.zhiyun.net.BaseEntity;
import d.v.e.h.d;

public class PrimeInfo
extends BaseEntity {
    private String activeTime;
    private String createAt;
    private int deviceId;
    private String endTime;
    private int getWay;
    private int hasRenew;
    private int id;
    private int inactive;
    private boolean isShowDialog;
    private int overdueTime;
    private int periodTime;
    private String startTime;
    private int status;
    private String updateAt;
    private int userId;

    public PrimeInfo() {
        String string2;
        this.activeTime = string2 = "";
        this.startTime = string2;
        this.endTime = string2;
        this.createAt = string2;
        this.updateAt = string2;
    }

    public String getActiveTime() {
        return this.activeTime;
    }

    public String getCreateAt() {
        return this.createAt;
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public String getEndTime() {
        return this.endTime;
    }

    public int getGetWay() {
        return this.getWay;
    }

    public int getHasRenew() {
        return this.hasRenew;
    }

    public int getId() {
        return this.id;
    }

    public int getInactive() {
        return this.inactive;
    }

    public boolean getIsShowDialog() {
        return this.isShowDialog;
    }

    public int getOverdueTime() {
        return this.overdueTime;
    }

    public int getPeriodTime() {
        return this.periodTime;
    }

    public String getStartTime() {
        return this.startTime;
    }

    public int getStatus() {
        return d.c(this.status);
    }

    public String getUpdateAt() {
        return this.updateAt;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setActiveTime(String string2) {
        this.activeTime = string2;
    }

    public void setCreateAt(String string2) {
        this.createAt = string2;
    }

    public void setDeviceId(int n10) {
        this.deviceId = n10;
    }

    public void setEndTime(String string2) {
        this.endTime = string2;
    }

    public void setGetWay(int n10) {
        this.getWay = n10;
    }

    public void setHasRenew(int n10) {
        this.hasRenew = n10;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setInactive(int n10) {
        this.inactive = n10;
    }

    public void setIsShowDialog(boolean bl2) {
        this.isShowDialog = bl2;
    }

    public void setOverdueTime(int n10) {
        this.overdueTime = n10;
    }

    public void setPeriodTime(int n10) {
        this.periodTime = n10;
    }

    public void setStartTime(String string2) {
        this.startTime = string2;
    }

    public void setStatus(int n10) {
        this.status = n10;
    }

    public void setUpdateAt(String string2) {
        this.updateAt = string2;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PrimeInfo{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", userId=");
        int n10 = this.userId;
        stringBuilder.append(n10);
        stringBuilder.append(", deviceId=");
        int n11 = this.deviceId;
        stringBuilder.append(n11);
        stringBuilder.append(", periodTime=");
        int n12 = this.periodTime;
        stringBuilder.append(n12);
        stringBuilder.append(", activeTime='");
        String string2 = this.activeTime;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", startTime='");
        String string3 = this.startTime;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", endTime='");
        string3 = this.endTime;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", hasRenew=");
        int n13 = this.hasRenew;
        stringBuilder.append(n13);
        stringBuilder.append(", status=");
        n13 = this.status;
        stringBuilder.append(n13);
        stringBuilder.append(", getWay=");
        n13 = this.getWay;
        stringBuilder.append(n13);
        stringBuilder.append(", createAt='");
        string3 = this.createAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", updateAt='");
        string3 = this.updateAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", inactive=");
        n13 = this.inactive;
        stringBuilder.append(n13);
        stringBuilder.append(", overdueTime=");
        n13 = this.overdueTime;
        stringBuilder.append(n13);
        stringBuilder.append(", isShowDialog=");
        n13 = (int)(this.isShowDialog ? 1 : 0);
        stringBuilder.append(n13 != 0);
        stringBuilder.append(", errcode=");
        n13 = this.errcode;
        stringBuilder.append(n13);
        stringBuilder.append(", errmsg='");
        string3 = this.errmsg;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

