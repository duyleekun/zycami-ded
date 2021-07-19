/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzhm;

public final class zzhl
implements Runnable {
    public final /* synthetic */ boolean zza;
    public final /* synthetic */ Uri zzb;
    public final /* synthetic */ String zzc;
    public final /* synthetic */ String zzd;
    public final /* synthetic */ zzhm zze;

    public zzhl(zzhm zzhm2, boolean bl2, Uri uri, String string2, String string3) {
        this.zze = zzhm2;
        this.zza = bl2;
        this.zzb = uri;
        this.zzc = string2;
        this.zzd = string3;
    }

    /*
     * Unable to fully structure code
     */
    public final void run() {
        block109: {
            block108: {
                block107: {
                    block106: {
                        block110: {
                            block103: {
                                block105: {
                                    block104: {
                                        block102: {
                                            block101: {
                                                block100: {
                                                    var1_1 = this.zze;
                                                    var2_2 = this.zza;
                                                    var3_3 = this.zzb;
                                                    var4_4 = this.zzc;
                                                    var5_5 = this.zzd;
                                                    var6_6 = var1_1.zza;
                                                    var6_6.zzg();
                                                    var6_6 = var1_1.zza;
                                                    var6_6 = var6_6.zzx;
                                                    var6_6 = var6_6.zzc();
                                                    var7_7 = zzdw.zzac;
                                                    var8_8 = null;
                                                    var9_9 = var6_6.zzn(null, (zzdv)var7_7);
                                                    var10_10 = "Activity created with data 'referrer' without required params";
                                                    var11_11 = "_cis";
                                                    var12_12 = "utm_medium";
                                                    var13_13 = "utm_source";
                                                    var14_14 = "utm_campaign";
                                                    var15_15 = "gclid";
                                                    if (var9_9) break block100;
                                                    var6_6 = var1_1.zza;
                                                    var6_6 = var6_6.zzx;
                                                    var6_6 = var6_6.zzc();
                                                    var16_16 = zzdw.zzae;
                                                    var9_9 = var6_6.zzn(null, (zzdv)var16_16);
                                                    if (var9_9) break block100;
                                                    var6_6 = var1_1.zza;
                                                    var6_6 = var6_6.zzx;
                                                    var6_6 = var6_6.zzc();
                                                    var16_16 = zzdw.zzad;
                                                    var9_9 = var6_6.zzn(null, (zzdv)var16_16);
                                                    if (!var9_9) break block101;
                                                }
                                                var6_6 = var1_1.zza;
                                                var6_6 = var6_6.zzx;
                                                var6_6 = var6_6.zzl();
                                                var17_17 = TextUtils.isEmpty((CharSequence)var5_5);
                                                if (!var17_17) break block102;
                                            }
lbl59:
                                            // 2 sources

                                            while (true) {
                                                var9_9 = false;
                                                var6_6 = null;
                                                break block103;
                                                break;
                                            }
                                        }
                                        try {
                                            var17_17 = var5_5.contains(var15_15);
                                            if (var17_17) break block104;
                                        }
                                        catch (Exception var19_20) {
                                            var1_1.zza.zzx.zzat().zzb().zzb("Throwable caught in handleReferrerForOnActivityCreated", var19_20);
                                            return;
                                        }
                                        var17_17 = var5_5.contains(var14_14);
                                        if (var17_17) break block104;
                                        var17_17 = var5_5.contains(var13_13);
                                        if (var17_17) break block104;
                                        var17_17 = var5_5.contains(var12_12);
                                        if (var17_17) break block104;
                                        var6_6 = var6_6.zzx;
                                        var6_6 = var6_6.zzat();
                                        var6_6 = var6_6.zzj();
                                        var6_6.zza(var10_10);
                                        ** continue;
                                    }
                                    var16_16 = "https://google.com/search?";
                                    var8_8 = String.valueOf(var5_5);
                                    var18_18 = var8_8.length();
                                    if (var18_18 == 0) break block105;
                                    var8_8 = var16_16.concat(var8_8);
                                    ** GOTO lbl101
                                }
                                var8_8 = new String((String)var16_16);
lbl101:
                                // 2 sources

                                var8_8 = Uri.parse((String)var8_8);
                                var6_6 = var6_6.zzi((Uri)var8_8);
                                if (var6_6 == null) break block103;
                                var8_8 = "referrer";
                                var6_6.putString((String)var11_11, var8_8);
                            }
                            var8_8 = "_cmp";
                            var17_17 = true;
                            if (!var2_2) break block110;
                            var19_19 = var1_1.zza;
                            var19_19 = var19_19.zzx;
                            var19_19 = var19_19.zzl();
                            var19_19 = var19_19.zzi((Uri)var3_3);
                            if (var19_19 == null) break block106;
                            var3_3 = "intent";
                            var19_19.putString((String)var11_11, (String)var3_3);
                            var3_3 = var1_1.zza;
                            var3_3 = var3_3.zzx;
                            var3_3 = var3_3.zzc();
                            var11_11 = null;
                            var20_21 = var3_3.zzn(null, (zzdv)var7_7);
                            if (!var20_21) ** GOTO lbl152
                            var20_21 = var19_19.containsKey(var15_15);
                            if (var20_21 || var6_6 == null) ** GOTO lbl152
                            var20_21 = var6_6.containsKey(var15_15);
                            if (!var20_21) ** GOTO lbl152
                            var3_3 = new Object[var17_17];
                            var7_7 = null;
                            var11_11 = var6_6.getString(var15_15);
                            var3_3[0] = var11_11;
                            var7_7 = "_cer";
                            var11_11 = "gclid=%s";
                            var3_3 = String.format((String)var11_11, (Object[])var3_3);
                            var19_19.putString((String)var7_7, (String)var3_3);
lbl152:
                            // 4 sources

                            var3_3 = var1_1.zza;
                            var3_3.zzs(var4_4, var8_8, (Bundle)var19_19);
                            var3_3 = var1_1.zza;
                            var3_3 = var3_3.zzb;
                            var3_3.zzb(var4_4, (Bundle)var19_19);
                            break block106;
                        }
                        var2_2 = false;
                        var19_19 = null;
                    }
                    var3_3 = var1_1.zza;
                    var3_3 = var3_3.zzx;
                    var3_3 = var3_3.zzc();
                    var7_7 = zzdw.zzae;
                    var11_11 = null;
                    var20_21 = var3_3.zzn(null, (zzdv)var7_7);
                    var7_7 = "auto";
                    if (!var20_21) ** GOTO lbl207
                    var3_3 = var1_1.zza;
                    var3_3 = var3_3.zzx;
                    var3_3 = var3_3.zzc();
                    var11_11 = zzdw.zzad;
                    var17_17 = false;
                    var16_16 = null;
                    var20_21 = var3_3.zzn(null, (zzdv)var11_11);
                    if (var20_21 || var6_6 == null) ** GOTO lbl207
                    var20_21 = var6_6.containsKey(var15_15);
                    if (!var20_21) ** GOTO lbl207
                    if (var19_19 == null) break block107;
                    var2_2 = var19_19.containsKey(var15_15);
                    if (var2_2) ** GOTO lbl207
                }
                var19_19 = var1_1.zza;
                var3_3 = "_lgclid";
                var11_11 = var6_6.getString(var15_15);
                var17_17 = true;
                var19_19.zzy((String)var7_7, (String)var3_3, var11_11, var17_17);
lbl207:
                // 5 sources

                if (var2_2 = TextUtils.isEmpty((CharSequence)var5_5)) ** GOTO lbl288
                var19_19 = var1_1.zza;
                var19_19 = var19_19.zzx;
                var19_19 = var19_19.zzat();
                var19_19 = var19_19.zzj();
                var3_3 = "Activity created with referrer";
                var19_19.zzb((String)var3_3, var5_5);
                var19_19 = var1_1.zza;
                var19_19 = var19_19.zzx;
                var19_19 = var19_19.zzc();
                var3_3 = zzdw.zzad;
                var11_11 = null;
                var2_2 = var19_19.zzn(null, (zzdv)var3_3);
                var3_3 = "_ldl";
                if (!var2_2) break block108;
                if (var6_6 == null) ** GOTO lbl242
                var19_19 = var1_1.zza;
                var19_19.zzs(var4_4, var8_8, (Bundle)var6_6);
                var19_19 = var1_1.zza;
                var19_19 = var19_19.zzb;
                var19_19.zzb(var4_4, (Bundle)var6_6);
                ** GOTO lbl252
lbl242:
                // 1 sources

                var19_19 = var1_1.zza;
                var19_19 = var19_19.zzx;
                var19_19 = var19_19.zzat();
                var19_19 = var19_19.zzj();
                var4_4 = "Referrer does not contain valid parameters";
                var19_19.zzb(var4_4, var5_5);
lbl252:
                // 2 sources

                var19_19 = var1_1.zza;
                var21_22 = true;
                var5_5 = null;
                var19_19.zzy((String)var7_7, (String)var3_3, null, var21_22);
                return;
            }
            var2_2 = var5_5.contains(var15_15);
            if (!var2_2) ** GOTO lbl289
            var2_2 = var5_5.contains(var14_14);
            if (var2_2) break block109;
            var2_2 = var5_5.contains(var13_13);
            if (var2_2) break block109;
            var2_2 = var5_5.contains(var12_12);
            if (var2_2) break block109;
            var19_19 = "utm_term";
            var2_2 = var5_5.contains((CharSequence)var19_19);
            if (var2_2) break block109;
            var19_19 = "utm_content";
            var2_2 = var5_5.contains((CharSequence)var19_19);
            if (!var2_2) ** GOTO lbl289
        }
        var2_2 = TextUtils.isEmpty((CharSequence)var5_5);
        if (var2_2) ** GOTO lbl288
        var19_19 = var1_1.zza;
        var21_23 = true;
        var19_19.zzy((String)var7_7, (String)var3_3, var5_5, var21_23);
lbl288:
        // 3 sources

        return;
lbl289:
        // 2 sources

        var19_19 = var1_1.zza;
        var19_19 = var19_19.zzx;
        var19_19 = var19_19.zzat();
        var19_19 = var19_19.zzj();
        var19_19.zza(var10_10);
    }
}

