/*
 * Decompiled with CFR 0.151.
 */
package g.h0.j;

import f.h2.t.f0;
import g.a0;
import g.b0;
import g.c0;
import g.c0$a;
import g.d0;
import g.h0.d;
import g.h0.i.c;
import g.h0.j.f;
import g.h0.j.g;
import g.u;
import g.u$a;
import h.n;
import h.z;
import java.net.ProtocolException;
import okhttp3.Handshake;
import okhttp3.internal.connection.RealConnection;

public final class b
implements u {
    private final boolean b;

    public b(boolean bl2) {
        this.b = bl2;
    }

    public c0 intercept(u$a object) {
        long l10;
        long l11;
        int n10;
        int n11;
        boolean bl2;
        boolean bl3;
        String string2;
        f0.p(object, "chain");
        object = (g)object;
        Object object2 = ((g)object).m();
        f0.m(object2);
        object = ((g)object).o();
        Object object3 = ((a0)object).f();
        long l12 = System.currentTimeMillis();
        ((c)object2).w((a0)object);
        Object object4 = ((a0)object).m();
        int n12 = f.b((String)object4);
        Long l13 = null;
        boolean bl4 = true;
        if (n12 != 0 && object3 != null) {
            string2 = "100-continue";
            object4 = ((a0)object).i("Expect");
            n12 = f.q2.u.I1(string2, (String)object4, bl4);
            if (n12 != 0) {
                ((c)object2).f();
                object4 = ((c)object2).q(bl4);
                ((c)object2).s();
                bl3 = false;
                string2 = null;
            } else {
                n12 = 0;
                object4 = null;
                bl3 = bl4;
            }
            if (object4 == null) {
                boolean n112 = ((b0)object3).isDuplex();
                if (n112) {
                    ((c)object2).f();
                    n n13 = z.c(((c)object2).c((a0)object, bl4));
                    ((b0)object3).writeTo(n13);
                } else {
                    n n14 = z.c(((c)object2).c((a0)object, false));
                    ((b0)object3).writeTo(n14);
                    n14.close();
                }
            } else {
                ((c)object2).o();
                RealConnection realConnection = ((c)object2).h();
                boolean bl5 = realConnection.C();
                if (!bl5) {
                    ((c)object2).n();
                }
            }
        } else {
            ((c)object2).o();
            n12 = 0;
            object4 = null;
            bl3 = bl4;
        }
        if (object3 == null || !(bl2 = ((b0)object3).isDuplex())) {
            ((c)object2).e();
        }
        if (object4 == null) {
            object4 = ((c)object2).q(false);
            f0.m(object4);
            if (bl3) {
                ((c)object2).s();
                bl3 = false;
                string2 = null;
            }
        }
        object3 = ((c0$a)object4).E((a0)object);
        object4 = ((c)object2).h().c();
        object3 = ((c0$a)object3).u((Handshake)object4).F(l12);
        long l14 = System.currentTimeMillis();
        n12 = ((c0)(object3 = ((c0$a)object3).C(l14).c())).v0();
        if (n12 == (n11 = 100)) {
            object3 = ((c)object2).q(false);
            f0.m(object3);
            if (bl3) {
                ((c)object2).s();
            }
            object = ((c0$a)object3).E((a0)object);
            object3 = ((c)object2).h().c();
            object = ((c0$a)object).u((Handshake)object3).F(l12);
            long l15 = System.currentTimeMillis();
            object = ((c0$a)object).C(l15);
            object3 = ((c0$a)object).c();
            n12 = ((c0)object3).v0();
        }
        ((c)object2).r((c0)object3);
        int n15 = this.b;
        if (n15 != 0 && n12 == (n15 = 101)) {
            object = ((c0)object3).G0();
            object3 = d.c;
            object = ((c0$a)object).b((d0)object3).c();
        } else {
            object = ((c0)object3).G0();
            object3 = ((c)object2).p((c0)object3);
            object = ((c0$a)object).b((d0)object3).c();
        }
        object3 = ((c0)object).L0();
        String string3 = "Connection";
        object3 = ((a0)object3).i(string3);
        String string4 = "close";
        bl2 = f.q2.u.I1(string4, (String)object3, bl4);
        if (bl2 || (bl2 = f.q2.u.I1(string4, (String)(object3 = c0.A0((c0)object, string3, null, 2, null)), bl4))) {
            ((c)object2).n();
        }
        if ((n12 == (n10 = 204) || n12 == (n10 = 205)) && (n10 = (int)((l11 = (l10 = (object2 = ((c0)object).r0()) != null ? ((d0)object2).contentLength() : (long)-1) - (l12 = 0L)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("HTTP ");
            ((StringBuilder)object3).append(n12);
            string3 = " had non-zero Content-Length: ";
            ((StringBuilder)object3).append(string3);
            object = ((c0)object).r0();
            if (object != null) {
                l12 = ((d0)object).contentLength();
                l13 = l12;
            }
            ((StringBuilder)object3).append(l13);
            object = ((StringBuilder)object3).toString();
            object2 = new ProtocolException((String)object);
            throw object2;
        }
        return object;
    }
}

