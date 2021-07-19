/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.zhiyun.account.data.me.remote.AccountManager$AuthData;

public class AccountManager$ThirdBindData {
    public AccountManager$AuthData authData;
    public String platform;
    public String token;

    public AccountManager$ThirdBindData(String string2, String string3, AccountManager$AuthData accountManager$AuthData) {
        this.token = string2;
        this.platform = string3;
        this.authData = accountManager$AuthData;
    }
}

