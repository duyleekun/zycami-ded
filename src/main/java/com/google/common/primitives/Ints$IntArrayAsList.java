/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Ints$IntArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final int[] array;
    public final int end;
    public final int start;

    public Ints$IntArrayAsList(int[] nArray) {
        int n10 = nArray.length;
        this(nArray, 0, n10);
    }

    public Ints$IntArrayAsList(int[] nArray, int n10, int n11) {
        this.array = nArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Integer;
        if (n10 == 0) return 0 != 0;
        int[] nArray = this.array;
        object = (Integer)object;
        int n11 = (Integer)object;
        int n12 = this.start;
        int n13 = this.end;
        if ((n11 = Ints.access$000(nArray, n11, n12, n13)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Ints$IntArrayAsList;
        if (n10 != 0) {
            object = (Ints$IntArrayAsList)object;
            n10 = this.size();
            int n11 = ((Ints$IntArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                int[] nArray = this.array;
                int n12 = this.start + n11;
                int n13 = nArray[n12];
                int[] nArray2 = ((Ints$IntArrayAsList)object).array;
                int n14 = ((Ints$IntArrayAsList)object).start + n11;
                if (n13 == (n12 = nArray2[n14])) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Integer get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        int[] nArray = this.array;
        int n12 = this.start + n10;
        return nArray[n12];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            int[] nArray = this.array;
            n10 = Ints.hashCode(nArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object instanceof Integer;
        if (n10 != 0) {
            int[] nArray = this.array;
            object = (Integer)object;
            int n11 = (Integer)object;
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Ints.access$000(nArray, n11, n12, n13)) >= 0) {
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
        int n10 = object instanceof Integer;
        if (n10 != 0) {
            int[] nArray = this.array;
            object = (Integer)object;
            int n11 = (Integer)object;
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Ints.access$100(nArray, n11, n12, n13)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public Integer set(int n10, Integer n11) {
        int n12 = this.size();
        Preconditions.checkElementIndex(n10, n12);
        int[] nArray = this.array;
        int n13 = this.start;
        int n14 = n13 + n10;
        n14 = nArray[n14];
        n13 += n10;
        nArray[n13] = n10 = ((Integer)Preconditions.checkNotNull(n11)).intValue();
        return n14;
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
        int[] nArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Ints$IntArrayAsList ints$IntArrayAsList = new Ints$IntArrayAsList(nArray, n10, n13 += n11);
        return ints$IntArrayAsList;
    }

    public int[] toIntArray() {
        int[] nArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(nArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 5;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        int[] nArray = this.array;
        int n11 = this.start;
        n10 = nArray[n11];
        stringBuilder.append(n10);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            stringBuilder.append(", ");
            int[] nArray2 = this.array;
            n11 = nArray2[n10];
            stringBuilder.append(n11);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

