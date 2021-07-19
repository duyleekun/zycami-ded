/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;

public class LongSparseArray
implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private long[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        Object object;
        DELETED = object = new Object();
    }

    public LongSparseArray() {
        this(10);
    }

    public LongSparseArray(int n10) {
        long[] lArray = null;
        this.mGarbage = false;
        if (n10 == 0) {
            Object[] objectArray = ContainerHelpers.EMPTY_LONGS;
            this.mKeys = objectArray;
            objectArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mValues = objectArray;
        } else {
            n10 = ContainerHelpers.idealLongArraySize(n10);
            lArray = new long[n10];
            this.mKeys = lArray;
            Object[] objectArray = new Object[n10];
            this.mValues = objectArray;
        }
    }

    private void gc() {
        int n10 = this.mSize;
        long[] lArray = this.mKeys;
        Object[] objectArray = this.mValues;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Object object2 = DELETED;
            if (object == object2) continue;
            if (i10 != n11) {
                long l10;
                lArray[n11] = l10 = lArray[i10];
                objectArray[n11] = object;
                object = null;
                objectArray[i10] = null;
            }
            ++n11;
        }
        this.mGarbage = false;
        this.mSize = n11;
    }

    public void append(long l10, Object object) {
        int n10;
        Object[] objectArray;
        long l11;
        long l12;
        int n11;
        int n12 = this.mSize;
        if (n12 != 0 && (n11 = (int)((l12 = l10 - (l11 = (objectArray = this.mKeys)[n10 = n12 + -1])) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            this.put(l10, object);
            return;
        }
        n11 = this.mGarbage;
        if (n11 != 0 && n12 >= (n11 = (objectArray = this.mKeys).length)) {
            this.gc();
        }
        if ((n12 = this.mSize) >= (n11 = (objectArray = this.mKeys).length)) {
            n11 = ContainerHelpers.idealLongArraySize(n12 + 1);
            long[] lArray = new long[n11];
            objectArray = new Object[n11];
            Object[] objectArray2 = this.mKeys;
            int n13 = objectArray2.length;
            System.arraycopy(objectArray2, 0, lArray, 0, n13);
            objectArray2 = this.mValues;
            n13 = objectArray2.length;
            System.arraycopy(objectArray2, 0, objectArray, 0, n13);
            this.mKeys = lArray;
            this.mValues = objectArray;
        }
        this.mKeys[n12] = l10;
        this.mValues[n12] = object;
        this.mSize = ++n12;
    }

    public void clear() {
        int n10 = this.mSize;
        Object[] objectArray = this.mValues;
        for (int i10 = 0; i10 < n10; ++i10) {
            objectArray[i10] = null;
        }
        this.mSize = 0;
        this.mGarbage = false;
    }

    public LongSparseArray clone() {
        Object object;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        object = (LongSparseArray)object;
        long[] lArray = this.mKeys;
        Object object2 = lArray.clone();
        long[] lArray2 = (long[])object2;
        ((LongSparseArray)object).mKeys = lArray2;
        Object[] objectArray = this.mValues;
        Object object3 = objectArray.clone();
        Object[] objectArray2 = (Object[])object3;
        ((LongSparseArray)object).mValues = objectArray2;
        return object;
    }

    public boolean containsKey(long l10) {
        int n10 = this.indexOfKey(l10);
        n10 = n10 >= 0 ? 1 : 0;
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

    public void delete(long l10) {
        this.remove(l10);
    }

    public Object get(long l10) {
        return this.get(l10, null);
    }

    public Object get(long l10, Object object) {
        Object object2;
        Object[] objectArray;
        Object object3 = this.mKeys;
        int n10 = this.mSize;
        int n11 = ContainerHelpers.binarySearch(object3, n10, l10);
        if (n11 >= 0 && (object3 = (Object)(objectArray = this.mValues)[n11]) != (object2 = DELETED)) {
            return objectArray[n11];
        }
        return object;
    }

    public int indexOfKey(long l10) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        long[] lArray = this.mKeys;
        int n10 = this.mSize;
        return ContainerHelpers.binarySearch(lArray, n10, l10);
    }

    public int indexOfValue(Object object) {
        int n10;
        int n11 = this.mGarbage;
        if (n11 != 0) {
            this.gc();
        }
        for (n11 = 0; n11 < (n10 = this.mSize); ++n11) {
            Object object2 = this.mValues[n11];
            if (object2 != object) continue;
            return n11;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public long keyAt(int n10) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        return this.mKeys[n10];
    }

    public void put(long l10, Object object) {
        long[] lArray = this.mKeys;
        int n10 = this.mSize;
        int n11 = ContainerHelpers.binarySearch(lArray, n10, l10);
        if (n11 >= 0) {
            Object[] objectArray = this.mValues;
            objectArray[n11] = object;
        } else {
            int n12;
            Object[] objectArray;
            Object object2;
            Object[] objectArray2;
            Object[] objectArray3;
            n10 = this.mSize;
            if ((n11 ^= 0xFFFFFFFF) < n10 && (objectArray3 = (objectArray2 = this.mValues)[n11]) == (object2 = DELETED)) {
                this.mKeys[n11] = l10;
                objectArray2[n11] = object;
                return;
            }
            int n13 = this.mGarbage;
            if (n13 != 0 && n10 >= (n13 = (objectArray2 = (Object[])this.mKeys).length)) {
                this.gc();
                lArray = this.mKeys;
                n10 = this.mSize;
                n11 = ~ContainerHelpers.binarySearch(lArray, n10, l10);
            }
            if ((n10 = this.mSize) >= (n13 = (objectArray2 = (Object[])this.mKeys).length)) {
                n10 = ContainerHelpers.idealLongArraySize(n10 + 1);
                objectArray2 = new long[n10];
                objectArray = new Object[n10];
                objectArray3 = this.mKeys;
                int n14 = objectArray3.length;
                System.arraycopy(objectArray3, 0, objectArray2, 0, n14);
                objectArray3 = this.mValues;
                n14 = objectArray3.length;
                System.arraycopy(objectArray3, 0, objectArray, 0, n14);
                this.mKeys = (long[])objectArray2;
                this.mValues = objectArray;
            }
            if ((n13 = (n10 = this.mSize) - n11) != 0) {
                objectArray2 = this.mKeys;
                int n15 = n11 + 1;
                System.arraycopy(objectArray2, n11, objectArray2, n15, n10 -= n11);
                objectArray = this.mValues;
                n13 = this.mSize - n11;
                System.arraycopy(objectArray, n11, objectArray, n15, n13);
            }
            objectArray = this.mKeys;
            objectArray[n11] = l10;
            Object[] objectArray4 = this.mValues;
            objectArray4[n11] = object;
            this.mSize = n12 = this.mSize + 1;
        }
    }

    public void putAll(LongSparseArray longSparseArray) {
        int n10 = longSparseArray.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            long l10 = longSparseArray.keyAt(i10);
            Object object = longSparseArray.valueAt(i10);
            this.put(l10, object);
        }
    }

    public Object putIfAbsent(long l10, Object object) {
        Object object2 = this.get(l10);
        if (object2 == null) {
            this.put(l10, object);
        }
        return object2;
    }

    public void remove(long l10) {
        Object object;
        Object[] objectArray;
        Object object2 = this.mKeys;
        int n10 = this.mSize;
        int n11 = ContainerHelpers.binarySearch(object2, n10, l10);
        if (n11 >= 0 && (object2 = (Object)(objectArray = this.mValues)[n11]) != (object = DELETED)) {
            objectArray[n11] = object;
            n11 = 1;
            this.mGarbage = n11;
        }
    }

    public boolean remove(long l10, Object object) {
        boolean bl2;
        Object object2;
        int n10 = this.indexOfKey(l10);
        if (n10 >= 0 && (object == (object2 = this.valueAt(n10)) || object != null && (bl2 = object.equals(object2)))) {
            this.removeAt(n10);
            return true;
        }
        return false;
    }

    public void removeAt(int n10) {
        Object[] objectArray = this.mValues;
        Object object = objectArray[n10];
        Object object2 = DELETED;
        if (object != object2) {
            objectArray[n10] = object2;
            n10 = 1;
            this.mGarbage = n10;
        }
    }

    public Object replace(long l10, Object object) {
        int n10 = this.indexOfKey(l10);
        if (n10 >= 0) {
            Object[] objectArray = this.mValues;
            Object object2 = objectArray[n10];
            objectArray[n10] = object;
            return object2;
        }
        return null;
    }

    public boolean replace(long l10, Object object, Object object2) {
        boolean bl2;
        Object object3;
        int n10 = this.indexOfKey(l10);
        if (n10 >= 0 && ((object3 = this.mValues[n10]) == object || object != null && (bl2 = object.equals(object3)))) {
            this.mValues[n10] = object2;
            return true;
        }
        return false;
    }

    public void setValueAt(int n10, Object object) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        this.mValues[n10] = object;
    }

    public int size() {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        return this.mSize;
    }

    public String toString() {
        char c10;
        int n10 = this.size();
        if (n10 <= 0) {
            return "{}";
        }
        int n11 = this.mSize * 28;
        StringBuilder stringBuilder = new StringBuilder(n11);
        stringBuilder.append('{');
        for (n11 = 0; n11 < (c10 = this.mSize); ++n11) {
            Object object;
            if (n11 > 0) {
                object = ", ";
                stringBuilder.append((String)object);
            }
            long l10 = this.keyAt(n11);
            stringBuilder.append(l10);
            c10 = '=';
            stringBuilder.append(c10);
            object = this.valueAt(n11);
            if (object != this) {
                stringBuilder.append(object);
                continue;
            }
            object = "(this Map)";
            stringBuilder.append((String)object);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public Object valueAt(int n10) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        return this.mValues[n10];
    }
}

