/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.push.eq;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak$a;

public final class p
extends ak$a {
    public final /* synthetic */ Context a;

    public p(int n10, String string2, Context context) {
        this.a = context;
        super(n10, string2);
    }

    public void onCallback() {
        eq eq2 = eq.a(this.a);
        ak ak2 = ak.a(this.a);
        int n10 = hr.aF.a();
        int n11 = ak2.a(n10, 0);
        eq2.a(n11);
    }
}

