/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Build$VERSION
 */
package androidx.core.graphics;

import android.graphics.Bitmap;
import android.os.Build;

public final class BitmapCompat {
    private BitmapCompat() {
    }

    public static int getAllocationByteCount(Bitmap bitmap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 19;
        if (n10 >= n11) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }

    public static boolean hasMipMap(Bitmap bitmap) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            return bitmap.hasMipMap();
        }
        return false;
    }

    public static void setHasMipMap(Bitmap bitmap, boolean bl2) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 >= n11) {
            bitmap.setHasMipMap(bl2);
        }
    }
}

