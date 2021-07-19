/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import h.n;
import h.o;
import java.io.Closeable;

public abstract class e$d
implements Closeable {
    private final boolean a;
    private final o b;
    private final n c;

    public e$d(boolean bl2, o o10, n n10) {
        f0.p(o10, "source");
        f0.p(n10, "sink");
        this.a = bl2;
        this.b = o10;
        this.c = n10;
    }

    public final boolean a() {
        return this.a;
    }

    public final n h() {
        return this.c;
    }

    public final o q() {
        return this.b;
    }
}

