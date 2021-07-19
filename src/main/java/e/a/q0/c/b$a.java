/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Message
 */
package e.a.q0.c;

import android.os.Handler;
import android.os.Message;
import e.a.a1.a;
import e.a.h0$c;
import e.a.q0.c.b$b;
import e.a.s0.b;
import e.a.s0.c;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class b$a
extends h0$c {
    private final Handler a;
    private final boolean b;
    private volatile boolean c;

    public b$a(Handler handler, boolean bl2) {
        this.a = handler;
        this.b = bl2;
    }

    public b c(Runnable runnable, long l10, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Object object = "unit == null";
        Objects.requireNonNull(timeUnit, (String)object);
        boolean bl2 = this.c;
        if (bl2) {
            return e.a.s0.c.a();
        }
        runnable = e.a.a1.a.b0(runnable);
        Handler handler = this.a;
        object = new b$b(handler, runnable);
        runnable = Message.obtain((Handler)this.a, (Runnable)object);
        ((Message)runnable).obj = this;
        boolean bl3 = this.b;
        if (bl3) {
            bl3 = true;
            runnable.setAsynchronous(bl3);
        }
        handler = this.a;
        l10 = timeUnit.toMillis(l10);
        handler.sendMessageDelayed((Message)runnable, l10);
        boolean bl4 = this.c;
        if (bl4) {
            this.a.removeCallbacks((Runnable)object);
            return e.a.s0.c.a();
        }
        return object;
    }

    public void dispose() {
        this.c = true;
        this.a.removeCallbacksAndMessages((Object)this);
    }

    public boolean isDisposed() {
        return this.c;
    }
}

