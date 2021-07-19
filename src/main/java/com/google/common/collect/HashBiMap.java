/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.BiMap;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.HashBiMap$EntrySet;
import com.google.common.collect.HashBiMap$Inverse;
import com.google.common.collect.HashBiMap$KeySet;
import com.google.common.collect.HashBiMap$ValueSet;
import com.google.common.collect.Hashing;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.Serialization;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public final class HashBiMap
extends AbstractMap
implements BiMap,
Serializable {
    private static final int ABSENT = 255;
    private static final int ENDPOINT = 254;
    private transient Set entrySet;
    private transient int firstInInsertionOrder;
    private transient int[] hashTableKToV;
    private transient int[] hashTableVToK;
    private transient BiMap inverse;
    private transient Set keySet;
    public transient Object[] keys;
    private transient int lastInInsertionOrder;
    public transient int modCount;
    private transient int[] nextInBucketKToV;
    private transient int[] nextInBucketVToK;
    private transient int[] nextInInsertionOrder;
    private transient int[] prevInInsertionOrder;
    public transient int size;
    private transient Set valueSet;
    public transient Object[] values;

    private HashBiMap(int n10) {
        this.init(n10);
    }

    public static /* synthetic */ int access$000(HashBiMap hashBiMap) {
        return hashBiMap.firstInInsertionOrder;
    }

    public static /* synthetic */ int[] access$100(HashBiMap hashBiMap) {
        return hashBiMap.nextInInsertionOrder;
    }

    public static /* synthetic */ void access$200(HashBiMap hashBiMap, int n10, Object object, boolean bl2) {
        hashBiMap.replaceValueInEntry(n10, object, bl2);
    }

    public static /* synthetic */ BiMap access$302(HashBiMap hashBiMap, BiMap biMap) {
        hashBiMap.inverse = biMap;
        return biMap;
    }

    public static /* synthetic */ void access$400(HashBiMap hashBiMap, int n10, Object object, boolean bl2) {
        hashBiMap.replaceKeyInEntry(n10, object, bl2);
    }

    private int bucket(int n10) {
        int n11 = this.hashTableKToV.length + -1;
        return n10 & n11;
    }

    public static HashBiMap create() {
        return HashBiMap.create(16);
    }

    public static HashBiMap create(int n10) {
        HashBiMap hashBiMap = new HashBiMap(n10);
        return hashBiMap;
    }

    public static HashBiMap create(Map map) {
        HashBiMap hashBiMap = HashBiMap.create(map.size());
        hashBiMap.putAll(map);
        return hashBiMap;
    }

    private static int[] createFilledWithAbsent(int n10) {
        int[] nArray = new int[n10];
        Arrays.fill(nArray, -1);
        return nArray;
    }

    private void deleteFromTableKToV(int n10, int n11) {
        int[] nArray;
        int n12;
        int n13 = -1;
        if (n10 != n13) {
            n12 = 1;
        } else {
            n12 = 0;
            nArray = null;
        }
        Preconditions.checkArgument(n12 != 0);
        n11 = this.bucket(n11);
        nArray = this.hashTableKToV;
        int n14 = nArray[n11];
        if (n14 == n10) {
            int n15;
            int[] nArray2 = this.nextInBucketKToV;
            nArray[n11] = n15 = nArray2[n10];
            nArray2[n10] = n13;
            return;
        }
        n11 = nArray[n11];
        nArray = this.nextInBucketKToV;
        n12 = nArray[n11];
        while (true) {
            int n16 = n12;
            n12 = n11;
            n11 = n16;
            if (n16 == n13) break;
            if (n16 == n10) {
                int[] nArray3 = this.nextInBucketKToV;
                nArray3[n12] = n14 = nArray3[n10];
                nArray3[n10] = n13;
                return;
            }
            nArray = this.nextInBucketKToV;
            n12 = nArray[n16];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected to find entry with key ");
        Object object = this.keys[n10];
        stringBuilder.append(object);
        object = stringBuilder.toString();
        AssertionError assertionError = new AssertionError(object);
        throw assertionError;
    }

    private void deleteFromTableVToK(int n10, int n11) {
        int[] nArray;
        int n12;
        int n13 = -1;
        if (n10 != n13) {
            n12 = 1;
        } else {
            n12 = 0;
            nArray = null;
        }
        Preconditions.checkArgument(n12 != 0);
        n11 = this.bucket(n11);
        nArray = this.hashTableVToK;
        int n14 = nArray[n11];
        if (n14 == n10) {
            int n15;
            int[] nArray2 = this.nextInBucketVToK;
            nArray[n11] = n15 = nArray2[n10];
            nArray2[n10] = n13;
            return;
        }
        n11 = nArray[n11];
        nArray = this.nextInBucketVToK;
        n12 = nArray[n11];
        while (true) {
            int n16 = n12;
            n12 = n11;
            n11 = n16;
            if (n16 == n13) break;
            if (n16 == n10) {
                int[] nArray3 = this.nextInBucketVToK;
                nArray3[n12] = n14 = nArray3[n10];
                nArray3[n10] = n13;
                return;
            }
            nArray = this.nextInBucketVToK;
            n12 = nArray[n16];
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Expected to find entry with value ");
        Object object = this.values[n10];
        stringBuilder.append(object);
        object = stringBuilder.toString();
        AssertionError assertionError = new AssertionError(object);
        throw assertionError;
    }

    private void ensureCapacity(int n10) {
        Object[] objectArray;
        int n11;
        Object object = this.nextInBucketKToV;
        int n12 = ((int[])object).length;
        if (n12 < n10) {
            n11 = ImmutableCollection$Builder.expandedCapacity(((int[])object).length, n10);
            objectArray = Arrays.copyOf(this.keys, n11);
            this.keys = objectArray;
            objectArray = Arrays.copyOf(this.values, n11);
            this.values = objectArray;
            objectArray = HashBiMap.expandAndFillWithAbsent(this.nextInBucketKToV, n11);
            this.nextInBucketKToV = (int[])objectArray;
            objectArray = HashBiMap.expandAndFillWithAbsent(this.nextInBucketVToK, n11);
            this.nextInBucketVToK = (int[])objectArray;
            objectArray = HashBiMap.expandAndFillWithAbsent(this.prevInInsertionOrder, n11);
            this.prevInInsertionOrder = (int[])objectArray;
            objectArray = this.nextInInsertionOrder;
            object = HashBiMap.expandAndFillWithAbsent((int[])objectArray, n11);
            this.nextInInsertionOrder = object;
        }
        if ((n11 = ((int[])(object = this.hashTableKToV)).length) < n10) {
            double d10 = 1.0;
            n10 = Hashing.closedTableSize(n10, d10);
            object = HashBiMap.createFilledWithAbsent(n10);
            this.hashTableKToV = object;
            int[] nArray = HashBiMap.createFilledWithAbsent(n10);
            this.hashTableVToK = nArray;
            n10 = 0;
            nArray = null;
            while (n10 < (n11 = this.size)) {
                n11 = Hashing.smearedHash(this.keys[n10]);
                n11 = this.bucket(n11);
                objectArray = this.nextInBucketKToV;
                int[] nArray2 = this.hashTableKToV;
                int n13 = nArray2[n11];
                objectArray[n10] = n13;
                nArray2[n11] = n10;
                object = this.values[n10];
                n11 = Hashing.smearedHash(object);
                n11 = this.bucket(n11);
                objectArray = this.nextInBucketVToK;
                nArray2 = this.hashTableVToK;
                n13 = nArray2[n11];
                objectArray[n10] = n13;
                nArray2[n11] = n10++;
            }
        }
    }

    private static int[] expandAndFillWithAbsent(int[] nArray, int n10) {
        int n11 = nArray.length;
        nArray = Arrays.copyOf(nArray, n10);
        Arrays.fill(nArray, n11, n10, -1);
        return nArray;
    }

    private void insertIntoTableKToV(int n10, int n11) {
        int n12;
        int[] nArray;
        int n13 = -1;
        if (n10 != n13) {
            n13 = 1;
        } else {
            n13 = 0;
            nArray = null;
        }
        Preconditions.checkArgument(n13 != 0);
        n11 = this.bucket(n11);
        nArray = this.nextInBucketKToV;
        int[] nArray2 = this.hashTableKToV;
        nArray[n10] = n12 = nArray2[n11];
        nArray2[n11] = n10;
    }

    private void insertIntoTableVToK(int n10, int n11) {
        int n12;
        int[] nArray;
        int n13 = -1;
        if (n10 != n13) {
            n13 = 1;
        } else {
            n13 = 0;
            nArray = null;
        }
        Preconditions.checkArgument(n13 != 0);
        n11 = this.bucket(n11);
        nArray = this.nextInBucketVToK;
        int[] nArray2 = this.hashTableVToK;
        nArray[n10] = n12 = nArray2[n11];
        nArray2[n11] = n10;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void moveEntryToIndex(int var1_1, int var2_2) {
        block6: {
            if (var1_1 == var2_2) {
                return;
            }
            var3_3 /* !! */  = this.prevInInsertionOrder[var1_1];
            var4_4 /* !! */  = this.nextInInsertionOrder[var1_1];
            this.setSucceeds(var3_3 /* !! */ , var2_2);
            this.setSucceeds(var2_2, var4_4 /* !! */ );
            var5_5 /* !! */  = this.keys;
            var6_6 = var5_5 /* !! */ [var1_1];
            var7_7 /* !! */  = this.values;
            var8_8 = var7_7 /* !! */ [var1_1];
            var5_5 /* !! */ [var2_2] = var6_6;
            var7_7 /* !! */ [var2_2] = var8_8;
            var3_3 /* !! */  = Hashing.smearedHash(var6_6);
            var3_3 /* !! */  = this.bucket(var3_3 /* !! */ );
            var6_6 = this.hashTableKToV;
            var9_9 /* !! */  = var6_6[var3_3 /* !! */ ];
            if (var9_9 /* !! */  != var1_1) break block6;
            var6_6[var3_3 /* !! */ ] = var2_2;
            ** GOTO lbl31
        }
        var3_3 /* !! */  = (int)var6_6[var3_3 /* !! */ ];
        var6_6 = this.nextInBucketKToV;
        var4_4 /* !! */  = (int)var6_6[var3_3 /* !! */ ];
        while (true) {
            block7: {
                block8: {
                    var10_10 /* !! */  = var4_4 /* !! */ ;
                    var4_4 /* !! */  = var3_3 /* !! */ ;
                    var3_3 /* !! */  = var10_10 /* !! */ ;
                    if (var10_10 /* !! */  != var1_1) break block7;
                    var5_5 /* !! */  = this.nextInBucketKToV;
                    var5_5 /* !! */ [var4_4 /* !! */ ] = var2_2;
lbl31:
                    // 2 sources

                    var5_5 /* !! */  = this.nextInBucketKToV;
                    var4_4 /* !! */  = (int)var5_5 /* !! */ [var1_1];
                    var5_5 /* !! */ [var2_2] = var4_4 /* !! */ ;
                    var4_4 /* !! */  = -1;
                    var5_5 /* !! */ [var1_1] = var4_4 /* !! */ ;
                    var3_3 /* !! */  = Hashing.smearedHash(var8_8);
                    var3_3 /* !! */  = this.bucket(var3_3 /* !! */ );
                    var7_7 /* !! */  = this.hashTableVToK;
                    var11_11 = var7_7 /* !! */ [var3_3 /* !! */ ];
                    if (var11_11 != var1_1) break block8;
                    var7_7 /* !! */ [var3_3 /* !! */ ] = var2_2;
                    ** GOTO lbl54
                }
                var3_3 /* !! */  = (int)var7_7 /* !! */ [var3_3 /* !! */ ];
                var7_7 /* !! */  = this.nextInBucketVToK;
                var9_9 /* !! */  = var7_7 /* !! */ [var3_3 /* !! */ ];
                while (true) {
                    block9: {
                        var10_10 /* !! */  = (int)var9_9 /* !! */ ;
                        var9_9 /* !! */  = var3_3 /* !! */ ;
                        var3_3 /* !! */  = var10_10 /* !! */ ;
                        if (var10_10 /* !! */  != var1_1) break block9;
                        var5_5 /* !! */  = this.nextInBucketVToK;
                        var5_5 /* !! */ [var9_9 /* !! */ ] = var2_2;
lbl54:
                        // 2 sources

                        var5_5 /* !! */  = this.nextInBucketVToK;
                        var5_5 /* !! */ [var2_2] = var9_9 /* !! */  = var5_5 /* !! */ [var1_1];
                        var5_5 /* !! */ [var1_1] = var4_4 /* !! */ ;
                        return;
                    }
                    var7_7 /* !! */  = this.nextInBucketVToK;
                    var9_9 /* !! */  = var7_7 /* !! */ [var10_10 /* !! */ ];
                }
            }
            var6_6 = this.nextInBucketKToV;
            var4_4 /* !! */  = (int)var6_6[var10_10 /* !! */ ];
        }
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        int n10 = Serialization.readCount(objectInputStream);
        this.init(16);
        Serialization.populateMap(this, objectInputStream, n10);
    }

    private void removeEntry(int n10, int n11, int n12) {
        int n13 = 1;
        int n14 = -1;
        n14 = n10 != n14 ? n13 : 0;
        Preconditions.checkArgument(n14 != 0);
        this.deleteFromTableKToV(n10, n11);
        this.deleteFromTableVToK(n10, n12);
        n11 = this.prevInInsertionOrder[n10];
        n12 = this.nextInInsertionOrder[n10];
        this.setSucceeds(n11, n12);
        n11 = this.size - n13;
        this.moveEntryToIndex(n11, n10);
        Object[] objectArray = this.keys;
        n11 = this.size;
        n12 = n11 + -1;
        objectArray[n12] = null;
        objectArray = this.values;
        n12 = n11 + -1;
        objectArray[n12] = null;
        this.size = n11 -= n13;
        this.modCount = n10 = this.modCount + n13;
    }

    private void replaceKeyInEntry(int n10, Object object, boolean n11) {
        int[] nArray;
        int n12 = -1;
        int n13 = n10 != n12 ? 1 : 0;
        Preconditions.checkArgument(n13 != 0);
        n13 = Hashing.smearedHash(object);
        int n14 = this.findEntryByKey(object, n13);
        int n15 = this.lastInInsertionOrder;
        int n16 = -2;
        if (n14 != n12) {
            if (n11 != 0) {
                n15 = this.prevInInsertionOrder[n14];
                nArray = this.nextInInsertionOrder;
                n16 = nArray[n14];
                this.removeEntryKeyHashKnown(n14, n13);
                n11 = this.size;
                if (n10 == n11) {
                    n10 = n14;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Key already present in map: ");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
        }
        if (n15 == n10) {
            nArray = this.prevInInsertionOrder;
            n15 = nArray[n10];
        } else {
            n11 = this.size;
            if (n15 == n11) {
                n15 = n14;
            }
        }
        if (n16 == n10) {
            nArray = this.nextInInsertionOrder;
            n14 = nArray[n10];
        } else {
            n11 = this.size;
            if (n16 != n11) {
                n14 = n16;
            }
        }
        n11 = this.prevInInsertionOrder[n10];
        n12 = this.nextInInsertionOrder[n10];
        this.setSucceeds(n11, n12);
        n11 = Hashing.smearedHash(this.keys[n10]);
        this.deleteFromTableKToV(n10, n11);
        this.keys[n10] = object;
        int n17 = Hashing.smearedHash(object);
        this.insertIntoTableKToV(n10, n17);
        this.setSucceeds(n15, n10);
        this.setSucceeds(n10, n14);
    }

    private void replaceValueInEntry(int n10, Object object, boolean n11) {
        int n12 = -1;
        int n13 = n10 != n12 ? 1 : 0;
        Preconditions.checkArgument(n13 != 0);
        n13 = Hashing.smearedHash(object);
        int n14 = this.findEntryByValue(object, n13);
        if (n14 != n12) {
            if (n11 != 0) {
                this.removeEntryValueHashKnown(n14, n13);
                n11 = this.size;
                if (n10 == n11) {
                    n10 = n14;
                }
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Value already present in map: ");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
                throw illegalArgumentException;
            }
        }
        n11 = Hashing.smearedHash(this.values[n10]);
        this.deleteFromTableVToK(n10, n11);
        this.values[n10] = object;
        this.insertIntoTableVToK(n10, n13);
    }

    private void setSucceeds(int n10, int n11) {
        int n12 = -2;
        if (n10 == n12) {
            this.firstInInsertionOrder = n11;
        } else {
            int[] nArray = this.nextInInsertionOrder;
            nArray[n10] = n11;
        }
        if (n11 == n12) {
            this.lastInInsertionOrder = n10;
        } else {
            int[] nArray = this.prevInInsertionOrder;
            nArray[n11] = n10;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMap(this, objectOutputStream);
    }

    public void clear() {
        int n10;
        Object[] objectArray = this.keys;
        int n11 = this.size;
        Arrays.fill(objectArray, 0, n11, null);
        objectArray = this.values;
        n11 = this.size;
        Arrays.fill(objectArray, 0, n11, null);
        objectArray = this.hashTableKToV;
        n11 = -1;
        Arrays.fill((int[])objectArray, n11);
        Arrays.fill(this.hashTableVToK, n11);
        objectArray = this.nextInBucketKToV;
        int n12 = this.size;
        Arrays.fill((int[])objectArray, 0, n12, n11);
        objectArray = this.nextInBucketVToK;
        n12 = this.size;
        Arrays.fill((int[])objectArray, 0, n12, n11);
        objectArray = this.prevInInsertionOrder;
        n12 = this.size;
        Arrays.fill((int[])objectArray, 0, n12, n11);
        objectArray = this.nextInInsertionOrder;
        n12 = this.size;
        Arrays.fill((int[])objectArray, 0, n12, n11);
        this.size = 0;
        this.firstInInsertionOrder = n10 = -2;
        this.lastInInsertionOrder = n10;
        this.modCount = n10 = this.modCount + 1;
    }

    public boolean containsKey(Object object) {
        int n10;
        int n11 = this.findEntryByKey(object);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public boolean containsValue(Object object) {
        int n10;
        int n11 = this.findEntryByValue(object);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public Set entrySet() {
        Set set = this.entrySet;
        if (set == null) {
            this.entrySet = set = new HashBiMap$EntrySet(this);
        }
        return set;
    }

    public int findEntry(Object object, int n10, int[] object2, int[] nArray, Object[] objectArray) {
        int n11;
        n10 = this.bucket(n10);
        n10 = object2[n10];
        while (n10 != (n11 = -1)) {
            object2 = objectArray[n10];
            n11 = (int)(Objects.equal(object2, object) ? 1 : 0);
            if (n11 != 0) {
                return n10;
            }
            n10 = nArray[n10];
        }
        return n11;
    }

    public int findEntryByKey(Object object) {
        int n10 = Hashing.smearedHash(object);
        return this.findEntryByKey(object, n10);
    }

    public int findEntryByKey(Object object, int n10) {
        int[] nArray = this.hashTableKToV;
        int[] nArray2 = this.nextInBucketKToV;
        Object[] objectArray = this.keys;
        return this.findEntry(object, n10, nArray, nArray2, objectArray);
    }

    public int findEntryByValue(Object object) {
        int n10 = Hashing.smearedHash(object);
        return this.findEntryByValue(object, n10);
    }

    public int findEntryByValue(Object object, int n10) {
        int[] nArray = this.hashTableVToK;
        int[] nArray2 = this.nextInBucketVToK;
        Object[] objectArray = this.values;
        return this.findEntry(object, n10, nArray, nArray2, objectArray);
    }

    public Object forcePut(Object object, Object object2) {
        return this.put(object, object2, true);
    }

    public Object get(Object object) {
        int n10;
        int n11 = this.findEntryByKey(object);
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            Object[] objectArray = this.values;
            object = objectArray[n11];
        }
        return object;
    }

    public Object getInverse(Object object) {
        int n10;
        int n11 = this.findEntryByValue(object);
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            Object[] objectArray = this.keys;
            object = objectArray[n11];
        }
        return object;
    }

    public void init(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedSize");
        int n11 = Hashing.closedTableSize(n10, 1.0);
        this.size = 0;
        Object[] objectArray = new Object[n10];
        this.keys = objectArray;
        objectArray = new Object[n10];
        this.values = objectArray;
        objectArray = HashBiMap.createFilledWithAbsent(n11);
        this.hashTableKToV = (int[])objectArray;
        int[] nArray = HashBiMap.createFilledWithAbsent(n11);
        this.hashTableVToK = nArray;
        nArray = HashBiMap.createFilledWithAbsent(n10);
        this.nextInBucketKToV = nArray;
        nArray = HashBiMap.createFilledWithAbsent(n10);
        this.nextInBucketVToK = nArray;
        this.firstInInsertionOrder = n11 = -2;
        this.lastInInsertionOrder = n11;
        nArray = HashBiMap.createFilledWithAbsent(n10);
        this.prevInInsertionOrder = nArray;
        int[] nArray2 = HashBiMap.createFilledWithAbsent(n10);
        this.nextInInsertionOrder = nArray2;
    }

    public BiMap inverse() {
        BiMap biMap = this.inverse;
        if (biMap == null) {
            this.inverse = biMap = new HashBiMap$Inverse(this);
        }
        return biMap;
    }

    public Set keySet() {
        Set set = this.keySet;
        if (set == null) {
            this.keySet = set = new HashBiMap$KeySet(this);
        }
        return set;
    }

    public Object put(Object object, Object object2) {
        return this.put(object, object2, false);
    }

    /*
     * WARNING - void declaration
     */
    public Object put(Object object, Object object2, boolean bl2) {
        Object[] objectArray;
        int n10;
        int n11 = Hashing.smearedHash(object);
        int n12 = this.findEntryByKey(object, n11);
        if (n12 != (n10 = -1)) {
            object = this.values[n12];
            n11 = (int)(Objects.equal(object, object2) ? 1 : 0);
            if (n11 != 0) {
                return object2;
            }
            this.replaceValueInEntry(n12, object2, bl2);
            return object;
        }
        n12 = Hashing.smearedHash(object2);
        int n13 = this.findEntryByValue(object2, n12);
        int n14 = 1;
        if (bl2) {
            if (n13 != n10) {
                this.removeEntryValueHashKnown(n13, n12);
            }
        } else {
            void var3_6;
            if (n13 == n10) {
                int n15 = n14;
            } else {
                boolean bl3 = false;
                objectArray = null;
            }
            String string2 = "Value already present: %s";
            Preconditions.checkArgument((boolean)var3_6, string2, object2);
        }
        int n16 = this.size + n14;
        this.ensureCapacity(n16);
        objectArray = this.keys;
        n10 = this.size;
        objectArray[n10] = object;
        this.values[n10] = object2;
        this.insertIntoTableKToV(n10, n11);
        int n17 = this.size;
        this.insertIntoTableVToK(n17, n12);
        n17 = this.lastInInsertionOrder;
        int n18 = this.size;
        this.setSucceeds(n17, n18);
        n17 = this.size;
        this.setSucceeds(n17, -2);
        this.size = n17 = this.size + n14;
        this.modCount = n17 = this.modCount + n14;
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public Object putInverse(Object object, Object objectArray, boolean bl2) {
        Object[] objectArray2;
        int n10;
        int n11 = Hashing.smearedHash(object);
        int n12 = this.findEntryByValue(object, n11);
        if (n12 != (n10 = -1)) {
            object = this.keys[n12];
            n11 = (int)(Objects.equal(object, objectArray) ? 1 : 0);
            if (n11 != 0) {
                return objectArray;
            }
            this.replaceKeyInEntry(n12, objectArray, bl2);
            return object;
        }
        n12 = this.lastInInsertionOrder;
        int n13 = Hashing.smearedHash(objectArray);
        int n14 = this.findEntryByKey(objectArray, n13);
        int n15 = 1;
        if (bl2) {
            if (n14 != n10) {
                objectArray2 = this.prevInInsertionOrder;
                n12 = objectArray2[n14];
                this.removeEntryKeyHashKnown(n14, n13);
            }
        } else {
            void var3_6;
            if (n14 == n10) {
                int n16 = n15;
            } else {
                boolean bl3 = false;
                objectArray2 = null;
            }
            String string2 = "Key already present: %s";
            Preconditions.checkArgument((boolean)var3_6, string2, (Object)objectArray);
        }
        int n17 = this.size + n15;
        this.ensureCapacity(n17);
        objectArray2 = this.keys;
        n10 = this.size;
        objectArray2[n10] = (int)objectArray;
        objectArray = this.values;
        objectArray[n10] = object;
        this.insertIntoTableKToV(n10, n13);
        Object object2 = this.size;
        this.insertIntoTableVToK((int)object2, n11);
        object2 = -2;
        if (n12 == object2) {
            object2 = this.firstInInsertionOrder;
        } else {
            object = this.nextInInsertionOrder;
            object2 = object[n12];
        }
        int n18 = this.size;
        this.setSucceeds(n12, n18);
        n18 = this.size;
        this.setSucceeds(n18, (int)object2);
        this.size = object2 = this.size + n15;
        this.modCount = object2 = this.modCount + n15;
        return null;
    }

    public Object remove(Object object) {
        int n10;
        int n11 = Hashing.smearedHash(object);
        int n12 = this.findEntryByKey(object, n11);
        if (n12 == (n10 = -1)) {
            return null;
        }
        Object object2 = this.values[n12];
        this.removeEntryKeyHashKnown(n12, n11);
        return object2;
    }

    public void removeEntry(int n10) {
        int n11 = Hashing.smearedHash(this.keys[n10]);
        this.removeEntryKeyHashKnown(n10, n11);
    }

    public void removeEntryKeyHashKnown(int n10, int n11) {
        int n12 = Hashing.smearedHash(this.values[n10]);
        this.removeEntry(n10, n11, n12);
    }

    public void removeEntryValueHashKnown(int n10, int n11) {
        int n12 = Hashing.smearedHash(this.keys[n10]);
        this.removeEntry(n10, n12, n11);
    }

    public Object removeInverse(Object object) {
        int n10;
        int n11 = Hashing.smearedHash(object);
        int n12 = this.findEntryByValue(object, n11);
        if (n12 == (n10 = -1)) {
            return null;
        }
        Object object2 = this.keys[n12];
        this.removeEntryValueHashKnown(n12, n11);
        return object2;
    }

    public int size() {
        return this.size;
    }

    public Set values() {
        Set set = this.valueSet;
        if (set == null) {
            this.valueSet = set = new HashBiMap$ValueSet(this);
        }
        return set;
    }
}

