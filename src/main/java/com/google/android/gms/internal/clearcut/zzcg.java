/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzas;
import com.google.android.gms.internal.clearcut.zzay;
import com.google.android.gms.internal.clearcut.zzbn;
import com.google.android.gms.internal.clearcut.zzbp;
import com.google.android.gms.internal.clearcut.zzcg$zza;
import com.google.android.gms.internal.clearcut.zzcg$zze;
import com.google.android.gms.internal.clearcut.zzcg$zzf;
import com.google.android.gms.internal.clearcut.zzcg$zzg;
import com.google.android.gms.internal.clearcut.zzch;
import com.google.android.gms.internal.clearcut.zzck;
import com.google.android.gms.internal.clearcut.zzcl;
import com.google.android.gms.internal.clearcut.zzcm;
import com.google.android.gms.internal.clearcut.zzcn;
import com.google.android.gms.internal.clearcut.zzco;
import com.google.android.gms.internal.clearcut.zzdc;
import com.google.android.gms.internal.clearcut.zzdo;
import com.google.android.gms.internal.clearcut.zzdp;
import com.google.android.gms.internal.clearcut.zzdr;
import com.google.android.gms.internal.clearcut.zzea;
import com.google.android.gms.internal.clearcut.zzeb;
import com.google.android.gms.internal.clearcut.zzec;
import com.google.android.gms.internal.clearcut.zzef;
import com.google.android.gms.internal.clearcut.zzew;
import com.google.android.gms.internal.clearcut.zzey;
import com.google.android.gms.internal.clearcut.zzfl;
import com.google.android.gms.internal.clearcut.zzfr;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzcg
extends zzas {
    private static Map zzjr;
    public zzey zzjp;
    private int zzjq;

    static {
        ConcurrentHashMap concurrentHashMap;
        zzjr = concurrentHashMap = new ConcurrentHashMap();
    }

    public zzcg() {
        zzey zzey2;
        this.zzjp = zzey2 = zzey.zzea();
        this.zzjq = -1;
    }

    public static zzcg$zzf zza(zzdo zzdo2, Object object, zzdo zzdo3, zzck object2, int n10, zzfl zzfl2, Class clazz) {
        zzcg$zze zzcg$zze = new zzcg$zze(null, 66321687, zzfl2, false, false);
        object2 = new zzcg$zzf(zzdo2, object, zzdo3, zzcg$zze, clazz);
        return object2;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static zzcg zza(zzcg zzcg2, byte[] object) {
        Object object2;
        int n10;
        block14: {
            n10 = zzcg$zzg.zzkg;
            zzcg2 = (zzcg)zzcg2.zza(n10, null, null);
            object2 = zzea.zzcm();
            object2 = ((zzea)object2).zzp(zzcg2);
            int n11 = ((Object)object).length;
            zzay zzay2 = new zzay();
            object2.zza(zzcg2, (byte[])object, 0, n11, zzay2);
            object = zzea.zzcm();
            object = ((zzea)object).zzp(zzcg2);
            object.zzc(zzcg2);
            int n12 = zzcg2.zzex;
            if (n12 != 0) break block14;
            return zzcg2;
        }
        try {
            object = new RuntimeException();
            throw object;
        }
        catch (IOException iOException) {
            object2 = iOException.getCause();
            n10 = object2 instanceof zzco;
            if (n10 != 0) {
                throw (zzco)iOException.getCause();
            }
            String string2 = iOException.getMessage();
            object2 = new zzco(string2);
            throw ((zzco)object2).zzg(zzcg2);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw zzco.zzbl().zzg(zzcg2);
        }
    }

    public static Object zza(zzdo zzdo2, String string2, Object[] objectArray) {
        zzec zzec2 = new zzec(zzdo2, string2, objectArray);
        return zzec2;
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

    public static void zza(Class clazz, zzcg zzcg2) {
        zzjr.put(clazz, zzcg2);
    }

    public static final boolean zza(zzcg zzcg2, boolean bl2) {
        byte by2;
        int n10 = zzcg$zzg.zzkd;
        Byte by3 = (Byte)zzcg2.zza(n10, null, null);
        byte by4 = by3;
        if (by4 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by4) {
            return false;
        }
        return zzea.zzcm().zzp(zzcg2).zzo(zzcg2);
    }

    public static zzcl zzaz() {
        return zzch.zzbk();
    }

    public static zzcg zzb(zzcg zzcg2, byte[] object) {
        if ((zzcg2 = zzcg.zza(zzcg2, (byte[])object)) != null) {
            int n10;
            int n11 = zzcg$zzg.zzkd;
            zzco zzco2 = null;
            object = (Byte)zzcg2.zza(n11, null, null);
            if ((n11 = (int)((Byte)object).byteValue()) != (n10 = 1)) {
                if (n11 == 0) {
                    n10 = 0;
                } else {
                    object = zzea.zzcm().zzp(zzcg2);
                    n10 = (int)(object.zzo(zzcg2) ? 1 : 0);
                    n11 = zzcg$zzg.zzke;
                    zzcg zzcg3 = n10 != 0 ? zzcg2 : null;
                    zzcg2.zza(n11, zzcg3, null);
                }
            }
            if (n10 == 0) {
                object = new zzew(zzcg2);
                object = ((Throwable)object).getMessage();
                zzco2 = new zzco((String)object);
                throw zzco2.zzg(zzcg2);
            }
        }
        return zzcg2;
    }

    public static zzcm zzba() {
        return zzdc.zzbx();
    }

    public static zzcn zzbb() {
        return zzeb.zzcn();
    }

    public static zzcg zzc(Class object) {
        Object object2 = (zzcg)zzjr.get(object);
        if (object2 == null) {
            boolean bl2;
            try {
                object2 = ((Class)object).getName();
                bl2 = true;
            }
            catch (ClassNotFoundException classNotFoundException) {
                object2 = new IllegalStateException("Class initialization cannot fail.", classNotFoundException);
                throw object2;
            }
            ClassLoader classLoader = ((Class)object).getClassLoader();
            Class.forName((String)object2, bl2, classLoader);
            object2 = (zzcg)zzjr.get(object);
        }
        if (object2 == null) {
            String string2 = "Unable to get default instance for: ";
            int n10 = ((String)(object = String.valueOf(((Class)object).getName()))).length();
            object = n10 != 0 ? string2.concat((String)object) : new String(string2);
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        return object2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        int n10 = zzcg$zzg.zzki;
        Class<?> clazz = ((zzcg)this.zza(n10, null, null)).getClass();
        if ((n10 = (int)(clazz.isInstance(object) ? 1 : 0)) == 0) {
            return false;
        }
        clazz = zzea.zzcm().zzp(this);
        object = (zzcg)object;
        return clazz.equals(this, object);
    }

    public int hashCode() {
        int n10 = this.zzex;
        if (n10 != 0) {
            return n10;
        }
        this.zzex = n10 = zzea.zzcm().zzp(this).hashCode(this);
        return n10;
    }

    public final boolean isInitialized() {
        byte by2;
        int bl3 = zzcg$zzg.zzkd;
        Object object = (Byte)this.zza(bl3, null, null);
        byte by3 = (Byte)object;
        if (by3 == (by2 = 1)) {
            return by2 != 0;
        }
        if (!by3) {
            return false;
        }
        object = zzea.zzcm().zzp(this);
        boolean bl2 = object.zzo(this);
        int n10 = zzcg$zzg.zzke;
        zzcg zzcg2 = bl2 ? this : null;
        this.zza(n10, zzcg2, null);
        return bl2;
    }

    public String toString() {
        String string2 = super.toString();
        return zzdr.zza(this, string2);
    }

    public abstract Object zza(int var1, Object var2, Object var3);

    public final int zzas() {
        int n10 = this.zzjq;
        int n11 = -1;
        if (n10 == n11) {
            zzef zzef2 = zzea.zzcm().zzp(this);
            this.zzjq = n10 = zzef2.zzm(this);
        }
        return this.zzjq;
    }

    public final void zzb(zzbn object) {
        Object object2 = zzea.zzcm();
        Class<?> clazz = this.getClass();
        object2 = ((zzea)object2).zze(clazz);
        object = zzbp.zza((zzbn)object);
        object2.zza(this, (zzfr)object);
    }

    public final /* synthetic */ zzdp zzbc() {
        int n10 = zzcg$zzg.zzkh;
        zzcg$zza zzcg$zza = (zzcg$zza)this.zza(n10, null, null);
        zzcg$zza.zza(this);
        return zzcg$zza;
    }

    public final /* synthetic */ zzdp zzbd() {
        int n10 = zzcg$zzg.zzkh;
        return (zzcg$zza)this.zza(n10, null, null);
    }

    public final /* synthetic */ zzdo zzbe() {
        int n10 = zzcg$zzg.zzki;
        return (zzcg)this.zza(n10, null, null);
    }

    public final void zzf(int n10) {
        this.zzjq = n10;
    }

    public final int zzs() {
        return this.zzjq;
    }
}

