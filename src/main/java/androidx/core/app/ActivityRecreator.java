/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.Application
 *  android.app.Application$ActivityLifecycleCallbacks
 *  android.content.res.Configuration
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.Log;
import androidx.core.app.ActivityRecreator$1;
import androidx.core.app.ActivityRecreator$2;
import androidx.core.app.ActivityRecreator$3;
import androidx.core.app.ActivityRecreator$LifecycleCheckCallbacks;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public final class ActivityRecreator {
    private static final String LOG_TAG = "ActivityRecreator";
    public static final Class activityThreadClass;
    private static final Handler mainHandler;
    public static final Field mainThreadField;
    public static final Method performStopActivity2ParamsMethod;
    public static final Method performStopActivity3ParamsMethod;
    public static final Method requestRelaunchActivityMethod;
    public static final Field tokenField;

    static {
        Object object;
        Looper looper = Looper.getMainLooper();
        mainHandler = object = new Handler(looper);
        object = ActivityRecreator.getActivityThreadClass();
        activityThreadClass = object;
        mainThreadField = ActivityRecreator.getMainThreadField();
        tokenField = ActivityRecreator.getTokenField();
        performStopActivity3ParamsMethod = ActivityRecreator.getPerformStopActivity3Params((Class)object);
        performStopActivity2ParamsMethod = ActivityRecreator.getPerformStopActivity2Params((Class)object);
        requestRelaunchActivityMethod = ActivityRecreator.getRequestRelaunchActivityMethod((Class)object);
    }

    private ActivityRecreator() {
    }

    private static Class getActivityThreadClass() {
        String string2 = "android.app.ActivityThread";
        try {
            return Class.forName(string2);
        }
        catch (Throwable throwable) {
            return null;
        }
    }

    private static Field getMainThreadField() {
        boolean bl2;
        Object object = Activity.class;
        String string2 = "mMainThread";
        try {
            object = ((Class)object).getDeclaredField(string2);
            bl2 = true;
        }
        catch (Throwable throwable) {
            return null;
        }
        ((Field)object).setAccessible(bl2);
        return object;
    }

    private static Method getPerformStopActivity2Params(Class genericDeclaration) {
        Class<IBinder> clazz;
        Class<Boolean> clazz2;
        Class[] classArray;
        if (genericDeclaration == null) {
            return null;
        }
        String string2 = "performStopActivity";
        int n10 = 2;
        try {
            classArray = new Class[n10];
            clazz2 = null;
            clazz = IBinder.class;
        }
        catch (Throwable throwable) {
            return null;
        }
        classArray[0] = clazz;
        clazz2 = Boolean.TYPE;
        boolean bl2 = true;
        classArray[bl2] = clazz2;
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
        ((Method)genericDeclaration).setAccessible(bl2);
        return genericDeclaration;
    }

    private static Method getPerformStopActivity3Params(Class genericDeclaration) {
        Class<IBinder> clazz;
        Class<Boolean> clazz2;
        int n10;
        Class[] classArray;
        if (genericDeclaration == null) {
            return null;
        }
        String string2 = "performStopActivity";
        int n11 = 3;
        try {
            classArray = new Class[n11];
            n10 = 0;
            clazz2 = null;
            clazz = IBinder.class;
        }
        catch (Throwable throwable) {
            return null;
        }
        classArray[0] = clazz;
        clazz2 = Boolean.TYPE;
        boolean bl2 = true;
        classArray[bl2] = clazz2;
        n10 = 2;
        Class<String> clazz3 = String.class;
        classArray[n10] = clazz3;
        genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
        ((Method)genericDeclaration).setAccessible(bl2);
        return genericDeclaration;
    }

    private static Method getRequestRelaunchActivityMethod(Class genericDeclaration) {
        boolean bl2 = ActivityRecreator.needsRelaunchCall();
        if (bl2 && genericDeclaration != null) {
            Class<IBinder> clazz;
            Class<List> clazz2;
            int n10;
            Class[] classArray;
            String string2 = "requestRelaunchActivity";
            int n11 = 9;
            try {
                classArray = new Class[n11];
                n10 = 0;
                clazz2 = null;
                clazz = IBinder.class;
            }
            catch (Throwable throwable) {}
            classArray[0] = clazz;
            clazz2 = List.class;
            boolean bl3 = true;
            classArray[bl3] = clazz2;
            n10 = 2;
            Class clazz3 = List.class;
            classArray[n10] = clazz3;
            n10 = 3;
            clazz3 = Integer.TYPE;
            classArray[n10] = clazz3;
            n10 = 4;
            clazz3 = Boolean.TYPE;
            classArray[n10] = clazz3;
            n10 = 5;
            Class<Configuration> clazz4 = Configuration.class;
            classArray[n10] = clazz4;
            n10 = 6;
            clazz4 = Configuration.class;
            classArray[n10] = clazz4;
            n10 = 7;
            classArray[n10] = clazz3;
            n10 = 8;
            classArray[n10] = clazz3;
            genericDeclaration = ((Class)genericDeclaration).getDeclaredMethod(string2, classArray);
            ((Method)genericDeclaration).setAccessible(bl3);
            return genericDeclaration;
        }
        return null;
    }

    private static Field getTokenField() {
        boolean bl2;
        Object object = Activity.class;
        String string2 = "mToken";
        try {
            object = ((Class)object).getDeclaredField(string2);
            bl2 = true;
        }
        catch (Throwable throwable) {
            return null;
        }
        ((Field)object).setAccessible(bl2);
        return object;
    }

    private static boolean needsRelaunchCall() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        n10 = n10 != n11 && n10 != (n11 = 27) ? 0 : 1;
        return n10 != 0;
    }

    public static boolean queueOnStopIfNecessary(Object object, int n10, Activity object2) {
        block10: {
            Object object3;
            try {
                object3 = tokenField;
            }
            catch (Throwable throwable) {
                Log.e((String)LOG_TAG, (String)"Exception while fetching field values", (Throwable)throwable);
                return false;
            }
            object3 = ((Field)object3).get(object2);
            if (object3 != object) break block10;
            int n11 = object2.hashCode();
            if (n11 != n10) break block10;
            object = mainThreadField;
            object = ((Field)object).get(object2);
            Handler handler = mainHandler;
            object2 = new ActivityRecreator$3(object, object3);
            handler.postAtFrontOfQueue((Runnable)object2);
            return true;
        }
        return false;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static boolean recreate(Activity object) {
        Object[] objectArray;
        Handler handler;
        ActivityRecreator$LifecycleCheckCallbacks activityRecreator$LifecycleCheckCallbacks;
        Application application;
        Object object2;
        Object object3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 28;
        if (n10 >= n12) {
            object.recreate();
            return n11 != 0;
        }
        n10 = (int)(ActivityRecreator.needsRelaunchCall() ? 1 : 0);
        n12 = 0;
        if (n10 != 0 && (object3 = requestRelaunchActivityMethod) == null) {
            return false;
        }
        object3 = performStopActivity2ParamsMethod;
        if (object3 == null && (object3 = performStopActivity3ParamsMethod) == null) {
            return false;
        }
        try {
            object3 = tokenField;
            object3 = ((Field)object3).get(object);
            if (object3 == null) {
                return false;
            }
            object2 = mainThreadField;
            if ((object2 = ((Field)object2).get(object)) == null) {
                return false;
            }
            application = object.getApplication();
            activityRecreator$LifecycleCheckCallbacks = new ActivityRecreator$LifecycleCheckCallbacks((Activity)object);
            application.registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)activityRecreator$LifecycleCheckCallbacks);
            handler = mainHandler;
            objectArray = new ActivityRecreator$1(activityRecreator$LifecycleCheckCallbacks, object3);
            handler.post((Runnable)objectArray);
        }
        catch (Throwable throwable) {
            return false;
        }
        int n13 = ActivityRecreator.needsRelaunchCall();
        if (n13 != 0) {
            object = requestRelaunchActivityMethod;
            n13 = 9;
            objectArray = new Object[n13];
            objectArray[0] = object3;
            n10 = 0;
            object3 = null;
            objectArray[n11] = null;
            int n14 = 2;
            objectArray[n14] = null;
            n14 = 3;
            Integer n15 = 0;
            objectArray[n14] = n15;
            n14 = 4;
            Boolean bl2 = Boolean.FALSE;
            objectArray[n14] = bl2;
            n14 = 5;
            objectArray[n14] = null;
            n14 = 6;
            objectArray[n14] = null;
            n10 = 7;
            objectArray[n10] = bl2;
            n10 = 8;
            objectArray[n10] = bl2;
            ((Method)object).invoke(object2, objectArray);
        } else {
            object.recreate();
        }
        {
            catch (Throwable throwable) {
                object3 = mainHandler;
                ActivityRecreator$2 activityRecreator$2 = new ActivityRecreator$2(application, activityRecreator$LifecycleCheckCallbacks);
                object3.post((Runnable)activityRecreator$2);
                throw throwable;
            }
            object = new ActivityRecreator$2(application, activityRecreator$LifecycleCheckCallbacks);
            handler.post((Runnable)object);
            return n11 != 0;
        }
    }
}

