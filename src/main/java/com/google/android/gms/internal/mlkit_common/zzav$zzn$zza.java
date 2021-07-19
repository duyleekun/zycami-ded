/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzaz;
import com.google.android.gms.internal.mlkit_common.zzba;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzn$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzn$zza zza;
    private static final /* enum */ zzav$zzn$zza zzb;
    private static final /* enum */ zzav$zzn$zza zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzn$zza[] zzf;
    private final int zze;

    static {
        zzav$zzn$zza zzav$zzn$zza;
        zzav$zzn$zza zzav$zzn$zza2;
        Object object = new zzav$zzn$zza("UNKNOWN_MODEL_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzn$zza2 = new zzav$zzn$zza("STABLE_MODEL", n10, n10);
        int n11 = 2;
        zzc = zzav$zzn$zza = new zzav$zzn$zza("LATEST_MODEL", n11, n11);
        zzav$zzn$zza[] zzav$zzn$zzaArray = new zzav$zzn$zza[3];
        zzav$zzn$zzaArray[0] = object;
        zzav$zzn$zzaArray[n10] = zzav$zzn$zza2;
        zzav$zzn$zzaArray[n11] = zzav$zzn$zza;
        zzf = zzav$zzn$zzaArray;
        zzd = object = new zzba();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzn$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzn$zza[] values() {
        return (zzav$zzn$zza[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzaz.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzn$zza.class.getName();
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

