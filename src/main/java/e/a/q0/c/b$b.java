/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package e.a.q0.c;

import android.os.Handler;
import e.a.a1.a;
import e.a.s0.b;

public final class b$b
implements Runnable,
b {
    private final Handler a;
    private final Runnable b;
    private volatile boolean c;

    public b$b(Handler handler, Runnable runnable) {
        this.a = handler;
        this.b = runnable;
    }

    public void dispose() {
        this.a.removeCallbacks((Runnable)this);
        this.c = true;
    }

    public boolean isDisposed() {
        return this.c;
    }

    public void run() {
        Runnable runnable = this.b;
        try {
            runnable.run();
        }
        catch (Throwable throwable) {
            e.a.a1.a.Y(throwable);
        }
    }
}

