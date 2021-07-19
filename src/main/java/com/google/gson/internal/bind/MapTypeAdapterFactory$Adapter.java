/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.ObjectConstructor;
import com.google.gson.internal.Streams;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.TypeAdapterRuntimeTypeWrapper;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public final class MapTypeAdapterFactory$Adapter
extends TypeAdapter {
    private final ObjectConstructor constructor;
    private final TypeAdapter keyTypeAdapter;
    public final /* synthetic */ MapTypeAdapterFactory this$0;
    private final TypeAdapter valueTypeAdapter;

    public MapTypeAdapterFactory$Adapter(MapTypeAdapterFactory object, Gson gson, Type type, TypeAdapter typeAdapter, Type type2, TypeAdapter typeAdapter2, ObjectConstructor objectConstructor) {
        this.this$0 = object;
        this.keyTypeAdapter = object = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter, type);
        this.valueTypeAdapter = object = new TypeAdapterRuntimeTypeWrapper(gson, typeAdapter2, type2);
        this.constructor = objectConstructor;
    }

    private String keyToString(JsonElement object) {
        boolean bl2 = ((JsonElement)object).isJsonPrimitive();
        if (bl2) {
            bl2 = ((JsonPrimitive)(object = ((JsonElement)object).getAsJsonPrimitive())).isNumber();
            if (bl2) {
                return String.valueOf(((JsonPrimitive)object).getAsNumber());
            }
            bl2 = ((JsonPrimitive)object).isBoolean();
            if (bl2) {
                return Boolean.toString(((JsonPrimitive)object).getAsBoolean());
            }
            bl2 = ((JsonPrimitive)object).isString();
            if (bl2) {
                return ((JsonPrimitive)object).getAsString();
            }
            object = new AssertionError();
            throw object;
        }
        boolean bl3 = ((JsonElement)object).isJsonNull();
        if (bl3) {
            return "null";
        }
        object = new AssertionError();
        throw object;
    }

    public Map read(JsonReader object) {
        Object object2;
        Object object3 = ((JsonReader)object).peek();
        if (object3 == (object2 = JsonToken.NULL)) {
            ((JsonReader)object).nextNull();
            return null;
        }
        object2 = (Map)this.constructor.construct();
        Object object4 = JsonToken.BEGIN_ARRAY;
        String string2 = "duplicate key: ";
        if (object3 == object4) {
            boolean bl2;
            ((JsonReader)object).beginArray();
            while (bl2 = ((JsonReader)object).hasNext()) {
                ((JsonReader)object).beginArray();
                object3 = this.keyTypeAdapter.read((JsonReader)object);
                object4 = this.valueTypeAdapter.read((JsonReader)object);
                object4 = object2.put(object3, object4);
                if (object4 == null) {
                    ((JsonReader)object).endArray();
                    continue;
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object3);
                object3 = ((StringBuilder)object2).toString();
                object = new JsonSyntaxException((String)object3);
                throw object;
            }
            ((JsonReader)object).endArray();
        } else {
            boolean bl3;
            ((JsonReader)object).beginObject();
            while (bl3 = ((JsonReader)object).hasNext()) {
                JsonReaderInternalAccess.INSTANCE.promoteNameToValue((JsonReader)object);
                object3 = this.keyTypeAdapter.read((JsonReader)object);
                object4 = this.valueTypeAdapter.read((JsonReader)object);
                object4 = object2.put(object3, object4);
                if (object4 == null) continue;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(object3);
                object3 = ((StringBuilder)object2).toString();
                object = new JsonSyntaxException((String)object3);
                throw object;
            }
            ((JsonReader)object).endObject();
        }
        return object2;
    }

    public void write(JsonWriter jsonWriter, Map iterator2) {
        Map.Entry entry;
        boolean bl2;
        if (iterator2 == null) {
            jsonWriter.nullValue();
            return;
        }
        Object object = this.this$0;
        boolean bl3 = ((MapTypeAdapterFactory)object).complexMapKeySerialization;
        if (!bl3) {
            jsonWriter.beginObject();
            iterator2 = iterator2.entrySet().iterator();
            while (bl3 = iterator2.hasNext()) {
                object = (Map.Entry)iterator2.next();
                Object object2 = String.valueOf(object.getKey());
                jsonWriter.name((String)object2);
                object2 = this.valueTypeAdapter;
                object = object.getValue();
                ((TypeAdapter)object2).write(jsonWriter, object);
            }
            jsonWriter.endObject();
            return;
        }
        int n10 = iterator2.size();
        object = new ArrayList(n10);
        int n11 = iterator2.size();
        ArrayList arrayList = new ArrayList(n11);
        iterator2 = iterator2.entrySet().iterator();
        n11 = 0;
        boolean bl4 = false;
        Object object3 = null;
        while (bl2 = iterator2.hasNext()) {
            entry = iterator2.next();
            Object object4 = this.keyTypeAdapter;
            Object k10 = entry.getKey();
            object4 = ((TypeAdapter)object4).toJsonTree(k10);
            object.add(object4);
            entry = entry.getValue();
            arrayList.add(entry);
            bl2 = ((JsonElement)object4).isJsonArray();
            if (!bl2 && !(bl2 = ((JsonElement)object4).isJsonObject())) {
                bl2 = false;
                entry = null;
            } else {
                bl2 = true;
            }
            bl4 |= bl2;
        }
        if (bl4) {
            jsonWriter.beginArray();
            int n12 = object.size();
            while (n11 < n12) {
                jsonWriter.beginArray();
                Streams.write((JsonElement)object.get(n11), jsonWriter);
                object3 = this.valueTypeAdapter;
                entry = arrayList.get(n11);
                ((TypeAdapter)object3).write(jsonWriter, entry);
                jsonWriter.endArray();
                ++n11;
            }
            jsonWriter.endArray();
        } else {
            jsonWriter.beginObject();
            int n13 = object.size();
            while (n11 < n13) {
                object3 = (JsonElement)object.get(n11);
                object3 = this.keyToString((JsonElement)object3);
                jsonWriter.name((String)object3);
                object3 = this.valueTypeAdapter;
                entry = arrayList.get(n11);
                ((TypeAdapter)object3).write(jsonWriter, entry);
                ++n11;
            }
            jsonWriter.endObject();
        }
    }
}

