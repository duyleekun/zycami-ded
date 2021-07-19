/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.aaid.entity;

import com.huawei.hms.core.aidl.IMessageEntity;

public class TokenResp
implements IMessageEntity {
    public String belongId;
    public int retCode = 0;
    public String subjectId;
    public String token = "";

    public String getBelongId() {
        return this.belongId;
    }

    public int getRetCode() {
        return this.retCode;
    }

    public String getSubjectId() {
        return this.subjectId;
    }

    public String getToken() {
        return this.token;
    }

    public void setBelongId(String string2) {
        this.belongId = string2;
    }

    public void setRetCode(int n10) {
        this.retCode = n10;
    }

    public void setSubjectId(String string2) {
        this.subjectId = string2;
    }

    public void setToken(String string2) {
        this.token = string2;
    }
}

