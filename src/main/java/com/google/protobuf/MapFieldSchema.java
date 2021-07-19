/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntryLite$Metadata;
import java.util.Map;

public interface MapFieldSchema {
    public Map forMapData(Object var1);

    public MapEntryLite$Metadata forMapMetadata(Object var1);

    public Map forMutableMapData(Object var1);

    public int getSerializedSize(int var1, Object var2, Object var3);

    public boolean isImmutable(Object var1);

    public Object mergeFrom(Object var1, Object var2);

    public Object newMapField(Object var1);

    public Object toImmutable(Object var1);
}

