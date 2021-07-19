/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.reflect.TypeToken;

public class ObjectTypeAdapter$1
implements TypeAdapterFactory {
    public TypeAdapter create(Gson gson, TypeToken object) {
        Class<Object> clazz;
        if ((object = ((TypeToken)object).getRawType()) == (clazz = Object.class)) {
            object = new ObjectTypeAdapter(gson);
            return object;
        }
        return null;
    }
}

