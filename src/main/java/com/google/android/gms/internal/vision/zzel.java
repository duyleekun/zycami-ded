/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzdq;
import com.google.android.gms.internal.vision.zzdz;
import com.google.android.gms.internal.vision.zzec;
import com.google.android.gms.internal.vision.zzef;
import com.google.android.gms.internal.vision.zzei;
import com.google.android.gms.internal.vision.zzej;
import com.google.android.gms.internal.vision.zzek;
import com.google.android.gms.internal.vision.zzem;
import com.google.android.gms.internal.vision.zzeq;
import com.google.android.gms.internal.vision.zzes;
import com.google.android.gms.internal.vision.zzev;
import com.google.android.gms.internal.vision.zzex;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.SortedSet;

public final class zzel
extends zzek {
    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final zzem zzdb() {
        var1_1 = this.zzng.entrySet();
        var2_2 = var1_1.isEmpty();
        if (var2_2) {
            return zzdz.zzmt;
        }
        var4_4 = var1_1.size();
        var3_3 /* !! */  = new zzei(var4_4);
        var1_1 = var1_1.iterator();
        var5_5 = 0;
        while (true) {
            block21: {
                block19: {
                    block20: {
                        var6_6 = var1_1.hasNext();
                        var7_7 = 0;
                        var8_8 = null;
                        var9_9 = 1;
                        if (var6_6 == 0) break;
                        var10_10 = (Map.Entry)var1_1.next();
                        var11_11 = var10_10.getKey();
                        var12_12 = (var10_10 = (Collection)var10_10.getValue()) instanceof zzej;
                        if (var12_12 == 0 || (var12_12 = var10_10 instanceof SortedSet) != 0) break block20;
                        var13_13 = var10_10;
                        var13_13 = (zzej)var10_10;
                        var14_14 = var13_13.zzcu();
                        if (var14_14 == 0) break block19;
                    }
                    var10_10 = ((Collection)var10_10).toArray();
                    var12_12 = var10_10.length;
                    while (var12_12 != 0) {
                        if (var12_12 != var9_9) {
                            var14_14 = zzej.zzy(var12_12);
                            var15_15 = new Object[var14_14];
                            var16_16 = var14_14 + -1;
                            var18_18 = 0;
                            var19_19 = 0;
                            for (var17_17 = 0; var17_17 < var12_12; ++var17_17) {
                                var20_20 = zzeq.zzb(var10_10[var17_17], var17_17);
                                var21_21 = var20_20.hashCode();
                                var22_22 = zzec.zzx(var21_21);
                                while (true) {
                                    if ((var24_24 = var15_15[var23_23 = var22_22 & var16_16]) == null) {
                                        var9_9 = var18_18 + 1;
                                        var10_10[var18_18] = var20_20;
                                        var15_15[var23_23] = var20_20;
                                        var19_19 += var21_21;
                                        var18_18 = var9_9;
                                        break;
                                    }
                                    var9_9 = (int)var24_24.equals(var20_20);
                                    if (var9_9 != 0) break;
                                    ++var22_22;
                                    var9_9 = 1;
                                }
                                var9_9 = 1;
                            }
                            Arrays.fill(var10_10, var18_18, var12_12, null);
                            var4_4 = 1;
                            if (var18_18 == var4_4) {
                                var4_4 = 0;
                                var20_20 = null;
                                var10_10 = var10_10[0];
                                var13_13 = new zzex(var10_10, var19_19);
                            } else {
                                var4_4 = zzej.zzy(var18_18);
                                if (var4_4 < (var14_14 /= 2)) {
                                    var12_12 = var18_18;
                                    var9_9 = 1;
                                    continue;
                                }
                                var4_4 = var10_10.length;
                                var7_7 = var4_4 >> 1;
                                if (var18_18 < (var7_7 += (var4_4 >>= 2))) {
                                    var10_10 = Arrays.copyOf(var10_10, var18_18);
                                }
                                var4_4 = var18_18;
                                var21_21 = var18_18;
                                var13_13 = new zzev(var10_10, var19_19, var15_15, var16_16, var18_18);
                            }
                        } else {
                            var4_4 = 0;
                            var20_20 = null;
                            var10_10 = var10_10[0];
                            var13_13 = new zzex(var10_10);
                        }
                        break block19;
                    }
                    var13_13 = zzev.zznq;
                }
                var4_4 = (int)var13_13.isEmpty();
                if (var4_4 != 0) break block21;
                var4_4 = var3_3 /* !! */ .size;
                var6_6 = 1;
                var8_8 = var3_3 /* !! */ .zznd;
                var9_9 = var8_8.length;
                if ((var4_4 = var4_4 + var6_6 << var6_6) <= var9_9) ** GOTO lbl103
                var9_9 = var8_8.length;
                if (var4_4 >= 0) {
                    var14_14 = var9_9 >> 1;
                    if ((var9_9 = var9_9 + var14_14 + var6_6) < var4_4) {
                        var4_4 = Integer.highestOneBit(var4_4 + -1);
                        var9_9 = var4_4 << 1;
                    }
                    if (var9_9 < 0) {
                        var9_9 = -1 >>> 1;
                    }
                    var20_20 = Arrays.copyOf(var8_8, var9_9);
                    var3_3 /* !! */ .zznd = var20_20;
                    var4_4 = 0;
                    var20_20 = null;
                    var3_3 /* !! */ .zzne = false;
                } else {
                    var1_1 = new AssertionError((Object)"cannot store more than MAX_VALUE elements");
                    throw var1_1;
lbl103:
                    // 1 sources

                    var4_4 = 0;
                    var20_20 = null;
                }
                zzdq.zza(var11_11, var13_13);
                var10_10 = var3_3 /* !! */ .zznd;
                var7_7 = var3_3 /* !! */ .size;
                var9_9 = var7_7 * 2;
                var10_10[var9_9] = var11_11;
                var9_9 = var7_7 * 2;
                var25_25 = 1;
                var10_10[var9_9 += var25_25] = var13_13;
                var3_3 /* !! */ .size = var7_7 += var25_25;
                var6_6 = var13_13.size();
                var5_5 += var6_6;
                continue;
            }
            var4_4 = 0;
            var20_20 = null;
        }
        var25_25 = var9_9;
        var3_3 /* !! */ .zzne = var9_9;
        var4_4 = var3_3 /* !! */ .size;
        var3_3 /* !! */  = var3_3 /* !! */ .zznd;
        var3_3 /* !! */  = zzes.zza(var4_4, var3_3 /* !! */ );
        var1_1 = new zzem((zzef)var3_3 /* !! */ , var5_5, null);
        return var1_1;
    }
}

