/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.account.me.account;

import android.content.Context;
import android.view.View;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.SetPassFragment;
import d.v.a.i.a.m0;
import d.v.a.i.a.w0.c;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.f.i.g;

public class SetPassFragment$a {
    public final /* synthetic */ SetPassFragment a;

    public SetPassFragment$a(SetPassFragment setPassFragment) {
        this.a = setPassFragment;
    }

    public void a(View object) {
        Object object2 = SetPassFragment.k((SetPassFragment)this.a).a;
        int n10 = object2.getVisibility();
        if (n10 == 0 && (n10 = (int)((object2 = SetPassFragment.k((SetPassFragment)this.a).a).isChecked() ? 1 : 0)) == 0) {
            object = SetPassFragment.l((SetPassFragment)this.a).x;
            object2 = this.a.requireContext();
            int n11 = R$string.me_agress_zhiyun_please;
            object2 = g.m((Context)object2, n11);
            ((j)object).setValue(object2);
            return;
        }
        object2 = SetPassFragment.k((SetPassFragment)this.a).e.getPass();
        boolean n12 = c.e((String)object2);
        if (!n12) {
            object = SetPassFragment.l((SetPassFragment)this.a).x;
            object2 = this.a.requireContext();
            int n11 = R$string.me_pass_error;
            object2 = g.m((Context)object2, n11);
            ((j)object).setValue(object2);
            return;
        }
        Object object3 = SetPassFragment.k((SetPassFragment)this.a).f.getPass();
        boolean bl2 = ((String)object2).equals(object3);
        if (!bl2) {
            object = SetPassFragment.l((SetPassFragment)this.a).x;
            object2 = this.a.requireContext();
            int n13 = R$string.me_pass_not_equal;
            object2 = g.m((Context)object2, n13);
            ((j)object).setValue(object2);
            return;
        }
        object3 = SetPassFragment.l(this.a);
        boolean bl3 = SetPassFragment.k((SetPassFragment)this.a).b.isChecked();
        ((m0)object3).A((View)object, bl3, (String)object2);
    }

    public void b(View view) {
        d.v.a.k.a.g(view);
    }

    public void c(View view) {
        SetPassFragment.j(this.a);
    }
}

