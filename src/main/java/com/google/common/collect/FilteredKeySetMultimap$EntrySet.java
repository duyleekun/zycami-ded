/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FilteredKeyMultimap$Entries;
import com.google.common.collect.FilteredKeySetMultimap;
import com.google.common.collect.Sets;
import java.util.Set;

public class FilteredKeySetMultimap$EntrySet
extends FilteredKeyMultimap$Entries
implements Set {
    public final /* synthetic */ FilteredKeySetMultimap this$0;

    public FilteredKeySetMultimap$EntrySet(FilteredKeySetMultimap filteredKeySetMultimap) {
        this.this$0 = filteredKeySetMultimap;
        super(filteredKeySetMultimap);
    }

    public boolean equals(Object object) {
        return Sets.equalsImpl(this, object);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }
}

