/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.h0$c;
import e.a.s0.a;
import e.a.s0.b;
import e.a.w0.g.e$a;
import e.a.w0.g.e$c;
import e.a.w0.g.g;
import io.reactivex.internal.disposables.EmptyDisposable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class e$b
extends h0$c {
    private final a a;
    private final e$a b;
    private final e$c c;
    public final AtomicBoolean d;

    public e$b(e$a object) {
        Object object2 = new AtomicBoolean();
        this.d = object2;
        this.b = object;
        this.a = object2 = new a();
        this.c = object = ((e$a)object).b();
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        b b10 = this.a;
        boolean bl2 = ((a)b10).isDisposed();
        if (bl2) {
            return EmptyDisposable.INSTANCE;
        }
        b10 = this.c;
        a a10 = this.a;
        return ((g)b10).e(runnable, l10, timeUnit, a10);
    }

    public void dispose() {
        Object object = this.d;
        e$c e$c = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            this.a.dispose();
            object = this.b;
            e$c = this.c;
            ((e$a)object).d(e$c);
        }
    }

    public boolean isDisposed() {
        return this.d.get();
    }
}

