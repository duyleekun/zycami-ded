/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.common.primitives.ImmutableLongArray$1;
import com.google.common.primitives.ImmutableLongArray$AsList;
import com.google.common.primitives.ImmutableLongArray$Builder;
import com.google.common.primitives.Longs;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class ImmutableLongArray
implements Serializable {
    private static final ImmutableLongArray EMPTY;
    private final long[] array;
    private final int end;
    private final transient int start;

    static {
        ImmutableLongArray immutableLongArray;
        long[] lArray = new long[]{};
        EMPTY = immutableLongArray = new ImmutableLongArray(lArray);
    }

    private ImmutableLongArray(long[] lArray) {
        int n10 = lArray.length;
        this(lArray, 0, n10);
    }

    private ImmutableLongArray(long[] lArray, int n10, int n11) {
        this.array = lArray;
        this.start = n10;
        this.end = n11;
    }

    public /* synthetic */ ImmutableLongArray(long[] lArray, int n10, int n11, ImmutableLongArray$1 immutableLongArray$1) {
        this(lArray, n10, n11);
    }

    public static /* synthetic */ long[] access$000(ImmutableLongArray immutableLongArray) {
        return immutableLongArray.array;
    }

    public static /* synthetic */ int access$100(ImmutableLongArray immutableLongArray) {
        return immutableLongArray.start;
    }

    public static /* synthetic */ ImmutableLongArray access$200() {
        return EMPTY;
    }

    public static ImmutableLongArray$Builder builder() {
        ImmutableLongArray$Builder immutableLongArray$Builder = new ImmutableLongArray$Builder(10);
        return immutableLongArray$Builder;
    }

    public static ImmutableLongArray$Builder builder(int n10) {
        ImmutableLongArray$Builder immutableLongArray$Builder;
        boolean bl2;
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            immutableLongArray$Builder = null;
        }
        Preconditions.checkArgument(bl2, "Invalid initialCapacity: %s", n10);
        immutableLongArray$Builder = new ImmutableLongArray$Builder(n10);
        return immutableLongArray$Builder;
    }

    public static ImmutableLongArray copyOf(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            return ImmutableLongArray.copyOf((Collection)iterable);
        }
        return ImmutableLongArray.builder().addAll(iterable).build();
    }

    public static ImmutableLongArray copyOf(Collection object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = EMPTY;
        } else {
            object = Longs.toArray((Collection)object);
            ImmutableLongArray immutableLongArray = new ImmutableLongArray((long[])object);
            object = immutableLongArray;
        }
        return object;
    }

    public static ImmutableLongArray copyOf(long[] object) {
        int n10 = ((long[])object).length;
        if (n10 == 0) {
            object = EMPTY;
        } else {
            int n11 = ((long[])object).length;
            object = Arrays.copyOf(object, n11);
            ImmutableLongArray immutableLongArray = new ImmutableLongArray((long[])object);
            object = immutableLongArray;
        }
        return object;
    }

    private boolean isPartialView() {
        long[] lArray;
        int n10;
        int n11 = this.start;
        n11 = n11 <= 0 && (n11 = this.end) >= (n10 = (lArray = this.array).length) ? 0 : 1;
        return n11 != 0;
    }

    public static ImmutableLongArray of() {
        return EMPTY;
    }

    public static ImmutableLongArray of(long l10) {
        long[] lArray = new long[]{l10};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long l11) {
        long[] lArray = new long[]{l10, l11};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long l11, long l12) {
        long[] lArray = new long[]{l10, l11, l12};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long l11, long l12, long l13) {
        long[] lArray = new long[]{l10, l11, l12, l13};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long l11, long l12, long l13, long l14) {
        long[] lArray = new long[]{l10, l11, l12, l13, l14};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long l11, long l12, long l13, long l14, long l15) {
        long[] lArray = new long[]{l10, l11, l12, l13, l14, l15};
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray);
        return immutableLongArray;
    }

    public static ImmutableLongArray of(long l10, long ... lArray) {
        long[] lArray2;
        int n10 = lArray.length;
        int n11 = 1;
        int n12 = 0x7FFFFFFE;
        if (n10 <= n12) {
            n10 = n11;
        } else {
            n10 = 0;
            lArray2 = null;
        }
        Preconditions.checkArgument(n10 != 0, "the total number of elements must fit in an int");
        lArray2 = new long[lArray.length + n11];
        lArray2[0] = l10;
        int n13 = lArray.length;
        System.arraycopy(lArray, 0, lArray2, n11, n13);
        ImmutableLongArray immutableLongArray = new ImmutableLongArray(lArray2);
        return immutableLongArray;
    }

    public List asList() {
        ImmutableLongArray$AsList immutableLongArray$AsList = new ImmutableLongArray$AsList(this, null);
        return immutableLongArray$AsList;
    }

    public boolean contains(long l10) {
        int n10 = this.indexOf(l10);
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof ImmutableLongArray;
        if (n11 == 0) {
            return false;
        }
        object = (ImmutableLongArray)object;
        n11 = this.length();
        if (n11 != (n10 = ((ImmutableLongArray)object).length())) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = this.length()); ++n11) {
            long l10;
            long l11 = this.get(n11);
            long l12 = l11 - (l10 = ((ImmutableLongArray)object).get(n11));
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 == 0) continue;
            return false;
        }
        return bl2;
    }

    public long get(int n10) {
        int n11 = this.length();
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

    public int indexOf(long l10) {
        int n10;
        for (int i10 = this.start; i10 < (n10 = this.end); ++i10) {
            long[] lArray = this.array;
            long l11 = lArray[i10];
            long l12 = l11 - l10;
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 != 0) continue;
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

    public int lastIndexOf(long l10) {
        int n10;
        for (int i10 = this.end + -1; i10 >= (n10 = this.start); i10 += -1) {
            long[] lArray = this.array;
            long l11 = lArray[i10];
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object != false) continue;
            return i10 - n10;
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
        ImmutableLongArray immutableLongArray = bl2 ? EMPTY : this;
        return immutableLongArray;
    }

    public ImmutableLongArray subArray(int n10, int n11) {
        ImmutableLongArray immutableLongArray;
        int n12 = this.length();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        if (n10 == n11) {
            immutableLongArray = EMPTY;
        } else {
            ImmutableLongArray immutableLongArray2;
            long[] lArray = this.array;
            int n13 = this.start;
            n10 += n13;
            immutableLongArray = immutableLongArray2 = new ImmutableLongArray(lArray, n10, n13 += n11);
        }
        return immutableLongArray;
    }

    public long[] toArray() {
        long[] lArray = this.array;
        int n10 = this.start;
        int n11 = this.end;
        return Arrays.copyOfRange(lArray, n10, n11);
    }

    public String toString() {
        boolean bl2 = this.isEmpty();
        if (bl2) {
            return "[]";
        }
        int n10 = this.length() * 5;
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

    public ImmutableLongArray trimmed() {
        ImmutableLongArray immutableLongArray;
        boolean bl2 = this.isPartialView();
        if (bl2) {
            long[] lArray = this.toArray();
            immutableLongArray = new ImmutableLongArray(lArray);
        } else {
            immutableLongArray = this;
        }
        return immutableLongArray;
    }

    public Object writeReplace() {
        return this.trimmed();
    }
}

