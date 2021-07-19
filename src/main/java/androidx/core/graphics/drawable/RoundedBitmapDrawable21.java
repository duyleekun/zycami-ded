/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Outline
 *  android.graphics.Rect
 *  android.view.Gravity
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;

public class RoundedBitmapDrawable21
extends RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void getOutline(Outline outline) {
        this.updateDstRect();
        Rect rect = this.mDstRect;
        float f10 = this.getCornerRadius();
        outline.setRoundRect(rect, f10);
    }

    public void gravityCompatApply(int n10, int n11, int n12, Rect rect, Rect rect2) {
        Gravity.apply((int)n10, (int)n11, (int)n12, (Rect)rect, (Rect)rect2, (int)0);
    }

    public boolean hasMipMap() {
        boolean bl2;
        Bitmap bitmap = this.mBitmap;
        if (bitmap != null && (bl2 = bitmap.hasMipMap())) {
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
            bitmap.setHasMipMap(bl2);
            this.invalidateSelf();
        }
    }
}

