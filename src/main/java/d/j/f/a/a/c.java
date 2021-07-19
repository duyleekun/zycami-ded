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
package d.j.f.a.a;

import android.content.Context;
import d.j.f.a.a.a;
import d.j.f.a.a.e;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class c
extends SSLSocketFactory {
    public static final X509HostnameVerifier c;
    public static final X509HostnameVerifier d;
    private static volatile c e;
    private SSLContext a;
    private Context b;

    static {
        BrowserCompatHostnameVerifier browserCompatHostnameVerifier = new BrowserCompatHostnameVerifier();
        c = browserCompatHostnameVerifier;
        browserCompatHostnameVerifier = new StrictHostnameVerifier();
        d = browserCompatHostnameVerifier;
        e = null;
    }

    private c(KeyStore keyStore) {
        super(keyStore);
    }

    private c(KeyStore object, Context object2) {
        super((KeyStore)object);
        this.b = object2;
        this.a = object = d.j.f.a.a.j.e.i();
        object2 = this.b;
        object = new e((Context)object2);
        object2 = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{object};
        ((SSLContext)object2).init(null, trustManagerArray, null);
    }

    public c(KeyStore object, InputStream object2, String trustManagerArray) {
        super((KeyStore)object);
        this.a = object = d.j.f.a.a.j.e.i();
        object = new a((InputStream)object2, (String)trustManagerArray);
        object2 = this.a;
        trustManagerArray = new X509TrustManager[]{object};
        ((SSLContext)object2).init(null, trustManagerArray, null);
    }

    private void a(Socket socket) {
        socket = (SSLSocket)socket;
        d.j.f.a.a.j.e.g((SSLSocket)socket);
        d.j.f.a.a.j.e.f((SSLSocket)socket);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c b(KeyStore keyStore, Context context) {
        Object object = e;
        if (object != null) return e;
        object = c.class;
        synchronized (object) {
            c c10 = e;
            if (c10 != null) return e;
            e = c10 = new c(keyStore, context);
            return e;
        }
    }

    public Socket createSocket() {
        Socket socket = this.a.getSocketFactory().createSocket();
        this.a(socket);
        return socket;
    }

    public Socket createSocket(Socket socket, String string2, int n10, boolean bl2) {
        socket = this.a.getSocketFactory().createSocket(socket, string2, n10, bl2);
        this.a(socket);
        return socket;
    }
}

