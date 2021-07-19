/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbk;
import com.google.android.gms.internal.mlkit_common.zzbl;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzac$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzac$zzb zza;
    private static final /* enum */ zzav$zzac$zzb zzb;
    private static final /* enum */ zzav$zzac$zzb zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzac$zzb[] zzf;
    private final int zze;

    static {
        zzav$zzac$zzb zzav$zzac$zzb;
        zzav$zzac$zzb zzav$zzac$zzb2;
        Object object = new zzav$zzac$zzb("UNKNOWN_CLASSIFICATIONS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzac$zzb2 = new zzav$zzac$zzb("NO_CLASSIFICATIONS", n10, n10);
        int n11 = 2;
        zzc = zzav$zzac$zzb = new zzav$zzac$zzb("ALL_CLASSIFICATIONS", n11, n11);
        zzav$zzac$zzb[] zzav$zzac$zzbArray = new zzav$zzac$zzb[3];
        zzav$zzac$zzbArray[0] = object;
        zzav$zzac$zzbArray[n10] = zzav$zzac$zzb2;
        zzav$zzac$zzbArray[n11] = zzav$zzac$zzb;
        zzf = zzav$zzac$zzbArray;
        zzd = object = new zzbk();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzac$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzac$zzb[] values() {
        return (zzav$zzac$zzb[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzbl.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzac$zzb.class.getName();
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

