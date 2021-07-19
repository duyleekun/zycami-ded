/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.h2.s.l;
import f.h2.t.f0;
import h.k0;
import h.m;
import h.q;
import java.io.IOException;

public class d
extends q {
    private boolean b;
    private final l c;

    public d(k0 k02, l l10) {
        f0.p(k02, "delegate");
        f0.p(l10, "onException");
        super(k02);
        this.c = l10;
    }

    public void close() {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        try {
            super.close();
        }
        catch (IOException iOException) {
            boolean bl3;
            this.b = bl3 = true;
            l l10 = this.c;
            l10.invoke(iOException);
        }
    }

    public void flush() {
        boolean bl2 = this.b;
        if (bl2) {
            return;
        }
        try {
            super.flush();
        }
        catch (IOException iOException) {
            boolean bl3;
            this.b = bl3 = true;
            l l10 = this.c;
            l10.invoke(iOException);
        }
    }

    public final l q() {
        return this.c;
    }

    public void t(m m10, long l10) {
        String string2 = "source";
        f0.p(m10, string2);
        boolean bl2 = this.b;
        if (bl2) {
            m10.skip(l10);
            return;
        }
        try {
            super.t(m10, l10);
        }
        catch (IOException iOException) {
            boolean bl3;
            this.b = bl3 = true;
            l l11 = this.c;
            l11.invoke(iOException);
        }
    }
}

