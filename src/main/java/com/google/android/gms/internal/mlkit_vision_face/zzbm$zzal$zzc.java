/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzcv;
import com.google.android.gms.internal.mlkit_vision_face.zzcw;
import com.google.android.gms.internal.mlkit_vision_face.zzgf;
import com.google.android.gms.internal.mlkit_vision_face.zzgh;
import com.google.android.gms.internal.mlkit_vision_face.zzgi;

public final class zzbm$zzal$zzc
extends Enum
implements zzgf {
    private static final /* enum */ zzbm$zzal$zzc zza;
    private static final /* enum */ zzbm$zzal$zzc zzb;
    private static final /* enum */ zzbm$zzal$zzc zzc;
    private static final /* enum */ zzbm$zzal$zzc zzd;
    private static final /* enum */ zzbm$zzal$zzc zze;
    private static final /* enum */ zzbm$zzal$zzc zzf;
    private static final zzgi zzg;
    private static final /* synthetic */ zzbm$zzal$zzc[] zzi;
    private final int zzh;

    static {
        zzbm$zzal$zzc zzbm$zzal$zzc;
        zzbm$zzal$zzc zzbm$zzal$zzc2;
        zzbm$zzal$zzc zzbm$zzal$zzc3;
        zzbm$zzal$zzc zzbm$zzal$zzc4;
        zzbm$zzal$zzc zzbm$zzal$zzc5;
        Object object = new zzbm$zzal$zzc("SOURCE_UNKNOWN", 0, 0);
        zza = object;
        int n10 = 1;
        zzb = zzbm$zzal$zzc5 = new zzbm$zzal$zzc("APP_ASSET", n10, n10);
        int n11 = 2;
        zzc = zzbm$zzal$zzc4 = new zzbm$zzal$zzc("LOCAL", n11, n11);
        int n12 = 3;
        zzd = zzbm$zzal$zzc3 = new zzbm$zzal$zzc("CLOUD", n12, n12);
        int n13 = 4;
        zze = zzbm$zzal$zzc2 = new zzbm$zzal$zzc("SDK_BUILT_IN", n13, n13);
        int n14 = 5;
        zzf = zzbm$zzal$zzc = new zzbm$zzal$zzc("URI", n14, n14);
        zzbm$zzal$zzc[] zzbm$zzal$zzcArray = new zzbm$zzal$zzc[6];
        zzbm$zzal$zzcArray[0] = object;
        zzbm$zzal$zzcArray[n10] = zzbm$zzal$zzc5;
        zzbm$zzal$zzcArray[n11] = zzbm$zzal$zzc4;
        zzbm$zzal$zzcArray[n12] = zzbm$zzal$zzc3;
        zzbm$zzal$zzcArray[n13] = zzbm$zzal$zzc2;
        zzbm$zzal$zzcArray[n14] = zzbm$zzal$zzc;
        zzi = zzbm$zzal$zzcArray;
        zzg = object = new zzcv();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzbm$zzal$zzc() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzh = var3_1;
    }

    public static zzbm$zzal$zzc[] values() {
        return (zzbm$zzal$zzc[])zzi.clone();
    }

    public static zzgh zzb() {
        return zzcw.zza;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder("<");
        String string2 = zzbm$zzal$zzc.class.getName();
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

