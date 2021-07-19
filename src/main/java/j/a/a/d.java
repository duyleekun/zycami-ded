/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.Log
 */
package j.a.a;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import j.a.a.a;
import j.a.a.d$a;
import j.a.a.e$b;
import j.a.a.i.e;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class d {
    private static final String a = "EasyPermissions";

    public static boolean a(Context object, String ... stringArray) {
        int n10 = Build.VERSION.SDK_INT;
        boolean bl2 = true;
        int n11 = 23;
        if (n10 < n11) {
            Log.w((String)a, (String)"hasPermissions: API version < M, returning true by default");
            return bl2;
        }
        if (object != null) {
            n10 = stringArray.length;
            n11 = 0;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string2 = stringArray[i10];
                int n12 = ContextCompat.checkSelfPermission(object, string2);
                if (n12 == 0) continue;
                return false;
            }
            return bl2;
        }
        object = new IllegalArgumentException("Can't check permissions for null context");
        throw object;
    }

    private static boolean b(Object object) {
        Object object2 = object.getClass().getSimpleName();
        boolean bl2 = ((String)object2).endsWith("_");
        if (!bl2) {
            return false;
        }
        object2 = "org.androidannotations.api.view.HasViews";
        try {
            object2 = Class.forName((String)object2);
        }
        catch (ClassNotFoundException classNotFoundException) {
            return false;
        }
        return ((Class)object2).isInstance(object);
    }

    private static void c(Object object, int n10, String[] stringArray) {
        int n11;
        int n12 = stringArray.length;
        int[] nArray = new int[n12];
        Object[] objectArray = null;
        for (int i10 = 0; i10 < (n11 = stringArray.length); ++i10) {
            nArray[i10] = 0;
        }
        objectArray = new Object[]{object};
        d.d(n10, stringArray, nArray, objectArray);
    }

    public static void d(int n10, String[] stringArray, int[] object, Object ... objectArray) {
        int n11;
        int n12;
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        int n13 = 0;
        Object object2 = null;
        for (n12 = 0; n12 < (n11 = stringArray.length); ++n12) {
            String string2 = stringArray[n12];
            int n14 = object[n12];
            if (n14 == 0) {
                arrayList.add(string2);
                continue;
            }
            arrayList2.add(string2);
        }
        int n15 = objectArray.length;
        while (n13 < n15) {
            object = objectArray[n13];
            n12 = (int)(arrayList.isEmpty() ? 1 : 0);
            if (n12 == 0 && (n12 = object instanceof d$a) != 0) {
                object2 = object;
                object2 = (d$a)object;
                object2.g(n10, arrayList);
            }
            if ((n12 = (int)(arrayList2.isEmpty() ? 1 : 0)) == 0 && (n12 = object instanceof d$a) != 0) {
                object2 = object;
                object2 = (d$a)object;
                object2.c(n10, arrayList2);
            }
            if ((n12 = (int)(arrayList.isEmpty() ? 1 : 0)) == 0 && (n12 = (int)(arrayList2.isEmpty() ? 1 : 0)) != 0) {
                d.j(object, n10);
            }
            ++n13;
        }
    }

    public static boolean e(Activity activity, String string2) {
        return e.d(activity).f(string2);
    }

    public static boolean f(Fragment fragment, String string2) {
        return e.e(fragment).f(string2);
    }

    public static void g(Activity activity, String string2, int n10, String ... stringArray) {
        e$b e$b = new e$b(activity, n10, stringArray);
        d.i(e$b.g(string2).a());
    }

    public static void h(Fragment fragment, String string2, int n10, String ... stringArray) {
        e$b e$b = new e$b(fragment, n10, stringArray);
        d.i(e$b.g(string2).a());
    }

    public static void i(j.a.a.e stringArray) {
        String[] stringArray2;
        Object object = stringArray.a().b();
        boolean bl2 = d.a(object, stringArray2 = stringArray.c());
        if (bl2) {
            object = stringArray.a().c();
            int n10 = stringArray.f();
            stringArray = stringArray.c();
            d.c(object, n10, stringArray);
            return;
        }
        e e10 = stringArray.a();
        String string2 = stringArray.e();
        String string3 = stringArray.d();
        String string4 = stringArray.b();
        int n11 = stringArray.g();
        int n12 = stringArray.f();
        String[] stringArray3 = stringArray.c();
        e10.g(string2, string3, string4, n11, n12, stringArray3);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void j(Object object, int n10) {
        String string2 = a;
        Class<?> clazz = object.getClass();
        boolean bl2 = d.b(object);
        if (bl2) {
            clazz = clazz.getSuperclass();
        }
        while (clazz != null) {
            for (Method method : clazz.getDeclaredMethods()) {
                boolean bl3;
                Object[] objectArray = method.getAnnotation(a.class);
                if (objectArray == null || (bl3 = objectArray.value()) != n10) continue;
                objectArray = method.getParameterTypes();
                bl3 = objectArray.length;
                if (bl3 > false) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Cannot execute method ");
                    string2 = method.getName();
                    stringBuilder.append(string2);
                    stringBuilder.append(" because it is non-void method and/or has input parameters.");
                    String string3 = stringBuilder.toString();
                    object = new RuntimeException(string3);
                    throw object;
                }
                try {
                    bl3 = method.isAccessible();
                    if (!bl3) {
                        bl3 = true;
                        method.setAccessible(bl3);
                    }
                    objectArray = new Object[]{};
                    method.invoke(object, objectArray);
                }
                catch (InvocationTargetException invocationTargetException) {
                    objectArray = "runDefaultMethod:InvocationTargetException";
                    Log.e((String)string2, objectArray, (Throwable)invocationTargetException);
                }
                catch (IllegalAccessException illegalAccessException) {
                    objectArray = "runDefaultMethod:IllegalAccessException";
                    Log.e((String)string2, objectArray, (Throwable)illegalAccessException);
                }
            }
            clazz = clazz.getSuperclass();
        }
        return;
    }

    public static boolean k(Activity activity, String ... stringArray) {
        return e.d(activity).k(stringArray);
    }

    public static boolean l(Fragment fragment, String ... stringArray) {
        return e.e(fragment).k(stringArray);
    }

    public static boolean m(Activity activity, List list) {
        return e.d(activity).l(list);
    }

    public static boolean n(Fragment fragment, List list) {
        return e.e(fragment).l(list);
    }
}

