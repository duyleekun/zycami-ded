/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class TokenReq
implements IMessageEntity {
    public String aaid;
    public String appId;
    public boolean firstTime;
    public boolean isFastApp = false;
    public boolean isMultiSender = false;
    public String packageName;
    public String projectId;
    public String scope;
    public String subjectId;

    public String getAaid() {
        return this.aaid;
    }

    public String getAppId() {
        return this.appId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public String getProjectId() {
        return this.projectId;
    }

    public String getScope() {
        return this.scope;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isFirstTime() {
        return this.firstTime;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAaid(String string2) {
        this.aaid = string2;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setFastApp(boolean bl2) {
        this.isFastApp = bl2;
    }

    public void setFirstTime(boolean bl2) {
        this.firstTime = bl2;
    }

    public void setMultiSender(boolean bl2) {
        this.isMultiSender = bl2;
    }

    public void setPackageName(String string2) {
        this.packageName = string2;
    }

    public void setProjectId(String string2) {
        this.projectId = string2;
    }

    public void setScope(String string2) {
        this.scope = string2;
    }

    public void setSubjectId(String string2) {
        this.subjectId = string2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = TokenReq.class.getName();
        stringBuffer.append(string2);
        stringBuffer.append("{");
        stringBuffer.append("pkgName: ");
        string2 = this.packageName;
        stringBuffer.append(string2);
        stringBuffer.append(",isFirstTime: ");
        boolean bl2 = this.firstTime;
        stringBuffer.append(bl2);
        stringBuffer.append(",scope:");
        string2 = this.scope;
        stringBuffer.append(string2);
        stringBuffer.append(",appId:");
        string2 = this.appId;
        stringBuffer.append(string2);
        stringBuffer.append(",projectId:");
        string2 = this.projectId;
        stringBuffer.append(string2);
        stringBuffer.append(",subjectId:");
        string2 = this.subjectId;
        stringBuffer.append(string2);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

