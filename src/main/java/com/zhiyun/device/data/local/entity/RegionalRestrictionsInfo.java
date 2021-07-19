/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.local.entity;

public class RegionalRestrictionsInfo {
    private String deviceName;
    private String deviceSn;
    private int id;
    private boolean isRestrictions;

    public RegionalRestrictionsInfo(String string2, String string3, boolean bl2) {
        this.deviceName = string2;
        this.deviceSn = string3;
        this.isRestrictions = bl2;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public String getDeviceSn() {
        return this.deviceSn;
    }

    public int getId() {
        return this.id;
    }

    public boolean isRestrictions() {
        return this.isRestrictions;
    }

    public void setDeviceName(String string2) {
        this.deviceName = string2;
    }

    public void setDeviceSn(String string2) {
        this.deviceSn = string2;
    }

    public void setId(int n10) {
        this.id = n10;
    }

    public void setRestrictions(boolean bl2) {
        this.isRestrictions = bl2;
    }
}

