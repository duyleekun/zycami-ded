/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 */
package g.h0.n.i;

import android.net.http.X509TrustManagerExtensions;
import f.h2.t.f0;
import g.h0.n.i.b$a;
import g.h0.p.c;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public final class b
extends c {
    public static final b$a d;
    private final X509TrustManager b;
    private final X509TrustManagerExtensions c;

    static {
        b$a b$a;
        d = b$a = new b$a(null);
    }

    public b(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        f0.p(x509TrustManager, "trustManager");
        f0.p(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.b = x509TrustManager;
        this.c = x509TrustManagerExtensions;
    }

    public List a(List object, String object2) {
        String string2;
        f0.p(object, "chain");
        f0.p(object2, "hostname");
        Object object3 = new X509Certificate[]{};
        object = object.toArray((T[])object3);
        object3 = "null cannot be cast to non-null type kotlin.Array<T>";
        Objects.requireNonNull(object, (String)object3);
        try {
            object3 = this.c;
            string2 = "RSA";
        }
        catch (CertificateException certificateException) {
            object3 = certificateException.getMessage();
            object2 = new SSLPeerUnverifiedException((String)object3);
            ((Throwable)object2).initCause(certificateException);
            throw object2;
        }
        object = object3.checkServerTrusted(object, string2, (String)object2);
        object2 = "x509TrustManagerExtensio\u2026ficates, \"RSA\", hostname)";
        f0.o(object, (String)object2);
        return object;
    }

    public boolean equals(Object object) {
        boolean bl2;
        X509TrustManager x509TrustManager;
        boolean bl3 = object instanceof b;
        if (bl3 && (object = ((b)object).b) == (x509TrustManager = this.b)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int hashCode() {
        return System.identityHashCode(this.b);
    }
}

