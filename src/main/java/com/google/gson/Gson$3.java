/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class Gson$3
extends TypeAdapter {
    public Number read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        return jsonReader.nextLong();
    }

    public void write(JsonWriter jsonWriter, Number object) {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        object = object.toString();
        jsonWriter.value((String)object);
    }
}

