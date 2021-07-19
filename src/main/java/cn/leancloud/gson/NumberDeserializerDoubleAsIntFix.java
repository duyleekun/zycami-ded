/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;

public class NumberDeserializerDoubleAsIntFix
implements JsonDeserializer {
    public static Object parsePrecisionNumber(Number number) {
        double d10;
        if (number == null) {
            return null;
        }
        double d11 = Math.ceil(number.doubleValue());
        double d12 = d11 - (d10 = (double)number.intValue());
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object == false) {
            return number.intValue();
        }
        long l10 = number.longValue();
        d10 = l10;
        double d13 = d11 - d10;
        Object object2 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object2 == false) {
            return number.longValue();
        }
        return number.doubleValue();
    }

    public Number deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return (Number)this.read(jsonElement);
    }

    public Object read(JsonElement jsonElement) {
        boolean bl2 = jsonElement.isJsonPrimitive();
        if (bl2) {
            bl2 = ((JsonPrimitive)(jsonElement = jsonElement.getAsJsonPrimitive())).isBoolean();
            if (bl2) {
                return ((JsonPrimitive)jsonElement).getAsBoolean();
            }
            bl2 = ((JsonPrimitive)jsonElement).isString();
            if (bl2) {
                return ((JsonPrimitive)jsonElement).getAsString();
            }
            bl2 = ((JsonPrimitive)jsonElement).isNumber();
            if (bl2) {
                return NumberDeserializerDoubleAsIntFix.parsePrecisionNumber(((JsonPrimitive)jsonElement).getAsNumber());
            }
        }
        return null;
    }
}

