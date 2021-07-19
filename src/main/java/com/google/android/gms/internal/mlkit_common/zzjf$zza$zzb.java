/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzjg;
import com.google.android.gms.internal.mlkit_common.zzjh;

public final class zzjf$zza$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzjf$zza$zzb zza;
    private static final /* enum */ zzjf$zza$zzb zzb;
    private static final zzfu zzc;
    private static final /* synthetic */ zzjf$zza$zzb[] zze;
    private final int zzd;

    static {
        zzjf$zza$zzb zzjf$zza$zzb;
        Object object = new zzjf$zza$zzb("UNKNOWN_ENGINE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjf$zza$zzb = new zzjf$zza$zzb("TFLITE", n10, n10);
        zzjf$zza$zzb[] zzjf$zza$zzbArray = new zzjf$zza$zzb[2];
        zzjf$zza$zzbArray[0] = object;
        zzjf$zza$zzbArray[n10] = zzjf$zza$zzb;
        zze = zzjf$zza$zzbArray;
        zzc = object = new zzjg();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjf$zza$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzjf$zza$zzb[] values() {
        return (zzjf$zza$zzb[])zze.clone();
    }

    public static zzfx zzb() {
        return zzjh.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjf$zza$zzb.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzd;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzd;
    }
}

