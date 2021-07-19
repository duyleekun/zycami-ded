/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class FilteredMultimapValues
extends AbstractCollection {
    private final FilteredMultimap multimap;

    public FilteredMultimapValues(FilteredMultimap filteredMultimap) {
        this.multimap = filteredMultimap = (FilteredMultimap)Preconditions.checkNotNull(filteredMultimap);
    }

    public void clear() {
        this.multimap.clear();
    }

    public boolean contains(Object object) {
        return this.multimap.containsValue(object);
    }

    public Iterator iterator() {
        return Maps.valueIterator(this.multimap.entries().iterator());
    }

    public boolean remove(Object object) {
        boolean bl2;
        Predicate predicate = this.multimap.entryPredicate();
        Iterator iterator2 = this.multimap.unfiltered().entries().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            boolean bl3 = predicate.apply(entry);
            if (!bl3 || !(bl2 = Objects.equal(entry = entry.getValue(), object))) continue;
            iterator2.remove();
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection object) {
        Collection collection = this.multimap.unfiltered().entries();
        Predicate predicate = this.multimap.entryPredicate();
        object = Maps.valuePredicateOnEntries(Predicates.in((Collection)object));
        object = Predicates.and(predicate, (Predicate)object);
        return Iterables.removeIf(collection, (Predicate)object);
    }

    public boolean retainAll(Collection object) {
        Collection collection = this.multimap.unfiltered().entries();
        Predicate predicate = this.multimap.entryPredicate();
        object = Maps.valuePredicateOnEntries(Predicates.not(Predicates.in((Collection)object)));
        object = Predicates.and(predicate, (Predicate)object);
        return Iterables.removeIf(collection, (Predicate)object);
    }

    public int size() {
        return this.multimap.size();
    }
}

