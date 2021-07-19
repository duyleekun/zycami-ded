/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzcc;
import com.google.android.gms.internal.mlkit_common.zzcd;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzal$zzc
extends Enum
implements zzfv {
    public static final /* enum */ zzav$zzal$zzc zza;
    private static final /* enum */ zzav$zzal$zzc zzb;
    private static final /* enum */ zzav$zzal$zzc zzc;
    private static final /* enum */ zzav$zzal$zzc zzd;
    private static final /* enum */ zzav$zzal$zzc zze;
    private static final /* enum */ zzav$zzal$zzc zzf;
    private static final zzfu zzg;
    private static final /* synthetic */ zzav$zzal$zzc[] zzi;
    private final int zzh;

    static {
        zzav$zzal$zzc zzav$zzal$zzc;
        zzav$zzal$zzc zzav$zzal$zzc2;
        zzav$zzal$zzc zzav$zzal$zzc3;
        zzav$zzal$zzc zzav$zzal$zzc4;
        zzav$zzal$zzc zzav$zzal$zzc5;
        Object object = new zzav$zzal$zzc("SOURCE_UNKNOWN", 0, 0);
        zzb = object;
        int n10 = 1;
        zzc = zzav$zzal$zzc5 = new zzav$zzal$zzc("APP_ASSET", n10, n10);
        int n11 = 2;
        zzd = zzav$zzal$zzc4 = new zzav$zzal$zzc("LOCAL", n11, n11);
        int n12 = 3;
        zza = zzav$zzal$zzc3 = new zzav$zzal$zzc("CLOUD", n12, n12);
        int n13 = 4;
        zze = zzav$zzal$zzc2 = new zzav$zzal$zzc("SDK_BUILT_IN", n13, n13);
        int n14 = 5;
        zzf = zzav$zzal$zzc = new zzav$zzal$zzc("URI", n14, n14);
        zzav$zzal$zzc[] zzav$zzal$zzcArray = new zzav$zzal$zzc[6];
        zzav$zzal$zzcArray[0] = object;
        zzav$zzal$zzcArray[n10] = zzav$zzal$zzc5;
        zzav$zzal$zzcArray[n11] = zzav$zzal$zzc4;
        zzav$zzal$zzcArray[n12] = zzav$zzal$zzc3;
        zzav$zzal$zzcArray[n13] = zzav$zzal$zzc2;
        zzav$zzal$zzcArray[n14] = zzav$zzal$zzc;
        zzi = zzav$zzal$zzcArray;
        zzg = object = new zzcd();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzal$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzav$zzal$zzc[] values() {
        return (zzav$zzal$zzc[])zzi.clone();
    }

    public static zzfx zzb() {
        return zzcc.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzal$zzc.class.getName();
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

