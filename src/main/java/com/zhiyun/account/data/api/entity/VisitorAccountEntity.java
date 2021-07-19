/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.api.entity;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.net.BaseEntity;

public class VisitorAccountEntity
extends BaseEntity {
    private String token;
    private int userId;
    private UserInfo userInfo;

    public VisitorAccountEntity(int n10, String string2, UserInfo userInfo) {
        this.userId = n10;
        this.token = string2;
        this.userInfo = userInfo;
    }

    public String getToken() {
        return this.token;
    }

    public int getUserId() {
        return this.userId;
    }

    public UserInfo getUserInfo() {
        return this.userInfo;
    }

    public void setToken(String string2) {
        this.token = string2;
    }

    public void setUserId(int n10) {
        this.userId = n10;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}

