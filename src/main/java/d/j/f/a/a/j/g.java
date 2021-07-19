/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.apache.http.conn.ssl.BrowserCompatHostnameVerifier
 *  org.apache.http.conn.ssl.StrictHostnameVerifier
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 */
package d.j.f.a.a.j;

import android.content.Context;
import d.j.f.a.a.j.a;
import d.j.f.a.a.j.h;
import d.j.f.a.a.j.o.c;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.i;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class g
extends SSLSocketFactory {
    public static final X509HostnameVerifier i;
    public static final X509HostnameVerifier j;
    private static final String k;
    private static volatile g l;
    private SSLContext a = null;
    private SSLSocket b = null;
    private Context c;
    private String[] d;
    private X509TrustManager e;
    private String[] f;
    private String[] g;
    private String[] h;

    static {
        BrowserCompatHostnameVerifier browserCompatHostnameVerifier = new BrowserCompatHostnameVerifier();
        i = browserCompatHostnameVerifier;
        browserCompatHostnameVerifier = new StrictHostnameVerifier();
        j = browserCompatHostnameVerifier;
        k = g.class.getSimpleName();
        l = null;
    }

    private g(Context object) {
        if (object == null) {
            d.j.f.a.a.j.o.i.d(k, "SecureSSLSocketFactory: context is null");
            return;
        }
        this.m((Context)object);
        SSLContext sSLContext = d.j.f.a.a.j.e.i();
        this.o(sSLContext);
        object = d.j.f.a.a.j.h.a(object);
        this.e = object;
        sSLContext = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{object};
        sSLContext.init(null, trustManagerArray, null);
    }

    public g(InputStream object, String trustManagerArray) {
        Object object2 = d.j.f.a.a.j.e.i();
        this.a = object2;
        object2 = new a((InputStream)object, (String)trustManagerArray);
        this.q((X509TrustManager)object2);
        object = this.a;
        trustManagerArray = new X509TrustManager[]{object2};
        ((SSLContext)object).init(null, trustManagerArray, null);
    }

    public g(X509TrustManager x509TrustManager) {
        SSLContext sSLContext;
        this.a = sSLContext = d.j.f.a.a.j.e.i();
        this.q(x509TrustManager);
        sSLContext = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{x509TrustManager};
        sSLContext.init(null, trustManagerArray, null);
    }

    private void a(Socket socket) {
        String string2;
        String[] stringArray;
        Object object = this.h;
        boolean bl2 = d.j.f.a.a.j.o.c.a(object);
        boolean bl3 = true;
        Object object2 = null;
        if (!bl2) {
            d.j.f.a.a.j.o.i.e(k, "set protocols");
            object = socket;
            object = (SSLSocket)socket;
            stringArray = this.h;
            d.j.f.a.a.j.e.h((SSLSocket)object, stringArray);
            bl2 = bl3;
        } else {
            bl2 = false;
            object = null;
        }
        stringArray = this.g;
        boolean bl4 = d.j.f.a.a.j.o.c.a(stringArray);
        if (bl4 && (bl4 = d.j.f.a.a.j.o.c.a(stringArray = this.f))) {
            bl3 = false;
            string2 = null;
        } else {
            d.j.f.a.a.j.o.i.e(k, "set white cipher or black cipher");
            object2 = socket;
            object2 = (SSLSocket)socket;
            d.j.f.a.a.j.e.g((SSLSocket)object2);
            stringArray = this.g;
            bl4 = d.j.f.a.a.j.o.c.a(stringArray);
            if (!bl4) {
                stringArray = this.g;
                d.j.f.a.a.j.e.l((SSLSocket)object2, stringArray);
            } else {
                stringArray = this.f;
                d.j.f.a.a.j.e.e((SSLSocket)object2, stringArray);
            }
        }
        if (!bl2) {
            object = k;
            object2 = "set default protocols";
            d.j.f.a.a.j.o.i.e((String)object, (String)object2);
            object = socket;
            object = (SSLSocket)socket;
            d.j.f.a.a.j.e.g((SSLSocket)object);
        }
        if (!bl3) {
            object = k;
            string2 = "set default cipher suites";
            d.j.f.a.a.j.o.i.e((String)object, string2);
            socket = (SSLSocket)socket;
            d.j.f.a.a.j.e.f((SSLSocket)socket);
        }
    }

    public static void b(X509TrustManager object) {
        Object object2;
        String string2 = k;
        String string3 = "ssf update socket factory trust manager";
        d.j.f.a.a.j.o.i.e(string2, string3);
        long l10 = System.currentTimeMillis();
        try {
            l = object2 = new g((X509TrustManager)object);
        }
        catch (KeyManagementException keyManagementException) {
            object = k;
            object2 = "KeyManagementException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = k;
            object2 = "NoSuchAlgorithmException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        object = k;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("update: cost : ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append(" ms");
        string2 = ((StringBuilder)object2).toString();
        d.j.f.a.a.j.o.i.b((String)object, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static g f(Context object) {
        long l10 = System.currentTimeMillis();
        d.j.f.a.a.j.o.e.b(object);
        Object object2 = l;
        if (object2 == null) {
            object2 = g.class;
            synchronized (object2) {
                g g10 = l;
                if (g10 == null) {
                    l = g10 = new g((Context)object);
                }
            }
        }
        if ((object2 = d.j.f.a.a.j.g.l.c) == null && object != null) {
            object2 = l;
            ((g)object2).m((Context)object);
        }
        object = k;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("getInstance: cost : ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        ((StringBuilder)object2).append(" ms");
        String string2 = ((StringBuilder)object2).toString();
        d.j.f.a.a.j.o.i.b((String)object, string2);
        return l;
    }

    public String[] c() {
        return this.f;
    }

    public Socket createSocket(String stringArray, int n10) {
        Object object = k;
        String string2 = "createSocket: host , port";
        d.j.f.a.a.j.o.i.e((String)object, string2);
        object = this.a.getSocketFactory();
        stringArray = ((SocketFactory)object).createSocket((String)stringArray, n10);
        n10 = stringArray instanceof SSLSocket;
        if (n10 != 0) {
            this.a((Socket)stringArray);
            String[] stringArray2 = stringArray;
            stringArray2 = (SSLSocket)stringArray;
            this.b = stringArray2;
            stringArray2 = (String[])stringArray2.getEnabledCipherSuites().clone();
            this.d = stringArray2;
        }
        return (Socket)stringArray;
    }

    public Socket createSocket(String string2, int n10, InetAddress inetAddress, int n11) {
        return this.createSocket(string2, n10);
    }

    public Socket createSocket(InetAddress object, int n10) {
        object = ((InetAddress)object).getHostAddress();
        return this.createSocket((String)object, n10);
    }

    public Socket createSocket(InetAddress object, int n10, InetAddress inetAddress, int n11) {
        object = ((InetAddress)object).getHostAddress();
        return this.createSocket((String)object, n10);
    }

    public Socket createSocket(Socket socket, String stringArray, int n10, boolean bl2) {
        Object object = k;
        String string2 = "createSocket s host port autoClose";
        d.j.f.a.a.j.o.i.e((String)object, string2);
        object = this.a.getSocketFactory();
        socket = ((SSLSocketFactory)object).createSocket(socket, (String)stringArray, n10, bl2);
        boolean bl3 = socket instanceof SSLSocket;
        if (bl3) {
            this.a(socket);
            stringArray = socket;
            stringArray = (SSLSocket)socket;
            this.b = stringArray;
            stringArray = (String[])stringArray.getEnabledCipherSuites().clone();
            this.d = stringArray;
        }
        return socket;
    }

    public X509Certificate[] d() {
        X509TrustManager x509TrustManager = this.e;
        boolean bl2 = x509TrustManager instanceof d.j.f.a.a.j.i;
        if (bl2) {
            return ((d.j.f.a.a.j.i)x509TrustManager).e();
        }
        return new X509Certificate[0];
    }

    public Context e() {
        return this.c;
    }

    public String[] g() {
        return this.h;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        String[] stringArray = this.d;
        if (stringArray != null) {
            return stringArray;
        }
        return new String[0];
    }

    public SSLContext h() {
        return this.a;
    }

    public SSLSocket i() {
        return this.b;
    }

    public String[] j() {
        return this.g;
    }

    public X509TrustManager k() {
        return this.e;
    }

    public void l(String[] stringArray) {
        this.f = stringArray;
    }

    public void m(Context context) {
        this.c = context = context.getApplicationContext();
    }

    public void n(String[] stringArray) {
        this.h = stringArray;
    }

    public void o(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void p(String[] stringArray) {
        this.g = stringArray;
    }

    public void q(X509TrustManager x509TrustManager) {
        this.e = x509TrustManager;
    }
}

