/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;
import java.util.ConcurrentModificationException;
import java.util.Map;

public class SimpleArrayMap {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean CONCURRENT_MODIFICATION_EXCEPTIONS = true;
    private static final boolean DEBUG = false;
    private static final String TAG = "ArrayMap";
    public static Object[] mBaseCache;
    public static int mBaseCacheSize;
    public static Object[] mTwiceBaseCache;
    public static int mTwiceBaseCacheSize;
    public Object[] mArray;
    public int[] mHashes;
    public int mSize;

    public SimpleArrayMap() {
        Object[] objectArray = ContainerHelpers.EMPTY_INTS;
        this.mHashes = objectArray;
        objectArray = ContainerHelpers.EMPTY_OBJECTS;
        this.mArray = objectArray;
        this.mSize = 0;
    }

    public SimpleArrayMap(int n10) {
        if (n10 == 0) {
            Object[] objectArray = ContainerHelpers.EMPTY_INTS;
            this.mHashes = objectArray;
            objectArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mArray = objectArray;
        } else {
            this.allocArrays(n10);
        }
        this.mSize = 0;
    }

    public SimpleArrayMap(SimpleArrayMap simpleArrayMap) {
        this();
        if (simpleArrayMap != null) {
            this.putAll(simpleArrayMap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void allocArrays(int n10) {
        Object object = SimpleArrayMap.class;
        int n11 = 1;
        int n12 = 8;
        if (n10 == n12) {
            synchronized (object) {
                Object[] objectArray = mTwiceBaseCache;
                if (objectArray != null) {
                    this.mArray = objectArray;
                    Object object2 = objectArray[0];
                    object2 = object2;
                    mTwiceBaseCache = object2;
                    object2 = objectArray[n11];
                    object2 = (int[])object2;
                    this.mHashes = (int[])object2;
                    objectArray[n11] = null;
                    objectArray[0] = null;
                    mTwiceBaseCacheSize = n10 = mTwiceBaseCacheSize - n11;
                    return;
                }
            }
        } else {
            n12 = 4;
            if (n10 == n12) {
                synchronized (object) {
                    Object[] objectArray = mBaseCache;
                    if (objectArray != null) {
                        this.mArray = objectArray;
                        Object object3 = objectArray[0];
                        object3 = object3;
                        mBaseCache = object3;
                        object3 = objectArray[n11];
                        object3 = (int[])object3;
                        this.mHashes = (int[])object3;
                        objectArray[n11] = null;
                        objectArray[0] = null;
                        mBaseCacheSize = n10 = mBaseCacheSize - n11;
                        return;
                    }
                }
            }
        }
        object = new int[n10];
        this.mHashes = (int[])object;
        Object[] objectArray = new Object[n10 << n11];
        this.mArray = objectArray;
    }

    private static int binarySearchHashes(int[] object, int n10, int n11) {
        try {
            return ContainerHelpers.binarySearch(object, n10, n11);
        }
        catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException) {
            object = new ConcurrentModificationException;
            object();
            throw object;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void freeArrays(int[] nArray, Object[] objectArray, int n10) {
        Class<SimpleArrayMap> clazz = SimpleArrayMap.class;
        int n11 = nArray.length;
        int n12 = 2;
        int n13 = 10;
        int n14 = 1;
        int n15 = 8;
        if (n11 == n15) {
            synchronized (clazz) {
                Object[] objectArray2;
                n11 = mTwiceBaseCacheSize;
                if (n11 >= n13) return;
                objectArray[0] = objectArray2 = mTwiceBaseCache;
                objectArray[n14] = nArray;
                int n16 = (n10 << 1) - n14;
                while (true) {
                    if (n16 < n12) {
                        mTwiceBaseCache = objectArray;
                        mTwiceBaseCacheSize = n16 = mTwiceBaseCacheSize + n14;
                        return;
                    }
                    objectArray[n16] = null;
                    n16 += -1;
                }
            }
        }
        n11 = nArray.length;
        n15 = 4;
        if (n11 != n15) return;
        synchronized (clazz) {
            Object[] objectArray3;
            n11 = mBaseCacheSize;
            if (n11 >= n13) return;
            objectArray[0] = objectArray3 = mBaseCache;
            objectArray[n14] = nArray;
            int n17 = (n10 << 1) - n14;
            while (true) {
                if (n17 < n12) {
                    mBaseCache = objectArray;
                    mBaseCacheSize = n17 = mBaseCacheSize + n14;
                    return;
                }
                objectArray[n17] = null;
                n17 += -1;
            }
        }
    }

    public void clear() {
        int n10 = this.mSize;
        if (n10 > 0) {
            int[] nArray = this.mHashes;
            Object[] objectArray = this.mArray;
            Object[] objectArray2 = ContainerHelpers.EMPTY_INTS;
            this.mHashes = objectArray2;
            objectArray2 = ContainerHelpers.EMPTY_OBJECTS;
            this.mArray = objectArray2;
            objectArray2 = null;
            this.mSize = 0;
            SimpleArrayMap.freeArrays(nArray, objectArray, n10);
        }
        if ((n10 = this.mSize) <= 0) {
            return;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public boolean containsKey(Object object) {
        int n10 = this.indexOfKey(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsValue(Object object) {
        int n10 = this.indexOfValue(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public void ensureCapacity(int n10) {
        Object[] objectArray;
        int n11 = this.mSize;
        int[] nArray = this.mHashes;
        int n12 = nArray.length;
        if (n12 < n10) {
            Object[] objectArray2 = this.mArray;
            this.allocArrays(n10);
            n10 = this.mSize;
            if (n10 > 0) {
                objectArray = this.mHashes;
                System.arraycopy(nArray, 0, objectArray, 0, n11);
                objectArray = this.mArray;
                int n13 = n11 << 1;
                System.arraycopy(objectArray2, 0, objectArray, 0, n13);
            }
            SimpleArrayMap.freeArrays(nArray, objectArray2, n11);
        }
        if ((n10 = this.mSize) == n11) {
            return;
        }
        objectArray = new ConcurrentModificationException();
        throw objectArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        block15: {
            int n12;
            int n10;
            boolean bl2;
            block16: {
                int n11;
                block14: {
                    block13: {
                        bl2 = true;
                        if (this == object) {
                            return bl2;
                        }
                        n10 = object instanceof SimpleArrayMap;
                        if (n10 == 0) break block13;
                        object = (SimpleArrayMap)object;
                        n10 = this.size();
                        if (n10 != (n11 = ((SimpleArrayMap)object).size())) {
                            return false;
                        }
                        break block14;
                    }
                    n10 = object instanceof Map;
                    if (n10 == 0) break block15;
                    object = (Map)object;
                    n10 = this.size();
                    if (n10 != (n12 = object.size())) {
                        return false;
                    }
                    break block16;
                }
                n10 = 0;
                try {
                    while (true) {
                        if (n10 >= (n11 = this.mSize)) {
                            return bl2;
                        }
                        Object object4 = this.keyAt(n10);
                        Object object3 = this.valueAt(n10);
                        Object object2 = ((SimpleArrayMap)object).get(object4);
                        if (object3 == null ? object2 != null || (n11 = (int)(((SimpleArrayMap)object).containsKey(object4) ? 1 : 0)) == 0 : (n11 = (int)(object3.equals(object2) ? 1 : 0)) == 0) {
                            return false;
                        }
                        ++n10;
                    }
                }
                catch (ClassCastException | NullPointerException runtimeException) {
                    return false;
                }
            }
            n10 = 0;
            try {
                while (true) {
                    if (n10 >= (n12 = this.mSize)) {
                        return bl2;
                    }
                    Object object6 = this.keyAt(n10);
                    Object object5 = this.valueAt(n10);
                    Object v10 = object.get(object6);
                    if (object5 == null ? v10 != null || (n12 = (int)(object.containsKey(object6) ? 1 : 0)) == 0 : (n12 = (int)(object5.equals(v10) ? 1 : 0)) == 0) {
                        return false;
                    }
                    ++n10;
                }
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        return false;
    }

    public Object get(Object object) {
        return this.getOrDefault(object, null);
    }

    public Object getOrDefault(Object object, Object object2) {
        int n10 = this.indexOfKey(object);
        if (n10 >= 0) {
            object2 = this.mArray;
            n10 = (n10 << 1) + 1;
            object2 = object2[n10];
        }
        return object2;
    }

    public int hashCode() {
        int[] nArray = this.mHashes;
        Object[] objectArray = this.mArray;
        int n10 = this.mSize;
        int n11 = 1;
        int n12 = 0;
        int n13 = 0;
        while (n12 < n10) {
            int n14;
            Object object = objectArray[n11];
            int n15 = nArray[n12];
            if (object == null) {
                n14 = 0;
                object = null;
            } else {
                n14 = object.hashCode();
            }
            n13 += (n14 ^= n15);
            ++n12;
            n11 += 2;
        }
        return n13;
    }

    public int indexOf(Object object, int n10) {
        Object object2;
        Object object3;
        int n11 = this.mSize;
        if (n11 == 0) {
            return -1;
        }
        int[] nArray = this.mHashes;
        int n12 = SimpleArrayMap.binarySearchHashes(nArray, n11, n10);
        if (n12 < 0) {
            return n12;
        }
        Object object4 = this.mArray;
        int n13 = n12 << 1;
        int n14 = object.equals(object4 = object4[n13]);
        if (n14 != 0) {
            return n12;
        }
        for (n14 = n12 + 1; n14 < n11 && (n13 = (object3 = this.mHashes)[n14]) == n10; ++n14) {
            object3 = this.mArray;
            int n15 = n14 << 1;
            n13 = object.equals(object3 = (Object)object3[n15]) ? 1 : 0;
            if (n13 == 0) continue;
            return n14;
        }
        n12 += -1;
        while (n12 >= 0 && (n11 = (object2 = this.mHashes)[n12]) == n10) {
            object2 = this.mArray;
            n13 = n12 << 1;
            n11 = object.equals(object2 = (Object)object2[n13]) ? 1 : 0;
            if (n11 != 0) {
                return n12;
            }
            n12 += -1;
        }
        return ~n14;
    }

    public int indexOfKey(Object object) {
        int n10;
        if (object == null) {
            n10 = this.indexOfNull();
        } else {
            int n11 = object.hashCode();
            n10 = this.indexOf(object, n11);
        }
        return n10;
    }

    public int indexOfNull() {
        Object object;
        Object object2;
        int n10 = this.mSize;
        if (n10 == 0) {
            return -1;
        }
        int[] nArray = this.mHashes;
        int n11 = 0;
        Object object3 = null;
        int n12 = SimpleArrayMap.binarySearchHashes(nArray, n10, 0);
        if (n12 < 0) {
            return n12;
        }
        object3 = this.mArray;
        int n13 = n12 << 1;
        if ((object3 = object3[n13]) == null) {
            return n12;
        }
        for (n11 = n12 + 1; n11 < n10 && (n13 = (object2 = this.mHashes)[n11]) == 0; ++n11) {
            object2 = this.mArray;
            int n14 = n11 << 1;
            if ((object2 = (Object)object2[n14]) != null) continue;
            return n11;
        }
        n12 += -1;
        while (n12 >= 0 && (n10 = (object = this.mHashes)[n12]) == 0) {
            object = this.mArray;
            n13 = n12 << 1;
            if ((object = (Object)object[n13]) == null) {
                return n12;
            }
            n12 += -1;
        }
        return ~n11;
    }

    public int indexOfValue(Object object) {
        int n10 = this.mSize * 2;
        Object[] objectArray = this.mArray;
        int n11 = 1;
        if (object == null) {
            for (int i10 = n11; i10 < n10; i10 += 2) {
                Object object2 = objectArray[i10];
                if (object2 != null) continue;
                return i10 >> n11;
            }
        } else {
            for (int i11 = n11; i11 < n10; i11 += 2) {
                Object object3 = objectArray[i11];
                boolean bl2 = object.equals(object3);
                if (!bl2) continue;
                return i11 >> 1;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.mSize;
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public Object keyAt(int n10) {
        Object[] objectArray = this.mArray;
        return objectArray[n10 <<= 1];
    }

    public Object put(Object object, Object object2) {
        Object[] objectArray;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14 = this.mSize;
        int n15 = 0;
        Object[] objectArray2 = null;
        if (object == null) {
            n13 = this.indexOfNull();
            n12 = 0;
        } else {
            n13 = object.hashCode();
            int n16 = this.indexOf(object, n13);
            n12 = n13;
            n13 = n16;
        }
        if (n13 >= 0) {
            int n17 = (n13 << 1) + 1;
            Object[] objectArray3 = this.mArray;
            objectArray2 = objectArray3[n17];
            objectArray3[n17] = object2;
            return objectArray2;
        }
        n13 ^= 0xFFFFFFFF;
        int[] nArray = this.mHashes;
        int n18 = nArray.length;
        if (n14 >= n18) {
            n18 = 4;
            n11 = 8;
            if (n14 >= n11) {
                n18 = (n14 >> 1) + n14;
            } else if (n14 >= n18) {
                n18 = n11;
            }
            Object[] objectArray4 = this.mArray;
            this.allocArrays(n18);
            n18 = this.mSize;
            if (n14 == n18) {
                Object[] objectArray5 = this.mHashes;
                int n19 = objectArray5.length;
                if (n19 > 0) {
                    n19 = nArray.length;
                    System.arraycopy(nArray, 0, objectArray5, 0, n19);
                    objectArray5 = this.mArray;
                    n19 = objectArray4.length;
                    System.arraycopy(objectArray4, 0, objectArray5, 0, n19);
                }
                SimpleArrayMap.freeArrays(nArray, objectArray4, n14);
            } else {
                object = new ConcurrentModificationException();
                throw object;
            }
        }
        if (n13 < n14) {
            objectArray2 = this.mHashes;
            n10 = n13 + 1;
            n18 = n14 - n13;
            System.arraycopy(objectArray2, n13, objectArray2, n10, n18);
            objectArray2 = this.mArray;
            n18 = n13 << 1;
            n11 = this.mSize - n13 << 1;
            System.arraycopy(objectArray2, n18, objectArray2, n10 <<= 1, n11);
        }
        if (n14 == (n15 = this.mSize) && n13 < (n10 = (objectArray = this.mHashes).length)) {
            objectArray[n13] = n12;
            objectArray = this.mArray;
            objectArray[n13 <<= 1] = (int)object;
            objectArray[++n13] = (int)object2;
            this.mSize = ++n15;
            return null;
        }
        object = new ConcurrentModificationException();
        throw object;
    }

    public void putAll(SimpleArrayMap objectArray) {
        int n10 = objectArray.mSize;
        int n11 = this.mSize + n10;
        this.ensureCapacity(n11);
        n11 = this.mSize;
        if (n11 == 0) {
            if (n10 > 0) {
                Object[] objectArray2 = objectArray.mHashes;
                int[] nArray = this.mHashes;
                System.arraycopy(objectArray2, 0, nArray, 0, n10);
                objectArray = objectArray.mArray;
                objectArray2 = this.mArray;
                int n12 = n10 << 1;
                System.arraycopy(objectArray, 0, objectArray2, 0, n12);
                this.mSize = n10;
            }
        } else {
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object = objectArray.keyAt(i10);
                Object object2 = objectArray.valueAt(i10);
                this.put(object, object2);
            }
        }
    }

    public Object putIfAbsent(Object object, Object object2) {
        Object object3 = this.get(object);
        if (object3 == null) {
            object3 = this.put(object, object2);
        }
        return object3;
    }

    public Object remove(Object object) {
        int n10 = this.indexOfKey(object);
        if (n10 >= 0) {
            return this.removeAt(n10);
        }
        return null;
    }

    public boolean remove(Object object, Object object2) {
        boolean bl2;
        Object object3;
        int n10 = this.indexOfKey(object);
        if (n10 >= 0 && (object2 == (object3 = this.valueAt(n10)) || object2 != null && (bl2 = object2.equals(object3)))) {
            this.removeAt(n10);
            return true;
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     */
    public Object removeAt(int n10) {
        Object[] objectArray = this.mArray;
        int n11 = n10 << 1;
        int n12 = n11 + 1;
        Object object = objectArray[n12];
        int n13 = this.mSize;
        int n14 = 0;
        Object[] objectArray2 = null;
        int n15 = 1;
        if (n13 <= n15) {
            SimpleArrayMap.freeArrays(this.mHashes, objectArray, n13);
            int[] nArray = ContainerHelpers.EMPTY_INTS;
            this.mHashes = nArray;
            Object[] objectArray3 = ContainerHelpers.EMPTY_OBJECTS;
            this.mArray = objectArray3;
        } else {
            int n16 = n13 + -1;
            int[] nArray = this.mHashes;
            int n17 = nArray.length;
            int n18 = 8;
            if (n17 > n18 && n13 < (n17 = nArray.length / 3)) {
                if (n13 > n18) {
                    n17 = n13 >> 1;
                    n18 = n13 + n17;
                }
                this.allocArrays(n18);
                n17 = this.mSize;
                if (n13 != n17) {
                    ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
                    throw concurrentModificationException;
                }
                if (n10 > 0) {
                    int[] nArray2 = this.mHashes;
                    System.arraycopy(nArray, 0, nArray2, 0, n10);
                    Object[] objectArray4 = this.mArray;
                    System.arraycopy(objectArray, 0, objectArray4, 0, n11);
                }
                if (n10 < n16) {
                    n14 = n10 + 1;
                    int[] nArray3 = this.mHashes;
                    n18 = n16 - n10;
                    System.arraycopy(nArray, n14, nArray3, n10, n18);
                    n10 = n14 << 1;
                    objectArray2 = this.mArray;
                    n15 = n18 << 1;
                    System.arraycopy(objectArray, n10, objectArray2, n11, n15);
                }
            } else {
                int n19;
                if (n10 < n16) {
                    n19 = n10 + 1;
                    n14 = n16 - n10;
                    System.arraycopy(nArray, n19, nArray, n10, n14);
                    Object[] objectArray5 = this.mArray;
                    System.arraycopy(objectArray5, n19 <<= n15, objectArray5, n11, n14 <<= n15);
                }
                Object[] objectArray6 = this.mArray;
                n19 = n16 << 1;
                n11 = 0;
                objectArray6[n19] = null;
                objectArray6[n19 += n15] = null;
            }
            n14 = n16;
        }
        n10 = this.mSize;
        if (n13 == n10) {
            this.mSize = n14;
            return object;
        }
        ConcurrentModificationException concurrentModificationException = new ConcurrentModificationException();
        throw concurrentModificationException;
    }

    public Object replace(Object object, Object object2) {
        int n10 = this.indexOfKey(object);
        if (n10 >= 0) {
            return this.setValueAt(n10, object2);
        }
        return null;
    }

    public boolean replace(Object object, Object object2, Object object3) {
        boolean bl2;
        Object object4;
        int n10 = this.indexOfKey(object);
        if (n10 >= 0 && ((object4 = this.valueAt(n10)) == object2 || object2 != null && (bl2 = object2.equals(object4)))) {
            this.setValueAt(n10, object3);
            return true;
        }
        return false;
    }

    public Object setValueAt(int n10, Object object) {
        n10 = (n10 << 1) + 1;
        Object[] objectArray = this.mArray;
        Object object2 = objectArray[n10];
        objectArray[n10] = object;
        return object2;
    }

    public int size() {
        return this.mSize;
    }

    public String toString() {
        char c10;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "{}";
        }
        int n10 = this.mSize * 28;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('{');
        for (n10 = 0; n10 < (c10 = this.mSize); ++n10) {
            Object object;
            if (n10 > 0) {
                object = ", ";
                stringBuilder.append((String)object);
            }
            object = this.keyAt(n10);
            String string2 = "(this Map)";
            if (object != this) {
                stringBuilder.append(object);
            } else {
                stringBuilder.append(string2);
            }
            c10 = '=';
            stringBuilder.append(c10);
            object = this.valueAt(n10);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            stringBuilder.append(string2);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object valueAt(int n10) {
        Object[] objectArray = this.mArray;
        n10 = (n10 << 1) + 1;
        return objectArray[n10];
    }
}

