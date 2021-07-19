/*
 * Decompiled with CFR 0.151.
 */
package k;

import k.f;
import k.i$b$a;

public final class a
implements Runnable {
    public final /* synthetic */ i$b$a a;
    public final /* synthetic */ f b;
    public final /* synthetic */ Throwable c;

    public /* synthetic */ a(i$b$a a10, f f10, Throwable throwable) {
        this.a = a10;
        this.b = f10;
        this.c = throwable;
    }

    public final void run() {
        i$b$a i$b$a = this.a;
        f f10 = this.b;
        Throwable throwable = this.c;
        i$b$a.b(f10, throwable);
    }
}

