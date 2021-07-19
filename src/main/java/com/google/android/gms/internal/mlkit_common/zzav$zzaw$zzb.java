/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcn;
import com.google.android.gms.internal.mlkit_common.zzco;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzaw$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzaw$zzb zza;
    private static final /* enum */ zzav$zzaw$zzb zzb;
    private static final /* enum */ zzav$zzaw$zzb zzc;
    private static final zzfu zzd;
    private static final /* synthetic */ zzav$zzaw$zzb[] zzf;
    private final int zze;

    static {
        zzav$zzaw$zzb zzav$zzaw$zzb;
        zzav$zzaw$zzb zzav$zzaw$zzb2;
        Object object = new zzav$zzaw$zzb("MODE_UNSPECIFIED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzaw$zzb2 = new zzav$zzaw$zzb("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzav$zzaw$zzb = new zzav$zzaw$zzb("SINGLE_IMAGE", n11, n11);
        zzav$zzaw$zzb[] zzav$zzaw$zzbArray = new zzav$zzaw$zzb[3];
        zzav$zzaw$zzbArray[0] = object;
        zzav$zzaw$zzbArray[n10] = zzav$zzaw$zzb2;
        zzav$zzaw$zzbArray[n11] = zzav$zzaw$zzb;
        zzf = zzav$zzaw$zzbArray;
        zzd = object = new zzcn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzaw$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzav$zzaw$zzb[] values() {
        return (zzav$zzaw$zzb[])zzf.clone();
    }

    public static zzfx zzb() {
        return zzco.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzaw$zzb.class.getName();
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

