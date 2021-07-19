/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzct;
import com.google.android.gms.internal.mlkit_common.zzcu;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzbc$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzbc$zza zza;
    private static final /* enum */ zzav$zzbc$zza zzb;
    private static final /* enum */ zzav$zzbc$zza zzc;
    private static final /* enum */ zzav$zzbc$zza zzd;
    private static final /* enum */ zzav$zzbc$zza zze;
    private static final /* enum */ zzav$zzbc$zza zzf;
    private static final /* enum */ zzav$zzbc$zza zzg;
    private static final zzfu zzh;
    private static final /* synthetic */ zzav$zzbc$zza[] zzj;
    private final int zzi;

    static {
        zzav$zzbc$zza zzav$zzbc$zza;
        zzav$zzbc$zza zzav$zzbc$zza2;
        zzav$zzbc$zza zzav$zzbc$zza3;
        zzav$zzbc$zza zzav$zzbc$zza4;
        zzav$zzbc$zza zzav$zzbc$zza5;
        zzav$zzbc$zza zzav$zzbc$zza6;
        Object object = new zzav$zzbc$zza("NO_ERROR", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzbc$zza6 = new zzav$zzbc$zza("STATUS_SENSITIVE_TOPIC", n10, n10);
        int n11 = 2;
        zzc = zzav$zzbc$zza5 = new zzav$zzbc$zza("STATUS_QUALITY_THRESHOLDED", n11, n11);
        int n12 = 3;
        zzd = zzav$zzbc$zza4 = new zzav$zzbc$zza("STATUS_INTERNAL_ERROR", n12, n12);
        int n13 = 4;
        zze = zzav$zzbc$zza3 = new zzav$zzbc$zza("STATUS_NOT_SUPPORTED_LANGUAGE", n13, 101);
        int n14 = 5;
        zzf = zzav$zzbc$zza2 = new zzav$zzbc$zza("STATUS_32_BIT_CPU", n14, 1001);
        int n15 = 6;
        zzg = zzav$zzbc$zza = new zzav$zzbc$zza("STATUS_32_BIT_APP", n15, 1002);
        zzav$zzbc$zza[] zzav$zzbc$zzaArray = new zzav$zzbc$zza[7];
        zzav$zzbc$zzaArray[0] = object;
        zzav$zzbc$zzaArray[n10] = zzav$zzbc$zza6;
        zzav$zzbc$zzaArray[n11] = zzav$zzbc$zza5;
        zzav$zzbc$zzaArray[n12] = zzav$zzbc$zza4;
        zzav$zzbc$zzaArray[n13] = zzav$zzbc$zza3;
        zzav$zzbc$zzaArray[n14] = zzav$zzbc$zza2;
        zzav$zzbc$zzaArray[n15] = zzav$zzbc$zza;
        zzj = zzav$zzbc$zzaArray;
        zzh = object = new zzcu();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzbc$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzav$zzbc$zza[] values() {
        return (zzav$zzbc$zza[])zzj.clone();
    }

    public static zzfx zzb() {
        return zzct.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzbc$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzi;
    }
}

