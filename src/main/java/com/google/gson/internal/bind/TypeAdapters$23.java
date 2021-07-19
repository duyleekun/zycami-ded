/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.InetAddress;

public class TypeAdapters$23
extends TypeAdapter {
    public InetAddress read(JsonReader jsonReader) {
        JsonToken jsonToken;
        JsonToken jsonToken2 = jsonReader.peek();
        if (jsonToken2 == (jsonToken = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        return InetAddress.getByName(jsonReader.nextString());
    }

    public void write(JsonWriter jsonWriter, InetAddress object) {
        object = object == null ? null : ((InetAddress)object).getHostAddress();
        jsonWriter.value((String)object);
    }
}

