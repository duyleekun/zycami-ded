/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.support.api.entity.push;

import com.huawei.hms.core.aidl.IMessageEntity;

public class ProfileReq
implements IMessageEntity {
    public int operation;
    public String pkgName;
    public String profileId;
    public String subjectId;
    public int type;

    public int getOperation() {
        return this.operation;
    }

    public String getPkgName() {
        return this.pkgName;
    }

    public String getProfileId() {
        return this.profileId;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public int getType() {
        return this.type;
    }

    public void setOperation(int n10) {
        this.operation = n10;
    }

    public void setPkgName(String string2) {
        this.pkgName = string2;
    }

    public void setProfileId(String string2) {
        this.profileId = string2;
    }

    public void setSubjectId(String string2) {
        this.subjectId = string2;
    }

    public void setType(int n10) {
        this.type = n10;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = ProfileReq.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append("{ pkgName: ");
        string2 = this.pkgName;
        stringBuilder.append(string2);
        stringBuilder.append(",subjectId: ");
        string2 = this.subjectId;
        stringBuilder.append(string2);
        stringBuilder.append(",operation: ");
        int n10 = this.operation;
        stringBuilder.append(n10);
        stringBuilder.append(" type: ");
        n10 = this.type;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

