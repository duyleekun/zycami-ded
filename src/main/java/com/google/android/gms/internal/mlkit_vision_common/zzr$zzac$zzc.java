/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzak;
import com.google.android.gms.internal.mlkit_vision_common.zzal;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzac$zzc
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzac$zzc zza;
    private static final /* enum */ zzr$zzac$zzc zzb;
    private static final /* enum */ zzr$zzac$zzc zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzac$zzc[] zzf;
    private final int zze;

    static {
        zzr$zzac$zzc zzr$zzac$zzc;
        zzr$zzac$zzc zzr$zzac$zzc2;
        Object object = new zzr$zzac$zzc("UNKNOWN_CONTOURS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzac$zzc2 = new zzr$zzac$zzc("NO_CONTOURS", n10, n10);
        int n11 = 2;
        zzc = zzr$zzac$zzc = new zzr$zzac$zzc("ALL_CONTOURS", n11, n11);
        zzr$zzac$zzc[] zzr$zzac$zzcArray = new zzr$zzac$zzc[3];
        zzr$zzac$zzcArray[0] = object;
        zzr$zzac$zzcArray[n10] = zzr$zzac$zzc2;
        zzr$zzac$zzcArray[n11] = zzr$zzac$zzc;
        zzf = zzr$zzac$zzcArray;
        zzd = object = new zzak();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzac$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzac$zzc[] values() {
        return (zzr$zzac$zzc[])zzf.clone();
    }

    public static zzen zzb() {
        return zzal.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzac$zzc.class.getName();
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

