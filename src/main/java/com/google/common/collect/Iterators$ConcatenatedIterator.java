/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Deque;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterators$ConcatenatedIterator
implements Iterator {
    private Iterator iterator;
    private Deque metaIterators;
    private Iterator toRemove;
    private Iterator topMetaIterator;

    public Iterators$ConcatenatedIterator(Iterator iterator2) {
        UnmodifiableIterator unmodifiableIterator = Iterators.emptyIterator();
        this.iterator = unmodifiableIterator;
        this.topMetaIterator = iterator2 = (Iterator)Preconditions.checkNotNull(iterator2);
    }

    private Iterator getTopMetaIterator() {
        while (true) {
            boolean bl2;
            Object object;
            if ((object = this.topMetaIterator) != null && (bl2 = object.hasNext())) {
                return this.topMetaIterator;
            }
            object = this.metaIterators;
            if (object == null || (bl2 = object.isEmpty())) break;
            this.topMetaIterator = object = (Iterator)this.metaIterators.removeFirst();
        }
        return null;
    }

    public boolean hasNext() {
        Iterator iterator2;
        boolean bl2;
        while (!(bl2 = (iterator2 = (Iterator)Preconditions.checkNotNull(this.iterator)).hasNext())) {
            this.topMetaIterator = iterator2 = this.getTopMetaIterator();
            if (iterator2 == null) {
                return false;
            }
            this.iterator = iterator2 = (Iterator)iterator2.next();
            boolean bl3 = iterator2 instanceof Iterators$ConcatenatedIterator;
            if (!bl3) continue;
            iterator2 = (Iterators$ConcatenatedIterator)iterator2;
            Deque<Iterator> deque = ((Iterators$ConcatenatedIterator)iterator2).iterator;
            this.iterator = deque;
            deque = this.metaIterators;
            if (deque == null) {
                deque = new Deque<Iterator>();
                this.metaIterators = deque;
            }
            deque = this.metaIterators;
            Iterator iterator3 = this.topMetaIterator;
            deque.addFirst(iterator3);
            deque = ((Iterators$ConcatenatedIterator)iterator2).metaIterators;
            if (deque != null) {
                while (!(bl3 = (deque = ((Iterators$ConcatenatedIterator)iterator2).metaIterators).isEmpty())) {
                    deque = this.metaIterators;
                    iterator3 = ((Iterators$ConcatenatedIterator)iterator2).metaIterators.removeLast();
                    deque.addFirst(iterator3);
                }
            }
            this.topMetaIterator = iterator2 = ((Iterators$ConcatenatedIterator)iterator2).topMetaIterator;
        }
        return true;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Iterator iterator2;
            this.toRemove = iterator2 = this.iterator;
            return iterator2.next();
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        boolean bl2;
        Iterator iterator2 = this.toRemove;
        if (iterator2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            iterator2 = null;
        }
        CollectPreconditions.checkRemove(bl2);
        this.toRemove.remove();
        this.toRemove = null;
    }
}

