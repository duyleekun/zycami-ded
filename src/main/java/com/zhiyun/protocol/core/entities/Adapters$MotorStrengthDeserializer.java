/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.Strength;
import com.zhiyun.protocol.core.entities.Adapters;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapters$MotorStrengthDeserializer
implements JsonDeserializer {
    public List deserialize(JsonElement jsonElement, Type strengthArray, JsonDeserializationContext jsonDeserializationContext) {
        int n10;
        if ((jsonElement = Adapters.access$000(jsonElement)) == null) {
            return Collections.emptyList();
        }
        int n11 = ((JsonArray)jsonElement).size();
        strengthArray = new Strength[n11];
        for (int i10 = 0; i10 < (n10 = ((JsonArray)jsonElement).size()); ++i10) {
            Strength strength;
            n10 = ((JsonArray)jsonElement).get(i10).getAsInt();
            strengthArray[i10] = strength = Strength.from(n10);
        }
        return Arrays.asList(strengthArray);
    }
}

