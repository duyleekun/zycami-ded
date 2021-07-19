/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.google.android.gms.measurement.internal;

import android.util.Log;
import androidx.collection.ArrayMap;
import com.google.android.gms.internal.measurement.zzbw;
import com.google.android.gms.internal.measurement.zzby;
import com.google.android.gms.internal.measurement.zzcd;
import com.google.android.gms.internal.measurement.zzck;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zzlo;
import com.google.android.gms.measurement.internal.zzao;
import com.google.android.gms.measurement.internal.zzdv;
import com.google.android.gms.measurement.internal.zzdw;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzw;
import com.google.android.gms.measurement.internal.zzy;
import java.util.HashSet;

public final class zzv
extends zzw {
    public final /* synthetic */ zzy zza;
    private final zzbw zzh;

    public zzv(zzy zzy2, String string2, int n10, zzbw zzbw2) {
        this.zza = zzy2;
        super(string2, n10);
        this.zzh = zzbw2;
    }

    public final int zza() {
        return this.zzh.zzb();
    }

    public final boolean zzb() {
        return false;
    }

    public final boolean zzc() {
        return this.zzh.zzg();
    }

    /*
     * Unable to fully structure code
     */
    public final boolean zzd(Long var1_1, Long var2_2, zzdb var3_3, long var4_4, zzao var6_5, boolean var7_6) {
        block33: {
            block32: {
                block34: {
                    var8_7 = this;
                    var9_8 = Boolean.TRUE;
                    var10_9 = Boolean.FALSE;
                    zzlo.zzb();
                    var11_10 = this.zza.zzx.zzc();
                    var12_11 = this.zzb;
                    var13_12 = zzdw.zzaa;
                    var14_13 = var11_10.zzn((String)var12_11, (zzdv)var13_12);
                    var12_11 = this.zzh;
                    var15_14 = var12_11.zzm();
                    if (var15_14) {
                        var12_11 = var6_5;
                        var16_15 = var6_5.zze;
                    } else {
                        var16_15 = var4_4;
                    }
                    var18_16 = var8_7.zza.zzx.zzat().zzn();
                    var19_17 = Log.isLoggable((String)var18_16, (int)2);
                    var20_18 = null;
                    if (var19_17) {
                        var18_16 = var8_7.zza.zzx.zzat().zzk();
                        var21_19 = var8_7.zzc;
                        var22_20 = var21_19;
                        var23_21 = var8_7.zzh;
                        var24_22 = var23_21.zza();
                        if (var24_22) {
                            var24_22 = var8_7.zzh.zzb();
                            var23_21 = (int)var24_22;
                        } else {
                            var24_22 = false;
                            var23_21 = null;
                        }
                        var25_23 = var8_7.zza.zzx.zzm();
                        var26_24 = var8_7.zzh.zzc();
                        var25_23 = var25_23.zzc(var26_24);
                        var26_24 = "Evaluating filter. audience, filter, event";
                        var18_16.zzd(var26_24, var22_20, var23_21, var25_23);
                        var18_16 = var8_7.zza.zzx.zzat().zzk();
                        var22_20 = var8_7.zza.zza.zzn();
                        var23_21 = var8_7.zzh;
                        var22_20 = var22_20.zzi((zzbw)var23_21);
                        var23_21 = "Filter definition";
                        var18_16.zzb((String)var23_21, var22_20);
                    }
                    var18_16 = var8_7.zzh;
                    var19_17 = var18_16.zza();
                    var21_19 = 0;
                    var22_20 = null;
                    if (!var19_17 || (var19_17 = (var18_16 = var8_7.zzh).zzb()) > (var24_22 = 256 != 0)) break block33;
                    var18_16 = var8_7.zzh;
                    var19_17 = var18_16.zzi();
                    var23_21 = var8_7.zzh;
                    var24_22 = var23_21.zzj();
                    var25_23 = var8_7.zzh;
                    var27_25 = var25_23.zzm();
                    var28_26 = true;
                    if (!(var19_17 || var24_22 || var27_25)) {
                        var19_17 = false;
                        var18_16 = null;
                    } else {
                        var19_17 = var28_26;
                    }
                    if (var7_6 && !var19_17) {
                        var9_8 = var8_7.zza.zzx.zzat().zzk();
                        var29_27 = var8_7.zzc;
                        var10_9 = var29_27;
                        var11_10 = var8_7.zzh;
                        var14_13 = (int)var11_10.zza();
                        if (var14_13 != 0) {
                            var11_10 = var8_7.zzh;
                            var14_13 = var11_10.zzb();
                            var20_18 = var14_13;
                        }
                        var9_8.zzc("Event filter already evaluated true and it is not associated with an enhanced audience. audience ID, filter ID", var10_9, var20_18);
                        return var28_26;
                    }
                    var23_21 = var8_7.zzh;
                    var25_23 = var3_3.zzd();
                    var30_29 = var23_21.zzg();
                    if (!var30_29) break block34;
                    var31_30 = var23_21.zzh();
                    var12_11 = zzw.zzg(var16_15, (zzcd)var31_30);
                    if (var12_11 == null) lbl-1000:
                    // 12 sources

                    {
                        while (true) {
                            var29_28 = false;
                            var10_9 = null;
                            break block32;
                            break;
                        }
                    }
                    var15_14 = var12_11.booleanValue();
                    if (!var15_14) break block32;
                }
                var12_11 = new HashSet();
                var13_12 = var23_21.zzd().iterator();
                while (var30_29 = var13_12.hasNext()) {
                    block35: {
                        var31_30 = (zzby)var13_12.next();
                        var32_31 = var31_30.zzh();
                        var33_32 = var32_31.isEmpty();
                        if (!var33_32) break block35;
                        var10_9 = var8_7.zza.zzx.zzat().zze();
                        var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                        var13_12 = "null or empty param name in filter. event";
                        var10_9.zzb((String)var13_12, var12_11);
                        ** GOTO lbl-1000
                    }
                    var31_30 = var31_30.zzh();
                    var12_11.add((Object)var31_30);
                }
                var13_12 = new ArrayMap();
                var31_30 = var3_3.zza().iterator();
                while (var33_32 = var31_30.hasNext()) {
                    var32_31 = (zzdf)var31_30.next();
                    var34_33 = var32_31.zzb();
                    var35_34 = var12_11.contains(var34_33);
                    if (!var35_34) continue;
                    var35_34 = var32_31.zze();
                    if (var35_34) {
                        var34_33 = var32_31.zzb();
                        var36_35 = var32_31.zze();
                        if (var36_35) {
                            var37_36 = var32_31.zzf();
                            var32_31 = var37_36;
                        } else {
                            var33_32 = false;
                            var32_31 = null;
                        }
                        var13_12.put(var34_33, var32_31);
                        continue;
                    }
                    var35_34 = var32_31.zzi();
                    if (var35_34) {
                        var34_33 = var32_31.zzb();
                        var36_35 = var32_31.zzi();
                        if (var36_35) {
                            var39_37 = var32_31.zzj();
                            var32_31 = var39_37;
                        } else {
                            var33_32 = false;
                            var32_31 = null;
                        }
                        var13_12.put(var34_33, var32_31);
                        continue;
                    }
                    var35_34 = var32_31.zzc();
                    if (var35_34) {
                        var34_33 = var32_31.zzb();
                        var32_31 = var32_31.zzd();
                        var13_12.put(var34_33, var32_31);
                        continue;
                    }
                    var10_9 = var8_7.zza.zzx.zzat().zze();
                    var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                    var13_12 = var8_7.zza.zzx.zzm();
                    var23_21 = var32_31.zzb();
                    var13_12 = var13_12.zzd((String)var23_21);
                    var23_21 = "Unknown value for param. event, param";
                    var10_9.zzc((String)var23_21, var12_11, var13_12);
                    ** GOTO lbl-1000
                }
                var12_11 = var23_21.zzd().iterator();
                while (var24_22 = var12_11.hasNext()) {
                    block41: {
                        block44: {
                            block45: {
                                block43: {
                                    block42: {
                                        block39: {
                                            block40: {
                                                block37: {
                                                    block38: {
                                                        block36: {
                                                            var23_21 = (zzby)var12_11.next();
                                                            var30_29 = var23_21.zze();
                                                            if (var30_29 && (var30_29 = var23_21.zzf())) {
                                                                var30_29 = var28_26;
                                                            } else {
                                                                var30_29 = false;
                                                                var31_30 = null;
                                                            }
                                                            var32_31 = var23_21.zzh();
                                                            var35_34 = var32_31.isEmpty();
                                                            if (!var35_34) break block36;
                                                            var10_9 = var8_7.zza.zzx.zzat().zze();
                                                            var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                                                            var13_12 = "Event has empty param name. event";
                                                            var10_9.zzb((String)var13_12, var12_11);
                                                            ** GOTO lbl-1000
                                                        }
                                                        var34_33 = var13_12.get(var32_31);
                                                        var36_35 = var34_33 instanceof Long;
                                                        if (!var36_35) break block37;
                                                        var36_35 = var23_21.zzc();
                                                        if (var36_35) break block38;
                                                        var10_9 = var8_7.zza.zzx.zzat().zze();
                                                        var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                                                        var13_12 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                                                        var23_21 = "No number filter for long param. event, param";
                                                        var10_9.zzc((String)var23_21, var12_11, var13_12);
                                                        ** GOTO lbl-1000
                                                    }
                                                    var34_33 = (Long)var34_33;
                                                    var41_38 = var34_33.longValue();
                                                    var23_21 = var23_21.zzd();
                                                    if ((var23_21 = zzw.zzg(var41_38, (zzcd)var23_21)) == null) ** GOTO lbl-1000
                                                    var24_22 = var23_21.booleanValue();
                                                    if (var24_22 != var30_29) continue;
                                                    break block32;
                                                }
                                                var36_35 = var34_33 instanceof Double;
                                                if (!var36_35) break block39;
                                                var36_35 = var23_21.zzc();
                                                if (var36_35) break block40;
                                                var10_9 = var8_7.zza.zzx.zzat().zze();
                                                var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                                                var13_12 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                                                var23_21 = "No number filter for double param. event, param";
                                                var10_9.zzc((String)var23_21, var12_11, var13_12);
                                                ** GOTO lbl-1000
                                            }
                                            var34_33 = (Double)var34_33;
                                            var43_39 = var34_33.doubleValue();
                                            var23_21 = var23_21.zzd();
                                            if ((var23_21 = zzw.zzh(var43_39, (zzcd)var23_21)) == null) ** GOTO lbl-1000
                                            var24_22 = var23_21.booleanValue();
                                            if (var24_22 != var30_29) continue;
                                            break block32;
                                        }
                                        var36_35 = var34_33 instanceof String;
                                        if (!var36_35) break block41;
                                        var36_35 = var23_21.zza();
                                        if (!var36_35) break block42;
                                        var34_33 = (String)var34_33;
                                        var23_21 = var23_21.zzb();
                                        var32_31 = var8_7.zza.zzx.zzat();
                                        var23_21 = zzw.zzf((String)var34_33, (zzck)var23_21, (zzei)var32_31);
                                        break block43;
                                    }
                                    var36_35 = var23_21.zzc();
                                    if (!var36_35) break block44;
                                    var36_35 = zzkf.zzl((String)(var34_33 = (String)var34_33));
                                    if (!var36_35) break block45;
                                    var23_21 = var23_21.zzd();
                                    var23_21 = zzw.zzi((String)var34_33, (zzcd)var23_21);
                                }
                                if (var23_21 == null) ** GOTO lbl-1000
                                var24_22 = var23_21.booleanValue();
                                if (var24_22 != var30_29) continue;
                                break block32;
                            }
                            var10_9 = var8_7.zza.zzx.zzat().zze();
                            var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                            var13_12 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                            var23_21 = "Invalid param value for number filter. event, param";
                            var10_9.zzc((String)var23_21, var12_11, var13_12);
                            ** GOTO lbl-1000
                        }
                        var10_9 = var8_7.zza.zzx.zzat().zze();
                        var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                        var13_12 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                        var23_21 = "No filter for String param. event, param";
                        var10_9.zzc((String)var23_21, var12_11, var13_12);
                        ** GOTO lbl-1000
                    }
                    if (var34_33 == null) {
                        var12_11 = var8_7.zza.zzx.zzat().zzk();
                        var13_12 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                        var20_18 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                        var23_21 = "Missing param for filter. event, param";
                        var12_11.zzc((String)var23_21, var13_12, var20_18);
                        break block32;
                    }
                    var10_9 = var8_7.zza.zzx.zzat().zze();
                    var12_11 = var8_7.zza.zzx.zzm().zzc((String)var25_23);
                    var13_12 = var8_7.zza.zzx.zzm().zzd((String)var32_31);
                    var23_21 = "Unknown param type. event, param";
                    var10_9.zzc((String)var23_21, var12_11, var13_12);
                    ** continue;
lbl257:
                    // 1 sources

                    ** GOTO lbl-1000
                }
                var10_9 = var9_8;
            }
            var12_11 = var8_7.zza.zzx.zzat().zzk();
            var13_12 = var10_9 == null ? "null" : var10_9;
            var20_18 = "Event filter result";
            var12_11.zzb((String)var20_18, var13_12);
            if (var10_9 == null) {
                return false;
            }
            var8_7.zzd = var9_8;
            var29_28 = var10_9.booleanValue();
            if (!var29_28) {
                return var28_26;
            }
            var8_7.zze = var9_8;
            if (var19_17 && (var45_40 = var3_3.zze())) {
                var46_41 = var3_3.zzf();
                var9_8 = var46_41;
                var10_9 = var8_7.zzh;
                var29_28 = var10_9.zzj();
                if (var29_28) {
                    if (var14_13 != 0 && (var29_28 = (var10_9 = var8_7.zzh).zzg())) {
                        var9_8 = var1_1;
                    }
                    var8_7.zzg = var9_8;
                } else {
                    if (var14_13 != 0 && (var29_28 = (var10_9 = var8_7.zzh).zzg())) {
                        var9_8 = var2_2;
                    }
                    var8_7.zzf = var9_8;
                }
            }
            return var28_26;
        }
        var9_8 = var8_7.zza.zzx.zzat().zze();
        var10_9 = zzei.zzl(var8_7.zzb);
        var11_10 = var8_7.zzh;
        var14_13 = var11_10.zza();
        if (var14_13 != 0) {
            var11_10 = var8_7.zzh;
            var14_13 = var11_10.zzb();
            var20_18 = var14_13;
        }
        var11_10 = String.valueOf(var20_18);
        var9_8.zzc("Invalid event filter ID. appId, id", var10_9, var11_10);
        return false;
    }
}

