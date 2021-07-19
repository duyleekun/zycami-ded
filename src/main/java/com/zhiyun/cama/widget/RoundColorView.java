/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.zhiyun.cama.R$styleable;

public class RoundColorView
extends View {
    private int a;
    private int b;
    private Paint c;
    private int d = 0xFFFFFF;
    private boolean e;
    private float f;
    private float g;

    public RoundColorView(Context context) {
        this(context, null);
    }

    public RoundColorView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundColorView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        float f11;
        int[] nArray = R$styleable.RoundColorView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.f = f11 = context.getDimension(0, 0.0f);
        boolean bl2 = true;
        this.g = f10 = context.getDimension((int)(bl2 ? 1 : 0), 0.0f);
        context.recycle();
        super();
        this.c = context;
        context.setAntiAlias(bl2);
    }

    private void b(Canvas canvas) {
        Paint paint = this.c;
        int n10 = this.d;
        paint.setColor(n10);
        paint = this.c;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        int n11 = this.a;
        float f10 = n11 / 2;
        float f11 = this.b / 2;
        float f12 = n11 / 2;
        Paint paint2 = this.c;
        canvas.drawCircle(f10, f11, f12, paint2);
    }

    private void c(Canvas canvas) {
        Paint paint = this.c;
        int n10 = this.d;
        paint.setColor(n10);
        float f10 = this.a / 2;
        float f11 = this.b / 2;
        float f12 = this.f;
        float f13 = 2.0f;
        Paint paint2 = this.c;
        canvas.drawCircle(f10, f11, f12 /= f13, paint2);
        paint = this.c;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.c;
        f11 = this.g;
        paint.setStrokeWidth(f11);
        int n11 = this.a;
        f11 = n11 / 2;
        f12 = this.b / 2;
        f10 = n11 / 2;
        float f14 = this.g / f13;
        Paint paint3 = this.c;
        canvas.drawCircle(f11, f12, f10 -= f14, paint3);
    }

    public int a() {
        return this.d;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        boolean bl2 = this.e;
        if (bl2) {
            this.c(canvas);
        } else {
            this.b(canvas);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        this.a = n10 = View.MeasureSpec.getSize((int)n10);
        this.b = n10 = View.MeasureSpec.getSize((int)n11);
        n11 = this.a;
        this.setMeasuredDimension(n11, n10);
    }

    public void setChecked(boolean bl2) {
        this.e = bl2;
        this.postInvalidate();
    }

    public void setColor(int n10) {
        this.d = n10;
    }
}

