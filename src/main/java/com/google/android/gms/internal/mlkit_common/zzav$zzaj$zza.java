/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbw;
import com.google.android.gms.internal.mlkit_common.zzbx;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzaj$zza
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzaj$zza zza;
    private static final /* enum */ zzav$zzaj$zza zzb;
    private static final zzfu zzc;
    private static final /* synthetic */ zzav$zzaj$zza[] zze;
    private final int zzd;

    static {
        zzav$zzaj$zza zzav$zzaj$zza;
        Object object = new zzav$zzaj$zza("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzaj$zza = new zzav$zzaj$zza("TRANSLATE", n10, n10);
        zzav$zzaj$zza[] zzav$zzaj$zzaArray = new zzav$zzaj$zza[2];
        zzav$zzaj$zzaArray[0] = object;
        zzav$zzaj$zzaArray[n10] = zzav$zzaj$zza;
        zze = zzav$zzaj$zzaArray;
        zzc = object = new zzbx();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzaj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzav$zzaj$zza[] values() {
        return (zzav$zzaj$zza[])zze.clone();
    }

    public static zzav$zzaj$zza zza(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                return null;
            }
            return zzb;
        }
        return zza;
    }

    public static zzfx zzb() {
        return zzbw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzaj$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzd;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzd;
    }
}

