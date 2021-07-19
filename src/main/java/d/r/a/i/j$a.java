/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$o;
import d.r.a.i.j;
import d.r.a.s.c;

public final class j$a
implements Runnable {
    public final /* synthetic */ h$o a;
    public final /* synthetic */ j b;

    public j$a(j j10, h$o o10) {
        this.b = j10;
        this.a = o10;
    }

    public final void run() {
        j j10 = this.b;
        c c10 = j10.d;
        j10 = j.d(j10);
        h$o h$o = this.a;
        String string2 = h$o.e;
        int n10 = h$o.f;
        boolean bl2 = h$o.g;
        c10.onLog((Context)j10, string2, n10, bl2);
    }
}

