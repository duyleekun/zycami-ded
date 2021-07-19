/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_common.zzeg;
import com.google.android.gms.internal.mlkit_common.zzfc;
import com.google.android.gms.internal.mlkit_common.zzff;
import com.google.android.gms.internal.mlkit_common.zzfq$zzb;
import com.google.android.gms.internal.mlkit_common.zzfq$zze;
import com.google.android.gms.internal.mlkit_common.zzft;
import com.google.android.gms.internal.mlkit_common.zzfw;
import com.google.android.gms.internal.mlkit_common.zzfy;
import com.google.android.gms.internal.mlkit_common.zzha;
import com.google.android.gms.internal.mlkit_common.zzhb;
import com.google.android.gms.internal.mlkit_common.zzhc;
import com.google.android.gms.internal.mlkit_common.zzhm;
import com.google.android.gms.internal.mlkit_common.zzho;
import com.google.android.gms.internal.mlkit_common.zzhp;
import com.google.android.gms.internal.mlkit_common.zzhr;
import com.google.android.gms.internal.mlkit_common.zzii;
import com.google.android.gms.internal.mlkit_common.zzip;
import com.google.android.gms.internal.mlkit_common.zzjd;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzfq
extends zzeg {
    private static Map zzd;
    public zzii zzb;
    private int zzc;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzd = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzfq() {
        zzii zzii2;
        this.zzb = zzii2 = zzii.zza();
        this.zzc = -1;
    }

    public static zzfq zza(Class serializable) {
        ClassLoader classLoader;
        int n10;
        Object object = (zzfq)zzd.get(serializable);
        if (object == null) {
            try {
                object = serializable.getName();
                n10 = 1;
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
                throw object;
            }
            classLoader = serializable.getClassLoader();
            Class.forName((String)object, n10 != 0, classLoader);
            object = (zzfq)zzd.get(serializable);
        }
        if (object == null) {
            object = (zzfq)zzip.zza(serializable);
            n10 = zzfq$zze.zzf;
            classLoader = null;
            if ((object = (zzfq)((zzfq)object).zza(n10, null, null)) != null) {
                Map map = zzd;
                map.put(serializable, object);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object;
    }

    public static Object zza(zzhb zzhb2, String string2, Object[] objectArray) {
        zzho zzho2 = new zzho(zzhb2, string2, objectArray);
        return zzho2;
    }

    public static Object zza(Method object, Object object2, Object ... objectArray) {
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

    public static void zza(Class clazz, zzfq zzfq2) {
        zzd.put(clazz, zzfq2);
    }

    public static final boolean zza(zzfq zzfq2, boolean bl2) {
        byte by2;
        int n10 = zzfq$zze.zza;
        Object object = (Byte)zzfq2.zza(n10, null, null);
        byte by3 = (Byte)object;
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = zzhm.zza().zza(zzfq2);
        boolean bl3 = object.zzc(zzfq2);
        if (bl2) {
            zzfq zzfq3;
            int n11 = zzfq$zze.zzb;
            if (bl3) {
                zzfq3 = zzfq2;
            } else {
                by2 = 0;
                zzfq3 = null;
            }
            zzfq2.zza(n11, zzfq3, null);
        }
        return bl3;
    }

    public static zzfw zzk() {
        return zzft.zzd();
    }

    public static zzfy zzl() {
        return zzhp.zzd();
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        if (this == object) {
            return true;
        }
        zzhr zzhr2 = null;
        if (object == null) {
            return false;
        }
        Class<?> clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            return false;
        }
        zzhr2 = zzhm.zza().zza(this);
        object = (zzfq)object;
        return zzhr2.zza((Object)this, object);
    }

    public int hashCode() {
        int n10 = this.zza;
        if (n10 != 0) {
            return n10;
        }
        this.zza = n10 = zzhm.zza().zza(this).zza(this);
        return n10;
    }

    public String toString() {
        String string2 = super.toString();
        return zzhc.zza(this, string2);
    }

    public final zzfq$zzb zza(zzfq zzfq2) {
        return this.zzh().zza(zzfq2);
    }

    public abstract Object zza(int var1, Object var2, Object var3);

    public final void zza(int n10) {
        this.zzc = n10;
    }

    public final void zza(zzfc object) {
        zzhr zzhr2 = zzhm.zza().zza(this);
        object = zzff.zza((zzfc)object);
        zzhr2.zza((Object)this, (zzjd)object);
    }

    public final int zzg() {
        return this.zzc;
    }

    public final zzfq$zzb zzh() {
        int n10 = zzfq$zze.zze;
        return (zzfq$zzb)this.zza(n10, null, null);
    }

    public final boolean zzi() {
        return zzfq.zza(this, true);
    }

    public final int zzj() {
        int n10 = this.zzc;
        int n11 = -1;
        if (n10 == n11) {
            zzhr zzhr2 = zzhm.zza().zza(this);
            this.zzc = n10 = zzhr2.zzd(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzha zzm() {
        int n10 = zzfq$zze.zze;
        zzfq$zzb zzfq$zzb = (zzfq$zzb)this.zza(n10, null, null);
        zzfq$zzb.zza(this);
        return zzfq$zzb;
    }

    public final /* synthetic */ zzhb zzn() {
        int n10 = zzfq$zze.zzf;
        return (zzfq)this.zza(n10, null, null);
    }
}

