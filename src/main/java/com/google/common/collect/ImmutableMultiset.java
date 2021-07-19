/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset$1;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableMultiset$EntrySet;
import com.google.common.collect.ImmutableMultisetGwtSerializationDependencies;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.Multisets;
import com.google.common.collect.RegularImmutableMultiset;
import com.google.common.collect.Sets;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableMultiset
extends ImmutableMultisetGwtSerializationDependencies
implements Multiset {
    private transient ImmutableList asList;
    private transient ImmutableSet entrySet;

    public static ImmutableMultiset$Builder builder() {
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder();
        return immutableMultiset$Builder;
    }

    private static ImmutableMultiset copyFromElements(Object ... objectArray) {
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder();
        return ((ImmutableMultiset$Builder)immutableMultiset$Builder.add(objectArray)).build();
    }

    public static ImmutableMultiset copyFromEntries(Collection object) {
        int n10 = object.size();
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder(n10);
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)object.next();
            Object object2 = multiset$Entry.getElement();
            n10 = multiset$Entry.getCount();
            immutableMultiset$Builder.addCopies(object2, n10);
        }
        return immutableMultiset$Builder.build();
    }

    public static ImmutableMultiset copyOf(Iterable iterable) {
        int n10;
        Object object;
        boolean bl2 = iterable instanceof ImmutableMultiset;
        if (bl2) {
            object = iterable;
            object = (ImmutableMultiset)iterable;
            n10 = (int)(((ImmutableCollection)object).isPartialView() ? 1 : 0);
            if (n10 == 0) {
                return object;
            }
        }
        n10 = Multisets.inferDistinctElements(iterable);
        object = new ImmutableMultiset$Builder(n10);
        ((ImmutableMultiset$Builder)object).addAll(iterable);
        return ((ImmutableMultiset$Builder)object).build();
    }

    public static ImmutableMultiset copyOf(Iterator iterator2) {
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder();
        return ((ImmutableMultiset$Builder)immutableMultiset$Builder.addAll(iterator2)).build();
    }

    public static ImmutableMultiset copyOf(Object[] objectArray) {
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    private ImmutableSet createEntrySet() {
        boolean bl2 = this.isEmpty();
        ImmutableSet immutableSet = bl2 ? ImmutableSet.of() : new ImmutableMultiset$EntrySet(this, null);
        return immutableSet;
    }

    public static ImmutableMultiset of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static ImmutableMultiset of(Object object) {
        Object[] objectArray = new Object[]{object};
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    public static ImmutableMultiset of(Object object, Object object2) {
        Object[] objectArray = new Object[]{object, object2};
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3) {
        Object[] objectArray = new Object[]{object, object2, object3};
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3, Object object4) {
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3, Object object4, Object object5) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5};
        return ImmutableMultiset.copyFromElements(objectArray);
    }

    public static ImmutableMultiset of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object ... objectArray) {
        ImmutableMultiset$Builder immutableMultiset$Builder = new ImmutableMultiset$Builder();
        return ((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)((ImmutableMultiset$Builder)immutableMultiset$Builder.add(object)).add(object2)).add(object3)).add(object4)).add(object5)).add(object6)).add(objectArray)).build();
    }

    public final int add(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ImmutableList asList() {
        ImmutableList immutableList = this.asList;
        if (immutableList == null) {
            this.asList = immutableList = super.asList();
        }
        return immutableList;
    }

    public boolean contains(Object object) {
        int n10 = this.count(object);
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        int n11;
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        while ((n11 = unmodifiableIterator.hasNext()) != 0) {
            Multiset$Entry multiset$Entry = (Multiset$Entry)unmodifiableIterator.next();
            int n12 = multiset$Entry.getCount() + n10;
            Object object = multiset$Entry.getElement();
            Arrays.fill(objectArray, n10, n12, object);
            n11 = multiset$Entry.getCount();
            n10 += n11;
        }
        return n10;
    }

    public abstract ImmutableSet elementSet();

    public ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.entrySet;
        if (immutableSet == null) {
            this.entrySet = immutableSet = this.createEntrySet();
        }
        return immutableSet;
    }

    public boolean equals(Object object) {
        return Multisets.equalsImpl(this, object);
    }

    public abstract Multiset$Entry getEntry(int var1);

    public int hashCode() {
        return Sets.hashCodeImpl(this.entrySet());
    }

    public UnmodifiableIterator iterator() {
        UnmodifiableIterator unmodifiableIterator = this.entrySet().iterator();
        ImmutableMultiset$1 immutableMultiset$1 = new ImmutableMultiset$1(this, unmodifiableIterator);
        return immutableMultiset$1;
    }

    public final int remove(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final int setCount(Object object, int n10) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public final boolean setCount(Object object, int n10, int n11) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public String toString() {
        return this.entrySet().toString();
    }

    public abstract Object writeReplace();
}

