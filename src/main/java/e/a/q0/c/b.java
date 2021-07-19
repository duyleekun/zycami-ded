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
import e.a.h0;
import e.a.h0$c;
import e.a.q0.c.b$a;
import e.a.q0.c.b$b;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public final class b
extends h0 {
    private final Handler b;
    private final boolean c;

    public b(Handler handler, boolean bl2) {
        this.b = handler;
        this.c = bl2;
    }

    public h0$c c() {
        Handler handler = this.b;
        boolean bl2 = this.c;
        b$a b$a = new b$a(handler, bl2);
        return b$a;
    }

    public e.a.s0.b f(Runnable runnable, long l10, TimeUnit timeUnit) {
        Objects.requireNonNull(runnable, "run == null");
        Objects.requireNonNull(timeUnit, "unit == null");
        runnable = e.a.a1.a.b0(runnable);
        Handler handler = this.b;
        b$b b$b = new b$b(handler, runnable);
        runnable = Message.obtain((Handler)this.b, (Runnable)b$b);
        boolean bl2 = this.c;
        if (bl2) {
            bl2 = true;
            runnable.setAsynchronous(bl2);
        }
        handler = this.b;
        l10 = timeUnit.toMillis(l10);
        handler.sendMessageDelayed((Message)runnable, l10);
        return b$b;
    }
}

