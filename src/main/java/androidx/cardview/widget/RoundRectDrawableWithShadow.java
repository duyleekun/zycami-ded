/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$FillType
 *  android.graphics.RadialGradient
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 */
package androidx.cardview.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.cardview.R$color;
import androidx.cardview.R$dimen;
import androidx.cardview.widget.RoundRectDrawableWithShadow$RoundRectHelper;

public class RoundRectDrawableWithShadow
extends Drawable {
    private static final double COS_45 = 0.0;
    private static final float SHADOW_MULTIPLIER = 1.5f;
    public static RoundRectDrawableWithShadow$RoundRectHelper sRoundRectHelper;
    private boolean mAddPaddingForCorners;
    private ColorStateList mBackground;
    private final RectF mCardBounds;
    private float mCornerRadius;
    private Paint mCornerShadowPaint;
    private Path mCornerShadowPath;
    private boolean mDirty;
    private Paint mEdgeShadowPaint;
    private final int mInsetShadow;
    private Paint mPaint;
    private boolean mPrintedShadowClipWarning;
    private float mRawMaxShadowSize;
    private float mRawShadowSize;
    private final int mShadowEndColor;
    private float mShadowSize;
    private final int mShadowStartColor;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0));
    }

    public RoundRectDrawableWithShadow(Resources resources, ColorStateList colorStateList, float f10, float f11, float f12) {
        float f13;
        int n10;
        boolean bl2;
        this.mDirty = bl2 = true;
        this.mAddPaddingForCorners = bl2;
        this.mPrintedShadowClipWarning = false;
        int n11 = R$color.cardview_shadow_start_color;
        this.mShadowStartColor = n11 = resources.getColor(n11);
        n11 = R$color.cardview_shadow_end_color;
        this.mShadowEndColor = n11 = resources.getColor(n11);
        n11 = R$dimen.cardview_compat_inset_shadow;
        this.mInsetShadow = n10 = resources.getDimensionPixelSize(n11);
        n11 = 5;
        super(n11);
        this.mPaint = resources;
        this.setBackground(colorStateList);
        super(n11);
        this.mCornerShadowPaint = resources;
        colorStateList = Paint.Style.FILL;
        resources.setStyle((Paint.Style)colorStateList);
        this.mCornerRadius = f13 = (float)((int)(f10 + 0.5f));
        super();
        this.mCardBounds = resources;
        colorStateList = this.mCornerShadowPaint;
        super((Paint)colorStateList);
        this.mEdgeShadowPaint = resources;
        resources.setAntiAlias(false);
        this.setShadowSize(f11, f12);
    }

    private void buildComponents(Rect rect) {
        float f10 = this.mRawMaxShadowSize;
        float f11 = 1.5f * f10;
        RectF rectF = this.mCardBounds;
        float f12 = (float)rect.left + f10;
        float f13 = (float)rect.top + f11;
        float f14 = (float)rect.right - f10;
        float f15 = (float)rect.bottom - f11;
        rectF.set(f12, f13, f14, f15);
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        int n10;
        RoundRectDrawableWithShadow roundRectDrawableWithShadow = this;
        float f10 = this.mCornerRadius;
        float f11 = -f10;
        float f12 = -f10;
        RectF rectF = new RectF(f11, f12, f10, f10);
        RectF rectF2 = new RectF(rectF);
        f11 = this.mShadowSize;
        f12 = -f11;
        f11 = -f11;
        rectF2.inset(f12, f11);
        Object object = this.mCornerShadowPath;
        if (object == null) {
            this.mCornerShadowPath = object = new Path();
        } else {
            object.reset();
        }
        object = roundRectDrawableWithShadow.mCornerShadowPath;
        Object object2 = Path.FillType.EVEN_ODD;
        object.setFillType(object2);
        object = roundRectDrawableWithShadow.mCornerShadowPath;
        f12 = -roundRectDrawableWithShadow.mCornerRadius;
        object.moveTo(f12, 0.0f);
        object = roundRectDrawableWithShadow.mCornerShadowPath;
        f12 = -roundRectDrawableWithShadow.mShadowSize;
        object.rLineTo(f12, 0.0f);
        roundRectDrawableWithShadow.mCornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        roundRectDrawableWithShadow.mCornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        roundRectDrawableWithShadow.mCornerShadowPath.close();
        float f13 = roundRectDrawableWithShadow.mCornerRadius;
        f10 = roundRectDrawableWithShadow.mShadowSize + f13;
        rectF2 = roundRectDrawableWithShadow.mCornerShadowPaint;
        f12 = roundRectDrawableWithShadow.mCornerRadius;
        float f14 = roundRectDrawableWithShadow.mShadowSize;
        float f15 = f12 + f14;
        int n11 = 3;
        int[] nArray = new int[n11];
        nArray[0] = n10 = roundRectDrawableWithShadow.mShadowStartColor;
        int n12 = 1;
        nArray[n12] = n10;
        n10 = roundRectDrawableWithShadow.mShadowEndColor;
        int n13 = 2;
        nArray[n13] = n10;
        float[] fArray = new float[n11];
        fArray[0] = 0.0f;
        fArray[n12] = f13 /= f10;
        fArray[n13] = 1.0f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        object = new RadialGradient(0.0f, 0.0f, f15, nArray, fArray, tileMode);
        rectF2.setShader((Shader)object);
        rectF = roundRectDrawableWithShadow.mEdgeShadowPaint;
        f11 = roundRectDrawableWithShadow.mCornerRadius;
        float f16 = -f11;
        f14 = roundRectDrawableWithShadow.mShadowSize;
        float f17 = f16 + f14;
        float f18 = -f11 - f14;
        object = new int[n11];
        int n14 = roundRectDrawableWithShadow.mShadowStartColor;
        object[0] = (Path)n14;
        object[n12] = (Path)n14;
        n14 = roundRectDrawableWithShadow.mShadowEndColor;
        object[n13] = (Path)n14;
        Object object3 = object2 = (Object)new float[n11];
        object3[0] = (Path.FillType)0.0f;
        object3[1] = (Path.FillType)0.5f;
        object3[2] = (Path.FillType)1.0f;
        Shader.TileMode tileMode2 = Shader.TileMode.CLAMP;
        rectF2 = new LinearGradient(0.0f, f17, 0.0f, f18, (int[])object, (float[])object2, tileMode2);
        rectF.setShader((Shader)rectF2);
        roundRectDrawableWithShadow.mEdgeShadowPaint.setAntiAlias(false);
    }

    public static float calculateHorizontalPadding(float f10, float f11, boolean bl2) {
        if (bl2) {
            double d10 = f10;
            double d11 = COS_45;
            double d12 = 1.0 - d11;
            double d13 = f11;
            f10 = (float)(d10 += (d12 *= d13));
        }
        return f10;
    }

    public static float calculateVerticalPadding(float f10, float f11, boolean bl2) {
        float f12 = 1.5f;
        if (bl2) {
            double d10 = f10 * f12;
            double d11 = COS_45;
            double d12 = 1.0 - d11;
            double d13 = f11;
            return (float)(d10 + (d12 *= d13));
        }
        return f10 * f12;
    }

    private void drawShadow(Canvas canvas) {
        Paint paint;
        float f10;
        float f11 = this.mCornerRadius;
        float f12 = -f11;
        float f13 = this.mShadowSize;
        f12 -= f13;
        f13 = this.mInsetShadow;
        f11 += f13;
        f13 = this.mRawShadowSize;
        float f14 = 2.0f;
        RectF rectF = this.mCardBounds;
        f13 = rectF.width();
        float f15 = (f11 += (f13 /= f14)) * f14;
        int n10 = 0;
        f14 = 0.0f;
        RectF rectF2 = null;
        float f16 = (f13 -= f15) - 0.0f;
        float f17 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        boolean bl2 = true;
        float f18 = Float.MIN_VALUE;
        if (f17 > 0) {
            f17 = (float)bl2;
            f13 = f18;
        } else {
            f17 = 0.0f;
            rectF = null;
            f13 = 0.0f;
        }
        RectF rectF3 = this.mCardBounds;
        float f19 = rectF3.height() - f15;
        float f20 = f19 - 0.0f;
        n10 = f20 == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1);
        boolean bl3 = n10 > 0 ? bl2 : false;
        int n11 = canvas.save();
        rectF2 = this.mCardBounds;
        f18 = rectF2.left + f11;
        f14 = rectF2.top + f11;
        canvas.translate(f18, f14);
        rectF2 = this.mCornerShadowPath;
        Paint paint2 = this.mCornerShadowPaint;
        canvas.drawPath((Path)rectF2, paint2);
        if (f17 != false) {
            bl2 = false;
            f18 = 0.0f;
            paint2 = null;
            f19 = this.mCardBounds.width() - f15;
            f14 = this.mCornerRadius;
            f10 = -f14;
            paint = this.mEdgeShadowPaint;
            rectF2 = canvas;
            canvas.drawRect(0.0f, f12, f19, f10, paint);
        }
        canvas.restoreToCount(n11);
        n11 = canvas.save();
        rectF2 = this.mCardBounds;
        f18 = rectF2.right - f11;
        f14 = rectF2.bottom - f11;
        canvas.translate(f18, f14);
        n10 = 0x43340000;
        f14 = 180.0f;
        canvas.rotate(f14);
        rectF2 = this.mCornerShadowPath;
        paint2 = this.mCornerShadowPaint;
        canvas.drawPath((Path)rectF2, paint2);
        if (f17 != false) {
            bl2 = false;
            f18 = 0.0f;
            paint2 = null;
            rectF = this.mCardBounds;
            f19 = rectF.width() - f15;
            f13 = -this.mCornerRadius;
            f14 = this.mShadowSize;
            f10 = f13 + f14;
            paint = this.mEdgeShadowPaint;
            rectF2 = canvas;
            canvas.drawRect(0.0f, f12, f19, f10, paint);
        }
        canvas.restoreToCount(n11);
        f17 = canvas.save();
        rectF2 = this.mCardBounds;
        f18 = rectF2.left + f11;
        f14 = rectF2.bottom - f11;
        canvas.translate(f18, f14);
        n10 = 1132920832;
        f14 = 270.0f;
        canvas.rotate(f14);
        rectF2 = this.mCornerShadowPath;
        paint2 = this.mCornerShadowPaint;
        canvas.drawPath((Path)rectF2, paint2);
        if (bl3) {
            bl2 = false;
            f18 = 0.0f;
            paint2 = null;
            f19 = this.mCardBounds.height() - f15;
            f14 = this.mCornerRadius;
            f10 = -f14;
            paint = this.mEdgeShadowPaint;
            rectF2 = canvas;
            canvas.drawRect(0.0f, f12, f19, f10, paint);
        }
        canvas.restoreToCount((int)f17);
        f17 = canvas.save();
        rectF2 = this.mCardBounds;
        f18 = rectF2.right - f11;
        f14 = rectF2.top + f11;
        canvas.translate(f18, f14);
        f11 = 90.0f;
        canvas.rotate(f11);
        Path path = this.mCornerShadowPath;
        rectF2 = this.mCornerShadowPaint;
        canvas.drawPath(path, (Paint)rectF2);
        if (bl3) {
            bl2 = false;
            f18 = 0.0f;
            paint2 = null;
            path = this.mCardBounds;
            f19 = path.height() - f15;
            f11 = this.mCornerRadius;
            f10 = -f11;
            paint = this.mEdgeShadowPaint;
            rectF2 = canvas;
            canvas.drawRect(0.0f, f12, f19, f10, paint);
        }
        canvas.restoreToCount((int)f17);
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

    private void setShadowSize(float f10, float f11) {
        int n10 = 0;
        float f12 = 0.0f;
        StringBuilder stringBuilder = null;
        float f13 = f10 - 0.0f;
        float f14 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        String string2 = ". Must be >= 0";
        if (f14 >= 0) {
            float f15 = f11 - 0.0f;
            n10 = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
            if (n10 >= 0) {
                float f16;
                float f17;
                int n11 = this.toEven(f10);
                f10 = n11;
                int n12 = this.toEven(f11);
                f11 = n12;
                n10 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                f14 = 1.0f;
                if (n10 > 0) {
                    n11 = this.mPrintedShadowClipWarning ? 1 : 0;
                    if (n11 == 0) {
                        this.mPrintedShadowClipWarning = f14;
                    }
                    f10 = f11;
                }
                if ((n10 = (int)((f17 = (f12 = this.mRawShadowSize) - f10) == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1))) == 0 && (n10 = (int)((f16 = (f12 = this.mRawMaxShadowSize) - f11) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) == 0) {
                    return;
                }
                this.mRawShadowSize = f10;
                this.mRawMaxShadowSize = f11;
                f10 *= 1.5f;
                f11 = this.mInsetShadow;
                this.mShadowSize = f10 = (float)((int)(f10 + f11 + 0.5f));
                this.mDirty = f14;
                this.invalidateSelf();
                return;
            }
            stringBuilder = new StringBuilder();
            stringBuilder.append("Invalid max shadow size ");
            stringBuilder.append(f11);
            stringBuilder.append(string2);
            String string3 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            throw illegalArgumentException;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid shadow size ");
        stringBuilder.append(f10);
        stringBuilder.append(string2);
        String string4 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string4);
        throw illegalArgumentException;
    }

    private int toEven(float f10) {
        float f11 = 0.5f;
        int n10 = (int)(f10 += f11);
        int n11 = n10 % 2;
        int n12 = 1;
        if (n11 == n12) {
            n10 -= n12;
        }
        return n10;
    }

    public void draw(Canvas canvas) {
        float f10;
        Object object;
        boolean bl2 = this.mDirty;
        if (bl2) {
            object = this.getBounds();
            this.buildComponents((Rect)object);
            bl2 = false;
            f10 = 0.0f;
            object = null;
            this.mDirty = false;
        }
        f10 = this.mRawShadowSize;
        float f11 = 2.0f;
        canvas.translate(0.0f, f10 /= f11);
        this.drawShadow(canvas);
        f10 = -this.mRawShadowSize / f11;
        canvas.translate(0.0f, f10);
        object = sRoundRectHelper;
        RectF rectF = this.mCardBounds;
        float f12 = this.mCornerRadius;
        Paint paint = this.mPaint;
        object.drawRoundRect(canvas, rectF, f12, paint);
    }

    public ColorStateList getColor() {
        return this.mBackground;
    }

    public float getCornerRadius() {
        return this.mCornerRadius;
    }

    public void getMaxShadowAndCornerPadding(Rect rect) {
        this.getPadding(rect);
    }

    public float getMaxShadowSize() {
        return this.mRawMaxShadowSize;
    }

    public float getMinHeight() {
        float f10 = this.mRawMaxShadowSize;
        float f11 = this.mCornerRadius;
        float f12 = this.mInsetShadow;
        f11 += f12;
        f12 = 1.5f;
        float f13 = f10 * f12;
        float f14 = 2.0f;
        f10 = Math.max(f10, f11 += (f13 /= f14)) * f14;
        f11 = this.mRawMaxShadowSize * f12;
        f12 = this.mInsetShadow;
        f11 = (f11 + f12) * f14;
        return f10 + f11;
    }

    public float getMinWidth() {
        float f10 = this.mRawMaxShadowSize;
        float f11 = this.mCornerRadius;
        float f12 = this.mInsetShadow;
        f11 += f12;
        f12 = 2.0f;
        float f13 = f10 / f12;
        f10 = Math.max(f10, f11 += f13) * f12;
        f11 = this.mRawMaxShadowSize;
        f13 = this.mInsetShadow;
        f11 = (f11 + f13) * f12;
        return f10 + f11;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        float f10 = this.mRawMaxShadowSize;
        float f11 = this.mCornerRadius;
        boolean bl2 = this.mAddPaddingForCorners;
        int n10 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateVerticalPadding(f10, f11, bl2));
        f11 = this.mRawMaxShadowSize;
        float f12 = this.mCornerRadius;
        boolean bl3 = this.mAddPaddingForCorners;
        int n11 = (int)Math.ceil(RoundRectDrawableWithShadow.calculateHorizontalPadding(f11, f12, bl3));
        rect.set(n11, n10, n11, n10);
        return true;
    }

    public float getShadowSize() {
        return this.mRawShadowSize;
    }

    public boolean isStateful() {
        boolean bl2;
        ColorStateList colorStateList = this.mBackground;
        if (colorStateList != null && (bl2 = colorStateList.isStateful()) || (bl2 = super.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return bl2;
    }

    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.mDirty = true;
    }

    public boolean onStateChange(int[] nArray) {
        ColorStateList colorStateList = this.mBackground;
        int n10 = colorStateList.getDefaultColor();
        int n11 = colorStateList.getColorForState(nArray, n10);
        colorStateList = this.mPaint;
        int n12 = colorStateList.getColor();
        if (n12 == n11) {
            return false;
        }
        this.mPaint.setColor(n11);
        this.mDirty = n11 = 1;
        this.invalidateSelf();
        return n11;
    }

    public void setAddPaddingForCorners(boolean bl2) {
        this.mAddPaddingForCorners = bl2;
        this.invalidateSelf();
    }

    public void setAlpha(int n10) {
        this.mPaint.setAlpha(n10);
        this.mCornerShadowPaint.setAlpha(n10);
        this.mEdgeShadowPaint.setAlpha(n10);
    }

    public void setColor(ColorStateList colorStateList) {
        this.setBackground(colorStateList);
        this.invalidateSelf();
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.mPaint.setColorFilter(colorFilter);
    }

    public void setCornerRadius(float f10) {
        float f11 = 0.0f;
        IllegalArgumentException illegalArgumentException = null;
        float f12 = f10 - 0.0f;
        float f13 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (f13 >= 0) {
            f11 = this.mCornerRadius;
            int n10 = (int)(f10 + 0.5f);
            float f14 = f11 - (f10 = (float)n10);
            f13 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (f13 == false) {
                return;
            }
            this.mCornerRadius = f10;
            this.mDirty = true;
            this.invalidateSelf();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Invalid radius ");
        stringBuilder.append(f10);
        stringBuilder.append(". Must be >= 0");
        String string2 = stringBuilder.toString();
        illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void setMaxShadowSize(float f10) {
        float f11 = this.mRawShadowSize;
        this.setShadowSize(f11, f10);
    }

    public void setShadowSize(float f10) {
        float f11 = this.mRawMaxShadowSize;
        this.setShadowSize(f10, f11);
    }
}

