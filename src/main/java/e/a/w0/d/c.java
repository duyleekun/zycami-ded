/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.d;

import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;

public abstract class c
extends CountDownLatch
implements g0,
b {
    public Object a;
    public Throwable b;
    public b c;
    public volatile boolean d;

    public c() {
        super(1);
    }

    public final Object a() {
        Throwable throwable;
        long l10;
        long l11 = this.getCount();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            try {
                e.a.w0.i.c.b();
                this.await();
            }
            catch (InterruptedException interruptedException) {
                this.dispose();
                throw ExceptionHelper.f(interruptedException);
            }
        }
        if ((throwable = this.b) == null) {
            return this.a;
        }
        throw ExceptionHelper.f(throwable);
    }

    public final void dispose() {
        boolean bl2;
        this.d = bl2 = true;
        b b10 = this.c;
        if (b10 != null) {
            b10.dispose();
        }
    }

    public final boolean isDisposed() {
        return this.d;
    }

    public final void onComplete() {
        this.countDown();
    }

    public final void onSubscribe(b b10) {
        this.c = b10;
        boolean bl2 = this.d;
        if (bl2) {
            b10.dispose();
        }
    }
}

