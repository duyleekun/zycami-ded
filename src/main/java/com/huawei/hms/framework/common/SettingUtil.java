/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.provider.Settings$Secure
 *  android.provider.Settings$System
 */
package com.huawei.hms.framework.common;

import android.content.ContentResolver;
import android.provider.Settings;
import com.huawei.hms.framework.common.Logger;

public class SettingUtil {
    private static final String TAG = "SettingUtil";

    public static int getSecureInt(ContentResolver contentResolver, String string2, int n10) {
        try {
            n10 = Settings.Secure.getInt((ContentResolver)contentResolver, (String)string2, (int)n10);
        }
        catch (RuntimeException runtimeException) {
            string2 = TAG;
            String string3 = "Settings Secure getInt throwFromSystemServer:";
            Logger.e(string2, string3, runtimeException);
        }
        return n10;
    }

    public static int getSystemInt(ContentResolver contentResolver, String string2, int n10) {
        try {
            n10 = Settings.System.getInt((ContentResolver)contentResolver, (String)string2, (int)n10);
        }
        catch (RuntimeException runtimeException) {
            string2 = TAG;
            String string3 = "Settings System getInt throwFromSystemServer:";
            Logger.e(string2, string3, runtimeException);
        }
        return n10;
    }
}

