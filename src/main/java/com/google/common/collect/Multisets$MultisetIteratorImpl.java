/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Multisets$MultisetIteratorImpl
implements Iterator {
    private boolean canRemove;
    private Multiset$Entry currentEntry;
    private final Iterator entryIterator;
    private int laterCount;
    private final Multiset multiset;
    private int totalCount;

    public Multisets$MultisetIteratorImpl(Multiset multiset, Iterator iterator2) {
        this.multiset = multiset;
        this.entryIterator = iterator2;
    }

    public boolean hasNext() {
        Iterator iterator2;
        int n10 = this.laterCount;
        if (n10 <= 0 && !(n10 = (iterator2 = this.entryIterator).hasNext())) {
            n10 = 0;
            iterator2 = null;
        } else {
            n10 = 1;
        }
        return n10 != 0;
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            n10 = this.laterCount;
            if (n10 == 0) {
                Multiset$Entry multiset$Entry;
                this.currentEntry = multiset$Entry = (Multiset$Entry)this.entryIterator.next();
                this.laterCount = n10 = multiset$Entry.getCount();
                this.totalCount = n10;
            }
            n10 = this.laterCount;
            int n11 = 1;
            this.laterCount = n10 -= n11;
            this.canRemove = n11;
            return this.currentEntry.getElement();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        CollectPreconditions.checkRemove(this.canRemove);
        int n10 = this.totalCount;
        int n11 = 1;
        if (n10 == n11) {
            Iterator iterator2 = this.entryIterator;
            iterator2.remove();
        } else {
            Multiset multiset = this.multiset;
            Object object = this.currentEntry.getElement();
            multiset.remove(object);
        }
        this.totalCount = n10 = this.totalCount - n11;
        this.canRemove = false;
    }
}

