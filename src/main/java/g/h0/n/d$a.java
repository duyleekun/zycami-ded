/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.Conscrypt$Version
 */
package g.h0.n;

import f.h2.t.u;
import g.h0.n.d;
import org.conscrypt.Conscrypt;

public final class d$a {
    private d$a() {
    }

    public /* synthetic */ d$a(u u10) {
        this();
    }

    public static /* synthetic */ boolean b(d$a d$a, int n10, int n11, int n12, int n13, Object object) {
        int n14 = n13 & 2;
        if (n14 != 0) {
            n11 = 0;
        }
        if ((n13 &= 4) != 0) {
            n12 = 0;
        }
        return d$a.a(n10, n11, n12);
    }

    public final boolean a(int n10, int n11, int n12) {
        Conscrypt.Version version = Conscrypt.version();
        int n13 = version.major();
        boolean bl2 = true;
        if (n13 != n10) {
            n11 = version.major();
            if (n11 <= n10) {
                bl2 = false;
            }
            return bl2;
        }
        n10 = version.minor();
        if (n10 != n11) {
            n10 = version.minor();
            if (n10 <= n11) {
                bl2 = false;
            }
            return bl2;
        }
        n10 = version.patch();
        if (n10 < n12) {
            bl2 = false;
        }
        return bl2;
    }

    public final d c() {
        boolean bl2 = this.d();
        d d10 = null;
        if (bl2) {
            d d11;
            d10 = d11 = new d(null);
        }
        return d10;
    }

    public final boolean d() {
        return d.t();
    }
}

