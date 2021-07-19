/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.account.me.account;

import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.account.me.account.RegisterFragment;
import d.v.a.f.b.a;

public class RegisterFragment$a
extends a {
    public final /* synthetic */ RegisterFragment a;

    public RegisterFragment$a(RegisterFragment registerFragment) {
        this.a = registerFragment;
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }

    public void onSuccess(UserInfo userInfo) {
        RegisterFragment.P(this.a);
    }
}

