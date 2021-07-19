/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzfb;
import com.google.android.gms.internal.mlkit_vision_common.zzfc;
import com.google.android.gms.internal.mlkit_vision_common.zzfe;
import com.google.android.gms.internal.mlkit_vision_common.zzge;
import com.google.android.gms.internal.mlkit_vision_common.zzhe;
import com.google.android.gms.internal.mlkit_vision_common.zzhf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzfd
extends zzfb {
    private static final Class zza = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzfd() {
        super(null);
    }

    public /* synthetic */ zzfd(zzfe zzfe2) {
        this();
    }

    private static List zzb(Object object, long l10) {
        return (List)zzhf.zzf(object, l10);
    }

    public final void zza(Object object, long l10) {
        zzes zzes2 = (zzes)zzhf.zzf(object, l10);
        boolean bl2 = zzes2 instanceof zzfc;
        if (bl2) {
            zzes2 = ((zzfc)((Object)zzes2)).zze();
        } else {
            Class clazz = zza;
            Class<?> clazz2 = zzes2.getClass();
            bl2 = clazz.isAssignableFrom(clazz2);
            if (bl2) {
                return;
            }
            bl2 = zzes2 instanceof zzge;
            if (bl2 && (bl2 = zzes2 instanceof zzes)) {
                boolean bl3 = (zzes2 = (zzes)zzes2).zza();
                if (bl3) {
                    zzes2.zzb();
                }
                return;
            }
            zzes2 = Collections.unmodifiableList(zzes2);
        }
        zzhf.zza(object, l10, zzes2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public final void zza(Object var1_1, Object var2_2, long var3_3) {
        var2_2 = zzfd.zzb(var2_2, var3_3);
        var5_4 = var2_2.size();
        var6_5 /* !! */  = zzfd.zzb(var1_1, var3_3);
        var7_6 = var6_5 /* !! */ .isEmpty();
        if (var7_6 != 0) {
            var7_6 = var6_5 /* !! */  instanceof zzfc;
            if (var7_6 != 0) {
                var6_5 /* !! */  = new ArrayList<E>(var5_4);
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzge;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzes) != 0) {
                    var8_7 = ((zzes)var6_5 /* !! */ ).zzb(var5_4);
                    var6_5 /* !! */  = var8_7;
                } else {
                    var6_5 /* !! */  = new ArrayList<E>(var5_4);
                }
            }
            zzhf.zza(var1_1, var3_3, var6_5 /* !! */ );
        } else {
            var9_8 = zzfd.zza;
            var10_9 = var6_5 /* !! */ .getClass();
            var7_6 = var9_8.isAssignableFrom(var10_9);
            if (var7_6 != 0) {
                var11_10 = var6_5 /* !! */ .size() + var5_4;
                var9_8 = new Object(var11_10);
                var9_8.addAll(var6_5 /* !! */ );
                zzhf.zza(var1_1, var3_3, var9_8);
lbl27:
                // 2 sources

                while (true) {
                    var6_5 /* !! */  = var9_8;
                    break;
                }
            } else {
                var7_6 = var6_5 /* !! */  instanceof zzhe;
                if (var7_6 != 0) {
                    var11_11 = ((List)var6_5 /* !! */ ).size() + var5_4;
                    var9_8 = new Object(var11_11);
                    var6_5 /* !! */  = (zzhe)var6_5 /* !! */ ;
                    var9_8.addAll(var6_5 /* !! */ );
                    zzhf.zza(var1_1, var3_3, var9_8);
                    ** continue;
                }
                var7_6 = var6_5 /* !! */  instanceof zzge;
                if (var7_6 != 0 && (var7_6 = var6_5 /* !! */  instanceof zzes) != 0) {
                    var9_8 = var6_5 /* !! */ ;
                    var9_8 = (zzes)var6_5 /* !! */ ;
                    var11_12 = var9_8.zza();
                    if (!var11_12) {
                        var12_13 = ((List)var6_5 /* !! */ ).size() + var5_4;
                        var6_5 /* !! */  = var9_8.zzb(var12_13);
                        zzhf.zza(var1_1, var3_3, var6_5 /* !! */ );
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
        zzhf.zza(var1_1, var3_3, var2_2);
    }
}

