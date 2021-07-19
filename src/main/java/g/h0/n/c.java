/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.bouncycastle.jsse.BCSSLParameters
 *  org.bouncycastle.jsse.BCSSLSocket
 *  org.bouncycastle.jsse.provider.BouncyCastleJsseProvider
 */
package g.h0.n;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.c$a;
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
import org.bouncycastle.jsse.BCSSLParameters;
import org.bouncycastle.jsse.BCSSLSocket;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

public final class c
extends h {
    private static final boolean g;
    public static final c$a h;
    private final Provider f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object = new c$a(null);
        h = object;
        boolean bl2 = false;
        String string2 = "org.bouncycastle.jsse.provider.BouncyCastleJsseProvider";
        try {
            object = object.getClass();
            object = ((Class)object).getClassLoader();
            Class.forName(string2, false, (ClassLoader)object);
            bl2 = true;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        g = bl2;
    }

    private c() {
        Object object = new BouncyCastleJsseProvider();
        object = (Provider)object;
        this.f = object;
    }

    public /* synthetic */ c(u u10) {
        this();
    }

    public static final /* synthetic */ boolean t() {
        return g;
    }

    public void f(SSLSocket sSLSocket, String string2, List stringArray) {
        f0.p(sSLSocket, "sslSocket");
        Object object = "protocols";
        f0.p(stringArray, (String)object);
        boolean bl2 = sSLSocket instanceof BCSSLSocket;
        if (bl2) {
            sSLSocket = (BCSSLSocket)sSLSocket;
            string2 = sSLSocket.getParameters();
            stringArray = g.h0.n.h.e.b((List)stringArray);
            f0.o(string2, "sslParameters");
            bl2 = false;
            object = new String[]{};
            stringArray = stringArray.toArray((T[])object);
            object = "null cannot be cast to non-null type kotlin.Array<T>";
            Objects.requireNonNull(stringArray, (String)object);
            string2.setApplicationProtocols(stringArray);
            sSLSocket.setParameters((BCSSLParameters)string2);
        } else {
            super.f(sSLSocket, string2, (List)stringArray);
        }
    }

    public String j(SSLSocket object) {
        String string2 = "sslSocket";
        f0.p(object, string2);
        int n10 = object instanceof BCSSLSocket;
        if (n10 != 0) {
            if ((object = ((BCSSLSocket)object).getApplicationProtocol()) == null || (n10 = ((String)object).hashCode()) == 0 && (n10 = (int)(((String)object).equals(string2 = "") ? 1 : 0)) != 0) {
                object = null;
            }
        } else {
            object = super.j((SSLSocket)object);
        }
        return object;
    }

    public SSLContext p() {
        Object object = this.f;
        object = SSLContext.getInstance("TLS", (Provider)object);
        f0.o(object, "SSLContext.getInstance(\"TLS\", provider)");
        return object;
    }

    public X509TrustManager r() {
        Object object = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
        ((TrustManagerFactory)object).init((KeyStore)null);
        Object object2 = "factory";
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
            return (X509TrustManager)object;
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

    public X509TrustManager s(SSLSocketFactory object) {
        f0.p(object, "sslSocketFactory");
        object = new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with BouncyCastle");
        throw object;
    }
}

