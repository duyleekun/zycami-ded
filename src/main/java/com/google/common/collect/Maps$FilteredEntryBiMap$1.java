/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import java.util.Map;

public final class Maps$FilteredEntryBiMap$1
implements Predicate {
    public final /* synthetic */ Predicate val$forwardPredicate;

    public Maps$FilteredEntryBiMap$1(Predicate predicate) {
        this.val$forwardPredicate = predicate;
    }

    public boolean apply(Map.Entry entry) {
        Predicate predicate = this.val$forwardPredicate;
        Object v10 = entry.getValue();
        entry = entry.getKey();
        entry = Maps.immutableEntry(v10, entry);
        return predicate.apply(entry);
    }
}

