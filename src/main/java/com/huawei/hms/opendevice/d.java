/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.huawei.hms.opendevice.d$a;
import com.huawei.hms.opendevice.s;
import com.huawei.hms.support.log.HMSLog;
import d.j.f.a.a.j.g;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.security.GeneralSecurityException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public abstract class d {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String a(Context var0, String var1_2, String var2_4, Map var3_6) {
        block68: {
            block61: {
                block64: {
                    block67: {
                        block60: {
                            block63: {
                                block66: {
                                    block59: {
                                        block62: {
                                            block65: {
                                                block58: {
                                                    block57: {
                                                        block56: {
                                                            var4_8 = "close connection";
                                                            var5_9 = "PushHttpClient";
                                                            var6_10 /* !! */  = null;
                                                            if (var2_4 == null || (var7_11 = TextUtils.isEmpty((CharSequence)var1_2)) != 0 || (var7_11 = TextUtils.isEmpty((CharSequence)var2_4)) != 0) break block68;
                                                            var7_11 = -1;
                                                            var8_12 = d$a.b;
                                                            var8_12 = var8_12.a();
                                                            var0 = d.a((Context)var0, (String)var1_2, (Map)var3_6, (String)var8_12);
                                                            if (var0 != null) break block56;
                                                            d.j.f.a.a.k.d.d(null);
                                                            d.j.f.a.a.k.d.c(null);
                                                            d.j.f.a.a.k.d.c(null);
                                                            s.a((HttpURLConnection)var0);
                                                            HMSLog.i(var5_9, var4_8);
                                                            return null;
                                                        }
                                                        var3_6 = var0.getOutputStream();
                                                        var1_2 = new BufferedOutputStream((OutputStream)var3_6);
                                                        var3_6 = "UTF-8";
                                                        var2_4 = var2_4.getBytes((String)var3_6);
                                                        var1_2.write((byte[])var2_4);
                                                        var1_2.flush();
                                                        var7_11 = var0.getResponseCode();
                                                        var2_4 = new StringBuilder();
                                                        var3_6 = "http post response code: ";
                                                        var2_4.append((String)var3_6);
                                                        var2_4.append(var7_11);
                                                        var2_4 = var2_4.toString();
                                                        HMSLog.d(var5_9, (String)var2_4);
                                                        var9_13 = 400;
                                                        if (var7_11 < var9_13) break block57;
                                                        var2_4 = var0.getErrorStream();
                                                        break block58;
                                                    }
                                                    var2_4 = var0.getInputStream();
                                                }
                                                var3_6 = new BufferedInputStream((InputStream)var2_4);
                                                try {
                                                    var6_10 /* !! */  = s.a((InputStream)var3_6);
                                                }
                                                catch (Exception v12) {
                                                    ** continue;
                                                }
                                                catch (RuntimeException v13) {
                                                    ** continue;
                                                }
                                                catch (IOException v14) {
                                                    ** continue;
                                                }
                                                d.j.f.a.a.k.d.d((OutputStream)var1_2);
                                                d.j.f.a.a.k.d.c((InputStream)var2_4);
                                                d.j.f.a.a.k.d.c((InputStream)var3_6);
                                                s.a((HttpURLConnection)var0);
                                                HMSLog.i(var5_9, var4_8);
                                                return var6_10 /* !! */ ;
                                                catch (Throwable var3_7) {
                                                    var10_19 = null;
                                                    var6_10 /* !! */  = var0;
                                                    var0 = var3_7;
                                                    var3_6 = null;
                                                    ** GOTO lbl196
                                                }
                                                catch (Exception v0) {
                                                    var3_6 = null;
                                                    break block59;
                                                }
                                                catch (RuntimeException v1) {
                                                    var3_6 = null;
                                                    break block60;
                                                }
                                                catch (IOException v2) {
                                                    var3_6 = null;
                                                    break block61;
                                                }
                                                catch (Throwable var2_5) {
                                                    var3_6 = null;
                                                    var6_10 /* !! */  = var0;
                                                    var0 = var2_5;
                                                    var9_13 = 0;
                                                    var2_4 = null;
                                                    ** GOTO lbl196
                                                }
                                                catch (Exception v3) {
                                                    var9_13 = 0;
                                                    var2_4 = null;
                                                    break block62;
                                                }
                                                catch (RuntimeException v4) {
                                                    var9_13 = 0;
                                                    var2_4 = null;
                                                    break block63;
                                                }
                                                catch (IOException v5) {
                                                    var9_13 = 0;
                                                    var2_4 = null;
                                                    break block64;
                                                }
                                                catch (Throwable var1_3) {
                                                    var9_14 = false;
                                                    var2_4 = null;
                                                    var3_6 = null;
                                                    var6_10 /* !! */  = var0;
                                                    var0 = var1_3;
                                                    var1_2 = null;
                                                    ** GOTO lbl196
                                                }
                                                catch (Exception v6) {
                                                    var1_2 = null;
                                                    break block65;
                                                }
                                                catch (RuntimeException v7) {
                                                    var1_2 = null;
                                                    break block66;
                                                }
                                                catch (IOException v8) {
                                                    var1_2 = null;
                                                    break block67;
                                                }
                                                catch (Throwable var0_1) {
                                                    var1_2 = null;
                                                    var9_15 = false;
                                                    var2_4 = null;
                                                    var3_6 = null;
                                                    ** GOTO lbl196
                                                }
                                                catch (Exception v9) {
                                                    var0 = null;
                                                    var1_2 = null;
                                                }
                                            }
                                            var9_16 = false;
                                            var2_4 = null;
                                        }
                                        var3_6 = null;
                                    }
lbl128:
                                    // 2 sources

                                    while (true) {
                                        var8_12 = new StringBuilder();
                                        var11_21 = "http execute encounter unknown exception - http code:";
                                        var8_12.append(var11_21);
                                        var8_12.append(var7_11);
                                        var12_24 = var8_12.toString();
                                        HMSLog.w(var5_9, var12_24);
                                        ** GOTO lbl187
                                        break;
                                    }
                                    catch (RuntimeException v10) {
                                        var0 = null;
                                        var1_2 = null;
                                    }
                                }
                                var9_17 = false;
                                var2_4 = null;
                            }
                            var3_6 = null;
                        }
lbl151:
                        // 2 sources

                        while (true) {
                            var8_12 = new StringBuilder();
                            var11_22 = "http execute encounter RuntimeException - http code:";
                            var8_12.append(var11_22);
                            var8_12.append(var7_11);
                            var12_25 = var8_12.toString();
                            HMSLog.w(var5_9, var12_25);
                            ** GOTO lbl187
                            break;
                        }
                        catch (IOException v11) {
                            var0 = null;
                            var1_2 = null;
                        }
                    }
                    var9_18 = false;
                    var2_4 = null;
                }
                var3_6 = null;
            }
lbl174:
            // 2 sources

            while (true) {
                var8_12 = new StringBuilder();
                var11_23 = "http execute encounter IOException - http code:";
                var8_12.append(var11_23);
                var8_12.append(var7_11);
                var12_26 = var8_12.toString();
                try {
                    HMSLog.w(var5_9, var12_26);
                }
                catch (Throwable var10_20) {
                    var6_10 /* !! */  = var0;
                    var0 = var10_20;
                }
lbl187:
                // 3 sources

                d.j.f.a.a.k.d.d((OutputStream)var1_2);
                d.j.f.a.a.k.d.c((InputStream)var2_4);
                d.j.f.a.a.k.d.c((InputStream)var3_6);
                s.a((HttpURLConnection)var0);
                HMSLog.i(var5_9, var4_8);
                return null;
lbl196:
                // 5 sources

                d.j.f.a.a.k.d.d((OutputStream)var1_2);
                d.j.f.a.a.k.d.c((InputStream)var2_4);
                d.j.f.a.a.k.d.c((InputStream)var3_6);
                s.a((HttpURLConnection)var6_10 /* !! */ );
                HMSLog.i(var5_9, var4_8);
                throw var0;
            }
        }
        return null;
    }

    public static HttpURLConnection a(Context object, String object2, Map object3, String string2) {
        int n10;
        Object object4 = new URL((String)object2);
        object2 = (HttpURLConnection)((URLConnection)FirebasePerfUrlConnection.instrument(((URL)object4).openConnection()));
        d.a((Context)object, (HttpURLConnection)object2);
        ((HttpURLConnection)object2).setRequestMethod(string2);
        int n11 = 15000;
        ((URLConnection)object2).setConnectTimeout(n11);
        ((URLConnection)object2).setReadTimeout(n11);
        n11 = 1;
        ((URLConnection)object2).setDoOutput(n11 != 0);
        ((URLConnection)object2).setDoInput(n11 != 0);
        ((URLConnection)object2).setRequestProperty("Content-type", "application/json; charset=UTF-8");
        string2 = "Connection";
        object4 = "close";
        ((URLConnection)object2).setRequestProperty(string2, (String)object4);
        if (object3 != null && (n10 = object3.size()) >= n11) {
            boolean bl2;
            object = object3.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                object3 = (Map.Entry)object.next();
                string2 = (String)object3.getKey();
                if (string2 == null || (bl3 = TextUtils.isEmpty((CharSequence)string2))) continue;
                object4 = object3.getValue();
                object3 = object4 == null ? "" : (String)object3.getValue();
                object4 = "UTF-8";
                object3 = URLEncoder.encode((String)object3, (String)object4);
                ((URLConnection)object2).setRequestProperty(string2, (String)object3);
            }
        }
        return object2;
    }

    public static void a(Context object, HttpURLConnection httpURLConnection) {
        String string2 = "PushHttpClient";
        boolean bl2 = httpURLConnection instanceof HttpsURLConnection;
        if (bl2) {
            httpURLConnection = (HttpsURLConnection)httpURLConnection;
            bl2 = false;
            g g10 = null;
            try {
                g10 = g.f(object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = "Get SocketFactory Illegal Argument Exception.";
                HMSLog.w(string2, (String)object);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "Get SocketFactory Illegal Access Exception.";
                HMSLog.w(string2, (String)object);
            }
            catch (IOException iOException) {
                object = "Get SocketFactory IO Exception.";
                HMSLog.w(string2, (String)object);
            }
            catch (GeneralSecurityException generalSecurityException) {
                object = "Get SocketFactory General Security Exception.";
                HMSLog.w(string2, (String)object);
            }
            catch (KeyStoreException keyStoreException) {
                object = "Get SocketFactory Key Store exception.";
                HMSLog.w(string2, (String)object);
            }
            catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                object = "Get SocketFactory Algorithm Exception.";
                HMSLog.w(string2, (String)object);
            }
            if (g10 != null) {
                ((HttpsURLConnection)httpURLConnection).setSSLSocketFactory(g10);
                object = g.j;
                ((HttpsURLConnection)httpURLConnection).setHostnameVerifier((HostnameVerifier)object);
            } else {
                object = new Exception("No ssl socket factory set.");
                throw object;
            }
        }
    }
}

