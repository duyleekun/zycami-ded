/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.protocol.core.entities.Adapters;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Adapters$SceneModeDeserializer
implements JsonDeserializer {
    public List deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext object) {
        if ((jsonElement = Adapters.access$000(jsonElement)) != null) {
            int n10;
            object = ((JsonArray)jsonElement).get(0);
            int n11 = object.getAsInt();
            if (n11 != (n10 = -1)) {
                n11 = ((JsonArray)jsonElement).size();
                object = new SceneMode[n11];
                for (int i10 = 0; i10 < (n10 = ((JsonArray)jsonElement).size()); ++i10) {
                    SceneMode sceneMode;
                    n10 = ((JsonArray)jsonElement).get(i10).getAsInt();
                    object[i10] = sceneMode = SceneMode.valueOf(n10);
                }
                return Arrays.asList(object);
            }
        }
        return Collections.emptyList();
    }
}

