/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Point
 *  android.view.Display
 *  android.view.Display$Mode
 */
package androidx.core.view;

import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import androidx.core.view.DisplayCompat;
import androidx.core.view.DisplayCompat$ModeCompat;

public class DisplayCompat$Api23Impl {
    private DisplayCompat$Api23Impl() {
    }

    public static DisplayCompat$ModeCompat getMode(Context context, Display object) {
        boolean bl2;
        Display.Mode mode = object.getMode();
        if ((context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, object)) != null && !(bl2 = DisplayCompat$Api23Impl.physicalSizeEquals(mode, (Point)context))) {
            object = new DisplayCompat$ModeCompat(mode, (Point)context);
        } else {
            boolean bl3 = true;
            object = new DisplayCompat$ModeCompat(mode, bl3);
        }
        return object;
    }

    public static DisplayCompat$ModeCompat[] getSupportedModes(Context context, Display display) {
        int n10;
        Display.Mode[] modeArray = display.getSupportedModes();
        int n11 = modeArray.length;
        DisplayCompat$ModeCompat[] displayCompat$ModeCompatArray = new DisplayCompat$ModeCompat[n11];
        Display.Mode mode = display.getMode();
        context = DisplayCompat.getCurrentDisplaySizeFromWorkarounds(context, display);
        display = null;
        if (context != null && (n10 = DisplayCompat$Api23Impl.physicalSizeEquals(mode, (Point)context)) == 0) {
            int n12;
            Object var8_8 = null;
            for (n10 = 0; n10 < (n12 = modeArray.length); ++n10) {
                Display.Mode mode2;
                Object object = modeArray[n10];
                n12 = (int)(DisplayCompat$Api23Impl.physicalSizeEquals(object, mode) ? 1 : 0);
                if (n12 != 0) {
                    mode2 = modeArray[n10];
                    object = new DisplayCompat$ModeCompat(mode2, (Point)context);
                } else {
                    mode2 = modeArray[n10];
                    object = new DisplayCompat$ModeCompat(mode2, false);
                }
                displayCompat$ModeCompatArray[n10] = object;
            }
        } else {
            int n13;
            for (int i10 = 0; i10 < (n13 = modeArray.length); ++i10) {
                DisplayCompat$ModeCompat displayCompat$ModeCompat;
                context = modeArray[i10];
                n13 = (int)(DisplayCompat$Api23Impl.physicalSizeEquals((Display.Mode)context, mode) ? 1 : 0);
                Display.Mode mode3 = modeArray[i10];
                displayCompat$ModeCompatArray[i10] = displayCompat$ModeCompat = new DisplayCompat$ModeCompat(mode3, n13 != 0);
            }
        }
        return displayCompat$ModeCompatArray;
    }

    public static boolean isCurrentModeTheLargestMode(Display modeArray) {
        int n10;
        Display.Mode mode = modeArray.getMode();
        modeArray = modeArray.getSupportedModes();
        for (int i10 = 0; i10 < (n10 = modeArray.length); ++i10) {
            Display.Mode mode2;
            int n11;
            n10 = mode.getPhysicalHeight();
            if (n10 >= (n11 = (mode2 = modeArray[i10]).getPhysicalHeight()) && (n10 = mode.getPhysicalWidth()) >= (n11 = (mode2 = modeArray[i10]).getPhysicalWidth())) {
                continue;
            }
            return false;
        }
        return true;
    }

    public static boolean physicalSizeEquals(Display.Mode mode, Point point) {
        int n10;
        int n11;
        int n12;
        int n13 = mode.getPhysicalWidth();
        if (n13 == (n12 = point.x) && (n13 = mode.getPhysicalHeight()) == (n12 = point.y) || (n13 = mode.getPhysicalWidth()) == (n12 = point.y) && (n11 = mode.getPhysicalHeight()) == (n10 = point.x)) {
            n11 = 1;
        } else {
            n11 = 0;
            mode = null;
        }
        return n11 != 0;
    }

    public static boolean physicalSizeEquals(Display.Mode mode, Display.Mode mode2) {
        int n10;
        int n11;
        int n12;
        int n13 = mode.getPhysicalWidth();
        if (n13 == (n12 = mode2.getPhysicalWidth()) && (n11 = mode.getPhysicalHeight()) == (n10 = mode2.getPhysicalHeight())) {
            n11 = 1;
        } else {
            n11 = 0;
            mode = null;
        }
        return n11 != 0;
    }
}

