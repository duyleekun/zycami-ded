/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzca;
import com.google.android.gms.internal.mlkit_common.zzcb;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzal$zzb
extends Enum
implements zzfv {
    public static final /* enum */ zzav$zzal$zzb zza;
    public static final /* enum */ zzav$zzal$zzb zzb;
    public static final /* enum */ zzav$zzal$zzb zzc;
    private static final /* enum */ zzav$zzal$zzb zzd;
    private static final /* enum */ zzav$zzal$zzb zze;
    private static final /* enum */ zzav$zzal$zzb zzf;
    private static final /* enum */ zzav$zzal$zzb zzg;
    private static final zzfu zzh;
    private static final /* synthetic */ zzav$zzal$zzb[] zzj;
    private final int zzi;

    static {
        zzav$zzal$zzb zzav$zzal$zzb;
        zzav$zzal$zzb zzav$zzal$zzb2;
        zzav$zzal$zzb zzav$zzal$zzb3;
        zzav$zzal$zzb zzav$zzal$zzb4;
        zzav$zzal$zzb zzav$zzal$zzb5;
        zzav$zzal$zzb zzav$zzal$zzb6;
        Object object = new zzav$zzal$zzb("TYPE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzd = zzav$zzal$zzb6 = new zzav$zzal$zzb("CUSTOM", n10, n10);
        int n11 = 2;
        zzb = zzav$zzal$zzb5 = new zzav$zzal$zzb("AUTOML_IMAGE_LABELING", n11, n11);
        int n12 = 3;
        zzc = zzav$zzal$zzb4 = new zzav$zzal$zzb("BASE_TRANSLATE", n12, n12);
        int n13 = 4;
        zze = zzav$zzal$zzb3 = new zzav$zzal$zzb("CUSTOM_OBJECT_DETECTION", n13, n13);
        int n14 = 5;
        zzf = zzav$zzal$zzb2 = new zzav$zzal$zzb("CUSTOM_IMAGE_LABELING", n14, n14);
        int n15 = 6;
        zzg = zzav$zzal$zzb = new zzav$zzal$zzb("BASE_ENTITY_EXTRACTION", n15, n15);
        zzav$zzal$zzb[] zzav$zzal$zzbArray = new zzav$zzal$zzb[7];
        zzav$zzal$zzbArray[0] = object;
        zzav$zzal$zzbArray[n10] = zzav$zzal$zzb6;
        zzav$zzal$zzbArray[n11] = zzav$zzal$zzb5;
        zzav$zzal$zzbArray[n12] = zzav$zzal$zzb4;
        zzav$zzal$zzbArray[n13] = zzav$zzal$zzb3;
        zzav$zzal$zzbArray[n14] = zzav$zzal$zzb2;
        zzav$zzal$zzbArray[n15] = zzav$zzal$zzb;
        zzj = zzav$zzal$zzbArray;
        zzh = object = new zzca();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzal$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzi = var3_1;
    }

    public static zzav$zzal$zzb[] values() {
        return (zzav$zzal$zzb[])zzj.clone();
    }

    public static zzfx zzb() {
        return zzcb.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzal$zzb.class.getName();
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

