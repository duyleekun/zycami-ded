/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapShader
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.util.DisplayMetrics
 */
package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;

public abstract class RoundedBitmapDrawable
extends Drawable {
    private static final int DEFAULT_PAINT_FLAGS = 3;
    private boolean mApplyGravity;
    public final Bitmap mBitmap;
    private int mBitmapHeight;
    private final BitmapShader mBitmapShader;
    private int mBitmapWidth;
    private float mCornerRadius;
    public final Rect mDstRect;
    private final RectF mDstRectF;
    private int mGravity = 119;
    private boolean mIsCircular;
    private final Paint mPaint;
    private final Matrix mShaderMatrix;
    private int mTargetDensity = 160;

    public RoundedBitmapDrawable(Resources resources, Bitmap bitmap) {
        int n10;
        boolean bl2;
        Paint paint;
        int n11 = 3;
        this.mPaint = paint = new Paint(n11);
        this.mShaderMatrix = paint;
        super();
        this.mDstRect = paint;
        super();
        this.mDstRectF = paint;
        this.mApplyGravity = bl2 = true;
        if (resources != null) {
            resources = resources.getDisplayMetrics();
            this.mTargetDensity = n10 = resources.densityDpi;
        }
        this.mBitmap = bitmap;
        if (bitmap != null) {
            this.computeBitmapSize();
            paint = Shader.TileMode.CLAMP;
            super(bitmap, (Shader.TileMode)paint, (Shader.TileMode)paint);
            this.mBitmapShader = resources;
        } else {
            this.mBitmapHeight = n10 = -1;
            this.mBitmapWidth = n10;
            n10 = 0;
            resources = null;
            this.mBitmapShader = null;
        }
    }

    private void computeBitmapSize() {
        int n10;
        Bitmap bitmap = this.mBitmap;
        int n11 = this.mTargetDensity;
        this.mBitmapWidth = n10 = bitmap.getScaledWidth(n11);
        bitmap = this.mBitmap;
        n11 = this.mTargetDensity;
        this.mBitmapHeight = n10 = bitmap.getScaledHeight(n11);
    }

    private static boolean isGreaterThanZero(float f10) {
        float f11 = 0.05f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    private void updateCircularCornerRadius() {
        float f10;
        int n10 = this.mBitmapHeight;
        int n11 = this.mBitmapWidth;
        this.mCornerRadius = f10 = (float)(Math.min(n10, n11) / 2);
    }

    public void draw(Canvas canvas) {
        Bitmap bitmap = this.mBitmap;
        if (bitmap == null) {
            return;
        }
        this.updateDstRect();
        Shader shader = this.mPaint.getShader();
        if (shader == null) {
            float f10 = 0.0f;
            shader = null;
            Rect rect = this.mDstRect;
            Paint paint = this.mPaint;
            canvas.drawBitmap(bitmap, null, rect, paint);
        } else {
            bitmap = this.mDstRectF;
            float f11 = this.mCornerRadius;
            Paint paint = this.mPaint;
            canvas.drawRoundRect((RectF)bitmap, f11, f11, paint);
        }
    }

    public int getAlpha() {
        return this.mPaint.getAlpha();
    }

    public final Bitmap getBitmap() {
        return this.mBitmap;
    }

    public ColorFilter getColorFilter() {
        return this.mPaint.getColorFilter();
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public int getGravity() {
        return this.mGravity;
    }

    public int getIntrinsicHeight() {
        return this.mBitmapHeight;
    }

    public int getIntrinsicWidth() {
        return this.mBitmapWidth;
    }

    public int getOpacity() {
        float f10;
        Bitmap bitmap;
        int n10 = this.mGravity;
        int n11 = -3;
        int n12 = 119;
        if (n10 == n12 && (n10 = (int)(this.mIsCircular ? 1 : 0)) == 0 && (bitmap = this.mBitmap) != null && (n10 = (int)(bitmap.hasAlpha() ? 1 : 0)) == 0 && (n10 = (bitmap = this.mPaint).getAlpha()) >= (n12 = 255) && (n10 = (int)(RoundedBitmapDrawable.isGreaterThanZero(f10 = this.mCornerRadius) ? 1 : 0)) == 0) {
            n11 = -1;
        }
        return n11;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public void gravityCompatApply(int n10, int n11, int n12, Rect rect, Rect rect2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean hasAntiAlias() {
        return this.mPaint.isAntiAlias();
    }

    public boolean hasMipMap() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public boolean isCircular() {
        return this.mIsCircular;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        boolean bl2 = this.mIsCircular;
        if (bl2) {
            this.updateCircularCornerRadius();
        }
        this.mApplyGravity = true;
    }

    public void setAlpha(int n10) {
        Paint paint = this.mPaint;
        int n11 = paint.getAlpha();
        if (n10 != n11) {
            paint = this.mPaint;
            paint.setAlpha(n10);
            this.invalidateSelf();
        }
    }

    public void setAntiAlias(boolean bl2) {
        this.mPaint.setAntiAlias(bl2);
        this.invalidateSelf();
    }

    public void setCircular(boolean bl2) {
        boolean bl3;
        this.mIsCircular = bl2;
        this.mApplyGravity = bl3 = true;
        if (bl2) {
            this.updateCircularCornerRadius();
            Paint paint = this.mPaint;
            BitmapShader bitmapShader = this.mBitmapShader;
            paint.setShader((Shader)bitmapShader);
            this.invalidateSelf();
        } else {
            bl2 = false;
            Object var3_4 = null;
            this.setCornerRadius(0.0f);
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setCornerRadius(float f10) {
        float f11 = this.mCornerRadius;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return;
        }
        f11 = 0.0f;
        Paint paint = null;
        this.mIsCircular = false;
        object = RoundedBitmapDrawable.isGreaterThanZero(f10);
        if (object != false) {
            paint = this.mPaint;
            BitmapShader bitmapShader = this.mBitmapShader;
            paint.setShader((Shader)bitmapShader);
        } else {
            paint = this.mPaint;
            Object var5_6 = null;
            paint.setShader(null);
        }
        this.mCornerRadius = f10;
        this.invalidateSelf();
    }

    public void setDither(boolean bl2) {
        this.mPaint.setDither(bl2);
        this.invalidateSelf();
    }

    public void setFilterBitmap(boolean bl2) {
        this.mPaint.setFilterBitmap(bl2);
        this.invalidateSelf();
    }

    public void setGravity(int n10) {
        int n11 = this.mGravity;
        if (n11 != n10) {
            this.mGravity = n10;
            n10 = 1;
            this.mApplyGravity = n10;
            this.invalidateSelf();
        }
    }

    public void setMipMap(boolean bl2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public void setTargetDensity(int n10) {
        int n11 = this.mTargetDensity;
        if (n11 != n10) {
            if (n10 == 0) {
                n10 = 160;
            }
            this.mTargetDensity = n10;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                this.computeBitmapSize();
            }
            this.invalidateSelf();
        }
    }

    public void setTargetDensity(Canvas canvas) {
        int n10 = canvas.getDensity();
        this.setTargetDensity(n10);
    }

    public void setTargetDensity(DisplayMetrics displayMetrics) {
        int n10 = displayMetrics.densityDpi;
        this.setTargetDensity(n10);
    }

    public void updateDstRect() {
        int n10 = this.mApplyGravity;
        if (n10 != 0) {
            float f10;
            Rect rect;
            int n11;
            RoundedBitmapDrawable roundedBitmapDrawable;
            RectF rectF;
            RoundedBitmapDrawable roundedBitmapDrawable2;
            int n12;
            n10 = this.mIsCircular;
            if (n10 != 0) {
                float f11;
                n10 = this.mBitmapWidth;
                int n13 = this.mBitmapHeight;
                int n14 = Math.min(n10, n13);
                n12 = this.mGravity;
                Rect rect2 = this.getBounds();
                Rect rect3 = this.mDstRect;
                roundedBitmapDrawable2 = this;
                int n15 = n14;
                this.gravityCompatApply(n12, n14, n14, rect2, rect3);
                rectF = this.mDstRect;
                n10 = rectF.width();
                n13 = this.mDstRect.height();
                n10 = Math.min(n10, n13);
                roundedBitmapDrawable = this.mDstRect;
                n13 = (roundedBitmapDrawable.width() - n10) / 2;
                n13 = Math.max(0, n13);
                roundedBitmapDrawable2 = this.mDstRect;
                n11 = (roundedBitmapDrawable2.height() - n10) / 2;
                n11 = Math.max(0, n11);
                rect = this.mDstRect;
                rect.inset(n13, n11);
                n13 = 0x3F000000;
                f10 = 0.5f;
                this.mCornerRadius = f11 = (float)n10 * f10;
            } else {
                n11 = this.mGravity;
                n12 = this.mBitmapWidth;
                int n16 = this.mBitmapHeight;
                Rect rect4 = this.getBounds();
                Rect rect5 = this.mDstRect;
                roundedBitmapDrawable = this;
                this.gravityCompatApply(n11, n12, n16, rect4, rect5);
            }
            rectF = this.mDstRectF;
            roundedBitmapDrawable = this.mDstRect;
            rectF.set((Rect)roundedBitmapDrawable);
            rectF = this.mBitmapShader;
            if (rectF != null) {
                rectF = this.mShaderMatrix;
                roundedBitmapDrawable = this.mDstRectF;
                float f12 = ((RectF)roundedBitmapDrawable).left;
                f10 = ((RectF)roundedBitmapDrawable).top;
                rectF.setTranslate(f12, f10);
                rectF = this.mShaderMatrix;
                f10 = this.mDstRectF.width();
                n11 = this.mBitmap.getWidth();
                f12 = n11;
                f10 /= f12;
                roundedBitmapDrawable2 = this.mDstRectF;
                f12 = roundedBitmapDrawable2.height();
                rect = this.mBitmap;
                n12 = rect.getHeight();
                float f13 = n12;
                rectF.preScale(f10, f12 /= f13);
                rectF = this.mBitmapShader;
                roundedBitmapDrawable = this.mShaderMatrix;
                rectF.setLocalMatrix((Matrix)roundedBitmapDrawable);
                rectF = this.mPaint;
                roundedBitmapDrawable = this.mBitmapShader;
                rectF.setShader((Shader)roundedBitmapDrawable);
            }
            this.mApplyGravity = false;
        }
    }
}

