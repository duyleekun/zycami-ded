/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonObject;
import cn.leancloud.json.JSONObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JSONObjectAdapter
extends TypeAdapter {
    public JSONObject read(JsonReader object) {
        object = (JsonElement)TypeAdapters.JSON_ELEMENT.read((JsonReader)object);
        object = (JsonObject)object;
        GsonObject gsonObject = new GsonObject((JsonObject)object);
        return gsonObject;
    }

    public void write(JsonWriter jsonWriter, JSONObject object) {
        boolean bl2 = object instanceof GsonObject;
        if (!bl2) {
            jsonWriter.nullValue();
        } else {
            TypeAdapter typeAdapter = TypeAdapters.JSON_ELEMENT;
            object = ((GsonObject)object).getRawObject();
            typeAdapter.write(jsonWriter, object);
        }
    }
}

