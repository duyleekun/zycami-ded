/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.Collection;

public final class CollectionTypeAdapterFactory$Adapter
extends TypeAdapter {
    private final ObjectConstructor constructor;
    private final TypeAdapter elementTypeAdapter;

    public CollectionTypeAdapterFactory$Adapter(Gson gson, Type type, TypeAdapter typeAdapter, ObjectConstructor objectConstructor) {
        TypeAdapterRuntimeTypeWrapper typeAdapterRuntimeTypeWrapper = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.elementTypeAdapter = typeAdapterRuntimeTypeWrapper;
        this.constructor = objectConstructor;
    }

    public Collection read(JsonReader jsonReader) {
        boolean bl2;
        Object object;
        Object object2 = jsonReader.peek();
        if (object2 == (object = JsonToken.NULL)) {
            jsonReader.nextNull();
            return null;
        }
        object2 = (Collection)this.constructor.construct();
        jsonReader.beginArray();
        while (bl2 = jsonReader.hasNext()) {
            object = this.elementTypeAdapter.read(jsonReader);
            object2.add(object);
        }
        jsonReader.endArray();
        return object2;
    }

    public void write(JsonWriter jsonWriter, Collection object) {
        boolean bl2;
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            TypeAdapter typeAdapter = this.elementTypeAdapter;
            typeAdapter.write(jsonWriter, e10);
        }
        jsonWriter.endArray();
    }
}

