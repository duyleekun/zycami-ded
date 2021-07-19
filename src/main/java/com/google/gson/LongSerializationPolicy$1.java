/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.LongSerializationPolicy;

public final class LongSerializationPolicy$1
extends LongSerializationPolicy {
    public JsonElement serialize(Long l10) {
        JsonPrimitive jsonPrimitive = new JsonPrimitive(l10);
        return jsonPrimitive;
    }
}

