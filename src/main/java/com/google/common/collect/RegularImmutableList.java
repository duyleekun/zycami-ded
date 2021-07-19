/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public class RegularImmutableList
extends ImmutableList {
    public static final ImmutableList EMPTY;
    public final transient Object[] array;
    private final transient int size;

    static {
        Object[] objectArray = new Object[]{};
        RegularImmutableList regularImmutableList = new RegularImmutableList(objectArray, 0);
        EMPTY = regularImmutableList;
    }

    public RegularImmutableList(Object[] objectArray, int n10) {
        this.array = objectArray;
        this.size = n10;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        Object[] objectArray2 = this.array;
        int n11 = this.size;
        System.arraycopy(objectArray2, 0, objectArray, n10, n11);
        int n12 = this.size;
        return n10 + n12;
    }

    public Object get(int n10) {
        int n11 = this.size;
        Preconditions.checkElementIndex(n10, n11);
        return this.array[n10];
    }

    public Object[] internalArray() {
        return this.array;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public boolean isPartialView() {
        return false;
    }

    public int size() {
        return this.size;
    }
}

