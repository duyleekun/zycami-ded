/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.core.aidl;

import com.huawei.hms.core.aidl.IMessageEntity;
import java.util.List;

public class RequestHeader
implements IMessageEntity {
    private int apiLevel;
    private List apiNameList;
    private String appId;
    private String packageName;
    private int sdkVersion;
    private String sessionId;

    public RequestHeader() {
    }

    public RequestHeader(String string2, String string3, int n10, String string4) {
        this.appId = string2;
        this.packageName = string3;
        this.sdkVersion = n10;
        this.sessionId = string4;
    }

    public List getApiNameList() {
        return this.apiNameList;
    }

    public String getAppID() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public int getSdkVersion() {
        return this.sdkVersion;
    }

    public String getSessionId() {
        return this.sessionId;
    }

    public void setApiLevel(int n10) {
        this.apiLevel = n10;
    }

    public void setApiNameList(List list) {
        this.apiNameList = list;
    }

    public void setAppID(String string2) {
        this.appId = string2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setSdkVersion(int n10) {
        this.sdkVersion = n10;
    }

    public void setSessionId(String string2) {
        this.sessionId = string2;
    }
}

