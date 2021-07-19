/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.entities;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.zhiyun.stabilizer.entities.PathShot;
import com.zhiyun.stabilizer.entities.PathShot$1;
import java.lang.reflect.Type;
import java.math.BigDecimal;

public class PathShot$DecimalJsonSerializer
implements JsonSerializer {
    public final /* synthetic */ PathShot this$0;

    private PathShot$DecimalJsonSerializer(PathShot pathShot) {
        this.this$0 = pathShot;
    }

    public /* synthetic */ PathShot$DecimalJsonSerializer(PathShot pathShot, PathShot$1 pathShot$1) {
        this(pathShot);
    }

    public JsonElement serialize(Double object, Type object2, JsonSerializationContext object3) {
        if (object == null) {
            return null;
        }
        boolean bl2 = ((Double)object).isInfinite();
        if (!bl2 && !(bl2 = ((Double)object).isNaN())) {
            double d10 = (Double)object;
            object2 = new BigDecimal(d10);
            double d11 = ((BigDecimal)object2).setScale(2, 4).doubleValue();
            object = d11;
            object3 = new JsonPrimitive((Number)object);
            return object3;
        }
        object2 = 0;
        object = new JsonPrimitive((Number)object2);
        return object;
    }
}

