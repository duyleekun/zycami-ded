/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.NumberDeserializerDoubleAsIntFix;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;

public class MapDeserializerDoubleAsIntFix
implements JsonDeserializer {
    public Map deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        return (Map)this.read(jsonElement);
    }

    public Object read(JsonElement iterator2) {
        boolean bl2 = ((JsonElement)((Object)iterator2)).isJsonArray();
        if (bl2) {
            boolean bl3;
            ArrayList<Object> arrayList = new ArrayList<Object>();
            iterator2 = ((JsonElement)((Object)iterator2)).getAsJsonArray().iterator();
            while (bl3 = iterator2.hasNext()) {
                Object object = (JsonElement)iterator2.next();
                object = this.read((JsonElement)object);
                arrayList.add(object);
            }
            return arrayList;
        }
        bl2 = ((JsonElement)((Object)iterator2)).isJsonObject();
        if (bl2) {
            boolean bl4;
            LinkedTreeMap linkedTreeMap = new LinkedTreeMap();
            iterator2 = ((JsonElement)((Object)iterator2)).getAsJsonObject().entrySet().iterator();
            while (bl4 = iterator2.hasNext()) {
                Object object = (Map.Entry)iterator2.next();
                Object k10 = object.getKey();
                object = (JsonElement)object.getValue();
                object = this.read((JsonElement)object);
                linkedTreeMap.put(k10, object);
            }
            return linkedTreeMap;
        }
        bl2 = ((JsonElement)((Object)iterator2)).isJsonPrimitive();
        if (bl2) {
            bl2 = ((JsonPrimitive)((Object)(iterator2 = ((JsonElement)((Object)iterator2)).getAsJsonPrimitive()))).isBoolean();
            if (bl2) {
                return ((JsonPrimitive)((Object)iterator2)).getAsBoolean();
            }
            bl2 = ((JsonPrimitive)((Object)iterator2)).isString();
            if (bl2) {
                return ((JsonPrimitive)((Object)iterator2)).getAsString();
            }
            bl2 = ((JsonPrimitive)((Object)iterator2)).isNumber();
            if (bl2) {
                return NumberDeserializerDoubleAsIntFix.parsePrecisionNumber(((JsonPrimitive)((Object)iterator2)).getAsNumber());
            }
        }
        return null;
    }
}

