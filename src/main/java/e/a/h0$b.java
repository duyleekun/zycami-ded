/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.c1.a;
import e.a.h0$c;
import e.a.s0.b;
import io.reactivex.internal.util.ExceptionHelper;

public final class h0$b
implements b,
Runnable,
a {
    public final Runnable a;
    public final h0$c b;
    public volatile boolean c;

    public h0$b(Runnable runnable, h0$c h0$c) {
        this.a = runnable;
        this.b = h0$c;
    }

    public void dispose() {
        this.c = true;
        this.b.dispose();
    }

    public Runnable getWrappedRunnable() {
        return this.a;
    }

    public boolean isDisposed() {
        return this.c;
    }

    public void run() {
        boolean bl2 = this.c;
        if (!bl2) {
            Runnable runnable;
            try {
                runnable = this.a;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.b.dispose();
                throw ExceptionHelper.f(throwable);
            }
            runnable.run();
        }
    }
}

