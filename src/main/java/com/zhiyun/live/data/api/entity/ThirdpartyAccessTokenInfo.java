/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.live.data.api.entity;

import com.zhiyun.net.BaseEntity;

public class ThirdpartyAccessTokenInfo
extends BaseEntity {
    public String accessToken;
    public int expiresAt;
    public int expiresIn;
    public String openid;

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ThirdpartyAccessTokenInfo{accessToken='");
        String string2 = this.accessToken;
        stringBuilder.append(string2);
        char c10 = '\'';
        stringBuilder.append(c10);
        stringBuilder.append(", openid='");
        String string3 = this.openid;
        stringBuilder.append(string3);
        stringBuilder.append(c10);
        stringBuilder.append(", expiresAt='");
        int n10 = this.expiresAt;
        stringBuilder.append(n10);
        stringBuilder.append(c10);
        stringBuilder.append(", expiresIn='");
        n10 = this.expiresIn;
        stringBuilder.append(n10);
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

