/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgb;
import com.google.android.gms.internal.measurement.zzgz;
import com.google.android.gms.internal.measurement.zzha;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzht;
import com.google.android.gms.internal.measurement.zzhx;
import com.google.android.gms.internal.measurement.zzhy;
import com.google.android.gms.internal.measurement.zzhz;
import com.google.android.gms.internal.measurement.zzim;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zziz;
import com.google.android.gms.internal.measurement.zzjf;
import com.google.android.gms.internal.measurement.zzjg;
import com.google.android.gms.internal.measurement.zzjh;
import com.google.android.gms.internal.measurement.zzjx;
import com.google.android.gms.internal.measurement.zzkh;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzhs
extends zzgb {
    private static final Map zza;
    public zzjx zzc;
    public int zzd;

    static {
        ConcurrentHashMap concurrentHashMap;
        zza = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzhs() {
        zzjx zzjx2;
        this.zzc = zzjx2 = zzjx.zza();
        this.zzd = -1;
    }

    public static Object zzbA(Method object, Object object2, Object ... objectArray) {
        try {
            return ((Method)object).invoke(object2, objectArray);
        }
        catch (InvocationTargetException invocationTargetException) {
            object = invocationTargetException.getCause();
            boolean bl2 = object instanceof RuntimeException;
            if (!bl2) {
                bl2 = object instanceof Error;
                if (bl2) {
                    throw (Error)object;
                }
                object2 = new RuntimeException("Unexpected exception thrown by generated accessor method.", (Throwable)object);
                throw object2;
            }
            throw (RuntimeException)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", illegalAccessException);
            throw object2;
        }
    }

    public static zzhx zzbB() {
        return zzht.zzd();
    }

    public static zzhy zzbC() {
        return zzim.zzf();
    }

    public static zzhy zzbD(zzhy zzhy2) {
        int n10 = zzhy2.size();
        n10 = n10 == 0 ? 10 : (n10 += n10);
        return zzhy2.zzd(n10);
    }

    public static zzhz zzbE() {
        return zzjg.zzd();
    }

    public static zzhz zzbF(zzhz zzhz2) {
        int n10 = zzhz2.size();
        n10 = n10 == 0 ? 10 : (n10 += n10);
        return zzhz2.zze(n10);
    }

    public static zzhs zzbx(Class serializable) {
        ClassLoader classLoader;
        int n10;
        Object object = zza;
        Object object2 = (zzhs)object.get(serializable);
        if (object2 == null) {
            try {
                object2 = serializable.getName();
                n10 = 1;
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
                throw object;
            }
            classLoader = serializable.getClassLoader();
            Class.forName((String)object2, n10 != 0, classLoader);
            object2 = (zzhs)object.get(serializable);
        }
        if (object2 == null) {
            object2 = (zzhs)zzkh.zzc(serializable);
            n10 = 6;
            classLoader = null;
            if ((object2 = (zzhs)((zzhs)object2).zzl(n10, null, null)) != null) {
                object.put(serializable, object2);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object2;
    }

    public static void zzby(Class clazz, zzhs zzhs2) {
        zza.put(clazz, zzhs2);
    }

    public static Object zzbz(zzix zzix2, String string2, Object[] objectArray) {
        zzjh zzjh2 = new zzjh(zzix2, string2, objectArray);
        return zzjh2;
    }

    public final boolean equals(Object object) {
        Class<?> clazz;
        if (this == object) {
            return true;
        }
        Object object2 = null;
        if (object == null) {
            return false;
        }
        Class<?> clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            return false;
        }
        object2 = zzjf.zza();
        clazz2 = this.getClass();
        object2 = ((zzjf)object2).zzb(clazz2);
        object = (zzhs)object;
        return object2.zzb(this, object);
    }

    public final int hashCode() {
        int n10 = this.zzb;
        if (n10 != 0) {
            return n10;
        }
        zzjf zzjf2 = zzjf.zza();
        Class<?> clazz = this.getClass();
        this.zzb = n10 = zzjf2.zzb(clazz).zzc(this);
        return n10;
    }

    public final String toString() {
        String string2 = super.toString();
        return zziz.zza(this, string2);
    }

    public final int zzbq() {
        return this.zzd;
    }

    public final void zzbr(int n10) {
        this.zzd = n10;
    }

    public final zzho zzbt() {
        return (zzho)this.zzl(5, null, null);
    }

    public final zzho zzbu() {
        zzho zzho2 = (zzho)this.zzl(5, null, null);
        zzho2.zzaB(this);
        return zzho2;
    }

    public final void zzbv(zzgz object) {
        Object object2 = zzjf.zza();
        Class<?> clazz = this.getClass();
        object2 = ((zzjf)object2).zzb(clazz);
        object = zzha.zza((zzgz)object);
        object2.zzm(this, (zzha)object);
    }

    public final int zzbw() {
        int n10 = this.zzd;
        int n11 = -1;
        if (n10 == n11) {
            Object object = zzjf.zza();
            Class<?> clazz = this.getClass();
            object = ((zzjf)object).zzb(clazz);
            this.zzd = n10 = object.zze(this);
        }
        return n10;
    }

    public abstract Object zzl(int var1, Object var2, Object var3);
}

