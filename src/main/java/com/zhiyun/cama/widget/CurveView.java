/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.DashPathEffect
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.widget.CurveView$a;
import d.v.c.b2.b;
import d.v.e.l.c2;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.n2;
import d.v.f.i.g;
import d.v.v.q.d;
import d.v.v.q.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CurveView
extends View {
    private static final int O = 20;
    private static final long P = 500000L;
    private Rect A;
    public float B;
    public float C;
    public int D;
    public PointF E;
    private RectF F;
    private PointF G;
    private int H;
    private int I;
    private String J;
    private double K;
    private PointF L;
    private long M;
    private String N;
    private final int a;
    private final int b;
    private final int c;
    private final int d;
    private final double e;
    private final double f;
    private final double g;
    private List h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private Paint m;
    private Paint n;
    private Paint o;
    private Paint p;
    private int q;
    private int r;
    private Path s;
    private float t;
    private long u;
    private float v;
    private boolean w;
    private CurveView$a x;
    private m2$d y;
    private Bitmap z;

    public CurveView(Context context) {
        this(context, null);
    }

    public CurveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CurveView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        ArrayList arrayList;
        double d10;
        int n11;
        int n12;
        float f10 = 20.0f;
        this.a = n12 = h2.b(f10);
        this.b = n11 = h2.b(f10);
        this.c = 6;
        this.d = n11 = h2.b(8.0f);
        this.e = 0.125;
        this.f = d10 = 1.0;
        this.g = 4.0;
        this.h = arrayList = new ArrayList();
        this.B = 0.0f;
        this.C = 0.0f;
        this.D = n10 = -1;
        this.E = null;
        this.H = n10;
        this.I = n10;
        this.K = d10;
        this.M = -1;
        this.n();
    }

    private void A() {
        boolean bl2;
        m2$d m2$d = this.y;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            m2$d = this.y;
            m2$d.a();
        }
        b b10 = new b(this);
        this.y = m2$d = m2.Y(1000L, b10);
    }

    private void C() {
        boolean bl2;
        int n10 = this.a;
        float f10 = n10;
        int n11 = this.b;
        float f11 = n11;
        int n12 = this.q;
        float f12 = n10 + n12;
        n12 = this.r;
        float f13 = n11 + n12;
        Object object = new RectF(f10, f11, f12, f13);
        this.F = object;
        n10 = this.a;
        float f14 = n10;
        float f15 = n10;
        float f16 = this.q + n10;
        float f17 = n10;
        int n13 = Color.rgb((int)145, (int)133, (int)255);
        n10 = 54;
        f12 = 7.6E-44f;
        int n14 = 143;
        f10 = 2.0E-43f;
        n11 = 244;
        f13 = 3.42E-43f;
        int n15 = Color.rgb((int)n10, (int)n14, (int)n11);
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        object = new LinearGradient(f14, f15, f16, f17, n13, n15, tileMode);
        Paint paint = this.i;
        paint.setShader((Shader)object);
        object = this.J;
        if (object != null && (bl2 = (object = this.h).isEmpty())) {
            object = this.J;
            this.r((String)object);
        }
    }

    private void b() {
        boolean bl2;
        m2$d m2$d = this.y;
        if (m2$d != null && !(bl2 = m2$d.b())) {
            m2$d = this.y;
            m2$d.a();
        }
    }

    private void c(Canvas canvas) {
        float f10 = this.v;
        float f11 = this.z.getWidth();
        float f12 = 2.0f;
        f10 -= (f11 /= f12);
        f11 = this.b;
        float f13 = this.v;
        float f14 = (float)this.z.getWidth() / f12;
        int n10 = this.r;
        int n11 = this.b;
        f12 = n10 + n11;
        RectF rectF = new RectF(f10, f11, f13 += f14, f12);
        Bitmap bitmap = this.z;
        Rect rect = this.A;
        Paint paint = this.m;
        canvas.drawBitmap(bitmap, rect, rectF, paint);
    }

    private void d(Canvas canvas) {
        List list;
        int n10;
        this.s.reset();
        int n11 = 0;
        while (n11 < (n10 = (list = this.h).size() + -1)) {
            list = (PointF)this.h.get(n11);
            List list2 = this.h;
            list2 = (PointF)list2.get(++n11);
            float f10 = ((PointF)list2).x;
            float f11 = ((PointF)list).x;
            f10 -= f11;
            Path path = this.s;
            float f12 = ((PointF)list).y;
            path.moveTo(f11, f12);
            Path path2 = this.s;
            f11 = ((PointF)list).x;
            float f13 = 3.0f;
            float f14 = f11 + (f10 /= f13);
            float f15 = ((PointF)list).y;
            float f16 = ((PointF)list2).x;
            float f17 = f16 - f10;
            float f18 = ((PointF)list2).y;
            path2.cubicTo(f14, f15, f17, f18, f16, f18);
            list = this.s;
            list2 = this.i;
            canvas.drawPath((Path)list, (Paint)list2);
        }
    }

    private void e(Canvas canvas) {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.h).size()); ++i10) {
            Paint paint;
            int n11;
            float f10;
            float f11;
            float f12;
            list = (PointF)this.h.get(i10);
            int n12 = this.H;
            if (i10 == n12) {
                f12 = ((PointF)list).x;
                f11 = ((PointF)list).y;
                int n13 = this.d;
                float f13 = n13;
                Paint paint2 = this.k;
                canvas.drawCircle(f12, f11, f13, paint2);
                f12 = ((PointF)list).x;
                f10 = ((PointF)list).y;
                n11 = this.d;
                f11 = n11;
                paint = this.l;
                canvas.drawCircle(f12, f10, f11, paint);
                continue;
            }
            f12 = ((PointF)list).x;
            f10 = ((PointF)list).y;
            n11 = this.d;
            f11 = n11;
            paint = this.j;
            canvas.drawCircle(f12, f10, f11, paint);
        }
    }

    private void f(Canvas canvas) {
        RectF rectF;
        float f10 = (float)this.r / 4.0f;
        int n10 = this.a;
        float f11 = n10;
        int n11 = this.q;
        float f12 = n10 + n11;
        int n12 = this.a;
        float f13 = n12;
        int n13 = this.b;
        float f14 = n13;
        int n14 = this.q;
        float f15 = n12 + n14;
        n14 = this.r;
        float f16 = n13 + n14;
        this.F = rectF = new RectF(f13, f14, f15, f16);
        f15 = 6.0f;
        f13 = h2.b(f15);
        f15 = h2.b(f15);
        Paint paint = this.n;
        canvas.drawRoundRect(rectF, f13, f15, paint);
        n11 = this.b;
        f13 = (float)n11 + f10;
        f14 = (float)n11 + f10;
        Paint paint2 = this.o;
        rectF = canvas;
        f15 = f11;
        f16 = f12;
        canvas.drawLine(f11, f13, f12, f14, paint2);
        n11 = this.b;
        f15 = n11;
        f13 = 3.0f * f10;
        f16 = f15 + f13;
        f14 = (float)n11 + f13;
        paint2 = this.o;
        f15 = f11;
        f13 = f16;
        f16 = f12;
        canvas.drawLine(f11, f13, f12, f14, paint2);
        n11 = this.b;
        f15 = n11;
        f13 = f15 + (f10 *= 2.0f);
        f14 = (float)n11 + f10;
        paint2 = this.n;
        f15 = f11;
        canvas.drawLine(f11, f13, f12, f14, paint2);
    }

    private void g(Canvas canvas) {
        float f10 = this.p.ascent();
        float f11 = this.p.descent();
        f10 = Math.abs(f10 + f11);
        int n10 = this.a;
        float f12 = 6.0f;
        int n11 = h2.b(f12);
        f11 = n10 + n11;
        n11 = this.b;
        int n12 = h2.b(f12);
        float f13 = (float)(n11 + n12) + f10;
        Paint paint = this.p;
        canvas.drawText("4X", f11, f13, paint);
        int n13 = this.a;
        n10 = h2.b(f12);
        f10 = n13 + n10;
        n10 = this.b;
        n11 = this.r;
        n10 += n11;
        n11 = h2.b(f12);
        f11 = n10 - n11;
        Paint paint2 = this.p;
        canvas.drawText("1/8X", f10, f11, paint2);
        paint = this.p;
        String string2 = this.N;
        f10 = paint.measureText(string2);
        string2 = this.N;
        f13 = this.a;
        float f14 = ((float)this.q - f10) / 2.0f;
        n13 = this.b;
        n12 = this.r;
        int n14 = h2.b(f12);
        f10 = (n13 += n12) - n14;
        Paint paint3 = this.p;
        canvas.drawText(string2, f13 += f14, f10, paint3);
    }

    private int j(float f10, float f11) {
        List list;
        int n10;
        for (int i10 = 0; i10 < (n10 = (list = this.h).size()); ++i10) {
            float f12;
            float f13;
            Object object;
            list = (PointF)this.h.get(i10);
            float f14 = ((PointF)list).x;
            int n11 = this.d;
            float f15 = n11;
            f15 = f14 - f15;
            float f16 = 10.0f;
            float f17 = f10 - (f15 -= f16);
            Object object2 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object2 < 0 || (object = (f13 = f10 - (f14 = f14 + (f15 = (float)n11) + f16)) == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1)) > 0) continue;
            float f18 = ((PointF)list).y;
            f14 = n11;
            float f19 = f11 - (f14 = f18 - f14 - f16);
            object = f19 == 0.0f ? 0 : (f19 > 0.0f ? 1 : -1);
            if (object < 0 || (n10 = (int)((f12 = f11 - (f18 = f18 + (f14 = (float)n11) + f16)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1))) > 0) continue;
            return i10;
        }
        return -1;
    }

    private PointF k(float f10) {
        PointF pointF;
        block1: {
            List list;
            int n10;
            int n11 = 0;
            pointF = null;
            while (n11 < (n10 = (list = this.h).size() + -1)) {
                float f11;
                list = (PointF)this.h.get(n11);
                List list2 = this.h;
                list2 = (PointF)list2.get(++n11);
                float f12 = ((PointF)list).x;
                float f13 = f10 - f12;
                Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
                if (object <= 0 || (object = (f11 = f10 - (f12 = ((PointF)list2).x)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) >= 0) continue;
                pointF = new PointF();
                pointF.x = f10;
                double d10 = d.v.v.q.d.e(f10, (PointF)list, (PointF)list2);
                pointF.y = f10 = d.v.v.q.d.f(d10);
                break block1;
            }
            n11 = 0;
            pointF = null;
        }
        return pointF;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private String l(List var1_1) {
        var2_2 /* !! */  = this;
        var3_3 = var1_1;
        var4_4 = new StringBuilder();
        for (var5_5 = 0; var5_5 < (var6_6 = var1_1.size()); ++var5_5) {
            var7_7 = (PointF)var3_3.get(var5_5);
            var8_8 = var1_1.size() + -1;
            var9_9 = 0.0;
            if (var5_5 != var8_8) {
                var8_8 = var5_5 + 1;
                var11_10 = (PointF)var3_3.get(var8_8);
                var12_11 = var11_10.x;
                var13_12 = var7_7.x;
                var12_11 -= var13_12;
                var13_12 = var2_2 /* !! */ .t;
                var14_13 = var12_11 *= var13_12;
            } else {
                var14_13 = var9_9;
            }
            if (var5_5 != 0) {
                var8_8 = var5_5 + -1;
                var11_10 = (PointF)var3_3.get(var8_8);
                var16_14 = var7_7.x;
                var12_11 = var11_10.x;
                var16_14 -= var12_11;
                var12_11 = var2_2 /* !! */ .t;
                var9_9 = var16_14 *= var12_11;
            }
            var12_11 = var2_2 /* !! */ .t;
            var17_15 = var7_7.x;
            var18_16 = var2_2 /* !! */ .a;
            var19_17 = var18_16;
            var20_18 = var12_11 *= (var17_15 -= var19_17);
            var22_19 = 1.0;
            var20_18 *= var22_19;
            var8_8 = var2_2 /* !! */ .r;
            var24_20 = var8_8;
            var26_21 = 2.0;
            var28_22 = var7_7.y;
            var29_23 = var2_2 /* !! */ .b;
            var30_24 = var29_23;
            var30_24 = var28_22 - var30_24;
            var31_25 = var30_24;
            cfr_temp_0 = var31_25 - (var24_20 /= var26_21);
            var33_26 /* !! */  = cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1);
            var34_27 = 3.0;
            if (var33_26 /* !! */  < 0) {
                var36_28 = var29_23;
                var31_25 = var28_22 -= var36_28;
                var31_25 = (var24_20 - var31_25) / var24_20 * var34_27;
                var26_21 = 1.0;
                var22_19 = var31_25 + var26_21;
            } else {
                var26_21 = 1.0;
                var36_28 = var29_23;
                var31_25 = var36_28 = var28_22 - var36_28;
                cfr_temp_1 = var31_25 - var24_20;
                var33_26 /* !! */  = (double)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 > 0.0 ? 1 : -1));
                if (var33_26 /* !! */  > 0) {
                    var36_28 = (float)(var8_8 += var29_23) - var28_22;
                    var31_25 = (double)var36_28 / var24_20 * 0.875;
                    var37_29 = 0.125;
                    var22_19 = var31_25 + var37_29;
                } else {
                    var22_19 = var26_21;
                }
            }
            var2_2 /* !! */  = d.v.v.q.d.a(var4_4, var20_18, var22_19);
            if (var5_5 == 0) {
                var39_30 = var20_18 - (var14_13 /= var34_27);
lbl66:
                // 2 sources

                while (true) {
                    var20_18 += var14_13;
                    break;
                }
            } else {
                var41_31 = var1_1.size() + -1;
                if (var5_5 == var41_31) {
                    var39_30 = var20_18 - (var9_9 /= var34_27);
                    var20_18 += var9_9;
                } else {
                    var39_30 = var20_18 - (var9_9 /= var34_27);
                    var14_13 /= var34_27;
                    ** continue;
                }
            }
            var4_4 = d.v.v.q.d.a(d.v.v.q.d.a((StringBuilder)var2_2 /* !! */ , var39_30, var22_19), var20_18, var22_19);
            var2_2 /* !! */  = this;
            var3_3 = var1_1;
        }
        return var4_4.toString();
    }

    private double m(float f10) {
        int n10 = this.r;
        double d10 = n10;
        double d11 = 2.0;
        int n11 = this.b;
        float f11 = n11;
        f11 = f10 - f11;
        double d12 = f11;
        double d13 = d12 - (d10 /= d11);
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        double d14 = 1.0;
        if (object < 0) {
            float f12 = n11;
            d11 = f10 -= f12;
            d11 = (d10 - d11) / d10;
            double d15 = 3.0;
            d14 += (d11 *= d15);
        } else {
            f11 = n11;
            double d16 = f11 = f10 - f11;
            double d17 = d16 - d10;
            object = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
            if (object > 0) {
                float f13 = (float)(n10 += n11) - f10;
                d11 = (double)f13 / d10 * 0.875;
                double d18 = 0.125;
                d14 = d11 + d18;
            }
        }
        return d14;
    }

    private void n() {
        this.o();
        this.q();
        this.p();
    }

    private void o() {
        Bitmap bitmap;
        this.z = bitmap = BitmapFactory.decodeResource((Resources)this.getResources(), (int)2131231186);
        int n10 = this.z.getWidth();
        int n11 = this.z.getHeight();
        bitmap = new Rect(0, 0, n10, n11);
        this.A = bitmap;
    }

    private void p() {
        Object object;
        this.s = object = new Path();
        object = new ArrayList();
        this.h = object;
        object = new PointF();
        this.L = object;
        object = d.v.f.i.g.o(this.getResources(), 2131952128);
        this.N = object;
    }

    private void q() {
        float f10;
        float f11;
        Paint paint;
        this.i = paint = new Paint();
        int n10 = -65536;
        paint.setColor(n10);
        paint = this.i;
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        paint = this.i;
        float f12 = 5.0f;
        paint.setStrokeWidth(f12);
        paint = this.i;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        this.j = paint = new Paint();
        paint.setColor(-1);
        this.j.setAntiAlias(bl2);
        paint = this.j;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.k = paint = new Paint();
        int n11 = Color.rgb((int)67, (int)68, (int)81);
        paint.setColor(n11);
        this.k.setAntiAlias(bl2);
        paint = this.k;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.m = paint = new Paint();
        paint.setColor(n10);
        this.m.setAntiAlias(bl2);
        this.m.setStrokeWidth(f12);
        paint = this.m;
        Paint.Style style3 = Paint.Style.STROKE;
        paint.setStyle(style3);
        this.n = paint = new Paint();
        style3 = this.getResources();
        int n12 = 2131099773;
        n10 = style3.getColor(n12, null);
        paint.setColor(n10);
        this.n.setAntiAlias(bl2);
        paint = this.n;
        float f13 = 1.0f;
        float f14 = h2.b(f13);
        paint.setStrokeWidth(f14);
        paint = this.n;
        Paint.Style style4 = Paint.Style.STROKE;
        paint.setStyle(style4);
        this.o = paint = new Paint();
        n12 = this.getResources().getColor(n12, null);
        paint.setColor(n12);
        this.o.setAntiAlias(bl2);
        paint = this.o;
        f12 = h2.b(f13);
        paint.setStrokeWidth(f12);
        paint = this.o;
        Object object = Paint.Style.STROKE;
        paint.setStyle(object);
        paint = this.o;
        int n13 = 2;
        float[] fArray = new float[n13];
        float f15 = 6.0f;
        fArray[0] = f11 = (float)h2.b(f15);
        f11 = 3.0f;
        fArray[bl2] = f10 = (float)h2.b(f11);
        object = new DashPathEffect(fArray, 0.0f);
        paint.setPathEffect((PathEffect)object);
        this.l = paint = new Paint();
        n12 = this.getResources().getColor(2131099772, null);
        paint.setColor(n12);
        this.l.setAntiAlias(bl2);
        paint = this.l;
        f13 = h2.b(f13);
        paint.setStrokeWidth(f13);
        paint = this.l;
        style3 = Paint.Style.STROKE;
        paint.setStyle(style3);
        paint = this.l;
        object = new float[n13];
        f14 = h2.b(f15);
        object[0] = (Paint.Style)f14;
        f14 = h2.b(f11);
        object[bl2] = (Paint.Style)f14;
        style3 = new DashPathEffect((float[])object, 0.0f);
        paint.setPathEffect((PathEffect)style3);
        this.p = paint = new Paint();
        n10 = this.getResources().getColor(2131099780, null);
        paint.setColor(n10);
        this.p.setAntiAlias(bl2);
        paint = this.p;
        style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        paint = this.p;
        f13 = h2.g(10.0f);
        paint.setTextSize(f13);
    }

    private void r(String string2) {
        CurveView curveView = this;
        Object object = this.h;
        if (object == null) {
            object = new ArrayList();
            this.h = object;
        }
        object = curveView.h;
        object.clear();
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        double d10 = 3.0;
        double d11 = 0.875;
        float f10 = 2.0f;
        int n11 = 0;
        float f11 = 0.0f;
        PointF pointF = null;
        double d12 = 1.0;
        if (n10 == 0) {
            PointF pointF2;
            float f12;
            int n12;
            Object object2 = string2;
            object = string2.split("\\)");
            int n13 = 0;
            object2 = null;
            float f13 = 0.0f;
            while (true) {
                int n14 = ((String[])object).length;
                n12 = 1;
                if (n13 >= n14) break;
                Object object3 = object[n13].substring(n12).split(",");
                String string3 = object3[0];
                f12 = Float.parseFloat(string3);
                float f14 = Float.parseFloat(object3[n12]);
                pointF2 = new PointF();
                pointF2.x = f12;
                pointF2.y = f14;
                object3 = curveView.h;
                object3.add(pointF2);
                n13 += 3;
            }
            object = curveView.h;
            n13 = object.size() - n12;
            object = (PointF)object.get(n13);
            object2 = curveView.h;
            pointF = (PointF)object2.get(0);
            f11 = pointF.x;
            float f15 = ((PointF)object).x - f11;
            n13 = curveView.r;
            f13 = (float)n13 / f10;
            double d13 = f13;
            Iterator iterator2 = curveView.h.iterator();
            while ((n12 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
                float f16;
                double d14;
                pointF2 = (PointF)iterator2.next();
                f12 = (pointF2.x - f11) / f15;
                float f17 = curveView.q;
                f12 *= f17;
                f17 = curveView.a;
                pointF2.x = f12 += f17;
                f12 = pointF2.y;
                double d15 = f12;
                double d16 = d15 - d12;
                Object object4 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
                if (object4 > 0) {
                    d14 = ((double)f12 - d12) / d10 * d13;
                    d14 = d13 - d14;
                    int n15 = curveView.b;
                    d10 = n15;
                    pointF2.y = f16 = (float)(d14 += d10);
                } else {
                    d10 = f12;
                    double d17 = d10 - d12;
                    Object object5 = d17 == 0.0 ? 0 : (d17 < 0.0 ? -1 : 1);
                    if (object5 < 0) {
                        d10 = ((double)f12 - 0.125) / d11 * d13;
                        d10 = d13 - d10 + d13;
                        int n16 = curveView.b;
                        d14 = n16;
                        pointF2.y = f16 = (float)(d10 += d14);
                    } else {
                        object5 = curveView.b;
                        d10 = (double)object5 + d13;
                        pointF2.y = f16 = (float)d10;
                    }
                }
                d10 = 3.0;
            }
            object = curveView.h;
            object = curveView.l((List)object);
            curveView.w((String)object);
        } else {
            float f18;
            n10 = curveView.q / 5;
            int n17 = curveView.r;
            float f19 = (float)n17 / f10;
            double d18 = curveView.K;
            double d19 = d18 - d12;
            Object object6 = d19 == 0.0 ? 0 : (d19 > 0.0 ? 1 : -1);
            if (object6 > 0) {
                object6 = curveView.b;
                double d20 = object6;
                double d21 = f19;
                d12 = 4.0 - d18;
                d18 = 3.0;
                f19 = (float)(d20 += (d21 *= (d12 /= d18)));
            } else {
                object6 = curveView.b;
                f18 = (float)object6 + f19;
                double d22 = f18;
                d10 = f19;
                d12 = (d12 - d18) / d11;
                f19 = (float)(d22 += (d10 *= d12));
            }
            while (true) {
                object6 = 6;
                f18 = 8.4E-45f;
                if (n11 >= object6) break;
                object6 = curveView.a;
                int n18 = n10 * n11;
                f18 = (float)(object6 += n18);
                List list = curveView.h;
                PointF pointF3 = new PointF(f18, f19);
                list.add(pointF3);
                ++n11;
            }
            float f20 = curveView.v;
            f19 = 0.0f;
            float f21 = f20 - 0.0f;
            n17 = (int)(f21 == 0.0f ? 0 : (f21 > 0.0f ? 1 : -1));
            if (n17 == 0) {
                n10 = curveView.a;
                f20 = n10;
            }
            curveView.v = f20;
        }
        this.invalidate();
    }

    private boolean s(String string2) {
        long l10;
        long l11 = d.v.v.q.h.u(string2);
        long l12 = l11 - (l10 = 500000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            object = 1;
        } else {
            object = 0;
            string2 = null;
        }
        return (boolean)object;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private boolean t(float f10, float f11) {
        void var4_7;
        PointF pointF;
        this.G = pointF = this.k(f10);
        if (pointF != null) {
            f10 = pointF.y;
            float f12 = (f10 = Math.abs(f11 - f10)) - (f11 = 20.0f);
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object < 0) {
                return (boolean)var4_7;
            }
        }
        boolean bl2 = false;
        return (boolean)var4_7;
    }

    private /* synthetic */ void u() {
        int n10 = this.D;
        int n11 = -1;
        float f10 = 0.0f / 0.0f;
        if (n10 != n11) {
            List list;
            if (n10 != 0 && n10 != (n11 = (list = this.h).size() + -1)) {
                this.I = n10 = this.D;
                CurveView$a curveView$a = this.x;
                if (curveView$a != null && (list = this.E) != null) {
                    float f11 = ((PointF)list).x;
                    f10 = ((PointF)list).y;
                    curveView$a.a(f11, f10);
                }
            }
        } else {
            Object object = this.G;
            if (object != null) {
                object = this.h;
                n10 = object.size();
                n11 = 20;
                f10 = 2.8E-44f;
                if (n10 < n11) {
                    object = this.G;
                    this.z((PointF)object);
                    object = this.x;
                    if (object != null) {
                        PointF pointF = this.G;
                        float f12 = pointF.x;
                        f10 = pointF.y;
                        object.e(f12, f10);
                    }
                }
            }
        }
    }

    private void w(String string2) {
        CurveView$a curveView$a = this.x;
        if (curveView$a != null) {
            curveView$a.c(string2);
        }
    }

    private void x() {
        CurveView$a curveView$a = this.x;
        if (curveView$a != null) {
            float f10 = this.v;
            int n10 = this.a;
            float f11 = n10;
            f10 -= f11;
            f11 = this.t;
            long l10 = (long)(f10 *= f11);
            curveView$a.d(l10);
        }
    }

    private void z(PointF pointF) {
        float f10;
        List list;
        int n10;
        int n11;
        this.H = n11 = -1;
        int n12 = 0;
        float f11 = 0.0f;
        while (n12 < (n10 = (list = this.h).size() + -1)) {
            float f12;
            list = (PointF)this.h.get(n12);
            List list2 = this.h;
            list2 = (PointF)list2.get(++n12);
            float f13 = pointF.x;
            f10 = ((PointF)list).x;
            float f14 = f13 - f10;
            n10 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
            if (n10 <= 0 || (n10 = (int)((f12 = f13 - (f10 = ((PointF)list2).x)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1))) >= 0) continue;
            this.H = n12;
            break;
        }
        if ((n12 = this.H) != n11) {
            f11 = pointF.x;
            f10 = pointF.y;
            Object object = new PointF(f11, f10);
            this.L = object;
            object = this.h;
            n12 = this.H;
            object.add(n12, pointF);
            this.invalidate();
        }
    }

    public void B(long l10) {
        float f10 = l10;
        float f11 = this.u;
        f10 /= f11;
        f11 = this.a;
        float f12 = this.q;
        this.v = f11 += (f10 *= f12);
        this.invalidate();
    }

    public void a() {
        int n10 = this.H;
        int n11 = -1;
        if (n10 != n11) {
            List list = this.h;
            list.remove(n10);
            this.H = n11;
            n10 = 0;
            this.G = null;
            this.invalidate();
        }
    }

    public long getCurrentPosition() {
        float f10 = this.v;
        float f11 = this.a;
        f10 -= f11;
        f11 = this.t;
        return (long)(f10 * f11);
    }

    public void h() {
        Object object = this.h;
        int n10 = this.s((String)(object = this.l((List)object)));
        if (n10 != 0) {
            this.w((String)object);
        } else {
            n2.e(d.v.f.i.g.m(this.getContext(), 2131952124));
            object = this.h;
            n10 = this.H;
            object.remove(n10);
        }
        this.H = -1;
        this.G = null;
        this.invalidate();
    }

    public void i() {
        int n10 = this.I;
        int n11 = -1;
        if (n10 != n11) {
            PointF pointF;
            Object object = (PointF)this.h.get(n10);
            float f10 = ((PointF)object).x;
            float f11 = ((PointF)object).y;
            this.L = pointF = new PointF(f10, f11);
            object = this.h;
            int n12 = this.I;
            object.remove(n12);
            object = this.h;
            object = this.l((List)object);
            n12 = (int)(this.s((String)object) ? 1 : 0);
            if (n12 != 0) {
                this.w((String)object);
            } else {
                n2.e(d.v.f.i.g.m(this.getContext(), 2131952124));
                object = this.h;
                n12 = this.I;
                PointF pointF2 = this.L;
                object.add(n12, pointF2);
            }
            this.I = n11;
            this.invalidate();
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f(canvas);
        this.g(canvas);
        this.d(canvas);
        this.c(canvas);
        this.e(canvas);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        n12 = this.a;
        n13 = n12 * 2;
        this.q = n10 -= n13;
        n11 -= n12;
        n12 = this.b;
        this.r = n11 -= n12;
        long l10 = this.u;
        long l11 = 0L;
        n13 = (int)(l10 == l11 ? 0 : (l10 < l11 ? -1 : 1));
        if (n13 != 0) {
            float f10 = l10;
            float f11 = n10;
            this.t = f10 /= f11;
            long l12 = this.M;
            long l13 = -1;
            long l14 = l12 - l13;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                this.setInitPosition(l12);
                this.M = l13;
            }
        }
        this.C();
    }

    public boolean onTouchEvent(MotionEvent object) {
        int n10 = object.getAction();
        Object object2 = -1;
        float f10 = 0.0f / 0.0f;
        int n11 = 1;
        if (n10 != 0) {
            boolean bl2 = false;
            float f11 = 0.0f;
            if (n10 != n11) {
                Object object3 = 2;
                float f12 = 2.8E-45f;
                if (n10 == object3) {
                    float f13 = object.getX();
                    float f14 = object.getY();
                    f12 = this.B;
                    f12 = Math.abs(f13 - f12);
                    int n12 = 1101004800;
                    float f15 = 20.0f;
                    float f16 = f12 - f15;
                    object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                    if (object3 < 0) {
                        f12 = this.C;
                        float f17 = (f12 = Math.abs(f14 - f12)) - f15;
                        object3 = f17 == 0.0f ? 0 : (f17 < 0.0f ? -1 : 1);
                        if (object3 < 0) {
                            return n11 != 0;
                        }
                    }
                    this.w = n11;
                    this.b();
                    f13 = Math.max((float)this.a, f13);
                    object3 = this.q;
                    n12 = this.a;
                    f13 = Math.min((float)(object3 + n12), f13);
                    f14 = Math.max((float)this.b, f14);
                    object3 = this.r;
                    n12 = this.b;
                    f12 = object3 + n12;
                    f14 = Math.min(f12, f14);
                    object3 = this.D;
                    if (object3 == object2) {
                        this.v = f13;
                    } else {
                        PointF pointF;
                        List list;
                        if (object3 != 0 && object3 != (object2 = (list = this.h).size() - n11)) {
                            float f18;
                            list = this.h;
                            object3 = this.D - n11;
                            list = (PointF)list.get((int)object3);
                            pointF = this.h;
                            n12 = this.D + n11;
                            pointF = (PointF)pointF.get(n12);
                            f10 = ((PointF)list).x;
                            n12 = this.d;
                            float f19 = n12;
                            float f20 = (f10 = f13 - f10) - f19;
                            object2 = f20 == 0.0f ? 0 : (f20 < 0.0f ? -1 : 1);
                            if (object2 >= 0 && (object2 = (Object)((f18 = (f10 = pointF.x - f13) - (f12 = (float)n12)) == 0.0f ? 0 : (f18 < 0.0f ? -1 : 1))) >= 0) {
                                list = this.E;
                                ((PointF)list).x = f13;
                            }
                        }
                        Object object4 = this.E;
                        object4.y = f14;
                        this.v = f13 = object4.x;
                        object4 = this.x;
                        if (object4 != null) {
                            double d10 = this.m(f14);
                            object = this.x;
                            pointF = new Object[n11];
                            d10 = c2.c(d10, n11);
                            pointF[0] = object4 = Double.valueOf(d10);
                            object4 = String.format("%sX", (Object[])pointF);
                            object.b(n11 != 0, (String)object4);
                        }
                    }
                    this.invalidate();
                    this.x();
                }
            } else {
                String string2;
                int n13 = this.D;
                if (n13 != object2 && (n13 = (int)(this.w ? 1 : 0)) != 0) {
                    object = this.h;
                    n10 = this.s((String)(object = this.l((List)object)));
                    if (n10 != 0) {
                        this.w((String)object);
                    } else {
                        float f21;
                        float f22;
                        object = this.E;
                        string2 = this.L;
                        ((PointF)object).x = f22 = ((PointF)string2).x;
                        ((PointF)object).y = f21 = ((PointF)string2).y;
                        this.invalidate();
                        object = this.getContext();
                        n10 = 2131952124;
                        f21 = 1.9540682E38f;
                        object = d.v.f.i.g.m((Context)object, n10);
                        n2.e((String)object);
                    }
                }
                if ((object = this.x) != null) {
                    string2 = "";
                    object.b(false, string2);
                }
                this.b();
                this.D = object2;
                n13 = 0;
                float f23 = 0.0f;
                object = null;
                this.E = null;
                this.w = false;
            }
        } else {
            int n14;
            float f24;
            float f25;
            this.B = f25 = object.getX();
            this.C = f24 = object.getY();
            this.v = f25 = this.B;
            this.D = n14 = this.j(f25, f24);
            if (n14 != object2) {
                object = (PointF)this.h.get(n14);
                PointF pointF = this.E = object;
                float f26 = pointF.x;
                f25 = pointF.y;
                object = new PointF(f26, f25);
                this.L = object;
                object = this.E;
                this.v = f24 = ((PointF)object).x;
            }
            f24 = this.a;
            f25 = this.v;
            this.v = f24 = Math.max(f24, f25);
            n10 = this.q;
            int n15 = this.a;
            f25 = n10 += n15;
            this.v = f24 = Math.min(f25, f24);
            n14 = this.D;
            if (n14 != object2 || (n14 = (int)(this.t(f24 = this.B, f25 = this.C) ? 1 : 0)) != 0) {
                this.A();
            }
            this.invalidate();
            this.x();
        }
        return n11 != 0;
    }

    public void setCurveSpeedCallback(CurveView$a curveView$a) {
        this.x = curveView$a;
    }

    public void setDuration(long l10) {
        this.u = l10;
        int n10 = this.q;
        if (n10 == 0) {
            return;
        }
        float f10 = l10;
        float f11 = n10;
        this.t = f10 /= f11;
        l10 = this.M;
        long l11 = -1;
        long l12 = l10 - l11;
        n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n10 != 0) {
            this.setInitPosition(l10);
        }
        this.invalidate();
    }

    public void setInitPosition(long l10) {
        this.M = l10;
        long l11 = this.u;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object != false && (object = (Object)this.q) != false) {
            float f10 = l10;
            float f11 = l11;
            f10 /= f11;
            int n10 = this.a;
            f11 = n10;
            float f12 = object;
            this.v = f11 += (f10 *= f12);
            this.invalidate();
            this.M = l10 = (long)-1;
        }
    }

    public void setSpeedPoint(String string2) {
        this.y(string2, 1.0);
    }

    public /* synthetic */ void v() {
        this.u();
    }

    public void y(String string2, double d10) {
        this.J = string2;
        this.K = d10;
        int n10 = this.q;
        if (n10 != 0) {
            this.r(string2);
        }
    }
}

