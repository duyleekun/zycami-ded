/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.primitives.ImmutableDoubleArray;
import java.util.Collection;

public final class ImmutableDoubleArray$Builder {
    private double[] array;
    private int count = 0;

    public ImmutableDoubleArray$Builder(int n10) {
        double[] dArray = new double[n10];
        this.array = dArray;
    }

    private void ensureRoomFor(int n10) {
        int n11 = this.count + n10;
        double[] dArray = this.array;
        int n12 = dArray.length;
        if (n11 > n12) {
            n10 = ImmutableDoubleArray$Builder.expandedCapacity(dArray.length, n11);
            dArray = new double[n10];
            double[] dArray2 = this.array;
            n12 = this.count;
            System.arraycopy(dArray2, 0, dArray, 0, n12);
            this.array = dArray;
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

    public ImmutableDoubleArray$Builder add(double d10) {
        int n10 = 1;
        this.ensureRoomFor(n10);
        double[] dArray = this.array;
        int n11 = this.count;
        dArray[n11] = d10;
        this.count = n11 += n10;
        return this;
    }

    public ImmutableDoubleArray$Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
        int n10 = immutableDoubleArray.length();
        this.ensureRoomFor(n10);
        double[] dArray = ImmutableDoubleArray.access$000(immutableDoubleArray);
        int n11 = ImmutableDoubleArray.access$100(immutableDoubleArray);
        double[] dArray2 = this.array;
        int n12 = this.count;
        int n13 = immutableDoubleArray.length();
        System.arraycopy(dArray, n11, dArray2, n12, n13);
        n10 = this.count;
        int n14 = immutableDoubleArray.length();
        this.count = n10 += n14;
        return this;
    }

    public ImmutableDoubleArray$Builder addAll(Iterable object) {
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object = (Collection)object;
            return this.addAll((Collection)object);
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Double d10 = (Double)object.next();
            double d11 = d10;
            this.add(d11);
        }
        return this;
    }

    public ImmutableDoubleArray$Builder addAll(Collection object) {
        int n10 = object.size();
        this.ensureRoomFor(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            double d10;
            int n11;
            Double d11 = (Double)object.next();
            double[] dArray = this.array;
            int n12 = this.count;
            this.count = n11 = n12 + 1;
            dArray[n12] = d10 = d11.doubleValue();
        }
        return this;
    }

    public ImmutableDoubleArray$Builder addAll(double[] dArray) {
        int n10 = dArray.length;
        this.ensureRoomFor(n10);
        double[] dArray2 = this.array;
        int n11 = this.count;
        int n12 = dArray.length;
        System.arraycopy(dArray, 0, dArray2, n11, n12);
        n10 = this.count;
        int n13 = dArray.length;
        this.count = n10 += n13;
        return this;
    }

    public ImmutableDoubleArray build() {
        ImmutableDoubleArray immutableDoubleArray;
        int n10 = this.count;
        if (n10 == 0) {
            immutableDoubleArray = ImmutableDoubleArray.access$200();
        } else {
            double[] dArray = this.array;
            int n11 = this.count;
            immutableDoubleArray = new ImmutableDoubleArray(dArray, 0, n11, null);
        }
        return immutableDoubleArray;
    }
}

