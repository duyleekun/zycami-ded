/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class CompactLinkedHashMap
extends CompactHashMap {
    private static final int ENDPOINT = 254;
    private final boolean accessOrder;
    private transient int firstEntry;
    private transient int lastEntry;
    public transient long[] links;

    public CompactLinkedHashMap() {
        this(3);
    }

    public CompactLinkedHashMap(int n10) {
        this(n10, false);
    }

    public CompactLinkedHashMap(int n10, boolean bl2) {
        super(n10);
        this.accessOrder = bl2;
    }

    public static CompactLinkedHashMap create() {
        CompactLinkedHashMap compactLinkedHashMap = new CompactLinkedHashMap();
        return compactLinkedHashMap;
    }

    public static CompactLinkedHashMap createWithExpectedSize(int n10) {
        CompactLinkedHashMap compactLinkedHashMap = new CompactLinkedHashMap(n10);
        return compactLinkedHashMap;
    }

    private int getPredecessor(int n10) {
        return (int)(this.links[n10] >>> 32) + -1;
    }

    private void setPredecessor(int n10, int n11) {
        long[] lArray = this.links;
        long l10 = lArray[n10] & 0xFFFFFFFFL;
        long l11 = (long)(n11 + 1) << 32;
        lArray[n10] = l10 |= l11;
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
        long[] lArray = this.links;
        long l10 = lArray[n10] & 0xFFFFFFFF00000000L;
        long l11 = (long)(n11 + 1) & 0xFFFFFFFFL;
        lArray[n10] = l10 |= l11;
    }

    public void accessEntry(int n10) {
        int n11 = this.accessOrder;
        if (n11 != 0) {
            n11 = this.getPredecessor(n10);
            int n12 = this.getSuccessor(n10);
            this.setSucceeds(n11, n12);
            n11 = this.lastEntry;
            this.setSucceeds(n11, n10);
            n11 = -2;
            this.setSucceeds(n10, n11);
            this.incrementModCount();
        }
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
        long[] lArray = new long[n10];
        this.links = lArray;
        return n10;
    }

    public void clear() {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return;
        }
        this.firstEntry = n10 = -2;
        this.lastEntry = n10;
        long[] lArray = this.links;
        if (lArray != null) {
            int n11 = this.size();
            long l10 = 0L;
            Arrays.fill(lArray, 0, n11, l10);
        }
        super.clear();
    }

    public Map convertToHashFloodingResistantImplementation() {
        Map map = super.convertToHashFloodingResistantImplementation();
        this.links = null;
        return map;
    }

    public Map createHashFloodingResistantDelegate(int n10) {
        boolean bl2 = this.accessOrder;
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10, 1.0f, bl2);
        return linkedHashMap;
    }

    public int firstEntryIndex() {
        return this.firstEntry;
    }

    public int getSuccessor(int n10) {
        return (int)this.links[n10] + -1;
    }

    public void init(int n10) {
        super.init(n10);
        this.firstEntry = n10 = -2;
        this.lastEntry = n10;
    }

    public void insertEntry(int n10, Object object, Object object2, int n11, int n12) {
        super.insertEntry(n10, object, object2, n11, n12);
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
        this.links[n12] = 0L;
    }

    public void resizeEntries(int n10) {
        super.resizeEntries(n10);
        long[] lArray = Arrays.copyOf(this.links, n10);
        this.links = lArray;
    }
}

