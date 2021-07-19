/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.huawei.hms.android;

import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HwBuildEx {
    public static int getSystemPropertiesInt(String object, int n10) {
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        Object object3 = "getInt";
        int n11 = 2;
        Class[] classArray = new Class[n11];
        Class clazz = String.class;
        classArray[0] = clazz;
        clazz = Integer.TYPE;
        int n12 = 1;
        classArray[n12] = clazz;
        object3 = ((Class)object2).getDeclaredMethod((String)object3, classArray);
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = n10;
        objectArray[n12] = object;
        object = ((Method)object3).invoke(object2, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException exception) {
            Log.e((String)"HwBuildEx", (String)"An exception occurred while reading: EMUI_SDK_INT");
            return n10;
        }
    }
}

