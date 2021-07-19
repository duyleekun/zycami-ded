/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzez;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzgn
extends Enum {
    public static final /* enum */ zzgn zza;
    public static final /* enum */ zzgn zzb;
    public static final /* enum */ zzgn zzc;
    public static final /* enum */ zzgn zzd;
    public static final /* enum */ zzgn zze;
    public static final /* enum */ zzgn zzf;
    public static final /* enum */ zzgn zzg;
    public static final /* enum */ zzgn zzh;
    public static final /* enum */ zzgn zzi;
    public static final /* enum */ zzgn zzj;
    private static final /* synthetic */ zzgn[] zzn;
    private final Class zzk;
    private final Class zzl;
    private final Object zzm;

    static {
        zzgn zzgn2;
        zzgn zzgn3;
        zzgn zzgn4;
        zzgn zzgn5;
        zzgn zzgn6;
        zzgn[] zzgnArray;
        zzgn[] zzgnArray2 = zzgnArray;
        zzgnArray = new zzgn("VOID", 0, Void.class, Void.class, null);
        zza = zzgnArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzgn[] zzgnArray3 = zzgnArray2;
        Class<Constable> clazz = object;
        zzgnArray2 = new zzgn("INT", 1, object, Integer.class, (Object)serializable);
        zzb = zzgnArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzgn zzgn7 = zzgn6;
        zzc = zzgn6 = new zzgn("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzgnArray3 = zzgn5;
        zzd = zzgn5 = new zzgn("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzgn7 = zzgn4;
        zze = zzgn4 = new zzgn("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzgnArray3 = zzgn7;
        zzf = zzgn7 = new zzgn("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzgn zzgn8 = zzgn3;
        zzg = zzgn3 = new zzgn("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzez.zza;
        zzgnArray3 = zzgn8;
        zzh = zzgn8 = new zzgn("BYTE_STRING", 7, zzez.class, zzez.class, (Object)serializable);
        zzgnArray3 = zzgn2;
        clazz = object;
        zzi = zzgn2 = new zzgn("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzj = object;
        zzgnArray3 = new zzgn[]{zzgnArray, zzgnArray2, zzgn6, zzgn5, zzgn4, zzgn7, zzgn3, zzgn8, zzgn2, object};
        zzn = zzgnArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzgn(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzk = object;
        this.zzl = var4_2;
        this.zzm = var5_3;
    }

    public static zzgn[] values() {
        return (zzgn[])zzn.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}

