/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.ColorStateList
 *  android.graphics.Canvas
 *  android.graphics.ColorFilter
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.Drawable$ConstantState
 */
package com.google.android.material.internal;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.internal.CircularBorderDrawable$CircularBorderState;

public class CircularBorderDrawable
extends Drawable {
    private static final float DRAW_STROKE_WIDTH_MULTIPLE = 1.3333f;
    private ColorStateList borderTint;
    public float borderWidth;
    private int bottomInnerStrokeColor;
    private int bottomOuterStrokeColor;
    private int currentBorderTintColor;
    private boolean invalidateShader;
    public final Paint paint;
    public final Rect rect;
    public final RectF rectF;
    private float rotation;
    public final CircularBorderDrawable$CircularBorderState state;
    private int topInnerStrokeColor;
    private int topOuterStrokeColor;

    public CircularBorderDrawable() {
        Paint paint;
        Object object;
        this.rect = object = new Rect();
        this.rectF = object;
        super(this, null);
        this.state = object;
        int n10 = 1;
        this.invalidateShader = n10;
        this.paint = paint = new Paint(n10);
        object = Paint.Style.STROKE;
        paint.setStyle((Paint.Style)object);
    }

    private Shader createGradientShader() {
        float f10;
        Rect rect = this.rect;
        this.copyBounds(rect);
        float f11 = this.borderWidth;
        float f12 = rect.height();
        int n10 = 6;
        int[] nArray = new int[n10];
        int n11 = this.topOuterStrokeColor;
        int n12 = this.currentBorderTintColor;
        nArray[0] = n11 = ColorUtils.compositeColors(n11, n12);
        n11 = this.topInnerStrokeColor;
        int n13 = this.currentBorderTintColor;
        n11 = ColorUtils.compositeColors(n11, n13);
        n13 = 1;
        nArray[n13] = n11;
        n11 = ColorUtils.setAlphaComponent(this.topInnerStrokeColor, 0);
        int n14 = this.currentBorderTintColor;
        n11 = ColorUtils.compositeColors(n11, n14);
        n14 = 2;
        nArray[n14] = n11;
        n11 = ColorUtils.setAlphaComponent(this.bottomInnerStrokeColor, 0);
        int n15 = this.currentBorderTintColor;
        n11 = ColorUtils.compositeColors(n11, n15);
        n15 = 3;
        nArray[n15] = n11;
        n11 = this.bottomInnerStrokeColor;
        int n16 = this.currentBorderTintColor;
        n11 = ColorUtils.compositeColors(n11, n16);
        n16 = 4;
        nArray[n16] = n11;
        n11 = this.bottomOuterStrokeColor;
        int n17 = this.currentBorderTintColor;
        n11 = ColorUtils.compositeColors(n11, n17);
        n17 = 5;
        nArray[n17] = n11;
        float[] fArray = new float[n10];
        fArray[0] = 0.0f;
        fArray[n13] = f11 /= f12;
        fArray[n14] = f10 = 0.5f;
        fArray[n15] = f10;
        f10 = 1.0f;
        fArray[n16] = f11 = f10 - f11;
        fArray[n17] = f10;
        float f13 = rect.top;
        float f14 = rect.bottom;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        LinearGradient linearGradient = new LinearGradient(0.0f, f13, 0.0f, f14, nArray, fArray, tileMode);
        return linearGradient;
    }

    public void draw(Canvas canvas) {
        float f10;
        float f11;
        Shader shader;
        Paint paint;
        boolean bl2 = this.invalidateShader;
        if (bl2) {
            paint = this.paint;
            shader = this.createGradientShader();
            paint.setShader(shader);
            bl2 = false;
            f11 = 0.0f;
            paint = null;
            this.invalidateShader = false;
        }
        f11 = this.paint.getStrokeWidth() / 2.0f;
        shader = this.rectF;
        Rect rect = this.rect;
        this.copyBounds(rect);
        rect = this.rect;
        shader.set(rect);
        shader.left = f10 = shader.left + f11;
        shader.top = f10 = shader.top + f11;
        shader.right = f10 = shader.right - f11;
        shader.bottom = f10 = shader.bottom - f11;
        canvas.save();
        f11 = this.rotation;
        f10 = shader.centerX();
        float f12 = shader.centerY();
        canvas.rotate(f11, f10, f12);
        paint = this.paint;
        canvas.drawOval((RectF)shader, paint);
        canvas.restore();
    }

    public Drawable.ConstantState getConstantState() {
        return this.state;
    }

    public int getOpacity() {
        float f10 = this.borderWidth;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object > 0) {
            object = -3;
            f10 = 0.0f / 0.0f;
        } else {
            object = -2;
            f10 = 0.0f / 0.0f;
        }
        return (int)object;
    }

    public boolean getPadding(Rect rect) {
        int n10 = Math.round(this.borderWidth);
        rect.set(n10, n10, n10, n10);
        return true;
    }

    public boolean isStateful() {
        boolean bl2;
        ColorStateList colorStateList = this.borderTint;
        if (colorStateList != null && (bl2 = colorStateList.isStateful()) || (bl2 = super.isStateful())) {
            bl2 = true;
        } else {
            bl2 = false;
            colorStateList = null;
        }
        return bl2;
    }

    public void onBoundsChange(Rect rect) {
        this.invalidateShader = true;
    }

    public boolean onStateChange(int[] nArray) {
        int n10;
        int n11;
        int n12;
        ColorStateList colorStateList = this.borderTint;
        if (colorStateList != null && (n12 = colorStateList.getColorForState(nArray, n11 = this.currentBorderTintColor)) != (n10 = this.currentBorderTintColor)) {
            n10 = 1;
            this.invalidateShader = n10;
            this.currentBorderTintColor = n12;
        }
        if ((n12 = this.invalidateShader) != 0) {
            this.invalidateSelf();
        }
        return this.invalidateShader;
    }

    public void setAlpha(int n10) {
        this.paint.setAlpha(n10);
        this.invalidateSelf();
    }

    public void setBorderTint(ColorStateList colorStateList) {
        if (colorStateList != null) {
            int n10;
            int[] nArray = this.getState();
            int n11 = this.currentBorderTintColor;
            this.currentBorderTintColor = n10 = colorStateList.getColorForState(nArray, n11);
        }
        this.borderTint = colorStateList;
        this.invalidateShader = true;
        this.invalidateSelf();
    }

    public void setBorderWidth(float f10) {
        float f11 = this.borderWidth;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.borderWidth = f10;
            Paint paint = this.paint;
            float f13 = 1.3333f;
            paint.setStrokeWidth(f10 *= f13);
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            this.invalidateShader = bl2;
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        this.invalidateSelf();
    }

    public void setGradientColors(int n10, int n11, int n12, int n13) {
        this.topOuterStrokeColor = n10;
        this.topInnerStrokeColor = n11;
        this.bottomOuterStrokeColor = n12;
        this.bottomInnerStrokeColor = n13;
    }

    public final void setRotation(float f10) {
        float f11 = this.rotation;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.rotation = f10;
            this.invalidateSelf();
        }
    }
}

