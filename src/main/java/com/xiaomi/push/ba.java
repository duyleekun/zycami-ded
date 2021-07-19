/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.xiaomi.push;

import android.util.Log;
import com.xiaomi.push.ba$a;
import com.xiaomi.push.t;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class ba {
    private static final Map a;

    static {
        HashMap<Class<Comparable<Boolean>>, Class<Comparable<Boolean>>> hashMap;
        a = hashMap = new HashMap<Class<Comparable<Boolean>>, Class<Comparable<Boolean>>>();
        Class<Boolean> clazz = Boolean.TYPE;
        hashMap.put(Boolean.class, clazz);
        Class<Constable> clazz2 = Byte.TYPE;
        hashMap.put(Byte.class, clazz2);
        clazz2 = Character.TYPE;
        hashMap.put(Character.class, clazz2);
        clazz2 = Short.TYPE;
        hashMap.put(Short.class, clazz2);
        clazz2 = Integer.TYPE;
        hashMap.put(Integer.class, clazz2);
        Class<Float> clazz3 = Float.TYPE;
        hashMap.put(Float.class, clazz3);
        Class<Long> clazz4 = Long.TYPE;
        hashMap.put(Long.class, clazz4);
        Class<Double> clazz5 = Double.TYPE;
        hashMap.put(Double.class, clazz5);
        hashMap.put(clazz, clazz);
        Class<Constable> clazz6 = Byte.TYPE;
        hashMap.put(clazz6, clazz6);
        clazz6 = Character.TYPE;
        hashMap.put(clazz6, clazz6);
        clazz6 = Short.TYPE;
        hashMap.put(clazz6, clazz6);
        hashMap.put(clazz2, clazz2);
        hashMap.put(clazz3, clazz3);
        hashMap.put(clazz4, clazz4);
        clazz6 = Double.TYPE;
        hashMap.put(clazz6, clazz6);
    }

    public static Object a(Class serializable, Object object, String string2) {
        boolean bl2;
        Field field;
        block4: {
            field = null;
            do {
                bl2 = true;
                if (field != null) break block4;
                field = serializable.getDeclaredField(string2);
                try {
                    field.setAccessible(bl2);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    serializable = serializable.getSuperclass();
                }
            } while (serializable != null);
            serializable = new Serializable();
            throw serializable;
        }
        field.setAccessible(bl2);
        return field.get(object);
    }

    public static Object a(Class clazz, String string2) {
        try {
            return ba.a(clazz, null, string2);
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        return null;
    }

    public static Object a(Class genericDeclaration, String objectArray, Object ... objectArray2) {
        Class[] classArray = ba.a(objectArray2);
        genericDeclaration = ba.a((Class)genericDeclaration, (String)objectArray, classArray);
        objectArray = ba.a(objectArray2);
        return ((Method)genericDeclaration).invoke(null, objectArray);
    }

    public static Object a(Object object, String string2) {
        Class<?> clazz = object.getClass();
        try {
            return ba.a(clazz, object, string2);
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        return null;
    }

    public static Object a(Object object, String string2, Object ... objectArray) {
        try {
            return ba.b(object, string2, objectArray);
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Meet exception when call Method '");
            stringBuilder.append(string2);
            stringBuilder.append("' in ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            Log.w((String)"JavaCalls", (String)object, (Throwable)exception);
            return null;
        }
    }

    public static Object a(String object, String string2) {
        object = t.a(null, (String)object);
        try {
            return ba.a((Class)object, null, string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        catch (IllegalAccessException illegalAccessException) {
            illegalAccessException.printStackTrace();
        }
        catch (NoSuchFieldException noSuchFieldException) {
            noSuchFieldException.printStackTrace();
        }
        return null;
    }

    public static Object a(String string2, String string3, Object ... objectArray) {
        Serializable serializable;
        try {
            serializable = t.a(null, string2);
        }
        catch (Exception exception) {
            serializable = new StringBuilder();
            ((StringBuilder)serializable).append("Meet exception when call Method '");
            ((StringBuilder)serializable).append(string3);
            ((StringBuilder)serializable).append("' in ");
            ((StringBuilder)serializable).append(string2);
            string2 = ((StringBuilder)serializable).toString();
            Log.w((String)"JavaCalls", (String)string2, (Throwable)exception);
            return null;
        }
        return ba.a((Class)serializable, string3, objectArray);
    }

    private static Method a(Class serializable, String string2, Class ... classArray) {
        GenericDeclaration genericDeclaration = ba.a(serializable.getDeclaredMethods(), string2, classArray);
        if (genericDeclaration == null) {
            genericDeclaration = serializable.getSuperclass();
            if (genericDeclaration != null) {
                return ba.a(serializable.getSuperclass(), string2, classArray);
            }
            serializable = new NoSuchMethodException();
            throw serializable;
        }
        genericDeclaration.setAccessible(true);
        return genericDeclaration;
    }

    private static Method a(Method[] methodArray, String string2, Class[] classArray) {
        String string3 = "Method name must not be null.";
        Objects.requireNonNull(string2, string3);
        for (Method method : methodArray) {
            Class[] classArray2 = method.getName();
            boolean bl2 = classArray2.equals(string2);
            if (!bl2 || !(bl2 = ba.a(classArray2 = method.getParameterTypes(), classArray))) continue;
            return method;
        }
        return null;
    }

    private static boolean a(Class[] classArray, Class[] classArray2) {
        boolean bl2 = true;
        if (classArray == null) {
            int n10;
            if (classArray2 != null && (n10 = classArray2.length) != 0) {
                bl2 = false;
            }
            return bl2;
        }
        if (classArray2 == null) {
            int n11 = classArray.length;
            if (n11 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        int n12 = classArray.length;
        int n13 = classArray2.length;
        if (n12 != n13) {
            return false;
        }
        for (n12 = 0; n12 < (n13 = classArray.length); ++n12) {
            Class clazz;
            Object object = classArray2[n12];
            if (object == null || (n13 = (int)(((Class)(object = classArray[n12])).isAssignableFrom(clazz = classArray2[n12]) ? 1 : 0)) != 0) continue;
            object = a;
            clazz = classArray[n12];
            boolean bl3 = object.containsKey(clazz);
            if (bl3) {
                Class clazz2;
                clazz = classArray[n12];
                n13 = (int)((clazz = (Class)object.get(clazz)).equals(object = object.get(clazz2 = classArray2[n12])) ? 1 : 0);
                if (n13 != 0) continue;
            }
            return false;
        }
        return bl2;
    }

    private static Class[] a(Object ... objectArray) {
        int n10;
        Class[] classArray = null;
        if (objectArray != null && (n10 = objectArray.length) > 0) {
            int n11;
            n10 = objectArray.length;
            Class[] classArray2 = new Class[n10];
            for (int i10 = 0; i10 < (n11 = objectArray.length); ++i10) {
                boolean bl2;
                Class clazz = objectArray[i10];
                if (clazz != null && (bl2 = clazz instanceof ba$a)) {
                    classArray2[i10] = clazz = ((ba$a)clazz).a;
                    continue;
                }
                if (clazz == null) {
                    n11 = 0;
                    clazz = null;
                } else {
                    clazz = clazz.getClass();
                }
                classArray2[i10] = clazz;
            }
            classArray = classArray2;
        }
        return classArray;
    }

    private static Object[] a(Object ... objectArray) {
        Object[] objectArray2;
        int n10;
        if (objectArray != null && (n10 = objectArray.length) > 0) {
            int n11;
            n10 = objectArray.length;
            objectArray2 = new Object[n10];
            for (int i10 = 0; i10 < (n11 = objectArray.length); ++i10) {
                boolean bl2;
                Object object = objectArray[i10];
                objectArray2[i10] = object != null && (bl2 = object instanceof ba$a) ? (object = ((ba$a)object).a) : object;
            }
        } else {
            n10 = 0;
            objectArray2 = null;
        }
        return objectArray2;
    }

    public static Object b(Object object, String object2, Object ... objectArray) {
        Class<?> clazz = object.getClass();
        Class[] classArray = ba.a(objectArray);
        object2 = ba.a(clazz, (String)object2, classArray);
        objectArray = ba.a(objectArray);
        return ((Method)object2).invoke(object, objectArray);
    }
}

