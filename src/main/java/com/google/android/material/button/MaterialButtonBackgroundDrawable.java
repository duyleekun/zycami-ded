/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.ColorFilter
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.graphics.drawable.InsetDrawable
 *  android.graphics.drawable.LayerDrawable
 *  android.graphics.drawable.RippleDrawable
 */
package com.google.android.material.button;

import android.content.res.ColorStateList;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;

public class MaterialButtonBackgroundDrawable
extends RippleDrawable {
    public MaterialButtonBackgroundDrawable(ColorStateList colorStateList, InsetDrawable insetDrawable, Drawable drawable2) {
        super(colorStateList, (Drawable)insetDrawable, drawable2);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        GradientDrawable gradientDrawable = null;
        Drawable drawable2 = this.getDrawable(0);
        if (drawable2 != null) {
            drawable2 = (LayerDrawable)((InsetDrawable)this.getDrawable(0)).getDrawable();
            gradientDrawable = (GradientDrawable)drawable2.getDrawable(0);
            gradientDrawable.setColorFilter(colorFilter);
        }
    }
}

