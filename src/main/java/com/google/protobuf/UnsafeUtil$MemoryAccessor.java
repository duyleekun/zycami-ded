/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.lang.reflect.Field;
import sun.misc.Unsafe;

public abstract class UnsafeUtil$MemoryAccessor {
    public Unsafe unsafe;

    public UnsafeUtil$MemoryAccessor(Unsafe unsafe) {
        this.unsafe = unsafe;
    }

    public final int arrayBaseOffset(Class clazz) {
        return this.unsafe.arrayBaseOffset(clazz);
    }

    public final int arrayIndexScale(Class clazz) {
        return this.unsafe.arrayIndexScale(clazz);
    }

    public abstract void copyMemory(long var1, byte[] var3, long var4, long var6);

    public abstract void copyMemory(byte[] var1, long var2, long var4, long var6);

    public abstract boolean getBoolean(Object var1, long var2);

    public abstract byte getByte(long var1);

    public abstract byte getByte(Object var1, long var2);

    public abstract double getDouble(Object var1, long var2);

    public abstract float getFloat(Object var1, long var2);

    public abstract int getInt(long var1);

    public final int getInt(Object object, long l10) {
        return this.unsafe.getInt(object, l10);
    }

    public abstract long getLong(long var1);

    public final long getLong(Object object, long l10) {
        return this.unsafe.getLong(object, l10);
    }

    public final Object getObject(Object object, long l10) {
        return this.unsafe.getObject(object, l10);
    }

    public abstract Object getStaticObject(Field var1);

    public final long objectFieldOffset(Field field) {
        return this.unsafe.objectFieldOffset(field);
    }

    public abstract void putBoolean(Object var1, long var2, boolean var4);

    public abstract void putByte(long var1, byte var3);

    public abstract void putByte(Object var1, long var2, byte var4);

    public abstract void putDouble(Object var1, long var2, double var4);

    public abstract void putFloat(Object var1, long var2, float var4);

    public abstract void putInt(long var1, int var3);

    public final void putInt(Object object, long l10, int n10) {
        this.unsafe.putInt(object, l10, n10);
    }

    public abstract void putLong(long var1, long var3);

    public final void putLong(Object object, long l10, long l11) {
        this.unsafe.putLong(object, l10, l11);
    }

    public final void putObject(Object object, long l10, Object object2) {
        this.unsafe.putObject(object, l10, object2);
    }
}

