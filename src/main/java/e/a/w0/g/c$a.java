/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.c;
import java.util.concurrent.TimeUnit;

public final class c$a
extends h0$c {
    public b b(Runnable runnable) {
        runnable.run();
        return c.d;
    }

    public b c(Runnable object, long l10, TimeUnit timeUnit) {
        object = new UnsupportedOperationException("This scheduler doesn't support delayed execution");
        throw object;
    }

    public b d(Runnable object, long l10, long l11, TimeUnit timeUnit) {
        object = new UnsupportedOperationException("This scheduler doesn't support periodic execution");
        throw object;
    }

    public void dispose() {
    }

    public boolean isDisposed() {
        return false;
    }
}

