/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonPrimitive;
import com.google.gson.internal.LinkedTreeMap;
import java.util.AbstractMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class JsonObject
extends JsonElement {
    private final LinkedTreeMap members;

    public JsonObject() {
        LinkedTreeMap linkedTreeMap;
        this.members = linkedTreeMap = new LinkedTreeMap();
    }

    public void add(String string2, JsonElement jsonElement) {
        LinkedTreeMap linkedTreeMap = this.members;
        if (jsonElement == null) {
            jsonElement = JsonNull.INSTANCE;
        }
        linkedTreeMap.put(string2, jsonElement);
    }

    public void addProperty(String string2, Boolean object) {
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Boolean)object);
            object = jsonPrimitive;
        }
        this.add(string2, (JsonElement)object);
    }

    public void addProperty(String string2, Character object) {
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Character)object);
            object = jsonPrimitive;
        }
        this.add(string2, (JsonElement)object);
    }

    public void addProperty(String string2, Number object) {
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((Number)object);
            object = jsonPrimitive;
        }
        this.add(string2, (JsonElement)object);
    }

    public void addProperty(String string2, String object) {
        if (object == null) {
            object = JsonNull.INSTANCE;
        } else {
            JsonPrimitive jsonPrimitive = new JsonPrimitive((String)object);
            object = jsonPrimitive;
        }
        this.add(string2, (JsonElement)object);
    }

    public JsonObject deepCopy() {
        boolean bl2;
        JsonObject jsonObject = new JsonObject();
        Iterator iterator2 = this.members.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Map.Entry)iterator2.next();
            String string2 = (String)object.getKey();
            object = ((JsonElement)object.getValue()).deepCopy();
            jsonObject.add(string2, (JsonElement)object);
        }
        return jsonObject;
    }

    public Set entrySet() {
        return this.members.entrySet();
    }

    public boolean equals(Object object) {
        LinkedTreeMap linkedTreeMap;
        boolean bl2;
        boolean bl3;
        if (!(object == this || (bl3 = object instanceof JsonObject) && (bl2 = ((AbstractMap)(object = ((JsonObject)object).members)).equals(linkedTreeMap = this.members)))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public JsonElement get(String string2) {
        return (JsonElement)this.members.get(string2);
    }

    public JsonArray getAsJsonArray(String string2) {
        return (JsonArray)this.members.get(string2);
    }

    public JsonObject getAsJsonObject(String string2) {
        return (JsonObject)this.members.get(string2);
    }

    public JsonPrimitive getAsJsonPrimitive(String string2) {
        return (JsonPrimitive)this.members.get(string2);
    }

    public boolean has(String string2) {
        return this.members.containsKey(string2);
    }

    public int hashCode() {
        return this.members.hashCode();
    }

    public Set keySet() {
        return this.members.keySet();
    }

    public JsonElement remove(String string2) {
        return (JsonElement)this.members.remove(string2);
    }

    public int size() {
        return this.members.size();
    }
}

