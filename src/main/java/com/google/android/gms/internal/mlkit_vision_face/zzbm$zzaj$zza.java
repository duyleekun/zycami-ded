/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcp;
import com.google.android.gms.internal.mlkit_vision_face.zzcq;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzaj$zza
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzaj$zza zza;
    private static final /* enum */ zzbm$zzaj$zza zzb;
    private static final zzgi zzc;
    private static final /* synthetic */ zzbm$zzaj$zza[] zze;
    private final int zzd;

    static {
        zzbm$zzaj$zza zzbm$zzaj$zza;
        Object object = new zzbm$zzaj$zza("UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzaj$zza = new zzbm$zzaj$zza("TRANSLATE", n10, n10);
        zzbm$zzaj$zza[] zzbm$zzaj$zzaArray = new zzbm$zzaj$zza[2];
        zzbm$zzaj$zzaArray[0] = object;
        zzbm$zzaj$zzaArray[n10] = zzbm$zzaj$zza;
        zze = zzbm$zzaj$zzaArray;
        zzc = object = new zzcp();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzaj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzd = var3_1;
    }

    public static zzbm$zzaj$zza[] values() {
        return (zzbm$zzaj$zza[])zze.clone();
    }

    public static zzgh zzb() {
        return zzcq.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzaj$zza.class.getName();
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

