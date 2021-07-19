/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedIterables;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Set;

public final class RegularImmutableSortedSet
extends ImmutableSortedSet {
    public static final RegularImmutableSortedSet NATURAL_EMPTY_SET;
    public final transient ImmutableList elements;

    static {
        RegularImmutableSortedSet regularImmutableSortedSet;
        ImmutableList immutableList = ImmutableList.of();
        Ordering ordering = Ordering.natural();
        NATURAL_EMPTY_SET = regularImmutableSortedSet = new RegularImmutableSortedSet(immutableList, ordering);
    }

    public RegularImmutableSortedSet(ImmutableList immutableList, Comparator comparator) {
        super(comparator);
        this.elements = immutableList;
    }

    private int unsafeBinarySearch(Object object) {
        ImmutableList immutableList = this.elements;
        Comparator comparator = this.unsafeComparator();
        return Collections.binarySearch(immutableList, object, comparator);
    }

    public ImmutableList asList() {
        return this.elements;
    }

    public Object ceiling(Object object) {
        int n10;
        int n11 = this.tailIndex(object, true);
        if (n11 == (n10 = this.size())) {
            n11 = 0;
            object = null;
        } else {
            ImmutableList immutableList = this.elements;
            object = immutableList.get(n11);
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean contains(Object object) {
        boolean bl2 = false;
        if (object == null) return bl2;
        try {
            int n10 = this.unsafeBinarySearch(object);
            if (n10 < 0) return bl2;
            return true;
        }
        catch (ClassCastException classCastException) {
            return bl2;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsAll(Collection iterator2) {
        int bl2;
        Object object;
        int bl3 = iterator2 instanceof Multiset;
        if (bl3) {
            iterator2 = ((Multiset)((Object)iterator2)).elementSet();
        }
        if ((bl3 = SortedIterables.hasSameComparator((Comparator)(object = this.comparator()), (Iterable)((Object)iterator2))) == 0) return super.containsAll((Collection<?>)((Object)iterator2));
        bl3 = iterator2.size();
        if (bl3 <= (bl2 = 1)) {
            return super.containsAll((Collection<?>)((Object)iterator2));
        }
        object = this.iterator();
        iterator2 = iterator2.iterator();
        boolean bl4 = object.hasNext();
        if (!bl4) {
            return false;
        }
        Object e10 = iterator2.next();
        Object e11 = object.next();
        try {
            while (true) {
                int n10;
                if ((n10 = this.unsafeCompare(e11, e10)) < 0) {
                    boolean bl5 = object.hasNext();
                    if (!bl5) {
                        return false;
                    }
                    e11 = object.next();
                    continue;
                }
                if (n10 == 0) {
                    bl4 = iterator2.hasNext();
                    if (!bl4) {
                        return bl2 != 0;
                    }
                    e10 = iterator2.next();
                    continue;
                }
                if (n10 > 0) break;
            }
            return false;
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        return this.elements.copyIntoArray(objectArray, n10);
    }

    public ImmutableSortedSet createDescendingSet() {
        Object object = Collections.reverseOrder(this.comparator);
        boolean bl2 = this.isEmpty();
        if (bl2) {
            object = ImmutableSortedSet.emptySet(object);
        } else {
            ImmutableList immutableList = this.elements.reverse();
            RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet(immutableList, (Comparator)object);
            object = regularImmutableSortedSet;
        }
        return object;
    }

    public UnmodifiableIterator descendingIterator() {
        return this.elements.reverse().iterator();
    }

    public boolean equals(Object iterator2) {
        int n10;
        boolean bl2 = true;
        if (iterator2 == this) {
            return bl2;
        }
        int n11 = iterator2 instanceof Set;
        if (n11 == 0) {
            return false;
        }
        iterator2 = (Set)((Object)iterator2);
        n11 = this.size();
        if (n11 != (n10 = iterator2.size())) {
            return false;
        }
        n11 = (int)(this.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            return bl2;
        }
        Object object = this.comparator;
        n11 = (int)(SortedIterables.hasSameComparator((Comparator)object, (Iterable)((Object)iterator2)) ? 1 : 0);
        if (n11 != 0) {
            block12: {
                iterator2 = iterator2.iterator();
                try {
                    object = this.iterator();
                }
                catch (ClassCastException | NoSuchElementException runtimeException) {
                    return false;
                }
                while (true) {
                    n10 = (int)(object.hasNext() ? 1 : 0);
                    if (n10 == 0) break block12;
                    Object e10 = object.next();
                    Object e11 = iterator2.next();
                    if (e11 == null) break;
                    if ((n10 = this.unsafeCompare(e10, e11)) == 0) continue;
                    break;
                }
                return false;
            }
            return bl2;
        }
        return this.containsAll((Collection)((Object)iterator2));
    }

    public Object first() {
        boolean bl2 = this.isEmpty();
        if (!bl2) {
            return this.elements.get(0);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Object floor(Object object) {
        int n10 = 1;
        int n11 = this.headIndex(object, n10 != 0) - n10;
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            ImmutableList immutableList = this.elements;
            object = immutableList.get(n11);
        }
        return object;
    }

    public RegularImmutableSortedSet getSubSet(int n10, int n11) {
        int n12;
        if (n10 == 0 && n11 == (n12 = this.size())) {
            return this;
        }
        if (n10 < n11) {
            ImmutableList immutableList = this.elements.subList(n10, n11);
            Comparator comparator = this.comparator;
            RegularImmutableSortedSet regularImmutableSortedSet = new RegularImmutableSortedSet(immutableList, comparator);
            return regularImmutableSortedSet;
        }
        return ImmutableSortedSet.emptySet(this.comparator);
    }

    public int headIndex(Object object, boolean bl2) {
        Comparator comparator;
        ImmutableList immutableList = this.elements;
        int n10 = Collections.binarySearch(immutableList, object = Preconditions.checkNotNull(object), comparator = this.comparator());
        if (n10 >= 0) {
            if (bl2) {
                ++n10;
            }
            return n10;
        }
        return ~n10;
    }

    public ImmutableSortedSet headSetImpl(Object object, boolean bl2) {
        int n10 = this.headIndex(object, bl2);
        return this.getSubSet(0, n10);
    }

    public Object higher(Object object) {
        int n10;
        ImmutableList immutableList = null;
        int n11 = this.tailIndex(object, false);
        if (n11 == (n10 = this.size())) {
            n11 = 0;
            object = null;
        } else {
            immutableList = this.elements;
            object = immutableList.get(n11);
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int indexOf(Object object) {
        ImmutableList immutableList;
        int n10 = -1;
        if (object == null) {
            return n10;
        }
        try {
            immutableList = this.elements;
        }
        catch (ClassCastException classCastException) {
            return n10;
        }
        Comparator comparator = this.unsafeComparator();
        int n11 = Collections.binarySearch(immutableList, object, comparator);
        if (n11 < 0) return n10;
        return n11;
    }

    public Object[] internalArray() {
        return this.elements.internalArray();
    }

    public int internalArrayEnd() {
        return this.elements.internalArrayEnd();
    }

    public int internalArrayStart() {
        return this.elements.internalArrayStart();
    }

    public boolean isPartialView() {
        return this.elements.isPartialView();
    }

    public UnmodifiableIterator iterator() {
        return this.elements.iterator();
    }

    public Object last() {
        boolean bl2 = this.isEmpty();
        if (!bl2) {
            ImmutableList immutableList = this.elements;
            int n10 = this.size() + -1;
            return immutableList.get(n10);
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public Object lower(Object object) {
        int n10;
        ImmutableList immutableList = null;
        int n11 = this.headIndex(object, false) + -1;
        if (n11 == (n10 = -1)) {
            n11 = 0;
            object = null;
        } else {
            immutableList = this.elements;
            object = immutableList.get(n11);
        }
        return object;
    }

    public int size() {
        return this.elements.size();
    }

    public ImmutableSortedSet subSetImpl(Object object, boolean bl2, Object object2, boolean bl3) {
        return this.tailSetImpl(object, bl2).headSetImpl(object2, bl3);
    }

    public int tailIndex(Object object, boolean bl2) {
        Comparator comparator;
        ImmutableList immutableList = this.elements;
        int n10 = Collections.binarySearch(immutableList, object = Preconditions.checkNotNull(object), comparator = this.comparator());
        if (n10 >= 0) {
            if (!bl2) {
                ++n10;
            }
            return n10;
        }
        return ~n10;
    }

    public ImmutableSortedSet tailSetImpl(Object object, boolean bl2) {
        int n10 = this.tailIndex(object, bl2);
        int n11 = this.size();
        return this.getSubSet(n10, n11);
    }

    public Comparator unsafeComparator() {
        return this.comparator;
    }
}

