/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.conscrypt.ConscryptHostnameVerifier
 */
package g.h0.n;

import java.security.cert.X509Certificate;
import javax.net.ssl.SSLSession;
import org.conscrypt.ConscryptHostnameVerifier;

public final class d$b
implements ConscryptHostnameVerifier {
    public static final d$b a;

    static {
        d$b d$b;
        a = d$b = new d$b();
    }

    private d$b() {
    }

    public final boolean a(String string2, SSLSession sSLSession) {
        return true;
    }

    public boolean b(X509Certificate[] x509CertificateArray, String string2, SSLSession sSLSession) {
        return true;
    }
}

