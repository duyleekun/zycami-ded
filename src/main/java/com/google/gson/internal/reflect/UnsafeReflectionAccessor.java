/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import com.google.gson.internal.reflect.ReflectionAccessor;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class UnsafeReflectionAccessor
extends ReflectionAccessor {
    private static Class unsafeClass;
    private final Field overrideField;
    private final Object theUnsafe;

    public UnsafeReflectionAccessor() {
        Object object;
        this.theUnsafe = object = UnsafeReflectionAccessor.getUnsafeInstance();
        this.overrideField = object = UnsafeReflectionAccessor.getOverrideField();
    }

    private static Field getOverrideField() {
        Class<AccessibleObject> clazz = AccessibleObject.class;
        String string2 = "override";
        try {
            return clazz.getDeclaredField(string2);
        }
        catch (NoSuchFieldException noSuchFieldException) {
            return null;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static Object getUnsafeInstance() {
        Object object = null;
        Object object2 = "sun.misc.Unsafe";
        try {
            object2 = Class.forName((String)object2);
        }
        catch (Exception exception) {
            return object;
        }
        unsafeClass = object2;
        String string2 = "theUnsafe";
        object2 = ((Class)object2).getDeclaredField(string2);
        boolean bl2 = true;
        ((Field)object2).setAccessible(bl2);
        return ((Field)object2).get(null);
    }

    public void makeAccessible(AccessibleObject object) {
        boolean bl2 = this.makeAccessibleWithUnsafe((AccessibleObject)object);
        if (!bl2) {
            bl2 = true;
            try {
                ((AccessibleObject)object).setAccessible(bl2);
            }
            catch (SecurityException securityException) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Gson couldn't modify fields for ");
                stringBuilder.append(object);
                stringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
                object = stringBuilder.toString();
                JsonIOException jsonIOException = new JsonIOException((String)object, securityException);
                throw jsonIOException;
            }
        }
    }

    public boolean makeAccessibleWithUnsafe(AccessibleObject object) {
        Object object2 = this.theUnsafe;
        if (object2 != null && (object2 = this.overrideField) != null) {
            boolean bl2;
            Object object3;
            try {
                object2 = unsafeClass;
                object3 = "objectFieldOffset";
                bl2 = true;
            }
            catch (Exception exception) {}
            Object[] objectArray = new Class[bl2];
            Object object4 = Field.class;
            objectArray[0] = object4;
            object2 = ((Class)object2).getMethod((String)object3, (Class<?>[])objectArray);
            object3 = this.theUnsafe;
            objectArray = new Object[bl2];
            object4 = this.overrideField;
            objectArray[0] = object4;
            object2 = ((Method)object2).invoke(object3, objectArray);
            object2 = (Long)object2;
            long l10 = (Long)object2;
            object2 = unsafeClass;
            object3 = "putBoolean";
            int n10 = 3;
            Class[] classArray = new Class[n10];
            Class<Object> clazz = Object.class;
            classArray[0] = clazz;
            clazz = Long.TYPE;
            classArray[bl2] = clazz;
            clazz = Boolean.TYPE;
            int n11 = 2;
            classArray[n11] = clazz;
            object2 = ((Class)object2).getMethod((String)object3, classArray);
            object3 = this.theUnsafe;
            Object[] objectArray2 = new Object[n10];
            objectArray2[0] = object;
            object = l10;
            objectArray2[bl2] = object;
            object = Boolean.TRUE;
            objectArray2[n11] = object;
            ((Method)object2).invoke(object3, objectArray2);
            return bl2;
        }
        return false;
    }
}

