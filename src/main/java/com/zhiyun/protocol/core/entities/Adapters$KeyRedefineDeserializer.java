/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.KeyRedefine;
import com.zhiyun.protocol.core.entities.Adapters;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapters$KeyRedefineDeserializer
implements JsonDeserializer {
    private KeyRedefine decodeKeyRedefine(JsonArray object) {
        JsonElement jsonElement = ((JsonArray)object).get(0);
        int n10 = jsonElement.getAsInt();
        JsonElement jsonElement2 = ((JsonArray)object).get(1);
        int n11 = jsonElement2.getAsInt();
        object = ((JsonArray)object).get(2).getAsJsonArray();
        int n12 = ((JsonArray)object).size();
        int[] nArray = new int[n12];
        for (int i10 = 0; i10 < n12; ++i10) {
            int n13;
            JsonElement jsonElement3 = ((JsonArray)object).get(i10);
            nArray[i10] = n13 = jsonElement3.getAsInt();
        }
        object = new KeyRedefine();
        ((KeyRedefine)object).setKeyType(0);
        ((KeyRedefine)object).setKeyGroup(n10);
        ((KeyRedefine)object).setKeyValue(n11);
        ((KeyRedefine)object).setKeyEvents(nArray);
        return object;
    }

    public List deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext keyRedefineArray) {
        if ((jsonElement = Adapters.access$000(jsonElement)) == null) {
            return Collections.emptyList();
        }
        int n10 = ((JsonArray)jsonElement).size();
        int n11 = ((JsonArray)jsonElement).size();
        keyRedefineArray = new KeyRedefine[n11];
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = Adapters.access$000(((JsonArray)jsonElement).get(i10));
            if (object == null) continue;
            object = ((JsonElement)object).getAsJsonArray();
            keyRedefineArray[i10] = object = this.decodeKeyRedefine((JsonArray)object);
        }
        return Arrays.asList(keyRedefineArray);
    }
}

