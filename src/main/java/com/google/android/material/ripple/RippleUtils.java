/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.os.Build$VERSION
 *  android.util.StateSet
 */
package com.google.android.material.ripple;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.StateSet;
import androidx.core.graphics.ColorUtils;

public class RippleUtils {
    private static final int[] FOCUSED_STATE_SET;
    private static final int[] HOVERED_FOCUSED_STATE_SET;
    private static final int[] HOVERED_STATE_SET;
    private static final int[] PRESSED_STATE_SET;
    private static final int[] SELECTED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_FOCUSED_STATE_SET;
    private static final int[] SELECTED_HOVERED_STATE_SET;
    private static final int[] SELECTED_PRESSED_STATE_SET;
    private static final int[] SELECTED_STATE_SET;
    public static final boolean USE_FRAMEWORK_RIPPLE;

    static {
        int[] nArray;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 1;
        int n12 = 21;
        if (n10 >= n12) {
            n10 = n11;
        } else {
            n10 = 0;
            nArray = null;
        }
        USE_FRAMEWORK_RIPPLE = n10;
        nArray = new int[n11];
        nArray[0] = 16842919;
        PRESSED_STATE_SET = nArray;
        n10 = 2;
        int[] nArray2 = new int[n10];
        nArray2[0] = 16843623;
        nArray2[1] = 16842908;
        HOVERED_FOCUSED_STATE_SET = nArray2;
        nArray2 = new int[n11];
        nArray2[0] = 16842908;
        FOCUSED_STATE_SET = nArray2;
        nArray2 = new int[n11];
        nArray2[0] = 16843623;
        HOVERED_STATE_SET = nArray2;
        nArray2 = new int[n10];
        nArray2[0] = 0x10100A1;
        nArray2[1] = 16842919;
        SELECTED_PRESSED_STATE_SET = nArray2;
        int[] nArray3 = nArray2 = new int[3];
        nArray2[0] = 0x10100A1;
        nArray3[1] = 16843623;
        nArray3[2] = 16842908;
        SELECTED_HOVERED_FOCUSED_STATE_SET = nArray2;
        nArray2 = new int[n10];
        nArray2[0] = 0x10100A1;
        nArray2[1] = 16842908;
        SELECTED_FOCUSED_STATE_SET = nArray2;
        nArray = new int[n10];
        nArray[0] = 0x10100A1;
        nArray[1] = 16843623;
        SELECTED_HOVERED_STATE_SET = nArray;
        nArray = new int[n11];
        nArray[0] = 0x10100A1;
        SELECTED_STATE_SET = nArray;
    }

    private RippleUtils() {
    }

    public static ColorStateList convertToRippleDrawableColor(ColorStateList colorStateList) {
        int n10;
        int n11;
        int n12 = USE_FRAMEWORK_RIPPLE;
        int n13 = 2;
        int n14 = 1;
        int[] nArray = null;
        if (n12 != 0) {
            int n15;
            int n16;
            int[][] nArrayArray = new int[n13][];
            int[] nArray2 = new int[n13];
            int[] nArray3 = SELECTED_STATE_SET;
            nArrayArray[0] = nArray3;
            nArray3 = SELECTED_PRESSED_STATE_SET;
            nArray2[0] = n16 = RippleUtils.getColorForState(colorStateList, nArray3);
            nArray = StateSet.NOTHING;
            nArrayArray[n14] = nArray;
            nArray = PRESSED_STATE_SET;
            nArray2[n14] = n15 = RippleUtils.getColorForState(colorStateList, nArray);
            colorStateList = new ColorStateList((int[][])nArrayArray, nArray2);
            return colorStateList;
        }
        n12 = 10;
        int[][] nArrayArray = new int[n12][];
        int[] nArray4 = new int[n12];
        int[] nArray5 = SELECTED_PRESSED_STATE_SET;
        nArrayArray[0] = nArray5;
        nArray4[0] = n11 = RippleUtils.getColorForState(colorStateList, nArray5);
        nArray5 = SELECTED_HOVERED_FOCUSED_STATE_SET;
        nArrayArray[n14] = nArray5;
        nArray4[n14] = n11 = RippleUtils.getColorForState(colorStateList, nArray5);
        int[] nArray6 = SELECTED_FOCUSED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n14 = RippleUtils.getColorForState(colorStateList, nArray6);
        n13 = 3;
        nArray6 = SELECTED_HOVERED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n14 = RippleUtils.getColorForState(colorStateList, nArray6);
        n13 = 4;
        nArray6 = SELECTED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = 0;
        n13 = 5;
        nArray6 = PRESSED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n14 = RippleUtils.getColorForState(colorStateList, nArray6);
        n13 = 6;
        nArray6 = HOVERED_FOCUSED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n14 = RippleUtils.getColorForState(colorStateList, nArray6);
        n13 = 7;
        nArray6 = FOCUSED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n14 = RippleUtils.getColorForState(colorStateList, nArray6);
        n13 = 8;
        nArray6 = HOVERED_STATE_SET;
        nArrayArray[n13] = nArray6;
        nArray4[n13] = n10 = RippleUtils.getColorForState(colorStateList, nArray6);
        n10 = 9;
        int[] nArray7 = StateSet.NOTHING;
        nArrayArray[n10] = nArray7;
        nArray4[n10] = 0;
        colorStateList = new ColorStateList((int[][])nArrayArray, nArray4);
        return colorStateList;
    }

    private static int doubleAlpha(int n10) {
        int n11 = Math.min(Color.alpha((int)n10) * 2, 255);
        return ColorUtils.setAlphaComponent(n10, n11);
    }

    private static int getColorForState(ColorStateList colorStateList, int[] nArray) {
        int n10;
        if (colorStateList != null) {
            int n11 = colorStateList.getDefaultColor();
            n10 = colorStateList.getColorForState(nArray, n11);
        } else {
            n10 = 0;
            colorStateList = null;
        }
        boolean bl2 = USE_FRAMEWORK_RIPPLE;
        if (bl2) {
            n10 = RippleUtils.doubleAlpha(n10);
        }
        return n10;
    }
}

