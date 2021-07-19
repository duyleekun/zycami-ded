/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class Gson$FutureTypeAdapter
extends TypeAdapter {
    private TypeAdapter delegate;

    public Object read(JsonReader object) {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) {
            return typeAdapter.read((JsonReader)object);
        }
        object = new IllegalStateException();
        throw object;
    }

    public void setDelegate(TypeAdapter object) {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter == null) {
            this.delegate = object;
            return;
        }
        object = new AssertionError();
        throw object;
    }

    public void write(JsonWriter object, Object object2) {
        TypeAdapter typeAdapter = this.delegate;
        if (typeAdapter != null) {
            typeAdapter.write((JsonWriter)object, object2);
            return;
        }
        object = new IllegalStateException();
        throw object;
    }
}

