/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.net.URL;

public class TypeAdapters$21
extends TypeAdapter {
    public URL read(JsonReader object) {
        Object object2 = ((JsonReader)object).peek();
        JsonToken jsonToken = JsonToken.NULL;
        URL uRL = null;
        if (object2 == jsonToken) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object2 = "null";
        boolean bl2 = ((String)object2).equals(object = ((JsonReader)object).nextString());
        if (!bl2) {
            uRL = new URL((String)object);
        }
        return uRL;
    }

    public void write(JsonWriter jsonWriter, URL object) {
        object = object == null ? null : ((URL)object).toExternalForm();
        jsonWriter.value((String)object);
    }
}

