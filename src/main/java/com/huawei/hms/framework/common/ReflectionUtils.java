/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.common;

import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.ReflectionUtils$1;
import com.huawei.hms.framework.common.ReflectionUtils$2;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;

public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static boolean checkCompatible(String string2) {
        try {
            ReflectionUtils.tryLoadClass(string2);
            return true;
        }
        catch (Exception exception) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append("ClassNotFoundException");
            string2 = stringBuilder.toString();
            Logger.w(TAG, string2);
            return false;
        }
    }

    private static Class getClass(String string2) {
        if (string2 == null) {
            return null;
        }
        try {
            return Class.forName(string2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return null;
        }
    }

    /*
     * WARNING - void declaration
     */
    public static Object getFieldObj(Object object, String object2) {
        Object object3;
        block9: {
            boolean bl2;
            String string2 = TAG;
            object3 = null;
            if (object != null && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
                void var0_5;
                Object object4 = object.getClass();
                object2 = ((Class)object4).getDeclaredField((String)object2);
                object4 = new ReflectionUtils$1((Field)object2);
                AccessController.doPrivileged(object4);
                try {
                    object3 = ((Field)object2).get(object);
                    break block9;
                }
                catch (SecurityException securityException) {
                    object2 = "not security int method getStaticFieldObj,SecurityException:";
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = "Exception in getFieldObj :: NoSuchFieldException:";
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = "Exception in getFieldObj :: IllegalArgumentException:";
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = "Exception in getFieldObj :: IllegalAccessException:";
                }
                Logger.e(string2, (String)object2, (Throwable)var0_5);
            }
        }
        return object3;
    }

    /*
     * WARNING - void declaration
     */
    private static Method getMethod(Class clazz, String string2, Class ... classArray) {
        String string3 = TAG;
        if (clazz != null && string2 != null) {
            void var0_3;
            try {
                return clazz.getDeclaredMethod(string2, classArray);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                string2 = "NoSuchMethodException:";
            }
            catch (SecurityException securityException) {
                string2 = "SecurityException:";
            }
            Logger.e(string3, string2, (Throwable)var0_3);
            return null;
        }
        Logger.w(string3, "targetClass is  null pr name is null:");
        return null;
    }

    /*
     * WARNING - void declaration
     */
    public static Object getStaticFieldObj(String object, String object2) {
        Object object3;
        block10: {
            boolean bl2;
            String string2 = TAG;
            object3 = null;
            if (object == null) {
                return null;
            }
            if ((object = ReflectionUtils.getClass((String)object)) != null && !(bl2 = TextUtils.isEmpty((CharSequence)object2))) {
                void var0_5;
                object2 = ((Class)object).getDeclaredField((String)object2);
                ReflectionUtils$2 reflectionUtils$2 = new ReflectionUtils$2((Field)object2);
                AccessController.doPrivileged(reflectionUtils$2);
                try {
                    object3 = ((Field)object2).get(object);
                    break block10;
                }
                catch (SecurityException securityException) {
                    object2 = "not security int method getStaticFieldObj,SecurityException:";
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = "Exception in getFieldObj :: NoSuchFieldException:";
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = "Exception in getFieldObj :: IllegalArgumentException:";
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = "Exception in getFieldObj :: IllegalAccessException:";
                }
                Logger.e(string2, (String)object2, (Throwable)var0_5);
            }
        }
        return object3;
    }

    /*
     * WARNING - void declaration
     */
    private static Object invoke(Object object, Method object2, Object ... objectArray) {
        void var0_3;
        String string2 = TAG;
        if (object2 == null) {
            return null;
        }
        try {
            return ((Method)object2).invoke(object, objectArray);
        }
        catch (Exception exception) {
            object2 = "Exception in invoke:";
        }
        catch (RuntimeException runtimeException) {
            object2 = "RuntimeException in invoke:";
        }
        Logger.e(string2, (String)object2, (Throwable)var0_3);
        return null;
    }

    public static Object invokeStaticMethod(String object, String string2, Class[] classArray, Object ... objectArray) {
        object = ReflectionUtils.getMethod(ReflectionUtils.getClass((String)object), string2, classArray);
        string2 = null;
        if (object == null) {
            return null;
        }
        return ReflectionUtils.invoke(null, (Method)object, objectArray);
    }

    public static Object invokeStaticMethod(String object, String string2, Object ... objectArray) {
        Class[] classArray;
        if (object == null) {
            return null;
        }
        if (objectArray != null) {
            int n10 = objectArray.length;
            classArray = new Class[n10];
            for (int i10 = 0; i10 < n10; ++i10) {
                Object object2 = objectArray[i10];
                ReflectionUtils.setClassType(classArray, object2, i10);
            }
        } else {
            classArray = null;
        }
        if ((object = ReflectionUtils.getMethod(ReflectionUtils.getClass((String)object), string2, classArray)) == null) {
            return null;
        }
        return ReflectionUtils.invoke(null, (Method)object, objectArray);
    }

    private static void setClassType(Class[] classArray, Object clazz, int n10) {
        boolean bl2 = clazz instanceof Integer;
        if (bl2) {
            classArray[n10] = clazz = Integer.TYPE;
        } else {
            bl2 = clazz instanceof Long;
            if (bl2) {
                classArray[n10] = clazz = Long.TYPE;
            } else {
                bl2 = clazz instanceof Double;
                if (bl2) {
                    classArray[n10] = clazz = Double.TYPE;
                } else {
                    bl2 = clazz instanceof Float;
                    if (bl2) {
                        classArray[n10] = clazz = Float.TYPE;
                    } else {
                        bl2 = clazz instanceof Boolean;
                        if (bl2) {
                            classArray[n10] = clazz = Boolean.TYPE;
                        } else {
                            bl2 = clazz instanceof Character;
                            if (bl2) {
                                classArray[n10] = clazz = Character.TYPE;
                            } else {
                                bl2 = clazz instanceof Byte;
                                if (bl2) {
                                    classArray[n10] = clazz = Byte.TYPE;
                                } else {
                                    bl2 = clazz instanceof Void;
                                    if (bl2) {
                                        clazz = Void.TYPE;
                                        classArray[n10] = clazz;
                                    } else {
                                        bl2 = clazz instanceof Short;
                                        classArray[n10] = bl2 ? (clazz = Short.TYPE) : (clazz = clazz.getClass());
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static void tryLoadClass(String object) {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader != null) {
            classLoader.loadClass((String)object);
            return;
        }
        object = new ClassNotFoundException("not found classloader");
        throw object;
    }
}

