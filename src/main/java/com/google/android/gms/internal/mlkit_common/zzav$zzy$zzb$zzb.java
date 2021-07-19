/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbb;
import com.google.android.gms.internal.mlkit_common.zzbc;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzy$zzb$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzy$zzb$zzb zza;
    private static final /* enum */ zzav$zzy$zzb$zzb zzb;
    private static final /* enum */ zzav$zzy$zzb$zzb zzc;
    private static final /* enum */ zzav$zzy$zzb$zzb zzd;
    private static final /* enum */ zzav$zzy$zzb$zzb zze;
    private static final zzfu zzf;
    private static final /* synthetic */ zzav$zzy$zzb$zzb[] zzh;
    private final int zzg;

    static {
        zzav$zzy$zzb$zzb zzav$zzy$zzb$zzb;
        zzav$zzy$zzb$zzb zzav$zzy$zzb$zzb2;
        zzav$zzy$zzb$zzb zzav$zzy$zzb$zzb3;
        zzav$zzy$zzb$zzb zzav$zzy$zzb$zzb4;
        Object object = new zzav$zzy$zzb$zzb("UNKNOWN_DATA_TYPE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzy$zzb$zzb4 = new zzav$zzy$zzb$zzb("TYPE_FLOAT32", n10, n10);
        int n11 = 2;
        zzc = zzav$zzy$zzb$zzb3 = new zzav$zzy$zzb$zzb("TYPE_INT32", n11, n11);
        int n12 = 3;
        zzd = zzav$zzy$zzb$zzb2 = new zzav$zzy$zzb$zzb("TYPE_BYTE", n12, n12);
        int n13 = 4;
        zze = zzav$zzy$zzb$zzb = new zzav$zzy$zzb$zzb("TYPE_LONG", n13, n13);
        zzav$zzy$zzb$zzb[] zzav$zzy$zzb$zzbArray = new zzav$zzy$zzb$zzb[5];
        zzav$zzy$zzb$zzbArray[0] = object;
        zzav$zzy$zzb$zzbArray[n10] = zzav$zzy$zzb$zzb4;
        zzav$zzy$zzb$zzbArray[n11] = zzav$zzy$zzb$zzb3;
        zzav$zzy$zzb$zzbArray[n12] = zzav$zzy$zzb$zzb2;
        zzav$zzy$zzb$zzbArray[n13] = zzav$zzy$zzb$zzb;
        zzh = zzav$zzy$zzb$zzbArray;
        zzf = object = new zzbb();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzy$zzb$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzav$zzy$zzb$zzb[] values() {
        return (zzav$zzy$zzb$zzb[])zzh.clone();
    }

    public static zzfx zzb() {
        return zzbc.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzy$zzb$zzb.class.getName();
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

