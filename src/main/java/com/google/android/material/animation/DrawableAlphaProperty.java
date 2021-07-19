/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.os.Build$VERSION
 *  android.util.Property
 */
package com.google.android.material.animation;

import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Property;
import java.util.WeakHashMap;

public class DrawableAlphaProperty
extends Property {
    public static final Property DRAWABLE_ALPHA_COMPAT;
    private final WeakHashMap alphaCache;

    static {
        DrawableAlphaProperty drawableAlphaProperty = new DrawableAlphaProperty();
        DRAWABLE_ALPHA_COMPAT = drawableAlphaProperty;
    }

    private DrawableAlphaProperty() {
        super(Integer.class, "drawableAlphaCompat");
        WeakHashMap weakHashMap;
        this.alphaCache = weakHashMap = new WeakHashMap();
    }

    public Integer get(Drawable drawable2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return drawable2.getAlpha();
        }
        WeakHashMap weakHashMap = this.alphaCache;
        n10 = (int)(weakHashMap.containsKey(drawable2) ? 1 : 0);
        if (n10 != 0) {
            return (Integer)this.alphaCache.get(drawable2);
        }
        return 255;
    }

    public void set(Drawable drawable2, Integer n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 19;
        if (n11 < n12) {
            WeakHashMap weakHashMap = this.alphaCache;
            weakHashMap.put(drawable2, n10);
        }
        int n13 = n10;
        drawable2.setAlpha(n13);
    }
}

