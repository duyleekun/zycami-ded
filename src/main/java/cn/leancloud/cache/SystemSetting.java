/*
 * Decompiled with CFR 0.151.
 */
package cn.leancloud.cache;

import java.util.Map;

public interface SystemSetting {
    public Map getAll(String var1);

    public boolean getBoolean(String var1, String var2, boolean var3);

    public float getFloat(String var1, String var2, float var3);

    public int getInteger(String var1, String var2, int var3);

    public long getLong(String var1, String var2, long var3);

    public String getString(String var1, String var2, String var3);

    public void removeKey(String var1, String var2);

    public void removeKeyZone(String var1);

    public void saveBoolean(String var1, String var2, boolean var3);

    public void saveFloat(String var1, String var2, float var3);

    public void saveInteger(String var1, String var2, int var3);

    public void saveLong(String var1, String var2, long var3);

    public void saveString(String var1, String var2, String var3);
}

