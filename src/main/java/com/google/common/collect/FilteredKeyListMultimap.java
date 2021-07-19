/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ListMultimap;
import java.util.List;

public final class FilteredKeyListMultimap
extends FilteredKeyMultimap
implements ListMultimap {
    public FilteredKeyListMultimap(ListMultimap listMultimap, Predicate predicate) {
        super(listMultimap, predicate);
    }

    public List get(Object object) {
        return (List)super.get(object);
    }

    public List removeAll(Object object) {
        return (List)super.removeAll(object);
    }

    public List replaceValues(Object object, Iterable iterable) {
        return (List)super.replaceValues(object, iterable);
    }

    public ListMultimap unfiltered() {
        return (ListMultimap)super.unfiltered();
    }
}

