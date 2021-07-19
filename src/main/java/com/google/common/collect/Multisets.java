/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Iterators;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets$1;
import com.google.common.collect.Multisets$2;
import com.google.common.collect.Multisets$3;
import com.google.common.collect.Multisets$4;
import com.google.common.collect.Multisets$5;
import com.google.common.collect.Multisets$DecreasingCount;
import com.google.common.collect.Multisets$FilteredMultiset;
import com.google.common.collect.Multisets$ImmutableEntry;
import com.google.common.collect.Multisets$MultisetIteratorImpl;
import com.google.common.collect.Multisets$UnmodifiableMultiset;
import com.google.common.collect.SortedMultiset;
import com.google.common.collect.UnmodifiableSortedMultiset;
import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public final class Multisets {
    private Multisets() {
    }

    private static boolean addAllImpl(Multiset multiset, AbstractMapBasedMultiset abstractMapBasedMultiset) {
        boolean bl2 = abstractMapBasedMultiset.isEmpty();
        if (bl2) {
            return false;
        }
        abstractMapBasedMultiset.addTo(multiset);
        return true;
    }

    private static boolean addAllImpl(Multiset multiset, Multiset object) {
        int n10 = object instanceof AbstractMapBasedMultiset;
        if (n10 != 0) {
            object = (AbstractMapBasedMultiset)object;
            return Multisets.addAllImpl(multiset, (AbstractMapBasedMultiset)object);
        }
        n10 = object.isEmpty();
        if (n10 != 0) {
            return false;
        }
        object = object.entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)object.next();
            Object object2 = multiset$Entry.getElement();
            n10 = multiset$Entry.getCount();
            multiset.add(object2, n10);
        }
        return true;
    }

    public static boolean addAllImpl(Multiset multiset, Collection object) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(object);
        boolean bl2 = object instanceof Multiset;
        if (bl2) {
            object = Multisets.cast((Iterable)object);
            return Multisets.addAllImpl(multiset, (Multiset)object);
        }
        bl2 = object.isEmpty();
        if (bl2) {
            return false;
        }
        object = object.iterator();
        return Iterators.addAll(multiset, (Iterator)object);
    }

    public static Multiset cast(Iterable iterable) {
        return (Multiset)iterable;
    }

    public static boolean containsOccurrences(Multiset multiset, Multiset object) {
        int n10;
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(object);
        object = object.entrySet().iterator();
        while ((n10 = object.hasNext()) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)object.next();
            Object object2 = multiset$Entry.getElement();
            int n11 = multiset.count(object2);
            if (n11 >= (n10 = multiset$Entry.getCount())) continue;
            return false;
        }
        return true;
    }

    public static ImmutableMultiset copyHighestCountFirst(Multiset collection) {
        collection = collection.entrySet();
        Object object = new Multiset$Entry[]{};
        collection = collection.toArray((T[])object);
        object = Multisets$DecreasingCount.INSTANCE;
        Arrays.sort(collection, object);
        return ImmutableMultiset.copyFromEntries(Arrays.asList(collection));
    }

    public static Multiset difference(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Multisets$4 multisets$4 = new Multisets$4(multiset, multiset2);
        return multisets$4;
    }

    public static Iterator elementIterator(Iterator iterator2) {
        Multisets$5 multisets$5 = new Multisets$5(iterator2);
        return multisets$5;
    }

    public static boolean equalsImpl(Multiset multiset, Object iterator2) {
        boolean bl2 = true;
        if (iterator2 == multiset) {
            return bl2;
        }
        int n10 = iterator2 instanceof Multiset;
        if (n10 != 0) {
            Object object;
            Object object2;
            int n11;
            iterator2 = (Multiset)((Object)iterator2);
            n10 = multiset.size();
            if (n10 == (n11 = iterator2.size()) && (n10 = (object2 = multiset.entrySet()).size()) == (n11 = (object = iterator2.entrySet()).size())) {
                iterator2 = iterator2.entrySet().iterator();
                while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                    object2 = (Multiset$Entry)iterator2.next();
                    object = object2.getElement();
                    n11 = multiset.count(object);
                    if (n11 == (n10 = object2.getCount())) continue;
                    return false;
                }
                return bl2;
            }
        }
        return false;
    }

    public static Multiset filter(Multiset multiset, Predicate predicate) {
        boolean bl2 = multiset instanceof Multisets$FilteredMultiset;
        if (bl2) {
            multiset = (Multisets$FilteredMultiset)multiset;
            predicate = Predicates.and(((Multisets$FilteredMultiset)multiset).predicate, predicate);
            multiset = ((Multisets$FilteredMultiset)multiset).unfiltered;
            Multisets$FilteredMultiset multisets$FilteredMultiset = new Multisets$FilteredMultiset(multiset, predicate);
            return multisets$FilteredMultiset;
        }
        Multisets$FilteredMultiset multisets$FilteredMultiset = new Multisets$FilteredMultiset(multiset, predicate);
        return multisets$FilteredMultiset;
    }

    public static Multiset$Entry immutableEntry(Object object, int n10) {
        Multisets$ImmutableEntry multisets$ImmutableEntry = new Multisets$ImmutableEntry(object, n10);
        return multisets$ImmutableEntry;
    }

    public static int inferDistinctElements(Iterable iterable) {
        boolean bl2 = iterable instanceof Multiset;
        if (bl2) {
            return ((Multiset)iterable).elementSet().size();
        }
        return 11;
    }

    public static Multiset intersection(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Multisets$2 multisets$2 = new Multisets$2(multiset, multiset2);
        return multisets$2;
    }

    public static Iterator iteratorImpl(Multiset multiset) {
        Iterator iterator2 = multiset.entrySet().iterator();
        Multisets$MultisetIteratorImpl multisets$MultisetIteratorImpl = new Multisets$MultisetIteratorImpl(multiset, iterator2);
        return multisets$MultisetIteratorImpl;
    }

    public static int linearTimeSizeImpl(Multiset object) {
        int n10;
        object = object.entrySet().iterator();
        long l10 = 0L;
        while ((n10 = object.hasNext()) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)object.next();
            n10 = multiset$Entry.getCount();
            long l11 = n10;
            l10 += l11;
        }
        return Ints.saturatedCast(l10);
    }

    public static boolean removeAllImpl(Multiset multiset, Collection collection) {
        boolean bl2 = collection instanceof Multiset;
        if (bl2) {
            collection = ((Multiset)collection).elementSet();
        }
        return multiset.elementSet().removeAll(collection);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static boolean removeOccurrences(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator iterator2 = multiset.entrySet().iterator();
        boolean bl2 = false;
        Object object = null;
        boolean bl3;
        while (bl3 = iterator2.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
            Object object2 = multiset$Entry.getElement();
            int n10 = multiset2.count(object2);
            int n11 = multiset$Entry.getCount();
            boolean bl4 = true;
            if (n10 >= n11) {
                iterator2.remove();
            } else {
                if (n10 <= 0) continue;
                object = multiset$Entry.getElement();
                multiset.remove(object, n10);
            }
            bl2 = bl4;
        }
        return bl2;
    }

    public static boolean removeOccurrences(Multiset multiset, Iterable object) {
        boolean bl2;
        boolean bl3 = object instanceof Multiset;
        if (bl3) {
            object = (Multiset)object;
            return Multisets.removeOccurrences(multiset, (Multiset)object);
        }
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(object);
        bl3 = false;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = multiset.remove(e10);
            bl3 |= bl2;
        }
        return bl3;
    }

    public static boolean retainAllImpl(Multiset multiset, Collection collection) {
        Preconditions.checkNotNull(collection);
        boolean bl2 = collection instanceof Multiset;
        if (bl2) {
            collection = ((Multiset)collection).elementSet();
        }
        return multiset.elementSet().retainAll(collection);
    }

    public static boolean retainOccurrences(Multiset multiset, Multiset multiset2) {
        return Multisets.retainOccurrencesImpl(multiset, multiset2);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static boolean retainOccurrencesImpl(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Iterator iterator2 = multiset.entrySet().iterator();
        boolean bl2 = false;
        Object object = null;
        boolean bl3;
        while (bl3 = iterator2.hasNext()) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
            Object object2 = multiset$Entry.getElement();
            int n10 = multiset2.count(object2);
            boolean bl4 = true;
            if (n10 == 0) {
                iterator2.remove();
            } else {
                int n11 = multiset$Entry.getCount();
                if (n10 >= n11) continue;
                object = multiset$Entry.getElement();
                multiset.setCount(object, n10);
            }
            bl2 = bl4;
        }
        return bl2;
    }

    public static int setCountImpl(Multiset multiset, Object object, int n10) {
        String string2 = "count";
        CollectPreconditions.checkNonnegative(n10, string2);
        int n11 = multiset.count(object);
        if ((n10 -= n11) > 0) {
            multiset.add(object, n10);
        } else if (n10 < 0) {
            n10 = -n10;
            multiset.remove(object, n10);
        }
        return n11;
    }

    public static boolean setCountImpl(Multiset multiset, Object object, int n10, int n11) {
        CollectPreconditions.checkNonnegative(n10, "oldCount");
        String string2 = "newCount";
        CollectPreconditions.checkNonnegative(n11, string2);
        int n12 = multiset.count(object);
        if (n12 == n10) {
            multiset.setCount(object, n11);
            return true;
        }
        return false;
    }

    public static Multiset sum(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Multisets$3 multisets$3 = new Multisets$3(multiset, multiset2);
        return multisets$3;
    }

    public static Multiset union(Multiset multiset, Multiset multiset2) {
        Preconditions.checkNotNull(multiset);
        Preconditions.checkNotNull(multiset2);
        Multisets$1 multisets$1 = new Multisets$1(multiset, multiset2);
        return multisets$1;
    }

    public static Multiset unmodifiableMultiset(ImmutableMultiset immutableMultiset) {
        return (Multiset)Preconditions.checkNotNull(immutableMultiset);
    }

    public static Multiset unmodifiableMultiset(Multiset multiset) {
        boolean bl2 = multiset instanceof Multisets$UnmodifiableMultiset;
        if (!bl2 && !(bl2 = multiset instanceof ImmutableMultiset)) {
            multiset = (Multiset)Preconditions.checkNotNull(multiset);
            Multisets$UnmodifiableMultiset multisets$UnmodifiableMultiset = new Multisets$UnmodifiableMultiset(multiset);
            return multisets$UnmodifiableMultiset;
        }
        return multiset;
    }

    public static SortedMultiset unmodifiableSortedMultiset(SortedMultiset sortedMultiset) {
        sortedMultiset = (SortedMultiset)Preconditions.checkNotNull(sortedMultiset);
        UnmodifiableSortedMultiset unmodifiableSortedMultiset = new UnmodifiableSortedMultiset(sortedMultiset);
        return unmodifiableSortedMultiset;
    }
}

