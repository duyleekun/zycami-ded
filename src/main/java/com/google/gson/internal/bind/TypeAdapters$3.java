/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$3
extends TypeAdapter {
    public Boolean read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        jsonToken = JsonToken.STRING;
        if (jsonToken2 == jsonToken) {
            return Boolean.parseBoolean(jsonReader.nextString());
        }
        return jsonReader.nextBoolean();
    }

    public void write(JsonWriter jsonWriter, Boolean bl2) {
        jsonWriter.value(bl2);
    }
}

