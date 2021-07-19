/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableIntArray;
import java.util.Collection;

public final class ImmutableIntArray$Builder {
    private int[] array;
    private int count = 0;

    public ImmutableIntArray$Builder(int n10) {
        int[] nArray = new int[n10];
        this.array = nArray;
    }

    private void ensureRoomFor(int n10) {
        int n11 = this.count + n10;
        int[] nArray = this.array;
        int n12 = nArray.length;
        if (n11 > n12) {
            n10 = ImmutableIntArray$Builder.expandedCapacity(nArray.length, n11);
            nArray = new int[n10];
            int[] nArray2 = this.array;
            n12 = this.count;
            System.arraycopy(nArray2, 0, nArray, 0, n12);
            this.array = nArray;
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

    public ImmutableIntArray$Builder add(int n10) {
        int n11 = 1;
        this.ensureRoomFor(n11);
        int[] nArray = this.array;
        int n12 = this.count;
        nArray[n12] = n10;
        this.count = n12 += n11;
        return this;
    }

    public ImmutableIntArray$Builder addAll(ImmutableIntArray immutableIntArray) {
        int n10 = immutableIntArray.length();
        this.ensureRoomFor(n10);
        int[] nArray = ImmutableIntArray.access$000(immutableIntArray);
        int n11 = ImmutableIntArray.access$100(immutableIntArray);
        int[] nArray2 = this.array;
        int n12 = this.count;
        int n13 = immutableIntArray.length();
        System.arraycopy(nArray, n11, nArray2, n12, n13);
        n10 = this.count;
        int n14 = immutableIntArray.length();
        this.count = n10 += n14;
        return this;
    }

    public ImmutableIntArray$Builder addAll(Iterable object) {
        int n10 = object instanceof Collection;
        if (n10 != 0) {
            object = (Collection)object;
            return this.addAll((Collection)object);
        }
        object = object.iterator();
        while ((n10 = object.hasNext()) != 0) {
            Integer n11 = (Integer)object.next();
            n10 = n11;
            this.add(n10);
        }
        return this;
    }

    public ImmutableIntArray$Builder addAll(Collection object) {
        int n10 = object.size();
        this.ensureRoomFor(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            int n11;
            Integer n12 = (Integer)object.next();
            int[] nArray = this.array;
            int n13 = this.count;
            this.count = n11 = n13 + 1;
            nArray[n13] = n10 = n12.intValue();
        }
        return this;
    }

    public ImmutableIntArray$Builder addAll(int[] nArray) {
        int n10 = nArray.length;
        this.ensureRoomFor(n10);
        int[] nArray2 = this.array;
        int n11 = this.count;
        int n12 = nArray.length;
        System.arraycopy(nArray, 0, nArray2, n11, n12);
        n10 = this.count;
        int n13 = nArray.length;
        this.count = n10 += n13;
        return this;
    }

    public ImmutableIntArray build() {
        ImmutableIntArray immutableIntArray;
        int n10 = this.count;
        if (n10 == 0) {
            immutableIntArray = ImmutableIntArray.access$200();
        } else {
            int[] nArray = this.array;
            int n11 = this.count;
            immutableIntArray = new ImmutableIntArray(nArray, 0, n11, null);
        }
        return immutableIntArray;
    }
}

