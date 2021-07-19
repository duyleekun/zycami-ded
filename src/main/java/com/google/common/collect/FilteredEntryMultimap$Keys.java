/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multimaps$Keys;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class FilteredEntryMultimap$Keys
extends Multimaps$Keys {
    public final /* synthetic */ FilteredEntryMultimap this$0;

    public FilteredEntryMultimap$Keys(FilteredEntryMultimap filteredEntryMultimap) {
        this.this$0 = filteredEntryMultimap;
        super(filteredEntryMultimap);
    }

    public Set entrySet() {
        FilteredEntryMultimap$Keys$1 filteredEntryMultimap$Keys$1 = new FilteredEntryMultimap$Keys$1(this);
        return filteredEntryMultimap$Keys$1;
    }

    public int remove(Object object, int n10) {
        boolean bl2;
        Iterator iterator2 = "occurrences";
        CollectPreconditions.checkNonnegative(n10, (String)((Object)iterator2));
        if (n10 == 0) {
            return this.count(object);
        }
        iterator2 = (Collection)this.this$0.unfiltered.asMap().get(object);
        int n11 = 0;
        if (iterator2 == null) {
            return 0;
        }
        iterator2 = iterator2.iterator();
        while (bl2 = iterator2.hasNext()) {
            FilteredEntryMultimap filteredEntryMultimap = this.this$0;
            Object e10 = iterator2.next();
            bl2 = FilteredEntryMultimap.access$000(filteredEntryMultimap, object, e10);
            if (!bl2 || ++n11 > n10) continue;
            iterator2.remove();
        }
        return n11;
    }
}

