/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzai;
import com.google.android.gms.internal.mlkit_vision_common.zzaj;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzac$zza
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzac$zza zza;
    private static final /* enum */ zzr$zzac$zza zzb;
    private static final /* enum */ zzr$zzac$zza zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzr$zzac$zza[] zzf;
    private final int zze;

    static {
        zzr$zzac$zza zzr$zzac$zza;
        zzr$zzac$zza zzr$zzac$zza2;
        Object object = new zzr$zzac$zza("UNKNOWN_CLASSIFICATIONS", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzac$zza2 = new zzr$zzac$zza("NO_CLASSIFICATIONS", n10, n10);
        int n11 = 2;
        zzc = zzr$zzac$zza = new zzr$zzac$zza("ALL_CLASSIFICATIONS", n11, n11);
        zzr$zzac$zza[] zzr$zzac$zzaArray = new zzr$zzac$zza[3];
        zzr$zzac$zzaArray[0] = object;
        zzr$zzac$zzaArray[n10] = zzr$zzac$zza2;
        zzr$zzac$zzaArray[n11] = zzr$zzac$zza;
        zzf = zzr$zzac$zzaArray;
        zzd = object = new zzaj();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzac$zza() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzr$zzac$zza[] values() {
        return (zzr$zzac$zza[])zzf.clone();
    }

    public static zzen zzb() {
        return zzai.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzac$zza.class.getName();
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

