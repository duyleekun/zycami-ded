/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.account.me.account;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.LoginQuickFragment;
import d.v.a.i.a.m0;
import d.v.a.i.a.y0.d$b;
import d.v.e.i.j;

public class LoginQuickFragment$a
implements d$b {
    public final /* synthetic */ LoginQuickFragment a;

    public LoginQuickFragment$a(LoginQuickFragment loginQuickFragment) {
        this.a = loginQuickFragment;
    }

    public void a(String string2, String string3, String string4) {
        m0 m02 = LoginQuickFragment.k(this.a);
        Context context = this.a.requireContext();
        String string5 = LoginQuickFragment.j((LoginQuickFragment)this.a).g.getCountryCode();
        String string6 = LoginQuickFragment.j((LoginQuickFragment)this.a).g.getName();
        m02.t(context, string5, string6, string2, string3, string4);
    }

    public void onFailed(String object) {
        object = LoginQuickFragment.k((LoginQuickFragment)this.a).x;
        Object object2 = this.a;
        int n10 = R$string.me_code_send_failed;
        object2 = ((Fragment)object2).getString(n10);
        ((j)object).setValue(object2);
    }
}

