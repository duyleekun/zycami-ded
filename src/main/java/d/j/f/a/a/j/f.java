/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.apache.http.conn.ssl.BrowserCompatHostnameVerifier
 *  org.apache.http.conn.ssl.SSLSocketFactory
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
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class f
extends org.apache.http.conn.ssl.SSLSocketFactory {
    public static final X509HostnameVerifier i;
    public static final X509HostnameVerifier j;
    private static final String k;
    private static volatile f l;
    private SSLContext a;
    private SSLSocket b;
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
        k = f.class.getSimpleName();
        l = null;
    }

    private f(KeyStore keyStore) {
        super(keyStore);
        this.b = null;
    }

    private f(KeyStore keyStore, Context object) {
        super(keyStore);
        keyStore = null;
        this.b = null;
        if (object == null) {
            d.j.f.a.a.j.o.i.d(k, "SecureSSLSocketFactory: context is null");
            return;
        }
        this.n((Context)object);
        SSLContext sSLContext = d.j.f.a.a.j.e.i();
        this.p(sSLContext);
        object = d.j.f.a.a.j.h.a(object);
        this.e = object;
        sSLContext = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{object};
        sSLContext.init(null, trustManagerArray, null);
    }

    public f(KeyStore keyStore, InputStream object, String trustManagerArray) {
        super(keyStore);
        this.b = null;
        Object object2 = d.j.f.a.a.j.e.i();
        this.a = object2;
        object2 = new a((InputStream)object, (String)trustManagerArray);
        this.s((X509TrustManager)object2);
        object = this.a;
        trustManagerArray = new X509TrustManager[]{object2};
        ((SSLContext)object).init(null, trustManagerArray, null);
    }

    public f(KeyStore keyStore, X509TrustManager x509TrustManager) {
        super(keyStore);
        SSLContext sSLContext;
        this.b = null;
        this.a = sSLContext = d.j.f.a.a.j.e.i();
        this.s(x509TrustManager);
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
        Object object2 = k;
        String string2 = "sasf update socket factory trust manager";
        d.j.f.a.a.j.o.i.e(object2, string2);
        string2 = null;
        try {
            object2 = new f(null, (X509TrustManager)object);
            l = object2;
        }
        catch (IOException iOException) {
            object = k;
            object2 = "IOException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
        catch (CertificateException certificateException) {
            object = k;
            object2 = "CertificateException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
        catch (KeyStoreException keyStoreException) {
            object = k;
            object2 = "KeyStoreException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object = k;
            object2 = "UnrecoverableKeyException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
        catch (KeyManagementException keyManagementException) {
            object = k;
            object2 = "KeyManagementException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = k;
            object2 = "NoSuchAlgorithmException";
            d.j.f.a.a.j.o.i.d((String)object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static f f(KeyStore keyStore, Context context) {
        d.j.f.a.a.j.o.e.b(context);
        Object object = l;
        if (object != null) return l;
        object = f.class;
        synchronized (object) {
            f f10 = l;
            if (f10 != null) return l;
            l = f10 = new f(keyStore, context);
            return l;
        }
    }

    public String[] c() {
        return this.f;
    }

    public Socket createSocket() {
        Object object = k;
        String[] stringArray = "createSocket: ";
        d.j.f.a.a.j.o.i.e((String)object, (String)stringArray);
        object = this.a.getSocketFactory().createSocket();
        boolean bl2 = object instanceof SSLSocket;
        if (bl2) {
            this.a((Socket)object);
            stringArray = object;
            stringArray = (SSLSocket)object;
            this.b = stringArray;
            stringArray = (String[])stringArray.getEnabledCipherSuites().clone();
            this.d = stringArray;
        }
        return (Socket)object;
    }

    public Socket createSocket(Socket socket, String stringArray, int n10, boolean bl2) {
        Object object = k;
        String string2 = "createSocket: socket host port autoClose";
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

    public SSLContext h() {
        return this.a;
    }

    public SSLSocket i() {
        return this.b;
    }

    public String[] j() {
        String[] stringArray = this.d;
        if (stringArray != null) {
            return stringArray;
        }
        return new String[0];
    }

    public String[] k() {
        return this.g;
    }

    public X509TrustManager l() {
        return this.e;
    }

    public void m(String[] stringArray) {
        this.f = stringArray;
    }

    public void n(Context context) {
        this.c = context = context.getApplicationContext();
    }

    public void o(String[] stringArray) {
        this.h = stringArray;
    }

    public void p(SSLContext sSLContext) {
        this.a = sSLContext;
    }

    public void q(SSLSocket sSLSocket) {
        this.b = sSLSocket;
    }

    public void r(String[] stringArray) {
        this.g = stringArray;
    }

    public void s(X509TrustManager x509TrustManager) {
        this.e = x509TrustManager;
    }
}

