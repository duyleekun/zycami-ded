/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.e;
import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import e.a.w0.e.b.k1$a;
import e.a.w0.e.b.k1$b;
import e.a.w0.e.b.k1$c;
import i.g.d;
import java.util.concurrent.TimeUnit;

public final class k1
extends a {
    public final long c;
    public final long d;
    public final TimeUnit e;
    public final h0 f;
    public final long g;
    public final int h;
    public final boolean i;

    public k1(j j10, long l10, long l11, TimeUnit timeUnit, h0 h02, long l12, int n10, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = l11;
        this.e = timeUnit;
        this.f = h02;
        this.g = l12;
        this.h = n10;
        this.i = bl2;
    }

    public void m6(d object) {
        e e10 = new e((d)object);
        long l10 = this.c;
        long l11 = this.d;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            long l13 = this.g;
            l11 = Long.MAX_VALUE;
            long l14 = l13 - l11;
            object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 == false) {
                object = this.b;
                l10 = this.c;
                TimeUnit timeUnit = this.e;
                h0 h02 = this.f;
                int n10 = this.h;
                k1$b k1$b = new k1$b(e10, l10, timeUnit, h02, n10);
                ((j)object).l6(k1$b);
                return;
            }
            object = this.b;
            TimeUnit timeUnit = this.e;
            h0 h03 = this.f;
            int n11 = this.h;
            boolean bl2 = this.i;
            k1$a k1$a = new k1$a(e10, l10, timeUnit, h03, n11, l13, bl2);
            ((j)object).l6(k1$a);
            return;
        }
        object = this.b;
        TimeUnit timeUnit = this.e;
        h0$c h0$c = this.f.c();
        int n12 = this.h;
        k1$c k1$c = new k1$c(e10, l10, l11, timeUnit, h0$c, n12);
        ((j)object).l6(k1$c);
    }
}

