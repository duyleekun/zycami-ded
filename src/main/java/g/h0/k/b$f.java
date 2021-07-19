/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.d;
import g.h0.k.b;
import h.k0;
import h.m;
import h.o0;
import h.s;

public final class b$f
implements k0 {
    private final s a;
    private boolean b;
    public final /* synthetic */ b c;

    public b$f(b object) {
        s s10;
        this.c = object;
        object = g.h0.k.b.m((b)object).timeout();
        this.a = s10 = new s((o0)object);
    }

    public void close() {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        this.b = true;
        b b10 = this.c;
        s s10 = this.a;
        g.h0.k.b.j(b10, s10);
        g.h0.k.b.q(this.c, 3);
    }

    public void flush() {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        g.h0.k.b.m(this.c).flush();
    }

    public void t(m object, long l10) {
        String string2 = "source";
        f0.p(object, string2);
        boolean bl2 = this.b ^ true;
        if (bl2) {
            d.k(((m)object).S0(), 0L, l10);
            g.h0.k.b.m(this.c).t((m)object, l10);
            return;
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }

    public o0 timeout() {
        return this.a;
    }
}

