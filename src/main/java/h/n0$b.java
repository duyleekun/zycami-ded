/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m;
import h.m0;
import h.n0;
import h.r;
import java.io.InterruptedIOException;

public final class n0$b
extends r {
    public final /* synthetic */ n0 a;
    public final /* synthetic */ m0 b;

    public n0$b(n0 n02, m0 m02, m0 m03) {
        this.a = n02;
        this.b = m02;
        super(m03);
    }

    public long read(m object, long l10) {
        Object object2 = "sink";
        f0.p(object, (String)object2);
        try {
            object2 = this.a;
        }
        catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
            object = new InterruptedIOException("interrupted");
            throw object;
        }
        l10 = ((n0)object2).j(l10);
        return super.read((m)object, l10);
    }
}

