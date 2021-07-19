/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

public final class RegularImmutableMap$KeysOrValuesAsList
extends ImmutableList {
    private final transient Object[] alternatingKeysAndValues;
    private final transient int offset;
    private final transient int size;

    public RegularImmutableMap$KeysOrValuesAsList(Object[] objectArray, int n10, int n11) {
        this.alternatingKeysAndValues = objectArray;
        this.offset = n10;
        this.size = n11;
    }

    public Object get(int n10) {
        int n11 = this.size;
        Preconditions.checkElementIndex(n10, n11);
        Object[] objectArray = this.alternatingKeysAndValues;
        n10 *= 2;
        int n12 = this.offset;
        return objectArray[n10 += n12];
    }

    public boolean isPartialView() {
        return true;
    }

    public int size() {
        return this.size;
    }
}

