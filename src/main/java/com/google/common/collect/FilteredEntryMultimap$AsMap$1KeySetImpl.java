/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;

public class FilteredEntryMultimap$AsMap$1KeySetImpl
extends Maps$KeySet {
    public final /* synthetic */ FilteredEntryMultimap$AsMap this$1;

    public FilteredEntryMultimap$AsMap$1KeySetImpl(FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap) {
        this.this$1 = filteredEntryMultimap$AsMap;
        super(filteredEntryMultimap$AsMap);
    }

    public boolean remove(Object object) {
        boolean bl2;
        FilteredEntryMultimap$AsMap filteredEntryMultimap$AsMap = this.this$1;
        if ((object = filteredEntryMultimap$AsMap.remove(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean removeAll(Collection object) {
        FilteredEntryMultimap filteredEntryMultimap = this.this$1.this$0;
        object = Maps.keyPredicateOnEntries(Predicates.in((Collection)object));
        return filteredEntryMultimap.removeEntriesIf((Predicate)object);
    }

    public boolean retainAll(Collection object) {
        FilteredEntryMultimap filteredEntryMultimap = this.this$1.this$0;
        object = Maps.keyPredicateOnEntries(Predicates.not(Predicates.in((Collection)object)));
        return filteredEntryMultimap.removeEntriesIf((Predicate)object);
    }
}

