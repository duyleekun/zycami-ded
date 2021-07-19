/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzcf;
import com.google.android.gms.internal.mlkit_vision_common.zzcg;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzcc$zzb$zzb
extends Enum
implements zzel {
    private static final /* enum */ zzcc$zzb$zzb zza;
    private static final /* enum */ zzcc$zzb$zzb zzb;
    private static final /* enum */ zzcc$zzb$zzb zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzcc$zzb$zzb[] zzf;
    private final int zze;

    static {
        zzcc$zzb$zzb zzcc$zzb$zzb;
        zzcc$zzb$zzb zzcc$zzb$zzb2;
        Object object = new zzcc$zzb$zzb("CLASSIFICATION_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcc$zzb$zzb2 = new zzcc$zzb$zzb("CLASSIFICATION_NONE", n10, n10);
        int n11 = 2;
        zzc = zzcc$zzb$zzb = new zzcc$zzb$zzb("CLASSIFICATION_ALL", n11, n11);
        zzcc$zzb$zzb[] zzcc$zzb$zzbArray = new zzcc$zzb$zzb[3];
        zzcc$zzb$zzbArray[0] = object;
        zzcc$zzb$zzbArray[n10] = zzcc$zzb$zzb2;
        zzcc$zzb$zzbArray[n11] = zzcc$zzb$zzb;
        zzf = zzcc$zzb$zzbArray;
        zzd = object = new zzcf();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcc$zzb$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzcc$zzb$zzb[] values() {
        return (zzcc$zzb$zzb[])zzf.clone();
    }

    public static zzen zzb() {
        return zzcg.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcc$zzb$zzb.class.getName();
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

