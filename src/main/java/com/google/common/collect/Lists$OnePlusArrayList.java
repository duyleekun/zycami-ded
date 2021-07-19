/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

public class Lists$OnePlusArrayList
extends AbstractList
implements Serializable,
RandomAccess {
    private static final long serialVersionUID;
    public final Object first;
    public final Object[] rest;

    public Lists$OnePlusArrayList(Object objectArray, Object[] objectArray2) {
        this.first = objectArray;
        objectArray = (Object[])Preconditions.checkNotNull(objectArray2);
        this.rest = objectArray;
    }

    public Object get(int n10) {
        Object object;
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        if (n10 == 0) {
            object = this.first;
        } else {
            Object[] objectArray = this.rest;
            object = objectArray[n10 += -1];
        }
        return object;
    }

    public int size() {
        return IntMath.saturatedAdd(this.rest.length, 1);
    }
}

