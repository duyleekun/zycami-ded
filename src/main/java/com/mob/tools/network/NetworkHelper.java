/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  org.apache.http.conn.ssl.SSLSocketFactory
 *  org.apache.http.conn.ssl.X509HostnameVerifier
 */
package com.mob.tools.network;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.network.ByteArrayPart;
import com.mob.tools.network.FileDownloadListener;
import com.mob.tools.network.FilePart;
import com.mob.tools.network.HTTPPart;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpConnectionImpl;
import com.mob.tools.network.HttpConnectionImpl23;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.MultiPart;
import com.mob.tools.network.NetworkHelper$1;
import com.mob.tools.network.NetworkHelper$2;
import com.mob.tools.network.NetworkHelper$3;
import com.mob.tools.network.NetworkHelper$4;
import com.mob.tools.network.NetworkHelper$5;
import com.mob.tools.network.NetworkHelper$NetworkTimeOut;
import com.mob.tools.network.NetworkHelper$SimpleX509TrustManager;
import com.mob.tools.network.OnReadListener;
import com.mob.tools.network.RawNetworkCallback;
import com.mob.tools.network.SSLSocketFactoryEx;
import com.mob.tools.network.StringPart;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;

public class NetworkHelper {
    public static int connectionTimeout = 0;
    private static boolean followRedirects = true;
    public static int readTimout;
    public boolean instanceFollowRedirects;

    public NetworkHelper() {
        boolean bl2;
        this.instanceFollowRedirects = bl2 = followRedirects;
    }

    public static String checkHttpRequestUrl(String string2) {
        block37: {
            Object[] objectArray;
            String string3;
            Object object;
            block41: {
                String string4;
                Object object2;
                block38: {
                    StringBuilder stringBuilder;
                    Object object3;
                    Object object4;
                    int n11;
                    block40: {
                        block39: {
                            int n10;
                            object = "isCleartextTrafficPermitted";
                            n11 = TextUtils.isEmpty((CharSequence)string2);
                            if (n11 != 0) break block37;
                            n11 = Build.VERSION.SDK_INT;
                            int n12 = 23;
                            if (n11 < n12) break block37;
                            object4 = "android.security.NetworkSecurityPolicy";
                            object4 = ReflectHelper.importClass((String)object4);
                            object3 = "getInstance";
                            object2 = new Object[]{};
                            object4 = ReflectHelper.invokeStaticMethod((String)object4, (String)object3, (Object[])object2);
                            object3 = new Object[]{};
                            object3 = ReflectHelper.invokeInstanceMethod(object4, (String)object, (Object[])object3);
                            object3 = (Boolean)object3;
                            boolean n102 = (Boolean)object3;
                            if (n102) break block37;
                            string2 = string2.trim();
                            object3 = "http://";
                            boolean bl2 = string2.startsWith((String)object3);
                            if (!bl2) break block37;
                            object3 = string2.trim();
                            object3 = Uri.parse((String)object3);
                            if (object3 == null) break block37;
                            object2 = object3.getScheme();
                            if (object2 == null) break block37;
                            string3 = "http";
                            boolean bl3 = ((String)object2).equals(string3);
                            if (!bl3) break block37;
                            object2 = object3.getHost();
                            string3 = object3.getPath();
                            string4 = "";
                            if (object2 == null) break block38;
                            int n13 = object3.getPort();
                            stringBuilder = new StringBuilder();
                            stringBuilder.append((String)object2);
                            if (n13 <= 0 || n13 == (n10 = 80)) break block39;
                            object2 = new StringBuilder();
                            String string5 = ":";
                            ((StringBuilder)object2).append(string5);
                            ((StringBuilder)object2).append(n13);
                            object3 = ((StringBuilder)object2).toString();
                            break block40;
                        }
                        object3 = string4;
                    }
                    stringBuilder.append((String)object3);
                    object2 = stringBuilder.toString();
                    int n14 = 24;
                    if (n11 < n14) break block38;
                    n11 = 1;
                    objectArray = new Object[n11];
                    objectArray[0] = object2;
                    object = ReflectHelper.invokeInstanceMethod(object4, (String)object, objectArray);
                    object = (Boolean)object;
                    boolean bl4 = (Boolean)object;
                    if (!bl4) break block38;
                    return string2;
                }
                object = new StringBuilder();
                objectArray = "https://";
                ((StringBuilder)object).append((String)objectArray);
                ((StringBuilder)object).append((String)object2);
                if (string3 != null) break block41;
                string3 = string4;
            }
            try {
                ((StringBuilder)object).append(string3);
                return ((StringBuilder)object).toString();
            }
            catch (Throwable throwable) {
                objectArray = MobLog.getInstance();
                objectArray.d(throwable);
            }
        }
        return string2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private HttpURLConnection getConnection(String object, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        int n10;
        int n11;
        NetworkHelper$SimpleX509TrustManager networkHelper$SimpleX509TrustManager;
        int n12;
        SecureRandom secureRandom;
        int n13;
        Object object2;
        int n14;
        Object object3;
        javax.net.ssl.SSLSocketFactory sSLSocketFactory;
        Object object4;
        block13: {
            block12: {
                object4 = new URL((String)object);
                object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object4).openConnection()));
                object4 = "methodTokens";
                sSLSocketFactory = null;
                try {
                    object3 = ReflectHelper.getInstanceField(object, (String)object4);
                }
                catch (Throwable throwable) {
                    n14 = 0;
                    object3 = null;
                }
                object2 = "HttpURLConnection";
                n13 = 1;
                secureRandom = null;
                if (object3 == null) {
                    object4 = "PERMITTED_USER_METHODS";
                    object3 = ReflectHelper.getStaticField((String)object2, (String)object4);
                    break block12;
                }
                n12 = 0;
                networkHelper$SimpleX509TrustManager = null;
                break block13;
                catch (Throwable throwable) {}
            }
            n12 = n13;
        }
        if (object3 != null) {
            String string2;
            object3 = (String[])object3;
            int n15 = ((String[])object3).length + n13;
            String[] stringArray = new String[n15];
            int n16 = ((String[])object3).length;
            System.arraycopy(object3, 0, stringArray, 0, n16);
            n14 = ((String[])object3).length;
            stringArray[n14] = string2 = "PATCH";
            if (n12 != 0) {
                ReflectHelper.setStaticField((String)object2, (String)object4, stringArray);
            } else {
                ReflectHelper.setInstanceField(object, (String)object4, stringArray);
            }
        }
        if ((n11 = Build.VERSION.SDK_INT) < (n14 = 8)) {
            object4 = "http.keepAlive";
            object3 = "false";
            System.setProperty((String)object4, (String)object3);
        }
        if ((n11 = object instanceof HttpsURLConnection) != 0) {
            object4 = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            object3 = object;
            object3 = (HttpsURLConnection)object;
            object2 = SSLContext.getInstance("TLS");
            TrustManager[] trustManagerArray = new TrustManager[n13];
            networkHelper$SimpleX509TrustManager = new NetworkHelper$SimpleX509TrustManager(null);
            trustManagerArray[0] = networkHelper$SimpleX509TrustManager;
            secureRandom = new SecureRandom();
            ((SSLContext)object2).init(null, trustManagerArray, secureRandom);
            sSLSocketFactory = ((SSLContext)object2).getSocketFactory();
            ((HttpsURLConnection)object3).setSSLSocketFactory(sSLSocketFactory);
            ((HttpsURLConnection)object3).setHostnameVerifier((HostnameVerifier)object4);
        }
        if ((n11 = networkHelper$NetworkTimeOut == null ? connectionTimeout : networkHelper$NetworkTimeOut.connectionTimeout) > 0) {
            ((HttpURLConnection)object).setConnectTimeout(n11);
        }
        if ((n10 = networkHelper$NetworkTimeOut == null ? readTimout : networkHelper$NetworkTimeOut.readTimout) > 0) {
            ((HttpURLConnection)object).setReadTimeout(n10);
        }
        return (HttpURLConnection)object;
    }

    private HTTPPart getDataPostHttpPart(HttpURLConnection object, String string2, byte[] byArray) {
        object = new ByteArrayPart();
        ((ByteArrayPart)object).append(byArray);
        return object;
    }

    private HTTPPart getFilePostHTTPPart(HttpURLConnection object, String string2, ArrayList object2, ArrayList object3) {
        boolean bl2;
        String string3;
        Object object4;
        Object object5;
        string2 = UUID.randomUUID().toString();
        Object object6 = new StringBuilder();
        ((StringBuilder)object6).append("multipart/form-data; boundary=");
        ((StringBuilder)object6).append(string2);
        object6 = ((StringBuilder)object6).toString();
        ((URLConnection)object).setRequestProperty("Content-Type", (String)object6);
        object = new MultiPart();
        object6 = new StringPart();
        String string4 = "Content-Disposition: form-data; name=\"";
        String string5 = "--";
        String string6 = "\r\n";
        if (object2 != null) {
            boolean n10;
            object2 = ((ArrayList)object2).iterator();
            while (n10 = object2.hasNext()) {
                object5 = (KVPair)object2.next();
                ((StringPart)object6).append(string5).append(string2).append(string6);
                object4 = ((StringPart)object6).append(string4);
                string3 = ((KVPair)object5).name;
                object4 = ((StringPart)object4).append(string3);
                string3 = "\"\r\n\r\n";
                ((StringPart)object4).append(string3);
                object5 = (String)((KVPair)object5).value;
                object5 = ((StringPart)object6).append((String)object5);
                ((StringPart)object5).append(string6);
            }
        }
        ((MultiPart)object).append((HTTPPart)object6);
        object2 = ((ArrayList)object3).iterator();
        while (bl2 = object2.hasNext()) {
            int n10;
            object3 = (KVPair)object2.next();
            object6 = new StringPart();
            object4 = (String)((KVPair)object3).value;
            object5 = new File((String)object4);
            ((StringPart)object6).append(string5).append(string2).append(string6);
            object4 = ((StringPart)object6).append(string4);
            string3 = ((KVPair)object3).name;
            object4 = ((StringPart)object4).append(string3);
            string3 = "\"; filename=\"";
            object4 = ((StringPart)object4).append(string3);
            object5 = ((File)object5).getName();
            ((StringPart)object4).append((String)object5).append("\"\r\n");
            object5 = URLConnection.getFileNameMap();
            object4 = (String)((KVPair)object3).value;
            object5 = object5.getContentTypeFor((String)object4);
            if (object5 == null || (n10 = ((String)object5).length()) <= 0) {
                object5 = ((String)((KVPair)object3).value).toLowerCase();
                int n11 = ((String)object5).endsWith((String)(object4 = "jpg"));
                if (n11 == 0 && (n11 = ((String)(object5 = ((String)((KVPair)object3).value).toLowerCase())).endsWith((String)(object4 = "jpeg"))) == 0) {
                    object5 = ((String)((KVPair)object3).value).toLowerCase();
                    n11 = ((String)object5).endsWith((String)(object4 = "png"));
                    if (n11 != 0) {
                        object5 = "image/png";
                    } else {
                        object5 = ((String)((KVPair)object3).value).toLowerCase();
                        n11 = ((String)object5).endsWith((String)(object4 = "gif"));
                        if (n11 != 0) {
                            object5 = "image/gif";
                        } else {
                            object4 = (String)((KVPair)object3).value;
                            object5 = new FileInputStream((String)object4);
                            object4 = URLConnection.guessContentTypeFromStream((InputStream)object5);
                            ((FileInputStream)object5).close();
                            object5 = object4 != null && (n11 = ((String)object4).length()) > 0 ? object4 : "application/octet-stream";
                        }
                    }
                } else {
                    object5 = "image/jpeg";
                }
            }
            object5 = ((StringPart)object6).append("Content-Type: ").append((String)object5);
            object4 = "\r\n\r\n";
            ((StringPart)object5).append((String)object4);
            ((MultiPart)object).append((HTTPPart)object6);
            object6 = new FilePart();
            object3 = (String)((KVPair)object3).value;
            ((FilePart)object6).setFile((String)object3);
            ((MultiPart)object).append((HTTPPart)object6);
            object3 = new StringPart();
            ((StringPart)object3).append(string6);
            ((MultiPart)object).append((HTTPPart)object3);
        }
        object2 = new StringPart();
        ((StringPart)object2).append(string5).append(string2).append("--\r\n");
        ((MultiPart)object).append((HTTPPart)object2);
        return object;
    }

    public static boolean getFollowRedirects() {
        return followRedirects;
    }

    private Object getHttpPatch(String string2) {
        return null;
    }

    private HTTPPart getTextPostHTTPPart(HttpURLConnection object, String string2, ArrayList arrayList) {
        string2 = "Content-Type";
        String string3 = "application/x-www-form-urlencoded";
        ((URLConnection)object).setRequestProperty(string2, string3);
        object = new StringPart();
        if (arrayList != null) {
            string2 = this.kvPairsToUrl(arrayList);
            ((StringPart)object).append(string2);
        }
        return object;
    }

    private void httpPatchImpl(String string2, ArrayList arrayList, KVPair kVPair, long l10, ArrayList arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut objectArray) {
        Object[] objectArray2;
        long l11;
        long l12;
        Object object;
        Object object2;
        block14: {
            Object object3;
            block13: {
                int n10;
                Object object4;
                Object object5;
                Object object6;
                int n11;
                int n12;
                NetworkHelper networkHelper = this;
                object2 = string2;
                object = arrayList;
                l12 = l10;
                HttpResponseCallback httpResponseCallback2 = httpResponseCallback;
                Object[] objectArray3 = objectArray;
                l11 = System.currentTimeMillis();
                Object object7 = MobLog.getInstance();
                CharSequence charSequence = new StringBuilder();
                charSequence.append("httpPatch: ");
                charSequence.append(string2);
                charSequence = charSequence.toString();
                Object object8 = new Object[]{};
                ((NLog)object7).i(charSequence, (Object[])object8);
                ReflectHelper.importClass("org.apache.http.entity.InputStreamEntity");
                ReflectHelper.importClass("org.apache.http.params.BasicHttpParams");
                ReflectHelper.importClass("org.apache.http.params.HttpConnectionParams");
                ReflectHelper.importClass("org.apache.http.HttpVersion");
                ReflectHelper.importClass("org.apache.http.params.HttpProtocolParams");
                ReflectHelper.importClass("org.apache.http.conn.scheme.SchemeRegistry");
                ReflectHelper.importClass("org.apache.http.conn.scheme.PlainSocketFactory");
                ReflectHelper.importClass("org.apache.http.conn.scheme.Scheme");
                ReflectHelper.importClass("org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager");
                object7 = "org.apache.http.impl.client.DefaultHttpClient";
                ReflectHelper.importClass((String)object7);
                if (arrayList != null && (n12 = ((String)(object = this.kvPairsToUrl(arrayList))).length()) > 0) {
                    object7 = new StringBuilder();
                    ((StringBuilder)object7).append(string2);
                    ((StringBuilder)object7).append("?");
                    ((StringBuilder)object7).append((String)object);
                    object2 = ((StringBuilder)object7).toString();
                }
                object = networkHelper.getHttpPatch((String)object2);
                n12 = 2;
                int n13 = 1;
                if (object != null && arrayList2 != null) {
                    object8 = arrayList2.iterator();
                    while ((n11 = object8.hasNext()) != 0) {
                        object6 = (KVPair)object8.next();
                        object5 = new Object[n12];
                        object5[0] = object4 = object6.name;
                        object6 = object6.value;
                        object5[n13] = object6;
                        object6 = "setHeader";
                        ReflectHelper.invokeInstanceMethod(object, (String)object6, object5);
                    }
                }
                object8 = new FilePart();
                object6 = onReadListener;
                ((HTTPPart)object8).setOnReadListener(onReadListener);
                object6 = kVPair;
                object6 = (String)kVPair.value;
                ((FilePart)object8).setFile((String)object6);
                ((HTTPPart)object8).setOffset(l12);
                object6 = ((HTTPPart)object8).toInputStream();
                long l13 = ((FilePart)object8).length() - l12;
                objectArray2 = new Object[n12];
                objectArray2[0] = object6;
                object3 = Long.valueOf(l13);
                objectArray2[n13] = object3;
                objectArray2 = ReflectHelper.newInstance("InputStreamEntity", objectArray2);
                object3 = new Object[n13];
                object3[0] = "application/offset+octet-stream";
                object8 = "setContentEncoding";
                ReflectHelper.invokeInstanceMethod((Object)objectArray2, (String)object8, object3);
                object3 = new Object[n13];
                object3[0] = objectArray2;
                ReflectHelper.invokeInstanceMethod(object, "setEntity", object3);
                objectArray2 = new Object[]{};
                object3 = "BasicHttpParams";
                objectArray2 = ReflectHelper.newInstance((String)object3, objectArray2);
                int n14 = objectArray3 == null ? connectionTimeout : objectArray3.connectionTimeout;
                object6 = "HttpConnectionParams";
                if (n14 > 0) {
                    object5 = new Object[n12];
                    object5[0] = objectArray2;
                    object5[n13] = object4 = Integer.valueOf(n14);
                    object4 = "setConnectionTimeout";
                    ReflectHelper.invokeStaticMethod((String)object6, (String)object4, object5);
                }
                if ((n10 = objectArray3 == null ? readTimout : objectArray3.readTimout) > 0) {
                    objectArray3 = new Object[n12];
                    objectArray3[0] = objectArray2;
                    objectArray3[n13] = object8 = Integer.valueOf(n14);
                    object8 = "setSoTimeout";
                    ReflectHelper.invokeStaticMethod((String)object6, (String)object8, objectArray3);
                }
                objectArray3 = new Object[n13];
                objectArray3[0] = objectArray2;
                ReflectHelper.invokeInstanceMethod(object, "setParams", objectArray3);
                boolean bl2 = object2.startsWith("https://");
                objectArray2 = "DefaultHttpClient";
                if (bl2) {
                    object2 = KeyStore.getInstance(KeyStore.getDefaultType());
                    object2.load(null, null);
                    objectArray3 = new SSLSocketFactoryEx((KeyStore)object2);
                    object2 = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
                    objectArray3.setHostnameVerifier((X509HostnameVerifier)object2);
                    object2 = new Object[]{};
                    object2 = ReflectHelper.newInstance((String)object3, object2);
                    object3 = ReflectHelper.getStaticField("HttpVersion", "HTTP_1_1");
                    object8 = new Object[n12];
                    object8[0] = object2;
                    object8[n13] = object3;
                    object3 = "HttpProtocolParams";
                    ReflectHelper.invokeStaticMethod((String)object3, "setVersion", (Object[])object8);
                    object8 = new Object[n12];
                    object8[0] = object2;
                    object8[n13] = "UTF-8";
                    ReflectHelper.invokeStaticMethod((String)object3, "setContentCharset", (Object[])object8);
                    object3 = new Object[]{};
                    object3 = ReflectHelper.newInstance("SchemeRegistry", object3);
                    object8 = new Object[]{};
                    object8 = ReflectHelper.invokeStaticMethod("PlainSocketFactory", "getSocketFactory", (Object[])object8);
                    n11 = 3;
                    object5 = new Object[n11];
                    object5[0] = "http";
                    object5[n13] = object8;
                    n14 = 80;
                    object5[n12] = object8 = Integer.valueOf(n14);
                    object8 = "Scheme";
                    object5 = ReflectHelper.newInstance((String)object8, object5);
                    object6 = new Object[n11];
                    object6[0] = object4 = "https";
                    object6[n13] = objectArray3;
                    n10 = 443;
                    objectArray3 = n10;
                    object6[n12] = objectArray3;
                    objectArray3 = ReflectHelper.newInstance((String)object8, object6);
                    object8 = new Object[n13];
                    object8[0] = object5;
                    object6 = "register";
                    ReflectHelper.invokeInstanceMethod(object3, (String)object6, (Object[])object8);
                    object8 = new Object[n13];
                    object8[0] = objectArray3;
                    ReflectHelper.invokeInstanceMethod(object3, (String)object6, (Object[])object8);
                    objectArray3 = new Object[n12];
                    objectArray3[0] = object2;
                    objectArray3[n13] = object3;
                    object3 = ReflectHelper.newInstance("ThreadSafeClientConnManager", objectArray3);
                    objectArray3 = new Object[n12];
                    objectArray3[0] = object3;
                    objectArray3[n13] = object2;
                    object2 = ReflectHelper.newInstance((String)objectArray2, objectArray3);
                } else {
                    object2 = new Object[]{};
                    object2 = ReflectHelper.newInstance((String)objectArray2, object2);
                }
                objectArray2 = new Object[n13];
                objectArray2[0] = object;
                object = ReflectHelper.invokeInstanceMethod(object2, "execute", objectArray2);
                objectArray2 = new Object[]{};
                objectArray2 = ReflectHelper.invokeInstanceMethod(object2, "getConnectionManager", objectArray2);
                object3 = "shutdown";
                if (httpResponseCallback2 == null) break block13;
                try {
                    object2 = new HttpConnectionImpl(object);
                }
                catch (Throwable throwable) {
                    try {
                        throw throwable;
                    }
                    catch (Throwable throwable2) {
                        Object[] objectArray4 = new Object[]{};
                        ReflectHelper.invokeInstanceMethod((Object)objectArray2, (String)object3, objectArray4);
                        throw throwable2;
                    }
                }
                httpResponseCallback2.onResponse((HttpConnection)object2);
                object2 = new Object[]{};
                ReflectHelper.invokeInstanceMethod((Object)objectArray2, (String)object3, object2);
                break block14;
            }
            object2 = new Object[]{};
            ReflectHelper.invokeInstanceMethod((Object)objectArray2, (String)object3, object2);
        }
        object2 = MobLog.getInstance();
        object = new StringBuilder();
        ((StringBuilder)object).append("use time: ");
        l12 = System.currentTimeMillis() - l11;
        ((StringBuilder)object).append(l12);
        object = ((StringBuilder)object).toString();
        objectArray2 = new Object[]{};
        object2.i(object, objectArray2);
    }

    private String kvPairsToUrl(ArrayList object) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (KVPair)object.next();
            String string2 = ((KVPair)object2).name;
            String string3 = "utf-8";
            string2 = Data.urlEncode(string2, string3);
            object2 = ((KVPair)object2).value;
            object2 = object2 != null ? Data.urlEncode((String)object2, string3) : "";
            int n10 = stringBuilder.length();
            if (n10 > 0) {
                n10 = 38;
                stringBuilder.append((char)n10);
            }
            stringBuilder.append(string2);
            char c10 = '=';
            stringBuilder.append(c10);
            stringBuilder.append((String)object2);
        }
        return stringBuilder.toString();
    }

    public static void setFollowRedirects(boolean bl2) {
        followRedirects = bl2;
    }

    public void download(String string2, OutputStream outputStream, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        byte[] byArray = new byte[1024];
        NetworkHelper$1 networkHelper$1 = new NetworkHelper$1(this, byArray, outputStream);
        this.rawGet(string2, networkHelper$1, networkHelper$NetworkTimeOut);
        outputStream.flush();
    }

    public String downloadCache(Context context, String string2, String string3, boolean bl2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        return this.downloadCache(context, string2, string3, bl2, networkHelper$NetworkTimeOut, null);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public String downloadCache(Context var1_1, String var2_2, String var3_3, boolean var4_4, NetworkHelper$NetworkTimeOut var5_5, FileDownloadListener var6_6) {
        block55: {
            block54: {
                block49: {
                    block57: {
                        block56: {
                            block58: {
                                var7_7 = this;
                                var8_8 = var1_1 /* !! */ ;
                                var9_10 = var2_2;
                                var10_11 = var3_3;
                                var11_12 = System.currentTimeMillis();
                                var13_13 = MobLog.getInstance();
                                var14_14 = new StringBuilder();
                                var14_14.append("downloading: ");
                                var14_14.append(var2_2);
                                var14_14 = var14_14.toString();
                                var15_15 = 0;
                                var16_16 = null;
                                var17_17 = new Object[]{};
                                var13_13.i(var14_14, (Object[])var17_17);
                                var18_18 = "use time: ";
                                if (var4_4) {
                                    var13_13 = ResHelper.getCachePath(var1_1 /* !! */ , var3_3);
                                    var14_14 = Data.MD5(var2_2);
                                    var17_17 = new File((String)var13_13, (String)var14_14);
                                    if (var4_4 && (var19_19 = var17_17.exists()) != 0) {
                                        var8_8 = MobLog.getInstance();
                                        var9_10 = new StringBuilder();
                                        var9_10.append(var18_18);
                                        var20_20 = System.currentTimeMillis() - var11_12;
                                        var9_10.append(var20_20);
                                        var9_10 = var9_10.toString();
                                        var10_11 = new Object[]{};
                                        var8_8.i(var9_10, (Object[])var10_11);
                                        if (var6_6 != null) {
                                            var22_23 = 100;
                                            var23_25 = var17_17.length();
                                            var25_27 = var17_17.length();
                                            var1_1 /* !! */  = var6_6;
                                            var6_6.onProgress(var22_23, var23_25, var25_27);
                                        }
                                        return var17_17.getAbsolutePath();
                                    }
                                }
                                var13_13 = var5_5;
                                var27_30 = var7_7.getConnection((String)var9_10, var5_5);
                                var19_19 = var7_7.instanceFollowRedirects;
                                var27_30.setInstanceFollowRedirects((boolean)var19_19);
                                var27_30.connect();
                                var19_19 = var27_30.getResponseCode();
                                var28_31 = 200;
                                if (var19_19 != var28_31) break block55;
                                var13_13 = var27_30.getHeaderFields();
                                var28_31 = 1;
                                if (var13_13 != null && (var29_32 /* !! */  = var13_13.get("Content-Disposition")) != null && (var30_33 = var29_32 /* !! */ .size()) > 0) {
                                    var29_32 /* !! */  = var29_32 /* !! */ .get(0);
                                    var31_34 = ";";
                                    var29_32 /* !! */  = var29_32 /* !! */ .split((String)var31_34);
                                    var30_33 = var29_32 /* !! */ .length;
                                    var33_36 = null;
                                    var34_37 = 0;
                                    var35_38 = null;
                                    for (var32_35 = 0; var32_35 < var30_33; ++var32_35) {
                                        var36_39 = var29_32 /* !! */ [var32_35];
                                        var17_17 = var36_39.trim();
                                        var37_40 = var17_17.startsWith((String)(var16_16 = "filename"));
                                        if (var37_40 != 0) {
                                            var17_17 = var36_39.split("=")[var28_31];
                                            var38_41 = (int)var17_17.startsWith((String)(var16_16 = "\""));
                                            if (var38_41 != 0 && (var15_15 = var17_17.endsWith((String)var16_16)) != 0) {
                                                var15_15 = var17_17.length() - var28_31;
                                                var35_38 = var17_17.substring(var28_31, var15_15);
                                            } else {
                                                var35_38 = var17_17;
                                            }
                                        }
                                        var15_15 = 0;
                                        var16_16 = null;
                                    }
                                } else {
                                    var34_37 = 0;
                                    var35_38 = null;
                                }
                                if (var35_38 != null) break block56;
                                var17_17 = Data.MD5(var2_2);
                                if (var13_13 == null || (var13_13 = var13_13.get(var29_32 /* !! */  = "Content-Type")) == null || (var39_42 = var13_13.size()) <= 0) break block57;
                                var39_42 = 0;
                                var29_32 /* !! */  = null;
                                var39_42 = (int)(var13_13 = (var13_13 = (String)var13_13.get(0)) == null ? "" : var13_13.trim()).startsWith((String)(var29_32 /* !! */  = "image/"));
                                if (var39_42 == 0) break block58;
                                var40_43 = 6;
                                var9_10 = var13_13.substring(var40_43);
                                var13_13 = new StringBuilder();
                                var13_13.append((String)var17_17);
                                var13_13.append(".");
                                var14_14 = "jpeg";
                                var28_31 = (int)var14_14.equals(var9_10);
                                if (var28_31 != 0) {
                                    var9_10 = "jpg";
                                }
                                var13_13.append((String)var9_10);
                                var35_38 = var13_13.toString();
                                break block56;
                            }
                            var19_19 = var9_10.lastIndexOf(47);
                            if (var19_19 > 0) {
                                var9_10 = var9_10.substring(var19_19 += var28_31);
                            } else {
                                var40_43 = 0;
                                var9_10 = null;
                            }
                            if (var9_10 == null || (var19_19 = var9_10.length()) <= 0 || (var19_19 = var9_10.lastIndexOf(46)) <= 0 || (var28_31 = var9_10.length() - var19_19) >= (var39_42 = 10)) break block57;
                            var14_14 = new StringBuilder();
                            var14_14.append((String)var17_17);
                            var9_10 = var9_10.substring(var19_19);
                            var14_14.append((String)var9_10);
                            var35_38 = var14_14.toString();
                        }
                        var17_17 = var35_38;
                    }
                    var8_8 = ResHelper.getCachePath((Context)var8_8, (String)var10_11);
                    var16_16 = new File((String)var8_8, (String)var17_17);
                    if (var4_4 && (var22_24 = var16_16.exists()) != 0) {
                        var27_30.disconnect();
                        var8_8 = MobLog.getInstance();
                        var9_10 = new StringBuilder();
                        var9_10.append(var18_18);
                        var20_21 = System.currentTimeMillis() - var11_12;
                        var9_10.append(var20_21);
                        var9_10 = var9_10.toString();
                        var10_11 = new Object[]{};
                        var8_8.i(var9_10, (Object[])var10_11);
                        if (var6_6 != null) {
                            var22_24 = 100;
                            var23_26 = var16_16.length();
                            var25_28 = var16_16.length();
                            var1_1 /* !! */  = var6_6;
                            var6_6.onProgress(var22_24, var23_26, var25_28);
                        }
                        return var16_16.getAbsolutePath();
                    }
                    var8_8 = var16_16.getParentFile();
                    var22_24 = var8_8.exists();
                    if (var22_24 == 0) {
                        var8_8 = var16_16.getParentFile();
                        var8_8.mkdirs();
                    }
                    if ((var22_24 = var16_16.exists()) != 0) {
                        var16_16.delete();
                    }
                    if (var6_6 != null) {
                        block50: {
                            var22_24 = var6_6.isCanceled();
                            if (var22_24 == 0) break block49;
                            var22_24 = var16_16.exists();
                            if (var22_24 == 0) break block50;
                            var16_16.delete();
                        }
                        return null;
                    }
                }
                var8_8 = var27_30.getInputStream();
                var38_41 = var27_30.getContentLength();
                var31_34 = new FileOutputStream((File)var16_16);
                var40_43 = 1024;
                var33_36 = new byte[var40_43];
                var40_43 = var8_8.read(var33_36);
                var39_42 = 0;
                var29_32 /* !! */  = null;
                while (var40_43 > 0) {
                    block53: {
                        block51: {
                            block52: {
                                var10_11 = null;
                                var31_34.write(var33_36, 0, var40_43);
                                var37_40 = var39_42 + var40_43;
                                if (var6_6 == null) break block51;
                                if (var38_41 <= 0) {
                                    var40_43 = 100;
                                    break block52;
                                }
                                var40_43 = var37_40 * 100;
                                var40_43 /= var38_41;
                            }
                            var25_29 = var37_40;
                            var41_44 = var38_41;
                            var9_10 = var6_6;
                            var34_37 = var37_40;
                            var6_6.onProgress(var40_43, var25_29, var41_44);
                            var40_43 = (int)var6_6.isCanceled();
                            if (var40_43 != 0) {
                                break;
                            }
                            break block53;
                        }
                        var34_37 = var37_40;
                    }
                    var40_43 = var8_8.read(var33_36);
                    var39_42 = var34_37;
                }
                if (var6_6 == null) ** GOTO lbl234
                try {
                    var40_43 = (int)var6_6.isCanceled();
                    if (var40_43 == 0) break block54;
                }
                catch (Throwable var8_9) {
                    var40_43 = var16_16.exists();
                    if (var40_43 != 0) {
                        var16_16.delete();
                    }
                    throw var8_9;
                }
                var40_43 = (int)var16_16.exists();
                if (var40_43 == 0) ** GOTO lbl221
                var16_16.delete();
lbl221:
                // 2 sources

                var31_34.flush();
                var8_8.close();
                var31_34.close();
                return null;
            }
            var40_43 = 100;
            var20_22 = var16_16.length();
            var43_45 = var16_16.length();
            var1_1 /* !! */  = var6_6;
            var6_6.onProgress(var40_43, var20_22, var43_45);
lbl234:
            // 2 sources

            var31_34.flush();
            var8_8.close();
            var31_34.close();
            var27_30.disconnect();
            var8_8 = MobLog.getInstance();
            var9_10 = new StringBuilder();
            var9_10.append(var18_18);
            var20_22 = System.currentTimeMillis() - var11_12;
            var9_10.append(var20_22);
            var9_10 = var9_10.toString();
            var10_11 = new Object[]{};
            var8_8.i(var9_10, (Object[])var10_11);
            return var16_16.getAbsolutePath();
        }
        var8_8 = new StringBuilder();
        var10_11 = var27_30.getErrorStream();
        var14_14 = Charset.forName("utf-8");
        var9_10 = new InputStreamReader((InputStream)var10_11, (Charset)var14_14);
        var10_11 = new BufferedReader((Reader)var9_10);
        var9_10 = var10_11.readLine();
        while (var9_10 != null) {
            var28_31 = var8_8.length();
            if (var28_31 > 0) {
                var28_31 = 10;
                var8_8.append((char)var28_31);
            } else {
                var28_31 = 10;
            }
            var8_8.append((String)var9_10);
            var9_10 = var10_11.readLine();
        }
        var10_11.close();
        var27_30.disconnect();
        var9_10 = new HashMap();
        var8_8 = var8_8.toString();
        var9_10.put("error", var8_8);
        var8_8 = var19_19;
        var9_10.put("status", var8_8);
        var10_11 = new Hashon();
        var9_10 = var10_11.fromHashMap((HashMap)var9_10);
        var8_8 = new Throwable((String)var9_10);
        throw var8_8;
    }

    public void getHttpPostResponse(String object, ArrayList object2, KVPair objectArray, ArrayList object3, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object4) {
        int n10;
        long l10 = System.currentTimeMillis();
        ArrayList<KVPair> arrayList = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)((Object)arrayList)).i(charSequence, objectArray2);
        object4 = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object4);
        boolean bl2 = true;
        ((URLConnection)object4).setDoOutput(bl2);
        ((HttpURLConnection)object4).setChunkedStreamingMode(0);
        if (objectArray != null && (arrayList = objectArray.value) != null && (bl2 = ((File)((Object)(arrayList = new ArrayList<KVPair>((String)(charSequence = (String)objectArray.value))))).exists())) {
            arrayList = new ArrayList<KVPair>();
            arrayList.add((KVPair)objectArray);
            object = this.getFilePostHTTPPart((HttpURLConnection)object4, (String)object, (ArrayList)object2, arrayList);
        } else {
            object = this.getTextPostHTTPPart((HttpURLConnection)object4, (String)object, (ArrayList)object2);
        }
        if (object3 != null) {
            object2 = ((ArrayList)object3).iterator();
            while ((n10 = object2.hasNext()) != 0) {
                objectArray = (KVPair)object2.next();
                object3 = objectArray.name;
                objectArray = (String)objectArray.value;
                ((URLConnection)object4).setRequestProperty((String)object3, (String)objectArray);
            }
        }
        boolean bl3 = this.instanceFollowRedirects;
        ((HttpURLConnection)object4).setInstanceFollowRedirects(bl3);
        ((URLConnection)object4).connect();
        object2 = ((URLConnection)object4).getOutputStream();
        object = ((HTTPPart)object).toInputStream();
        n10 = 65536;
        objectArray = new byte[n10];
        int n11 = ((InputStream)object).read((byte[])objectArray);
        while (n11 > 0) {
            ((OutputStream)object2).write((byte[])objectArray, 0, n11);
            n11 = ((InputStream)object).read((byte[])objectArray);
        }
        ((OutputStream)object2).flush();
        ((InputStream)object).close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object = new HttpConnectionImpl23((HttpURLConnection)object4);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object4).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object);
            ((HttpURLConnection)object4).disconnect();
        } else {
            ((HttpURLConnection)object4).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public boolean getInstanceFollowRedirects() {
        return this.instanceFollowRedirects;
    }

    public String httpGet(String object, ArrayList object2, ArrayList object3, NetworkHelper$NetworkTimeOut objectArray) {
        int n10;
        int n11;
        long l10 = System.currentTimeMillis();
        Object object4 = MobLog.getInstance();
        Object object5 = new StringBuilder();
        ((StringBuilder)object5).append("httpGet: ");
        ((StringBuilder)object5).append((String)object);
        object5 = ((StringBuilder)object5).toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object4).i(object5, objectArray2);
        if (object2 != null && (n11 = ((String)(object2 = this.kvPairsToUrl((ArrayList)object2))).length()) > 0) {
            object4 = new StringBuilder();
            ((StringBuilder)object4).append((String)object);
            ((StringBuilder)object4).append("?");
            ((StringBuilder)object4).append((String)object2);
            object = ((StringBuilder)object4).toString();
        }
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)objectArray);
        if (object3 != null) {
            object2 = ((ArrayList)object3).iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object3 = (KVPair)object2.next();
                objectArray = ((KVPair)object3).name;
                object3 = (String)((KVPair)object3).value;
                ((URLConnection)object).setRequestProperty((String)objectArray, (String)object3);
            }
        }
        int n12 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(n12 != 0);
        ((URLConnection)object).connect();
        n12 = ((HttpURLConnection)object).getResponseCode();
        n10 = 200;
        char c10 = '\n';
        object4 = "utf-8";
        if (n12 == n10) {
            object2 = new StringBuilder();
            object5 = ((URLConnection)object).getInputStream();
            object4 = Charset.forName((String)object4);
            object3 = new InputStreamReader((InputStream)object5, (Charset)object4);
            object4 = new BufferedReader((Reader)object3);
            object3 = ((BufferedReader)object4).readLine();
            while (object3 != null) {
                int n13 = ((StringBuilder)object2).length();
                if (n13 > 0) {
                    ((StringBuilder)object2).append(c10);
                }
                ((StringBuilder)object2).append((String)object3);
                object3 = ((BufferedReader)object4).readLine();
            }
            ((BufferedReader)object4).close();
            ((HttpURLConnection)object).disconnect();
            object = ((StringBuilder)object2).toString();
            object2 = MobLog.getInstance();
            object3 = new StringBuilder();
            ((StringBuilder)object3).append("use time: ");
            long l11 = System.currentTimeMillis() - l10;
            ((StringBuilder)object3).append(l11);
            object3 = ((StringBuilder)object3).toString();
            objectArray = new Object[]{};
            ((NLog)object2).i(object3, objectArray);
            return object;
        }
        object3 = new StringBuilder();
        Closeable closeable = ((HttpURLConnection)object).getErrorStream();
        object4 = Charset.forName((String)object4);
        Object object6 = new InputStreamReader((InputStream)closeable, (Charset)object4);
        closeable = new BufferedReader((Reader)object6);
        object6 = ((BufferedReader)closeable).readLine();
        while (object6 != null) {
            n11 = ((StringBuilder)object3).length();
            if (n11 > 0) {
                ((StringBuilder)object3).append(c10);
            }
            ((StringBuilder)object3).append((String)object6);
            object6 = ((BufferedReader)closeable).readLine();
        }
        ((BufferedReader)closeable).close();
        ((HttpURLConnection)object).disconnect();
        object = new HashMap();
        object3 = ((StringBuilder)object3).toString();
        ((HashMap)object).put("error", object3);
        object2 = n12;
        ((HashMap)object).put("status", object2);
        object3 = new Hashon();
        object = ((Hashon)object3).fromHashMap((HashMap)object);
        object2 = new Throwable((String)object);
        throw object2;
    }

    public ArrayList httpHead(String object, ArrayList object2, KVPair object3, ArrayList object4, NetworkHelper$NetworkTimeOut object5) {
        int n10;
        long l10 = System.currentTimeMillis();
        object3 = MobLog.getInstance();
        String[] stringArray = new StringBuilder();
        stringArray.append("httpHead: ");
        stringArray.append((String)object);
        stringArray = stringArray.toString();
        Object[] objectArray = new Object[]{};
        ((NLog)object3).i(stringArray, objectArray);
        if (object2 != null && (n10 = ((String)(object2 = this.kvPairsToUrl((ArrayList)object2))).length()) > 0) {
            object3 = new StringBuilder();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append("?");
            ((StringBuilder)object3).append((String)object2);
            object = ((StringBuilder)object3).toString();
        }
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object5);
        object2 = "HEAD";
        ((HttpURLConnection)object).setRequestMethod((String)object2);
        if (object4 != null) {
            object2 = object4.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object3 = (KVPair)object2.next();
                object4 = ((KVPair)object3).name;
                object3 = (String)((KVPair)object3).value;
                ((URLConnection)object).setRequestProperty((String)object4, (String)object3);
            }
        }
        boolean bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl2);
        ((URLConnection)object).connect();
        object2 = ((URLConnection)object).getHeaderFields();
        object3 = new ArrayList();
        if (object2 != null) {
            boolean bl3;
            object2 = object2.entrySet().iterator();
            while (bl3 = object2.hasNext()) {
                object4 = (Map.Entry)object2.next();
                object5 = (List)object4.getValue();
                if (object5 == null) {
                    object4 = (String)object4.getKey();
                    stringArray = new String[]{};
                    object5 = new KVPair((String)object4, stringArray);
                    ((ArrayList)object3).add(object5);
                    continue;
                }
                int n11 = object5.size();
                objectArray = new String[n11];
                for (int i10 = 0; i10 < n11; ++i10) {
                    String string2 = (String)object5.get(i10);
                    objectArray[i10] = string2;
                }
                object4 = (String)object4.getKey();
                object5 = new KVPair((String)object4, objectArray);
                ((ArrayList)object3).add(object5);
            }
        }
        ((HttpURLConnection)object).disconnect();
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        object4 = new Object[]{};
        ((NLog)object).i(object2, object4);
        return object3;
    }

    public void httpPatch(String string2, ArrayList arrayList, KVPair kVPair, long l10, ArrayList arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            this.httpPatchImpl23(string2, arrayList, kVPair, l10, arrayList2, onReadListener, httpResponseCallback, networkHelper$NetworkTimeOut);
        } else {
            this.httpPatchImpl(string2, arrayList, kVPair, l10, arrayList2, onReadListener, httpResponseCallback, networkHelper$NetworkTimeOut);
        }
    }

    public void httpPatchImpl23(String object, ArrayList object2, KVPair objectArray, long l10, ArrayList object3, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object4) {
        int n10;
        long l11 = System.currentTimeMillis();
        Object object5 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPatch: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object5).i(charSequence, objectArray2);
        if (object2 != null && (n10 = ((String)(object2 = this.kvPairsToUrl((ArrayList)object2))).length()) > 0) {
            object5 = new StringBuilder();
            ((StringBuilder)object5).append((String)object);
            ((StringBuilder)object5).append("?");
            ((StringBuilder)object5).append((String)object2);
            object = ((StringBuilder)object5).toString();
        }
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object4);
        boolean bl2 = true;
        ((URLConnection)object).setDoOutput(bl2);
        ((HttpURLConnection)object).setChunkedStreamingMode(0);
        ((HttpURLConnection)object).setRequestMethod("PATCH");
        object2 = "Content-Type";
        object4 = "application/offset+octet-stream";
        ((URLConnection)object).setRequestProperty((String)object2, (String)object4);
        if (object3 != null) {
            boolean bl3;
            object2 = ((ArrayList)object3).iterator();
            while (bl3 = object2.hasNext()) {
                object3 = (KVPair)object2.next();
                object4 = ((KVPair)object3).name;
                object3 = (String)((KVPair)object3).value;
                ((URLConnection)object).setRequestProperty((String)object4, (String)object3);
            }
        }
        bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl2);
        ((URLConnection)object).connect();
        object2 = ((URLConnection)object).getOutputStream();
        object3 = new FilePart();
        ((HTTPPart)object3).setOnReadListener(onReadListener);
        objectArray = (String)objectArray.value;
        ((FilePart)object3).setFile((String)objectArray);
        ((HTTPPart)object3).setOffset(l10);
        objectArray = ((HTTPPart)object3).toInputStream();
        int n11 = 65536;
        byte[] byArray = new byte[n11];
        int n12 = objectArray.read(byArray);
        while (n12 > 0) {
            ((OutputStream)object2).write(byArray, 0, n12);
            n12 = objectArray.read(byArray);
        }
        ((OutputStream)object2).flush();
        objectArray.close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object2 = new HttpConnectionImpl23((HttpURLConnection)object);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object2);
            ((HttpURLConnection)object).disconnect();
        } else {
            ((HttpURLConnection)object).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l12 = System.currentTimeMillis() - l11;
        ((StringBuilder)object2).append(l12);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public String httpPost(String string2, ArrayList arrayList, int n10, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        HashMap hashMap = new HashMap();
        NetworkHelper$5 networkHelper$5 = new NetworkHelper$5(this, hashMap);
        this.httpPost(string2, arrayList, n10, networkHelper$5, networkHelper$NetworkTimeOut);
        return (String)hashMap.get("resp");
    }

    public String httpPost(String string2, ArrayList arrayList, KVPair kVPair, ArrayList arrayList2, int n10, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        String string3;
        boolean bl2;
        Object object;
        ArrayList<KVPair> arrayList3 = new ArrayList<KVPair>();
        if (kVPair != null && (object = kVPair.value) != null && (bl2 = ((File)(object = new File(string3 = (String)kVPair.value))).exists())) {
            arrayList3.add(kVPair);
        }
        object = this;
        string3 = string2;
        return this.httpPostFiles(string2, arrayList, arrayList3, arrayList2, n10, networkHelper$NetworkTimeOut);
    }

    public String httpPost(String string2, ArrayList arrayList, KVPair kVPair, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        return this.httpPost(string2, arrayList, kVPair, arrayList2, 0, networkHelper$NetworkTimeOut);
    }

    public void httpPost(String object, ArrayList object2, int n10, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object3) {
        long l10 = System.currentTimeMillis();
        Object[] objectArray = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        objectArray.i(charSequence, objectArray2);
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object3);
        n10 = 1;
        ((URLConnection)object).setDoOutput(n10 != 0);
        objectArray = "Connection";
        object3 = "Keep-Alive";
        ((URLConnection)object).setRequestProperty((String)objectArray, (String)object3);
        if (object2 != null) {
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                objectArray = (KVPair)object2.next();
                object3 = objectArray.name;
                objectArray = (String)objectArray.value;
                ((URLConnection)object).setRequestProperty((String)object3, (String)objectArray);
            }
        }
        object2 = new StringPart();
        ((StringPart)object2).append(null);
        n10 = (int)(this.instanceFollowRedirects ? 1 : 0);
        ((HttpURLConnection)object).setInstanceFollowRedirects(n10 != 0);
        ((URLConnection)object).connect();
        objectArray = ((URLConnection)object).getOutputStream();
        object2 = ((HTTPPart)object2).toInputStream();
        int n11 = 65536;
        object3 = new byte[n11];
        int n12 = ((InputStream)object2).read((byte[])object3);
        while (n12 > 0) {
            objectArray.write((byte[])object3, 0, n12);
            n12 = ((InputStream)object2).read((byte[])object3);
        }
        objectArray.flush();
        ((InputStream)object2).close();
        objectArray.close();
        if (httpResponseCallback != null) {
            try {
                object2 = new HttpConnectionImpl23((HttpURLConnection)object);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object2);
            ((HttpURLConnection)object).disconnect();
        } else {
            ((HttpURLConnection)object).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public void httpPost(String object, ArrayList object2, ArrayList objectArray, ArrayList object3, int n10, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object4) {
        int n11;
        long l10 = System.currentTimeMillis();
        Object object5 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object5).i(charSequence, objectArray2);
        object4 = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object4);
        int n12 = 1;
        ((URLConnection)object4).setDoOutput(n12 != 0);
        object5 = "Connection";
        charSequence = "Keep-Alive";
        ((URLConnection)object4).setRequestProperty((String)object5, (String)charSequence);
        if (objectArray != null && (n12 = objectArray.size()) > 0) {
            object = this.getFilePostHTTPPart((HttpURLConnection)object4, (String)object, (ArrayList)object2, (ArrayList)objectArray);
            if (n10 >= 0) {
                ((HttpURLConnection)object4).setChunkedStreamingMode(n10);
            }
        } else {
            object = this.getTextPostHTTPPart((HttpURLConnection)object4, (String)object, (ArrayList)object2);
            long l11 = ((HTTPPart)object).length();
            int bl2 = (int)l11;
            ((HttpURLConnection)object4).setFixedLengthStreamingMode(bl2);
        }
        if (object3 != null) {
            object2 = ((ArrayList)object3).iterator();
            while ((n11 = object2.hasNext()) != 0) {
                objectArray = (KVPair)object2.next();
                object3 = objectArray.name;
                objectArray = (String)objectArray.value;
                ((URLConnection)object4).setRequestProperty((String)object3, (String)objectArray);
            }
        }
        boolean bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object4).setInstanceFollowRedirects(bl2);
        ((URLConnection)object4).connect();
        object2 = ((URLConnection)object4).getOutputStream();
        object = ((HTTPPart)object).toInputStream();
        n11 = 65536;
        objectArray = new byte[n11];
        int n13 = ((InputStream)object).read((byte[])objectArray);
        while (n13 > 0) {
            ((OutputStream)object2).write((byte[])objectArray, 0, n13);
            n13 = ((InputStream)object).read((byte[])objectArray);
        }
        ((OutputStream)object2).flush();
        ((InputStream)object).close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object = new HttpConnectionImpl23((HttpURLConnection)object4);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object4).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object);
            ((HttpURLConnection)object4).disconnect();
        } else {
            ((HttpURLConnection)object4).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public void httpPost(String string2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        this.httpPost(string2, arrayList, arrayList2, arrayList3, 0, httpResponseCallback, networkHelper$NetworkTimeOut);
    }

    public void httpPost(String object, ArrayList object2, byte[] object3, ArrayList object4, int n10, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object5) {
        int n11;
        long l10 = System.currentTimeMillis();
        Object object6 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        ((NLog)object6).i(charSequence, objectArray);
        object5 = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object5);
        int n12 = 1;
        ((URLConnection)object5).setDoOutput(n12 != 0);
        object6 = "Connection";
        charSequence = "Keep-Alive";
        ((URLConnection)object5).setRequestProperty((String)object6, (String)charSequence);
        if (object3 != null && (n12 = ((Object)object3).length) > 0) {
            object = this.getDataPostHttpPart((HttpURLConnection)object5, (String)object, (byte[])object3);
            if (n10 >= 0) {
                ((HttpURLConnection)object5).setChunkedStreamingMode(n10);
            }
        } else {
            object = this.getTextPostHTTPPart((HttpURLConnection)object5, (String)object, (ArrayList)object2);
            long l11 = ((HTTPPart)object).length();
            int bl2 = (int)l11;
            ((HttpURLConnection)object5).setFixedLengthStreamingMode(bl2);
        }
        if (object4 != null) {
            object2 = ((ArrayList)object4).iterator();
            while ((n11 = object2.hasNext()) != 0) {
                object3 = (KVPair)object2.next();
                object4 = object3.name;
                object3 = (String)object3.value;
                ((URLConnection)object5).setRequestProperty((String)object4, (String)object3);
            }
        }
        boolean bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object5).setInstanceFollowRedirects(bl2);
        ((URLConnection)object5).connect();
        object2 = ((URLConnection)object5).getOutputStream();
        object = ((HTTPPart)object).toInputStream();
        n11 = 65536;
        object3 = new byte[n11];
        int n13 = ((InputStream)object).read((byte[])object3);
        while (n13 > 0) {
            ((OutputStream)object2).write((byte[])object3, 0, n13);
            n13 = ((InputStream)object).read((byte[])object3);
        }
        ((OutputStream)object2).flush();
        ((InputStream)object).close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object = new HttpConnectionImpl23((HttpURLConnection)object5);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object5).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object);
            ((HttpURLConnection)object5).disconnect();
        } else {
            ((HttpURLConnection)object5).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        object3 = new Object[0];
        ((NLog)object).i(object2, object3);
    }

    public String httpPostFiles(String string2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int n10, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        HashMap hashMap = new HashMap();
        NetworkHelper$3 networkHelper$3 = new NetworkHelper$3(this, hashMap);
        this.httpPost(string2, arrayList, arrayList2, arrayList3, n10, (HttpResponseCallback)networkHelper$3, networkHelper$NetworkTimeOut);
        return (String)hashMap.get("resp");
    }

    public String httpPostFiles(String string2, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        return this.httpPostFiles(string2, arrayList, arrayList2, arrayList3, 0, networkHelper$NetworkTimeOut);
    }

    public String httpPostFilesChecked(String string2, ArrayList arrayList, byte[] byArray, ArrayList arrayList2, int n10, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        HashMap hashMap = new HashMap();
        NetworkHelper$4 networkHelper$4 = new NetworkHelper$4(this, hashMap);
        this.httpPost(string2, arrayList, byArray, arrayList2, n10, (HttpResponseCallback)networkHelper$4, networkHelper$NetworkTimeOut);
        return (String)hashMap.get("resp");
    }

    public String httpPut(String string2, ArrayList arrayList, KVPair kVPair, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        return this.httpPut(string2, arrayList, kVPair, arrayList2, networkHelper$NetworkTimeOut, null);
    }

    public String httpPut(String object, ArrayList object2, KVPair object3, ArrayList objectArray, NetworkHelper$NetworkTimeOut object4, OnReadListener object5) {
        int n10;
        long l10 = System.currentTimeMillis();
        Object object6 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("httpPut: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object6).i(charSequence, objectArray2);
        if (object2 != null && (n10 = ((String)(object2 = this.kvPairsToUrl((ArrayList)object2))).length()) > 0) {
            object6 = new StringBuilder();
            ((StringBuilder)object6).append((String)object);
            ((StringBuilder)object6).append("?");
            ((StringBuilder)object6).append((String)object2);
            object = ((StringBuilder)object6).toString();
        }
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object4);
        int n11 = 1;
        ((URLConnection)object).setDoOutput(n11 != 0);
        ((HttpURLConnection)object).setChunkedStreamingMode(0);
        ((HttpURLConnection)object).setRequestMethod("PUT");
        object2 = "Content-Type";
        object4 = "application/octet-stream";
        ((URLConnection)object).setRequestProperty((String)object2, (String)object4);
        if (objectArray != null) {
            boolean c10;
            object2 = objectArray.iterator();
            while (c10 = object2.hasNext()) {
                objectArray = (KVPair)object2.next();
                object4 = objectArray.name;
                objectArray = (String)objectArray.value;
                ((URLConnection)object).setRequestProperty((String)object4, (String)objectArray);
            }
        }
        n11 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(n11 != 0);
        ((URLConnection)object).connect();
        object2 = ((URLConnection)object).getOutputStream();
        objectArray = new FilePart();
        if (object5 != null) {
            objectArray.setOnReadListener((OnReadListener)object5);
        }
        object3 = (String)((KVPair)object3).value;
        objectArray.setFile((String)object3);
        object3 = objectArray.toInputStream();
        int n12 = 65536;
        objectArray = new byte[n12];
        int n13 = ((InputStream)object3).read((byte[])objectArray);
        while (n13 > 0) {
            ((OutputStream)object2).write((byte[])objectArray, 0, n13);
            n13 = ((InputStream)object3).read((byte[])objectArray);
        }
        ((OutputStream)object2).flush();
        ((InputStream)object3).close();
        ((OutputStream)object2).close();
        n11 = ((HttpURLConnection)object).getResponseCode();
        int n14 = 200;
        char c10 = '\n';
        object4 = "utf-8";
        if (n11 != n14 && n11 != (n14 = 201)) {
            object3 = new StringBuilder();
            object = ((HttpURLConnection)object).getErrorStream();
            object4 = Charset.forName((String)object4);
            object5 = new InputStreamReader((InputStream)object, (Charset)object4);
            object = new BufferedReader((Reader)object5);
            object4 = ((BufferedReader)object).readLine();
            while (object4 != null) {
                int n15 = ((StringBuilder)object3).length();
                if (n15 > 0) {
                    ((StringBuilder)object3).append(c10);
                }
                ((StringBuilder)object3).append((String)object4);
                object4 = ((BufferedReader)object).readLine();
            }
            ((BufferedReader)object).close();
            object = new HashMap();
            object3 = ((StringBuilder)object3).toString();
            ((HashMap)object).put("error", object3);
            object2 = n11;
            ((HashMap)object).put("status", object2);
            object3 = new Hashon();
            object = ((Hashon)object3).fromHashMap((HashMap)object);
            object2 = new Throwable((String)object);
            throw object2;
        }
        object2 = new StringBuilder();
        object5 = ((URLConnection)object).getInputStream();
        object4 = Charset.forName((String)object4);
        object3 = new InputStreamReader((InputStream)object5, (Charset)object4);
        object4 = new BufferedReader((Reader)object3);
        object3 = ((BufferedReader)object4).readLine();
        while (object3 != null) {
            int n16 = ((StringBuilder)object2).length();
            if (n16 > 0) {
                ((StringBuilder)object2).append(c10);
            }
            ((StringBuilder)object2).append((String)object3);
            object3 = ((BufferedReader)object4).readLine();
        }
        ((BufferedReader)object4).close();
        ((HttpURLConnection)object).disconnect();
        object = ((StringBuilder)object2).toString();
        object2 = MobLog.getInstance();
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object3).append(l11);
        object3 = ((StringBuilder)object3).toString();
        objectArray = new Object[]{};
        ((NLog)object2).i(object3, objectArray);
        return object;
    }

    public String jsonPost(String string2, ArrayList arrayList, ArrayList arrayList2, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        HashMap hashMap = new HashMap();
        NetworkHelper$2 networkHelper$2 = new NetworkHelper$2(this, hashMap);
        this.jsonPost(string2, arrayList, arrayList2, networkHelper$NetworkTimeOut, (HttpResponseCallback)networkHelper$2);
        string2 = "res";
        boolean bl2 = hashMap.containsKey(string2);
        string2 = bl2 ? (String)hashMap.get(string2) : null;
        return string2;
    }

    public void jsonPost(String string2, ArrayList object, ArrayList arrayList, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut, HttpResponseCallback httpResponseCallback) {
        String string3;
        Object object2;
        boolean bl2;
        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        object = ((ArrayList)object).iterator();
        while (bl2 = object.hasNext()) {
            object2 = (KVPair)object.next();
            string3 = ((KVPair)object2).name;
            object2 = ((KVPair)object2).value;
            hashMap.put(string3, object2);
        }
        object2 = this;
        string3 = string2;
        this.jsonPost(string2, hashMap, arrayList, networkHelper$NetworkTimeOut, httpResponseCallback);
    }

    public void jsonPost(String object, HashMap object2, ArrayList objectArray, NetworkHelper$NetworkTimeOut object3, HttpResponseCallback httpResponseCallback) {
        long l10 = System.currentTimeMillis();
        Object object4 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("jsonPost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object4).i(charSequence, objectArray2);
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object3);
        int n10 = 1;
        ((URLConnection)object).setDoOutput(n10 != 0);
        ((HttpURLConnection)object).setChunkedStreamingMode(0);
        object3 = "content-type";
        object4 = "application/json";
        ((URLConnection)object).setRequestProperty((String)object3, (String)object4);
        if (objectArray != null) {
            objectArray = objectArray.iterator();
            while ((n10 = objectArray.hasNext()) != 0) {
                object3 = (KVPair)objectArray.next();
                object4 = ((KVPair)object3).name;
                object3 = (String)((KVPair)object3).value;
                ((URLConnection)object).setRequestProperty((String)object4, (String)object3);
            }
        }
        objectArray = new StringPart();
        if (object2 != null) {
            object3 = new Hashon();
            object2 = ((Hashon)object3).fromHashMap((HashMap)object2);
            objectArray.append((String)object2);
        }
        boolean bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl2);
        ((URLConnection)object).connect();
        object2 = ((URLConnection)object).getOutputStream();
        objectArray = objectArray.toInputStream();
        n10 = 65536;
        object3 = new byte[n10];
        int n11 = objectArray.read((byte[])object3);
        while (n11 > 0) {
            ((OutputStream)object2).write((byte[])object3, 0, n11);
            n11 = objectArray.read((byte[])object3);
        }
        ((OutputStream)object2).flush();
        objectArray.close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object2 = new HttpConnectionImpl23((HttpURLConnection)object);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object2);
            ((HttpURLConnection)object).disconnect();
        } else {
            ((HttpURLConnection)object).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public void rawGet(String string2, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        this.rawGet(string2, null, httpResponseCallback, networkHelper$NetworkTimeOut);
    }

    public void rawGet(String string2, RawNetworkCallback rawNetworkCallback, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        this.rawGet(string2, null, rawNetworkCallback, networkHelper$NetworkTimeOut);
    }

    public void rawGet(String object, ArrayList object2, HttpResponseCallback objectArray, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        int n10;
        long l10 = System.currentTimeMillis();
        Object object3 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("rawGet: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        ((NLog)object3).i(charSequence, objectArray2);
        object = this.getConnection((String)object, networkHelper$NetworkTimeOut);
        if (object2 != null) {
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object3 = (KVPair)object2.next();
                charSequence = ((KVPair)object3).name;
                object3 = (String)((KVPair)object3).value;
                ((URLConnection)object).setRequestProperty((String)charSequence, (String)object3);
            }
        }
        int n11 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(n11 != 0);
        ((URLConnection)object).connect();
        n11 = ((HttpURLConnection)object).getResponseCode();
        n10 = 301;
        if (n11 == n10) {
            object = ((URLConnection)object).getHeaderField("Location");
            n11 = 0;
            object2 = null;
            this.rawGet((String)object, null, (HttpResponseCallback)objectArray, networkHelper$NetworkTimeOut);
        } else if (objectArray != null) {
            try {
                object2 = new HttpConnectionImpl23((HttpURLConnection)object);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object).disconnect();
                    throw throwable2;
                }
            }
            objectArray.onResponse((HttpConnection)object2);
            ((HttpURLConnection)object).disconnect();
        } else {
            ((HttpURLConnection)object).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public void rawGet(String object, ArrayList object2, RawNetworkCallback object3, NetworkHelper$NetworkTimeOut object4) {
        int n10;
        long l10 = System.currentTimeMillis();
        Object object5 = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("rawGet: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        ((NLog)object5).i(charSequence, objectArray);
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object4);
        if (object2 != null) {
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = object2.hasNext()) != 0) {
                object4 = (KVPair)object2.next();
                object5 = ((KVPair)object4).name;
                object4 = (String)((KVPair)object4).value;
                ((URLConnection)object).setRequestProperty((String)object5, (String)object4);
            }
        }
        int n11 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(n11 != 0);
        ((URLConnection)object).connect();
        n11 = ((HttpURLConnection)object).getResponseCode();
        n10 = 200;
        if (n11 == n10) {
            if (object3 != null) {
                object2 = ((URLConnection)object).getInputStream();
                object3.onResponse((InputStream)object2);
            }
            ((HttpURLConnection)object).disconnect();
            object = MobLog.getInstance();
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("use time: ");
            long l11 = System.currentTimeMillis() - l10;
            ((StringBuilder)object2).append(l11);
            object2 = ((StringBuilder)object2).toString();
            object3 = new Object[]{};
            ((NLog)object).i(object2, (Object[])object3);
            return;
        }
        object3 = new StringBuilder();
        Closeable closeable = ((HttpURLConnection)object).getErrorStream();
        Charset charset = Charset.forName("utf-8");
        object4 = new InputStreamReader((InputStream)closeable, charset);
        closeable = new BufferedReader((Reader)object4);
        object4 = ((BufferedReader)closeable).readLine();
        while (object4 != null) {
            int n12 = ((StringBuilder)object3).length();
            if (n12 > 0) {
                n12 = 10;
                ((StringBuilder)object3).append((char)n12);
            }
            ((StringBuilder)object3).append((String)object4);
            object4 = ((BufferedReader)closeable).readLine();
        }
        ((BufferedReader)closeable).close();
        ((HttpURLConnection)object).disconnect();
        object = new HashMap();
        object3 = ((StringBuilder)object3).toString();
        ((HashMap)object).put("error", object3);
        object2 = n11;
        ((HashMap)object).put("status", object2);
        object3 = new Hashon();
        object = ((Hashon)object3).fromHashMap((HashMap)object);
        object2 = new Throwable((String)object);
        throw object2;
    }

    public void rawPost(String object, ArrayList object2, HTTPPart objectArray, int n10, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut object3) {
        Object object4;
        long l10 = System.currentTimeMillis();
        NLog nLog = MobLog.getInstance();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("rawpost: ");
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Object[] objectArray2 = new Object[]{};
        nLog.i(charSequence, objectArray2);
        object = this.getConnection((String)object, (NetworkHelper$NetworkTimeOut)object3);
        int n11 = 1;
        ((URLConnection)object).setDoOutput(n11 != 0);
        if (n10 >= 0) {
            ((HttpURLConnection)object).setChunkedStreamingMode(0);
        }
        if (object2 != null) {
            object2 = ((ArrayList)object2).iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object4 = (KVPair)object2.next();
                object3 = ((KVPair)object4).name;
                object4 = (String)((KVPair)object4).value;
                ((URLConnection)object).setRequestProperty((String)object3, (String)object4);
            }
        }
        boolean bl2 = this.instanceFollowRedirects;
        ((HttpURLConnection)object).setInstanceFollowRedirects(bl2);
        ((URLConnection)object).connect();
        object2 = ((URLConnection)object).getOutputStream();
        objectArray = objectArray.toInputStream();
        n10 = 65536;
        object4 = new byte[n10];
        n11 = objectArray.read((byte[])object4);
        while (n11 > 0) {
            ((OutputStream)object2).write((byte[])object4, 0, n11);
            n11 = objectArray.read((byte[])object4);
        }
        ((OutputStream)object2).flush();
        objectArray.close();
        ((OutputStream)object2).close();
        if (httpResponseCallback != null) {
            try {
                object2 = new HttpConnectionImpl23((HttpURLConnection)object);
            }
            catch (Throwable throwable) {
                try {
                    throw throwable;
                }
                catch (Throwable throwable2) {
                    ((HttpURLConnection)object).disconnect();
                    throw throwable2;
                }
            }
            httpResponseCallback.onResponse((HttpConnection)object2);
            ((HttpURLConnection)object).disconnect();
        } else {
            ((HttpURLConnection)object).disconnect();
        }
        object = MobLog.getInstance();
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("use time: ");
        long l11 = System.currentTimeMillis() - l10;
        ((StringBuilder)object2).append(l11);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        ((NLog)object).i(object2, objectArray);
    }

    public void rawPost(String string2, ArrayList arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkHelper$NetworkTimeOut networkHelper$NetworkTimeOut) {
        this.rawPost(string2, arrayList, hTTPPart, 0, httpResponseCallback, networkHelper$NetworkTimeOut);
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void rawPost(String var1_1, ArrayList var2_2, HTTPPart var3_3, RawNetworkCallback var4_6, NetworkHelper$NetworkTimeOut var5_7) {
        var6_8 = System.currentTimeMillis();
        var8_9 = MobLog.getInstance();
        var9_10 /* !! */  = new StringBuilder();
        var9_10 /* !! */ .append("rawpost: ");
        var9_10 /* !! */ .append((String)var1_1);
        var9_10 /* !! */  = var9_10 /* !! */ .toString();
        var10_11 = new Object[]{};
        var8_9.i(var9_10 /* !! */ , var10_11);
        var1_1 = this.getConnection((String)var1_1, (NetworkHelper$NetworkTimeOut)var5_7);
        var11_12 = 1;
        var1_1.setDoOutput((boolean)var11_12);
        var1_1.setChunkedStreamingMode(0);
        if (var2_2 != null) {
            var2_2 = var2_2.iterator();
            while ((var11_12 = var2_2.hasNext()) != 0) {
                var5_7 = (KVPair)var2_2.next();
                var8_9 = var5_7.name;
                var5_7 = (String)var5_7.value;
                var1_1.setRequestProperty((String)var8_9, (String)var5_7);
            }
        }
        var12_13 = this.instanceFollowRedirects;
        var1_1.setInstanceFollowRedirects((boolean)var12_13);
        var1_1.connect();
        var2_2 = var1_1.getOutputStream();
        var3_3 = var3_3.toInputStream();
        var11_12 = 65536;
        var5_7 = new byte[var11_12];
        var13_14 = var3_3.read((byte[])var5_7);
        while (var13_14 > 0) {
            var2_2.write((byte[])var5_7, 0, var13_14);
            var13_14 = var3_3.read((byte[])var5_7);
        }
        var2_2.flush();
        var3_3.close();
        var2_2.close();
        var12_13 = var1_1.getResponseCode();
        var14_15 = 200;
        if (var12_13 != var14_15) ** GOTO lbl60
        if (var4_6 == null) ** GOTO lbl58
        var2_2 = var1_1.getInputStream();
        var4_6.onResponse((InputStream)var2_2);
        if (var2_2 == null) ** GOTO lbl91
        var2_2.close();
        ** GOTO lbl91
        catch (Throwable var3_4) {
            try {
                throw var3_4;
            }
            catch (Throwable var3_5) {
                block14: {
                    block15: {
                        if (var2_2 == null) break block14;
                        try {
                            var2_2.close();
                            break block14;
                        }
                        catch (Throwable v1) {}
lbl58:
                        // 1 sources

                        var1_1.disconnect();
                        break block15;
lbl60:
                        // 1 sources

                        var3_3 = new StringBuilder();
                        var5_7 = var1_1.getErrorStream();
                        var17_17 = Charset.forName("utf-8");
                        var4_6 = new InputStreamReader((InputStream)var5_7, var17_17);
                        var5_7 = new BufferedReader((Reader)var4_6);
                        var4_6 = var5_7.readLine();
                        while (true) {
                            if (var4_6 == null) {
                                var5_7.close();
                                var1_1.disconnect();
                                var1_1 = new HashMap();
                                var3_3 = var3_3.toString();
                                var1_1.put("error", var3_3);
                                var2_2 = var12_13;
                                var1_1.put("status", var2_2);
                                var3_3 = new Hashon();
                                var1_1 = var3_3.fromHashMap((HashMap)var1_1);
                                var2_2 = new Throwable((String)var1_1);
                                throw var2_2;
                            }
                            var18_18 = var3_3.length();
                            if (var18_18 > 0) {
                                var18_18 = 10;
                                var3_3.append((char)var18_18);
                            }
                            var3_3.append((String)var4_6);
                            var4_6 = var5_7.readLine();
                        }
                        catch (Throwable v0) {}
lbl91:
                        // 3 sources

                        var1_1.disconnect();
                    }
                    var1_1 = MobLog.getInstance();
                    var2_2 = new StringBuilder();
                    var2_2.append("use time: ");
                    var15_16 = System.currentTimeMillis() - var6_8;
                    var2_2.append(var15_16);
                    var2_2 = var2_2.toString();
                    var3_3 = new Object[]{};
                    var1_1.i(var2_2, (Object[])var3_3);
                    return;
                }
                var1_1.disconnect();
                throw var3_5;
            }
        }
    }

    public void setInstanceFollowRedirects(boolean bl2) {
        this.instanceFollowRedirects = bl2;
    }
}

