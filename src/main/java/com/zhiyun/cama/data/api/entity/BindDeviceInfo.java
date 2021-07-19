/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.zhiyun.cama.data.api.entity;

import android.text.TextUtils;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo$Theme;
import d.v.e.l.m1;
import d.v.e.l.q2.c;

public class BindDeviceInfo {
    private String activeAt;
    private String activeCode;
    private int activeUserId;
    private String bindAt;
    private int deviceId;
    private String deviceModel;
    private String deviceName;
    private boolean fetchSuccess;
    private String firmwareVersion;
    private int id;
    private String sn;
    private String theme;

    public BindDeviceInfo() {
    }

    public BindDeviceInfo(int n10, int n11, String string2, int n12, String string3, String string4, String string5, String string6, String string7, String string8) {
        this.id = n10;
        this.deviceId = n11;
        this.bindAt = string2;
        this.activeUserId = n12;
        this.sn = string3;
        this.activeCode = string4;
        this.theme = string5;
        this.activeAt = string6;
        this.deviceName = string7;
        this.deviceModel = string8;
    }

    public String getActiveAt() {
        return this.activeAt;
    }

    public String getActiveCode() {
        return this.activeCode;
    }

    public String getActiveTime() {
        return m1.O(this.activeAt);
    }

    public int getActiveUserId() {
        return this.activeUserId;
    }

    public String getBindAt() {
        return this.bindAt;
    }

    public String getBindTime() {
        return m1.O(this.bindAt);
    }

    public int getDeviceId() {
        return this.deviceId;
    }

    public String getDeviceModel() {
        return this.deviceModel;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getFirmwareVersion() {
        return this.firmwareVersion;
    }

    public int getId() {
        return this.id;
    }

    public String getSn() {
        return this.sn;
    }

    public BindDeviceInfo$Theme getTheme() {
        boolean bl2;
        String string2 = this.theme;
        if (string2 != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            String string3 = this.theme;
            return (BindDeviceInfo$Theme)c.a(BindDeviceInfo$Theme.class, string3);
        }
        return null;
    }

    public boolean isFetchSuccess() {
        return this.fetchSuccess;
    }

    public void setActiveAt(String string2) {
        this.activeAt = string2;
    }

    public void setActiveCode(String string2) {
        this.activeCode = string2;
    }

    public void setActiveUserId(int n10) {
        this.activeUserId = n10;
    }

    public void setBindAt(String string2) {
        this.bindAt = string2;
    }

    public void setDeviceId(int n10) {
        this.deviceId = n10;
    }

    public void setDeviceModel(String string2) {
        this.deviceModel = string2;
    }

    public void setDeviceName(String string2) {
        this.deviceName = string2;
    }

    public void setFetchSuccess(boolean bl2) {
        this.fetchSuccess = bl2;
    }

    public void setFirmwareVersion(String string2) {
        this.firmwareVersion = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setSn(String string2) {
        this.sn = string2;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("BindDeviceInfo{id=");
        int c10 = this.id;
        stringBuilder.append(c10);
        stringBuilder.append(", deviceId=");
        int n10 = this.deviceId;
        stringBuilder.append(n10);
        stringBuilder.append(", bindAt='");
        String string2 = this.bindAt;
        stringBuilder.append(string2);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", activeUserId=");
        int n11 = this.activeUserId;
        stringBuilder.append(n11);
        stringBuilder.append(", sn='");
        String string3 = this.sn;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", activeCode='");
        string3 = this.activeCode;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", theme=");
        string3 = this.theme;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", activeAt='");
        string3 = this.activeAt;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", deviceName='");
        string3 = this.deviceName;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append(", deviceModel='");
        string3 = this.deviceModel;
        stringBuilder.append(string3);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

