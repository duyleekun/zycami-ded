/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.apache.http.conn.ssl.BrowserCompatHostnameVerifier
 *  org.apache.http.conn.ssl.StrictHostnameVerifier
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 */
package d.j.f.a.a;

import android.content.Context;
import d.j.f.a.a.a;
import d.j.f.a.a.j.e;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.conn.ssl.BrowserCompatHostnameVerifier;
import org.apache.http.conn.ssl.StrictHostnameVerifier;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class d
extends SSLSocketFactory {
    public static final X509HostnameVerifier c;
    public static final X509HostnameVerifier d;
    private static volatile d e;
    private SSLContext a = null;
    private Context b;

    static {
        BrowserCompatHostnameVerifier browserCompatHostnameVerifier = new BrowserCompatHostnameVerifier();
        c = browserCompatHostnameVerifier;
        browserCompatHostnameVerifier = new StrictHostnameVerifier();
        d = browserCompatHostnameVerifier;
        e = null;
    }

    private d(Context object) {
        this.b = object;
        object = d.j.f.a.a.j.e.i();
        this.a = object;
        Object object2 = this.b;
        super((Context)object2);
        object2 = this.a;
        TrustManager[] trustManagerArray = new X509TrustManager[]{object};
        ((SSLContext)object2).init(null, trustManagerArray, null);
    }

    public d(InputStream object, String trustManagerArray) {
        Object object2 = d.j.f.a.a.j.e.i();
        this.a = object2;
        object2 = new a((InputStream)object, (String)trustManagerArray);
        object = this.a;
        trustManagerArray = new X509TrustManager[]{object2};
        ((SSLContext)object).init(null, trustManagerArray, null);
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
    public static d b(Context context) {
        Object object = e;
        if (object != null) return e;
        object = d.class;
        synchronized (object) {
            d d10 = e;
            if (d10 != null) return e;
            e = d10 = new d(context);
            return e;
        }
    }

    public Socket createSocket(String object, int n10) {
        SSLSocketFactory sSLSocketFactory = this.a.getSocketFactory();
        object = sSLSocketFactory.createSocket((String)object, n10);
        n10 = object instanceof SSLSocket;
        if (n10 != 0) {
            this.a((Socket)object);
        }
        return (Socket)object;
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

    public Socket createSocket(Socket socket, String string2, int n10, boolean bl2) {
        SSLSocketFactory sSLSocketFactory = this.a.getSocketFactory();
        socket = sSLSocketFactory.createSocket(socket, string2, n10, bl2);
        boolean bl3 = socket instanceof SSLSocket;
        if (bl3) {
            this.a(socket);
        }
        return socket;
    }

    public String[] getDefaultCipherSuites() {
        return new String[0];
    }

    public String[] getSupportedCipherSuites() {
        return new String[0];
    }
}

