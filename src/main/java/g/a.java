/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.b;
import g.h0.d;
import g.p;
import g.t;
import g.t$a;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import java.util.Objects;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.CertificatePinner;

public final class a {
    private final t a;
    private final List b;
    private final List c;
    private final p d;
    private final SocketFactory e;
    private final SSLSocketFactory f;
    private final HostnameVerifier g;
    private final CertificatePinner h;
    private final b i;
    private final Proxy j;
    private final ProxySelector k;

    public a(String object, int n10, p object2, SocketFactory object3, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, b b10, Proxy proxy, List list, List list2, ProxySelector proxySelector) {
        f0.p(object, "uriHost");
        f0.p(object2, "dns");
        f0.p(object3, "socketFactory");
        f0.p(b10, "proxyAuthenticator");
        f0.p(list, "protocols");
        f0.p(list2, "connectionSpecs");
        String string2 = "proxySelector";
        f0.p(proxySelector, string2);
        this.d = object2;
        this.e = object3;
        this.f = sSLSocketFactory;
        this.g = hostnameVerifier;
        this.h = certificatePinner;
        this.i = b10;
        this.j = proxy;
        this.k = proxySelector;
        object2 = new t$a();
        object3 = sSLSocketFactory != null ? "https" : "http";
        this.a = object = ((t$a)object2).M((String)object3).x((String)object).D(n10).h();
        this.b = object = g.h0.d.c0(list);
        this.c = object = g.h0.d.c0(list2);
    }

    public final CertificatePinner a() {
        return this.h;
    }

    public final List b() {
        return this.c;
    }

    public final p c() {
        return this.d;
    }

    public final HostnameVerifier d() {
        return this.g;
    }

    public final List e() {
        return this.b;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean equals(Object object) {
        boolean bl2 = object instanceof a;
        if (!bl2) return false;
        t t10 = this.a;
        object = (a)object;
        t t11 = ((a)object).a;
        bl2 = f0.g(t10, t11);
        if (!bl2) return false;
        boolean bl3 = this.o((a)object);
        if (!bl3) return false;
        return true;
    }

    public final Proxy f() {
        return this.j;
    }

    public final b g() {
        return this.i;
    }

    public final ProxySelector h() {
        return this.k;
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = (527 + n10) * 31;
        n10 = this.d.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.i.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = ((Object)this.b).hashCode();
        n11 = (n11 + n10) * 31;
        n10 = ((Object)this.c).hashCode();
        n11 = (n11 + n10) * 31;
        n10 = this.k.hashCode();
        n11 = (n11 + n10) * 31;
        n10 = Objects.hashCode(this.j);
        n11 = (n11 + n10) * 31;
        n10 = Objects.hashCode(this.f);
        n11 = (n11 + n10) * 31;
        n10 = Objects.hashCode(this.g);
        n11 = (n11 + n10) * 31;
        n10 = Objects.hashCode(this.h);
        return n11 + n10;
    }

    public final SocketFactory i() {
        return this.e;
    }

    public final SSLSocketFactory j() {
        return this.f;
    }

    public final t k() {
        return this.a;
    }

    public final CertificatePinner l() {
        return this.h;
    }

    public final List m() {
        return this.c;
    }

    public final p n() {
        return this.d;
    }

    public final boolean o(a object) {
        int n10;
        f0.p(object, "that");
        Object object2 = this.d;
        Object object3 = ((a)object).d;
        int n11 = f0.g(object2, object3);
        if (n11 != 0 && (n11 = f0.g(object2 = this.i, object3 = ((a)object).i)) != 0 && (n11 = f0.g(object2 = this.b, object3 = ((a)object).b)) != 0 && (n11 = f0.g(object2 = this.c, object3 = ((a)object).c)) != 0 && (n11 = f0.g(object2 = this.k, object3 = ((a)object).k)) != 0 && (n11 = f0.g(object2 = this.j, object3 = ((a)object).j)) != 0 && (n11 = f0.g(object2 = this.f, object3 = ((a)object).f)) != 0 && (n11 = f0.g(object2 = this.g, object3 = ((a)object).g)) != 0 && (n11 = f0.g(object2 = this.h, object3 = ((a)object).h)) != 0 && (n11 = ((t)(object2 = this.a)).N()) == (n10 = ((t)(object = ((a)object).a)).N())) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public final HostnameVerifier p() {
        return this.g;
    }

    public final List q() {
        return this.b;
    }

    public final Proxy r() {
        return this.j;
    }

    public final b s() {
        return this.i;
    }

    public final ProxySelector t() {
        return this.k;
    }

    public String toString() {
        Object object;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Address{");
        Object object2 = this.a.F();
        stringBuilder.append((String)object2);
        stringBuilder.append(':');
        int n10 = this.a.N();
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        object2 = this.j;
        if (object2 != null) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("proxy=");
            object = this.j;
        } else {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("proxySelector=");
            object = this.k;
        }
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        stringBuilder.append((String)object2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    public final SocketFactory u() {
        return this.e;
    }

    public final SSLSocketFactory v() {
        return this.f;
    }

    public final t w() {
        return this.a;
    }
}

