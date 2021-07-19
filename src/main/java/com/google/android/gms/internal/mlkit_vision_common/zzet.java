/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzdf;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzet
extends Enum {
    public static final /* enum */ zzet zza;
    public static final /* enum */ zzet zzb;
    public static final /* enum */ zzet zzc;
    public static final /* enum */ zzet zzd;
    public static final /* enum */ zzet zze;
    public static final /* enum */ zzet zzf;
    public static final /* enum */ zzet zzg;
    public static final /* enum */ zzet zzh;
    public static final /* enum */ zzet zzi;
    public static final /* enum */ zzet zzj;
    private static final /* synthetic */ zzet[] zzn;
    private final Class zzk;
    private final Class zzl;
    private final Object zzm;

    static {
        zzet zzet2;
        zzet zzet3;
        zzet zzet4;
        zzet zzet5;
        zzet zzet6;
        zzet[] zzetArray;
        zzet[] zzetArray2 = zzetArray;
        zzetArray = new zzet("VOID", 0, Void.class, Void.class, null);
        zza = zzetArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzet[] zzetArray3 = zzetArray2;
        Class<Constable> clazz = object;
        zzetArray2 = new zzet("INT", 1, object, Integer.class, (Object)serializable);
        zzb = zzetArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzet zzet7 = zzet6;
        zzc = zzet6 = new zzet("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzetArray3 = zzet5;
        zzd = zzet5 = new zzet("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzet7 = zzet4;
        zze = zzet4 = new zzet("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzetArray3 = zzet7;
        zzf = zzet7 = new zzet("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzet zzet8 = zzet3;
        zzg = zzet3 = new zzet("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzdf.zza;
        zzetArray3 = zzet8;
        zzh = zzet8 = new zzet("BYTE_STRING", 7, zzdf.class, zzdf.class, (Object)serializable);
        zzetArray3 = zzet2;
        clazz = object;
        zzi = zzet2 = new zzet("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzj = object;
        zzetArray3 = new zzet[]{zzetArray, zzetArray2, zzet6, zzet5, zzet4, zzet7, zzet3, zzet8, zzet2, object};
        zzn = zzetArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzet(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzk = object;
        this.zzl = var4_2;
        this.zzm = var5_3;
    }

    public static zzet[] values() {
        return (zzet[])zzn.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}

