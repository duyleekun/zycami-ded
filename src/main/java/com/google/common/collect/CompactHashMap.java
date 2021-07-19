/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$2;
import com.google.common.collect.CompactHashMap$3;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactHashMap$KeySetView;
import com.google.common.collect.CompactHashMap$ValuesView;
import com.google.common.collect.CompactHashing;
import com.google.common.collect.Hashing;
import com.google.common.primitives.Ints;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CompactHashMap
extends AbstractMap
implements Serializable {
    public static final double HASH_FLOODING_FPP = 0.001;
    private static final int MAX_HASH_BUCKET_LENGTH = 9;
    private static final Object NOT_FOUND;
    public transient int[] entries;
    private transient Set entrySetView;
    private transient Set keySetView;
    public transient Object[] keys;
    private transient int metadata;
    private transient int size;
    private transient Object table;
    public transient Object[] values;
    private transient Collection valuesView;

    static {
        Object object;
        NOT_FOUND = object = new Object();
    }

    public CompactHashMap() {
        this.init(3);
    }

    public CompactHashMap(int n10) {
        this.init(n10);
    }

    public static /* synthetic */ int access$000(CompactHashMap compactHashMap) {
        return compactHashMap.metadata;
    }

    public static /* synthetic */ Object access$100(CompactHashMap compactHashMap, Object object) {
        return compactHashMap.removeHelper(object);
    }

    public static /* synthetic */ Object access$200() {
        return NOT_FOUND;
    }

    public static /* synthetic */ int access$400(CompactHashMap compactHashMap, Object object) {
        return compactHashMap.indexOf(object);
    }

    public static /* synthetic */ int access$500(CompactHashMap compactHashMap) {
        return compactHashMap.hashTableMask();
    }

    public static /* synthetic */ Object access$600(CompactHashMap compactHashMap) {
        return compactHashMap.table;
    }

    public static /* synthetic */ int access$710(CompactHashMap compactHashMap) {
        int n10;
        int n11 = compactHashMap.size;
        compactHashMap.size = n10 = n11 + -1;
        return n11;
    }

    public static CompactHashMap create() {
        CompactHashMap compactHashMap = new CompactHashMap();
        return compactHashMap;
    }

    public static CompactHashMap createWithExpectedSize(int n10) {
        CompactHashMap compactHashMap = new CompactHashMap(n10);
        return compactHashMap;
    }

    private int hashTableMask() {
        int n10 = this.metadata & 0x1F;
        int n11 = 1;
        return (n11 << n10) - n11;
    }

    private int indexOf(Object object) {
        int n10;
        int n11 = this.needsAllocArrays();
        int n12 = -1;
        if (n11 != 0) {
            return n12;
        }
        Object object2 = this.table;
        n11 = Hashing.smearedHash(object);
        int n13 = n11 & (n10 = this.hashTableMask());
        int n14 = CompactHashing.tableGet(object2, n13);
        if (n14 == 0) {
            return n12;
        }
        n11 = CompactHashing.getHashPrefix(n11, n10);
        do {
            Object object3;
            int[] nArray;
            int n15;
            if ((n15 = CompactHashing.getHashPrefix(n13 = (nArray = this.entries)[n14 += -1], n10)) != n11 || (n15 = (int)(Objects.equal(object, object3 = this.keys[n14]) ? 1 : 0)) == 0) continue;
            return n14;
        } while ((n14 = CompactHashing.getNext(n13, n10)) != 0);
        return n12;
    }

    private void readObject(ObjectInputStream object) {
        ((ObjectInputStream)object).defaultReadObject();
        int n10 = ((ObjectInputStream)object).readInt();
        if (n10 >= 0) {
            this.init(n10);
            Object var4_4 = null;
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = ((ObjectInputStream)object).readObject();
                Object object3 = ((ObjectInputStream)object).readObject();
                this.put(object2, object3);
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

    private Object removeHelper(Object object) {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return NOT_FOUND;
        }
        int n11 = this.hashTableMask();
        Object object2 = this.table;
        int[] nArray = this.entries;
        Object[] objectArray = this.keys;
        Object object3 = object;
        int n12 = CompactHashing.remove(object, null, n11, object2, nArray, objectArray, null);
        if (n12 == (n10 = -1)) {
            return NOT_FOUND;
        }
        object3 = this.values[n12];
        this.moveLastEntry(n12, n11);
        this.size = n12 = this.size + -1;
        this.incrementModCount();
        return object3;
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
        boolean bl2;
        objectOutputStream.defaultWriteObject();
        int n10 = this.size();
        objectOutputStream.writeInt(n10);
        Iterator iterator2 = this.entrySetIterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Object k10 = entry.getKey();
            objectOutputStream.writeObject(k10);
            entry = entry.getValue();
            objectOutputStream.writeObject(entry);
        }
    }

    public void accessEntry(int n10) {
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
        this.keys = objectArray;
        objectArray = new Object[n10];
        this.values = objectArray;
        return n10;
    }

    public void clear() {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return;
        }
        this.incrementModCount();
        Object[] objectArray = this.delegateOrNull();
        int n11 = 0;
        if (objectArray != null) {
            n10 = this.size();
            int n12 = 3;
            int n13 = -1 >>> 2;
            this.metadata = n10 = Ints.constrainToRange(n10, n12, n13);
            this.table = null;
            this.size = 0;
        } else {
            objectArray = this.keys;
            int n14 = this.size;
            Arrays.fill(objectArray, 0, n14, null);
            objectArray = this.values;
            n14 = this.size;
            Arrays.fill(objectArray, 0, n14, null);
            CompactHashing.tableClear(this.table);
            objectArray = this.entries;
            n11 = this.size;
            Arrays.fill((int[])objectArray, 0, n11, 0);
            this.size = 0;
        }
    }

    public boolean containsKey(Object object) {
        int n10;
        Map map = this.delegateOrNull();
        if (map != null) {
            n10 = map.containsKey(object);
        } else {
            int n11;
            n10 = this.indexOf(object);
            if (n10 != (n11 = -1)) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
        }
        return n10 != 0;
    }

    public boolean containsValue(Object object) {
        int n10;
        Map map = this.delegateOrNull();
        if (map != null) {
            return map.containsValue(object);
        }
        map = null;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            Object object2 = this.values[i10];
            n10 = (int)(Objects.equal(object, object2) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    public Map convertToHashFloodingResistantImplementation() {
        int n10 = this.hashTableMask() + 1;
        Map map = this.createHashFloodingResistantDelegate(n10);
        int n11 = this.firstEntryIndex();
        while (n11 >= 0) {
            Object object = this.keys[n11];
            Object object2 = this.values[n11];
            map.put(object, object2);
            n11 = this.getSuccessor(n11);
        }
        this.table = map;
        this.entries = null;
        this.keys = null;
        this.values = null;
        this.incrementModCount();
        return map;
    }

    public Set createEntrySet() {
        CompactHashMap$EntrySetView compactHashMap$EntrySetView = new CompactHashMap$EntrySetView(this);
        return compactHashMap$EntrySetView;
    }

    public Map createHashFloodingResistantDelegate(int n10) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10, 1.0f);
        return linkedHashMap;
    }

    public Set createKeySet() {
        CompactHashMap$KeySetView compactHashMap$KeySetView = new CompactHashMap$KeySetView(this);
        return compactHashMap$KeySetView;
    }

    public Collection createValues() {
        CompactHashMap$ValuesView compactHashMap$ValuesView = new CompactHashMap$ValuesView(this);
        return compactHashMap$ValuesView;
    }

    public Map delegateOrNull() {
        Object object = this.table;
        boolean bl2 = object instanceof Map;
        if (bl2) {
            return (Map)object;
        }
        return null;
    }

    public Set entrySet() {
        Set set = this.entrySetView;
        if (set == null) {
            this.entrySetView = set = this.createEntrySet();
        }
        return set;
    }

    public Iterator entrySetIterator() {
        Object object = this.delegateOrNull();
        if (object != null) {
            return object.entrySet().iterator();
        }
        object = new CompactHashMap$2(this);
        return object;
    }

    public int firstEntryIndex() {
        int n10 = this.isEmpty();
        n10 = n10 != 0 ? -1 : 0;
        return n10;
    }

    public Object get(Object object) {
        int n10;
        Map map = this.delegateOrNull();
        if (map != null) {
            return map.get(object);
        }
        int n11 = this.indexOf(object);
        if (n11 == (n10 = -1)) {
            return null;
        }
        this.accessEntry(n11);
        return this.values[n11];
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
        this.metadata = n10 = Ints.constrainToRange(n10, n11, -1 >>> 2);
    }

    public void insertEntry(int n10, Object object, Object object2, int n11, int n12) {
        int[] nArray = this.entries;
        nArray[n10] = n11 = CompactHashing.maskCombine(n11, 0, n12);
        this.keys[n10] = object;
        this.values[n10] = object2;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public Set keySet() {
        Set set = this.keySetView;
        if (set == null) {
            this.keySetView = set = this.createKeySet();
        }
        return set;
    }

    public Iterator keySetIterator() {
        Object object = this.delegateOrNull();
        if (object != null) {
            return object.keySet().iterator();
        }
        object = new CompactHashMap$1(this);
        return object;
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
            Object object2;
            Object[] objectArray = this.keys;
            objectArray[n10] = object2 = objectArray[n12];
            Object[] objectArray2 = this.values;
            objectArray2[n10] = object = objectArray2[n12];
            objectArray[n12] = null;
            objectArray2[n12] = null;
            int[] nArray2 = this.entries;
            nArray2[n10] = n15 = nArray2[n12];
            nArray2[n12] = 0;
            Object object3 = this.table;
            n13 = Hashing.smearedHash(object2) & n11;
            n14 = CompactHashing.tableGet(object3, n13);
            if (n14 == ++n12) {
                Object object4 = this.table;
                CompactHashing.tableSet(object4, n13, ++n10);
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
        this.keys[n10] = null;
        this.values[n10] = null;
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

    /*
     * Unable to fully structure code
     */
    public Object put(Object var1_1, Object var2_2) {
        block10: {
            block11: {
                var3_3 = this.needsAllocArrays();
                if (var3_3 != 0) {
                    this.allocArrays();
                }
                if ((var4_4 = this.delegateOrNull()) != null) {
                    return var4_4.put(var1_1, var2_2);
                }
                var4_4 = this.entries;
                var5_5 = this.keys;
                var6_6 = this.values;
                var7_7 = this.size;
                var8_8 = var7_7 + 1;
                var12_12 = this.table;
                var9_9 = Hashing.smearedHash(var1_1);
                var11_11 = var9_9 & (var10_10 = this.hashTableMask());
                var13_13 = CompactHashing.tableGet(var12_12, var11_11);
                if (var13_13 != 0) break block10;
                if (var8_8 <= var10_10) break block11;
                var3_3 = CompactHashing.newCapacity(var10_10);
                var3_3 = this.resizeTable(var10_10, var3_3, var9_9, var7_7);
lbl20:
                // 2 sources

                while (true) {
                    var14_14 = var3_3;
                    ** GOTO lbl49
                    break;
                }
            }
            var4_4 = this.table;
            CompactHashing.tableSet(var4_4, var11_11, var8_8);
            ** GOTO lbl48
        }
        var11_11 = CompactHashing.getHashPrefix(var9_9, var10_10);
        var14_14 = 0;
        while (true) {
            block12: {
                if ((var16_16 = CompactHashing.getHashPrefix((int)(var15_15 = var4_4[var13_13 += -1]), var10_10)) == var11_11 && (var16_16 = (int)Objects.equal(var1_1, var17_17 = var5_5[var13_13])) != 0) {
                    var1_1 = var6_6[var13_13];
                    var6_6[var13_13] = var2_2;
                    this.accessEntry(var13_13);
                    return var1_1;
                }
                var16_16 = CompactHashing.getNext((int)var15_15, var10_10);
                ++var14_14;
                if (var16_16 != 0) break block12;
                var18_18 = 9;
                if (var14_14 >= var18_18) {
                    return this.convertToHashFloodingResistantImplementation().put(var1_1, var2_2);
                }
                if (var8_8 > var10_10) {
                    var3_3 = CompactHashing.newCapacity(var10_10);
                    var3_3 = this.resizeTable(var10_10, var3_3, var9_9, var7_7);
                    ** continue;
                }
                var18_18 = CompactHashing.maskCombine((int)var15_15, var8_8, var10_10);
                var4_4[var13_13] = var18_18;
lbl48:
                // 2 sources

                var14_14 = var10_10;
lbl49:
                // 2 sources

                this.resizeMeMaybe(var8_8);
                var12_12 = var2_2;
                this.insertEntry(var7_7, var1_1, var2_2, var9_9, var14_14);
                this.size = var8_8;
                this.incrementModCount();
                return null;
            }
            var13_13 = var16_16;
        }
    }

    public Object remove(Object object) {
        Object object2 = this.delegateOrNull();
        if (object2 != null) {
            return object2.remove(object);
        }
        if ((object = this.removeHelper(object)) == (object2 = NOT_FOUND)) {
            object = null;
        }
        return object;
    }

    public void resizeEntries(int n10) {
        Object[] objectArray = Arrays.copyOf(this.entries, n10);
        this.entries = objectArray;
        objectArray = Arrays.copyOf(this.keys, n10);
        this.keys = objectArray;
        Object[] objectArray2 = Arrays.copyOf(this.values, n10);
        this.values = objectArray2;
    }

    public int size() {
        Map map = this.delegateOrNull();
        int n10 = map != null ? map.size() : this.size;
        return n10;
    }

    public void trimToSize() {
        int n10 = this.needsAllocArrays();
        if (n10 != 0) {
            return;
        }
        Map map = this.delegateOrNull();
        if (map != null) {
            int n11 = this.size();
            Map map2 = this.createHashFloodingResistantDelegate(n11);
            map2.putAll(map);
            this.table = map2;
            return;
        }
        n10 = this.size;
        int[] nArray = this.entries;
        int n12 = nArray.length;
        if (n10 < n12) {
            this.resizeEntries(n10);
        }
        if ((n10 = CompactHashing.tableSize(n10)) < (n12 = this.hashTableMask())) {
            this.resizeTable(n12, n10, 0, 0);
        }
    }

    public Collection values() {
        Collection collection = this.valuesView;
        if (collection == null) {
            this.valuesView = collection = this.createValues();
        }
        return collection;
    }

    public Iterator valuesIterator() {
        Object object = this.delegateOrNull();
        if (object != null) {
            return object.values().iterator();
        }
        object = new CompactHashMap$3(this);
        return object;
    }
}

