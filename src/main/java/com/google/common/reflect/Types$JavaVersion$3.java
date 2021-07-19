/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import com.google.common.reflect.Types$JavaVersion;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public final class Types$JavaVersion$3
extends Types$JavaVersion {
    public Type newArrayType(Type type) {
        return Types$JavaVersion.JAVA7.newArrayType(type);
    }

    public String typeName(Type object) {
        Object object2 = Type.class;
        Object[] objectArray = "getTypeName";
        Class[] classArray = new Class[]{};
        object2 = ((Class)object2).getMethod((String)objectArray, classArray);
        objectArray = new Object[]{};
        object = ((Method)object2).invoke(object, objectArray);
        try {
            return (String)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new RuntimeException(illegalAccessException);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = new RuntimeException(invocationTargetException);
            throw object2;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            object = new AssertionError((Object)"Type.getTypeName should be available in Java 8");
            throw object;
        }
    }

    public Type usedInGenericType(Type type) {
        return Types$JavaVersion.JAVA7.usedInGenericType(type);
    }
}

