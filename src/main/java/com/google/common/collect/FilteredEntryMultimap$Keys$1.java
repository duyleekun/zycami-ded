/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys;
import com.google.common.collect.FilteredEntryMultimap$Keys$1$1;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Collection;
import java.util.Iterator;

public class FilteredEntryMultimap$Keys$1
extends Multisets$EntrySet {
    public final /* synthetic */ FilteredEntryMultimap$Keys this$1;

    public FilteredEntryMultimap$Keys$1(FilteredEntryMultimap$Keys keys) {
        this.this$1 = keys;
    }

    private boolean removeEntriesIf(Predicate predicate) {
        FilteredEntryMultimap filteredEntryMultimap = this.this$1.this$0;
        FilteredEntryMultimap$Keys$1$1 filteredEntryMultimap$Keys$1$1 = new FilteredEntryMultimap$Keys$1$1(this, predicate);
        return filteredEntryMultimap.removeEntriesIf(filteredEntryMultimap$Keys$1$1);
    }

    public Iterator iterator() {
        return this.this$1.entryIterator();
    }

    public Multiset multiset() {
        return this.this$1;
    }

    public boolean removeAll(Collection object) {
        object = Predicates.in((Collection)object);
        return this.removeEntriesIf((Predicate)object);
    }

    public boolean retainAll(Collection object) {
        object = Predicates.not(Predicates.in((Collection)object));
        return this.removeEntriesIf((Predicate)object);
    }

    public int size() {
        return this.this$1.this$0.keySet().size();
    }
}

