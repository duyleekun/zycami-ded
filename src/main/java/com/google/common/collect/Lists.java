/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.CartesianList;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists$1;
import com.google.common.collect.Lists$2;
import com.google.common.collect.Lists$AbstractListWrapper;
import com.google.common.collect.Lists$CharSequenceAsList;
import com.google.common.collect.Lists$OnePlusArrayList;
import com.google.common.collect.Lists$Partition;
import com.google.common.collect.Lists$RandomAccessPartition;
import com.google.common.collect.Lists$RandomAccessReverseList;
import com.google.common.collect.Lists$ReverseList;
import com.google.common.collect.Lists$StringAsImmutableList;
import com.google.common.collect.Lists$TransformingRandomAccessList;
import com.google.common.collect.Lists$TransformingSequentialList;
import com.google.common.collect.Lists$TwoPlusArrayList;
import com.google.common.primitives.Ints;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Lists {
    private Lists() {
    }

    public static boolean addAllImpl(List object, int n10, Iterable iterable) {
        boolean bl2;
        object = object.listIterator(n10);
        Iterator iterator2 = iterable.iterator();
        boolean bl3 = false;
        iterable = null;
        while (bl2 = iterator2.hasNext()) {
            iterable = iterator2.next();
            object.add(iterable);
            bl3 = true;
        }
        return bl3;
    }

    public static List asList(Object object, Object object2, Object[] objectArray) {
        Lists$TwoPlusArrayList lists$TwoPlusArrayList = new Lists$TwoPlusArrayList(object, object2, objectArray);
        return lists$TwoPlusArrayList;
    }

    public static List asList(Object object, Object[] objectArray) {
        Lists$OnePlusArrayList lists$OnePlusArrayList = new Lists$OnePlusArrayList(object, objectArray);
        return lists$OnePlusArrayList;
    }

    public static List cartesianProduct(List list) {
        return CartesianList.create(list);
    }

    public static List cartesianProduct(List ... listArray) {
        return Lists.cartesianProduct(Arrays.asList(listArray));
    }

    public static List cast(Iterable iterable) {
        return (List)iterable;
    }

    public static ImmutableList charactersOf(String string2) {
        string2 = (String)Preconditions.checkNotNull(string2);
        Lists$StringAsImmutableList lists$StringAsImmutableList = new Lists$StringAsImmutableList(string2);
        return lists$StringAsImmutableList;
    }

    public static List charactersOf(CharSequence charSequence) {
        charSequence = (CharSequence)Preconditions.checkNotNull(charSequence);
        Lists$CharSequenceAsList lists$CharSequenceAsList = new Lists$CharSequenceAsList(charSequence);
        return lists$CharSequenceAsList;
    }

    public static int computeArrayListCapacity(int n10) {
        CollectPreconditions.checkNonnegative(n10, "arraySize");
        long l10 = (long)n10 + (long)5;
        long l11 = n10 / 10;
        return Ints.saturatedCast(l10 + l11);
    }

    public static boolean equalsImpl(List object, Object iterator2) {
        int n10;
        Object object2 = Preconditions.checkNotNull(object);
        boolean bl2 = true;
        if (iterator2 == object2) {
            return bl2;
        }
        int n11 = iterator2 instanceof List;
        if (n11 == 0) {
            return false;
        }
        iterator2 = (List)((Object)iterator2);
        n11 = object.size();
        if (n11 != (n10 = iterator2.size())) {
            return false;
        }
        n10 = object instanceof RandomAccess;
        if (n10 != 0 && (n10 = iterator2 instanceof RandomAccess) != 0) {
            for (n10 = 0; n10 < n11; ++n10) {
                Object e10;
                Object e11 = ((List)object).get(n10);
                boolean bl3 = Objects.equal(e11, e10 = ((List)((Object)iterator2)).get(n10));
                if (bl3) continue;
                return false;
            }
            return bl2;
        }
        object = object.iterator();
        iterator2 = iterator2.iterator();
        return Iterators.elementsEqual((Iterator)object, iterator2);
    }

    public static int hashCodeImpl(List object) {
        int n10;
        object = object.iterator();
        int n11 = 1;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            n11 *= 31;
            if (e10 == null) {
                n10 = 0;
                e10 = null;
            } else {
                n10 = e10.hashCode();
            }
            n11 = ~(~(n11 + n10));
        }
        return n11;
    }

    public static int indexOfImpl(List object, Object object2) {
        boolean bl2 = object instanceof RandomAccess;
        if (bl2) {
            return Lists.indexOfRandomAccess((List)object, object2);
        }
        object = object.listIterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = Objects.equal(object2, e10);
            if (!bl2) continue;
            return object.previousIndex();
        }
        return -1;
    }

    private static int indexOfRandomAccess(List list, Object object) {
        int n10;
        int n11 = list.size();
        if (object == null) {
            for (n10 = 0; n10 < n11; ++n10) {
                object = list.get(n10);
                if (object != null) continue;
                return n10;
            }
        } else {
            while (n10 < n11) {
                Object e10 = list.get(n10);
                boolean bl2 = object.equals(e10);
                if (bl2) {
                    return n10;
                }
                ++n10;
            }
        }
        return -1;
    }

    public static int lastIndexOfImpl(List object, Object object2) {
        int n10 = object instanceof RandomAccess;
        if (n10 != 0) {
            return Lists.lastIndexOfRandomAccess((List)object, object2);
        }
        n10 = object.size();
        object = object.listIterator(n10);
        while ((n10 = (int)(object.hasPrevious() ? 1 : 0)) != 0) {
            Object e10 = object.previous();
            n10 = (int)(Objects.equal(object2, e10) ? 1 : 0);
            if (n10 == 0) continue;
            return object.nextIndex();
        }
        return -1;
    }

    private static int lastIndexOfRandomAccess(List list, Object object) {
        if (object == null) {
            for (int i10 = list.size() + -1; i10 >= 0; i10 += -1) {
                Object e10 = list.get(i10);
                if (e10 != null) continue;
                return i10;
            }
        } else {
            for (int i11 = list.size() + -1; i11 >= 0; i11 += -1) {
                Object e11 = list.get(i11);
                boolean bl2 = object.equals(e11);
                if (!bl2) continue;
                return i11;
            }
        }
        return -1;
    }

    public static ListIterator listIteratorImpl(List list, int n10) {
        Lists$AbstractListWrapper lists$AbstractListWrapper = new Lists$AbstractListWrapper(list);
        return lists$AbstractListWrapper.listIterator(n10);
    }

    public static ArrayList newArrayList() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static ArrayList newArrayList(Iterable object) {
        ArrayList arrayList;
        Preconditions.checkNotNull(object);
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object = Collections2.cast((Iterable)object);
            arrayList = new ArrayList(object);
        } else {
            object = object.iterator();
            arrayList = Lists.newArrayList((Iterator)object);
        }
        return arrayList;
    }

    public static ArrayList newArrayList(Iterator iterator2) {
        ArrayList arrayList = Lists.newArrayList();
        Iterators.addAll(arrayList, iterator2);
        return arrayList;
    }

    public static ArrayList newArrayList(Object ... objectArray) {
        Preconditions.checkNotNull(objectArray);
        int n10 = Lists.computeArrayListCapacity(objectArray.length);
        ArrayList arrayList = new ArrayList(n10);
        Collections.addAll(arrayList, objectArray);
        return arrayList;
    }

    public static ArrayList newArrayListWithCapacity(int n10) {
        CollectPreconditions.checkNonnegative(n10, "initialArraySize");
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }

    public static ArrayList newArrayListWithExpectedSize(int n10) {
        n10 = Lists.computeArrayListCapacity(n10);
        ArrayList arrayList = new ArrayList(n10);
        return arrayList;
    }

    public static CopyOnWriteArrayList newCopyOnWriteArrayList() {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        return copyOnWriteArrayList;
    }

    public static CopyOnWriteArrayList newCopyOnWriteArrayList(Iterable collection) {
        boolean bl2 = collection instanceof Collection;
        collection = bl2 ? Collections2.cast(collection) : Lists.newArrayList(collection);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList(collection);
        return copyOnWriteArrayList;
    }

    public static LinkedList newLinkedList() {
        LinkedList linkedList = new LinkedList();
        return linkedList;
    }

    public static LinkedList newLinkedList(Iterable iterable) {
        LinkedList linkedList = Lists.newLinkedList();
        Iterables.addAll(linkedList, iterable);
        return linkedList;
    }

    public static List partition(List list, int n10) {
        Lists$Partition lists$Partition;
        boolean bl2;
        Preconditions.checkNotNull(list);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            lists$Partition = null;
        }
        Preconditions.checkArgument(bl2);
        bl2 = list instanceof RandomAccess;
        lists$Partition = bl2 ? new Lists$RandomAccessPartition(list, n10) : new Lists$Partition(list, n10);
        return lists$Partition;
    }

    public static List reverse(List list) {
        boolean bl2 = list instanceof ImmutableList;
        if (bl2) {
            return ((ImmutableList)list).reverse();
        }
        bl2 = list instanceof Lists$ReverseList;
        if (bl2) {
            return ((Lists$ReverseList)list).getForwardList();
        }
        bl2 = list instanceof RandomAccess;
        if (bl2) {
            Lists$RandomAccessReverseList lists$RandomAccessReverseList = new Lists$RandomAccessReverseList(list);
            return lists$RandomAccessReverseList;
        }
        Lists$ReverseList lists$ReverseList = new Lists$ReverseList(list);
        return lists$ReverseList;
    }

    public static List subListImpl(List list, int n10, int n11) {
        boolean bl2 = list instanceof RandomAccess;
        Lists$AbstractListWrapper lists$AbstractListWrapper = bl2 ? new Lists$1(list) : new Lists$2(list);
        return lists$AbstractListWrapper.subList(n10, n11);
    }

    public static List transform(List list, Function function) {
        boolean bl2 = list instanceof RandomAccess;
        AbstractList abstractList = bl2 ? new Lists$TransformingRandomAccessList(list, function) : new Lists$TransformingSequentialList(list, function);
        return abstractList;
    }
}

