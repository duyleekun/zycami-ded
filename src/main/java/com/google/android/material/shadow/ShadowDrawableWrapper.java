/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
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
package com.google.android.material.shadow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.appcompat.graphics.drawable.DrawableWrapper;
import androidx.core.content.ContextCompat;
import com.google.android.material.R$color;

public class ShadowDrawableWrapper
extends DrawableWrapper {
    public static final double COS_45 = 0.0;
    public static final float SHADOW_BOTTOM_SCALE = 1.0f;
    public static final float SHADOW_HORIZ_SCALE = 0.5f;
    public static final float SHADOW_MULTIPLIER = 1.5f;
    public static final float SHADOW_TOP_SCALE = 0.25f;
    private boolean addPaddingForCorners;
    public final RectF contentBounds;
    public float cornerRadius;
    public final Paint cornerShadowPaint;
    public Path cornerShadowPath;
    private boolean dirty;
    public final Paint edgeShadowPaint;
    public float maxShadowSize;
    private boolean printedShadowClipWarning;
    public float rawMaxShadowSize;
    public float rawShadowSize;
    private float rotation;
    private final int shadowEndColor;
    private final int shadowMiddleColor;
    public float shadowSize;
    private final int shadowStartColor;

    static {
        COS_45 = Math.cos(Math.toRadians(45.0));
    }

    public ShadowDrawableWrapper(Context context, Drawable drawable2, float f10, float f11, float f12) {
        super(drawable2);
        RectF rectF;
        int n10;
        boolean bl2;
        this.dirty = bl2 = true;
        this.addPaddingForCorners = bl2;
        this.printedShadowClipWarning = false;
        int n11 = R$color.design_fab_shadow_start_color;
        this.shadowStartColor = n11 = ContextCompat.getColor(context, n11);
        n11 = R$color.design_fab_shadow_mid_color;
        this.shadowMiddleColor = n11 = ContextCompat.getColor(context, n11);
        n11 = R$color.design_fab_shadow_end_color;
        this.shadowEndColor = n10 = ContextCompat.getColor(context, n11);
        super(5);
        this.cornerShadowPaint = context;
        Paint.Style style2 = Paint.Style.FILL;
        context.setStyle(style2);
        this.cornerRadius = f10 = (float)Math.round(f10);
        this.contentBounds = rectF = new RectF();
        super((Paint)context);
        this.edgeShadowPaint = rectF;
        rectF.setAntiAlias(false);
        this.setShadowSize(f11, f12);
    }

    private void buildComponents(Rect rect) {
        float f10 = this.rawMaxShadowSize;
        float f11 = 1.5f * f10;
        RectF rectF = this.contentBounds;
        float f12 = (float)rect.left + f10;
        float f13 = (float)rect.top + f11;
        float f14 = (float)rect.right - f10;
        float f15 = (float)rect.bottom - f11;
        rectF.set(f12, f13, f14, f15);
        rect = this.getWrappedDrawable();
        RectF rectF2 = this.contentBounds;
        int n10 = (int)rectF2.left;
        int n11 = (int)rectF2.top;
        int n12 = (int)rectF2.right;
        int n13 = (int)rectF2.bottom;
        rect.setBounds(n10, n11, n12, n13);
        this.buildShadowCorners();
    }

    private void buildShadowCorners() {
        float[] fArray;
        int n10;
        ShadowDrawableWrapper shadowDrawableWrapper = this;
        float f10 = this.cornerRadius;
        float f11 = -f10;
        float f12 = -f10;
        RectF rectF = new RectF(f11, f12, f10, f10);
        RectF rectF2 = new RectF(rectF);
        f11 = this.shadowSize;
        f12 = -f11;
        f11 = -f11;
        rectF2.inset(f12, f11);
        Path path = this.cornerShadowPath;
        if (path == null) {
            this.cornerShadowPath = path = new Path();
        } else {
            path.reset();
        }
        path = shadowDrawableWrapper.cornerShadowPath;
        Path.FillType fillType = Path.FillType.EVEN_ODD;
        path.setFillType(fillType);
        path = shadowDrawableWrapper.cornerShadowPath;
        f12 = -shadowDrawableWrapper.cornerRadius;
        Object object = null;
        path.moveTo(f12, 0.0f);
        path = shadowDrawableWrapper.cornerShadowPath;
        f12 = -shadowDrawableWrapper.shadowSize;
        path.rLineTo(f12, 0.0f);
        shadowDrawableWrapper.cornerShadowPath.arcTo(rectF2, 180.0f, 90.0f, false);
        shadowDrawableWrapper.cornerShadowPath.arcTo(rectF, 270.0f, -90.0f, false);
        path = shadowDrawableWrapper.cornerShadowPath;
        path.close();
        f11 = rectF2.top;
        float f13 = -f11;
        float f14 = f13 - 0.0f;
        float f15 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        int n11 = 2;
        f12 = 2.8E-45f;
        int n12 = 1;
        int n13 = 3;
        if (f15 > 0) {
            Object object2;
            f11 = shadowDrawableWrapper.cornerRadius / f13;
            float f16 = 1.0f;
            float f17 = (f16 - f11) / 2.0f + f11;
            Paint paint = shadowDrawableWrapper.cornerShadowPaint;
            int n14 = 4;
            int[] nArray = new int[n14];
            nArray[0] = 0;
            nArray[n12] = n10 = shadowDrawableWrapper.shadowStartColor;
            nArray[n11] = n10 = shadowDrawableWrapper.shadowMiddleColor;
            nArray[n13] = n10 = shadowDrawableWrapper.shadowEndColor;
            Object[] objectArray = new float[n14];
            objectArray[0] = 0.0f;
            objectArray[n12] = f11;
            objectArray[n11] = f17;
            f15 = 1065353216;
            objectArray[n13] = f11 = 1.0f;
            path = Shader.TileMode.CLAMP;
            RadialGradient radialGradient = object2;
            f17 = 0.0f;
            int[] nArray2 = nArray;
            nArray = null;
            object = objectArray;
            objectArray = nArray2;
            fillType = object2;
            object2 = object;
            object = paint;
            paint = path;
            radialGradient(0.0f, 0.0f, f13, nArray2, (float[])object2, (Shader.TileMode)path);
            object.setShader((Shader)radialGradient);
        }
        path = shadowDrawableWrapper.edgeShadowPaint;
        float f18 = rectF.top;
        f10 = rectF2.top;
        object = new int[n13];
        object[0] = n10 = shadowDrawableWrapper.shadowStartColor;
        object[n12] = n10 = shadowDrawableWrapper.shadowMiddleColor;
        object[2] = n12 = shadowDrawableWrapper.shadowEndColor;
        float[] fArray2 = fArray = new float[n13];
        fArray[0] = 0.0f;
        fArray2[1] = 0.5f;
        fArray2[2] = 1.0f;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        fillType = new LinearGradient(0.0f, f18, 0.0f, f10, object, fArray, tileMode);
        path.setShader((Shader)fillType);
        shadowDrawableWrapper.edgeShadowPaint.setAntiAlias(false);
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
        float f10;
        Paint paint;
        float f11;
        int n10;
        float f12;
        Paint paint2;
        int n11;
        ShadowDrawableWrapper shadowDrawableWrapper = this;
        Canvas canvas2 = canvas;
        int n12 = canvas.save();
        float f13 = this.rotation;
        float f14 = this.contentBounds.centerX();
        RectF rectF = this.contentBounds;
        float f15 = rectF.centerY();
        canvas.rotate(f13, f14, f15);
        float f16 = this.cornerRadius;
        f13 = -f16;
        f14 = this.shadowSize;
        float f17 = f13 - f14;
        RectF rectF2 = this.contentBounds;
        f13 = rectF2.width();
        float f18 = f16 * 2.0f;
        f14 = 0.0f;
        Paint paint3 = null;
        float f19 = (f13 -= f18) - 0.0f;
        float f20 = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
        int n13 = 1;
        f15 = Float.MIN_VALUE;
        int n14 = 0;
        float f21 = 0.0f;
        if (f20 > 0) {
            n11 = n13;
        } else {
            n11 = 0;
            paint2 = null;
        }
        rectF2 = shadowDrawableWrapper.contentBounds;
        f13 = rectF2.height() - f18;
        float f22 = f13 - 0.0f;
        f20 = f22 == 0.0f ? 0 : (f22 > 0.0f ? 1 : -1);
        int n15 = f20 > 0 ? n13 : 0;
        f13 = shadowDrawableWrapper.rawShadowSize;
        f14 = 0.25f * f13;
        f14 = f13 - f14;
        n13 = 0x3F000000;
        f15 = 0.5f * f13;
        f15 = f13 - f15;
        int n16 = 1065353216;
        float f23 = 1.0f;
        f21 = f13 * f23;
        f13 -= f21;
        float f24 = f16 / (f15 += f16);
        float f25 = f16 / (f14 += f16);
        float f26 = f16 / (f13 += f16);
        n14 = canvas.save();
        rectF2 = shadowDrawableWrapper.contentBounds;
        f14 = rectF2.left + f16;
        f13 = rectF2.top + f16;
        canvas2.translate(f14, f13);
        canvas2.scale(f24, f25);
        rectF2 = shadowDrawableWrapper.cornerShadowPath;
        paint3 = shadowDrawableWrapper.cornerShadowPaint;
        canvas2.drawPath((Path)rectF2, paint3);
        if (n11 != 0) {
            f13 = f23 / f24;
            canvas2.scale(f13, f23);
            f14 = 0.0f;
            paint3 = null;
            float f27 = shadowDrawableWrapper.contentBounds.width() - f18;
            f13 = shadowDrawableWrapper.cornerRadius;
            f15 = -f13;
            Paint paint4 = shadowDrawableWrapper.edgeShadowPaint;
            rectF2 = canvas;
            float f28 = f15;
            f15 = f17;
            n16 = n14;
            f21 = f27;
            f12 = f26;
            f26 = f28;
            n10 = n12;
            f11 = f25;
            paint = paint4;
            canvas.drawRect(0.0f, f17, f27, f28, paint4);
        } else {
            n16 = n14;
            f12 = f26;
            n10 = n12;
            f11 = f25;
        }
        canvas2.restoreToCount(n16);
        n16 = canvas.save();
        rectF2 = shadowDrawableWrapper.contentBounds;
        f14 = rectF2.right - f16;
        f13 = rectF2.bottom - f16;
        canvas2.translate(f14, f13);
        f25 = f12;
        canvas2.scale(f24, f12);
        f20 = 0x43340000;
        f13 = 180.0f;
        canvas2.rotate(f13);
        rectF2 = shadowDrawableWrapper.cornerShadowPath;
        paint3 = shadowDrawableWrapper.cornerShadowPaint;
        canvas2.drawPath((Path)rectF2, paint3);
        if (n11 != 0) {
            f20 = 1065353216;
            f13 = 1.0f;
            f14 = f13 / f24;
            canvas2.scale(f14, f13);
            f14 = 0.0f;
            paint3 = null;
            f21 = shadowDrawableWrapper.contentBounds.width() - f18;
            f13 = -shadowDrawableWrapper.cornerRadius;
            f15 = shadowDrawableWrapper.shadowSize;
            f26 = f13 + f15;
            paint2 = shadowDrawableWrapper.edgeShadowPaint;
            rectF2 = canvas;
            f15 = f17;
            f10 = f11;
            f11 = f12;
            paint = paint2;
            canvas.drawRect(0.0f, f17, f21, f26, paint2);
        } else {
            f10 = f11;
            f11 = f12;
        }
        canvas2.restoreToCount(n16);
        n11 = canvas.save();
        rectF2 = shadowDrawableWrapper.contentBounds;
        f14 = rectF2.left + f16;
        f13 = rectF2.bottom - f16;
        canvas2.translate(f14, f13);
        canvas2.scale(f24, f11);
        f20 = 1132920832;
        f13 = 270.0f;
        canvas2.rotate(f13);
        rectF2 = shadowDrawableWrapper.cornerShadowPath;
        paint3 = shadowDrawableWrapper.cornerShadowPaint;
        canvas2.drawPath((Path)rectF2, paint3);
        if (n15 != 0) {
            f20 = 1065353216;
            f13 = 1.0f;
            f23 = f13 / f11;
            canvas2.scale(f23, f13);
            f14 = 0.0f;
            paint3 = null;
            f21 = shadowDrawableWrapper.contentBounds.height() - f18;
            f13 = shadowDrawableWrapper.cornerRadius;
            f26 = -f13;
            paint = shadowDrawableWrapper.edgeShadowPaint;
            rectF2 = canvas;
            f15 = f17;
            canvas.drawRect(0.0f, f17, f21, f26, paint);
        }
        canvas2.restoreToCount(n11);
        n12 = canvas.save();
        rectF2 = shadowDrawableWrapper.contentBounds;
        f14 = rectF2.right - f16;
        f13 = rectF2.top + f16;
        canvas2.translate(f14, f13);
        f16 = f10;
        canvas2.scale(f24, f10);
        f20 = 1119092736;
        f13 = 90.0f;
        canvas2.rotate(f13);
        rectF2 = shadowDrawableWrapper.cornerShadowPath;
        paint3 = shadowDrawableWrapper.cornerShadowPaint;
        canvas2.drawPath((Path)rectF2, paint3);
        if (n15 != 0) {
            f20 = 1065353216;
            f13 = 1.0f;
            f23 = f13 / f10;
            canvas2.scale(f23, f13);
            f14 = 0.0f;
            paint3 = null;
            f21 = shadowDrawableWrapper.contentBounds.height() - f18;
            f13 = shadowDrawableWrapper.cornerRadius;
            f26 = -f13;
            paint = shadowDrawableWrapper.edgeShadowPaint;
            rectF2 = canvas;
            f15 = f17;
            canvas.drawRect(0.0f, f17, f21, f26, paint);
        }
        canvas2.restoreToCount(n12);
        f20 = n10;
        canvas2.restoreToCount(n10);
    }

    private static int toEven(float f10) {
        int n10;
        int n11 = Math.round(f10);
        int n12 = n11 % 2;
        if (n12 == (n10 = 1)) {
            n11 += -1;
        }
        return n11;
    }

    public void draw(Canvas canvas) {
        boolean bl2 = this.dirty;
        if (bl2) {
            Rect rect = this.getBounds();
            this.buildComponents(rect);
            bl2 = false;
            rect = null;
            this.dirty = false;
        }
        this.drawShadow(canvas);
        super.draw(canvas);
    }

    public float getCornerRadius() {
        return this.cornerRadius;
    }

    public float getMaxShadowSize() {
        return this.rawMaxShadowSize;
    }

    public float getMinHeight() {
        float f10 = this.rawMaxShadowSize;
        float f11 = this.cornerRadius;
        float f12 = 1.5f;
        float f13 = f10 * f12;
        float f14 = 2.0f;
        f10 = Math.max(f10, f11 += (f13 /= f14)) * f14;
        f11 = this.rawMaxShadowSize * f12 * f14;
        return f10 + f11;
    }

    public float getMinWidth() {
        float f10 = this.rawMaxShadowSize;
        float f11 = this.cornerRadius;
        float f12 = 2.0f;
        float f13 = f10 / f12;
        f10 = Math.max(f10, f11 += f13) * f12;
        f11 = this.rawMaxShadowSize * f12;
        return f10 + f11;
    }

    public int getOpacity() {
        return -3;
    }

    public boolean getPadding(Rect rect) {
        float f10 = this.rawMaxShadowSize;
        float f11 = this.cornerRadius;
        boolean bl2 = this.addPaddingForCorners;
        int n10 = (int)Math.ceil(ShadowDrawableWrapper.calculateVerticalPadding(f10, f11, bl2));
        f11 = this.rawMaxShadowSize;
        float f12 = this.cornerRadius;
        boolean bl3 = this.addPaddingForCorners;
        int n11 = (int)Math.ceil(ShadowDrawableWrapper.calculateHorizontalPadding(f11, f12, bl3));
        rect.set(n11, n10, n11, n10);
        return true;
    }

    public float getShadowSize() {
        return this.rawShadowSize;
    }

    public void onBoundsChange(Rect rect) {
        this.dirty = true;
    }

    public void setAddPaddingForCorners(boolean bl2) {
        this.addPaddingForCorners = bl2;
        this.invalidateSelf();
    }

    public void setAlpha(int n10) {
        super.setAlpha(n10);
        this.cornerShadowPaint.setAlpha(n10);
        this.edgeShadowPaint.setAlpha(n10);
    }

    public void setCornerRadius(float f10) {
        float f11 = this.cornerRadius;
        int n10 = Math.round(f10);
        float f12 = f11 - (f10 = (float)n10);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            return;
        }
        this.cornerRadius = f10;
        this.dirty = true;
        this.invalidateSelf();
    }

    public void setMaxShadowSize(float f10) {
        float f11 = this.rawShadowSize;
        this.setShadowSize(f11, f10);
    }

    public final void setRotation(float f10) {
        float f11 = this.rotation;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.rotation = f10;
            this.invalidateSelf();
        }
    }

    public void setShadowSize(float f10) {
        float f11 = this.rawMaxShadowSize;
        this.setShadowSize(f10, f11);
    }

    public void setShadowSize(float f10, float f11) {
        float f12;
        int n10 = 0;
        float f13 = 0.0f;
        float f14 = f10 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object >= 0 && (n10 = (f12 = f11 - 0.0f) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) >= 0) {
            float f15;
            float f16;
            int n11 = ShadowDrawableWrapper.toEven(f10);
            f10 = n11;
            int n12 = ShadowDrawableWrapper.toEven(f11);
            f11 = n12;
            n10 = (int)(f10 == f11 ? 0 : (f10 > f11 ? 1 : -1));
            object = true;
            if (n10 > 0) {
                n11 = (int)(this.printedShadowClipWarning ? 1 : 0);
                if (n11 == 0) {
                    this.printedShadowClipWarning = object;
                }
                f10 = f11;
            }
            if ((n10 = (int)((f16 = (f13 = this.rawShadowSize) - f10) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) == 0 && (n10 = (int)((f15 = (f13 = this.rawMaxShadowSize) - f11) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1))) == 0) {
                return;
            }
            this.rawShadowSize = f10;
            this.rawMaxShadowSize = f11;
            this.shadowSize = f10 = (float)Math.round(f10 * 1.5f);
            this.maxShadowSize = f11;
            this.dirty = object;
            this.invalidateSelf();
            return;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid shadow size");
        throw illegalArgumentException;
    }
}

