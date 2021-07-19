/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.internal.bind.ObjectTypeAdapter$1;
import com.google.gson.internal.bind.ObjectTypeAdapter$2;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;

public final class ObjectTypeAdapter
extends TypeAdapter {
    public static final TypeAdapterFactory FACTORY;
    private final Gson gson;

    static {
        ObjectTypeAdapter$1 objectTypeAdapter$1 = new ObjectTypeAdapter$1();
        FACTORY = objectTypeAdapter$1;
    }

    public ObjectTypeAdapter(Gson gson) {
        this.gson = gson;
    }

    public Object read(JsonReader object) {
        boolean bl2;
        Object object2 = ((JsonReader)object).peek();
        Object object3 = ObjectTypeAdapter$2.$SwitchMap$com$google$gson$stream$JsonToken;
        int n10 = ((Enum)object2).ordinal();
        n10 = object3[n10];
        switch (n10) {
            default: {
                object = new IllegalStateException();
                throw object;
            }
            case 6: {
                ((JsonReader)object).nextNull();
                return null;
            }
            case 5: {
                return ((JsonReader)object).nextBoolean();
            }
            case 4: {
                return ((JsonReader)object).nextDouble();
            }
            case 3: {
                return ((JsonReader)object).nextString();
            }
            case 2: {
                boolean bl3;
                object2 = new LinkedTreeMap();
                ((JsonReader)object).beginObject();
                while (bl3 = ((JsonReader)object).hasNext()) {
                    object3 = ((JsonReader)object).nextName();
                    Object object4 = this.read((JsonReader)object);
                    object2.put(object3, object4);
                }
                ((JsonReader)object).endObject();
                return object2;
            }
            case 1: 
        }
        object2 = new ArrayList();
        ((JsonReader)object).beginArray();
        while (bl2 = ((JsonReader)object).hasNext()) {
            object3 = this.read((JsonReader)object);
            object2.add(object3);
        }
        ((JsonReader)object).endArray();
        return object2;
    }

    public void write(JsonWriter jsonWriter, Object object) {
        if (object == null) {
            jsonWriter.nullValue();
            return;
        }
        Object object2 = this.gson;
        Class<?> clazz = object.getClass();
        boolean bl2 = (object2 = ((Gson)object2).getAdapter(clazz)) instanceof ObjectTypeAdapter;
        if (bl2) {
            jsonWriter.beginObject();
            jsonWriter.endObject();
            return;
        }
        ((TypeAdapter)object2).write(jsonWriter, object);
    }
}

