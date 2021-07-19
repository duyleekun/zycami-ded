/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntrySetMultimap;
import com.google.common.collect.FilteredKeyListMultimap;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableListMultimap$Builder;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$UnmodifiableEntries;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps$CustomListMultimap;
import com.google.common.collect.Multimaps$CustomMultimap;
import com.google.common.collect.Multimaps$CustomSetMultimap;
import com.google.common.collect.Multimaps$CustomSortedSetMultimap;
import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$TransformedEntriesListMultimap;
import com.google.common.collect.Multimaps$TransformedEntriesMultimap;
import com.google.common.collect.Multimaps$UnmodifiableListMultimap;
import com.google.common.collect.Multimaps$UnmodifiableMultimap;
import com.google.common.collect.Multimaps$UnmodifiableSetMultimap;
import com.google.common.collect.Multimaps$UnmodifiableSortedSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

public final class Multimaps {
    private Multimaps() {
    }

    public static /* synthetic */ Collection access$000(Collection collection) {
        return Multimaps.unmodifiableValueCollection(collection);
    }

    public static /* synthetic */ Collection access$100(Collection collection) {
        return Multimaps.unmodifiableEntries(collection);
    }

    public static Map asMap(ListMultimap listMultimap) {
        return listMultimap.asMap();
    }

    public static Map asMap(Multimap multimap) {
        return multimap.asMap();
    }

    public static Map asMap(SetMultimap setMultimap) {
        return setMultimap.asMap();
    }

    public static Map asMap(SortedSetMultimap sortedSetMultimap) {
        return sortedSetMultimap.asMap();
    }

    public static boolean equalsImpl(Multimap object, Object object2) {
        if (object2 == object) {
            return true;
        }
        boolean bl2 = object2 instanceof Multimap;
        if (bl2) {
            object2 = (Multimap)object2;
            object = object.asMap();
            object2 = object2.asMap();
            return object.equals(object2);
        }
        return false;
    }

    public static Multimap filterEntries(Multimap multimap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = multimap instanceof SetMultimap;
        if (bl2) {
            return Multimaps.filterEntries((SetMultimap)multimap, predicate);
        }
        bl2 = multimap instanceof FilteredMultimap;
        if (bl2) {
            multimap = Multimaps.filterFiltered((FilteredMultimap)multimap, predicate);
        } else {
            multimap = (Multimap)Preconditions.checkNotNull(multimap);
            FilteredEntryMultimap filteredEntryMultimap = new FilteredEntryMultimap(multimap, predicate);
            multimap = filteredEntryMultimap;
        }
        return multimap;
    }

    public static SetMultimap filterEntries(SetMultimap setMultimap, Predicate predicate) {
        Preconditions.checkNotNull(predicate);
        boolean bl2 = setMultimap instanceof FilteredSetMultimap;
        if (bl2) {
            setMultimap = Multimaps.filterFiltered((FilteredSetMultimap)setMultimap, predicate);
        } else {
            setMultimap = (SetMultimap)Preconditions.checkNotNull(setMultimap);
            FilteredEntrySetMultimap filteredEntrySetMultimap = new FilteredEntrySetMultimap(setMultimap, predicate);
            setMultimap = filteredEntrySetMultimap;
        }
        return setMultimap;
    }

    private static Multimap filterFiltered(FilteredMultimap multimap, Predicate predicate) {
        predicate = Predicates.and(multimap.entryPredicate(), predicate);
        multimap = multimap.unfiltered();
        FilteredEntryMultimap filteredEntryMultimap = new FilteredEntryMultimap(multimap, predicate);
        return filteredEntryMultimap;
    }

    private static SetMultimap filterFiltered(FilteredSetMultimap setMultimap, Predicate predicate) {
        predicate = Predicates.and(setMultimap.entryPredicate(), predicate);
        setMultimap = setMultimap.unfiltered();
        FilteredEntrySetMultimap filteredEntrySetMultimap = new FilteredEntrySetMultimap(setMultimap, predicate);
        return filteredEntrySetMultimap;
    }

    public static ListMultimap filterKeys(ListMultimap object, Predicate predicate) {
        boolean bl2 = object instanceof FilteredKeyListMultimap;
        if (bl2) {
            object = (FilteredKeyListMultimap)object;
            ListMultimap listMultimap = ((FilteredKeyListMultimap)object).unfiltered();
            object = Predicates.and(((FilteredKeyMultimap)object).keyPredicate, predicate);
            FilteredKeyListMultimap filteredKeyListMultimap = new FilteredKeyListMultimap(listMultimap, (Predicate)object);
            return filteredKeyListMultimap;
        }
        FilteredKeyListMultimap filteredKeyListMultimap = new FilteredKeyListMultimap((ListMultimap)object, predicate);
        return filteredKeyListMultimap;
    }

    public static Multimap filterKeys(Multimap object, Predicate predicate) {
        boolean bl2 = object instanceof SetMultimap;
        if (bl2) {
            return Multimaps.filterKeys((SetMultimap)object, predicate);
        }
        bl2 = object instanceof ListMultimap;
        if (bl2) {
            return Multimaps.filterKeys((ListMultimap)object, predicate);
        }
        bl2 = object instanceof FilteredKeyMultimap;
        if (bl2) {
            object = (FilteredKeyMultimap)object;
            Multimap multimap = ((FilteredKeyMultimap)object).unfiltered;
            object = Predicates.and(((FilteredKeyMultimap)object).keyPredicate, predicate);
            FilteredKeyMultimap filteredKeyMultimap = new FilteredKeyMultimap(multimap, (Predicate)object);
            return filteredKeyMultimap;
        }
        bl2 = object instanceof FilteredMultimap;
        if (bl2) {
            object = (FilteredMultimap)object;
            predicate = Maps.keyPredicateOnEntries(predicate);
            return Multimaps.filterFiltered((FilteredMultimap)object, predicate);
        }
        FilteredKeyMultimap filteredKeyMultimap = new FilteredKeyMultimap((Multimap)object, predicate);
        return filteredKeyMultimap;
    }

    public static SetMultimap filterKeys(SetMultimap object, Predicate predicate) {
        boolean bl2 = object instanceof FilteredKeySetMultimap;
        if (bl2) {
            object = (FilteredKeySetMultimap)object;
            Multimap multimap = ((FilteredKeySetMultimap)object).unfiltered();
            object = Predicates.and(((FilteredKeyMultimap)object).keyPredicate, predicate);
            FilteredKeySetMultimap filteredKeySetMultimap = new FilteredKeySetMultimap((SetMultimap)multimap, (Predicate)object);
            return filteredKeySetMultimap;
        }
        bl2 = object instanceof FilteredSetMultimap;
        if (bl2) {
            object = (FilteredSetMultimap)object;
            predicate = Maps.keyPredicateOnEntries(predicate);
            return Multimaps.filterFiltered((FilteredSetMultimap)object, predicate);
        }
        FilteredKeySetMultimap filteredKeySetMultimap = new FilteredKeySetMultimap((SetMultimap)object, predicate);
        return filteredKeySetMultimap;
    }

    public static Multimap filterValues(Multimap multimap, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Multimaps.filterEntries(multimap, predicate);
    }

    public static SetMultimap filterValues(SetMultimap setMultimap, Predicate predicate) {
        predicate = Maps.valuePredicateOnEntries(predicate);
        return Multimaps.filterEntries(setMultimap, predicate);
    }

    public static SetMultimap forMap(Map map) {
        Multimaps$MapMultimap multimaps$MapMultimap = new Multimaps$MapMultimap(map);
        return multimaps$MapMultimap;
    }

    public static ImmutableListMultimap index(Iterable iterable, Function function) {
        return Multimaps.index(iterable.iterator(), function);
    }

    public static ImmutableListMultimap index(Iterator iterator2, Function function) {
        boolean bl2;
        Preconditions.checkNotNull(function);
        ImmutableListMultimap$Builder immutableListMultimap$Builder = ImmutableListMultimap.builder();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Preconditions.checkNotNull(e10, iterator2);
            Object object = function.apply(e10);
            immutableListMultimap$Builder.put(object, e10);
        }
        return immutableListMultimap$Builder.build();
    }

    public static Multimap invertFrom(Multimap object, Multimap multimap) {
        boolean bl2;
        Preconditions.checkNotNull(multimap);
        object = object.entries().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object v10 = entry.getValue();
            entry = entry.getKey();
            multimap.put(v10, entry);
        }
        return multimap;
    }

    public static ListMultimap newListMultimap(Map map, Supplier supplier) {
        Multimaps$CustomListMultimap multimaps$CustomListMultimap = new Multimaps$CustomListMultimap(map, supplier);
        return multimaps$CustomListMultimap;
    }

    public static Multimap newMultimap(Map map, Supplier supplier) {
        Multimaps$CustomMultimap multimaps$CustomMultimap = new Multimaps$CustomMultimap(map, supplier);
        return multimaps$CustomMultimap;
    }

    public static SetMultimap newSetMultimap(Map map, Supplier supplier) {
        Multimaps$CustomSetMultimap multimaps$CustomSetMultimap = new Multimaps$CustomSetMultimap(map, supplier);
        return multimaps$CustomSetMultimap;
    }

    public static SortedSetMultimap newSortedSetMultimap(Map map, Supplier supplier) {
        Multimaps$CustomSortedSetMultimap multimaps$CustomSortedSetMultimap = new Multimaps$CustomSortedSetMultimap(map, supplier);
        return multimaps$CustomSortedSetMultimap;
    }

    public static ListMultimap synchronizedListMultimap(ListMultimap listMultimap) {
        return Synchronized.listMultimap(listMultimap, null);
    }

    public static Multimap synchronizedMultimap(Multimap multimap) {
        return Synchronized.multimap(multimap, null);
    }

    public static SetMultimap synchronizedSetMultimap(SetMultimap setMultimap) {
        return Synchronized.setMultimap(setMultimap, null);
    }

    public static SortedSetMultimap synchronizedSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        return Synchronized.sortedSetMultimap(sortedSetMultimap, null);
    }

    public static ListMultimap transformEntries(ListMultimap listMultimap, Maps$EntryTransformer maps$EntryTransformer) {
        Multimaps$TransformedEntriesListMultimap multimaps$TransformedEntriesListMultimap = new Multimaps$TransformedEntriesListMultimap(listMultimap, maps$EntryTransformer);
        return multimaps$TransformedEntriesListMultimap;
    }

    public static Multimap transformEntries(Multimap multimap, Maps$EntryTransformer maps$EntryTransformer) {
        Multimaps$TransformedEntriesMultimap multimaps$TransformedEntriesMultimap = new Multimaps$TransformedEntriesMultimap(multimap, maps$EntryTransformer);
        return multimaps$TransformedEntriesMultimap;
    }

    public static ListMultimap transformValues(ListMultimap listMultimap, Function object) {
        Preconditions.checkNotNull(object);
        object = Maps.asEntryTransformer((Function)object);
        return Multimaps.transformEntries(listMultimap, (Maps$EntryTransformer)object);
    }

    public static Multimap transformValues(Multimap multimap, Function object) {
        Preconditions.checkNotNull(object);
        object = Maps.asEntryTransformer((Function)object);
        return Multimaps.transformEntries(multimap, (Maps$EntryTransformer)object);
    }

    private static Collection unmodifiableEntries(Collection collection) {
        boolean bl2 = collection instanceof Set;
        if (bl2) {
            return Maps.unmodifiableEntrySet((Set)collection);
        }
        collection = Collections.unmodifiableCollection(collection);
        Maps$UnmodifiableEntries maps$UnmodifiableEntries = new Maps$UnmodifiableEntries(collection);
        return maps$UnmodifiableEntries;
    }

    public static ListMultimap unmodifiableListMultimap(ImmutableListMultimap immutableListMultimap) {
        return (ListMultimap)Preconditions.checkNotNull(immutableListMultimap);
    }

    public static ListMultimap unmodifiableListMultimap(ListMultimap listMultimap) {
        boolean bl2 = listMultimap instanceof Multimaps$UnmodifiableListMultimap;
        if (!bl2 && !(bl2 = listMultimap instanceof ImmutableListMultimap)) {
            Multimaps$UnmodifiableListMultimap multimaps$UnmodifiableListMultimap = new Multimaps$UnmodifiableListMultimap(listMultimap);
            return multimaps$UnmodifiableListMultimap;
        }
        return listMultimap;
    }

    public static Multimap unmodifiableMultimap(ImmutableMultimap immutableMultimap) {
        return (Multimap)Preconditions.checkNotNull(immutableMultimap);
    }

    public static Multimap unmodifiableMultimap(Multimap multimap) {
        boolean bl2 = multimap instanceof Multimaps$UnmodifiableMultimap;
        if (!bl2 && !(bl2 = multimap instanceof ImmutableMultimap)) {
            Multimaps$UnmodifiableMultimap multimaps$UnmodifiableMultimap = new Multimaps$UnmodifiableMultimap(multimap);
            return multimaps$UnmodifiableMultimap;
        }
        return multimap;
    }

    public static SetMultimap unmodifiableSetMultimap(ImmutableSetMultimap immutableSetMultimap) {
        return (SetMultimap)Preconditions.checkNotNull(immutableSetMultimap);
    }

    public static SetMultimap unmodifiableSetMultimap(SetMultimap setMultimap) {
        boolean bl2 = setMultimap instanceof Multimaps$UnmodifiableSetMultimap;
        if (!bl2 && !(bl2 = setMultimap instanceof ImmutableSetMultimap)) {
            Multimaps$UnmodifiableSetMultimap multimaps$UnmodifiableSetMultimap = new Multimaps$UnmodifiableSetMultimap(setMultimap);
            return multimaps$UnmodifiableSetMultimap;
        }
        return setMultimap;
    }

    public static SortedSetMultimap unmodifiableSortedSetMultimap(SortedSetMultimap sortedSetMultimap) {
        boolean bl2 = sortedSetMultimap instanceof Multimaps$UnmodifiableSortedSetMultimap;
        if (bl2) {
            return sortedSetMultimap;
        }
        Multimaps$UnmodifiableSortedSetMultimap multimaps$UnmodifiableSortedSetMultimap = new Multimaps$UnmodifiableSortedSetMultimap(sortedSetMultimap);
        return multimaps$UnmodifiableSortedSetMultimap;
    }

    private static Collection unmodifiableValueCollection(Collection collection) {
        boolean bl2 = collection instanceof SortedSet;
        if (bl2) {
            return Collections.unmodifiableSortedSet((SortedSet)collection);
        }
        bl2 = collection instanceof Set;
        if (bl2) {
            return Collections.unmodifiableSet((Set)collection);
        }
        bl2 = collection instanceof List;
        if (bl2) {
            return Collections.unmodifiableList((List)collection);
        }
        return Collections.unmodifiableCollection(collection);
    }
}

