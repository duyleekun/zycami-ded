/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzia;
import com.google.android.gms.internal.mlkit_vision_common.zzib;

public final class zzhv$zzc$zza
extends Enum
implements zzel {
    private static final /* enum */ zzhv$zzc$zza zza;
    private static final /* enum */ zzhv$zzc$zza zzb;
    private static final /* enum */ zzhv$zzc$zza zzc;
    private static final /* enum */ zzhv$zzc$zza zzd;
    private static final /* enum */ zzhv$zzc$zza zze;
    private static final /* enum */ zzhv$zzc$zza zzf;
    private static final zzeo zzg;
    private static final /* synthetic */ zzhv$zzc$zza[] zzi;
    private final int zzh;

    static {
        zzhv$zzc$zza zzhv$zzc$zza;
        zzhv$zzc$zza zzhv$zzc$zza2;
        zzhv$zzc$zza zzhv$zzc$zza3;
        zzhv$zzc$zza zzhv$zzc$zza4;
        zzhv$zzc$zza zzhv$zzc$zza5;
        Object object = new zzhv$zzc$zza("UNKNOWN_ACTION", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzhv$zzc$zza5 = new zzhv$zzc$zza("INITIALIZATION", n10, n10);
        int n11 = 2;
        zzc = zzhv$zzc$zza4 = new zzhv$zzc$zza("COMPILATION", n11, n11);
        int n12 = 3;
        zzd = zzhv$zzc$zza3 = new zzhv$zzc$zza("EXECUTION", n12, n12);
        int n13 = 4;
        zze = zzhv$zzc$zza2 = new zzhv$zzc$zza("TEARDOWN", n13, n13);
        int n14 = 5;
        zzf = zzhv$zzc$zza = new zzhv$zzc$zza("VALIDATION", n14, n14);
        zzhv$zzc$zza[] zzhv$zzc$zzaArray = new zzhv$zzc$zza[6];
        zzhv$zzc$zzaArray[0] = object;
        zzhv$zzc$zzaArray[n10] = zzhv$zzc$zza5;
        zzhv$zzc$zzaArray[n11] = zzhv$zzc$zza4;
        zzhv$zzc$zzaArray[n12] = zzhv$zzc$zza3;
        zzhv$zzc$zzaArray[n13] = zzhv$zzc$zza2;
        zzhv$zzc$zzaArray[n14] = zzhv$zzc$zza;
        zzi = zzhv$zzc$zzaArray;
        zzg = object = new zzib();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhv$zzc$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzhv$zzc$zza[] values() {
        return (zzhv$zzc$zza[])zzi.clone();
    }

    public static zzen zzb() {
        return zzia.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzhv$zzc$zza.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzh;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzh;
    }
}

