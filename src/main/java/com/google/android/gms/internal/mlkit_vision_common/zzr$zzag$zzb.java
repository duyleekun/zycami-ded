/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzas;
import com.google.android.gms.internal.mlkit_vision_common.zzat;
import com.google.android.gms.internal.mlkit_vision_common.zzel;
import com.google.android.gms.internal.mlkit_vision_common.zzen;
import com.google.android.gms.internal.mlkit_vision_common.zzeo;

public final class zzr$zzag$zzb
extends Enum
implements zzel {
    public static final /* enum */ zzr$zzag$zzb zza;
    public static final /* enum */ zzr$zzag$zzb zzb;
    public static final /* enum */ zzr$zzag$zzb zzc;
    public static final /* enum */ zzr$zzag$zzb zzd;
    public static final /* enum */ zzr$zzag$zzb zze;
    public static final /* enum */ zzr$zzag$zzb zzf;
    private static final zzeo zzg;
    private static final /* synthetic */ zzr$zzag$zzb[] zzi;
    private final int zzh;

    static {
        zzr$zzag$zzb zzr$zzag$zzb;
        zzr$zzag$zzb zzr$zzag$zzb2;
        zzr$zzag$zzb zzr$zzag$zzb3;
        zzr$zzag$zzb zzr$zzag$zzb4;
        zzr$zzag$zzb zzr$zzag$zzb5;
        Object object = new zzr$zzag$zzb("SOURCE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzr$zzag$zzb5 = new zzr$zzag$zzb("BITMAP", n10, n10);
        int n11 = 2;
        zzc = zzr$zzag$zzb4 = new zzr$zzag$zzb("BYTEARRAY", n11, n11);
        int n12 = 3;
        zzd = zzr$zzag$zzb3 = new zzr$zzag$zzb("BYTEBUFFER", n12, n12);
        int n13 = 4;
        zze = zzr$zzag$zzb2 = new zzr$zzag$zzb("FILEPATH", n13, n13);
        int n14 = 5;
        zzf = zzr$zzag$zzb = new zzr$zzag$zzb("ANDROID_MEDIA_IMAGE", n14, n14);
        zzr$zzag$zzb[] zzr$zzag$zzbArray = new zzr$zzag$zzb[6];
        zzr$zzag$zzbArray[0] = object;
        zzr$zzag$zzbArray[n10] = zzr$zzag$zzb5;
        zzr$zzag$zzbArray[n11] = zzr$zzag$zzb4;
        zzr$zzag$zzbArray[n12] = zzr$zzag$zzb3;
        zzr$zzag$zzbArray[n13] = zzr$zzag$zzb2;
        zzr$zzag$zzbArray[n14] = zzr$zzag$zzb;
        zzi = zzr$zzag$zzbArray;
        zzg = object = new zzas();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzr$zzag$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzr$zzag$zzb[] values() {
        return (zzr$zzag$zzb[])zzi.clone();
    }

    public static zzen zzb() {
        return zzat.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzr$zzag$zzb.class.getName();
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

