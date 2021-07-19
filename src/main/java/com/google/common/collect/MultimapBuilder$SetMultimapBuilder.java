/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.SetMultimap;

public abstract class MultimapBuilder$SetMultimapBuilder
extends MultimapBuilder {
    public MultimapBuilder$SetMultimapBuilder() {
        super(null);
    }

    public abstract SetMultimap build();

    public SetMultimap build(Multimap multimap) {
        return (SetMultimap)super.build(multimap);
    }
}

