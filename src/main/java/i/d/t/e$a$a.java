/*
 * Decompiled with CFR 0.151.
 */
package i.d.t;

import i.d.t.e;
import i.d.t.e$a;
import i.h.c;

public class e$a$a
implements Thread.UncaughtExceptionHandler {
    public final /* synthetic */ e a;
    public final /* synthetic */ e$a b;

    public e$a$a(e$a a10, e e10) {
        this.b = a10;
        this.a = e10;
    }

    public void uncaughtException(Thread object, Throwable throwable) {
        c c10 = e.a(this.b.b);
        object = ((Thread)object).getName();
        c10.error("Uncaught exception in thread {}: {}", object, (Object)throwable);
    }
}

