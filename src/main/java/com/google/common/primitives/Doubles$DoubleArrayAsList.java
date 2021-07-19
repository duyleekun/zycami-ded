/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Doubles$DoubleArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final double[] array;
    public final int end;
    public final int start;

    public Doubles$DoubleArrayAsList(double[] dArray) {
        int n10 = dArray.length;
        this(dArray, 0, n10);
    }

    public Doubles$DoubleArrayAsList(double[] dArray, int n10, int n11) {
        this.array = dArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Double;
        if (n10 == 0) return 0 != 0;
        double[] dArray = this.array;
        object = (Double)object;
        double d10 = (Double)object;
        int n11 = this.start;
        int n12 = this.end;
        if ((n11 = Doubles.access$000(dArray, d10, n11, n12)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Doubles$DoubleArrayAsList;
        if (n10 != 0) {
            object = (Doubles$DoubleArrayAsList)object;
            n10 = this.size();
            int n11 = ((Doubles$DoubleArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                double[] dArray = this.array;
                int n12 = this.start + n11;
                double d10 = dArray[n12];
                int n13 = ((Doubles$DoubleArrayAsList)object).start + n11;
                double d11 = (dArray = ((Doubles$DoubleArrayAsList)object).array)[n13];
                double d12 = d10 - d11;
                Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                if (object2 == false) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Double get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        double[] dArray = this.array;
        int n12 = this.start + n10;
        return dArray[n12];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            double[] dArray = this.array;
            double d10 = dArray[i10];
            n10 = Doubles.hashCode(d10);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object instanceof Double;
        if (n10 != 0) {
            double[] dArray = this.array;
            object = (Double)object;
            double d10 = (Double)object;
            int n11 = this.start;
            int n12 = this.end;
            if ((n11 = Doubles.access$000(dArray, d10, n11, n12)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public int lastIndexOf(Object object) {
        int n10 = object instanceof Double;
        if (n10 != 0) {
            double[] dArray = this.array;
            object = (Double)object;
            double d10 = (Double)object;
            int n11 = this.start;
            int n12 = this.end;
            if ((n11 = Doubles.access$100(dArray, d10, n11, n12)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public Double set(int n10, Double d10) {
        double d11;
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        double[] dArray = this.array;
        int n12 = this.start;
        int n13 = n12 + n10;
        double d12 = dArray[n13];
        dArray[n12 += n10] = d11 = ((Double)Preconditions.checkNotNull(d10)).doubleValue();
        return d12;
    }

    public int size() {
        int n10 = this.end;
        int n11 = this.start;
        return n10 - n11;
    }

    public List subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            return Collections.emptyList();
        }
        double[] dArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Doubles$DoubleArrayAsList doubles$DoubleArrayAsList = new Doubles$DoubleArrayAsList(dArray, n10, n13 += n11);
        return doubles$DoubleArrayAsList;
    }

    public double[] toDoubleArray() {
        double[] dArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(dArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 12;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        double[] dArray = this.array;
        int n11 = this.start;
        double d10 = dArray[n11];
        stringBuilder.append(d10);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            stringBuilder.append(", ");
            double[] dArray2 = this.array;
            double d11 = dArray2[n10];
            stringBuilder.append(d11);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

