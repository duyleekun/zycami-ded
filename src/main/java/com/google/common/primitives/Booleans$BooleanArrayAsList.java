/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Booleans;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Booleans$BooleanArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final boolean[] array;
    public final int end;
    public final int start;

    public Booleans$BooleanArrayAsList(boolean[] blArray) {
        int n10 = blArray.length;
        this(blArray, 0, n10);
    }

    public Booleans$BooleanArrayAsList(boolean[] blArray, int n10, int n11) {
        this.array = blArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Boolean;
        if (n10 == 0) return 0 != 0;
        boolean[] blArray = this.array;
        object = (Boolean)object;
        int n11 = ((Boolean)object).booleanValue();
        int n12 = this.start;
        int n13 = this.end;
        if ((n11 = Booleans.access$000(blArray, n11 != 0, n12, n13)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Booleans$BooleanArrayAsList;
        if (n10 != 0) {
            object = (Booleans$BooleanArrayAsList)object;
            n10 = this.size();
            int n11 = ((Booleans$BooleanArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                boolean[] blArray = this.array;
                int n12 = this.start + n11;
                int n13 = blArray[n12];
                boolean[] blArray2 = ((Booleans$BooleanArrayAsList)object).array;
                int n14 = ((Booleans$BooleanArrayAsList)object).start + n11;
                if (n13 == (n12 = blArray2[n14])) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Boolean get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        boolean[] blArray = this.array;
        int n12 = this.start + n10;
        return blArray[n12];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            boolean[] blArray = this.array;
            n10 = Booleans.hashCode(blArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10;
        int n11;
        boolean n112;
        boolean[] blArray;
        int n12;
        int n102 = object instanceof Boolean;
        if (n102 != 0 && (n12 = Booleans.access$000(blArray = this.array, n112 = ((Boolean)(object = (Boolean)object)).booleanValue(), n11 = this.start, n10 = this.end)) >= 0) {
            n102 = this.start;
            return n12 - n102;
        }
        return -1;
    }

    public boolean isEmpty() {
        return false;
    }

    public int lastIndexOf(Object object) {
        int n10;
        int n11;
        boolean n112;
        boolean[] blArray;
        int n12;
        int n102 = object instanceof Boolean;
        if (n102 != 0 && (n12 = Booleans.access$100(blArray = this.array, n112 = ((Boolean)(object = (Boolean)object)).booleanValue(), n11 = this.start, n10 = this.end)) >= 0) {
            n102 = this.start;
            return n12 - n102;
        }
        return -1;
    }

    public Boolean set(int n10, Boolean bl2) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        boolean[] blArray = this.array;
        int n12 = this.start;
        int bl3 = n12 + n10;
        boolean bl4 = blArray[bl3];
        n12 += n10;
        blArray[n12] = n10 = (int)(((Boolean)Preconditions.checkNotNull(bl2)).booleanValue() ? 1 : 0);
        return bl4;
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
        boolean[] blArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Booleans$BooleanArrayAsList booleans$BooleanArrayAsList = new Booleans$BooleanArrayAsList(blArray, n10, n13 += n11);
        return booleans$BooleanArrayAsList;
    }

    public boolean[] toBooleanArray() {
        boolean[] blArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(blArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 7;
        StringBuilder stringBuilder = new StringBuilder(n10);
        Object object = this.array;
        int n11 = this.start;
        n10 = object[n11];
        object = n10 != 0 ? (Object)"[true" : (Object)"[false";
        stringBuilder.append((String)object);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            Object object2 = this.array;
            n11 = object2[n10];
            object2 = n11 != 0 ? (Object)", true" : (Object)", false";
            stringBuilder.append((String)object2);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

