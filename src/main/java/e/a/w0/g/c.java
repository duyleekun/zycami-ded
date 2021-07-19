/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.c$a;
import java.util.concurrent.TimeUnit;

public final class c
extends h0 {
    public static final h0 b;
    public static final h0$c c;
    public static final b d;

    static {
        Object object = new c();
        b = object;
        c = object = new c$a();
        d = object = e.a.s0.c.b();
        object.dispose();
    }

    private c() {
    }

    public h0$c c() {
        return c;
    }

    public b e(Runnable runnable) {
        runnable.run();
        return d;
    }

    public b f(Runnable object, long l10, TimeUnit timeUnit) {
        object = new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        throw object;
    }

    public b g(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        object = new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        throw object;
    }
}

