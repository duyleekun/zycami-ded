/*
 * Decompiled with CFR 0.151.
 */
package g.i0;

import f.h2.t.f0;
import f.h2.t.u;
import g.a0;
import g.c0;
import g.e;
import g.i;
import g.q;
import g.t;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Handshake;
import okhttp3.Protocol;
import okhttp3.logging.HttpLoggingInterceptor$a;

public final class a
extends q {
    private long c;
    private final HttpLoggingInterceptor$a d;

    private a(HttpLoggingInterceptor$a httpLoggingInterceptor$a) {
        this.d = httpLoggingInterceptor$a;
    }

    public /* synthetic */ a(HttpLoggingInterceptor$a httpLoggingInterceptor$a, u u10) {
        this(httpLoggingInterceptor$a);
    }

    private final void D(String string2) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        long l10 = System.nanoTime();
        long l11 = this.c;
        long l12 = timeUnit.toMillis(l10 -= l11);
        HttpLoggingInterceptor$a httpLoggingInterceptor$a = this.d;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        stringBuilder.append(l12);
        stringBuilder.append(" ms] ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        httpLoggingInterceptor$a.log(string2);
    }

    public void A(e object, c0 c02) {
        f0.p(object, "call");
        f0.p(c02, "response");
        object = new StringBuilder();
        ((StringBuilder)object).append("satisfactionFailure: ");
        ((StringBuilder)object).append(c02);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void B(e object, Handshake handshake2) {
        f0.p(object, "call");
        object = new StringBuilder();
        ((StringBuilder)object).append("secureConnectEnd: ");
        ((StringBuilder)object).append(handshake2);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void C(e e10) {
        f0.p(e10, "call");
        this.D("secureConnectStart");
    }

    public void a(e object, c0 c02) {
        f0.p(object, "call");
        f0.p(c02, "cachedResponse");
        object = new StringBuilder();
        ((StringBuilder)object).append("cacheConditionalHit: ");
        ((StringBuilder)object).append(c02);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void b(e object, c0 c02) {
        f0.p(object, "call");
        f0.p(c02, "response");
        object = new StringBuilder();
        ((StringBuilder)object).append("cacheHit: ");
        ((StringBuilder)object).append(c02);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void c(e e10) {
        f0.p(e10, "call");
        this.D("cacheMiss");
    }

    public void d(e e10) {
        f0.p(e10, "call");
        this.D("callEnd");
    }

    public void e(e object, IOException iOException) {
        f0.p(object, "call");
        f0.p(iOException, "ioe");
        object = new StringBuilder();
        ((StringBuilder)object).append("callFailed: ");
        ((StringBuilder)object).append(iOException);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void f(e object) {
        long l10;
        f0.p(object, "call");
        this.c = l10 = System.nanoTime();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("callStart: ");
        object = object.C();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        this.D((String)object);
    }

    public void g(e e10) {
        f0.p(e10, "call");
        this.D("canceled");
    }

    public void h(e object, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        f0.p(object, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectEnd: ");
        ((StringBuilder)object).append((Object)protocol);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void i(e object, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        f0.p(object, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        f0.p(iOException, "ioe");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectFailed: ");
        ((StringBuilder)object).append((Object)protocol);
        ((StringBuilder)object).append(' ');
        ((StringBuilder)object).append(iOException);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void j(e object, InetSocketAddress inetSocketAddress, Proxy proxy) {
        f0.p(object, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectStart: ");
        ((StringBuilder)object).append(inetSocketAddress);
        ((StringBuilder)object).append(' ');
        ((StringBuilder)object).append(proxy);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void k(e object, i i10) {
        f0.p(object, "call");
        f0.p(i10, "connection");
        object = new StringBuilder();
        ((StringBuilder)object).append("connectionAcquired: ");
        ((StringBuilder)object).append(i10);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void l(e e10, i i10) {
        f0.p(e10, "call");
        f0.p(i10, "connection");
        this.D("connectionReleased");
    }

    public void m(e object, String string2, List list) {
        f0.p(object, "call");
        f0.p(string2, "domainName");
        f0.p(list, "inetAddressList");
        object = new StringBuilder();
        ((StringBuilder)object).append("dnsEnd: ");
        ((StringBuilder)object).append(list);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void n(e object, String string2) {
        f0.p(object, "call");
        f0.p(string2, "domainName");
        object = new StringBuilder();
        ((StringBuilder)object).append("dnsStart: ");
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void o(e object, t t10, List list) {
        f0.p(object, "call");
        f0.p(t10, "url");
        f0.p(list, "proxies");
        object = new StringBuilder();
        ((StringBuilder)object).append("proxySelectEnd: ");
        ((StringBuilder)object).append(list);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void p(e object, t t10) {
        f0.p(object, "call");
        f0.p(t10, "url");
        object = new StringBuilder();
        ((StringBuilder)object).append("proxySelectStart: ");
        ((StringBuilder)object).append(t10);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void q(e object, long l10) {
        f0.p(object, "call");
        object = new StringBuilder();
        ((StringBuilder)object).append("requestBodyEnd: byteCount=");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void r(e e10) {
        f0.p(e10, "call");
        this.D("requestBodyStart");
    }

    public void s(e object, IOException iOException) {
        f0.p(object, "call");
        f0.p(iOException, "ioe");
        object = new StringBuilder();
        ((StringBuilder)object).append("requestFailed: ");
        ((StringBuilder)object).append(iOException);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void t(e e10, a0 a02) {
        f0.p(e10, "call");
        f0.p(a02, "request");
        this.D("requestHeadersEnd");
    }

    public void u(e e10) {
        f0.p(e10, "call");
        this.D("requestHeadersStart");
    }

    public void v(e object, long l10) {
        f0.p(object, "call");
        object = new StringBuilder();
        ((StringBuilder)object).append("responseBodyEnd: byteCount=");
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void w(e e10) {
        f0.p(e10, "call");
        this.D("responseBodyStart");
    }

    public void x(e object, IOException iOException) {
        f0.p(object, "call");
        f0.p(iOException, "ioe");
        object = new StringBuilder();
        ((StringBuilder)object).append("responseFailed: ");
        ((StringBuilder)object).append(iOException);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void y(e object, c0 c02) {
        f0.p(object, "call");
        f0.p(c02, "response");
        object = new StringBuilder();
        ((StringBuilder)object).append("responseHeadersEnd: ");
        ((StringBuilder)object).append(c02);
        object = ((StringBuilder)object).toString();
        this.D((String)object);
    }

    public void z(e e10) {
        f0.p(e10, "call");
        this.D("responseHeadersStart");
    }
}

