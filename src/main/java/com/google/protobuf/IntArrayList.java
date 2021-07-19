/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$IntList;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class IntArrayList
extends AbstractProtobufList
implements Internal$IntList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST;
    private int[] array;
    private int size;

    static {
        IntArrayList intArrayList;
        int[] nArray = new int[]{};
        EMPTY_LIST = intArrayList = new IntArrayList(nArray, 0);
        intArrayList.makeImmutable();
    }

    public IntArrayList() {
        int[] nArray = new int[10];
        this(nArray, 0);
    }

    private IntArrayList(int[] nArray, int n10) {
        this.array = nArray;
        this.size = n10;
    }

    private void addInt(int n10, int n11) {
        int n12;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n12 = this.size)) {
            int[] nArray = this.array;
            int n13 = nArray.length;
            if (n12 < n13) {
                n13 = n10 + 1;
                System.arraycopy(nArray, n10, nArray, n13, n12 -= n10);
            } else {
                n12 = n12 * 3 / 2 + 1;
                int[] nArray2 = new int[n12];
                System.arraycopy(nArray, 0, nArray2, 0, n10);
                nArray = this.array;
                n13 = n10 + 1;
                int n14 = this.size - n10;
                System.arraycopy(nArray, n10, nArray2, n13, n14);
                this.array = nArray2;
            }
            this.array[n10] = n11;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static IntArrayList emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int n10) {
        int n11;
        if (n10 >= 0 && n10 < (n11 = this.size)) {
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    private String makeOutOfBoundsExceptionMessage(int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Index:");
        stringBuilder.append(n10);
        stringBuilder.append(", Size:");
        n10 = this.size;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }

    public void add(int n10, Integer n11) {
        int n12 = n11;
        this.addInt(n10, n12);
    }

    public boolean add(Integer n10) {
        int n11 = n10;
        this.addInt(n11);
        return true;
    }

    public boolean addAll(Collection object) {
        this.ensureIsMutable();
        Internal.checkNotNull(object);
        int n10 = object instanceof IntArrayList;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (IntArrayList)object;
        n10 = ((IntArrayList)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            int[] nArray = this.array;
            n12 = nArray.length;
            if ((n11 += n10) > n12) {
                this.array = nArray = Arrays.copyOf(nArray, n11);
            }
            nArray = ((IntArrayList)object).array;
            int[] nArray2 = this.array;
            int n13 = this.size;
            int n14 = ((IntArrayList)object).size;
            System.arraycopy(nArray, 0, nArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public void addInt(int n10) {
        this.ensureIsMutable();
        int n11 = this.size;
        int[] nArray = this.array;
        int n12 = nArray.length;
        if (n11 == n12) {
            n12 = n11 * 3 / 2 + 1;
            int[] nArray2 = new int[n12];
            System.arraycopy(nArray, 0, nArray2, 0, n11);
            this.array = nArray2;
        }
        int[] nArray3 = this.array;
        int n13 = this.size;
        this.size = n12 = n13 + 1;
        nArray3[n13] = n10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof IntArrayList;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (IntArrayList)object;
        n10 = this.size;
        int n11 = ((IntArrayList)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((IntArrayList)object).array;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            int[] nArray = this.array;
            n11 = nArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public Integer get(int n10) {
        return this.getInt(n10);
    }

    public int getInt(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            int[] nArray = this.array;
            n10 = nArray[i10];
            n11 += n10;
        }
        return n11;
    }

    public Internal$IntList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            int[] nArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            IntArrayList intArrayList = new IntArrayList(nArray, n12);
            return intArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Integer remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        int[] nArray = this.array;
        int n11 = nArray[n10];
        int n12 = this.size;
        int n13 = n12 + -1;
        if (n10 < n13) {
            n13 = n10 + 1;
            n12 = n12 - n10 + -1;
            System.arraycopy(nArray, n13, nArray, n10, n12);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return n11;
    }

    public boolean remove(Object object) {
        int n10;
        this.ensureIsMutable();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            Integer n13 = this.array[i10];
            n10 = (int)(object.equals(n13) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.array;
            n11 = i10 + 1;
            n10 = this.size - i10;
            int n14 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n14);
            this.size = n12 = this.size - n14;
            this.modCount = n12 = this.modCount + n14;
            return n14 != 0;
        }
        return false;
    }

    public void removeRange(int n10, int n11) {
        this.ensureIsMutable();
        if (n11 >= n10) {
            int[] nArray = this.array;
            int n12 = this.size - n11;
            System.arraycopy(nArray, n11, nArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public Integer set(int n10, Integer n11) {
        int n12 = n11;
        return this.setInt(n10, n12);
    }

    public int setInt(int n10, int n11) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        int[] nArray = this.array;
        int n12 = nArray[n10];
        nArray[n10] = n11;
        return n12;
    }

    public int size() {
        return this.size;
    }
}

