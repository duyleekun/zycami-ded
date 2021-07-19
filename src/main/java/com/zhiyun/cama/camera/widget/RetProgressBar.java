/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import d.v.e.l.o1;

public class RetProgressBar
extends View {
    private Paint a;
    private Paint b;
    private Path c;
    private Path d;
    private float e;
    private float f;
    private int g;
    private int h;
    private float i;
    private float j;
    private float[] k;
    private float l;
    private float m;

    public RetProgressBar(Context context) {
        this(context, null);
    }

    public RetProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RetProgressBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        float f11;
        Object object;
        this.c = object = new Path();
        this.d = object = new Path();
        this.g = 100;
        object = new float[8];
        this.k = (float[])object;
        object = R$styleable.RetProgressBar;
        attributeSet = context.obtainStyledAttributes(attributeSet, (int[])object);
        object = context.getResources();
        int bl2 = 2131099772;
        n10 = o1.c((Resources)object, bl2);
        n10 = attributeSet.getColor(0, n10);
        int n11 = o1.c(context.getResources(), bl2);
        n11 = attributeSet.getColor(2, n11);
        boolean bl3 = true;
        this.e = f11 = attributeSet.getDimension((int)(bl3 ? 1 : 0), 0.0f);
        this.f = f10 = attributeSet.getDimension(3, 0.0f);
        attributeSet.recycle();
        super();
        this.b = attributeSet;
        attributeSet.setAntiAlias(bl3);
        this.b.setColor(n10);
        attributeSet = this.b;
        object = Paint.Style.STROKE;
        attributeSet.setStyle((Paint.Style)object);
        attributeSet = this.b;
        float f12 = this.e;
        attributeSet.setStrokeWidth(f12);
        super();
        this.a = attributeSet;
        attributeSet.setAntiAlias(bl3);
        attributeSet = this.a;
        object = Paint.Style.STROKE;
        attributeSet.setStyle((Paint.Style)object);
        attributeSet = this.a;
        f12 = this.e;
        attributeSet.setStrokeWidth(f12);
        this.a.setColor(n11);
        context = this.a;
        attributeSet = Paint.Cap.ROUND;
        context.setStrokeCap((Paint.Cap)attributeSet);
        context = this.a;
        attributeSet = Paint.Join.ROUND;
        context.setStrokeJoin((Paint.Join)attributeSet);
    }

    private void a(Canvas canvas) {
        float f10 = this.l;
        float f11 = this.m;
        float f12 = this.i;
        float f13 = this.j;
        RectF rectF = new RectF(f10, f11, f12, f13);
        this.b(canvas, rectF, true);
    }

    private void b(Canvas canvas, RectF rectF, boolean bl2) {
        Path.Direction direction;
        float f10;
        float f11 = 0.0f;
        float[] fArray = null;
        if (bl2) {
            f10 = this.f;
        } else {
            direction = null;
            f10 = 0.0f;
        }
        float f12 = bl2 ? this.f : 0.0f;
        float f13 = bl2 ? this.f : 0.0f;
        if (bl2) {
            f11 = this.f;
        }
        this.e(f10, f12, f13, f11);
        this.d.reset();
        Path path = this.d;
        fArray = this.k;
        direction = Path.Direction.CW;
        path.addRoundRect(rectF, fArray, direction);
        rectF = this.d;
        path = this.b;
        canvas.drawPath((Path)rectF, (Paint)path);
    }

    private void c(Canvas canvas) {
        float f10;
        float f11;
        Path path;
        this.c.reset();
        Path path2 = this.c;
        float f12 = this.i;
        float f13 = this.j;
        path2.moveTo(f12, f13);
        int n10 = this.h;
        int n11 = this.g;
        int n12 = n11 / 4;
        float f14 = 4.0f;
        if (n10 > n12) {
            path2 = this.c;
            f12 = this.l;
            f13 = this.j;
            path2.lineTo(f12, f13);
        } else {
            path = this.c;
            n10 = -n10;
            f11 = (float)n10 * f14;
            f10 = this.i;
            f11 *= f10;
            f12 = n11;
            path.rLineTo(f11 /= f12, 0.0f);
        }
        n10 = this.h;
        n11 = this.g;
        n12 = n11 / 2;
        f10 = 2.0f;
        if (n10 > n12) {
            path2 = this.c;
            f12 = this.l;
            f13 = this.e / f10;
            path2.lineTo(f12, f13);
        } else {
            n12 = n11 / 4;
            if (n10 > n12) {
                path = this.c;
                n10 = -(n10 + -25);
                f11 = (float)n10 * f14;
                float f15 = this.j;
                f11 *= f15;
                f12 = n11;
                path.rLineTo(0.0f, f11 /= f12);
            }
        }
        n10 = this.h;
        n11 = this.g;
        n12 = n11 * 3 / 4;
        if (n10 > n12) {
            path2 = this.c;
            f12 = this.i;
            f13 = this.e / f10;
            path2.lineTo(f12, f13);
            n10 = this.h;
            n11 = this.g;
            if (n10 == n11) {
                path2 = this.c;
                f12 = this.i;
                f13 = this.j;
                path2.lineTo(f12, f13);
            } else {
                path = this.c;
                f11 = (float)(n10 += -75) * f14;
                f14 = this.j;
                f10 = this.e;
                f11 *= (f14 -= f10);
                f12 = n11;
                path.rLineTo(0.0f, f11 /= f12);
            }
        } else {
            n12 = n11 / 2;
            if (n10 > n12) {
                path = this.c;
                f11 = (float)(n10 += -50) * f14;
                f14 = this.i;
                f11 *= f14;
                f12 = n11;
                path.rLineTo(f11 /= f12, 0.0f);
            }
        }
        path2 = this.c;
        Paint paint = this.a;
        canvas.drawPath(path2, paint);
    }

    private void d() {
        this.c.reset();
    }

    private void e(float f10, float f11, float f12, float f13) {
        float[] fArray = this.k;
        fArray[0] = f10;
        fArray[1] = f10;
        fArray[2] = f11;
        fArray[3] = f11;
        fArray[4] = f12;
        fArray[5] = f12;
        fArray[6] = f13;
        fArray[7] = f13;
    }

    public int getMax() {
        return this.g;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a(canvas);
        int n10 = this.h;
        if (n10 > 0) {
            this.c(canvas);
        }
    }

    public void onMeasure(int n10, int n11) {
        float f10;
        super.onMeasure(n10, n11);
        n10 = View.MeasureSpec.getSize((int)n10);
        n11 = View.MeasureSpec.getSize((int)n11);
        float f11 = this.e;
        float f12 = 2.0f;
        this.l = f10 = f11 / f12;
        this.m = f10 = f11 / f12;
        float f13 = n10;
        f10 = f11 / f12;
        this.i = f13 -= f10;
        f13 = n11;
        this.j = f13 -= (f11 /= f12);
    }

    public void setProgress(int n10) {
        int n11;
        if (n10 < 0) {
            n10 = 0;
        }
        if (n10 == 0) {
            this.d();
        }
        if (n10 >= (n11 = this.g)) {
            n10 = n11;
        }
        this.h = n10;
        this.invalidate();
    }
}

