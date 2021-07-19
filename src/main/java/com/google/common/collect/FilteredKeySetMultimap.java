/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.FilteredKeySetMultimap$EntrySet;
import com.google.common.collect.FilteredSetMultimap;
import com.google.common.collect.SetMultimap;
import java.util.Set;

public final class FilteredKeySetMultimap
extends FilteredKeyMultimap
implements FilteredSetMultimap {
    public FilteredKeySetMultimap(SetMultimap setMultimap, Predicate predicate) {
        super(setMultimap, predicate);
    }

    public Set createEntries() {
        FilteredKeySetMultimap$EntrySet filteredKeySetMultimap$EntrySet = new FilteredKeySetMultimap$EntrySet(this);
        return filteredKeySetMultimap$EntrySet;
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

