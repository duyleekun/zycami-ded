/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;

public final class zzkp
extends Enum {
    public static final /* enum */ zzkp zza;
    public static final /* enum */ zzkp zzb;
    public static final /* enum */ zzkp zzc;
    public static final /* enum */ zzkp zzd;
    public static final /* enum */ zzkp zze;
    public static final /* enum */ zzkp zzf;
    public static final /* enum */ zzkp zzg;
    public static final /* enum */ zzkp zzh;
    public static final /* enum */ zzkp zzi;
    private static final /* synthetic */ zzkp[] zzk;
    private final Object zzj;

    static {
        zzkp zzkp2;
        zzkp zzkp3;
        zzkp zzkp4;
        Object object = 0;
        zza = zzkp4 = new zzkp("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new zzkp("LONG", n10, object2);
        zzb = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new zzkp("FLOAT", n11, object3);
        zzc = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new zzkp("DOUBLE", n12, object4);
        zzd = object3;
        Object object5 = Boolean.FALSE;
        object4 = new zzkp("BOOLEAN", 4, object5);
        zze = object4;
        object5 = new zzkp("STRING", 5, (Object)"");
        zzf = object5;
        Object object6 = zzgs.zzb;
        zzg = zzkp3 = new zzkp("BYTE_STRING", 6, object6);
        object6 = new zzkp("ENUM", 7, null);
        zzh = object6;
        int n13 = 8;
        zzi = zzkp2 = new zzkp("MESSAGE", n13, null);
        zzkp[] zzkpArray = new zzkp[9];
        zzkpArray[0] = zzkp4;
        zzkpArray[n10] = object;
        zzkpArray[n11] = object2;
        zzkpArray[n12] = object3;
        zzkpArray[4] = object4;
        zzkpArray[5] = object5;
        zzkpArray[6] = zzkp3;
        zzkpArray[7] = object6;
        zzkpArray[n13] = zzkp2;
        zzk = zzkpArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzkp() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzj = var3_1;
    }

    public static zzkp[] values() {
        return (zzkp[])zzk.clone();
    }
}

