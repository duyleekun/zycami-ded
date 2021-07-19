/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.graphics.drawable.Drawable$Callback
 *  android.graphics.drawable.GradientDrawable
 *  android.os.Build$VERSION
 *  android.view.View
 */
package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

public class CutoutDrawable
extends GradientDrawable {
    private final RectF cutoutBounds;
    private final Paint cutoutPaint;
    private int savedLayer;

    public CutoutDrawable() {
        Paint paint;
        this.cutoutPaint = paint = new Paint(1);
        this.setPaintStyles();
        this.cutoutBounds = paint;
    }

    private void postDraw(Canvas canvas) {
        Drawable.Callback callback = this.getCallback();
        int n10 = this.useHardwareLayer(callback);
        if (n10 == 0) {
            n10 = this.savedLayer;
            canvas.restoreToCount(n10);
        }
    }

    private void preDraw(Canvas canvas) {
        Drawable.Callback callback = this.getCallback();
        boolean bl2 = this.useHardwareLayer(callback);
        if (bl2) {
            callback = (View)callback;
            int n10 = 2;
            bl2 = false;
            callback.setLayerType(n10, null);
        } else {
            this.saveCanvasLayer(canvas);
        }
    }

    private void saveCanvasLayer(Canvas canvas) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            int n12;
            float f10 = 0.0f;
            float f11 = 0.0f;
            float f12 = canvas.getWidth();
            n10 = canvas.getHeight();
            float f13 = n10;
            this.savedLayer = n12 = canvas.saveLayer(0.0f, 0.0f, f12, f13, null);
        } else {
            int n13;
            n11 = 0;
            float f14 = canvas.getWidth();
            n10 = canvas.getHeight();
            float f15 = n10;
            float f16 = 0.0f;
            int n14 = 31;
            float f17 = 4.3E-44f;
            this.savedLayer = n13 = canvas.saveLayer(0.0f, 0.0f, f14, f15, null, n14);
        }
    }

    private void setPaintStyles() {
        Paint paint = this.cutoutPaint;
        Paint.Style style2 = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style2);
        this.cutoutPaint.setColor(-1);
        paint = this.cutoutPaint;
        PorterDuff.Mode mode = PorterDuff.Mode.DST_OUT;
        style2 = new PorterDuffXfermode(mode);
        paint.setXfermode((Xfermode)style2);
    }

    private boolean useHardwareLayer(Drawable.Callback callback) {
        return callback instanceof View;
    }

    public void draw(Canvas canvas) {
        this.preDraw(canvas);
        super.draw(canvas);
        RectF rectF = this.cutoutBounds;
        Paint paint = this.cutoutPaint;
        canvas.drawRect(rectF, paint);
        this.postDraw(canvas);
    }

    public boolean hasCutout() {
        return this.cutoutBounds.isEmpty() ^ true;
    }

    public void removeCutout() {
        this.setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void setCutout(float f10, float f11, float f12, float f13) {
        float f14;
        float f15;
        float f16;
        RectF rectF = this.cutoutBounds;
        float f17 = rectF.left;
        float f18 = f10 - f17;
        Object object = f18 == 0.0f ? 0 : (f18 > 0.0f ? 1 : -1);
        if (object != false || (object = (f16 = f11 - (f17 = rectF.top)) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1)) != false || (object = (f15 = f12 - (f17 = rectF.right)) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) != false || (object = (f14 = f13 - (f17 = rectF.bottom)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) != false) {
            rectF.set(f10, f11, f12, f13);
            this.invalidateSelf();
        }
    }

    public void setCutout(RectF rectF) {
        float f10 = rectF.left;
        float f11 = rectF.top;
        float f12 = rectF.right;
        float f13 = rectF.bottom;
        this.setCutout(f10, f11, f12, f13);
    }
}

