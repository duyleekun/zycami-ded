/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.conscrypt.Conscrypt
 *  org.conscrypt.ConscryptHostnameVerifier
 */
package g.h0.n;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.d$a;
import g.h0.n.d$b;
import g.h0.n.h;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

public final class d
extends h {
    private static final boolean g;
    public static final d$a h;
    private final Provider f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        d$a d$a;
        h = d$a = new d$a(null);
        int n10 = 0;
        String string2 = "org.conscrypt.Conscrypt$Version";
        try {
            boolean bl2;
            Object object = d$a.getClass();
            object = ((Class)object).getClassLoader();
            Class.forName(string2, false, (ClassLoader)object);
            int n11 = Conscrypt.isAvailable();
            int n12 = 1;
            if (n11 != 0 && (bl2 = d$a.a(n11 = 2, n12, 0))) {
                n10 = n12;
            }
        }
        catch (ClassNotFoundException | NoClassDefFoundError throwable) {}
        g = n10;
    }

    private d() {
        Provider provider = Conscrypt.newProvider();
        f0.o(provider, "Conscrypt.newProvider()");
        this.f = provider;
    }

    public /* synthetic */ d(u u10) {
        this();
    }

    public static final /* synthetic */ boolean t() {
        return g;
    }

    public void f(SSLSocket sSLSocket, String stringArray, List object) {
        f0.p(sSLSocket, "sslSocket");
        String string2 = "protocols";
        f0.p(object, string2);
        boolean bl2 = Conscrypt.isConscrypt((SSLSocket)sSLSocket);
        if (bl2) {
            boolean bl3 = true;
            Conscrypt.setUseSessionTickets((SSLSocket)sSLSocket, (boolean)bl3);
            stringArray = g.h0.n.h.e.b((List)object);
            object = new String[]{};
            stringArray = stringArray.toArray((T[])object);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(stringArray, (String)object);
            Conscrypt.setApplicationProtocols((SSLSocket)sSLSocket, (String[])stringArray);
        } else {
            super.f(sSLSocket, (String)stringArray, (List)object);
        }
    }

    public String j(SSLSocket object) {
        String string2 = "sslSocket";
        f0.p(object, string2);
        boolean bl2 = Conscrypt.isConscrypt((SSLSocket)object);
        object = bl2 ? Conscrypt.getApplicationProtocol((SSLSocket)object) : super.j((SSLSocket)object);
        return object;
    }

    public SSLContext p() {
        Object object = this.f;
        object = SSLContext.getInstance("TLS", (Provider)object);
        f0.o(object, "SSLContext.getInstance(\"TLS\", provider)");
        return object;
    }

    public SSLSocketFactory q(X509TrustManager object) {
        f0.p(object, "trustManager");
        SSLContext sSLContext = this.p();
        TrustManager[] trustManagerArray = new TrustManager[]{object};
        sSLContext.init(null, trustManagerArray, null);
        object = sSLContext.getSocketFactory();
        f0.o(object, "newSSLContext().apply {\n\u2026null)\n    }.socketFactory");
        return object;
    }

    public X509TrustManager r() {
        Object object = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        ((TrustManagerFactory)object).init((KeyStore)null);
        Object object2 = "TrustManagerFactory.getI\u2026(null as KeyStore?)\n    }";
        f0.o(object, (String)object2);
        object = ((TrustManagerFactory)object).getTrustManagers();
        f0.m(object);
        int n10 = ((TrustManager[])object).length;
        int n11 = 1;
        if (n10 != n11 || (n10 = (object2 = object[0]) instanceof X509TrustManager) == 0) {
            n11 = 0;
        }
        if (n11 != 0) {
            object = object[0];
            Objects.requireNonNull(object, "null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            object = (X509TrustManager)object;
            object2 = d$b.a;
            Conscrypt.setHostnameVerifier((TrustManager)object, (ConscryptHostnameVerifier)object2);
            return object;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Unexpected default trust managers: ");
        object = Arrays.toString((Object[])object);
        f0.o(object, "java.util.Arrays.toString(this)");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public X509TrustManager s(SSLSocketFactory sSLSocketFactory) {
        f0.p(sSLSocketFactory, "sslSocketFactory");
        return null;
    }
}

