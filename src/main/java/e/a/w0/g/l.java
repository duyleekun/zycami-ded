/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.a1.a;
import e.a.h0;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.l$c;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;

public final class l
extends h0 {
    private static final l b;

    static {
        l l10;
        b = l10 = new l();
    }

    public static l k() {
        return b;
    }

    public h0$c c() {
        l$c l$c = new l$c();
        return l$c;
    }

    public b e(Runnable runnable) {
        e.a.a1.a.b0(runnable).run();
        return EmptyDisposable.INSTANCE;
    }

    public b f(Runnable runnable, long l10, TimeUnit timeUnit) {
        timeUnit.sleep(l10);
        runnable = e.a.a1.a.b0(runnable);
        try {
            runnable.run();
        }
        catch (InterruptedException interruptedException) {
            Thread thread = Thread.currentThread();
            thread.interrupt();
            e.a.a1.a.Y(interruptedException);
        }
        return EmptyDisposable.INSTANCE;
    }
}

