/*
 * Decompiled with CFR 0.151.
 */
package androidx.collection;

import androidx.collection.ContainerHelpers;

public class SparseArrayCompat
implements Cloneable {
    private static final Object DELETED;
    private boolean mGarbage;
    private int[] mKeys;
    private int mSize;
    private Object[] mValues;

    static {
        Object object;
        DELETED = object = new Object();
    }

    public SparseArrayCompat() {
        this(10);
    }

    public SparseArrayCompat(int n10) {
        int[] nArray = null;
        this.mGarbage = false;
        if (n10 == 0) {
            Object[] objectArray = ContainerHelpers.EMPTY_INTS;
            this.mKeys = objectArray;
            objectArray = ContainerHelpers.EMPTY_OBJECTS;
            this.mValues = objectArray;
        } else {
            n10 = ContainerHelpers.idealIntArraySize(n10);
            nArray = new int[n10];
            this.mKeys = nArray;
            Object[] objectArray = new Object[n10];
            this.mValues = objectArray;
        }
    }

    private void gc() {
        int n10 = this.mSize;
        int[] nArray = this.mKeys;
        Object[] objectArray = this.mValues;
        int n11 = 0;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = objectArray[i10];
            Object object2 = DELETED;
            if (object == object2) continue;
            if (i10 != n11) {
                int n12;
                nArray[n11] = n12 = nArray[i10];
                objectArray[n11] = object;
                object = null;
                objectArray[i10] = null;
            }
            ++n11;
        }
        this.mGarbage = false;
        this.mSize = n11;
    }

    public void append(int n10, Object object) {
        int n11;
        Object[] objectArray;
        int n12;
        int n13 = this.mSize;
        if (n13 != 0 && n10 <= (n12 = (objectArray = this.mKeys)[n11 = n13 + -1])) {
            this.put(n10, object);
            return;
        }
        n12 = this.mGarbage;
        if (n12 != 0 && n13 >= (n12 = (objectArray = this.mKeys).length)) {
            this.gc();
        }
        if ((n13 = this.mSize) >= (n12 = (objectArray = this.mKeys).length)) {
            n12 = ContainerHelpers.idealIntArraySize(n13 + 1);
            int[] nArray = new int[n12];
            objectArray = new Object[n12];
            Object[] objectArray2 = this.mKeys;
            int n14 = objectArray2.length;
            System.arraycopy(objectArray2, 0, nArray, 0, n14);
            objectArray2 = this.mValues;
            n14 = objectArray2.length;
            System.arraycopy(objectArray2, 0, objectArray, 0, n14);
            this.mKeys = nArray;
            this.mValues = objectArray;
        }
        this.mKeys[n13] = n10;
        this.mValues[n13] = object;
        this.mSize = ++n13;
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

    public SparseArrayCompat clone() {
        Object object;
        try {
            object = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            AssertionError assertionError = new AssertionError((Object)cloneNotSupportedException);
            throw assertionError;
        }
        object = (SparseArrayCompat)object;
        int[] nArray = this.mKeys;
        Object object2 = nArray.clone();
        int[] nArray2 = (int[])object2;
        ((SparseArrayCompat)object).mKeys = nArray2;
        Object[] objectArray = this.mValues;
        Object object3 = objectArray.clone();
        Object[] objectArray2 = (Object[])object3;
        ((SparseArrayCompat)object).mValues = objectArray2;
        return object;
    }

    public boolean containsKey(int n10) {
        n10 = (n10 = this.indexOfKey(n10)) >= 0 ? 1 : 0;
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

    public void delete(int n10) {
        this.remove(n10);
    }

    public Object get(int n10) {
        return this.get(n10, null);
    }

    public Object get(int n10, Object object) {
        Object object2;
        int n11;
        Object[] objectArray = this.mKeys;
        int n12 = this.mSize;
        if ((n10 = ContainerHelpers.binarySearch(objectArray, n12, n10)) >= 0 && (n11 = (objectArray = (Object[])this.mValues)[n10]) != (object2 = DELETED)) {
            return objectArray[n10];
        }
        return object;
    }

    public int indexOfKey(int n10) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        int[] nArray = this.mKeys;
        int n11 = this.mSize;
        return ContainerHelpers.binarySearch(nArray, n11, n10);
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

    public int keyAt(int n10) {
        boolean bl2 = this.mGarbage;
        if (bl2) {
            this.gc();
        }
        return this.mKeys[n10];
    }

    public void put(int n10, Object object) {
        int[] nArray = this.mKeys;
        int n11 = this.mSize;
        int n12 = ContainerHelpers.binarySearch(nArray, n11, n10);
        if (n12 >= 0) {
            Object[] objectArray = this.mValues;
            objectArray[n12] = object;
        } else {
            Object[] objectArray;
            Object object2;
            Object[] objectArray2;
            Object[] objectArray3;
            n11 = this.mSize;
            if ((n12 ^= 0xFFFFFFFF) < n11 && (objectArray3 = (objectArray2 = this.mValues)[n12]) == (object2 = DELETED)) {
                this.mKeys[n12] = n10;
                objectArray2[n12] = object;
                return;
            }
            int n13 = this.mGarbage;
            if (n13 != 0 && n11 >= (n13 = (objectArray2 = (Object[])this.mKeys).length)) {
                this.gc();
                nArray = this.mKeys;
                n11 = this.mSize;
                n12 = ~ContainerHelpers.binarySearch(nArray, n11, n10);
            }
            if ((n11 = this.mSize) >= (n13 = (objectArray2 = (Object[])this.mKeys).length)) {
                n11 = ContainerHelpers.idealIntArraySize(n11 + 1);
                objectArray2 = new int[n11];
                objectArray = new Object[n11];
                objectArray3 = this.mKeys;
                int n14 = objectArray3.length;
                System.arraycopy(objectArray3, 0, objectArray2, 0, n14);
                objectArray3 = this.mValues;
                n14 = objectArray3.length;
                System.arraycopy(objectArray3, 0, objectArray, 0, n14);
                this.mKeys = (int[])objectArray2;
                this.mValues = objectArray;
            }
            if ((n13 = (n11 = this.mSize) - n12) != 0) {
                objectArray2 = this.mKeys;
                int n15 = n12 + 1;
                System.arraycopy(objectArray2, n12, objectArray2, n15, n11 -= n12);
                objectArray = this.mValues;
                n13 = this.mSize - n12;
                System.arraycopy(objectArray, n12, objectArray, n15, n13);
            }
            objectArray = this.mKeys;
            objectArray[n12] = n10;
            Object[] objectArray4 = this.mValues;
            objectArray4[n12] = object;
            this.mSize = n10 = this.mSize + 1;
        }
    }

    public void putAll(SparseArrayCompat sparseArrayCompat) {
        int n10 = sparseArrayCompat.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = sparseArrayCompat.keyAt(i10);
            Object object = sparseArrayCompat.valueAt(i10);
            this.put(n11, object);
        }
    }

    public Object putIfAbsent(int n10, Object object) {
        Object object2 = this.get(n10);
        if (object2 == null) {
            this.put(n10, object);
        }
        return object2;
    }

    public void remove(int n10) {
        Object object;
        int n11;
        Object[] objectArray = this.mKeys;
        int n12 = this.mSize;
        if ((n10 = ContainerHelpers.binarySearch(objectArray, n12, n10)) >= 0 && (n11 = (objectArray = (Object[])this.mValues)[n10]) != (object = DELETED)) {
            objectArray[n10] = (int)object;
            n10 = 1;
            this.mGarbage = n10;
        }
    }

    public boolean remove(int n10, Object object) {
        boolean bl2;
        Object object2;
        if ((n10 = this.indexOfKey(n10)) >= 0 && (object == (object2 = this.valueAt(n10)) || object != null && (bl2 = object.equals(object2)))) {
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

    public void removeAtRange(int n10, int n11) {
        int n12 = this.mSize;
        n11 += n10;
        n11 = Math.min(n12, n11);
        while (n10 < n11) {
            this.removeAt(n10);
            ++n10;
        }
    }

    public Object replace(int n10, Object object) {
        if ((n10 = this.indexOfKey(n10)) >= 0) {
            Object[] objectArray = this.mValues;
            Object object2 = objectArray[n10];
            objectArray[n10] = object;
            return object2;
        }
        return null;
    }

    public boolean replace(int n10, Object object, Object object2) {
        boolean bl2;
        Object object3;
        if ((n10 = this.indexOfKey(n10)) >= 0 && ((object3 = this.mValues[n10]) == object || object != null && (bl2 = object.equals(object3)))) {
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
            c10 = this.keyAt(n11);
            stringBuilder.append((int)c10);
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

