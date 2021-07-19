/*
 * Decompiled with CFR 0.151.
 */
package g.h0.p;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.h;
import g.h0.p.a;
import g.h0.p.b;
import g.h0.p.c;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import javax.net.ssl.X509TrustManager;

public final class c$a {
    private c$a() {
    }

    public /* synthetic */ c$a(u u10) {
        this();
    }

    public final c a(X509TrustManager x509TrustManager) {
        f0.p(x509TrustManager, "trustManager");
        return h.e.g().d(x509TrustManager);
    }

    public final c b(X509Certificate ... x509CertificateArray) {
        f0.p(x509CertificateArray, "caCerts");
        int n10 = x509CertificateArray.length;
        x509CertificateArray = Arrays.copyOf(x509CertificateArray, n10);
        b b10 = new b(x509CertificateArray);
        a a10 = new a(b10);
        return a10;
    }
}

