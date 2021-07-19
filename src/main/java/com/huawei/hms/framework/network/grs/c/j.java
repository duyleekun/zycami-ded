/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 */
package com.huawei.hms.framework.network.grs.c;

import android.content.Context;
import android.os.SystemClock;
import com.huawei.hms.framework.common.IoUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.a.c;
import com.huawei.hms.framework.network.grs.c.a;
import com.huawei.hms.framework.network.grs.c.b;
import com.huawei.hms.framework.network.grs.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class j
extends b
implements Callable {
    private static final String i = "j";

    public j(String string2, int n10, a a10, Context context, String string3, GrsBaseInfo grsBaseInfo, c c10) {
        super(string2, n10, a10, context, string3, grsBaseInfo, c10);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public f call() {
        block15: {
            block14: {
                var1_1 = this;
                var2_2 = j.i;
                var3_6 = "Post call execute";
                Logger.i((String)var2_2, var3_6);
                var4_7 = 0L;
                try {
                    var6_8 = SystemClock.elapsedRealtime();
                }
                catch (IOException var2_5) {
                    var6_8 = var4_7;
                    break block14;
                }
                try {
                    var4_7 = System.currentTimeMillis();
                    var8_9 = this.c();
                    var9_10 /* !! */  = this.b();
                    var10_11 = this.e();
                    var8_9 = com.huawei.hms.framework.network.grs.d.a.a.a((String)var8_9, var9_10 /* !! */ , (String)var10_11);
                    var9_10 /* !! */  = null;
                    if (var8_9 == null) {
                        var8_9 = "create HttpsURLConnection instance by url return null.";
                        Logger.w((String)var2_2, var8_9);
                        return null;
                    }
                    var2_2 = "Content-Type";
                    var10_11 = "application/json; charset=UTF-8";
                    var8_9.setRequestProperty((String)var2_2, (String)var10_11);
                    var2_2 = "POST";
                    var8_9.setRequestMethod((String)var2_2);
                    var11_12 = 1;
                    var8_9.setDoOutput((boolean)var11_12);
                    var8_9.setDoInput((boolean)var11_12);
                    var8_9.connect();
                    var2_2 = var8_9.getOutputStream();
                    var10_11 = this.f();
                    var12_13 = "services";
                    var13_14 = "";
                    var10_11 = var10_11.a((String)var12_13, var13_14);
                    var12_13 = "UTF-8";
                    var10_11 = var10_11.getBytes((String)var12_13);
                    var2_2.write((byte[])var10_11);
                    var2_2.close();
                    var14_15 = var8_9.getResponseCode();
                    var11_12 = 200;
                    if (var14_15 == var11_12) {
                    }
                    ** GOTO lbl59
                }
                catch (IOException var2_4) {
                    var23_21 = var4_7;
                    var4_7 = var6_8;
                    var6_8 = var23_21;
                    break block14;
                }
                try {
                    var9_10 /* !! */  = var8_9.getInputStream();
                    var2_2 = IoUtils.toByteArray((InputStream)var9_10 /* !! */ );
                }
                finally {
                    IoUtils.closeSecure((InputStream)var9_10 /* !! */ );
                }
                {
                    var9_10 /* !! */  = var2_2;
lbl59:
                    // 2 sources

                    var15_16 = var8_9.getHeaderFields();
                    var8_9.disconnect();
                    var16_17 = SystemClock.elapsedRealtime();
                    var18_18 = System.currentTimeMillis();
                    if (var9_10 /* !! */  == null) {
                        var11_12 = 0;
                        var2_2 = null;
                        var2_2 = new byte[0];
                        var20_19 /* !! */  = var2_2;
                    } else {
                        var20_19 /* !! */  = var9_10 /* !! */ ;
                    }
                    var21_20 = var16_17 - var6_8;
                    var12_13 = var2_2;
                }
                {
                    var1_1.a = var2_2 = new f(var14_15, var15_16, (byte[])var20_19 /* !! */ , var21_20);
                    break block15;
                }
            }
            var25_22 = SystemClock.elapsedRealtime();
            var18_18 = System.currentTimeMillis();
            var10_11 = j.i;
            var12_13 = "RequestCallableV2 run task catch IOException";
            Logger.w((String)var10_11, (String)var12_13, (Throwable)var2_2);
            var1_1.a = var10_11 = new f((Exception)var2_2, var25_22 -= var4_7);
            var4_7 = var6_8;
        }
        var6_8 = var18_18;
        var2_2 = var1_1.a;
        var8_9 = this.c();
        var2_2.a((String)var8_9);
        var2_2 = var1_1.a;
        var27_23 = this.d();
        var2_2.a(var27_23);
        var1_1.a.b(var4_7);
        var1_1.a.a(var18_18);
        var2_2 = this.a();
        if (var2_2 != null) {
            var2_2 = this.a();
            var3_6 = var1_1.a;
            var2_2.a((f)var3_6);
        }
        return var1_1.a;
    }
}

