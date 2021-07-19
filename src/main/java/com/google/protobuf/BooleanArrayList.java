/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$BooleanList;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class BooleanArrayList
extends AbstractProtobufList
implements Internal$BooleanList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST;
    private boolean[] array;
    private int size;

    static {
        BooleanArrayList booleanArrayList;
        boolean[] blArray = new boolean[]{};
        EMPTY_LIST = booleanArrayList = new BooleanArrayList(blArray, 0);
        booleanArrayList.makeImmutable();
    }

    public BooleanArrayList() {
        boolean[] blArray = new boolean[10];
        this(blArray, 0);
    }

    private BooleanArrayList(boolean[] blArray, int n10) {
        this.array = blArray;
        this.size = n10;
    }

    private void addBoolean(int n10, boolean bl2) {
        int n11;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            boolean[] blArray = this.array;
            int n12 = blArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(blArray, n10, blArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                boolean[] blArray2 = new boolean[n11];
                System.arraycopy(blArray, 0, blArray2, 0, n10);
                blArray = this.array;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(blArray, n10, blArray2, n12, n13);
                this.array = blArray2;
            }
            this.array[n10] = bl2;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static BooleanArrayList emptyList() {
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

    public void add(int n10, Boolean bl2) {
        boolean bl3 = bl2;
        this.addBoolean(n10, bl3);
    }

    public boolean add(Boolean bl2) {
        boolean bl3 = bl2;
        this.addBoolean(bl3);
        return true;
    }

    public boolean addAll(Collection object) {
        this.ensureIsMutable();
        Internal.checkNotNull(object);
        int n10 = object instanceof BooleanArrayList;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (BooleanArrayList)object;
        n10 = ((BooleanArrayList)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            boolean[] blArray = this.array;
            n12 = blArray.length;
            if ((n11 += n10) > n12) {
                this.array = blArray = Arrays.copyOf(blArray, n11);
            }
            blArray = ((BooleanArrayList)object).array;
            boolean[] blArray2 = this.array;
            int n13 = this.size;
            int n14 = ((BooleanArrayList)object).size;
            System.arraycopy(blArray, 0, blArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public void addBoolean(boolean bl2) {
        this.ensureIsMutable();
        int n10 = this.size;
        boolean[] blArray = this.array;
        int n11 = blArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            boolean[] blArray2 = new boolean[n11];
            System.arraycopy(blArray, 0, blArray2, 0, n10);
            this.array = blArray2;
        }
        boolean[] blArray3 = this.array;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        blArray3[n12] = bl2;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof BooleanArrayList;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (BooleanArrayList)object;
        n10 = this.size;
        int n11 = ((BooleanArrayList)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((BooleanArrayList)object).array;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            boolean[] blArray = this.array;
            n11 = blArray[n10];
            Object object2 = object[n10];
            if (n11 == object2) continue;
            return false;
        }
        return bl2;
    }

    public Boolean get(int n10) {
        return this.getBoolean(n10);
    }

    public boolean getBoolean(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            boolean[] blArray = this.array;
            n10 = Internal.hashBoolean(blArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public Internal$BooleanList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            boolean[] blArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            BooleanArrayList booleanArrayList = new BooleanArrayList(blArray, n12);
            return booleanArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Boolean remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        boolean[] blArray = this.array;
        boolean bl2 = blArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(blArray, n12, blArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return bl2;
    }

    public boolean remove(Object object) {
        int n10;
        this.ensureIsMutable();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            Boolean bl2 = this.array[i10];
            n10 = (int)(object.equals(bl2) ? 1 : 0);
            if (n10 == 0) continue;
            object = this.array;
            n11 = i10 + 1;
            n10 = this.size - i10;
            int n13 = 1;
            System.arraycopy(object, n11, object, i10, n10 -= n13);
            this.size = n12 = this.size - n13;
            this.modCount = n12 = this.modCount + n13;
            return n13 != 0;
        }
        return false;
    }

    public void removeRange(int n10, int n11) {
        this.ensureIsMutable();
        if (n11 >= n10) {
            boolean[] blArray = this.array;
            int n12 = this.size - n11;
            System.arraycopy(blArray, n11, blArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public Boolean set(int n10, Boolean bl2) {
        boolean bl3 = bl2;
        return this.setBoolean(n10, bl3);
    }

    public boolean setBoolean(int n10, boolean bl2) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        boolean[] blArray = this.array;
        boolean bl3 = blArray[n10];
        blArray[n10] = bl2;
        return bl3;
    }

    public int size() {
        return this.size;
    }
}

