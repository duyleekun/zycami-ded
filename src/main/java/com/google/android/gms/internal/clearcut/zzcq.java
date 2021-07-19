/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzbb;
import java.io.Serializable;
import java.lang.constant.Constable;

public final class zzcq
extends Enum {
    public static final /* enum */ zzcq zzkx;
    public static final /* enum */ zzcq zzky;
    public static final /* enum */ zzcq zzkz;
    public static final /* enum */ zzcq zzla;
    public static final /* enum */ zzcq zzlb;
    public static final /* enum */ zzcq zzlc;
    public static final /* enum */ zzcq zzld;
    public static final /* enum */ zzcq zzle;
    public static final /* enum */ zzcq zzlf;
    public static final /* enum */ zzcq zzlg;
    private static final /* synthetic */ zzcq[] zzlk;
    private final Class zzlh;
    private final Class zzli;
    private final Object zzlj;

    static {
        zzcq zzcq2;
        zzcq zzcq3;
        zzcq zzcq4;
        zzcq zzcq5;
        zzcq zzcq6;
        zzcq[] zzcqArray;
        zzcq[] zzcqArray2 = zzcqArray;
        zzcqArray = new zzcq("VOID", 0, Void.class, Void.class, null);
        zzkx = zzcqArray;
        Object object = Integer.TYPE;
        Serializable serializable = 0;
        zzcq[] zzcqArray3 = zzcqArray2;
        Class<Constable> clazz = object;
        zzcqArray2 = new zzcq("INT", 1, object, Integer.class, (Object)serializable);
        zzky = zzcqArray2;
        Class<Number> clazz2 = Long.TYPE;
        Number number = 0L;
        zzcq zzcq7 = zzcq6;
        zzkz = zzcq6 = new zzcq("LONG", 2, clazz2, Long.class, (Object)number);
        clazz = Float.TYPE;
        serializable = Float.valueOf(0.0f);
        zzcqArray3 = zzcq5;
        zzla = zzcq5 = new zzcq("FLOAT", 3, clazz, Float.class, (Object)serializable);
        clazz2 = Double.TYPE;
        number = 0.0;
        zzcq7 = zzcq4;
        zzlb = zzcq4 = new zzcq("DOUBLE", 4, clazz2, Double.class, (Object)number);
        clazz = Boolean.TYPE;
        serializable = Boolean.FALSE;
        zzcqArray3 = zzcq7;
        zzlc = zzcq7 = new zzcq("BOOLEAN", 5, clazz, Boolean.class, (Object)serializable);
        zzcq zzcq8 = zzcq3;
        zzld = zzcq3 = new zzcq("STRING", 6, String.class, String.class, (Object)"");
        serializable = zzbb.zzfi;
        zzcqArray3 = zzcq8;
        zzle = zzcq8 = new zzcq("BYTE_STRING", 7, zzbb.class, zzbb.class, (Object)serializable);
        zzcqArray3 = zzcq2;
        clazz = object;
        zzlf = zzcq2 = new zzcq("ENUM", 8, object, Integer.class, null);
        object = new Object("MESSAGE", 9, Object.class, Object.class, null);
        zzlg = object;
        zzcqArray3 = new zzcq[]{zzcqArray, zzcqArray2, zzcq6, zzcq5, zzcq4, zzcq7, zzcq3, zzcq8, zzcq2, object};
        zzlk = zzcqArray3;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private zzcq(Object object) {
        void var5_3;
        void var4_2;
        void var2_-1;
        void var1_-1;
        this.zzlh = object;
        this.zzli = var4_2;
        this.zzlj = var5_3;
    }

    public static zzcq[] values() {
        return (zzcq[])zzlk.clone();
    }

    public final Class zzbq() {
        return this.zzli;
    }
}

