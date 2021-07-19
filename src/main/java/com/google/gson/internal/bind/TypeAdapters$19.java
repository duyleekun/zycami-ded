/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$19
extends TypeAdapter {
    public StringBuilder read(JsonReader object) {
        JsonToken jsonToken;
        Object object2 = ((JsonReader)object).peek();
        if (object2 == (jsonToken = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object = ((JsonReader)object).nextString();
        object2 = new StringBuilder((String)object);
        return object2;
    }

    public void write(JsonWriter jsonWriter, StringBuilder charSequence) {
        charSequence = charSequence == null ? null : charSequence.toString();
        jsonWriter.value((String)charSequence);
    }
}

