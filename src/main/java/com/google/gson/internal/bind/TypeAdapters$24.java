/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.util.UUID;

public class TypeAdapters$24
extends TypeAdapter {
    public UUID read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        return UUID.fromString(jsonReader.nextString());
    }

    public void write(JsonWriter jsonWriter, UUID object) {
        object = object == null ? null : ((UUID)object).toString();
        jsonWriter.value((String)object);
    }
}

