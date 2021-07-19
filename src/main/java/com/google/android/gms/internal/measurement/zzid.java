/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgs;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzid
extends Enum {
    public static final /* enum */ zzid zza;
    public static final /* enum */ zzid zzb;
    public static final /* enum */ zzid zzc;
    public static final /* enum */ zzid zzd;
    public static final /* enum */ zzid zze;
    public static final /* enum */ zzid zzf;
    public static final /* enum */ zzid zzg;
    public static final /* enum */ zzid zzh;
    public static final /* enum */ zzid zzi;
    public static final /* enum */ zzid zzj;
    private static final /* synthetic */ zzid[] zzn;
    private final Class zzk;
    private final Class zzl;
    private final Object zzm;

    static {
        zzid zzid2;
        zzid zzid3;
        zzid zzid4;
        zzid zzid5;
        zzid zzid6;
        zzid[] zzidArray;
        zzid[] zzidArray2 = zzidArray;
        zzidArray = new zzid("VOID", 0, Void.class, Void.class, null);
        zza = zzidArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzid[] zzidArray3 = zzidArray2;
        Class<Constable> clazz = object;
        zzidArray2 = new zzid("INT", 1, object, Integer.class, (Object)serializable);
        zzb = zzidArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzid zzid7 = zzid6;
        zzc = zzid6 = new zzid("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzidArray3 = zzid5;
        zzd = zzid5 = new zzid("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzid7 = zzid4;
        zze = zzid4 = new zzid("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzidArray3 = zzid7;
        zzf = zzid7 = new zzid("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzid zzid8 = zzid3;
        zzg = zzid3 = new zzid("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzgs.zzb;
        zzidArray3 = zzid8;
        zzh = zzid8 = new zzid("BYTE_STRING", 7, zzgs.class, zzgs.class, (Object)serializable);
        zzidArray3 = zzid2;
        clazz = object;
        zzi = zzid2 = new zzid("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzj = object;
        zzidArray3 = new zzid[]{zzidArray, zzidArray2, zzid6, zzid5, zzid4, zzid7, zzid3, zzid8, zzid2, object};
        zzn = zzidArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzid(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzk = object;
        this.zzl = var4_2;
        this.zzm = var5_3;
    }

    public static zzid[] values() {
        return (zzid[])zzn.clone();
    }

    public final Class zza() {
        return this.zzl;
    }
}

