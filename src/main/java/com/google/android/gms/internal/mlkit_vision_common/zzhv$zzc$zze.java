/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzic;
import com.google.android.gms.internal.mlkit_vision_common.zzid;

public final class zzhv$zzc$zze
extends Enum
implements zzel {
    private static final /* enum */ zzhv$zzc$zze zza;
    private static final /* enum */ zzhv$zzc$zze zzb;
    private static final /* enum */ zzhv$zzc$zze zzc;
    private static final /* enum */ zzhv$zzc$zze zzd;
    private static final /* enum */ zzhv$zzc$zze zze;
    private static final /* enum */ zzhv$zzc$zze zzf;
    private static final zzeo zzg;
    private static final /* synthetic */ zzhv$zzc$zze[] zzi;
    private final int zzh;

    static {
        zzhv$zzc$zze zzhv$zzc$zze;
        zzhv$zzc$zze zzhv$zzc$zze2;
        zzhv$zzc$zze zzhv$zzc$zze3;
        zzhv$zzc$zze zzhv$zzc$zze4;
        zzhv$zzc$zze zzhv$zzc$zze5;
        Object object = new zzhv$zzc$zze("UNKNOWN_STATUS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzhv$zzc$zze5 = new zzhv$zzc$zze("COMPLETED_EVENT", n10, n10);
        int n11 = 2;
        zzc = zzhv$zzc$zze4 = new zzhv$zzc$zze("MISSING_END_EVENT", n11, n11);
        int n12 = 3;
        zzd = zzhv$zzc$zze3 = new zzhv$zzc$zze("HANG", n12, n12);
        int n13 = 4;
        zze = zzhv$zzc$zze2 = new zzhv$zzc$zze("ABANDONED_FROM_HANG", n13, n13);
        int n14 = 5;
        zzf = zzhv$zzc$zze = new zzhv$zzc$zze("FORCED_CRASH_FROM_HANG", n14, n14);
        zzhv$zzc$zze[] zzhv$zzc$zzeArray = new zzhv$zzc$zze[6];
        zzhv$zzc$zzeArray[0] = object;
        zzhv$zzc$zzeArray[n10] = zzhv$zzc$zze5;
        zzhv$zzc$zzeArray[n11] = zzhv$zzc$zze4;
        zzhv$zzc$zzeArray[n12] = zzhv$zzc$zze3;
        zzhv$zzc$zzeArray[n13] = zzhv$zzc$zze2;
        zzhv$zzc$zzeArray[n14] = zzhv$zzc$zze;
        zzi = zzhv$zzc$zzeArray;
        zzg = object = new zzid();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhv$zzc$zze() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzhv$zzc$zze[] values() {
        return (zzhv$zzc$zze[])zzi.clone();
    }

    public static zzen zzb() {
        return zzic.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzhv$zzc$zze.class.getName();
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

