/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapters$EnumTypeAdapter;
import com.google.gson.reflect.TypeToken;

public class TypeAdapters$30
implements TypeAdapterFactory {
    public TypeAdapter create(Gson clazz, TypeToken clazz2) {
        clazz = Enum.class;
        boolean bl2 = clazz.isAssignableFrom(clazz2 = ((TypeToken)((Object)clazz2)).getRawType());
        if (bl2 && clazz2 != clazz) {
            boolean bl3 = clazz2.isEnum();
            if (!bl3) {
                clazz2 = clazz2.getSuperclass();
            }
            clazz = new TypeAdapters$EnumTypeAdapter(clazz2);
            return clazz;
        }
        return null;
    }
}

