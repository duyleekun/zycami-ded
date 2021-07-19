/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$1;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public abstract class CompactHashMap$Itr
implements Iterator {
    public int currentIndex;
    public int expectedMetadata;
    public int indexToRemove;
    public final /* synthetic */ CompactHashMap this$0;

    private CompactHashMap$Itr(CompactHashMap compactHashMap) {
        int n10;
        int n11;
        this.this$0 = compactHashMap;
        this.expectedMetadata = n11 = CompactHashMap.access$000(compactHashMap);
        this.currentIndex = n10 = compactHashMap.firstEntryIndex();
        this.indexToRemove = -1;
    }

    public /* synthetic */ CompactHashMap$Itr(CompactHashMap compactHashMap, CompactHashMap.1 var2_2) {
        this(compactHashMap);
    }

    private void checkForConcurrentModification() {
        int n10;
        Serializable serializable = this.this$0;
        int n11 = CompactHashMap.access$000(serializable);
        if (n11 == (n10 = this.expectedMetadata)) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public abstract Object getOutput(int var1);

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
            int n11;
            this.indexToRemove = n10 = this.currentIndex;
            Object object = this.getOutput(n10);
            CompactHashMap compactHashMap = this.this$0;
            int n12 = this.currentIndex;
            this.currentIndex = n11 = compactHashMap.getSuccessor(n12);
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        CompactHashMap compactHashMap;
        this.checkForConcurrentModification();
        int n10 = this.indexToRemove;
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            compactHashMap = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        this.incrementExpectedModCount();
        compactHashMap = this.this$0;
        Object object = compactHashMap.keys;
        int n11 = this.indexToRemove;
        object = object[n11];
        compactHashMap.remove(object);
        compactHashMap = this.this$0;
        int n12 = this.currentIndex;
        n11 = this.indexToRemove;
        this.currentIndex = n10 = compactHashMap.adjustAfterRemove(n12, n11);
        this.indexToRemove = -1;
    }
}

