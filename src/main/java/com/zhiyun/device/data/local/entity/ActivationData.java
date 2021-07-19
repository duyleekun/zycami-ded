/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.local.entity;

public class ActivationData {
    private String account;
    private String activeAt;
    private String activeCode;
    private String activeStatus;
    private String appVersion;
    private int deviceModel;
    private String deviceName;
    private String ex;
    private int id;
    private boolean isVisitor;
    private String latitude;
    private String longitude;
    private String serialNum;
    private int userId;

    public ActivationData(int n10, String string2, String string3, int n11, String string4, String string5, String string6, String string7, String string8, String string9, String string10, boolean bl2, String string11) {
        this.userId = n10;
        this.account = string2;
        this.serialNum = string3;
        this.deviceModel = n11;
        this.deviceName = string4;
        this.appVersion = string5;
        this.longitude = string6;
        this.latitude = string7;
        this.activeCode = string8;
        this.activeAt = string9;
        this.activeStatus = string10;
        this.isVisitor = bl2;
        this.ex = string11;
    }

    public String getAccount() {
        return this.account;
    }

    public String getActiveAt() {
        return this.activeAt;
    }

    public String getActiveCode() {
        return this.activeCode;
    }

    public String getActiveStatus() {
        return this.activeStatus;
    }

    public String getAppVersion() {
        return this.appVersion;
    }

    public int getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getEx() {
        return this.ex;
    }

    public int getId() {
        return this.id;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public String getSerialNum() {
        return this.serialNum;
    }

    public int getUserId() {
        return this.userId;
    }

    public boolean isVisitor() {
        return this.isVisitor;
    }

    public void setAccount(String string2) {
        this.account = string2;
    }

    public void setActiveAt(String string2) {
        this.activeAt = string2;
    }

    public void setActiveCode(String string2) {
        this.activeCode = string2;
    }

    public void setActiveStatus(String string2) {
        this.activeStatus = string2;
    }

    public void setAppVersion(String string2) {
        this.appVersion = string2;
    }

    public void setDeviceModel(int n10) {
        this.deviceModel = n10;
    }

    public void setDeviceName(String string2) {
        this.deviceName = string2;
    }

    public void setEx(String string2) {
        this.ex = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setLatitude(String string2) {
        this.latitude = string2;
    }

    public void setLongitude(String string2) {
        this.longitude = string2;
    }

    public void setSerialNum(String string2) {
        this.serialNum = string2;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }

    public void setVisitor(boolean bl2) {
        this.isVisitor = bl2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ActivationData{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", userId=");
        int n10 = this.userId;
        stringBuilder.append(n10);
        stringBuilder.append(", account='");
        String string2 = this.account;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", serialNum='");
        String string3 = this.serialNum;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", deviceModel=");
        int n11 = this.deviceModel;
        stringBuilder.append(n11);
        stringBuilder.append(", deviceName='");
        string3 = this.deviceName;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", appVersion='");
        string3 = this.appVersion;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", longitude='");
        string3 = this.longitude;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", latitude='");
        string3 = this.latitude;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", activeCode='");
        string3 = this.activeCode;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", activeAt='");
        string3 = this.activeAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", activeStatus='");
        string3 = this.activeStatus;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", isVisitor=");
        boolean bl2 = this.isVisitor;
        stringBuilder.append(bl2);
        stringBuilder.append(", ex='");
        string3 = this.ex;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

