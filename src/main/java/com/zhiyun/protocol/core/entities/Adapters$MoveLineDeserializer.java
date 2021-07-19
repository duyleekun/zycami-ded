/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.core.entities.MoveLine;
import d.v.y.d.b;
import java.lang.reflect.Type;

public class Adapters$MoveLineDeserializer
implements JsonDeserializer {
    public MoveLine deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        int bl2 = jsonElement.getAsInt();
        boolean bl3 = b.c(bl2, 0);
        boolean bl4 = b.c(bl2, 1);
        boolean bl5 = b.c(bl2, 2);
        MoveLine moveLine = new MoveLine(bl3, bl4, bl5);
        return moveLine;
    }
}

