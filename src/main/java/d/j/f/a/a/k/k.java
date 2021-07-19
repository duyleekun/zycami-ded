/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 */
package d.j.f.a.a.k;

import android.app.Activity;
import com.huawei.secure.android.common.util.LogsUtil;
import d.j.f.a.a.k.k$a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;

public class k {
    private static final String a = "ScreenUtil";
    private static final int b = 524288;

    private static void a(Activity activity, int n10) {
        boolean bl2;
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.getWindow().addFlags(n10);
            return;
        }
        LogsUtil.l("", "activity is null");
    }

    private static void b(Activity activity, int n10) {
        boolean bl2;
        if (activity != null && !(bl2 = activity.isFinishing())) {
            activity.getWindow().clearFlags(n10);
            return;
        }
        LogsUtil.l("", "activity is null");
    }

    public static void c(Activity activity) {
        k.a(activity, 8192);
    }

    public static void d(Activity activity) {
        k.b(activity, 8192);
    }

    public static void e(Activity object) {
        boolean bl2;
        String string2 = a;
        if (object != null && !(bl2 = object.isFinishing())) {
            object = object.getWindow();
            Object object2 = "android.view.Window";
            object2 = Class.forName((String)object2);
            Object[] objectArray = "addPrivateFlags";
            int n10 = 1;
            Class[] classArray = new Class[n10];
            Class<Integer> clazz = Integer.TYPE;
            classArray[0] = clazz;
            object2 = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
            objectArray = new k$a((Method)object2);
            AccessController.doPrivileged(objectArray);
            objectArray = new Object[n10];
            n10 = 524288;
            Integer n11 = n10;
            objectArray[0] = n11;
            try {
                ((Method)object2).invoke(object, objectArray);
            }
            catch (IllegalAccessException illegalAccessException) {
                object = "hideOverlayWindows IllegalAccessException";
                LogsUtil.l(string2, (String)object);
            }
            catch (InvocationTargetException invocationTargetException) {
                object = "hideOverlayWindows InvocationTargetException";
                LogsUtil.l(string2, (String)object);
            }
            catch (NoSuchMethodException noSuchMethodException) {
                object = "hideOverlayWindows NoSuchMethodException";
                LogsUtil.l(string2, (String)object);
            }
            catch (ClassNotFoundException classNotFoundException) {
                object = "hideOverlayWindows ClassNotFoundException";
                LogsUtil.l(string2, (String)object);
            }
        }
    }
}

