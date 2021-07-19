/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.k0;
import h.m;
import h.o0;

public abstract class q
implements k0 {
    private final k0 a;

    public q(k0 k02) {
        f0.p(k02, "delegate");
        this.a = k02;
    }

    public final k0 a() {
        return this.a;
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        this.a.flush();
    }

    public final k0 h() {
        return this.a;
    }

    public void t(m m10, long l10) {
        f0.p(m10, "source");
        this.a.t(m10, l10);
    }

    public o0 timeout() {
        return this.a.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append('(');
        object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

