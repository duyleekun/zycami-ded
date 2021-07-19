/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.account.me.account;

import android.view.View;
import androidx.navigation.NavDirections;
import com.zhiyun.account.data.me.ThirdPlatform;
import com.zhiyun.account.me.account.AccountMainFragment;
import d.v.a.i.a.l0;
import d.v.a.i.a.m0;
import d.v.a.k.a;
import d.v.e.i.j;

public class AccountMainFragment$b {
    public final /* synthetic */ AccountMainFragment a;

    public AccountMainFragment$b(AccountMainFragment accountMainFragment) {
        this.a = accountMainFragment;
    }

    public void a(View object) {
        object = AccountMainFragment.j((AccountMainFragment)this.a).C;
        Boolean bl2 = Boolean.TRUE;
        ((j)object).setValue(bl2);
    }

    public void b(View view) {
        NavDirections navDirections = l0.a();
        d.v.a.k.a.c(view, navDirections);
    }

    public void c(View view) {
        NavDirections navDirections = l0.b();
        d.v.a.k.a.c(view, navDirections);
    }

    public void d(ThirdPlatform thirdPlatform) {
        m0 m02 = AccountMainFragment.j(this.a);
        View view = this.a.getView();
        m02.H(view, thirdPlatform);
    }
}

