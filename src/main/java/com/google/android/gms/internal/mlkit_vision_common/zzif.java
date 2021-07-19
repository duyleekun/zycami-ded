/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;
import com.google.android.gms.internal.mlkit_vision_common.zzie;
import com.google.android.gms.internal.mlkit_vision_common.zzig;

public final class zzif
extends Enum
implements zzel {
    private static final /* enum */ zzif zza;
    private static final /* enum */ zzif zzb;
    private static final /* enum */ zzif zzc;
    private static final zzeo zzd;
    private static final /* synthetic */ zzif[] zzf;
    private final int zze;

    static {
        zzif zzif2;
        zzif zzif3;
        Object object = new zzif("UNKNOWN_EVENT_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzif3 = new zzif("VALIDATION_TEST", n10, n10);
        int n11 = 2;
        zzc = zzif2 = new zzif("CONTINUOUS_FEEDBACK", n11, n11);
        zzif[] zzifArray = new zzif[3];
        zzifArray[0] = object;
        zzifArray[n10] = zzif3;
        zzifArray[n11] = zzif2;
        zzf = zzifArray;
        zzd = object = new zzie();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzif() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zze = var3_1;
    }

    public static zzif[] values() {
        return (zzif[])zzf.clone();
    }

    public static zzen zzb() {
        return zzig.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzif.class.getName();
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

