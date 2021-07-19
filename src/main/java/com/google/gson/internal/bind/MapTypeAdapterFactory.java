/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.bind.MapTypeAdapterFactory$Adapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Map;

public final class MapTypeAdapterFactory
implements TypeAdapterFactory {
    public final boolean complexMapKeySerialization;
    private final ConstructorConstructor constructorConstructor;

    public MapTypeAdapterFactory(ConstructorConstructor constructorConstructor, boolean bl2) {
        this.constructorConstructor = constructorConstructor;
        this.complexMapKeySerialization = bl2;
    }

    private TypeAdapter getKeyAdapter(Gson object, Type object2) {
        Class<Boolean> clazz = Boolean.TYPE;
        if (object2 != clazz && object2 != (clazz = Boolean.class)) {
            object2 = TypeToken.get((Type)object2);
            object = ((Gson)object).getAdapter((TypeToken)object2);
        } else {
            object = TypeAdapters.BOOLEAN_AS_STRING;
        }
        return object;
    }

    public TypeAdapter create(Gson gson, TypeToken object) {
        Type[] typeArray = ((TypeToken)object).getType();
        Class<Map> clazz = Map.class;
        Class clazz2 = ((TypeToken)object).getRawType();
        boolean bl2 = clazz.isAssignableFrom(clazz2);
        if (!bl2) {
            return null;
        }
        clazz2 = $Gson$Types.getRawType((Type)typeArray);
        typeArray = $Gson$Types.getMapKeyAndValueTypes((Type)typeArray, clazz2);
        clazz = typeArray[0];
        TypeAdapter typeAdapter = this.getKeyAdapter(gson, (Type)((Object)clazz));
        int n10 = 1;
        Object object2 = TypeToken.get(typeArray[n10]);
        TypeAdapter typeAdapter2 = gson.getAdapter((TypeToken)object2);
        ObjectConstructor objectConstructor = this.constructorConstructor.get((TypeToken)object);
        Type type = typeArray[0];
        Type type2 = typeArray[n10];
        object2 = object;
        object = new MapTypeAdapterFactory$Adapter(this, gson, type, typeAdapter, type2, typeAdapter2, objectConstructor);
        return object;
    }
}

