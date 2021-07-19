/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.h0.i.c;
import g.h0.i.e;
import g.q;
import h.m;
import h.m0;
import h.r;
import java.io.IOException;
import java.net.ProtocolException;

public final class c$b
extends r {
    private long a;
    private boolean b;
    private boolean c;
    private boolean d;
    private final long e;
    public final /* synthetic */ c f;

    public c$b(c c10, m0 m02, long l10) {
        String string2 = "delegate";
        f0.p(m02, string2);
        this.f = c10;
        super(m02);
        this.e = l10;
        this.b = true;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            l12 = 0;
            c10 = null;
            this.a(null);
        }
    }

    public final IOException a(IOException iOException) {
        boolean bl2 = this.c;
        if (bl2) {
            return iOException;
        }
        this.c = bl2 = true;
        if (iOException == null && (bl2 = this.b)) {
            bl2 = false;
            this.b = false;
            q q10 = this.f.i();
            e e10 = this.f.g();
            q10.w(e10);
        }
        c c10 = this.f;
        long l10 = this.a;
        return c10.a(l10, true, false, iOException);
    }

    public void close() {
        boolean bl2 = this.d;
        if (bl2) {
            return;
        }
        this.d = bl2 = true;
        try {
            super.close();
            bl2 = false;
            Object var2_2 = null;
        }
        catch (IOException iOException) {
            throw this.a(iOException);
        }
        this.a(null);
    }

    public long read(m object, long l10) {
        Object object2 = "sink";
        f0.p(object, (String)object2);
        boolean bl2 = this.d ^ true;
        if (bl2) {
            long l11;
            long l12;
            int n10;
            long l13;
            block26: {
                long l14;
                long l15;
                Object object3;
                block25: {
                    try {
                        object2 = this.delegate();
                    }
                    catch (IOException iOException) {
                        throw this.a(iOException);
                    }
                    l13 = object2.read((m)object, l10);
                    n10 = this.b;
                    if (n10 == 0) break block25;
                    n10 = 0;
                    object3 = null;
                    this.b = false;
                    object3 = this.f;
                    object3 = ((c)object3).i();
                    object2 = this.f;
                    object2 = ((c)object2).g();
                    ((q)object3).w((g.e)object2);
                }
                if ((n10 = (l15 = l13 - (l14 = (long)-1)) == 0L ? 0 : (l15 < 0L ? -1 : 1)) == 0) {
                    this.a(null);
                    return l14;
                }
                l12 = this.a + l13;
                l11 = this.e;
                n10 = l11 == l14 ? 0 : (l11 < l14 ? -1 : 1);
                if (n10 == 0 || (n10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) <= 0) break block26;
                CharSequence charSequence = new StringBuilder();
                object3 = "expected ";
                charSequence.append((String)object3);
                l14 = this.e;
                charSequence.append(l14);
                object3 = " bytes but received ";
                charSequence.append((String)object3);
                charSequence.append(l12);
                charSequence = charSequence.toString();
                object = new ProtocolException((String)charSequence);
                throw object;
            }
            this.a = l12;
            n10 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
            if (n10 == 0) {
                this.a(null);
            }
            return l13;
        }
        String string2 = "closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }
}

