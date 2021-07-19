/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.s0.h7;

import d.v.c.s0.h7.k0;
import java.util.concurrent.Callable;

public final class o
implements Callable {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ int b;

    public /* synthetic */ o(k0 k02, int n10) {
        this.a = k02;
        this.b = n10;
    }

    public final Object call() {
        k0 k02 = this.a;
        int n10 = this.b;
        return k02.P(n10);
    }
}

