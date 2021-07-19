/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.updatesdk.a.a.d;

import com.huawei.updatesdk.a.a.c.a.a.a;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class f {
    private static final String a = "f";

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public static Class a(Field annotatedElement) {
        void var0_3;
        Class clazz = Map.class;
        Class<?> clazz2 = ((Field)annotatedElement).getType();
        int n10 = (int)(clazz.isAssignableFrom(clazz2) ? 1 : 0);
        if (n10 != 0) {
            n10 = 1;
        } else {
            clazz = List.class;
            clazz2 = ((Field)annotatedElement).getType();
            n10 = (int)(clazz.isAssignableFrom(clazz2) ? 1 : 0);
            if (n10 == 0) return var0_3;
            n10 = 0;
            clazz2 = null;
        }
        Class clazz3 = f.a((Field)annotatedElement, n10);
        return var0_3;
    }

    private static Class a(Field object, int n10) {
        block14: {
            int n11 = (object = ((Field)object).getGenericType()) instanceof ParameterizedType;
            if (n11 != 0 && (object = ((ParameterizedType)object).getActualTypeArguments()) != null && (n11 = ((Type[])object).length) > n10) {
                String string2;
                Object object2;
                block15: {
                    object2 = object[n10];
                    n11 = object2 instanceof Class;
                    if (n11 != 0) {
                        object = object[n10];
                        object = (Class)object;
                        break block14;
                    }
                    object = object[n10];
                    object = object.toString();
                    string2 = "class ";
                    n10 = ((String)object).indexOf(string2);
                    if (n10 < 0) {
                        n10 = 0;
                        string2 = null;
                    }
                    object2 = "<";
                    n11 = ((String)object).indexOf((String)object2);
                    if (n11 >= 0) break block15;
                    n11 = ((String)object).length();
                }
                object = ((String)object).substring(n10, n11);
                try {
                    object = Class.forName((String)object);
                    break block14;
                }
                catch (ClassNotFoundException classNotFoundException) {
                    string2 = a;
                    object2 = new StringBuilder();
                    String string3 = "getType exception!";
                    ((StringBuilder)object2).append(string3);
                    object = classNotFoundException.getMessage();
                    ((StringBuilder)object2).append((String)object);
                    object = ((StringBuilder)object2).toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.b(string2, (String)object);
                }
            }
            object = null;
        }
        return object;
    }

    public static Field[] a(Class fieldArray) {
        int n10;
        int n11;
        Object object = fieldArray.getSuperclass();
        if (object != null) {
            object = f.a(fieldArray.getSuperclass());
        } else {
            n11 = 0;
            object = null;
        }
        fieldArray = fieldArray.getDeclaredFields();
        int n12 = 0;
        if (object != null && (n10 = ((Field[])object).length) > 0) {
            n10 = fieldArray.length;
            int n13 = ((Field[])object).length;
            Field[] fieldArray2 = new Field[n10 += n13];
            n13 = ((Object)object).length;
            System.arraycopy(object, 0, fieldArray2, 0, n13);
            n11 = ((Object)object).length;
            n13 = fieldArray.length;
            System.arraycopy(fieldArray, 0, fieldArray2, n11, n13);
            fieldArray = fieldArray2;
        }
        object = new ArrayList();
        n10 = fieldArray.length;
        while (n12 < n10) {
            String string2;
            Field field = fieldArray[n12];
            String string3 = field.getName();
            int n14 = string3.indexOf(string2 = "$");
            if (n14 < 0) {
                object.add(field);
            }
            ++n12;
        }
        n12 = object.size();
        if (n12 != (n10 = fieldArray.length)) {
            int n15 = object.size();
            fieldArray = new Field[n15];
            object.toArray(fieldArray);
        }
        return fieldArray;
    }
}

