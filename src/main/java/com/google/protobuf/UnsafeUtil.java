/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Android;
import com.google.protobuf.UnsafeUtil$1;
import com.google.protobuf.UnsafeUtil$Android32MemoryAccessor;
import com.google.protobuf.UnsafeUtil$Android64MemoryAccessor;
import com.google.protobuf.UnsafeUtil$JvmMemoryAccessor;
import com.google.protobuf.UnsafeUtil$MemoryAccessor;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

public final class UnsafeUtil {
    private static final long BOOLEAN_ARRAY_BASE_OFFSET = 0L;
    private static final long BOOLEAN_ARRAY_INDEX_SCALE = 0L;
    private static final long BUFFER_ADDRESS_OFFSET = 0L;
    private static final int BYTE_ARRAY_ALIGNMENT = 0;
    public static final long BYTE_ARRAY_BASE_OFFSET = 0L;
    private static final long DOUBLE_ARRAY_BASE_OFFSET = 0L;
    private static final long DOUBLE_ARRAY_INDEX_SCALE = 0L;
    private static final long FLOAT_ARRAY_BASE_OFFSET = 0L;
    private static final long FLOAT_ARRAY_INDEX_SCALE = 0L;
    private static final boolean HAS_UNSAFE_ARRAY_OPERATIONS = false;
    private static final boolean HAS_UNSAFE_BYTEBUFFER_OPERATIONS = false;
    private static final long INT_ARRAY_BASE_OFFSET = 0L;
    private static final long INT_ARRAY_INDEX_SCALE = 0L;
    private static final boolean IS_ANDROID_32 = false;
    private static final boolean IS_ANDROID_64 = false;
    public static final boolean IS_BIG_ENDIAN = false;
    private static final long LONG_ARRAY_BASE_OFFSET = 0L;
    private static final long LONG_ARRAY_INDEX_SCALE = 0L;
    private static final UnsafeUtil$MemoryAccessor MEMORY_ACCESSOR;
    private static final Class MEMORY_CLASS;
    private static final long OBJECT_ARRAY_BASE_OFFSET = 0L;
    private static final long OBJECT_ARRAY_INDEX_SCALE = 0L;
    private static final int STRIDE = 8;
    private static final int STRIDE_ALIGNMENT_MASK = 7;
    private static final Unsafe UNSAFE;
    private static final Logger logger;

    static {
        int n10;
        long l10;
        long l11;
        long l12;
        long l13;
        long l14;
        long l15;
        Object object = Object[].class;
        Object object2 = double[].class;
        Class<float[]> clazz = float[].class;
        Class<long[]> clazz2 = long[].class;
        Class<int[]> clazz3 = int[].class;
        Class<boolean[]> clazz4 = boolean[].class;
        logger = Logger.getLogger(UnsafeUtil.class.getName());
        UNSAFE = UnsafeUtil.getUnsafe();
        MEMORY_CLASS = Android.getMemoryClass();
        IS_ANDROID_64 = UnsafeUtil.determineAndroidSupportByAddressSize(Long.TYPE);
        IS_ANDROID_32 = UnsafeUtil.determineAndroidSupportByAddressSize(Integer.TYPE);
        MEMORY_ACCESSOR = UnsafeUtil.getMemoryAccessor();
        HAS_UNSAFE_BYTEBUFFER_OPERATIONS = UnsafeUtil.supportsUnsafeByteBufferOperations();
        HAS_UNSAFE_ARRAY_OPERATIONS = UnsafeUtil.supportsUnsafeArrayOperations();
        Class<byte[]> clazz5 = byte[].class;
        int n11 = UnsafeUtil.arrayBaseOffset(clazz5);
        BYTE_ARRAY_BASE_OFFSET = l15 = (long)n11;
        int n12 = UnsafeUtil.arrayBaseOffset(clazz4);
        BOOLEAN_ARRAY_BASE_OFFSET = n12;
        BOOLEAN_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(clazz4);
        int n13 = UnsafeUtil.arrayBaseOffset(clazz3);
        INT_ARRAY_BASE_OFFSET = l14 = (long)n13;
        INT_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(clazz3);
        int n14 = UnsafeUtil.arrayBaseOffset(clazz2);
        LONG_ARRAY_BASE_OFFSET = l13 = (long)n14;
        LONG_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(clazz2);
        int n15 = UnsafeUtil.arrayBaseOffset(clazz);
        FLOAT_ARRAY_BASE_OFFSET = l12 = (long)n15;
        FLOAT_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(clazz);
        int n16 = UnsafeUtil.arrayBaseOffset(object2);
        DOUBLE_ARRAY_BASE_OFFSET = l11 = (long)n16;
        DOUBLE_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(object2);
        int n17 = UnsafeUtil.arrayBaseOffset(object);
        OBJECT_ARRAY_BASE_OFFSET = l10 = (long)n17;
        OBJECT_ARRAY_INDEX_SCALE = UnsafeUtil.arrayIndexScale(object);
        BUFFER_ADDRESS_OFFSET = UnsafeUtil.fieldOffset(UnsafeUtil.bufferAddressField());
        long l16 = (long)7 & l15;
        BYTE_ARRAY_ALIGNMENT = n10 = (int)l16;
        object = ByteOrder.nativeOrder();
        if (object == (object2 = ByteOrder.BIG_ENDIAN)) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        IS_BIG_ENDIAN = n10;
    }

    private UnsafeUtil() {
    }

    public static /* synthetic */ byte access$000(Object object, long l10) {
        return UnsafeUtil.getByteBigEndian(object, l10);
    }

    public static /* synthetic */ byte access$100(Object object, long l10) {
        return UnsafeUtil.getByteLittleEndian(object, l10);
    }

    public static /* synthetic */ void access$200(Object object, long l10, byte by2) {
        UnsafeUtil.putByteBigEndian(object, l10, by2);
    }

    public static /* synthetic */ void access$300(Object object, long l10, byte by2) {
        UnsafeUtil.putByteLittleEndian(object, l10, by2);
    }

    public static /* synthetic */ boolean access$400(Object object, long l10) {
        return UnsafeUtil.getBooleanBigEndian(object, l10);
    }

    public static /* synthetic */ boolean access$500(Object object, long l10) {
        return UnsafeUtil.getBooleanLittleEndian(object, l10);
    }

    public static /* synthetic */ void access$600(Object object, long l10, boolean bl2) {
        UnsafeUtil.putBooleanBigEndian(object, l10, bl2);
    }

    public static /* synthetic */ void access$700(Object object, long l10, boolean bl2) {
        UnsafeUtil.putBooleanLittleEndian(object, l10, bl2);
    }

    public static long addressOffset(ByteBuffer byteBuffer) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l10 = BUFFER_ADDRESS_OFFSET;
        return unsafeUtil$MemoryAccessor.getLong(byteBuffer, l10);
    }

    public static Object allocateInstance(Class clazz) {
        Object object;
        try {
            object = UNSAFE;
        }
        catch (InstantiationException instantiationException) {
            object = new IllegalStateException(instantiationException);
            throw object;
        }
        return ((Unsafe)object).allocateInstance(clazz);
    }

    private static int arrayBaseOffset(Class clazz) {
        int n10;
        boolean bl2 = HAS_UNSAFE_ARRAY_OPERATIONS;
        if (bl2) {
            UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
            n10 = unsafeUtil$MemoryAccessor.arrayBaseOffset(clazz);
        } else {
            n10 = -1;
        }
        return n10;
    }

    private static int arrayIndexScale(Class clazz) {
        int n10;
        boolean bl2 = HAS_UNSAFE_ARRAY_OPERATIONS;
        if (bl2) {
            UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
            n10 = unsafeUtil$MemoryAccessor.arrayIndexScale(clazz);
        } else {
            n10 = -1;
        }
        return n10;
    }

    private static Field bufferAddressField() {
        Class<Long> clazz;
        Object object;
        Field field;
        boolean bl2 = Android.isOnAndroidDevice();
        if (bl2 && (field = UnsafeUtil.field(Buffer.class, (String)(object = "effectiveDirectAddress"))) != null) {
            return field;
        }
        object = "address";
        field = UnsafeUtil.field(Buffer.class, (String)object);
        if (field == null || (object = field.getType()) != (clazz = Long.TYPE)) {
            bl2 = false;
            field = null;
        }
        return field;
    }

    public static void copyMemory(long l10, byte[] byArray, long l11, long l12) {
        MEMORY_ACCESSOR.copyMemory(l10, byArray, l11, l12);
    }

    public static void copyMemory(byte[] byArray, long l10, long l11, long l12) {
        MEMORY_ACCESSOR.copyMemory(byArray, l10, l11, l12);
    }

    public static void copyMemory(byte[] byArray, long l10, byte[] byArray2, long l11, long l12) {
        int n10 = (int)l10;
        int n11 = (int)l11;
        int n12 = (int)l12;
        System.arraycopy(byArray, n10, byArray2, n11, n12);
    }

    private static boolean determineAndroidSupportByAddressSize(Class clazz) {
        int n10;
        String string2;
        Class clazz2;
        Class<byte[]> clazz3 = byte[].class;
        boolean bl2 = Android.isOnAndroidDevice();
        if (!bl2) {
            return false;
        }
        try {
            clazz2 = MEMORY_CLASS;
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

    private static Field field(Class annotatedElement, String string2) {
        try {
            annotatedElement = annotatedElement.getDeclaredField(string2);
        }
        catch (Throwable throwable) {
            annotatedElement = null;
        }
        return annotatedElement;
    }

    private static long fieldOffset(Field field) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor;
        long l10 = field != null && (unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR) != null ? unsafeUtil$MemoryAccessor.objectFieldOffset(field) : (long)-1;
        return l10;
    }

    private static int firstDifferingByteIndexNativeEndian(long l10, long l11) {
        boolean bl2 = IS_BIG_ENDIAN;
        int n10 = bl2 ? Long.numberOfLeadingZeros(l10 ^= l11) : Long.numberOfTrailingZeros(l10 ^= l11);
        return n10 >> 3;
    }

    public static boolean getBoolean(Object object, long l10) {
        return MEMORY_ACCESSOR.getBoolean(object, l10);
    }

    public static boolean getBoolean(boolean[] blArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = BOOLEAN_ARRAY_BASE_OFFSET;
        long l12 = BOOLEAN_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getBoolean(blArray, l11 += (l10 *= l12));
    }

    private static boolean getBooleanBigEndian(Object object, long l10) {
        byte by2 = UnsafeUtil.getByteBigEndian(object, l10);
        if (by2) {
            by2 = 1;
        } else {
            by2 = 0;
            object = null;
        }
        return by2 != 0;
    }

    private static boolean getBooleanLittleEndian(Object object, long l10) {
        byte by2 = UnsafeUtil.getByteLittleEndian(object, l10);
        if (by2) {
            by2 = 1;
        } else {
            by2 = 0;
            object = null;
        }
        return by2 != 0;
    }

    public static byte getByte(long l10) {
        return MEMORY_ACCESSOR.getByte(l10);
    }

    public static byte getByte(Object object, long l10) {
        return MEMORY_ACCESSOR.getByte(object, l10);
    }

    public static byte getByte(byte[] byArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = BYTE_ARRAY_BASE_OFFSET + l10;
        return unsafeUtil$MemoryAccessor.getByte(byArray, l11);
    }

    private static byte getByteBigEndian(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = UnsafeUtil.getInt(object, l11);
        int n11 = (int)(((l10 ^ (long)-1) & (long)3) << 3);
        return (byte)(n10 >>> n11 & 0xFF);
    }

    private static byte getByteLittleEndian(Object object, long l10) {
        long l11 = (long)-4 & l10;
        int n10 = UnsafeUtil.getInt(object, l11);
        int n11 = (int)((l10 & (long)3) << 3);
        return (byte)(n10 >>> n11 & 0xFF);
    }

    public static double getDouble(Object object, long l10) {
        return MEMORY_ACCESSOR.getDouble(object, l10);
    }

    public static double getDouble(double[] dArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = DOUBLE_ARRAY_BASE_OFFSET;
        long l12 = DOUBLE_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getDouble(dArray, l11 += (l10 *= l12));
    }

    public static float getFloat(Object object, long l10) {
        return MEMORY_ACCESSOR.getFloat(object, l10);
    }

    public static float getFloat(float[] fArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = FLOAT_ARRAY_BASE_OFFSET;
        long l12 = FLOAT_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getFloat(fArray, l11 += (l10 *= l12));
    }

    public static int getInt(long l10) {
        return MEMORY_ACCESSOR.getInt(l10);
    }

    public static int getInt(Object object, long l10) {
        return MEMORY_ACCESSOR.getInt(object, l10);
    }

    public static int getInt(int[] nArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = INT_ARRAY_BASE_OFFSET;
        long l12 = INT_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getInt(nArray, l11 += (l10 *= l12));
    }

    public static long getLong(long l10) {
        return MEMORY_ACCESSOR.getLong(l10);
    }

    public static long getLong(Object object, long l10) {
        return MEMORY_ACCESSOR.getLong(object, l10);
    }

    public static long getLong(long[] lArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = LONG_ARRAY_BASE_OFFSET;
        long l12 = LONG_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getLong(lArray, l11 += (l10 *= l12));
    }

    private static UnsafeUtil$MemoryAccessor getMemoryAccessor() {
        Unsafe unsafe = UNSAFE;
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = null;
        if (unsafe == null) {
            return null;
        }
        boolean bl2 = Android.isOnAndroidDevice();
        if (bl2) {
            bl2 = IS_ANDROID_64;
            if (bl2) {
                unsafeUtil$MemoryAccessor = new UnsafeUtil$Android64MemoryAccessor(unsafe);
                return unsafeUtil$MemoryAccessor;
            }
            bl2 = IS_ANDROID_32;
            if (bl2) {
                unsafeUtil$MemoryAccessor = new UnsafeUtil$Android32MemoryAccessor(unsafe);
            }
            return unsafeUtil$MemoryAccessor;
        }
        unsafeUtil$MemoryAccessor = new UnsafeUtil$JvmMemoryAccessor(unsafe);
        return unsafeUtil$MemoryAccessor;
    }

    public static Object getObject(Object object, long l10) {
        return MEMORY_ACCESSOR.getObject(object, l10);
    }

    public static Object getObject(Object[] objectArray, long l10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = OBJECT_ARRAY_BASE_OFFSET;
        long l12 = OBJECT_ARRAY_INDEX_SCALE;
        return unsafeUtil$MemoryAccessor.getObject(objectArray, l11 += (l10 *= l12));
    }

    public static Object getStaticObject(Field field) {
        return MEMORY_ACCESSOR.getStaticObject(field);
    }

    public static Unsafe getUnsafe() {
        Object object = new UnsafeUtil$1();
        object = AccessController.doPrivileged(object);
        try {
            object = (Unsafe)object;
        }
        catch (Throwable throwable) {
            object = null;
        }
        return object;
    }

    public static boolean hasUnsafeArrayOperations() {
        return HAS_UNSAFE_ARRAY_OPERATIONS;
    }

    public static boolean hasUnsafeByteBufferOperations() {
        return HAS_UNSAFE_BYTEBUFFER_OPERATIONS;
    }

    public static boolean isAndroid64() {
        return IS_ANDROID_64;
    }

    public static int mismatch(byte[] object, int n10, byte[] byArray, int n11, int n12) {
        int n13;
        int n14;
        if (n10 >= 0 && n11 >= 0 && n12 >= 0 && (n14 = n10 + n12) <= (n13 = ((byte[])object).length) && (n14 = n11 + n12) <= (n13 = byArray.length)) {
            int n15;
            n14 = 0;
            n13 = (int)(HAS_UNSAFE_ARRAY_OPERATIONS ? 1 : 0);
            if (n13 != 0) {
                n13 = BYTE_ARRAY_ALIGNMENT + n10 & 7;
                while (n14 < n12 && (n15 = n13 & 7) != 0) {
                    n15 = n10 + n14;
                    n15 = object[n15];
                    int n16 = n11 + n14;
                    if (n15 != (n16 = byArray[n16])) {
                        return n14;
                    }
                    ++n14;
                    ++n13;
                }
                n13 = (n12 - n14 & 0xFFFFFFF8) + n14;
                while (n14 < n13) {
                    long l10 = BYTE_ARRAY_BASE_OFFSET;
                    long l11 = (long)n10 + l10;
                    long l12 = n14;
                    l11 += l12;
                    l11 = UnsafeUtil.getLong(object, l11);
                    long l13 = n11;
                    l10 = l10 + l13 + l12;
                    long l14 = l11 - (l10 = UnsafeUtil.getLong((Object)byArray, l10));
                    Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                    if (object2 != false) {
                        int n17 = UnsafeUtil.firstDifferingByteIndexNativeEndian(l11, l10);
                        return n14 + n17;
                    }
                    n14 += 8;
                }
            }
            while (n14 < n12) {
                n13 = n10 + n14;
                n13 = object[n13];
                n15 = n11 + n14;
                if (n13 != (n15 = byArray[n15])) {
                    return n14;
                }
                ++n14;
            }
            return -1;
        }
        object = new IndexOutOfBoundsException;
        object();
        throw object;
    }

    public static long objectFieldOffset(Field field) {
        return MEMORY_ACCESSOR.objectFieldOffset(field);
    }

    public static void putBoolean(Object object, long l10, boolean bl2) {
        MEMORY_ACCESSOR.putBoolean(object, l10, bl2);
    }

    public static void putBoolean(boolean[] blArray, long l10, boolean bl2) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = BOOLEAN_ARRAY_BASE_OFFSET;
        long l12 = BOOLEAN_ARRAY_INDEX_SCALE;
        unsafeUtil$MemoryAccessor.putBoolean(blArray, l11 += (l10 *= l12), bl2);
    }

    private static void putBooleanBigEndian(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        UnsafeUtil.putByteBigEndian(object, l10, by2);
    }

    private static void putBooleanLittleEndian(Object object, long l10, boolean bl2) {
        byte by2 = (byte)(bl2 ? 1 : 0);
        UnsafeUtil.putByteLittleEndian(object, l10, by2);
    }

    public static void putByte(long l10, byte by2) {
        MEMORY_ACCESSOR.putByte(l10, by2);
    }

    public static void putByte(Object object, long l10, byte by2) {
        MEMORY_ACCESSOR.putByte(object, l10, by2);
    }

    public static void putByte(byte[] byArray, long l10, byte by2) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = BYTE_ARRAY_BASE_OFFSET + l10;
        unsafeUtil$MemoryAccessor.putByte(byArray, l11, by2);
    }

    private static void putByteBigEndian(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = UnsafeUtil.getInt(object, l11);
        int n11 = (~((int)l10) & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        UnsafeUtil.putInt(object, l11, n11);
    }

    private static void putByteLittleEndian(Object object, long l10, byte by2) {
        long l11 = (long)-4 & l10;
        int n10 = UnsafeUtil.getInt(object, l11);
        int n11 = ((int)l10 & 3) << 3;
        int n12 = 255;
        int n13 = ~(n12 << n11);
        n11 = (n12 & by2) << n11 | (n10 &= n13);
        UnsafeUtil.putInt(object, l11, n11);
    }

    public static void putDouble(Object object, long l10, double d10) {
        MEMORY_ACCESSOR.putDouble(object, l10, d10);
    }

    public static void putDouble(double[] dArray, long l10, double d10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = DOUBLE_ARRAY_BASE_OFFSET;
        long l12 = DOUBLE_ARRAY_INDEX_SCALE;
        long l13 = l11 + (l10 *= l12);
        unsafeUtil$MemoryAccessor.putDouble(dArray, l13, d10);
    }

    public static void putFloat(Object object, long l10, float f10) {
        MEMORY_ACCESSOR.putFloat(object, l10, f10);
    }

    public static void putFloat(float[] fArray, long l10, float f10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = FLOAT_ARRAY_BASE_OFFSET;
        long l12 = FLOAT_ARRAY_INDEX_SCALE;
        unsafeUtil$MemoryAccessor.putFloat(fArray, l11 += (l10 *= l12), f10);
    }

    public static void putInt(long l10, int n10) {
        MEMORY_ACCESSOR.putInt(l10, n10);
    }

    public static void putInt(Object object, long l10, int n10) {
        MEMORY_ACCESSOR.putInt(object, l10, n10);
    }

    public static void putInt(int[] nArray, long l10, int n10) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = INT_ARRAY_BASE_OFFSET;
        long l12 = INT_ARRAY_INDEX_SCALE;
        unsafeUtil$MemoryAccessor.putInt(nArray, l11 += (l10 *= l12), n10);
    }

    public static void putLong(long l10, long l11) {
        MEMORY_ACCESSOR.putLong(l10, l11);
    }

    public static void putLong(Object object, long l10, long l11) {
        MEMORY_ACCESSOR.putLong(object, l10, l11);
    }

    public static void putLong(long[] lArray, long l10, long l11) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l12 = LONG_ARRAY_BASE_OFFSET;
        long l13 = LONG_ARRAY_INDEX_SCALE;
        long l14 = l12 + (l10 *= l13);
        unsafeUtil$MemoryAccessor.putLong(lArray, l14, l11);
    }

    public static void putObject(Object object, long l10, Object object2) {
        MEMORY_ACCESSOR.putObject(object, l10, object2);
    }

    public static void putObject(Object[] objectArray, long l10, Object object) {
        UnsafeUtil$MemoryAccessor unsafeUtil$MemoryAccessor = MEMORY_ACCESSOR;
        long l11 = OBJECT_ARRAY_BASE_OFFSET;
        long l12 = OBJECT_ARRAY_INDEX_SCALE;
        unsafeUtil$MemoryAccessor.putObject(objectArray, l11 += (l10 *= l12), object);
    }

    private static boolean supportsUnsafeArrayOperations() {
        boolean bl2;
        Object object;
        Class<Object> clazz = Object.class;
        Object object2 = UNSAFE;
        if (object2 == null) {
            return false;
        }
        try {
            object2 = object2.getClass();
            object = "objectFieldOffset";
            bl2 = true;
        }
        catch (Throwable throwable) {
            object2 = logger;
            object = Level.WARNING;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("platform method missing - proto runtime falling back to safer methods: ");
            stringBuilder.append(throwable);
            String string2 = stringBuilder.toString();
            ((Logger)object2).log((Level)object, string2);
            return false;
        }
        Class[] classArray = new Class[bl2];
        Class[] classArray2 = Field.class;
        classArray[0] = classArray2;
        ((Class)object2).getMethod((String)object, classArray);
        object = "arrayBaseOffset";
        classArray = new Class[bl2];
        classArray2 = Class.class;
        classArray[0] = classArray2;
        ((Class)object2).getMethod((String)object, classArray);
        object = "arrayIndexScale";
        classArray = new Class[bl2];
        classArray2 = Class.class;
        classArray[0] = classArray2;
        ((Class)object2).getMethod((String)object, classArray);
        object = "getInt";
        int n10 = 2;
        classArray2 = new Class[n10];
        classArray2[0] = clazz;
        Class<Long> clazz2 = Long.TYPE;
        classArray2[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray2);
        object = "putInt";
        int n11 = 3;
        Class[] classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        Class<Constable> clazz3 = Integer.TYPE;
        classArray3[n10] = clazz3;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "getLong";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putLong";
        classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        classArray3[n10] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "getObject";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putObject";
        classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        classArray3[n10] = clazz;
        ((Class)object2).getMethod((String)object, classArray3);
        boolean bl3 = Android.isOnAndroidDevice();
        if (bl3) {
            return bl2;
        }
        object = "getByte";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putByte";
        classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        clazz3 = Byte.TYPE;
        classArray3[n10] = clazz3;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "getBoolean";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putBoolean";
        classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        clazz3 = Boolean.TYPE;
        classArray3[n10] = clazz3;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "getFloat";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putFloat";
        classArray3 = new Class[n11];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        clazz3 = Float.TYPE;
        classArray3[n10] = clazz3;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "getDouble";
        classArray3 = new Class[n10];
        classArray3[0] = clazz;
        classArray3[bl2] = clazz2;
        ((Class)object2).getMethod((String)object, classArray3);
        object = "putDouble";
        classArray2 = new Class[n11];
        classArray2[0] = clazz;
        classArray2[bl2] = clazz2;
        clazz = Double.TYPE;
        classArray2[n10] = clazz;
        ((Class)object2).getMethod((String)object, classArray2);
        return bl2;
    }

    private static boolean supportsUnsafeByteBufferOperations() {
        int n10;
        Class clazz;
        Object object;
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        String string2;
        block44: {
            String string3;
            string2 = "copyMemory";
            object4 = "getLong";
            object3 = Object.class;
            object2 = UNSAFE;
            if (object2 == null) {
                return false;
            }
            try {
                object2 = object2.getClass();
                string3 = "objectFieldOffset";
                bl2 = true;
            }
            catch (Throwable throwable) {
                object4 = logger;
                object3 = Level.WARNING;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("platform method missing - proto runtime falling back to safer methods: ");
                ((StringBuilder)object2).append(throwable);
                String string4 = ((StringBuilder)object2).toString();
                ((Logger)object4).log((Level)object3, string4);
                return false;
            }
            object = new Class[bl2];
            clazz = Field.class;
            object[0] = clazz;
            ((Class)object2).getMethod(string3, (Class<?>)object);
            n10 = 2;
            object = new Class[n10];
            object[0] = object3;
            clazz = Long.TYPE;
            object[bl2] = clazz;
            ((Class)object2).getMethod((String)object4, (Class<?>)object);
            object = UnsafeUtil.bufferAddressField();
            if (object != null) break block44;
            return false;
        }
        int n11 = Android.isOnAndroidDevice();
        if (n11 != 0) {
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
        int n12 = 3;
        object = new Class[n12];
        object[0] = clazz;
        object[bl2] = clazz;
        object[n10] = clazz;
        ((Class)object2).getMethod(string2, (Class<?>)object);
        n11 = 5;
        object = new Class[n11];
        object[0] = object3;
        object[bl2] = clazz;
        object[n10] = object3;
        object[n12] = clazz;
        n12 = 4;
        object[n12] = clazz;
        ((Class)object2).getMethod(string2, (Class<?>)object);
        return bl2;
    }
}

