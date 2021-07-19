/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.UiModeManager
 *  android.content.Context
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.view.Display
 */
package androidx.core.view;

import android.app.UiModeManager;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.text.TextUtils;
import android.view.Display;
import androidx.core.view.DisplayCompat$Api17Impl;
import androidx.core.view.DisplayCompat$Api23Impl;
import androidx.core.view.DisplayCompat$ModeCompat;
import java.lang.reflect.Method;

public final class DisplayCompat {
    private static final int DISPLAY_SIZE_4K_HEIGHT = 2160;
    private static final int DISPLAY_SIZE_4K_WIDTH = 3840;

    private DisplayCompat() {
    }

    public static Point getCurrentDisplaySizeFromWorkarounds(Context context, Display display) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 28;
        Point point = n10 < n11 ? DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("sys.display-size", display) : DisplayCompat.parsePhysicalDisplaySizeFromSystemProperties("vendor.display-size", display);
        if (point != null) {
            return point;
        }
        int n12 = DisplayCompat.isSonyBravia4kTv(context);
        n10 = 0;
        point = null;
        if (n12 != 0 && (n12 = DisplayCompat.isCurrentModeTheLargestMode(display)) != 0) {
            n12 = 3840;
            int n13 = 2160;
            point = new Point(n12, n13);
        }
        return point;
    }

    private static Point getDisplaySize(Context context, Display display) {
        if ((context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display)) != null) {
            return context;
        }
        context = new Point();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            DisplayCompat$Api17Impl.getRealSize(display, (Point)context);
        } else {
            display.getSize((Point)context);
        }
        return context;
    }

    public static DisplayCompat$ModeCompat getMode(Context context, Display display) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return DisplayCompat$Api23Impl.getMode(context, display);
        }
        context = DisplayCompat.getDisplaySize(context, display);
        DisplayCompat$ModeCompat displayCompat$ModeCompat = new DisplayCompat$ModeCompat((Point)context);
        return displayCompat$ModeCompat;
    }

    public static DisplayCompat$ModeCompat[] getSupportedModes(Context object, Display display) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return DisplayCompat$Api23Impl.getSupportedModes(object, display);
        }
        DisplayCompat$ModeCompat[] displayCompat$ModeCompatArray = new DisplayCompat$ModeCompat[1];
        object = DisplayCompat.getMode(object, display);
        displayCompat$ModeCompatArray[0] = object;
        return displayCompat$ModeCompatArray;
    }

    private static String getSystemProperty(String object) {
        int n10;
        Object object2;
        Object object3 = "android.os.SystemProperties";
        try {
            object3 = Class.forName((String)object3);
            object2 = "get";
            n10 = 1;
        }
        catch (Exception exception) {
            return null;
        }
        Class[] classArray = new Class[n10];
        Class<String> clazz = String.class;
        classArray[0] = clazz;
        object2 = ((Class)object3).getMethod((String)object2, classArray);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        object = ((Method)object2).invoke(object3, objectArray);
        return (String)object;
    }

    public static boolean isCurrentModeTheLargestMode(Display display) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        if (n10 >= n11) {
            return DisplayCompat$Api23Impl.isCurrentModeTheLargestMode(display);
        }
        return true;
    }

    private static boolean isSonyBravia4kTv(Context context) {
        boolean bl2;
        String string2;
        String string3;
        boolean bl3 = DisplayCompat.isTv(context);
        if (bl3 && (bl3 = (string3 = "Sony").equals(string2 = Build.MANUFACTURER)) && (bl3 = (string2 = Build.MODEL).startsWith(string3 = "BRAVIA")) && (bl2 = (context = context.getPackageManager()).hasSystemFeature(string2 = "com.sony.dtv.hardware.panel.qfhd"))) {
            bl2 = true;
        } else {
            bl2 = false;
            context = null;
        }
        return bl2;
    }

    private static boolean isTv(Context context) {
        int n10;
        int n11;
        String string2 = "uimode";
        if ((context = (UiModeManager)context.getSystemService(string2)) != null && (n11 = context.getCurrentModeType()) == (n10 = 4)) {
            n11 = 1;
        } else {
            n11 = 0;
            context = null;
        }
        return n11 != 0;
    }

    private static Point parseDisplaySize(String object) {
        int n10;
        object = object.trim();
        String string2 = "x";
        int n11 = ((String[])(object = object.split(string2, -1))).length;
        if (n11 == (n10 = 2)) {
            string2 = object[0];
            n11 = Integer.parseInt(string2);
            n10 = 1;
            object = object[n10];
            int n12 = Integer.parseInt((String)object);
            if (n11 > 0 && n12 > 0) {
                Point point = new Point(n11, n12);
                return point;
            }
        }
        object = new NumberFormatException();
        throw object;
    }

    private static Point parsePhysicalDisplaySizeFromSystemProperties(String string2, Display display) {
        int n10 = display.getDisplayId();
        if (n10 != 0) {
            return null;
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)(string2 = DisplayCompat.getSystemProperty(string2))) ? 1 : 0);
        if (n10 != 0) {
            return null;
        }
        try {
            return DisplayCompat.parseDisplaySize(string2);
        }
        catch (NumberFormatException numberFormatException) {
            return null;
        }
    }
}

