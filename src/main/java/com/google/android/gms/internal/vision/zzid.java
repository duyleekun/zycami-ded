/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzge;
import com.google.android.gms.internal.vision.zzgm;
import com.google.android.gms.internal.vision.zzhl;
import com.google.android.gms.internal.vision.zzhn;
import com.google.android.gms.internal.vision.zzho;
import com.google.android.gms.internal.vision.zzhp;
import com.google.android.gms.internal.vision.zzid$zza;
import com.google.android.gms.internal.vision.zzid$zzd;
import com.google.android.gms.internal.vision.zzid$zzf;
import com.google.android.gms.internal.vision.zzid$zzg;
import com.google.android.gms.internal.vision.zzif;
import com.google.android.gms.internal.vision.zzig;
import com.google.android.gms.internal.vision.zzii;
import com.google.android.gms.internal.vision.zzik;
import com.google.android.gms.internal.vision.zzin;
import com.google.android.gms.internal.vision.zzjm;
import com.google.android.gms.internal.vision.zzjn;
import com.google.android.gms.internal.vision.zzjo;
import com.google.android.gms.internal.vision.zzka;
import com.google.android.gms.internal.vision.zzkb;
import com.google.android.gms.internal.vision.zzkd;
import com.google.android.gms.internal.vision.zzkf;
import com.google.android.gms.internal.vision.zzku;
import com.google.android.gms.internal.vision.zzkw;
import com.google.android.gms.internal.vision.zzld;
import com.google.android.gms.internal.vision.zzlk;
import com.google.android.gms.internal.vision.zzlq;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzid
extends zzge {
    private static Map zzyb;
    public zzkw zzxz;
    private int zzya;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzyb = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzid() {
        zzkw zzkw2;
        this.zzxz = zzkw2 = zzkw.zzja();
        this.zzya = -1;
    }

    private static zzid$zzg zza(zzhp zzhp2) {
        return (zzid$zzg)zzhp2;
    }

    public static zzid$zzg zza(zzjn zzjn2, zzjn zzjn3, zzig object, int n10, zzlk zzlk2, boolean bl2, Class clazz) {
        List list = Collections.emptyList();
        zzid$zzd zzid$zzd = new zzid$zzd(null, 202056002, zzlk2, true, false);
        object = new zzid$zzg(zzjn2, list, zzjn3, zzid$zzd, clazz);
        return object;
    }

    public static zzid zza(zzid zzid2, byte[] byArray) {
        int n10 = byArray.length;
        zzho zzho2 = zzho.zzgf();
        return zzid.zzb(zzid.zza(zzid2, byArray, 0, n10, zzho2));
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static zzid zza(zzid zzid2, byte[] object, int n10, int n11, zzho zzho2) {
        Object object2;
        int n12;
        block12: {
            void var3_7;
            void var4_8;
            n12 = zzid$zzf.zzyk;
            zzid2 = (zzid)zzid2.zza(n12, null, null);
            object2 = zzkb.zzik();
            object2 = ((zzkb)object2).zzx(zzid2);
            zzgm zzgm2 = new zzgm((zzho)var4_8);
            object2.zza(zzid2, (byte[])object, 0, (int)var3_7, zzgm2);
            object2.zzj(zzid2);
            int n13 = zzid2.zzte;
            if (n13 != 0) break block12;
            return zzid2;
        }
        try {
            RuntimeException runtimeException = new RuntimeException();
            throw runtimeException;
        }
        catch (IOException iOException) {
            object2 = iOException.getCause();
            n12 = object2 instanceof zzin;
            if (n12 != 0) {
                throw (zzin)iOException.getCause();
            }
            String string2 = iOException.getMessage();
            object2 = new zzin(string2);
            throw ((zzin)object2).zzg(zzid2);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzin.zzhh().zzg(zzid2);
        }
    }

    public static zzid zza(zzid zzid2, byte[] byArray, zzho zzho2) {
        int n10 = byArray.length;
        return zzid.zzb(zzid.zza(zzid2, byArray, 0, n10, zzho2));
    }

    public static zzik zza(zzik zzik2) {
        int n10 = zzik2.size();
        n10 = n10 == 0 ? 10 : (n10 <<= 1);
        return zzik2.zzan(n10);
    }

    public static Object zza(zzjn zzjn2, String string2, Object[] objectArray) {
        zzkd zzkd2 = new zzkd(zzjn2, string2, objectArray);
        return zzkd2;
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

    public static void zza(Class clazz, zzid zzid2) {
        zzyb.put(clazz, zzid2);
    }

    public static final boolean zza(zzid zzid2, boolean bl2) {
        byte by2;
        int n10 = zzid$zzf.zzyh;
        Object object = (Byte)zzid2.zza(n10, null, null);
        byte by3 = (Byte)object;
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = zzkb.zzik().zzx(zzid2);
        boolean bl3 = object.zzw(zzid2);
        if (bl2) {
            zzid zzid3;
            int n11 = zzid$zzf.zzyi;
            if (bl3) {
                zzid3 = zzid2;
            } else {
                by2 = 0;
                zzid3 = null;
            }
            zzid2.zza(n11, zzid3, null);
        }
        return bl3;
    }

    public static /* synthetic */ zzid$zzg zzb(zzhp zzhp2) {
        return zzid.zza(zzhp2);
    }

    private static zzid zzb(zzid zzid2) {
        boolean bl2;
        if (zzid2 != null && !(bl2 = zzid2.isInitialized())) {
            Object object = new zzku(zzid2);
            object = ((Throwable)object).getMessage();
            zzin zzin2 = new zzin((String)object);
            throw zzin2.zzg(zzid2);
        }
        return zzid2;
    }

    public static zzid zzd(Class serializable) {
        ClassLoader classLoader;
        int n10;
        Object object = (zzid)zzyb.get(serializable);
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
            object = (zzid)zzyb.get(serializable);
        }
        if (object == null) {
            object = (zzid)zzld.zzh(serializable);
            n10 = zzid$zzf.zzym;
            classLoader = null;
            if ((object = (zzid)((zzid)object).zza(n10, null, null)) != null) {
                Map map = zzyb;
                map.put(serializable, object);
            } else {
                serializable = new IllegalStateException();
                throw serializable;
            }
        }
        return object;
    }

    public static zzii zzha() {
        return zzif.zzhg();
    }

    public static zzik zzhb() {
        return zzka.zzij();
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        if (this == object) {
            return true;
        }
        zzkf zzkf2 = null;
        if (object == null) {
            return false;
        }
        Class<?> clazz2 = this.getClass();
        if (clazz2 != (clazz = object.getClass())) {
            return false;
        }
        zzkf2 = zzkb.zzik().zzx(this);
        object = (zzid)object;
        return zzkf2.equals(this, object);
    }

    public int hashCode() {
        int n10 = this.zzte;
        if (n10 != 0) {
            return n10;
        }
        this.zzte = n10 = zzkb.zzik().zzx(this).hashCode(this);
        return n10;
    }

    public final boolean isInitialized() {
        return zzid.zza(this, true);
    }

    public String toString() {
        String string2 = super.toString();
        return zzjo.zza(this, string2);
    }

    public abstract Object zza(int var1, Object var2, Object var3);

    public final void zzak(int n10) {
        this.zzya = n10;
    }

    public final void zzb(zzhl object) {
        zzkf zzkf2 = zzkb.zzik().zzx(this);
        object = zzhn.zza((zzhl)object);
        zzkf2.zza(this, (zzlq)object);
    }

    public final int zzef() {
        return this.zzya;
    }

    public final /* synthetic */ zzjn zzgx() {
        int n10 = zzid$zzf.zzym;
        return (zzid)this.zza(n10, null, null);
    }

    public final zzid$zza zzgy() {
        int n10 = zzid$zzf.zzyl;
        return (zzid$zza)this.zza(n10, null, null);
    }

    public final int zzgz() {
        int n10 = this.zzya;
        int n11 = -1;
        if (n10 == n11) {
            zzkf zzkf2 = zzkb.zzik().zzx(this);
            this.zzya = n10 = zzkf2.zzu(this);
        }
        return this.zzya;
    }

    public final /* synthetic */ zzjm zzhc() {
        int n10 = zzid$zzf.zzyl;
        zzid$zza zzid$zza = (zzid$zza)this.zza(n10, null, null);
        zzid$zza.zza(this);
        return zzid$zza;
    }

    public final /* synthetic */ zzjm zzhd() {
        int n10 = zzid$zzf.zzyl;
        return (zzid$zza)this.zza(n10, null, null);
    }
}

