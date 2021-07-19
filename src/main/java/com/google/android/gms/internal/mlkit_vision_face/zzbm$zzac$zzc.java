/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcf;
import com.google.android.gms.internal.mlkit_vision_face.zzcg;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzac$zzc
extends Enum
implements zzgf {
    public static final /* enum */ zzbm$zzac$zzc zza;
    public static final /* enum */ zzbm$zzac$zzc zzb;
    public static final /* enum */ zzbm$zzac$zzc zzc;
    private static final zzgi zzd;
    private static final /* synthetic */ zzbm$zzac$zzc[] zzf;
    private final int zze;

    static {
        zzbm$zzac$zzc zzbm$zzac$zzc;
        zzbm$zzac$zzc zzbm$zzac$zzc2;
        Object object = new zzbm$zzac$zzc("UNKNOWN_CONTOURS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzac$zzc2 = new zzbm$zzac$zzc("NO_CONTOURS", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzac$zzc = new zzbm$zzac$zzc("ALL_CONTOURS", n11, n11);
        zzbm$zzac$zzc[] zzbm$zzac$zzcArray = new zzbm$zzac$zzc[3];
        zzbm$zzac$zzcArray[0] = object;
        zzbm$zzac$zzcArray[n10] = zzbm$zzac$zzc2;
        zzbm$zzac$zzcArray[n11] = zzbm$zzac$zzc;
        zzf = zzbm$zzac$zzcArray;
        zzd = object = new zzcf();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzac$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzbm$zzac$zzc[] values() {
        return (zzbm$zzac$zzc[])zzf.clone();
    }

    public static zzgh zzb() {
        return zzcg.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzac$zzc.class.getName();
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

