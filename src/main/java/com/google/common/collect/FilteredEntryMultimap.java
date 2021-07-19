/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.FilteredMultimapValues;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class FilteredEntryMultimap
extends AbstractMultimap
implements FilteredMultimap {
    public final Predicate predicate;
    public final Multimap unfiltered;

    public FilteredEntryMultimap(Multimap object, Predicate predicate) {
        object = (Multimap)Preconditions.checkNotNull(object);
        this.unfiltered = object;
        this.predicate = object = (Predicate)Preconditions.checkNotNull(predicate);
    }

    public static /* synthetic */ boolean access$000(FilteredEntryMultimap filteredEntryMultimap, Object object, Object object2) {
        return filteredEntryMultimap.satisfies(object, object2);
    }

    public static Collection filterCollection(Collection collection, Predicate predicate) {
        boolean bl2 = collection instanceof Set;
        if (bl2) {
            return Sets.filter((Set)collection, predicate);
        }
        return Collections2.filter(collection, predicate);
    }

    private boolean satisfies(Object object, Object object2) {
        Predicate predicate = this.predicate;
        object = Maps.immutableEntry(object, object2);
        return predicate.apply(object);
    }

    public void clear() {
        this.entries().clear();
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        Map map = this.asMap();
        object = map.get(object);
        if (object != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Map createAsMap() {
        FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap = new FilteredEntryMultimap$AsMap(this);
        return filteredEntryMultimap$AsMap;
    }

    public Collection createEntries() {
        Collection collection = this.unfiltered.entries();
        Predicate predicate = this.predicate;
        return FilteredEntryMultimap.filterCollection(collection, predicate);
    }

    public Set createKeySet() {
        return this.asMap().keySet();
    }

    public Multiset createKeys() {
        FilteredEntryMultimap$Keys filteredEntryMultimap$Keys = new FilteredEntryMultimap$Keys(this);
        return filteredEntryMultimap$Keys;
    }

    public Collection createValues() {
        FilteredMultimapValues filteredMultimapValues = new FilteredMultimapValues(this);
        return filteredMultimapValues;
    }

    public Iterator entryIterator() {
        AssertionError assertionError = new AssertionError((Object)"should never be called");
        throw assertionError;
    }

    public Predicate entryPredicate() {
        return this.predicate;
    }

    public Collection get(Object object) {
        Collection collection = this.unfiltered.get(object);
        FilteredEntryMultimap$ValuePredicate filteredEntryMultimap$ValuePredicate = new FilteredEntryMultimap$ValuePredicate(this, object);
        return FilteredEntryMultimap.filterCollection(collection, filteredEntryMultimap$ValuePredicate);
    }

    public Collection removeAll(Object object) {
        object = this.asMap().remove(object);
        Collection collection = this.unmodifiableEmptyCollection();
        return (Collection)MoreObjects.firstNonNull(object, collection);
    }

    public boolean removeEntriesIf(Predicate predicate) {
        int n10;
        Iterator iterator2 = this.unfiltered.asMap().entrySet().iterator();
        int n11 = 0;
        while ((n10 = iterator2.hasNext()) != 0) {
            boolean bl2;
            Object object = iterator2.next();
            Object object2 = object.getKey();
            Collection collection = (Collection)object.getValue();
            FilteredEntryMultimap$ValuePredicate filteredEntryMultimap$ValuePredicate = new FilteredEntryMultimap$ValuePredicate(this, object2);
            boolean bl3 = (collection = FilteredEntryMultimap.filterCollection(collection, filteredEntryMultimap$ValuePredicate)).isEmpty();
            if (bl3 || !(bl2 = predicate.apply(object2 = Maps.immutableEntry(object2, collection)))) continue;
            n11 = collection.size();
            if (n11 == (n10 = (object = (Collection)object.getValue()).size())) {
                iterator2.remove();
            } else {
                collection.clear();
            }
            n11 = 1;
        }
        return n11 != 0;
    }

    public int size() {
        return this.entries().size();
    }

    public Multimap unfiltered() {
        return this.unfiltered;
    }

    public Collection unmodifiableEmptyCollection() {
        Object object = this.unfiltered;
        boolean bl2 = object instanceof SetMultimap;
        object = bl2 ? Collections.emptySet() : Collections.emptyList();
        return object;
    }
}

