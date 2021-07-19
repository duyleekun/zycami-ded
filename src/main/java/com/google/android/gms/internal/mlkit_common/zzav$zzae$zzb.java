/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzbs;
import com.google.android.gms.internal.mlkit_common.zzbt;
import com.google.android.gms.internal.mlkit_common.zzfu;
import com.google.android.gms.internal.mlkit_common.zzfv;
import com.google.android.gms.internal.mlkit_common.zzfx;

public final class zzav$zzae$zzb
extends Enum
implements zzfv {
    private static final /* enum */ zzav$zzae$zzb zza;
    private static final /* enum */ zzav$zzae$zzb zzb;
    private static final /* enum */ zzav$zzae$zzb zzc;
    private static final /* enum */ zzav$zzae$zzb zzd;
    private static final /* enum */ zzav$zzae$zzb zze;
    private static final /* enum */ zzav$zzae$zzb zzf;
    private static final /* enum */ zzav$zzae$zzb zzg;
    private static final /* enum */ zzav$zzae$zzb zzh;
    private static final /* enum */ zzav$zzae$zzb zzi;
    private static final zzfu zzj;
    private static final /* synthetic */ zzav$zzae$zzb[] zzl;
    private final int zzk;

    static {
        zzav$zzae$zzb zzav$zzae$zzb;
        zzav$zzae$zzb zzav$zzae$zzb2;
        zzav$zzae$zzb zzav$zzae$zzb3;
        zzav$zzae$zzb zzav$zzae$zzb4;
        zzav$zzae$zzb zzav$zzae$zzb5;
        zzav$zzae$zzb zzav$zzae$zzb6;
        zzav$zzae$zzb zzav$zzae$zzb7;
        zzav$zzae$zzb zzav$zzae$zzb8;
        Object object = new zzav$zzae$zzb("UNKNOWN_FORMAT", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzav$zzae$zzb8 = new zzav$zzae$zzb("NV16", n10, n10);
        int n11 = 2;
        zzc = zzav$zzae$zzb7 = new zzav$zzae$zzb("NV21", n11, n11);
        int n12 = 3;
        zzd = zzav$zzae$zzb6 = new zzav$zzae$zzb("YV12", n12, n12);
        int n13 = 4;
        int n14 = 7;
        zze = zzav$zzae$zzb5 = new zzav$zzae$zzb("YUV_420_888", n13, n14);
        int n15 = 5;
        int n16 = 8;
        zzf = zzav$zzae$zzb4 = new zzav$zzae$zzb("JPEG", n15, n16);
        n12 = 6;
        zzg = zzav$zzae$zzb3 = new zzav$zzae$zzb("BITMAP", n12, n13);
        zzh = zzav$zzae$zzb2 = new zzav$zzae$zzb("CM_SAMPLE_BUFFER_REF", n14, n15);
        zzi = zzav$zzae$zzb = new zzav$zzae$zzb("UI_IMAGE", n16, n12);
        zzav$zzae$zzb[] zzav$zzae$zzbArray = new zzav$zzae$zzb[9];
        zzav$zzae$zzbArray[0] = object;
        zzav$zzae$zzbArray[n10] = zzav$zzae$zzb8;
        zzav$zzae$zzbArray[n11] = zzav$zzae$zzb7;
        zzav$zzae$zzbArray[3] = zzav$zzae$zzb6;
        zzav$zzae$zzbArray[4] = zzav$zzae$zzb5;
        zzav$zzae$zzbArray[n15] = zzav$zzae$zzb4;
        zzav$zzae$zzbArray[n12] = zzav$zzae$zzb3;
        zzav$zzae$zzbArray[7] = zzav$zzae$zzb2;
        zzav$zzae$zzbArray[n16] = zzav$zzae$zzb;
        zzl = zzav$zzae$zzbArray;
        zzj = object = new zzbs();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzav$zzae$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzk = var3_1;
    }

    public static zzav$zzae$zzb[] values() {
        return (zzav$zzae$zzb[])zzl.clone();
    }

    public static zzfx zzb() {
        return zzbt.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzav$zzae$zzb.class.getName();
        stringBuilder.append(string2);
        stringBuilder.append('@');
        string2 = Integer.toHexString(System.identityHashCode(this));
        stringBuilder.append(string2);
        stringBuilder.append(" number=");
        int n10 = this.zzk;
        stringBuilder.append(n10);
        stringBuilder.append(" name=");
        string2 = this.name();
        stringBuilder.append(string2);
        stringBuilder.append('>');
        return stringBuilder.toString();
    }

    public final int zza() {
        return this.zzk;
    }
}

