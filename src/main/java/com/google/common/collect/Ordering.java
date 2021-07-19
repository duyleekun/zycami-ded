/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AllEqualOrdering;
import com.google.common.collect.ByFunctionOrdering;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ComparatorOrdering;
import com.google.common.collect.CompoundOrdering;
import com.google.common.collect.ExplicitOrdering;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.LexicographicalOrdering;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.NaturalOrdering;
import com.google.common.collect.NullsFirstOrdering;
import com.google.common.collect.NullsLastOrdering;
import com.google.common.collect.Ordering$ArbitraryOrderingHolder;
import com.google.common.collect.ReverseOrdering;
import com.google.common.collect.TopKSelector;
import com.google.common.collect.UsingToStringOrdering;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public abstract class Ordering
implements Comparator {
    public static final int LEFT_IS_GREATER = 1;
    public static final int RIGHT_IS_GREATER = 255;

    public static Ordering allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    public static Ordering arbitrary() {
        return Ordering$ArbitraryOrderingHolder.ARBITRARY_ORDERING;
    }

    public static Ordering compound(Iterable iterable) {
        CompoundOrdering compoundOrdering = new CompoundOrdering(iterable);
        return compoundOrdering;
    }

    public static Ordering explicit(Object object, Object ... objectArray) {
        return Ordering.explicit(Lists.asList(object, objectArray));
    }

    public static Ordering explicit(List list) {
        ExplicitOrdering explicitOrdering = new ExplicitOrdering(list);
        return explicitOrdering;
    }

    public static Ordering from(Ordering ordering) {
        return (Ordering)Preconditions.checkNotNull(ordering);
    }

    public static Ordering from(Comparator comparator) {
        boolean bl2 = comparator instanceof Ordering;
        if (bl2) {
            comparator = (Ordering)comparator;
        } else {
            ComparatorOrdering comparatorOrdering = new ComparatorOrdering(comparator);
            comparator = comparatorOrdering;
        }
        return comparator;
    }

    public static Ordering natural() {
        return NaturalOrdering.INSTANCE;
    }

    public static Ordering usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public int binarySearch(List list, Object object) {
        return Collections.binarySearch(list, object, this);
    }

    public abstract int compare(Object var1, Object var2);

    public Ordering compound(Comparator comparator) {
        comparator = (Comparator)Preconditions.checkNotNull(comparator);
        CompoundOrdering compoundOrdering = new CompoundOrdering(this, comparator);
        return compoundOrdering;
    }

    public List greatestOf(Iterable iterable, int n10) {
        return this.reverse().leastOf(iterable, n10);
    }

    public List greatestOf(Iterator iterator2, int n10) {
        return this.reverse().leastOf(iterator2, n10);
    }

    public ImmutableList immutableSortedCopy(Iterable iterable) {
        return ImmutableList.sortedCopyOf(this, iterable);
    }

    public boolean isOrdered(Iterable object) {
        int n10 = (object = object.iterator()).hasNext();
        if (n10 != 0) {
            boolean bl2;
            Object e10 = object.next();
            while (bl2 = object.hasNext()) {
                Object e11 = object.next();
                n10 = this.compare(e10, e11);
                if (n10 > 0) {
                    return false;
                }
                e10 = e11;
            }
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable object) {
        int n10 = (object = object.iterator()).hasNext();
        if (n10 != 0) {
            boolean bl2;
            Object e10 = object.next();
            while (bl2 = object.hasNext()) {
                Object e11 = object.next();
                n10 = this.compare(e10, e11);
                if (n10 >= 0) {
                    return false;
                }
                e10 = e11;
            }
        }
        return true;
    }

    public List leastOf(Iterable objectArray, int n10) {
        int n11 = objectArray instanceof Collection;
        if (n11 != 0) {
            long l10;
            long l11;
            Iterable iterable = objectArray;
            iterable = (Collection)objectArray;
            long l12 = iterable.size();
            long l13 = l12 - (l11 = (long)n10 * (l10 = (long)2));
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object <= 0) {
                objectArray = iterable.toArray();
                Arrays.sort(objectArray, this);
                n11 = objectArray.length;
                if (n11 > n10) {
                    objectArray = Arrays.copyOf(objectArray, n10);
                }
                return Collections.unmodifiableList(Arrays.asList(objectArray));
            }
        }
        objectArray = objectArray.iterator();
        return this.leastOf((Iterator)objectArray, n10);
    }

    public List leastOf(Iterator object, int n10) {
        int n11;
        Preconditions.checkNotNull(object);
        String string2 = "k";
        CollectPreconditions.checkNonnegative(n10, string2);
        if (n10 != 0 && (n11 = object.hasNext()) != 0) {
            n11 = -1 >>> 2;
            if (n10 >= n11) {
                object = Lists.newArrayList((Iterator)object);
                Collections.sort(object, this);
                n11 = ((ArrayList)object).size();
                if (n11 > n10) {
                    n11 = ((ArrayList)object).size();
                    List list = ((ArrayList)object).subList(n10, n11);
                    list.clear();
                }
                ((ArrayList)object).trimToSize();
                return Collections.unmodifiableList(object);
            }
            TopKSelector topKSelector = TopKSelector.least(n10, this);
            topKSelector.offerAll((Iterator)object);
            return topKSelector.topK();
        }
        return Collections.emptyList();
    }

    public Ordering lexicographical() {
        LexicographicalOrdering lexicographicalOrdering = new LexicographicalOrdering(this);
        return lexicographicalOrdering;
    }

    public Object max(Iterable object) {
        object = object.iterator();
        return this.max((Iterator)object);
    }

    public Object max(Object object, Object object2) {
        int n10 = this.compare(object, object2);
        if (n10 < 0) {
            object = object2;
        }
        return object;
    }

    public Object max(Object object, Object object2, Object object3, Object ... objectArray) {
        object = this.max(object, object2);
        object = this.max(object, object3);
        int n10 = objectArray.length;
        object3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object4 = objectArray[i10];
            object = this.max(object, object4);
        }
        return object;
    }

    public Object max(Iterator iterator2) {
        boolean bl2;
        Object object = iterator2.next();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            object = this.max(object, e10);
        }
        return object;
    }

    public Object min(Iterable object) {
        object = object.iterator();
        return this.min((Iterator)object);
    }

    public Object min(Object object, Object object2) {
        int n10 = this.compare(object, object2);
        if (n10 > 0) {
            object = object2;
        }
        return object;
    }

    public Object min(Object object, Object object2, Object object3, Object ... objectArray) {
        object = this.min(object, object2);
        object = this.min(object, object3);
        int n10 = objectArray.length;
        object3 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object4 = objectArray[i10];
            object = this.min(object, object4);
        }
        return object;
    }

    public Object min(Iterator iterator2) {
        boolean bl2;
        Object object = iterator2.next();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            object = this.min(object, e10);
        }
        return object;
    }

    public Ordering nullsFirst() {
        NullsFirstOrdering nullsFirstOrdering = new NullsFirstOrdering(this);
        return nullsFirstOrdering;
    }

    public Ordering nullsLast() {
        NullsLastOrdering nullsLastOrdering = new NullsLastOrdering(this);
        return nullsLastOrdering;
    }

    public Ordering onKeys() {
        Function function = Maps.keyFunction();
        return this.onResultOf(function);
    }

    public Ordering onResultOf(Function function) {
        ByFunctionOrdering byFunctionOrdering = new ByFunctionOrdering(function, this);
        return byFunctionOrdering;
    }

    public Ordering reverse() {
        ReverseOrdering reverseOrdering = new ReverseOrdering(this);
        return reverseOrdering;
    }

    public List sortedCopy(Iterable objectArray) {
        objectArray = Iterables.toArray((Iterable)objectArray);
        Arrays.sort(objectArray, this);
        return Lists.newArrayList(Arrays.asList(objectArray));
    }
}

