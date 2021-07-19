/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzgi;
import com.google.android.gms.internal.mlkit_common.zzgk;
import com.google.android.gms.internal.mlkit_common.zzgl;
import com.google.android.gms.internal.mlkit_common.zzhk;
import com.google.android.gms.internal.mlkit_common.zzik;
import com.google.android.gms.internal.mlkit_common.zzip;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzgn
extends zzgl {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgn() {
        super(null);
    }

    public /* synthetic */ zzgn(zzgk zzgk2) {
        this();
    }

    private static List zzb(Object object, long l10) {
        return (List)zzip.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzfy zzfy2 = (zzfy)zzip.zzf(object, l10);
        boolean bl2 = zzfy2 instanceof zzgi;
        if (bl2) {
            zzfy2 = ((zzgi)((Object)zzfy2)).a_();
        } else {
            Class clazz = zza;
            Class<?> clazz2 = zzfy2.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            bl2 = zzfy2 instanceof zzhk;
            if (bl2 && (bl2 = zzfy2 instanceof zzfy)) {
                boolean bl3 = (zzfy2 = (zzfy)zzfy2).zza();
                if (bl3) {
                    zzfy2.b_();
                }
                return;
            }
            zzfy2 = Collections.unmodifiableList(zzfy2);
        }
        zzip.zza(object, l10, zzfy2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(Object var1_1, Object var2_2, long var3_3) {
        var2_2 = zzgn.zzb(var2_2, var3_3);
        var5_4 = var2_2.size();
        var6_5 /* !! */  = zzgn.zzb(var1_1, var3_3);
        var7_6 = var6_5 /* !! */ .isEmpty();
        if (var7_6 != 0) {
            var7_6 = var6_5 /* !! */  instanceof zzgi;
            if (var7_6 != 0) {
                var6_5 /* !! */  = new ArrayList<E>(var5_4);
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzhk;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzfy) != 0) {
                    var8_7 = ((zzfy)var6_5 /* !! */ ).zzb(var5_4);
                    var6_5 /* !! */  = var8_7;
                } else {
                    var6_5 /* !! */  = new ArrayList<E>(var5_4);
                }
            }
            zzip.zza(var1_1, var3_3, var6_5 /* !! */ );
        } else {
            var9_8 = zzgn.zza;
            var10_9 = var6_5 /* !! */ .getClass();
            var7_6 = var9_8.isAssignableFrom(var10_9);
            if (var7_6 != 0) {
                var11_10 = var6_5 /* !! */ .size() + var5_4;
                var9_8 = new Object(var11_10);
                var9_8.addAll(var6_5 /* !! */ );
                zzip.zza(var1_1, var3_3, var9_8);
lbl27:
                // 2 sources

                while (true) {
                    var6_5 /* !! */  = var9_8;
                    break;
                }
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzik;
                if (var7_6 != 0) {
                    var11_11 = ((List)var6_5 /* !! */ ).size() + var5_4;
                    var9_8 = new Object(var11_11);
                    var6_5 /* !! */  = (zzik)var6_5 /* !! */ ;
                    var9_8.addAll(var6_5 /* !! */ );
                    zzip.zza(var1_1, var3_3, var9_8);
                    ** continue;
                }
                var7_6 = var6_5 /* !! */  instanceof zzhk;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzfy) != 0) {
                    var9_8 = var6_5 /* !! */ ;
                    var9_8 = (zzfy)var6_5 /* !! */ ;
                    var11_12 = var9_8.zza();
                    if (!var11_12) {
                        var12_13 = ((List)var6_5 /* !! */ ).size() + var5_4;
                        var6_5 /* !! */  = var9_8.zzb(var12_13);
                        zzip.zza(var1_1, var3_3, var6_5 /* !! */ );
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
        zzip.zza(var1_1, var3_3, var2_2);
    }
}

