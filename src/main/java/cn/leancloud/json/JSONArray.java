/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.json;

import cn.leancloud.json.JSONObject;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public abstract class JSONArray
implements List,
Cloneable,
Serializable {
    public abstract JSONArray fluentAdd(int var1, Object var2);

    public abstract JSONArray fluentAdd(Object var1);

    public abstract JSONArray fluentAddAll(int var1, Collection var2);

    public abstract JSONArray fluentAddAll(Collection var1);

    public abstract JSONArray fluentClear();

    public abstract JSONArray fluentRemove(int var1);

    public abstract JSONArray fluentRemove(Object var1);

    public abstract JSONArray fluentRemoveAll(Collection var1);

    public abstract JSONArray fluentRetainAll(Collection var1);

    public abstract JSONArray fluentSet(int var1, Object var2);

    public abstract BigDecimal getBigDecimal(int var1);

    public abstract BigInteger getBigInteger(int var1);

    public abstract Boolean getBoolean(int var1);

    public abstract boolean getBooleanValue(int var1);

    public abstract Byte getByte(int var1);

    public abstract byte getByteValue(int var1);

    public abstract Date getDate(int var1);

    public abstract Double getDouble(int var1);

    public abstract double getDoubleValue(int var1);

    public abstract Float getFloat(int var1);

    public abstract float getFloatValue(int var1);

    public abstract int getIntValue(int var1);

    public abstract Integer getInteger(int var1);

    public abstract JSONArray getJSONArray(int var1);

    public abstract JSONObject getJSONObject(int var1);

    public abstract Long getLong(int var1);

    public abstract long getLongValue(int var1);

    public abstract Object getObject(int var1, Class var2);

    public abstract Object getObject(int var1, Type var2);

    public abstract Short getShort(int var1);

    public abstract short getShortValue(int var1);

    public abstract java.sql.Date getSqlDate(int var1);

    public abstract String getString(int var1);

    public abstract Timestamp getTimestamp(int var1);

    public abstract String toJSONString();

    public abstract List toJavaList(Class var1);
}

