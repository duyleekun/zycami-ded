/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

public interface JsonDeserializer {
    public Object deserialize(JsonElement var1, Type var2, JsonDeserializationContext var3);
}

