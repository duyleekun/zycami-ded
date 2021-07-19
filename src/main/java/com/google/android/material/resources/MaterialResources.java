/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.ColorStateList
 *  android.content.res.TypedArray
 *  android.graphics.drawable.Drawable
 */
package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import androidx.appcompat.content.res.AppCompatResources;
import com.google.android.material.resources.TextAppearance;

public class MaterialResources {
    private MaterialResources() {
    }

    public static ColorStateList getColorStateList(Context context, TypedArray typedArray, int n10) {
        int n11 = typedArray.hasValue(n10);
        if (n11 != 0 && (n11 = typedArray.getResourceId(n10, 0)) != 0 && (context = AppCompatResources.getColorStateList(context, n11)) != null) {
            return context;
        }
        return typedArray.getColorStateList(n10);
    }

    public static Drawable getDrawable(Context context, TypedArray typedArray, int n10) {
        int n11 = typedArray.hasValue(n10);
        if (n11 != 0 && (n11 = typedArray.getResourceId(n10, 0)) != 0 && (context = AppCompatResources.getDrawable(context, n11)) != null) {
            return context;
        }
        return typedArray.getDrawable(n10);
    }

    public static int getIndexWithValue(TypedArray typedArray, int n10, int n11) {
        boolean bl2 = typedArray.hasValue(n10);
        if (bl2) {
            return n10;
        }
        return n11;
    }

    public static TextAppearance getTextAppearance(Context context, TypedArray typedArray, int n10) {
        boolean bl2 = typedArray.hasValue(n10);
        if (bl2) {
            bl2 = false;
            int n11 = typedArray.getResourceId(n10, 0);
            if (n11 != 0) {
                TextAppearance textAppearance = new TextAppearance(context, n11);
                return textAppearance;
            }
        }
        return null;
    }
}

