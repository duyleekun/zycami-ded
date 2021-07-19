/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzce;
import com.google.android.gms.internal.mlkit_common.zzcf;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzan$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzan$zzb zza;
    private static final /* enum */ zzav$zzan$zzb zzb;
    private static final /* enum */ zzav$zzan$zzb zzc;
    private static final /* enum */ zzav$zzan$zzb zzd;
    private static final /* enum */ zzav$zzan$zzb zze;
    private static final /* enum */ zzav$zzan$zzb zzf;
    private static final /* enum */ zzav$zzan$zzb zzg;
    private static final zzfu zzh;
    private static final /* synthetic */ zzav$zzan$zzb[] zzj;
    private final int zzi;

    static {
        zzav$zzan$zzb zzav$zzan$zzb;
        zzav$zzan$zzb zzav$zzan$zzb2;
        zzav$zzan$zzb zzav$zzan$zzb3;
        zzav$zzan$zzb zzav$zzan$zzb4;
        zzav$zzan$zzb zzav$zzan$zzb5;
        zzav$zzan$zzb zzav$zzan$zzb6;
        Object object = new zzav$zzan$zzb("CATEGORY_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzan$zzb6 = new zzav$zzan$zzb("CATEGORY_HOME_GOOD", n10, n10);
        int n11 = 2;
        zzc = zzav$zzan$zzb5 = new zzav$zzan$zzb("CATEGORY_FASHION_GOOD", n11, n11);
        int n12 = 3;
        zzd = zzav$zzan$zzb4 = new zzav$zzan$zzb("CATEGORY_ANIMAL", n12, n12);
        int n13 = 4;
        zze = zzav$zzan$zzb3 = new zzav$zzan$zzb("CATEGORY_FOOD", n13, n13);
        int n14 = 5;
        zzf = zzav$zzan$zzb2 = new zzav$zzan$zzb("CATEGORY_PLACE", n14, n14);
        int n15 = 6;
        zzg = zzav$zzan$zzb = new zzav$zzan$zzb("CATEGORY_PLANT", n15, n15);
        zzav$zzan$zzb[] zzav$zzan$zzbArray = new zzav$zzan$zzb[7];
        zzav$zzan$zzbArray[0] = object;
        zzav$zzan$zzbArray[n10] = zzav$zzan$zzb6;
        zzav$zzan$zzbArray[n11] = zzav$zzan$zzb5;
        zzav$zzan$zzbArray[n12] = zzav$zzan$zzb4;
        zzav$zzan$zzbArray[n13] = zzav$zzan$zzb3;
        zzav$zzan$zzbArray[n14] = zzav$zzan$zzb2;
        zzav$zzan$zzbArray[n15] = zzav$zzan$zzb;
        zzj = zzav$zzan$zzbArray;
        zzh = object = new zzce();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzan$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzav$zzan$zzb[] values() {
        return (zzav$zzan$zzb[])zzj.clone();
    }

    public static zzfx zzb() {
        return zzcf.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzan$zzb.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzi;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzi;
    }
}

