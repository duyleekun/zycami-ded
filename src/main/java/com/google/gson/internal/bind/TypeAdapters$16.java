/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$16
extends TypeAdapter {
    public String read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        jsonToken = JsonToken.BOOLEAN;
        if (jsonToken2 == jsonToken) {
            return Boolean.toString(jsonReader.nextBoolean());
        }
        return jsonReader.nextString();
    }

    public void write(JsonWriter jsonWriter, String string2) {
        jsonWriter.value(string2);
    }
}

