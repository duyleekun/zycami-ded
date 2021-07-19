/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ObjectCountHashMap;
import java.util.Arrays;

public class ObjectCountLinkedHashMap
extends ObjectCountHashMap {
    private static final int ENDPOINT = 254;
    private transient int firstEntry;
    private transient int lastEntry;
    public transient long[] links;

    public ObjectCountLinkedHashMap() {
        this(3);
    }

    public ObjectCountLinkedHashMap(int n10) {
        this(n10, 1.0f);
    }

    public ObjectCountLinkedHashMap(int n10, float f10) {
        super(n10, f10);
    }

    public ObjectCountLinkedHashMap(ObjectCountHashMap objectCountHashMap) {
        int n10 = objectCountHashMap.size();
        int n11 = 1065353216;
        float f10 = 1.0f;
        this.init(n10, f10);
        n10 = objectCountHashMap.firstIndex();
        while (true) {
            n11 = -1;
            f10 = 0.0f / 0.0f;
            if (n10 == n11) break;
            Object object = objectCountHashMap.getKey(n10);
            int n12 = objectCountHashMap.getValue(n10);
            this.put(object, n12);
            n10 = objectCountHashMap.nextIndex(n10);
        }
    }

    public static ObjectCountLinkedHashMap create() {
        ObjectCountLinkedHashMap objectCountLinkedHashMap = new ObjectCountLinkedHashMap();
        return objectCountLinkedHashMap;
    }

    public static ObjectCountLinkedHashMap createWithExpectedSize(int n10) {
        ObjectCountLinkedHashMap objectCountLinkedHashMap = new ObjectCountLinkedHashMap(n10);
        return objectCountLinkedHashMap;
    }

    private int getPredecessor(int n10) {
        return (int)(this.links[n10] >>> 32);
    }

    private int getSuccessor(int n10) {
        return (int)this.links[n10];
    }

    private void setPredecessor(int n10, int n11) {
        long[] lArray = this.links;
        long l10 = lArray[n10] & 0xFFFFFFFFL;
        long l11 = (long)n11 << 32;
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
        long l11 = (long)n11 & 0xFFFFFFFFL;
        lArray[n10] = l10 |= l11;
    }

    public void clear() {
        int n10;
        super.clear();
        this.firstEntry = n10 = -2;
        this.lastEntry = n10;
    }

    public int firstIndex() {
        int n10 = this.firstEntry;
        int n11 = -2;
        if (n10 == n11) {
            n10 = -1;
        }
        return n10;
    }

    public void init(int n10, float f10) {
        int n11;
        super.init(n10, f10);
        this.firstEntry = n11 = -2;
        this.lastEntry = n11;
        long[] lArray = new long[n10];
        this.links = lArray;
        Arrays.fill(lArray, (long)-1);
    }

    public void insertEntry(int n10, Object object, int n11, int n12) {
        super.insertEntry(n10, object, n11, n12);
        int n13 = this.lastEntry;
        this.setSucceeds(n13, n10);
        this.setSucceeds(n10, -2);
    }

    public void moveLastEntry(int n10) {
        int n11 = this.size() + -1;
        int n12 = this.getPredecessor(n10);
        int n13 = this.getSuccessor(n10);
        this.setSucceeds(n12, n13);
        if (n10 < n11) {
            n12 = this.getPredecessor(n11);
            this.setSucceeds(n12, n10);
            n11 = this.getSuccessor(n11);
            this.setSucceeds(n10, n11);
        }
        super.moveLastEntry(n10);
    }

    public int nextIndex(int n10) {
        int n11;
        if ((n10 = this.getSuccessor(n10)) == (n11 = -2)) {
            n10 = -1;
        }
        return n10;
    }

    public int nextIndexAfterRemove(int n10, int n11) {
        int n12 = this.size();
        if (n10 == n12) {
            n10 = n11;
        }
        return n10;
    }

    public void resizeEntries(int n10) {
        super.resizeEntries(n10);
        long[] lArray = this.links;
        int n11 = lArray.length;
        this.links = lArray = Arrays.copyOf(lArray, n10);
        Arrays.fill(lArray, n11, n10, (long)-1);
    }
}

