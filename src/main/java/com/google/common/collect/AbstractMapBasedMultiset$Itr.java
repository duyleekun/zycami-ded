/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ObjectCountHashMap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class AbstractMapBasedMultiset$Itr
implements Iterator {
    public int entryIndex;
    public int expectedModCount;
    public final /* synthetic */ AbstractMapBasedMultiset this$0;
    public int toRemove;

    public AbstractMapBasedMultiset$Itr(AbstractMapBasedMultiset abstractMapBasedMultiset) {
        int n10;
        int n11;
        this.this$0 = abstractMapBasedMultiset;
        this.entryIndex = n11 = abstractMapBasedMultiset.backingMap.firstIndex();
        this.toRemove = -1;
        this.expectedModCount = n10 = abstractMapBasedMultiset.backingMap.modCount;
    }

    private void checkForConcurrentModification() {
        Object object = this.this$0.backingMap;
        int n10 = ((ObjectCountHashMap)object).modCount;
        int n11 = this.expectedModCount;
        if (n10 == n11) {
            return;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean hasNext() {
        void var1_4;
        this.checkForConcurrentModification();
        int bl2 = this.entryIndex;
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
        }
        return (boolean)var1_4;
    }

    public Object next() {
        int n10 = this.hasNext();
        if (n10 != 0) {
            int n11;
            n10 = this.entryIndex;
            Object object = this.result(n10);
            this.toRemove = n11 = this.entryIndex;
            this.entryIndex = n11 = this.this$0.backingMap.nextIndex(n11);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        Object object;
        this.checkForConcurrentModification();
        int n10 = this.toRemove;
        int n11 = -1;
        if (n10 != n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        object = this.this$0;
        long l10 = ((AbstractMapBasedMultiset)object).size;
        ObjectCountHashMap objectCountHashMap = ((AbstractMapBasedMultiset)object).backingMap;
        int n12 = this.toRemove;
        long l11 = objectCountHashMap.removeEntry(n12);
        ((AbstractMapBasedMultiset)object).size = l10 -= l11;
        object = this.this$0.backingMap;
        int n13 = this.entryIndex;
        int n14 = this.toRemove;
        this.entryIndex = n10 = ((ObjectCountHashMap)object).nextIndexAfterRemove(n13, n14);
        this.toRemove = n11;
        this.expectedModCount = n10 = this.this$0.backingMap.modCount;
    }

    public abstract Object result(int var1);
}

