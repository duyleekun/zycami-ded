/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.FilteredKeyMultimap;
import com.google.common.collect.ForwardingCollection;
import java.util.Collection;
import java.util.Map;

public class FilteredKeyMultimap$Entries
extends ForwardingCollection {
    public final /* synthetic */ FilteredKeyMultimap this$0;

    public FilteredKeyMultimap$Entries(FilteredKeyMultimap filteredKeyMultimap) {
        this.this$0 = filteredKeyMultimap;
    }

    public Collection delegate() {
        Collection collection = this.this$0.unfiltered.entries();
        Predicate predicate = this.this$0.entryPredicate();
        return Collections2.filter(collection, predicate);
    }

    public boolean remove(Object object) {
        Object k10;
        Object object2;
        boolean bl2 = object instanceof Map.Entry;
        if (bl2 && (bl2 = (object2 = this.this$0.unfiltered).containsKey(k10 = (object = (Map.Entry)object).getKey())) && (bl2 = (object2 = this.this$0.keyPredicate).apply(k10 = object.getKey()))) {
            object2 = this.this$0.unfiltered;
            k10 = object.getKey();
            object = object.getValue();
            return object2.remove(k10, object);
        }
        return false;
    }
}

