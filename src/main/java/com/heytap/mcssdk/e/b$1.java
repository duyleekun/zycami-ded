/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.heytap.mcssdk.e;

import android.content.Context;
import com.heytap.mcssdk.e.b;

public class b$1
implements Runnable {
    public final /* synthetic */ d.i.a.a.b.b a;
    public final /* synthetic */ Context b;
    public final /* synthetic */ d.i.a.a.c.b c;
    public final /* synthetic */ b d;

    public b$1(b b10, d.i.a.a.b.b b11, Context context, d.i.a.a.c.b b12) {
        this.d = b10;
        this.a = b11;
        this.b = context;
        this.c = b12;
    }

    public void run() {
        d.i.a.a.b.b b10 = this.a;
        Context context = this.b;
        d.i.a.a.c.b b11 = this.c;
        b10.a(context, b11);
    }
}

