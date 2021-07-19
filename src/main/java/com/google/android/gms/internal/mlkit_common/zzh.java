/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import com.google.android.gms.internal.mlkit_common.zzad;
import com.google.android.gms.internal.mlkit_common.zze;
import com.google.android.gms.internal.mlkit_common.zzg;
import com.google.android.gms.internal.mlkit_common.zzo;
import com.google.android.gms.internal.mlkit_common.zzq;
import com.google.android.gms.internal.mlkit_common.zzr;

public final class zzh {
    public static final zzh zza = zzh.zza().zzb().zzc();
    private static final zzh zzb = zzh.zza().zza().zzc();
    private final boolean zzc;
    private final boolean zzd;
    private final zzad zze;

    private zzh(boolean bl2, boolean bl3, zzad zzad2) {
        this.zzc = bl2;
        this.zzd = false;
        this.zze = zzad2;
    }

    public /* synthetic */ zzh(boolean bl2, boolean bl3, zzad zzad2, zze zze2) {
        this(bl2, false, zzad2);
    }

    public static /* synthetic */ int zza(zzh zzh2, Context context, zzr zzr2) {
        zzad zzad2 = zzh2.zze;
        int n10 = zzad2.size();
        int n11 = 0;
        while (n11 < n10) {
            Object object = zzad2.get(n11);
            ++n11;
            object = (zzo)object;
            int[] nArray = com.google.android.gms.internal.mlkit_common.zze.zza;
            int n12 = zzh2.zzc;
            int n13 = ((zzo)object).zza(context, zzr2, n12 != 0);
            n12 = 1;
            n13 -= n12;
            if ((n13 = nArray[n13]) != n12) {
                int n14 = 2;
                if (n13 != n14) continue;
                return zzq.zzb;
            }
            return zzq.zza;
        }
        return zzq.zzc;
    }

    private static zzg zza() {
        zzg zzg2 = new zzg(null);
        return zzg2;
    }

    public static /* synthetic */ boolean zza(zzh zzh2) {
        return zzh2.zzc;
    }

    public static /* synthetic */ boolean zzb(zzh zzh2) {
        return zzh2.zzd;
    }
}

