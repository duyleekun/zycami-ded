/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$s;
import d.r.a.h$t;
import d.r.a.i.n;
import d.r.a.s.c;

public final class n$a
implements Runnable {
    public final /* synthetic */ h$s a;
    public final /* synthetic */ n b;

    public n$a(n n10, h$s s10) {
        this.b = n10;
        this.a = s10;
    }

    public final void run() {
        n n10 = this.b;
        c c10 = n10.d;
        n10 = n.d(n10);
        Object object = this.a;
        int n11 = ((h$t)object).d;
        object = ((h$t)object).c;
        c10.onPublish((Context)n10, n11, (String)object);
    }
}

