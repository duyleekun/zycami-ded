/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.UnsafeAllocator$1;
import com.google.gson.internal.UnsafeAllocator$2;
import com.google.gson.internal.UnsafeAllocator$3;
import com.google.gson.internal.UnsafeAllocator$4;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator {
    public static void assertInstantiable(Class object) {
        int n10 = ((Class)object).getModifiers();
        boolean bl2 = Modifier.isInterface(n10);
        if (!bl2) {
            if ((n10 = (int)(Modifier.isAbstract(n10) ? 1 : 0)) == 0) {
                return;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Abstract class can't be instantiated! Class name: ");
            object = ((Class)object).getName();
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
            throw unsupportedOperationException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Interface can't be instantiated! Interface name: ");
        object = ((Class)object).getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException((String)object);
        throw unsupportedOperationException;
    }

    public static UnsafeAllocator create() {
        Class<Class> clazz;
        Object object;
        Object object2;
        Object object3;
        Object object4 = "newInstance";
        int n10 = 0;
        Object object5 = null;
        Class<Class> clazz2 = null;
        boolean bl2 = true;
        Object object6 = "sun.misc.Unsafe";
        try {
            object6 = Class.forName((String)object6);
            object3 = "theUnsafe";
        }
        catch (Exception exception) {
            int n11 = 2;
            object3 = ObjectStreamClass.class;
            object2 = "getConstructorId";
            try {
                object = new Class[bl2];
                clazz = Class.class;
            }
            catch (Exception exception2) {
                object5 = ObjectInputStream.class;
                try {
                    object6 = new Class[n11];
                    object3 = Class.class;
                }
                catch (Exception exception3) {
                    object4 = new UnsafeAllocator$4();
                    return object4;
                }
                object6[0] = object3;
                clazz2 = Class.class;
                object6[bl2] = clazz2;
                object4 = ((Class)object5).getDeclaredMethod((String)object4, (Class<?>)object6);
                ((Method)object4).setAccessible(bl2);
                object5 = new UnsafeAllocator$3((Method)object4);
                return object5;
            }
            object[0] = clazz;
            object3 = ((Class)object3).getDeclaredMethod((String)object2, (Class<?>)object);
            ((Method)object3).setAccessible(bl2);
            object2 = new Object[bl2];
            object = Object.class;
            object2[0] = object;
            object5 = ((Method)object3).invoke(null, object2);
            object5 = (Integer)object5;
            n10 = (Integer)object5;
            object3 = ObjectStreamClass.class;
            object2 = new Class[n11];
            object = Class.class;
            object2[0] = object;
            object = Integer.TYPE;
            object2[bl2] = object;
            object3 = ((Class)object3).getDeclaredMethod((String)object4, (Class<?>[])object2);
            ((Method)object3).setAccessible(bl2);
            object2 = new UnsafeAllocator$2((Method)object3, n10);
            return object2;
        }
        object3 = object6.getDeclaredField((String)object3);
        ((Field)object3).setAccessible(bl2);
        object3 = ((Field)object3).get(null);
        object2 = "allocateInstance";
        object = new Class[bl2];
        clazz = Class.class;
        object[0] = clazz;
        object6 = object6.getMethod((String)object2, (Class<?>)object);
        object2 = new UnsafeAllocator$1((Method)object6, object3);
        return object2;
    }

    public abstract Object newInstance(Class var1);
}

