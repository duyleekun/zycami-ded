/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Bytes;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Bytes$ByteArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final byte[] array;
    public final int end;
    public final int start;

    public Bytes$ByteArrayAsList(byte[] byArray) {
        int n10 = byArray.length;
        this(byArray, 0, n10);
    }

    public Bytes$ByteArrayAsList(byte[] byArray, int n10, int n11) {
        this.array = byArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Byte;
        if (n10 == 0) return 0 != 0;
        byte[] byArray = this.array;
        object = (Byte)object;
        int n11 = ((Byte)object).byteValue();
        int n12 = this.start;
        int n13 = this.end;
        if ((n11 = Bytes.access$000(byArray, (byte)n11, n12, n13)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Bytes$ByteArrayAsList;
        if (n10 != 0) {
            object = (Bytes$ByteArrayAsList)object;
            n10 = this.size();
            int n11 = ((Bytes$ByteArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                byte[] byArray = this.array;
                int n12 = this.start + n11;
                byte by2 = byArray[n12];
                byte[] byArray2 = ((Bytes$ByteArrayAsList)object).array;
                int n13 = ((Bytes$ByteArrayAsList)object).start + n11;
                if (by2 == (n12 = byArray2[n13])) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Byte get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        byte[] byArray = this.array;
        int n12 = this.start + n10;
        return byArray[n12];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            byte[] byArray = this.array;
            n10 = Bytes.hashCode(byArray[i10]);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object instanceof Byte;
        if (n10 != 0) {
            byte[] byArray = this.array;
            object = (Byte)object;
            int n11 = ((Byte)object).byteValue();
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Bytes.access$000(byArray, (byte)n11, n12, n13)) >= 0) {
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
        int n10 = object instanceof Byte;
        if (n10 != 0) {
            byte[] byArray = this.array;
            object = (Byte)object;
            int n11 = ((Byte)object).byteValue();
            int n12 = this.start;
            int n13 = this.end;
            if ((n11 = Bytes.access$100(byArray, (byte)n11, n12, n13)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public Byte set(int n10, Byte by2) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        byte[] byArray = this.array;
        int n12 = this.start;
        byte by3 = n12 + n10;
        by3 = byArray[by3];
        n12 += n10;
        byArray[n12] = n10 = (int)((Byte)Preconditions.checkNotNull(by2)).byteValue();
        return by3;
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
        byte[] byArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Bytes$ByteArrayAsList bytes$ByteArrayAsList = new Bytes$ByteArrayAsList(byArray, n10, n13 += n11);
        return bytes$ByteArrayAsList;
    }

    public byte[] toByteArray() {
        byte[] byArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(byArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 5;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        byte[] byArray = this.array;
        int n11 = this.start;
        n10 = byArray[n11];
        stringBuilder.append(n10);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            stringBuilder.append(", ");
            byte[] byArray2 = this.array;
            n11 = byArray2[n10];
            stringBuilder.append(n11);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

