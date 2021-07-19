/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.FilteredMultimap;
import com.google.common.collect.SetMultimap;

public interface FilteredSetMultimap
extends FilteredMultimap,
SetMultimap {
    public SetMultimap unfiltered();
}

