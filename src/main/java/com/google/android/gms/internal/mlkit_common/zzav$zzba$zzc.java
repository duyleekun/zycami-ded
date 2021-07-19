/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcr;
import com.google.android.gms.internal.mlkit_common.zzcs;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzba$zzc
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzba$zzc zza;
    private static final /* enum */ zzav$zzba$zzc zzb;
    private static final /* enum */ zzav$zzba$zzc zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzba$zzc[] zzf;
    private final int zze;

    static {
        zzav$zzba$zzc zzav$zzba$zzc;
        zzav$zzba$zzc zzav$zzba$zzc2;
        Object object = new zzav$zzba$zzc("UNKNOWN_PERFORMANCE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzba$zzc2 = new zzav$zzba$zzc("FAST", n10, n10);
        int n11 = 2;
        zzc = zzav$zzba$zzc = new zzav$zzba$zzc("ACCURATE", n11, n11);
        zzav$zzba$zzc[] zzav$zzba$zzcArray = new zzav$zzba$zzc[3];
        zzav$zzba$zzcArray[0] = object;
        zzav$zzba$zzcArray[n10] = zzav$zzba$zzc2;
        zzav$zzba$zzcArray[n11] = zzav$zzba$zzc;
        zzf = zzav$zzba$zzcArray;
        zzd = object = new zzcr();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzba$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzba$zzc[] values() {
        return (zzav$zzba$zzc[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzcs.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzba$zzc.class.getName();
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

