/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class DeleteTokenReq
implements IMessageEntity {
    public String appId;
    public int deleteType = 0;
    public boolean isFastApp = false;
    public boolean isMultiSender = false;
    public String pkgName;
    public String projectId;
    public String scope;
    public String subjectId;
    public String token;

    public String getAppId() {
        return this.appId;
    }

    public int getDeleteType() {
        return this.deleteType;
    }

    public String getPkgName() {
        return this.pkgName;
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

    public String getToken() {
        return this.token;
    }

    public boolean isFastApp() {
        return this.isFastApp;
    }

    public boolean isMultiSender() {
        return this.isMultiSender;
    }

    public void setAppId(String string2) {
        this.appId = string2;
    }

    public void setDeleteType(int n10) {
        this.deleteType = n10;
    }

    public void setFastApp(boolean bl2) {
        this.isFastApp = bl2;
    }

    public void setMultiSender(boolean bl2) {
        this.isMultiSender = bl2;
    }

    public void setPkgName(String string2) {
        this.pkgName = string2;
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

    public void setToken(String string2) {
        this.token = string2;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        String string2 = DeleteTokenReq.class.getName();
        stringBuffer.append(string2);
        stringBuffer.append("{");
        stringBuffer.append("pkgName: ");
        string2 = this.pkgName;
        stringBuffer.append(string2);
        stringBuffer.append(",scope:");
        string2 = this.scope;
        stringBuffer.append(string2);
        stringBuffer.append(",appId:");
        string2 = this.appId;
        stringBuffer.append(string2);
        stringBuffer.append(",projectId:");
        string2 = this.projectId;
        stringBuffer.append(string2);
        string2 = ",subjectId:";
        stringBuffer.append(string2);
        String string3 = this.subjectId;
        stringBuffer.append(string3);
        stringBuffer.append(string2);
        string2 = this.subjectId;
        stringBuffer.append(string2);
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

