/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbo;
import com.google.android.gms.internal.mlkit_common.zzbp;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzac$zzd
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzac$zzd zza;
    private static final /* enum */ zzav$zzac$zzd zzb;
    private static final /* enum */ zzav$zzac$zzd zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzac$zzd[] zzf;
    private final int zze;

    static {
        zzav$zzac$zzd zzav$zzac$zzd;
        zzav$zzac$zzd zzav$zzac$zzd2;
        Object object = new zzav$zzac$zzd("UNKNOWN_LANDMARKS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzac$zzd2 = new zzav$zzac$zzd("NO_LANDMARKS", n10, n10);
        int n11 = 2;
        zzc = zzav$zzac$zzd = new zzav$zzac$zzd("ALL_LANDMARKS", n11, n11);
        zzav$zzac$zzd[] zzav$zzac$zzdArray = new zzav$zzac$zzd[3];
        zzav$zzac$zzdArray[0] = object;
        zzav$zzac$zzdArray[n10] = zzav$zzac$zzd2;
        zzav$zzac$zzdArray[n11] = zzav$zzac$zzd;
        zzf = zzav$zzac$zzdArray;
        zzd = object = new zzbo();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzac$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzac$zzd[] values() {
        return (zzav$zzac$zzd[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzbp.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzac$zzd.class.getName();
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

