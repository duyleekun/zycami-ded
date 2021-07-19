/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.core.entities.Adapters;
import com.zhiyun.protocol.core.entities.Preset;
import com.zhiyun.protocol.core.entities.Preset$Row;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapters$PresetDeserializer
implements JsonDeserializer {
    private Preset createPreset(JsonElement object) {
        Preset preset = new Preset();
        Object object2 = Adapters.access$000((JsonElement)object);
        if (object2 == null) {
            return preset;
        }
        object = ((JsonElement)object).getAsJsonArray();
        object2 = ((JsonArray)object).get(0).getAsJsonArray();
        preset.pitch = object2 = this.createRow((JsonElement)object2);
        object2 = ((JsonArray)object).get(1).getAsJsonArray();
        preset.roll = object2 = this.createRow((JsonElement)object2);
        object = ((JsonArray)object).get(2).getAsJsonArray();
        preset.yaw = object = this.createRow((JsonElement)object);
        return preset;
    }

    private Preset$Row createRow(JsonElement jsonElement) {
        float f10;
        int n10;
        Preset$Row preset$Row = new Preset$Row();
        JsonArray jsonArray = Adapters.access$000(jsonElement);
        if (jsonArray == null) {
            return preset$Row;
        }
        jsonElement = jsonElement.getAsJsonArray();
        preset$Row.follow = n10 = ((JsonArray)jsonElement).get(0).getAsInt();
        preset$Row.control = n10 = ((JsonArray)jsonElement).get(1).getAsInt();
        preset$Row.smooth = n10 = ((JsonArray)jsonElement).get(2).getAsInt();
        preset$Row.dead = f10 = ((JsonArray)jsonElement).get(3).getAsFloat();
        return preset$Row;
    }

    public List deserialize(JsonElement jsonElement, Type presetArray, JsonDeserializationContext jsonDeserializationContext) {
        int n10;
        if ((jsonElement = Adapters.access$000(jsonElement)) == null) {
            return Collections.emptyList();
        }
        int n11 = ((JsonArray)jsonElement).size();
        presetArray = new Preset[n11];
        for (int i10 = 0; i10 < (n10 = ((JsonArray)jsonElement).size()); ++i10) {
            Object object = ((JsonArray)jsonElement).get(i10);
            presetArray[i10] = object = this.createPreset((JsonElement)object);
        }
        return Arrays.asList(presetArray);
    }
}

