/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.availableupdate;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.availableupdate.i;
import com.huawei.hms.availableupdate.k;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.IOUtils;
import d.j.f.a.a.j.g;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class j
implements k {
    public HttpURLConnection a;
    public volatile int b = -1;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(String object, OutputStream outputStream, int n10, int n11, Context object2) {
        InputStream inputStream = null;
        try {
            this.a((String)object, (Context)object2);
            object = this.a;
            String string2 = "GET";
            ((HttpURLConnection)object).setRequestMethod(string2);
            if (n10 > 0) {
                object = this.a;
                String string3 = "Range";
                StringBuilder stringBuilder = new StringBuilder();
                String string4 = "bytes=";
                stringBuilder.append(string4);
                stringBuilder.append(n10);
                string4 = "-";
                stringBuilder.append(string4);
                stringBuilder.append(n11);
                String string5 = stringBuilder.toString();
                ((URLConnection)object).addRequestProperty(string3, string5);
            }
            object = this.a;
            int n12 = ((HttpURLConnection)object).getResponseCode();
            if (n10 <= 0 || n12 != (n11 = 206)) {
                if (n10 > 0) return n12;
                n10 = 200;
                if (n12 != n10) return n12;
            }
            Object object3 = this.a;
            inputStream = ((URLConnection)object3).getInputStream();
            n11 = 4096;
            object3 = new BufferedInputStream(inputStream, n11);
            this.a((InputStream)object3, outputStream);
            outputStream.flush();
            return n12;
        }
        finally {
            IOUtils.closeQuietly(inputStream);
        }
    }

    public void a() {
        this.b = 1;
    }

    public final void a(InputStream object, OutputStream outputStream) {
        int n10;
        int n11;
        int n12 = 4096;
        byte[] byArray = new byte[n12];
        while ((n11 = -1) != (n10 = ((InputStream)object).read(byArray))) {
            outputStream.write(byArray, 0, n10);
            n10 = this.b;
            n11 = 1;
            if (n10 != n11) continue;
            object = new i("HTTP(s) request was canceled.");
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void a(String object, Context object2) {
        block11: {
            Object object3;
            int n10 = this.b;
            String string2 = "HttpRequestHelper";
            if (n10 == 0) {
                object3 = "Not allowed to repeat open http(s) connection.";
                HMSLog.e(string2, (String)object3);
            }
            object3 = new URL((String)object);
            this.a = object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object3).openConnection()));
            boolean bl2 = object instanceof HttpsURLConnection;
            if (bl2) {
                Object object4;
                try {
                    object = g.f((Context)object2);
                    if (object != null) {
                        object2 = this.a;
                        object2 = (HttpsURLConnection)object2;
                        ((HttpsURLConnection)object2).setSSLSocketFactory((SSLSocketFactory)object);
                    }
                    object2 = this.a;
                    object2 = (HttpsURLConnection)object2;
                    ((HttpsURLConnection)object2).setSSLSocketFactory((SSLSocketFactory)object);
                    break block11;
                }
                catch (IllegalAccessException illegalAccessException) {
                }
                catch (IllegalArgumentException illegalArgumentException) {
                }
                catch (KeyStoreException keyStoreException) {
                }
                catch (CertificateException certificateException) {
                }
                catch (IOException iOException) {
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                }
                catch (KeyManagementException keyManagementException) {
                    // empty catch block
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Failed to new TLSSocketFactory instance.");
                object4 = ((Throwable)object4).getMessage();
                ((StringBuilder)object2).append((String)object4);
                object4 = ((StringBuilder)object2).toString();
                HMSLog.e(string2, (String)object4);
                object4 = new IOException("Failed to create SSLSocketFactory.");
                throw object4;
            }
        }
        object = this.a;
        int n11 = 30000;
        ((URLConnection)object).setConnectTimeout(n11);
        this.a.setReadTimeout(n11);
        object = this.a;
        boolean bl3 = true;
        ((URLConnection)object).setDoInput(bl3);
        this.a.setDoOutput(bl3);
        this.a.setUseCaches(false);
        this.a.setInstanceFollowRedirects(bl3);
        this.b = 0;
    }

    public void close() {
        int n10;
        this.b = n10 = -1;
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}

