/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonArray;
import cn.leancloud.gson.GsonObject$InnerEntry;
import cn.leancloud.gson.GsonWrapper;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
import cn.leancloud.json.TypeReference;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class GsonObject
extends JSONObject {
    private JsonObject gsonObject;

    public GsonObject() {
        JsonObject jsonObject;
        this.gsonObject = jsonObject = new JsonObject();
    }

    public GsonObject(JsonObject jsonObject) {
        this.gsonObject = jsonObject;
    }

    public GsonObject(Map object) {
        Object object2 = new JsonObject();
        this.gsonObject = object2;
        if (object != null) {
            boolean bl2;
            object = object.entrySet().iterator();
            while (bl2 = object.hasNext()) {
                object2 = (Map.Entry)object.next();
                JsonObject jsonObject = this.gsonObject;
                String string2 = (String)object2.getKey();
                object2 = GsonWrapper.toJsonElement(object2.getValue());
                jsonObject.add(string2, (JsonElement)object2);
            }
        }
    }

    public void clear() {
        boolean bl2;
        Iterator iterator2 = this.gsonObject.keySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            String string2 = (String)iterator2.next();
            this.remove(string2);
        }
    }

    public Object clone() {
        JsonElement jsonElement = this.gsonObject.deepCopy();
        GsonObject gsonObject = new GsonObject((JsonObject)jsonElement);
        return gsonObject;
    }

    public boolean containsKey(Object object) {
        JsonObject jsonObject = this.gsonObject;
        object = (String)object;
        return jsonObject.has((String)object);
    }

    public boolean containsValue(Object object) {
        boolean bl2;
        Object object2 = this.values();
        if (object2 == null) {
            return false;
        }
        object2 = object2.iterator();
        while (bl2 = object2.hasNext()) {
            Object e10 = object2.next();
            bl2 = e10.equals(object);
            if (!bl2) continue;
            return true;
        }
        return false;
    }

    public Set entrySet() {
        boolean bl2;
        Object object = this.gsonObject.entrySet();
        HashSet<GsonObject$InnerEntry> hashSet = new HashSet<GsonObject$InnerEntry>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (Map.Entry)object.next();
            String string2 = (String)object2.getKey();
            object2 = (JsonElement)object2.getValue();
            GsonObject$InnerEntry gsonObject$InnerEntry = new GsonObject$InnerEntry(string2, (JsonElement)object2);
            hashSet.add(gsonObject$InnerEntry);
        }
        return hashSet;
    }

    public boolean equals(Object object) {
        JsonObject jsonObject = null;
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        boolean bl2 = object instanceof GsonObject;
        if (!bl2) {
            return false;
        }
        jsonObject = this.gsonObject;
        object = ((GsonObject)object).gsonObject;
        return jsonObject.equals(object);
    }

    public JSONObject fluentClear() {
        this.clear();
        return this;
    }

    public JSONObject fluentPut(String string2, Object object) {
        object = GsonWrapper.toJsonElement(object);
        this.gsonObject.add(string2, (JsonElement)object);
        return this;
    }

    public JSONObject fluentPutAll(Map map) {
        this.putAll(map);
        return this;
    }

    public Object get(Object object) {
        JsonObject jsonObject = this.gsonObject;
        object = (String)object;
        return GsonWrapper.toJavaObject(jsonObject.get((String)object));
    }

    public BigDecimal getBigDecimal(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        if (!bl2) {
            return BigDecimal.ZERO;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return BigDecimal.ZERO;
        }
        return ((JsonElement)object).getAsBigDecimal();
    }

    public BigInteger getBigInteger(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        if (!bl2) {
            return BigInteger.ZERO;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return BigInteger.ZERO;
        }
        return ((JsonElement)object).getAsBigInteger();
    }

    public Boolean getBoolean(String object) {
        Boolean bl2 = Boolean.FALSE;
        JsonObject jsonObject = this.gsonObject;
        boolean bl3 = jsonObject.has((String)object);
        if (!bl3) {
            return bl2;
        }
        jsonObject = this.gsonObject;
        bl3 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl3) {
            return bl2;
        }
        return ((JsonElement)object).getAsBoolean();
    }

    public boolean getBooleanValue(String string2) {
        return this.getBoolean(string2);
    }

    public Byte getByte(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        Byte by2 = 0;
        if (!bl2) {
            return by2;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return by2;
        }
        return ((JsonElement)object).getAsByte();
    }

    public byte getByteValue(String string2) {
        return this.getByte(string2);
    }

    public byte[] getBytes(String string2) {
        if ((string2 = this.getString(string2)) == null) {
            return null;
        }
        return string2.getBytes();
    }

    public java.util.Date getDate(String string2) {
        return GsonWrapper.castToDate(this.getObject(string2, Object.class));
    }

    public Double getDouble(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        double d10 = 0.0;
        Double d11 = d10;
        if (!bl2) {
            return d11;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return d11;
        }
        return ((JsonElement)object).getAsDouble();
    }

    public double getDoubleValue(String string2) {
        return this.getDouble(string2);
    }

    public Float getFloat(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        Float f10 = Float.valueOf(0.0f);
        if (!bl2) {
            return f10;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return f10;
        }
        return Float.valueOf(((JsonElement)object).getAsFloat());
    }

    public float getFloatValue(String string2) {
        return this.getFloat(string2).floatValue();
    }

    public Map getInnerMap() {
        boolean bl2;
        int n10 = this.gsonObject.size();
        HashMap hashMap = new HashMap(n10);
        Iterator iterator2 = this.gsonObject.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (Map.Entry)iterator2.next();
            Object k10 = object.getKey();
            object = GsonWrapper.toJavaObject((JsonElement)object.getValue());
            hashMap.put(k10, object);
        }
        return hashMap;
    }

    public int getIntValue(String string2) {
        return this.getInteger(string2);
    }

    public Integer getInteger(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        Integer n10 = 0;
        if (!bl2) {
            return n10;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return n10;
        }
        return ((JsonElement)object).getAsInt();
    }

    public JSONArray getJSONArray(String object) {
        Object object2 = this.gsonObject;
        boolean bl2 = ((JsonObject)object2).has((String)object);
        if (!bl2) {
            return null;
        }
        object2 = this.gsonObject;
        bl2 = ((JsonElement)(object = ((JsonObject)object2).get((String)object))).isJsonArray();
        if (!bl2) {
            return null;
        }
        object = ((JsonElement)object).getAsJsonArray();
        object2 = new GsonArray((JsonArray)object);
        return object2;
    }

    public JSONObject getJSONObject(String object) {
        Object object2 = this.gsonObject;
        boolean bl2 = ((JsonObject)object2).has((String)object);
        if (!bl2) {
            return null;
        }
        object2 = this.gsonObject;
        bl2 = ((JsonElement)(object = ((JsonObject)object2).get((String)object))).isJsonObject();
        if (!bl2) {
            return null;
        }
        object = ((JsonElement)object).getAsJsonObject();
        object2 = new GsonObject((JsonObject)object);
        return object2;
    }

    public Long getLong(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        long l10 = 0L;
        Long l11 = l10;
        if (!bl2) {
            return l11;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return l11;
        }
        return ((JsonElement)object).getAsLong();
    }

    public long getLongValue(String string2) {
        return this.getLong(string2);
    }

    public Object getObject(String string2, TypeReference object) {
        object = object == null ? null : ((TypeReference)object).getType();
        return this.getObject(string2, (Type)object);
    }

    public Object getObject(String object, Class clazz) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        if (!bl2) {
            return null;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonNull();
        if (bl2) {
            return null;
        }
        return GsonWrapper.toJavaObject((JsonElement)object, clazz);
    }

    public Object getObject(String string2, Type type) {
        boolean bl2 = type instanceof Class;
        if (bl2) {
            try {
                type = (Class)type;
            }
            catch (Exception exception) {}
            return this.getObject(string2, (Class)type);
        }
        return null;
    }

    public JsonObject getRawObject() {
        return this.gsonObject;
    }

    public Short getShort(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        Short s10 = 0;
        if (!bl2) {
            return s10;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return s10;
        }
        return ((JsonElement)object).getAsShort();
    }

    public short getShortValue(String string2) {
        return this.getShort(string2);
    }

    public Date getSqlDate(String object) {
        object = new UnsupportedOperationException("getSqlDate is not supported.");
        throw object;
    }

    public String getString(String object) {
        JsonObject jsonObject = this.gsonObject;
        boolean bl2 = jsonObject.has((String)object);
        if (!bl2) {
            return null;
        }
        jsonObject = this.gsonObject;
        bl2 = ((JsonElement)(object = jsonObject.get((String)object))).isJsonPrimitive();
        if (!bl2) {
            return null;
        }
        return ((JsonElement)object).getAsString();
    }

    public Timestamp getTimestamp(String object) {
        object = new UnsupportedOperationException("getTimestamp is not supported.");
        throw object;
    }

    public int hashCode() {
        return this.gsonObject.hashCode();
    }

    public boolean isEmpty() {
        JsonObject jsonObject = this.gsonObject;
        int n10 = jsonObject.size();
        if (n10 <= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            jsonObject = null;
        }
        return n10 != 0;
    }

    public Set keySet() {
        return this.gsonObject.keySet();
    }

    public Object put(String string2, Object object) {
        boolean bl2 = object instanceof GsonObject;
        if (bl2) {
            JsonObject jsonObject = this.gsonObject;
            Object object2 = object;
            object2 = ((GsonObject)object).getRawObject();
            jsonObject.add(string2, (JsonElement)object2);
        } else {
            JsonElement jsonElement = GsonWrapper.toJsonElement(object);
            JsonObject jsonObject = this.gsonObject;
            jsonObject.add(string2, jsonElement);
        }
        return object;
    }

    public void putAll(Map object) {
        boolean bl2;
        object = object.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            String string2 = (String)entry.getKey();
            entry = entry.getValue();
            this.put(string2, (Object)entry);
        }
    }

    public Object remove(Object object) {
        JsonObject jsonObject = this.gsonObject;
        object = (String)object;
        return jsonObject.remove((String)object);
    }

    public int size() {
        return this.gsonObject.size();
    }

    public String toJSONString() {
        return this.gsonObject.toString();
    }

    public Object toJavaObject(Class clazz) {
        return GsonWrapper.toJavaObject(this.gsonObject, clazz);
    }

    public Collection values() {
        boolean bl2;
        int n10 = this.size();
        ArrayList arrayList = new ArrayList(n10);
        Iterator iterator2 = this.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object v10 = ((Map.Entry)iterator2.next()).getValue();
            arrayList.add(v10);
        }
        return arrayList;
    }
}

