/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import com.xiaomi.mipush.sdk.e;
import com.xiaomi.mipush.sdk.h;
import com.xiaomi.push.hr;
import com.xiaomi.push.service.ak;
import com.xiaomi.push.service.ak$a;

public class f
extends ak$a {
    public final /* synthetic */ e a;

    public f(e e10, int n10, String string2) {
        this.a = e10;
        super(n10, string2);
    }

    public void onCallback() {
        ak ak2 = ak.a(e.a(this.a));
        int n10 = hr.ao.a();
        boolean bl2 = true;
        int n11 = ak2.a(n10, bl2);
        e e10 = this.a;
        n10 = (int)(e.a(e10) ? 1 : 0);
        if (n10 != n11) {
            e10 = this.a;
            e.a(e10, n11 != 0);
            ak2 = e.a(this.a);
            h.b((Context)ak2);
        }
    }
}

