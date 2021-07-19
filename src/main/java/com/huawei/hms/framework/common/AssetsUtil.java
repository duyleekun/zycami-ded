/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.huawei.hms.framework.common;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import java.io.InputStream;

public class AssetsUtil {
    private static final String TAG = "AssetsUtil";

    public static String[] list(Context context, String string2) {
        String string3 = TAG;
        if (context == null) {
            Logger.w(string3, "context is null");
            return new String[0];
        }
        context = context.getAssets();
        String[] stringArray = null;
        try {
            stringArray = context.list(string2);
        }
        catch (RuntimeException runtimeException) {
            string2 = "AssetManager has been destroyed";
            Logger.e(string3, string2, runtimeException);
        }
        return stringArray;
    }

    public static InputStream open(Context context, String string2) {
        String string3 = TAG;
        InputStream inputStream = null;
        if (context == null) {
            Logger.w(string3, "context is null");
            return null;
        }
        context = context.getAssets();
        try {
            inputStream = context.open(string2);
        }
        catch (RuntimeException runtimeException) {
            string2 = "AssetManager has been destroyed";
            Logger.e(string3, string2, runtimeException);
        }
        return inputStream;
    }
}

