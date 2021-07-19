/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.e.b$1;
import com.heytap.mcssdk.e.c;
import com.heytap.mcssdk.f.f;
import d.i.a.a.c.a;

public class b
implements c {
    public void a(Context context, a a10, d.i.a.a.b.b b10) {
        int n10;
        if (a10 == null) {
            return;
        }
        int n11 = a10.getType();
        if (n11 == (n10 = 4103)) {
            a10 = (d.i.a.a.c.b)a10;
            if (b10 != null) {
                b$1 b$1 = new b$1(this, b10, context, (d.i.a.a.c.b)a10);
                f.b(b$1);
            }
        }
    }
}

