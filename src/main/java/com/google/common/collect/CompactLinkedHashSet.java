/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashSet;
import com.google.common.collect.ObjectArrays;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class CompactLinkedHashSet
extends CompactHashSet {
    private static final int ENDPOINT = 254;
    private transient int firstEntry;
    private transient int lastEntry;
    private transient int[] predecessor;
    private transient int[] successor;

    public CompactLinkedHashSet() {
    }

    public CompactLinkedHashSet(int n10) {
        super(n10);
    }

    public static CompactLinkedHashSet create() {
        CompactLinkedHashSet compactLinkedHashSet = new CompactLinkedHashSet();
        return compactLinkedHashSet;
    }

    public static CompactLinkedHashSet create(Collection collection) {
        CompactLinkedHashSet compactLinkedHashSet = CompactLinkedHashSet.createWithExpectedSize(collection.size());
        compactLinkedHashSet.addAll(collection);
        return compactLinkedHashSet;
    }

    public static CompactLinkedHashSet create(Object ... objectArray) {
        CompactLinkedHashSet compactLinkedHashSet = CompactLinkedHashSet.createWithExpectedSize(objectArray.length);
        Collections.addAll(compactLinkedHashSet, objectArray);
        return compactLinkedHashSet;
    }

    public static CompactLinkedHashSet createWithExpectedSize(int n10) {
        CompactLinkedHashSet compactLinkedHashSet = new CompactLinkedHashSet(n10);
        return compactLinkedHashSet;
    }

    private int getPredecessor(int n10) {
        return this.predecessor[n10] + -1;
    }

    private void setPredecessor(int n10, int n11) {
        int[] nArray = this.predecessor;
        nArray[n10] = ++n11;
    }

    private void setSucceeds(int n10, int n11) {
        int n12 = -2;
        if (n10 == n12) {
            this.firstEntry = n11;
        } else {
            this.setSuccessor(n10, n11);
        }
        if (n11 == n12) {
            this.lastEntry = n10;
        } else {
            this.setPredecessor(n11, n10);
        }
    }

    private void setSuccessor(int n10, int n11) {
        int[] nArray = this.successor;
        nArray[n10] = ++n11;
    }

    public int adjustAfterRemove(int n10, int n11) {
        int n12 = this.size();
        if (n10 >= n12) {
            n10 = n11;
        }
        return n10;
    }

    public int allocArrays() {
        int n10 = super.allocArrays();
        int[] nArray = new int[n10];
        this.predecessor = nArray;
        nArray = new int[n10];
        this.successor = nArray;
        return n10;
    }

    public void clear() {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return;
        }
        this.firstEntry = n10 = -2;
        this.lastEntry = n10;
        int[] nArray = this.predecessor;
        int n11 = this.size();
        Arrays.fill(nArray, 0, n11, 0);
        nArray = this.successor;
        n11 = this.size();
        Arrays.fill(nArray, 0, n11, 0);
        super.clear();
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int n10) {
        return this.successor[n10] + -1;
    }

    public void init(int n10) {
        super.init(n10);
        this.firstEntry = n10 = -2;
        this.lastEntry = n10;
    }

    public void insertEntry(int n10, Object object, int n11, int n12) {
        super.insertEntry(n10, object, n11, n12);
        int n13 = this.lastEntry;
        this.setSucceeds(n13, n10);
        this.setSucceeds(n10, -2);
    }

    public void moveLastEntry(int n10, int n11) {
        int n12 = this.size() + -1;
        super.moveLastEntry(n10, n11);
        n11 = this.getPredecessor(n10);
        int n13 = this.getSuccessor(n10);
        this.setSucceeds(n11, n13);
        if (n10 < n12) {
            n11 = this.getPredecessor(n12);
            this.setSucceeds(n11, n10);
            n11 = this.getSuccessor(n12);
            this.setSucceeds(n10, n11);
        }
        this.predecessor[n12] = 0;
        this.successor[n12] = 0;
    }

    public void resizeEntries(int n10) {
        super.resizeEntries(n10);
        int[] nArray = Arrays.copyOf(this.predecessor, n10);
        this.predecessor = nArray;
        int[] nArray2 = Arrays.copyOf(this.successor, n10);
        this.successor = nArray2;
    }

    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    public Object[] toArray(Object[] objectArray) {
        return ObjectArrays.toArrayImpl(this, objectArray);
    }
}

