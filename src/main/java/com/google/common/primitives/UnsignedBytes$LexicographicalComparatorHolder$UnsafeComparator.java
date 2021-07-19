/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.UnsignedBytes;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1;
import com.google.common.primitives.UnsignedLongs;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.Comparator;
import sun.misc.Unsafe;

public final class UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator
extends Enum
implements Comparator {
    private static final /* synthetic */ UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] $VALUES;
    public static final boolean BIG_ENDIAN;
    public static final int BYTE_ARRAY_BASE_OFFSET;
    public static final /* enum */ UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator INSTANCE;
    public static final Unsafe theUnsafe;

    static {
        int n10;
        int n11;
        boolean bl2;
        Object object = byte[].class;
        String string2 = "INSTANCE";
        Object object2 = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator(string2, 0);
        INSTANCE = object2;
        int n12 = 1;
        Object object3 = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[n12];
        object3[0] = object2;
        $VALUES = object3;
        object2 = ByteOrder.nativeOrder();
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        BIG_ENDIAN = bl2 = object2.equals(byteOrder);
        theUnsafe = object2 = UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.getUnsafe();
        BYTE_ARRAY_BASE_OFFSET = n11 = ((Unsafe)object2).arrayBaseOffset((Class<?>)object);
        String string3 = "64";
        object3 = System.getProperty("sun.arch.data.model");
        boolean bl3 = string3.equals(object3);
        if (bl3 && (n11 %= 8) == 0 && (n10 = ((Unsafe)object2).arrayIndexScale((Class<?>)object)) == n12) {
            return;
        }
        object = new Error();
        throw object;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator() {
        void var2_-1;
        void var1_-1;
    }

    private static Unsafe getUnsafe() {
        try {
            return Unsafe.getUnsafe();
        }
        catch (SecurityException securityException) {
            UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1;
            try {
                unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 = new UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1();
                unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1 = AccessController.doPrivileged(unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1);
            }
            catch (PrivilegedActionException privilegedActionException) {
                Throwable throwable = privilegedActionException.getCause();
                RuntimeException runtimeException = new RuntimeException("Could not initialize intrinsics", throwable);
                throw runtimeException;
            }
            return (Unsafe)((Object)unsignedBytes$LexicographicalComparatorHolder$UnsafeComparator$1);
        }
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator valueOf(String string2) {
        return Enum.valueOf(UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator.class, string2);
    }

    public static UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[] values() {
        return (UnsignedBytes$LexicographicalComparatorHolder$UnsafeComparator[])$VALUES.clone();
    }

    public int compare(byte[] byArray, byte[] byArray2) {
        int n10;
        int n11 = byArray.length;
        int n12 = byArray2.length;
        n11 = Math.min(n11, n12);
        n12 = n11 & 0xFFFFFFF8;
        for (n10 = 0; n10 < n12; n10 += 8) {
            long l10;
            long l11;
            Unsafe unsafe = theUnsafe;
            int n13 = BYTE_ARRAY_BASE_OFFSET;
            long l12 = n13;
            long l13 = n10;
            l12 += l13;
            long l14 = (l12 = unsafe.getLong(byArray, l12)) - (l11 = unsafe.getLong(byArray2, l10 = (long)n13 + l13));
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object == false) continue;
            int n14 = BIG_ENDIAN;
            if (n14 != 0) {
                return UnsignedLongs.compare(l12, l11);
            }
            n14 = Long.numberOfTrailingZeros(l12 ^ l11) & 0xFFFFFFF8;
            long l15 = l12 >>> n14;
            l12 = 255L;
            int n15 = (int)(l15 & l12);
            n14 = (int)(l11 >>> n14 & l12);
            return n15 - n14;
        }
        while (n10 < n11) {
            n12 = byArray[n10];
            byte by2 = byArray2[n10];
            if ((n12 = UnsignedBytes.compare((byte)n12, by2)) != 0) {
                return n12;
            }
            ++n10;
        }
        int n16 = byArray.length;
        int n17 = byArray2.length;
        return n16 - n17;
    }

    public String toString() {
        return "UnsignedBytes.lexicographicalComparator() (sun.misc.Unsafe version)";
    }
}

