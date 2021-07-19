/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class AliyunEntity
extends BaseEntity {
    public String AccessKeyId;
    public String AccessKeySecret;
    public String Expiration;
    public String SecurityToken;

    public AliyunEntity() {
        String string2;
        this.AccessKeySecret = string2 = "";
        this.AccessKeyId = string2;
        this.Expiration = string2;
        this.SecurityToken = string2;
    }
}

