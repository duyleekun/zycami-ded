/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.gson;

import cn.leancloud.gson.GsonArray$InnerIterator;
import cn.leancloud.gson.GsonObject;
import cn.leancloud.gson.GsonWrapper;
import cn.leancloud.json.JSONArray;
import cn.leancloud.json.JSONObject;
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
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GsonArray
extends JSONArray {
    private JsonArray gsonArray;

    public GsonArray() {
        JsonArray jsonArray;
        this.gsonArray = jsonArray = new JsonArray();
    }

    public GsonArray(JsonArray jsonArray) {
        this.gsonArray = jsonArray;
    }

    public GsonArray(List object) {
        boolean bl2;
        JsonElement jsonElement;
        int n10 = object.size();
        this.gsonArray = jsonElement = new JsonArray(n10);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            jsonElement = object.next();
            JsonArray jsonArray = this.gsonArray;
            jsonElement = GsonWrapper.toJsonElement(jsonElement);
            jsonArray.add(jsonElement);
        }
    }

    private JsonElement getElement(int n10) {
        int n11 = this.size();
        if (n10 >= n11) {
            return null;
        }
        return this.gsonArray.get(n10);
    }

    public void add(int n10, Object object) {
        JsonArray jsonArray = this.gsonArray;
        JsonElement jsonElement = jsonArray.get(n10);
        boolean bl2 = jsonElement.isJsonArray();
        if (bl2) {
            jsonElement = (JsonArray)jsonElement;
            object = GsonWrapper.toJsonElement(object);
            ((JsonArray)jsonElement).add((JsonElement)object);
        }
    }

    public boolean add(Object object) {
        JsonArray jsonArray = this.gsonArray;
        object = GsonWrapper.toJsonElement(object);
        jsonArray.add((JsonElement)object);
        return true;
    }

    public boolean addAll(int n10, Collection collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("addAll with specified index.");
        throw unsupportedOperationException;
    }

    public boolean addAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            JsonArray jsonArray = this.gsonArray;
            object2 = GsonWrapper.toJsonElement(object2);
            jsonArray.add((JsonElement)object2);
        }
        return true;
    }

    public void clear() {
        int n10;
        for (int i10 = this.size(); i10 >= (n10 = 1); i10 += -1) {
            JsonArray jsonArray = this.gsonArray;
            int n11 = i10 + -1;
            jsonArray.remove(n11);
        }
    }

    public Object clone() {
        JsonArray jsonArray = this.gsonArray.deepCopy();
        GsonArray gsonArray = new GsonArray(jsonArray);
        return gsonArray;
    }

    public boolean contains(Object object) {
        object = GsonWrapper.toJsonElement(object);
        return this.gsonArray.contains((JsonElement)object);
    }

    public boolean containsAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            JsonArray jsonArray = this.gsonArray;
            bl2 = jsonArray.contains((JsonElement)(object2 = GsonWrapper.toJsonElement(object2)));
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        JsonArray jsonArray = null;
        if (object == null) {
            return false;
        }
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof GsonArray;
        if (!bl2) {
            return false;
        }
        jsonArray = this.gsonArray;
        object = ((GsonArray)object).gsonArray;
        return jsonArray.equals(object);
    }

    public JSONArray fluentAdd(int n10, Object object) {
        this.add(n10, object);
        return this;
    }

    public JSONArray fluentAdd(Object object) {
        this.add(object);
        return this;
    }

    public JSONArray fluentAddAll(int n10, Collection collection) {
        this.addAll(n10, collection);
        return this;
    }

    public JSONArray fluentAddAll(Collection collection) {
        this.addAll(collection);
        return this;
    }

    public JSONArray fluentClear() {
        this.clear();
        return this;
    }

    public JSONArray fluentRemove(int n10) {
        this.remove(n10);
        return this;
    }

    public JSONArray fluentRemove(Object object) {
        this.remove(object);
        return this;
    }

    public JSONArray fluentRemoveAll(Collection collection) {
        this.removeAll(collection);
        return this;
    }

    public JSONArray fluentRetainAll(Collection collection) {
        this.retainAll(collection);
        return this;
    }

    public JSONArray fluentSet(int n10, Object object) {
        this.set(n10, object);
        return this;
    }

    public Object get(int n10) {
        return GsonWrapper.toJavaObject(this.getElement(n10));
    }

    public BigDecimal getBigDecimal(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsBigDecimal();
    }

    public BigInteger getBigInteger(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsBigInteger();
    }

    public Boolean getBoolean(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return Boolean.FALSE;
        }
        return jsonElement.getAsBoolean();
    }

    public boolean getBooleanValue(int n10) {
        return this.getBoolean(n10);
    }

    public Byte getByte(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return (byte)0;
        }
        return jsonElement.getAsByte();
    }

    public byte getByteValue(int n10) {
        return this.getByte(n10);
    }

    public java.util.Date getDate(int n10) {
        return GsonWrapper.castToDate(this.get(n10));
    }

    public Double getDouble(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return 0.0;
        }
        return jsonElement.getAsDouble();
    }

    public double getDoubleValue(int n10) {
        return this.getDouble(n10);
    }

    public Float getFloat(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return Float.valueOf(0.0f);
        }
        return Float.valueOf(jsonElement.getAsFloat());
    }

    public float getFloatValue(int n10) {
        return this.getFloat(n10).floatValue();
    }

    public int getIntValue(int n10) {
        return this.getInteger(n10);
    }

    public Integer getInteger(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return 0;
        }
        return jsonElement.getAsInt();
    }

    public JSONArray getJSONArray(int n10) {
        boolean bl2;
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement != null && (bl2 = jsonElement.isJsonArray())) {
            jsonElement = jsonElement.getAsJsonArray();
            GsonArray gsonArray = new GsonArray((JsonArray)jsonElement);
            return gsonArray;
        }
        return null;
    }

    public JSONObject getJSONObject(int n10) {
        boolean bl2;
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement != null && (bl2 = jsonElement.isJsonObject())) {
            jsonElement = jsonElement.getAsJsonObject();
            GsonObject gsonObject = new GsonObject((JsonObject)jsonElement);
            return gsonObject;
        }
        return null;
    }

    public Long getLong(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return 0L;
        }
        return jsonElement.getAsLong();
    }

    public long getLongValue(int n10) {
        return this.getLong(n10);
    }

    public Object getObject(int n10, Class clazz) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return null;
        }
        return GsonWrapper.toJavaObject(jsonElement, clazz);
    }

    public Object getObject(int n10, Type type) {
        return this.getObject(n10, type);
    }

    public JsonArray getRawObject() {
        return this.gsonArray;
    }

    public Short getShort(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return (short)0;
        }
        return jsonElement.getAsShort();
    }

    public short getShortValue(int n10) {
        return this.getShort(n10);
    }

    public Date getSqlDate(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("getSqlDate is not supported.");
        throw unsupportedOperationException;
    }

    public String getString(int n10) {
        JsonElement jsonElement = this.getElement(n10);
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsString();
    }

    public Timestamp getTimestamp(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("getTimestamp is not supported.");
        throw unsupportedOperationException;
    }

    public int hashCode() {
        return this.gsonArray.hashCode();
    }

    public int indexOf(Object object) {
        int n10;
        object = GsonWrapper.toJsonElement(object);
        for (int i10 = 0; i10 < (n10 = this.size()); ++i10) {
            JsonElement jsonElement = this.gsonArray.get(i10);
            n10 = (int)(object.equals(jsonElement) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 <= 0 ? 1 : 0;
        return n10 != 0;
    }

    public Iterator iterator() {
        Iterator iterator2 = this.gsonArray.iterator();
        GsonArray$InnerIterator gsonArray$InnerIterator = new GsonArray$InnerIterator(iterator2);
        return gsonArray$InnerIterator;
    }

    public int lastIndexOf(Object object) {
        object = GsonWrapper.toJsonElement(object);
        for (int i10 = this.size() + -1; i10 >= 0; i10 += -1) {
            JsonElement jsonElement = this.gsonArray.get(i10);
            boolean bl2 = object.equals(jsonElement);
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public ListIterator listIterator() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
        throw unsupportedOperationException;
    }

    public ListIterator listIterator(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("remove");
        throw unsupportedOperationException;
    }

    public Object remove(int n10) {
        return this.gsonArray.remove(n10);
    }

    public boolean remove(Object object) {
        JsonArray jsonArray = this.gsonArray;
        object = GsonWrapper.toJsonElement(object);
        return jsonArray.remove((JsonElement)object);
    }

    public boolean removeAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = object.next();
            JsonArray jsonArray = this.gsonArray;
            object2 = GsonWrapper.toJsonElement(object2);
            jsonArray.remove((JsonElement)object2);
        }
        return true;
    }

    public boolean retainAll(Collection collection) {
        return false;
    }

    public Object set(int n10, Object object) {
        JsonArray jsonArray = this.gsonArray;
        JsonElement jsonElement = GsonWrapper.toJsonElement(object);
        jsonArray.set(n10, jsonElement);
        return object;
    }

    public int size() {
        return this.gsonArray.size();
    }

    public List subList(int n10, int n11) {
        int n12;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        while (n10 >= 0 && n10 < (n12 = this.size()) && n10 < n11) {
            Object object = GsonWrapper.toJavaObject(this.gsonArray.get(n10));
            arrayList.add(object);
            ++n10;
        }
        return arrayList;
    }

    public Object[] toArray() {
        boolean bl2;
        int n10 = this.size();
        ArrayList arrayList = new ArrayList(n10);
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            arrayList.add(e10);
        }
        return arrayList.toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        boolean bl2;
        int n10 = this.size();
        ArrayList arrayList = new ArrayList(n10);
        Iterator iterator2 = this.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            arrayList.add(e10);
        }
        return arrayList.toArray(objectArray);
    }

    public String toJSONString() {
        return this.gsonArray.toString();
    }

    public List toJavaList(Class clazz) {
        int n10;
        int n11 = this.size();
        ArrayList<Object> arrayList = new ArrayList<Object>(n11);
        for (n11 = 0; n11 < (n10 = this.size()); ++n11) {
            Object object = this.getObject(n11, clazz);
            arrayList.add(object);
        }
        return arrayList;
    }
}

