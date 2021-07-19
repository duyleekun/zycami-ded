/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.hatool.a0$a;
import com.huawei.hms.hatool.b;
import com.huawei.hms.hatool.b0;
import com.huawei.hms.hatool.r0;
import com.huawei.hms.hatool.y;
import d.j.f.a.a.j.g;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;

public abstract class a0 {
    public static b0 a(String string2, byte[] byArray, Map map) {
        return a0.a(string2, byArray, map, "POST");
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b0 a(String object, byte[] object2, Map object3, String object4) {
        Object object5;
        int n10;
        String string2;
        String string3;
        block61: {
            int n11;
            block67: {
                block66: {
                    block65: {
                        block64: {
                            block63: {
                                block62: {
                                    void var1_6;
                                    block60: {
                                        block59: {
                                            block58: {
                                                block57: {
                                                    block56: {
                                                        block55: {
                                                            block54: {
                                                                block53: {
                                                                    string3 = "hmsSdk";
                                                                    n11 = TextUtils.isEmpty((CharSequence)object);
                                                                    string2 = "";
                                                                    if (n11 != 0) {
                                                                        return new b0(-100, string2);
                                                                    }
                                                                    n11 = -102;
                                                                    n10 = -101;
                                                                    object5 = null;
                                                                    int n12 = ((byte[])object2).length;
                                                                    object = a0.a((String)object, n12, (Map)object3, (String)object4);
                                                                    if (object != null) break block53;
                                                                    object2 = new b0;
                                                                    object2(n10, string2);
                                                                    r0.a(null);
                                                                    r0.a(null);
                                                                    if (object == null) return object2;
                                                                    r0.a((HttpURLConnection)object);
                                                                    return object2;
                                                                }
                                                                object3 = ((URLConnection)object).getOutputStream();
                                                                object4 = new BufferedOutputStream((OutputStream)object3);
                                                                try {
                                                                    ((FilterOutputStream)object4).write((byte[])object2);
                                                                    ((BufferedOutputStream)object4).flush();
                                                                    int n13 = ((HttpURLConnection)object).getResponseCode();
                                                                    try {
                                                                        String string4 = a0.b((HttpURLConnection)object);
                                                                        object5 = new b0(n13, string4);
                                                                    }
                                                                    catch (IOException iOException) {
                                                                        n11 = n13;
                                                                        break block54;
                                                                    }
                                                                    catch (UnknownHostException unknownHostException) {
                                                                        n11 = n13;
                                                                        break block55;
                                                                    }
                                                                    catch (ConnectException connectException) {
                                                                        n11 = n13;
                                                                        break block56;
                                                                    }
                                                                    catch (SSLHandshakeException sSLHandshakeException) {
                                                                        n11 = n13;
                                                                        break block57;
                                                                    }
                                                                    catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                                                                        n11 = n13;
                                                                        break block58;
                                                                    }
                                                                    catch (SecurityException securityException) {
                                                                        n11 = n13;
                                                                        break block59;
                                                                    }
                                                                    r0.a((Closeable)object4);
                                                                    r0.a((Closeable)object3);
                                                                    if (object == null) return object5;
                                                                    r0.a((HttpURLConnection)object);
                                                                    return object5;
                                                                }
                                                                catch (Throwable throwable) {
                                                                    object5 = object4;
                                                                    break block60;
                                                                }
                                                                catch (IOException iOException) {}
                                                            }
                                                            object5 = object4;
                                                            break block62;
                                                            catch (UnknownHostException unknownHostException) {}
                                                        }
                                                        object5 = object4;
                                                        break block63;
                                                        catch (ConnectException connectException) {}
                                                    }
                                                    object5 = object4;
                                                    break block64;
                                                    catch (SSLHandshakeException sSLHandshakeException) {}
                                                }
                                                object5 = object4;
                                                break block65;
                                                catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {}
                                            }
                                            object5 = object4;
                                            break block66;
                                            catch (SecurityException securityException) {}
                                        }
                                        object5 = object4;
                                        break block67;
                                        catch (a0$a a0$a) {
                                            object5 = object4;
                                            break block61;
                                        }
                                        catch (Throwable throwable) {
                                            object3 = null;
                                            break block60;
                                        }
                                        catch (IOException iOException) {
                                            object3 = null;
                                            break block62;
                                        }
                                        catch (UnknownHostException unknownHostException) {
                                            object3 = null;
                                            break block63;
                                        }
                                        catch (ConnectException connectException) {
                                            object3 = null;
                                            break block64;
                                        }
                                        catch (SSLHandshakeException sSLHandshakeException) {
                                            object3 = null;
                                            break block65;
                                        }
                                        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                                            object3 = null;
                                            break block66;
                                        }
                                        catch (SecurityException securityException) {
                                            object3 = null;
                                            break block67;
                                        }
                                        catch (a0$a a0$a) {
                                            object3 = null;
                                            break block61;
                                        }
                                        catch (Throwable throwable) {
                                            object = null;
                                            object3 = null;
                                            break block60;
                                        }
                                        catch (IOException iOException) {
                                            object = null;
                                            object3 = null;
                                            break block62;
                                        }
                                        catch (UnknownHostException unknownHostException) {
                                            object = null;
                                            object3 = null;
                                            break block63;
                                        }
                                        catch (ConnectException connectException) {
                                            object = null;
                                            object3 = null;
                                            break block64;
                                        }
                                        catch (SSLHandshakeException sSLHandshakeException) {
                                            object = null;
                                            object3 = null;
                                            break block65;
                                        }
                                        catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {
                                            object = null;
                                            object3 = null;
                                            break block66;
                                        }
                                        catch (SecurityException securityException) {
                                            object = null;
                                            object3 = null;
                                            break block67;
                                        }
                                        catch (a0$a a0$a) {
                                            object = null;
                                            object3 = null;
                                            break block61;
                                        }
                                        catch (Throwable throwable) {}
                                    }
                                    r0.a(object5);
                                    r0.a((Closeable)object3);
                                    if (object == null) throw var1_6;
                                    r0.a((HttpURLConnection)object);
                                    throw var1_6;
                                    catch (IOException iOException) {}
                                }
                                object2 = "events PostRequest(byte[]): IOException occurred.";
                                {
                                    y.f(string3, (String)object2);
                                    object2 = new b0;
                                    object2(n11, string2);
                                }
                                r0.a(object5);
                                r0.a((Closeable)object3);
                                if (object == null) return object2;
                                r0.a((HttpURLConnection)object);
                                return object2;
                                catch (UnknownHostException unknownHostException) {}
                            }
                            object2 = "No address associated with hostname or No network";
                            {
                                y.f(string3, (String)object2);
                                object2 = new b0;
                                object2(n11, string2);
                            }
                            r0.a(object5);
                            r0.a((Closeable)object3);
                            if (object == null) return object2;
                            r0.a((HttpURLConnection)object);
                            return object2;
                            catch (ConnectException connectException) {}
                        }
                        object2 = "Network is unreachable or Connection refused";
                        {
                            y.f(string3, (String)object2);
                            object2 = new b0;
                            object2(n11, string2);
                        }
                        r0.a(object5);
                        r0.a((Closeable)object3);
                        if (object == null) return object2;
                        r0.a((HttpURLConnection)object);
                        return object2;
                        catch (SSLHandshakeException sSLHandshakeException) {}
                    }
                    object2 = "Chain validation failed,Certificate expired";
                    {
                        y.f(string3, (String)object2);
                        object2 = new b0;
                        object2(n11, string2);
                    }
                    r0.a(object5);
                    r0.a((Closeable)object3);
                    if (object == null) return object2;
                    r0.a((HttpURLConnection)object);
                    return object2;
                    catch (SSLPeerUnverifiedException sSLPeerUnverifiedException) {}
                }
                object2 = "Certificate has not been verified,Request is restricted!";
                {
                    y.f(string3, (String)object2);
                    object2 = new b0;
                    object2(n11, string2);
                }
                r0.a(object5);
                r0.a((Closeable)object3);
                if (object == null) return object2;
                r0.a((HttpURLConnection)object);
                return object2;
                catch (SecurityException securityException) {}
            }
            object2 = "SecurityException with HttpClient. Please check INTERNET permission.";
            {
                y.f(string3, (String)object2);
                object2 = new b0;
                object2(n11, string2);
            }
            r0.a(object5);
            r0.a((Closeable)object3);
            if (object == null) return object2;
            r0.a((HttpURLConnection)object);
            return object2;
            catch (a0$a a0$a) {}
        }
        object2 = "PostRequest(byte[]): No ssl socket factory set!";
        {
            y.f(string3, (String)object2);
            object2 = new b0;
            object2(n10, string2);
        }
        r0.a(object5);
        r0.a((Closeable)object3);
        if (object == null) return object2;
        r0.a((HttpURLConnection)object);
        return object2;
    }

    public static HttpURLConnection a(String object, int n10, Map object2, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            y.b("hmsSdk", "CreateConnection: invalid urlPath.");
            return null;
        }
        Object object3 = new URL((String)object);
        object = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object3).openConnection()));
        a0.a((HttpURLConnection)object);
        ((HttpURLConnection)object).setRequestMethod(string2);
        int n11 = 15000;
        ((URLConnection)object).setConnectTimeout(n11);
        ((URLConnection)object).setReadTimeout(n11);
        n11 = 1;
        ((URLConnection)object).setDoOutput(n11 != 0);
        String string3 = "application/json; charset=UTF-8";
        ((URLConnection)object).setRequestProperty("Content-Type", string3);
        Object object4 = String.valueOf(n10);
        ((URLConnection)object).setRequestProperty("Content-Length", (String)object4);
        object4 = "Connection";
        object3 = "close";
        ((URLConnection)object).setRequestProperty((String)object4, (String)object3);
        if (object2 != null && (n10 = object2.size()) >= n11) {
            boolean bl3;
            object4 = object2.entrySet().iterator();
            while (bl3 = object4.hasNext()) {
                object2 = (Map.Entry)object4.next();
                string2 = (String)object2.getKey();
                if (string2 == null || (bl2 = TextUtils.isEmpty((CharSequence)string2))) continue;
                object2 = (String)object2.getValue();
                ((URLConnection)object).setRequestProperty(string2, (String)object2);
            }
        }
        return object;
    }

    public static void a(HttpURLConnection object) {
        Object object2 = "hmsSdk";
        boolean bl2 = object instanceof HttpsURLConnection;
        if (bl2) {
            g g10;
            block10: {
                object = (HttpsURLConnection)object;
                bl2 = false;
                g10 = null;
                Object object3 = b.f();
                try {
                    g10 = g.f(object3);
                    break block10;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object3 = "getSocketFactory(): Illegal Access Exception ";
                }
                catch (IOException iOException) {
                    object3 = "getSocketFactory(): IO Exception!";
                }
                catch (GeneralSecurityException generalSecurityException) {
                    object3 = "getSocketFactory(): General Security Exception";
                }
                catch (KeyStoreException keyStoreException) {
                    object3 = "getSocketFactory(): Key Store exception";
                }
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                    object3 = "getSocketFactory(): Algorithm Exception!";
                }
                y.f((String)object2, (String)object3);
            }
            if (g10 != null) {
                ((HttpsURLConnection)object).setSSLSocketFactory(g10);
                object2 = new d.j.f.a.a.j.n.b();
                ((HttpsURLConnection)object).setHostnameVerifier((HostnameVerifier)object2);
            } else {
                object = new a0$a("No ssl socket factory set");
                throw object;
            }
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String b(HttpURLConnection object) {
        Throwable throwable2222222;
        InputStream inputStream;
        block4: {
            inputStream = null;
            inputStream = ((URLConnection)object).getInputStream();
            object = r0.a(inputStream);
            {
                catch (Throwable throwable2222222) {
                    break block4;
                }
                catch (IOException iOException) {}
                {
                    int n10 = ((HttpURLConnection)object).getResponseCode();
                    String string2 = "hmsSdk";
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "When Response Content From Connection inputStream operation exception! ";
                    stringBuilder.append(string3);
                    stringBuilder.append(n10);
                    object = stringBuilder.toString();
                    y.f(string2, (String)object);
                }
                r0.a((Closeable)inputStream);
                return "";
            }
            r0.a((Closeable)inputStream);
            return object;
        }
        r0.a((Closeable)inputStream);
        throw throwable2222222;
    }
}

