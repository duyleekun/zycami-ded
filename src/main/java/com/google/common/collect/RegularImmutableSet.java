/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;

public final class RegularImmutableSet
extends ImmutableSet {
    public static final RegularImmutableSet EMPTY;
    public final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    private final transient int size;
    public final transient Object[] table;

    static {
        RegularImmutableSet regularImmutableSet;
        Object[] objectArray = new Object[]{};
        EMPTY = regularImmutableSet = new RegularImmutableSet(objectArray, 0, null, 0, 0);
    }

    public RegularImmutableSet(Object[] objectArray, int n10, Object[] objectArray2, int n11, int n12) {
        this.elements = objectArray;
        this.table = objectArray2;
        this.mask = n11;
        this.hashCode = n10;
        this.size = n12;
    }

    public boolean contains(Object object) {
        Object[] objectArray = this.table;
        if (object != null && objectArray != null) {
            int n10 = Hashing.smearedHash(object);
            while (true) {
                int n11;
                Object object2;
                if ((object2 = objectArray[n10 &= (n11 = this.mask)]) == null) {
                    return false;
                }
                n11 = (int)(object2.equals(object) ? 1 : 0);
                if (n11 != 0) {
                    return true;
                }
                ++n10;
            }
        }
        return false;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        Object[] objectArray2 = this.elements;
        int n11 = this.size;
        System.arraycopy(objectArray2, 0, objectArray, n10, n11);
        int n12 = this.size;
        return n10 + n12;
    }

    public ImmutableList createAsList() {
        Object[] objectArray = this.elements;
        int n10 = this.size;
        return ImmutableList.asImmutableList(objectArray, n10);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public Object[] internalArray() {
        return this.elements;
    }

    public int internalArrayEnd() {
        return this.size;
    }

    public int internalArrayStart() {
        return 0;
    }

    public boolean isHashCodeFast() {
        return true;
    }

    public boolean isPartialView() {
        return false;
    }

    public UnmodifiableIterator iterator() {
        return this.asList().iterator();
    }

    public int size() {
        return this.size;
    }
}

