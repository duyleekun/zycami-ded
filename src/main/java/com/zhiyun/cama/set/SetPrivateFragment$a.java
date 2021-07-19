/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.cama.set;

import android.view.View;
import com.zhiyun.account.set.ModifyPassActivity;
import com.zhiyun.account.set.PrivateBindActivity;
import com.zhiyun.cama.set.SetPrivateFragment;
import d.v.c.x1.l;

public class SetPrivateFragment$a {
    public final /* synthetic */ SetPrivateFragment a;

    public SetPrivateFragment$a(SetPrivateFragment setPrivateFragment) {
        this.a = setPrivateFragment;
    }

    public void a(View view) {
        l.g(view);
    }

    public void b(View view) {
        PrivateBindActivity.h(this.a.requireActivity());
    }

    public void c(View view) {
        ModifyPassActivity.j(this.a.requireActivity());
    }
}

