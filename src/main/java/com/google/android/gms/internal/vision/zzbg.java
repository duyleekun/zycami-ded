/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.Uri
 *  android.util.Log
 */
package com.google.android.gms.internal.vision;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.Log;
import com.google.android.gms.internal.vision.zzcy;

public final class zzbg {
    private static volatile zzcy zzgc;
    private static final Object zzgd;

    static {
        Object object;
        zzgc = zzcy.zzcb();
        zzgd = object = new Object();
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean zza(Context var0, Uri var1_1) {
        var1_1 = var1_1.getAuthority();
        var2_2 = "com.google.android.gms.phenotype";
        var3_3 = var2_2.equals(var1_1);
        var4_4 = 0;
        if (var3_3 == 0) {
            var3_3 = String.valueOf(var1_1).length() + 91;
            var5_5 = new StringBuilder(var3_3);
            var5_5.append((String)var1_1);
            var5_5.append(" is an unsupported authority. Only com.google.android.gms.phenotype authority is supported.");
            var1_1 = var5_5.toString();
            Log.e((String)"PhenotypeClientHelper", (String)var1_1);
            return false;
        }
        var1_1 = zzbg.zzgc;
        var6_7 = var1_1.isPresent();
        if (var6_7) {
            return (Boolean)zzbg.zzgc.get();
        }
        var1_1 = zzbg.zzgd;
        synchronized (var1_1) {
            var2_2 = zzbg.zzgc;
            var3_3 = (int)var2_2.isPresent();
            if (var3_3 != 0) {
                var0 = zzbg.zzgc;
                var0 = var0.get();
                var0 = (Boolean)var0;
                return var0.booleanValue();
            }
            var2_2 = "com.google.android.gms";
            var5_6 = var0.getPackageName();
            var3_3 = (int)var2_2.equals(var5_6);
            var8_10 = 1;
            if (var3_3 != 0) ** GOTO lbl-1000
            var2_2 = var0.getPackageManager();
            var9_11 = "com.google.android.gms.phenotype";
            if ((var2_2 = var2_2.resolveContentProvider(var9_11, 0)) != null && (var3_3 = (int)(var9_11 = "com.google.android.gms").equals(var2_2 = var2_2.packageName)) != 0) lbl-1000:
            // 2 sources

            {
                var3_3 = var8_10;
            } else {
                var3_3 = 0;
                var2_2 = null;
            }
            if (var3_3 != 0 && (var7_9 = zzbg.zzf((Context)var0))) {
                var4_4 = var8_10;
            }
            var0 = (boolean)var4_4;
            zzbg.zzgc = var0 = zzcy.zzb(var0);
            return (Boolean)zzbg.zzgc.get();
        }
    }

    private static boolean zzf(Context context) {
        context = context.getPackageManager();
        String string2 = "com.google.android.gms";
        try {
            context = context.getApplicationInfo(string2, 0);
            int n10 = context.flags & 0x81;
            if (n10 != 0) {
                return true;
            }
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {}
        return false;
    }
}

