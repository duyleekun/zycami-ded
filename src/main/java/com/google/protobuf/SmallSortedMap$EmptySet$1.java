/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class SmallSortedMap$EmptySet$1
implements Iterator {
    public boolean hasNext() {
        return false;
    }

    public Object next() {
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }
}

