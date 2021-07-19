/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.flogger.util;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public final class FastStackGetter {
    private final Method getDepthMethod;
    private final Method getElementMethod;
    private final Object javaLangAccess;

    private FastStackGetter(Object object, Method method, Method method2) {
        this.javaLangAccess = object;
        this.getElementMethod = method;
        this.getDepthMethod = method2;
    }

    public static FastStackGetter createIfSupported() {
        Object object = "sun.misc.JavaLangAccess";
        Object object2 = "sun.misc.SharedSecrets";
        object2 = Class.forName((String)object2);
        Object object3 = "getJavaLangAccess";
        Object object4 = null;
        Object[] objectArray = new Class[]{};
        object2 = ((Class)object2).getMethod((String)object3, (Class<?>[])objectArray);
        object3 = new Object[]{};
        object2 = ((Method)object2).invoke(null, (Object[])object3);
        object3 = Class.forName((String)object);
        objectArray = "getStackTraceElement";
        int n10 = 2;
        Class[] classArray = new Class[n10];
        Class clazz = Throwable.class;
        classArray[0] = clazz;
        clazz = Integer.TYPE;
        int n11 = 1;
        classArray[n11] = clazz;
        object3 = ((Class)object3).getMethod((String)objectArray, classArray);
        object = Class.forName((String)object);
        objectArray = "getStackTraceDepth";
        classArray = new Class[n11];
        clazz = Throwable.class;
        classArray[0] = clazz;
        object = ((Class)object).getMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        Serializable serializable = new Throwable();
        objectArray[0] = serializable;
        serializable = Integer.valueOf(0);
        objectArray[n11] = serializable;
        objectArray = ((Method)object3).invoke(object2, objectArray);
        objectArray = (StackTraceElement)objectArray;
        objectArray = new Object[n11];
        serializable = new Throwable();
        objectArray[0] = serializable;
        object4 = ((Method)object).invoke(object2, objectArray);
        object4 = (Integer)object4;
        ((Integer)object4).intValue();
        try {
            object4 = new FastStackGetter(object2, (Method)object3, (Method)object);
            return object4;
        }
        catch (Throwable throwable) {
            return null;
        }
        catch (ThreadDeath threadDeath) {
            throw threadDeath;
        }
    }

    public int getStackTraceDepth(Throwable object) {
        Object object2 = this.getDepthMethod;
        Object object3 = this.javaLangAccess;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = ((Method)object2).invoke(object3, objectArray);
        object = (Integer)object;
        try {
            return (Integer)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object2 = new AssertionError((Object)illegalAccessException);
            throw object2;
        }
        catch (InvocationTargetException invocationTargetException) {
            object2 = invocationTargetException.getCause();
            boolean bl2 = object2 instanceof RuntimeException;
            if (!bl2) {
                object2 = invocationTargetException.getCause();
                bl2 = object2 instanceof Error;
                if (bl2) {
                    throw (Error)invocationTargetException.getCause();
                }
                Throwable throwable = invocationTargetException.getCause();
                object2 = new RuntimeException(throwable);
                throw object2;
            }
            throw (RuntimeException)invocationTargetException.getCause();
        }
    }

    public StackTraceElement getStackTraceElement(Throwable object, int n10) {
        Method method = this.getElementMethod;
        Object object2 = this.javaLangAccess;
        int n11 = 2;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        int n12 = 1;
        Object object3 = n10;
        objectArray[n12] = object3;
        object = method.invoke(object2, objectArray);
        try {
            return (StackTraceElement)object;
        }
        catch (IllegalAccessException illegalAccessException) {
            object3 = new AssertionError((Object)illegalAccessException);
            throw object3;
        }
        catch (InvocationTargetException invocationTargetException) {
            object3 = invocationTargetException.getCause();
            n10 = object3 instanceof RuntimeException;
            if (n10 == 0) {
                object3 = invocationTargetException.getCause();
                n10 = object3 instanceof Error;
                if (n10 != 0) {
                    throw (Error)invocationTargetException.getCause();
                }
                Throwable throwable = invocationTargetException.getCause();
                object3 = new RuntimeException(throwable);
                throw object3;
            }
            throw (RuntimeException)invocationTargetException.getCause();
        }
    }
}

