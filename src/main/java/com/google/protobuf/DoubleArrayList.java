/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.AbstractProtobufList;
import com.google.protobuf.Internal;
import com.google.protobuf.Internal$DoubleList;
import com.google.protobuf.PrimitiveNonBoxingCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

public final class DoubleArrayList
extends AbstractProtobufList
implements Internal$DoubleList,
RandomAccess,
PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST;
    private double[] array;
    private int size;

    static {
        DoubleArrayList doubleArrayList;
        double[] dArray = new double[]{};
        EMPTY_LIST = doubleArrayList = new DoubleArrayList(dArray, 0);
        doubleArrayList.makeImmutable();
    }

    public DoubleArrayList() {
        double[] dArray = new double[10];
        this(dArray, 0);
    }

    private DoubleArrayList(double[] dArray, int n10) {
        this.array = dArray;
        this.size = n10;
    }

    private void addDouble(int n10, double d10) {
        int n11;
        this.ensureIsMutable();
        if (n10 >= 0 && n10 <= (n11 = this.size)) {
            double[] dArray = this.array;
            int n12 = dArray.length;
            if (n11 < n12) {
                n12 = n10 + 1;
                System.arraycopy(dArray, n10, dArray, n12, n11 -= n10);
            } else {
                n11 = n11 * 3 / 2 + 1;
                double[] dArray2 = new double[n11];
                System.arraycopy(dArray, 0, dArray2, 0, n10);
                dArray = this.array;
                n12 = n10 + 1;
                int n13 = this.size - n10;
                System.arraycopy(dArray, n10, dArray2, n12, n13);
                this.array = dArray2;
            }
            this.array[n10] = d10;
            this.size = n10 = this.size + 1;
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        String string2 = this.makeOutOfBoundsExceptionMessage(n10);
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static DoubleArrayList emptyList() {
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

    public void add(int n10, Double d10) {
        double d11 = d10;
        this.addDouble(n10, d11);
    }

    public boolean add(Double d10) {
        double d11 = d10;
        this.addDouble(d11);
        return true;
    }

    public boolean addAll(Collection object) {
        this.ensureIsMutable();
        Internal.checkNotNull(object);
        int n10 = object instanceof DoubleArrayList;
        if (n10 == 0) {
            return super.addAll((Collection)object);
        }
        object = (DoubleArrayList)object;
        n10 = ((DoubleArrayList)object).size;
        if (n10 == 0) {
            return false;
        }
        int n11 = this.size;
        int n12 = (-1 >>> 1) - n11;
        if (n12 >= n10) {
            double[] dArray = this.array;
            n12 = dArray.length;
            if ((n11 += n10) > n12) {
                this.array = dArray = Arrays.copyOf(dArray, n11);
            }
            dArray = ((DoubleArrayList)object).array;
            double[] dArray2 = this.array;
            int n13 = this.size;
            int n14 = ((DoubleArrayList)object).size;
            System.arraycopy(dArray, 0, dArray2, n13, n14);
            this.size = n11;
            n14 = this.modCount;
            n10 = 1;
            this.modCount = n14 += n10;
            return n10 != 0;
        }
        object = new OutOfMemoryError();
        throw object;
    }

    public void addDouble(double d10) {
        this.ensureIsMutable();
        int n10 = this.size;
        double[] dArray = this.array;
        int n11 = dArray.length;
        if (n10 == n11) {
            n11 = n10 * 3 / 2 + 1;
            double[] dArray2 = new double[n11];
            System.arraycopy(dArray, 0, dArray2, 0, n10);
            this.array = dArray2;
        }
        double[] dArray3 = this.array;
        int n12 = this.size;
        this.size = n11 = n12 + 1;
        dArray3[n12] = d10;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof DoubleArrayList;
        if (n10 == 0) {
            return super.equals(object);
        }
        object = (DoubleArrayList)object;
        n10 = this.size;
        int n11 = ((DoubleArrayList)object).size;
        if (n10 != n11) {
            return false;
        }
        object = ((DoubleArrayList)object).array;
        for (n10 = 0; n10 < (n11 = this.size); ++n10) {
            Object object2;
            long l10;
            double[] dArray = this.array;
            double d10 = dArray[n10];
            long l11 = Double.doubleToLongBits(d10);
            long l12 = l11 - (l10 = Double.doubleToLongBits((double)(object2 = object[n10])));
            n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n11 == 0) continue;
            return false;
        }
        return bl2;
    }

    public Double get(int n10) {
        return this.getDouble(n10);
    }

    public double getDouble(int n10) {
        this.ensureIndexInRange(n10);
        return this.array[n10];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            double[] dArray = this.array;
            double d10 = dArray[i10];
            long l10 = Double.doubleToLongBits(d10);
            n11 *= 31;
            n10 = Internal.hashLong(l10);
            n11 += n10;
        }
        return n11;
    }

    public Internal$DoubleList mutableCopyWithCapacity(int n10) {
        int n11 = this.size;
        if (n10 >= n11) {
            double[] dArray = Arrays.copyOf(this.array, n10);
            int n12 = this.size;
            DoubleArrayList doubleArrayList = new DoubleArrayList(dArray, n12);
            return doubleArrayList;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        throw illegalArgumentException;
    }

    public Double remove(int n10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        double[] dArray = this.array;
        double d10 = dArray[n10];
        int n11 = this.size;
        int n12 = n11 + -1;
        if (n10 < n12) {
            n12 = n10 + 1;
            n11 = n11 - n10 + -1;
            System.arraycopy(dArray, n12, dArray, n10, n11);
        }
        this.size = n10 = this.size + -1;
        this.modCount = n10 = this.modCount + 1;
        return d10;
    }

    public boolean remove(Object object) {
        int n10;
        this.ensureIsMutable();
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.size); ++i10) {
            int n12;
            double d10 = this.array[i10];
            Double d11 = d10;
            n10 = (int)(object.equals(d11) ? 1 : 0);
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
            double[] dArray = this.array;
            int n12 = this.size - n11;
            System.arraycopy(dArray, n11, dArray, n10, n12);
            int n13 = this.size;
            this.size = n13 -= (n11 -= n10);
            this.modCount = n10 = this.modCount + 1;
            return;
        }
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("toIndex < fromIndex");
        throw indexOutOfBoundsException;
    }

    public Double set(int n10, Double d10) {
        double d11 = d10;
        return this.setDouble(n10, d11);
    }

    public double setDouble(int n10, double d10) {
        this.ensureIsMutable();
        this.ensureIndexInRange(n10);
        double[] dArray = this.array;
        double d11 = dArray[n10];
        dArray[n10] = d10;
        return d11;
    }

    public int size() {
        return this.size;
    }
}

