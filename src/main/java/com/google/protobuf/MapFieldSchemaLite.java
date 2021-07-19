/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MapFieldLite;
import com.google.protobuf.MapFieldSchema;
import java.util.HashMap;
import java.util.Map;

public class MapFieldSchemaLite
implements MapFieldSchema {
    private static int getSerializedSizeLite(int n10, Object iterator2, Object object) {
        int n11;
        iterator2 = (MapFieldLite)((Object)iterator2);
        object = (MapEntryLite)object;
        boolean n112 = ((HashMap)((Object)iterator2)).isEmpty();
        int n12 = 0;
        if (n112) {
            return 0;
        }
        iterator2 = ((MapFieldLite)((Object)iterator2)).entrySet().iterator();
        while ((n11 = iterator2.hasNext()) != 0) {
            Map.Entry entry = (Map.Entry)iterator2.next();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            n11 = ((MapEntryLite)object).computeMessageSize(n10, k10, entry);
            n12 += n11;
        }
        return n12;
    }

    private static MapFieldLite mergeFromLite(Object object, Object object2) {
        object = (MapFieldLite)object;
        boolean bl2 = ((HashMap)(object2 = (MapFieldLite)object2)).isEmpty();
        if (!bl2) {
            bl2 = ((MapFieldLite)object).isMutable();
            if (!bl2) {
                object = ((MapFieldLite)object).mutableCopy();
            }
            ((MapFieldLite)object).mergeFrom((MapFieldLite)object2);
        }
        return object;
    }

    public Map forMapData(Object object) {
        return (MapFieldLite)object;
    }

    public MapEntryLite$Metadata forMapMetadata(Object object) {
        return ((MapEntryLite)object).getMetadata();
    }

    public Map forMutableMapData(Object object) {
        return (MapFieldLite)object;
    }

    public int getSerializedSize(int n10, Object object, Object object2) {
        return MapFieldSchemaLite.getSerializedSizeLite(n10, object, object2);
    }

    public boolean isImmutable(Object object) {
        return ((MapFieldLite)object).isMutable() ^ true;
    }

    public Object mergeFrom(Object object, Object object2) {
        return MapFieldSchemaLite.mergeFromLite(object, object2);
    }

    public Object newMapField(Object object) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    public Object toImmutable(Object object) {
        ((MapFieldLite)object).makeImmutable();
        return object;
    }
}

