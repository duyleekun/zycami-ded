/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.BoundType;
import com.google.common.collect.Cut;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Iterables;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range$1;
import com.google.common.collect.Range$LowerBoundFn;
import com.google.common.collect.Range$RangeLexOrdering;
import com.google.common.collect.Range$UpperBoundFn;
import com.google.common.collect.RangeGwtSerializationDependencies;
import java.io.Serializable;
import java.util.Comparator;
import java.util.SortedSet;

public final class Range
extends RangeGwtSerializationDependencies
implements Predicate,
Serializable {
    private static final Range ALL;
    private static final long serialVersionUID;
    public final Cut lowerBound;
    public final Cut upperBound;

    static {
        Range range;
        Cut cut = Cut.belowAll();
        Cut cut2 = Cut.aboveAll();
        ALL = range = new Range(cut, cut2);
    }

    private Range(Cut object, Cut cut) {
        Serializable serializable;
        this.lowerBound = serializable = (Cut)Preconditions.checkNotNull(object);
        this.upperBound = serializable = (Cut)Preconditions.checkNotNull(cut);
        int n10 = ((Cut)object).compareTo(cut);
        if (n10 <= 0 && object != (serializable = Cut.aboveAll()) && cut != (serializable = Cut.belowAll())) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid range: ");
        object = Range.toString((Cut)object, cut);
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        super((String)object);
        throw serializable;
    }

    public static Range all() {
        return ALL;
    }

    public static Range atLeast(Comparable comparable) {
        comparable = Cut.belowValue(comparable);
        Cut cut = Cut.aboveAll();
        return Range.create((Cut)comparable, cut);
    }

    public static Range atMost(Comparable comparable) {
        Cut cut = Cut.belowAll();
        comparable = Cut.aboveValue(comparable);
        return Range.create(cut, (Cut)comparable);
    }

    private static SortedSet cast(Iterable iterable) {
        return (SortedSet)iterable;
    }

    public static Range closed(Comparable comparable, Comparable comparable2) {
        comparable = Cut.belowValue(comparable);
        comparable2 = Cut.aboveValue(comparable2);
        return Range.create((Cut)comparable, (Cut)comparable2);
    }

    public static Range closedOpen(Comparable comparable, Comparable comparable2) {
        comparable = Cut.belowValue(comparable);
        comparable2 = Cut.belowValue(comparable2);
        return Range.create((Cut)comparable, (Cut)comparable2);
    }

    public static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static Range create(Cut cut, Cut cut2) {
        Range range = new Range(cut, cut2);
        return range;
    }

    public static Range downTo(Comparable object, BoundType boundType) {
        int[] nArray = Range$1.$SwitchMap$com$google$common$collect$BoundType;
        int n10 = boundType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                return Range.atLeast((Comparable)object);
            }
            object = new AssertionError();
            throw object;
        }
        return Range.greaterThan((Comparable)object);
    }

    public static Range encloseAll(Iterable object) {
        boolean bl2;
        Object object2;
        Object object3;
        Object object4;
        Preconditions.checkNotNull(object);
        boolean bl3 = object instanceof SortedSet;
        if (bl3) {
            object4 = Range.cast((Iterable)object);
            object3 = object4.comparator();
            object2 = Ordering.natural();
            bl2 = object2.equals(object3);
            if (bl2 || object3 == null) {
                object = (Comparable)object4.first();
                object4 = (Comparable)object4.last();
                return Range.closed((Comparable)object, (Comparable)object4);
            }
        }
        object = object.iterator();
        object3 = object4 = (Comparable)Preconditions.checkNotNull(object.next());
        while (bl2 = object.hasNext()) {
            object2 = (Comparable)Preconditions.checkNotNull(object.next());
            object4 = (Comparable)Ordering.natural().min(object4, object2);
            Ordering ordering = Ordering.natural();
            object3 = (Comparable)ordering.max(object3, object2);
        }
        return Range.closed((Comparable)object4, (Comparable)object3);
    }

    public static Range greaterThan(Comparable comparable) {
        comparable = Cut.aboveValue(comparable);
        Cut cut = Cut.aboveAll();
        return Range.create((Cut)comparable, cut);
    }

    public static Range lessThan(Comparable comparable) {
        Cut cut = Cut.belowAll();
        comparable = Cut.belowValue(comparable);
        return Range.create(cut, (Cut)comparable);
    }

    public static Function lowerBoundFn() {
        return Range$LowerBoundFn.INSTANCE;
    }

    public static Range open(Comparable comparable, Comparable comparable2) {
        comparable = Cut.aboveValue(comparable);
        comparable2 = Cut.belowValue(comparable2);
        return Range.create((Cut)comparable, (Cut)comparable2);
    }

    public static Range openClosed(Comparable comparable, Comparable comparable2) {
        comparable = Cut.aboveValue(comparable);
        comparable2 = Cut.aboveValue(comparable2);
        return Range.create((Cut)comparable, (Cut)comparable2);
    }

    public static Range range(Comparable comparable, BoundType object, Comparable comparable2, BoundType boundType) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull((Object)boundType);
        BoundType boundType2 = BoundType.OPEN;
        comparable = object == boundType2 ? Cut.aboveValue(comparable) : Cut.belowValue(comparable);
        object = boundType == boundType2 ? Cut.belowValue(comparable2) : Cut.aboveValue(comparable2);
        return Range.create((Cut)comparable, (Cut)object);
    }

    public static Ordering rangeLexOrdering() {
        return Range$RangeLexOrdering.INSTANCE;
    }

    public static Range singleton(Comparable comparable) {
        return Range.closed(comparable, comparable);
    }

    private static String toString(Cut cut, Cut cut2) {
        StringBuilder stringBuilder = new StringBuilder(16);
        cut.describeAsLowerBound(stringBuilder);
        stringBuilder.append("..");
        cut2.describeAsUpperBound(stringBuilder);
        return stringBuilder.toString();
    }

    public static Range upTo(Comparable object, BoundType boundType) {
        int[] nArray = Range$1.$SwitchMap$com$google$common$collect$BoundType;
        int n10 = boundType.ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 == n11) {
                return Range.atMost((Comparable)object);
            }
            object = new AssertionError();
            throw object;
        }
        return Range.lessThan((Comparable)object);
    }

    public static Function upperBoundFn() {
        return Range$UpperBoundFn.INSTANCE;
    }

    public boolean apply(Comparable comparable) {
        return this.contains(comparable);
    }

    public Range canonical(DiscreteDomain object) {
        Preconditions.checkNotNull(object);
        Cut cut = this.lowerBound.canonical((DiscreteDomain)object);
        object = this.upperBound.canonical((DiscreteDomain)object);
        Cut cut2 = this.lowerBound;
        object = cut == cut2 && object == (cut2 = this.upperBound) ? this : Range.create(cut, (Cut)object);
        return object;
    }

    public boolean contains(Comparable comparable) {
        boolean bl2;
        Preconditions.checkNotNull(comparable);
        Cut cut = this.lowerBound;
        boolean bl3 = cut.isLessThan(comparable);
        if (bl3 && !(bl2 = (cut = this.upperBound).isLessThan(comparable))) {
            bl2 = true;
        } else {
            bl2 = false;
            comparable = null;
        }
        return bl2;
    }

    public boolean containsAll(Iterable object) {
        Object object2;
        boolean bl2 = Iterables.isEmpty((Iterable)object);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        bl2 = object instanceof SortedSet;
        if (bl2) {
            object2 = Range.cast((Iterable)object);
            Comparator comparator = object2.comparator();
            Ordering ordering = Ordering.natural();
            boolean bl4 = ordering.equals(comparator);
            if (bl4 || comparator == null) {
                object = (Comparable)object2.first();
                boolean bl5 = this.contains((Comparable)object);
                if (!bl5 || !(bl5 = this.contains((Comparable)(object = (Comparable)object2.last())))) {
                    bl3 = false;
                }
                return bl3;
            }
        }
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Comparable)object.next();
            bl2 = this.contains((Comparable)object2);
            if (bl2) continue;
            return false;
        }
        return bl3;
    }

    public boolean encloses(Range serializable) {
        int n10;
        Cut cut = this.lowerBound;
        Cut cut2 = serializable.lowerBound;
        int n11 = cut.compareTo(cut2);
        if (n11 <= 0 && (n10 = (cut = this.upperBound).compareTo((Cut)(serializable = serializable.upperBound))) >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            serializable = null;
        }
        return n10 != 0;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof Range;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            object = (Range)object;
            Cut cut = this.lowerBound;
            Cut cut2 = ((Range)object).lowerBound;
            bl2 = cut.equals(cut2);
            if (bl2 && (bl4 = (cut = this.upperBound).equals(object = ((Range)object).upperBound))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public Range gap(Range serializable) {
        Cut cut = this.lowerBound;
        Serializable serializable2 = serializable.lowerBound;
        int n10 = cut.compareTo((Cut)serializable2);
        if (n10 < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            cut = null;
        }
        serializable2 = n10 != 0 ? this : serializable;
        if (n10 == 0) {
            serializable = this;
        }
        cut = ((Range)serializable2).upperBound;
        serializable = serializable.lowerBound;
        return Range.create(cut, (Cut)serializable);
    }

    public boolean hasLowerBound() {
        boolean bl2;
        Cut cut = this.lowerBound;
        Cut cut2 = Cut.belowAll();
        if (cut != cut2) {
            bl2 = true;
        } else {
            bl2 = false;
            cut = null;
        }
        return bl2;
    }

    public boolean hasUpperBound() {
        boolean bl2;
        Cut cut = this.upperBound;
        Cut cut2 = Cut.aboveAll();
        if (cut != cut2) {
            bl2 = true;
        } else {
            bl2 = false;
            cut = null;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.lowerBound.hashCode() * 31;
        int n11 = this.upperBound.hashCode();
        return n10 + n11;
    }

    public Range intersection(Range serializable) {
        Cut cut = this.lowerBound;
        Cut cut2 = serializable.lowerBound;
        int n10 = cut.compareTo(cut2);
        cut2 = this.upperBound;
        Cut cut3 = serializable.upperBound;
        int n11 = cut2.compareTo(cut3);
        if (n10 >= 0 && n11 <= 0) {
            return this;
        }
        if (n10 <= 0 && n11 >= 0) {
            return serializable;
        }
        cut = n10 >= 0 ? this.lowerBound : serializable.lowerBound;
        serializable = n11 <= 0 ? this.upperBound : serializable.upperBound;
        return Range.create(cut, (Cut)serializable);
    }

    public boolean isConnected(Range serializable) {
        int n10;
        Cut cut = this.lowerBound;
        Cut cut2 = ((Range)serializable).upperBound;
        int n11 = cut.compareTo(cut2);
        if (n11 <= 0 && (n10 = ((Cut)(serializable = ((Range)serializable).lowerBound)).compareTo(cut = this.upperBound)) <= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            serializable = null;
        }
        return n10 != 0;
    }

    public boolean isEmpty() {
        Cut cut = this.lowerBound;
        Cut cut2 = this.upperBound;
        return cut.equals(cut2);
    }

    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    public Comparable lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    public Object readResolve() {
        Range range = ALL;
        boolean bl2 = this.equals(range);
        if (bl2) {
            return Range.all();
        }
        return this;
    }

    public Range span(Range serializable) {
        Cut cut = this.lowerBound;
        Cut cut2 = serializable.lowerBound;
        int n10 = cut.compareTo(cut2);
        cut2 = this.upperBound;
        Cut cut3 = serializable.upperBound;
        int n11 = cut2.compareTo(cut3);
        if (n10 <= 0 && n11 >= 0) {
            return this;
        }
        if (n10 >= 0 && n11 <= 0) {
            return serializable;
        }
        cut = n10 <= 0 ? this.lowerBound : serializable.lowerBound;
        serializable = n11 >= 0 ? this.upperBound : serializable.upperBound;
        return Range.create(cut, (Cut)serializable);
    }

    public String toString() {
        Cut cut = this.lowerBound;
        Cut cut2 = this.upperBound;
        return Range.toString(cut, cut2);
    }

    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    public Comparable upperEndpoint() {
        return this.upperBound.endpoint();
    }
}

