/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzhy;
import com.google.android.gms.internal.mlkit_vision_common.zzhz;

public final class zzhv$zza$zza
extends Enum
implements zzel {
    private static final /* enum */ zzhv$zza$zza zza;
    private static final /* enum */ zzhv$zza$zza zzb;
    private static final zzeo zzc;
    private static final /* synthetic */ zzhv$zza$zza[] zze;
    private final int zzd;

    static {
        zzhv$zza$zza zzhv$zza$zza;
        Object object = new zzhv$zza$zza("UNKNOWN_ENGINE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzhv$zza$zza = new zzhv$zza$zza("TFLITE", n10, n10);
        zzhv$zza$zza[] zzhv$zza$zzaArray = new zzhv$zza$zza[2];
        zzhv$zza$zzaArray[0] = object;
        zzhv$zza$zzaArray[n10] = zzhv$zza$zza;
        zze = zzhv$zza$zzaArray;
        zzc = object = new zzhz();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhv$zza$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzhv$zza$zza[] values() {
        return (zzhv$zza$zza[])zze.clone();
    }

    public static zzen zzb() {
        return zzhy.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzhv$zza$zza.class.getName();
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

