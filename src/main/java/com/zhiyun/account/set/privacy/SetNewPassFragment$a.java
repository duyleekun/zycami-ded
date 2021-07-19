/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import androidx.core.app.ActivityCompat;
import com.zhiyun.account.R$string;
import com.zhiyun.account.set.privacy.SetNewPassFragment;
import d.v.a.i.a.w0.c;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.f.i.g;

public class SetNewPassFragment$a {
    public final /* synthetic */ SetNewPassFragment a;

    public SetNewPassFragment$a(SetNewPassFragment setNewPassFragment) {
        this.a = setNewPassFragment;
    }

    public void a(View object) {
        String string2 = SetNewPassFragment.j((SetNewPassFragment)this.a).b.getPass();
        int n10 = c.e(string2);
        if (n10 == 0) {
            object = SetNewPassFragment.k((SetNewPassFragment)this.a).q;
            string2 = this.a.requireContext();
            n10 = R$string.me_pass_error;
            string2 = g.m((Context)string2, n10);
            ((j)object).setValue(string2);
            return;
        }
        String string3 = SetNewPassFragment.j((SetNewPassFragment)this.a).c.getPass();
        n10 = string2.equals(string3);
        if (n10 == 0) {
            object = SetNewPassFragment.k((SetNewPassFragment)this.a).q;
            string2 = this.a.requireContext();
            n10 = R$string.me_pass_not_equal;
            string2 = g.m((Context)string2, n10);
            ((j)object).setValue(string2);
            return;
        }
        SetNewPassFragment.k(this.a).F((View)object, string2);
    }

    public void b(View object) {
        boolean bl2 = d.v.a.k.a.g(object);
        if (!bl2) {
            object = this.a.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }
}

