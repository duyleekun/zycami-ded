/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zhiyun.protocol.core.entities.StoryAttribute;
import com.zhiyun.protocol.core.entities.StoryAttribute$Precision;
import java.lang.reflect.Type;

public class Adapters$StoryAttributeDeserializer
implements JsonDeserializer {
    private StoryAttribute$Precision parsePrecision(JsonArray jsonElement) {
        int n10;
        StoryAttribute$Precision storyAttribute$Precision = new StoryAttribute$Precision();
        int n11 = ((JsonArray)jsonElement).size();
        if (n11 >= (n10 = 1)) {
            int n12;
            float f10;
            n11 = 0;
            JsonElement jsonElement2 = ((JsonArray)jsonElement).get(0);
            storyAttribute$Precision.value = f10 = jsonElement2.getAsFloat();
            jsonElement = ((JsonArray)jsonElement).get(n10);
            storyAttribute$Precision.notMove = n12 = jsonElement.getAsInt();
        }
        return storyAttribute$Precision;
    }

    public StoryAttribute deserialize(JsonElement object, Type object2, JsonDeserializationContext object3) {
        boolean bl2;
        boolean bl3;
        object2 = new StoryAttribute();
        object = ((JsonElement)object).getAsJsonObject();
        object3 = ((JsonObject)object).getAsJsonObject("precision");
        JsonArray jsonArray = ((JsonObject)object3).getAsJsonArray("pitch");
        JsonArray jsonArray2 = ((JsonObject)object3).getAsJsonArray("roll");
        object3 = ((JsonObject)object3).getAsJsonArray("yaw");
        ((StoryAttribute)object2).notify = bl3 = ((JsonObject)object).get("notify").getAsBoolean();
        String string2 = "duration";
        object = ((JsonObject)object).get(string2);
        ((StoryAttribute)object2).duration = bl2 = ((JsonElement)object).getAsBoolean();
        if (jsonArray != null) {
            ((StoryAttribute)object2).pitch = object = this.parsePrecision(jsonArray);
        }
        if (jsonArray2 != null) {
            ((StoryAttribute)object2).roll = object = this.parsePrecision(jsonArray2);
        }
        if (object3 != null) {
            ((StoryAttribute)object2).yaw = object = this.parsePrecision((JsonArray)object3);
        }
        return object2;
    }
}

