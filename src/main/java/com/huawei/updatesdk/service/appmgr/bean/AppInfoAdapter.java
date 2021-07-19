/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.service.appmgr.bean;

import java.util.List;

public class AppInfoAdapter {
    private String appId;
    private String appStorePkgName;
    private String business;
    private String carrierId;
    private boolean isShowImmediate = false;
    private int minIntervalDay = 0;
    private boolean mustBtnOne = false;
    private List packageList;
    private String serviceZone;
    private String targetPkgName;

    public String getAppId() {
        return this.appId;
    }

    public String getAppStorePkgName() {
        return this.appStorePkgName;
    }

    public String getBusiness() {
        return this.business;
    }

    public String getCarrierId() {
        return this.carrierId;
    }

    public int getMinIntervalDay() {
        return this.minIntervalDay;
    }

    public List getPackageList() {
        return this.packageList;
    }

    public String getServiceZone() {
        return this.serviceZone;
    }

    public String getTargetPkgName() {
        return this.targetPkgName;
    }

    public boolean isMustBtnOne() {
        return this.mustBtnOne;
    }

    public boolean isShowImmediate() {
        return this.isShowImmediate;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setAppStorePkgName(String string2) {
        this.appStorePkgName = string2;
    }

    public void setBusiness(String string2) {
        this.business = string2;
    }

    public void setCarrierId(String string2) {
        this.carrierId = string2;
    }

    public void setMinIntervalDay(int n10) {
        this.minIntervalDay = n10;
    }

    public void setMustBtnOne(boolean bl2) {
        this.mustBtnOne = bl2;
    }

    public void setPackageList(List list) {
        this.packageList = list;
    }

    public void setServiceZone(String string2) {
        this.serviceZone = string2;
    }

    public void setShowImmediate(boolean bl2) {
        this.isShowImmediate = bl2;
    }

    public void setTargetPkgName(String string2) {
        this.targetPkgName = string2;
    }
}

