/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkg;
import com.google.android.gms.internal.measurement.zzkh;
import sun.misc.Unsafe;

public final class zzkf
extends zzkg {
    public zzkf(Unsafe unsafe) {
        super(unsafe);
    }

    public final byte zza(Object object, long l10) {
        return this.zza.getByte(object, l10);
    }

    public final void zzb(Object object, long l10, byte by2) {
        this.zza.putByte(object, l10, by2);
    }

    public final boolean zzc(Object object, long l10) {
        return this.zza.getBoolean(object, l10);
    }

    public final void zzd(Object object, long l10, boolean bl2) {
        this.zza.putBoolean(object, l10, bl2);
    }

    public final float zze(Object object, long l10) {
        return this.zza.getFloat(object, l10);
    }

    public final void zzf(Object object, long l10, float f10) {
        this.zza.putFloat(object, l10, f10);
    }

    public final double zzg(Object object, long l10) {
        return this.zza.getDouble(object, l10);
    }

    public final void zzh(Object object, long l10, double d10) {
        this.zza.putDouble(object, l10, d10);
    }

    public final boolean zzi() {
        Object object;
        Object object2 = Object.class;
        boolean bl2 = super.zzi();
        if (!bl2) {
            return false;
        }
        try {
            object = this.zza;
        }
        catch (Throwable throwable) {
            zzkh.zzs(throwable);
            return false;
        }
        object = object.getClass();
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        Class<Long> clazz = Long.TYPE;
        boolean bl3 = true;
        classArray[bl3] = clazz;
        Class[] classArray2 = "getByte";
        ((Class)object).getMethod((String)classArray2, classArray);
        int n11 = 3;
        classArray2 = new Class[n11];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        Object object3 = Byte.TYPE;
        classArray2[n10] = object3;
        object3 = "putByte";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray2 = new Class[n10];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        object3 = "getBoolean";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray2 = new Class[n11];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        object3 = Boolean.TYPE;
        classArray2[n10] = object3;
        object3 = "putBoolean";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray2 = new Class[n10];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        object3 = "getFloat";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray2 = new Class[n11];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        object3 = Float.TYPE;
        classArray2[n10] = object3;
        object3 = "putFloat";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray2 = new Class[n10];
        classArray2[0] = object2;
        classArray2[bl3] = clazz;
        object3 = "getDouble";
        ((Class)object).getMethod((String)object3, classArray2);
        classArray = new Class[n11];
        classArray[0] = object2;
        classArray[bl3] = clazz;
        object2 = Double.TYPE;
        classArray[n10] = object2;
        object2 = "putDouble";
        ((Class)object).getMethod((String)object2, classArray);
        return bl3;
    }

    public final boolean zzj() {
        Object object;
        Class<Object> clazz = Object.class;
        String string2 = "copyMemory";
        boolean bl2 = super.zzj();
        if (!bl2) {
            return false;
        }
        try {
            object = this.zza;
        }
        catch (Throwable throwable) {
            zzkh.zzs(throwable);
            return false;
        }
        object = object.getClass();
        boolean bl3 = true;
        Class[] classArray = new Class[bl3];
        Class<Long> clazz2 = Long.TYPE;
        classArray[0] = clazz2;
        Class[] classArray2 = "getByte";
        ((Class)object).getMethod((String)classArray2, classArray);
        int n10 = 2;
        classArray2 = new Class[n10];
        classArray2[0] = clazz2;
        Class[] classArray3 = Byte.TYPE;
        classArray2[bl3] = classArray3;
        classArray3 = "putByte";
        ((Class)object).getMethod((String)classArray3, classArray2);
        classArray2 = new Class[bl3];
        classArray2[0] = clazz2;
        classArray3 = "getInt";
        ((Class)object).getMethod((String)classArray3, classArray2);
        classArray2 = new Class[n10];
        classArray2[0] = clazz2;
        classArray3 = Integer.TYPE;
        classArray2[bl3] = classArray3;
        classArray3 = "putInt";
        ((Class)object).getMethod((String)classArray3, classArray2);
        classArray2 = new Class[bl3];
        classArray2[0] = clazz2;
        classArray3 = "getLong";
        ((Class)object).getMethod((String)classArray3, classArray2);
        classArray2 = new Class[n10];
        classArray2[0] = clazz2;
        classArray2[bl3] = clazz2;
        classArray3 = "putLong";
        ((Class)object).getMethod((String)classArray3, classArray2);
        int n11 = 3;
        classArray3 = new Class[n11];
        classArray3[0] = clazz2;
        classArray3[bl3] = clazz2;
        classArray3[n10] = clazz2;
        ((Class)object).getMethod(string2, classArray3);
        int n12 = 5;
        classArray3 = new Class[n12];
        classArray3[0] = clazz;
        classArray3[bl3] = clazz2;
        classArray3[n10] = clazz;
        classArray3[n11] = clazz2;
        int n13 = 4;
        classArray3[n13] = clazz2;
        ((Class)object).getMethod(string2, classArray3);
        return bl3;
    }
}

