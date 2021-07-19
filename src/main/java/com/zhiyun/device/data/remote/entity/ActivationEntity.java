/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.data.remote.entity;

import com.zhiyun.net.BaseEntity;

public class ActivationEntity
extends BaseEntity {
    private String activeAt;
    private String active_code;
    private int code_type = 1;

    public String getActiveAt() {
        return this.activeAt;
    }

    public String getActiveCode() {
        return this.active_code;
    }

    public int getCodeType() {
        return this.code_type;
    }

    public void setActiveAt(String string2) {
        this.activeAt = string2;
    }

    public void setActiveCode(String string2) {
        this.active_code = string2;
    }

    public void setCodeType(int n10) {
        this.code_type = n10;
    }
}

