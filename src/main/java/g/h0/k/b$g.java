/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.k.b;
import g.h0.k.b$a;
import h.m;

public final class b$g
extends b$a {
    private boolean d;
    public final /* synthetic */ b e;

    public b$g(b b10) {
        this.e = b10;
        super(b10);
    }

    public void close() {
        boolean bl2 = this.a();
        if (bl2) {
            return;
        }
        bl2 = this.d;
        if (!bl2) {
            this.q();
        }
        this.B(true);
    }

    public long read(m object, long l10) {
        String string2 = "sink";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        if (l12 >= 0) {
            l12 = n10;
        } else {
            l12 = 0;
            string2 = null;
        }
        if (l12 != false) {
            l12 = this.a() ^ n10;
            if (l12 != false) {
                l12 = (long)this.d;
                long l13 = -1;
                if (l12 != false) {
                    return l13;
                }
                long l14 = super.read((m)object, l10);
                long l15 = l14 - l13;
                Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object2 == false) {
                    this.d = n10;
                    this.q();
                    return l13;
                }
                return l14;
            }
            String string3 = "closed".toString();
            object = new IllegalStateException(string3);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("byteCount < 0: ");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }
}

