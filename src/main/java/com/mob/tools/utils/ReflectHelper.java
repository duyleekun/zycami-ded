/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 */
package com.mob.tools.utils;

import android.content.BroadcastReceiver;
import com.mob.tools.gui.CachePool;
import com.mob.tools.utils.ReflectHelper$1;
import com.mob.tools.utils.ReflectHelper$2;
import java.io.Serializable;
import java.lang.constant.Constable;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

public class ReflectHelper {
    private static CachePool cachedConstr;
    private static CachePool cachedMethod;
    private static HashMap classMap;
    private static HashMap nameMap;
    private static HashSet packageSet;

    static {
        boolean bl2;
        Object object = new HashSet();
        packageSet = object;
        ((HashSet)object).add("java.lang");
        packageSet.add("java.io");
        packageSet.add("java.nio");
        packageSet.add("java.net");
        packageSet.add("java.util");
        packageSet.add("com.mob.tools");
        packageSet.add("com.mob.tools.gui");
        packageSet.add("com.mob.tools.log");
        packageSet.add("com.mob.tools.network");
        packageSet.add("com.mob.tools.utils");
        object = new HashMap();
        classMap = object;
        Object object2 = Double.TYPE;
        Object object3 = "double";
        ((HashMap)object).put(object3, object2);
        object = classMap;
        object2 = Float.TYPE;
        ((HashMap)object).put("float", object2);
        object = classMap;
        object2 = Long.TYPE;
        ((HashMap)object).put("long", object2);
        object = classMap;
        object2 = Integer.TYPE;
        ((HashMap)object).put("int", object2);
        object = classMap;
        object2 = Short.TYPE;
        ((HashMap)object).put("short", object2);
        object = classMap;
        object2 = Byte.TYPE;
        ((HashMap)object).put("byte", object2);
        object = classMap;
        object2 = Character.TYPE;
        ((HashMap)object).put("char", object2);
        object = classMap;
        object2 = Boolean.TYPE;
        ((HashMap)object).put("boolean", object2);
        classMap.put("Object", Object.class);
        classMap.put("String", String.class);
        classMap.put("Thread", Thread.class);
        classMap.put("Runnable", Runnable.class);
        object = classMap;
        String string2 = "System";
        ((HashMap)object).put(string2, System.class);
        classMap.put(object3, Double.class);
        classMap.put("Float", Float.class);
        classMap.put("Long", Long.class);
        classMap.put("Integer", Integer.class);
        classMap.put("Short", Short.class);
        classMap.put("Byte", Byte.class);
        classMap.put("Character", Character.class);
        object = classMap;
        object2 = Boolean.class;
        object3 = "Boolean";
        ((HashMap)object).put(object3, object2);
        object = new HashMap();
        nameMap = object;
        object = classMap.entrySet().iterator();
        while (bl2 = object.hasNext()) {
            object2 = (Map.Entry)object.next();
            object3 = nameMap;
            string2 = object2.getValue();
            object2 = object2.getKey();
            ((HashMap)object3).put(string2, object2);
        }
        cachedMethod = object = new CachePool(25);
        cachedConstr = object = new CachePool(5);
    }

    public static Object createProxy(HashMap object, Class ... classArray) {
        boolean bl2;
        HashMap hashMap = new HashMap();
        object = ((HashMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            Object k10 = entry.getKey();
            ReflectHelper$1 reflectHelper$1 = new ReflectHelper$1(entry);
            hashMap.put(k10, reflectHelper$1);
        }
        return ReflectHelper.createProxy(hashMap, classArray);
    }

    public static Object createProxy(Map map, Class ... classArray) {
        int n10 = classArray.length;
        if (n10 == 0) {
            return null;
        }
        ClassLoader classLoader = classArray[0].getClassLoader();
        ReflectHelper$2 reflectHelper$2 = new ReflectHelper$2(map);
        return Proxy.newProxyInstance(classLoader, classArray, (InvocationHandler)reflectHelper$2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Class getClass(String string2) {
        Class<?> clazz = ReflectHelper.getImportedClass(string2);
        if (clazz != null) return clazz;
        try {
            clazz = Class.forName(string2);
            if (clazz == null) return clazz;
            HashMap hashMap = classMap;
            hashMap.put(string2, clazz);
        }
        finally {
            return clazz;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Class getImportedClass(String string2) {
        Class<ReflectHelper> clazz = ReflectHelper.class;
        synchronized (clazz) {
            Object object = classMap;
            object = ((HashMap)object).get(string2);
            object = (Class)object;
            if (object == null) {
                boolean bl2;
                Object object2 = packageSet;
                object2 = ((HashSet)object2).iterator();
                while (bl2 = object2.hasNext()) {
                    object = object2.next();
                    object = (String)object;
                    try {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append((String)object);
                        object = ".";
                        stringBuilder.append((String)object);
                        stringBuilder.append(string2);
                        object = stringBuilder.toString();
                        ReflectHelper.importClass((String)object);
                    }
                    catch (Throwable throwable) {}
                    object = classMap;
                    object = ((HashMap)object).get(string2);
                    if ((object = (Class)object) == null) continue;
                }
            }
            return object;
        }
    }

    public static Object getInstanceField(Object object, String object2) {
        try {
            return ReflectHelper.onGetInstanceField(object, (String)object2);
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchFieldException;
            if (bl2) {
                throw throwable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("className: ");
            object = object.getClass();
            stringBuilder.append(object);
            stringBuilder.append(", fieldName: ");
            stringBuilder.append((String)object2);
            object = stringBuilder.toString();
            object2 = new Throwable((String)object, throwable);
            throw object2;
        }
    }

    public static String getName(Class clazz) {
        String string2 = (String)nameMap.get(clazz);
        if (string2 == null) {
            HashMap hashMap = classMap;
            string2 = clazz.getSimpleName();
            boolean bl2 = hashMap.containsKey(string2);
            if (bl2) {
                hashMap = nameMap;
                Object v10 = classMap.get(string2);
                hashMap.remove(v10);
            }
            classMap.put(string2, clazz);
            hashMap = nameMap;
            hashMap.put(clazz, string2);
        }
        return string2;
    }

    public static Object getStaticField(String string2, String object) {
        try {
            return ReflectHelper.onGetStaticField(string2, (String)object);
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchFieldException;
            if (bl2) {
                throw throwable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("className: ");
            stringBuilder.append(string2);
            stringBuilder.append(", fieldName: ");
            stringBuilder.append((String)object);
            string2 = stringBuilder.toString();
            object = new Throwable(string2, throwable);
            throw object;
        }
    }

    private static Class[] getTypes(Object[] objectArray) {
        int n10;
        int n11 = objectArray.length;
        Class[] classArray = new Class[n11];
        for (int i10 = 0; i10 < (n10 = objectArray.length); ++i10) {
            Object object = objectArray[i10];
            n10 = object instanceof BroadcastReceiver;
            if (n10 != 0) {
                object = BroadcastReceiver.class;
                classArray[i10] = object;
                continue;
            }
            object = objectArray[i10];
            if (object == null) {
                n10 = 0;
                object = null;
            } else {
                object = objectArray[i10].getClass();
            }
            classArray[i10] = object;
        }
        return classArray;
    }

    public static String importClass(String string2) {
        return ReflectHelper.importClass(null, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static String importClass(String object, String object2) {
        Class<ReflectHelper> clazz = ReflectHelper.class;
        synchronized (clazz) {
            Object object3;
            Object object4 = ".*";
            boolean bl2 = ((String)object3).endsWith((String)object4);
            if (bl2) {
                object = packageSet;
                bl2 = false;
                object4 = null;
                int n10 = ((String)object3).length() + -2;
                object3 = ((String)object3).substring(0, n10);
                ((HashSet)object).add(object3);
                return "*";
            }
            object3 = Class.forName((String)object3);
            if (object == null) {
                object = ((Class)object3).getSimpleName();
            }
            if (bl2 = ((HashMap)(object4 = classMap)).containsKey(object)) {
                object4 = nameMap;
                HashMap hashMap = classMap;
                Object v10 = hashMap.get(object);
                ((HashMap)object4).remove(v10);
            }
            object4 = classMap;
            ((HashMap)object4).put(object, object3);
            object4 = nameMap;
            ((HashMap)object4).put(object3, object);
            return object;
        }
    }

    public static Object invokeInstanceMethod(Object object, String object2, Object ... objectArray) {
        Class<?> clazz = null;
        try {
            return ReflectHelper.invokeMethod(null, object, (String)object2, objectArray);
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchMethodException;
            if (!bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "className: ";
                stringBuilder.append(string2);
                if (object != null) {
                    clazz = object.getClass();
                }
                stringBuilder.append(clazz);
                stringBuilder.append(", methodName: ");
                stringBuilder.append((String)object2);
                object = stringBuilder.toString();
                object2 = new Throwable((String)object, throwable);
                throw object2;
            }
            throw throwable;
        }
    }

    public static Object invokeInstanceMethod(Object object, String string2, Object[] objectArray, Class[] classArray) {
        return ReflectHelper.invokeMethod(null, object, string2, objectArray, classArray);
    }

    private static Object invokeMethod(String object, Object object2, String object3, Object ... objectArray) {
        Object object4;
        int n10;
        Object object5;
        int n11;
        Object object6 = String.class;
        Class<?> clazz = object2 == null ? ReflectHelper.getImportedClass((String)object) : object2.getClass();
        Class[] classArray = "getMethod";
        boolean n112 = ((String)((Object)object3)).equals(classArray);
        int n12 = 2;
        int n13 = 0;
        Object object7 = null;
        int n14 = 1;
        if (n112 && objectArray != null && (n11 = objectArray.length) == n12) {
            classArray = new Class[n12];
            classArray[0] = object6;
            classArray[n14] = Class[].class;
            object5 = objectArray[n14];
            if (object5 == object6) {
                object5 = new Class[n14];
                object5[0] = object6;
                objectArray[n14] = object5;
            }
        } else {
            int n15;
            object6 = "getDeviceId";
            boolean bl2 = ((String)((Object)object3)).equals(object6);
            if (bl2 && objectArray != null && (n15 = objectArray.length) == n14) {
                classArray = new Class[n14];
                object6 = Integer.TYPE;
                classArray[0] = object6;
            } else {
                int n16;
                object6 = "invoke";
                boolean bl3 = ((String)((Object)object3)).equals(object6);
                if (bl3 && objectArray != null && (n16 = objectArray.length) == n12) {
                    classArray = new Class[n12];
                    classArray[0] = Object.class;
                    object6 = Object[].class;
                    classArray[n14] = object6;
                } else {
                    int n17;
                    object6 = "setAccessible";
                    boolean bl4 = ((String)((Object)object3)).equals(object6);
                    if (bl4 && objectArray != null && (n17 = objectArray.length) == n14) {
                        classArray = new Class[n14];
                        object6 = Boolean.TYPE;
                        classArray[0] = object6;
                    } else {
                        classArray = ReflectHelper.getTypes(objectArray);
                    }
                }
            }
        }
        object6 = new StringBuffer();
        n12 = classArray.length;
        String string2 = null;
        for (n10 = 0; n10 < n12; ++n10) {
            object4 = classArray[n10];
            object4 = object4 == null ? "" : ((Class)object4).getName();
            ((StringBuffer)object6).append((String)object4);
        }
        object5 = new StringBuilder();
        string2 = clazz.getName();
        ((StringBuilder)object5).append(string2);
        string2 = "#";
        ((StringBuilder)object5).append(string2);
        ((StringBuilder)object5).append((String)((Object)object3));
        ((StringBuilder)object5).append(string2);
        n10 = objectArray.length;
        ((StringBuilder)object5).append(n10);
        object6 = ((StringBuffer)object6).toString();
        ((StringBuilder)object5).append((String)object6);
        object6 = ((StringBuilder)object5).toString();
        object5 = (Method)cachedMethod.get(object6);
        n10 = 0;
        string2 = null;
        if (object5 != null) {
            int n18 = Modifier.isStatic(((Method)object5).getModifiers());
            if (object2 == null) {
                n13 = n18;
            } else if (!n18) {
                n13 = n14;
            }
            if (n13 && (n13 = (int)(ReflectHelper.matchParams(object7 = ((Method)object5).getParameterTypes(), classArray) ? 1 : 0))) {
                ((Method)object5).setAccessible(n14 != 0);
                object = ((Method)object5).getReturnType();
                object3 = Void.TYPE;
                if (object == object3) {
                    ((Method)object5).invoke(object2, objectArray);
                    return null;
                }
                return ((Method)object5).invoke(object2, objectArray);
            }
        }
        while (clazz != null) {
            block26: {
                try {
                    object5 = clazz.getDeclaredMethod((String)((Object)object3), classArray);
                }
                catch (Throwable throwable) {
                    clazz = clazz.getSuperclass();
                    continue;
                }
                object7 = cachedMethod;
                object7.put(object6, object5);
                ((Method)object5).setAccessible(n14 != 0);
                object7 = ((Method)object5).getReturnType();
                object4 = Void.TYPE;
                if (object7 != object4) break block26;
                ((Method)object5).invoke(object2, objectArray);
                return null;
            }
            return ((Method)object5).invoke(object2, objectArray);
        }
        object6 = new StringBuilder();
        clazz = "className: ";
        ((StringBuilder)object6).append((String)((Object)clazz));
        if (object2 != null) {
            object = object2.getClass();
        }
        ((StringBuilder)object6).append(object);
        ((StringBuilder)object6).append(", methodName: ");
        ((StringBuilder)object6).append((String)((Object)object3));
        object = ((StringBuilder)object6).toString();
        objectArray = new NoSuchMethodException((String)object);
        throw objectArray;
    }

    private static Object invokeMethod(String object, Object object2, String object3, Object[] objectArray, Class[] object4) {
        Class<?> clazz = null;
        if (objectArray == null) {
            objectArray = new Object[]{};
        }
        if (object4 == null) {
            object4 = new Class[]{};
        }
        CharSequence charSequence = new StringBuilder();
        Object object5 = clazz.getName();
        charSequence.append((String)object5);
        object5 = "#";
        charSequence.append((String)object5);
        charSequence.append((String)object3);
        charSequence.append((String)object5);
        int n10 = objectArray.length;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object5 = (Method)cachedMethod.get(charSequence);
        boolean bl2 = true;
        if (object5 != null) {
            ((Method)object5).setAccessible(bl2);
            object = ((Method)object5).getReturnType();
            object3 = Void.TYPE;
            if (object == object3) {
                ((Method)object5).invoke(object2, objectArray);
                return null;
            }
            return ((Method)object5).invoke(object2, objectArray);
        }
        for (clazz = object2 == null ? ReflectHelper.getImportedClass((String)object) : object2.getClass(); clazz != null; clazz = clazz.getSuperclass()) {
            block14: {
                try {
                    object5 = clazz.getDeclaredMethod((String)object3, (Class<?>)object4);
                }
                catch (Throwable throwable) {
                    continue;
                }
                Object object6 = cachedMethod;
                ((CachePool)object6).put(charSequence, object5);
                ((Method)object5).setAccessible(bl2);
                object6 = ((Method)object5).getReturnType();
                Class<Void> clazz2 = Void.TYPE;
                if (object6 != clazz2) break block14;
                ((Method)object5).invoke(object2, objectArray);
                return null;
            }
            return ((Method)object5).invoke(object2, objectArray);
        }
        object4 = new StringBuilder();
        clazz = "className: ";
        ((StringBuilder)object4).append((String)((Object)clazz));
        if (object2 != null) {
            object = object2.getClass();
        }
        ((StringBuilder)object4).append(object);
        ((StringBuilder)object4).append(", methodName: ");
        ((StringBuilder)object4).append((String)object3);
        object = ((StringBuilder)object4).toString();
        objectArray = new NoSuchMethodException((String)object);
        throw objectArray;
    }

    public static Object invokeStaticMethod(String string2, String object, Object ... objectArray) {
        boolean bl2 = false;
        StringBuilder stringBuilder = null;
        try {
            return ReflectHelper.invokeMethod(string2, null, (String)object, objectArray);
        }
        catch (Throwable throwable) {
            bl2 = throwable instanceof NoSuchMethodException;
            if (bl2) {
                throw throwable;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("className: ");
            stringBuilder.append(string2);
            stringBuilder.append(", methodName: ");
            stringBuilder.append((String)object);
            string2 = stringBuilder.toString();
            object = new Throwable(string2, throwable);
            throw object;
        }
    }

    public static Object invokeStaticMethod(String string2, String string3, Object[] objectArray, Class[] classArray) {
        return ReflectHelper.invokeMethod(string2, null, string3, objectArray, classArray);
    }

    private static boolean matchParams(Class[] classArray, Class[] classArray2) {
        boolean bl2;
        block3: {
            int n10 = classArray.length;
            int n11 = classArray2.length;
            bl2 = false;
            if (n10 == n11) {
                for (n10 = 0; n10 < (n11 = classArray2.length); ++n10) {
                    Class clazz;
                    Class clazz2 = classArray2[n10];
                    if (clazz2 == null || (n11 = (int)(ReflectHelper.primitiveEquals(clazz2 = classArray[n10], clazz = classArray2[n10]) ? 1 : 0)) != 0 || (n11 = (int)((clazz2 = classArray[n10]).isAssignableFrom(clazz = classArray2[n10]) ? 1 : 0)) != 0) {
                        continue;
                    }
                    break block3;
                }
                bl2 = true;
            }
        }
        return bl2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object newArray(String string2, Object ... object) {
        boolean bl2;
        Object object2;
        String string3;
        StringBuilder stringBuilder;
        block6: {
            Object object3;
            int n10;
            int n11 = 0;
            stringBuilder = null;
            string3 = string2;
            int n12 = 0;
            while ((n10 = string3.startsWith((String)(object3 = "["))) != 0) {
                ++n12;
                n10 = 1;
                string3 = string3.substring(n10);
            }
            n10 = ((Object)object).length;
            object2 = null;
            if (n12 == n10) {
                object3 = new int[n12];
                while (n11 < n12) {
                    Object object4 = object[n11];
                    object4 = String.valueOf(object4);
                    int n13 = Integer.parseInt((String)object4);
                    object3[n11] = n13;
                    ++n11;
                }
                object2 = object3;
                break block6;
                catch (Throwable throwable) {}
            }
        }
        if (object2 != null && (object = (bl2 = ((String)(object = "B")).equals(string3)) ? Byte.TYPE : ((bl2 = ((String)(object = "S")).equals(string3)) ? Short.TYPE : ((bl2 = ((String)(object = "I")).equals(string3)) ? Integer.TYPE : ((bl2 = ((String)(object = "J")).equals(string3)) ? Long.TYPE : ((bl2 = ((String)(object = "F")).equals(string3)) ? Float.TYPE : ((bl2 = ((String)(object = "D")).equals(string3)) ? Double.TYPE : ((bl2 = ((String)(object = "Z")).equals(string3)) ? Boolean.TYPE : ((bl2 = ((String)(object = "C")).equals(string3)) ? Character.TYPE : ReflectHelper.getImportedClass(string3))))))))) != null) {
            return Array.newInstance(object, (int[])object2);
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("className: [");
        stringBuilder.append(string2);
        stringBuilder.append(", methodName: <init>");
        string2 = stringBuilder.toString();
        object = new NoSuchMethodException(string2);
        throw object;
    }

    public static Object newInstance(String string2, Object ... objectArray) {
        try {
            return ReflectHelper.onNewInstance(string2, objectArray);
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchMethodException;
            if (bl2) {
                throw throwable;
            }
            Serializable serializable = new StringBuilder();
            serializable.append("className: ");
            serializable.append(string2);
            serializable.append(", methodName: <init>");
            string2 = serializable.toString();
            serializable = new Throwable(string2, throwable);
            throw serializable;
        }
    }

    /*
     * WARNING - void declaration
     */
    private static Object onGetElement(Object object, String string2) {
        Object object2;
        boolean n10 = object instanceof List;
        CharSequence charSequence = "]";
        String string3 = "[";
        int n11 = 1;
        int n12 = -1;
        if (n10) {
            boolean bl2;
            boolean bl3 = string2.startsWith(string3);
            if (bl3 && (bl2 = string2.endsWith((String)charSequence))) {
                void var2_8;
                int n13 = string2.length() - n11;
                object2 = string2.substring(n11, n13);
                try {
                    int n14 = Integer.parseInt((String)object2);
                }
                catch (Throwable throwable) {
                    int n15 = n12;
                }
                if (var2_8 != n12) {
                    return ((List)object).get((int)var2_8);
                }
            }
        } else {
            boolean bl4;
            object2 = "length";
            boolean bl5 = ((String)object2).equals(string2);
            if (bl5) {
                return Array.getLength(object);
            }
            boolean bl6 = string2.startsWith(string3);
            if (bl6 && (bl4 = string2.endsWith((String)charSequence))) {
                void var2_15;
                int n16 = string2.length() - n11;
                object2 = string2.substring(n11, n16);
                try {
                    int n17 = Integer.parseInt((String)object2);
                }
                catch (Throwable throwable) {
                    int n18 = n12;
                }
                if (var2_15 != n12) {
                    return Array.get(object, (int)var2_15);
                }
            }
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("className: ");
        object = object.getClass();
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append(", fieldName: ");
        ((StringBuilder)charSequence).append(string2);
        object = ((StringBuilder)charSequence).toString();
        object2 = new NoSuchFieldException((String)object);
        throw object2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object onGetInstanceField(Object object, String string2) {
        boolean bl2;
        Field field;
        Serializable serializable;
        boolean bl3 = object instanceof List;
        if (bl3) return ReflectHelper.onGetElement(object, string2);
        Class clazz = object.getClass();
        bl3 = clazz.isArray();
        if (bl3) {
            return ReflectHelper.onGetElement(object, string2);
        }
        bl3 = object instanceof Map;
        if (bl3) {
            return ((Map)object).get(string2);
        }
        clazz = new ArrayList();
        for (serializable = object.getClass(); serializable != null; serializable = ((Class)serializable).getSuperclass()) {
            ((ArrayList)((Object)clazz)).add(serializable);
        }
        clazz = ((ArrayList)((Object)clazz)).iterator();
        do {
            if (!(bl2 = clazz.hasNext())) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("className: ");
                object = object.getClass();
                ((StringBuilder)serializable).append(object);
                ((StringBuilder)serializable).append(", fieldName: ");
                ((StringBuilder)serializable).append(string2);
                object = ((StringBuilder)serializable).toString();
                clazz = new NoSuchFieldException((String)object);
                throw clazz;
            }
            serializable = (Class)clazz.next();
            field = null;
            try {
                field = ((Class)serializable).getDeclaredField(string2);
            }
            catch (Throwable throwable) {}
        } while (field == null || (bl2 = Modifier.isStatic(field.getModifiers())));
        field.setAccessible(true);
        return field.get(object);
    }

    private static Object onGetStaticField(String string2, String string3) {
        boolean bl2;
        Object object;
        Object object2 = new ArrayList();
        for (object = ReflectHelper.getImportedClass(string2); object != null; object = ((Class)object).getSuperclass()) {
            ((ArrayList)object2).add(object);
        }
        object2 = ((ArrayList)object2).iterator();
        while (bl2 = object2.hasNext()) {
            boolean bl3;
            object = (Class)object2.next();
            try {
                object = ((Class)object).getDeclaredField(string3);
            }
            catch (Throwable throwable) {
                bl2 = false;
                object = null;
            }
            if (object == null || !(bl3 = Modifier.isStatic(((Field)object).getModifiers()))) continue;
            ((Field)object).setAccessible(true);
            return ((Field)object).get(null);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("className: ");
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", fieldName: ");
        ((StringBuilder)object).append(string3);
        string2 = ((StringBuilder)object).toString();
        object2 = new NoSuchFieldException(string2);
        throw object2;
    }

    /*
     * WARNING - void declaration
     */
    private static Object onNewInstance(String object, Object ... objectArray) {
        int n10;
        void var3_5;
        Object object2;
        int n11;
        Object object3 = "[";
        boolean n12 = ((String)object).startsWith((String)object3);
        if (n12) {
            return ReflectHelper.newArray((String)object, objectArray);
        }
        object3 = ReflectHelper.getImportedClass((String)object);
        Class[] classArray = new StringBuilder();
        ArrayList arrayList = ((Class)object3).getName();
        classArray.append((String)((Object)arrayList));
        classArray.append("#");
        int n13 = objectArray.length;
        classArray.append(n13);
        classArray = classArray.toString();
        arrayList = (Constructor)cachedConstr.get(classArray);
        Object object4 = ReflectHelper.getTypes(objectArray);
        int n14 = 1;
        if (arrayList != null && (n11 = ReflectHelper.matchParams((Class[])(object2 = ((Constructor)((Object)arrayList)).getParameterTypes()), object4)) != 0) {
            ((Constructor)((Object)arrayList)).setAccessible(n14 != 0);
            return ((Constructor)((Object)arrayList)).newInstance(objectArray);
        }
        object3 = ((Class)object3).getDeclaredConstructors();
        arrayList = new ArrayList();
        object2 = new ArrayList();
        for (GenericDeclaration genericDeclaration : object3) {
            int n15;
            Class[] classArray2 = ((Constructor)genericDeclaration).getParameterTypes();
            int n16 = ReflectHelper.matchParams(classArray2, object4);
            if (n16 != 0) {
                cachedConstr.put(classArray, genericDeclaration);
                ((Constructor)genericDeclaration).setAccessible(n14 != 0);
                return ((Constructor)genericDeclaration).newInstance(objectArray);
            }
            n16 = classArray2.length;
            if (n16 <= 0) continue;
            n16 = classArray2.length - n14;
            Class clazz = classArray2[n16];
            if ((n16 = (int)(clazz.isArray() ? 1 : 0)) == 0 || (n16 = ((Class[])object4).length) < (n15 = classArray2.length - n14)) continue;
            arrayList.add((Constructor<?>)genericDeclaration);
            ((ArrayList)object2).add(classArray2);
        }
        boolean bl2 = false;
        object3 = null;
        while (++var3_5 < (n10 = ((ArrayList)object2).size())) {
            int n17;
            Object object5;
            int n18;
            block8: {
                int n19;
                classArray = (Class[])((ArrayList)object2).get((int)var3_5);
                n18 = classArray.length - n14;
                object5 = classArray[n18].getComponentType();
                n17 = (int)(ReflectHelper.tryMatchParams(classArray, object4) ? 1 : 0);
                if (n17 != 0) {
                    object = new Object[objectArray.length + n14];
                    n10 = objectArray.length;
                    System.arraycopy(objectArray, 0, object, 0, n10);
                    n10 = objectArray.length;
                    object[n10] = object4 = Array.newInstance(object5, 0);
                    object = (Constructor)arrayList.get((int)var3_5);
                    ((Constructor)object).setAccessible(n14 != 0);
                    return ((Constructor)object).newInstance(objectArray);
                }
                for (n17 = classArray.length - n14; n17 < (n19 = ((Class[])object4).length); ++n17) {
                    GenericDeclaration genericDeclaration;
                    genericDeclaration = object4[n17];
                    n19 = (int)(genericDeclaration.equals(object5) ? 1 : 0);
                    if (n19 != 0) continue;
                    n17 = 0;
                    break block8;
                }
                n17 = n14;
            }
            if (n17 == 0) continue;
            int n20 = ((Class[])object4).length;
            int n21 = classArray.length;
            n20 = n20 - n21 + n14;
            object4 = Array.newInstance(object5, n20);
            object2 = null;
            for (n11 = 0; n11 < n20; ++n11) {
                n18 = classArray.length - n14 + n11;
                object5 = objectArray[n18];
                Array.set(object4, n11, object5);
            }
            object = new Object[objectArray.length + n14];
            n10 = objectArray.length;
            System.arraycopy(objectArray, 0, object, 0, n10);
            n10 = objectArray.length;
            object[n10] = object4;
            object = (Constructor)arrayList.get((int)var3_5);
            ((Constructor)object).setAccessible(n14 != 0);
            return ((Constructor)object).newInstance(objectArray);
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("className: ");
        ((StringBuilder)object3).append((String)object);
        ((StringBuilder)object3).append(", methodName: <init>");
        object = ((StringBuilder)object3).toString();
        objectArray = new NoSuchMethodException((String)object);
        throw objectArray;
    }

    private static void onSetElement(Object object, String string2, Object object2) {
        Object object3 = Float.class;
        Object object4 = Long.class;
        Class<Integer> clazz = Integer.class;
        Class<Short> clazz2 = Short.class;
        Class<Byte> clazz3 = Byte.class;
        int n10 = object instanceof List;
        Class<Double> clazz4 = "]";
        Object object5 = "[";
        int n11 = -1;
        float f10 = 0.0f / 0.0f;
        int n12 = 1;
        if (n10 != 0) {
            int n13 = string2.startsWith((String)object5);
            if (n13 != 0 && (n13 = string2.endsWith((String)((Object)clazz4))) != 0) {
                n13 = string2.length() - n12;
                object3 = string2.substring(n12, n13);
                try {
                    n13 = Integer.parseInt((String)object3);
                }
                catch (Throwable throwable) {
                    n13 = n11;
                    float f11 = f10;
                }
                if (n13 != n11) {
                    ((List)object).set(n13, object2);
                    return;
                }
            }
        } else {
            n10 = string2.startsWith((String)object5);
            if (n10 != 0 && (n10 = string2.endsWith((String)((Object)clazz4))) != 0) {
                n10 = string2.length() - n12;
                String string3 = string2.substring(n12, n10);
                try {
                    n10 = Integer.parseInt(string3);
                }
                catch (Throwable throwable) {
                    n10 = n11;
                }
                if (n10 != n11) {
                    clazz4 = object.getClass().getName();
                    while ((n11 = (int)(((String)((Object)clazz4)).startsWith((String)object5) ? 1 : 0)) != 0) {
                        clazz4 = ((String)((Object)clazz4)).substring(n12);
                    }
                    object5 = object2.getClass();
                    String string4 = "B";
                    n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                    if (n11 != 0) {
                        if (object5 == clazz3) {
                            Array.set(object, n10, object2);
                            return;
                        }
                    } else {
                        string4 = "S";
                        n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                        n12 = 0;
                        Object object6 = null;
                        if (n11 != 0) {
                            if (object5 == clazz2) {
                                object6 = object2;
                            } else if (object5 == clazz3) {
                                object3 = object2;
                                object3 = (Byte)object2;
                                short s10 = ((Byte)object3).byteValue();
                                object6 = s10;
                            }
                            if (object6 != null) {
                                Array.set(object, n10, object6);
                                return;
                            }
                        } else {
                            string4 = "I";
                            n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                            if (n11 != 0) {
                                if (object5 == clazz) {
                                    object6 = object2;
                                } else if (object5 == clazz2) {
                                    object3 = object2;
                                    object3 = (Short)object2;
                                    short s11 = (Short)object3;
                                    object6 = (int)s11;
                                } else if (object5 == clazz3) {
                                    object3 = object2;
                                    object3 = (Byte)object2;
                                    byte by2 = (Byte)object3;
                                    object6 = (int)by2;
                                }
                                if (object6 != null) {
                                    Array.set(object, n10, object6);
                                    return;
                                }
                            } else {
                                string4 = "J";
                                n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                                if (n11 != 0) {
                                    if (object5 == object4) {
                                        object6 = object2;
                                    } else if (object5 == clazz) {
                                        object3 = object2;
                                        object3 = (Integer)object2;
                                        int n14 = (Integer)object3;
                                        long l10 = n14;
                                        object6 = l10;
                                    } else if (object5 == clazz2) {
                                        object3 = object2;
                                        object3 = (Short)object2;
                                        short s12 = (Short)object3;
                                        long l11 = s12;
                                        object6 = l11;
                                    } else if (object5 == clazz3) {
                                        object3 = object2;
                                        object3 = (Byte)object2;
                                        byte by3 = (Byte)object3;
                                        long l12 = by3;
                                        object6 = l12;
                                    }
                                    if (object6 != null) {
                                        Array.set(object, n10, object6);
                                        return;
                                    }
                                } else {
                                    string4 = "F";
                                    n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                                    if (n11 != 0) {
                                        if (object5 == object3) {
                                            object6 = object2;
                                        } else if (object5 == object4) {
                                            object3 = object2;
                                            object3 = (Long)object2;
                                            long l13 = (Long)object3;
                                            float f12 = l13;
                                            object6 = Float.valueOf(f12);
                                        } else if (object5 == clazz) {
                                            object3 = object2;
                                            object3 = (Integer)object2;
                                            int n15 = (Integer)object3;
                                            float f13 = n15;
                                            object6 = Float.valueOf(f13);
                                        } else if (object5 == clazz2) {
                                            object3 = object2;
                                            object3 = (Short)object2;
                                            short s13 = (Short)object3;
                                            float f14 = s13;
                                            object6 = Float.valueOf(f14);
                                        } else if (object5 == clazz3) {
                                            object3 = object2;
                                            object3 = (Byte)object2;
                                            byte by4 = (Byte)object3;
                                            float f15 = by4;
                                            object6 = Float.valueOf(f15);
                                        }
                                        if (object6 != null) {
                                            Array.set(object, n10, object6);
                                            return;
                                        }
                                    } else {
                                        string4 = "D";
                                        n11 = (int)(string4.equals(clazz4) ? 1 : 0);
                                        if (n11 != 0) {
                                            clazz4 = Double.class;
                                            if (object5 == clazz4) {
                                                object6 = object2;
                                            } else if (object5 == object3) {
                                                object3 = object2;
                                                object3 = (Float)object2;
                                                float f16 = ((Float)object3).floatValue();
                                                double d10 = f16;
                                                object6 = d10;
                                            } else if (object5 == object4) {
                                                object3 = object2;
                                                object3 = (Long)object2;
                                                long l14 = (Long)object3;
                                                double d11 = l14;
                                                object6 = d11;
                                            } else if (object5 == clazz) {
                                                object3 = object2;
                                                object3 = (Integer)object2;
                                                int n16 = (Integer)object3;
                                                double d12 = n16;
                                                object6 = d12;
                                            } else if (object5 == clazz2) {
                                                object3 = object2;
                                                object3 = (Short)object2;
                                                short s14 = (Short)object3;
                                                double d13 = s14;
                                                object6 = d13;
                                            } else if (object5 == clazz3) {
                                                object3 = object2;
                                                object3 = (Byte)object2;
                                                byte by5 = (Byte)object3;
                                                double d14 = by5;
                                                object6 = d14;
                                            }
                                            if (object6 != null) {
                                                Array.set(object, n10, object6);
                                                return;
                                            }
                                        } else {
                                            object3 = "Z";
                                            boolean bl2 = ((String)object3).equals(clazz4);
                                            if (bl2) {
                                                object3 = Boolean.class;
                                                if (object5 == object3) {
                                                    Array.set(object, n10, object2);
                                                    return;
                                                }
                                            } else {
                                                object3 = "C";
                                                bl2 = ((String)object3).equals(clazz4);
                                                if (bl2) {
                                                    object3 = Character.class;
                                                    if (object5 == object3) {
                                                        Array.set(object, n10, object2);
                                                        return;
                                                    }
                                                } else {
                                                    object3 = ((Class)object5).getName();
                                                    bl2 = ((String)((Object)clazz4)).equals(object3);
                                                    if (bl2) {
                                                        Array.set(object, n10, object2);
                                                        return;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        object4 = new StringBuilder();
        ((StringBuilder)object4).append("className: ");
        object = object.getClass();
        ((StringBuilder)object4).append(object);
        ((StringBuilder)object4).append(", fieldName: ");
        ((StringBuilder)object4).append(string2);
        ((StringBuilder)object4).append(", value: ");
        object = String.valueOf(object2);
        ((StringBuilder)object4).append((String)object);
        object = ((StringBuilder)object4).toString();
        object3 = new NoSuchFieldException((String)object);
        throw object3;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void onSetInstanceField(Object object, String string2, Object object2) {
        boolean bl2;
        Field field;
        Serializable serializable;
        Object object3;
        boolean bl3 = object instanceof List;
        if (!bl3 && !(bl3 = ((Class)(object3 = object.getClass())).isArray())) {
            bl3 = object instanceof Map;
            if (bl3) {
                ((Map)object).put(string2, object2);
                return;
            }
            object3 = new ArrayList();
            for (serializable = object.getClass(); serializable != null; serializable = ((Class)serializable).getSuperclass()) {
                ((ArrayList)object3).add(serializable);
            }
        } else {
            ReflectHelper.onSetElement(object, string2, object2);
            return;
        }
        object3 = ((ArrayList)object3).iterator();
        do {
            if (!(bl2 = object3.hasNext())) {
                serializable = new StringBuilder();
                ((StringBuilder)serializable).append("className: ");
                object = object.getClass();
                ((StringBuilder)serializable).append(object);
                ((StringBuilder)serializable).append(", fieldName: ");
                ((StringBuilder)serializable).append(string2);
                ((StringBuilder)serializable).append(", value: ");
                object = String.valueOf(object2);
                ((StringBuilder)serializable).append((String)object);
                object = ((StringBuilder)serializable).toString();
                object3 = new NoSuchFieldException((String)object);
                throw object3;
            }
            serializable = (Class)object3.next();
            field = null;
            try {
                field = ((Class)serializable).getDeclaredField(string2);
            }
            catch (Throwable throwable) {}
        } while (field == null || (bl2 = Modifier.isStatic(field.getModifiers())));
        field.setAccessible(true);
        field.set(object, object2);
    }

    private static void onSetStaticField(String string2, String string3, Object object) {
        boolean bl2;
        Object object2;
        Object object3 = new ArrayList();
        for (object2 = ReflectHelper.getImportedClass(string2); object2 != null; object2 = ((Class)object2).getSuperclass()) {
            ((ArrayList)object3).add(object2);
        }
        object3 = ((ArrayList)object3).iterator();
        while (bl2 = object3.hasNext()) {
            boolean bl3;
            object2 = (Class)object3.next();
            try {
                object2 = ((Class)object2).getDeclaredField(string3);
            }
            catch (Throwable throwable) {
                bl2 = false;
                object2 = null;
            }
            if (object2 == null || !(bl3 = Modifier.isStatic(((Field)object2).getModifiers()))) continue;
            ((Field)object2).setAccessible(true);
            ((Field)object2).set(null, object);
            return;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("className: ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(", fieldName: ");
        ((StringBuilder)object2).append(string3);
        ((StringBuilder)object2).append(", value: ");
        string2 = String.valueOf(object);
        ((StringBuilder)object2).append(string2);
        string2 = ((StringBuilder)object2).toString();
        object3 = new NoSuchFieldException(string2);
        throw object3;
    }

    private static boolean primitiveEquals(Class clazz, Class clazz2) {
        boolean bl2;
        Class clazz3 = Float.class;
        Class<Long> clazz4 = Long.class;
        Class<Integer> clazz5 = Integer.class;
        Class<Character> clazz6 = Character.class;
        Class<Short> clazz7 = Short.class;
        Class<Byte> clazz8 = Byte.class;
        Class<Constable> clazz9 = Byte.TYPE;
        if (clazz == clazz9 && clazz2 == clazz8 || clazz == (clazz9 = Short.TYPE) && (clazz2 == clazz7 || clazz2 == clazz8 || clazz2 == clazz6) || clazz == (clazz9 = Character.TYPE) && (clazz2 == clazz6 || clazz2 == clazz7 || clazz2 == clazz8) || clazz == (clazz9 = Integer.TYPE) && (clazz2 == clazz5 || clazz2 == clazz7 || clazz2 == clazz8 || clazz2 == clazz6) || clazz == (clazz9 = Long.TYPE) && (clazz2 == clazz4 || clazz2 == clazz5 || clazz2 == clazz7 || clazz2 == clazz8 || clazz2 == clazz6) || clazz == (clazz9 = Float.TYPE) && (clazz2 == clazz3 || clazz2 == clazz4 || clazz2 == clazz5 || clazz2 == clazz7 || clazz2 == clazz8 || clazz2 == clazz6) || clazz == (clazz9 = Double.TYPE) && (clazz2 == (clazz9 = Double.class) || clazz2 == clazz3 || clazz2 == clazz4 || clazz2 == clazz5 || clazz2 == clazz7 || clazz2 == clazz8 || clazz2 == clazz6) || clazz == (clazz3 = Boolean.TYPE) && clazz2 == (clazz = Boolean.class)) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }

    public static void setInstanceField(Object object, String object2, Object object3) {
        try {
            ReflectHelper.onSetInstanceField(object, (String)object2, object3);
            return;
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchFieldException;
            if (bl2) {
                throw throwable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("className: ");
            object = object.getClass();
            stringBuilder.append(object);
            stringBuilder.append(", fieldName: ");
            stringBuilder.append((String)object2);
            stringBuilder.append(", value: ");
            object = String.valueOf(object3);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            object2 = new Throwable((String)object, throwable);
            throw object2;
        }
    }

    public static void setStaticField(String string2, String object, Object object2) {
        try {
            ReflectHelper.onSetStaticField(string2, (String)object, object2);
            return;
        }
        catch (Throwable throwable) {
            boolean bl2 = throwable instanceof NoSuchFieldException;
            if (bl2) {
                throw throwable;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("className: ");
            stringBuilder.append(string2);
            stringBuilder.append(", fieldName: ");
            stringBuilder.append((String)object);
            stringBuilder.append(", value: ");
            string2 = String.valueOf(object2);
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
            object = new Throwable(string2, throwable);
            throw object;
        }
    }

    private static boolean tryMatchParams(Class[] object, Class[] classArray) {
        int n10 = ((Class[])object).length;
        int n11 = classArray.length;
        n10 -= n11;
        n11 = 0;
        int n12 = 1;
        if (n10 == n12) {
            boolean bl2;
            int n13;
            block3: {
                int n14;
                for (n10 = 0; n10 < (n14 = classArray.length); ++n10) {
                    Class clazz;
                    Object object2 = classArray[n10];
                    if (object2 == null || (n14 = (int)(ReflectHelper.primitiveEquals((Class)(object2 = object[n10]), clazz = classArray[n10]) ? 1 : 0)) != 0 || (n14 = (int)(((Class)(object2 = object[n10])).isAssignableFrom(clazz = classArray[n10]) ? 1 : 0)) != 0) continue;
                    n13 = 0;
                    classArray = null;
                    break block3;
                }
                n13 = n12;
            }
            if (n13 != 0 && (bl2 = ((Class)(object = object[n13 = ((Class[])object).length - n12])).isArray())) {
                n11 = n12;
            }
        }
        return n11 != 0;
    }
}

