/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzbl;
import com.google.android.gms.internal.mlkit_vision_common.zzbm;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzaw$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzaw$zza zza;
    private static final /* enum */ zzr$zzaw$zza zzb;
    private static final /* enum */ zzr$zzaw$zza zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzaw$zza[] zzf;
    private final int zze;

    static {
        zzr$zzaw$zza zzr$zzaw$zza;
        zzr$zzaw$zza zzr$zzaw$zza2;
        Object object = new zzr$zzaw$zza("MODE_UNSPECIFIED", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzaw$zza2 = new zzr$zzaw$zza("STREAM", n10, n10);
        int n11 = 2;
        zzc = zzr$zzaw$zza = new zzr$zzaw$zza("SINGLE_IMAGE", n11, n11);
        zzr$zzaw$zza[] zzr$zzaw$zzaArray = new zzr$zzaw$zza[3];
        zzr$zzaw$zzaArray[0] = object;
        zzr$zzaw$zzaArray[n10] = zzr$zzaw$zza2;
        zzr$zzaw$zzaArray[n11] = zzr$zzaw$zza;
        zzf = zzr$zzaw$zzaArray;
        zzd = object = new zzbm();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzaw$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzaw$zza[] values() {
        return (zzr$zzaw$zza[])zzf.clone();
    }

    public static zzen zzb() {
        return zzbl.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzaw$zza.class.getName();
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

