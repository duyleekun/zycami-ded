/*
 * Decompiled with CFR 0.151.
 */
package e.a;

import e.a.c1.a;
import e.a.h0$c;
import e.a.s0.b;
import e.a.w0.g.g;

public final class h0$a
implements b,
Runnable,
a {
    public final Runnable a;
    public final h0$c b;
    public Thread c;

    public h0$a(Runnable runnable, h0$c h0$c) {
        this.a = runnable;
        this.b = h0$c;
    }

    public void dispose() {
        boolean bl2;
        Object object = this.c;
        Thread thread = Thread.currentThread();
        if (object == thread && (bl2 = (object = this.b) instanceof g)) {
            object = (g)object;
            ((g)object).h();
        } else {
            object = this.b;
            object.dispose();
        }
    }

    public Runnable getWrappedRunnable() {
        return this.a;
    }

    public boolean isDisposed() {
        return this.b.isDisposed();
    }

    public void run() {
        Thread thread;
        this.c = thread = Thread.currentThread();
        thread = null;
        try {
            Runnable runnable = this.a;
            runnable.run();
            return;
        }
        finally {
            this.dispose();
            this.c = null;
        }
    }
}

