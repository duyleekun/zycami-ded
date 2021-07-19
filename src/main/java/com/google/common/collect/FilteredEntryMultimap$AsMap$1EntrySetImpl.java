/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public class FilteredEntryMultimap$AsMap$1EntrySetImpl
extends Maps$EntrySet {
    public final /* synthetic */ FilteredEntryMultimap$AsMap this$1;

    public FilteredEntryMultimap$AsMap$1EntrySetImpl(FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap) {
        this.this$1 = filteredEntryMultimap$AsMap;
    }

    public Iterator iterator() {
        FilteredEntryMultimap$AsMap$1EntrySetImpl$1 filteredEntryMultimap$AsMap$1EntrySetImpl$1 = new FilteredEntryMultimap$AsMap$1EntrySetImpl$1(this);
        return filteredEntryMultimap$AsMap$1EntrySetImpl$1;
    }

    public Map map() {
        return this.this$1;
    }

    public boolean removeAll(Collection object) {
        FilteredEntryMultimap filteredEntryMultimap = this.this$1.this$0;
        object = Predicates.in((Collection)object);
        return filteredEntryMultimap.removeEntriesIf((Predicate)object);
    }

    public boolean retainAll(Collection object) {
        FilteredEntryMultimap filteredEntryMultimap = this.this$1.this$0;
        object = Predicates.not(Predicates.in((Collection)object));
        return filteredEntryMultimap.removeEntriesIf((Predicate)object);
    }

    public int size() {
        return Iterators.size(this.iterator());
    }
}

