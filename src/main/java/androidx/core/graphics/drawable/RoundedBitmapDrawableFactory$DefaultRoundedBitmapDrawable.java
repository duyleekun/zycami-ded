/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Rect
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import androidx.core.graphics.BitmapCompat;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.view.GravityCompat;

public class RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable
extends RoundedBitmapDrawable {
    public RoundedBitmapDrawableFactory$DefaultRoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void gravityCompatApply(int n10, int n11, int n12, Rect rect, Rect rect2) {
        GravityCompat.apply(n10, n11, n12, rect, rect2, 0);
    }

    public boolean hasMipMap() {
        boolean bl2;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && (bl2 = BitmapCompat.hasMipMap(bitmap))) {
            bl2 = true;
        } else {
            bl2 = false;
            bitmap = null;
        }
        return bl2;
    }

    public void setMipMap(boolean bl2) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null) {
            BitmapCompat.setHasMipMap(bitmap, bl2);
            this.invalidateSelf();
        }
    }
}

