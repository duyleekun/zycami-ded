/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.h2.t.f0;
import g.h0.d;
import g.h0.f.b;
import h.m;
import h.m0;
import h.n;
import h.o;
import h.o0;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public final class a$b
implements m0 {
    private boolean a;
    public final /* synthetic */ o b;
    public final /* synthetic */ b c;
    public final /* synthetic */ n d;

    public a$b(o o10, b b10, n n10) {
        this.b = o10;
        this.c = b10;
        this.d = n10;
    }

    public void close() {
        TimeUnit timeUnit;
        boolean bl2 = this.a;
        if (!bl2 && !(bl2 = g.h0.d.t(this, 100, timeUnit = TimeUnit.MILLISECONDS))) {
            this.a = bl2 = true;
            b b10 = this.c;
            b10.a();
        }
        this.b.close();
    }

    public long read(m n10, long l10) {
        o o10;
        String string2 = "sink";
        f0.p(n10, string2);
        boolean bl2 = true;
        try {
            o10 = this.b;
        }
        catch (IOException iOException) {
            boolean bl3 = this.a;
            if (!bl3) {
                this.a = bl2;
                b b10 = this.c;
                b10.a();
            }
            throw iOException;
        }
        l10 = o10.read((m)n10, l10);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            boolean bl4 = this.a;
            if (!bl4) {
                this.a = bl2;
                n10 = this.d;
                n10.close();
            }
            return l11;
        }
        m m10 = this.d.getBuffer();
        long l13 = ((m)n10).S0() - l10;
        ((m)n10).s0(m10, l13, l10);
        this.d.o();
        return l10;
    }

    public o0 timeout() {
        return this.b.timeout();
    }
}

