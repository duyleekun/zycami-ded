/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.util.DisplayMetrics
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.ViewConfiguration
 */
package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat {
    private static final String TAG = "ViewConfigCompat";
    private static Method sGetScaledScrollFactorMethod;

    static {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 == n11) {
            Object object = ViewConfiguration.class;
            String string2 = "getScaledScrollFactor";
            Class[] classArray = null;
            classArray = new Class[]{};
            object = ((Class)object).getDeclaredMethod(string2, classArray);
            try {
                sGetScaledScrollFactorMethod = object;
            }
            catch (Exception exception) {
                object = TAG;
                string2 = "Could not find method getScaledScrollFactor() on ViewConfiguration";
                Log.i((String)object, (String)string2);
            }
        }
    }

    private ViewConfigurationCompat() {
    }

    private static float getLegacyScrollFactor(ViewConfiguration object, Context context) {
        boolean bl2;
        Object object2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 25;
        if (n10 >= n11 && (object2 = sGetScaledScrollFactorMethod) != null) {
            n11 = 0;
            Object[] objectArray = null;
            objectArray = new Object[]{};
            object = ((Method)object2).invoke(object, objectArray);
            object = (Integer)object;
            try {
                return ((Integer)object).intValue();
            }
            catch (Exception exception) {
                object = TAG;
                object2 = "Could not find method getScaledScrollFactor() on ViewConfiguration";
                Log.i((String)object, (String)object2);
            }
        }
        object = new TypedValue();
        object2 = context.getTheme();
        n10 = (int)(object2.resolveAttribute(n11 = 16842829, (TypedValue)object, bl2 = true) ? 1 : 0);
        if (n10 != 0) {
            context = context.getResources().getDisplayMetrics();
            return object.getDimension((DisplayMetrics)context);
        }
        return 0.0f;
    }

    public static float getScaledHorizontalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return viewConfiguration.getScaledHorizontalScrollFactor();
        }
        return ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
    }

    public static int getScaledHoverSlop(ViewConfiguration viewConfiguration) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return viewConfiguration.getScaledHoverSlop();
        }
        return viewConfiguration.getScaledTouchSlop() / 2;
    }

    public static int getScaledPagingTouchSlop(ViewConfiguration viewConfiguration) {
        return viewConfiguration.getScaledPagingTouchSlop();
    }

    public static float getScaledVerticalScrollFactor(ViewConfiguration viewConfiguration, Context context) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 >= n11) {
            return viewConfiguration.getScaledVerticalScrollFactor();
        }
        return ViewConfigurationCompat.getLegacyScrollFactor(viewConfiguration, context);
    }

    public static boolean hasPermanentMenuKey(ViewConfiguration viewConfiguration) {
        return viewConfiguration.hasPermanentMenuKey();
    }

    public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration viewConfiguration, Context object) {
        boolean bl2;
        String string2;
        String string3;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        if (n10 >= n11) {
            return viewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
        }
        viewConfiguration = object.getResources();
        int n12 = viewConfiguration.getIdentifier((String)(object = "config_showMenuShortcutsWhenKeyboardPresent"), string3 = "bool", string2 = "android");
        if (n12 != 0 && (bl2 = viewConfiguration.getBoolean(n12))) {
            bl2 = true;
        } else {
            bl2 = false;
            viewConfiguration = null;
        }
        return bl2;
    }
}

