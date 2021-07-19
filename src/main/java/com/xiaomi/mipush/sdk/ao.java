/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.text.TextUtils
 */
package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.mipush.sdk.an;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ao
implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ an a;
    public final /* synthetic */ String[] a;

    public ao(an an2, String[] stringArray, Context context) {
        this.a = an2;
        this.a = stringArray;
        this.a = context;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void run() {
        block15: {
            var1_1 = 0;
            var2_2 = null;
            while (true) {
                block16: {
                    var3_4 = this.a;
                    var4_5 = ((String[])var3_4).length;
                    if (var1_1 >= var4_5) break block15;
                    var3_4 = var3_4[var1_1];
                    var5_6 = TextUtils.isEmpty((CharSequence)var3_4);
                    if (var5_6) break block16;
                    if (var1_1 <= 0) ** GOTO lbl22
                    var6_7 = Math.random() * 2.0 + 1.0;
                    var8_8 = (long)var6_7;
                    var10_9 = 1000L;
                    var8_8 *= var10_9;
                    Thread.sleep(var8_8);
lbl22:
                    // 2 sources

                    var3_4 = this.a;
                    var3_4 = var3_4.getPackageManager();
                    var12_10 /* !! */  = this.a;
                    var12_10 /* !! */  = var12_10 /* !! */ [var1_1];
                    var13_11 = 4;
                    var3_4 = var3_4.getPackageInfo((String)var12_10 /* !! */ , var13_11);
                    if (var3_4 == null) break block16;
                    var12_10 /* !! */  = this.a;
                    var14_12 = this.a;
                    an.a((an)var12_10 /* !! */ , var14_12, (PackageInfo)var3_4);
                }
                ++var1_1;
            }
            catch (Throwable var2_3) {
                b.a(var2_3);
            }
        }
    }
}

