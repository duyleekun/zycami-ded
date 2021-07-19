/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;

public abstract class MultimapBuilder$ListMultimapBuilder
extends MultimapBuilder {
    public MultimapBuilder$ListMultimapBuilder() {
        super(null);
    }

    public abstract ListMultimap build();

    public ListMultimap build(Multimap multimap) {
        return (ListMultimap)super.build(multimap);
    }
}

