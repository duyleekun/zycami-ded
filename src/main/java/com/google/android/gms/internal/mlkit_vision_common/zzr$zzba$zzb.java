/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbn;
import com.google.android.gms.internal.mlkit_vision_common.zzbo;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzba$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzba$zzb zza;
    private static final /* enum */ zzr$zzba$zzb zzb;
    private static final /* enum */ zzr$zzba$zzb zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzba$zzb[] zzf;
    private final int zze;

    static {
        zzr$zzba$zzb zzr$zzba$zzb;
        zzr$zzba$zzb zzr$zzba$zzb2;
        Object object = new zzr$zzba$zzb("INVALID_MODE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzba$zzb2 = new zzr$zzba$zzb("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzr$zzba$zzb = new zzr$zzba$zzb("SINGLE_IMAGE", n11, n11);
        zzr$zzba$zzb[] zzr$zzba$zzbArray = new zzr$zzba$zzb[3];
        zzr$zzba$zzbArray[0] = object;
        zzr$zzba$zzbArray[n10] = zzr$zzba$zzb2;
        zzr$zzba$zzbArray[n11] = zzr$zzba$zzb;
        zzf = zzr$zzba$zzbArray;
        zzd = object = new zzbn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzba$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzba$zzb[] values() {
        return (zzr$zzba$zzb[])zzf.clone();
    }

    public static zzen zzb() {
        return zzbo.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzba$zzb.class.getName();
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

