/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FilteredEntryMultimap;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1EntrySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1KeySetImpl;
import com.google.common.collect.FilteredEntryMultimap$AsMap$1ValuesImpl;
import com.google.common.collect.FilteredEntryMultimap$ValuePredicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Sets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

public class FilteredEntryMultimap$AsMap
extends Maps$ViewCachingAbstractMap {
    public final /* synthetic */ FilteredEntryMultimap this$0;

    public FilteredEntryMultimap$AsMap(FilteredEntryMultimap filteredEntryMultimap) {
        this.this$0 = filteredEntryMultimap;
    }

    public void clear() {
        this.this$0.clear();
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        if ((object = this.get(object)) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Set createEntrySet() {
        FilteredEntryMultimap$AsMap$1EntrySetImpl filteredEntryMultimap$AsMap$1EntrySetImpl = new FilteredEntryMultimap$AsMap$1EntrySetImpl(this);
        return filteredEntryMultimap$AsMap$1EntrySetImpl;
    }

    public Set createKeySet() {
        FilteredEntryMultimap$AsMap$1KeySetImpl filteredEntryMultimap$AsMap$1KeySetImpl = new FilteredEntryMultimap$AsMap$1KeySetImpl(this);
        return filteredEntryMultimap$AsMap$1KeySetImpl;
    }

    public Collection createValues() {
        FilteredEntryMultimap$AsMap$1ValuesImpl filteredEntryMultimap$AsMap$1ValuesImpl = new FilteredEntryMultimap$AsMap$1ValuesImpl(this);
        return filteredEntryMultimap$AsMap$1ValuesImpl;
    }

    public Collection get(Object object) {
        Collection collection = (Collection)this.this$0.unfiltered.asMap().get(object);
        Object object2 = null;
        if (collection == null) {
            return null;
        }
        FilteredEntryMultimap filteredEntryMultimap = this.this$0;
        FilteredEntryMultimap$ValuePredicate filteredEntryMultimap$ValuePredicate = new FilteredEntryMultimap$ValuePredicate(filteredEntryMultimap, object);
        boolean bl2 = (object = FilteredEntryMultimap.filterCollection(collection, filteredEntryMultimap$ValuePredicate)).isEmpty();
        if (!bl2) {
            object2 = object;
        }
        return object2;
    }

    public Collection remove(Object object) {
        boolean bl2;
        Object object2 = (Collection)this.this$0.unfiltered.asMap().get(object);
        if (object2 == null) {
            return null;
        }
        ArrayList arrayList = Lists.newArrayList();
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            FilteredEntryMultimap filteredEntryMultimap = this.this$0;
            Object e10 = object2.next();
            boolean bl3 = FilteredEntryMultimap.access$000(filteredEntryMultimap, object, e10);
            if (!bl3) continue;
            object2.remove();
            arrayList.add(e10);
        }
        boolean bl4 = arrayList.isEmpty();
        if (bl4) {
            return null;
        }
        object = this.this$0.unfiltered;
        bl4 = object instanceof SetMultimap;
        if (bl4) {
            return Collections.unmodifiableSet(Sets.newLinkedHashSet(arrayList));
        }
        return Collections.unmodifiableList(arrayList);
    }
}

