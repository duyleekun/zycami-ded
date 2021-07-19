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
import com.huawei.hms.framework.network.grs.c.a;
import com.huawei.hms.framework.network.grs.c.b;
import com.huawei.hms.framework.network.grs.c.f;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class i
extends b
implements Callable {
    private static final String i = "i";

    public i(String string2, int n10, a a10, Context context, String string3, GrsBaseInfo grsBaseInfo) {
        super(string2, n10, a10, context, string3, grsBaseInfo, null);
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
                var2_2 = com.huawei.hms.framework.network.grs.c.i.i;
                var3_6 = "Get call execute";
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
                    var2_2 = "GET";
                    var8_9.setRequestMethod((String)var2_2);
                    var8_9.connect();
                    var11_12 = var8_9.getResponseCode();
                    var12_13 = 200;
                    if (var11_12 == var12_13) {
                    }
                    ** GOTO lbl44
                }
                catch (IOException var2_4) {
                    var20_18 = var4_7;
                    var4_7 = var6_8;
                    var6_8 = var20_18;
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
lbl44:
                    // 2 sources

                    var13_14 = var8_9.getHeaderFields();
                    var8_9.disconnect();
                    var14_15 = SystemClock.elapsedRealtime();
                    var16_16 = System.currentTimeMillis();
                    if (var9_10 /* !! */  == null) {
                        var12_13 = 0;
                        var2_2 = null;
                        var2_2 = new byte[0];
                    } else {
                        var2_2 = var9_10 /* !! */ ;
                    }
                    var18_17 = var14_15 - var6_8;
                    var10_11 = var8_9;
                }
                {
                    var1_1.a = var8_9 = new f(var11_12, var13_14, (byte[])var2_2, var18_17);
                    break block15;
                }
            }
            var22_19 = SystemClock.elapsedRealtime();
            var16_16 = System.currentTimeMillis();
            var10_11 = com.huawei.hms.framework.network.grs.c.i.i;
            var24_20 = "RequestCallable run task catch IOException";
            Logger.w((String)var10_11, var24_20, (Throwable)var2_2);
            var1_1.a = var10_11 = new f((Exception)var2_2, var22_19 -= var4_7);
            var4_7 = var6_8;
        }
        var2_2 = var1_1.a;
        var25_21 = this.c();
        var2_2.a(var25_21);
        var2_2 = var1_1.a;
        var26_22 = this.d();
        var2_2.a(var26_22);
        var1_1.a.b(var4_7);
        var1_1.a.a(var16_16);
        var2_2 = this.a();
        if (var2_2 != null) {
            var2_2 = this.a();
            var3_6 = var1_1.a;
            var2_2.a((f)var3_6);
        }
        return var1_1.a;
    }
}

