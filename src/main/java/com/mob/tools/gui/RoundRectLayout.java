/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.widget.RelativeLayout
 */
package com.mob.tools.gui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class RoundRectLayout
extends RelativeLayout {
    private Path path;
    private float[] rect;

    public RoundRectLayout(Context context) {
        super(context);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RoundRectLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void dispatchDraw(Canvas canvas) {
        Object object = this.rect;
        if (object != null) {
            object = this.path;
            if (object == null) {
                Path path;
                int n10 = this.getWidth();
                int n11 = this.getHeight();
                this.path = path = new Path();
                float f10 = n10;
                float f11 = n11;
                path = new RectF(0.0f, 0.0f, f10, f11);
                object = this.path;
                float[] fArray = this.rect;
                Path.Direction direction = Path.Direction.CW;
                object.addRoundRect((RectF)path, fArray, direction);
            }
            object = this.path;
            canvas.clipPath((Path)object);
        }
        super.dispatchDraw(canvas);
    }

    public void setRound(float f10) {
        this.setRound(f10, f10, f10, f10);
    }

    public void setRound(float f10, float f11, float f12, float f13) {
        float[] fArray = new float[]{f10, f10, f11, f11, f12, f12, f13, f13};
        this.rect = fArray;
    }
}

