/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzch;
import com.google.android.gms.internal.mlkit_vision_common.zzci;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzcc$zzb$zzc
extends Enum
implements zzel {
    private static final /* enum */ zzcc$zzb$zzc zza;
    private static final /* enum */ zzcc$zzb$zzc zzb;
    private static final /* enum */ zzcc$zzb$zzc zzc;
    private static final /* enum */ zzcc$zzb$zzc zzd;
    private static final zzeo zze;
    private static final /* synthetic */ zzcc$zzb$zzc[] zzg;
    private final int zzf;

    static {
        zzcc$zzb$zzc zzcc$zzb$zzc;
        zzcc$zzb$zzc zzcc$zzb$zzc2;
        zzcc$zzb$zzc zzcc$zzb$zzc3;
        Object object = new zzcc$zzb$zzc("LANDMARK_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzcc$zzb$zzc3 = new zzcc$zzb$zzc("LANDMARK_NONE", n10, n10);
        int n11 = 2;
        zzc = zzcc$zzb$zzc2 = new zzcc$zzb$zzc("LANDMARK_ALL", n11, n11);
        int n12 = 3;
        zzd = zzcc$zzb$zzc = new zzcc$zzb$zzc("LANDMARK_CONTOUR", n12, n12);
        zzcc$zzb$zzc[] zzcc$zzb$zzcArray = new zzcc$zzb$zzc[4];
        zzcc$zzb$zzcArray[0] = object;
        zzcc$zzb$zzcArray[n10] = zzcc$zzb$zzc3;
        zzcc$zzb$zzcArray[n11] = zzcc$zzb$zzc2;
        zzcc$zzb$zzcArray[n12] = zzcc$zzb$zzc;
        zzg = zzcc$zzb$zzcArray;
        zze = object = new zzci();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcc$zzb$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzcc$zzb$zzc[] values() {
        return (zzcc$zzb$zzc[])zzg.clone();
    }

    public static zzen zzb() {
        return zzch.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzcc$zzb$zzc.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzf;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzf;
    }
}

