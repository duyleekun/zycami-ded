/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m;
import h.m0;
import h.o0;

/*
 * Illegal identifiers - consider using --renameillegalidents true
 */
public abstract class r
implements m0 {
    private final m0 delegate;

    public r(m0 m02) {
        f0.p(m02, "delegate");
        this.delegate = m02;
    }

    public final m0 -deprecated_delegate() {
        return this.delegate;
    }

    public void close() {
        this.delegate.close();
    }

    public final m0 delegate() {
        return this.delegate;
    }

    public long read(m m10, long l10) {
        f0.p(m10, "sink");
        return this.delegate.read(m10, l10);
    }

    public o0 timeout() {
        return this.delegate.timeout();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Object object = this.getClass().getSimpleName();
        stringBuilder.append((String)object);
        stringBuilder.append('(');
        object = this.delegate;
        stringBuilder.append(object);
        stringBuilder.append(')');
        return stringBuilder.toString();
    }
}

