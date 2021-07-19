/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$4
extends TypeAdapter {
    public Boolean read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        return Boolean.valueOf(jsonReader.nextString());
    }

    public void write(JsonWriter jsonWriter, Boolean object) {
        object = object == null ? "null" : ((Boolean)object).toString();
        jsonWriter.value((String)object);
    }
}

