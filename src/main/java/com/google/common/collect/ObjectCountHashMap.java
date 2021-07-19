/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Hashing;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.ObjectCountHashMap$MapEntry;
import java.util.Arrays;

public class ObjectCountHashMap {
    public static final float DEFAULT_LOAD_FACTOR = 1.0f;
    public static final int DEFAULT_SIZE = 3;
    private static final long HASH_MASK = 0xFF00000000L;
    private static final int MAXIMUM_CAPACITY = 0x40000000;
    private static final long NEXT_MASK = 0xFFFFFFFFL;
    public static final int UNSET = 255;
    public transient long[] entries;
    public transient Object[] keys;
    private transient float loadFactor;
    public transient int modCount;
    public transient int size;
    private transient int[] table;
    private transient int threshold;
    public transient int[] values;

    public ObjectCountHashMap() {
        this.init(3, 1.0f);
    }

    public ObjectCountHashMap(int n10) {
        this(n10, 1.0f);
    }

    public ObjectCountHashMap(int n10, float f10) {
        this.init(n10, f10);
    }

    public ObjectCountHashMap(ObjectCountHashMap objectCountHashMap) {
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

    public static ObjectCountHashMap create() {
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap();
        return objectCountHashMap;
    }

    public static ObjectCountHashMap createWithExpectedSize(int n10) {
        ObjectCountHashMap objectCountHashMap = new ObjectCountHashMap(n10);
        return objectCountHashMap;
    }

    private static int getHash(long l10) {
        return (int)(l10 >>> 32);
    }

    private static int getNext(long l10) {
        return (int)l10;
    }

    private int hashTableMask() {
        return this.table.length + -1;
    }

    private static long[] newEntries(int n10) {
        long[] lArray = new long[n10];
        Arrays.fill(lArray, (long)-1);
        return lArray;
    }

    private static int[] newTable(int n10) {
        int[] nArray = new int[n10];
        Arrays.fill(nArray, -1);
        return nArray;
    }

    private int remove(Object object, int n10) {
        int n11 = this.hashTableMask() & n10;
        int[] nArray = this.table;
        int n12 = nArray[n11];
        int n13 = 0;
        long[] lArray = null;
        int n14 = -1;
        if (n12 == n14) {
            return 0;
        }
        int n15 = n14;
        while (true) {
            long l10;
            Object object2;
            long l11;
            int n16;
            if ((n16 = ObjectCountHashMap.getHash(l11 = (object2 = this.entries)[n12])) == n10 && (n16 = (int)(Objects.equal(object, object2 = (Object)this.keys[n12]) ? 1 : 0)) != 0) {
                object = this.values;
                Object object3 = object[n12];
                if (n15 == n14) {
                    int[] nArray2 = this.table;
                    lArray = this.entries;
                    long l12 = lArray[n12];
                    nArray2[n11] = n13 = ObjectCountHashMap.getNext(l12);
                } else {
                    long[] lArray2 = this.entries;
                    long l13 = lArray2[n15];
                    l10 = lArray2[n12];
                    n11 = ObjectCountHashMap.getNext(l10);
                    lArray2[n15] = l13 = ObjectCountHashMap.swapNext(l13, n11);
                }
                this.moveLastEntry(n12);
                this.size = n10 = this.size + -1;
                this.modCount = n10 = this.modCount + 1;
                return (int)object3;
            }
            long[] lArray3 = this.entries;
            l10 = lArray3[n12];
            n15 = ObjectCountHashMap.getNext(l10);
            if (n15 == n14) {
                return 0;
            }
            int n17 = n15;
            n15 = n12;
            n12 = n17;
        }
    }

    private void resizeMeMaybe(int n10) {
        long[] lArray = this.entries;
        int n11 = lArray.length;
        if (n10 > n11) {
            n10 = n11 >>> 1;
            int n12 = 1;
            if ((n10 = Math.max(n12, n10) + n11) < 0) {
                n10 = -1 >>> 1;
            }
            if (n10 != n11) {
                this.resizeEntries(n10);
            }
        }
    }

    private void resizeTable(int n10) {
        int n11;
        int[] nArray = this.table;
        int n12 = nArray.length;
        int n13 = 0x40000000;
        float f10 = 2.0f;
        if (n12 >= n13) {
            this.threshold = -1 >>> 1;
            return;
        }
        float f11 = n10;
        f10 = this.loadFactor;
        n12 = (int)(f11 *= f10) + 1;
        int[] nArray2 = ObjectCountHashMap.newTable(n10);
        long[] lArray = this.entries;
        int n14 = nArray2.length + -1;
        int n15 = 0;
        while (n15 < (n11 = this.size)) {
            n11 = ObjectCountHashMap.getHash(lArray[n15]);
            int n16 = n11 & n14;
            int n17 = nArray2[n16];
            nArray2[n16] = n15++;
            long l10 = n11;
            int n18 = 32;
            l10 <<= n18;
            long l11 = 0xFFFFFFFFL;
            long l12 = n17;
            long l13 = l12 & l11;
            lArray[n15] = l10 |= l13;
        }
        this.threshold = n12;
        this.table = nArray2;
    }

    private static long swapNext(long l10, int n10) {
        long l11 = (long)n10 & 0xFFFFFFFFL;
        return (l10 &= 0xFFFFFFFF00000000L) | l11;
    }

    public void clear() {
        int n10;
        this.modCount = n10 = this.modCount + 1;
        Object[] objectArray = this.keys;
        int n11 = this.size;
        Arrays.fill(objectArray, 0, n11, null);
        objectArray = this.values;
        n11 = this.size;
        Arrays.fill((int[])objectArray, 0, n11, 0);
        Arrays.fill(this.table, -1);
        Arrays.fill(this.entries, (long)-1);
        this.size = 0;
    }

    public boolean containsKey(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public void ensureCapacity(int n10) {
        long[] lArray = this.entries;
        int n11 = lArray.length;
        if (n10 > n11) {
            this.resizeEntries(n10);
        }
        if (n10 >= (n11 = this.threshold)) {
            n11 = 2;
            n10 = Integer.highestOneBit(n10 + -1) << 1;
            n10 = Math.max(n11, n10);
            this.resizeTable(n10);
        }
    }

    public int firstIndex() {
        int n10 = this.size;
        n10 = n10 == 0 ? -1 : 0;
        return n10;
    }

    public int get(Object object) {
        int n10;
        int n11 = this.indexOf(object);
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            int[] nArray = this.values;
            n11 = nArray[n11];
        }
        return n11;
    }

    public Multiset$Entry getEntry(int n10) {
        int n11 = this.size;
        Preconditions.checkElementIndex(n10, n11);
        ObjectCountHashMap$MapEntry objectCountHashMap$MapEntry = new ObjectCountHashMap$MapEntry(this, n10);
        return objectCountHashMap$MapEntry;
    }

    public Object getKey(int n10) {
        int n11 = this.size;
        Preconditions.checkElementIndex(n10, n11);
        return this.keys[n10];
    }

    public int getValue(int n10) {
        int n11 = this.size;
        Preconditions.checkElementIndex(n10, n11);
        return this.values[n10];
    }

    public int indexOf(Object object) {
        int n10 = Hashing.smearedHash(object);
        int[] nArray = this.table;
        int n11 = this.hashTableMask() & n10;
        int n12 = nArray[n11];
        while (n12 != (n11 = -1)) {
            Object object2 = this.entries;
            long l10 = object2[n12];
            n11 = ObjectCountHashMap.getHash(l10);
            if (n11 == n10 && (n11 = (int)(Objects.equal(object, object2 = (Object)this.keys[n12]) ? 1 : 0)) != 0) {
                return n12;
            }
            n12 = ObjectCountHashMap.getNext(l10);
        }
        return n11;
    }

    public void init(int n10, float f10) {
        Object[] objectArray;
        int n11;
        int n12 = 0;
        int n13 = 1;
        if (n10 >= 0) {
            n11 = n13;
        } else {
            n11 = 0;
            objectArray = null;
        }
        String string2 = "Initial capacity must be non-negative";
        Preconditions.checkArgument(n11 != 0, string2);
        objectArray = null;
        float f11 = f10 - 0.0f;
        n11 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (n11 > 0) {
            n12 = n13;
        }
        Preconditions.checkArgument(n12 != 0, "Illegal load factor");
        double d10 = f10;
        n12 = Hashing.closedTableSize(n10, d10);
        objectArray = ObjectCountHashMap.newTable(n12);
        this.table = objectArray;
        this.loadFactor = f10;
        objectArray = new Object[n10];
        this.keys = objectArray;
        objectArray = new int[n10];
        this.values = objectArray;
        long[] lArray = ObjectCountHashMap.newEntries(n10);
        this.entries = lArray;
        n10 = (int)((float)n12 * f10);
        this.threshold = n10 = Math.max(n13, n10);
    }

    public void insertEntry(int n10, Object object, int n11, int n12) {
        long l10;
        long[] lArray = this.entries;
        lArray[n10] = l10 = (long)n12 << 32 | 0xFFFFFFFFL;
        this.keys[n10] = object;
        this.values[n10] = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void moveLastEntry(int n10) {
        int n11 = this.size() + -1;
        long l10 = -1;
        int n12 = 0;
        long[] lArray = null;
        if (n10 < n11) {
            long l11;
            Object object;
            Object object2;
            Object[] objectArray = this.keys;
            objectArray[n10] = object2 = objectArray[n11];
            object2 = this.values;
            object2[n10] = object = object2[n11];
            objectArray[n11] = null;
            object2[n11] = false;
            lArray = this.entries;
            lArray[n10] = l11 = lArray[n11];
            lArray[n11] = l10;
            int n13 = ObjectCountHashMap.getHash(l11);
            int[] nArray = this.table;
            int n14 = this.hashTableMask();
            n12 = nArray[n13 &= n14];
            if (n12 == n11) {
                nArray[n13] = n10;
                return;
            }
            while (true) {
                long[] lArray2;
                if ((n13 = ObjectCountHashMap.getNext(l11 = (lArray2 = this.entries)[n12])) == n11) {
                    long[] lArray3 = this.entries;
                    lArray3[n12] = l10 = ObjectCountHashMap.swapNext(l11, n10);
                    return;
                }
                n12 = n13;
            }
        }
        this.keys[n10] = null;
        this.values[n10] = 0;
        long[] lArray4 = this.entries;
        lArray4[n10] = l10;
    }

    public int nextIndex(int n10) {
        int n11 = this.size;
        if (++n10 >= n11) {
            n10 = -1;
        }
        return n10;
    }

    public int nextIndexAfterRemove(int n10, int n11) {
        return n10 + -1;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int put(Object object, int n10) {
        CollectPreconditions.checkPositive(n10, "count");
        long[] lArray = this.entries;
        Object[] objectArray = this.keys;
        int[] nArray = this.values;
        int n11 = Hashing.smearedHash(object);
        int n12 = this.hashTableMask() & n11;
        int n13 = this.size;
        int[] nArray2 = this.table;
        int n14 = nArray2[n12];
        int n15 = -1;
        if (n14 == n15) {
            nArray2[n12] = n13;
        } else {
            while (true) {
                Object object2;
                long l10;
                if ((n12 = ObjectCountHashMap.getHash(l10 = lArray[n14])) == n11 && (n12 = (int)(Objects.equal(object, object2 = objectArray[n14]) ? 1 : 0)) != 0) {
                    int n16 = nArray[n14];
                    nArray[n14] = n10;
                    return n16;
                }
                n12 = ObjectCountHashMap.getNext(l10);
                if (n12 == n15) {
                    long l11;
                    lArray[n14] = l11 = ObjectCountHashMap.swapNext(l10, n13);
                    break;
                }
                n14 = n12;
            }
        }
        int n17 = -1 >>> 1;
        if (n13 == n17) {
            object = new IllegalStateException("Cannot contain more than Integer.MAX_VALUE elements!");
            throw object;
        }
        n17 = n13 + 1;
        this.resizeMeMaybe(n17);
        this.insertEntry(n13, object, n10, n11);
        this.size = n17;
        int n18 = this.threshold;
        if (n13 >= n18) {
            object = this.table;
            n18 = ((Object)object).length * 2;
            this.resizeTable(n18);
        }
        this.modCount = n18 = this.modCount + 1;
        return 0;
    }

    public int remove(Object object) {
        int n10 = Hashing.smearedHash(object);
        return this.remove(object, n10);
    }

    public int removeEntry(int n10) {
        Object object = this.keys[n10];
        n10 = ObjectCountHashMap.getHash(this.entries[n10]);
        return this.remove(object, n10);
    }

    public void resizeEntries(int n10) {
        Object[] objectArray = Arrays.copyOf(this.keys, n10);
        this.keys = objectArray;
        objectArray = Arrays.copyOf(this.values, n10);
        this.values = (int[])objectArray;
        objectArray = this.entries;
        int n11 = objectArray.length;
        objectArray = Arrays.copyOf((long[])objectArray, n10);
        if (n10 > n11) {
            long l10 = -1;
            Arrays.fill((long[])objectArray, n11, n10, l10);
        }
        this.entries = (long[])objectArray;
    }

    public void setValue(int n10, int n11) {
        int n12 = this.size;
        Preconditions.checkElementIndex(n10, n12);
        this.values[n10] = n11;
    }

    public int size() {
        return this.size;
    }
}

