/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.graphics.Color
 *  android.util.Log
 *  android.util.TypedValue
 *  android.view.View
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import androidx.appcompat.R$styleable;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.ColorUtils;

public class ThemeUtils {
    public static final int[] ACTIVATED_STATE_SET;
    public static final int[] CHECKED_STATE_SET;
    public static final int[] DISABLED_STATE_SET;
    public static final int[] EMPTY_STATE_SET;
    public static final int[] FOCUSED_STATE_SET;
    public static final int[] NOT_PRESSED_OR_FOCUSED_STATE_SET;
    public static final int[] PRESSED_STATE_SET;
    public static final int[] SELECTED_STATE_SET;
    private static final String TAG = "ThemeUtils";
    private static final int[] TEMP_ARRAY;
    private static final ThreadLocal TL_TYPED_VALUE;

    static {
        ThreadLocal threadLocal;
        TL_TYPED_VALUE = threadLocal = new ThreadLocal();
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = -16842910;
        DISABLED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 16842908;
        FOCUSED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 16843518;
        ACTIVATED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 16842919;
        PRESSED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 0x10100A0;
        CHECKED_STATE_SET = nArray;
        nArray = new int[n10];
        nArray[0] = 0x10100A1;
        SELECTED_STATE_SET = nArray;
        nArray = new int[]{-16842919, -16842908};
        NOT_PRESSED_OR_FOCUSED_STATE_SET = nArray;
        EMPTY_STATE_SET = new int[0];
        TEMP_ARRAY = new int[n10];
    }

    private ThemeUtils() {
    }

    public static void checkAppCompatTheme(View object, Context context) {
        block10: {
            Object object2 = R$styleable.AppCompatTheme;
            context = context.obtainStyledAttributes(object2);
            int n10 = R$styleable.AppCompatTheme_windowActionBar;
            n10 = context.hasValue(n10) ? 1 : 0;
            if (n10 != 0) break block10;
            object2 = TAG;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "View ";
            stringBuilder.append(string2);
            object = object.getClass();
            stringBuilder.append(object);
            object = " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).";
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
            Log.e((String)object2, (String)object);
        }
        return;
        finally {
            context.recycle();
        }
    }

    public static ColorStateList createDisabledStateList(int n10, int n11) {
        int n12 = 2;
        int[][] nArrayArray = new int[n12][];
        int[] nArray = new int[n12];
        int[] nArray2 = DISABLED_STATE_SET;
        nArrayArray[0] = nArray2;
        nArray[0] = n11;
        int[] nArray3 = EMPTY_STATE_SET;
        int n13 = 1;
        nArrayArray[n13] = nArray3;
        nArray[n13] = n10;
        ColorStateList colorStateList = new ColorStateList((int[][])nArrayArray, nArray);
        return colorStateList;
    }

    public static int getDisabledThemeAttrColor(Context object, int n10) {
        boolean bl2;
        ColorStateList colorStateList = ThemeUtils.getThemeAttrColorStateList(object, n10);
        if (colorStateList != null && (bl2 = colorStateList.isStateful())) {
            object = DISABLED_STATE_SET;
            n10 = colorStateList.getDefaultColor();
            return colorStateList.getColorForState((int[])object, n10);
        }
        colorStateList = ThemeUtils.getTypedValue();
        object.getTheme().resolveAttribute(0x1010033, (TypedValue)colorStateList, true);
        float f10 = colorStateList.getFloat();
        return ThemeUtils.getThemeAttrColor(object, n10, f10);
    }

    public static int getThemeAttrColor(Context object, int n10) {
        int[] nArray = TEMP_ARRAY;
        nArray[0] = n10;
        n10 = 0;
        Object var3_3 = null;
        object = TintTypedArray.obtainStyledAttributes((Context)object, null, nArray);
        try {
            n10 = ((TintTypedArray)object).getColor(0, 0);
            return n10;
        }
        finally {
            ((TintTypedArray)object).recycle();
        }
    }

    public static int getThemeAttrColor(Context context, int n10, float f10) {
        int n11 = ThemeUtils.getThemeAttrColor(context, n10);
        n10 = Math.round((float)Color.alpha((int)n11) * f10);
        return ColorUtils.setAlphaComponent(n11, n10);
    }

    public static ColorStateList getThemeAttrColorStateList(Context object, int n10) {
        int[] nArray = TEMP_ARRAY;
        nArray[0] = n10;
        n10 = 0;
        ColorStateList colorStateList = null;
        object = TintTypedArray.obtainStyledAttributes((Context)object, null, nArray);
        try {
            colorStateList = ((TintTypedArray)object).getColorStateList(0);
            return colorStateList;
        }
        finally {
            ((TintTypedArray)object).recycle();
        }
    }

    private static TypedValue getTypedValue() {
        ThreadLocal threadLocal = TL_TYPED_VALUE;
        TypedValue typedValue = (TypedValue)threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        return typedValue;
    }
}

