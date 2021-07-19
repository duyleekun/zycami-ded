/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzau;
import com.google.android.gms.internal.mlkit_vision_common.zzav;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzaj$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzaj$zza zza;
    private static final /* enum */ zzr$zzaj$zza zzb;
    private static final zzeo zzc;
    private static final /* synthetic */ zzr$zzaj$zza[] zze;
    private final int zzd;

    static {
        zzr$zzaj$zza zzr$zzaj$zza;
        Object object = new zzr$zzaj$zza("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzaj$zza = new zzr$zzaj$zza("TRANSLATE", n10, n10);
        zzr$zzaj$zza[] zzr$zzaj$zzaArray = new zzr$zzaj$zza[2];
        zzr$zzaj$zzaArray[0] = object;
        zzr$zzaj$zzaArray[n10] = zzr$zzaj$zza;
        zze = zzr$zzaj$zzaArray;
        zzc = object = new zzau();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzaj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzr$zzaj$zza[] values() {
        return (zzr$zzaj$zza[])zze.clone();
    }

    public static zzen zzb() {
        return zzav.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzaj$zza.class.getName();
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

