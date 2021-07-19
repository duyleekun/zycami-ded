/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashBiMap$View;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class HashBiMap$View$1
implements Iterator {
    private int expectedModCount;
    private int index;
    private int indexToRemove;
    private int remaining;
    public final /* synthetic */ HashBiMap$View this$0;

    public HashBiMap$View$1(HashBiMap$View object) {
        int n10;
        int n11;
        this.this$0 = object;
        this.index = n11 = HashBiMap.access$000(((HashBiMap$View)object).biMap);
        this.indexToRemove = -1;
        object = ((HashBiMap$View)object).biMap;
        this.expectedModCount = n11 = ((HashBiMap)object).modCount;
        this.remaining = n10 = ((HashBiMap)object).size;
    }

    private void checkForComodification() {
        Serializable serializable = this.this$0.biMap;
        int n10 = serializable.modCount;
        int n11 = this.expectedModCount;
        if (n10 == n11) {
            return;
        }
        serializable = new ConcurrentModificationException();
        throw serializable;
    }

    public boolean hasNext() {
        this.checkForComodification();
        int n10 = this.index;
        int n11 = -2;
        n10 = n10 != n11 && (n10 = this.remaining) > 0 ? 1 : 0;
        return n10 != 0;
    }

    public Object next() {
        boolean bl2 = this.hasNext();
        if (bl2) {
            Object object = this.this$0;
            int n10 = this.index;
            object = ((HashBiMap$View)object).forEntry(n10);
            this.indexToRemove = n10 = this.index;
            int[] nArray = HashBiMap.access$100(this.this$0.biMap);
            int n11 = this.index;
            this.index = n10 = nArray[n11];
            this.remaining = n10 = this.remaining + -1;
            return object;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public void remove() {
        HashBiMap hashBiMap;
        this.checkForComodification();
        int n10 = this.indexToRemove;
        int n11 = -1;
        if (n10 != n11) {
            n10 = 1;
        } else {
            n10 = 0;
            hashBiMap = null;
        }
        CollectPreconditions.checkRemove(n10 != 0);
        hashBiMap = this.this$0.biMap;
        int n12 = this.indexToRemove;
        hashBiMap.removeEntry(n12);
        n10 = this.index;
        HashBiMap hashBiMap2 = this.this$0.biMap;
        int n13 = hashBiMap2.size;
        if (n10 == n13) {
            this.index = n10 = this.indexToRemove;
        }
        this.indexToRemove = n11;
        this.expectedModCount = n10 = hashBiMap2.modCount;
    }
}

