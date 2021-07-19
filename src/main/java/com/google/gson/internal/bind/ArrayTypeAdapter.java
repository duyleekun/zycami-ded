/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ArrayTypeAdapter$1;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class ArrayTypeAdapter
extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final Class componentType;
    private final TypeAdapter componentTypeAdapter;

    static {
        ArrayTypeAdapter$1 arrayTypeAdapter$1 = new ArrayTypeAdapter$1();
        FACTORY = arrayTypeAdapter$1;
    }

    public ArrayTypeAdapter(Gson gson, TypeAdapter typeAdapter, Class clazz) {
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, clazz);
        this.componentTypeAdapter = typeAdapterRuntimeTypeWrapper;
        this.componentType = clazz;
    }

    public Object read(JsonReader jsonReader) {
        boolean bl2;
        Object object;
        Object object2 = jsonReader.peek();
        if (object2 == (object = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        object2 = new ArrayList();
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            object = this.componentTypeAdapter.read(jsonReader);
            object2.add(object);
        }
        jsonReader.endArray();
        int n10 = object2.size();
        object = Array.newInstance(this.componentType, n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object e10 = object2.get(i10);
            Array.set(object, i10, e10);
        }
        return object;
    }

    public void write(JsonWriter jsonWriter, Object object) {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        int n10 = Array.getLength(object);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = Array.get(object, i10);
            TypeAdapter typeAdapter = this.componentTypeAdapter;
            typeAdapter.write(jsonWriter, object2);
        }
        jsonWriter.endArray();
    }
}

