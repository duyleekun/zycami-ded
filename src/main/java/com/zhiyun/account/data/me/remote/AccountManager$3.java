/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.data.me.remote;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.data.me.remote.AccountManager;
import com.zhiyun.net.BaseEntity;
import d.v.a.f.b.a;
import d.v.a.f.c.d.d;

public final class AccountManager$3
extends a {
    public final /* synthetic */ a val$callback;
    public final /* synthetic */ int val$userId;

    public AccountManager$3(int n10, a a10) {
        this.val$userId = n10;
        this.val$callback = a10;
    }

    public void onError(Throwable throwable, int n10, String string2) {
        a a10 = this.val$callback;
        if (a10 != null) {
            a10.onError(throwable, n10, string2);
        }
    }

    public void onSuccess(UserInfo object) {
        int n10;
        int n11;
        int n12;
        UserInfo userInfo = AccountManager.convertUserInfoResponse((UserInfo)object);
        Object object2 = d.F();
        boolean n122 = ((d)object2).Q();
        if (n122 && (n12 = ((UserInfo)(object2 = d.F().L())).getId()) == (n11 = this.val$userId) && (n10 = ((BaseEntity)object).errcode) == 0) {
            object = d.F();
            ((d)object).c0(userInfo);
        }
        if ((object = this.val$callback) != null) {
            object.onSuccess(userInfo);
        }
    }
}

