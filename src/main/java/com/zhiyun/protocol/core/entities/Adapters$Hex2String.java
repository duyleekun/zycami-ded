/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.protocol.core.entities;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import java.lang.reflect.Type;

public class Adapters$Hex2String
implements JsonDeserializer {
    public byte[] deserialize(JsonElement object, Type type, JsonDeserializationContext object2) {
        object = ((JsonElement)object).getAsString();
        int n10 = ((String)object).length();
        int n11 = n10 / 2;
        object2 = new byte[n11];
        for (int i10 = 0; i10 < n10; i10 += 2) {
            int n12 = i10 / 2;
            int n13 = ((String)object).charAt(i10);
            int n14 = 16;
            n13 = Character.digit((char)n13, n14) << 4;
            char c10 = i10 + 1;
            c10 = ((String)object).charAt(c10);
            n14 = Character.digit(c10, n14);
            n13 = (byte)(n13 | n14);
            object2[n12] = n13;
        }
        return object2;
    }
}

