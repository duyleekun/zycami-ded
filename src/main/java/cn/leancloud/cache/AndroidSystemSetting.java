/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.leancloud.cache;

import android.content.Context;
import cn.leancloud.AVLogger;
import cn.leancloud.cache.SystemSetting;
import cn.leancloud.utils.LogUtil;
import java.util.Map;

public class AndroidSystemSetting
implements SystemSetting {
    private static AVLogger LOGGER = LogUtil.getLogger(AndroidSystemSetting.class);
    private Context context;

    public AndroidSystemSetting(Context context) {
        this.context = context;
    }

    public Map getAll(String string2) {
        Context context = this.context;
        if (context == null) {
            return null;
        }
        return context.getSharedPreferences(string2, 0).getAll();
    }

    public boolean getBoolean(String string2, String string3, boolean bl2) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return bl2;
        }
        return context.getSharedPreferences(string2, 0).getBoolean(string3, bl2);
    }

    public float getFloat(String string2, String string3, float f10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return f10;
        }
        return context.getSharedPreferences(string2, 0).getFloat(string3, f10);
    }

    public int getInteger(String string2, String string3, int n10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return n10;
        }
        return context.getSharedPreferences(string2, 0).getInt(string3, n10);
    }

    public long getLong(String string2, String string3, long l10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return l10;
        }
        return context.getSharedPreferences(string2, 0).getLong(string3, l10);
    }

    public String getString(String string2, String string3, String string4) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return string4;
        }
        return context.getSharedPreferences(string2, 0).getString(string3, string4);
    }

    public void removeKey(String string2, String string3) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.remove(string3);
        string2.apply();
    }

    public void removeKeyZone(String string2) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.clear();
        string2.apply();
    }

    public void saveBoolean(String string2, String string3, boolean bl2) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.putBoolean(string3, bl2);
        string2.apply();
    }

    public void saveFloat(String string2, String string3, float f10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.putFloat(string3, f10);
        string2.apply();
    }

    public void saveInteger(String string2, String string3, int n10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.putInt(string3, n10);
        string2.apply();
    }

    public void saveLong(String string2, String string3, long l10) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.putLong(string3, l10);
        string2.apply();
    }

    public void saveString(String string2, String string3, String string4) {
        Context context = this.context;
        if (context == null) {
            LOGGER.w("application context is null");
            return;
        }
        string2 = context.getSharedPreferences(string2, 0).edit();
        string2.putString(string3, string4);
        string2.apply();
    }
}

