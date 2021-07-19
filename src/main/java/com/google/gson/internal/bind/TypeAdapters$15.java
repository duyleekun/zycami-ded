/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$15
extends TypeAdapter {
    public Character read(JsonReader object) {
        int n10;
        Object object2;
        Object object3 = ((JsonReader)object).peek();
        if (object3 == (object2 = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        int n11 = ((String)(object = ((JsonReader)object).nextString())).length();
        if (n11 == (n10 = 1)) {
            return Character.valueOf(((String)object).charAt(0));
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Expecting character, got: ");
        ((StringBuilder)object2).append((String)object);
        object = ((StringBuilder)object2).toString();
        object3 = new JsonSyntaxException((String)object);
        throw object3;
    }

    public void write(JsonWriter jsonWriter, Character object) {
        object = object == null ? null : String.valueOf(object);
        jsonWriter.value((String)object);
    }
}

