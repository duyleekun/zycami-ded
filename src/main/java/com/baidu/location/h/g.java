/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.baidu.location.h;

import android.util.Log;
import com.baidu.location.h.a;
import com.baidu.location.h.f;
import com.baidu.location.h.l;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPInputStream;
import javax.net.ssl.HttpsURLConnection;

public class g
implements Runnable {
    public final /* synthetic */ f a;

    public g(f f10) {
        this.a = f10;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block40: {
            block43: {
                var1_1 = this.a;
                var2_8 = l.f;
                var1_1.h = var2_8;
                var1_1.b();
                var1_1 = this.a;
                var3_11 = var1_1.i;
                var2_8 = null;
                var4_12 = 0;
                var5_13 = null;
                while (true) {
                    block42: {
                        block45: {
                            block44: {
                                block41: {
                                    var6_16 = 1;
                                    if (var3_11 <= 0) break block40;
                                    var8_20 = this.a;
                                    var8_20 = var8_20.h;
                                    var7_17 = new URL((String)var8_20);
                                    var7_17 = var7_17.openConnection();
                                    var7_17 = FirebasePerfUrlConnection.instrument(var7_17);
                                    var7_17 = (URLConnection)var7_17;
                                    var7_17 = (HttpsURLConnection)var7_17;
                                    var5_13 = "GET";
                                    var7_17.setRequestMethod((String)var5_13);
                                    var7_17.setDoInput((boolean)var6_16);
                                    var7_17.setDoOutput((boolean)var6_16);
                                    var7_17.setUseCaches(false);
                                    var4_12 = com.baidu.location.h.a.b;
                                    var7_17.setConnectTimeout(var4_12);
                                    var4_12 = com.baidu.location.h.a.b;
                                    var7_17.setReadTimeout(var4_12);
                                    var5_13 = "Content-Type";
                                    var8_20 = "application/x-www-form-urlencoded; charset=utf-8";
                                    var7_17.setRequestProperty((String)var5_13, (String)var8_20);
                                    var5_13 = "Accept-Charset";
                                    var8_20 = "UTF-8";
                                    var7_17.setRequestProperty((String)var5_13, (String)var8_20);
                                    var5_13 = l.az;
                                    if (var5_13 != null) {
                                        var8_20 = "bd-loc-android";
                                        var7_17.setRequestProperty((String)var8_20, (String)var5_13);
                                    }
                                    if ((var4_12 = var7_17.getResponseCode()) != (var9_21 = 200)) ** GOTO lbl78
                                    var5_13 = var7_17.getInputStream();
                                    var8_20 = var7_17.getContentEncoding();
                                    if (var8_20 != null && (var9_21 = (int)var8_20.contains((CharSequence)(var10_22 = "gzip"))) != 0) {
                                        var10_22 = new BufferedInputStream((InputStream)var5_13);
                                        var5_13 = var8_20 = new GZIPInputStream((InputStream)var10_22);
                                    }
                                    var8_20 = new ByteArrayOutputStream();
                                    var11_23 = 1024;
                                    try {
                                        var10_22 = new byte[var11_23];
                                        while ((var12_24 = var5_13.read((byte[])var10_22)) != (var13_25 = -1)) {
                                            var8_20.write((byte[])var10_22, 0, var12_24);
                                        }
                                        var5_13.close();
                                        var8_20.close();
                                        var10_22 = this.a;
                                        var15_27 = var8_20.toByteArray();
                                        var16_28 = "utf-8";
                                        var10_22.j = var14_26 = new String(var15_27, var16_28);
                                        var10_22 = this.a;
                                        var10_22.a((boolean)var6_16);
                                        var7_17.disconnect();
                                        var11_23 = var6_16;
                                        ** GOTO lbl86
                                    }
                                    catch (Throwable var1_2) {
                                        break block41;
                                    }
                                    catch (Throwable var1_3) {
                                        var9_21 = 0;
                                        var8_20 = null;
                                    }
                                }
                                var2_8 = var5_13;
                                ** GOTO lbl105
                                catch (Exception v0) {
                                    block46: {
                                        var9_21 = 0;
                                        var8_20 = null;
                                        break block46;
lbl78:
                                        // 1 sources

                                        try {
                                            var7_17.disconnect();
                                            var4_12 = 0;
                                            var5_13 = null;
                                            var9_21 = 0;
                                            var8_20 = null;
                                            var11_23 = 0;
                                            var10_22 = null;
                                        }
                                        catch (Throwable var1_5) {
                                            var9_21 = 0;
                                            var8_20 = null;
                                        }
lbl86:
                                        // 2 sources

                                        if (var7_17 != null) {
                                            var7_17.disconnect();
                                        }
                                        if (var5_13 != null) {
                                            try {
                                                var5_13.close();
                                            }
                                            catch (Exception var5_14) {
                                                var5_14.printStackTrace();
                                            }
                                        }
                                        if (var8_20 != null) {
                                            try {
                                                var8_20.close();
                                            }
                                            catch (Exception var5_15) {
                                                var5_15.printStackTrace();
                                            }
                                        }
                                        var5_13 = var7_17;
                                        break block42;
lbl105:
                                        // 2 sources

                                        var5_13 = var7_17;
                                        break block43;
                                        catch (Exception v1) {
                                            var9_21 = 0;
                                            var8_20 = null;
                                            var5_13 = var7_17;
                                            var7_17 = null;
                                        }
                                        catch (Throwable var1_6) {
                                            var9_21 = 0;
                                            var8_20 = null;
                                            break block43;
                                        }
                                        catch (Exception v2) {
                                            var7_17 = null;
                                            var9_21 = 0;
                                            var8_20 = null;
                                            break block44;
                                        }
                                        catch (Exception v3) {}
                                    }
                                    var17_29 = var7_17;
                                    var7_17 = var5_13;
                                    var5_13 = var17_29;
                                }
                            }
                            var10_22 = com.baidu.location.h.a.a;
                            var14_26 = "NetworkCommunicationException!";
                            Log.d((String)var10_22, (String)var14_26);
                            if (var5_13 == null) break block45;
                            var5_13.disconnect();
                        }
                        if (var7_17 != null) {
                            try {
                                var7_17.close();
                            }
                            catch (Exception var7_18) {
                                var7_18.printStackTrace();
                            }
                        }
                        if (var8_20 != null) {
                            try {
                                var8_20.close();
                            }
                            catch (Exception var7_19) {
                                var7_19.printStackTrace();
                            }
                        }
                        var11_23 = 0;
                        var10_22 = null;
                    }
                    if (var11_23 == 0) {
                        var3_11 += -1;
                        continue;
                    }
                    break block40;
                    break;
                }
                catch (Throwable var1_7) {
                    var2_8 = var7_17;
                }
            }
            if (var5_13 != null) {
                var5_13.disconnect();
            }
            if (var2_8 != null) {
                try {
                    var2_8.close();
                }
                catch (Exception var2_9) {
                    var2_9.printStackTrace();
                }
            }
            if (var8_20 == null) throw var1_4;
            try {
                var8_20.close();
                throw var1_4;
            }
            catch (Exception var2_10) {
                var2_10.printStackTrace();
            }
            throw var1_4;
        }
        if (var3_11 <= 0) {
            f.p = var3_11 = f.p + var6_16;
            var1_1 = this.a;
            var1_1.j = null;
            var1_1.a(false);
            return;
        }
        f.p = 0;
    }
}

