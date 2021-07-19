/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.h0.i.c;
import h.k0;
import h.m;
import h.q;
import java.io.IOException;
import java.net.ProtocolException;

public final class c$a
extends q {
    private boolean b;
    private long c;
    private boolean d;
    private final long e;
    public final /* synthetic */ c f;

    public c$a(c c10, k0 k02, long l10) {
        f0.p(k02, "delegate");
        this.f = c10;
        super(k02);
        this.e = l10;
    }

    private final IOException q(IOException iOException) {
        boolean bl2 = this.b;
        if (bl2) {
            return iOException;
        }
        this.b = true;
        c c10 = this.f;
        long l10 = this.c;
        return c10.a(l10, false, true, iOException);
    }

    public void close() {
        long l10;
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        long l11 = this.e;
        long l12 = -1;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (bl2 = (l10 = (l12 = this.c) - l11) == 0L ? 0 : (l10 < 0L ? -1 : 1))) {
            ProtocolException protocolException = new ProtocolException("unexpected end of stream");
            throw protocolException;
        }
        try {
            super.close();
            bl2 = false;
            Object var7_6 = null;
        }
        catch (IOException iOException) {
            throw this.q(iOException);
        }
        this.q(null);
    }

    public void flush() {
        try {
            super.flush();
            return;
        }
        catch (IOException iOException) {
            throw this.q(iOException);
        }
    }

    public void t(m object, long l10) {
        CharSequence charSequence = "source";
        f0.p(object, (String)charSequence);
        int n10 = this.d ^ 1;
        if (n10 != 0) {
            long l11;
            long l12 = this.e;
            long l13 = -1;
            long l14 = l12 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false && (n10 = (l11 = (l13 = this.c + l10) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1)) > 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("expected ");
                long l15 = this.e;
                ((StringBuilder)charSequence).append(l15);
                ((StringBuilder)charSequence).append(" bytes but received ");
                l15 = this.c + l10;
                ((StringBuilder)charSequence).append(l15);
                String string2 = ((StringBuilder)charSequence).toString();
                object = new ProtocolException(string2);
                throw object;
            }
            try {
                super.t((m)object, l10);
                l12 = this.c + l10;
            }
            catch (IOException iOException) {
                throw this.q(iOException);
            }
            this.c = l12;
            return;
        }
        String string3 = "closed".toString();
        object = new IllegalStateException(string3);
        throw object;
    }
}

