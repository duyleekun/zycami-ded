/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.core.entities.Adapters;
import com.zhiyun.protocol.core.entities.PresetLimit;
import com.zhiyun.protocol.core.entities.PresetLimit$Row;
import d.v.y.d.i;
import java.lang.reflect.Type;

public class Adapters$PresetLimitDeserializer
implements JsonDeserializer {
    private PresetLimit$Row parseRow(JsonElement object) {
        i i10;
        object = Adapters.access$000((JsonElement)object);
        PresetLimit$Row presetLimit$Row = new PresetLimit$Row();
        presetLimit$Row.follow = i10 = Adapters.access$100(((JsonArray)object).get(0));
        presetLimit$Row.control = i10 = Adapters.access$100(((JsonArray)object).get(1));
        presetLimit$Row.smooth = i10 = Adapters.access$100(((JsonArray)object).get(2));
        presetLimit$Row.dead = object = Adapters.access$100(((JsonArray)object).get(3));
        return presetLimit$Row;
    }

    public PresetLimit deserialize(JsonElement object, Type object2, JsonDeserializationContext object3) {
        int n10;
        int n11;
        if ((object = Adapters.access$000((JsonElement)object)) != null && (n11 = ((JsonArray)object).size()) >= (n10 = 3)) {
            object2 = new PresetLimit();
            object3 = ((JsonArray)object).get(0);
            ((PresetLimit)object2).pitch = object3 = this.parseRow((JsonElement)object3);
            object3 = ((JsonArray)object).get(1);
            ((PresetLimit)object2).roll = object3 = this.parseRow((JsonElement)object3);
            object = ((JsonArray)object).get(2);
            ((PresetLimit)object2).yaw = object = this.parseRow((JsonElement)object);
            return object2;
        }
        return null;
    }
}

