/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.ViewConfiguration
 *  android.widget.Scroller
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import com.zhiyun.cama.widget.HorizontalScrollView$a;
import d.v.e.l.h2;
import java.util.List;

public class HorizontalScrollView
extends View {
    private List A;
    private HorizontalScrollView$a B;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final int e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    private int l;
    private int m;
    private float n;
    private int o;
    private float p;
    private VelocityTracker q;
    private Scroller r;
    private float s;
    private float t;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private boolean z;

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalScrollView(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        int n11;
        this.a = n11 = h2.b(2.5f);
        this.b = n11 = h2.b(10.0f);
        this.c = n11 = h2.b(1.0f);
        this.d = n11 = h2.b(24.0f);
        this.e = 10;
        super();
        this.A = object;
        this.g();
        this.h();
        this.i();
    }

    private void a() {
        float f10 = this.p;
        int n10 = this.w;
        float f11 = n10;
        f11 = f10 % f11;
        float f12 = 0.0f;
        float f13 = f11 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            f12 = n10;
            float f14 = 2.0f;
            float f15 = f11 - (f12 /= f14);
            object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
            if (object > 0) {
                float f16 = (float)n10 - f11;
                this.p = f10 += f16;
            } else {
                this.p = f10 -= f11;
            }
            this.invalidate();
        }
    }

    private void b() {
        float f10 = this.p;
        int n10 = this.l;
        float f11 = n10;
        int n11 = (int)(f10 - f11);
        float f12 = n10 * 2;
        int n12 = (int)(f10 + f12);
        n10 = this.w;
        this.x = n11 /= n10;
        this.y = n12 /= n10;
        this.x = n12 = Math.max(0, n11);
        n12 = this.y;
        n10 = this.A.size() + -1;
        this.y = n12 = Math.min(n12, n10);
    }

    private void c(Canvas canvas) {
        float f10;
        float f11;
        Object object;
        List list;
        float f12;
        int n10;
        int n11 = this.l;
        int n12 = this.c;
        float f13 = n11 -= n12;
        n12 = 0x40000000;
        float f14 = 2.0f;
        f13 /= f14;
        float f15 = this.p;
        f13 -= f15;
        int n13 = this.m;
        int n14 = this.b;
        n13 = n13 - n14 + -10;
        f15 = n13;
        float f16 = (float)n14 + f15;
        this.b();
        for (int i10 = n10 = this.x; i10 <= (n10 = this.y); ++i10) {
            float f17;
            n10 = this.w;
            f12 = n10 * i10;
            float f18 = f13 + f12;
            int n15 = i10 % 2;
            if (n15 == 0) {
                f12 = this.p;
                f17 = n10;
                float f19 = (f12 /= f17) - (f17 = (float)i10);
                n10 = (int)(f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1));
                if (n10 != 0) {
                    n10 = i10 % 5;
                    list = n10 == 0 ? this.g : this.f;
                    object = list;
                    list = canvas;
                    f12 = f18;
                    f11 = f15;
                    f10 = f18;
                    canvas.drawLine(f18, f15, f18, f16, object);
                }
            }
            if (i10 != (n10 = (list = this.A).size() / 2)) continue;
            n10 = h2.b(12.0f);
            f17 = n10;
            f17 = f15 - f17;
            n15 = h2.b(f14);
            f12 = n15;
            Paint paint = this.i;
            canvas.drawCircle(f18, f17, f12, paint);
        }
        n11 = this.l;
        n13 = this.c;
        f12 = (float)(n11 - n13) / f14;
        n10 = this.m + -10;
        int n16 = this.d;
        f11 = n10 - n16;
        f10 = (float)(n11 - n13) / f14;
        object = this.h;
        list = canvas;
        canvas.drawLine(f12, f11, f10, f16, object);
    }

    private void d(Canvas canvas) {
        float f10 = 48.0f;
        float f11 = h2.b(f10);
        float f12 = this.m;
        Paint paint = this.j;
        canvas.drawRect(0.0f, 0.0f, f11, f12, paint);
        int n10 = this.l;
        int n11 = h2.b(f10);
        float f13 = n10 - n11;
        f11 = this.l;
        f12 = this.m;
        paint = this.k;
        canvas.drawRect(f13, 0.0f, f11, f12, paint);
    }

    private void e(Canvas canvas) {
        int n10;
        int n11;
        Object object;
        Object object2;
        int n12;
        int n13 = this.f();
        int n14 = 1;
        if (n13 >= 0 && n13 < (n12 = (object2 = this.A).size())) {
            object2 = new Object[n14];
            object2[0] = object = this.A.get(n13);
            object2 = String.format("%s\u00b0", (Object[])object2);
            object = this.g;
            float f10 = object.measureText((String)object2);
            int n15 = this.l;
            float f11 = ((float)n15 - f10) / 2.0f;
            n11 = this.m + -10;
            float f12 = 35.0f;
            int n16 = h2.b(f12);
            f10 = n11 -= n16;
            Paint paint = this.g;
            canvas.drawText((String)object2, f11, f10, paint);
        }
        if ((n10 = this.v) != n13) {
            n10 = Math.abs(n10 - n13);
            this.v = n13;
            object2 = this.B;
            if (object2 != null) {
                object = (Integer)this.A.get(n13);
                n11 = (Integer)object;
                object2.c(n11);
            }
            if (((n13 %= (n12 = 2)) == 0 || n10 > n14) && (n10 = (int)(this.z ? 1 : 0)) != 0) {
                this.performHapticFeedback(0, n12);
            }
        }
    }

    private int f() {
        float f10 = this.p;
        int n10 = (int)f10;
        int n11 = this.w;
        n10 /= n11;
        float f11 = n11;
        f10 %= f11;
        float f12 = n11;
        f11 = 2.0f;
        float f13 = f10 - (f12 /= f11);
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0) {
            ++n10;
        }
        return n10;
    }

    private void g() {
        this.j();
    }

    private void h() {
        Scroller scroller;
        List list;
        int n10;
        int n11;
        float f10 = 0.0f / 0.0f;
        for (n11 = -180; n11 <= (n10 = 180); ++n11) {
            list = this.A;
            Integer n12 = n11;
            list.add(n12);
        }
        n11 = this.c;
        n10 = this.a;
        n11 += n10;
        n10 = this.A.size() + -1;
        this.o = n11 *= n10;
        n11 = this.a;
        n10 = this.c;
        this.w = n11 += n10;
        this.s = f10 = (float)ViewConfiguration.get((Context)this.getContext()).getScaledMaximumFlingVelocity();
        this.t = f10 = (float)ViewConfiguration.get((Context)this.getContext()).getScaledMinimumFlingVelocity();
        list = this.getContext();
        this.r = scroller = new Scroller((Context)list);
        this.x = 0;
        this.y = n11 = this.A.size() + -1;
    }

    private void i() {
    }

    private void j() {
        Paint paint;
        this.f = paint = new Paint();
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        paint = this.f;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.f;
        float f10 = this.c;
        paint.setStrokeWidth(f10);
        paint = this.f;
        int n10 = this.getResources().getColor(2131099776, null);
        paint.setColor(n10);
        this.g = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.g;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.g;
        f10 = this.c;
        paint.setStrokeWidth(f10);
        paint = this.g;
        f10 = h2.g(16.0f);
        paint.setTextSize(f10);
        paint = this.g;
        n10 = this.getResources().getColor(2131099772, null);
        paint.setColor(n10);
        this.h = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.h;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.h;
        f10 = this.c;
        paint.setStrokeWidth(f10);
        paint = this.h;
        n10 = this.getResources().getColor(2131099812, null);
        paint.setColor(n10);
        this.i = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.i;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.i;
        f10 = this.c;
        paint.setStrokeWidth(f10);
        paint = this.i;
        n10 = this.getResources().getColor(2131099784, null);
        paint.setColor(n10);
        this.j = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.j;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.k = paint = new Paint();
        paint.setAntiAlias(bl2);
        paint = this.k;
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
    }

    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.r;
        int n10 = scroller.computeScrollOffset();
        if (n10 == 0) {
            return;
        }
        scroller = this.r;
        n10 = scroller.getCurrX();
        int n11 = this.u;
        if ((n11 = n10 - n11) != 0) {
            float f10 = this.p;
            float f11 = n11;
            this.p = f10 -= f11;
            n11 = 0;
            this.p = f11 = Math.max(0.0f, f10);
            int n12 = this.o;
            f10 = n12;
            this.p = f11 = Math.min(f11, f10);
            this.u = n10;
        }
        if ((n10 = (int)((scroller = this.r).isFinished() ? 1 : 0)) != 0) {
            this.a();
            n10 = 0;
            scroller = null;
            this.z = false;
        }
        this.invalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.c(canvas);
        this.e(canvas);
        this.d(canvas);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        LinearGradient linearGradient;
        super.onSizeChanged(n10, n11, n12, n13);
        int n14 = n10;
        this.l = n10;
        n14 = n11;
        this.m = n11;
        n14 = this.l;
        float f10 = 48.0f;
        int n15 = h2.b(f10);
        float f11 = n14 - n15;
        float f12 = this.l;
        int n16 = 31;
        int n17 = Color.argb((int)255, (int)18, (int)23, (int)n16);
        int n18 = 19;
        int n19 = 20;
        int n20 = 21;
        int n21 = Color.argb((int)0, (int)n18, (int)n19, (int)n20);
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        LinearGradient linearGradient2 = linearGradient;
        int n22 = n19;
        n19 = n21;
        linearGradient = new LinearGradient(f11, 0.0f, f12, 0.0f, n17, n21, tileMode);
        this.j.setShader((Shader)linearGradient);
        f11 = h2.b(f10);
        int n23 = Color.argb((int)0, (int)n18, (int)n22, (int)n20);
        int n24 = Color.argb((int)255, (int)18, (int)23, (int)n16);
        Shader.TileMode tileMode2 = Shader.TileMode.MIRROR;
        linearGradient2 = new LinearGradient(0.0f, 0.0f, f11, 0.0f, n23, n24, tileMode2);
        this.k.setShader((Shader)linearGradient2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        VelocityTracker velocityTracker = this.q;
        if (velocityTracker == null) {
            this.q = velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker = this.q;
        velocityTracker.addMovement(motionEvent);
        int n10 = motionEvent.getAction();
        int n11 = 1;
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                float f10 = 2.8E-45f;
                if (n10 == n12) {
                    float f11;
                    float f12 = motionEvent.getX();
                    f10 = this.n;
                    f12 -= f10;
                    this.p = f10 = this.p - f12;
                    n10 = 0;
                    velocityTracker = null;
                    this.p = f12 = Math.max(0.0f, f10);
                    n12 = this.o;
                    f10 = n12;
                    this.p = f12 = Math.min(f12, f10);
                    this.n = f11 = motionEvent.getX();
                    this.invalidate();
                }
            } else {
                motionEvent = this.q;
                float f13 = this.s;
                motionEvent.computeCurrentVelocity(1000, f13);
                motionEvent = this.q;
                float f14 = motionEvent.getXVelocity();
                float f15 = Math.abs(f14);
                f13 = this.t;
                n10 = f15 == f13 ? 0 : (f15 > f13 ? 1 : -1);
                if (n10 > 0) {
                    velocityTracker = this.r;
                    n10 = (int)(velocityTracker.isFinished() ? 1 : 0);
                    if (n10 == 0) {
                        velocityTracker = this.r;
                        velocityTracker.abortAnimation();
                    }
                    this.u = 0;
                    Scroller scroller = this.r;
                    int n13 = (int)f14;
                    int n14 = -1000;
                    int n15 = 1000;
                    scroller.fling(0, 0, n13, 0, n14, n15, 0, 0);
                    this.invalidate();
                } else {
                    f14 = 0.0f;
                    motionEvent = null;
                    this.z = false;
                    this.a();
                }
            }
        } else {
            float f16;
            velocityTracker = this.r;
            n10 = (int)(velocityTracker.isFinished() ? 1 : 0);
            if (n10 == 0) {
                velocityTracker = this.r;
                velocityTracker.abortAnimation();
            }
            this.z = n11;
            this.n = f16 = motionEvent.getX();
        }
        return n11 != 0;
    }

    public void setDataList(List list) {
        this.A = list;
    }

    public void setHorizontalScrollListener(HorizontalScrollView$a horizontalScrollView$a) {
        this.B = horizontalScrollView$a;
    }

    public void setPosition(int n10) {
        float f10;
        int n11 = this.w;
        this.p = f10 = (float)(n10 * n11);
        this.invalidate();
    }

    public void setPositionData(int n10) {
        int n11;
        List list = this.A;
        Integer n12 = n10;
        if ((n10 = list.indexOf(n12)) != (n11 = -1)) {
            this.setPosition(n10);
        }
    }
}

