/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgl;
import com.google.android.gms.internal.vision.zzlc;
import com.google.android.gms.internal.vision.zzld$zza;
import com.google.android.gms.internal.vision.zzld$zzb;
import com.google.android.gms.internal.vision.zzld$zzc;
import com.google.android.gms.internal.vision.zzld$zzd;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zzld {
    private static final Logger logger;
    private static final Unsafe zzaaj;
    private static final boolean zzacj;
    private static final boolean zzack;
    private static final zzld$zzc zzacl;
    private static final boolean zzacm;
    private static final long zzacn;
    private static final long zzaco;
    private static final long zzacp;
    private static final long zzacq;
    private static final long zzacr;
    private static final long zzacs;
    private static final long zzact;
    private static final long zzacu;
    private static final long zzacv;
    private static final long zzacw;
    private static final long zzacx;
    private static final long zzacy;
    private static final long zzacz;
    private static final long zzada;
    private static final int zzadb;
    public static final boolean zzadc;
    private static final Class zzti;
    private static final boolean zzun;

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
        logger = Logger.getLogger(zzld.class.getName());
        Object object3 = zzld.zzjg();
        zzaaj = object3;
        zzti = zzgl.zzem();
        Class<Long> clazz5 = Long.TYPE;
        zzacj = bl2 = zzld.zzk(clazz5);
        Class<Integer> clazz6 = Integer.TYPE;
        zzack = n10 = zzld.zzk(clazz6);
        zzld$zzc zzld$zzc = null;
        if (object3 != null) {
            boolean bl3 = zzgl.zzel();
            if (bl3) {
                if (bl2) {
                    zzld$zzc = new zzld$zza((Unsafe)object3);
                } else if (n10 != 0) {
                    zzld$zzc = new zzld$zzb((Unsafe)object3);
                }
            } else {
                zzld$zzc = new zzld$zzd((Unsafe)object3);
            }
        }
        zzacl = zzld$zzc;
        zzacm = zzld.zzji();
        zzun = zzld.zzjh();
        object3 = byte[].class;
        int n11 = zzld.zzi((Class)object3);
        zzacn = l16 = (long)n11;
        n10 = zzld.zzi(clazz4);
        zzaco = n10;
        zzacp = zzld.zzj(clazz4);
        int n12 = zzld.zzi(clazz3);
        zzacq = l15 = (long)n12;
        zzacr = zzld.zzj(clazz3);
        int n13 = zzld.zzi(clazz2);
        zzacs = l14 = (long)n13;
        zzact = zzld.zzj(clazz2);
        int n14 = zzld.zzi(clazz);
        zzacu = l13 = (long)n14;
        zzacv = zzld.zzj(clazz);
        int n15 = zzld.zzi(object2);
        zzacw = l12 = (long)n15;
        zzacx = zzld.zzj(object2);
        int n16 = zzld.zzi(object);
        zzacy = l11 = (long)n16;
        int n17 = zzld.zzj(object);
        zzacz = l10 = (long)n17;
        object = zzld.zzjj();
        if (object != null && zzld$zzc != null) {
            object2 = zzld$zzc.zzadd;
            l10 = ((Unsafe)object2).objectFieldOffset((Field)object);
        } else {
            l10 = -1;
        }
        zzada = l10;
        l10 = (long)7 & l16;
        zzadb = n17 = (int)l10;
        object = ByteOrder.nativeOrder();
        object2 = ByteOrder.BIG_ENDIAN;
        if (object == object2) {
            n17 = 1;
        } else {
            n17 = 0;
            object = null;
        }
        zzadc = n17;
    }

    private zzld() {
    }

    public static byte zza(byte[] byArray, long l10) {
        zzld$zzc zzld$zzc = zzacl;
        long l11 = zzacn + l10;
        return zzld$zzc.zzy(byArray, l11);
    }

    private static void zza(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zzld.zzk(object, l11);
        int n11 = (~((int)l10) & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzld.zzb(object, l11, n11);
    }

    public static void zza(Object object, long l10, double d10) {
        zzacl.zza(object, l10, d10);
    }

    public static void zza(Object object, long l10, float f10) {
        zzacl.zza(object, l10, f10);
    }

    public static void zza(Object object, long l10, long l11) {
        zzacl.zza(object, l10, l11);
    }

    public static void zza(Object object, long l10, Object object2) {
        zzld.zzacl.zzadd.putObject(object, l10, object2);
    }

    public static void zza(Object object, long l10, boolean bl2) {
        zzacl.zza(object, l10, bl2);
    }

    public static void zza(byte[] byArray, long l10, byte by2) {
        zzld$zzc zzld$zzc = zzacl;
        long l11 = zzacn + l10;
        zzld$zzc.zze(byArray, l11, by2);
    }

    private static Field zzb(Class annotatedElement, String string2) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string2);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static void zzb(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zzld.zzk(object, l11);
        int n11 = ((int)l10 & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzld.zzb(object, l11, n11);
    }

    public static void zzb(Object object, long l10, int n10) {
        zzacl.zzb(object, l10, n10);
    }

    private static void zzb(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zzld.zza(object, l10, by2);
    }

    public static /* synthetic */ void zzc(Object object, long l10, byte by2) {
        zzld.zza(object, l10, by2);
    }

    private static void zzc(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zzld.zzb(object, l10, by2);
    }

    public static /* synthetic */ void zzd(Object object, long l10, byte by2) {
        zzld.zzb(object, l10, by2);
    }

    public static /* synthetic */ void zzd(Object object, long l10, boolean bl2) {
        zzld.zzb(object, l10, bl2);
    }

    public static /* synthetic */ void zze(Object object, long l10, boolean bl2) {
        zzld.zzc(object, l10, bl2);
    }

    public static Object zzh(Class clazz) {
        Object object;
        try {
            object = zzaaj;
        }
        catch (InstantiationException instantiationException) {
            object = new IllegalStateException(instantiationException);
            throw object;
        }
        return ((Unsafe)object).allocateInstance(clazz);
    }

    private static int zzi(Class clazz) {
        boolean bl2 = zzun;
        if (bl2) {
            return zzld.zzacl.zzadd.arrayBaseOffset(clazz);
        }
        return -1;
    }

    private static int zzj(Class clazz) {
        boolean bl2 = zzun;
        if (bl2) {
            return zzld.zzacl.zzadd.arrayIndexScale(clazz);
        }
        return -1;
    }

    public static boolean zzje() {
        return zzun;
    }

    public static boolean zzjf() {
        return zzacm;
    }

    public static Unsafe zzjg() {
        Object object = new zzlc();
        object = AccessController.doPrivileged(object);
        try {
            object = (Unsafe)object;
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    private static boolean zzjh() {
        Object object;
        boolean bl2;
        Object object2;
        Class<Object> clazz = Object.class;
        Object object3 = zzaaj;
        if (object3 == null) {
            return false;
        }
        try {
            object3 = object3.getClass();
            object2 = "objectFieldOffset";
            bl2 = true;
        }
        catch (Throwable throwable) {
            object3 = logger;
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
        boolean bl3 = zzgl.zzel();
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

    private static boolean zzji() {
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
            object2 = zzaaj;
            if (object2 == null) {
                return false;
            }
            try {
                object2 = object2.getClass();
                charSequence = "objectFieldOffset";
                bl2 = true;
            }
            catch (Throwable throwable) {
                object4 = logger;
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
            object = zzld.zzjj();
            if (object != null) break block44;
            return false;
        }
        int n12 = zzgl.zzel();
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

    private static Field zzjj() {
        Class<Long> clazz;
        Object object;
        Field field;
        boolean bl2 = zzgl.zzel();
        if (bl2 && (field = zzld.zzb(Buffer.class, (String)(object = "effectiveDirectAddress"))) != null) {
            return field;
        }
        object = "address";
        field = zzld.zzb(Buffer.class, (String)object);
        if (field != null && (object = field.getType()) == (clazz = Long.TYPE)) {
            return field;
        }
        return null;
    }

    public static int zzk(Object object, long l10) {
        return zzacl.zzk(object, l10);
    }

    private static boolean zzk(Class clazz) {
        int n10;
        String string2;
        Class clazz2;
        Class<byte[]> clazz3 = byte[].class;
        boolean bl2 = zzgl.zzel();
        if (!bl2) {
            return false;
        }
        try {
            clazz2 = zzti;
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

    public static long zzl(Object object, long l10) {
        return zzacl.zzl(object, l10);
    }

    public static boolean zzm(Object object, long l10) {
        return zzacl.zzm(object, l10);
    }

    public static float zzn(Object object, long l10) {
        return zzacl.zzn(object, l10);
    }

    public static double zzo(Object object, long l10) {
        return zzacl.zzo(object, l10);
    }

    public static Object zzp(Object object, long l10) {
        return zzld.zzacl.zzadd.getObject(object, l10);
    }

    private static byte zzq(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zzld.zzk(object, l11);
        int n11 = (int)(((l10 ^ (long)-1) & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static byte zzr(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zzld.zzk(object, l11);
        int n11 = (int)((l10 & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static boolean zzs(Object object, long l10) {
        byte by2 = zzld.zzq(object, l10);
        return by2 != 0;
    }

    private static boolean zzt(Object object, long l10) {
        byte by2 = zzld.zzr(object, l10);
        return by2 != 0;
    }

    public static /* synthetic */ byte zzu(Object object, long l10) {
        return zzld.zzq(object, l10);
    }

    public static /* synthetic */ byte zzv(Object object, long l10) {
        return zzld.zzr(object, l10);
    }

    public static /* synthetic */ boolean zzw(Object object, long l10) {
        return zzld.zzs(object, l10);
    }

    public static /* synthetic */ boolean zzx(Object object, long l10) {
        return zzld.zzt(object, l10);
    }
}

