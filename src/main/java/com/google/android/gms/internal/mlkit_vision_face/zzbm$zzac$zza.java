/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcd;
import com.google.android.gms.internal.mlkit_vision_face.zzce;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzac$zza
extends Enum
implements zzgf {
    public static final /* enum */ zzbm$zzac$zza zza;
    public static final /* enum */ zzbm$zzac$zza zzb;
    public static final /* enum */ zzbm$zzac$zza zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzac$zza[] zzf;
    private final int zze;

    static {
        zzbm$zzac$zza zzbm$zzac$zza;
        zzbm$zzac$zza zzbm$zzac$zza2;
        Object object = new zzbm$zzac$zza("UNKNOWN_CLASSIFICATIONS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzac$zza2 = new zzbm$zzac$zza("NO_CLASSIFICATIONS", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzac$zza = new zzbm$zzac$zza("ALL_CLASSIFICATIONS", n11, n11);
        zzbm$zzac$zza[] zzbm$zzac$zzaArray = new zzbm$zzac$zza[3];
        zzbm$zzac$zzaArray[0] = object;
        zzbm$zzac$zzaArray[n10] = zzbm$zzac$zza2;
        zzbm$zzac$zzaArray[n11] = zzbm$zzac$zza;
        zzf = zzbm$zzac$zzaArray;
        zzd = object = new zzce();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzac$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzac$zza[] values() {
        return (zzbm$zzac$zza[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzcd.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzac$zza.class.getName();
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

