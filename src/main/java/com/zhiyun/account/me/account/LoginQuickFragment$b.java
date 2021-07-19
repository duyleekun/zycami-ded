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
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.LoginQuickFragment;
import d.v.a.i.a.p0;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.f.i.g;

public class LoginQuickFragment$b {
    public final /* synthetic */ LoginQuickFragment a;

    public LoginQuickFragment$b(LoginQuickFragment loginQuickFragment) {
        this.a = loginQuickFragment;
    }

    public void a(View object) {
        Object object2 = LoginQuickFragment.j((LoginQuickFragment)this.a).b;
        boolean bl2 = object2.isChecked();
        if (!bl2) {
            object = LoginQuickFragment.k((LoginQuickFragment)this.a).x;
            object2 = this.a.getResources();
            int n10 = R$string.me_agress_zhiyun_please;
            object2 = g.o((Resources)object2, n10);
            ((j)object).setValue(object2);
        } else {
            object2 = this.a;
            LoginQuickFragment.l((LoginQuickFragment)object2, (View)object);
        }
    }

    public void b(View object) {
        Boolean bl2 = (Boolean)LoginQuickFragment.k((LoginQuickFragment)this.a).g.getValue();
        boolean bl3 = d.v.e.h.a.c(bl2);
        if (bl3) {
            object = LoginQuickFragment.k((LoginQuickFragment)this.a).g;
            bl2 = Boolean.FALSE;
            object.setValue(bl2);
        } else {
            boolean bl4 = d.v.a.k.a.g(object);
            if (!bl4) {
                object = this.a.getActivity();
                object.finishAfterTransition();
            }
        }
    }

    public void c(View view) {
        Object object = LoginQuickFragment.k((LoginQuickFragment)this.a).g;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
        object = p0.a();
        d.v.a.k.a.c(view, (NavDirections)object);
    }

    public void d(View view) {
        Object object = LoginQuickFragment.k((LoginQuickFragment)this.a).g;
        Boolean bl2 = Boolean.FALSE;
        ((MutableLiveData)object).setValue(bl2);
        object = p0.b();
        d.v.a.k.a.c(view, (NavDirections)object);
    }
}

