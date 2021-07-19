/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class TypeAdapters$EnumTypeAdapter
extends TypeAdapter {
    private final Map constantToName;
    private final Map nameToConstant;

    public TypeAdapters$EnumTypeAdapter(Class clazz) {
        int n10;
        Object object;
        this.nameToConstant = object = new HashMap();
        this.constantToName = object = new HashMap();
        object = clazz.getEnumConstants();
        object = (Enum[])object;
        try {
            n10 = ((T[])object).length;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            super((Object)noSuchFieldException);
            throw object;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2;
            String string2;
            Object t10;
            block20: {
                t10 = object[i10];
                string2 = ((Enum)t10).name();
                object2 = clazz.getField(string2);
                Class<SerializedName> clazz2 = SerializedName.class;
                object2 = ((Field)object2).getAnnotation(clazz2);
                object2 = (SerializedName)object2;
                if (object2 == null) break block20;
                string2 = object2.value();
                object2 = object2.alternate();
                int n11 = ((String[])object2).length;
                for (int i11 = 0; i11 < n11; ++i11) {
                    Object object3 = object2[i11];
                    Map map = this.nameToConstant;
                    map.put(object3, t10);
                    continue;
                }
            }
            object2 = this.nameToConstant;
            object2.put(string2, t10);
            object2 = this.constantToName;
            object2.put(t10, string2);
            continue;
        }
        return;
    }

    public Enum read(JsonReader object) {
        JsonToken jsonToken;
        Object object2 = ((JsonReader)object).peek();
        if (object2 == (jsonToken = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object2 = this.nameToConstant;
        object = ((JsonReader)object).nextString();
        return (Enum)object2.get(object);
    }

    public void write(JsonWriter jsonWriter, Enum object) {
        if (object == null) {
            object = null;
        } else {
            Map map = this.constantToName;
            object = (String)map.get(object);
        }
        jsonWriter.value((String)object);
    }
}

