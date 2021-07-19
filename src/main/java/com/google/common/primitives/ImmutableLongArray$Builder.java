/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableLongArray;
import java.util.Collection;

public final class ImmutableLongArray$Builder {
    private long[] array;
    private int count = 0;

    public ImmutableLongArray$Builder(int n10) {
        long[] lArray = new long[n10];
        this.array = lArray;
    }

    private void ensureRoomFor(int n10) {
        int n11 = this.count + n10;
        long[] lArray = this.array;
        int n12 = lArray.length;
        if (n11 > n12) {
            n10 = ImmutableLongArray$Builder.expandedCapacity(lArray.length, n11);
            lArray = new long[n10];
            long[] lArray2 = this.array;
            n12 = this.count;
            System.arraycopy(lArray2, 0, lArray, 0, n12);
            this.array = lArray;
        }
    }

    private static int expandedCapacity(int n10, int n11) {
        if (n11 >= 0) {
            int n12 = n10 >> 1;
            if ((n10 = n10 + n12 + 1) < n11) {
                n10 = Integer.highestOneBit(n11 += -1) << 1;
            }
            if (n10 < 0) {
                n10 = -1 >>> 1;
            }
            return n10;
        }
        AssertionError assertionError = new AssertionError((Object)"cannot store more than MAX_VALUE elements");
        throw assertionError;
    }

    public ImmutableLongArray$Builder add(long l10) {
        int n10 = 1;
        this.ensureRoomFor(n10);
        long[] lArray = this.array;
        int n11 = this.count;
        lArray[n11] = l10;
        this.count = n11 += n10;
        return this;
    }

    public ImmutableLongArray$Builder addAll(ImmutableLongArray immutableLongArray) {
        int n10 = immutableLongArray.length();
        this.ensureRoomFor(n10);
        long[] lArray = ImmutableLongArray.access$000(immutableLongArray);
        int n11 = ImmutableLongArray.access$100(immutableLongArray);
        long[] lArray2 = this.array;
        int n12 = this.count;
        int n13 = immutableLongArray.length();
        System.arraycopy(lArray, n11, lArray2, n12, n13);
        n10 = this.count;
        int n14 = immutableLongArray.length();
        this.count = n10 += n14;
        return this;
    }

    public ImmutableLongArray$Builder addAll(Iterable object) {
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object = (Collection)object;
            return this.addAll((Collection)object);
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Long l10 = (Long)object.next();
            long l11 = l10;
            this.add(l11);
        }
        return this;
    }

    public ImmutableLongArray$Builder addAll(Collection object) {
        int n10 = object.size();
        this.ensureRoomFor(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            long l10;
            int n11;
            Long l11 = (Long)object.next();
            long[] lArray = this.array;
            int n12 = this.count;
            this.count = n11 = n12 + 1;
            lArray[n12] = l10 = l11.longValue();
        }
        return this;
    }

    public ImmutableLongArray$Builder addAll(long[] lArray) {
        int n10 = lArray.length;
        this.ensureRoomFor(n10);
        long[] lArray2 = this.array;
        int n11 = this.count;
        int n12 = lArray.length;
        System.arraycopy(lArray, 0, lArray2, n11, n12);
        n10 = this.count;
        int n13 = lArray.length;
        this.count = n10 += n13;
        return this;
    }

    public ImmutableLongArray build() {
        ImmutableLongArray immutableLongArray;
        int n10 = this.count;
        if (n10 == 0) {
            immutableLongArray = ImmutableLongArray.access$200();
        } else {
            long[] lArray = this.array;
            int n11 = this.count;
            immutableLongArray = new ImmutableLongArray(lArray, 0, n11, null);
        }
        return immutableLongArray;
    }
}

