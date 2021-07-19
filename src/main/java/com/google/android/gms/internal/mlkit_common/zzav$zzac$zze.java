/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbq;
import com.google.android.gms.internal.mlkit_common.zzbr;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzac$zze
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzac$zze zza;
    private static final /* enum */ zzav$zzac$zze zzb;
    private static final /* enum */ zzav$zzac$zze zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzac$zze[] zzf;
    private final int zze;

    static {
        zzav$zzac$zze zzav$zzac$zze;
        zzav$zzac$zze zzav$zzac$zze2;
        Object object = new zzav$zzac$zze("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzac$zze2 = new zzav$zzac$zze("FAST", n10, n10);
        int n11 = 2;
        zzc = zzav$zzac$zze = new zzav$zzac$zze("ACCURATE", n11, n11);
        zzav$zzac$zze[] zzav$zzac$zzeArray = new zzav$zzac$zze[3];
        zzav$zzac$zzeArray[0] = object;
        zzav$zzac$zzeArray[n10] = zzav$zzac$zze2;
        zzav$zzac$zzeArray[n11] = zzav$zzac$zze;
        zzf = zzav$zzac$zzeArray;
        zzd = object = new zzbr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzac$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzac$zze[] values() {
        return (zzav$zzac$zze[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzbq.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzac$zze.class.getName();
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

