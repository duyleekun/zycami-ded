/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.MapMaker;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;
import java.util.concurrent.ConcurrentMap;

public class Striped$LargeLazyStriped
extends Striped$PowerOfTwoStriped {
    public final ConcurrentMap locks;
    public final int size;
    public final Supplier supplier;

    public Striped$LargeLazyStriped(int n10, Supplier supplier) {
        super(n10);
        n10 = this.mask;
        int n11 = -1;
        n10 = n10 == n11 ? -1 >>> 1 : ++n10;
        this.size = n10;
        this.supplier = supplier;
        Object object = new MapMaker();
        this.locks = object = ((MapMaker)object).weakValues().makeMap();
    }

    public Object getAt(int n10) {
        int n11 = this.size;
        int n12 = -1 >>> 1;
        if (n11 != n12) {
            n11 = this.size();
            Preconditions.checkElementIndex(n10, n11);
        }
        Object object = this.locks;
        Object object2 = n10;
        if ((object = object.get(object2)) != null) {
            return object;
        }
        object = this.supplier.get();
        object2 = this.locks;
        Integer n13 = n10;
        return MoreObjects.firstNonNull(object2.putIfAbsent(n13, object), object);
    }

    public int size() {
        return this.size;
    }
}

