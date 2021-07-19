/*
 * Decompiled with CFR 0.151.
 */
package d.v.k0.f.e;

import d.v.k0.f.d.a;
import d.v.k0.f.e.u$a;

public class u$c
extends a {
    private long e = -1;

    private u$c() {
    }

    public /* synthetic */ u$c(u$a u$a) {
        this();
    }

    public void a() {
        super.a();
        this.e = -1;
    }

    public boolean k() {
        long l10;
        long l11 = System.currentTimeMillis();
        long l12 = l11 - (l10 = this.e);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void l(long l10) {
        this.e = l10 += 5000L;
    }

    public String toString() {
        return this.d();
    }
}

