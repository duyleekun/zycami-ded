/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIndexedListIterator;
import com.google.common.collect.UnmodifiableListIterator;

public final class Iterators$ArrayItr
extends AbstractIndexedListIterator {
    public static final UnmodifiableListIterator EMPTY;
    private final Object[] array;
    private final int offset;

    static {
        Object[] objectArray = new Object[]{};
        Iterators$ArrayItr iterators$ArrayItr = new Iterators$ArrayItr(objectArray, 0, 0, 0);
        EMPTY = iterators$ArrayItr;
    }

    public Iterators$ArrayItr(Object[] objectArray, int n10, int n11, int n12) {
        super(n11, n12);
        this.array = objectArray;
        this.offset = n10;
    }

    public Object get(int n10) {
        Object[] objectArray = this.array;
        int n11 = this.offset + n10;
        return objectArray[n11];
    }
}

