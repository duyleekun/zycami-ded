/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public abstract class AbstractInvocationHandler
implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    private static boolean isProxyOfSameInterfaces(Object objectArray, Class objectArray2) {
        boolean bl2;
        Class<?> clazz;
        boolean bl3 = objectArray2.isInstance(objectArray);
        if (!(bl3 || (bl3 = Proxy.isProxyClass(clazz = objectArray.getClass())) && (bl2 = Arrays.equals(objectArray = objectArray.getClass().getInterfaces(), objectArray2 = objectArray2.getInterfaces())))) {
            bl2 = false;
            objectArray = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean equals(Object object) {
        return super.equals(object);
    }

    public abstract Object handleInvocation(Object var1, Method var2, Object[] var3);

    public int hashCode() {
        return super.hashCode();
    }

    public final Object invoke(Object object, Method object2, Object[] objectArray) {
        String string2;
        String string3;
        Object object3;
        boolean bl2;
        if (objectArray == null) {
            objectArray = NO_ARGS;
        }
        if (!(bl2 = objectArray.length) && (bl2 = (boolean)(object3 = ((Method)object2).getName()).equals(string3 = "hashCode"))) {
            return this.hashCode();
        }
        bl2 = objectArray.length;
        boolean bl3 = true;
        if (bl2 == bl3 && (bl2 = (boolean)(object3 = ((Method)object2).getName()).equals(string2 = "equals"))) {
            object3 = ((Method)object2).getParameterTypes();
            string2 = null;
            Class<Object> clazz = Object.class;
            if ((object3 = object3[0]) == clazz) {
                object2 = objectArray[0];
                if (object2 == null) {
                    return Boolean.FALSE;
                }
                if (object == object2) {
                    return Boolean.TRUE;
                }
                boolean bl4 = AbstractInvocationHandler.isProxyOfSameInterfaces(object2, object = object.getClass());
                if (!bl4 || !(bl4 = this.equals(object = Proxy.getInvocationHandler(object2)))) {
                    bl3 = false;
                    string3 = null;
                }
                return bl3;
            }
        }
        if (!(bl2 = objectArray.length) && (bl2 = (boolean)(object3 = ((Method)object2).getName()).equals(string3 = "toString"))) {
            return this.toString();
        }
        return this.handleInvocation(object, (Method)object2, objectArray);
    }

    public String toString() {
        return super.toString();
    }
}

