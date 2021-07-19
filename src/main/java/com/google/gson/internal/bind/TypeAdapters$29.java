/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.bind;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.LazilyParsedNumber;
import com.google.gson.internal.bind.TypeAdapters$36;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.Map;

public class TypeAdapters$29
extends TypeAdapter {
    public JsonElement read(JsonReader object) {
        Object object2 = TypeAdapters$36.$SwitchMap$com$google$gson$stream$JsonToken;
        Object object3 = ((JsonReader)object).peek();
        int n10 = object3.ordinal();
        int n11 = object2[n10];
        switch (n11) {
            default: {
                object = new IllegalArgumentException();
                throw object;
            }
            case 6: {
                object2 = new JsonObject;
                ((JsonObject)object2)();
                ((JsonReader)object).beginObject();
                while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                    object3 = ((JsonReader)object).nextName();
                    JsonElement jsonElement = this.read((JsonReader)object);
                    ((JsonObject)object2).add((String)object3, jsonElement);
                }
                ((JsonReader)object).endObject();
                return object2;
            }
            case 5: {
                object2 = new JsonArray;
                ((JsonArray)object2)();
                ((JsonReader)object).beginArray();
                while ((n10 = (int)(((JsonReader)object).hasNext() ? 1 : 0)) != 0) {
                    object3 = this.read((JsonReader)object);
                    ((JsonArray)object2).add((JsonElement)object3);
                }
                ((JsonReader)object).endArray();
                return object2;
            }
            case 4: {
                ((JsonReader)object).nextNull();
                return JsonNull.INSTANCE;
            }
            case 3: {
                object2 = new JsonPrimitive;
                object = ((JsonReader)object).nextString();
                ((JsonPrimitive)object2)((String)object);
                return object2;
            }
            case 2: {
                object2 = new JsonPrimitive;
                object = ((JsonReader)object).nextBoolean();
                ((JsonPrimitive)object2)((Boolean)object);
                return object2;
            }
            case 1: 
        }
        object = ((JsonReader)object).nextString();
        object2 = new JsonPrimitive;
        object3 = new LazilyParsedNumber((String)object);
        ((JsonPrimitive)object2)((Number)object3);
        return object2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void write(JsonWriter object, JsonElement object2) {
        boolean bl2;
        if (object2 != null && !(bl2 = ((JsonElement)object2).isJsonNull())) {
            bl2 = ((JsonElement)object2).isJsonPrimitive();
            if (bl2) {
                bl2 = ((JsonPrimitive)(object2 = ((JsonElement)object2).getAsJsonPrimitive())).isNumber();
                if (bl2) {
                    object2 = ((JsonPrimitive)object2).getAsNumber();
                    ((JsonWriter)object).value((Number)object2);
                    return;
                }
                bl2 = ((JsonPrimitive)object2).isBoolean();
                if (bl2) {
                    boolean bl3 = ((JsonPrimitive)object2).getAsBoolean();
                    ((JsonWriter)object).value(bl3);
                    return;
                }
                object2 = ((JsonPrimitive)object2).getAsString();
                ((JsonWriter)object).value((String)object2);
                return;
            }
            bl2 = ((JsonElement)object2).isJsonArray();
            if (bl2) {
                ((JsonWriter)object).beginArray();
                object2 = ((JsonElement)object2).getAsJsonArray().iterator();
                while (true) {
                    if (!(bl2 = object2.hasNext())) {
                        ((JsonWriter)object).endArray();
                        return;
                    }
                    JsonElement jsonElement = (JsonElement)object2.next();
                    this.write((JsonWriter)object, jsonElement);
                }
            }
            bl2 = ((JsonElement)object2).isJsonObject();
            if (!bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Couldn't write ");
                object2 = object2.getClass();
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                object = new IllegalArgumentException((String)object2);
                throw object;
            }
            ((JsonWriter)object).beginObject();
            object2 = ((JsonElement)object2).getAsJsonObject().entrySet().iterator();
            while (true) {
                if (!(bl2 = object2.hasNext())) {
                    ((JsonWriter)object).endObject();
                    return;
                }
                Object object3 = (Map.Entry)object2.next();
                String string2 = (String)object3.getKey();
                ((JsonWriter)object).name(string2);
                object3 = (JsonElement)object3.getValue();
                this.write((JsonWriter)object, (JsonElement)object3);
            }
        }
        ((JsonWriter)object).nullValue();
    }
}

