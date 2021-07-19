/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.ArrayMap
 *  android.util.ArraySet
 */
package com.huawei.updatesdk.b.a.b;

import android.util.ArrayMap;
import android.util.ArraySet;
import com.huawei.updatesdk.a.a.c.a.a.a;
import com.huawei.updatesdk.b.a.b.c$a;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class c {
    public static c$a a(File object) {
        c$a c$a = new c$a();
        if ((object = c.b((File)object)) != null) {
            boolean bl2;
            Object object2 = c.a(object, "mKeySetMapping");
            boolean bl3 = object2 instanceof ArrayMap;
            if (bl3) {
                object2 = (ArrayMap)object2;
                c$a.a = object2;
            }
            if (bl2 = (object = c.a(object, (String)(object2 = "mUpgradeKeySets"))) instanceof ArraySet) {
                object = (ArraySet)object;
                c$a.b = object;
            }
        }
        return c$a;
    }

    private static Object a(Object object, String object2) {
        block7: {
            String string2 = "KeySetsUtils";
            Object object3 = "android.content.pm.PackageParser$Package";
            object3 = Class.forName((String)object3);
            object2 = ((Class)object3).getDeclaredField((String)object2);
            try {
                object = ((Field)object2).get(object);
                break block7;
            }
            catch (NoSuchFieldError noSuchFieldError) {
                object = "can not find field,NoSuchFieldError";
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "can not find field,IllegalAccessException";
            }
            catch (NoSuchFieldException noSuchFieldException) {
                object = "can not find field,NoSuchFieldException";
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = "can not find class,ClassNotFoundException";
            }
            a.c(string2, (String)object);
            object = null;
        }
        return object;
    }

    private static Object b(File object) {
        block16: {
            String string2 = "KeySetsUtils";
            Object object2 = "android.content.pm.PackageParser";
            object2 = Class.forName((String)object2);
            Object object3 = "parsePackage";
            int n10 = 2;
            Class[] classArray = new Class[n10];
            Class clazz = File.class;
            classArray[0] = clazz;
            clazz = Integer.TYPE;
            int n11 = 1;
            classArray[n11] = clazz;
            object3 = ((Class)object2).getDeclaredMethod((String)object3, classArray);
            object2 = ((Class)object2).newInstance();
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            object = 0;
            objectArray[n11] = object;
            try {
                object = ((Method)object3).invoke(object2, objectArray);
                break block16;
            }
            catch (Exception exception) {
                object2 = new StringBuilder();
                object3 = "can not get PackageParser,";
                ((StringBuilder)object2).append((String)object3);
                object = exception.getMessage();
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            }
            catch (InvocationTargetException invocationTargetException) {
                object = "can not get PackageParser,InvocationTargetException";
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "can not get PackageParser,IllegalAccessException";
            }
            catch (InstantiationException instantiationException) {
                object = "can not get PackageParser,InstantiationException";
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = "can not get PackageParser,NoSuchMethodException";
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = "can not get PackageParser,ClassNotFoundException";
            }
            a.c(string2, (String)object);
            object = null;
        }
        return object;
    }
}

