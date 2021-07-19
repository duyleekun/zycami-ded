/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.CameraManufacturer;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapters$CameraManufacturersDeserializer
implements JsonDeserializer {
    public List deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        int n10;
        CameraManufacturer cameraManufacturer;
        Object object;
        jsonElement = jsonElement.getAsJsonArray();
        int n11 = ((JsonArray)jsonElement).size();
        int n12 = 0;
        int n13 = 1;
        if (n11 == n13) {
            object = ((JsonArray)jsonElement).get(0);
            n13 = ((JsonElement)object).getAsInt();
            cameraManufacturer = CameraManufacturer.CLOSE;
            n10 = cameraManufacturer.value;
            if (n13 == n10) {
                return Collections.emptyList();
            }
        }
        object = new CameraManufacturer[n11];
        while (n12 < n11) {
            n10 = ((JsonArray)jsonElement).get(n12).getAsInt();
            cameraManufacturer = CameraManufacturer.from(n10);
            object[n12] = cameraManufacturer;
            ++n12;
        }
        return Arrays.asList(object);
    }
}

