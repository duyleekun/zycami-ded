/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.Rect
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VPathRenderer;

public class VectorDrawableCompat$VectorDrawableCompatState
extends Drawable.ConstantState {
    public boolean mAutoMirrored;
    public boolean mCacheDirty;
    public boolean mCachedAutoMirrored;
    public Bitmap mCachedBitmap;
    public int mCachedRootAlpha;
    public int[] mCachedThemeAttrs;
    public ColorStateList mCachedTint;
    public PorterDuff.Mode mCachedTintMode;
    public int mChangingConfigurations;
    public Paint mTempPaint;
    public ColorStateList mTint;
    public PorterDuff.Mode mTintMode;
    public VectorDrawableCompat$VPathRenderer mVPathRenderer;

    public VectorDrawableCompat$VectorDrawableCompatState() {
        Object object;
        this.mTint = null;
        this.mTintMode = object = VectorDrawableCompat.DEFAULT_TINT_MODE;
        this.mVPathRenderer = object;
    }

    public VectorDrawableCompat$VectorDrawableCompatState(VectorDrawableCompat$VectorDrawableCompatState vectorDrawableCompat$VectorDrawableCompatState) {
        Object object;
        int n10 = 0;
        this.mTint = null;
        this.mTintMode = object = VectorDrawableCompat.DEFAULT_TINT_MODE;
        if (vectorDrawableCompat$VectorDrawableCompatState != null) {
            boolean bl2;
            Paint paint;
            this.mChangingConfigurations = n10 = vectorDrawableCompat$VectorDrawableCompatState.mChangingConfigurations;
            VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer;
            super(vectorDrawableCompat$VPathRenderer);
            this.mVPathRenderer = object;
            vectorDrawableCompat$VPathRenderer = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint;
            if (vectorDrawableCompat$VPathRenderer != null) {
                paint = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mFillPaint;
                super(paint);
                object.mFillPaint = vectorDrawableCompat$VPathRenderer;
            }
            if ((object = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint) != null) {
                object = this.mVPathRenderer;
                paint = vectorDrawableCompat$VectorDrawableCompatState.mVPathRenderer.mStrokePaint;
                super(paint);
                object.mStrokePaint = vectorDrawableCompat$VPathRenderer;
            }
            object = vectorDrawableCompat$VectorDrawableCompatState.mTint;
            this.mTint = object;
            this.mTintMode = object = vectorDrawableCompat$VectorDrawableCompatState.mTintMode;
            this.mAutoMirrored = bl2 = vectorDrawableCompat$VectorDrawableCompatState.mAutoMirrored;
        }
    }

    public boolean canReuseBitmap(int n10, int n11) {
        Bitmap bitmap;
        Bitmap bitmap2 = this.mCachedBitmap;
        int n12 = bitmap2.getWidth();
        return n10 == n12 && n11 == (n10 = (bitmap = this.mCachedBitmap).getHeight());
    }

    public boolean canReuseCache() {
        int n10;
        Object object;
        ColorStateList colorStateList;
        int n11 = this.mCacheDirty;
        return n11 == 0 && (colorStateList = this.mCachedTint) == (object = this.mTint) && (colorStateList = this.mCachedTintMode) == (object = this.mTintMode) && (n11 = this.mCachedAutoMirrored) == (n10 = this.mAutoMirrored) && (n11 = this.mCachedRootAlpha) == (n10 = ((VectorDrawableCompat$VPathRenderer)(object = this.mVPathRenderer)).getRootAlpha());
    }

    public void createCachedBitmapIfNeeded(int n10, int n11) {
        boolean bl2;
        Bitmap bitmap = this.mCachedBitmap;
        if (bitmap == null || !(bl2 = this.canReuseBitmap(n10, n11))) {
            Bitmap bitmap2;
            bitmap = Bitmap.Config.ARGB_8888;
            this.mCachedBitmap = bitmap2 = Bitmap.createBitmap((int)n10, (int)n11, (Bitmap.Config)bitmap);
            n10 = 1;
            this.mCacheDirty = n10;
        }
    }

    public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
        colorFilter = this.getPaint(colorFilter);
        Bitmap bitmap = this.mCachedBitmap;
        canvas.drawBitmap(bitmap, null, rect, (Paint)colorFilter);
    }

    public int getChangingConfigurations() {
        return this.mChangingConfigurations;
    }

    public Paint getPaint(ColorFilter colorFilter) {
        boolean bl3 = this.hasTranslucentRoot();
        if (!bl3 && colorFilter == null) {
            return null;
        }
        Paint paint = this.mTempPaint;
        if (paint == null) {
            this.mTempPaint = paint = new Paint();
            boolean bl2 = true;
            paint.setFilterBitmap(bl2);
        }
        paint = this.mTempPaint;
        int n10 = this.mVPathRenderer.getRootAlpha();
        paint.setAlpha(n10);
        this.mTempPaint.setColorFilter(colorFilter);
        return this.mTempPaint;
    }

    public boolean hasTranslucentRoot() {
        int n10;
        VectorDrawableCompat$VPathRenderer vectorDrawableCompat$VPathRenderer = this.mVPathRenderer;
        int n11 = vectorDrawableCompat$VPathRenderer.getRootAlpha();
        if (n11 < (n10 = 255)) {
            n11 = 1;
        } else {
            n11 = 0;
            vectorDrawableCompat$VPathRenderer = null;
        }
        return n11 != 0;
    }

    public boolean isStateful() {
        return this.mVPathRenderer.isStateful();
    }

    public Drawable newDrawable() {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat(this);
        return vectorDrawableCompat;
    }

    public Drawable newDrawable(Resources object) {
        object = new VectorDrawableCompat(this);
        return object;
    }

    public boolean onStateChanged(int[] nArray) {
        boolean bl2;
        boolean bl3 = this.mVPathRenderer.onStateChanged(nArray);
        this.mCacheDirty = bl2 = this.mCacheDirty | bl3;
        return bl3;
    }

    public void updateCacheStates() {
        int n10;
        ColorStateList colorStateList;
        this.mCachedTint = colorStateList = this.mTint;
        colorStateList = this.mTintMode;
        this.mCachedTintMode = colorStateList;
        this.mCachedRootAlpha = n10 = this.mVPathRenderer.getRootAlpha();
        n10 = (int)(this.mAutoMirrored ? 1 : 0);
        this.mCachedAutoMirrored = n10;
        this.mCacheDirty = false;
    }

    public void updateCachedBitmap(int n10, int n11) {
        this.mCachedBitmap.eraseColor(0);
        Bitmap bitmap = this.mCachedBitmap;
        Canvas canvas = new Canvas(bitmap);
        this.mVPathRenderer.draw(canvas, n10, n11, null);
    }
}

