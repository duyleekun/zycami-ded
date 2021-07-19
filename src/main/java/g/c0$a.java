/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.d0;
import g.h0.i.c;
import g.s;
import g.s$a;
import okhttp3.Handshake;
import okhttp3.Protocol;

public class c0$a {
    private a0 a;
    private Protocol b;
    private int c;
    private String d;
    private Handshake e;
    private s$a f;
    private d0 g;
    private c0 h;
    private c0 i;
    private c0 j;
    private long k;
    private long l;
    private c m;

    public c0$a() {
        s$a s$a;
        this.c = -1;
        this.f = s$a = new s$a();
    }

    public c0$a(c0 object) {
        long l10;
        int n10;
        Object object2;
        f0.p(object, "response");
        this.c = -1;
        this.a = object2 = ((c0)object).L0();
        object2 = ((c0)object).J0();
        this.b = object2;
        this.c = n10 = ((c0)object).v0();
        object2 = ((c0)object).E0();
        this.d = object2;
        object2 = ((c0)object).x0();
        this.e = object2;
        object2 = ((c0)object).C0().j();
        this.f = object2;
        object2 = ((c0)object).r0();
        this.g = object2;
        object2 = ((c0)object).F0();
        this.h = object2;
        object2 = ((c0)object).t0();
        this.i = object2;
        object2 = ((c0)object).I0();
        this.j = object2;
        this.k = l10 = ((c0)object).M0();
        this.l = l10 = ((c0)object).K0();
        this.m = object = ((c0)object).w0();
    }

    private final void e(c0 object) {
        if (object != null) {
            boolean bl2;
            if ((object = ((c0)object).r0()) == null) {
                bl2 = true;
            } else {
                bl2 = false;
                object = null;
            }
            if (!bl2) {
                String string2 = "priorResponse.body != null".toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private final void f(String string2, c0 object) {
        boolean bl2;
        if (object == null) return;
        d0 d02 = ((c0)object).r0();
        boolean bl3 = true;
        if (d02 == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            Object var3_4 = null;
        }
        if (bl2) {
            c0 c02 = ((c0)object).F0();
            if (c02 == null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                Object var3_7 = null;
            }
            if (bl2) {
                c0 c03 = ((c0)object).t0();
                if (c03 == null) {
                    bl2 = bl3;
                } else {
                    bl2 = false;
                    Object var3_10 = null;
                }
                if (bl2) {
                    if ((object = ((c0)object).I0()) != null) {
                        bl3 = false;
                    }
                    if (bl3) return;
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string2);
                    ((StringBuilder)object).append(".priorResponse != null");
                    string2 = ((StringBuilder)object).toString();
                    string2 = string2.toString();
                    object = new IllegalArgumentException(string2);
                    throw object;
                }
                object = new StringBuilder();
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append(".cacheResponse != null");
                string2 = ((StringBuilder)object).toString();
                string2 = string2.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(".networkResponse != null");
            string2 = ((StringBuilder)object).toString();
            string2 = string2.toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(".body != null");
        string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public c0$a A(c0 c02) {
        this.e(c02);
        this.j = c02;
        return this;
    }

    public c0$a B(Protocol protocol) {
        f0.p((Object)protocol, "protocol");
        this.b = protocol;
        return this;
    }

    public c0$a C(long l10) {
        this.l = l10;
        return this;
    }

    public c0$a D(String string2) {
        f0.p(string2, "name");
        this.f.l(string2);
        return this;
    }

    public c0$a E(a0 a02) {
        f0.p(a02, "request");
        this.a = a02;
        return this;
    }

    public c0$a F(long l10) {
        this.k = l10;
        return this;
    }

    public final void G(d0 d02) {
        this.g = d02;
    }

    public final void H(c0 c02) {
        this.i = c02;
    }

    public final void I(int n10) {
        this.c = n10;
    }

    public final void J(c c10) {
        this.m = c10;
    }

    public final void K(Handshake handshake2) {
        this.e = handshake2;
    }

    public final void L(s$a s$a) {
        f0.p(s$a, "<set-?>");
        this.f = s$a;
    }

    public final void M(String string2) {
        this.d = string2;
    }

    public final void N(c0 c02) {
        this.h = c02;
    }

    public final void O(c0 c02) {
        this.j = c02;
    }

    public final void P(Protocol protocol) {
        this.b = protocol;
    }

    public final void Q(long l10) {
        this.l = l10;
    }

    public final void R(a0 a02) {
        this.a = a02;
    }

    public final void S(long l10) {
        this.k = l10;
    }

    public c0$a a(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        this.f.b(string2, string3);
        return this;
    }

    public c0$a b(d0 d02) {
        this.g = d02;
        return this;
    }

    public c0 c() {
        Object object;
        boolean bl2;
        c0$a c0$a = this;
        int n10 = this.c;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            Object object2 = c0$a.a;
            if (object2 != null) {
                Protocol protocol = c0$a.b;
                if (protocol != null) {
                    String string2 = c0$a.d;
                    if (string2 != null) {
                        c0 c02;
                        Handshake handshake2 = c0$a.e;
                        s s10 = c0$a.f.i();
                        d0 d02 = c0$a.g;
                        c0 c03 = c0$a.h;
                        c0 c04 = c0$a.i;
                        c0 c05 = c0$a.j;
                        long l10 = c0$a.k;
                        long l11 = c0$a.l;
                        Object object3 = object = c0$a.m;
                        object = c02;
                        c02 = new c0((a0)object2, protocol, string2, n10, handshake2, s10, d02, c03, c04, c05, l10, l11, (c)object3);
                        return c02;
                    }
                    object2 = "message == null".toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
                object2 = "protocol == null".toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object2 = "request == null".toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("code < 0: ");
        int n11 = c0$a.c;
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public c0$a d(c0 c02) {
        this.f("cacheResponse", c02);
        this.i = c02;
        return this;
    }

    public c0$a g(int n10) {
        this.c = n10;
        return this;
    }

    public final d0 h() {
        return this.g;
    }

    public final c0 i() {
        return this.i;
    }

    public final int j() {
        return this.c;
    }

    public final c k() {
        return this.m;
    }

    public final Handshake l() {
        return this.e;
    }

    public final s$a m() {
        return this.f;
    }

    public final String n() {
        return this.d;
    }

    public final c0 o() {
        return this.h;
    }

    public final c0 p() {
        return this.j;
    }

    public final Protocol q() {
        return this.b;
    }

    public final long r() {
        return this.l;
    }

    public final a0 s() {
        return this.a;
    }

    public final long t() {
        return this.k;
    }

    public c0$a u(Handshake handshake2) {
        this.e = handshake2;
        return this;
    }

    public c0$a v(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        this.f.m(string2, string3);
        return this;
    }

    public c0$a w(s object) {
        f0.p(object, "headers");
        this.f = object = ((s)object).j();
        return this;
    }

    public final void x(c c10) {
        f0.p(c10, "deferredTrailers");
        this.m = c10;
    }

    public c0$a y(String string2) {
        f0.p(string2, "message");
        this.d = string2;
        return this;
    }

    public c0$a z(c0 c02) {
        this.f("networkResponse", c02);
        this.h = c02;
        return this;
    }
}

