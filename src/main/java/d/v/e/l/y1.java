/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 *  android.graphics.RectF
 */
package d.v.e.l;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;

public final class y1 {
    private y1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    private static float a(Rect rect) {
        float f10 = (float)rect.width() * 1.0f;
        float f11 = rect.height();
        return f10 / f11;
    }

    private static float b(RectF rectF) {
        float f10 = rectF.width() * 1.0f;
        float f11 = rectF.height();
        return f10 / f11;
    }

    public static Rect c(Bitmap bitmap, float f10) {
        double d10;
        int n10 = bitmap.getWidth();
        int n11 = bitmap.getHeight();
        int n12 = 0;
        Rect rect = new Rect(0, 0, n10, n11);
        float f11 = y1.a(rect);
        double d11 = f11;
        double d12 = d11 - (d10 = (double)f10);
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            n11 = Math.round((float)n11 * f10);
            n10 = (n10 - n11) / 2;
            n11 = 0;
            bitmap = null;
            n12 = n10;
        } else {
            float f12 = (float)n10 / f10;
            int n13 = Math.round(f12);
            n11 = (n11 - n13) / 2;
        }
        rect.inset(n12, n11);
        return rect;
    }

    public static Rect d(Bitmap bitmap, RectF rectF) {
        float f10 = y1.b(rectF);
        return y1.c(bitmap, f10);
    }
}

