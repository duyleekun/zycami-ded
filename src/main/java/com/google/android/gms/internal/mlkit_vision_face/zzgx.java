/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzgv;
import com.google.android.gms.internal.mlkit_vision_face.zzgw;
import com.google.android.gms.internal.mlkit_vision_face.zzgy;
import com.google.android.gms.internal.mlkit_vision_face.zzhy;
import com.google.android.gms.internal.mlkit_vision_face.zziy;
import com.google.android.gms.internal.mlkit_vision_face.zziz;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzgx
extends zzgv {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgx() {
        super(null);
    }

    public /* synthetic */ zzgx(zzgy zzgy2) {
        this();
    }

    private static List zzb(Object object, long l10) {
        return (List)zziz.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzgm zzgm2 = (zzgm)zziz.zzf(object, l10);
        boolean bl2 = zzgm2 instanceof zzgw;
        if (bl2) {
            zzgm2 = ((zzgw)((Object)zzgm2)).zze();
        } else {
            Class clazz = zza;
            Class<?> clazz2 = zzgm2.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            bl2 = zzgm2 instanceof zzhy;
            if (bl2 && (bl2 = zzgm2 instanceof zzgm)) {
                boolean bl3 = (zzgm2 = (zzgm)zzgm2).zza();
                if (bl3) {
                    zzgm2.zzb();
                }
                return;
            }
            zzgm2 = Collections.unmodifiableList(zzgm2);
        }
        zziz.zza(object, l10, zzgm2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(Object var1_1, Object var2_2, long var3_3) {
        var2_2 = zzgx.zzb(var2_2, var3_3);
        var5_4 = var2_2.size();
        var6_5 /* !! */  = zzgx.zzb(var1_1, var3_3);
        var7_6 = var6_5 /* !! */ .isEmpty();
        if (var7_6 != 0) {
            var7_6 = var6_5 /* !! */  instanceof zzgw;
            if (var7_6 != 0) {
                var6_5 /* !! */  = new ArrayList<E>(var5_4);
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzhy;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzgm) != 0) {
                    var8_7 = ((zzgm)var6_5 /* !! */ ).zzb(var5_4);
                    var6_5 /* !! */  = var8_7;
                } else {
                    var6_5 /* !! */  = new ArrayList<E>(var5_4);
                }
            }
            zziz.zza(var1_1, var3_3, var6_5 /* !! */ );
        } else {
            var9_8 = zzgx.zza;
            var10_9 = var6_5 /* !! */ .getClass();
            var7_6 = var9_8.isAssignableFrom(var10_9);
            if (var7_6 != 0) {
                var11_10 = var6_5 /* !! */ .size() + var5_4;
                var9_8 = new Object(var11_10);
                var9_8.addAll(var6_5 /* !! */ );
                zziz.zza(var1_1, var3_3, var9_8);
lbl27:
                // 2 sources

                while (true) {
                    var6_5 /* !! */  = var9_8;
                    break;
                }
            } else {
                var7_6 = var6_5 /* !! */  instanceof zziy;
                if (var7_6 != 0) {
                    var11_11 = ((List)var6_5 /* !! */ ).size() + var5_4;
                    var9_8 = new Object(var11_11);
                    var6_5 /* !! */  = (zziy)var6_5 /* !! */ ;
                    var9_8.addAll(var6_5 /* !! */ );
                    zziz.zza(var1_1, var3_3, var9_8);
                    ** continue;
                }
                var7_6 = var6_5 /* !! */  instanceof zzhy;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzgm) != 0) {
                    var9_8 = var6_5 /* !! */ ;
                    var9_8 = (zzgm)var6_5 /* !! */ ;
                    var11_12 = var9_8.zza();
                    if (!var11_12) {
                        var12_13 = ((List)var6_5 /* !! */ ).size() + var5_4;
                        var6_5 /* !! */  = var9_8.zzb(var12_13);
                        zziz.zza(var1_1, var3_3, var6_5 /* !! */ );
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
        zziz.zza(var1_1, var3_3, var2_2);
    }
}

