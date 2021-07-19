/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzih;
import com.google.android.gms.internal.measurement.zzii;
import com.google.android.gms.internal.measurement.zzil;
import com.google.android.gms.internal.measurement.zzje;
import com.google.android.gms.internal.measurement.zzkb;
import com.google.android.gms.internal.measurement.zzkh;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzij
extends zzil {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzij() {
        super(null);
    }

    public /* synthetic */ zzij(zzii zzii2) {
        super(null);
    }

    public final void zza(Object object, long l10) {
        zzhz zzhz2 = (zzhz)zzkh.zzn(object, l10);
        boolean bl2 = zzhz2 instanceof zzih;
        if (bl2) {
            zzhz2 = ((zzih)((Object)zzhz2)).zzi();
        } else {
            Class clazz = zza;
            Class<?> clazz2 = zzhz2.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            bl2 = zzhz2 instanceof zzje;
            if (bl2 && (bl2 = zzhz2 instanceof zzhz)) {
                boolean bl3 = (zzhz2 = (zzhz)zzhz2).zza();
                if (bl3) {
                    zzhz2.zzb();
                }
                return;
            }
            zzhz2 = Collections.unmodifiableList(zzhz2);
        }
        zzkh.zzo(object, l10, zzhz2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zzb(Object var1_1, Object var2_2, long var3_3) {
        var2_2 = (List)zzkh.zzn(var2_2, var3_3);
        var5_4 = var2_2.size();
        var6_5 /* !! */  = (ArrayList<E>)zzkh.zzn(var1_1, var3_3);
        var7_6 = var6_5 /* !! */ .isEmpty();
        if (var7_6 != 0) {
            var7_6 = var6_5 /* !! */  instanceof zzih;
            if (var7_6 != 0) {
                var6_5 /* !! */  = new ArrayList<E>(var5_4);
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzje;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzhz) != 0) {
                    var8_7 = ((zzhz)var6_5 /* !! */ ).zze(var5_4);
                    var6_5 /* !! */  = var8_7;
                } else {
                    var6_5 /* !! */  = new ArrayList<E>(var5_4);
                }
            }
            zzkh.zzo(var1_1, var3_3, var6_5 /* !! */ );
        } else {
            var9_8 = zzij.zza;
            var10_9 = var6_5 /* !! */ .getClass();
            var7_6 = var9_8.isAssignableFrom(var10_9);
            if (var7_6 != 0) {
                var11_10 = var6_5 /* !! */ .size() + var5_4;
                var9_8 = new Object(var11_10);
                var9_8.addAll(var6_5 /* !! */ );
                zzkh.zzo(var1_1, var3_3, var9_8);
lbl27:
                // 2 sources

                while (true) {
                    var6_5 /* !! */  = var9_8;
                    break;
                }
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzkb;
                if (var7_6 != 0) {
                    var11_11 = ((List)var6_5 /* !! */ ).size() + var5_4;
                    var9_8 = new Object(var11_11);
                    var6_5 /* !! */  = (zzkb)var6_5 /* !! */ ;
                    var5_4 = var9_8.size();
                    var9_8.addAll(var5_4, var6_5 /* !! */ );
                    zzkh.zzo(var1_1, var3_3, var9_8);
                    ** continue;
                }
                var7_6 = var6_5 /* !! */  instanceof zzje;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzhz) != 0) {
                    var9_8 = var6_5 /* !! */ ;
                    var9_8 = (zzhz)var6_5 /* !! */ ;
                    var11_12 = var9_8.zza();
                    if (!var11_12) {
                        var12_13 = ((List)var6_5 /* !! */ ).size() + var5_4;
                        var6_5 /* !! */  = var9_8.zze(var12_13);
                        zzkh.zzo(var1_1, var3_3, var6_5 /* !! */ );
                    }
                }
            }
        }
        var5_4 = ((List)var6_5 /* !! */ ).size();
        var7_6 = var2_2.size();
        if (var5_4 > 0 && var7_6 > 0) {
            ((List)var6_5 /* !! */ ).addAll(var2_2);
        }
        if (var5_4 > 0) {
            var2_2 = var6_5 /* !! */ ;
        }
        zzkh.zzo(var1_1, var3_3, var2_2);
    }
}

