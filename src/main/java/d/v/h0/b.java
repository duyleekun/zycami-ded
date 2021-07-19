/*
 * Decompiled with CFR 0.151.
 */
package d.v.h0;

import d.v.h0.i$b;

public final class b
implements Runnable {
    public final /* synthetic */ i$b a;
    public final /* synthetic */ Throwable b;

    public /* synthetic */ b(i$b b10, Throwable throwable) {
        this.a = b10;
        this.b = throwable;
    }

    public final void run() {
        i$b i$b = this.a;
        Throwable throwable = this.b;
        i$b.b(throwable);
    }
}

