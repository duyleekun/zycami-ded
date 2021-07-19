/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.TreeTypeAdapter$GsonContextImpl;
import com.google.gson.internal.bind.TreeTypeAdapter$SingleTypeFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;

public final class TreeTypeAdapter
extends TypeAdapter {
    private final TreeTypeAdapter$GsonContextImpl context;
    private TypeAdapter delegate;
    private final JsonDeserializer deserializer;
    public final Gson gson;
    private final JsonSerializer serializer;
    private final TypeAdapterFactory skipPast;
    private final TypeToken typeToken;

    public TreeTypeAdapter(JsonSerializer jsonSerializer, JsonDeserializer jsonDeserializer, Gson gson, TypeToken typeToken, TypeAdapterFactory typeAdapterFactory) {
        TreeTypeAdapter$GsonContextImpl treeTypeAdapter$GsonContextImpl;
        this.context = treeTypeAdapter$GsonContextImpl = new TreeTypeAdapter$GsonContextImpl(this, null);
        this.serializer = jsonSerializer;
        this.deserializer = jsonDeserializer;
        this.gson = gson;
        this.typeToken = typeToken;
        this.skipPast = typeAdapterFactory;
    }

    private TypeAdapter delegate() {
        Object object = this.delegate;
        if (object == null) {
            object = this.gson;
            TypeAdapterFactory typeAdapterFactory = this.skipPast;
            TypeToken typeToken = this.typeToken;
            this.delegate = object = ((Gson)object).getDelegateAdapter(typeAdapterFactory, typeToken);
        }
        return object;
    }

    public static TypeAdapterFactory newFactory(TypeToken typeToken, Object object) {
        TreeTypeAdapter$SingleTypeFactory treeTypeAdapter$SingleTypeFactory = new TreeTypeAdapter$SingleTypeFactory(object, typeToken, false, null);
        return treeTypeAdapter$SingleTypeFactory;
    }

    public static TypeAdapterFactory newFactoryWithMatchRawType(TypeToken typeToken, Object object) {
        boolean bl2;
        Object object2;
        Type type = typeToken.getType();
        if (type == (object2 = typeToken.getRawType())) {
            bl2 = true;
        } else {
            bl2 = false;
            type = null;
        }
        object2 = new TreeTypeAdapter$SingleTypeFactory(object, typeToken, bl2, null);
        return object2;
    }

    public static TypeAdapterFactory newTypeHierarchyFactory(Class clazz, Object object) {
        TreeTypeAdapter$SingleTypeFactory treeTypeAdapter$SingleTypeFactory = new TreeTypeAdapter$SingleTypeFactory(object, null, false, clazz);
        return treeTypeAdapter$SingleTypeFactory;
    }

    public Object read(JsonReader object) {
        JsonDeserializer jsonDeserializer = this.deserializer;
        if (jsonDeserializer == null) {
            return this.delegate().read((JsonReader)object);
        }
        boolean bl2 = ((JsonElement)(object = Streams.parse((JsonReader)object))).isJsonNull();
        if (bl2) {
            return null;
        }
        jsonDeserializer = this.deserializer;
        Type type = this.typeToken.getType();
        TreeTypeAdapter$GsonContextImpl treeTypeAdapter$GsonContextImpl = this.context;
        return jsonDeserializer.deserialize((JsonElement)object, type, treeTypeAdapter$GsonContextImpl);
    }

    public void write(JsonWriter jsonWriter, Object object) {
        JsonSerializer jsonSerializer = this.serializer;
        if (jsonSerializer == null) {
            this.delegate().write(jsonWriter, object);
            return;
        }
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        Type type = this.typeToken.getType();
        TreeTypeAdapter$GsonContextImpl treeTypeAdapter$GsonContextImpl = this.context;
        Streams.write(jsonSerializer.serialize(object, type, treeTypeAdapter$GsonContextImpl), jsonWriter);
    }
}

