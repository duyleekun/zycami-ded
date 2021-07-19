/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.ImmutableMap;

public class EmptyImmutableListMultimap
extends ImmutableListMultimap {
    public static final EmptyImmutableListMultimap INSTANCE;
    private static final long serialVersionUID;

    static {
        EmptyImmutableListMultimap emptyImmutableListMultimap;
        INSTANCE = emptyImmutableListMultimap = new EmptyImmutableListMultimap();
    }

    private EmptyImmutableListMultimap() {
        ImmutableMap immutableMap = ImmutableMap.of();
        super(immutableMap, 0);
    }

    private Object readResolve() {
        return INSTANCE;
    }
}

