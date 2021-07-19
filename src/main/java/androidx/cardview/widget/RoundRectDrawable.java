/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.Outline
 *  android.graphics.Paint
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffColorFilter
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 */
package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

public class RoundRectDrawable
extends Drawable {
    private ColorStateList mBackground;
    private final RectF mBoundsF;
    private final Rect mBoundsI;
    private boolean mInsetForPadding = false;
    private boolean mInsetForRadius = true;
    private float mPadding;
    private final Paint mPaint;
    private float mRadius;
    private ColorStateList mTint;
    private PorterDuffColorFilter mTintFilter;
    private PorterDuff.Mode mTintMode;

    public RoundRectDrawable(ColorStateList colorStateList, float f10) {
        Paint paint;
        PorterDuff.Mode mode;
        this.mTintMode = mode = PorterDuff.Mode.SRC_IN;
        this.mRadius = f10;
        this.mPaint = paint = new Paint(5);
        this.setBackground(colorStateList);
        this.mBoundsF = colorStateList;
        super();
        this.mBoundsI = colorStateList;
    }

    private PorterDuffColorFilter createTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList != null && mode != null) {
            Object object = this.getState();
            int n10 = colorStateList.getColorForState(object, 0);
            object = new PorterDuffColorFilter;
            object(n10, mode);
            return object;
        }
        return null;
    }

    private void setBackground(ColorStateList colorStateList) {
        int n10;
        if (colorStateList == null) {
            n10 = 0;
            colorStateList = ColorStateList.valueOf((int)0);
        }
        this.mBackground = colorStateList;
        Paint paint = this.mPaint;
        int[] nArray = this.getState();
        int n11 = this.mBackground.getDefaultColor();
        n10 = colorStateList.getColorForState(nArray, n11);
        paint.setColor(n10);
    }

    private void updateBounds(Rect rect) {
        if (rect == null) {
            rect = this.getBounds();
        }
        RectF rectF = this.mBoundsF;
        int bl2 = rect.left;
        float f10 = bl2;
        int n10 = rect.top;
        float f11 = n10;
        int n11 = rect.right;
        float f12 = n11;
        int n12 = rect.bottom;
        float f13 = n12;
        rectF.set(f10, f11, f12, f13);
        rectF = this.mBoundsI;
        rectF.set(rect);
        int n13 = this.mInsetForPadding;
        if (n13 != 0) {
            float f14 = this.mPadding;
            float f15 = this.mRadius;
            boolean bl3 = this.mInsetForRadius;
            f14 = RoundRectDrawableWithShadow.calculateVerticalPadding(f14, f15, bl3);
            f15 = this.mPadding;
            f10 = this.mRadius;
            boolean bl4 = this.mInsetForRadius;
            f15 = RoundRectDrawableWithShadow.calculateHorizontalPadding(f15, f10, bl4);
            Rect rect2 = this.mBoundsI;
            int n14 = (int)Math.ceil(f15);
            double d10 = Math.ceil(f14);
            n13 = (int)d10;
            rect2.inset(n14, n13);
            rect = this.mBoundsF;
            rectF = this.mBoundsI;
            rect.set((Rect)rectF);
        }
    }

    public void draw(Canvas canvas) {
        boolean bl2;
        Paint paint = this.mPaint;
        PorterDuffColorFilter porterDuffColorFilter = this.mTintFilter;
        if (porterDuffColorFilter != null && (porterDuffColorFilter = paint.getColorFilter()) == null) {
            porterDuffColorFilter = this.mTintFilter;
            paint.setColorFilter((ColorFilter)porterDuffColorFilter);
            bl2 = true;
        } else {
            bl2 = false;
            porterDuffColorFilter = null;
        }
        RectF rectF = this.mBoundsF;
        float f10 = this.mRadius;
        canvas.drawRoundRect(rectF, f10, f10, paint);
        if (bl2) {
            canvas = null;
            paint.setColorFilter(null);
        }
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline outline) {
        Rect rect = this.mBoundsI;
        float f10 = this.mRadius;
        outline.setRoundRect(rect, f10);
    }

    public float getPadding() {
        return this.mPadding;
    }

    public float getRadius() {
        return this.mRadius;
    }

    public boolean isStateful() {
        boolean bl2;
        ColorStateList colorStateList = this.mTint;
        if (colorStateList != null && (bl2 = colorStateList.isStateful()) || (colorStateList = this.mBackground) != null && (bl2 = colorStateList.isStateful()) || (bl2 = super.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return bl2;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.updateBounds(rect);
    }

    public boolean onStateChange(int[] object) {
        Paint paint;
        ColorStateList colorStateList = this.mBackground;
        int n10 = colorStateList.getDefaultColor();
        int n11 = colorStateList.getColorForState(object, n10);
        colorStateList = this.mPaint;
        int n12 = colorStateList.getColor();
        n10 = 1;
        if (n11 != n12) {
            n12 = n10;
        } else {
            n12 = 0;
            colorStateList = null;
        }
        if (n12) {
            paint = this.mPaint;
            paint.setColor(n11);
        }
        if ((object = (Object)this.mTint) != null && (paint = this.mTintMode) != null) {
            object = this.createTintFilter((ColorStateList)object, (PorterDuff.Mode)paint);
            this.mTintFilter = (PorterDuffColorFilter)object;
            return n10;
        }
        return n12;
    }

    public void setAlpha(int n10) {
        this.mPaint.setAlpha(n10);
    }

    public void setColor(ColorStateList colorStateList) {
        this.setBackground(colorStateList);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setPadding(float f10, boolean bl2, boolean bl3) {
        float f11 = this.mPadding;
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 == false && (f13 = (float)this.mInsetForPadding) == bl2 && (f13 = (float)this.mInsetForRadius) == bl3) {
            return;
        }
        this.mPadding = f10;
        this.mInsetForPadding = bl2;
        this.mInsetForRadius = bl3;
        this.updateBounds(null);
        this.invalidateSelf();
    }

    public void setRadius(float f10) {
        float f11 = this.mRadius;
        float f12 = f10 - f11;
        float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (f13 == false) {
            return;
        }
        this.mRadius = f10;
        this.updateBounds(null);
        this.invalidateSelf();
    }

    public void setTintList(ColorStateList colorStateList) {
        this.mTint = colorStateList;
        PorterDuff.Mode mode = this.mTintMode;
        colorStateList = this.createTintFilter(colorStateList, mode);
        this.mTintFilter = colorStateList;
        this.invalidateSelf();
    }

    public void setTintMode(PorterDuff.Mode mode) {
        this.mTintMode = mode;
        ColorStateList colorStateList = this.mTint;
        mode = this.createTintFilter(colorStateList, mode);
        this.mTintFilter = mode;
        this.invalidateSelf();
    }
}

