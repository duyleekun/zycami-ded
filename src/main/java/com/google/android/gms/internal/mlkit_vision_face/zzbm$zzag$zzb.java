/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcn;
import com.google.android.gms.internal.mlkit_vision_face.zzco;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzag$zzb
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzag$zzb zza;
    private static final /* enum */ zzbm$zzag$zzb zzb;
    private static final /* enum */ zzbm$zzag$zzb zzc;
    private static final /* enum */ zzbm$zzag$zzb zzd;
    private static final /* enum */ zzbm$zzag$zzb zze;
    private static final /* enum */ zzbm$zzag$zzb zzf;
    private static final zzgi zzg;
    private static final /* synthetic */ zzbm$zzag$zzb[] zzi;
    private final int zzh;

    static {
        zzbm$zzag$zzb zzbm$zzag$zzb;
        zzbm$zzag$zzb zzbm$zzag$zzb2;
        zzbm$zzag$zzb zzbm$zzag$zzb3;
        zzbm$zzag$zzb zzbm$zzag$zzb4;
        zzbm$zzag$zzb zzbm$zzag$zzb5;
        Object object = new zzbm$zzag$zzb("SOURCE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzag$zzb5 = new zzbm$zzag$zzb("BITMAP", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzag$zzb4 = new zzbm$zzag$zzb("BYTEARRAY", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzag$zzb3 = new zzbm$zzag$zzb("BYTEBUFFER", n12, n12);
        int n13 = 4;
        zze = zzbm$zzag$zzb2 = new zzbm$zzag$zzb("FILEPATH", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzag$zzb = new zzbm$zzag$zzb("ANDROID_MEDIA_IMAGE", n14, n14);
        zzbm$zzag$zzb[] zzbm$zzag$zzbArray = new zzbm$zzag$zzb[6];
        zzbm$zzag$zzbArray[0] = object;
        zzbm$zzag$zzbArray[n10] = zzbm$zzag$zzb5;
        zzbm$zzag$zzbArray[n11] = zzbm$zzag$zzb4;
        zzbm$zzag$zzbArray[n12] = zzbm$zzag$zzb3;
        zzbm$zzag$zzbArray[n13] = zzbm$zzag$zzb2;
        zzbm$zzag$zzbArray[n14] = zzbm$zzag$zzb;
        zzi = zzbm$zzag$zzbArray;
        zzg = object = new zzcn();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzag$zzb() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzbm$zzag$zzb[] values() {
        return (zzbm$zzag$zzb[])zzi.clone();
    }

    public static zzgh zzb() {
        return zzco.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzag$zzb.class.getName();
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

