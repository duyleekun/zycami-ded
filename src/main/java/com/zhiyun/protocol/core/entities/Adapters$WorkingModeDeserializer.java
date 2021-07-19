/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.core.entities.Adapters;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Adapters$WorkingModeDeserializer
implements JsonDeserializer {
    public List deserialize(JsonElement jsonElement, Type workingModeArray, JsonDeserializationContext jsonDeserializationContext) {
        int n10;
        jsonElement = Adapters.access$000(jsonElement);
        int n11 = ((JsonArray)jsonElement).size();
        workingModeArray = new WorkingMode[n11];
        for (int i10 = 0; i10 < (n10 = ((JsonArray)jsonElement).size()); ++i10) {
            WorkingMode workingMode;
            n10 = ((JsonArray)jsonElement).get(i10).getAsInt();
            workingModeArray[i10] = workingMode = WorkingMode.from(n10);
        }
        return Arrays.asList(workingModeArray);
    }
}

