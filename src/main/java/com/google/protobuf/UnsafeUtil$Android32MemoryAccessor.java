/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.UnsafeUtil;
import com.google.protobuf.UnsafeUtil$MemoryAccessor;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class UnsafeUtil$Android32MemoryAccessor
extends UnsafeUtil$MemoryAccessor {
    private static final long SMALL_ADDRESS_MASK = 255L;

    public UnsafeUtil$Android32MemoryAccessor(Unsafe unsafe) {
        super(unsafe);
    }

    private static int smallAddress(long l10) {
        return (int)(l10 & (long)-1);
    }

    public void copyMemory(long l10, byte[] byArray, long l11, long l12) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void copyMemory(byte[] object, long l10, long l11, long l12) {
        object = new UnsupportedOperationException;
        object();
        throw object;
    }

    public boolean getBoolean(Object object, long l10) {
        boolean bl2 = UnsafeUtil.IS_BIG_ENDIAN;
        if (bl2) {
            return UnsafeUtil.access$400(object, l10);
        }
        return UnsafeUtil.access$500(object, l10);
    }

    public byte getByte(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public byte getByte(Object object, long l10) {
        boolean bl2 = UnsafeUtil.IS_BIG_ENDIAN;
        if (bl2) {
            return UnsafeUtil.access$000(object, l10);
        }
        return UnsafeUtil.access$100(object, l10);
    }

    public double getDouble(Object object, long l10) {
        return Double.longBitsToDouble(this.getLong(object, l10));
    }

    public float getFloat(Object object, long l10) {
        return Float.intBitsToFloat(this.getInt(object, l10));
    }

    public int getInt(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public long getLong(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object getStaticObject(Field field) {
        try {
            return field.get(null);
        }
        catch (IllegalAccessException illegalAccessException) {
            return null;
        }
    }

    public void putBoolean(Object object, long l10, boolean bl2) {
        boolean bl3 = UnsafeUtil.IS_BIG_ENDIAN;
        if (bl3) {
            UnsafeUtil.access$600(object, l10, bl2);
        } else {
            UnsafeUtil.access$700(object, l10, bl2);
        }
    }

    public void putByte(long l10, byte by2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void putByte(Object object, long l10, byte by2) {
        boolean bl2 = UnsafeUtil.IS_BIG_ENDIAN;
        if (bl2) {
            UnsafeUtil.access$200(object, l10, by2);
        } else {
            UnsafeUtil.access$300(object, l10, by2);
        }
    }

    public void putDouble(Object object, long l10, double d10) {
        long l11 = Double.doubleToLongBits(d10);
        this.putLong(object, l10, l11);
    }

    public void putFloat(Object object, long l10, float f10) {
        int n10 = Float.floatToIntBits(f10);
        this.putInt(object, l10, n10);
    }

    public void putInt(long l10, int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void putLong(long l10, long l11) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

