/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Preconditions;
import com.google.gson.internal.bind.TreeTypeAdapter;
import com.google.gson.reflect.TypeToken;

public final class TreeTypeAdapter$SingleTypeFactory
implements TypeAdapterFactory {
    private final JsonDeserializer deserializer;
    private final TypeToken exactType;
    private final Class hierarchyType;
    private final boolean matchRawType;
    private final JsonSerializer serializer;

    public TreeTypeAdapter$SingleTypeFactory(Object object, TypeToken typeToken, boolean bl2, Class clazz) {
        boolean bl3;
        Object object2;
        boolean bl4 = object instanceof JsonSerializer;
        Object object3 = null;
        if (bl4) {
            object2 = object;
            object2 = (JsonSerializer)object;
        } else {
            bl4 = false;
            object2 = null;
        }
        this.serializer = object2;
        boolean bl5 = object instanceof JsonDeserializer;
        if (bl5) {
            object3 = object;
            object3 = (JsonDeserializer)object;
        }
        this.deserializer = object3;
        if (object2 == null && object3 == null) {
            bl3 = false;
            object = null;
        } else {
            bl3 = true;
        }
        $Gson$Preconditions.checkArgument(bl3);
        this.exactType = typeToken;
        this.matchRawType = bl2;
        this.hierarchyType = clazz;
    }

    public TypeAdapter create(Gson gson, TypeToken typeToken) {
        Object object;
        boolean bl2;
        Object object2 = this.exactType;
        if (object2 != null) {
            bl2 = ((TypeToken)object2).equals(typeToken);
            if (!(bl2 || (bl2 = this.matchRawType) && (object2 = this.exactType.getType()) == (object = typeToken.getRawType()))) {
                bl2 = false;
                object2 = null;
            } else {
                bl2 = true;
            }
        } else {
            object2 = this.hierarchyType;
            object = typeToken.getRawType();
            bl2 = ((Class)object2).isAssignableFrom((Class<?>)object);
        }
        if (bl2) {
            JsonSerializer jsonSerializer = this.serializer;
            JsonDeserializer jsonDeserializer = this.deserializer;
            object = object2;
            object2 = new TreeTypeAdapter(jsonSerializer, jsonDeserializer, gson, typeToken, this);
        } else {
            bl2 = false;
            object2 = null;
        }
        return object2;
    }
}

