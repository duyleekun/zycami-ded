/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzjr;
import com.google.android.gms.internal.mlkit_common.zzjs;

public final class zzjf$zzk$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzjf$zzk$zza zza;
    private static final /* enum */ zzjf$zzk$zza zzb;
    private static final /* enum */ zzjf$zzk$zza zzc;
    private static final /* enum */ zzjf$zzk$zza zzd;
    private static final zzfu zze;
    private static final /* synthetic */ zzjf$zzk$zza[] zzg;
    private final int zzf;

    static {
        zzjf$zzk$zza zzjf$zzk$zza;
        zzjf$zzk$zza zzjf$zzk$zza2;
        zzjf$zzk$zza zzjf$zzk$zza3;
        Object object = new zzjf$zzk$zza("UNKNOWN_METRIC", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjf$zzk$zza3 = new zzjf$zzk$zza("MEAN_ABSOLUTE_ERROR", n10, n10);
        int n11 = 2;
        zzc = zzjf$zzk$zza2 = new zzjf$zzk$zza("MEAN_SQUARED_ERROR", n11, n11);
        int n12 = 3;
        zzd = zzjf$zzk$zza = new zzjf$zzk$zza("ROOT_MEAN_SQUARED_ERROR", n12, n12);
        zzjf$zzk$zza[] zzjf$zzk$zzaArray = new zzjf$zzk$zza[4];
        zzjf$zzk$zzaArray[0] = object;
        zzjf$zzk$zzaArray[n10] = zzjf$zzk$zza3;
        zzjf$zzk$zzaArray[n11] = zzjf$zzk$zza2;
        zzjf$zzk$zzaArray[n12] = zzjf$zzk$zza;
        zzg = zzjf$zzk$zzaArray;
        zze = object = new zzjs();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjf$zzk$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzf = var3_1;
    }

    public static zzjf$zzk$zza[] values() {
        return (zzjf$zzk$zza[])zzg.clone();
    }

    public static zzfx zzb() {
        return zzjr.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjf$zzk$zza.class.getName();
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

