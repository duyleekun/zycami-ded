/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.google.gson.Gson;

public class AccountManager$AuthData {
    public String access_token;
    public String avatar;
    public long expires_at;
    public String nickname;
    public String openid;
    public String sex;
    public String unionid;

    public AccountManager$AuthData(String string2, String string3, String string4, String string5, String string6) {
        this.openid = string2;
        this.access_token = string3;
        this.nickname = string4;
        this.avatar = string5;
        this.sex = string6;
    }

    public String toJsonString() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }
}

