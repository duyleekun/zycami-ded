/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.e1.e;
import e.a.h0;
import e.a.h0$c;
import e.a.j;
import e.a.w0.e.b.a;
import e.a.w0.e.b.k$a;
import e.a.w0.e.b.k$b;
import e.a.w0.e.b.k$c;
import i.g.d;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class k
extends a {
    public final long c;
    public final long d;
    public final TimeUnit e;
    public final h0 f;
    public final Callable g;
    public final int h;
    public final boolean i;

    public k(j j10, long l10, long l11, TimeUnit timeUnit, h0 h02, Callable callable, int n10, boolean bl2) {
        super(j10);
        this.c = l10;
        this.d = l11;
        this.e = timeUnit;
        this.f = h02;
        this.g = callable;
        this.h = n10;
        this.i = bl2;
    }

    public void m6(d d10) {
        int n10;
        long l10 = this.c;
        long l11 = this.d;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false && (object = (Object)this.h) == (n10 = -1 >>> 1)) {
            j j10 = this.b;
            e e10 = new e(d10);
            Callable callable = this.g;
            long l13 = this.c;
            TimeUnit timeUnit = this.e;
            h0 h02 = this.f;
            k$b k$b = new k$b(e10, callable, l13, timeUnit, h02);
            j10.l6(k$b);
            return;
        }
        Object object2 = this.f;
        h0$c h0$c = ((h0)object2).c();
        l10 = this.c;
        l11 = this.d;
        long l14 = l10 - l11;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            object2 = this.b;
            e e11 = new e(d10);
            Callable callable = this.g;
            long l15 = this.c;
            TimeUnit timeUnit = this.e;
            int n11 = this.h;
            boolean bl2 = this.i;
            k$a k$a = new k$a(e11, callable, l15, timeUnit, n11, bl2, h0$c);
            ((j)object2).l6(k$a);
            return;
        }
        object2 = this.b;
        e e12 = new e(d10);
        Callable callable = this.g;
        long l16 = this.c;
        long l17 = this.d;
        TimeUnit timeUnit = this.e;
        k$c k$c = new k$c(e12, callable, l16, l17, timeUnit, h0$c);
        ((j)object2).l6(k$c);
    }
}

