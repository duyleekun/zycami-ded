/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Striped$1;
import com.google.common.util.concurrent.Striped$PowerOfTwoStriped;

public class Striped$CompactStriped
extends Striped$PowerOfTwoStriped {
    private final Object[] array;

    private Striped$CompactStriped(int n10, Supplier supplier) {
        super(n10);
        Object[] objectArray;
        int n11 = 0;
        int n12 = 1;
        int n13 = 0x40000000;
        if (n10 <= n13) {
            n10 = n12;
        } else {
            n10 = 0;
            objectArray = null;
        }
        String string2 = "Stripes must be <= 2^30)";
        Preconditions.checkArgument(n10 != 0, string2);
        n10 = this.mask + n12;
        objectArray = new Object[n10];
        this.array = objectArray;
        while (n11 < (n12 = (objectArray = this.array).length)) {
            Object object;
            objectArray[n11] = object = supplier.get();
            ++n11;
        }
    }

    public /* synthetic */ Striped$CompactStriped(int n10, Supplier supplier, Striped$1 striped$1) {
        this(n10, supplier);
    }

    public Object getAt(int n10) {
        return this.array[n10];
    }

    public int size() {
        return this.array.length;
    }
}

