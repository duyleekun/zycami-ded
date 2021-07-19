/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.lang.reflect.Method;

public class SystemPropUtils {
    private static final String TAG = "SystemPropUtils";

    public static String getProperty(String object, String string2, String object2, String string3) {
        Object[] objectArray = String.class;
        int n10 = TextUtils.isEmpty((CharSequence)object);
        if (n10 == 0 && (n10 = TextUtils.isEmpty((CharSequence)string2)) == 0 && (n10 = TextUtils.isEmpty((CharSequence)object2)) == 0) {
            try {
                object2 = Class.forName((String)object2);
                n10 = 2;
            }
            catch (Exception exception) {
                Logger.e(TAG, "getProperty catch exception: ", exception);
                return string3;
            }
            Class[] classArray = new Class[n10];
            classArray[0] = objectArray;
            int n11 = 1;
            classArray[n11] = objectArray;
            object = ((Class)object2).getMethod((String)object, classArray);
            objectArray = new Object[n10];
            objectArray[0] = string2;
            objectArray[n11] = string3;
            object = ((Method)object).invoke(object2, objectArray);
            return (String)object;
        }
        Logger.w(TAG, "reflect class for method has exception.");
        return string3;
    }
}

