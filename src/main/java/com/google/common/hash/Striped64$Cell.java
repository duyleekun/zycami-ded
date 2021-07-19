/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.Striped64;
import java.lang.reflect.Field;
import sun.misc.Unsafe;

public final class Striped64$Cell {
    private static final Unsafe UNSAFE;
    private static final long valueOffset;
    public volatile long p0;
    public volatile long p1;
    public volatile long p2;
    public volatile long p3;
    public volatile long p4;
    public volatile long p5;
    public volatile long p6;
    public volatile long q0;
    public volatile long q1;
    public volatile long q2;
    public volatile long q3;
    public volatile long q4;
    public volatile long q5;
    public volatile long q6;
    public volatile long value;

    static {
        Object object;
        Unsafe unsafe;
        try {
            unsafe = Striped64.access$000();
        }
        catch (Exception exception) {
            object = new Error(exception);
            throw object;
        }
        UNSAFE = unsafe;
        object = Striped64$Cell.class;
        String string2 = "value";
        object = ((Class)object).getDeclaredField(string2);
        long l10 = unsafe.objectFieldOffset((Field)object);
        valueOffset = l10;
    }

    public Striped64$Cell(long l10) {
        this.value = l10;
    }

    public final boolean cas(long l10, long l11) {
        Unsafe unsafe = UNSAFE;
        long l12 = valueOffset;
        return unsafe.compareAndSwapLong(this, l12, l10, l11);
    }
}

