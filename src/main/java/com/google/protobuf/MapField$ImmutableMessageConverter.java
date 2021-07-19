/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.MapEntry;
import com.google.protobuf.MapField$Converter;
import com.google.protobuf.Message;
import java.util.Map;

public class MapField$ImmutableMessageConverter
implements MapField$Converter {
    private final MapEntry defaultEntry;

    public MapField$ImmutableMessageConverter(MapEntry mapEntry) {
        this.defaultEntry = mapEntry;
    }

    public Message convertKeyAndValueToMessage(Object object, Object object2) {
        return this.defaultEntry.newBuilderForType().setKey(object).setValue(object2).buildPartial();
    }

    public void convertMessageToKeyAndValue(Message object, Map map) {
        object = (MapEntry)object;
        Object object2 = ((MapEntry)object).getKey();
        object = ((MapEntry)object).getValue();
        map.put(object2, object);
    }

    public Message getMessageDefaultInstance() {
        return this.defaultEntry;
    }
}

