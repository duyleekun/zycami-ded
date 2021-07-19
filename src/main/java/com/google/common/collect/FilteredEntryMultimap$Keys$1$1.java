/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.FilteredEntryMultimap$Keys$1;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

public class FilteredEntryMultimap$Keys$1$1
implements Predicate {
    public final /* synthetic */ FilteredEntryMultimap.Keys.1 this$2;
    public final /* synthetic */ Predicate val$predicate;

    public FilteredEntryMultimap$Keys$1$1(FilteredEntryMultimap.Keys.1 var1_1, Predicate predicate) {
        this.this$2 = var1_1;
        this.val$predicate = predicate;
    }

    public boolean apply(Map.Entry object) {
        Predicate predicate = this.val$predicate;
        Object k10 = object.getKey();
        int n10 = ((Collection)object.getValue()).size();
        object = Multisets.immutableEntry(k10, n10);
        return predicate.apply(object);
    }
}

