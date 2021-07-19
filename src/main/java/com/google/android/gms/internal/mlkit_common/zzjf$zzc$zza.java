/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzji;
import com.google.android.gms.internal.mlkit_common.zzjj;

public final class zzjf$zzc$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzjf$zzc$zza zza;
    private static final /* enum */ zzjf$zzc$zza zzb;
    private static final /* enum */ zzjf$zzc$zza zzc;
    private static final /* enum */ zzjf$zzc$zza zzd;
    private static final /* enum */ zzjf$zzc$zza zze;
    private static final /* enum */ zzjf$zzc$zza zzf;
    private static final zzfu zzg;
    private static final /* synthetic */ zzjf$zzc$zza[] zzi;
    private final int zzh;

    static {
        zzjf$zzc$zza zzjf$zzc$zza;
        zzjf$zzc$zza zzjf$zzc$zza2;
        zzjf$zzc$zza zzjf$zzc$zza3;
        zzjf$zzc$zza zzjf$zzc$zza4;
        zzjf$zzc$zza zzjf$zzc$zza5;
        Object object = new zzjf$zzc$zza("UNKNOWN_ACTION", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjf$zzc$zza5 = new zzjf$zzc$zza("INITIALIZATION", n10, n10);
        int n11 = 2;
        zzc = zzjf$zzc$zza4 = new zzjf$zzc$zza("COMPILATION", n11, n11);
        int n12 = 3;
        zzd = zzjf$zzc$zza3 = new zzjf$zzc$zza("EXECUTION", n12, n12);
        int n13 = 4;
        zze = zzjf$zzc$zza2 = new zzjf$zzc$zza("TEARDOWN", n13, n13);
        int n14 = 5;
        zzf = zzjf$zzc$zza = new zzjf$zzc$zza("VALIDATION", n14, n14);
        zzjf$zzc$zza[] zzjf$zzc$zzaArray = new zzjf$zzc$zza[6];
        zzjf$zzc$zzaArray[0] = object;
        zzjf$zzc$zzaArray[n10] = zzjf$zzc$zza5;
        zzjf$zzc$zzaArray[n11] = zzjf$zzc$zza4;
        zzjf$zzc$zzaArray[n12] = zzjf$zzc$zza3;
        zzjf$zzc$zzaArray[n13] = zzjf$zzc$zza2;
        zzjf$zzc$zzaArray[n14] = zzjf$zzc$zza;
        zzi = zzjf$zzc$zzaArray;
        zzg = object = new zzji();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjf$zzc$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzjf$zzc$zza[] values() {
        return (zzjf$zzc$zza[])zzi.clone();
    }

    public static zzfx zzb() {
        return zzjj.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjf$zzc$zza.class.getName();
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

