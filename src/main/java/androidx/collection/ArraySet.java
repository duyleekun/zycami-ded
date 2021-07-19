/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ArraySet$1;
import androidx.collection.ContainerHelpers;
import androidx.collection.MapCollections;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class ArraySet
implements Collection,
Set {
    private static final int BASE_SIZE = 4;
    private static final int CACHE_SIZE = 10;
    private static final boolean DEBUG = false;
    private static final int[] INT = new int[0];
    private static final Object[] OBJECT = new Object[0];
    private static final String TAG = "ArraySet";
    private static Object[] sBaseCache;
    private static int sBaseCacheSize;
    private static Object[] sTwiceBaseCache;
    private static int sTwiceBaseCacheSize;
    public Object[] mArray;
    private MapCollections mCollections;
    private int[] mHashes;
    public int mSize;

    public ArraySet() {
        this(0);
    }

    public ArraySet(int n10) {
        if (n10 == 0) {
            Object[] objectArray = INT;
            this.mHashes = objectArray;
            objectArray = OBJECT;
            this.mArray = objectArray;
        } else {
            this.allocArrays(n10);
        }
        this.mSize = 0;
    }

    public ArraySet(ArraySet arraySet) {
        this();
        if (arraySet != null) {
            this.addAll(arraySet);
        }
    }

    public ArraySet(Collection collection) {
        this();
        if (collection != null) {
            this.addAll(collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void allocArrays(int n10) {
        int[] nArray = null;
        int n11 = 1;
        int n12 = 8;
        if (n10 == n12) {
            Class<ArraySet> clazz = ArraySet.class;
            synchronized (clazz) {
                Object[] objectArray = sTwiceBaseCache;
                if (objectArray != null) {
                    this.mArray = objectArray;
                    Object object = objectArray[0];
                    object = object;
                    sTwiceBaseCache = object;
                    object = objectArray[n11];
                    object = (int[])object;
                    this.mHashes = (int[])object;
                    objectArray[n11] = null;
                    objectArray[0] = null;
                    sTwiceBaseCacheSize = n10 = sTwiceBaseCacheSize - n11;
                    return;
                }
            }
        } else {
            n12 = 4;
            if (n10 == n12) {
                Class<ArraySet> clazz = ArraySet.class;
                synchronized (clazz) {
                    Object[] objectArray = sBaseCache;
                    if (objectArray != null) {
                        this.mArray = objectArray;
                        Object object = objectArray[0];
                        object = object;
                        sBaseCache = object;
                        object = objectArray[n11];
                        object = (int[])object;
                        this.mHashes = (int[])object;
                        objectArray[n11] = null;
                        objectArray[0] = null;
                        sBaseCacheSize = n10 = sBaseCacheSize - n11;
                        return;
                    }
                }
            }
        }
        nArray = new int[n10];
        this.mHashes = nArray;
        Object[] objectArray = new Object[n10];
        this.mArray = objectArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void freeArrays(int[] nArray, Object[] objectArray, int n10) {
        int n11 = nArray.length;
        int n12 = 2;
        int n13 = 10;
        int n14 = 1;
        int n15 = 8;
        if (n11 == n15) {
            Class<ArraySet> clazz = ArraySet.class;
            synchronized (clazz) {
                Object[] objectArray2;
                n15 = sTwiceBaseCacheSize;
                if (n15 >= n13) return;
                objectArray[0] = objectArray2 = sTwiceBaseCache;
                objectArray[n14] = nArray;
                n10 -= n14;
                while (true) {
                    if (n10 < n12) {
                        int n16;
                        sTwiceBaseCache = objectArray;
                        sTwiceBaseCacheSize = n16 = sTwiceBaseCacheSize + n14;
                        return;
                    }
                    objectArray[n10] = null;
                    n10 += -1;
                }
            }
        }
        n11 = nArray.length;
        n15 = 4;
        if (n11 != n15) return;
        Class<ArraySet> clazz = ArraySet.class;
        synchronized (clazz) {
            Object[] objectArray3;
            n15 = sBaseCacheSize;
            if (n15 >= n13) return;
            objectArray[0] = objectArray3 = sBaseCache;
            objectArray[n14] = nArray;
            n10 -= n14;
            while (true) {
                if (n10 < n12) {
                    int n17;
                    sBaseCache = objectArray;
                    sBaseCacheSize = n17 = sBaseCacheSize + n14;
                    return;
                }
                objectArray[n10] = null;
                n10 += -1;
            }
        }
    }

    private MapCollections getCollection() {
        MapCollections mapCollections = this.mCollections;
        if (mapCollections == null) {
            this.mCollections = mapCollections = new ArraySet$1(this);
        }
        return this.mCollections;
    }

    private int indexOf(Object object, int n10) {
        Object object2;
        Object object3;
        int n11;
        int n12 = this.mSize;
        if (n12 == 0) {
            return -1;
        }
        int[] nArray = this.mHashes;
        int n13 = ContainerHelpers.binarySearch(nArray, n12, n10);
        if (n13 < 0) {
            return n13;
        }
        Object object4 = this.mArray[n13];
        int n14 = object.equals(object4);
        if (n14 != 0) {
            return n13;
        }
        for (n14 = n13 + 1; n14 < n12 && (n11 = (object3 = this.mHashes)[n14]) == n10; ++n14) {
            object3 = this.mArray[n14];
            n11 = object.equals(object3) ? 1 : 0;
            if (n11 == 0) continue;
            return n14;
        }
        n13 += -1;
        while (n13 >= 0 && (n12 = (object2 = this.mHashes)[n13]) == n10) {
            object2 = this.mArray[n13];
            n12 = object.equals(object2) ? 1 : 0;
            if (n12 != 0) {
                return n13;
            }
            n13 += -1;
        }
        return ~n14;
    }

    private int indexOfNull() {
        Object object;
        Object object2;
        int n10;
        int n11 = this.mSize;
        if (n11 == 0) {
            return -1;
        }
        int[] nArray = this.mHashes;
        int n12 = 0;
        Object object3 = null;
        int n13 = ContainerHelpers.binarySearch(nArray, n11, 0);
        if (n13 < 0) {
            return n13;
        }
        object3 = this.mArray[n13];
        if (object3 == null) {
            return n13;
        }
        for (n12 = n13 + 1; n12 < n11 && (n10 = (object2 = this.mHashes)[n12]) == 0; ++n12) {
            object2 = this.mArray[n12];
            if (object2 != null) continue;
            return n12;
        }
        n13 += -1;
        while (n13 >= 0 && (n11 = (object = this.mHashes)[n13]) == 0) {
            object = this.mArray[n13];
            if (object == null) {
                return n13;
            }
            n13 += -1;
        }
        return ~n12;
    }

    public boolean add(Object object) {
        Object[] objectArray;
        int n10;
        int n11;
        int n12 = 0;
        Object[] objectArray2 = null;
        if (object == null) {
            n11 = this.indexOfNull();
            n10 = 0;
        } else {
            n11 = object.hashCode();
            int n13 = this.indexOf(object, n11);
            n10 = n11;
            n11 = n13;
        }
        if (n11 >= 0) {
            return false;
        }
        n11 ^= 0xFFFFFFFF;
        int n14 = this.mSize;
        int[] nArray = this.mHashes;
        int n15 = nArray.length;
        if (n14 >= n15) {
            n15 = 4;
            int n16 = 8;
            if (n14 >= n16) {
                n15 = (n14 >> 1) + n14;
            } else if (n14 >= n15) {
                n15 = n16;
            }
            objectArray = this.mArray;
            this.allocArrays(n15);
            Object[] objectArray3 = this.mHashes;
            n16 = objectArray3.length;
            if (n16 > 0) {
                n16 = nArray.length;
                System.arraycopy(nArray, 0, objectArray3, 0, n16);
                objectArray3 = this.mArray;
                n16 = objectArray.length;
                System.arraycopy(objectArray, 0, objectArray3, 0, n16);
            }
            n12 = this.mSize;
            ArraySet.freeArrays(nArray, objectArray, n12);
        }
        if (n11 < (n12 = this.mSize)) {
            objectArray = this.mHashes;
            int n17 = n11 + 1;
            System.arraycopy(objectArray, n11, objectArray, n17, n12 -= n11);
            objectArray2 = this.mArray;
            n14 = this.mSize - n11;
            System.arraycopy(objectArray2, n11, objectArray2, n17, n14);
        }
        this.mHashes[n11] = n10;
        this.mArray[n11] = object;
        int n18 = this.mSize;
        n12 = 1;
        this.mSize = n18 += n12;
        return n12 != 0;
    }

    public void addAll(ArraySet objectArray) {
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
                System.arraycopy(objectArray, 0, objectArray2, 0, n10);
                this.mSize = n10;
            }
        } else {
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object = objectArray.valueAt(i10);
                this.add(object);
            }
        }
    }

    public boolean addAll(Collection object) {
        int n10 = this.mSize;
        int n11 = object.size();
        this.ensureCapacity(n10 += n11);
        object = object.iterator();
        n10 = 0;
        while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Object e10 = object.next();
            n11 = this.add(e10) ? 1 : 0;
            n10 |= n11;
        }
        return n10 != 0;
    }

    public void clear() {
        int n10 = this.mSize;
        if (n10 != 0) {
            int[] nArray = this.mHashes;
            Object[] objectArray = this.mArray;
            ArraySet.freeArrays(nArray, objectArray, n10);
            Object[] objectArray2 = INT;
            this.mHashes = objectArray2;
            objectArray2 = OBJECT;
            this.mArray = objectArray2;
            n10 = 0;
            objectArray2 = null;
            this.mSize = 0;
        }
    }

    public boolean contains(Object object) {
        int n10 = this.indexOf(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = this.contains(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public void ensureCapacity(int n10) {
        int[] nArray = this.mHashes;
        int n11 = nArray.length;
        if (n11 < n10) {
            Object[] objectArray = this.mArray;
            this.allocArrays(n10);
            n10 = this.mSize;
            if (n10 > 0) {
                int[] nArray2 = this.mHashes;
                System.arraycopy(nArray, 0, nArray2, 0, n10);
                Object[] objectArray2 = this.mArray;
                int n12 = this.mSize;
                System.arraycopy(objectArray, 0, objectArray2, 0, n12);
            }
            n10 = this.mSize;
            ArraySet.freeArrays(nArray, objectArray, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof Set;
        if (n10 != 0) {
            int n11;
            object = (Set)object;
            n10 = this.size();
            if (n10 != (n11 = object.size())) {
                return false;
            }
            n10 = 0;
            try {
                while (true) {
                    if (n10 >= (n11 = this.mSize)) {
                        return bl2;
                    }
                    Object object2 = this.valueAt(n10);
                    n11 = object.contains(object2) ? 1 : 0;
                    if (n11 == 0) {
                        return false;
                    }
                    ++n10;
                }
            }
            catch (ClassCastException | NullPointerException runtimeException) {}
        }
        return false;
    }

    public int hashCode() {
        int[] nArray = this.mHashes;
        int n10 = this.mSize;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n12 = nArray[i10];
            n11 += n12;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10;
        if (object == null) {
            n10 = this.indexOfNull();
        } else {
            int n11 = object.hashCode();
            n10 = this.indexOf(object, n11);
        }
        return n10;
    }

    public boolean isEmpty() {
        int n10 = this.mSize;
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public Iterator iterator() {
        return this.getCollection().getKeySet().iterator();
    }

    public boolean remove(Object object) {
        int n10 = this.indexOf(object);
        if (n10 >= 0) {
            this.removeAt(n10);
            return true;
        }
        return false;
    }

    public boolean removeAll(ArraySet arraySet) {
        int n10 = arraySet.mSize;
        int n11 = this.mSize;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = arraySet.valueAt(i10);
            this.remove(object);
        }
        int n12 = this.mSize;
        if (n11 != n12) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean removeAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = this.remove(e10);
            bl3 |= bl2;
        }
        return bl3;
    }

    public Object removeAt(int n10) {
        Object[] objectArray = this.mArray;
        Object object = objectArray[n10];
        int n11 = this.mSize;
        int n12 = 0;
        int n13 = 1;
        if (n11 <= n13) {
            ArraySet.freeArrays(this.mHashes, objectArray, n11);
            Object[] objectArray2 = INT;
            this.mHashes = objectArray2;
            objectArray2 = OBJECT;
            this.mArray = objectArray2;
            this.mSize = 0;
        } else {
            int[] nArray = this.mHashes;
            int n14 = nArray.length;
            int n15 = 8;
            if (n14 > n15 && n11 < (n14 = nArray.length / 3)) {
                Object[] objectArray3;
                if (n11 > n15) {
                    n14 = n11 >> 1;
                    n15 = n11 + n14;
                }
                this.allocArrays(n15);
                this.mSize = n11 = this.mSize - n13;
                if (n10 > 0) {
                    objectArray3 = this.mHashes;
                    System.arraycopy(nArray, 0, objectArray3, 0, n10);
                    objectArray3 = this.mArray;
                    System.arraycopy(objectArray, 0, objectArray3, 0, n10);
                }
                if (n10 < (n11 = this.mSize)) {
                    n12 = n10 + 1;
                    int[] nArray2 = this.mHashes;
                    System.arraycopy(nArray, n12, nArray2, n10, n11 -= n10);
                    objectArray3 = this.mArray;
                    n13 = this.mSize - n10;
                    System.arraycopy(objectArray, n12, objectArray3, n10, n13);
                }
            } else {
                Object[] objectArray4;
                int n16;
                this.mSize = n11 -= n13;
                if (n10 < n11) {
                    n16 = n10 + 1;
                    System.arraycopy(nArray, n16, nArray, n10, n11 -= n10);
                    objectArray4 = this.mArray;
                    n12 = this.mSize - n10;
                    System.arraycopy(objectArray4, n16, objectArray4, n10, n12);
                }
                Object[] objectArray5 = this.mArray;
                n16 = this.mSize;
                n11 = 0;
                objectArray4 = null;
                objectArray5[n16] = null;
            }
        }
        return object;
    }

    public boolean retainAll(Collection collection) {
        int n10 = this.mSize;
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        while (n10 >= 0) {
            Object object = this.mArray[n10];
            boolean bl2 = collection.contains(object);
            if (!bl2) {
                this.removeAt(n10);
                n12 = n11;
            }
            n10 += -1;
        }
        return n12 != 0;
    }

    public int size() {
        return this.mSize;
    }

    public Object[] toArray() {
        int n10 = this.mSize;
        Object[] objectArray = new Object[n10];
        System.arraycopy(this.mArray, 0, objectArray, 0, n10);
        return objectArray;
    }

    public Object[] toArray(Object[] objectArray) {
        int n10 = objectArray.length;
        int n11 = this.mSize;
        if (n10 < n11) {
            objectArray = objectArray.getClass().getComponentType();
            n10 = this.mSize;
            objectArray = (Object[])Array.newInstance(objectArray, n10);
        }
        Object[] objectArray2 = this.mArray;
        n11 = this.mSize;
        System.arraycopy(objectArray2, 0, objectArray, 0, n11);
        n10 = objectArray.length;
        n11 = this.mSize;
        if (n10 > n11) {
            n10 = 0;
            objectArray2 = null;
            objectArray[n11] = null;
        }
        return objectArray;
    }

    public String toString() {
        int n10;
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "{}";
        }
        int n11 = this.mSize * 14;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append('{');
        for (n11 = 0; n11 < (n10 = this.mSize); ++n11) {
            Object object;
            if (n11 > 0) {
                object = ", ";
                stringBuilder.append((String)object);
            }
            if ((object = this.valueAt(n11)) != this) {
                stringBuilder.append(object);
                continue;
            }
            object = "(this Set)";
            stringBuilder.append((String)object);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object valueAt(int n10) {
        return this.mArray[n10];
    }
}

