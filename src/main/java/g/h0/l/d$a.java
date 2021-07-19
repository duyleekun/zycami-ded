/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import g.h0.h.a;
import g.h0.l.d;

public final class d$a
extends a {
    public final /* synthetic */ String e;
    public final /* synthetic */ d f;
    public final /* synthetic */ long g;

    public d$a(String string2, String string3, d d10, long l10) {
        this.e = string2;
        this.f = d10;
        this.g = l10;
        super(string3, false, 2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public long f() {
        d d10 = this.f;
        // MONITORENTER : d10
        d d11 = this.f;
        long l10 = d.E(d11);
        d d12 = this.f;
        long l11 = d.D(d12);
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1;
        d12 = null;
        if (l12 < 0) {
            l12 = n10;
        } else {
            d11 = this.f;
            long l13 = d.D(d11);
            long l14 = 1L;
            d.t0(d11, l13 += l14);
            l12 = 0;
            d11 = null;
        }
        // MONITOREXIT : d10
        if (l12 != false) {
            d10 = this.f;
            l12 = 0;
            d11 = null;
            d.a(d10, null);
            return -1;
        }
        d10 = this.f;
        d10.p1(false, n10, 0);
        return this.g;
    }
}

