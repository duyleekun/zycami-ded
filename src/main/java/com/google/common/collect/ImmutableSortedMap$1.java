/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

public final class ImmutableSortedMap$1
implements Comparator {
    public final /* synthetic */ Comparator val$comparator;

    public ImmutableSortedMap$1(Comparator comparator) {
        this.val$comparator = comparator;
    }

    public int compare(Map.Entry entry, Map.Entry entry2) {
        Comparator comparator = this.val$comparator;
        entry = entry.getKey();
        entry2 = entry2.getKey();
        return comparator.compare(entry, entry2);
    }
}

