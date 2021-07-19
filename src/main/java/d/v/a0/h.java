/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.g1$c;
import d.v.a0.n1.f;

public final class h
implements Runnable {
    public final /* synthetic */ f a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ int d;

    public /* synthetic */ h(f f10, String string2, Throwable throwable, int n10) {
        this.a = f10;
        this.b = string2;
        this.c = throwable;
        this.d = n10;
    }

    public final void run() {
        f f10 = this.a;
        String string2 = this.b;
        Throwable throwable = this.c;
        int n10 = this.d;
        g1$c.v(f10, string2, throwable, n10);
    }
}

