/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Matrix
 */
package d.r.a.u;

import android.graphics.Bitmap;
import android.graphics.Matrix;

public final class g {
    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static Bitmap a(Bitmap bitmap, int n10, int n11) {
        Matrix matrix;
        int n12 = bitmap.getWidth();
        int n13 = bitmap.getHeight();
        float f10 = n10;
        float f11 = n12;
        f10 /= f11;
        float f12 = n11;
        f11 = n13;
        f12 /= f11;
        try {
            matrix = new Matrix();
        }
        catch (Exception exception) {
            return bitmap;
        }
        matrix.postScale(f10, f12);
        boolean bl2 = true;
        return Bitmap.createBitmap((Bitmap)bitmap, (int)0, (int)0, (int)n12, (int)n13, (Matrix)matrix, (boolean)bl2);
    }
}

