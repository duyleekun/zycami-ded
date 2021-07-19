/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$1;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$2;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray$3;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import sun.misc.Unsafe;

public abstract class LittleEndianByteArray$UnsafeByteArray
extends Enum
implements LittleEndianByteArray$LittleEndianBytes {
    private static final /* synthetic */ LittleEndianByteArray$UnsafeByteArray[] $VALUES;
    private static final int BYTE_ARRAY_BASE_OFFSET;
    public static final /* enum */ LittleEndianByteArray$UnsafeByteArray UNSAFE_BIG_ENDIAN;
    public static final /* enum */ LittleEndianByteArray$UnsafeByteArray UNSAFE_LITTLE_ENDIAN;
    private static final Unsafe theUnsafe;

    static {
        int n10;
        Object object = byte[].class;
        Object object2 = new LittleEndianByteArray$UnsafeByteArray$1();
        UNSAFE_LITTLE_ENDIAN = object2;
        int n11 = 1;
        LittleEndianByteArray$UnsafeByteArray$2 littleEndianByteArray$UnsafeByteArray$2 = new LittleEndianByteArray$UnsafeByteArray$2();
        UNSAFE_BIG_ENDIAN = littleEndianByteArray$UnsafeByteArray$2;
        int n12 = 2;
        LittleEndianByteArray$UnsafeByteArray[] littleEndianByteArray$UnsafeByteArrayArray = new LittleEndianByteArray$UnsafeByteArray[n12];
        littleEndianByteArray$UnsafeByteArrayArray[0] = object2;
        littleEndianByteArray$UnsafeByteArrayArray[n11] = littleEndianByteArray$UnsafeByteArray$2;
        $VALUES = littleEndianByteArray$UnsafeByteArrayArray;
        theUnsafe = object2 = LittleEndianByteArray$UnsafeByteArray.getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = n10 = ((Unsafe)object2).arrayBaseOffset((Class<?>)object);
        int n13 = ((Unsafe)object2).arrayIndexScale((Class<?>)object);
        if (n13 == n11) {
            return;
        }
        object = new AssertionError();
        throw object;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LittleEndianByteArray$UnsafeByteArray() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ LittleEndianByteArray$UnsafeByteArray(LittleEndianByteArray$1 littleEndianByteArray$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static /* synthetic */ int access$100() {
        return BYTE_ARRAY_BASE_OFFSET;
    }

    public static /* synthetic */ Unsafe access$200() {
        return theUnsafe;
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException securityException) {
            LittleEndianByteArray$UnsafeByteArray$3 littleEndianByteArray$UnsafeByteArray$3;
            try {
                littleEndianByteArray$UnsafeByteArray$3 = new LittleEndianByteArray$UnsafeByteArray$3();
                littleEndianByteArray$UnsafeByteArray$3 = AccessController.doPrivileged(littleEndianByteArray$UnsafeByteArray$3);
            }
            catch (PrivilegedActionException privilegedActionException) {
                Throwable throwable = privilegedActionException.getCause();
                RuntimeException runtimeException = new RuntimeException("Could not initialize intrinsics", throwable);
                throw runtimeException;
            }
            return (Unsafe)((Object)littleEndianByteArray$UnsafeByteArray$3);
        }
    }

    public static LittleEndianByteArray$UnsafeByteArray valueOf(String string2) {
        return Enum.valueOf(LittleEndianByteArray$UnsafeByteArray.class, string2);
    }

    public static LittleEndianByteArray$UnsafeByteArray[] values() {
        return (LittleEndianByteArray$UnsafeByteArray[])$VALUES.clone();
    }
}

