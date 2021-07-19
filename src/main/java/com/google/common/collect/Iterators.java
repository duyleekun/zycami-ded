/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators$1;
import com.google.common.collect.Iterators$10;
import com.google.common.collect.Iterators$11;
import com.google.common.collect.Iterators$2;
import com.google.common.collect.Iterators$3;
import com.google.common.collect.Iterators$4;
import com.google.common.collect.Iterators$5;
import com.google.common.collect.Iterators$6;
import com.google.common.collect.Iterators$7;
import com.google.common.collect.Iterators$8;
import com.google.common.collect.Iterators$9;
import com.google.common.collect.Iterators$ArrayItr;
import com.google.common.collect.Iterators$ConcatenatedIterator;
import com.google.common.collect.Iterators$EmptyModifiableIterator;
import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.Iterators$PeekingImpl;
import com.google.common.collect.Lists;
import com.google.common.collect.PeekingIterator;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.collect.UnmodifiableListIterator;
import com.google.common.primitives.Ints;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public final class Iterators {
    private Iterators() {
    }

    public static boolean addAll(Collection collection, Iterator iterator2) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Preconditions.checkNotNull(iterator2);
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = collection.add(e10);
            bl3 |= bl2;
        }
        return bl3;
    }

    public static int advance(Iterator iterator2, int n10) {
        int n11;
        Preconditions.checkNotNull(iterator2);
        boolean bl2 = n10 >= 0;
        String string2 = "numberToAdvance must be nonnegative";
        Preconditions.checkArgument(bl2, string2);
        for (n11 = 0; n11 < n10 && (bl2 = iterator2.hasNext()); ++n11) {
            iterator2.next();
        }
        return n11;
    }

    public static boolean all(Iterator iterator2, Predicate predicate) {
        boolean bl2;
        Preconditions.checkNotNull(predicate);
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = predicate.apply(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public static boolean any(Iterator iterator2, Predicate predicate) {
        int n10;
        int n11 = Iterators.indexOf(iterator2, predicate);
        if (n11 != (n10 = -1)) {
            n11 = 1;
        } else {
            n11 = 0;
            iterator2 = null;
        }
        return n11 != 0;
    }

    public static Enumeration asEnumeration(Iterator iterator2) {
        Preconditions.checkNotNull(iterator2);
        Iterators$11 iterators$11 = new Iterators$11(iterator2);
        return iterators$11;
    }

    public static ListIterator cast(Iterator iterator2) {
        return (ListIterator)iterator2;
    }

    public static void checkNonnegative(int n10) {
        if (n10 >= 0) {
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("position (");
        stringBuilder.append(n10);
        stringBuilder.append(") must not be negative");
        String string2 = stringBuilder.toString();
        IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string2);
        throw indexOutOfBoundsException;
    }

    public static void clear(Iterator iterator2) {
        boolean bl2;
        Preconditions.checkNotNull(iterator2);
        while (bl2 = iterator2.hasNext()) {
            iterator2.next();
            iterator2.remove();
        }
    }

    public static Iterator concat(Iterator iterator2) {
        Iterators$ConcatenatedIterator iterators$ConcatenatedIterator = new Iterators$ConcatenatedIterator(iterator2);
        return iterators$ConcatenatedIterator;
    }

    public static Iterator concat(Iterator iterator2, Iterator iterator3) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        Object[] objectArray = new Iterator[]{iterator2, iterator3};
        return Iterators.concat(Iterators.consumingForArray(objectArray));
    }

    public static Iterator concat(Iterator iterator2, Iterator iterator3, Iterator iterator4) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        Preconditions.checkNotNull(iterator4);
        Object[] objectArray = new Iterator[]{iterator2, iterator3, iterator4};
        return Iterators.concat(Iterators.consumingForArray(objectArray));
    }

    public static Iterator concat(Iterator iterator2, Iterator iterator3, Iterator iterator4, Iterator iterator5) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(iterator3);
        Preconditions.checkNotNull(iterator4);
        Preconditions.checkNotNull(iterator5);
        Object[] objectArray = new Iterator[]{iterator2, iterator3, iterator4, iterator5};
        return Iterators.concat(Iterators.consumingForArray(objectArray));
    }

    public static Iterator concat(Iterator ... iteratorArray) {
        int n10 = iteratorArray.length;
        return Iterators.concatNoDefensiveCopy(Arrays.copyOf(iteratorArray, n10));
    }

    public static Iterator concatNoDefensiveCopy(Iterator ... iteratorArray) {
        for (Iterator iterator2 : (Iterator[])Preconditions.checkNotNull(iteratorArray)) {
            Preconditions.checkNotNull(iterator2);
        }
        return Iterators.concat(Iterators.consumingForArray(iteratorArray));
    }

    private static Iterator consumingForArray(Object ... objectArray) {
        Iterators$3 iterators$3 = new Iterators$3(objectArray);
        return iterators$3;
    }

    public static Iterator consumingIterator(Iterator iterator2) {
        Preconditions.checkNotNull(iterator2);
        Iterators$8 iterators$8 = new Iterators$8(iterator2);
        return iterators$8;
    }

    public static boolean contains(Iterator iterator2, Object object) {
        boolean bl2 = true;
        if (object == null) {
            boolean bl3;
            while (bl3 = iterator2.hasNext()) {
                object = iterator2.next();
                if (object != null) continue;
                return bl2;
            }
        } else {
            boolean bl4;
            while (bl4 = iterator2.hasNext()) {
                Object e10 = iterator2.next();
                bl4 = object.equals(e10);
                if (!bl4) continue;
                return bl2;
            }
        }
        return false;
    }

    public static Iterator cycle(Iterable iterable) {
        Preconditions.checkNotNull(iterable);
        Iterators$2 iterators$2 = new Iterators$2(iterable);
        return iterators$2;
    }

    public static Iterator cycle(Object ... objectArray) {
        return Iterators.cycle(Lists.newArrayList(objectArray));
    }

    public static boolean elementsEqual(Iterator iterator2, Iterator iterator3) {
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            bl2 = iterator3.hasNext();
            if (!bl2) {
                return false;
            }
            Object e11 = iterator2.next();
            bl2 = Objects.equal(e11, e10 = iterator3.next());
            if (bl2) continue;
            return false;
        }
        return iterator3.hasNext() ^ true;
    }

    public static UnmodifiableIterator emptyIterator() {
        return Iterators.emptyListIterator();
    }

    public static UnmodifiableListIterator emptyListIterator() {
        return Iterators$ArrayItr.EMPTY;
    }

    public static Iterator emptyModifiableIterator() {
        return Iterators$EmptyModifiableIterator.INSTANCE;
    }

    public static UnmodifiableIterator filter(Iterator iterator2, Predicate predicate) {
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(predicate);
        Iterators$5 iterators$5 = new Iterators$5(iterator2, predicate);
        return iterators$5;
    }

    public static UnmodifiableIterator filter(Iterator iterator2, Class object) {
        object = Predicates.instanceOf((Class)object);
        return Iterators.filter(iterator2, (Predicate)object);
    }

    public static Object find(Iterator object, Predicate predicate) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(predicate);
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            boolean bl3 = predicate.apply(e10);
            if (!bl3) continue;
            return e10;
        }
        object = new NoSuchElementException();
        throw object;
    }

    public static Object find(Iterator iterator2, Predicate predicate, Object object) {
        boolean bl2;
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(predicate);
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            boolean bl3 = predicate.apply(e10);
            if (!bl3) continue;
            return e10;
        }
        return object;
    }

    public static UnmodifiableIterator forArray(Object ... objectArray) {
        int n10 = objectArray.length;
        return Iterators.forArray(objectArray, 0, n10, 0);
    }

    public static UnmodifiableListIterator forArray(Object[] objectArray, int n10, int n11, int n12) {
        Iterators$ArrayItr iterators$ArrayItr;
        int n13;
        if (n11 >= 0) {
            n13 = 1;
        } else {
            n13 = 0;
            iterators$ArrayItr = null;
        }
        Preconditions.checkArgument(n13 != 0);
        n13 = n10 + n11;
        int n14 = objectArray.length;
        Preconditions.checkPositionIndexes(n10, n13, n14);
        Preconditions.checkPositionIndex(n12, n11);
        if (n11 == 0) {
            return Iterators.emptyListIterator();
        }
        iterators$ArrayItr = new Iterators$ArrayItr(objectArray, n10, n11, n12);
        return iterators$ArrayItr;
    }

    public static UnmodifiableIterator forEnumeration(Enumeration enumeration) {
        Preconditions.checkNotNull(enumeration);
        Iterators$10 iterators$10 = new Iterators$10(enumeration);
        return iterators$10;
    }

    public static int frequency(Iterator iterator2, Object object) {
        boolean bl2;
        int n10 = 0;
        while (bl2 = Iterators.contains(iterator2, object)) {
            ++n10;
        }
        return n10;
    }

    public static Object get(Iterator object, int n10) {
        Iterators.checkNonnegative(n10);
        int n11 = Iterators.advance((Iterator)object, n10);
        boolean bl2 = object.hasNext();
        if (bl2) {
            return object.next();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("position (");
        stringBuilder.append(n10);
        stringBuilder.append(") must be less than the number of elements that remained (");
        stringBuilder.append(n11);
        stringBuilder.append(")");
        String string2 = stringBuilder.toString();
        object = new IndexOutOfBoundsException(string2);
        throw object;
    }

    public static Object get(Iterator iterator2, int n10, Object object) {
        Iterators.checkNonnegative(n10);
        Iterators.advance(iterator2, n10);
        return Iterators.getNext(iterator2, object);
    }

    public static Object getLast(Iterator iterator2) {
        Object e10;
        boolean bl2;
        do {
            e10 = iterator2.next();
        } while (bl2 = iterator2.hasNext());
        return e10;
    }

    public static Object getLast(Iterator iterator2, Object object) {
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            object = Iterators.getLast(iterator2);
        }
        return object;
    }

    public static Object getNext(Iterator iterator2, Object object) {
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            object = iterator2.next();
        }
        return object;
    }

    public static Object getOnlyElement(Iterator object) {
        int n10;
        Object object2 = object.next();
        boolean bl2 = object.hasNext();
        if (!bl2) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "expected one element but was: <";
        stringBuilder.append(string2);
        stringBuilder.append(object2);
        object2 = null;
        for (int i10 = 0; i10 < (n10 = 4) && (n10 = (int)(object.hasNext() ? 1 : 0)) != 0; ++i10) {
            stringBuilder.append(", ");
            string2 = object.next();
            stringBuilder.append((Object)string2);
        }
        boolean bl3 = object.hasNext();
        if (bl3) {
            object = ", ...";
            stringBuilder.append((String)object);
        }
        stringBuilder.append('>');
        object2 = stringBuilder.toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static Object getOnlyElement(Iterator iterator2, Object object) {
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            object = Iterators.getOnlyElement(iterator2);
        }
        return object;
    }

    public static int indexOf(Iterator iterator2, Predicate predicate) {
        boolean bl2;
        Preconditions.checkNotNull(predicate, "predicate");
        int n10 = 0;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = predicate.apply(e10);
            if (bl2) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    public static Iterator limit(Iterator iterator2, int n10) {
        Iterators$7 iterators$7;
        boolean bl2;
        Preconditions.checkNotNull(iterator2);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            iterators$7 = null;
        }
        Preconditions.checkArgument(bl2, "limit is negative");
        iterators$7 = new Iterators$7(n10, iterator2);
        return iterators$7;
    }

    public static UnmodifiableIterator mergeSorted(Iterable iterable, Comparator comparator) {
        Preconditions.checkNotNull(iterable, "iterators");
        Preconditions.checkNotNull(comparator, "comparator");
        Iterators$MergingIterator iterators$MergingIterator = new Iterators$MergingIterator(iterable, comparator);
        return iterators$MergingIterator;
    }

    public static UnmodifiableIterator paddedPartition(Iterator iterator2, int n10) {
        return Iterators.partitionImpl(iterator2, n10, true);
    }

    public static UnmodifiableIterator partition(Iterator iterator2, int n10) {
        return Iterators.partitionImpl(iterator2, n10, false);
    }

    private static UnmodifiableIterator partitionImpl(Iterator iterator2, int n10, boolean bl2) {
        Iterators$4 iterators$4;
        boolean bl3;
        Preconditions.checkNotNull(iterator2);
        if (n10 > 0) {
            bl3 = true;
        } else {
            bl3 = false;
            iterators$4 = null;
        }
        Preconditions.checkArgument(bl3);
        iterators$4 = new Iterators$4(iterator2, n10, bl2);
        return iterators$4;
    }

    public static PeekingIterator peekingIterator(PeekingIterator peekingIterator) {
        return (PeekingIterator)Preconditions.checkNotNull(peekingIterator);
    }

    public static PeekingIterator peekingIterator(Iterator iterator2) {
        boolean bl2 = iterator2 instanceof Iterators$PeekingImpl;
        if (bl2) {
            return (Iterators$PeekingImpl)iterator2;
        }
        Iterators$PeekingImpl iterators$PeekingImpl = new Iterators$PeekingImpl(iterator2);
        return iterators$PeekingImpl;
    }

    public static Object pollNext(Iterator iterator2) {
        boolean bl2 = iterator2.hasNext();
        if (bl2) {
            Object e10 = iterator2.next();
            iterator2.remove();
            return e10;
        }
        return null;
    }

    public static boolean removeAll(Iterator iterator2, Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = collection.contains(e10);
            if (!bl2) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public static boolean removeIf(Iterator iterator2, Predicate predicate) {
        boolean bl2;
        Preconditions.checkNotNull(predicate);
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = predicate.apply(e10);
            if (!bl2) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public static boolean retainAll(Iterator iterator2, Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = collection.contains(e10);
            if (bl2) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public static UnmodifiableIterator singletonIterator(Object object) {
        Iterators$9 iterators$9 = new Iterators$9(object);
        return iterators$9;
    }

    public static int size(Iterator iterator2) {
        boolean bl2;
        long l10 = 0L;
        while (bl2 = iterator2.hasNext()) {
            iterator2.next();
            long l11 = 1L;
            l10 += l11;
        }
        return Ints.saturatedCast(l10);
    }

    public static Object[] toArray(Iterator iterator2, Class clazz) {
        return Iterables.toArray((Iterable)Lists.newArrayList(iterator2), clazz);
    }

    public static String toString(Iterator iterator2) {
        boolean bl2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('[');
        boolean bl3 = true;
        while (bl2 = iterator2.hasNext()) {
            String string2;
            if (!bl3) {
                string2 = ", ";
                stringBuilder.append(string2);
            }
            bl3 = false;
            string2 = null;
            Object e10 = iterator2.next();
            stringBuilder.append(e10);
        }
        stringBuilder.append(']');
        return stringBuilder.toString();
    }

    public static Iterator transform(Iterator iterator2, Function function) {
        Preconditions.checkNotNull(function);
        Iterators$6 iterators$6 = new Iterators$6(iterator2, function);
        return iterators$6;
    }

    public static Optional tryFind(Iterator iterator2, Predicate predicate) {
        boolean bl2;
        Preconditions.checkNotNull(iterator2);
        Preconditions.checkNotNull(predicate);
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            boolean bl3 = predicate.apply(e10);
            if (!bl3) continue;
            return Optional.of(e10);
        }
        return Optional.absent();
    }

    public static UnmodifiableIterator unmodifiableIterator(UnmodifiableIterator unmodifiableIterator) {
        return (UnmodifiableIterator)Preconditions.checkNotNull(unmodifiableIterator);
    }

    public static UnmodifiableIterator unmodifiableIterator(Iterator iterator2) {
        Preconditions.checkNotNull(iterator2);
        boolean bl2 = iterator2 instanceof UnmodifiableIterator;
        if (bl2) {
            return (UnmodifiableIterator)iterator2;
        }
        Iterators$1 iterators$1 = new Iterators$1(iterator2);
        return iterators$1;
    }
}

