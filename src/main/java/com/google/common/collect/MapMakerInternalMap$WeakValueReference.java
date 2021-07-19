/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import java.lang.ref.ReferenceQueue;

public interface MapMakerInternalMap$WeakValueReference {
    public void clear();

    public MapMakerInternalMap$WeakValueReference copyFor(ReferenceQueue var1, MapMakerInternalMap$InternalEntry var2);

    public Object get();

    public MapMakerInternalMap$InternalEntry getEntry();
}

