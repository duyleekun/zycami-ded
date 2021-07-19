/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.json.JSONArray;
import cn.leancloud.json.TypeReference;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

public abstract class JSONObject
implements Map,
Cloneable,
Serializable {
    public abstract JSONObject fluentClear();

    public abstract JSONObject fluentPut(String var1, Object var2);

    public abstract JSONObject fluentPutAll(Map var1);

    public abstract BigDecimal getBigDecimal(String var1);

    public abstract BigInteger getBigInteger(String var1);

    public abstract Boolean getBoolean(String var1);

    public abstract boolean getBooleanValue(String var1);

    public abstract Byte getByte(String var1);

    public abstract byte getByteValue(String var1);

    public abstract byte[] getBytes(String var1);

    public abstract Date getDate(String var1);

    public abstract Double getDouble(String var1);

    public abstract double getDoubleValue(String var1);

    public abstract Float getFloat(String var1);

    public abstract float getFloatValue(String var1);

    public abstract Map getInnerMap();

    public abstract int getIntValue(String var1);

    public abstract Integer getInteger(String var1);

    public abstract JSONArray getJSONArray(String var1);

    public abstract JSONObject getJSONObject(String var1);

    public abstract Long getLong(String var1);

    public abstract long getLongValue(String var1);

    public abstract Object getObject(String var1, TypeReference var2);

    public abstract Object getObject(String var1, Class var2);

    public abstract Object getObject(String var1, Type var2);

    public abstract Short getShort(String var1);

    public abstract short getShortValue(String var1);

    public abstract java.sql.Date getSqlDate(String var1);

    public abstract String getString(String var1);

    public abstract Timestamp getTimestamp(String var1);

    public abstract void putAll(Map var1);

    public abstract String toJSONString();

    public abstract Object toJavaObject(Class var1);

    public String toString() {
        return this.toJSONString();
    }
}

