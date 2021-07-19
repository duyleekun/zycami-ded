/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonArray;
import cn.leancloud.json.JSONArray;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.internal.bind.TypeAdapters;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

public class JSONArrayAdapter
extends TypeAdapter {
    public JSONArray read(JsonReader object) {
        object = (JsonElement)TypeAdapters.JSON_ELEMENT.read((JsonReader)object);
        object = (JsonArray)object;
        GsonArray gsonArray = new GsonArray((JsonArray)object);
        return gsonArray;
    }

    public void write(JsonWriter jsonWriter, JSONArray iterable) {
        boolean bl2 = iterable instanceof GsonArray;
        if (bl2) {
            TypeAdapter typeAdapter = TypeAdapters.JSON_ELEMENT;
            iterable = ((GsonArray)iterable).getRawObject();
            typeAdapter.write(jsonWriter, iterable);
        } else {
            jsonWriter.nullValue();
        }
    }
}

