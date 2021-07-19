/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.g0;
import e.a.v0.g;
import e.a.x0.a;
import e.a.z;
import java.util.concurrent.atomic.AtomicInteger;

public final class i
extends z {
    public final a a;
    public final int b;
    public final g c;
    public final AtomicInteger d;

    public i(a object, int n10, g g10) {
        this.a = object;
        this.b = n10;
        this.c = g10;
        this.d = object = new AtomicInteger();
    }

    public void K5(g0 object) {
        Object object2 = this.a;
        ((z)object2).subscribe((g0)object);
        object = this.d;
        int n10 = ((AtomicInteger)object).incrementAndGet();
        int n11 = this.b;
        if (n10 == n11) {
            object = this.a;
            object2 = this.c;
            ((a)object).l8((g)object2);
        }
    }
}

