/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class ThirdpartyPollInfo
extends BaseEntity {
    public String code;
    public String platform;
    public int status;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ThirdpartyPollInfo{code='");
        String string2 = this.code;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", status='");
        int n10 = this.status;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        stringBuilder.append(", platform='");
        String string3 = this.platform;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", errcode=");
        n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        string3 = this.errmsg;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

