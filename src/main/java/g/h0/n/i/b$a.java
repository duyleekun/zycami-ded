/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.http.X509TrustManagerExtensions
 */
package g.h0.n.i;

import android.net.http.X509TrustManagerExtensions;
import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.i.b;
import javax.net.ssl.X509TrustManager;

public final class b$a {
    private b$a() {
    }

    public /* synthetic */ b$a(u u10) {
        this();
    }

    public final b a(X509TrustManager x509TrustManager) {
        X509TrustManagerExtensions x509TrustManagerExtensions;
        f0.p(x509TrustManager, "trustManager");
        b b10 = null;
        try {
            x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            x509TrustManagerExtensions = null;
        }
        if (x509TrustManagerExtensions != null) {
            b10 = new b(x509TrustManager, x509TrustManagerExtensions);
        }
        return b10;
    }
}

