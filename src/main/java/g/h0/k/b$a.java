/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.k.b;
import h.m;
import h.m0;
import h.o0;
import h.s;
import java.io.IOException;

public abstract class b$a
implements m0 {
    private final s a;
    private boolean b;
    public final /* synthetic */ b c;

    public b$a(b object) {
        s s10;
        this.c = object;
        object = g.h0.k.b.n((b)object).timeout();
        this.a = s10 = new s((o0)object);
    }

    public final void B(boolean bl2) {
        this.b = bl2;
    }

    public final boolean a() {
        return this.b;
    }

    public final s h() {
        return this.a;
    }

    public final void q() {
        int n10;
        int n11;
        Object object = this.c;
        int n12 = g.h0.k.b.o((b)object);
        if (n12 == (n11 = 6)) {
            return;
        }
        object = this.c;
        n12 = g.h0.k.b.o((b)object);
        if (n12 == (n10 = 5)) {
            object = this.c;
            s s10 = this.a;
            g.h0.k.b.j((b)object, s10);
            g.h0.k.b.q(this.c, n11);
            return;
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("state: ");
        n10 = g.h0.k.b.o(this.c);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object = new IllegalStateException((String)charSequence);
        throw object;
    }

    public long read(m m10, long l10) {
        Object object = "sink";
        f0.p(m10, (String)object);
        try {
            object = this.c;
        }
        catch (IOException iOException) {
            this.c.c().G();
            this.q();
            throw iOException;
        }
        object = g.h0.k.b.n((b)object);
        return object.read(m10, l10);
    }

    public o0 timeout() {
        return this.a;
    }
}

