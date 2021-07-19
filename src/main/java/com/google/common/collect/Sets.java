/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.BoundType;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$FilteredCollection;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableEnumSet;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.Sets$1;
import com.google.common.collect.Sets$2;
import com.google.common.collect.Sets$3;
import com.google.common.collect.Sets$4;
import com.google.common.collect.Sets$5;
import com.google.common.collect.Sets$CartesianSet;
import com.google.common.collect.Sets$FilteredNavigableSet;
import com.google.common.collect.Sets$FilteredSet;
import com.google.common.collect.Sets$FilteredSortedSet;
import com.google.common.collect.Sets$PowerSet;
import com.google.common.collect.Sets$SetView;
import com.google.common.collect.Sets$UnmodifiableNavigableSet;
import com.google.common.collect.Synchronized;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public final class Sets {
    private Sets() {
    }

    public static Set cartesianProduct(List list) {
        return Sets$CartesianSet.create(list);
    }

    public static Set cartesianProduct(Set ... setArray) {
        return Sets.cartesianProduct(Arrays.asList(setArray));
    }

    public static Set combinations(Set object, int n10) {
        object = Maps.indexMap((Collection)object);
        Object object2 = "size";
        CollectPreconditions.checkNonnegative(n10, (String)object2);
        int n11 = object.size();
        if (n10 <= n11) {
            n11 = 1;
        } else {
            n11 = 0;
            object2 = null;
        }
        int n12 = object.size();
        String string2 = "size (%s) must be <= set.size() (%s)";
        Preconditions.checkArgument(n11 != 0, string2, n10, n12);
        if (n10 == 0) {
            return ImmutableSet.of(ImmutableSet.of());
        }
        n11 = object.size();
        if (n10 == n11) {
            return ImmutableSet.of(((ImmutableMap)object).keySet());
        }
        object2 = new Sets$5(n10, (ImmutableMap)object);
        return object2;
    }

    public static EnumSet complementOf(Collection collection) {
        boolean bl2 = collection instanceof EnumSet;
        if (bl2) {
            return EnumSet.complementOf((EnumSet)collection);
        }
        Preconditions.checkArgument(collection.isEmpty() ^ true, "collection is empty; use the other version of this method");
        Class clazz = ((Enum)collection.iterator().next()).getDeclaringClass();
        return Sets.makeComplementByHand(collection, clazz);
    }

    public static EnumSet complementOf(Collection enumSet, Class clazz) {
        Preconditions.checkNotNull(enumSet);
        boolean bl2 = enumSet instanceof EnumSet;
        enumSet = bl2 ? EnumSet.complementOf(enumSet) : Sets.makeComplementByHand(enumSet, clazz);
        return enumSet;
    }

    public static Sets$SetView difference(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Sets$3 sets$3 = new Sets$3(set, set2);
        return sets$3;
    }

    public static boolean equalsImpl(Set set, Object object) {
        boolean bl2 = true;
        if (set == object) {
            return bl2;
        }
        int n10 = object instanceof Set;
        if (n10 != 0) {
            block7: {
                block6: {
                    object = (Set)object;
                    n10 = set.size();
                    int n11 = object.size();
                    if (n10 != n11) break block6;
                    try {
                        boolean bl3 = set.containsAll((Collection<?>)object);
                        if (bl3) break block7;
                    }
                    catch (ClassCastException | NullPointerException runtimeException) {}
                }
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public static NavigableSet filter(NavigableSet set, Predicate predicate) {
        boolean bl2 = set instanceof Sets$FilteredSet;
        if (bl2) {
            set = (Sets$FilteredSet)set;
            predicate = Predicates.and(((Collections2$FilteredCollection)set).predicate, predicate);
            set = (NavigableSet)((Collections2$FilteredCollection)set).unfiltered;
            Sets$FilteredNavigableSet sets$FilteredNavigableSet = new Sets$FilteredNavigableSet((NavigableSet)set, predicate);
            return sets$FilteredNavigableSet;
        }
        set = (NavigableSet)Preconditions.checkNotNull(set);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        Sets$FilteredNavigableSet sets$FilteredNavigableSet = new Sets$FilteredNavigableSet((NavigableSet)set, predicate);
        return sets$FilteredNavigableSet;
    }

    public static Set filter(Set set, Predicate predicate) {
        boolean bl2 = set instanceof SortedSet;
        if (bl2) {
            return Sets.filter((SortedSet)set, predicate);
        }
        bl2 = set instanceof Sets$FilteredSet;
        if (bl2) {
            set = (Sets$FilteredSet)set;
            predicate = Predicates.and(((Collections2$FilteredCollection)set).predicate, predicate);
            set = (Set)((Collections2$FilteredCollection)set).unfiltered;
            Sets$FilteredSet sets$FilteredSet = new Sets$FilteredSet(set, predicate);
            return sets$FilteredSet;
        }
        set = (Set)Preconditions.checkNotNull(set);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        Sets$FilteredSet sets$FilteredSet = new Sets$FilteredSet(set, predicate);
        return sets$FilteredSet;
    }

    public static SortedSet filter(SortedSet set, Predicate predicate) {
        boolean bl2 = set instanceof Sets$FilteredSet;
        if (bl2) {
            set = (Sets$FilteredSet)set;
            predicate = Predicates.and(((Collections2$FilteredCollection)set).predicate, predicate);
            set = (SortedSet)((Collections2$FilteredCollection)set).unfiltered;
            Sets$FilteredSortedSet sets$FilteredSortedSet = new Sets$FilteredSortedSet((SortedSet)set, predicate);
            return sets$FilteredSortedSet;
        }
        set = (SortedSet)Preconditions.checkNotNull(set);
        predicate = (Predicate)Preconditions.checkNotNull(predicate);
        Sets$FilteredSortedSet sets$FilteredSortedSet = new Sets$FilteredSortedSet((SortedSet)set, predicate);
        return sets$FilteredSortedSet;
    }

    public static int hashCodeImpl(Set object) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object e10 = object.next();
            if (e10 != null) {
                n10 = e10.hashCode();
            } else {
                n10 = 0;
                e10 = null;
            }
            n11 = ~(~(n11 + n10));
        }
        return n11;
    }

    public static ImmutableSet immutableEnumSet(Enum enum_, Enum ... enumArray) {
        return ImmutableEnumSet.asImmutable(EnumSet.of(enum_, enumArray));
    }

    public static ImmutableSet immutableEnumSet(Iterable object) {
        boolean bl2 = object instanceof ImmutableEnumSet;
        if (bl2) {
            return (ImmutableEnumSet)object;
        }
        bl2 = object instanceof Collection;
        if (bl2) {
            bl2 = (object = (Collection)object).isEmpty();
            if (bl2) {
                return ImmutableSet.of();
            }
            return ImmutableEnumSet.asImmutable(EnumSet.copyOf(object));
        }
        bl2 = (object = object.iterator()).hasNext();
        if (bl2) {
            EnumSet<Enum> enumSet = EnumSet.of((Enum)object.next());
            Iterators.addAll(enumSet, (Iterator)object);
            return ImmutableEnumSet.asImmutable(enumSet);
        }
        return ImmutableSet.of();
    }

    public static Sets$SetView intersection(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Sets$2 sets$2 = new Sets$2(set, set2);
        return sets$2;
    }

    private static EnumSet makeComplementByHand(Collection collection, Class serializable) {
        serializable = EnumSet.allOf(serializable);
        ((AbstractSet)((Object)serializable)).removeAll(collection);
        return serializable;
    }

    public static Set newConcurrentHashSet() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        return Collections.newSetFromMap(concurrentHashMap);
    }

    public static Set newConcurrentHashSet(Iterable iterable) {
        Set set = Sets.newConcurrentHashSet();
        Iterables.addAll(set, iterable);
        return set;
    }

    public static CopyOnWriteArraySet newCopyOnWriteArraySet() {
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
        return copyOnWriteArraySet;
    }

    public static CopyOnWriteArraySet newCopyOnWriteArraySet(Iterable collection) {
        boolean bl2 = collection instanceof Collection;
        collection = bl2 ? Collections2.cast(collection) : Lists.newArrayList(collection);
        CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet(collection);
        return copyOnWriteArraySet;
    }

    public static EnumSet newEnumSet(Iterable iterable, Class serializable) {
        serializable = EnumSet.noneOf(serializable);
        Iterables.addAll((Collection)((Object)serializable), iterable);
        return serializable;
    }

    public static HashSet newHashSet() {
        HashSet hashSet = new HashSet();
        return hashSet;
    }

    public static HashSet newHashSet(Iterable object) {
        HashSet hashSet;
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            object = Collections2.cast((Iterable)object);
            hashSet = new HashSet(object);
        } else {
            object = object.iterator();
            hashSet = Sets.newHashSet((Iterator)object);
        }
        return hashSet;
    }

    public static HashSet newHashSet(Iterator iterator2) {
        HashSet hashSet = Sets.newHashSet();
        Iterators.addAll(hashSet, iterator2);
        return hashSet;
    }

    public static HashSet newHashSet(Object ... objectArray) {
        HashSet hashSet = Sets.newHashSetWithExpectedSize(objectArray.length);
        Collections.addAll(hashSet, objectArray);
        return hashSet;
    }

    public static HashSet newHashSetWithExpectedSize(int n10) {
        n10 = Maps.capacity(n10);
        HashSet hashSet = new HashSet(n10);
        return hashSet;
    }

    public static Set newIdentityHashSet() {
        return Collections.newSetFromMap(Maps.newIdentityHashMap());
    }

    public static LinkedHashSet newLinkedHashSet() {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        return linkedHashSet;
    }

    public static LinkedHashSet newLinkedHashSet(Iterable iterable) {
        boolean bl2 = iterable instanceof Collection;
        if (bl2) {
            iterable = Collections2.cast(iterable);
            LinkedHashSet linkedHashSet = new LinkedHashSet(iterable);
            return linkedHashSet;
        }
        LinkedHashSet linkedHashSet = Sets.newLinkedHashSet();
        Iterables.addAll(linkedHashSet, iterable);
        return linkedHashSet;
    }

    public static LinkedHashSet newLinkedHashSetWithExpectedSize(int n10) {
        n10 = Maps.capacity(n10);
        LinkedHashSet linkedHashSet = new LinkedHashSet(n10);
        return linkedHashSet;
    }

    public static Set newSetFromMap(Map map) {
        return Collections.newSetFromMap(map);
    }

    public static TreeSet newTreeSet() {
        TreeSet treeSet = new TreeSet();
        return treeSet;
    }

    public static TreeSet newTreeSet(Iterable iterable) {
        TreeSet treeSet = Sets.newTreeSet();
        Iterables.addAll(treeSet, iterable);
        return treeSet;
    }

    public static TreeSet newTreeSet(Comparator comparator) {
        comparator = (Comparator)Preconditions.checkNotNull(comparator);
        TreeSet treeSet = new TreeSet(comparator);
        return treeSet;
    }

    public static Set powerSet(Set set) {
        Sets$PowerSet sets$PowerSet = new Sets$PowerSet(set);
        return sets$PowerSet;
    }

    public static boolean removeAllImpl(Set set, Collection object) {
        int n10;
        Preconditions.checkNotNull(object);
        int n11 = object instanceof Multiset;
        if (n11 != 0) {
            object = ((Multiset)object).elementSet();
        }
        if ((n11 = object instanceof Set) != 0 && (n11 = object.size()) > (n10 = set.size())) {
            return Iterators.removeAll(set.iterator(), (Collection)object);
        }
        object = object.iterator();
        return Sets.removeAllImpl(set, (Iterator)object);
    }

    public static boolean removeAllImpl(Set set, Iterator iterator2) {
        boolean bl2;
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            bl2 = set.remove(e10);
            bl3 |= bl2;
        }
        return bl3;
    }

    public static NavigableSet subSet(NavigableSet navigableSet, Range object) {
        Object object2;
        int n10;
        Object object3;
        Comparator comparator = navigableSet.comparator();
        int n11 = 1;
        if (comparator != null && (comparator = navigableSet.comparator()) != (object3 = Ordering.natural()) && (n10 = object.hasLowerBound()) && (n10 = object.hasUpperBound())) {
            comparator = navigableSet.comparator();
            n10 = comparator.compare(object3 = object.lowerEndpoint(), object2 = object.upperEndpoint());
            if (n10 <= 0) {
                n10 = n11;
            } else {
                n10 = 0;
                comparator = null;
            }
            object3 = "set is using a custom comparator which is inconsistent with the natural ordering.";
            Preconditions.checkArgument(n10 != 0, object3);
        }
        if ((n10 = object.hasLowerBound()) && (n10 = object.hasUpperBound())) {
            int n12;
            comparator = object.lowerEndpoint();
            object3 = object.lowerBoundType();
            if (object3 == (object2 = BoundType.CLOSED)) {
                n12 = n11;
            } else {
                n12 = 0;
                object3 = null;
            }
            Comparable comparable = object.upperEndpoint();
            object = object.upperBoundType();
            if (object != object2) {
                n11 = 0;
            }
            return navigableSet.subSet(comparator, n12 != 0, comparable, n11 != 0);
        }
        n10 = object.hasLowerBound();
        if (n10) {
            comparator = object.lowerEndpoint();
            if ((object = object.lowerBoundType()) != (object3 = BoundType.CLOSED)) {
                n11 = 0;
            }
            return navigableSet.tailSet(comparator, n11 != 0);
        }
        n10 = object.hasUpperBound();
        if (n10) {
            comparator = object.upperEndpoint();
            if ((object = object.upperBoundType()) != (object3 = BoundType.CLOSED)) {
                n11 = 0;
            }
            return navigableSet.headSet(comparator, n11 != 0);
        }
        return (NavigableSet)Preconditions.checkNotNull(navigableSet);
    }

    public static Sets$SetView symmetricDifference(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Sets$4 sets$4 = new Sets$4(set, set2);
        return sets$4;
    }

    public static NavigableSet synchronizedNavigableSet(NavigableSet navigableSet) {
        return Synchronized.navigableSet(navigableSet);
    }

    public static Sets$SetView union(Set set, Set set2) {
        Preconditions.checkNotNull(set, "set1");
        Preconditions.checkNotNull(set2, "set2");
        Sets$1 sets$1 = new Sets$1(set, set2);
        return sets$1;
    }

    public static NavigableSet unmodifiableNavigableSet(NavigableSet navigableSet) {
        boolean bl2 = navigableSet instanceof ImmutableCollection;
        if (!bl2 && !(bl2 = navigableSet instanceof Sets$UnmodifiableNavigableSet)) {
            Sets$UnmodifiableNavigableSet sets$UnmodifiableNavigableSet = new Sets$UnmodifiableNavigableSet(navigableSet);
            return sets$UnmodifiableNavigableSet;
        }
        return navigableSet;
    }
}

