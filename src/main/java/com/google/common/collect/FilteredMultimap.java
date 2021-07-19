/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Multimap;

public interface FilteredMultimap
extends Multimap {
    public Predicate entryPredicate();

    public Multimap unfiltered();
}

