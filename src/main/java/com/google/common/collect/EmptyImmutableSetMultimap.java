/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSetMultimap;

public class EmptyImmutableSetMultimap
extends ImmutableSetMultimap {
    public static final EmptyImmutableSetMultimap INSTANCE;
    private static final long serialVersionUID;

    static {
        EmptyImmutableSetMultimap emptyImmutableSetMultimap;
        INSTANCE = emptyImmutableSetMultimap = new EmptyImmutableSetMultimap();
    }

    private EmptyImmutableSetMultimap() {
        ImmutableMap immutableMap = ImmutableMap.of();
        super(immutableMap, 0, null);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

