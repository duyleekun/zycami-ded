/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.View;
import androidx.core.view.ViewCompat;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils {
    private static final String TAG = "ViewUtils";
    private static Method sComputeFitSystemWindowsMethod;

    static {
        block9: {
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 18;
            if (n10 >= n11) {
                Object object = View.class;
                String string2 = "computeFitSystemWindows";
                int n12 = 2;
                Class[] classArray = new Class[n12];
                Class<Rect> clazz = null;
                Class<Rect> clazz2 = Rect.class;
                classArray[0] = clazz2;
                clazz = Rect.class;
                boolean bl2 = true;
                classArray[bl2] = clazz;
                object = ((Class)object).getDeclaredMethod(string2, classArray);
                sComputeFitSystemWindowsMethod = object;
                n10 = ((AccessibleObject)object).isAccessible() ? 1 : 0;
                if (n10 != 0) break block9;
                object = sComputeFitSystemWindowsMethod;
                try {
                    ((Method)object).setAccessible(bl2);
                }
                catch (NoSuchMethodException noSuchMethodException) {
                    object = TAG;
                    string2 = "Could not find method computeFitSystemWindows. Oh well.";
                    Log.d((String)object, (String)string2);
                }
            }
        }
    }

    private ViewUtils() {
    }

    public static void computeFitSystemWindows(View view, Rect object, Rect object2) {
        Method method = sComputeFitSystemWindowsMethod;
        if (method != null) {
            int n10 = 2;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object;
            int n11 = 1;
            objectArray[n11] = object2;
            try {
                method.invoke(view, objectArray);
            }
            catch (Exception exception) {
                object = TAG;
                object2 = "Could not invoke computeFitSystemWindows";
                Log.d((String)object, (String)object2, (Throwable)exception);
            }
        }
    }

    public static boolean isLayoutRtl(View view) {
        int n10;
        int n11 = ViewCompat.getLayoutDirection(view);
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void makeOptionalFitsSystemWindows(View object) {
        String string2 = "Could not invoke makeOptionalFitsSystemWindows";
        String string3 = TAG;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 16;
        if (n10 < n11) return;
        try {
            GenericDeclaration genericDeclaration = object.getClass();
            Object[] objectArray = "makeOptionalFitsSystemWindows";
            Class[] classArray = new Class[]{};
            genericDeclaration = ((Class)genericDeclaration).getMethod((String)objectArray, classArray);
            n11 = ((AccessibleObject)((Object)genericDeclaration)).isAccessible() ? 1 : 0;
            if (!n11) {
                n11 = 1;
                ((Method)genericDeclaration).setAccessible(n11 != 0);
            }
            objectArray = new Object[]{};
            ((Method)genericDeclaration).invoke(object, objectArray);
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            Log.d((String)string3, (String)string2, (Throwable)illegalAccessException);
            return;
        }
        catch (InvocationTargetException invocationTargetException) {
            Log.d((String)string3, (String)string2, (Throwable)invocationTargetException);
            return;
        }
        catch (NoSuchMethodException noSuchMethodException) {
            String string4 = "Could not find method makeOptionalFitsSystemWindows. Oh well...";
            Log.d((String)string3, (String)string4);
        }
    }
}

