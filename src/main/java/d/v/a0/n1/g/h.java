/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import d.v.a0.n1.g.u;

public final class h
implements Runnable {
    public final /* synthetic */ u a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Throwable c;
    public final /* synthetic */ int d;

    public /* synthetic */ h(u u10, String string2, Throwable throwable, int n10) {
        this.a = u10;
        this.b = string2;
        this.c = throwable;
        this.d = n10;
    }

    public final void run() {
        u u10 = this.a;
        String string2 = this.b;
        Throwable throwable = this.c;
        int n10 = this.d;
        u10.o(string2, throwable, n10);
    }
}

