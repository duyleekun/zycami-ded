/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.RectF
 *  android.os.Build$VERSION
 */
package com.google.android.material.canvas;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.os.Build;

public class CanvasCompat {
    private CanvasCompat() {
    }

    public static int saveLayerAlpha(Canvas canvas, float f10, float f11, float f12, float f13, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 > n12) {
            return canvas.saveLayerAlpha(f10, f11, f12, f13, n10);
        }
        return canvas.saveLayerAlpha(f10, f11, f12, f13, n10, 31);
    }

    public static int saveLayerAlpha(Canvas canvas, RectF rectF, int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 21;
        if (n11 > n12) {
            return canvas.saveLayerAlpha(rectF, n10);
        }
        return canvas.saveLayerAlpha(rectF, n10, 31);
    }
}

