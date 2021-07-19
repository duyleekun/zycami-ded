/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap;
import com.google.common.collect.MapMakerInternalMap$InternalEntry;
import com.google.common.collect.MapMakerInternalMap$Segment;
import com.google.common.collect.MapMakerInternalMap$Strength;

public interface MapMakerInternalMap$InternalEntryHelper {
    public MapMakerInternalMap$InternalEntry copy(MapMakerInternalMap$Segment var1, MapMakerInternalMap$InternalEntry var2, MapMakerInternalMap$InternalEntry var3);

    public MapMakerInternalMap$Strength keyStrength();

    public MapMakerInternalMap$InternalEntry newEntry(MapMakerInternalMap$Segment var1, Object var2, int var3, MapMakerInternalMap$InternalEntry var4);

    public MapMakerInternalMap$Segment newSegment(MapMakerInternalMap var1, int var2, int var3);

    public void setValue(MapMakerInternalMap$Segment var1, MapMakerInternalMap$InternalEntry var2, Object var3);

    public MapMakerInternalMap$Strength valueStrength();
}

