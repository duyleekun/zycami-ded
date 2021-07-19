/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.AsyncTask
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.e;

import android.net.Uri;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.updatesdk.b.b.a;
import com.huawei.updatesdk.service.otaupdate.f;

public class d
extends AsyncTask {
    private String a = null;
    private String b;

    public d(String string2, String string3) {
        this.a = string2;
        this.b = string3;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String a(Void ... var1_1) {
        block16: {
            block17: {
                block15: {
                    var1_1 /* !! */  = "cursor Execption";
                    var2_2 = "GetAccountZoneTask";
                    var3_3 = this.a;
                    var4_5 = TextUtils.isEmpty((CharSequence)var3_3);
                    var5_6 = null;
                    if (var4_5) {
                        return null;
                    }
                    var3_3 = this.a;
                    var6_8 = Uri.parse((String)var3_3);
                    try {
                        var3_3 = com.huawei.updatesdk.a.b.a.a.c();
                        var3_3 = var3_3.a();
                        var7_9 = var3_3.getContentResolver();
                        var8_13 = null;
                        var3_3 = var7_9.query((Uri)var6_8, null, null, null, null);
                        if (var3_3 == null) break block15;
                    }
                    catch (Throwable var3_4) {
                        var12_16 = var5_6;
                        var5_6 = var3_4;
                        var3_3 = var12_16;
                        break block16;
                    }
                    catch (Exception var7_11) {
                        var4_5 = false;
                        var3_3 = null;
                        ** GOTO lbl-1000
                    }
                    try {
                        var9_14 = var3_3.moveToFirst();
                        if (var9_14 == 0) break block15;
                        var7_9 = "homecountry";
                        var9_14 = var3_3.getColumnIndex((String)var7_9);
                        var5_6 = var3_3.getString(var9_14);
                        var7_9 = f.f();
                        var7_9.a((String)var5_6);
                        var7_9 = com.huawei.updatesdk.b.b.a.d();
                        var6_8 = this.b;
                        var10_15 = System.currentTimeMillis();
                        var7_9.a((String)var6_8, var10_15);
                        var7_9 = com.huawei.updatesdk.b.b.a.d();
                        var6_8 = this.b;
                        var7_9.b((String)var6_8, (String)var5_6);
                        break block17;
                    }
                    catch (Throwable var5_7) {
                        break block16;
                    }
                    catch (Exception var7_10) {
                        var12_16 = var5_6;
                        var5_6 = var3_3;
                        var3_3 = var12_16;
                        ** GOTO lbl-1000
                    }
                }
                var7_9 = "cursor == null: ";
                com.huawei.updatesdk.a.a.a.a(var2_2, (String)var7_9);
            }
            if (var3_3 == null) return var5_6;
            try {
                var3_3.close();
                return var5_6;
            }
            catch (Exception v0) {
                ** continue;
            }
lbl-1000:
            // 2 sources

            {
                var6_8 = new StringBuilder();
                var8_13 = "close cursor error: ";
                var6_8.append(var8_13);
                var7_12 = var7_12.toString();
                var6_8.append(var7_12);
                var7_12 = var6_8.toString();
                com.huawei.updatesdk.a.a.a.a(var2_2, var7_12);
                if (var5_6 == null) return var3_3;
            }
            try {
                var5_6.close();
                return var3_3;
            }
            catch (Exception v1) {
                var5_6 = var3_3;
lbl75:
                // 2 sources

                while (true) {
                    com.huawei.updatesdk.a.a.c.a.a.a.b(var2_2, (String)var1_1 /* !! */ );
                    return var5_6;
                }
            }
        }
        if (var3_3 == null) throw var5_6;
        try {
            var3_3.close();
            throw var5_6;
        }
        catch (Exception v2) {
            com.huawei.updatesdk.a.a.c.a.a.a.b(var2_2, (String)var1_1 /* !! */ );
        }
        throw var5_6;
    }
}

