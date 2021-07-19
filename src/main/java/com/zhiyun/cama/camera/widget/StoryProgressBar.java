/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.Path$Direction
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.camera.widget.StoryProgressBar$a;
import d.v.c.s0.i7.h;
import d.v.c.s0.i7.i;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.e.l.l2;
import d.v.e.l.o1;
import d.v.f.i.g;
import java.util.HashMap;
import java.util.Map;
import l.a.q.e0;

public class StoryProgressBar
extends e0 {
    private final int A;
    private int B;
    private int[] C;
    private long[] D;
    private int E;
    private boolean F;
    private final float[] G;
    private float[] H;
    private int I;
    private int J;
    private boolean K;
    private Map L;
    private boolean M;
    private int N;
    private int O;
    private long P;
    private StoryProgressBar$a Q;
    private Paint b;
    private Paint c;
    private final Path d;
    private final RectF e;
    private final RectF f;
    private int g;
    private float h;
    private float i;
    private float j;
    private final float k;
    private float l;
    private final int m;
    private final int n;
    private final int o;
    private int p;
    private int q;
    private int r;
    private final float s;
    private final int t;
    private int u;
    private final float v;
    private final int w;
    private int x;
    private int y;
    private int z;

    public StoryProgressBar(Context context) {
        this(context, null);
    }

    public StoryProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public StoryProgressBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        float f11;
        Path path;
        this.d = path = new Path();
        super();
        this.e = path;
        super();
        this.f = path;
        this.A = 100;
        this.B = n10 = 1;
        int n11 = 8;
        Object object = new float[n11];
        this.G = object;
        this.K = n10;
        object = new HashMap;
        super();
        this.L = object;
        object = R$styleable.StoryProgressBar;
        attributeSet = context.obtainStyledAttributes(attributeSet, (int[])object);
        float f12 = 2.0f;
        float f13 = h2.b(f12);
        this.k = f13 = attributeSet.getDimension(0, f13);
        f13 = h2.b(64.0f);
        this.h = f11 = attributeSet.getDimension(n10, f13);
        this.i = f11 *= f12;
        this.m = n10 = attributeSet.getResourceId(2, 0);
        this.n = n10 = attributeSet.getResourceId(5, 0);
        this.o = n10 = attributeSet.getResourceId(6, 0);
        this.s = f11 = attributeSet.getDimension(4, 1.0f);
        this.t = n10 = attributeSet.getResourceId(3, 0);
        int n12 = o1.c(context.getResources(), 2131099772);
        this.w = n12 = attributeSet.getColor(7, n12);
        this.v = f10 = attributeSet.getDimension(9, 0.0f);
        this.x = n12 = attributeSet.getResourceId(n11, 0);
        attributeSet.recycle();
        this.getAllColor();
        this.h();
    }

    private void a(Canvas canvas) {
        int n10;
        Paint paint = this.b;
        int n11 = this.p;
        paint.setColor(n11);
        paint = this.b;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = null;
        style2 = null;
        for (n11 = 0; n11 < (n10 = this.B); ++n11) {
            float f10;
            this.b(n11, canvas, false);
            float[] fArray = this.H;
            if (fArray == null) continue;
            RectF rectF = this.e;
            fArray[n11] = f10 = rectF.left;
        }
    }

    private void b(int n10, Canvas canvas, boolean bl2) {
        this.c(n10, canvas, bl2, false);
    }

    private void c(int n10, Canvas canvas, boolean bl2, boolean bl3) {
        float[] fArray;
        float f10;
        float f11;
        int n11;
        RectF rectF;
        int n12;
        RectF rectF2;
        float f12 = this.l;
        float f13 = n10;
        float f14 = this.j;
        float f15 = this.k + f14;
        f12 += (f13 *= f15);
        f13 = 0.0f;
        Path.Direction direction = null;
        f15 = 2.0f;
        if (bl2) {
            rectF2 = this.e;
            int n13 = this.z;
            float f16 = (float)n13 * 1.0f;
            int n14 = 1120403456;
            float f17 = 100.0f;
            rectF2.right = f14 = f14 * (f16 /= f17) + f12;
        } else {
            float f18;
            float f19;
            rectF2 = this.e;
            rectF2.right = f14 += f12;
            if (n10 == 0) {
                n12 = this.g;
                f14 = (float)n12 / f15;
            } else {
                n12 = 0;
                rectF = null;
                f14 = 0.0f;
            }
            n11 = this.B;
            int n15 = n11 + -1;
            if (n10 == n15) {
                n15 = this.g;
                f19 = (float)n15 / f15;
            } else {
                n15 = 0;
                f19 = 0.0f;
            }
            if (n10 == (n11 += -1)) {
                n11 = this.g;
                f11 = (float)n11 / f15;
            } else {
                n11 = 0;
                rectF2 = null;
                f11 = 0.0f;
            }
            if (n10 == 0) {
                int n16 = this.g;
                f18 = (float)n16 / f15;
            } else {
                boolean bl4 = false;
                f18 = 0.0f;
            }
            this.p(f14, f19, f11, f18);
        }
        rectF = this.e;
        rectF.left = f12;
        if (bl3) {
            f11 = this.s / f15;
        } else {
            n11 = 0;
            rectF2 = null;
            f11 = 0.0f;
        }
        rectF.top = f11;
        if (bl3) {
            int n17 = this.g;
            f10 = n17;
            f11 = this.s / f15;
            f10 -= f11;
        } else {
            int n18 = this.g;
            f10 = n18;
        }
        rectF.bottom = f10;
        this.f.set(rectF);
        RectF rectF3 = this.f;
        f14 = this.j;
        rectF3.right = f12 += f14;
        if (n10 == 0) {
            int n19 = this.g;
            f10 = (float)n19 / f15;
        } else {
            boolean bl5 = false;
            rectF3 = null;
            f10 = 0.0f;
        }
        int n20 = this.B;
        n12 = n20 + -1;
        if (n10 == n12) {
            n12 = this.g;
            f14 = (float)n12 / f15;
        } else {
            n12 = 0;
            rectF = null;
            f14 = 0.0f;
        }
        if (n10 == (n20 += -1)) {
            n20 = this.g;
            f12 = (float)n20 / f15;
        } else {
            n20 = 0;
            fArray = null;
            f12 = 0.0f;
        }
        if (n10 == 0) {
            n10 = this.g;
            float f20 = n10;
            f13 = f20 / f15;
        }
        this.p(f10, f14, f12, f13);
        this.d.reset();
        Path path = this.d;
        rectF3 = this.f;
        fArray = this.G;
        direction = Path.Direction.CW;
        path.addRoundRect(rectF3, fArray, direction);
        if (bl2) {
            path = this.b;
            int n21 = this.q;
            path.setColor(n21);
            path = this.b;
            rectF3 = Paint.Style.FILL;
            path.setStyle((Paint.Style)rectF3);
            path = this.e;
            rectF3 = this.b;
            canvas.saveLayer((RectF)path, (Paint)rectF3);
        }
        path = this.d;
        rectF3 = this.b;
        canvas.drawPath(path, (Paint)rectF3);
        if (bl2) {
            canvas.restore();
        }
    }

    private void d(Canvas canvas) {
        Paint object = this.b;
        Paint.Style style2 = Paint.Style.FILL;
        object.setStyle(style2);
        Paint paint = this.b;
        int n10 = this.q;
        paint.setColor(n10);
        int[] nArray = this.C;
        if (nArray == null) {
            return;
        }
        for (int n11 : nArray) {
            int n12 = this.E;
            if (n11 == n12) continue;
            this.b(n11, canvas, false);
        }
    }

    private void f(Canvas canvas) {
        int n10 = this.E;
        int n11 = -1;
        float f10 = 0.0f / 0.0f;
        if (n10 == n11) {
            return;
        }
        Paint paint = this.b;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.b;
        f10 = this.s;
        paint.setStrokeWidth(f10);
        paint = this.b;
        n11 = this.u;
        paint.setColor(n11);
        n10 = this.E;
        n11 = 0;
        f10 = 0.0f;
        style2 = null;
        boolean bl2 = true;
        this.c(n10, canvas, false, bl2);
        n10 = (int)(this.F ? 1 : 0);
        if (n10 == 0) {
            paint = this.b;
            style2 = Paint.Style.FILL;
            paint.setStyle(style2);
            paint = this.b;
            n11 = this.r;
            paint.setColor(n11);
        }
        n10 = this.E;
        n11 = (int)(this.F ? 1 : 0);
        this.b(n10, canvas, n11 != 0);
    }

    private void g(Canvas canvas) {
        int n10;
        Object object = this.D;
        if (object != null && (n10 = ((long[])object).length) != 0) {
            Object object2;
            object = this.c;
            float f10 = 0.5f;
            int n11 = h2.b(f10);
            float f11 = n11;
            int n12 = 0;
            float f12 = 0.0f;
            Object object3 = null;
            f10 = h2.b(f10);
            int n13 = this.y;
            object.setShadowLayer(f11, 0.0f, f10, n13);
            n10 = 0;
            object = null;
            f10 = 0.0f;
            for (int i10 = 0; i10 < (n11 = ((long[])(object2 = this.D)).length); ++i10) {
                int n14;
                object2 = this.L;
                object3 = i10;
                object2 = (Bitmap)object2.get(object3);
                object3 = new StringBuilder();
                long[] lArray = this.D;
                long l10 = lArray[i10];
                n13 = 1;
                float f13 = l2.a(l10, n13);
                ((StringBuilder)object3).append(f13);
                String string2 = "S";
                ((StringBuilder)object3).append(string2);
                object3 = ((StringBuilder)object3).toString();
                f13 = this.l;
                float f14 = i10;
                float f15 = this.j;
                float f16 = this.k + f15;
                f13 += (f14 *= f16);
                int n15 = 0x40000000;
                f14 = 2.0f;
                f13 += (f15 /= f14);
                Paint paint = this.c;
                f15 = d2.d(paint, (String)object3) / f14;
                f13 -= f15;
                int n16 = this.K;
                if (n16 != 0 && object2 != null) {
                    n16 = this.g;
                    f16 = 6.0f;
                    n14 = h2.b(f16);
                    n16 = (n16 - n14) / 2;
                } else {
                    n16 = 0;
                    paint = null;
                    f15 = 0.0f;
                }
                f15 = n16;
                f13 -= f15;
                n16 = this.g;
                f15 = n16;
                Paint paint2 = this.c;
                f16 = d2.b(paint2);
                f15 = (f15 + f16) / f14;
                Paint paint3 = this.c;
                canvas.drawText((String)object3, f13, f15, paint3);
                n15 = (int)(this.K ? 1 : 0);
                if (n15 == 0 || object2 == null) continue;
                n16 = object2.getWidth();
                n14 = object2.getHeight();
                paint3 = new Rect(0, 0, n16, n14);
                paint = this.c;
                f12 = d2.d(paint, (String)object3);
                f13 += f12;
                f12 = h2.b(4.0f);
                n12 = (int)(f13 += f12);
                f15 = 5.0f;
                n14 = h2.b(f15);
                int n17 = this.g + n12;
                float f17 = 10.0f;
                int n18 = h2.b(f17);
                n17 -= n18;
                n18 = this.g;
                n16 = h2.b(f15);
                string2 = new Rect(n12, n14, n17, n18 -= n16);
                object3 = new Paint(n13);
                canvas.drawBitmap((Bitmap)object2, (Rect)paint3, (Rect)string2, (Paint)object3);
            }
        }
    }

    private void getAllColor() {
        int n10;
        Context context = this.getContext();
        int n11 = this.m;
        this.p = n10 = d.v.f.i.g.c(context, n11);
        context = this.getContext();
        n11 = this.n;
        this.q = n10 = d.v.f.i.g.c(context, n11);
        context = this.getContext();
        n11 = this.o;
        this.r = n10 = d.v.f.i.g.c(context, n11);
        context = this.getContext();
        n11 = this.t;
        this.u = n10 = d.v.f.i.g.c(context, n11);
        context = this.getContext();
        n11 = this.x;
        this.y = n10 = d.v.f.i.g.c(context, n11);
    }

    private void h() {
        Paint paint;
        this.b = paint = new Paint();
        int bl2 = this.q;
        paint.setColor(bl2);
        paint = this.b;
        boolean bl3 = true;
        paint.setAntiAlias(bl3);
        this.c = paint = new Paint();
        int n10 = this.w;
        paint.setColor(n10);
        paint = this.c;
        float f10 = this.v;
        paint.setTextSize(f10);
        this.c.setAntiAlias(bl3);
        paint = ResourcesCompat.getFont(this.getContext(), 2131296257);
        this.c.setTypeface((Typeface)paint);
    }

    private /* synthetic */ void i() {
        float[] fArray;
        int n10;
        int n11 = this.E;
        if (n11 >= 0 && n11 < (n10 = (fArray = this.H).length)) {
            Rect rect = new Rect();
            this.getLocalVisibleRect(rect);
            fArray = this.H;
            int n12 = this.E;
            float f10 = fArray[n12];
            int n13 = rect.left;
            float f11 = n13;
            int n14 = (int)(f10 -= f11);
            float f12 = fArray[n12];
            float f13 = this.j;
            f12 += f13;
            f13 = n13;
            n10 = (int)(f12 -= f13);
            n12 = 0;
            f13 = 0.0f;
            if (n14 < 0) {
                float f14 = this.k;
                n11 = (int)f14 / 2;
                this.scrollBy(n14 -= n11, 0);
            } else {
                n14 = rect.width();
                if (n10 > n14) {
                    n11 = rect.width();
                    n10 -= n11;
                    float f15 = this.k;
                    n11 = (int)f15 / 2;
                    this.scrollBy(n10 += n11, 0);
                }
            }
        }
    }

    private /* synthetic */ void k() {
        Object object = this.H;
        float f10 = object[0];
        int n10 = 0;
        float[] fArray = null;
        float f11 = f10 - 0.0f;
        Object object2 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object2 < 0) {
            object2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            object2 = false;
            object = null;
            f10 = 0.0f;
        }
        this.M = object2;
        if (object2 != false) {
            object = new Rect;
            object();
            this.getLocalVisibleRect((Rect)object);
            object2 = object.left;
            fArray = this.H;
            float f12 = fArray[0];
            int n11 = (int)f12;
            float f13 = this.k;
            int n12 = (int)f13 / 2;
            if (object2 != (n11 -= n12)) {
                f10 = fArray[0];
                object2 = (int)f10;
                n10 = (int)f13 / 2;
                this.scrollBy((int)(object2 -= n10), 0);
            }
        }
    }

    private void n() {
        boolean bl2 = this.M;
        if (bl2) {
            h h10 = new h(this);
            this.post(h10);
        }
    }

    private void p(float f10, float f11, float f12, float f13) {
        float[] fArray = this.G;
        fArray[0] = f10;
        fArray[1] = f10;
        fArray[2] = f11;
        fArray[3] = f11;
        fArray[4] = f12;
        fArray[5] = f12;
        fArray[6] = f13;
        fArray[7] = f13;
    }

    public void e() {
        super.e();
        this.getAllColor();
        this.postInvalidate();
    }

    public long[] getDurationArray() {
        return this.D;
    }

    public int getMax() {
        return 100;
    }

    public int getProgress() {
        return this.z;
    }

    public int getStoryCount() {
        return this.B;
    }

    public /* synthetic */ void j() {
        this.i();
    }

    public /* synthetic */ void l() {
        this.k();
    }

    public void m() {
        this.L.clear();
        this.postInvalidate();
    }

    public void o(int n10, int n11, boolean bl2, int[] nArray, long[] lArray) {
        this.scrollTo(0, 0);
        this.z = 0;
        this.E = n11;
        this.B = n10;
        this.F = bl2;
        this.C = nArray;
        this.D = lArray;
        Object object = new float[n10];
        this.H = object;
        this.requestLayout();
        object = new i;
        object(this);
        this.post((Runnable)object);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.a(canvas);
        this.f(canvas);
        this.d(canvas);
        this.g(canvas);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = View.MeasureSpec.getSize((int)n10);
        this.g = n11 = View.MeasureSpec.getSize((int)n11);
        n11 = this.B;
        int n12 = 1;
        float f10 = Float.MIN_VALUE;
        float f11 = n11 == n12 ? this.i : this.h;
        this.j = f11;
        float f12 = n10;
        float f13 = (float)n11 * f11;
        float f14 = n11 - n12;
        f10 = this.k;
        this.l = f12 = (f12 - (f13 += (f14 *= f10))) / 2.0f;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block25: {
            block23: {
                block24: {
                    block27: {
                        block28: {
                            block26: {
                                var2_2 /* !! */  = new Rect();
                                this.getLocalVisibleRect(var2_2 /* !! */ );
                                var3_3 = var1_1.getAction();
                                var4_4 = 1;
                                var5_5 = 1.4E-45f;
                                if (var3_3 == 0) break block23;
                                var7_7 = 0.0f;
                                if (var3_3 == var4_4) break block24;
                                var8_8 = 2;
                                var9_10 = 2.8E-45f;
                                if (var3_3 != var8_8 || (var3_3 = this.M) == 0) break block25;
                                var10_13 = var1_1.getX();
                                var3_3 = (int)var10_13;
                                var8_8 = this.I;
                                var3_3 -= var8_8;
                                var8_8 = 0x40000000;
                                var9_10 = 2.0f;
                                if (var3_3 <= 0) break block26;
                                var11_16 = var2_2 /* !! */ .left;
                                var12_20 = this.k / var9_10;
                                var11_16 += var12_20;
                                var13_23 = this.H;
                                var9_10 = var13_23[0];
                                var14_25 = (int)(var11_16 -= var9_10);
                                if (var3_3 <= var14_25) break block27;
                                break block28;
                            }
                            var15_29 = this.H;
                            var12_21 = -var15_29[0];
                            var16_30 = this.getWidth();
                            var17_32 = var16_30;
                            var12_21 += var17_32;
                            var11_16 = var2_2 /* !! */ .right;
                            var12_21 -= var11_16;
                            var11_16 = this.k / var9_10;
                            var14_25 = -((int)(var12_21 += var11_16));
                            if (var3_3 >= var14_25) break block27;
                        }
                        var3_3 = var14_25;
                    }
                    if (var3_3 == 0) {
                        var14_25 = 0;
                        var2_2 /* !! */  = null;
                        var11_16 = 0.0f;
                    } else {
                        var14_25 = var4_4;
                        var11_16 = var5_5;
                    }
                    if (var14_25 != 0) {
                        var14_25 = -var3_3;
                        this.scrollBy(var14_25, 0);
                    }
                    var11_16 = var1_1.getX();
                    this.I = var14_25 = (int)var11_16;
                    var18_33 = var1_1.getY();
                    this.J = var19_37 = (int)var18_33;
                    break block25;
                }
                var3_3 = (int)this.M;
                if (var3_3 != 0) {
                    var20_41 = System.currentTimeMillis();
                    var22_42 = this.P;
                    var20_41 -= var22_42;
                    var10_14 = var1_1.getX();
                    var3_3 = (int)var10_14;
                    var16_31 = this.N;
                    var3_3 -= var16_31;
                    var18_34 = var1_1.getY();
                    var19_38 = (int)var18_34;
                    var16_31 = this.O;
                    var19_38 -= var16_31;
                    var22_42 = 200L;
                    cfr_temp_0 = var20_41 - var22_42;
                    var8_9 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var8_9 /* !! */  < 0) {
                        var8_9 /* !! */  = 20;
                        var9_11 = 2.8E-44f;
                        if (var3_3 < var8_9 /* !! */  && var19_38 < var8_9 /* !! */ ) {
                            var19_38 = this.I;
                            var10_14 = var19_38;
                            var13_24 = this.H;
                            var12_22 = var13_24[0];
                            var16_31 = var2_2 /* !! */ .left;
                            var24_43 = var16_31;
                            cfr_temp_1 = var10_14 - (var12_22 -= var24_43);
                            var3_3 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1));
                            if (var3_3 >= 0) {
                                var18_34 = var19_38;
                                var3_3 = var13_24.length - var4_4;
                                var10_14 = var13_24[var3_3];
                                var9_11 = var16_31;
                                var10_14 -= var9_11;
                                var9_11 = this.j;
                                cfr_temp_2 = var18_34 - (var10_14 += var9_11);
                                var19_38 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1));
                                if (var19_38 <= 0 && (var19_38 = this.J) < (var3_3 = this.g)) {
                                    for (var6_6 = 0; var6_6 < (var19_38 = this.B - var4_4); ++var6_6) {
                                        var19_38 = this.I;
                                        var10_14 = var19_38;
                                        var13_24 = this.H;
                                        var12_22 = var13_24[var6_6];
                                        var16_31 = var2_2 /* !! */ .left;
                                        var24_43 = var16_31;
                                        cfr_temp_3 = var10_14 - (var12_22 -= var24_43);
                                        var3_3 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1));
                                        if (var3_3 <= 0) continue;
                                        var18_34 = var19_38;
                                        var3_3 = var6_6 + 1;
                                        var10_14 = var13_24[var3_3];
                                        var9_11 = var16_31;
                                        cfr_temp_4 = var18_34 - (var10_14 -= var9_11);
                                        var19_38 = (int)(cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 < 0.0f ? -1 : 1));
                                        if (var19_38 >= 0) continue;
                                        var1_1 = this.Q;
                                        if (var1_1 == null) break;
                                        var1_1.a(var6_6);
                                        break;
                                    }
                                    var18_34 = this.I;
                                    var25_44 = this.H;
                                    var6_6 = var25_44.length - var4_4;
                                    var7_7 = var25_44[var6_6];
                                    var14_26 = var2_2 /* !! */ .left;
                                    var11_17 = var14_26;
                                    cfr_temp_5 = var18_34 - (var7_7 -= var11_17);
                                    var19_38 = (int)(cfr_temp_5 == 0.0f ? 0 : (cfr_temp_5 > 0.0f ? 1 : -1));
                                    if (var19_38 >= 0 && (var1_1 = this.Q) != null) {
                                        var14_26 = var25_44.length - var4_4;
                                        var1_1.a(var14_26);
                                        ** GOTO lbl164
                                    }
                                }
                            }
                        }
                    }
                } else {
                    var1_1 = this.H;
                    if (var1_1 != null && (var3_3 = (int)((cfr_temp_6 = (var10_15 = (float)(var14_27 = this.I)) - (var9_12 = var1_1[0])) == 0.0f ? 0 : (cfr_temp_6 > 0.0f ? 1 : -1))) >= 0) {
                        var11_18 = var14_27;
                        var3_3 = ((MotionEvent)var1_1).length - var4_4;
                        var18_35 = var1_1[var3_3];
                        var10_15 = this.j;
                        cfr_temp_7 = var11_18 - (var18_35 += var10_15);
                        var19_39 /* !! */  = (float)(cfr_temp_7 == 0.0f ? 0 : (cfr_temp_7 < 0.0f ? -1 : 1));
                        if (var19_39 /* !! */  <= 0 && (var19_39 /* !! */  = (float)this.J) < (var14_27 = this.g)) {
                            while (var6_6 < (var14_27 = ((MotionEvent)(var1_1 = (Object)this.H)).length - var4_4)) {
                                var14_27 = this.I;
                                var10_15 = var14_27;
                                var9_12 = var1_1[var6_6];
                                cfr_temp_8 = var10_15 - var9_12;
                                var3_3 = (int)(cfr_temp_8 == 0.0f ? 0 : (cfr_temp_8 > 0.0f ? 1 : -1));
                                if (var3_3 >= 0 && (var19_39 /* !! */  = (cfr_temp_9 = (var11_18 = (float)var14_27) - (var18_35 = var1_1[var3_3 = var6_6 + 1])) == 0.0f ? 0 : (cfr_temp_9 < 0.0f ? -1 : 1)) < 0) {
                                    var1_1 = this.Q;
                                    if (var1_1 == null) break;
                                    var1_1.a(var6_6);
                                    break;
                                }
                                ++var6_6;
                            }
                            if ((var19_39 /* !! */  = (float)((cfr_temp_10 = (var18_35 = (MotionEvent)((float)this.I)) - (var10_15 = (float)(var2_2 /* !! */  = (Rect)this.H)[var3_3 = ((Rect)var2_2 /* !! */ ).length - var4_4])) == 0 ? 0 : (cfr_temp_10 > 0 ? 1 : -1))) >= 0 && (var1_1 = this.Q) != null) {
                                var14_27 = ((Rect)var2_2 /* !! */ ).length - var4_4;
                                var1_1.a(var14_27);
                            }
                        }
                    }
                }
                break block25;
            }
            var11_19 = var1_1.getX();
            this.I = var14_28 = (int)var11_19;
            var18_36 = var1_1.getY();
            this.J = var19_40 = (int)var18_36;
            this.N = var14_28 = this.I;
            this.O = var19_40;
            this.P = var26_45 = System.currentTimeMillis();
        }
        return (boolean)var4_4;
    }

    public void onVisibilityChanged(View view, int n10) {
        super.onVisibilityChanged(view, n10);
        if (n10 == 0) {
            this.n();
        }
    }

    public void q(int n10, boolean bl2) {
        this.z = 0;
        this.E = n10;
        this.F = bl2;
        this.postInvalidate();
        n10 = this.getVisibility();
        if (n10 == 0) {
            this.n();
        }
    }

    public void r(int n10, Bitmap bitmap) {
        Map map = this.L;
        Integer n11 = n10;
        map.put(n11, bitmap);
        this.postInvalidate();
    }

    public void setOnStoryItemClickListener(StoryProgressBar$a storyProgressBar$a) {
        this.Q = storyProgressBar$a;
    }

    public void setProgress(int n10) {
        this.F = true;
        this.z = n10;
        this.postInvalidate();
    }
}

