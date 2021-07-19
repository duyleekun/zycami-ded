/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class TypeAdapters$1
extends TypeAdapter {
    public Class read(JsonReader object) {
        object = new UnsupportedOperationException("Attempted to deserialize a java.lang.Class. Forgot to register a type adapter?");
        throw object;
    }

    public void write(JsonWriter object, Class object2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Attempted to serialize java.lang.Class: ");
        object2 = ((Class)object2).getName();
        stringBuilder.append((String)object2);
        stringBuilder.append(". Forgot to register a type adapter?");
        object2 = stringBuilder.toString();
        object = new UnsupportedOperationException((String)object2);
        throw object;
    }
}

