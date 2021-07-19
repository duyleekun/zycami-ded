/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NoSuchElementException;

public final class Iterators$2
implements Iterator {
    public Iterator iterator;
    public final /* synthetic */ Iterable val$iterable;

    public Iterators$2(Iterable object) {
        this.val$iterable = object;
        this.iterator = object = Iterators.emptyModifiableIterator();
    }

    public boolean hasNext() {
        Iterator iterator2 = this.iterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2 && !(bl2 = (iterator2 = this.val$iterable.iterator()).hasNext())) {
            bl2 = false;
            iterator2 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object next() {
        Iterator iterator2 = this.iterator;
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            iterator2 = this.val$iterable.iterator();
            this.iterator = iterator2;
            bl2 = iterator2.hasNext();
            if (!bl2) {
                iterator2 = new NoSuchElementException();
                throw iterator2;
            }
        }
        return this.iterator.next();
    }

    public void remove() {
        this.iterator.remove();
    }
}

