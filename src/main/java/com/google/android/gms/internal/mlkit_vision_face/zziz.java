/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.mlkit_vision_face;

import com.google.android.gms.internal.mlkit_vision_face.zzex;
import com.google.android.gms.internal.mlkit_vision_face.zziz$zza;
import com.google.android.gms.internal.mlkit_vision_face.zziz$zzb;
import com.google.android.gms.internal.mlkit_vision_face.zziz$zzc;
import com.google.android.gms.internal.mlkit_vision_face.zziz$zzd;
import com.google.android.gms.internal.mlkit_vision_face.zzjb;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zziz {
    public static final boolean zza;
    private static final Logger zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final boolean zzf;
    private static final zziz$zzd zzg;
    private static final boolean zzh;
    private static final boolean zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final long zzw;
    private static final int zzx;

    static {
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        int n10;
        boolean bl2;
        Object object = Object[].class;
        Object object2 = double[].class;
        Class<float[]> clazz = float[].class;
        Class<long[]> clazz2 = long[].class;
        Class<int[]> clazz3 = int[].class;
        Class<boolean[]> clazz4 = boolean[].class;
        zzb = Logger.getLogger(zziz.class.getName());
        Object object3 = zziz.zzc();
        zzc = object3;
        zzd = zzex.zzb();
        Class<Long> clazz5 = Long.TYPE;
        zze = bl2 = zziz.zzd(clazz5);
        Class<Integer> clazz6 = Integer.TYPE;
        zzf = n10 = zziz.zzd(clazz6);
        zziz$zzd zziz$zzd = null;
        if (object3 != null) {
            boolean bl3 = zzex.zza();
            if (bl3) {
                if (bl2) {
                    zziz$zzd = new zziz$zzc((Unsafe)object3);
                } else if (n10 != 0) {
                    zziz$zzd = new zziz$zza((Unsafe)object3);
                }
            } else {
                zziz$zzd = new zziz$zzb((Unsafe)object3);
            }
        }
        zzg = zziz$zzd;
        zzh = zziz.zze();
        zzi = zziz.zzd();
        object3 = byte[].class;
        int n11 = zziz.zzb((Class)object3);
        zzj = l16 = (long)n11;
        n10 = zziz.zzb(clazz4);
        zzk = n10;
        zzl = zziz.zzc(clazz4);
        int n12 = zziz.zzb(clazz3);
        zzm = l15 = (long)n12;
        zzn = zziz.zzc(clazz3);
        int n13 = zziz.zzb(clazz2);
        zzo = l14 = (long)n13;
        zzp = zziz.zzc(clazz2);
        int n14 = zziz.zzb(clazz);
        zzq = l13 = (long)n14;
        zzr = zziz.zzc(clazz);
        int n15 = zziz.zzb(object2);
        zzs = l12 = (long)n15;
        zzt = zziz.zzc(object2);
        int n16 = zziz.zzb(object);
        zzu = l11 = (long)n16;
        int n17 = zziz.zzc(object);
        zzv = l10 = (long)n17;
        object = zziz.zzf();
        if (object != null && zziz$zzd != null) {
            object2 = zziz$zzd.zza;
            l10 = ((Unsafe)object2).objectFieldOffset((Field)object);
        } else {
            l10 = -1;
        }
        zzw = l10;
        l10 = (long)7 & l16;
        zzx = n17 = (int)l10;
        object = ByteOrder.nativeOrder();
        object2 = ByteOrder.BIG_ENDIAN;
        if (object == object2) {
            n17 = 1;
        } else {
            n17 = 0;
            object = null;
        }
        zza = n17;
    }

    private zziz() {
    }

    public static byte zza(byte[] byArray, long l10) {
        zziz$zzd zziz$zzd = zzg;
        long l11 = zzj + l10;
        return zziz$zzd.zza(byArray, l11);
    }

    public static int zza(Object object, long l10) {
        return zzg.zze(object, l10);
    }

    public static Object zza(Class clazz) {
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

    private static Field zza(Class annotatedElement, String string2) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string2);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    public static /* synthetic */ void zza(Object object, long l10, byte by2) {
        zziz.zzc(object, l10, by2);
    }

    public static void zza(Object object, long l10, double d10) {
        zzg.zza(object, l10, d10);
    }

    public static void zza(Object object, long l10, float f10) {
        zzg.zza(object, l10, f10);
    }

    public static void zza(Object object, long l10, int n10) {
        zzg.zza(object, l10, n10);
    }

    public static void zza(Object object, long l10, long l11) {
        zzg.zza(object, l10, l11);
    }

    public static void zza(Object object, long l10, Object object2) {
        zziz.zzg.zza.putObject(object, l10, object2);
    }

    public static void zza(Object object, long l10, boolean bl2) {
        zzg.zza(object, l10, bl2);
    }

    public static void zza(byte[] byArray, long l10, byte by2) {
        zziz$zzd zziz$zzd = zzg;
        long l11 = zzj + l10;
        zziz$zzd.zza((Object)byArray, l11, by2);
    }

    public static boolean zza() {
        return zzi;
    }

    private static int zzb(Class clazz) {
        boolean bl2 = zzi;
        if (bl2) {
            return zziz.zzg.zza.arrayBaseOffset(clazz);
        }
        return -1;
    }

    public static long zzb(Object object, long l10) {
        return zzg.zzf(object, l10);
    }

    public static /* synthetic */ void zzb(Object object, long l10, byte by2) {
        zziz.zzd(object, l10, by2);
    }

    public static /* synthetic */ void zzb(Object object, long l10, boolean bl2) {
        zziz.zzd(object, l10, bl2);
    }

    public static boolean zzb() {
        return zzh;
    }

    private static int zzc(Class clazz) {
        boolean bl2 = zzi;
        if (bl2) {
            return zziz.zzg.zza.arrayIndexScale(clazz);
        }
        return -1;
    }

    public static Unsafe zzc() {
        Object object = new zzjb();
        object = AccessController.doPrivileged(object);
        try {
            object = (Unsafe)object;
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    private static void zzc(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zziz.zza(object, l11);
        int n11 = (~((int)l10) & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zziz.zza(object, l11, n11);
    }

    public static /* synthetic */ void zzc(Object object, long l10, boolean bl2) {
        zziz.zze(object, l10, bl2);
    }

    public static boolean zzc(Object object, long l10) {
        return zzg.zzb(object, l10);
    }

    public static float zzd(Object object, long l10) {
        return zzg.zzc(object, l10);
    }

    private static void zzd(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zziz.zza(object, l11);
        int n11 = ((int)l10 & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zziz.zza(object, l11, n11);
    }

    private static void zzd(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zziz.zzc(object, l10, by2);
    }

    private static boolean zzd() {
        Object object;
        boolean bl2;
        Object object2;
        Class<Object> clazz = Object.class;
        Object object3 = zzc;
        if (object3 == null) {
            return false;
        }
        try {
            object3 = object3.getClass();
            object2 = "objectFieldOffset";
            bl2 = true;
        }
        catch (Throwable throwable) {
            object3 = zzb;
            object2 = Level.WARNING;
            String string2 = String.valueOf(throwable);
            int n10 = String.valueOf(string2).length() + 71;
            object = new StringBuilder(n10);
            ((StringBuilder)object).append("platform method missing - proto runtime falling back to safer methods: ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            ((Logger)object3).logp((Level)object2, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", string2);
            return false;
        }
        object = new Class[bl2];
        Class[] classArray = Field.class;
        object[0] = classArray;
        ((Class)object3).getMethod((String)object2, (Class<?>)object);
        object2 = "arrayBaseOffset";
        object = new Class[bl2];
        classArray = Class.class;
        object[0] = classArray;
        ((Class)object3).getMethod((String)object2, (Class<?>)object);
        object2 = "arrayIndexScale";
        object = new Class[bl2];
        classArray = Class.class;
        object[0] = classArray;
        ((Class)object3).getMethod((String)object2, (Class<?>)object);
        object2 = "getInt";
        int n11 = 2;
        classArray = new Class[n11];
        classArray[0] = clazz;
        Class<Long> clazz2 = Long.TYPE;
        classArray[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray);
        object2 = "putInt";
        int n12 = 3;
        Class[] classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        Class<Constable> clazz3 = Integer.TYPE;
        classArray2[n11] = clazz3;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "getLong";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putLong";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        classArray2[n11] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "getObject";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putObject";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        classArray2[n11] = clazz;
        ((Class)object3).getMethod((String)object2, classArray2);
        boolean bl3 = zzex.zza();
        if (bl3) {
            return bl2;
        }
        object2 = "getByte";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putByte";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        clazz3 = Byte.TYPE;
        classArray2[n11] = clazz3;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "getBoolean";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putBoolean";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        clazz3 = Boolean.TYPE;
        classArray2[n11] = clazz3;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "getFloat";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putFloat";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        clazz3 = Float.TYPE;
        classArray2[n11] = clazz3;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "getDouble";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        ((Class)object3).getMethod((String)object2, classArray2);
        object2 = "putDouble";
        classArray = new Class[n12];
        classArray[0] = clazz;
        classArray[bl2] = clazz2;
        clazz = Double.TYPE;
        classArray[n11] = clazz;
        ((Class)object3).getMethod((String)object2, classArray);
        return bl2;
    }

    private static boolean zzd(Class clazz) {
        int n10;
        String string2;
        Class clazz2;
        Class<byte[]> clazz3 = byte[].class;
        boolean bl2 = zzex.zza();
        if (!bl2) {
            return false;
        }
        try {
            clazz2 = zzd;
            string2 = "peekLong";
            n10 = 2;
        }
        catch (Throwable throwable) {
            return false;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = clazz;
        Class[] classArray2 = Boolean.TYPE;
        boolean bl3 = true;
        classArray[bl3] = classArray2;
        clazz2.getMethod(string2, classArray);
        string2 = "pokeLong";
        int n11 = 3;
        Object object = new Class[n11];
        object[0] = clazz;
        Class<Number> clazz4 = Long.TYPE;
        object[bl3] = clazz4;
        object[n10] = classArray2;
        clazz2.getMethod(string2, (Class<?>)object);
        string2 = "pokeInt";
        object = new Class[n11];
        object[0] = clazz;
        clazz4 = Integer.TYPE;
        object[bl3] = clazz4;
        object[n10] = classArray2;
        clazz2.getMethod(string2, (Class<?>)object);
        string2 = "peekInt";
        object = new Class[n10];
        object[0] = clazz;
        object[bl3] = classArray2;
        clazz2.getMethod(string2, (Class<?>)object);
        string2 = "pokeByte";
        classArray2 = new Class[n10];
        classArray2[0] = clazz;
        object = Byte.TYPE;
        classArray2[bl3] = object;
        clazz2.getMethod(string2, classArray2);
        string2 = "peekByte";
        classArray2 = new Class[bl3];
        classArray2[0] = clazz;
        clazz2.getMethod(string2, classArray2);
        string2 = "pokeByteArray";
        int n12 = 4;
        object = new Class[n12];
        object[0] = clazz;
        object[bl3] = clazz3;
        object[n10] = clazz4;
        object[n11] = clazz4;
        clazz2.getMethod(string2, (Class<?>)object);
        string2 = "peekByteArray";
        classArray2 = new Class[n12];
        classArray2[0] = clazz;
        classArray2[bl3] = clazz3;
        classArray2[n10] = clazz4;
        classArray2[n11] = clazz4;
        clazz2.getMethod(string2, classArray2);
        return bl3;
    }

    public static double zze(Object object, long l10) {
        return zzg.zzd(object, l10);
    }

    private static void zze(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zziz.zzd(object, l10, by2);
    }

    private static boolean zze() {
        int n10;
        Class clazz;
        Object object;
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        String string2;
        block44: {
            CharSequence charSequence;
            string2 = "copyMemory";
            object4 = "getLong";
            object3 = Object.class;
            object2 = zzc;
            if (object2 == null) {
                return false;
            }
            try {
                object2 = object2.getClass();
                charSequence = "objectFieldOffset";
                bl2 = true;
            }
            catch (Throwable throwable) {
                object4 = zzb;
                object3 = Level.WARNING;
                String string3 = String.valueOf(throwable);
                int n11 = String.valueOf(string3).length() + 71;
                charSequence = new StringBuilder(n11);
                ((StringBuilder)charSequence).append("platform method missing - proto runtime falling back to safer methods: ");
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                ((Logger)object4).logp((Level)object3, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", string3);
                return false;
            }
            object = new Class[bl2];
            clazz = Field.class;
            object[0] = clazz;
            ((Class)object2).getMethod((String)charSequence, (Class<?>)object);
            n10 = 2;
            object = new Class[n10];
            object[0] = object3;
            clazz = Long.TYPE;
            object[bl2] = clazz;
            ((Class)object2).getMethod((String)object4, (Class<?>)object);
            object = zziz.zzf();
            if (object != null) break block44;
            return false;
        }
        int n12 = zzex.zza();
        if (n12 != 0) {
            return bl2;
        }
        object = "getByte";
        Class[] classArray = new Class[bl2];
        classArray[0] = clazz;
        ((Class)object2).getMethod((String)object, classArray);
        object = "putByte";
        classArray = new Class[n10];
        classArray[0] = clazz;
        Class<Number> clazz2 = Byte.TYPE;
        classArray[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray);
        object = "getInt";
        classArray = new Class[bl2];
        classArray[0] = clazz;
        ((Class)object2).getMethod((String)object, classArray);
        object = "putInt";
        classArray = new Class[n10];
        classArray[0] = clazz;
        clazz2 = Integer.TYPE;
        classArray[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray);
        object = new Class[bl2];
        object[0] = clazz;
        ((Class)object2).getMethod((String)object4, (Class<?>)object);
        object4 = "putLong";
        object = new Class[n10];
        object[0] = clazz;
        object[bl2] = clazz;
        ((Class)object2).getMethod((String)object4, (Class<?>)object);
        int n13 = 3;
        object = new Class[n13];
        object[0] = clazz;
        object[bl2] = clazz;
        object[n10] = clazz;
        ((Class)object2).getMethod(string2, (Class<?>)object);
        n12 = 5;
        object = new Class[n12];
        object[0] = object3;
        object[bl2] = clazz;
        object[n10] = object3;
        object[n13] = clazz;
        n13 = 4;
        object[n13] = clazz;
        ((Class)object2).getMethod(string2, (Class<?>)object);
        return bl2;
    }

    public static Object zzf(Object object, long l10) {
        return zziz.zzg.zza.getObject(object, l10);
    }

    private static Field zzf() {
        Class<Long> clazz;
        Object object;
        Field field;
        boolean bl2 = zzex.zza();
        if (bl2 && (field = zziz.zza(Buffer.class, (String)(object = "effectiveDirectAddress"))) != null) {
            return field;
        }
        object = "address";
        field = zziz.zza(Buffer.class, (String)object);
        if (field != null && (object = field.getType()) == (clazz = Long.TYPE)) {
            return field;
        }
        return null;
    }

    public static /* synthetic */ byte zzg(Object object, long l10) {
        return zziz.zzk(object, l10);
    }

    public static /* synthetic */ byte zzh(Object object, long l10) {
        return zziz.zzl(object, l10);
    }

    public static /* synthetic */ boolean zzi(Object object, long l10) {
        return zziz.zzm(object, l10);
    }

    public static /* synthetic */ boolean zzj(Object object, long l10) {
        return zziz.zzn(object, l10);
    }

    private static byte zzk(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zziz.zza(object, l11);
        int n11 = (int)(((l10 ^ (long)-1) & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static byte zzl(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zziz.zza(object, l11);
        int n11 = (int)((l10 & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static boolean zzm(Object object, long l10) {
        byte by2 = zziz.zzk(object, l10);
        return by2 != 0;
    }

    private static boolean zzn(Object object, long l10) {
        byte by2 = zziz.zzl(object, l10);
        return by2 != 0;
    }
}

