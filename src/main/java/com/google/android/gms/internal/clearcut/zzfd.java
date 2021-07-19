/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzaw;
import com.google.android.gms.internal.clearcut.zzfd$zza;
import com.google.android.gms.internal.clearcut.zzfd$zzb;
import com.google.android.gms.internal.clearcut.zzfd$zzc;
import com.google.android.gms.internal.clearcut.zzfd$zzd;
import com.google.android.gms.internal.clearcut.zzfe;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class zzfd {
    private static final Logger logger;
    private static final Class zzfb;
    private static final boolean zzfy;
    private static final Unsafe zzmh;
    private static final boolean zzpg;
    private static final boolean zzph;
    private static final zzfd$zzd zzpi;
    private static final boolean zzpj;
    private static final long zzpk;
    private static final long zzpl;
    private static final long zzpm;
    private static final long zzpn;
    private static final long zzpo;
    private static final long zzpp;
    private static final long zzpq;
    private static final long zzpr;
    private static final long zzps;
    private static final long zzpt;
    private static final long zzpu;
    private static final long zzpv;
    private static final long zzpw;
    private static final long zzpx;
    private static final long zzpy;
    private static final boolean zzpz;

    /*
     * Unable to fully structure code
     */
    static {
        var0 = Object[].class;
        var1_1 = double[].class;
        var2_2 = float[].class;
        var3_3 = long[].class;
        var4_4 = int[].class;
        var5_5 = boolean[].class;
        zzfd.logger = Logger.getLogger(zzfd.class.getName());
        var6_6 = zzfd.zzef();
        zzfd.zzmh = var6_6;
        zzfd.zzfb = zzaw.zzy();
        var7_7 = Long.TYPE;
        zzfd.zzpg = var8_8 = zzfd.zzi(var7_7);
        var9_9 = Integer.TYPE;
        zzfd.zzph = var10_10 = zzfd.zzi(var9_9);
        var11_11 = null;
        if (var6_6 == null) {
            while (true) {
                var8_8 = false;
                var7_7 = null;
                break;
            }
        } else {
            var12_12 = zzaw.zzx();
            if (var12_12) {
                if (var8_8) {
                    var7_7 = new zzfd$zzb((Unsafe)var6_6);
                } else {
                    if (!var10_10) ** continue;
                    var7_7 = new zzfd$zza((Unsafe)var6_6);
                }
            } else {
                var7_7 = new zzfd$zzc((Unsafe)var6_6);
            }
        }
        zzfd.zzpi = var7_7;
        zzfd.zzpj = zzfd.zzeh();
        zzfd.zzfy = zzfd.zzeg();
        var6_6 = byte[].class;
        zzfd.zzpk = zzfd.zzg((Class)var6_6);
        var13_13 = zzfd.zzg(var5_5);
        zzfd.zzpl = var14_14 = (long)var13_13;
        zzfd.zzpm = zzfd.zzh(var5_5);
        var16_15 = zzfd.zzg(var4_4);
        zzfd.zzpn = var17_16 = (long)var16_15;
        zzfd.zzpo = zzfd.zzh(var4_4);
        var19_17 = zzfd.zzg(var3_3);
        zzfd.zzpp = var20_18 = (long)var19_17;
        zzfd.zzpq = zzfd.zzh(var3_3);
        var22_19 = zzfd.zzg(var2_2);
        zzfd.zzpr = var23_20 = (long)var22_19;
        zzfd.zzps = zzfd.zzh(var2_2);
        var25_21 = zzfd.zzg(var1_1);
        zzfd.zzpt = var26_22 = (long)var25_21;
        zzfd.zzpu = zzfd.zzh(var1_1);
        var28_23 = zzfd.zzg(var0);
        zzfd.zzpv = var29_24 = (long)var28_23;
        var31_25 = zzfd.zzh(var0);
        zzfd.zzpw = var31_25;
        zzfd.zzpx = var32_26 = zzfd.zzb(zzfd.zzei());
        var1_1 = "value";
        var0 = zzfd.zzb(String.class, (String)var1_1);
        if (var0 != null && (var1_1 = var0.getType()) == (var2_2 = char[].class)) {
            var11_11 = var0;
        }
        zzfd.zzpy = var32_26 = zzfd.zzb(var11_11);
        var0 = ByteOrder.nativeOrder();
        if (var0 == (var1_1 = ByteOrder.BIG_ENDIAN)) {
            var31_25 = 1;
        } else {
            var31_25 = 0;
            var0 = null;
        }
        zzfd.zzpz = var31_25;
    }

    private zzfd() {
    }

    public static byte zza(byte[] byArray, long l10) {
        zzfd$zzd zzfd$zzd = zzpi;
        long l11 = zzpk + l10;
        return zzfd$zzd.zzx(byArray, l11);
    }

    public static long zza(Field field) {
        return zzpi.zza(field);
    }

    public static void zza(long l10, byte by2) {
        zzpi.zza(l10, by2);
    }

    private static void zza(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zzfd.zzj(object, l11);
        int n11 = (~((int)l10) & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzfd.zza(object, l11, n11);
    }

    public static void zza(Object object, long l10, double d10) {
        zzpi.zza(object, l10, d10);
    }

    public static void zza(Object object, long l10, float f10) {
        zzpi.zza(object, l10, f10);
    }

    public static void zza(Object object, long l10, int n10) {
        zzpi.zza(object, l10, n10);
    }

    public static void zza(Object object, long l10, long l11) {
        zzpi.zza(object, l10, l11);
    }

    public static void zza(Object object, long l10, Object object2) {
        zzfd.zzpi.zzqa.putObject(object, l10, object2);
    }

    public static void zza(Object object, long l10, boolean bl2) {
        zzpi.zza(object, l10, bl2);
    }

    public static void zza(byte[] byArray, long l10, byte by2) {
        zzfd$zzd zzfd$zzd = zzpi;
        long l11 = zzpk + l10;
        zzfd$zzd.zze(byArray, l11, by2);
    }

    public static void zza(byte[] byArray, long l10, long l11, long l12) {
        zzpi.zza(byArray, l10, l11, l12);
    }

    public static /* synthetic */ boolean zzah() {
        return zzpz;
    }

    private static long zzb(Field field) {
        zzfd$zzd zzfd$zzd;
        if (field != null && (zzfd$zzd = zzpi) != null) {
            return zzfd$zzd.zza(field);
        }
        return -1;
    }

    public static long zzb(ByteBuffer byteBuffer) {
        zzfd$zzd zzfd$zzd = zzpi;
        long l10 = zzpx;
        return zzfd$zzd.zzk(byteBuffer, l10);
    }

    private static Field zzb(Class annotatedElement, String string2) {
        annotatedElement = ((Class)annotatedElement).getDeclaredField(string2);
        boolean bl2 = true;
        try {
            ((Field)annotatedElement).setAccessible(bl2);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static void zzb(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = zzfd.zzj(object, l11);
        int n11 = ((int)l10 & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        zzfd.zza(object, l11, n11);
    }

    private static void zzb(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zzfd.zza(object, l10, by2);
    }

    public static /* synthetic */ void zzc(Object object, long l10, byte by2) {
        zzfd.zza(object, l10, by2);
    }

    private static void zzc(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        zzfd.zzb(object, l10, by2);
    }

    public static /* synthetic */ void zzd(Object object, long l10, byte by2) {
        zzfd.zzb(object, l10, by2);
    }

    public static /* synthetic */ void zzd(Object object, long l10, boolean bl2) {
        zzfd.zzb(object, l10, bl2);
    }

    public static /* synthetic */ void zze(Object object, long l10, boolean bl2) {
        zzfd.zzc(object, l10, bl2);
    }

    public static boolean zzed() {
        return zzfy;
    }

    public static boolean zzee() {
        return zzpj;
    }

    public static Unsafe zzef() {
        Object object = new zzfe();
        object = AccessController.doPrivileged(object);
        try {
            object = (Unsafe)object;
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    private static boolean zzeg() {
        Object object;
        boolean bl2;
        Object object2;
        Class<Object> clazz = Object.class;
        Object object3 = zzmh;
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
        boolean bl3 = zzaw.zzx();
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

    private static boolean zzeh() {
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
            object2 = zzmh;
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
            object = zzfd.zzei();
            if (object != null) break block44;
            return false;
        }
        int n12 = zzaw.zzx();
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

    private static Field zzei() {
        Class<Long> clazz;
        Object object;
        Field field;
        boolean bl2 = zzaw.zzx();
        if (bl2 && (field = zzfd.zzb(Buffer.class, (String)(object = "effectiveDirectAddress"))) != null) {
            return field;
        }
        object = "address";
        field = zzfd.zzb(Buffer.class, (String)object);
        if (field != null && (object = field.getType()) == (clazz = Long.TYPE)) {
            return field;
        }
        return null;
    }

    public static /* synthetic */ long zzej() {
        return zzpk;
    }

    private static int zzg(Class clazz) {
        boolean bl2 = zzfy;
        if (bl2) {
            return zzfd.zzpi.zzqa.arrayBaseOffset(clazz);
        }
        return -1;
    }

    private static int zzh(Class clazz) {
        boolean bl2 = zzfy;
        if (bl2) {
            return zzfd.zzpi.zzqa.arrayIndexScale(clazz);
        }
        return -1;
    }

    private static boolean zzi(Class clazz) {
        int n10;
        String string2;
        Class clazz2;
        Class<byte[]> clazz3 = byte[].class;
        boolean bl2 = zzaw.zzx();
        if (!bl2) {
            return false;
        }
        try {
            clazz2 = zzfb;
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

    public static int zzj(Object object, long l10) {
        return zzpi.zzj(object, l10);
    }

    public static long zzk(Object object, long l10) {
        return zzpi.zzk(object, l10);
    }

    public static boolean zzl(Object object, long l10) {
        return zzpi.zzl(object, l10);
    }

    public static float zzm(Object object, long l10) {
        return zzpi.zzm(object, l10);
    }

    public static double zzn(Object object, long l10) {
        return zzpi.zzn(object, l10);
    }

    public static Object zzo(Object object, long l10) {
        return zzfd.zzpi.zzqa.getObject(object, l10);
    }

    private static byte zzp(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zzfd.zzj(object, l11);
        int n11 = (int)(((l10 ^ (long)-1) & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static byte zzq(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = zzfd.zzj(object, l11);
        int n11 = (int)((l10 & (long)3) << 3);
        return (byte)(n10 >>> n11);
    }

    private static boolean zzr(Object object, long l10) {
        byte by2 = zzfd.zzp(object, l10);
        return by2 != 0;
    }

    private static boolean zzs(Object object, long l10) {
        byte by2 = zzfd.zzq(object, l10);
        return by2 != 0;
    }

    public static /* synthetic */ byte zzt(Object object, long l10) {
        return zzfd.zzp(object, l10);
    }

    public static /* synthetic */ byte zzu(Object object, long l10) {
        return zzfd.zzq(object, l10);
    }

    public static /* synthetic */ boolean zzv(Object object, long l10) {
        return zzfd.zzr(object, l10);
    }

    public static /* synthetic */ boolean zzw(Object object, long l10) {
        return zzfd.zzs(object, l10);
    }
}

