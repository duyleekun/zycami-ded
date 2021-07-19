/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$j;
import d.r.a.h$t;
import d.r.a.i.q;
import d.r.a.s.c;

public final class q$a
implements Runnable {
    public final /* synthetic */ h$j a;
    public final /* synthetic */ q b;

    public q$a(q q10, h$j h$j) {
        this.b = q10;
        this.a = h$j;
    }

    public final void run() {
        q q10 = this.b;
        c c10 = q10.d;
        q10 = q.d(q10);
        Object object = this.a;
        int n10 = ((h$t)object).d;
        object = ((h$j)object).e;
        c10.onUnBind((Context)q10, n10, (String)object);
    }
}

