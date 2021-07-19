/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbp;
import com.google.android.gms.internal.mlkit_vision_common.zzbq;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzba$zzc
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzba$zzc zza;
    private static final /* enum */ zzr$zzba$zzc zzb;
    private static final /* enum */ zzr$zzba$zzc zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzba$zzc[] zzf;
    private final int zze;

    static {
        zzr$zzba$zzc zzr$zzba$zzc;
        zzr$zzba$zzc zzr$zzba$zzc2;
        Object object = new zzr$zzba$zzc("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzba$zzc2 = new zzr$zzba$zzc("FAST", n10, n10);
        int n11 = 2;
        zzc = zzr$zzba$zzc = new zzr$zzba$zzc("ACCURATE", n11, n11);
        zzr$zzba$zzc[] zzr$zzba$zzcArray = new zzr$zzba$zzc[3];
        zzr$zzba$zzcArray[0] = object;
        zzr$zzba$zzcArray[n10] = zzr$zzba$zzc2;
        zzr$zzba$zzcArray[n11] = zzr$zzba$zzc;
        zzf = zzr$zzba$zzcArray;
        zzd = object = new zzbq();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzba$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzba$zzc[] values() {
        return (zzr$zzba$zzc[])zzf.clone();
    }

    public static zzen zzb() {
        return zzbp.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzba$zzc.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zze;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zze;
    }
}

