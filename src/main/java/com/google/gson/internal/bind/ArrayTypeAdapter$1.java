/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.$Gson$Types;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

public class ArrayTypeAdapter$1
implements TypeAdapterFactory {
    public TypeAdapter create(Gson gson, TypeToken object) {
        Object object2;
        block2: {
            block3: {
                boolean bl2 = (object = ((TypeToken)object).getType()) instanceof GenericArrayType;
                if (bl2) break block2;
                bl2 = object instanceof Class;
                if (!bl2) break block3;
                object2 = object;
                object2 = (Class)object;
                bl2 = ((Class)object2).isArray();
                if (bl2) break block2;
            }
            return null;
        }
        object = $Gson$Types.getArrayComponentType((Type)object);
        object2 = TypeToken.get((Type)object);
        object2 = gson.getAdapter((TypeToken)object2);
        object = $Gson$Types.getRawType((Type)object);
        ArrayTypeAdapter arrayTypeAdapter = new ArrayTypeAdapter(gson, (TypeAdapter)object2, (Class)object);
        return arrayTypeAdapter;
    }
}

