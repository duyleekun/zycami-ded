/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.UnmodifiableIterator;
import java.util.NoSuchElementException;

public final class Iterators$3
extends UnmodifiableIterator {
    public int index = 0;
    public final /* synthetic */ Object[] val$elements;

    public Iterators$3(Object[] objectArray) {
        this.val$elements = objectArray;
    }

    public boolean hasNext() {
        int n10 = this.index;
        Object[] objectArray = this.val$elements;
        int n11 = objectArray.length;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object[] objectArray = this.val$elements;
            int n10 = this.index;
            Object object = objectArray[n10];
            objectArray[n10] = null;
            this.index = ++n10;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }
}

