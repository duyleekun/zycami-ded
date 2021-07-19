/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.UnsafeUtil$MemoryAccessor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeUtil$JvmMemoryAccessor
extends UnsafeUtil$MemoryAccessor {
    public UnsafeUtil$JvmMemoryAccessor(Unsafe unsafe) {
        super(unsafe);
    }

    public void copyMemory(long l10, byte[] byArray, long l11, long l12) {
        Unsafe unsafe = this.unsafe;
        long l13 = UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + l11;
        unsafe.copyMemory(null, l10, byArray, l13, l12);
    }

    public void copyMemory(byte[] byArray, long l10, long l11, long l12) {
        Unsafe unsafe = this.unsafe;
        long l13 = UnsafeUtil.BYTE_ARRAY_BASE_OFFSET + l10;
        unsafe.copyMemory(byArray, l13, null, l11, l12);
    }

    public boolean getBoolean(Object object, long l10) {
        return this.unsafe.getBoolean(object, l10);
    }

    public byte getByte(long l10) {
        return this.unsafe.getByte(l10);
    }

    public byte getByte(Object object, long l10) {
        return this.unsafe.getByte(object, l10);
    }

    public double getDouble(Object object, long l10) {
        return this.unsafe.getDouble(object, l10);
    }

    public float getFloat(Object object, long l10) {
        return this.unsafe.getFloat(object, l10);
    }

    public int getInt(long l10) {
        return this.unsafe.getInt(l10);
    }

    public long getLong(long l10) {
        return this.unsafe.getLong(l10);
    }

    public Object getStaticObject(Field field) {
        Object object = this.unsafe.staticFieldBase(field);
        long l10 = this.unsafe.staticFieldOffset(field);
        return this.getObject(object, l10);
    }

    public void putBoolean(Object object, long l10, boolean bl2) {
        this.unsafe.putBoolean(object, l10, bl2);
    }

    public void putByte(long l10, byte by2) {
        this.unsafe.putByte(l10, by2);
    }

    public void putByte(Object object, long l10, byte by2) {
        this.unsafe.putByte(object, l10, by2);
    }

    public void putDouble(Object object, long l10, double d10) {
        this.unsafe.putDouble(object, l10, d10);
    }

    public void putFloat(Object object, long l10, float f10) {
        this.unsafe.putFloat(object, l10, f10);
    }

    public void putInt(long l10, int n10) {
        this.unsafe.putInt(l10, n10);
    }

    public void putLong(long l10, long l11) {
        this.unsafe.putLong(l10, l11);
    }
}

