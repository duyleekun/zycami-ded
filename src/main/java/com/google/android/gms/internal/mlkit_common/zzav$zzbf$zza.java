/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcx;
import com.google.android.gms.internal.mlkit_common.zzcy;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzbf$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzbf$zza zza;
    private static final /* enum */ zzav$zzbf$zza zzb;
    private static final /* enum */ zzav$zzbf$zza zzc;
    private static final /* enum */ zzav$zzbf$zza zzd;
    private static final zzfu zze;
    private static final /* synthetic */ zzav$zzbf$zza[] zzg;
    private final int zzf;

    static {
        zzav$zzbf$zza zzav$zzbf$zza;
        zzav$zzbf$zza zzav$zzbf$zza2;
        zzav$zzbf$zza zzav$zzbf$zza3;
        Object object = new zzav$zzbf$zza("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzbf$zza3 = new zzav$zzbf$zza("CANONICAL", n10, n10);
        int n11 = 2;
        zzc = zzav$zzbf$zza2 = new zzav$zzbf$zza("TFLITE", n11, n11);
        int n12 = 3;
        zzd = zzav$zzbf$zza = new zzav$zzbf$zza("TFLITE_SUPPORT", n12, n12);
        zzav$zzbf$zza[] zzav$zzbf$zzaArray = new zzav$zzbf$zza[4];
        zzav$zzbf$zzaArray[0] = object;
        zzav$zzbf$zzaArray[n10] = zzav$zzbf$zza3;
        zzav$zzbf$zzaArray[n11] = zzav$zzbf$zza2;
        zzav$zzbf$zzaArray[n12] = zzav$zzbf$zza;
        zzg = zzav$zzbf$zzaArray;
        zze = object = new zzcy();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzbf$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzav$zzbf$zza[] values() {
        return (zzav$zzbf$zza[])zzg.clone();
    }

    public static zzfx zzb() {
        return zzcx.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzbf$zza.class.getName();
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

