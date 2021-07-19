/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.Active;
import java.lang.reflect.Type;

public class Adapters$ActiveDeserializer
implements JsonDeserializer {
    public Active deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return Active.from(jsonElement.getAsInt());
    }
}

