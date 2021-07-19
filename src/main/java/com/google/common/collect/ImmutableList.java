/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.ImmutableList$Itr;
import com.google.common.collect.ImmutableList$ReverseImmutableList;
import com.google.common.collect.ImmutableList$SerializedForm;
import com.google.common.collect.ImmutableList$SubList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.RegularImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

public abstract class ImmutableList
extends ImmutableCollection
implements List,
RandomAccess {
    private static final UnmodifiableListIterator EMPTY_ITR;

    static {
        ImmutableList immutableList = RegularImmutableList.EMPTY;
        ImmutableList$Itr immutableList$Itr = new ImmutableList$Itr(immutableList, 0);
        EMPTY_ITR = immutableList$Itr;
    }

    public static ImmutableList asImmutableList(Object[] objectArray) {
        int n10 = objectArray.length;
        return ImmutableList.asImmutableList(objectArray, n10);
    }

    public static ImmutableList asImmutableList(Object[] objectArray, int n10) {
        if (n10 == 0) {
            return ImmutableList.of();
        }
        RegularImmutableList regularImmutableList = new RegularImmutableList(objectArray, n10);
        return regularImmutableList;
    }

    public static ImmutableList$Builder builder() {
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        return immutableList$Builder;
    }

    public static ImmutableList$Builder builderWithExpectedSize(int n10) {
        CollectPreconditions.checkNonnegative(n10, "expectedSize");
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder(n10);
        return immutableList$Builder;
    }

    private static ImmutableList construct(Object ... objectArray) {
        return ImmutableList.asImmutableList(ObjectArrays.checkElementsNotNull(objectArray));
    }

    public static ImmutableList copyOf(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        boolean bl2 = iterable instanceof Collection;
        iterable = bl2 ? ImmutableList.copyOf((Collection)iterable) : ImmutableList.copyOf(iterable.iterator());
        return iterable;
    }

    public static ImmutableList copyOf(Collection collection) {
        boolean bl2 = collection instanceof ImmutableCollection;
        if (bl2) {
            bl2 = ((ImmutableCollection)(collection = ((ImmutableCollection)collection).asList())).isPartialView();
            if (bl2) {
                collection = ImmutableList.asImmutableList(((ImmutableCollection)collection).toArray());
            }
            return collection;
        }
        return ImmutableList.construct(collection.toArray());
    }

    public static ImmutableList copyOf(Iterator iterator2) {
        boolean bl2 = iterator2.hasNext();
        if (!bl2) {
            return ImmutableList.of();
        }
        Object e10 = iterator2.next();
        boolean bl3 = iterator2.hasNext();
        if (!bl3) {
            return ImmutableList.of(e10);
        }
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        return ((ImmutableList$Builder)((ImmutableList$Builder)immutableList$Builder.add(e10)).addAll(iterator2)).build();
    }

    public static ImmutableList copyOf(Object[] object) {
        int n10 = ((Object[])object).length;
        object = n10 == 0 ? ImmutableList.of() : ImmutableList.construct((Object[])object.clone());
        return object;
    }

    public static ImmutableList of() {
        return RegularImmutableList.EMPTY;
    }

    public static ImmutableList of(Object object) {
        Object[] objectArray = new Object[]{object};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2) {
        Object[] objectArray = new Object[]{object, object2};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3) {
        Object[] objectArray = new Object[]{object, object2, object3};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4) {
        Object[] objectArray = new Object[]{object, object2, object3, object4};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11) {
        Object[] objectArray = new Object[]{object, object2, object3, object4, object5, object6, object7, object8, object9, object10, object11};
        return ImmutableList.construct(objectArray);
    }

    public static ImmutableList of(Object object, Object object2, Object object3, Object object4, Object object5, Object object6, Object object7, Object object8, Object object9, Object object10, Object object11, Object object12, Object ... objectArray) {
        Object[] objectArray2;
        Object[] objectArray3 = objectArray;
        int n10 = objectArray.length;
        int n11 = 1;
        int n12 = 0x7FFFFFF3;
        if (n10 <= n12) {
            n10 = n11;
        } else {
            n10 = 0;
            objectArray2 = null;
        }
        Preconditions.checkArgument(n10 != 0, "the total number of elements must fit in an int");
        n10 = objectArray3.length;
        n12 = 12;
        objectArray2 = new Object[n10 + n12];
        objectArray2[0] = object;
        objectArray2[n11] = object2;
        objectArray2[2] = object3;
        objectArray2[3] = object4;
        objectArray2[4] = object5;
        objectArray2[5] = object6;
        objectArray2[6] = object7;
        objectArray2[7] = object8;
        objectArray2[8] = object9;
        objectArray2[9] = object10;
        objectArray2[10] = object11;
        objectArray2[11] = object12;
        n11 = objectArray3.length;
        System.arraycopy(objectArray3, 0, objectArray2, n12, n11);
        return ImmutableList.construct(objectArray2);
    }

    private void readObject(ObjectInputStream object) {
        object = new InvalidObjectException("Use SerializedForm");
        throw object;
    }

    public static ImmutableList sortedCopyOf(Iterable objectArray) {
        Object[] objectArray2 = new Comparable[]{};
        objectArray = (Comparable[])Iterables.toArray((Iterable)objectArray, objectArray2);
        ObjectArrays.checkElementsNotNull(objectArray);
        Arrays.sort(objectArray);
        return ImmutableList.asImmutableList(objectArray);
    }

    public static ImmutableList sortedCopyOf(Comparator comparator, Iterable objectArray) {
        Preconditions.checkNotNull(comparator);
        objectArray = Iterables.toArray((Iterable)objectArray);
        ObjectArrays.checkElementsNotNull(objectArray);
        Arrays.sort(objectArray, comparator);
        return ImmutableList.asImmutableList(objectArray);
    }

    public final void add(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final boolean addAll(int n10, Collection collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public final ImmutableList asList() {
        return this;
    }

    public boolean contains(Object object) {
        int n10 = this.indexOf(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public int copyIntoArray(Object[] objectArray, int n10) {
        int n11 = this.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12 = n10 + i10;
            Object e10 = this.get(i10);
            objectArray[n12] = e10;
        }
        return n10 + n11;
    }

    public boolean equals(Object object) {
        return Lists.equalsImpl(this, object);
    }

    public int hashCode() {
        int n10 = this.size();
        int n11 = 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            n11 *= 31;
            Object e10 = this.get(i10);
            int n12 = e10.hashCode();
            n11 = ~(~(n11 + n12));
        }
        return n11;
    }

    public int indexOf(Object object) {
        int n10 = object == null ? -1 : Lists.indexOfImpl(this, object);
        return n10;
    }

    public UnmodifiableIterator iterator() {
        return this.listIterator();
    }

    public int lastIndexOf(Object object) {
        int n10 = object == null ? -1 : Lists.lastIndexOfImpl(this, object);
        return n10;
    }

    public UnmodifiableListIterator listIterator() {
        return this.listIterator(0);
    }

    public UnmodifiableListIterator listIterator(int n10) {
        int n11 = this.size();
        Preconditions.checkPositionIndex(n10, n11);
        n11 = (int)(this.isEmpty() ? 1 : 0);
        if (n11 != 0) {
            return EMPTY_ITR;
        }
        ImmutableList$Itr immutableList$Itr = new ImmutableList$Itr(this, n10);
        return immutableList$Itr;
    }

    public final Object remove(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ImmutableList reverse() {
        int n10;
        int n11 = this.size();
        ImmutableList immutableList = n11 <= (n10 = 1) ? this : new ImmutableList$ReverseImmutableList(this);
        return immutableList;
    }

    public final Object set(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public ImmutableList subList(int n10, int n11) {
        int n12 = this.size();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        n12 = n11 - n10;
        int n13 = this.size();
        if (n12 == n13) {
            return this;
        }
        if (n12 == 0) {
            return ImmutableList.of();
        }
        return this.subListUnchecked(n10, n11);
    }

    public ImmutableList subListUnchecked(int n10, int n11) {
        ImmutableList$SubList immutableList$SubList = new ImmutableList$SubList(this, n10, n11 -= n10);
        return immutableList$SubList;
    }

    public Object writeReplace() {
        Object[] objectArray = this.toArray();
        ImmutableList$SerializedForm immutableList$SerializedForm = new ImmutableList$SerializedForm(objectArray);
        return immutableList$SerializedForm;
    }
}

