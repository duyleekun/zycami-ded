/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.util.Log
 *  android.view.View
 *  android.widget.PopupWindow
 */
package androidx.core.widget;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    private PopupWindowCompat() {
    }

    public static boolean getOverlapAnchor(PopupWindow object) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getOverlapAnchor();
        }
        n11 = 21;
        if (n10 >= n11) {
            Object object2;
            n10 = (int)(sOverlapAnchorFieldAttempted ? 1 : 0);
            String string2 = TAG;
            if (!n10) {
                n10 = 1;
                Object object3 = PopupWindow.class;
                String string3 = "mOverlapAnchor";
                object3 = ((Class)object3).getDeclaredField(string3);
                sOverlapAnchorField = object3;
                try {
                    ((Field)object3).setAccessible(n10 != 0);
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    string3 = "Could not fetch mOverlapAnchor field from PopupWindow";
                    Log.i((String)string2, (String)string3, (Throwable)noSuchFieldException);
                }
                sOverlapAnchorFieldAttempted = n10;
            }
            if ((object2 = sOverlapAnchorField) != null) {
                object = ((Field)object2).get(object);
                object = (Boolean)object;
                try {
                    return (Boolean)object;
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = "Could not get overlap anchor field in PopupWindow";
                    Log.i((String)string2, (String)object2, (Throwable)illegalAccessException);
                }
            }
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getWindowLayoutType(PopupWindow object) {
        Method method;
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return object.getWindowLayoutType();
        }
        n10 = (int)(sGetWindowLayoutTypeMethodAttempted ? 1 : 0);
        n11 = 0;
        if (!n10) {
            n10 = 1;
            object2 = PopupWindow.class;
            String string2 = "getWindowLayoutType";
            try {
                Class[] classArray = new Class[]{};
                sGetWindowLayoutTypeMethod = object2 = ((Class)object2).getDeclaredMethod(string2, classArray);
                ((Method)object2).setAccessible(n10 != 0);
            }
            catch (Exception exception) {}
            sGetWindowLayoutTypeMethodAttempted = n10;
        }
        if ((method = sGetWindowLayoutTypeMethod) != null) {
            try {
                object2 = new Object[]{};
                object = method.invoke(object, (Object[])object2);
                object = (Integer)object;
                return (Integer)object;
            }
            catch (Exception exception) {}
        }
        return 0;
    }

    public static void setOverlapAnchor(PopupWindow popupWindow, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            popupWindow.setOverlapAnchor(bl2);
        } else {
            n11 = 21;
            if (n10 >= n11) {
                Field field;
                n10 = (int)(sOverlapAnchorFieldAttempted ? 1 : 0);
                String string2 = TAG;
                if (!n10) {
                    n10 = 1;
                    Object object = PopupWindow.class;
                    String string3 = "mOverlapAnchor";
                    object = ((Class)object).getDeclaredField(string3);
                    sOverlapAnchorField = object;
                    try {
                        ((Field)object).setAccessible(n10 != 0);
                    }
                    catch (NoSuchFieldException noSuchFieldException) {
                        string3 = "Could not fetch mOverlapAnchor field from PopupWindow";
                        Log.i((String)string2, (String)string3, (Throwable)noSuchFieldException);
                    }
                    sOverlapAnchorFieldAttempted = n10;
                }
                if ((field = sOverlapAnchorField) != null) {
                    Object object = bl2;
                    try {
                        field.set(popupWindow, object);
                    }
                    catch (IllegalAccessException illegalAccessException) {
                        object = "Could not set overlap anchor field in PopupWindow";
                        Log.i((String)string2, (String)object, (Throwable)illegalAccessException);
                    }
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void setWindowLayoutType(PopupWindow popupWindow, int n10) {
        Object object;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 23;
        if (n11 >= n12) {
            popupWindow.setWindowLayoutType(n10);
            return;
        }
        n11 = (int)(sSetWindowLayoutTypeMethodAttempted ? 1 : 0);
        n12 = 0;
        boolean bl2 = true;
        if (n11 == 0) {
            object = PopupWindow.class;
            String string2 = "setWindowLayoutType";
            try {
                Class<Integer> clazz;
                Class[] classArray = new Class[bl2];
                classArray[0] = clazz = Integer.TYPE;
                sSetWindowLayoutTypeMethod = object = ((Class)object).getDeclaredMethod(string2, classArray);
                ((Method)object).setAccessible(bl2);
            }
            catch (Exception exception) {}
            sSetWindowLayoutTypeMethodAttempted = bl2;
        }
        if ((object = sSetWindowLayoutTypeMethod) == null) return;
        try {
            Object[] objectArray = new Object[bl2];
            Integer n13 = n10;
            objectArray[0] = n13;
            ((Method)object).invoke(popupWindow, objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void showAsDropDown(PopupWindow popupWindow, View view, int n10, int n11, int n12) {
        int n13 = Build.VERSION.SDK_INT;
        int n14 = 19;
        if (n13 >= n14) {
            popupWindow.showAsDropDown(view, n10, n11, n12);
        } else {
            n13 = ViewCompat.getLayoutDirection(view);
            if ((n12 = GravityCompat.getAbsoluteGravity(n12, n13) & 7) == (n13 = 5)) {
                n12 = popupWindow.getWidth();
                n13 = view.getWidth();
                n10 -= (n12 -= n13);
            }
            popupWindow.showAsDropDown(view, n10, n11);
        }
    }
}

