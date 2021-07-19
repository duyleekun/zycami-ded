/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;

public final class zzhu
extends Enum {
    public static final /* enum */ zzhu zza;
    public static final /* enum */ zzhu zzb;
    public static final /* enum */ zzhu zzc;
    public static final /* enum */ zzhu zzd;
    public static final /* enum */ zzhu zze;
    public static final /* enum */ zzhu zzf;
    public static final /* enum */ zzhu zzg;
    public static final /* enum */ zzhu zzh;
    public static final /* enum */ zzhu zzi;
    private static final /* synthetic */ zzhu[] zzk;
    private final Object zzj;

    static {
        zzhu zzhu2;
        zzhu zzhu3;
        zzhu zzhu4;
        Object object = 0;
        zza = zzhu4 = new zzhu("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new zzhu("LONG", n10, object2);
        zzb = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new zzhu("FLOAT", n11, object3);
        zzc = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new zzhu("DOUBLE", n12, object4);
        zzd = object3;
        Object object5 = Boolean.FALSE;
        object4 = new zzhu("BOOLEAN", 4, object5);
        zze = object4;
        object5 = new zzhu("STRING", 5, (Object)"");
        zzf = object5;
        Object object6 = zzdf.zza;
        zzg = zzhu3 = new zzhu("BYTE_STRING", 6, object6);
        object6 = new zzhu("ENUM", 7, null);
        zzh = object6;
        int n13 = 8;
        zzi = zzhu2 = new zzhu("MESSAGE", n13, null);
        zzhu[] zzhuArray = new zzhu[9];
        zzhuArray[0] = zzhu4;
        zzhuArray[n10] = object;
        zzhuArray[n11] = object2;
        zzhuArray[n12] = object3;
        zzhuArray[4] = object4;
        zzhuArray[5] = object5;
        zzhuArray[6] = zzhu3;
        zzhuArray[7] = object6;
        zzhuArray[n13] = zzhu2;
        zzk = zzhuArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzhu() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.zzj = var3_1;
    }

    public static zzhu[] values() {
        return (zzhu[])zzk.clone();
    }
}

