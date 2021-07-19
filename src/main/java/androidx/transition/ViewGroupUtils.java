/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.view.ViewGroup
 */
package androidx.transition;

import android.os.Build;
import android.view.ViewGroup;
import androidx.transition.ViewGroupOverlayApi14;
import androidx.transition.ViewGroupOverlayApi18;
import androidx.transition.ViewGroupOverlayImpl;
import androidx.transition.ViewGroupUtilsApi14;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewGroupUtils {
    private static Method sGetChildDrawingOrderMethod;
    private static boolean sGetChildDrawingOrderMethodFetched = false;
    private static boolean sTryHiddenSuppressLayout = true;

    private ViewGroupUtils() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static int getChildDrawingOrder(ViewGroup object, int n10) {
        Object object2;
        Object object3;
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 29;
        if (n11 >= n12) {
            return object.getChildDrawingOrder(n10);
        }
        n11 = (int)(sGetChildDrawingOrderMethodFetched ? 1 : 0);
        n12 = 0;
        Integer n13 = null;
        int n14 = 2;
        boolean bl2 = true;
        if (n11 == 0) {
            object3 = ViewGroup.class;
            object2 = "getChildDrawingOrder";
            try {
                Class<Integer> clazz;
                Class[] classArray = new Class[n14];
                classArray[0] = clazz = Integer.TYPE;
                classArray[bl2] = clazz;
                sGetChildDrawingOrderMethod = object3 = ((Class)object3).getDeclaredMethod((String)object2, classArray);
                ((Method)object3).setAccessible(bl2);
            }
            catch (NoSuchMethodException noSuchMethodException) {}
            sGetChildDrawingOrderMethodFetched = bl2;
        }
        if ((object3 = sGetChildDrawingOrderMethod) != null) {
            try {
                Object[] objectArray = new Object[n14];
                int n15 = object.getChildCount();
                objectArray[0] = object2 = Integer.valueOf(n15);
                n13 = n10;
                objectArray[bl2] = n13;
                object = ((Method)object3).invoke(object, objectArray);
                object = (Integer)object;
                return (Integer)object;
            }
            catch (IllegalAccessException | InvocationTargetException reflectiveOperationException) {}
        }
        return n10;
    }

    public static ViewGroupOverlayImpl getOverlay(ViewGroup viewGroup) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            ViewGroupOverlayApi18 viewGroupOverlayApi18 = new ViewGroupOverlayApi18(viewGroup);
            return viewGroupOverlayApi18;
        }
        return ViewGroupOverlayApi14.createFrom(viewGroup);
    }

    private static void hiddenSuppressLayout(ViewGroup viewGroup, boolean bl2) {
        boolean bl3 = sTryHiddenSuppressLayout;
        if (bl3) {
            try {
                viewGroup.suppressLayout(bl2);
            }
            catch (NoSuchMethodError noSuchMethodError) {
                viewGroup = null;
                sTryHiddenSuppressLayout = false;
            }
        }
    }

    public static void suppressLayout(ViewGroup viewGroup, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11) {
            viewGroup.suppressLayout(bl2);
        } else {
            n11 = 18;
            if (n10 >= n11) {
                ViewGroupUtils.hiddenSuppressLayout(viewGroup, bl2);
            } else {
                ViewGroupUtilsApi14.suppressLayout(viewGroup, bl2);
            }
        }
    }
}

