/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package com.zhiyun.account.me.account.visitor;

import android.content.Context;
import android.view.View;
import androidx.navigation.NavDirections;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import d.v.a.i.a.t0;
import d.v.a.i.a.v0.m;
import d.v.a.k.a;
import d.v.i0.b;

public class VisitorBindFragment
extends m {
    public GetCodeStatus a() {
        return GetCodeStatus.THIRD_BIND;
    }

    public void b(View view) {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((d.v.a.f.c.b)object).s();
        boolean bl3 = true;
        if (bl2) {
            object = d.v.a.f.c.b.N();
            ((d.v.a.f.c.b)object).e(bl3);
        }
        object = d.v.a.i.a.x0.a.a().b(bl3);
        a.c(view, (NavDirections)object);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        b.a(this).get(t0.class);
    }
}

