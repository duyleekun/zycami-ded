/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.i1$c;
import d.v.a0.n1.b;

public final class k0
implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ int d;

    public /* synthetic */ k0(b b10, String string2, Throwable throwable, int n10) {
        this.a = b10;
        this.b = string2;
        this.c = throwable;
        this.d = n10;
    }

    public final void run() {
        b b10 = this.a;
        String string2 = this.b;
        Throwable throwable = this.c;
        int n10 = this.d;
        i1$c.s(b10, string2, throwable, n10);
    }
}

