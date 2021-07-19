/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package com.zhiyun.account.me.account;

import android.view.View;
import androidx.navigation.NavDirections;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.i.a.n0;
import d.v.a.i.a.v0.m;
import d.v.a.k.a;

public class ForgetPassFragment
extends m {
    public GetCodeStatus a() {
        return GetCodeStatus.FORGET_PASS;
    }

    public void b(View view) {
        NavDirections navDirections = n0.a();
        a.c(view, navDirections);
    }
}

