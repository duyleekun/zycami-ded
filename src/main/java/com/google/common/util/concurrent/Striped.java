/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.math.IntMath;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$2;
import com.google.common.util.concurrent.Striped$3;
import com.google.common.util.concurrent.Striped$4;
import com.google.common.util.concurrent.Striped$5;
import com.google.common.util.concurrent.Striped$6;
import com.google.common.util.concurrent.Striped$CompactStriped;
import com.google.common.util.concurrent.Striped$LargeLazyStriped;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import com.google.common.util.concurrent.Striped$SmallLazyStriped;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;

public abstract class Striped {
    private static final int ALL_SET = 255;
    private static final int LARGE_LAZY_CUTOFF = 1024;
    private static final Supplier READ_WRITE_LOCK_SUPPLIER;
    private static final Supplier WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER;

    static {
        Supplier supplier = new Striped$5();
        READ_WRITE_LOCK_SUPPLIER = supplier;
        supplier = new Striped$6();
        WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER = supplier;
    }

    private Striped() {
    }

    public /* synthetic */ Striped(Striped$1 var1_1) {
        this();
    }

    public static /* synthetic */ int access$200(int n10) {
        return Striped.ceilToPowerOfTwo(n10);
    }

    public static /* synthetic */ int access$300(int n10) {
        return Striped.smear(n10);
    }

    private static int ceilToPowerOfTwo(int n10) {
        RoundingMode roundingMode = RoundingMode.CEILING;
        n10 = IntMath.log2(n10, roundingMode);
        return 1 << n10;
    }

    public static Striped custom(int n10, Supplier supplier) {
        Striped$CompactStriped striped$CompactStriped = new Striped$CompactStriped(n10, supplier, null);
        return striped$CompactStriped;
    }

    private static Striped lazy(int n10, Supplier supplier) {
        int n11 = 1024;
        Striped$PowerOfTwoStriped striped$PowerOfTwoStriped = n10 < n11 ? new Striped$SmallLazyStriped(n10, supplier) : new Striped$LargeLazyStriped(n10, supplier);
        return striped$PowerOfTwoStriped;
    }

    public static Striped lazyWeakLock(int n10) {
        Striped$2 striped$2 = new Striped$2();
        return Striped.lazy(n10, striped$2);
    }

    public static Striped lazyWeakReadWriteLock(int n10) {
        Supplier supplier = WEAK_SAFE_READ_WRITE_LOCK_SUPPLIER;
        return Striped.lazy(n10, supplier);
    }

    public static Striped lazyWeakSemaphore(int n10, int n11) {
        Striped$4 striped$4 = new Striped$4(n11);
        return Striped.lazy(n10, striped$4);
    }

    public static Striped lock(int n10) {
        Striped$1 striped$1 = new Striped$1();
        return Striped.custom(n10, striped$1);
    }

    public static Striped readWriteLock(int n10) {
        Supplier supplier = READ_WRITE_LOCK_SUPPLIER;
        return Striped.custom(n10, supplier);
    }

    public static Striped semaphore(int n10, int n11) {
        Striped$3 striped$3 = new Striped$3(n11);
        return Striped.custom(n10, striped$3);
    }

    private static int smear(int n10) {
        int n11 = n10 >>> 20;
        int n12 = n10 >>> 12;
        n11 = (n10 ^= (n11 ^= n12)) >>> 7 ^ n10;
        return n10 >>> 4 ^ n11;
    }

    public Iterable bulkGet(Iterable objectArray) {
        Object object;
        Object object2;
        Object object3;
        Class<Object> clazz = Object.class;
        int n10 = (objectArray = Iterables.toArray((Iterable)objectArray, clazz)).length;
        if (n10 == 0) {
            return ImmutableList.of();
        }
        n10 = objectArray.length;
        clazz = (Class<Object>)new int[n10];
        int n11 = 0;
        Object object4 = null;
        for (object3 = 0; object3 < (object2 = objectArray.length); ++object3) {
            object = objectArray[object3];
            object2 = this.indexFor(object);
            clazz[object3] = object2;
        }
        Arrays.sort((int[])clazz);
        object3 = clazz[0];
        objectArray[0] = object = this.getAt((int)object3);
        for (n11 = 1; n11 < (object2 = objectArray.length); ++n11) {
            object2 = clazz[n11];
            if (object2 == object3) {
                object2 = n11 + -1;
                objectArray[n11] = object = objectArray[object2];
                continue;
            }
            objectArray[n11] = object4 = this.getAt((int)object2);
            object3 = object2;
        }
        return Collections.unmodifiableList(Arrays.asList(objectArray));
    }

    public abstract Object get(Object var1);

    public abstract Object getAt(int var1);

    public abstract int indexFor(Object var1);

    public abstract int size();
}

