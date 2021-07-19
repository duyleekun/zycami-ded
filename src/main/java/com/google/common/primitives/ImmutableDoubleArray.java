/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles;
import com.google.common.primitives.ImmutableDoubleArray$1;
import com.google.common.primitives.ImmutableDoubleArray$AsList;
import com.google.common.primitives.ImmutableDoubleArray$Builder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ImmutableDoubleArray
implements Serializable {
    private static final ImmutableDoubleArray EMPTY;
    private final double[] array;
    private final int end;
    private final transient int start;

    static {
        ImmutableDoubleArray immutableDoubleArray;
        double[] dArray = new double[]{};
        EMPTY = immutableDoubleArray = new ImmutableDoubleArray(dArray);
    }

    private ImmutableDoubleArray(double[] dArray) {
        int n10 = dArray.length;
        this(dArray, 0, n10);
    }

    private ImmutableDoubleArray(double[] dArray, int n10, int n11) {
        this.array = dArray;
        this.start = n10;
        this.end = n11;
    }

    public /* synthetic */ ImmutableDoubleArray(double[] dArray, int n10, int n11, ImmutableDoubleArray$1 immutableDoubleArray$1) {
        this(dArray, n10, n11);
    }

    public static /* synthetic */ double[] access$000(ImmutableDoubleArray immutableDoubleArray) {
        return immutableDoubleArray.array;
    }

    public static /* synthetic */ int access$100(ImmutableDoubleArray immutableDoubleArray) {
        return immutableDoubleArray.start;
    }

    public static /* synthetic */ ImmutableDoubleArray access$200() {
        return EMPTY;
    }

    public static /* synthetic */ boolean access$500(double d10, double d11) {
        return ImmutableDoubleArray.areEqual(d10, d11);
    }

    private static boolean areEqual(double d10, double d11) {
        long l10;
        long l11 = Double.doubleToLongBits(d10);
        long l12 = l11 - (l10 = Double.doubleToLongBits(d11));
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public static ImmutableDoubleArray$Builder builder() {
        ImmutableDoubleArray$Builder immutableDoubleArray$Builder = new ImmutableDoubleArray$Builder(10);
        return immutableDoubleArray$Builder;
    }

    public static ImmutableDoubleArray$Builder builder(int n10) {
        ImmutableDoubleArray$Builder immutableDoubleArray$Builder;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            immutableDoubleArray$Builder = null;
        }
        Preconditions.checkArgument(bl2, "Invalid initialCapacity: %s", n10);
        immutableDoubleArray$Builder = new ImmutableDoubleArray$Builder(n10);
        return immutableDoubleArray$Builder;
    }

    public static ImmutableDoubleArray copyOf(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ImmutableDoubleArray.copyOf((Collection)iterable);
        }
        return ImmutableDoubleArray.builder().addAll(iterable).build();
    }

    public static ImmutableDoubleArray copyOf(Collection object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = EMPTY;
        } else {
            object = Doubles.toArray((Collection)object);
            ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray((double[])object);
            object = immutableDoubleArray;
        }
        return object;
    }

    public static ImmutableDoubleArray copyOf(double[] object) {
        int n10 = ((double[])object).length;
        if (n10 == 0) {
            object = EMPTY;
        } else {
            int n11 = ((double[])object).length;
            object = Arrays.copyOf(object, n11);
            ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray((double[])object);
            object = immutableDoubleArray;
        }
        return object;
    }

    private boolean isPartialView() {
        double[] dArray;
        int n10;
        int n11 = this.start;
        n11 = n11 <= 0 && (n11 = this.end) >= (n10 = (dArray = this.array).length) ? 0 : 1;
        return n11 != 0;
    }

    public static ImmutableDoubleArray of() {
        return EMPTY;
    }

    public static ImmutableDoubleArray of(double d10) {
        double[] dArray = new double[]{d10};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double d11) {
        double[] dArray = new double[]{d10, d11};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12) {
        double[] dArray = new double[]{d10, d11, d12};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13) {
        double[] dArray = new double[]{d10, d11, d12, d13};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14) {
        double[] dArray = new double[]{d10, d11, d12, d13, d14};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double d11, double d12, double d13, double d14, double d15) {
        double[] dArray = new double[]{d10, d11, d12, d13, d14, d15};
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray);
        return immutableDoubleArray;
    }

    public static ImmutableDoubleArray of(double d10, double ... dArray) {
        double[] dArray2;
        int n10 = dArray.length;
        int n11 = 1;
        int n12 = 0x7FFFFFFE;
        if (n10 <= n12) {
            n10 = n11;
        } else {
            n10 = 0;
            dArray2 = null;
        }
        Preconditions.checkArgument(n10 != 0, "the total number of elements must fit in an int");
        dArray2 = new double[dArray.length + n11];
        dArray2[0] = d10;
        int n13 = dArray.length;
        System.arraycopy(dArray, 0, dArray2, n11, n13);
        ImmutableDoubleArray immutableDoubleArray = new ImmutableDoubleArray(dArray2);
        return immutableDoubleArray;
    }

    public List asList() {
        ImmutableDoubleArray$AsList immutableDoubleArray$AsList = new ImmutableDoubleArray$AsList(this, null);
        return immutableDoubleArray$AsList;
    }

    public boolean contains(double d10) {
        int n10 = this.indexOf(d10);
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof ImmutableDoubleArray;
        if (n11 == 0) {
            return false;
        }
        object = (ImmutableDoubleArray)object;
        n11 = this.length();
        if (n11 != (n10 = ((ImmutableDoubleArray)object).length())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.length()); ++n11) {
            double d10;
            double d11 = this.get(n11);
            n10 = (int)(ImmutableDoubleArray.areEqual(d11, d10 = ((ImmutableDoubleArray)object).get(n11)) ? 1 : 0);
            if (n10 != 0) continue;
            return false;
        }
        return bl2;
    }

    public double get(int n10) {
        int n11 = this.length();
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

    public int indexOf(double d10) {
        int n10;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            double[] dArray = this.array;
            double d11 = dArray[i10];
            n10 = (int)(ImmutableDoubleArray.areEqual(d11, d10) ? 1 : 0);
            if (n10 == 0) continue;
            int n11 = this.start;
            return i10 - n11;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.end;
        int n11 = this.start;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public int lastIndexOf(double d10) {
        int n10;
        for (int i10 = this.end + -1; i10 >= (n10 = this.start); i10 += -1) {
            double[] dArray = this.array;
            double d11 = dArray[i10];
            n10 = (int)(ImmutableDoubleArray.areEqual(d11, d10) ? 1 : 0);
            if (n10 == 0) continue;
            int n11 = this.start;
            return i10 - n11;
        }
        return -1;
    }

    public int length() {
        int n10 = this.end;
        int n11 = this.start;
        return n10 - n11;
    }

    public Object readResolve() {
        boolean bl2 = this.isEmpty();
        ImmutableDoubleArray immutableDoubleArray = bl2 ? EMPTY : this;
        return immutableDoubleArray;
    }

    public ImmutableDoubleArray subArray(int n10, int n11) {
        ImmutableDoubleArray immutableDoubleArray;
        int n12 = this.length();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            immutableDoubleArray = EMPTY;
        } else {
            ImmutableDoubleArray immutableDoubleArray2;
            double[] dArray = this.array;
            int n13 = this.start;
            n10 += n13;
            immutableDoubleArray = immutableDoubleArray2 = new ImmutableDoubleArray(dArray, n10, n13 += n11);
        }
        return immutableDoubleArray;
    }

    public double[] toArray() {
        double[] dArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(dArray, n10, n11);
    }

    public String toString() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "[]";
        }
        int n10 = this.length() * 5;
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

    public ImmutableDoubleArray trimmed() {
        ImmutableDoubleArray immutableDoubleArray;
        boolean bl2 = this.isPartialView();
        if (bl2) {
            double[] dArray = this.toArray();
            immutableDoubleArray = new ImmutableDoubleArray(dArray);
        } else {
            immutableDoubleArray = this;
        }
        return immutableDoubleArray;
    }

    public Object writeReplace() {
        return this.trimmed();
    }
}

