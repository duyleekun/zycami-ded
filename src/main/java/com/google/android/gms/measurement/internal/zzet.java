/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzex;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzet {
    public final /* synthetic */ zzex zza;
    private final String zzb;
    private final Bundle zzc;
    private Bundle zzd;

    public zzet(zzex object, String string2, Bundle bundle) {
        this.zza = object;
        object = "default_event_parameters";
        Preconditions.checkNotEmpty((String)object);
        this.zzb = object;
        object = new Bundle();
        this.zzc = object;
    }

    /*
     * Unable to fully structure code
     */
    public final Bundle zza() {
        block38: {
            block39: {
                var1_1 = this.zzd;
                if (var1_1 != null) break block38;
                var1_1 = this.zza.zzd();
                var2_2 = this.zzb;
                var3_3 = null;
                if ((var1_1 = var1_1.getString(var2_2, null)) == null) break block39;
                var2_2 = new Bundle();
                var3_3 = new JSONArray((String)var1_1);
                var1_1 = null;
                var4_4 = 0;
                while (true) {
                    block40: {
                        block36: {
                            block37: {
                                var5_5 = var3_3.length();
                                if (var4_4 >= var5_5) break;
                                var6_6 = var3_3.getJSONObject(var4_4);
                                var7_7 = "n";
                                var7_7 = var6_6.getString(var7_7);
                                var8_8 = "t";
                                var8_8 = var6_6.getString(var8_8);
                                var9_9 = var8_8.hashCode();
                                var10_10 = 100;
                                var11_11 = 2;
                                var12_12 = 1;
                                if (var9_9 == var10_10) break block36;
                                var10_10 = 108;
                                if (var9_9 == var10_10) break block37;
                                var10_10 = 115;
                                if (var9_9 != var10_10 || (var9_9 = (int)var8_8.equals(var13_13 = "s")) == 0) ** GOTO lbl-1000
                                var9_9 = 0;
                                var13_13 = null;
                                break block40;
                            }
                            var13_13 = "l";
                            var9_9 = (int)var8_8.equals(var13_13);
                            if (var9_9 == 0) ** GOTO lbl-1000
                            var9_9 = var11_11;
                            break block40;
                        }
                        var13_13 = "d";
                        var9_9 = (int)var8_8.equals(var13_13);
                        if (var9_9 != 0) {
                            var9_9 = var12_12;
                        } else lbl-1000:
                        // 3 sources

                        {
                            var9_9 = -1;
                        }
                    }
                    var14_14 = "v";
                    if (var9_9 != 0) {
                        if (var9_9 != var12_12) {
                            if (var9_9 != var11_11) {
                                var6_6 = this.zza;
                                var6_6 = var6_6.zzx;
                                var6_6 = var6_6.zzat();
                                var6_6 = var6_6.zzb();
                                var7_7 = "Unrecognized persisted bundle type. Type";
                                var6_6.zzb(var7_7, var8_8);
                            }
                            var6_6 = var6_6.getString(var14_14);
                            var15_15 = Long.parseLong((String)var6_6);
                            var2_2.putLong(var7_7, var15_15);
                        }
                        var6_6 = var6_6.getString(var14_14);
                        var17_16 = Double.parseDouble((String)var6_6);
                        var2_2.putDouble(var7_7, var17_16);
                    }
                    var6_6 = var6_6.getString(var14_14);
                    try {
                        var2_2.putString(var7_7, (String)var6_6);
                    }
                    catch (NumberFormatException | JSONException v0) {
                        var6_6 = this.zza;
                        var6_6 = var6_6.zzx;
                        var6_6 = var6_6.zzat();
                        var6_6 = var6_6.zzb();
                        var7_7 = "Error reading value from SharedPreferences. Value dropped";
                        var6_6.zza(var7_7);
                    }
                    ++var4_4;
                }
                this.zzd = var2_2;
                {
                    catch (JSONException v1) {
                        var1_1 = this.zza.zzx.zzat().zzb();
                        var2_2 = "Error loading bundle from SharedPreferences. Values will be lost";
                        var1_1.zza(var2_2);
                    }
                }
            }
            if ((var1_1 = this.zzd) == null) {
                var1_1 = this.zzc;
                this.zzd = var1_1;
            }
        }
        return this.zzd;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(Bundle var1_1) {
        block21: {
            block20: {
                if (var1_1 == null) {
                    var1_1 = new Bundle();
                }
                var2_2 = this.zza.zzd().edit();
                var3_3 = var1_1.size();
                if (var3_3 != 0) break block20;
                var4_4 = this.zzb;
                var2_2.remove(var4_4);
                break block21;
            }
            var4_5 = this.zzb;
            var5_6 /* !! */  = new JSONArray();
            var6_7 = var1_1.keySet().iterator();
            while (var7_8 = var6_7.hasNext()) {
                block19: {
                    var8_9 = (String)var6_7.next();
                    var9_11 = var1_1.get((String)var8_9);
                    if (var9_11 == null) continue;
                    var10_12 /* !! */  = new JSONObject();
                    var11_13 = "n";
                    var10_12 /* !! */ .put(var11_13, var8_9);
                    var8_9 = "v";
                    var11_13 = String.valueOf(var9_11);
                    var10_12 /* !! */ .put((String)var8_9, (Object)var11_13);
                    var7_8 = var9_11 instanceof String;
                    var11_13 = "t";
                    if (var7_8) {
                        var8_9 = "s";
                        var10_12 /* !! */ .put(var11_13, var8_9);
                        break block19;
                    }
                    var7_8 = var9_11 instanceof Long;
                    if (var7_8) {
                        var8_9 = "l";
                        var10_12 /* !! */ .put(var11_13, var8_9);
                        break block19;
                    }
                    var7_8 = var9_11 instanceof Double;
                    if (!var7_8) ** GOTO lbl56
                    var8_9 = "d";
                    var10_12 /* !! */ .put(var11_13, var8_9);
                }
                var5_6 /* !! */ .put((Object)var10_12 /* !! */ );
                continue;
lbl56:
                // 1 sources

                var8_9 = this.zza;
                var8_9 = var8_9.zzx;
                var8_9 = var8_9.zzat();
                var8_9 = var8_9.zzb();
                var10_12 /* !! */  = "Cannot serialize bundle value to SharedPreferences. Type";
                var9_11 = var9_11.getClass();
                try {
                    var8_9.zzb((String)var10_12 /* !! */ , var9_11);
                }
                catch (JSONException var8_10) {
                    var9_11 = this.zza.zzx.zzat().zzb();
                    var10_12 /* !! */  = "Cannot serialize bundle value to SharedPreferences";
                    var9_11.zzb((String)var10_12 /* !! */ , (Object)var8_10);
                }
            }
            var5_6 /* !! */  = var5_6 /* !! */ .toString();
            var2_2.putString(var4_5, (String)var5_6 /* !! */ );
        }
        var2_2.apply();
        this.zzd = var1_1;
    }
}

