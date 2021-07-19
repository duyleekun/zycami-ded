/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.y;
import g.b;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.p.c;
import g.h0.p.d;
import g.j;
import g.m;
import g.o;
import g.p;
import g.q;
import g.q$c;
import g.u;
import g.z;
import g.z$a$a;
import g.z$a$b;
import g.z$b;
import j$.time.Duration;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import kotlin.collections.CollectionsKt___CollectionsKt;
import okhttp3.CertificatePinner;
import okhttp3.Protocol;

public final class z$a {
    private int A;
    private int B;
    private long C;
    private g.h0.i.h D;
    private o a;
    private j b;
    private final List c;
    private final List d;
    private q$c e;
    private boolean f;
    private b g;
    private boolean h;
    private boolean i;
    private m j;
    private g.c k;
    private p l;
    private Proxy m;
    private ProxySelector n;
    private b o;
    private SocketFactory p;
    private SSLSocketFactory q;
    private X509TrustManager r;
    private List s;
    private List t;
    private HostnameVerifier u;
    private CertificatePinner v;
    private c w;
    private int x;
    private int y;
    private int z;

    public z$a() {
        int n10;
        Object object = new o();
        this.a = object;
        this.b = object = new j();
        object = new ArrayList();
        this.c = object;
        object = new ArrayList();
        this.d = object;
        this.e = object = g.h0.d.e(g.q.a);
        this.f = n10 = 1;
        Object object2 = g.b.a;
        this.g = object2;
        this.h = n10;
        this.i = n10;
        this.j = object = g.m.a;
        this.l = object = g.p.a;
        this.o = object2;
        object = SocketFactory.getDefault();
        f0.o(object, "SocketFactory.getDefault()");
        this.p = object;
        object = g.z.G;
        this.s = object2 = ((z$b)object).a();
        this.t = object = ((z$b)object).b();
        this.u = object = g.h0.p.d.c;
        this.v = object = CertificatePinner.c;
        this.y = n10 = 10000;
        this.z = n10;
        this.A = n10;
        this.C = 1024L;
    }

    public z$a(z object) {
        long l10;
        int n10;
        f0.p(object, "okHttpClient");
        this();
        Object object2 = ((z)object).R();
        this.a = object2;
        this.b = object2 = ((z)object).O();
        object2 = this.c;
        List list = ((z)object).Z();
        f.x1.y.q0((Collection)object2, list);
        object2 = this.d;
        list = ((z)object).b0();
        f.x1.y.q0((Collection)object2, list);
        this.e = object2 = ((z)object).U();
        this.f = n10 = ((z)object).j0();
        this.g = object2 = ((z)object).I();
        this.h = n10 = ((z)object).V();
        this.i = n10 = ((z)object).W();
        this.j = object2 = ((z)object).Q();
        this.k = object2 = ((z)object).J();
        this.l = object2 = ((z)object).T();
        this.m = object2 = ((z)object).f0();
        this.n = object2 = ((z)object).h0();
        this.o = object2 = ((z)object).g0();
        this.p = object2 = ((z)object).k0();
        this.q = object2 = g.z.H((z)object);
        this.r = object2 = ((z)object).o0();
        this.s = object2 = ((z)object).P();
        this.t = object2 = ((z)object).e0();
        this.u = object2 = ((z)object).Y();
        this.v = object2 = ((z)object).M();
        this.w = object2 = ((z)object).L();
        this.x = n10 = ((z)object).K();
        this.y = n10 = ((z)object).N();
        this.z = n10 = ((z)object).i0();
        this.A = n10 = ((z)object).n0();
        this.B = n10 = ((z)object).d0();
        this.C = l10 = ((z)object).a0();
        this.D = object = ((z)object).X();
    }

    public final int A() {
        return this.y;
    }

    public final void A0(HostnameVerifier hostnameVerifier) {
        f0.p(hostnameVerifier, "<set-?>");
        this.u = hostnameVerifier;
    }

    public final j B() {
        return this.b;
    }

    public final void B0(long l10) {
        this.C = l10;
    }

    public final List C() {
        return this.s;
    }

    public final void C0(int n10) {
        this.B = n10;
    }

    public final m D() {
        return this.j;
    }

    public final void D0(List list) {
        f0.p(list, "<set-?>");
        this.t = list;
    }

    public final o E() {
        return this.a;
    }

    public final void E0(Proxy proxy) {
        this.m = proxy;
    }

    public final p F() {
        return this.l;
    }

    public final void F0(b b10) {
        f0.p(b10, "<set-?>");
        this.o = b10;
    }

    public final q$c G() {
        return this.e;
    }

    public final void G0(ProxySelector proxySelector) {
        this.n = proxySelector;
    }

    public final boolean H() {
        return this.h;
    }

    public final void H0(int n10) {
        this.z = n10;
    }

    public final boolean I() {
        return this.i;
    }

    public final void I0(boolean bl2) {
        this.f = bl2;
    }

    public final HostnameVerifier J() {
        return this.u;
    }

    public final void J0(g.h0.i.h h10) {
        this.D = h10;
    }

    public final List K() {
        return this.c;
    }

    public final void K0(SocketFactory socketFactory) {
        f0.p(socketFactory, "<set-?>");
        this.p = socketFactory;
    }

    public final long L() {
        return this.C;
    }

    public final void L0(SSLSocketFactory sSLSocketFactory) {
        this.q = sSLSocketFactory;
    }

    public final List M() {
        return this.d;
    }

    public final void M0(int n10) {
        this.A = n10;
    }

    public final int N() {
        return this.B;
    }

    public final void N0(X509TrustManager x509TrustManager) {
        this.r = x509TrustManager;
    }

    public final List O() {
        return this.t;
    }

    public final z$a O0(SocketFactory object) {
        Object object2 = "socketFactory";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof SSLSocketFactory ^ true;
        if (bl2) {
            object2 = this.p;
            bl2 = f0.g(object, object2) ^ true;
            if (bl2) {
                bl2 = false;
                object2 = null;
                this.D = null;
            }
            this.p = object;
            return this;
        }
        object2 = "socketFactory instanceof SSLSocketFactory".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public final Proxy P() {
        return this.m;
    }

    public final z$a P0(SSLSocketFactory object) {
        f0.p(object, "sslSocketFactory");
        Object object2 = this.q;
        boolean bl2 = f0.g(object, object2) ^ true;
        if (bl2) {
            bl2 = false;
            object2 = null;
            this.D = null;
        }
        this.q = object;
        object2 = g.h0.n.h.e;
        Object object3 = ((h$a)object2).g().s((SSLSocketFactory)object);
        if (object3 != null) {
            this.r = object3;
            object = ((h$a)object2).g();
            object2 = this.r;
            f0.m(object2);
            this.w = object = ((h)object).d((X509TrustManager)object2);
            return this;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to extract the trust manager on ");
        object2 = ((h$a)object2).g();
        stringBuilder.append(object2);
        stringBuilder.append(", ");
        stringBuilder.append("sslSocketFactory is ");
        object = object.getClass();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object3 = new IllegalStateException((String)object);
        throw object3;
    }

    public final b Q() {
        return this.o;
    }

    public final z$a Q0(SSLSocketFactory object, X509TrustManager x509TrustManager) {
        f0.p(object, "sslSocketFactory");
        f0.p(x509TrustManager, "trustManager");
        Object object2 = this.q;
        boolean bl2 = f0.g(object, object2) ^ true;
        if (bl2 || (bl2 = f0.g(x509TrustManager, object2 = this.r) ^ true)) {
            bl2 = false;
            object2 = null;
            this.D = null;
        }
        this.q = object;
        this.w = object = g.h0.p.c.a.a(x509TrustManager);
        this.r = x509TrustManager;
        return this;
    }

    public final ProxySelector R() {
        return this.n;
    }

    public final z$a R0(long l10, TimeUnit timeUnit) {
        int n10;
        f0.p((Object)timeUnit, "unit");
        this.A = n10 = g.h0.d.j("timeout", l10, timeUnit);
        return this;
    }

    public final int S() {
        return this.z;
    }

    public final z$a S0(Duration object) {
        f0.p(object, "duration");
        long l10 = object.toMillis();
        object = TimeUnit.MILLISECONDS;
        this.R0(l10, (TimeUnit)((Object)object));
        return this;
    }

    public final boolean T() {
        return this.f;
    }

    public final g.h0.i.h U() {
        return this.D;
    }

    public final SocketFactory V() {
        return this.p;
    }

    public final SSLSocketFactory W() {
        return this.q;
    }

    public final int X() {
        return this.A;
    }

    public final X509TrustManager Y() {
        return this.r;
    }

    public final z$a Z(HostnameVerifier hostnameVerifier) {
        f0.p(hostnameVerifier, "hostnameVerifier");
        HostnameVerifier hostnameVerifier2 = this.u;
        boolean bl2 = f0.g(hostnameVerifier, hostnameVerifier2) ^ true;
        if (bl2) {
            bl2 = false;
            hostnameVerifier2 = null;
            this.D = null;
        }
        this.u = hostnameVerifier;
        return this;
    }

    public final z$a a(l l10) {
        f0.p(l10, "block");
        z$a$a z$a$a = new z$a$a(l10);
        return this.c(z$a$a);
    }

    public final List a0() {
        return this.c;
    }

    public final z$a b(l l10) {
        f0.p(l10, "block");
        z$a$b z$a$b = new z$a$b(l10);
        return this.d(z$a$b);
    }

    public final z$a b0(long l10) {
        StringBuilder stringBuilder;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            object = 1;
        } else {
            object = 0;
            stringBuilder = null;
        }
        if (object != false) {
            this.C = l10;
            return this;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("minWebSocketMessageToCompress must be positive: ");
        stringBuilder.append(l10);
        String string2 = stringBuilder.toString();
        string2 = string2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public final z$a c(u u10) {
        f0.p(u10, "interceptor");
        this.c.add(u10);
        return this;
    }

    public final List c0() {
        return this.d;
    }

    public final z$a d(u u10) {
        f0.p(u10, "interceptor");
        this.d.add(u10);
        return this;
    }

    public final z$a d0(long l10, TimeUnit timeUnit) {
        int n10;
        f0.p((Object)timeUnit, "unit");
        this.B = n10 = g.h0.d.j("interval", l10, timeUnit);
        return this;
    }

    public final z$a e(b b10) {
        f0.p(b10, "authenticator");
        this.g = b10;
        return this;
    }

    public final z$a e0(Duration object) {
        f0.p(object, "duration");
        long l10 = object.toMillis();
        object = TimeUnit.MILLISECONDS;
        this.d0(l10, (TimeUnit)((Object)object));
        return this;
    }

    public final z f() {
        z z10 = new z(this);
        return z10;
    }

    public final z$a f0(List list) {
        Object object;
        f0.p(list, "protocols");
        list = CollectionsKt___CollectionsKt.L5(list);
        Object object2 = Protocol.H2_PRIOR_KNOWLEDGE;
        int n10 = list.contains(object2);
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0 && (n10 = list.contains(object = Protocol.HTTP_1_1)) == 0) {
            n10 = 0;
            object = null;
        } else {
            n10 = n12;
        }
        if (n10 != 0) {
            int n13 = list.contains(object2);
            if (n13 == 0 || (n13 = list.size()) <= n12) {
                n11 = n12;
            }
            if (n11 != 0) {
                object2 = Protocol.HTTP_1_0;
                n13 = list.contains(object2) ^ n12;
                if (n13 != 0) {
                    Objects.requireNonNull(list, "null cannot be cast to non-null type kotlin.collections.List<okhttp3.Protocol?>");
                    n13 = 0;
                    object2 = null;
                    n10 = list.contains(null) ^ n12;
                    if (n10 != 0) {
                        object = Protocol.SPDY_3;
                        list.remove(object);
                        object = this.t;
                        n10 = f0.g(list, object) ^ n12;
                        if (n10 != 0) {
                            this.D = null;
                        }
                        list = Collections.unmodifiableList(list);
                        f0.o(list, "Collections.unmodifiableList(protocolsCopy)");
                        this.t = list;
                        return this;
                    }
                    object2 = "protocols must not contain null".toString();
                    list = new List((String)object2);
                    throw list;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("protocols must not contain http/1.0: ");
                ((StringBuilder)object2).append(list);
                list = ((StringBuilder)object2).toString();
                list = list.toString();
                object2 = new IllegalArgumentException((String)((Object)list));
                throw object2;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("protocols containing h2_prior_knowledge cannot use other protocols: ");
            ((StringBuilder)object2).append(list);
            list = ((StringBuilder)object2).toString();
            list = list.toString();
            object2 = new IllegalArgumentException((String)((Object)list));
            throw object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("protocols must contain h2_prior_knowledge or http/1.1: ");
        ((StringBuilder)object2).append(list);
        list = ((StringBuilder)object2).toString();
        list = list.toString();
        object2 = new IllegalArgumentException((String)((Object)list));
        throw object2;
    }

    public final z$a g(g.c c10) {
        this.k = c10;
        return this;
    }

    public final z$a g0(Proxy proxy) {
        Proxy proxy2 = this.m;
        boolean bl2 = f0.g(proxy, proxy2) ^ true;
        if (bl2) {
            bl2 = false;
            proxy2 = null;
            this.D = null;
        }
        this.m = proxy;
        return this;
    }

    public final z$a h(long l10, TimeUnit timeUnit) {
        int n10;
        f0.p((Object)timeUnit, "unit");
        this.x = n10 = g.h0.d.j("timeout", l10, timeUnit);
        return this;
    }

    public final z$a h0(b b10) {
        f0.p(b10, "proxyAuthenticator");
        b b11 = this.o;
        boolean bl2 = f0.g(b10, b11) ^ true;
        if (bl2) {
            bl2 = false;
            b11 = null;
            this.D = null;
        }
        this.o = b10;
        return this;
    }

    public final z$a i(Duration object) {
        f0.p(object, "duration");
        long l10 = object.toMillis();
        object = TimeUnit.MILLISECONDS;
        this.h(l10, (TimeUnit)((Object)object));
        return this;
    }

    public final z$a i0(ProxySelector proxySelector) {
        f0.p(proxySelector, "proxySelector");
        ProxySelector proxySelector2 = this.n;
        boolean bl2 = f0.g(proxySelector, proxySelector2) ^ true;
        if (bl2) {
            bl2 = false;
            proxySelector2 = null;
            this.D = null;
        }
        this.n = proxySelector;
        return this;
    }

    public final z$a j(CertificatePinner certificatePinner) {
        f0.p(certificatePinner, "certificatePinner");
        CertificatePinner certificatePinner2 = this.v;
        boolean bl2 = f0.g(certificatePinner, certificatePinner2) ^ true;
        if (bl2) {
            bl2 = false;
            certificatePinner2 = null;
            this.D = null;
        }
        this.v = certificatePinner;
        return this;
    }

    public final z$a j0(long l10, TimeUnit timeUnit) {
        int n10;
        f0.p((Object)timeUnit, "unit");
        this.z = n10 = g.h0.d.j("timeout", l10, timeUnit);
        return this;
    }

    public final z$a k(long l10, TimeUnit timeUnit) {
        int n10;
        f0.p((Object)timeUnit, "unit");
        this.y = n10 = g.h0.d.j("timeout", l10, timeUnit);
        return this;
    }

    public final z$a k0(Duration object) {
        f0.p(object, "duration");
        long l10 = object.toMillis();
        object = TimeUnit.MILLISECONDS;
        this.j0(l10, (TimeUnit)((Object)object));
        return this;
    }

    public final z$a l(Duration object) {
        f0.p(object, "duration");
        long l10 = object.toMillis();
        object = TimeUnit.MILLISECONDS;
        this.k(l10, (TimeUnit)((Object)object));
        return this;
    }

    public final z$a l0(boolean bl2) {
        this.f = bl2;
        return this;
    }

    public final z$a m(j j10) {
        f0.p(j10, "connectionPool");
        this.b = j10;
        return this;
    }

    public final void m0(b b10) {
        f0.p(b10, "<set-?>");
        this.g = b10;
    }

    public final z$a n(List list) {
        f0.p(list, "connectionSpecs");
        List list2 = this.s;
        boolean bl2 = f0.g(list, list2) ^ true;
        if (bl2) {
            bl2 = false;
            list2 = null;
            this.D = null;
        }
        this.s = list = g.h0.d.c0(list);
        return this;
    }

    public final void n0(g.c c10) {
        this.k = c10;
    }

    public final z$a o(m m10) {
        f0.p(m10, "cookieJar");
        this.j = m10;
        return this;
    }

    public final void o0(int n10) {
        this.x = n10;
    }

    public final z$a p(o o10) {
        f0.p(o10, "dispatcher");
        this.a = o10;
        return this;
    }

    public final void p0(c c10) {
        this.w = c10;
    }

    public final z$a q(p p10) {
        f0.p(p10, "dns");
        p p11 = this.l;
        boolean bl2 = f0.g(p10, p11) ^ true;
        if (bl2) {
            bl2 = false;
            p11 = null;
            this.D = null;
        }
        this.l = p10;
        return this;
    }

    public final void q0(CertificatePinner certificatePinner) {
        f0.p(certificatePinner, "<set-?>");
        this.v = certificatePinner;
    }

    public final z$a r(q object) {
        f0.p(object, "eventListener");
        this.e = object = g.h0.d.e((q)object);
        return this;
    }

    public final void r0(int n10) {
        this.y = n10;
    }

    public final z$a s(q$c q$c) {
        f0.p(q$c, "eventListenerFactory");
        this.e = q$c;
        return this;
    }

    public final void s0(j j10) {
        f0.p(j10, "<set-?>");
        this.b = j10;
    }

    public final z$a t(boolean bl2) {
        this.h = bl2;
        return this;
    }

    public final void t0(List list) {
        f0.p(list, "<set-?>");
        this.s = list;
    }

    public final z$a u(boolean bl2) {
        this.i = bl2;
        return this;
    }

    public final void u0(m m10) {
        f0.p(m10, "<set-?>");
        this.j = m10;
    }

    public final b v() {
        return this.g;
    }

    public final void v0(o o10) {
        f0.p(o10, "<set-?>");
        this.a = o10;
    }

    public final g.c w() {
        return this.k;
    }

    public final void w0(p p10) {
        f0.p(p10, "<set-?>");
        this.l = p10;
    }

    public final int x() {
        return this.x;
    }

    public final void x0(q$c q$c) {
        f0.p(q$c, "<set-?>");
        this.e = q$c;
    }

    public final c y() {
        return this.w;
    }

    public final void y0(boolean bl2) {
        this.h = bl2;
    }

    public final CertificatePinner z() {
        return this.v;
    }

    public final void z0(boolean bl2) {
        this.i = bl2;
    }
}

