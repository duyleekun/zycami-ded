/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 */
package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.appcompat.widget.TintTypedArray;
import com.google.android.material.R$attr;
import com.google.android.material.R$styleable;

public final class ThemeEnforcement {
    private static final int[] APPCOMPAT_CHECK_ATTRS;
    private static final String APPCOMPAT_THEME_NAME = "Theme.AppCompat";
    private static final int[] MATERIAL_CHECK_ATTRS;
    private static final String MATERIAL_THEME_NAME = "Theme.MaterialComponents";

    static {
        int n10;
        int n11;
        int n12 = 1;
        int[] nArray = new int[n12];
        nArray[0] = n11 = R$attr.colorPrimary;
        APPCOMPAT_CHECK_ATTRS = nArray;
        int[] nArray2 = new int[n12];
        nArray2[0] = n10 = R$attr.colorSecondary;
        MATERIAL_CHECK_ATTRS = nArray2;
    }

    private ThemeEnforcement() {
    }

    public static void checkAppCompatTheme(Context context) {
        int[] nArray = APPCOMPAT_CHECK_ATTRS;
        ThemeEnforcement.checkTheme(context, nArray, APPCOMPAT_THEME_NAME);
    }

    private static void checkCompatibleTheme(Context context, AttributeSet attributeSet, int n10, int n11) {
        int[] nArray = R$styleable.ThemeEnforcement;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        n10 = R$styleable.ThemeEnforcement_enforceMaterialTheme;
        n11 = 0;
        n10 = (int)(attributeSet.getBoolean(n10, false) ? 1 : 0);
        attributeSet.recycle();
        if (n10 != 0) {
            ThemeEnforcement.checkMaterialTheme(context);
        }
        ThemeEnforcement.checkAppCompatTheme(context);
    }

    public static void checkMaterialTheme(Context context) {
        int[] nArray = MATERIAL_CHECK_ATTRS;
        ThemeEnforcement.checkTheme(context, nArray, MATERIAL_THEME_NAME);
    }

    private static void checkTextAppearance(Context object, AttributeSet attributeSet, int[] nArray, int n10, int n11, int ... nArray2) {
        int n12;
        Object object2 = R$styleable.ThemeEnforcement;
        object2 = object.obtainStyledAttributes(attributeSet, object2, n10, n11);
        int n13 = R$styleable.ThemeEnforcement_enforceTextAppearance;
        int n14 = 0;
        if ((n13 = (int)(object2.getBoolean(n13, false) ? 1 : 0)) == 0) {
            object2.recycle();
            return;
        }
        if (nArray2 != null && (n13 = nArray2.length) != 0) {
            n12 = (int)(ThemeEnforcement.isCustomTextAppearanceValid(object, attributeSet, nArray, n10, n11, nArray2) ? 1 : 0);
        } else {
            n12 = R$styleable.ThemeEnforcement_android_textAppearance;
            int n15 = -1;
            if ((n12 = object2.getResourceId(n12, n15)) != n15) {
                n14 = 1;
            }
            n12 = n14;
        }
        object2.recycle();
        if (n12 != 0) {
            return;
        }
        object = new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        throw object;
    }

    private static void checkTheme(Context object, int[] object2, String string2) {
        boolean bl2 = ThemeEnforcement.isTheme(object, (int[])object2);
        if (bl2) {
            return;
        }
        object2 = new StringBuilder;
        ((StringBuilder)object2)();
        ((StringBuilder)object2).append("The style on this component requires your app theme to be ");
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(" (or a descendant).");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static boolean isAppCompatTheme(Context context) {
        int[] nArray = APPCOMPAT_CHECK_ATTRS;
        return ThemeEnforcement.isTheme(context, nArray);
    }

    private static boolean isCustomTextAppearanceValid(Context context, AttributeSet attributeSet, int[] nArray, int n10, int n11, int ... nArray2) {
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        int n12 = nArray2.length;
        nArray = null;
        for (n10 = 0; n10 < n12; ++n10) {
            n11 = nArray2[n10];
            int n13 = -1;
            if ((n11 = context.getResourceId(n11, n13)) != n13) continue;
            context.recycle();
            return false;
        }
        context.recycle();
        return true;
    }

    public static boolean isMaterialTheme(Context context) {
        int[] nArray = MATERIAL_CHECK_ATTRS;
        return ThemeEnforcement.isTheme(context, nArray);
    }

    private static boolean isTheme(Context context, int[] nArray) {
        context = context.obtainStyledAttributes(nArray);
        boolean bl2 = context.hasValue(0);
        context.recycle();
        return bl2;
    }

    public static TypedArray obtainStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray, int n10, int n11, int ... nArray2) {
        ThemeEnforcement.checkCompatibleTheme(context, attributeSet, n10, n11);
        ThemeEnforcement.checkTextAppearance(context, attributeSet, nArray, n10, n11, nArray2);
        return context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
    }

    public static TintTypedArray obtainTintedStyledAttributes(Context context, AttributeSet attributeSet, int[] nArray, int n10, int n11, int ... nArray2) {
        ThemeEnforcement.checkCompatibleTheme(context, attributeSet, n10, n11);
        ThemeEnforcement.checkTextAppearance(context, attributeSet, nArray, n10, n11, nArray2);
        return TintTypedArray.obtainStyledAttributes(context, attributeSet, nArray, n10, n11);
    }
}

