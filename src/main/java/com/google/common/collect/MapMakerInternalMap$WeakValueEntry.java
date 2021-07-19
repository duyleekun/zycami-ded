/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$WeakValueReference;

public interface MapMakerInternalMap$WeakValueEntry
extends MapMakerInternalMap$InternalEntry {
    public void clearValue();

    public MapMakerInternalMap$WeakValueReference getValueReference();
}

