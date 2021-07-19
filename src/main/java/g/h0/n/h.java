/*
 * Decompiled with CFR 0.151.
 */
package g.h0.n;

import f.h2.t.f0;
import g.h0.d;
import g.h0.n.h$a;
import g.h0.p.a;
import g.h0.p.b;
import g.h0.p.c;
import g.h0.p.e;
import g.z;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class h {
    private static volatile h a;
    public static final int b = 4;
    public static final int c = 5;
    private static final Logger d;
    public static final h$a e;

    static {
        h$a h$a;
        e = h$a = new h$a(null);
        a = h$a.a(h$a);
        d = Logger.getLogger(z.class.getName());
    }

    public static final /* synthetic */ h a() {
        return a;
    }

    public static final /* synthetic */ void b(h h10) {
        a = h10;
    }

    public static final h h() {
        return e.g();
    }

    public static /* synthetic */ void n(h object, String string2, int n10, Throwable throwable, int n11, Object object2) {
        if (object2 == null) {
            int n12 = n11 & 2;
            int n13 = 4;
            if (n12 != 0) {
                n10 = n13;
            }
            if ((n11 &= n13) != 0) {
                throwable = null;
            }
            ((h)object).m(string2, n10, throwable);
            return;
        }
        object = new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        throw object;
    }

    public void c(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
    }

    public c d(X509TrustManager object) {
        f0.p(object, "trustManager");
        object = this.e((X509TrustManager)object);
        a a10 = new a((e)object);
        return a10;
    }

    public e e(X509TrustManager x509CertificateArray) {
        f0.p(x509CertificateArray, "trustManager");
        x509CertificateArray = x509CertificateArray.getAcceptedIssuers();
        f0.o(x509CertificateArray, "trustManager.acceptedIssuers");
        int n10 = x509CertificateArray.length;
        x509CertificateArray = Arrays.copyOf(x509CertificateArray, n10);
        b b10 = new b(x509CertificateArray);
        return b10;
    }

    public void f(SSLSocket sSLSocket, String string2, List list) {
        f0.p(sSLSocket, "sslSocket");
        f0.p(list, "protocols");
    }

    public void g(Socket socket, InetSocketAddress inetSocketAddress, int n10) {
        f0.p(socket, "socket");
        f0.p(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, n10);
    }

    public final String i() {
        return "OkHttp";
    }

    public String j(SSLSocket sSLSocket) {
        f0.p(sSLSocket, "sslSocket");
        return null;
    }

    public Object k(String string2) {
        f0.p(string2, "closer");
        Object object = d;
        Level level = Level.FINE;
        boolean bl2 = ((Logger)object).isLoggable(level);
        if (bl2) {
            object = new Throwable(string2);
        } else {
            bl2 = false;
            object = null;
        }
        return object;
    }

    public boolean l(String string2) {
        f0.p(string2, "hostname");
        return true;
    }

    public void m(String string2, int n10, Throwable throwable) {
        String string3 = "message";
        f0.p(string2, string3);
        int n11 = 5;
        Level level = n10 == n11 ? Level.WARNING : Level.INFO;
        d.log(level, string2, throwable);
    }

    public void o(String string2, Object object) {
        CharSequence charSequence = "message";
        f0.p(string2, (String)charSequence);
        if (object == null) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);");
            string2 = ((StringBuilder)charSequence).toString();
        }
        object = (Throwable)object;
        this.m(string2, 5, (Throwable)object);
    }

    public SSLContext p() {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        f0.o(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory q(X509TrustManager object) {
        Object object2;
        int n10;
        Object object3 = "trustManager";
        f0.p(object, (String)object3);
        try {
            object3 = this.p();
            n10 = 1;
        }
        catch (GeneralSecurityException generalSecurityException) {
            object2 = new StringBuilder();
            object2.append("No System TLS: ");
            object2.append(generalSecurityException);
            object2 = object2.toString();
            object3 = new AssertionError((String)object2, generalSecurityException);
            throw object3;
        }
        object2 = new TrustManager[n10];
        object2[0] = object;
        object = null;
        ((SSLContext)object3).init(null, (TrustManager[])object2, null);
        object = ((SSLContext)object3).getSocketFactory();
        object3 = "newSSLContext().apply {\n\u2026ll)\n      }.socketFactory";
        f0.o(object, (String)object3);
        return object;
    }

    public X509TrustManager r() {
        Object object = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
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

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public X509TrustManager s(SSLSocketFactory object) {
        String string2;
        f0.p(object, "sslSocketFactory");
        Object object2 = null;
        Class<X509TrustManager> clazz = "sun.security.ssl.SSLContextImpl";
        try {
            clazz = Class.forName((String)((Object)clazz));
            string2 = "sslContextClass";
        }
        catch (ClassNotFoundException classNotFoundException) {
            return object2;
        }
        f0.o(clazz, string2);
        string2 = "context";
        object = g.h0.d.Q(object, clazz, string2);
        if (object == null) return object2;
        clazz = X509TrustManager.class;
        string2 = "trustManager";
        object = g.h0.d.Q(object, clazz, string2);
        return object = (X509TrustManager)object;
    }

    public String toString() {
        String string2 = this.getClass().getSimpleName();
        f0.o(string2, "javaClass.simpleName");
        return string2;
    }
}

