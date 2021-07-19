/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.q2.u;
import g.c0;
import g.d0;
import g.s;
import g.s$a;

public final class a$a {
    private a$a() {
    }

    public /* synthetic */ a$a(f.h2.t.u u10) {
        this();
    }

    public static final /* synthetic */ s a(a$a a$a, s s10, s s11) {
        return a$a.c(s10, s11);
    }

    public static final /* synthetic */ c0 b(a$a a$a, c0 c02) {
        return a$a.f(c02);
    }

    private final s c(s s10, s s11) {
        int n10;
        s$a s$a = new s$a();
        int n11 = s10.size();
        int n12 = 0;
        String string2 = null;
        for (n10 = 0; n10 < n11; ++n10) {
            String string3 = s10.h(n10);
            String string4 = s10.n(n10);
            String string5 = "Warning";
            boolean bl2 = true;
            boolean bl3 = u.I1(string5, string3, bl2);
            if (bl3) {
                bl2 = false;
                String string6 = "1";
                bl3 = u.q2(string4, string6, false, 2, null);
                if (bl3) continue;
            }
            if (!(bl3 = this.d(string3)) && (bl3 = this.e(string3)) && (string5 = s11.e(string3)) != null) continue;
            s$a.g(string3, string4);
        }
        int n13 = s11.size();
        while (n12 < n13) {
            String string7 = s11.h(n12);
            n10 = (int)(this.d(string7) ? 1 : 0);
            if (n10 == 0 && (n10 = (int)(this.e(string7) ? 1 : 0)) != 0) {
                string2 = s11.n(n12);
                s$a.g(string7, string2);
            }
            ++n12;
        }
        return s$a.i();
    }

    private final boolean d(String string2) {
        boolean bl2;
        String string3 = "Content-Length";
        boolean bl3 = true;
        boolean bl4 = u.I1(string3, string2, bl3);
        if (!(bl4 || (bl4 = u.I1(string3 = "Content-Encoding", string2, bl3)) || (bl2 = u.I1(string3 = "Content-Type", string2, bl3)))) {
            bl3 = false;
        }
        return bl3;
    }

    private final boolean e(String string2) {
        boolean bl2;
        String string3 = "Connection";
        boolean bl3 = true;
        boolean bl4 = u.I1(string3, string2, bl3);
        if (bl4 || (bl4 = u.I1(string3 = "Keep-Alive", string2, bl3)) || (bl4 = u.I1(string3 = "Proxy-Authenticate", string2, bl3)) || (bl4 = u.I1(string3 = "Proxy-Authorization", string2, bl3)) || (bl4 = u.I1(string3 = "TE", string2, bl3)) || (bl4 = u.I1(string3 = "Trailers", string2, bl3)) || (bl4 = u.I1(string3 = "Transfer-Encoding", string2, bl3)) || (bl2 = u.I1(string3 = "Upgrade", string2, bl3))) {
            bl3 = false;
        }
        return bl3;
    }

    private final c0 f(c0 c02) {
        d0 d02 = c02 != null ? c02.r0() : null;
        if (d02 != null) {
            c02 = c02.G0().b(null).c();
        }
        return c02;
    }
}

