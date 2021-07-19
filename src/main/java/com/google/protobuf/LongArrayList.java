/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$LongList;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class LongArrayList
extends AbstractProtobufList
implements Internal$LongList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST;
    private long[] array;
    private int size;

    static {
        LongArrayList longArrayList;
        long[] lArray = new long[]{};
        EMPTY_LIST = longArrayList = new LongArrayList(lArray, 0);
        longArrayList.makeImmutable();
    }

    public LongArrayList() {
        long[] lArray = new long[10];
        this(lArray, 0);
    }

    private LongArrayList(long[] lArray, int n10) {
        this.array = lArray;
        this.size = n10;
    }

    private void addLong(int n10, long l10) {
        int n11;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            long[] lArray = this.array;
            int n12 = lArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(lArray, n10, lArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                long[] lArray2 = new long[n11];
                System.arraycopy(lArray, 0, lArray2, 0, n10);
                lArray = this.array;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(lArray, n10, lArray2, n12, n13);
                this.array = lArray2;
            }
            this.array[n10] = l10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static LongArrayList emptyList() {
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

    public void add(int n10, Long l10) {
        long l11 = l10;
        this.addLong(n10, l11);
    }

    public boolean add(Long l10) {
        long l11 = l10;
        this.addLong(l11);
        return true;
    }

    public boolean addAll(Collection object) {
        this.ensureIsMutable();
        Internal.checkNotNull(object);
        int n10 = object instanceof LongArrayList;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (LongArrayList)object;
        n10 = ((LongArrayList)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            long[] lArray = this.array;
            n12 = lArray.length;
            if ((n11 += n10) > n12) {
                this.array = lArray = Arrays.copyOf(lArray, n11);
            }
            lArray = ((LongArrayList)object).array;
            long[] lArray2 = this.array;
            int n13 = this.size;
            int n14 = ((LongArrayList)object).size;
            System.arraycopy(lArray, 0, lArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public void addLong(long l10) {
        this.ensureIsMutable();
        int n10 = this.size;
        long[] lArray = this.array;
        int n11 = lArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            long[] lArray2 = new long[n11];
            System.arraycopy(lArray, 0, lArray2, 0, n10);
            this.array = lArray2;
        }
        long[] lArray3 = this.array;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        lArray3[n12] = l10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof LongArrayList;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (LongArrayList)object;
        n10 = this.size;
        int n11 = ((LongArrayList)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((LongArrayList)object).array;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            long[] lArray = this.array;
            long l10 = lArray[n10];
            Object object2 = object[n10];
            long l11 = l10 - object2;
            n11 = (int)(l11 == 0L ? 0 : (l11 < 0L ? -1 : 1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public Long get(int n10) {
        return this.getLong(n10);
    }

    public long getLong(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            n11 *= 31;
            long[] lArray = this.array;
            long l10 = lArray[i10];
            n10 = Internal.hashLong(l10);
            n11 += n10;
        }
        return n11;
    }

    public Internal$LongList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            long[] lArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            LongArrayList longArrayList = new LongArrayList(lArray, n12);
            return longArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Long remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        long[] lArray = this.array;
        long l10 = lArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(lArray, n12, lArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return l10;
    }

    public boolean remove(Object object) {
        int n10;
        this.ensureIsMutable();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            long l10 = this.array[i10];
            Long l11 = l10;
            n10 = (int)(object.equals(l11) ? 1 : 0);
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
            long[] lArray = this.array;
            int n12 = this.size - n11;
            System.arraycopy(lArray, n11, lArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public Long set(int n10, Long l10) {
        long l11 = l10;
        return this.setLong(n10, l11);
    }

    public long setLong(int n10, long l10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        long[] lArray = this.array;
        long l11 = lArray[n10];
        lArray[n10] = l10;
        return l11;
    }

    public int size() {
        return this.size;
    }
}

