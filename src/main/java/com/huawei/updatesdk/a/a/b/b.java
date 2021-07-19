/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.apache.http.conn.ssl.SSLSocketFactory
 */
package com.huawei.updatesdk.a.a.b;

import android.content.Context;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.updatesdk.a.a.b.a;
import com.huawei.updatesdk.a.a.b.b$a;
import com.huawei.updatesdk.a.a.d.d;
import d.j.f.a.a.j.g;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.FilterInputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

public class b {
    private HttpURLConnection a = null;

    private HttpURLConnection a(String object, Context object2) {
        URL uRL = new URL((String)object);
        boolean bl2 = (object = (URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection())) instanceof HttpsURLConnection;
        if (bl2) {
            object = (HttpsURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection()));
            object2 = g.f(object2);
            ((HttpsURLConnection)object).setSSLSocketFactory((SSLSocketFactory)object2);
            object2 = org.apache.http.conn.ssl.SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            ((HttpsURLConnection)object).setHostnameVerifier((HostnameVerifier)object2);
        } else {
            boolean bl3 = object instanceof HttpURLConnection;
            if (bl3) {
                object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(uRL.openConnection()));
            } else {
                bl3 = false;
                object = null;
            }
        }
        return object;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private byte[] a(byte[] byArray) {
        void var1_8;
        FilterOutputStream filterOutputStream;
        String string2;
        String string3;
        block15: {
            ByteArrayOutputStream byteArrayOutputStream;
            string3 = "gzip error!";
            string2 = "HttpsUtil";
            filterOutputStream = null;
            try {
                block16: {
                    DataOutputStream dataOutputStream;
                    byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        int n10 = byArray.length;
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream((OutputStream)byteArrayOutputStream, n10);
                        dataOutputStream = new DataOutputStream(gZIPOutputStream);
                        filterOutputStream = null;
                    }
                    catch (IOException iOException) {}
                    int n11 = byArray.length;
                    dataOutputStream.write(byArray, 0, n11);
                    dataOutputStream.flush();
                    dataOutputStream.close();
                    return byteArrayOutputStream.toByteArray();
                    catch (Throwable throwable) {
                        filterOutputStream = dataOutputStream;
                        break block15;
                    }
                    catch (IOException iOException) {
                        filterOutputStream = dataOutputStream;
                        break block16;
                    }
                    break block16;
                    catch (IOException iOException) {
                        byteArrayOutputStream = null;
                    }
                }
                com.huawei.updatesdk.a.a.c.a.a.a.a(string2, string3, (Throwable)byArray);
                if (filterOutputStream == null) return byteArrayOutputStream.toByteArray();
            }
            catch (Throwable throwable) {
                break block15;
            }
            try {
                filterOutputStream.close();
                return byteArrayOutputStream.toByteArray();
            }
            catch (IOException iOException) {
                com.huawei.updatesdk.a.a.c.a.a.a.a(string2, string3, iOException);
            }
            return byteArrayOutputStream.toByteArray();
        }
        if (filterOutputStream == null) throw var1_8;
        try {
            filterOutputStream.close();
            throw var1_8;
        }
        catch (IOException iOException) {
            com.huawei.updatesdk.a.a.c.a.a.a.a(string2, string3, iOException);
        }
        throw var1_8;
    }

    /*
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public b$a a(String object, String object2, String object3, String object4, Context object5) {
        void var2_6;
        Object object6;
        block13: {
            block15: {
                b$a b$a;
                block14: {
                    int n10;
                    int n11;
                    block12: {
                        block11: {
                            block9: {
                                block10: {
                                    b$a = new b$a();
                                    object6 = null;
                                    object = this.a((String)object, (Context)object5);
                                    if (object != null) break block9;
                                    if (object == null) break block10;
                                    ((HttpURLConnection)object).disconnect();
                                }
                                d.a(null);
                                break block14;
                            }
                            this.a = object;
                            n11 = 1;
                            ((URLConnection)object).setDoInput(n11 != 0);
                            ((URLConnection)object).setDoOutput(n11 != 0);
                            n11 = 0;
                            object5 = null;
                            ((URLConnection)object).setUseCaches(false);
                            n11 = 5000;
                            ((URLConnection)object).setConnectTimeout(n11);
                            n11 = 10000;
                            ((URLConnection)object).setReadTimeout(n11);
                            object5 = "POST";
                            ((HttpURLConnection)object).setRequestMethod((String)object5);
                            object5 = "Content-Type";
                            String string2 = "application/x-gzip";
                            ((URLConnection)object).setRequestProperty((String)object5, string2);
                            object5 = "Content-Encoding";
                            string2 = "gzip";
                            ((URLConnection)object).setRequestProperty((String)object5, string2);
                            object5 = "Connection";
                            string2 = "Keep-Alive";
                            ((URLConnection)object).setRequestProperty((String)object5, string2);
                            object5 = "User-Agent";
                            ((URLConnection)object).setRequestProperty((String)object5, (String)object4);
                            object5 = ((URLConnection)object).getOutputStream();
                            object4 = new DataOutputStream((OutputStream)object5);
                            try {
                                object2 = ((String)object2).getBytes((String)object3);
                                object2 = this.a((byte[])object2);
                                ((FilterOutputStream)object4).write((byte[])object2);
                                ((DataOutputStream)object4).flush();
                                int n12 = ((HttpURLConnection)object).getResponseCode();
                                b$a.a(b$a, n12);
                                int n13 = 200;
                                if (n12 != n13) break block11;
                                object3 = ((URLConnection)object).getInputStream();
                                object2 = new BufferedInputStream((InputStream)object3);
                                break block12;
                            }
                            catch (Throwable throwable) {
                                break block13;
                            }
                        }
                        object3 = ((HttpURLConnection)object).getErrorStream();
                        object2 = new BufferedInputStream((InputStream)object3);
                    }
                    object6 = object2;
                    object2 = new com.huawei.updatesdk.a.a.d.b();
                    object3 = com.huawei.updatesdk.a.a.b.a.b();
                    object3 = ((a)object3).a();
                    while ((n11 = ((FilterInputStream)object6).read((byte[])object3)) != (n10 = -1)) {
                        ((com.huawei.updatesdk.a.a.d.b)object2).a((byte[])object3, n11);
                    }
                    object5 = com.huawei.updatesdk.a.a.b.a.b();
                    ((a)object5).a((byte[])object3);
                    object2 = ((com.huawei.updatesdk.a.a.d.b)object2).a();
                    b$a.a(b$a, (String)object2);
                    if (object != null) {
                        ((HttpURLConnection)object).disconnect();
                    }
                    d.a((Closeable)object4);
                }
                d.a(object6);
                return b$a;
                catch (Throwable throwable) {}
                break block15;
                catch (Throwable throwable) {
                    object = null;
                }
            }
            object4 = null;
        }
        if (object != null) {
            ((HttpURLConnection)object).disconnect();
        }
        d.a((Closeable)object4);
        d.a(object6);
        throw var2_6;
    }

    public void a() {
        HttpURLConnection httpURLConnection = this.a;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
    }
}

