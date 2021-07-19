/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ac;
import com.xiaomi.push.ai;
import com.xiaomi.push.bc;
import com.xiaomi.push.bf;
import com.xiaomi.push.h;
import com.xiaomi.push.hq;
import com.xiaomi.push.iw;
import com.xiaomi.push.ix;
import com.xiaomi.push.p;
import com.xiaomi.push.service.bi;
import com.xiaomi.push.service.bk;
import com.xiaomi.push.y;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public class bj {
    public static final Object a;

    static {
        Object object;
        a = object = new Object();
    }

    public static void a(Context context, hq hq2) {
        Object object = hq2.e();
        boolean bl2 = bi.a((String)object);
        if (!bl2) {
            return;
        }
        object = ai.a(context);
        bk bk2 = new bk(context, hq2);
        ((ai)object).a(bk2);
    }

    public static byte[] a(Context object) {
        Object object2 = p.a((Context)object);
        String string2 = "mipush";
        String string3 = "td_key";
        String string4 = "";
        boolean bl2 = TextUtils.isEmpty((CharSequence)(object2 = ((p)object2).a(string2, string3, string4)));
        if (bl2) {
            int n10 = 20;
            object2 = bf.a(n10);
            object = p.a((Context)object);
            ((p)object).a(string2, string3, (String)object2);
        }
        return bj.a((String)object2);
    }

    private static byte[] a(String object) {
        object = Arrays.copyOf(bc.a((String)object), 16);
        object[0] = 68;
        object[15] = 84;
        return object;
    }

    public static /* synthetic */ void b(Context context, hq hq2) {
        bj.c(context, hq2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private static void c(Context var0, hq var1_5) {
        block46: {
            block50: {
                block49: {
                    block48: {
                        block47: {
                            block44: {
                                block45: {
                                    var2_7 /* !! */  = bj.a((Context)var0);
                                    var3_8 /* !! */  = iw.a((ix)var1_5);
                                    var2_7 /* !! */  = h.b(var2_7 /* !! */ , var3_8 /* !! */ );
                                    var3_8 /* !! */  = (byte[])"  ts:";
                                    if (var2_7 /* !! */  == null) break block44;
                                    var4_9 = var2_7 /* !! */ .length;
                                    var5_10 = true;
                                    if (var4_9 < var5_10) break block44;
                                    var4_9 = var2_7 /* !! */ .length;
                                    var6_11 = 10240 != 0;
                                    if (var4_9 <= var6_11) break block45;
                                    var0 = new StringBuilder();
                                    var2_7 /* !! */  = (byte[])"TinyData write to cache file failed case too much data content item:";
                                    var0.append((String)var2_7 /* !! */ );
                                    var2_7 /* !! */  = (byte[])var1_5.d();
                                    var0.append((String)var2_7 /* !! */ );
                                    var0.append((String)var3_8 /* !! */ );
                                    var7_12 = System.currentTimeMillis();
                                    var0.append(var7_12);
                                    var0 = var0.toString();
lbl34:
                                    // 2 sources

                                    while (true) {
                                        b.a((String)var0);
                                        y.a(null);
                                        y.a(null);
                                        return;
                                    }
                                }
                                var0 = var0.getFilesDir();
                                var9_14 = "tiny_data.data";
                                var3_8 /* !! */  = new File((File)var0, (String)var9_14);
                                var9_14 = new FileOutputStream((File)var3_8 /* !! */ , var5_10);
                                var0 = new BufferedOutputStream((OutputStream)var9_14);
                                var10_15 = var2_7 /* !! */ .length;
                                var3_8 /* !! */  = ac.a(var10_15);
                                var0.write(var3_8 /* !! */ );
                                try {
                                    var0.write(var2_7 /* !! */ );
                                    var0.flush();
                                }
                                catch (Throwable var1_6) {
                                    var2_7 /* !! */  = (byte[])var0;
                                    var0 = var1_6;
                                    break block46;
                                }
                                catch (Exception var11_16) {
                                    var2_7 /* !! */  = (byte[])var0;
                                    var0 = var11_16;
                                    break block47;
                                }
                                catch (IOException var11_17) {
                                    var2_7 /* !! */  = (byte[])var0;
                                    var0 = var11_17;
                                    break block48;
                                }
                                y.a(null);
                                y.a((Closeable)var0);
                                break block50;
                            }
                            var0 = new StringBuilder();
                            var2_7 /* !! */  = (byte[])"TinyData write to cache file failed case encryption fail item:";
                            var0.append((String)var2_7 /* !! */ );
                            var2_7 /* !! */  = (byte[])var1_5.d();
                            var0.append((String)var2_7 /* !! */ );
                            var0.append((String)var3_8 /* !! */ );
                            var7_13 = System.currentTimeMillis();
                            try {
                                var0.append(var7_13);
                                var0 = var0.toString();
                                ** continue;
                            }
                            catch (Throwable var0_1) {
                                var2_7 /* !! */  = null;
                                break block46;
                            }
                            catch (Exception var0_2) {
                                var2_7 /* !! */  = null;
                            }
                        }
                        var3_8 /* !! */  = (byte[])new StringBuilder;
                        var3_8 /* !! */  = new StringBuilder();
                        var9_14 = "TinyData write to cache file  failed item:";
                        var3_8 /* !! */ .append((String)var9_14);
                        var1_5 = var1_5.d();
                        var3_8 /* !! */ .append((String)var1_5);
                        var1_5 = var3_8 /* !! */ .toString();
                        break block49;
                        catch (IOException var0_3) {
                            var2_7 /* !! */  = null;
                        }
                    }
                    var3_8 /* !! */  = (byte[])new StringBuilder;
                    var3_8 /* !! */  = new StringBuilder();
                    var9_14 = "TinyData write to cache file failed cause io exception item:";
                    var3_8 /* !! */ .append((String)var9_14);
                    var1_5 = var1_5.d();
                    var3_8 /* !! */ .append((String)var1_5);
                    var1_5 = var3_8 /* !! */ .toString();
                }
                try {
                    b.a((String)var1_5, (Throwable)var0);
                }
                catch (Throwable var0_4) {
                    // empty catch block
                }
                y.a(null);
                y.a((Closeable)var2_7 /* !! */ );
            }
            return;
        }
        y.a(null);
        y.a((Closeable)var2_7 /* !! */ );
        throw var0;
    }
}

