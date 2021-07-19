/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashSet;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CompactHashSet$1
implements Iterator {
    public int currentIndex;
    public int expectedMetadata;
    public int indexToRemove;
    public final /* synthetic */ CompactHashSet this$0;

    public CompactHashSet$1(CompactHashSet compactHashSet) {
        int n10;
        int n11;
        this.this$0 = compactHashSet;
        this.expectedMetadata = n11 = CompactHashSet.access$000(compactHashSet);
        this.currentIndex = n10 = compactHashSet.firstEntryIndex();
        this.indexToRemove = -1;
    }

    private void checkForConcurrentModification() {
        int n10;
        Serializable serializable = this.this$0;
        int n11 = CompactHashSet.access$000(serializable);
        if (n11 == (n10 = this.expectedMetadata)) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public boolean hasNext() {
        int n10 = this.currentIndex;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public void incrementExpectedModCount() {
        int n10;
        this.expectedMetadata = n10 = this.expectedMetadata + 32;
    }

    public Object next() {
        this.checkForConcurrentModification();
        int n10 = this.hasNext();
        if (n10 != 0) {
            this.indexToRemove = n10 = this.currentIndex;
            CompactHashSet compactHashSet = this.this$0;
            Object object = compactHashSet.elements[n10];
            this.currentIndex = n10 = compactHashSet.getSuccessor(n10);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        CompactHashSet compactHashSet;
        this.checkForConcurrentModification();
        int n10 = this.indexToRemove;
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            compactHashSet = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        this.incrementExpectedModCount();
        compactHashSet = this.this$0;
        Object object = compactHashSet.elements;
        int n11 = this.indexToRemove;
        object = object[n11];
        compactHashSet.remove(object);
        compactHashSet = this.this$0;
        int n12 = this.currentIndex;
        n11 = this.indexToRemove;
        this.currentIndex = n10 = compactHashSet.adjustAfterRemove(n12, n11);
        this.indexToRemove = -1;
    }
}

