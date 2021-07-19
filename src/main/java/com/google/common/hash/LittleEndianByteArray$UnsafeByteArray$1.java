/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$UnsafeByteArray;
import sun.misc.Unsafe;

public final class LittleEndianByteArray$UnsafeByteArray$1
extends LittleEndianByteArray$UnsafeByteArray {
    public long getLongLittleEndian(byte[] byArray, int n10) {
        Unsafe unsafe = LittleEndianByteArray$UnsafeByteArray.access$200();
        long l10 = n10;
        long l11 = LittleEndianByteArray$UnsafeByteArray.access$100();
        return unsafe.getLong(byArray, l10 += l11);
    }

    public void putLongLittleEndian(byte[] byArray, int n10, long l10) {
        Unsafe unsafe = LittleEndianByteArray$UnsafeByteArray.access$200();
        long l11 = n10;
        long l12 = LittleEndianByteArray$UnsafeByteArray.access$100();
        long l13 = l11 + l12;
        unsafe.putLong(byArray, l13, l10);
    }
}

