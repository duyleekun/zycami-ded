/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.view.View
 */
package com.zhiyun.account.me.account;

import android.content.res.Resources;
import android.view.View;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.LoginFragment;
import d.v.a.i.a.m0;
import d.v.a.i.a.o0;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.f.i.g;

public class LoginFragment$a {
    public final /* synthetic */ LoginFragment a;

    public LoginFragment$a(LoginFragment loginFragment) {
        this.a = loginFragment;
    }

    public void a(View object) {
        Object object2 = LoginFragment.k((LoginFragment)this.a).a;
        boolean bl2 = object2.isChecked();
        if (!bl2) {
            object = LoginFragment.l((LoginFragment)this.a).x;
            object2 = this.a.getResources();
            int n10 = R$string.me_agress_zhiyun_please;
            object2 = g.o((Resources)object2, n10);
            ((j)object).setValue(object2);
        } else {
            object2 = LoginFragment.l(this.a);
            String string2 = LoginFragment.k((LoginFragment)this.a).e.getCountryCode();
            String string3 = LoginFragment.k((LoginFragment)this.a).e.getName();
            String string4 = LoginFragment.k((LoginFragment)this.a).f.getPass();
            ((m0)object2).r((View)object, string2, string3, string4);
        }
    }

    public void b(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.requireActivity();
            object.finishAfterTransition();
        }
    }

    public void c(View view) {
        NavDirections navDirections = o0.a();
        d.v.a.k.a.c(view, navDirections);
    }

    public void d(View view) {
        LoginFragment.j(this.a, view);
    }
}

