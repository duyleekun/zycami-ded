/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.a.a;
import com.tencent.liteav.f;
import com.tencent.liteav.m;
import com.tencent.liteav.q;

public class s {
    public static q a(Context context, int n10) {
        int n11 = 2;
        q q10 = n10 != n11 && n10 != (n11 = 4) && n10 != n11 && n10 != (n11 = 6) && n10 != (n11 = 3) ? new f(context) : new m(context);
        return q10;
    }

    public static String a() {
        return a.a();
    }
}

