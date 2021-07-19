/*
 * Decompiled with CFR 0.151.
 */
package g;

import g.a0;
import g.b;
import g.e$a;
import g.f0;
import g.f0$a;
import g.g0;
import g.h0.h.d;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.o.a;
import g.h0.p.c;
import g.h0.p.c$a;
import g.h0.q.e;
import g.j;
import g.k;
import g.m;
import g.o;
import g.p;
import g.q$c;
import g.z$a;
import g.z$b;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

public class z
implements Cloneable,
e$a,
f0$a {
    private static final List E;
    private static final List F;
    public static final z$b G;
    private final int A;
    private final int B;
    private final long C;
    private final g.h0.i.h D;
    private final o a;
    private final j b;
    private final List c;
    private final List d;
    private final q$c e;
    private final boolean f;
    private final b g;
    private final boolean h;
    private final boolean i;
    private final m j;
    private final g.c k;
    private final p l;
    private final Proxy m;
    private final ProxySelector n;
    private final b o;
    private final SocketFactory p;
    private final SSLSocketFactory q;
    private final X509TrustManager r;
    private final List s;
    private final List t;
    private final HostnameVerifier u;
    private final CertificatePinner v;
    private final c w;
    private final int x;
    private final int y;
    private final int z;

    static {
        Protocol protocol;
        Object[] objectArray = new z$b(null);
        G = objectArray;
        int n10 = 2;
        Object object = new Protocol[n10];
        object[0] = protocol = Protocol.HTTP_2;
        protocol = Protocol.HTTP_1_1;
        int n11 = 1;
        object[n11] = protocol;
        E = g.h0.d.z((Object[])object);
        objectArray = new k[n10];
        objectArray[0] = object = g.k.h;
        objectArray[n11] = object = g.k.j;
        F = g.h0.d.z(objectArray);
    }

    public z() {
        z$a z$a = new z$a();
        this(z$a);
    }

    public z(z$a object) {
        long l10;
        int n10;
        boolean bl2;
        f.h2.t.f0.p(object, "builder");
        Object object2 = ((z$a)object).E();
        this.a = object2;
        this.b = object2 = ((z$a)object).B();
        this.c = object2 = g.h0.d.c0(((z$a)object).K());
        this.d = object2 = g.h0.d.c0(((z$a)object).M());
        this.e = object2 = ((z$a)object).G();
        this.f = bl2 = ((z$a)object).T();
        this.g = object2 = ((z$a)object).v();
        this.h = bl2 = ((z$a)object).H();
        this.i = bl2 = ((z$a)object).I();
        this.j = object2 = ((z$a)object).D();
        this.k = object2 = ((z$a)object).w();
        this.l = object2 = ((z$a)object).F();
        this.m = object2 = ((z$a)object).P();
        object2 = ((z$a)object).P();
        if (object2 != null) {
            object2 = g.h0.o.a.a;
        } else {
            object2 = ((z$a)object).R();
            if (object2 == null) {
                object2 = ProxySelector.getDefault();
            }
            if (object2 == null) {
                object2 = g.h0.o.a.a;
            }
        }
        this.n = object2;
        this.o = object2 = ((z$a)object).Q();
        this.p = object2 = ((z$a)object).V();
        this.s = object2 = ((z$a)object).C();
        Object object3 = ((z$a)object).O();
        this.t = object3;
        this.u = object3 = ((z$a)object).J();
        this.x = n10 = ((z$a)object).x();
        this.y = n10 = ((z$a)object).A();
        this.z = n10 = ((z$a)object).S();
        this.A = n10 = ((z$a)object).X();
        this.B = n10 = ((z$a)object).N();
        this.C = l10 = ((z$a)object).L();
        object3 = ((z$a)object).U();
        if (object3 == null) {
            object3 = new g.h0.i.h();
        }
        this.D = object3;
        n10 = object2 instanceof Collection;
        boolean bl3 = true;
        if (n10 == 0 || (n10 = (int)(object2.isEmpty() ? 1 : 0)) == 0) {
            object2 = object2.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object3 = (k)object2.next();
                n10 = (int)(((k)object3).i() ? 1 : 0);
                if (n10 == 0) continue;
                bl3 = false;
                break;
            }
        }
        if (bl3) {
            this.q = null;
            this.w = null;
            this.r = null;
            this.v = object = CertificatePinner.c;
        } else {
            object2 = ((z$a)object).W();
            if (object2 != null) {
                this.q = object2 = ((z$a)object).W();
                object2 = ((z$a)object).y();
                f.h2.t.f0.m(object2);
                this.w = object2;
                object3 = ((z$a)object).Y();
                f.h2.t.f0.m(object3);
                this.r = object3;
                object = ((z$a)object).z();
                f.h2.t.f0.m(object2);
                this.v = object = ((CertificatePinner)object).j((c)object2);
            } else {
                object2 = g.h0.n.h.e;
                this.r = object3 = ((h$a)object2).g().r();
                object2 = ((h$a)object2).g();
                f.h2.t.f0.m(object3);
                this.q = object2 = ((h)object2).q((X509TrustManager)object3);
                object2 = g.h0.p.c.a;
                f.h2.t.f0.m(object3);
                this.w = object2 = ((c$a)object2).a((X509TrustManager)object3);
                object = ((z$a)object).z();
                f.h2.t.f0.m(object2);
                this.v = object = ((CertificatePinner)object).j((c)object2);
            }
        }
        this.m0();
    }

    public static final /* synthetic */ List F() {
        return F;
    }

    public static final /* synthetic */ List G() {
        return E;
    }

    public static final /* synthetic */ SSLSocketFactory H(z z10) {
        return z10.q;
    }

    /*
     * Enabled aggressive block sorting
     */
    private final void m0() {
        Object object = this.c;
        Object object2 = "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Interceptor?>";
        Objects.requireNonNull(object, (String)object2);
        CertificatePinner certificatePinner = null;
        boolean bl2 = object.contains(null);
        boolean bl3 = true;
        if (!(bl2 ^= bl3)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Null interceptor: ");
            object2 = this.c;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        object = this.d;
        Objects.requireNonNull(object, (String)object2);
        bl2 = object.contains(null) ^ bl3;
        if (!bl2) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Null network interceptor: ");
            object2 = this.d;
            ((StringBuilder)object).append(object2);
            object = ((StringBuilder)object).toString();
            object = object.toString();
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        object = this.s;
        boolean bl4 = object instanceof Collection;
        certificatePinner = null;
        if (!bl4 || !(bl4 = object.isEmpty())) {
            object = object.iterator();
            while (bl4 = object.hasNext()) {
                object2 = (k)object.next();
                bl4 = ((k)object2).i();
                if (!bl4) continue;
                bl2 = false;
                object = null;
                break;
            }
        } else {
            bl2 = bl3;
        }
        if (bl2) {
            object = this.q;
            if (object == null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object = null;
            }
            object2 = "Check failed.";
            if (!bl2) {
                object2 = object2.toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object = this.w;
            if (object == null) {
                bl2 = bl3;
            } else {
                bl2 = false;
                object = null;
            }
            if (!bl2) {
                object2 = object2.toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object = this.r;
            if (object != null) {
                bl3 = false;
            }
            if (!bl3) {
                object2 = object2.toString();
                object = new IllegalStateException((String)object2);
                throw object;
            }
            object = this.v;
            certificatePinner = CertificatePinner.c;
            bl2 = f.h2.t.f0.g(object, certificatePinner);
            if (bl2) {
                return;
            }
            object2 = object2.toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object = this.q;
        if (object == null) {
            object2 = "sslSocketFactory == null".toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object = this.w;
        if (object == null) {
            object2 = "certificateChainCleaner == null".toString();
            object = new IllegalStateException((String)object2);
            throw object;
        }
        object = this.r;
        if (object != null) {
            return;
        }
        object2 = "x509TrustManager == null".toString();
        object = new IllegalStateException((String)object2);
        throw object;
    }

    public final SocketFactory A() {
        return this.p;
    }

    public final SSLSocketFactory B() {
        return this.l0();
    }

    public final int E() {
        return this.A;
    }

    public final b I() {
        return this.g;
    }

    public final g.c J() {
        return this.k;
    }

    public final int K() {
        return this.x;
    }

    public final c L() {
        return this.w;
    }

    public final CertificatePinner M() {
        return this.v;
    }

    public final int N() {
        return this.y;
    }

    public final j O() {
        return this.b;
    }

    public final List P() {
        return this.s;
    }

    public final m Q() {
        return this.j;
    }

    public final o R() {
        return this.a;
    }

    public final p T() {
        return this.l;
    }

    public final q$c U() {
        return this.e;
    }

    public final boolean V() {
        return this.h;
    }

    public final boolean W() {
        return this.i;
    }

    public final g.h0.i.h X() {
        return this.D;
    }

    public final HostnameVerifier Y() {
        return this.u;
    }

    public final List Z() {
        return this.c;
    }

    public g.e a(a0 a02) {
        f.h2.t.f0.p(a02, "request");
        g.h0.i.e e10 = new g.h0.i.e(this, a02, false);
        return e10;
    }

    public final long a0() {
        return this.C;
    }

    public f0 b(a0 a02, g0 g02) {
        f.h2.t.f0.p(a02, "request");
        f.h2.t.f0.p(g02, "listener");
        d d10 = g.h0.h.d.h;
        Random random = new Random();
        long l10 = this.B;
        long l11 = this.C;
        e e10 = new e(d10, a02, g02, random, l10, null, l11);
        e10.q(this);
        return e10;
    }

    public final List b0() {
        return this.d;
    }

    public final b c() {
        return this.g;
    }

    public z$a c0() {
        z$a z$a = new z$a(this);
        return z$a;
    }

    public Object clone() {
        return super.clone();
    }

    public final g.c d() {
        return this.k;
    }

    public final int d0() {
        return this.B;
    }

    public final int e() {
        return this.x;
    }

    public final List e0() {
        return this.t;
    }

    public final CertificatePinner f() {
        return this.v;
    }

    public final Proxy f0() {
        return this.m;
    }

    public final int g() {
        return this.y;
    }

    public final b g0() {
        return this.o;
    }

    public final ProxySelector h0() {
        return this.n;
    }

    public final j i() {
        return this.b;
    }

    public final int i0() {
        return this.z;
    }

    public final List j() {
        return this.s;
    }

    public final boolean j0() {
        return this.f;
    }

    public final m k() {
        return this.j;
    }

    public final SocketFactory k0() {
        return this.p;
    }

    public final o l() {
        return this.a;
    }

    public final SSLSocketFactory l0() {
        Object object = this.q;
        if (object != null) {
            return object;
        }
        object = new IllegalStateException("CLEARTEXT-only client");
        throw object;
    }

    public final p m() {
        return this.l;
    }

    public final q$c n() {
        return this.e;
    }

    public final int n0() {
        return this.A;
    }

    public final boolean o() {
        return this.h;
    }

    public final X509TrustManager o0() {
        return this.r;
    }

    public final boolean p() {
        return this.i;
    }

    public final HostnameVerifier q() {
        return this.u;
    }

    public final List r() {
        return this.c;
    }

    public final List s() {
        return this.d;
    }

    public final int t() {
        return this.B;
    }

    public final List u() {
        return this.t;
    }

    public final Proxy v() {
        return this.m;
    }

    public final b w() {
        return this.o;
    }

    public final ProxySelector x() {
        return this.n;
    }

    public final int y() {
        return this.z;
    }

    public final boolean z() {
        return this.f;
    }
}

