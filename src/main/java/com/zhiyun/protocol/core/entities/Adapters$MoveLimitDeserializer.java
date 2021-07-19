/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.core.entities.Adapters;
import com.zhiyun.protocol.core.entities.MoveLimit;
import java.lang.reflect.Type;

public class Adapters$MoveLimitDeserializer
implements JsonDeserializer {
    public MoveLimit deserialize(JsonElement object, Type object2, JsonDeserializationContext object3) {
        int n10;
        int n11;
        object2 = new MoveLimit();
        if ((object = Adapters.access$000((JsonElement)object)) == null) {
            return object2;
        }
        int n12 = ((JsonArray)object).size();
        if (n12 >= (n11 = 1)) {
            n12 = 0;
            ((MoveLimit)object2).pitch = object3 = Adapters.access$100(((JsonArray)object).get(0));
        }
        if ((n12 = ((JsonArray)object).size()) >= (n10 = 2)) {
            ((MoveLimit)object2).roll = object3 = Adapters.access$100(((JsonArray)object).get(n11));
        }
        if ((n12 = ((JsonArray)object).size()) >= (n11 = 3)) {
            ((MoveLimit)object2).yaw = object = Adapters.access$100(((JsonArray)object).get(n10));
        }
        return object2;
    }
}

