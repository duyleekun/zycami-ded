/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.preference.PreferenceManager
 */
package com.xiaomi.push;

import android.content.Context;
import android.preference.PreferenceManager;
import java.util.Map;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class n {
    public static void a(Context context) {
    }

    public static void a(Context context, String string2, boolean bl2) {
        n.a(context);
        PreferenceManager.getDefaultSharedPreferences((Context)context).edit().putBoolean(string2, bl2).commit();
    }

    public static void a(Map map, String string2, String string3) {
        if (map != null && string2 != null && string3 != null) {
            map.put(string2, string3);
        }
    }

    public static boolean a(Context context, String string2, boolean bl2) {
        n.a(context);
        return PreferenceManager.getDefaultSharedPreferences((Context)context).getBoolean(string2, bl2);
    }
}

