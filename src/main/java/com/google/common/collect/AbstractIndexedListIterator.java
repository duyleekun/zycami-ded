/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.UnmodifiableListIterator;
import java.util.NoSuchElementException;

public abstract class AbstractIndexedListIterator
extends UnmodifiableListIterator {
    private int position;
    private final int size;

    public AbstractIndexedListIterator(int n10) {
        this(n10, 0);
    }

    public AbstractIndexedListIterator(int n10, int n11) {
        Preconditions.checkPositionIndex(n11, n10);
        this.size = n10;
        this.position = n11;
    }

    public abstract Object get(int var1);

    public final boolean hasNext() {
        int n10 = this.position;
        int n11 = this.size;
        n10 = n10 < n11 ? 1 : 0;
        return n10 != 0;
    }

    public final boolean hasPrevious() {
        int n10 = this.position;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public final Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            n10 = this.position;
            this.position = n11 = n10 + 1;
            return this.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int nextIndex() {
        return this.position;
    }

    public final Object previous() {
        int n10 = this.hasPrevious();
        if (n10 != 0) {
            this.position = n10 = this.position + -1;
            return this.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int previousIndex() {
        return this.position + -1;
    }
}

