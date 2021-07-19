/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.g0;
import e.a.h0;
import e.a.h0$c;
import e.a.w0.e.e.a;
import e.a.w0.e.e.m$a;
import e.a.w0.e.e.m$b;
import e.a.w0.e.e.m$c;
import e.a.y0.l;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public final class m
extends a {
    public final long b;
    public final long c;
    public final TimeUnit d;
    public final h0 e;
    public final Callable f;
    public final int g;
    public final boolean h;

    public m(e0 e02, long l10, long l11, TimeUnit timeUnit, h0 h02, Callable callable, int n10, boolean bl2) {
        super(e02);
        this.b = l10;
        this.c = l11;
        this.d = timeUnit;
        this.e = h02;
        this.f = callable;
        this.g = n10;
        this.h = bl2;
    }

    public void K5(g0 g02) {
        int n10;
        long l10 = this.b;
        long l11 = this.c;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false && (object = (Object)this.g) == (n10 = -1 >>> 1)) {
            e0 e02 = this.a;
            l l13 = new l(g02);
            Callable callable = this.f;
            long l14 = this.b;
            TimeUnit timeUnit = this.d;
            h0 h02 = this.e;
            m$b m$b = new m$b(l13, callable, l14, timeUnit, h02);
            e02.subscribe(m$b);
            return;
        }
        Object object2 = this.e;
        h0$c h0$c = ((h0)object2).c();
        l10 = this.b;
        l11 = this.c;
        long l15 = l10 - l11;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            object2 = this.a;
            l l16 = new l(g02);
            Callable callable = this.f;
            long l17 = this.b;
            TimeUnit timeUnit = this.d;
            int n11 = this.g;
            boolean bl2 = this.h;
            m$a m$a = new m$a(l16, callable, l17, timeUnit, n11, bl2, h0$c);
            object2.subscribe(m$a);
            return;
        }
        object2 = this.a;
        l l18 = new l(g02);
        Callable callable = this.f;
        long l19 = this.b;
        long l20 = this.c;
        TimeUnit timeUnit = this.d;
        m$c m$c = new m$c(l18, callable, l19, l20, timeUnit, h0$c);
        object2.subscribe(m$c);
    }
}

