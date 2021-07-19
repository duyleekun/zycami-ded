/*
 * Decompiled with CFR 0.151.
 */
package okhttp3.internal.connection;

import g.h0.i.c;
import g.h0.q.e$d;
import h.n;
import h.o;

public final class RealConnection$b
extends e$d {
    public final /* synthetic */ c d;
    public final /* synthetic */ o e;
    public final /* synthetic */ n f;

    public RealConnection$b(c c10, o o10, n n10, boolean bl2, o o11, n n11) {
        this.d = c10;
        this.e = o10;
        this.f = n10;
        super(bl2, o11, n11);
    }

    public void close() {
        this.d.a(-1, true, true, null);
    }
}

