/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

public class DrawableUtils {
    private DrawableUtils() {
    }

    public static PorterDuffColorFilter updateTintFilter(Drawable object, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            object = object.getState();
            int n10 = colorStateList.getColorForState((int[])object, 0);
            colorStateList = new PorterDuffColorFilter(n10, mode);
            return colorStateList;
        }
        return null;
    }
}

