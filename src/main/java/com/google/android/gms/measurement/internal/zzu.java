/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.sqlite.SQLiteException
 *  android.text.TextUtils
 *  android.util.Pair
 */
package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzda;
import com.google.android.gms.internal.measurement.zzdb;
import com.google.android.gms.internal.measurement.zzdf;
import com.google.android.gms.internal.measurement.zziw;
import com.google.android.gms.measurement.internal.zzei;
import com.google.android.gms.measurement.internal.zzkf;
import com.google.android.gms.measurement.internal.zzs;
import com.google.android.gms.measurement.internal.zzy;
import java.io.IOException;
import java.util.ArrayList;

public final class zzu {
    public final /* synthetic */ zzy zza;
    private zzdb zzb;
    private Long zzc;
    private long zzd;

    public /* synthetic */ zzu(zzy zzy2, zzs zzs2) {
        this.zza = zzy2;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final zzdb zza(String var1_1, zzdb var2_2) {
        block57: {
            block53: {
                block54: {
                    block55: {
                        block56: {
                            block51: {
                                block52: {
                                    var3_3 = this;
                                    var4_4 = var1_1;
                                    var5_5 = var2_2;
                                    var6_6 = var2_2.zzd();
                                    var7_14 = var2_2.zza();
                                    this.zza.zza.zzn();
                                    var8_15 = "_eid";
                                    var9_16 /* !! */  = (Long)zzkf.zzA(var2_2, (String)var8_15);
                                    if (var9_16 /* !! */  == null) break block57;
                                    var10_17 = "_ep";
                                    var11_18 = var6_6.equals(var10_17);
                                    var12_19 = 0L;
                                    if (!var11_18) ** GOTO lbl197
                                    Preconditions.checkNotNull(var9_16 /* !! */ );
                                    this.zza.zza.zzn();
                                    var14_20 = var6_6 = zzkf.zzA(var2_2, "_en");
                                    var14_20 = (String)var6_6;
                                    var15_21 /* !! */  = TextUtils.isEmpty((CharSequence)var14_20);
                                    var11_18 = false;
                                    var10_17 = null;
                                    if (var15_21 /* !! */  != 0) {
                                        this.zza.zzx.zzat().zzc().zzb("Extra parameter without an event name. eventId", var9_16 /* !! */ );
                                        return null;
                                    }
                                    var6_6 = this.zzb;
                                    var16_22 = 1;
                                    var17_23 = null;
                                    if (var6_6 != null && (var6_6 = this.zzc) != null && (var15_21 /* !! */  = (cfr_temp_0 = (var18_24 = var9_16 /* !! */ .longValue()) - (var20_25 = (var6_6 = this.zzc).longValue())) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1)) == 0) ** GOTO lbl134
                                    var6_6 = var3_3.zza.zza;
                                    var22_26 = var6_6.zzi();
                                    var22_26.zzg();
                                    var22_26.zzX();
                                    var6_6 = var22_26.zze();
                                    var23_27 = 2;
                                    var24_28 = new String[var23_27];
                                    var24_28[0] = var4_4;
                                    var25_29 = String.valueOf(var9_16 /* !! */ );
                                    var24_28[var16_22] = var25_29;
                                    var25_29 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?";
                                    var24_28 = var6_6.rawQuery((String)var25_29, (String[])var24_28);
                                    var15_21 /* !! */  = (int)var24_28.moveToFirst();
                                    if (var15_21 /* !! */  != 0) break block51;
                                    var6_6 = var22_26.zzx;
                                    var6_6 = var6_6.zzat();
                                    var6_6 = var6_6.zzk();
                                    var25_29 = "Main event not found";
                                    var6_6.zza((String)var25_29);
                                    if (var24_28 == null) break block52;
                                    var24_28.close();
                                }
                                var15_21 /* !! */  = 0;
                                var6_6 = null;
                                break block53;
                            }
                            var6_6 = var24_28.getBlob(0);
                            var20_25 = var24_28.getLong(var16_22);
                            var25_29 = var20_25;
                            var10_17 = zzdb.zzk();
                            var6_6 = zzkf.zzt((zziw)var10_17, var6_6);
                            var6_6 = (zzda)var6_6;
                            var6_6 = var6_6.zzaA();
                            var6_6 = (zzdb)var6_6;
                            var6_6 = Pair.create((Object)var6_6, (Object)var25_29);
                            ** if (var24_28 == null) goto lbl-1000
lbl-1000:
                            // 1 sources

                            {
                                var24_28.close();
                            }
lbl-1000:
                            // 2 sources

                            {
                                break block53;
                            }
                            catch (IOException var6_7) {
                                var10_17 = var22_26.zzx;
                                var10_17 = var10_17.zzat();
                                var10_17 = var10_17.zzb();
                                var25_29 = "Failed to merge main event. appId, eventId";
                                var17_23 = zzei.zzl(var1_1);
                                try {
                                    var10_17.zzd((String)var25_29, var17_23, var9_16 /* !! */ , var6_7);
                                    if (var24_28 == null) break block54;
                                    break block55;
                                }
                                catch (SQLiteException var6_8) {
                                    break block56;
                                }
                            }
                            catch (Throwable var6_9) {
                                var11_18 = false;
                                var10_17 = null;
                                ** GOTO lbl194
                            }
                            catch (SQLiteException var6_10) {
                                var23_27 = 0;
                                var24_28 = null;
                            }
                        }
                        var10_17 = var22_26.zzx;
                        var10_17 = var10_17.zzat();
                        var10_17 = var10_17.zzb();
                        var17_23 = "Error selecting main event";
                        var10_17.zzb((String)var17_23, var6_6);
                        if (var24_28 == null) break block54;
                    }
                    var24_28.close();
                }
                var15_21 /* !! */  = 0;
                var6_6 = null;
            }
            if (var6_6 != null && (var10_17 = var6_6.first) != null) {
                var3_3.zzb = var10_17 = (zzdb)var10_17;
                var3_3.zzd = var26_30 = ((Long)var6_6.second).longValue();
                var3_3.zza.zza.zzn();
                var3_3.zzc = var6_6 = (Long)zzkf.zzA(var3_3.zzb, var8_15);
lbl134:
                // 2 sources

                var26_30 = var3_3.zzd;
                var28_31 = -1;
                var3_3.zzd = var26_30 += var28_31;
                var15_21 /* !! */  = (int)(var26_30 == var12_19 ? 0 : (var26_30 < var12_19 ? -1 : 1));
                if (var15_21 /* !! */  <= 0) {
                    var8_15 = var3_3.zza.zza.zzi();
                    var8_15.zzg();
                    var6_6 = var8_15.zzx.zzat().zzk();
                    var9_16 /* !! */  = "Clearing complex main event info. appId";
                    var6_6.zzb((String)var9_16 /* !! */ , var4_4);
                    var6_6 = var8_15.zze();
                    var9_16 /* !! */  = new String[var16_22];
                    var11_18 = false;
                    var10_17 = null;
                    var9_16 /* !! */ [0] = var4_4;
                    var4_4 = "delete from main_event_params where app_id=?";
                    try {
                        var6_6.execSQL((String)var4_4, var9_16 /* !! */ );
                    }
                    catch (SQLiteException var6_11) {
                        var8_15 = var8_15.zzx.zzat().zzb();
                        var4_4 = "Error clearing complex main event";
                        var8_15.zzb((String)var4_4, (Object)var6_11);
                    }
                } else {
                    var6_6 = var3_3.zza.zza;
                    var8_15 = var6_6.zzi();
                    var30_32 = var3_3.zzd;
                    var32_34 = var3_3.zzb;
                    var4_4 = var1_1;
                    var8_15.zzH(var1_1, (Long)var9_16 /* !! */ , var30_32, var32_34);
                }
                var6_6 = new ArrayList();
                var8_15 = var3_3.zzb.zza().iterator();
                while (var33_36 = var8_15.hasNext()) {
                    var4_4 = (zzdf)var8_15.next();
                    var3_3.zza.zza.zzn();
                    var9_16 /* !! */  = var4_4.zzb();
                    if ((var9_16 /* !! */  = zzkf.zzz(var5_5, (String)var9_16 /* !! */ )) != null) continue;
                    var6_6.add(var4_4);
                }
                var34_37 = var6_6.isEmpty();
                if (!var34_37) {
                    var6_6.addAll(var7_14);
                    var7_14 = var6_6;
                } else {
                    var6_6 = var3_3.zza.zzx.zzat().zzc();
                    var8_15 = "No unique parameters in main event. eventName";
                    var6_6.zzb((String)var8_15, var14_20);
                }
                var6_6 = var14_20;
            } else {
                var3_3.zza.zzx.zzat().zzc().zzc("Extra parameter without existing main event. eventName, eventId", var14_20, var9_16 /* !! */ );
                return null;
                {
                    catch (Throwable var6_12) {
                        var10_17 = var24_28;
                    }
                }
lbl194:
                // 2 sources

                if (var10_17 != null) {
                    var10_17.close();
                }
                throw var6_13;
lbl197:
                // 1 sources

                this.zzc = var9_16 /* !! */ ;
                this.zzb = var2_2;
                this.zza.zza.zzn();
                var8_15 = var12_19;
                var10_17 = zzkf.zzA(var2_2, "_epc");
                if (var10_17 != null) {
                    var8_15 = var10_17;
                }
                var8_15 = (Long)var8_15;
                var3_3.zzd = var35_39 = var8_15.longValue();
                var34_38 /* !! */  = (long)(var35_39 == var12_19 ? 0 : (var35_39 < var12_19 ? -1 : 1));
                if (var34_38 /* !! */  <= 0) {
                    var8_15 = var3_3.zza.zzx.zzat().zzc();
                    var4_4 = "Complex event with zero extra param count. eventName";
                    var8_15.zzb((String)var4_4, var6_6);
                } else {
                    var8_15 = var3_3.zza.zza.zzi();
                    var9_16 /* !! */  = (Long)Preconditions.checkNotNull(var9_16 /* !! */ );
                    var30_33 = var3_3.zzd;
                    var4_4 = var1_1;
                    var32_35 = var2_2;
                    var8_15.zzH(var1_1, (Long)var9_16 /* !! */ , var30_33, var2_2);
                }
            }
        }
        var8_15 = (zzda)var2_2.zzbu();
        var8_15.zzl((String)var6_6);
        var8_15.zzi();
        var8_15.zzh((Iterable)var7_14);
        return (zzdb)var8_15.zzaA();
    }
}

