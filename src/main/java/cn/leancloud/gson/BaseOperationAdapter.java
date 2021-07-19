/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.AVObject;
import cn.leancloud.gson.GsonObject;
import cn.leancloud.gson.GsonWrapper;
import cn.leancloud.json.JSON;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.ops.BaseOperation;
import cn.leancloud.ops.CompoundOperation;
import cn.leancloud.ops.ObjectFieldOperation;
import cn.leancloud.ops.OperationBuilder;
import cn.leancloud.ops.OperationBuilder$OperationType;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.util.ArrayList;
import java.util.Collection;

public class BaseOperationAdapter
extends TypeAdapter {
    private static final String ATTR_FIELD = "field";
    private static final String ATTR_FINAL = "final";
    private static final String ATTR_OBJECT = "value";
    private static final String ATTR_OP = "operation";
    private static final String ATTR_SUBOPS = "subOps";

    private Object getParsedObject(Object objectArray) {
        boolean bl2 = objectArray instanceof JSONObject;
        if (bl2) {
            Object object = objectArray;
            object = (JSONObject)objectArray;
            Object object2 = "className";
            boolean bl3 = object.containsKey(object2);
            if (bl3) {
                object = JSON.toJSONString(object);
                object2 = AVObject.class;
                try {
                    return JSON.parseObject((String)object, (Class)object2);
                }
                catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            return objectArray;
        }
        bl2 = objectArray instanceof Collection;
        if (bl2) {
            ArrayList<Object> arrayList = new ArrayList<Object>();
            for (Object object : ((Collection)objectArray).toArray()) {
                object = this.getParsedObject(object);
                arrayList.add(object);
            }
            return arrayList;
        }
        return objectArray;
    }

    private Object parseJSONObject(JSONObject object) {
        Object object2;
        boolean bl2;
        Object object3 = ATTR_OP;
        boolean bl3 = object.containsKey(object3);
        boolean bl4 = false;
        Object object4 = null;
        if (bl3 && (bl2 = object.containsKey(object2 = ATTR_FIELD))) {
            object3 = ((JSONObject)object).getString((String)object3);
            object2 = ((JSONObject)object).getString((String)object2);
            Object object5 = ATTR_FINAL;
            boolean bl5 = object.containsKey(object5);
            if (bl5) {
                object5 = ((JSONObject)object).getBoolean((String)object5);
                bl2 = (Boolean)object5;
            } else {
                bl2 = false;
                object5 = null;
            }
            object3 = OperationBuilder$OperationType.valueOf((String)object3);
            Object object6 = ATTR_OBJECT;
            boolean bl6 = object.containsKey(object6);
            if (bl6) {
                object4 = object.get(object6);
            }
            object4 = this.getParsedObject(object4);
            object6 = OperationBuilder.gBuilder;
            object3 = ((OperationBuilder)object6).create((OperationBuilder$OperationType)((Object)object3), (String)object2, object4);
            ((BaseOperation)object3).setFinal(bl2);
            object2 = ATTR_SUBOPS;
            bl4 = object.containsKey(object2);
            if (bl4 && (bl4 = object3 instanceof CompoundOperation)) {
                object = ((JSONObject)object).getJSONArray((String)object2);
                object2 = JSONObject.class;
                object = ((JSONArray)object).toJavaList((Class)object2).iterator();
                while (bl3 = object.hasNext()) {
                    object2 = (JSONObject)object.next();
                    object2 = (BaseOperation)this.parseJSONObject((JSONObject)object2);
                    ((BaseOperation)object3).merge((ObjectFieldOperation)object2);
                }
            }
            return object3;
        }
        return null;
    }

    public BaseOperation read(JsonReader object) {
        Object object2 = TypeAdapters.JSON_ELEMENT;
        boolean bl2 = ((JsonElement)(object = (JsonElement)((TypeAdapter)object2).read((JsonReader)object))).isJsonObject();
        if (bl2) {
            object = ((JsonElement)object).getAsJsonObject();
            object2 = new GsonObject((JsonObject)object);
            return (BaseOperation)this.parseJSONObject((JSONObject)object2);
        }
        return null;
    }

    public void write(JsonWriter jsonWriter, BaseOperation object) {
        JsonObject jsonObject = new JsonObject();
        Object object2 = ((BaseOperation)object).getOperation();
        jsonObject.addProperty(ATTR_OP, (String)object2);
        object2 = ((BaseOperation)object).getField();
        jsonObject.addProperty(ATTR_FIELD, (String)object2);
        object2 = ((BaseOperation)object).isFinal();
        jsonObject.addProperty(ATTR_FINAL, (Boolean)object2);
        object2 = GsonWrapper.toJsonElement(((BaseOperation)object).getValue());
        String string2 = ATTR_OBJECT;
        jsonObject.add(string2, (JsonElement)object2);
        boolean bl2 = object instanceof CompoundOperation;
        if (bl2) {
            object = GsonWrapper.toJsonElement(((CompoundOperation)object).getSubOperations());
            object2 = ATTR_SUBOPS;
            jsonObject.add((String)object2, (JsonElement)object);
        }
        TypeAdapters.JSON_ELEMENT.write(jsonWriter, jsonObject);
    }
}

