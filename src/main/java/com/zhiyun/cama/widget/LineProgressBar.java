/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import d.v.e.l.o1;

public class LineProgressBar
extends View {
    private Paint a;
    private int b;
    private int c;
    private int d;
    private int e;
    private boolean f;

    public LineProgressBar(Context context) {
        this(context, null);
    }

    public LineProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LineProgressBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int[] nArray = R$styleable.LineProgressBar;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        int n11 = o1.c(context.getResources(), 2131099772);
        this.b = n11 = attributeSet.getColor(0, n11);
        n11 = (int)(attributeSet.getBoolean(1, false) ? 1 : 0);
        this.f = n11;
        attributeSet.recycle();
        this.b();
    }

    private void a(Canvas canvas) {
        RectF rectF = new RectF();
        Paint paint = null;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        float f10 = this.e;
        float f11 = 100;
        f10 /= f11;
        int n10 = this.c;
        f11 = n10;
        rectF.right = f10 *= f11;
        rectF.bottom = f10 = (float)this.d;
        boolean bl2 = this.f;
        if (bl2) {
            f10 = rectF.height();
            n10 = 0x40000000;
            f11 = 2.0f;
            float f12 = rectF.height() / f11;
            Paint paint2 = this.a;
            canvas.drawRoundRect(rectF, f10 /= f11, f12, paint2);
        } else {
            paint = this.a;
            canvas.drawRect(rectF, paint);
        }
    }

    private void b() {
        Paint paint;
        this.a = paint = new Paint();
        int n10 = this.b;
        paint.setColor(n10);
        paint = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.a.setStrokeWidth(2.0f);
        this.a.setAntiAlias(true);
    }

    public int getProgress() {
        return this.e;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int n10 = this.e;
        if (n10 > 0) {
            this.a(canvas);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        this.c = n10 = View.MeasureSpec.getSize((int)n10);
        this.d = n10 = View.MeasureSpec.getSize((int)n11);
    }

    public void setProgress(int n10) {
        this.e = n10;
        this.postInvalidate();
    }
}

