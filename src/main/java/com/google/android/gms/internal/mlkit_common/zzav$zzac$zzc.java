/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbm;
import com.google.android.gms.internal.mlkit_common.zzbn;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzac$zzc
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzac$zzc zza;
    private static final /* enum */ zzav$zzac$zzc zzb;
    private static final /* enum */ zzav$zzac$zzc zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzac$zzc[] zzf;
    private final int zze;

    static {
        zzav$zzac$zzc zzav$zzac$zzc;
        zzav$zzac$zzc zzav$zzac$zzc2;
        Object object = new zzav$zzac$zzc("UNKNOWN_CONTOURS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzac$zzc2 = new zzav$zzac$zzc("NO_CONTOURS", n10, n10);
        int n11 = 2;
        zzc = zzav$zzac$zzc = new zzav$zzac$zzc("ALL_CONTOURS", n11, n11);
        zzav$zzac$zzc[] zzav$zzac$zzcArray = new zzav$zzac$zzc[3];
        zzav$zzac$zzcArray[0] = object;
        zzav$zzac$zzcArray[n10] = zzav$zzac$zzc2;
        zzav$zzac$zzcArray[n11] = zzav$zzac$zzc;
        zzf = zzav$zzac$zzcArray;
        zzd = object = new zzbn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzac$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzac$zzc[] values() {
        return (zzav$zzac$zzc[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzbm.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzac$zzc.class.getName();
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

