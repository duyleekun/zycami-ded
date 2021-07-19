/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_common.zzda;
import com.google.android.gms.internal.mlkit_vision_common.zzdw;
import com.google.android.gms.internal.mlkit_vision_common.zzdy;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zza;
import com.google.android.gms.internal.mlkit_vision_common.zzej$zzf;
import com.google.android.gms.internal.mlkit_vision_common.zzek;
import com.google.android.gms.internal.mlkit_vision_common.zzeq;
import com.google.android.gms.internal.mlkit_vision_common.zzes;
import com.google.android.gms.internal.mlkit_vision_common.zzfr;
import com.google.android.gms.internal.mlkit_vision_common.zzfu;
import com.google.android.gms.internal.mlkit_vision_common.zzfw;
import com.google.android.gms.internal.mlkit_vision_common.zzgf;
import com.google.android.gms.internal.mlkit_vision_common.zzgg;
import com.google.android.gms.internal.mlkit_vision_common.zzgh;
import com.google.android.gms.internal.mlkit_vision_common.zzgi;
import com.google.android.gms.internal.mlkit_vision_common.zzhc;
import com.google.android.gms.internal.mlkit_vision_common.zzhf;
import com.google.android.gms.internal.mlkit_vision_common.zzht;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzej
extends zzda {
    private static Map zzd;
    public zzhc zzb;
    private int zzc;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzd = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzej() {
        zzhc zzhc2;
        this.zzb = zzhc2 = zzhc.zza();
        this.zzc = -1;
    }

    public static zzej zza(Class serializable) {
        ClassLoader classLoader;
        int n10;
        Object object = (zzej)zzd.get(serializable);
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
            object = (zzej)zzd.get(serializable);
        }
        if (object == null) {
            object = (zzej)zzhf.zza(serializable);
            n10 = zzej$zzf.zzf;
            classLoader = null;
            if ((object = (zzej)((zzej)object).zza(n10, null, null)) != null) {
                Map map = zzd;
                map.put(serializable, object);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object;
    }

    public static Object zza(zzfr zzfr2, String string2, Object[] objectArray) {
        zzgi zzgi2 = new zzgi(zzfr2, string2, objectArray);
        return zzgi2;
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

    public static void zza(Class clazz, zzej zzej2) {
        zzd.put(clazz, zzej2);
    }

    public static final boolean zza(zzej zzej2, boolean bl2) {
        byte by2;
        int n10 = zzej$zzf.zza;
        Object object = (Byte)zzej2.zza(n10, null, null);
        byte by3 = (Byte)object;
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = zzgg.zza().zza(zzej2);
        boolean bl3 = object.zzd(zzej2);
        if (bl2) {
            zzej zzej3;
            int n11 = zzej$zzf.zzb;
            if (bl3) {
                zzej3 = zzej2;
            } else {
                by2 = 0;
                zzej3 = null;
            }
            zzej2.zza(n11, zzej3, null);
        }
        return bl3;
    }

    public static zzeq zzk() {
        return zzek.zzd();
    }

    public static zzes zzl() {
        return zzgf.zzd();
    }

    public final boolean a_() {
        return zzej.zza(this, true);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        if (this == object) {
            return true;
        }
        zzgh zzgh2 = null;
        if (object == null) {
            return false;
        }
        Class<?> clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            return false;
        }
        zzgh2 = zzgg.zza().zza(this);
        object = (zzej)object;
        return zzgh2.zza((Object)this, object);
    }

    public int hashCode() {
        int n10 = this.zza;
        if (n10 != 0) {
            return n10;
        }
        this.zza = n10 = zzgg.zza().zza(this).zza(this);
        return n10;
    }

    public String toString() {
        String string2 = super.toString();
        return zzfw.zza(this, string2);
    }

    public final zzej$zza zza(zzej zzej2) {
        return this.zzh().zza(zzej2);
    }

    public abstract Object zza(int var1, Object var2, Object var3);

    public final void zza(int n10) {
        this.zzc = n10;
    }

    public final void zza(zzdw object) {
        zzgh zzgh2 = zzgg.zza().zza(this);
        object = zzdy.zza((zzdw)object);
        zzgh2.zza((Object)this, (zzht)object);
    }

    public final int zzg() {
        return this.zzc;
    }

    public final zzej$zza zzh() {
        int n10 = zzej$zzf.zze;
        return (zzej$zza)this.zza(n10, null, null);
    }

    public final /* synthetic */ zzfr zzi() {
        int n10 = zzej$zzf.zzf;
        return (zzej)this.zza(n10, null, null);
    }

    public final int zzj() {
        int n10 = this.zzc;
        int n11 = -1;
        if (n10 == n11) {
            zzgh zzgh2 = zzgg.zza().zza(this);
            this.zzc = n10 = zzgh2.zzb(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzfu zzm() {
        int n10 = zzej$zzf.zze;
        zzej$zza zzej$zza = (zzej$zza)this.zza(n10, null, null);
        zzej$zza.zza(this);
        return zzej$zza;
    }
}

