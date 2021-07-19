/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzam;
import com.google.android.gms.internal.mlkit_vision_common.zzan;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzac$zzd
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzac$zzd zza;
    private static final /* enum */ zzr$zzac$zzd zzb;
    private static final /* enum */ zzr$zzac$zzd zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzac$zzd[] zzf;
    private final int zze;

    static {
        zzr$zzac$zzd zzr$zzac$zzd;
        zzr$zzac$zzd zzr$zzac$zzd2;
        Object object = new zzr$zzac$zzd("UNKNOWN_LANDMARKS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzac$zzd2 = new zzr$zzac$zzd("NO_LANDMARKS", n10, n10);
        int n11 = 2;
        zzc = zzr$zzac$zzd = new zzr$zzac$zzd("ALL_LANDMARKS", n11, n11);
        zzr$zzac$zzd[] zzr$zzac$zzdArray = new zzr$zzac$zzd[3];
        zzr$zzac$zzdArray[0] = object;
        zzr$zzac$zzdArray[n10] = zzr$zzac$zzd2;
        zzr$zzac$zzdArray[n11] = zzr$zzac$zzd;
        zzf = zzr$zzac$zzdArray;
        zzd = object = new zzan();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzac$zzd() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzac$zzd[] values() {
        return (zzr$zzac$zzd[])zzf.clone();
    }

    public static zzen zzb() {
        return zzam.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzac$zzd.class.getName();
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

