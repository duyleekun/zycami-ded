/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzep;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzgd
extends Enum {
    public static final /* enum */ zzgd zza;
    public static final /* enum */ zzgd zzb;
    public static final /* enum */ zzgd zzc;
    public static final /* enum */ zzgd zzd;
    public static final /* enum */ zzgd zze;
    public static final /* enum */ zzgd zzf;
    public static final /* enum */ zzgd zzg;
    public static final /* enum */ zzgd zzh;
    public static final /* enum */ zzgd zzi;
    public static final /* enum */ zzgd zzj;
    private static final /* synthetic */ zzgd[] zzn;
    private final Class zzk;
    private final Class zzl;
    private final Object zzm;

    static {
        zzgd zzgd2;
        zzgd zzgd3;
        zzgd zzgd4;
        zzgd zzgd5;
        zzgd zzgd6;
        zzgd[] zzgdArray;
        zzgd[] zzgdArray2 = zzgdArray;
        zzgdArray = new zzgd("VOID", 0, Void.class, Void.class, null);
        zza = zzgdArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzgd[] zzgdArray3 = zzgdArray2;
        Class<Constable> clazz = object;
        zzgdArray2 = new zzgd("INT", 1, object, Integer.class, (Object)serializable);
        zzb = zzgdArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzgd zzgd7 = zzgd6;
        zzc = zzgd6 = new zzgd("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzgdArray3 = zzgd5;
        zzd = zzgd5 = new zzgd("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzgd7 = zzgd4;
        zze = zzgd4 = new zzgd("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzgdArray3 = zzgd7;
        zzf = zzgd7 = new zzgd("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzgd zzgd8 = zzgd3;
        zzg = zzgd3 = new zzgd("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzep.zza;
        zzgdArray3 = zzgd8;
        zzh = zzgd8 = new zzgd("BYTE_STRING", 7, zzep.class, zzep.class, (Object)serializable);
        zzgdArray3 = zzgd2;
        clazz = object;
        zzi = zzgd2 = new zzgd("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzj = object;
        zzgdArray3 = new zzgd[]{zzgdArray, zzgdArray2, zzgd6, zzgd5, zzgd4, zzgd7, zzgd3, zzgd8, zzgd2, object};
        zzn = zzgdArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzgd(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzk = object;
        this.zzl = var4_2;
        this.zzm = var5_3;
    }

    public static zzgd[] values() {
        return (zzgd[])zzn.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}

