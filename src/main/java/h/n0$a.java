/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.k0;
import h.m;
import h.n0;
import h.q;
import java.io.InterruptedIOException;

public final class n0$a
extends q {
    public final /* synthetic */ n0 b;
    public final /* synthetic */ k0 c;

    public n0$a(n0 n02, k0 k02, k0 k03) {
        this.b = n02;
        this.c = k02;
        super(k03);
    }

    public void t(m object, long l10) {
        long l11;
        long l12;
        long l13;
        Object object2 = "source";
        f0.p(object, (String)object2);
        while ((l13 = (l12 = l10 - (l11 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            try {
                object2 = this.b;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                object = new InterruptedIOException("interrupted");
                throw object;
            }
            l11 = ((n0)object2).j(l10);
            super.t((m)object, l11);
            l10 -= l11;
        }
    }
}

