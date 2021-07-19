/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzip
extends Enum {
    public static final /* enum */ zzip zzyy;
    public static final /* enum */ zzip zzyz;
    public static final /* enum */ zzip zzza;
    public static final /* enum */ zzip zzzb;
    public static final /* enum */ zzip zzzc;
    public static final /* enum */ zzip zzzd;
    public static final /* enum */ zzip zzze;
    public static final /* enum */ zzip zzzf;
    public static final /* enum */ zzip zzzg;
    public static final /* enum */ zzip zzzh;
    private static final /* synthetic */ zzip[] zzzl;
    private final Class zzzi;
    private final Class zzzj;
    private final Object zzzk;

    static {
        zzip zzip2;
        zzip zzip3;
        zzip zzip4;
        zzip zzip5;
        zzip zzip6;
        zzip[] zzipArray;
        zzip[] zzipArray2 = zzipArray;
        zzipArray = new zzip("VOID", 0, Void.class, Void.class, null);
        zzyy = zzipArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzip[] zzipArray3 = zzipArray2;
        Class<Constable> clazz = object;
        zzipArray2 = new zzip("INT", 1, object, Integer.class, (Object)serializable);
        zzyz = zzipArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzip zzip7 = zzip6;
        zzza = zzip6 = new zzip("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzipArray3 = zzip5;
        zzzb = zzip5 = new zzip("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzip7 = zzip4;
        zzzc = zzip4 = new zzip("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzipArray3 = zzip7;
        zzzd = zzip7 = new zzip("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzip zzip8 = zzip3;
        zzze = zzip3 = new zzip("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzgs.zztt;
        zzipArray3 = zzip8;
        zzzf = zzip8 = new zzip("BYTE_STRING", 7, zzgs.class, zzgs.class, (Object)serializable);
        zzipArray3 = zzip2;
        clazz = object;
        zzzg = zzip2 = new zzip("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzzh = object;
        zzipArray3 = new zzip[]{zzipArray, zzipArray2, zzip6, zzip5, zzip4, zzip7, zzip3, zzip8, zzip2, object};
        zzzl = zzipArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzip(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzzi = object;
        this.zzzj = var4_2;
        this.zzzk = var5_3;
    }

    public static zzip[] values() {
        return (zzip[])zzzl.clone();
    }

    public final Class zzhq() {
        return this.zzzj;
    }
}

