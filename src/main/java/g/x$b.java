/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.s;
import h.o;
import java.io.Closeable;

public final class x$b
implements Closeable {
    private final s a;
    private final o b;

    public x$b(s s10, o o10) {
        f0.p(s10, "headers");
        f0.p(o10, "body");
        this.a = s10;
        this.b = o10;
    }

    public final o a() {
        return this.b;
    }

    public void close() {
        this.b.close();
    }

    public final s h() {
        return this.a;
    }
}

