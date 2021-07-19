/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public class Longs$LongArrayAsList
extends AbstractList
implements RandomAccess,
Serializable {
    private static final long serialVersionUID;
    public final long[] array;
    public final int end;
    public final int start;

    public Longs$LongArrayAsList(long[] lArray) {
        int n10 = lArray.length;
        this(lArray, 0, n10);
    }

    public Longs$LongArrayAsList(long[] lArray, int n10, int n11) {
        this.array = lArray;
        this.start = n10;
        this.end = n11;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        int n10 = object instanceof Long;
        if (n10 == 0) return 0 != 0;
        long[] lArray = this.array;
        object = (Long)object;
        long l10 = (Long)object;
        int n11 = this.start;
        int n12 = this.end;
        if ((n11 = Longs.access$000(lArray, l10, n11, n12)) == (n10 = -1)) return 0 != 0;
        return 1 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n10 = object instanceof Longs$LongArrayAsList;
        if (n10 != 0) {
            object = (Longs$LongArrayAsList)object;
            n10 = this.size();
            int n11 = ((Longs$LongArrayAsList)object).size();
            if (n11 != n10) {
                return false;
            }
            for (n11 = 0; n11 < n10; ++n11) {
                long[] lArray = this.array;
                int n12 = this.start + n11;
                long l10 = lArray[n12];
                int n13 = ((Longs$LongArrayAsList)object).start + n11;
                long l11 = (lArray = ((Longs$LongArrayAsList)object).array)[n13];
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false) continue;
                return false;
            }
            return bl2;
        }
        return super.equals(object);
    }

    public Long get(int n10) {
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        long[] lArray = this.array;
        int n12 = this.start + n10;
        return lArray[n12];
    }

    public int hashCode() {
        int n10;
        int n11 = 1;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            n11 *= 31;
            long[] lArray = this.array;
            long l10 = lArray[i10];
            n10 = Longs.hashCode(l10);
            n11 += n10;
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object instanceof Long;
        if (n10 != 0) {
            long[] lArray = this.array;
            object = (Long)object;
            long l10 = (Long)object;
            int n11 = this.start;
            int n12 = this.end;
            if ((n11 = Longs.access$000(lArray, l10, n11, n12)) >= 0) {
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
        int n10 = object instanceof Long;
        if (n10 != 0) {
            long[] lArray = this.array;
            object = (Long)object;
            long l10 = (Long)object;
            int n11 = this.start;
            int n12 = this.end;
            if ((n11 = Longs.access$100(lArray, l10, n11, n12)) >= 0) {
                n10 = this.start;
                return n11 - n10;
            }
        }
        return -1;
    }

    public Long set(int n10, Long l10) {
        long l11;
        int n11 = this.size();
        Preconditions.checkElementIndex(n10, n11);
        long[] lArray = this.array;
        int n12 = this.start;
        int n13 = n12 + n10;
        long l12 = lArray[n13];
        lArray[n12 += n10] = l11 = ((Long)Preconditions.checkNotNull(l10)).longValue();
        return l12;
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
        long[] lArray = this.array;
        int n13 = this.start;
        n10 += n13;
        Longs$LongArrayAsList longs$LongArrayAsList = new Longs$LongArrayAsList(lArray, n10, n13 += n11);
        return longs$LongArrayAsList;
    }

    public long[] toLongArray() {
        long[] lArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(lArray, n10, n11);
    }

    public String toString() {
        int n10 = this.size() * 10;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append('[');
        long[] lArray = this.array;
        int n11 = this.start;
        long l10 = lArray[n11];
        stringBuilder.append(l10);
        n10 = this.start;
        while (++n10 < (n11 = this.end)) {
            stringBuilder.append(", ");
            long[] lArray2 = this.array;
            long l11 = lArray2[n10];
            stringBuilder.append(l11);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

