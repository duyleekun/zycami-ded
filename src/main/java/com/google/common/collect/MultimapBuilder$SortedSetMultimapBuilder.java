/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder$SetMultimapBuilder;
import com.google.common.collect.SortedSetMultimap;

public abstract class MultimapBuilder$SortedSetMultimapBuilder
extends MultimapBuilder$SetMultimapBuilder {
    public abstract SortedSetMultimap build();

    public SortedSetMultimap build(Multimap multimap) {
        return (SortedSetMultimap)super.build(multimap);
    }
}

