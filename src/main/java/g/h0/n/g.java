/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.openjsse.javax.net.ssl.SSLParameters
 *  org.openjsse.javax.net.ssl.SSLSocket
 *  org.openjsse.net.ssl.OpenJSSE
 */
package g.h0.n;

import f.h2.t.f0;
import f.h2.t.u;
import g.h0.n.g$a;
import g.h0.n.h;
import java.security.KeyStore;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.javax.net.ssl.SSLSocket;
import org.openjsse.net.ssl.OpenJSSE;

public final class g
extends h {
    private static final boolean g;
    public static final g$a h;
    private final Provider f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object = new g$a(null);
        h = object;
        boolean bl2 = false;
        String string2 = "org.openjsse.net.ssl.OpenJSSE";
        try {
            object = object.getClass();
            object = ((Class)object).getClassLoader();
            Class.forName(string2, false, (ClassLoader)object);
            bl2 = true;
        }
        catch (ClassNotFoundException classNotFoundException) {}
        g = bl2;
    }

    private g() {
        Object object = new OpenJSSE();
        object = (Provider)object;
        this.f = object;
    }

    public /* synthetic */ g(u u10) {
        this();
    }

    public static final /* synthetic */ boolean t() {
        return g;
    }

    public void f(javax.net.ssl.SSLSocket sSLSocket, String object, List stringArray) {
        f0.p(sSLSocket, "sslSocket");
        Object object2 = "protocols";
        f0.p(stringArray, (String)object2);
        boolean bl2 = sSLSocket instanceof SSLSocket;
        if (bl2) {
            object = (sSLSocket = (SSLSocket)sSLSocket).getSSLParameters();
            bl2 = object instanceof org.openjsse.javax.net.ssl.SSLParameters;
            if (bl2) {
                stringArray = g.h0.n.h.e.b((List)stringArray);
                object2 = object;
                object2 = (org.openjsse.javax.net.ssl.SSLParameters)object;
                Object object3 = new String[]{};
                stringArray = stringArray.toArray((T[])object3);
                object3 = "null cannot be cast to non-null type kotlin.Array<T>";
                Objects.requireNonNull(stringArray, (String)object3);
                object2.setApplicationProtocols(stringArray);
                sSLSocket.setSSLParameters((SSLParameters)object);
            }
        } else {
            super.f(sSLSocket, (String)object, (List)stringArray);
        }
    }

    public String j(javax.net.ssl.SSLSocket object) {
        String string2 = "sslSocket";
        f0.p(object, string2);
        int n10 = object instanceof SSLSocket;
        if (n10 != 0) {
            if ((object = ((SSLSocket)object).getApplicationProtocol()) == null || (n10 = ((String)object).hashCode()) == 0 && (n10 = (int)(((String)object).equals(string2 = "") ? 1 : 0)) != 0) {
                object = null;
            }
        } else {
            object = super.j((javax.net.ssl.SSLSocket)object);
        }
        return object;
    }

    public SSLContext p() {
        Object object = this.f;
        object = SSLContext.getInstance("TLSv1.3", (Provider)object);
        f0.o(object, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return object;
    }

    public X509TrustManager r() {
        Object object = TrustManagerFactory.getDefaultAlgorithm();
        Object object2 = this.f;
        object = TrustManagerFactory.getInstance((String)object, (Provider)object2);
        ((TrustManagerFactory)object).init((KeyStore)null);
        object2 = "factory";
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
        object = new UnsupportedOperationException("clientBuilder.sslSocketFactory(SSLSocketFactory) not supported with OpenJSSE");
        throw object;
    }
}

