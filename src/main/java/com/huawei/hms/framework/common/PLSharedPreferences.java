/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Build$VERSION
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.huawei.hms.framework.common.Logger;
import java.util.Map;

public class PLSharedPreferences {
    private static final String MOVE_TO_DE_RECORDS = "grs_move2DE_records";
    private static final String TAG = "PLSharedPreferences";
    private SharedPreferences sp;

    public PLSharedPreferences(Context context, String string2) {
        context = this.getSharedPreferences(context, string2);
        this.sp = context;
    }

    private SharedPreferences getSharedPreferences(Context context, String string2) {
        block4: {
            Context context2;
            block5: {
                if (context == null) {
                    Logger.e(TAG, "context is null, must call init method to set context");
                    return null;
                }
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 24;
                if (n10 < n11) break block4;
                context2 = context.createDeviceProtectedStorageContext();
                SharedPreferences sharedPreferences = context2.getSharedPreferences(MOVE_TO_DE_RECORDS, 0);
                boolean bl2 = sharedPreferences.getBoolean(string2, false);
                if (bl2) break block5;
                bl2 = context2.moveSharedPreferencesFrom(context, string2);
                if (!bl2) break block4;
                context = sharedPreferences.edit();
                n11 = 1;
                context.putBoolean(string2, n11 != 0);
                context.apply();
            }
            context = context2;
        }
        return context.getSharedPreferences(string2, 0);
    }

    public void clear() {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().clear().apply();
    }

    public SharedPreferences.Editor edit() {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.edit();
    }

    public Map getAll() {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getAll();
    }

    public long getLong(String string2, long l10) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return l10;
        }
        return sharedPreferences.getLong(string2, l10);
    }

    public String getString(String string2) {
        return this.getString(string2, "");
    }

    public String getString(String string2, String string3) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return string3;
        }
        return sharedPreferences.getString(string2, string3);
    }

    public void putLong(String string2, long l10) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putLong(string2, l10).apply();
    }

    public void putString(String string2, String string3) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().putString(string2, string3).apply();
    }

    public void remove(String string2) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(string2).apply();
    }

    public void removeKeyValue(String string2) {
        SharedPreferences sharedPreferences = this.sp;
        if (sharedPreferences == null) {
            return;
        }
        sharedPreferences.edit().remove(string2).apply();
    }
}

