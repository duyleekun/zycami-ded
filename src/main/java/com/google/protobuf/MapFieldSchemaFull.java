/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.MapEntry;
import com.google.protobuf.MapEntry$Metadata;
import com.google.protobuf.MapEntryLite;
import com.google.protobuf.MapEntryLite$Metadata;
import com.google.protobuf.MapField;
import com.google.protobuf.MapFieldSchema;
import java.util.Map;

public class MapFieldSchemaFull
implements MapFieldSchema {
    private static int getSerializedSizeFull(int n10, Object iterator2, Object object) {
        int n11 = 0;
        if (iterator2 == null) {
            return 0;
        }
        iterator2 = ((MapField)((Object)iterator2)).getMap();
        object = (MapEntry)object;
        int n12 = iterator2.isEmpty();
        if (n12 != 0) {
            return 0;
        }
        iterator2 = iterator2.entrySet().iterator();
        while ((n12 = iterator2.hasNext()) != 0) {
            Map.Entry entry = iterator2.next();
            int n13 = CodedOutputStream.computeTagSize(n10);
            MapEntry$Metadata mapEntry$Metadata = ((MapEntry)object).getMetadata();
            Object k10 = entry.getKey();
            entry = entry.getValue();
            n12 = CodedOutputStream.computeLengthDelimitedFieldSize(MapEntryLite.computeSerializedSize(mapEntry$Metadata, k10, entry));
            n11 += (n13 += n12);
        }
        return n11;
    }

    private static Object mergeFromFull(Object object, Object object2) {
        object = (MapField)object;
        object2 = (MapField)object2;
        boolean bl2 = ((MapField)object).isMutable();
        if (!bl2) {
            ((MapField)object).copy();
        }
        ((MapField)object).mergeFrom((MapField)object2);
        return object;
    }

    public Map forMapData(Object object) {
        return ((MapField)object).getMap();
    }

    public MapEntryLite$Metadata forMapMetadata(Object object) {
        return ((MapEntry)object).getMetadata();
    }

    public Map forMutableMapData(Object object) {
        return ((MapField)object).getMutableMap();
    }

    public int getSerializedSize(int n10, Object object, Object object2) {
        return MapFieldSchemaFull.getSerializedSizeFull(n10, object, object2);
    }

    public boolean isImmutable(Object object) {
        return ((MapField)object).isMutable() ^ true;
    }

    public Object mergeFrom(Object object, Object object2) {
        return MapFieldSchemaFull.mergeFromFull(object, object2);
    }

    public Object newMapField(Object object) {
        return MapField.newMapField((MapEntry)object);
    }

    public Object toImmutable(Object object) {
        ((MapField)object).makeImmutable();
        return object;
    }
}

