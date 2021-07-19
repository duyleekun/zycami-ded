/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.webkit.SslErrorHandler
 *  org.apache.http.client.methods.HttpGet
 *  org.apache.http.client.methods.HttpUriRequest
 *  org.apache.http.conn.ClientConnectionManager
 *  org.apache.http.conn.scheme.PlainSocketFactory
 *  org.apache.http.conn.scheme.Scheme
 *  org.apache.http.conn.scheme.SchemeRegistry
 *  org.apache.http.conn.scheme.SocketFactory
 *  org.apache.http.conn.ssl.SSLSocketFactory
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 *  org.apache.http.impl.client.DefaultHttpClient
 *  org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager
 *  org.apache.http.params.BasicHttpParams
 *  org.apache.http.params.HttpConnectionParams
 *  org.apache.http.params.HttpParams
 */
package d.j.f.a.a.j;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import com.google.firebase.perf.network.FirebasePerfOkHttpClient;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import d.j.f.a.a.j.f;
import d.j.f.a.a.j.g;
import d.j.f.a.a.j.k$a;
import d.j.f.a.a.j.k$b;
import d.j.f.a.a.j.m;
import d.j.f.a.a.j.o.h;
import d.j.f.a.a.j.o.i;
import g.a0;
import g.a0$a;
import g.e;
import g.z;
import g.z$a;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.security.UnrecoverableKeyException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.scheme.SocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class k
extends Thread {
    private static final String i = k.class.getSimpleName();
    private SSLSocketFactory a;
    private HostnameVerifier b;
    private org.apache.http.conn.ssl.SSLSocketFactory c;
    private X509HostnameVerifier d;
    private SslErrorHandler e;
    private String f;
    private k$a g;
    private Context h;

    public k() {
    }

    public k(SslErrorHandler object, String object2, Context object3) {
        this.t((SslErrorHandler)object);
        this.v((String)object2);
        this.r((Context)object3);
        object2 = new m((Context)object3);
        super((X509TrustManager)object2);
        this.u((SSLSocketFactory)object);
        object = d.j.f.a.a.j.g.j;
        this.s((HostnameVerifier)object);
        object2 = null;
        Object object4 = new m((Context)object3);
        super(null, (X509TrustManager)object4);
        try {
            this.p((org.apache.http.conn.ssl.SSLSocketFactory)object);
        }
        catch (UnrecoverableKeyException unrecoverableKeyException) {
            object2 = i;
            super();
            object4 = "WebViewSSLCheckThread: UnrecoverableKeyException : ";
            ((StringBuilder)object3).append((String)object4);
            object = unrecoverableKeyException.getMessage();
            ((StringBuilder)object3).append((String)object);
            object = ((StringBuilder)object3).toString();
            d.j.f.a.a.j.o.i.d((String)object2, (String)object);
        }
        object = d.j.f.a.a.j.f.j;
        this.o((X509HostnameVerifier)object);
    }

    public k(SslErrorHandler sslErrorHandler, String string2, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier) {
        this.t(sslErrorHandler);
        this.v(string2);
        this.u(sSLSocketFactory);
        this.s(hostnameVerifier);
    }

    public k(SslErrorHandler sslErrorHandler, String string2, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier) {
        this.t(sslErrorHandler);
        this.v(string2);
        this.p(sSLSocketFactory);
        this.o(x509HostnameVerifier);
    }

    public k(SslErrorHandler sslErrorHandler, String string2, org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory, X509HostnameVerifier x509HostnameVerifier, k$a k$a, Context context) {
        this.e = sslErrorHandler;
        this.f = string2;
        this.c = sSLSocketFactory;
        this.d = x509HostnameVerifier;
        this.g = k$a;
        this.h = context;
    }

    public static /* synthetic */ String a() {
        return i;
    }

    private void b() {
        String string2 = i;
        d.j.f.a.a.j.o.i.e(string2, "callbackCancel: ");
        Object object = this.g;
        if (object != null) {
            string2 = this.h;
            String string3 = this.f;
            object.b((Context)string2, string3);
            return;
        }
        object = this.e;
        if (object != null) {
            object = "callbackCancel 2: ";
            d.j.f.a.a.j.o.i.e(string2, (String)object);
            string2 = this.e;
            string2.cancel();
        }
    }

    private void c() {
        Object object = i;
        String string2 = "callbackProceed: ";
        d.j.f.a.a.j.o.i.e((String)object, string2);
        object = this.g;
        if (object != null) {
            string2 = this.h;
            String string3 = this.f;
            object.a((Context)string2, string3);
            return;
        }
        object = this.e;
        if (object != null) {
            object.proceed();
        }
    }

    public static void d(SslErrorHandler sslErrorHandler, String string2, Context context) {
        k.e(sslErrorHandler, string2, context, null);
    }

    public static void e(SslErrorHandler sslErrorHandler, String string2, Context object, k$a object2) {
        boolean bl2;
        if (sslErrorHandler != null && !(bl2 = TextUtils.isEmpty((CharSequence)string2)) && object != null) {
            Object object3 = new z$a();
            m m10 = new m((Context)object);
            Object object4 = new g(m10);
            ((g)object4).m((Context)object);
            m10 = new m((Context)object);
            ((z$a)object3).Q0((SSLSocketFactory)object4, m10);
            object4 = d.j.f.a.a.j.g.j;
            ((z$a)object3).Z((HostnameVerifier)object4);
            object4 = new a0$a();
            object4 = ((a0$a)object4).B(string2);
            object4 = ((a0$a)object4).b();
            object3 = ((z$a)object3).f();
            object3 = ((z)object3).a((a0)object4);
            object4 = new k$b((k$a)object2, (Context)object, string2, sslErrorHandler);
            try {
                FirebasePerfOkHttpClient.enqueue((e)object3, (g.f)object4);
            }
            catch (Exception exception) {
                object = i;
                object2 = new StringBuilder();
                object3 = "checkServerCertificateWithOK: exception : ";
                ((StringBuilder)object2).append((String)object3);
                String string3 = exception.getMessage();
                ((StringBuilder)object2).append(string3);
                string3 = ((StringBuilder)object2).toString();
                d.j.f.a.a.j.o.i.d((String)object, string3);
                sslErrorHandler.cancel();
            }
            return;
        }
        d.j.f.a.a.j.o.i.d(i, "checkServerCertificateWithOK: handler or url or context is null");
    }

    public X509HostnameVerifier f() {
        return this.d;
    }

    public org.apache.http.conn.ssl.SSLSocketFactory g() {
        return this.c;
    }

    public k$a h() {
        return this.g;
    }

    public Context i() {
        return this.h;
    }

    public HostnameVerifier j() {
        return this.b;
    }

    public SslErrorHandler k() {
        return this.e;
    }

    public SSLSocketFactory l() {
        return this.a;
    }

    public String m() {
        return this.f;
    }

    public void o(X509HostnameVerifier x509HostnameVerifier) {
        this.d = x509HostnameVerifier;
    }

    public void p(org.apache.http.conn.ssl.SSLSocketFactory sSLSocketFactory) {
        this.c = sSLSocketFactory;
    }

    public void q(k$a k$a) {
        this.g = k$a;
    }

    public void r(Context context) {
        this.h = context;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block20: {
            block16: {
                block17: {
                    block21: {
                        block18: {
                            block19: {
                                block15: {
                                    super.run();
                                    var1_1 = this.c;
                                    var2_5 = 0;
                                    var3_6 = null;
                                    if (var1_1 == null || (var1_1 = this.d) == null) break block18;
                                    var1_1 = this.e;
                                    if (var1_1 == null || (var4_12 = TextUtils.isEmpty((CharSequence)(var1_1 = this.f))) != 0) break block19;
                                    var1_1 = this.c;
                                    var5_15 = this.d;
                                    var1_1.setHostnameVerifier((X509HostnameVerifier)var5_15);
                                    var1_1 = this.c;
                                    {
                                        catch (Throwable var1_2) {
                                            break block15;
                                        }
                                        catch (Exception var1_3) {}
                                        {
                                            var5_15 = k.i;
                                            var7_20 = new StringBuilder();
                                            var8_23 = "run: exception : ";
                                            var7_20.append(var8_23);
                                            var1_4 = var1_3.getMessage();
                                            var7_20.append(var1_4);
                                            var1_4 = var7_20.toString();
                                            d.j.f.a.a.j.o.i.d(var5_15, var1_4);
                                            this.b();
                                        }
                                        d.j.f.a.a.j.o.h.i(null);
                                        return;
                                    }
                                    var6_17 = var1_1 instanceof f;
                                    if (var6_17 == 0) ** GOTO lbl35
                                    {
                                        var1_1 = (f)var1_1;
                                        var5_15 = this.h;
                                        var1_1.n((Context)var5_15);
lbl35:
                                        // 2 sources

                                        var1_1 = new BasicHttpParams();
                                        var6_17 = 30000;
                                        HttpConnectionParams.setConnectionTimeout((HttpParams)var1_1, (int)var6_17);
                                        HttpConnectionParams.setSoTimeout((HttpParams)var1_1, (int)var6_17);
                                        var5_15 = new SchemeRegistry();
                                        var8_22 = "https";
                                        var9_25 = this.c;
                                        var10_26 = 443;
                                        var7_19 = new Scheme(var8_22, (SocketFactory)var9_25, var10_26);
                                        var5_15.register((Scheme)var7_19);
                                        var8_22 = "http";
                                        var9_25 = PlainSocketFactory.getSocketFactory();
                                        var10_26 = 80;
                                        var7_19 = new Scheme(var8_22, (SocketFactory)var9_25, var10_26);
                                        var5_15.register((Scheme)var7_19);
                                        var7_19 = new ThreadSafeClientConnManager((HttpParams)var1_1, (SchemeRegistry)var5_15);
                                        var5_15 = new DefaultHttpClient((ClientConnectionManager)var7_19, (HttpParams)var1_1);
                                        var1_1 = new HttpGet();
                                        var8_22 = this.f;
                                        var7_19 = new URI(var8_22);
                                        var1_1.setURI((URI)var7_19);
                                        var1_1 = var5_15.execute((HttpUriRequest)var1_1);
                                        var5_15 = k.i;
                                        var7_19 = new StringBuilder();
                                        var8_22 = "status code is : ";
                                        var7_19.append(var8_22);
                                        var1_1 = var1_1.getStatusLine();
                                        var4_12 = var1_1.getStatusCode();
                                        var7_19.append(var4_12);
                                        var1_1 = var7_19.toString();
                                        d.j.f.a.a.j.o.i.e(var5_15, (String)var1_1);
                                    }
                                    d.j.f.a.a.j.o.h.i(null);
                                    this.c();
                                    return;
                                }
                                d.j.f.a.a.j.o.h.i(null);
                                throw var1_2;
                            }
                            d.j.f.a.a.j.o.i.d(k.i, "sslErrorHandler or url is null");
                            this.b();
                            return;
                        }
                        var1_1 = this.a;
                        if (var1_1 == null || (var1_1 = this.b) == null) break block20;
                        try {
                            var5_16 = this.f;
                            var1_1 = new URL(var5_16);
                            var1_1 = var1_1.openConnection();
                            var1_1 = FirebasePerfUrlConnection.instrument(var1_1);
                            var1_1 = (URLConnection)var1_1;
                        }
                        catch (Throwable var3_8) {
                            var4_13 = false;
                            var1_1 = null;
                            break block16;
                        }
                        catch (Exception var3_9) {
                            var4_14 = false;
                            var1_1 = null;
                            ** GOTO lbl-1000
                        }
                        var6_18 = var1_1 instanceof HttpsURLConnection;
                        if (!var6_18) break block21;
                        {
                            var1_1 = (HttpsURLConnection)var1_1;
                        }
                        try {
                            var3_6 = this.a;
                            var1_1.setSSLSocketFactory((SSLSocketFactory)var3_6);
                            var3_6 = this.b;
                            var1_1.setHostnameVerifier((HostnameVerifier)var3_6);
                            var3_6 = "GET";
                            var1_1.setRequestMethod((String)var3_6);
                            var2_5 = 10000;
                            var1_1.setConnectTimeout(var2_5);
                            var2_5 = 20000;
                            var1_1.setReadTimeout(var2_5);
                            var1_1.connect();
                            var3_6 = var1_1;
                        }
                        catch (Exception var3_7) {
                            ** GOTO lbl-1000
                        }
                    }
                    if (var3_6 != null) {
                        var3_6.disconnect();
                    }
                    this.c();
                    return;
lbl-1000:
                    // 2 sources

                    {
                        var5_16 = k.i;
                        var7_21 = new StringBuilder();
                        var8_24 = "exception : ";
                        var7_21.append(var8_24);
                        var3_6 = var3_6.getMessage();
                        var7_21.append((String)var3_6);
                        var3_6 = var7_21.toString();
                        d.j.f.a.a.j.o.i.d(var5_16, (String)var3_6);
                        this.b();
                        if (var1_1 == null) break block17;
                    }
                    var1_1.disconnect();
                }
                return;
            }
            if (var1_1 != null) {
                var1_1.disconnect();
            }
            throw var3_11;
        }
        this.b();
    }

    public void s(HostnameVerifier hostnameVerifier) {
        this.b = hostnameVerifier;
    }

    public void t(SslErrorHandler sslErrorHandler) {
        this.e = sslErrorHandler;
    }

    public void u(SSLSocketFactory sSLSocketFactory) {
        this.a = sSLSocketFactory;
    }

    public void v(String string2) {
        this.f = string2;
    }
}

