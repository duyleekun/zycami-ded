/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk.utils;

import java.lang.reflect.Method;

public class s {
    public static String a(String object) {
        Object object2;
        Object object3;
        try {
            object3 = ClassLoader.getSystemClassLoader();
            object2 = "android.os.SystemProperties";
        }
        catch (Exception exception) {
            return "unknown";
        }
        object3 = ((ClassLoader)object3).loadClass((String)object2);
        object2 = "get";
        int n10 = 1;
        Class[] classArray = new Class[n10];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object2 = ((Class)object3).getMethod((String)object2, classArray);
        ((Method)object2).setAccessible(n10 != 0);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = ((Method)object2).invoke(object3, objectArray);
        return (String)object;
    }
}

