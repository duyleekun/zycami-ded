/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.LongSerializationPolicy;

public final class LongSerializationPolicy$2
extends LongSerializationPolicy {
    public JsonElement serialize(Long object) {
        object = String.valueOf(object);
        JsonPrimitive jsonPrimitive = new JsonPrimitive((String)object);
        return jsonPrimitive;
    }
}

