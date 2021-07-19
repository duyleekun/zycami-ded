/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzkc;
import com.google.android.gms.internal.measurement.zzkd;
import com.google.android.gms.internal.measurement.zzke;
import com.google.android.gms.internal.measurement.zzkf;
import com.google.android.gms.internal.measurement.zzkg;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zzkh {
    public static final long zza;
    public static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zzkg zzg;
    private static final boolean zzh;
    private static final boolean zzi;

    static {
        long l10;
        boolean bl2;
        int n10;
        Unsafe unsafe;
        Object object = Object[].class;
        Object object2 = double[].class;
        Class<float[]> clazz = float[].class;
        Class<long[]> clazz2 = long[].class;
        Class<int[]> clazz3 = int[].class;
        Class<boolean[]> clazz4 = boolean[].class;
        zzc = unsafe = zzkh.zzr();
        zzd = zzgd.zzb();
        Class<Long> clazz5 = Long.TYPE;
        zze = n10 = zzkh.zzE(clazz5);
        Class<Integer> clazz6 = Integer.TYPE;
        zzf = bl2 = zzkh.zzE(clazz6);
        zzkg zzkg2 = null;
        if (unsafe != null) {
            boolean bl3 = zzgd.zza();
            if (bl3) {
                if (n10 != 0) {
                    zzkg2 = new zzke(unsafe);
                } else if (bl2) {
                    zzkg2 = new zzkd(unsafe);
                }
            } else {
                zzkg2 = new zzkf(unsafe);
            }
        }
        zzg = zzkg2;
        boolean bl4 = false;
        unsafe = null;
        if (zzkg2 == null) {
            n10 = 0;
            clazz5 = null;
        } else {
            n10 = zzkg2.zzj();
        }
        zzh = n10;
        if (zzkg2 == null) {
            n10 = 0;
            clazz5 = null;
        } else {
            n10 = zzkg2.zzi();
        }
        zzi = n10;
        clazz5 = byte[].class;
        n10 = zzkh.zzC(clazz5);
        zza = l10 = (long)n10;
        zzkh.zzC(clazz4);
        zzkh.zzD(clazz4);
        zzkh.zzC(clazz3);
        zzkh.zzD(clazz3);
        zzkh.zzC(clazz2);
        zzkh.zzD(clazz2);
        zzkh.zzC(clazz);
        zzkh.zzD(clazz);
        zzkh.zzC(object2);
        zzkh.zzD(object2);
        zzkh.zzC(object);
        zzkh.zzD(object);
        object = zzkh.zzF();
        if (object != null && zzkg2 != null) {
            zzkg2.zzk((Field)object);
        }
        if ((object = ByteOrder.nativeOrder()) == (object2 = ByteOrder.BIG_ENDIAN)) {
            bl4 = true;
        }
        zzb = bl4;
    }

    private zzkh() {
    }

    public static /* synthetic */ void zzA(Object object, long l10, boolean bl2) {
        zzkh.zzJ(object, l10, (byte)(bl2 ? 1 : 0));
    }

    public static /* synthetic */ void zzB(Object object, long l10, boolean bl2) {
        zzkh.zzK(object, l10, (byte)(bl2 ? 1 : 0));
    }

    private static int zzC(Class clazz) {
        boolean bl2 = zzi;
        if (bl2) {
            return zzg.zzl(clazz);
        }
        return -1;
    }

    private static int zzD(Class clazz) {
        boolean bl2 = zzi;
        if (bl2) {
            return zzg.zzm(clazz);
        }
        return -1;
    }

    private static boolean zzE(Class object) {
        int n10;
        Class clazz;
        Class<byte[]> clazz2 = byte[].class;
        boolean bl2 = zzgd.zza();
        if (!bl2) {
            return false;
        }
        try {
            clazz = zzd;
            n10 = 2;
        }
        catch (Throwable throwable) {
            return false;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = object;
        Class[] classArray2 = Boolean.TYPE;
        boolean bl3 = true;
        classArray[bl3] = classArray2;
        Object object2 = "peekLong";
        clazz.getMethod((String)object2, classArray);
        int n11 = 3;
        object2 = new Class[n11];
        object2[0] = object;
        Class<Integer> clazz3 = Long.TYPE;
        object2[bl3] = clazz3;
        object2[n10] = classArray2;
        clazz3 = "pokeLong";
        clazz.getMethod((String)((Object)clazz3), (Class<?>)object2);
        object2 = new Class[n11];
        object2[0] = object;
        clazz3 = Integer.TYPE;
        object2[bl3] = clazz3;
        object2[n10] = classArray2;
        String string2 = "pokeInt";
        clazz.getMethod(string2, (Class<?>)object2);
        object2 = new Class[n10];
        object2[0] = object;
        object2[bl3] = classArray2;
        classArray2 = "peekInt";
        clazz.getMethod((String)classArray2, (Class<?>)object2);
        classArray2 = new Class[n10];
        classArray2[0] = object;
        object2 = Byte.TYPE;
        classArray2[bl3] = object2;
        object2 = "pokeByte";
        clazz.getMethod((String)object2, classArray2);
        classArray2 = new Class[bl3];
        classArray2[0] = object;
        object2 = "peekByte";
        clazz.getMethod((String)object2, classArray2);
        int n12 = 4;
        object2 = new Class[n12];
        object2[0] = object;
        object2[bl3] = clazz2;
        object2[n10] = clazz3;
        object2[n11] = clazz3;
        string2 = "pokeByteArray";
        clazz.getMethod(string2, (Class<?>)object2);
        classArray2 = new Class[n12];
        classArray2[0] = object;
        classArray2[bl3] = clazz2;
        classArray2[n10] = clazz3;
        classArray2[n11] = clazz3;
        object = "peekByteArray";
        clazz.getMethod((String)object, classArray2);
        return bl3;
    }

    private static Field zzF() {
        Class<Long> clazz;
        Object object;
        Field field;
        boolean bl2 = zzgd.zza();
        if (bl2 && (field = zzkh.zzG(Buffer.class, (String)(object = "effectiveDirectAddress"))) != null) {
            return field;
        }
        object = "address";
        field = zzkh.zzG(Buffer.class, (String)object);
        if (field != null && (object = field.getType()) == (clazz = Long.TYPE)) {
            return field;
        }
        return null;
    }

    private static Field zzG(Class annotatedElement, String string2) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string2);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static byte zzH(Object object, long l10) {
        zzkg zzkg2 = zzg;
        long l11 = (long)-4 & l10;
        int n10 = zzkg2.zzn(object, l11);
        int n11 = (int)(((l10 ^ (long)-1) & (long)3) << 3);
        return (byte)(n10 >>> n11 & 0xFF);
    }

    private static byte zzI(Object object, long l10) {
        zzkg zzkg2 = zzg;
        long l11 = (long)-4 & l10;
        int n10 = zzkg2.zzn(object, l11);
        int n11 = (int)((l10 & (long)3) << 3);
        return (byte)(n10 >>> n11 & 0xFF);
    }

    private static void zzJ(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        zzkg zzkg2 = zzg;
        int n10 = zzkg2.zzn(object, l11);
        int n11 = (~((int)l10) & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzkg2.zzo(object, l11, n11);
    }

    private static void zzK(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        zzkg zzkg2 = zzg;
        int n10 = zzkg2.zzn(object, l11);
        int n11 = ((int)l10 & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzkg2.zzo(object, l11, n11);
    }

    public static boolean zza() {
        return zzi;
    }

    public static boolean zzb() {
        return zzh;
    }

    public static Object zzc(Class clazz) {
        Object object;
        try {
            object = zzc;
        }
        catch (InstantiationException instantiationException) {
            object = new IllegalStateException(instantiationException);
            throw object;
        }
        return ((Unsafe)object).allocateInstance(clazz);
    }

    public static int zzd(Object object, long l10) {
        return zzg.zzn(object, l10);
    }

    public static void zze(Object object, long l10, int n10) {
        zzg.zzo(object, l10, n10);
    }

    public static long zzf(Object object, long l10) {
        return zzg.zzp(object, l10);
    }

    public static void zzg(Object object, long l10, long l11) {
        zzg.zzq(object, l10, l11);
    }

    public static boolean zzh(Object object, long l10) {
        return zzg.zzc(object, l10);
    }

    public static void zzi(Object object, long l10, boolean bl2) {
        zzg.zzd(object, l10, bl2);
    }

    public static float zzj(Object object, long l10) {
        return zzg.zze(object, l10);
    }

    public static void zzk(Object object, long l10, float f10) {
        zzg.zzf(object, l10, f10);
    }

    public static double zzl(Object object, long l10) {
        return zzg.zzg(object, l10);
    }

    public static void zzm(Object object, long l10, double d10) {
        zzg.zzh(object, l10, d10);
    }

    public static Object zzn(Object object, long l10) {
        return zzg.zzr(object, l10);
    }

    public static void zzo(Object object, long l10, Object object2) {
        zzg.zzs(object, l10, object2);
    }

    public static byte zzp(byte[] byArray, long l10) {
        zzkg zzkg2 = zzg;
        long l11 = zza + l10;
        return zzkg2.zza(byArray, l11);
    }

    public static void zzq(byte[] byArray, long l10, byte by2) {
        zzkg zzkg2 = zzg;
        long l11 = zza + l10;
        zzkg2.zzb(byArray, l11, by2);
    }

    public static Unsafe zzr() {
        Object object = new zzkc();
        object = AccessController.doPrivileged(object);
        try {
            object = (Unsafe)object;
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    public static /* synthetic */ void zzs(Throwable object) {
        Logger logger = Logger.getLogger(zzkh.class.getName());
        Level level = Level.WARNING;
        object = String.valueOf(object);
        int n10 = String.valueOf(object).length();
        StringBuilder stringBuilder = new StringBuilder(n10 += 71);
        stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        logger.logp(level, "com.google.protobuf.UnsafeUtil", "logMissingMethod", (String)object);
    }

    public static /* synthetic */ Field zzt() {
        return zzkh.zzF();
    }

    public static /* synthetic */ byte zzu(Object object, long l10) {
        return zzkh.zzH(object, l10);
    }

    public static /* synthetic */ byte zzv(Object object, long l10) {
        return zzkh.zzI(object, l10);
    }

    public static /* synthetic */ void zzw(Object object, long l10, byte by2) {
        zzkh.zzJ(object, l10, by2);
    }

    public static /* synthetic */ void zzx(Object object, long l10, byte by2) {
        zzkh.zzK(object, l10, by2);
    }

    public static /* synthetic */ boolean zzy(Object object, long l10) {
        byte by2 = zzkh.zzH(object, l10);
        return by2 != 0;
    }

    public static /* synthetic */ boolean zzz(Object object, long l10) {
        byte by2 = zzkh.zzI(object, l10);
        return by2 != 0;
    }
}

