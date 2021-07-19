/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzba;
import com.google.android.gms.internal.mlkit_vision_common.zzbb;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzal$zzc
extends Enum
implements zzel {
    private static final /* enum */ zzr$zzal$zzc zza;
    private static final /* enum */ zzr$zzal$zzc zzb;
    private static final /* enum */ zzr$zzal$zzc zzc;
    private static final /* enum */ zzr$zzal$zzc zzd;
    private static final /* enum */ zzr$zzal$zzc zze;
    private static final /* enum */ zzr$zzal$zzc zzf;
    private static final zzeo zzg;
    private static final /* synthetic */ zzr$zzal$zzc[] zzi;
    private final int zzh;

    static {
        zzr$zzal$zzc zzr$zzal$zzc;
        zzr$zzal$zzc zzr$zzal$zzc2;
        zzr$zzal$zzc zzr$zzal$zzc3;
        zzr$zzal$zzc zzr$zzal$zzc4;
        zzr$zzal$zzc zzr$zzal$zzc5;
        Object object = new zzr$zzal$zzc("SOURCE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzal$zzc5 = new zzr$zzal$zzc("APP_ASSET", n10, n10);
        int n11 = 2;
        zzc = zzr$zzal$zzc4 = new zzr$zzal$zzc("LOCAL", n11, n11);
        int n12 = 3;
        zzd = zzr$zzal$zzc3 = new zzr$zzal$zzc("CLOUD", n12, n12);
        int n13 = 4;
        zze = zzr$zzal$zzc2 = new zzr$zzal$zzc("SDK_BUILT_IN", n13, n13);
        int n14 = 5;
        zzf = zzr$zzal$zzc = new zzr$zzal$zzc("URI", n14, n14);
        zzr$zzal$zzc[] zzr$zzal$zzcArray = new zzr$zzal$zzc[6];
        zzr$zzal$zzcArray[0] = object;
        zzr$zzal$zzcArray[n10] = zzr$zzal$zzc5;
        zzr$zzal$zzcArray[n11] = zzr$zzal$zzc4;
        zzr$zzal$zzcArray[n12] = zzr$zzal$zzc3;
        zzr$zzal$zzcArray[n13] = zzr$zzal$zzc2;
        zzr$zzal$zzcArray[n14] = zzr$zzal$zzc;
        zzi = zzr$zzal$zzcArray;
        zzg = object = new zzba();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzal$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzr$zzal$zzc[] values() {
        return (zzr$zzal$zzc[])zzi.clone();
    }

    public static zzen zzb() {
        return zzbb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzal$zzc.class.getName();
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

