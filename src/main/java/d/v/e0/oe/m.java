/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Matrix
 *  android.graphics.RectF
 */
package d.v.e0.oe;

import android.graphics.Matrix;
import android.graphics.RectF;

public final class m {
    public static boolean a(RectF rectF) {
        float f10;
        float f11;
        boolean bl2;
        float f12;
        float f13;
        float f14;
        if (rectF != null && ((f14 = (f13 = (f12 = rectF.width()) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) != false || (bl2 = (f11 = (f10 = rectF.height()) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)))) {
            bl2 = false;
            f10 = 0.0f;
            rectF = null;
        } else {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        }
        return bl2;
    }

    public static RectF b(RectF rectF, float f10) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f10);
        matrix.mapRect(rectF);
        return rectF;
    }

    public static RectF c(RectF rectF, float f10, float f11) {
        Matrix matrix = new Matrix();
        matrix.setScale(f10, f11);
        matrix.mapRect(rectF);
        return rectF;
    }
}

