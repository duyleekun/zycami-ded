/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.o.a;

import d.v.v.o.a.c;
import d.v.v.o.a.d;

public final class a
implements Runnable {
    public final /* synthetic */ c a;
    public final /* synthetic */ d b;
    public final /* synthetic */ float[] c;
    public final /* synthetic */ long d;

    public /* synthetic */ a(c c10, d d10, float[] fArray, long l10) {
        this.a = c10;
        this.b = d10;
        this.c = fArray;
        this.d = l10;
    }

    public final void run() {
        c c10 = this.a;
        d d10 = this.b;
        float[] fArray = this.c;
        long l10 = this.d;
        c10.h(d10, fArray, l10);
    }
}

