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
import androidx.navigation.NavDirections;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.i.a.s0;
import d.v.a.i.a.t0;
import d.v.a.i.a.v0.m;
import d.v.a.k.a;
import d.v.i0.b;

public class ThirdBindFragment
extends m {
    public GetCodeStatus a() {
        return GetCodeStatus.THIRD_BIND;
    }

    public void b(View view) {
        NavDirections navDirections = s0.a();
        a.c(view, navDirections);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        b.a(this).get(t0.class);
    }
}

