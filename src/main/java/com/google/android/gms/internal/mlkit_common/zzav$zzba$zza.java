/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcp;
import com.google.android.gms.internal.mlkit_common.zzcq;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzba$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzba$zza zza;
    private static final /* enum */ zzav$zzba$zza zzb;
    private static final /* enum */ zzav$zzba$zza zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzba$zza[] zzf;
    private final int zze;

    static {
        zzav$zzba$zza zzav$zzba$zza;
        zzav$zzba$zza zzav$zzba$zza2;
        Object object = new zzav$zzba$zza("INVALID_MODE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzba$zza2 = new zzav$zzba$zza("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzav$zzba$zza = new zzav$zzba$zza("SINGLE_IMAGE", n11, n11);
        zzav$zzba$zza[] zzav$zzba$zzaArray = new zzav$zzba$zza[3];
        zzav$zzba$zzaArray[0] = object;
        zzav$zzba$zzaArray[n10] = zzav$zzba$zza2;
        zzav$zzba$zzaArray[n11] = zzav$zzba$zza;
        zzf = zzav$zzba$zzaArray;
        zzd = object = new zzcq();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzba$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzba$zza[] values() {
        return (zzav$zzba$zza[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzcp.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzba$zza.class.getName();
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

