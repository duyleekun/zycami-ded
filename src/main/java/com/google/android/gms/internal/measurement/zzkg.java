/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzkh;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public abstract class zzkg {
    public final Unsafe zza;

    public zzkg(Unsafe unsafe) {
        this.zza = unsafe;
    }

    public abstract byte zza(Object var1, long var2);

    public abstract void zzb(Object var1, long var2, byte var4);

    public abstract boolean zzc(Object var1, long var2);

    public abstract void zzd(Object var1, long var2, boolean var4);

    public abstract float zze(Object var1, long var2);

    public abstract void zzf(Object var1, long var2, float var4);

    public abstract double zzg(Object var1, long var2);

    public abstract void zzh(Object var1, long var2, double var4);

    public boolean zzi() {
        Object object = Object.class;
        Object object2 = this.zza;
        if (object2 != null) {
            object2 = object2.getClass();
            boolean bl2 = true;
            Class[] classArray = new Class[bl2];
            Class[] classArray2 = Field.class;
            classArray[0] = classArray2;
            classArray2 = "objectFieldOffset";
            ((Class)object2).getMethod((String)classArray2, classArray);
            classArray = new Class[bl2];
            classArray2 = Class.class;
            classArray[0] = classArray2;
            classArray2 = "arrayBaseOffset";
            ((Class)object2).getMethod((String)classArray2, classArray);
            classArray = new Class[bl2];
            classArray2 = Class.class;
            classArray[0] = classArray2;
            classArray2 = "arrayIndexScale";
            ((Class)object2).getMethod((String)classArray2, classArray);
            int n10 = 2;
            classArray2 = new Class[n10];
            classArray2[0] = object;
            Class<Long> clazz = Long.TYPE;
            classArray2[bl2] = clazz;
            Class[] classArray3 = "getInt";
            ((Class)object2).getMethod((String)classArray3, classArray2);
            int n11 = 3;
            classArray3 = new Class[n11];
            classArray3[0] = object;
            classArray3[bl2] = clazz;
            Object object3 = Integer.TYPE;
            classArray3[n10] = object3;
            object3 = "putInt";
            ((Class)object2).getMethod((String)object3, classArray3);
            classArray3 = new Class[n10];
            classArray3[0] = object;
            classArray3[bl2] = clazz;
            object3 = "getLong";
            ((Class)object2).getMethod((String)object3, classArray3);
            classArray3 = new Class[n11];
            classArray3[0] = object;
            classArray3[bl2] = clazz;
            classArray3[n10] = clazz;
            object3 = "putLong";
            ((Class)object2).getMethod((String)object3, classArray3);
            classArray3 = new Class[n10];
            classArray3[0] = object;
            classArray3[bl2] = clazz;
            object3 = "getObject";
            ((Class)object2).getMethod((String)object3, classArray3);
            classArray2 = new Class[n11];
            classArray2[0] = object;
            classArray2[bl2] = clazz;
            classArray2[n10] = object;
            object = "putObject";
            try {
                ((Class)object2).getMethod((String)object, classArray2);
                return bl2;
            }
            catch (Throwable throwable) {
                zzkh.zzs(throwable);
            }
        }
        return false;
    }

    public boolean zzj() {
        Object object = this.zza;
        if (object != null) {
            object = object.getClass();
            boolean bl2 = true;
            Class[] classArray = new Class[bl2];
            Object object2 = Field.class;
            classArray[0] = object2;
            object2 = "objectFieldOffset";
            ((Class)object).getMethod((String)object2, classArray);
            int n10 = 2;
            classArray = new Class[n10];
            object2 = Object.class;
            classArray[0] = object2;
            object2 = Long.TYPE;
            classArray[bl2] = object2;
            object2 = "getLong";
            try {
                ((Class)object).getMethod((String)object2, classArray);
                object = zzkh.zzt();
                if (object == null) {
                    return false;
                }
                return bl2;
            }
            catch (Throwable throwable) {
                zzkh.zzs(throwable);
            }
        }
        return false;
    }

    public final long zzk(Field field) {
        return this.zza.objectFieldOffset(field);
    }

    public final int zzl(Class clazz) {
        return this.zza.arrayBaseOffset(clazz);
    }

    public final int zzm(Class clazz) {
        return this.zza.arrayIndexScale(clazz);
    }

    public final int zzn(Object object, long l10) {
        return this.zza.getInt(object, l10);
    }

    public final void zzo(Object object, long l10, int n10) {
        this.zza.putInt(object, l10, n10);
    }

    public final long zzp(Object object, long l10) {
        return this.zza.getLong(object, l10);
    }

    public final void zzq(Object object, long l10, long l11) {
        this.zza.putLong(object, l10, l11);
    }

    public final Object zzr(Object object, long l10) {
        return this.zza.getObject(object, l10);
    }

    public final void zzs(Object object, long l10, Object object2) {
        this.zza.putObject(object, l10, object2);
    }
}

