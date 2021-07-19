/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;
import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;
import java.nio.ByteOrder;

public final class LittleEndianByteArray {
    public static final /* synthetic */ boolean $assertionsDisabled;
    private static final LittleEndianByteArray$LittleEndianBytes byteArray;

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        void var0_3;
        block4: {
            LittleEndianByteArray$JavaLittleEndianBytes littleEndianByteArray$JavaLittleEndianBytes = LittleEndianByteArray$JavaLittleEndianBytes.INSTANCE;
            Object object = "os.arch";
            try {
                object = System.getProperty((String)object);
                Object object2 = "amd64";
                boolean bl2 = ((String)object2).equals(object);
                if (!bl2) break block4;
                object = ByteOrder.nativeOrder();
                bl2 = object.equals(object2 = ByteOrder.LITTLE_ENDIAN);
                if (bl2) {
                    LittleEndianByteArray$UnsafeByteArray littleEndianByteArray$UnsafeByteArray = LittleEndianByteArray$UnsafeByteArray.UNSAFE_LITTLE_ENDIAN;
                } else {
                    LittleEndianByteArray$UnsafeByteArray littleEndianByteArray$UnsafeByteArray = LittleEndianByteArray$UnsafeByteArray.UNSAFE_BIG_ENDIAN;
                }
            }
            catch (Throwable throwable) {}
        }
        byteArray = var0_3;
    }

    private LittleEndianByteArray() {
    }

    public static int load32(byte[] byArray, int n10) {
        int n11 = byArray[n10] & 0xFF;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 8;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 16;
        return (byArray[n10 += 3] & 0xFF) << 24 | (n11 |= n12);
    }

    public static long load64(byte[] byArray, int n10) {
        return byteArray.getLongLittleEndian(byArray, n10);
    }

    public static long load64Safely(byte[] byArray, int n10, int n11) {
        int n12 = 8;
        n11 = Math.min(n11, n12);
        long l10 = 0L;
        for (int i10 = 0; i10 < n11; ++i10) {
            int n13 = n10 + i10;
            n13 = byArray[n13];
            long l11 = n13;
            long l12 = 255L;
            l11 &= l12;
            int n14 = i10 * 8;
            l10 |= (l11 <<= n14);
        }
        return l10;
    }

    public static void store64(byte[] byArray, int n10, long l10) {
        byteArray.putLongLittleEndian(byArray, n10, l10);
    }

    public static boolean usingUnsafe() {
        return byteArray instanceof LittleEndianByteArray$UnsafeByteArray;
    }
}

