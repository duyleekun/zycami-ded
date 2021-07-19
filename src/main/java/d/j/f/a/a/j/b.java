/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.apache.http.conn.ssl.SSLSocketFactory
 */
package d.j.f.a.a.j;

import android.content.Context;
import d.j.f.a.a.j.d;
import d.j.f.a.a.j.f;
import d.j.f.a.a.j.o.c;
import d.j.f.a.a.j.o.e;
import d.j.f.a.a.j.o.i;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class b
extends org.apache.http.conn.ssl.SSLSocketFactory {
    private static final String i = b.class.getSimpleName();
    private static volatile b j = null;
    private SSLContext a;
    private SSLSocket b;
    private Context c;
    private String[] d;
    private X509TrustManager e;
    private String[] f;
    private String[] g;
    private String[] h;

    private b(KeyStore keyStore) {
        super(keyStore);
        this.b = null;
    }

    private b(KeyStore keyStore, Context object) {
        super(keyStore);
        keyStore = null;
        this.b = null;
        if (object == null) {
            d.j.f.a.a.j.o.i.d(i, "SecureSSLSocketFactory: context is null");
            return;
        }
        this.n((Context)object);
        SSLContext sSLContext = d.j.f.a.a.j.e.i();
        this.p(sSLContext);
        object = d.j.f.a.a.j.d.a(object);
        this.e = object;
        sSLContext = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{object};
        sSLContext.init(null, trustManagerArray, null);
    }

    public b(KeyStore keyStore, X509TrustManager x509TrustManager) {
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
            d.j.f.a.a.j.o.i.e(i, "set protocols");
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
            d.j.f.a.a.j.o.i.e(i, "set white cipher or black cipher");
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
            object = i;
            object2 = "set default protocols";
            d.j.f.a.a.j.o.i.e((String)object, (String)object2);
            object = socket;
            object = (SSLSocket)socket;
            d.j.f.a.a.j.e.g((SSLSocket)object);
        }
        if (!bl3) {
            object = i;
            string2 = "set default cipher suites";
            d.j.f.a.a.j.o.i.e((String)object, string2);
            socket = (SSLSocket)socket;
            d.j.f.a.a.j.e.f((SSLSocket)socket);
        }
    }

    public static void b(X509TrustManager object) {
        Object object2;
        String string2 = i;
        String string3 = "sasfc update socket factory trust manager";
        d.j.f.a.a.j.o.i.e(string2, string3);
        long l10 = System.currentTimeMillis();
        try {
            object2 = new b(null, (X509TrustManager)object);
            j = object2;
        }
        catch (KeyStoreException keyStoreException) {
            object = i;
            object2 = "KeyStoreException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object = i;
            object2 = "UnrecoverableKeyException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        catch (KeyManagementException keyManagementException) {
            object = i;
            object2 = "KeyManagementException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            object = i;
            object2 = "NoSuchAlgorithmException";
            d.j.f.a.a.j.o.i.d((String)object, (String)object2);
        }
        object = i;
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("sasf system ca update: cost : ");
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
    public static b f(KeyStore keyStore, Context context) {
        d.j.f.a.a.j.o.e.b(context);
        Object object = j;
        if (object != null) return j;
        object = f.class;
        synchronized (object) {
            b b10 = j;
            if (b10 != null) return j;
            j = b10 = new b(keyStore, context);
            return j;
        }
    }

    public String[] c() {
        return this.f;
    }

    public Socket createSocket() {
        Object object = i;
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
        Object object = i;
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

