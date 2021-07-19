/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class ThirdpartyInfo
extends BaseEntity {
    public int sessionId;
    public String uri;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ThirdpartyInfo{sessionId='");
        int c10 = this.sessionId;
        stringBuilder.append(c10);
        char c11 = '\'';
        stringBuilder.append(c11);
        stringBuilder.append(", uri='");
        String string2 = this.uri;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append(", errcode=");
        int n10 = this.errcode;
        stringBuilder.append(n10);
        stringBuilder.append(", errmsg='");
        string2 = this.errmsg;
        stringBuilder.append(string2);
        stringBuilder.append(c11);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

