/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;
import com.google.android.gms.internal.mlkit_vision_face.zzkd;
import com.google.android.gms.internal.mlkit_vision_face.zzke;

public final class zzjp$zzk$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzjp$zzk$zzb zza;
    private static final /* enum */ zzjp$zzk$zzb zzb;
    private static final /* enum */ zzjp$zzk$zzb zzc;
    private static final /* enum */ zzjp$zzk$zzb zzd;
    private static final zzgi zze;
    private static final /* synthetic */ zzjp$zzk$zzb[] zzg;
    private final int zzf;

    static {
        zzjp$zzk$zzb zzjp$zzk$zzb;
        zzjp$zzk$zzb zzjp$zzk$zzb2;
        zzjp$zzk$zzb zzjp$zzk$zzb3;
        Object object = new zzjp$zzk$zzb("UNKNOWN_METRIC", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjp$zzk$zzb3 = new zzjp$zzk$zzb("MEAN_ABSOLUTE_ERROR", n10, n10);
        int n11 = 2;
        zzc = zzjp$zzk$zzb2 = new zzjp$zzk$zzb("MEAN_SQUARED_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzjp$zzk$zzb = new zzjp$zzk$zzb("ROOT_MEAN_SQUARED_ERROR", n12, n12);
        zzjp$zzk$zzb[] zzjp$zzk$zzbArray = new zzjp$zzk$zzb[4];
        zzjp$zzk$zzbArray[0] = object;
        zzjp$zzk$zzbArray[n10] = zzjp$zzk$zzb3;
        zzjp$zzk$zzbArray[n11] = zzjp$zzk$zzb2;
        zzjp$zzk$zzbArray[n12] = zzjp$zzk$zzb;
        zzg = zzjp$zzk$zzbArray;
        zze = object = new zzkd();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjp$zzk$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzjp$zzk$zzb[] values() {
        return (zzjp$zzk$zzb[])zzg.clone();
    }

    public static zzgh zzb() {
        return zzke.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjp$zzk$zzb.class.getName();
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

