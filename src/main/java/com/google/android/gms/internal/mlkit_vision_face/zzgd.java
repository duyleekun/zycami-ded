/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzeu;
import com.google.android.gms.internal.mlkit_vision_face.zzfq;
import com.google.android.gms.internal.mlkit_vision_face.zzfs;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zza;
import com.google.android.gms.internal.mlkit_vision_face.zzgd$zzf;
import com.google.android.gms.internal.mlkit_vision_face.zzge;
import com.google.android.gms.internal.mlkit_vision_face.zzgk;
import com.google.android.gms.internal.mlkit_vision_face.zzgm;
import com.google.android.gms.internal.mlkit_vision_face.zzhl;
import com.google.android.gms.internal.mlkit_vision_face.zzho;
import com.google.android.gms.internal.mlkit_vision_face.zzhq;
import com.google.android.gms.internal.mlkit_vision_face.zzhz;
import com.google.android.gms.internal.mlkit_vision_face.zzia;
import com.google.android.gms.internal.mlkit_vision_face.zzib;
import com.google.android.gms.internal.mlkit_vision_face.zzic;
import com.google.android.gms.internal.mlkit_vision_face.zziw;
import com.google.android.gms.internal.mlkit_vision_face.zziz;
import com.google.android.gms.internal.mlkit_vision_face.zzjn;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzgd
extends zzeu {
    private static Map zzd;
    public zziw zzb;
    private int zzc;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzd = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzgd() {
        zziw zziw2;
        this.zzb = zziw2 = zziw.zza();
        this.zzc = -1;
    }

    public static zzgd zza(Class serializable) {
        ClassLoader classLoader;
        int n10;
        Object object = (zzgd)zzd.get(serializable);
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
            object = (zzgd)zzd.get(serializable);
        }
        if (object == null) {
            object = (zzgd)zziz.zza(serializable);
            n10 = zzgd$zzf.zzf;
            classLoader = null;
            if ((object = (zzgd)((zzgd)object).zza(n10, null, null)) != null) {
                Map map = zzd;
                map.put(serializable, object);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object;
    }

    public static Object zza(zzhl zzhl2, String string2, Object[] objectArray) {
        zzic zzic2 = new zzic(zzhl2, string2, objectArray);
        return zzic2;
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

    public static void zza(Class clazz, zzgd zzgd2) {
        zzd.put(clazz, zzgd2);
    }

    public static final boolean zza(zzgd zzgd2, boolean bl2) {
        byte by2;
        int n10 = zzgd$zzf.zza;
        Object object = (Byte)zzgd2.zza(n10, null, null);
        byte by3 = (Byte)object;
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = zzia.zza().zza(zzgd2);
        boolean bl3 = object.zzd(zzgd2);
        if (bl2) {
            zzgd zzgd3;
            int n11 = zzgd$zzf.zzb;
            if (bl3) {
                zzgd3 = zzgd2;
            } else {
                by2 = 0;
                zzgd3 = null;
            }
            zzgd2.zza(n11, zzgd3, null);
        }
        return bl3;
    }

    public static zzgk zzk() {
        return zzge.zzd();
    }

    public static zzgm zzl() {
        return zzhz.zzd();
    }

    public final boolean a_() {
        return zzgd.zza(this, true);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        if (this == object) {
            return true;
        }
        zzib zzib2 = null;
        if (object == null) {
            return false;
        }
        Class<?> clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            return false;
        }
        zzib2 = zzia.zza().zza(this);
        object = (zzgd)object;
        return zzib2.zza((Object)this, object);
    }

    public int hashCode() {
        int n10 = this.zza;
        if (n10 != 0) {
            return n10;
        }
        this.zza = n10 = zzia.zza().zza(this).zza(this);
        return n10;
    }

    public String toString() {
        String string2 = super.toString();
        return zzhq.zza(this, string2);
    }

    public final zzgd$zza zza(zzgd zzgd2) {
        return this.zzh().zza(zzgd2);
    }

    public abstract Object zza(int var1, Object var2, Object var3);

    public final void zza(int n10) {
        this.zzc = n10;
    }

    public final void zza(zzfq object) {
        zzib zzib2 = zzia.zza().zza(this);
        object = zzfs.zza((zzfq)object);
        zzib2.zza((Object)this, (zzjn)object);
    }

    public final int zzg() {
        return this.zzc;
    }

    public final zzgd$zza zzh() {
        int n10 = zzgd$zzf.zze;
        return (zzgd$zza)this.zza(n10, null, null);
    }

    public final /* synthetic */ zzhl zzi() {
        int n10 = zzgd$zzf.zzf;
        return (zzgd)this.zza(n10, null, null);
    }

    public final int zzj() {
        int n10 = this.zzc;
        int n11 = -1;
        if (n10 == n11) {
            zzib zzib2 = zzia.zza().zza(this);
            this.zzc = n10 = zzib2.zzb(this);
        }
        return this.zzc;
    }

    public final /* synthetic */ zzho zzm() {
        int n10 = zzgd$zzf.zze;
        zzgd$zza zzgd$zza = (zzgd$zza)this.zza(n10, null, null);
        zzgd$zza.zza(this);
        return zzgd$zza;
    }
}

