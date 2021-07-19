/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.remote.AccountManager;
import d.v.a.f.b.a;

public final class AccountManager$1
extends a {
    public final /* synthetic */ a val$callback;

    public AccountManager$1(a a10) {
        this.val$callback = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.val$callback;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(UserInfo userInfo) {
        a a10 = this.val$callback;
        if (a10 != null) {
            userInfo = AccountManager.convertUserInfoResponse(userInfo);
            a10.onSuccess(userInfo);
        }
    }
}

