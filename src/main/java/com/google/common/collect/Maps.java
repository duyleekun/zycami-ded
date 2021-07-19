/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Converter;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.BiMap;
import com.google.common.collect.BoundType;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableEntry;
import com.google.common.collect.ImmutableEnumMap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.Iterators;
import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps$1;
import com.google.common.collect.Maps$10;
import com.google.common.collect.Maps$11;
import com.google.common.collect.Maps$12;
import com.google.common.collect.Maps$13;
import com.google.common.collect.Maps$2;
import com.google.common.collect.Maps$3;
import com.google.common.collect.Maps$4;
import com.google.common.collect.Maps$5;
import com.google.common.collect.Maps$6;
import com.google.common.collect.Maps$7;
import com.google.common.collect.Maps$8;
import com.google.common.collect.Maps$9;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$AsMapView;
import com.google.common.collect.Maps$BiMapConverter;
import com.google.common.collect.Maps$EntryFunction;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$FilteredEntryBiMap;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryNavigableMap;
import com.google.common.collect.Maps$FilteredEntrySortedMap;
import com.google.common.collect.Maps$FilteredKeyMap;
import com.google.common.collect.Maps$MapDifferenceImpl;
import com.google.common.collect.Maps$NavigableAsMapView;
import com.google.common.collect.Maps$SortedAsMapView;
import com.google.common.collect.Maps$SortedMapDifferenceImpl;
import com.google.common.collect.Maps$TransformedEntriesMap;
import com.google.common.collect.Maps$TransformedEntriesNavigableMap;
import com.google.common.collect.Maps$TransformedEntriesSortedMap;
import com.google.common.collect.Maps$UnmodifiableBiMap;
import com.google.common.collect.Maps$UnmodifiableEntrySet;
import com.google.common.collect.Maps$UnmodifiableNavigableMap;
import com.google.common.collect.Maps$ValueDifferenceImpl;
import com.google.common.collect.Ordering;
import com.google.common.collect.Range;
import com.google.common.collect.SortedMapDifference;
import com.google.common.collect.Synchronized;
import com.google.common.collect.UnmodifiableIterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Properties;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class Maps {
    private Maps() {
    }

    public static /* synthetic */ Map access$100(Map map) {
        return Maps.unmodifiableMap(map);
    }

    public static /* synthetic */ Set access$200(Set set) {
        return Maps.removeOnlySet(set);
    }

    public static /* synthetic */ SortedSet access$300(SortedSet sortedSet) {
        return Maps.removeOnlySortedSet(sortedSet);
    }

    public static /* synthetic */ NavigableSet access$400(NavigableSet navigableSet) {
        return Maps.removeOnlyNavigableSet(navigableSet);
    }

    public static /* synthetic */ Map.Entry access$800(Map.Entry entry) {
        return Maps.unmodifiableOrNull(entry);
    }

    public static Converter asConverter(BiMap biMap) {
        Maps$BiMapConverter maps$BiMapConverter = new Maps$BiMapConverter(biMap);
        return maps$BiMapConverter;
    }

    public static Function asEntryToEntryFunction(Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Maps$13 maps$13 = new Maps$13(maps$EntryTransformer);
        return maps$13;
    }

    public static Function asEntryToValueFunction(Maps$EntryTransformer maps$EntryTransformer) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Maps$11 maps$11 = new Maps$11(maps$EntryTransformer);
        return maps$11;
    }

    public static Maps$EntryTransformer asEntryTransformer(Function function) {
        Preconditions.checkNotNull(function);
        Maps$9 maps$9 = new Maps$9(function);
        return maps$9;
    }

    public static Map asMap(Set set, Function function) {
        Maps$AsMapView maps$AsMapView = new Maps$AsMapView(set, function);
        return maps$AsMapView;
    }

    public static NavigableMap asMap(NavigableSet navigableSet, Function function) {
        Maps$NavigableAsMapView maps$NavigableAsMapView = new Maps$NavigableAsMapView(navigableSet, function);
        return maps$NavigableAsMapView;
    }

    public static SortedMap asMap(SortedSet sortedSet, Function function) {
        Maps$SortedAsMapView maps$SortedAsMapView = new Maps$SortedAsMapView(sortedSet, function);
        return maps$SortedAsMapView;
    }

    public static Iterator asMapEntryIterator(Set object, Function function) {
        object = object.iterator();
        Maps$3 maps$3 = new Maps$3((Iterator)object, function);
        return maps$3;
    }

    public static Function asValueToValueFunction(Maps$EntryTransformer maps$EntryTransformer, Object object) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Maps$10 maps$10 = new Maps$10(maps$EntryTransformer, object);
        return maps$10;
    }

    public static int capacity(int n10) {
        int n11 = 3;
        if (n10 < n11) {
            CollectPreconditions.checkNonnegative(n10, "expectedSize");
            return n10 + 1;
        }
        n11 = 0x40000000;
        if (n10 < n11) {
            return (int)((float)n10 / 0.75f + 1.0f);
        }
        return -1 >>> 1;
    }

    public static boolean containsEntryImpl(Collection collection, Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (!bl2) {
            return false;
        }
        object = Maps.unmodifiableEntry((Map.Entry)object);
        return collection.contains(object);
    }

    public static boolean containsKeyImpl(Map map, Object object) {
        return Iterators.contains(Maps.keyIterator(map.entrySet().iterator()), object);
    }

    public static boolean containsValueImpl(Map map, Object object) {
        return Iterators.contains(Maps.valueIterator(map.entrySet().iterator()), object);
    }

    public static MapDifference difference(Map map, Map map2) {
        boolean bl2 = map instanceof SortedMap;
        if (bl2) {
            return Maps.difference((SortedMap)map, map2);
        }
        Equivalence equivalence = Equivalence.equals();
        return Maps.difference(map, map2, equivalence);
    }

    public static MapDifference difference(Map object, Map map, Equivalence equivalence) {
        Preconditions.checkNotNull(equivalence);
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(map);
        LinkedHashMap linkedHashMap3 = Maps.newLinkedHashMap();
        LinkedHashMap linkedHashMap4 = Maps.newLinkedHashMap();
        Maps.doDifference((Map)object, map, equivalence, linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
        object = new Maps$MapDifferenceImpl(linkedHashMap, linkedHashMap2, linkedHashMap3, linkedHashMap4);
        return object;
    }

    public static SortedMapDifference difference(SortedMap object, Map map) {
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(map);
        Object object2 = Maps.orNaturalOrder(object.comparator());
        TreeMap treeMap = Maps.newTreeMap((Comparator)object2);
        TreeMap treeMap2 = Maps.newTreeMap((Comparator)object2);
        treeMap2.putAll(map);
        TreeMap treeMap3 = Maps.newTreeMap((Comparator)object2);
        object2 = Maps.newTreeMap((Comparator)object2);
        Equivalence equivalence = Equivalence.equals();
        Maps.doDifference((Map)object, map, equivalence, treeMap, treeMap2, treeMap3, (Map)object2);
        object = new Maps$SortedMapDifferenceImpl(treeMap, treeMap2, treeMap3, (SortedMap)object2);
        return object;
    }

    private static void doDifference(Map object, Map map, Equivalence equivalence, Map map2, Map map3, Map map4, Map map5) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            Object k10 = object2.getKey();
            object2 = object2.getValue();
            boolean bl3 = map.containsKey(k10);
            if (bl3) {
                Object v10 = map3.remove(k10);
                boolean bl4 = equivalence.equivalent(object2, v10);
                if (bl4) {
                    map4.put(k10, object2);
                    continue;
                }
                object2 = Maps$ValueDifferenceImpl.create(object2, v10);
                map5.put(k10, object2);
                continue;
            }
            map2.put(k10, object2);
        }
    }

    public static boolean equalsImpl(Map object, Object set) {
        if (object == set) {
            return true;
        }
        boolean bl2 = set instanceof Map;
        if (bl2) {
            set = (Map)((Object)set);
            object = object.entrySet();
            set = set.entrySet();
            return object.equals(set);
        }
        return false;
    }

    public static BiMap filterEntries(BiMap biMap, Predicate predicate) {
        Preconditions.checkNotNull(biMap);
        Preconditions.checkNotNull(predicate);
        boolean bl2 = biMap instanceof Maps$FilteredEntryBiMap;
        if (bl2) {
            biMap = Maps.filterFiltered((Maps$FilteredEntryBiMap)biMap, predicate);
        } else {
            Maps$FilteredEntryBiMap maps$FilteredEntryBiMap = new Maps$FilteredEntryBiMap(biMap, predicate);
            biMap = maps$FilteredEntryBiMap;
        }
        return biMap;
    }

    public static Map filterEntries(Map map, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = map instanceof Maps$AbstractFilteredMap;
        if (bl2) {
            map = Maps.filterFiltered((Maps$AbstractFilteredMap)map, predicate);
        } else {
            map = (Map)Preconditions.checkNotNull(map);
            Maps$FilteredEntryMap maps$FilteredEntryMap = new Maps$FilteredEntryMap(map, predicate);
            map = maps$FilteredEntryMap;
        }
        return map;
    }

    public static NavigableMap filterEntries(NavigableMap navigableMap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = navigableMap instanceof Maps$FilteredEntryNavigableMap;
        if (bl2) {
            navigableMap = Maps.filterFiltered((Maps$FilteredEntryNavigableMap)navigableMap, predicate);
        } else {
            navigableMap = (NavigableMap)Preconditions.checkNotNull(navigableMap);
            Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap = new Maps$FilteredEntryNavigableMap(navigableMap, predicate);
            navigableMap = maps$FilteredEntryNavigableMap;
        }
        return navigableMap;
    }

    public static SortedMap filterEntries(SortedMap sortedMap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = sortedMap instanceof Maps$FilteredEntrySortedMap;
        if (bl2) {
            sortedMap = Maps.filterFiltered((Maps$FilteredEntrySortedMap)sortedMap, predicate);
        } else {
            sortedMap = (SortedMap)Preconditions.checkNotNull(sortedMap);
            Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap = new Maps$FilteredEntrySortedMap(sortedMap, predicate);
            sortedMap = maps$FilteredEntrySortedMap;
        }
        return sortedMap;
    }

    private static BiMap filterFiltered(Maps$FilteredEntryBiMap biMap, Predicate predicate) {
        predicate = Predicates.and(biMap.predicate, predicate);
        biMap = biMap.unfiltered();
        Maps$FilteredEntryBiMap maps$FilteredEntryBiMap = new Maps$FilteredEntryBiMap(biMap, predicate);
        return maps$FilteredEntryBiMap;
    }

    private static Map filterFiltered(Maps$AbstractFilteredMap object, Predicate predicate) {
        Map map = ((Maps$AbstractFilteredMap)object).unfiltered;
        object = Predicates.and(((Maps$AbstractFilteredMap)object).predicate, predicate);
        Maps$FilteredEntryMap maps$FilteredEntryMap = new Maps$FilteredEntryMap(map, (Predicate)object);
        return maps$FilteredEntryMap;
    }

    private static NavigableMap filterFiltered(Maps$FilteredEntryNavigableMap navigableMap, Predicate predicate) {
        predicate = Predicates.and(Maps$FilteredEntryNavigableMap.access$500(navigableMap), predicate);
        navigableMap = Maps$FilteredEntryNavigableMap.access$600(navigableMap);
        Maps$FilteredEntryNavigableMap maps$FilteredEntryNavigableMap = new Maps$FilteredEntryNavigableMap(navigableMap, predicate);
        return maps$FilteredEntryNavigableMap;
    }

    private static SortedMap filterFiltered(Maps$FilteredEntrySortedMap sortedMap, Predicate predicate) {
        predicate = Predicates.and(sortedMap.predicate, predicate);
        sortedMap = sortedMap.sortedMap();
        Maps$FilteredEntrySortedMap maps$FilteredEntrySortedMap = new Maps$FilteredEntrySortedMap(sortedMap, predicate);
        return maps$FilteredEntrySortedMap;
    }

    public static BiMap filterKeys(BiMap biMap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        predicate = Maps.keyPredicateOnEntries(predicate);
        return Maps.filterEntries(biMap, predicate);
    }

    public static Map filterKeys(Map map, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        Predicate predicate2 = Maps.keyPredicateOnEntries(predicate);
        boolean bl2 = map instanceof Maps$AbstractFilteredMap;
        if (bl2) {
            map = Maps.filterFiltered((Maps$AbstractFilteredMap)map, predicate2);
        } else {
            map = (Map)Preconditions.checkNotNull(map);
            Maps$FilteredKeyMap maps$FilteredKeyMap = new Maps$FilteredKeyMap(map, predicate, predicate2);
            map = maps$FilteredKeyMap;
        }
        return map;
    }

    public static NavigableMap filterKeys(NavigableMap navigableMap, Predicate predicate) {
        predicate = Maps.keyPredicateOnEntries(predicate);
        return Maps.filterEntries(navigableMap, predicate);
    }

    public static SortedMap filterKeys(SortedMap sortedMap, Predicate predicate) {
        predicate = Maps.keyPredicateOnEntries(predicate);
        return Maps.filterEntries(sortedMap, predicate);
    }

    public static BiMap filterValues(BiMap biMap, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Maps.filterEntries(biMap, predicate);
    }

    public static Map filterValues(Map map, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Maps.filterEntries(map, predicate);
    }

    public static NavigableMap filterValues(NavigableMap navigableMap, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Maps.filterEntries(navigableMap, predicate);
    }

    public static SortedMap filterValues(SortedMap sortedMap, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Maps.filterEntries(sortedMap, predicate);
    }

    public static ImmutableMap fromProperties(Properties properties) {
        boolean bl2;
        ImmutableMap$Builder immutableMap$Builder = ImmutableMap.builder();
        Enumeration<?> enumeration = properties.propertyNames();
        while (bl2 = enumeration.hasMoreElements()) {
            String string2 = (String)enumeration.nextElement();
            String string3 = properties.getProperty(string2);
            immutableMap$Builder.put(string2, string3);
        }
        return immutableMap$Builder.build();
    }

    public static Map.Entry immutableEntry(Object object, Object object2) {
        ImmutableEntry immutableEntry = new ImmutableEntry(object, object2);
        return immutableEntry;
    }

    public static ImmutableMap immutableEnumMap(Map object) {
        boolean bl2 = object instanceof ImmutableEnumMap;
        if (bl2) {
            return (ImmutableEnumMap)object;
        }
        bl2 = (object = object.entrySet().iterator()).hasNext();
        if (!bl2) {
            return ImmutableMap.of();
        }
        Map.Entry entry = (Map.Entry)object.next();
        Enum enum_ = (Enum)entry.getKey();
        entry = entry.getValue();
        CollectPreconditions.checkEntryNotNull(enum_, entry);
        Class clazz = enum_.getDeclaringClass();
        EnumMap enumMap = new EnumMap(clazz);
        enumMap.put(enum_, entry);
        while (bl2 = object.hasNext()) {
            entry = (Map.Entry)object.next();
            enum_ = (Enum)entry.getKey();
            entry = entry.getValue();
            CollectPreconditions.checkEntryNotNull(enum_, entry);
            enumMap.put(enum_, entry);
        }
        return ImmutableEnumMap.asImmutable(enumMap);
    }

    public static ImmutableMap indexMap(Collection object) {
        boolean bl2;
        int n10 = object.size();
        ImmutableMap$Builder immutableMap$Builder = new ImmutableMap$Builder(n10);
        object = object.iterator();
        n10 = 0;
        Integer n11 = null;
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            int n12 = n10 + 1;
            n11 = n10;
            immutableMap$Builder.put(e10, n11);
            n10 = n12;
        }
        return immutableMap$Builder.build();
    }

    public static Function keyFunction() {
        return Maps$EntryFunction.KEY;
    }

    public static Iterator keyIterator(Iterator iterator2) {
        Maps$1 maps$1 = new Maps$1(iterator2);
        return maps$1;
    }

    public static Object keyOrNull(Map.Entry entry) {
        entry = entry == null ? null : entry.getKey();
        return entry;
    }

    public static Predicate keyPredicateOnEntries(Predicate predicate) {
        Function function = Maps.keyFunction();
        return Predicates.compose(predicate, function);
    }

    public static ConcurrentMap newConcurrentMap() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        return concurrentHashMap;
    }

    public static EnumMap newEnumMap(Class clazz) {
        clazz = (Class)Preconditions.checkNotNull(clazz);
        EnumMap enumMap = new EnumMap(clazz);
        return enumMap;
    }

    public static EnumMap newEnumMap(Map map) {
        EnumMap enumMap = new EnumMap(map);
        return enumMap;
    }

    public static HashMap newHashMap() {
        HashMap hashMap = new HashMap();
        return hashMap;
    }

    public static HashMap newHashMap(Map map) {
        HashMap hashMap = new HashMap(map);
        return hashMap;
    }

    public static HashMap newHashMapWithExpectedSize(int n10) {
        n10 = Maps.capacity(n10);
        HashMap hashMap = new HashMap(n10);
        return hashMap;
    }

    public static IdentityHashMap newIdentityHashMap() {
        IdentityHashMap identityHashMap = new IdentityHashMap();
        return identityHashMap;
    }

    public static LinkedHashMap newLinkedHashMap() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        return linkedHashMap;
    }

    public static LinkedHashMap newLinkedHashMap(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap(map);
        return linkedHashMap;
    }

    public static LinkedHashMap newLinkedHashMapWithExpectedSize(int n10) {
        n10 = Maps.capacity(n10);
        LinkedHashMap linkedHashMap = new LinkedHashMap(n10);
        return linkedHashMap;
    }

    public static TreeMap newTreeMap() {
        TreeMap treeMap = new TreeMap();
        return treeMap;
    }

    public static TreeMap newTreeMap(Comparator comparator) {
        TreeMap treeMap = new TreeMap(comparator);
        return treeMap;
    }

    public static TreeMap newTreeMap(SortedMap sortedMap) {
        TreeMap treeMap = new TreeMap(sortedMap);
        return treeMap;
    }

    public static Comparator orNaturalOrder(Comparator comparator) {
        if (comparator != null) {
            return comparator;
        }
        return Ordering.natural();
    }

    public static void putAllImpl(Map map, Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            map.put(k10, entry);
        }
    }

    public static boolean removeEntryImpl(Collection collection, Object object) {
        boolean bl2 = object instanceof Map.Entry;
        if (!bl2) {
            return false;
        }
        object = Maps.unmodifiableEntry((Map.Entry)object);
        return collection.remove(object);
    }

    private static NavigableSet removeOnlyNavigableSet(NavigableSet navigableSet) {
        Maps$6 maps$6 = new Maps$6(navigableSet);
        return maps$6;
    }

    private static Set removeOnlySet(Set set) {
        Maps$4 maps$4 = new Maps$4(set);
        return maps$4;
    }

    private static SortedSet removeOnlySortedSet(SortedSet sortedSet) {
        Maps$5 maps$5 = new Maps$5(sortedSet);
        return maps$5;
    }

    public static boolean safeContainsKey(Map map, Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.containsKey(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return false;
        }
    }

    public static Object safeGet(Map map, Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.get(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return null;
        }
    }

    public static Object safeRemove(Map map, Object object) {
        Preconditions.checkNotNull(map);
        try {
            return map.remove(object);
        }
        catch (ClassCastException | NullPointerException runtimeException) {
            return null;
        }
    }

    public static NavigableMap subMap(NavigableMap navigableMap, Range object) {
        Object object2;
        int n10;
        Object object3;
        Comparator comparator = navigableMap.comparator();
        int n11 = 1;
        if (comparator != null && (comparator = navigableMap.comparator()) != (object3 = Ordering.natural()) && (n10 = object.hasLowerBound()) && (n10 = object.hasUpperBound())) {
            comparator = navigableMap.comparator();
            n10 = comparator.compare(object3 = object.lowerEndpoint(), object2 = object.upperEndpoint());
            if (n10 <= 0) {
                n10 = n11;
            } else {
                n10 = 0;
                comparator = null;
            }
            object3 = "map is using a custom comparator which is inconsistent with the natural ordering.";
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
            return navigableMap.subMap(comparator, n12 != 0, comparable, n11 != 0);
        }
        n10 = object.hasLowerBound();
        if (n10) {
            comparator = object.lowerEndpoint();
            if ((object = object.lowerBoundType()) != (object3 = BoundType.CLOSED)) {
                n11 = 0;
            }
            return navigableMap.tailMap(comparator, n11 != 0);
        }
        n10 = object.hasUpperBound();
        if (n10) {
            comparator = object.upperEndpoint();
            if ((object = object.upperBoundType()) != (object3 = BoundType.CLOSED)) {
                n11 = 0;
            }
            return navigableMap.headMap(comparator, n11 != 0);
        }
        return (NavigableMap)Preconditions.checkNotNull(navigableMap);
    }

    public static BiMap synchronizedBiMap(BiMap biMap) {
        return Synchronized.biMap(biMap, null);
    }

    public static NavigableMap synchronizedNavigableMap(NavigableMap navigableMap) {
        return Synchronized.navigableMap(navigableMap);
    }

    public static ImmutableMap toMap(Iterable iterable, Function function) {
        return Maps.toMap(iterable.iterator(), function);
    }

    public static ImmutableMap toMap(Iterator iterator2, Function function) {
        boolean bl2;
        Preconditions.checkNotNull(function);
        LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object = function.apply(e10);
            linkedHashMap.put(e10, object);
        }
        return ImmutableMap.copyOf((Map)linkedHashMap);
    }

    public static String toStringImpl(Map object) {
        boolean bl2;
        int n10 = object.size();
        StringBuilder stringBuilder = Collections2.newStringBuilderForCollection(n10);
        stringBuilder.append('{');
        object = object.entrySet().iterator();
        boolean bl3 = true;
        while (bl2 = object.hasNext()) {
            String string2;
            Map.Entry entry = (Map.Entry)object.next();
            if (!bl3) {
                string2 = ", ";
                stringBuilder.append(string2);
            }
            bl3 = false;
            string2 = null;
            Object k10 = entry.getKey();
            stringBuilder.append(k10);
            char c10 = '=';
            stringBuilder.append(c10);
            entry = entry.getValue();
            stringBuilder.append(entry);
        }
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public static Map transformEntries(Map map, Maps$EntryTransformer maps$EntryTransformer) {
        Maps$TransformedEntriesMap maps$TransformedEntriesMap = new Maps$TransformedEntriesMap(map, maps$EntryTransformer);
        return maps$TransformedEntriesMap;
    }

    public static NavigableMap transformEntries(NavigableMap navigableMap, Maps$EntryTransformer maps$EntryTransformer) {
        Maps$TransformedEntriesNavigableMap maps$TransformedEntriesNavigableMap = new Maps$TransformedEntriesNavigableMap(navigableMap, maps$EntryTransformer);
        return maps$TransformedEntriesNavigableMap;
    }

    public static SortedMap transformEntries(SortedMap sortedMap, Maps$EntryTransformer maps$EntryTransformer) {
        Maps$TransformedEntriesSortedMap maps$TransformedEntriesSortedMap = new Maps$TransformedEntriesSortedMap(sortedMap, maps$EntryTransformer);
        return maps$TransformedEntriesSortedMap;
    }

    public static Map.Entry transformEntry(Maps$EntryTransformer maps$EntryTransformer, Map.Entry entry) {
        Preconditions.checkNotNull(maps$EntryTransformer);
        Preconditions.checkNotNull(entry);
        Maps$12 maps$12 = new Maps$12(entry, maps$EntryTransformer);
        return maps$12;
    }

    public static Map transformValues(Map map, Function object) {
        object = Maps.asEntryTransformer((Function)object);
        return Maps.transformEntries(map, (Maps$EntryTransformer)object);
    }

    public static NavigableMap transformValues(NavigableMap navigableMap, Function object) {
        object = Maps.asEntryTransformer((Function)object);
        return Maps.transformEntries(navigableMap, (Maps$EntryTransformer)object);
    }

    public static SortedMap transformValues(SortedMap sortedMap, Function object) {
        object = Maps.asEntryTransformer((Function)object);
        return Maps.transformEntries(sortedMap, (Maps$EntryTransformer)object);
    }

    public static ImmutableMap uniqueIndex(Iterable iterable, Function function) {
        return Maps.uniqueIndex(iterable.iterator(), function);
    }

    public static ImmutableMap uniqueIndex(Iterator iterator2, Function object) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Object object2 = ImmutableMap.builder();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object3 = object.apply(e10);
            ((ImmutableMap$Builder)object2).put(object3, e10);
        }
        try {
            return ((ImmutableMap$Builder)object2).build();
        }
        catch (IllegalArgumentException illegalArgumentException) {
            object2 = new StringBuilder();
            String string2 = illegalArgumentException.getMessage();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(". To index multiple values under a key, use Multimaps.index.");
            string2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException(string2);
            throw object;
        }
    }

    public static BiMap unmodifiableBiMap(BiMap biMap) {
        Maps$UnmodifiableBiMap maps$UnmodifiableBiMap = new Maps$UnmodifiableBiMap(biMap, null);
        return maps$UnmodifiableBiMap;
    }

    public static Map.Entry unmodifiableEntry(Map.Entry entry) {
        Preconditions.checkNotNull(entry);
        Maps$7 maps$7 = new Maps$7(entry);
        return maps$7;
    }

    public static UnmodifiableIterator unmodifiableEntryIterator(Iterator iterator2) {
        Maps$8 maps$8 = new Maps$8(iterator2);
        return maps$8;
    }

    public static Set unmodifiableEntrySet(Set set) {
        set = Collections.unmodifiableSet(set);
        Maps$UnmodifiableEntrySet maps$UnmodifiableEntrySet = new Maps$UnmodifiableEntrySet(set);
        return maps$UnmodifiableEntrySet;
    }

    private static Map unmodifiableMap(Map map) {
        boolean bl2 = map instanceof SortedMap;
        if (bl2) {
            return Collections.unmodifiableSortedMap((SortedMap)map);
        }
        return Collections.unmodifiableMap(map);
    }

    public static NavigableMap unmodifiableNavigableMap(NavigableMap navigableMap) {
        Preconditions.checkNotNull(navigableMap);
        boolean bl2 = navigableMap instanceof Maps$UnmodifiableNavigableMap;
        if (bl2) {
            return navigableMap;
        }
        Maps$UnmodifiableNavigableMap maps$UnmodifiableNavigableMap = new Maps$UnmodifiableNavigableMap(navigableMap);
        return maps$UnmodifiableNavigableMap;
    }

    private static Map.Entry unmodifiableOrNull(Map.Entry entry) {
        entry = entry == null ? null : Maps.unmodifiableEntry(entry);
        return entry;
    }

    public static Function valueFunction() {
        return Maps$EntryFunction.VALUE;
    }

    public static Iterator valueIterator(Iterator iterator2) {
        Maps$2 maps$2 = new Maps$2(iterator2);
        return maps$2;
    }

    public static Object valueOrNull(Map.Entry entry) {
        entry = entry == null ? null : entry.getValue();
        return entry;
    }

    public static Predicate valuePredicateOnEntries(Predicate predicate) {
        Function function = Maps.valueFunction();
        return Predicates.compose(predicate, function);
    }
}

