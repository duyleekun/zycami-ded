/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzao;
import com.google.android.gms.internal.mlkit_vision_common.zzap;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzac$zze
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzac$zze zza;
    private static final /* enum */ zzr$zzac$zze zzb;
    private static final /* enum */ zzr$zzac$zze zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzac$zze[] zzf;
    private final int zze;

    static {
        zzr$zzac$zze zzr$zzac$zze;
        zzr$zzac$zze zzr$zzac$zze2;
        Object object = new zzr$zzac$zze("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzac$zze2 = new zzr$zzac$zze("FAST", n10, n10);
        int n11 = 2;
        zzc = zzr$zzac$zze = new zzr$zzac$zze("ACCURATE", n11, n11);
        zzr$zzac$zze[] zzr$zzac$zzeArray = new zzr$zzac$zze[3];
        zzr$zzac$zzeArray[0] = object;
        zzr$zzac$zzeArray[n10] = zzr$zzac$zze2;
        zzr$zzac$zzeArray[n11] = zzr$zzac$zze;
        zzf = zzr$zzac$zzeArray;
        zzd = object = new zzao();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzac$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzac$zze[] values() {
        return (zzr$zzac$zze[])zzf.clone();
    }

    public static zzen zzb() {
        return zzap.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzac$zze.class.getName();
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

