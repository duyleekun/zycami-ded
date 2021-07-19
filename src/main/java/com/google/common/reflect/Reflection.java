/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public final class Reflection {
    private Reflection() {
    }

    public static String getPackageName(Class clazz) {
        return Reflection.getPackageName(clazz.getName());
    }

    public static String getPackageName(String string2) {
        int n10 = string2.lastIndexOf(46);
        string2 = n10 < 0 ? "" : string2.substring(0, n10);
        return string2;
    }

    public static void initialize(Class ... classArray) {
        for (Class clazz : classArray) {
            String string2;
            try {
                string2 = clazz.getName();
            }
            catch (ClassNotFoundException classNotFoundException) {
                AssertionError assertionError = new AssertionError((Object)classNotFoundException);
                throw assertionError;
            }
            ClassLoader object = clazz.getClassLoader();
            boolean bl2 = true;
            Class.forName(string2, bl2, object);
        }
    }

    public static Object newProxy(Class clazz, InvocationHandler object) {
        Preconditions.checkNotNull(object);
        Preconditions.checkArgument(clazz.isInterface(), "%s is not an interface", (Object)clazz);
        ClassLoader classLoader = clazz.getClassLoader();
        Class[] classArray = new Class[]{clazz};
        object = Proxy.newProxyInstance(classLoader, classArray, (InvocationHandler)object);
        return clazz.cast(object);
    }
}

