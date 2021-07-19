/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.o.k.i;
import d.c.a.o.k.j;
import d.c.a.s.h;

public class i$d {
    private final j a;
    private final h b;
    public final /* synthetic */ i c;

    public i$d(i i10, h h10, j j10) {
        this.c = i10;
        this.b = h10;
        this.a = j10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a() {
        i i10 = this.c;
        synchronized (i10) {
            j j10 = this.a;
            h h10 = this.b;
            j10.s(h10);
            return;
        }
    }
}

