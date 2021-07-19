/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators$7
implements Iterator {
    private int count;
    public final /* synthetic */ Iterator val$iterator;
    public final /* synthetic */ int val$limitSize;

    public Iterators$7(int n10, Iterator iterator2) {
        this.val$limitSize = n10;
        this.val$iterator = iterator2;
    }

    public boolean hasNext() {
        Iterator iterator2;
        int n10 = this.count;
        int n11 = this.val$limitSize;
        if (n10 < n11 && (n10 = (int)((iterator2 = this.val$iterator).hasNext() ? 1 : 0))) {
            n10 = 1;
        } else {
            n10 = 0;
            iterator2 = null;
        }
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            this.count = n10 = this.count + 1;
            return this.val$iterator.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        this.val$iterator.remove();
    }
}

