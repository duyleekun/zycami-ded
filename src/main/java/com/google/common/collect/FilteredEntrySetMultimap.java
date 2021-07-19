/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.Set;

public final class FilteredEntrySetMultimap
extends FilteredEntryMultimap
implements FilteredSetMultimap {
    public FilteredEntrySetMultimap(SetMultimap setMultimap, Predicate predicate) {
        super(setMultimap, predicate);
    }

    public Set createEntries() {
        Set set = this.unfiltered().entries();
        Predicate predicate = this.entryPredicate();
        return Sets.filter(set, predicate);
    }

    public Set entries() {
        return (Set)super.entries();
    }

    public Set get(Object object) {
        return (Set)super.get(object);
    }

    public Set removeAll(Object object) {
        return (Set)super.removeAll(object);
    }

    public Set replaceValues(Object object, Iterable iterable) {
        return (Set)super.replaceValues(object, iterable);
    }

    public SetMultimap unfiltered() {
        return (SetMultimap)this.unfiltered;
    }
}

