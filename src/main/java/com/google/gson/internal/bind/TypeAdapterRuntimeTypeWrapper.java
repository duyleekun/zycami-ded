/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$Adapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public final class TypeAdapterRuntimeTypeWrapper
extends TypeAdapter {
    private final Gson context;
    private final TypeAdapter delegate;
    private final Type type;

    public TypeAdapterRuntimeTypeWrapper(Gson gson, TypeAdapter typeAdapter, Type type) {
        this.context = gson;
        this.delegate = typeAdapter;
        this.type = type;
    }

    private Type getRuntimeTypeIfMoreSpecific(Type clazz, Object object) {
        boolean bl2;
        Class<Object> clazz2;
        if (object != null && (clazz == (clazz2 = Object.class) || (bl2 = clazz instanceof TypeVariable) || (bl2 = clazz instanceof Class))) {
            clazz = object.getClass();
        }
        return clazz;
    }

    public Object read(JsonReader jsonReader) {
        return this.delegate.read(jsonReader);
    }

    public void write(JsonWriter jsonWriter, Object object) {
        Type type;
        Object object2 = this.delegate;
        Object object3 = this.type;
        if ((object3 = this.getRuntimeTypeIfMoreSpecific((Type)object3, object)) != (type = this.type)) {
            boolean bl2;
            object2 = this.context;
            boolean bl3 = (object2 = ((Gson)object2).getAdapter((TypeToken)(object3 = TypeToken.get((Type)object3)))) instanceof ReflectiveTypeAdapterFactory$Adapter;
            if (bl3 && !(bl2 = (object3 = this.delegate) instanceof ReflectiveTypeAdapterFactory$Adapter)) {
                object2 = object3;
            }
        }
        ((TypeAdapter)object2).write(jsonWriter, object);
    }
}

