/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.RandomAccess;

public class Lists$TwoPlusArrayList
extends AbstractList
implements Serializable,
RandomAccess {
    private static final long serialVersionUID;
    public final Object first;
    public final Object[] rest;
    public final Object second;

    public Lists$TwoPlusArrayList(Object objectArray, Object object, Object[] objectArray2) {
        this.first = objectArray;
        this.second = object;
        objectArray = (Object[])Preconditions.checkNotNull(objectArray2);
        this.rest = objectArray;
    }

    public Object get(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = this.size();
                Preconditions.checkElementIndex(n10, n11);
                Object[] objectArray = this.rest;
                return objectArray[n10 += -2];
            }
            return this.second;
        }
        return this.first;
    }

    public int size() {
        return IntMath.saturatedAdd(this.rest.length, 2);
    }
}

