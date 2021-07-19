/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PointF
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.zhiyun.nvseditor.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.nvseditor.widget.NvsTouchRect$a;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.v.t.a;

public class NvsTouchRect
extends View {
    private static final int u = 0;
    private static final int v = 1;
    private static final int w = 2;
    private static final float x = 0.1f;
    private static final float y = 5.0f;
    private Paint a;
    private int b = 0;
    private float c = 1.0f;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private int i;
    private int j;
    private float k;
    private float l;
    private float m;
    private float n;
    private boolean o;
    private boolean p;
    private boolean q;
    private boolean r = true;
    private m2$d s;
    private NvsTouchRect$a t;

    public NvsTouchRect(Context context) {
        this(context, null);
    }

    public NvsTouchRect(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NvsTouchRect(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.d();
    }

    private void a() {
        boolean bl2;
        m2$d m2$d = this.s;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            m2$d = this.s;
            m2$d.a();
        }
    }

    private float b(MotionEvent motionEvent) {
        float f10 = motionEvent.getX(0);
        int n10 = 1;
        float f11 = motionEvent.getX(n10);
        double d10 = f10 - f11;
        float f12 = motionEvent.getY(0);
        float f13 = motionEvent.getY(n10);
        return (float)Math.toDegrees(Math.atan2(f12 - f13, d10));
    }

    private float c(MotionEvent motionEvent) {
        float f10 = motionEvent.getX(0);
        int n10 = 1;
        float f11 = motionEvent.getX(n10);
        f10 -= f11;
        float f12 = motionEvent.getY(0);
        float f13 = motionEvent.getY(n10);
        f12 -= f13;
        f10 *= f10;
        f12 *= f12;
        return (float)Math.sqrt(f10 + f12);
    }

    private void d() {
        Paint paint;
        float f10;
        this.c = f10 = 1.0f;
        this.a = paint = new Paint();
        paint.setAntiAlias(true);
        paint = this.a;
        f10 = h2.b(f10);
        paint.setStrokeWidth(f10);
        Paint paint2 = this.a;
        paint = Paint.Style.STROKE;
        paint2.setStyle((Paint.Style)paint);
        paint2 = this.a;
        int n10 = 255;
        int n11 = Color.argb((int)136, (int)n10, (int)n10, (int)n10);
        paint2.setColor(n11);
    }

    private /* synthetic */ void e() {
        this.o = false;
        this.invalidate();
    }

    private void g() {
        int n10 = this.i;
        float f10 = n10;
        float f11 = this.h;
        int n11 = this.j;
        float f12 = n11;
        float f13 = (f10 /= f11) - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0) {
            this.l = f10 = (float)n11;
            this.k = f10 = (float)n11 * f11;
        } else {
            this.k = f10 = (float)n10;
            this.l = f10 /= f11;
        }
        float f14 = n10;
        f10 = this.k;
        f14 -= f10;
        f10 = 2.0f;
        this.m = f14 /= f10;
        f14 = n11;
        f11 = this.l;
        this.n = f14 = (f14 - f11) / f10;
    }

    private void i() {
        boolean bl2;
        m2$d m2$d = this.s;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            m2$d = this.s;
            m2$d.a();
        }
        a a10 = new a(this);
        this.s = m2$d = m2.Y(1000L, a10);
    }

    public /* synthetic */ void f() {
        this.e();
    }

    public void h(boolean bl2, boolean bl3) {
        this.p = bl2;
        this.q = bl3;
        if ((bl2 || bl3) && (bl2 = this.r)) {
            bl2 = false;
            this.r = false;
            int n10 = 2;
            this.performHapticFeedback(0, n10);
        }
        if (!(bl2 = this.p) && !(bl2 = this.q)) {
            this.r = bl2 = true;
        }
        this.invalidate();
    }

    public void onDraw(Canvas canvas) {
        Paint paint;
        int n10;
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        int n11;
        super.onDraw(canvas);
        int n12 = this.o;
        if (n12 == 0) {
            return;
        }
        float f15 = this.l;
        float f16 = 3.0f;
        f15 /= f16;
        float f17 = this.k / f16;
        int n13 = 0;
        f16 = 0.0f;
        while (true) {
            n11 = 4;
            f14 = 5.6E-45f;
            if (n13 >= n11) break;
            f13 = this.m;
            f14 = this.n;
            float f18 = n13;
            f12 = f18 * f15;
            f11 = f14 + f12;
            f10 = this.k + f13;
            float f19 = f14 + f12;
            Paint paint2 = this.a;
            canvas.drawLine(f13, f11, f10, f19, paint2);
            f14 = this.m;
            f13 = f14 + (f18 *= f17);
            f11 = this.n;
            f10 = f14 + f18;
            f14 = this.l;
            f19 = f11 + f14;
            paint2 = this.a;
            canvas.drawLine(f13, f11, f10, f19, paint2);
            ++n13;
        }
        n12 = this.q;
        n13 = 1096810496;
        f16 = 14.0f;
        if (n12 != 0) {
            f14 = this.m;
            f12 = this.j >> 1;
            f15 = h2.b(f16);
            f13 = f14 + f15;
            f11 = this.j >> 1;
            Paint paint3 = this.a;
            canvas.drawLine(f14, f12, f13, f11, paint3);
            f15 = this.m;
            f17 = this.k;
            f12 = f15 + f17;
            n11 = this.j >> 1;
            f13 = n11;
            f15 += f17;
            n10 = h2.b(f16);
            f17 = n10;
            f11 = f15 - f17;
            n12 = this.j >> 1;
            f10 = n12;
            paint = this.a;
            canvas.drawLine(f12, f13, f11, f10, paint);
        }
        if ((n12 = this.p) != 0) {
            n12 = this.i;
            f12 = n12 >> 1;
            f13 = this.n;
            f11 = n12 >> 1;
            f15 = h2.b(f16);
            f10 = f13 + f15;
            paint = this.a;
            canvas.drawLine(f12, f13, f11, f10, paint);
            n12 = this.i;
            n10 = n12 >> 1;
            f12 = n10;
            f17 = this.n;
            f14 = this.l;
            f13 = f17 + f14;
            f11 = n12 >> 1;
            n12 = h2.b(f16);
            f15 = n12;
            f10 = (f17 += f14) - f15;
            paint = this.a;
            canvas.drawLine(f12, f13, f11, f10, paint);
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        this.i = n10;
        this.j = n11;
        float f10 = this.h;
        n11 = 0;
        float f11 = f10 - 0.0f;
        n10 = (int)(f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1));
        if (n10 != 0) {
            this.g();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        block13: {
            float f10;
            float f11;
            block9: {
                float f12;
                int n11;
                block10: {
                    float f13;
                    int n12;
                    int n13;
                    block11: {
                        float f14;
                        float f15;
                        block12: {
                            n13 = motionEvent.getAction() & 0xFF;
                            n10 = 1;
                            if (n13 == 0) break block9;
                            if (n13 == n10) break block10;
                            n12 = 2;
                            f13 = 2.8E-45f;
                            if (n13 == n12) break block11;
                            int n14 = 5;
                            float f16 = 7.0E-45f;
                            if (n13 == n14) break block12;
                            n11 = 6;
                            f12 = 8.4E-45f;
                            if (n13 == n11) break block10;
                            break block13;
                        }
                        this.b = n12;
                        this.f = f15 = this.c(motionEvent);
                        this.g = f14 = this.b(motionEvent);
                        break block13;
                    }
                    n13 = this.b;
                    if (n13 == n10) {
                        float f17;
                        float f18;
                        f13 = this.d;
                        float f19 = this.e;
                        PointF pointF = new PointF(f13, f19);
                        f19 = motionEvent.getX();
                        float f20 = motionEvent.getY();
                        PointF pointF2 = new PointF(f19, f20);
                        NvsTouchRect$a nvsTouchRect$a = this.t;
                        if (nvsTouchRect$a != null) {
                            nvsTouchRect$a.c(pointF, pointF2);
                        }
                        this.d = f18 = motionEvent.getX();
                        this.e = f17 = motionEvent.getY();
                    } else if (n13 == n12) {
                        float f21;
                        NvsTouchRect$a nvsTouchRect$a;
                        double d10;
                        float f22 = this.c;
                        f13 = this.c(motionEvent);
                        f22 *= f13;
                        f13 = this.f;
                        this.c = f22 /= f13;
                        n13 = 0;
                        f22 = 0.0f;
                        Object var11_22 = null;
                        f13 = this.b(motionEvent);
                        float f23 = this.g;
                        double d11 = f23 = Math.abs(f13 - f23);
                        double d12 = d11 - (d10 = 0.1);
                        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
                        if (object >= 0) {
                            f22 = this.g;
                            f23 = -180.0f;
                            float f24 = (f22 = f13 - f22) - f23;
                            object = f24 == 0.0f ? 0 : (f24 < 0.0f ? -1 : 1);
                            if (object < 0) {
                                object = -1011613696;
                                f23 = -360.0f;
                                f22 += f23;
                            } else {
                                f23 = 180.0f;
                                float f25 = f22 - f23;
                                object = f25 == 0.0f ? 0 : (f25 > 0.0f ? 1 : -1);
                                if (object > 0) {
                                    object = 1135869952;
                                    f22 = f23 = 360.0f - f22;
                                }
                            }
                            this.g = f13;
                        }
                        if ((nvsTouchRect$a = this.t) != null) {
                            f23 = this.c;
                            nvsTouchRect$a.a(f23);
                            nvsTouchRect$a = this.t;
                            nvsTouchRect$a.b(f22);
                        }
                        this.f = f21 = this.c(motionEvent);
                    }
                    break block13;
                }
                n11 = 0;
                f12 = 0.0f;
                motionEvent = null;
                this.b = 0;
                this.i();
                break block13;
            }
            this.b = n10;
            this.d = f11 = motionEvent.getX();
            this.e = f10 = motionEvent.getY();
            this.o = n10;
            this.a();
            this.invalidate();
        }
        return n10 != 0;
    }

    public void setInitScale(float f10) {
        this.c = f10;
    }

    public void setRatio(float f10) {
        this.h = f10;
        int n10 = this.j;
        if (n10 != 0 && (n10 = this.i) != 0) {
            this.g();
        }
    }

    public void setScaleCallback(NvsTouchRect$a nvsTouchRect$a) {
        this.t = nvsTouchRect$a;
    }
}

