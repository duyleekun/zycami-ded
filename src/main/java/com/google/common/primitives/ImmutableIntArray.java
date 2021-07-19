/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.ImmutableIntArray$1;
import com.google.common.primitives.ImmutableIntArray$AsList;
import com.google.common.primitives.ImmutableIntArray$Builder;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ImmutableIntArray
implements Serializable {
    private static final ImmutableIntArray EMPTY;
    private final int[] array;
    private final int end;
    private final transient int start;

    static {
        ImmutableIntArray immutableIntArray;
        int[] nArray = new int[]{};
        EMPTY = immutableIntArray = new ImmutableIntArray(nArray);
    }

    private ImmutableIntArray(int[] nArray) {
        int n10 = nArray.length;
        this(nArray, 0, n10);
    }

    private ImmutableIntArray(int[] nArray, int n10, int n11) {
        this.array = nArray;
        this.start = n10;
        this.end = n11;
    }

    public /* synthetic */ ImmutableIntArray(int[] nArray, int n10, int n11, ImmutableIntArray$1 immutableIntArray$1) {
        this(nArray, n10, n11);
    }

    public static /* synthetic */ int[] access$000(ImmutableIntArray immutableIntArray) {
        return immutableIntArray.array;
    }

    public static /* synthetic */ int access$100(ImmutableIntArray immutableIntArray) {
        return immutableIntArray.start;
    }

    public static /* synthetic */ ImmutableIntArray access$200() {
        return EMPTY;
    }

    public static ImmutableIntArray$Builder builder() {
        ImmutableIntArray$Builder immutableIntArray$Builder = new ImmutableIntArray$Builder(10);
        return immutableIntArray$Builder;
    }

    public static ImmutableIntArray$Builder builder(int n10) {
        ImmutableIntArray$Builder immutableIntArray$Builder;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            immutableIntArray$Builder = null;
        }
        Preconditions.checkArgument(bl2, "Invalid initialCapacity: %s", n10);
        immutableIntArray$Builder = new ImmutableIntArray$Builder(n10);
        return immutableIntArray$Builder;
    }

    public static ImmutableIntArray copyOf(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ImmutableIntArray.copyOf((Collection)iterable);
        }
        return ImmutableIntArray.builder().addAll(iterable).build();
    }

    public static ImmutableIntArray copyOf(Collection object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = EMPTY;
        } else {
            object = Ints.toArray((Collection)object);
            ImmutableIntArray immutableIntArray = new ImmutableIntArray((int[])object);
            object = immutableIntArray;
        }
        return object;
    }

    public static ImmutableIntArray copyOf(int[] object) {
        int n10 = ((int[])object).length;
        if (n10 == 0) {
            object = EMPTY;
        } else {
            int n11 = ((int[])object).length;
            object = Arrays.copyOf(object, n11);
            ImmutableIntArray immutableIntArray = new ImmutableIntArray((int[])object);
            object = immutableIntArray;
        }
        return object;
    }

    private boolean isPartialView() {
        int[] nArray;
        int n10;
        int n11 = this.start;
        n11 = n11 <= 0 && (n11 = this.end) >= (n10 = (nArray = this.array).length) ? 0 : 1;
        return n11 != 0;
    }

    public static ImmutableIntArray of() {
        return EMPTY;
    }

    public static ImmutableIntArray of(int n10) {
        int[] nArray = new int[]{n10};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int n11) {
        int[] nArray = new int[]{n10, n11};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int n11, int n12) {
        int[] nArray = new int[]{n10, n11, n12};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int n11, int n12, int n13) {
        int[] nArray = new int[]{n10, n11, n12, n13};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int n11, int n12, int n13, int n14) {
        int[] nArray = new int[]{n10, n11, n12, n13, n14};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int n11, int n12, int n13, int n14, int n15) {
        int[] nArray = new int[]{n10, n11, n12, n13, n14, n15};
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray);
        return immutableIntArray;
    }

    public static ImmutableIntArray of(int n10, int ... nArray) {
        int[] nArray2;
        int n11 = nArray.length;
        int n12 = 1;
        int n13 = 0x7FFFFFFE;
        if (n11 <= n13) {
            n11 = n12;
        } else {
            n11 = 0;
            nArray2 = null;
        }
        Preconditions.checkArgument(n11 != 0, "the total number of elements must fit in an int");
        nArray2 = new int[nArray.length + n12];
        nArray2[0] = n10;
        n10 = nArray.length;
        System.arraycopy(nArray, 0, nArray2, n12, n10);
        ImmutableIntArray immutableIntArray = new ImmutableIntArray(nArray2);
        return immutableIntArray;
    }

    public List asList() {
        ImmutableIntArray$AsList immutableIntArray$AsList = new ImmutableIntArray$AsList(this, null);
        return immutableIntArray$AsList;
    }

    public boolean contains(int n10) {
        n10 = (n10 = this.indexOf(n10)) >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof ImmutableIntArray;
        if (n11 == 0) {
            return false;
        }
        object = (ImmutableIntArray)object;
        n11 = this.length();
        if (n11 != (n10 = ((ImmutableIntArray)object).length())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.length()); ++n11) {
            int n12;
            n10 = this.get(n11);
            if (n10 == (n12 = ((ImmutableIntArray)object).get(n11))) continue;
            return false;
        }
        return bl2;
    }

    public int get(int n10) {
        int n11 = this.length();
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

    public int indexOf(int n10) {
        int n11;
        for (int i10 = this.start; i10 < (n11 = this.end); ++i10) {
            int[] nArray = this.array;
            n11 = nArray[i10];
            if (n11 != n10) continue;
            n10 = this.start;
            return i10 - n10;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.end;
        int n11 = this.start;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }

    public int lastIndexOf(int n10) {
        int n11;
        for (int i10 = this.end + -1; i10 >= (n11 = this.start); i10 += -1) {
            int[] nArray = this.array;
            int n12 = nArray[i10];
            if (n12 != n10) continue;
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
        ImmutableIntArray immutableIntArray = bl2 ? EMPTY : this;
        return immutableIntArray;
    }

    public ImmutableIntArray subArray(int n10, int n11) {
        ImmutableIntArray immutableIntArray;
        int n12 = this.length();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            immutableIntArray = EMPTY;
        } else {
            ImmutableIntArray immutableIntArray2;
            int[] nArray = this.array;
            int n13 = this.start;
            n10 += n13;
            immutableIntArray = immutableIntArray2 = new ImmutableIntArray(nArray, n10, n13 += n11);
        }
        return immutableIntArray;
    }

    public int[] toArray() {
        int[] nArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(nArray, n10, n11);
    }

    public String toString() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "[]";
        }
        int n10 = this.length() * 5;
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

    public ImmutableIntArray trimmed() {
        ImmutableIntArray immutableIntArray;
        boolean bl2 = this.isPartialView();
        if (bl2) {
            int[] nArray = this.toArray();
            immutableIntArray = new ImmutableIntArray(nArray);
        } else {
            immutableIntArray = this;
        }
        return immutableIntArray;
    }

    public Object writeReplace() {
        return this.trimmed();
    }
}

