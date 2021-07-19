/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.BaseImmutableMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ImmutableBiMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized$SynchronizedBiMap;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import com.google.common.collect.Synchronized$SynchronizedDeque;
import com.google.common.collect.Synchronized$SynchronizedEntry;
import com.google.common.collect.Synchronized$SynchronizedList;
import com.google.common.collect.Synchronized$SynchronizedListMultimap;
import com.google.common.collect.Synchronized$SynchronizedMap;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import com.google.common.collect.Synchronized$SynchronizedMultiset;
import com.google.common.collect.Synchronized$SynchronizedNavigableMap;
import com.google.common.collect.Synchronized$SynchronizedNavigableSet;
import com.google.common.collect.Synchronized$SynchronizedQueue;
import com.google.common.collect.Synchronized$SynchronizedRandomAccessList;
import com.google.common.collect.Synchronized$SynchronizedSet;
import com.google.common.collect.Synchronized$SynchronizedSetMultimap;
import com.google.common.collect.Synchronized$SynchronizedSortedMap;
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import com.google.common.collect.Synchronized$SynchronizedSortedSetMultimap;
import com.google.common.collect.Synchronized$SynchronizedTable;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Deque;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Queue;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public final class Synchronized {
    private Synchronized() {
    }

    public static /* synthetic */ SortedSet access$100(SortedSet sortedSet, Object object) {
        return Synchronized.sortedSet(sortedSet, object);
    }

    public static /* synthetic */ List access$200(List list, Object object) {
        return Synchronized.list(list, object);
    }

    public static /* synthetic */ Set access$300(Set set, Object object) {
        return Synchronized.typePreservingSet(set, object);
    }

    public static /* synthetic */ Collection access$400(Collection collection, Object object) {
        return Synchronized.typePreservingCollection(collection, object);
    }

    public static /* synthetic */ Collection access$500(Collection collection, Object object) {
        return Synchronized.collection(collection, object);
    }

    public static /* synthetic */ Map.Entry access$700(Map.Entry entry, Object object) {
        return Synchronized.nullableSynchronizedEntry(entry, object);
    }

    public static BiMap biMap(BiMap biMap, Object object) {
        boolean bl2 = biMap instanceof Synchronized$SynchronizedBiMap;
        if (!bl2 && !(bl2 = biMap instanceof ImmutableBiMap)) {
            Synchronized$SynchronizedBiMap synchronized$SynchronizedBiMap = new Synchronized$SynchronizedBiMap(biMap, object, null, null);
            return synchronized$SynchronizedBiMap;
        }
        return biMap;
    }

    private static Collection collection(Collection collection, Object object) {
        Synchronized$SynchronizedCollection synchronized$SynchronizedCollection = new Synchronized$SynchronizedCollection(collection, object, null);
        return synchronized$SynchronizedCollection;
    }

    public static Deque deque(Deque deque, Object object) {
        Synchronized$SynchronizedDeque synchronized$SynchronizedDeque = new Synchronized$SynchronizedDeque(deque, object);
        return synchronized$SynchronizedDeque;
    }

    private static List list(List list, Object object) {
        boolean bl2 = list instanceof RandomAccess;
        Synchronized$SynchronizedList synchronized$SynchronizedList = bl2 ? new Synchronized$SynchronizedRandomAccessList(list, object) : new Synchronized$SynchronizedList(list, object);
        return synchronized$SynchronizedList;
    }

    public static ListMultimap listMultimap(ListMultimap listMultimap, Object object) {
        boolean bl2 = listMultimap instanceof Synchronized$SynchronizedListMultimap;
        if (!bl2 && !(bl2 = listMultimap instanceof BaseImmutableMultimap)) {
            Synchronized$SynchronizedListMultimap synchronized$SynchronizedListMultimap = new Synchronized$SynchronizedListMultimap(listMultimap, object);
            return synchronized$SynchronizedListMultimap;
        }
        return listMultimap;
    }

    public static Map map(Map map, Object object) {
        Synchronized$SynchronizedMap synchronized$SynchronizedMap = new Synchronized$SynchronizedMap(map, object);
        return synchronized$SynchronizedMap;
    }

    public static Multimap multimap(Multimap multimap, Object object) {
        boolean bl2 = multimap instanceof Synchronized$SynchronizedMultimap;
        if (!bl2 && !(bl2 = multimap instanceof BaseImmutableMultimap)) {
            Synchronized$SynchronizedMultimap synchronized$SynchronizedMultimap = new Synchronized$SynchronizedMultimap(multimap, object);
            return synchronized$SynchronizedMultimap;
        }
        return multimap;
    }

    public static Multiset multiset(Multiset multiset, Object object) {
        boolean bl2 = multiset instanceof Synchronized$SynchronizedMultiset;
        if (!bl2 && !(bl2 = multiset instanceof ImmutableMultiset)) {
            Synchronized$SynchronizedMultiset synchronized$SynchronizedMultiset = new Synchronized$SynchronizedMultiset(multiset, object);
            return synchronized$SynchronizedMultiset;
        }
        return multiset;
    }

    public static NavigableMap navigableMap(NavigableMap navigableMap) {
        return Synchronized.navigableMap(navigableMap, null);
    }

    public static NavigableMap navigableMap(NavigableMap navigableMap, Object object) {
        Synchronized$SynchronizedNavigableMap synchronized$SynchronizedNavigableMap = new Synchronized$SynchronizedNavigableMap(navigableMap, object);
        return synchronized$SynchronizedNavigableMap;
    }

    public static NavigableSet navigableSet(NavigableSet navigableSet) {
        return Synchronized.navigableSet(navigableSet, null);
    }

    public static NavigableSet navigableSet(NavigableSet navigableSet, Object object) {
        Synchronized$SynchronizedNavigableSet synchronized$SynchronizedNavigableSet = new Synchronized$SynchronizedNavigableSet(navigableSet, object);
        return synchronized$SynchronizedNavigableSet;
    }

    private static Map.Entry nullableSynchronizedEntry(Map.Entry entry, Object object) {
        if (entry == null) {
            return null;
        }
        Synchronized$SynchronizedEntry synchronized$SynchronizedEntry = new Synchronized$SynchronizedEntry(entry, object);
        return synchronized$SynchronizedEntry;
    }

    public static Queue queue(Queue queue, Object object) {
        boolean bl2 = queue instanceof Synchronized$SynchronizedQueue;
        if (!bl2) {
            Synchronized$SynchronizedQueue synchronized$SynchronizedQueue = new Synchronized$SynchronizedQueue(queue, object);
            queue = synchronized$SynchronizedQueue;
        }
        return queue;
    }

    public static Set set(Set set, Object object) {
        Synchronized$SynchronizedSet synchronized$SynchronizedSet = new Synchronized$SynchronizedSet(set, object);
        return synchronized$SynchronizedSet;
    }

    public static SetMultimap setMultimap(SetMultimap setMultimap, Object object) {
        boolean bl2 = setMultimap instanceof Synchronized$SynchronizedSetMultimap;
        if (!bl2 && !(bl2 = setMultimap instanceof BaseImmutableMultimap)) {
            Synchronized$SynchronizedSetMultimap synchronized$SynchronizedSetMultimap = new Synchronized$SynchronizedSetMultimap(setMultimap, object);
            return synchronized$SynchronizedSetMultimap;
        }
        return setMultimap;
    }

    public static SortedMap sortedMap(SortedMap sortedMap, Object object) {
        Synchronized$SynchronizedSortedMap synchronized$SynchronizedSortedMap = new Synchronized$SynchronizedSortedMap(sortedMap, object);
        return synchronized$SynchronizedSortedMap;
    }

    private static SortedSet sortedSet(SortedSet sortedSet, Object object) {
        Synchronized$SynchronizedSortedSet synchronized$SynchronizedSortedSet = new Synchronized$SynchronizedSortedSet(sortedSet, object);
        return synchronized$SynchronizedSortedSet;
    }

    public static SortedSetMultimap sortedSetMultimap(SortedSetMultimap sortedSetMultimap, Object object) {
        boolean bl2 = sortedSetMultimap instanceof Synchronized$SynchronizedSortedSetMultimap;
        if (bl2) {
            return sortedSetMultimap;
        }
        Synchronized$SynchronizedSortedSetMultimap synchronized$SynchronizedSortedSetMultimap = new Synchronized$SynchronizedSortedSetMultimap(sortedSetMultimap, object);
        return synchronized$SynchronizedSortedSetMultimap;
    }

    public static Table table(Table table, Object object) {
        Synchronized$SynchronizedTable synchronized$SynchronizedTable = new Synchronized$SynchronizedTable(table, object);
        return synchronized$SynchronizedTable;
    }

    private static Collection typePreservingCollection(Collection collection, Object object) {
        boolean bl2 = collection instanceof SortedSet;
        if (bl2) {
            return Synchronized.sortedSet((SortedSet)collection, object);
        }
        bl2 = collection instanceof Set;
        if (bl2) {
            return Synchronized.set((Set)collection, object);
        }
        bl2 = collection instanceof List;
        if (bl2) {
            return Synchronized.list((List)collection, object);
        }
        return Synchronized.collection(collection, object);
    }

    private static Set typePreservingSet(Set set, Object object) {
        boolean bl2 = set instanceof SortedSet;
        if (bl2) {
            return Synchronized.sortedSet((SortedSet)set, object);
        }
        return Synchronized.set(set, object);
    }
}

