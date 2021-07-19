/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.ConnectionMethod;
import java.lang.reflect.Type;

public class Adapters$ConnectionMethodDeserializer
implements JsonDeserializer {
    public ConnectionMethod deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return ConnectionMethod.from(jsonElement.getAsInt());
    }
}

