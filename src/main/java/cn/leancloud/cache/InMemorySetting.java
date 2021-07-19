/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import cn.leancloud.cache.SystemSetting;
import java.util.HashMap;
import java.util.Map;

public class InMemorySetting
implements SystemSetting {
    private Map dataMap;

    public InMemorySetting() {
        HashMap hashMap;
        this.dataMap = hashMap = new HashMap();
    }

    public Map getAll(String string2) {
        return this.dataMap;
    }

    public boolean getBoolean(String object, String string2, boolean bl2) {
        object = this.dataMap;
        boolean bl3 = object.containsKey(string2);
        if (bl3) {
            return (Boolean)this.dataMap.get(string2);
        }
        return bl2;
    }

    public float getFloat(String object, String string2, float f10) {
        object = this.dataMap;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return ((Float)this.dataMap.get(string2)).floatValue();
        }
        return f10;
    }

    public int getInteger(String object, String string2, int n10) {
        object = this.dataMap;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return (Integer)this.dataMap.get(string2);
        }
        return n10;
    }

    public long getLong(String object, String string2, long l10) {
        object = this.dataMap;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return (Long)this.dataMap.get(string2);
        }
        return l10;
    }

    public String getString(String object, String string2, String string3) {
        object = this.dataMap;
        boolean bl2 = object.containsKey(string2);
        if (bl2) {
            return (String)this.dataMap.get(string2);
        }
        return string3;
    }

    public void removeKey(String string2, String string3) {
        this.dataMap.remove(string3);
    }

    public void removeKeyZone(String string2) {
    }

    public void saveBoolean(String object, String string2, boolean bl2) {
        object = this.dataMap;
        Boolean bl3 = bl2;
        object.put(string2, bl3);
    }

    public void saveFloat(String object, String string2, float f10) {
        object = this.dataMap;
        Float f11 = Float.valueOf(f10);
        object.put(string2, f11);
    }

    public void saveInteger(String object, String string2, int n10) {
        object = this.dataMap;
        Integer n11 = n10;
        object.put(string2, n11);
    }

    public void saveLong(String object, String string2, long l10) {
        object = this.dataMap;
        Long l11 = l10;
        object.put(string2, l11);
    }

    public void saveString(String string2, String string3, String string4) {
        this.dataMap.put(string3, string4);
    }
}

