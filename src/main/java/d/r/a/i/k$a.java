/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.i.k;
import d.r.a.r.d;
import d.r.a.s.c;

public final class k$a
implements Runnable {
    public final /* synthetic */ d a;
    public final /* synthetic */ k b;

    public k$a(k k10, d d10) {
        this.b = k10;
        this.a = d10;
    }

    public final void run() {
        k k10 = this.b;
        c c10 = k10.d;
        k10 = k.d(k10);
        d d10 = this.a;
        c10.onTransmissionMessage((Context)k10, d10);
    }
}

