/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;
import com.google.android.gms.internal.mlkit_common.zzjp;
import com.google.android.gms.internal.mlkit_common.zzjq;

public final class zzjf$zzj$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzjf$zzj$zzb zza;
    private static final /* enum */ zzjf$zzj$zzb zzb;
    private static final /* enum */ zzjf$zzj$zzb zzc;
    private static final /* enum */ zzjf$zzj$zzb zzd;
    private static final /* enum */ zzjf$zzj$zzb zze;
    private static final zzfu zzf;
    private static final /* synthetic */ zzjf$zzj$zzb[] zzh;
    private final int zzg;

    static {
        zzjf$zzj$zzb zzjf$zzj$zzb;
        zzjf$zzj$zzb zzjf$zzj$zzb2;
        zzjf$zzj$zzb zzjf$zzj$zzb3;
        zzjf$zzj$zzb zzjf$zzj$zzb4;
        Object object = new zzjf$zzj$zzb("DELEGATE_NONE", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzjf$zzj$zzb4 = new zzjf$zzj$zzb("NNAPI", n10, n10);
        int n11 = 2;
        zzc = zzjf$zzj$zzb3 = new zzjf$zzj$zzb("GPU", n11, n11);
        int n12 = 3;
        zzd = zzjf$zzj$zzb2 = new zzjf$zzj$zzb("HEXAGON", n12, n12);
        int n13 = 4;
        zze = zzjf$zzj$zzb = new zzjf$zzj$zzb("EDGETPU", n13, n13);
        zzjf$zzj$zzb[] zzjf$zzj$zzbArray = new zzjf$zzj$zzb[5];
        zzjf$zzj$zzbArray[0] = object;
        zzjf$zzj$zzbArray[n10] = zzjf$zzj$zzb4;
        zzjf$zzj$zzbArray[n11] = zzjf$zzj$zzb3;
        zzjf$zzj$zzbArray[n12] = zzjf$zzj$zzb2;
        zzjf$zzj$zzbArray[n13] = zzjf$zzj$zzb;
        zzh = zzjf$zzj$zzbArray;
        zzf = object = new zzjp();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzjf$zzj$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzg = var3_1;
    }

    public static zzjf$zzj$zzb[] values() {
        return (zzjf$zzj$zzb[])zzh.clone();
    }

    public static zzfx zzb() {
        return zzjq.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzjf$zzj$zzb.class.getName();
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

