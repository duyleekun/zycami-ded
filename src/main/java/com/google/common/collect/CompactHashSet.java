/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashSet$1;
import com.google.common.collect.CompactHashing;
import com.google.common.collect.Hashing;
import com.google.common.collect.ObjectArrays;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public class CompactHashSet
extends AbstractSet
implements Serializable {
    public transient Object[] elements;
    private transient int[] entries;
    private transient int metadata;
    private transient int size;
    private transient Object table;

    public CompactHashSet() {
        this.init(3);
    }

    public CompactHashSet(int n10) {
        this.init(n10);
    }

    public static /* synthetic */ int access$000(CompactHashSet compactHashSet) {
        return compactHashSet.metadata;
    }

    public static CompactHashSet create() {
        CompactHashSet compactHashSet = new CompactHashSet();
        return compactHashSet;
    }

    public static CompactHashSet create(Collection collection) {
        CompactHashSet compactHashSet = CompactHashSet.createWithExpectedSize(collection.size());
        compactHashSet.addAll(collection);
        return compactHashSet;
    }

    public static CompactHashSet create(Object ... objectArray) {
        CompactHashSet compactHashSet = CompactHashSet.createWithExpectedSize(objectArray.length);
        Collections.addAll(compactHashSet, objectArray);
        return compactHashSet;
    }

    public static CompactHashSet createWithExpectedSize(int n10) {
        CompactHashSet compactHashSet = new CompactHashSet(n10);
        return compactHashSet;
    }

    private int hashTableMask() {
        int n10 = this.metadata & 0x1F;
        int n11 = 1;
        return (n11 << n10) - n11;
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        int n10 = ((ObjectInputStream)object).readInt();
        if (n10 >= 0) {
            this.init(n10);
            Object var4_4 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = ((ObjectInputStream)object).readObject();
                this.add(object2);
            }
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid size: ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        object = new InvalidObjectException(string2);
        throw object;
    }

    private void resizeMeMaybe(int n10) {
        int[] nArray = this.entries;
        int n11 = nArray.length;
        if (n10 > n11) {
            int n12 = n11 >>> 1;
            int n13 = 1;
            n10 = Math.min(-1 >>> 2, n12 = Math.max(n13, n12) + n11 | n13);
            if (n10 != n11) {
                this.resizeEntries(n10);
            }
        }
    }

    private int resizeTable(int n10, int n11, int n12, int n13) {
        Object object = CompactHashing.createTable(n11);
        n11 += -1;
        if (n13 != 0) {
            CompactHashing.tableSet(object, n12 &= n11, ++n13);
        }
        Object object2 = this.table;
        int[] nArray = this.entries;
        for (int i10 = 0; i10 <= n10; ++i10) {
            int n14 = CompactHashing.tableGet(object2, i10);
            while (n14 != 0) {
                int n15 = n14 + -1;
                int n16 = nArray[n15];
                int n17 = CompactHashing.getHashPrefix(n16, n10) | i10;
                int n18 = n17 & n11;
                int n19 = CompactHashing.tableGet(object, n18);
                CompactHashing.tableSet(object, n18, n14);
                nArray[n15] = n14 = CompactHashing.maskCombine(n17, n19, n11);
                n14 = CompactHashing.getNext(n16, n10);
            }
        }
        this.table = object;
        this.setHashTableMask(n11);
        return n11;
    }

    private void setHashTableMask(int n10) {
        n10 = Integer.numberOfLeadingZeros(n10);
        n10 = 32 - n10;
        this.metadata = n10 = CompactHashing.maskCombine(this.metadata, n10, 31);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        int n10 = this.size;
        objectOutputStream.writeInt(n10);
        n10 = this.firstEntryIndex();
        while (n10 >= 0) {
            Object object = this.elements[n10];
            objectOutputStream.writeObject(object);
            n10 = this.getSuccessor(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    public boolean add(Object object) {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            this.allocArrays();
        }
        int[] nArray = this.entries;
        Object[] objectArray = this.elements;
        int n11 = this.size;
        int n12 = n11 + 1;
        int n13 = Hashing.smearedHash(object);
        int n14 = this.hashTableMask();
        int n15 = n13 & n14;
        Object object2 = this.table;
        int n16 = CompactHashing.tableGet(object2, n15);
        int n17 = 1;
        if (n16 == 0) {
            if (n12 > n14) {
                n10 = CompactHashing.newCapacity(n14);
                n14 = this.resizeTable(n14, n10, n13, n11);
            } else {
                Object object3 = this.table;
                CompactHashing.tableSet(object3, n15, n12);
            }
        } else {
            n15 = CompactHashing.getHashPrefix(n13, n14);
            while (true) {
                Object object4;
                int n18;
                int n19;
                if ((n19 = CompactHashing.getHashPrefix(n18 = nArray[n16 -= n17], n14)) == n15 && (n19 = (int)(Objects.equal(object, object4 = objectArray[n16]) ? 1 : 0)) != 0) {
                    return false;
                }
                n19 = CompactHashing.getNext(n18, n14);
                if (n19 == 0) {
                    int n20;
                    if (n12 > n14) {
                        n10 = CompactHashing.newCapacity(n14);
                        n14 = this.resizeTable(n14, n10, n13, n11);
                        break;
                    }
                    nArray[n16] = n20 = CompactHashing.maskCombine(n18, n12, n14);
                    break;
                }
                n16 = n19;
            }
        }
        this.resizeMeMaybe(n12);
        this.insertEntry(n11, object, n13, n14);
        this.size = n12;
        this.incrementModCount();
        return n17 != 0;
    }

    public int adjustAfterRemove(int n10, int n11) {
        return n10 + -1;
    }

    public int allocArrays() {
        Object object;
        Preconditions.checkState(this.needsAllocArrays(), "Arrays already allocated");
        int n10 = this.metadata;
        int n11 = CompactHashing.tableSize(n10);
        this.table = object = CompactHashing.createTable(n11);
        this.setHashTableMask(n11 += -1);
        Object[] objectArray = new int[n10];
        this.entries = objectArray;
        objectArray = new Object[n10];
        this.elements = objectArray;
        return n10;
    }

    public void clear() {
        boolean bl2 = this.needsAllocArrays();
        if (bl2) {
            return;
        }
        this.incrementModCount();
        Object[] objectArray = this.elements;
        int n10 = this.size;
        Arrays.fill(objectArray, 0, n10, null);
        CompactHashing.tableClear(this.table);
        objectArray = this.entries;
        n10 = this.size;
        Arrays.fill((int[])objectArray, 0, n10, 0);
        this.size = 0;
    }

    public boolean contains(Object object) {
        int n10;
        int n11;
        int n12 = this.needsAllocArrays();
        if (n12 != 0) {
            return false;
        }
        Object object2 = this.table;
        n12 = Hashing.smearedHash(object);
        int n13 = n12 & (n11 = this.hashTableMask());
        int n14 = CompactHashing.tableGet(object2, n13);
        if (n14 == 0) {
            return false;
        }
        n12 = CompactHashing.getHashPrefix(n12, n11);
        do {
            Object[] objectArray;
            int[] nArray;
            int n15;
            if ((n15 = CompactHashing.getHashPrefix(n10 = (nArray = this.entries)[n14 -= (n13 = 1)], n11)) != n12 || (n14 = (int)(Objects.equal(object, object2 = (objectArray = this.elements)[n14]) ? 1 : 0)) == 0) continue;
            return n13 != 0;
        } while ((n14 = CompactHashing.getNext(n10, n11)) != 0);
        return false;
    }

    public int firstEntryIndex() {
        int n10 = this.isEmpty();
        n10 = n10 != 0 ? -1 : 0;
        return n10;
    }

    public int getSuccessor(int n10) {
        int n11 = this.size;
        if (++n10 >= n11) {
            n10 = -1;
        }
        return n10;
    }

    public void incrementModCount() {
        int n10;
        this.metadata = n10 = this.metadata + 32;
    }

    public void init(int n10) {
        int n11 = 1;
        int n12 = n10 >= 0 ? n11 : 0;
        Preconditions.checkArgument(n12 != 0, "Expected size must be >= 0");
        n10 = Math.min(-1 >>> 2, n10);
        this.metadata = n10 = Math.max(n11, n10);
    }

    public void insertEntry(int n10, Object object, int n11, int n12) {
        int[] nArray = this.entries;
        nArray[n10] = n11 = CompactHashing.maskCombine(n11, 0, n12);
        this.elements[n10] = object;
    }

    public boolean isEmpty() {
        int n10 = this.size;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public Iterator iterator() {
        CompactHashSet$1 compactHashSet$1 = new CompactHashSet$1(this);
        return compactHashSet$1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void moveLastEntry(int n10, int n11) {
        int n12 = this.size() + -1;
        int n13 = 0;
        int[] nArray = null;
        int n14 = 0;
        Object var7_7 = null;
        if (n10 < n12) {
            int n15;
            Object object;
            Object[] objectArray = this.elements;
            objectArray[n10] = object = objectArray[n12];
            objectArray[n12] = null;
            int[] nArray2 = this.entries;
            nArray2[n10] = n15 = nArray2[n12];
            nArray2[n12] = 0;
            Object object2 = this.table;
            n13 = Hashing.smearedHash(object) & n11;
            n14 = CompactHashing.tableGet(object2, n13);
            if (n14 == ++n12) {
                Object object3 = this.table;
                CompactHashing.tableSet(object3, n13, ++n10);
                return;
            }
            while (true) {
                if ((n15 = CompactHashing.getNext(n13 = (nArray = this.entries)[n14 += -1], n11)) == n12) {
                    int[] nArray3 = this.entries;
                    ++n10;
                    nArray3[n14] = n10 = CompactHashing.maskCombine(n13, n10, n11);
                    return;
                }
                n14 = n15;
            }
        }
        this.elements[n10] = null;
        int[] nArray4 = this.entries;
        nArray4[n10] = 0;
    }

    public boolean needsAllocArrays() {
        boolean bl2;
        Object object = this.table;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean remove(Object object) {
        int n10;
        Object[] objectArray;
        int[] nArray;
        Object object2;
        int n11 = this.needsAllocArrays();
        if (n11 != 0) {
            return false;
        }
        n11 = this.hashTableMask();
        int n12 = CompactHashing.remove(object, null, n11, object2 = this.table, nArray = this.entries, objectArray = this.elements, null);
        if (n12 == (n10 = -1)) {
            return false;
        }
        this.moveLastEntry(n12, n11);
        n12 = this.size;
        n11 = 1;
        this.size = n12 -= n11;
        this.incrementModCount();
        return n11 != 0;
    }

    public void resizeEntries(int n10) {
        int[] nArray = Arrays.copyOf(this.entries, n10);
        this.entries = nArray;
        Object[] objectArray = Arrays.copyOf(this.elements, n10);
        this.elements = objectArray;
    }

    public int size() {
        return this.size;
    }

    public Object[] toArray() {
        boolean bl2 = this.needsAllocArrays();
        if (bl2) {
            return new Object[0];
        }
        Object[] objectArray = this.elements;
        int n10 = this.size;
        return Arrays.copyOf(objectArray, n10);
    }

    public Object[] toArray(Object[] objectArray) {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            n10 = objectArray.length;
            if (n10 > 0) {
                n10 = 0;
                Object var3_3 = null;
                objectArray[0] = null;
            }
            return objectArray;
        }
        Object[] objectArray2 = this.elements;
        int n11 = this.size;
        return ObjectArrays.toArrayImpl(objectArray2, 0, n11, objectArray);
    }

    public void trimToSize() {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return;
        }
        n10 = this.size;
        int[] nArray = this.entries;
        int n11 = nArray.length;
        if (n10 < n11) {
            this.resizeEntries(n10);
        }
        if ((n10 = CompactHashing.tableSize(n10)) < (n11 = this.hashTableMask())) {
            this.resizeTable(n11, n10, 0, 0);
        }
    }
}

