/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.zhiyun.protocol.constants.JoystickSpeed;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class Adapters$JoystickSpeedDeserializer
implements JsonDeserializer {
    public List deserialize(JsonElement jsonElement, Type joystickSpeedArray, JsonDeserializationContext jsonDeserializationContext) {
        int n10;
        jsonElement = jsonElement.getAsJsonArray();
        int n11 = ((JsonArray)jsonElement).size();
        joystickSpeedArray = new JoystickSpeed[n11];
        for (int i10 = 0; i10 < (n10 = ((JsonArray)jsonElement).size()); ++i10) {
            JoystickSpeed joystickSpeed;
            n10 = ((JsonArray)jsonElement).get(i10).getAsInt();
            joystickSpeedArray[i10] = joystickSpeed = JoystickSpeed.valueOf(n10);
        }
        return Arrays.asList(joystickSpeedArray);
    }
}

