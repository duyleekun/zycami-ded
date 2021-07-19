/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.d.d;

public final class AccountManager$4
extends a {
    public final /* synthetic */ a val$callback;

    public AccountManager$4(a a10) {
        this.val$callback = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.val$callback;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(BaseEntity baseEntity) {
        int n10 = d.F().L().getId();
        a a10 = this.val$callback;
        AccountManager.queryUserDetail(n10, a10);
    }
}

