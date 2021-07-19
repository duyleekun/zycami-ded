/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.RectF
 *  android.graphics.Xfermode
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package d.v.c.b2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import d.v.c.b2.o$a;
import d.v.e.l.h2;

public class o
extends View {
    private static final int o = 255;
    private static final int p = 0x939393;
    private static final int q = 0;
    private static final float r = 0.0f;
    private static final int s = 0;
    private static final int t = 0;
    private static final int u = 0;
    private static final int v = 0;
    private static final int w = 0;
    public static final int x = 40;
    public static final float y;
    public static final int z;
    private Paint a;
    private Paint b;
    private Paint c;
    private int d = -1;
    private float e = 100.0f;
    private float f = 500.0f;
    private float g;
    private float h;
    private RectF i;
    private RectF j;
    public float k;
    public float l;
    public boolean m;
    private o$a n;

    static {
        int n10;
        int n11;
        q = n11 = h2.b(22.0f);
        r = h2.b(64.0f);
        s = h2.b(1.0f);
        float f10 = 2.0f;
        t = n10 = h2.b(f10);
        u = n10 * 2;
        v = h2.b(f10);
        y = n11 + 0 + 10;
    }

    public o(Context context) {
        super(context);
        float f10;
        this.g = f10 = -1.0f;
        this.h = f10;
        this.e(context);
    }

    public o(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        this.g = f10 = -1.0f;
        this.h = f10;
        this.e(context);
    }

    public o(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        this.g = f10 = -1.0f;
        this.h = f10;
        this.e(context);
    }

    private void a(float f10) {
        o$a o$a = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object != false && (o$a = this.n) != null) {
            boolean bl2 = this.m;
            o$a.c(f10, bl2);
        }
    }

    private void b() {
        o$a o$a = this.n;
        if (o$a != null) {
            boolean bl2 = this.m;
            o$a.a(bl2);
        }
    }

    private void c() {
        o$a o$a = this.n;
        if (o$a != null) {
            boolean bl2 = this.m;
            o$a.b(bl2);
        }
    }

    private void d(Canvas canvas, Paint paint, RectF rectF, int n10) {
        canvas.save();
        float f10 = rectF.left;
        int n11 = n10;
        float f11 = n10;
        f10 -= f11;
        float f12 = rectF.right + f11;
        f11 = this.g;
        RectF rectF2 = new RectF(f10, 0.0f, f12, f11);
        int n12 = u;
        f11 = n12;
        f10 = n12;
        Paint paint2 = this.a;
        canvas.drawRoundRect(rectF2, f11, f10, paint2);
        float f13 = rectF.left;
        n12 = v;
        f11 = n12;
        f12 = this.g;
        f10 = n12;
        rectF2 = new RectF(f13, f11, f13, f12 -= f10);
        int n13 = t;
        f10 = n13;
        f13 = n13;
        Paint paint3 = this.b;
        canvas.drawRoundRect(rectF2, f10, f13, paint3);
        n13 = this.getHeight() / 2;
        int n14 = h2.b(7.0f);
        n12 = q;
        n11 = n12 / 8;
        f12 = this.e;
        float f14 = n12 / 2;
        float f15 = f12 + f14;
        f12 = this.f;
        f10 = n12 / 2;
        float f16 = f12 - f10;
        float f17 = n11;
        f11 = f15 - f17;
        float f18 = n13 - n14;
        float f19 = n13 + n14;
        f10 = f18;
        f12 = f19;
        canvas.drawLine(f11, f18, f11, f19, paint);
        f11 = f15;
        canvas.drawLine(f15, f18, f15, f19, paint);
        f11 = f15 + f17;
        canvas.drawLine(f11, f18, f11, f19, paint);
        f11 = f16 - f17;
        canvas.drawLine(f11, f18, f11, f19, paint);
        f11 = f16;
        canvas.drawLine(f16, f18, f16, f19, paint);
        f11 = f16 + f17;
        canvas.drawLine(f11, f18, f11, f19, paint);
        canvas.restore();
    }

    private void e(Context context) {
        this.f();
    }

    private void f() {
        Paint paint;
        this.a = paint = new Paint();
        int n10 = 1;
        paint.setAntiAlias(n10 != 0);
        paint = this.a;
        Paint.Style style2 = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style2);
        paint = this.a;
        int n11 = this.d;
        paint.setColor(n11);
        this.b = paint = new Paint();
        PorterDuff.Mode mode = PorterDuff.Mode.XOR;
        style2 = new PorterDuffXfermode(mode);
        paint.setXfermode((Xfermode)style2);
        this.c = paint = new Paint(n10);
        paint.setColor(-7105645);
        paint = this.c;
        Paint.Style style3 = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style3);
        paint = this.c;
        float f10 = s;
        paint.setStrokeWidth(f10);
    }

    private boolean g(float f10, float f11) {
        boolean bl2;
        RectF rectF = this.i;
        if (rectF != null && (bl2 = rectF.contains(f10, f11))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    private boolean h(float f10, float f11) {
        boolean bl2;
        RectF rectF = this.j;
        if (rectF != null && (bl2 = rectF.contains(f10, f11))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
        }
        return bl2;
    }

    private float l(float f10) {
        float f11;
        boolean bl2 = this.m;
        if (bl2) {
            float f12 = this.e;
            bl2 = this.i(f12);
            if (!bl2) {
                f12 = this.e;
                bl2 = this.j(f12);
            }
        } else {
            float f13 = this.f;
            bl2 = this.i(f13);
            if (!bl2) {
                f13 = this.f;
                bl2 = this.j(f13);
            }
        }
        Object cfr_ignored_2 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        float f14 = f10 - 0.0f;
        bl2 = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        return f10;
    }

    public o$a getOnDragListener() {
        return this.n;
    }

    public boolean i(float f10) {
        float f11;
        int n10;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (n10 = (f11 = f10 - (f12 = y)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public boolean j(float f10) {
        float f11;
        float f12;
        float f13 = this.h;
        float f14 = 0.0f;
        float f15 = f13 - 0.0f;
        float f16 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        boolean bl2 = false;
        if (f16 > 0 && (f16 = f10 == f13 ? 0 : (f10 < f13 ? -1 : 1)) < 0 && (f12 = (f11 = f10 - (f13 -= (f14 = y))) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) >= 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void k(float f10, float f11) {
        float f12;
        int n10 = (int)f10;
        int n11 = q;
        this.e = f12 = (float)(n10 - n11);
        n10 = (int)f11 + n11;
        this.f = f12 = (float)n10;
        RectF rectF = this.i;
        if (rectF == null) {
            this.i = rectF = new RectF();
        }
        rectF = this.i;
        float f13 = this.e;
        float f14 = 40.0f;
        rectF.left = f13 -= f14;
        rectF.right = f10 += f14;
        f10 = 0.0f;
        rectF.top = 0.0f;
        rectF.bottom = f13 = this.g;
        rectF = this.j;
        if (rectF == null) {
            this.j = rectF = new RectF();
        }
        rectF = this.j;
        rectF.left = f11 -= f14;
        rectF.right = f11 = this.f + f14;
        rectF.top = 0.0f;
        rectF.bottom = f10 = this.g;
        this.postInvalidate();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = this.c;
        float f10 = this.e;
        int n10 = q;
        float f11 = n10;
        f10 += f11;
        f11 = this.f;
        float f12 = n10;
        f11 -= f12;
        f12 = this.g;
        RectF rectF = new RectF(f10, 0.0f, f11, f12);
        this.d(canvas, paint, rectF, n10);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        super.onSizeChanged(n10, n11, n12, n13);
        this.h = f10 = (float)n10;
        this.g = f10 = (float)n11;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block3: {
            block6: {
                block8: {
                    block4: {
                        block7: {
                            block5: {
                                var2_2 = var1_1.getX();
                                var3_3 = var1_1.getY();
                                var4_4 = var1_1.getAction();
                                var5_5 = false;
                                var6_6 = true;
                                var7_7 = 1.4E-45f;
                                if (!var4_4) break block4;
                                if (var4_4 == var6_6) break block5;
                                var8_8 = 2 != 0;
                                if (var4_4 != var8_8) break block6;
                                var9_9 = this.k;
                                var9_9 = var2_2 - var9_9;
                                var9_9 = this.l(var9_9);
                                this.a(var9_9);
                                break block7;
                            }
                            this.c();
                        }
lbl19:
                        // 3 sources

                        while (true) {
                            var4_4 = var6_6;
                            var9_9 = var7_7;
                            break block3;
                            break;
                        }
                    }
                    var4_4 = this.g(var2_2, var3_3);
                    if (!var4_4) break block8;
                    this.m = var6_6;
                    this.b();
                    ** GOTO lbl19
                }
                var4_4 = this.h(var2_2, var3_3);
                if (var4_4) {
                    this.m = false;
                    this.b();
                    ** continue;
                }
            }
            var4_4 = false;
            var9_10 = 0.0f;
        }
        this.k = var2_2;
        this.l = var3_3;
        if (var4_4 || (var10_11 = super.onTouchEvent(var1_1))) {
            var5_5 = var6_6;
        }
        return var5_5;
    }

    public void setOnDragListener(o$a o$a) {
        this.n = o$a;
    }
}

