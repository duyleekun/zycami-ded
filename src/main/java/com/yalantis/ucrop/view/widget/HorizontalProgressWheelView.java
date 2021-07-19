/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.yalantis.ucrop.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.yalantis.ucrop.R$color;
import com.yalantis.ucrop.R$dimen;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView$a;

public class HorizontalProgressWheelView
extends View {
    private final Rect a;
    private HorizontalProgressWheelView$a b;
    private float c;
    private Paint d;
    private Paint e;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private float j;
    private int k;

    public HorizontalProgressWheelView(Context context) {
        this(context, null);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        super();
        this.a = context;
        this.a();
    }

    public HorizontalProgressWheelView(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        super();
        this.a = context;
    }

    private void a() {
        int n10;
        Context context = this.getContext();
        int n11 = R$color.ucrop_color_widget_rotate_mid_line;
        this.k = n10 = ContextCompat.getColor(context, n11);
        context = this.getContext().getResources();
        n11 = R$dimen.ucrop_width_horizontal_wheel_progress_line;
        this.f = n10 = context.getDimensionPixelSize(n11);
        context = this.getContext().getResources();
        n11 = R$dimen.ucrop_height_horizontal_wheel_progress_line;
        this.g = n10 = context.getDimensionPixelSize(n11);
        context = this.getContext().getResources();
        n11 = R$dimen.ucrop_margin_horizontal_wheel_progress_line;
        this.h = n10 = context.getDimensionPixelSize(n11);
        context = new Paint(1);
        this.d = context;
        Paint.Style style2 = Paint.Style.STROKE;
        context.setStyle(style2);
        context = this.d;
        float f10 = this.f;
        context.setStrokeWidth(f10);
        context = this.d;
        style2 = this.getResources();
        int n12 = R$color.ucrop_color_progress_wheel_line;
        n11 = style2.getColor(n12);
        context.setColor(n11);
        style2 = this.d;
        context = new Paint((Paint)style2);
        this.e = context;
        n11 = this.k;
        context.setColor(n11);
        context = this.e;
        style2 = Paint.Cap.ROUND;
        context.setStrokeCap((Paint.Cap)style2);
        context = this.e;
        style2 = this.getContext().getResources();
        n12 = R$dimen.ucrop_width_middle_wheel_progress_line;
        f10 = style2.getDimensionPixelSize(n12);
        context.setStrokeWidth(f10);
    }

    private void b(MotionEvent object, float f10) {
        float f11;
        float f12;
        this.j = f12 = this.j - f10;
        this.postInvalidate();
        this.c = f11 = object.getX();
        object = this.b;
        if (object != null) {
            f10 = -f10;
            f12 = this.j;
            object.c(f10, f12);
        }
    }

    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        super.onDraw(canvas);
        Rect rect = this.a;
        canvas.getClipBounds(rect);
        rect = this.a;
        int n10 = rect.width();
        int n11 = this.f;
        int n12 = this.h;
        int n13 = n11 + n12;
        float f13 = this.j;
        float f14 = n12 += n11;
        f13 %= f14;
        f14 = 0.0f;
        for (n11 = 0; n11 < (n10 /= n13); ++n11) {
            int n14;
            int n15;
            float f15;
            Paint paint;
            n12 = n10 / 4;
            int n16 = 1132396544;
            f12 = 255.0f;
            if (n11 < n12) {
                paint = this.d;
                f15 = n11;
                f11 = n12;
                f15 = f15 / f11 * f12;
                n12 = (int)f15;
                paint.setAlpha(n12);
            } else {
                n15 = n10 * 3 / 4;
                if (n11 > n15) {
                    paint = this.d;
                    n14 = n10 - n11;
                    f15 = n14;
                    f11 = n12;
                    f15 = f15 / f11 * f12;
                    n12 = (int)f15;
                    paint.setAlpha(n12);
                } else {
                    Paint paint2 = this.d;
                    n16 = 255;
                    f12 = 3.57E-43f;
                    paint2.setAlpha(n16);
                }
            }
            f11 = -f13;
            Rect rect2 = this.a;
            f10 = (float)rect2.left + f11;
            n14 = this.f;
            int n17 = this.h;
            f15 = (n14 + n17) * n11;
            float f16 = f10 + f15;
            f12 = rect2.centerY();
            f10 = this.g;
            n14 = 0x40800000;
            f15 = 4.0f;
            float f17 = f12 - (f10 /= f15);
            rect2 = this.a;
            f10 = rect2.left;
            f11 += f10;
            n15 = this.f;
            n17 = this.h;
            n15 = (n15 + n17) * n11;
            f10 = n15;
            float f18 = f11 + f10;
            n12 = rect2.centerY();
            f11 = n12;
            n16 = this.g;
            f12 = (float)n16 / f15;
            float f19 = f11 + f12;
            Paint paint3 = this.d;
            canvas.drawLine(f16, f17, f18, f19, paint3);
        }
        f11 = this.a.centerX();
        float f20 = this.a.centerY();
        f14 = this.g;
        f13 = 2.0f;
        f20 -= (f14 /= f13);
        f12 = this.a.centerX();
        f14 = this.a.centerY();
        f10 = (float)this.g / f13 + f14;
        Paint paint = this.e;
        f13 = f20;
        canvas.drawLine(f11, f20, f12, f10, paint);
    }

    public boolean onTouchEvent(MotionEvent object) {
        int n10 = object.getAction();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                float f10 = 2.8E-45f;
                if (n10 == n12) {
                    float f11 = object.getX();
                    f10 = this.c;
                    f11 -= f10;
                    f10 = 0.0f;
                    HorizontalProgressWheelView$a horizontalProgressWheelView$a = null;
                    float f12 = f11 - 0.0f;
                    n12 = (int)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
                    if (n12 != 0) {
                        n12 = (int)(this.i ? 1 : 0);
                        if (n12 == 0) {
                            this.i = n11;
                            horizontalProgressWheelView$a = this.b;
                            if (horizontalProgressWheelView$a != null) {
                                horizontalProgressWheelView$a.b();
                            }
                        }
                        this.b((MotionEvent)object, f11);
                    }
                }
            } else {
                object = this.b;
                if (object != null) {
                    n10 = 0;
                    float f13 = 0.0f;
                    this.i = false;
                    object.a();
                }
            }
        } else {
            float f14;
            this.c = f14 = object.getX();
        }
        return n11 != 0;
    }

    public void setMiddleLineColor(int n10) {
        this.k = n10;
        this.e.setColor(n10);
        this.invalidate();
    }

    public void setScrollingListener(HorizontalProgressWheelView$a horizontalProgressWheelView$a) {
        this.b = horizontalProgressWheelView$a;
    }
}

