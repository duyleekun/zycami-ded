/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzjk;
import com.google.android.gms.internal.mlkit_common.zzjm;

public final class zzjf$zzc$zze
extends Enum
implements zzfv {
    private static final /* enum */ zzjf$zzc$zze zza;
    private static final /* enum */ zzjf$zzc$zze zzb;
    private static final /* enum */ zzjf$zzc$zze zzc;
    private static final /* enum */ zzjf$zzc$zze zzd;
    private static final /* enum */ zzjf$zzc$zze zze;
    private static final /* enum */ zzjf$zzc$zze zzf;
    private static final zzfu zzg;
    private static final /* synthetic */ zzjf$zzc$zze[] zzi;
    private final int zzh;

    static {
        zzjf$zzc$zze zzjf$zzc$zze;
        zzjf$zzc$zze zzjf$zzc$zze2;
        zzjf$zzc$zze zzjf$zzc$zze3;
        zzjf$zzc$zze zzjf$zzc$zze4;
        zzjf$zzc$zze zzjf$zzc$zze5;
        Object object = new zzjf$zzc$zze("UNKNOWN_STATUS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjf$zzc$zze5 = new zzjf$zzc$zze("COMPLETED_EVENT", n10, n10);
        int n11 = 2;
        zzc = zzjf$zzc$zze4 = new zzjf$zzc$zze("MISSING_END_EVENT", n11, n11);
        int n12 = 3;
        zzd = zzjf$zzc$zze3 = new zzjf$zzc$zze("HANG", n12, n12);
        int n13 = 4;
        zze = zzjf$zzc$zze2 = new zzjf$zzc$zze("ABANDONED_FROM_HANG", n13, n13);
        int n14 = 5;
        zzf = zzjf$zzc$zze = new zzjf$zzc$zze("FORCED_CRASH_FROM_HANG", n14, n14);
        zzjf$zzc$zze[] zzjf$zzc$zzeArray = new zzjf$zzc$zze[6];
        zzjf$zzc$zzeArray[0] = object;
        zzjf$zzc$zzeArray[n10] = zzjf$zzc$zze5;
        zzjf$zzc$zzeArray[n11] = zzjf$zzc$zze4;
        zzjf$zzc$zzeArray[n12] = zzjf$zzc$zze3;
        zzjf$zzc$zzeArray[n13] = zzjf$zzc$zze2;
        zzjf$zzc$zzeArray[n14] = zzjf$zzc$zze;
        zzi = zzjf$zzc$zzeArray;
        zzg = object = new zzjk();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjf$zzc$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzjf$zzc$zze[] values() {
        return (zzjf$zzc$zze[])zzi.clone();
    }

    public static zzfx zzb() {
        return zzjm.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjf$zzc$zze.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzh;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzh;
    }
}

