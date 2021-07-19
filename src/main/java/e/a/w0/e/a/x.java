/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.a;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.h0;
import e.a.s0.b;
import e.a.w0.e.a.x$a;
import e.a.w0.e.a.x$b;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class x
extends a {
    public final g a;
    public final long b;
    public final TimeUnit c;
    public final h0 d;
    public final g e;

    public x(g g10, long l10, TimeUnit timeUnit, h0 h02, g g11) {
        this.a = g10;
        this.b = l10;
        this.c = timeUnit;
        this.d = h02;
        this.e = g11;
    }

    public void L0(d d10) {
        e.a.s0.a a10 = new e.a.s0.a();
        d10.onSubscribe(a10);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        Object object = this.d;
        Object object2 = new x$a(this, atomicBoolean, a10, d10);
        long l10 = this.b;
        TimeUnit timeUnit = this.c;
        object = ((h0)object).f((Runnable)object2, l10, timeUnit);
        a10.b((b)object);
        object = this.a;
        object2 = new x$b(a10, atomicBoolean, d10);
        object.f((d)object2);
    }
}

