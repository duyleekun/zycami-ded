/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzih;
import com.google.android.gms.internal.mlkit_vision_common.zzii;

public final class zzhv$zzj$zza
extends Enum
implements zzel {
    private static final /* enum */ zzhv$zzj$zza zza;
    private static final /* enum */ zzhv$zzj$zza zzb;
    private static final /* enum */ zzhv$zzj$zza zzc;
    private static final /* enum */ zzhv$zzj$zza zzd;
    private static final /* enum */ zzhv$zzj$zza zze;
    private static final zzeo zzf;
    private static final /* synthetic */ zzhv$zzj$zza[] zzh;
    private final int zzg;

    static {
        zzhv$zzj$zza zzhv$zzj$zza;
        zzhv$zzj$zza zzhv$zzj$zza2;
        zzhv$zzj$zza zzhv$zzj$zza3;
        zzhv$zzj$zza zzhv$zzj$zza4;
        Object object = new zzhv$zzj$zza("DELEGATE_NONE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzhv$zzj$zza4 = new zzhv$zzj$zza("NNAPI", n10, n10);
        int n11 = 2;
        zzc = zzhv$zzj$zza3 = new zzhv$zzj$zza("GPU", n11, n11);
        int n12 = 3;
        zzd = zzhv$zzj$zza2 = new zzhv$zzj$zza("HEXAGON", n12, n12);
        int n13 = 4;
        zze = zzhv$zzj$zza = new zzhv$zzj$zza("EDGETPU", n13, n13);
        zzhv$zzj$zza[] zzhv$zzj$zzaArray = new zzhv$zzj$zza[5];
        zzhv$zzj$zzaArray[0] = object;
        zzhv$zzj$zzaArray[n10] = zzhv$zzj$zza4;
        zzhv$zzj$zzaArray[n11] = zzhv$zzj$zza3;
        zzhv$zzj$zzaArray[n12] = zzhv$zzj$zza2;
        zzhv$zzj$zzaArray[n13] = zzhv$zzj$zza;
        zzh = zzhv$zzj$zzaArray;
        zzf = object = new zzii();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhv$zzj$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzhv$zzj$zza[] values() {
        return (zzhv$zzj$zza[])zzh.clone();
    }

    public static zzen zzb() {
        return zzih.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzhv$zzj$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzg;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzg;
    }
}

