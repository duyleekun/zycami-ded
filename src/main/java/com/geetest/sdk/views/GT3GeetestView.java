/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorSet
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.geetest.sdk.views;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.model.beans.GT3ViewColor;
import com.geetest.sdk.model.beans.d;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.views.GT3GeetestView$a;
import com.geetest.sdk.views.GT3GeetestView$b;
import com.geetest.sdk.views.GT3GeetestView$c;

public class GT3GeetestView
extends View {
    private Paint a;
    private boolean aa = false;
    private double ab;
    private double ac;
    private int ad;
    private int ae;
    private int af;
    private ValueAnimator ag;
    private ValueAnimator ah;
    private int ai;
    private AnimatorSet aj;
    private Paint b;
    private Paint c;
    private Paint d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private float m;
    private Path n;
    private GT3GeetestView$c o;
    private int p;
    private int q;
    private Context s;
    private boolean t = false;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    private boolean z = false;

    public GT3GeetestView(Context context) {
        super(context);
        this.a(context);
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public GT3GeetestView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context);
    }

    public static /* synthetic */ int a(GT3GeetestView gT3GeetestView, int n10) {
        gT3GeetestView.ae = n10;
        return n10;
    }

    private void a(Context context) {
        this.s = context;
    }

    public static /* synthetic */ int b(GT3GeetestView gT3GeetestView, int n10) {
        gT3GeetestView.ai = n10;
        return n10;
    }

    public void a() {
        this.z = true;
        this.aa = false;
        this.y = false;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
    }

    public void b() {
        this.u = false;
        this.t = false;
        this.v = false;
        this.y = false;
        this.w = false;
        this.z = false;
        this.aa = true;
        this.x = false;
    }

    public void c() {
        this.y = true;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.z = false;
        this.aa = false;
    }

    public void d() {
        this.u = true;
        this.t = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.aa = false;
    }

    public void e() {
        this.ab = 0.0;
        this.t = true;
        this.u = false;
        this.v = false;
        this.w = false;
        this.x = false;
        this.y = false;
        this.z = false;
        this.aa = false;
    }

    public void f() {
        int n10;
        this.u = false;
        this.t = false;
        this.v = false;
        this.y = false;
        this.w = true;
        this.x = false;
        this.z = false;
        this.aa = false;
        this.af = n10 = this.p;
    }

    public void g() {
        int n10;
        this.ac = 0.0;
        this.ad = n10 = this.q;
        this.af = n10 = this.p;
        this.u = false;
        this.t = false;
        this.v = true;
        this.y = false;
        this.w = false;
        this.x = false;
        this.z = false;
        this.aa = false;
    }

    public void h() {
        int n10 = 2;
        Object object = new int[n10];
        object[0] = 0;
        object[1] = 300;
        object = ValueAnimator.ofInt((int[])object);
        this.ag = (ValueAnimator)object;
        long l10 = 700L;
        object.setDuration(l10);
        object = this.ag;
        GT3GeetestView$a gT3GeetestView$a = new GT3GeetestView$a(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)gT3GeetestView$a);
        object = new int[n10];
        object[0] = 0;
        object[1] = 255;
        object = ValueAnimator.ofInt((int[])object);
        this.ah = (ValueAnimator)object;
        object.setDuration(l10);
        object = this.ah;
        GT3GeetestView$b gT3GeetestView$b = new GT3GeetestView$b(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)gT3GeetestView$b);
        object = new AnimatorSet;
        object();
        this.aj = (AnimatorSet)object;
        Animator[] animatorArray = new Animator[n10];
        gT3GeetestView$b = this.ag;
        animatorArray[0] = gT3GeetestView$b;
        gT3GeetestView$b = this.ah;
        int n11 = 1;
        animatorArray[n11] = gT3GeetestView$b;
        object.playTogether(animatorArray);
        this.aj.start();
        this.u = false;
        this.t = false;
        this.v = false;
        this.y = false;
        this.w = false;
        this.z = false;
        this.aa = false;
        this.x = n11;
    }

    /*
     * Unable to fully structure code
     */
    public void onDraw(Canvas var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = this.s;
        var5_5 = new d();
        var6_6 = var5_5.f();
        this.q = var7_7 = com.geetest.sdk.utils.g.a(var4_4, var6_6);
        var4_4 = this.s;
        var5_5 = new d();
        var6_6 = var5_5.c();
        this.p = var7_7 = com.geetest.sdk.utils.g.a(var4_4, var6_6);
        var4_4 = this.s;
        var5_5 = new d();
        var8_8 = var5_5.a();
        var6_6 = var8_8;
        var7_7 = com.geetest.sdk.utils.g.a(var4_4, var6_6);
        var5_5 = this.s;
        var9_9 = new d();
        var10_10 = var9_9.h();
        var11_11 = com.geetest.sdk.utils.g.a((Context)var5_5, var10_10);
        var5_5 = this.s;
        var9_9 = new d();
        var10_10 = var9_9.g();
        var12_12 = com.geetest.sdk.utils.g.a((Context)var5_5, var10_10);
        var5_5 = this.s;
        var9_9 = new d();
        var10_10 = var9_9.e();
        var13_13 = com.geetest.sdk.utils.g.a((Context)var5_5, var10_10);
        var5_5 = this.s;
        var9_9 = new d();
        var10_10 = var9_9.d();
        var14_14 = com.geetest.sdk.utils.g.a((Context)var5_5, var10_10);
        var5_5 = new Path();
        this.n = var5_5;
        var15_15 = 1536;
        var5_5 = new Paint(var15_15);
        this.a = var5_5;
        var16_16 = 1;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.a;
        var17_17 = new GT3ViewColor();
        var18_18 = var17_17.getNormalColor();
        var5_5.setColor(var18_18);
        var5_5 = this.a;
        var19_19 = 1.0f;
        var5_5.setStrokeWidth(var19_19);
        var5_5 = this.a;
        var20_20 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.k = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.k;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getFaliColor();
        var5_5.setColor(var21_21);
        this.k.setStrokeWidth(var19_19);
        var5_5 = this.k;
        var20_20 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.b = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.b;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getAddColor();
        var5_5.setColor(var21_21);
        var5_5 = this.b;
        var22_22 = com.geetest.sdk.utils.g.a(this.s, var19_19);
        var5_5.setStrokeWidth(var22_22);
        var5_5 = this.b;
        var20_20 = Paint.Style.STROKE;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.c = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.c;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getAddColor();
        var5_5.setColor(var21_21);
        var5_5 = this.c;
        var20_20 = this.s;
        var23_23 = 0x40000000;
        var24_24 = 2.0f;
        var22_22 = com.geetest.sdk.utils.g.a((Context)var20_20, var24_24);
        var5_5.setStrokeWidth(var22_22);
        var5_5 = this.c;
        var20_20 = Paint.Style.STROKE;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.d = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.d;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getAddColor();
        var5_5.setColor(var21_21);
        this.d.setStrokeWidth(var19_19);
        var5_5 = this.d;
        var20_20 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.e = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.e;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getAddColor();
        var5_5.setColor(var21_21);
        this.e.setStrokeWidth(var19_19);
        var5_5 = this.e;
        var20_20 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var20_20);
        this.e.setAlpha(25);
        var5_5 = new Paint(var15_15);
        this.h = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.h;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getScanningColor();
        var5_5.setColor(var21_21);
        var5_5 = this.h;
        var22_22 = com.geetest.sdk.utils.g.a(this.s, var24_24);
        var5_5.setStrokeWidth(var22_22);
        var5_5 = this.h;
        var20_20 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var20_20);
        var5_5 = new Paint(var15_15);
        this.f = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.f;
        var20_20 = new GT3ViewColor();
        var21_21 = var20_20.getAddColor();
        var5_5.setColor(var21_21);
        var5_5 = this.f;
        var20_20 = this.s;
        var19_19 = com.geetest.sdk.utils.g.a((Context)var20_20, var19_19);
        var5_5.setStrokeWidth(var19_19);
        var5_5 = this.f;
        var17_17 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var17_17);
        this.f.setAlpha(50);
        var5_5 = new Paint(var15_15);
        this.g = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.g;
        var17_17 = new GT3ViewColor();
        var18_18 = var17_17.getWaitColor();
        var5_5.setColor(var18_18);
        var5_5 = this.g;
        var17_17 = this.s;
        var21_21 = 0x40800000;
        var22_22 = 4.0f;
        var19_19 = com.geetest.sdk.utils.g.a((Context)var17_17, var22_22);
        var5_5.setStrokeWidth(var19_19);
        var5_5 = this.g;
        var17_17 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var17_17);
        var5_5 = new Paint(var15_15);
        this.l = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.l;
        var17_17 = new GT3ViewColor();
        var18_18 = var17_17.getWaitColor();
        var5_5.setColor(var18_18);
        var5_5 = this.l;
        var19_19 = com.geetest.sdk.utils.g.a(this.s, var24_24);
        var5_5.setStrokeWidth(var19_19);
        var5_5 = this.l;
        var17_17 = Paint.Style.FILL;
        var5_5.setStyle((Paint.Style)var17_17);
        var5_5 = new Paint(var15_15);
        this.i = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.i;
        var17_17 = new GT3ViewColor();
        var18_18 = var17_17.getSuccessColor();
        var5_5.setColor(var18_18);
        var5_5 = this.i;
        var18_18 = com.geetest.sdk.utils.g.a(this.s, var24_24);
        var19_19 = var18_18;
        var5_5.setStrokeWidth(var19_19);
        var5_5 = this.i;
        var17_17 = Paint.Style.STROKE;
        var5_5.setStyle((Paint.Style)var17_17);
        var5_5 = new Paint(var15_15);
        this.j = var5_5;
        var5_5.setAntiAlias((boolean)var16_16);
        var5_5 = this.j;
        var9_9 = new GT3ViewColor();
        var15_15 = var9_9.getGogoColor();
        var5_5.setColor(var15_15);
        var5_5 = this.j;
        var9_9 = this.s;
        var16_16 = 0x40400000;
        var25_25 = 3.0f;
        var15_15 = com.geetest.sdk.utils.g.a((Context)var9_9, var25_25);
        var10_10 = var15_15;
        var5_5.setStrokeWidth(var10_10);
        var5_5 = this.j;
        var9_9 = Paint.Style.STROKE;
        var5_5.setStyle((Paint.Style)var9_9);
        this.postInvalidate();
        super.onDraw(var1_1);
        var5_5 = this.o;
        if (var5_5 != null) {
            this.m = var6_6 = var5_5.a();
        }
        if ((var8_8 = (int)var2_2.z) != 0) {
            var8_8 = this.getWidth() / 2;
            var6_6 = var8_8;
            var15_15 = this.getHeight() / 2;
            var10_10 = var15_15;
            var16_16 = var2_2.q;
            var25_25 = var16_16;
            var17_17 = var2_2.a;
            var3_3.drawCircle(var6_6, var10_10, var25_25, (Paint)var17_17);
        }
        if ((var8_8 = (int)var2_2.y) != 0) {
            var8_8 = this.getWidth() / 2;
            var6_6 = var8_8;
            var15_15 = this.getHeight() / 2;
            var10_10 = var15_15;
            var16_16 = var2_2.q;
            var25_25 = var16_16;
            var17_17 = var2_2.d;
            var3_3.drawCircle(var6_6, var10_10, var25_25, (Paint)var17_17);
        }
        if ((var8_8 = (int)var2_2.t) != 0) {
            var26_26 = var7_7;
            var28_27 = var2_2.p - var7_7;
            var30_28 = Math.abs(Math.sin(var2_2.ab));
            var32_29 = this.getWidth() / 2;
            var25_25 = this.getHeight() / 2;
            var18_18 = var2_2.q;
            var19_19 = var18_18;
            var20_20 = var2_2.d;
            var3_3.drawCircle(var32_29, var25_25, var19_19, (Paint)var20_20);
            var32_29 = this.getWidth() / 2;
            var16_16 = this.getHeight() / 2;
            var25_25 = var16_16;
            var6_6 = (float)(var26_26 += (var28_27 *= var30_28));
            var9_9 = var2_2.b;
            var3_3.drawCircle(var32_29, var25_25, var6_6, (Paint)var9_9);
            var7_7 = this.getWidth() / 2;
            var32_29 = var7_7;
            var15_15 = this.getHeight() / 2;
            var10_10 = var15_15;
            var33_30 = var2_2.e;
            var3_3.drawCircle(var32_29, var10_10, var6_6, var33_30);
            var34_31 = var2_2.ab;
            var36_32 = 0.05;
            var2_2.ab = var34_31 += var36_32;
        }
        if ((var7_7 = (int)var2_2.u) != 0) {
            var32_29 = this.getWidth() / 2;
            var6_6 = this.getHeight() / 2;
            var10_10 = var2_2.q;
            var33_30 = var2_2.d;
            var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            var32_29 = this.getWidth() / 2;
            var6_6 = this.getHeight() / 2;
            var10_10 = var2_2.p;
            var33_30 = var2_2.b;
            var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            var32_29 = this.getWidth() / 2;
            var6_6 = this.getHeight() / 2;
            var10_10 = var2_2.p;
            var33_30 = var2_2.e;
            var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            var32_29 = this.getWidth() / 2;
            var8_8 = this.getHeight() / 2;
            var6_6 = var8_8;
            var3_3.translate(var32_29, var6_6);
            var7_7 = var2_2.p;
            var10_10 = -var7_7;
            var32_29 = var7_7;
            var5_5 = new RectF(var10_10, var10_10, var32_29, var32_29);
            var32_29 = var2_2.m;
            var15_15 = 1119092736;
            var10_10 = var32_29 - 90.0f;
            var20_20 = var2_2.f;
            var16_16 = 1110704128;
            var25_25 = 45.0f;
            var18_18 = 1;
            var19_19 = 1.4E-45f;
            var4_4 = var1_1;
            var1_1.drawArc((RectF)var5_5, var10_10, var25_25, (boolean)var18_18, (Paint)var20_20);
        }
        if ((var7_7 = (int)var2_2.v) != 0) {
            var7_7 = var2_2.af;
            if (var7_7 > 0) {
                var32_29 = this.getWidth() / 2;
                var6_6 = this.getHeight() / 2;
                var10_10 = var2_2.q;
                var33_30 = var2_2.d;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                var7_7 = this.getWidth() / 2;
                var32_29 = var7_7;
                var8_8 = this.getHeight() / 2;
                var6_6 = var8_8;
                var15_15 = var2_2.af;
                var10_10 = var15_15;
                var33_30 = var2_2.b;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
lbl298:
                // 2 sources

                while (true) {
                    var38_33 = var13_13;
                    var39_34 = var14_14;
                    break;
                }
            } else {
                var7_7 = var2_2.ad;
                var8_8 = var2_2.q;
                if (var7_7 >= var8_8 && var7_7 <= (var8_8 = var2_2.p)) {
                    var32_29 = this.getWidth() / 2;
                    var6_6 = this.getHeight() / 2;
                    var10_10 = var2_2.q;
                    var33_30 = var2_2.d;
                    var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                    var32_29 = this.getWidth() / 2;
                    var8_8 = this.getHeight() / 2;
                    var6_6 = var8_8;
                    var15_15 = var2_2.ad;
                    var10_10 = var15_15;
                    var33_30 = var2_2.b;
                    var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                    var2_2.ad = var7_7 = var2_2.ad + 2;
                    ** continue;
                }
                var7_7 = var2_2.p * 2;
                var34_31 = var7_7;
                var36_32 = Math.abs(Math.sin(var2_2.ac));
                var34_31 = var34_31 * var36_32 + 0.0;
                var10_10 = this.getWidth() / 2;
                var25_25 = this.getHeight() / 2;
                var19_19 = var2_2.q;
                var20_20 = var2_2.d;
                var3_3.drawCircle(var10_10, var25_25, var19_19, (Paint)var20_20);
                var10_10 = this.getWidth() / 2;
                var25_25 = this.getHeight() / 2;
                var19_19 = var2_2.p;
                var20_20 = var2_2.c;
                var3_3.drawCircle(var10_10, var25_25, var19_19, (Paint)var20_20);
                var10_10 = (float)this.getWidth() / 2.0f;
                var16_16 = this.getHeight() / 2;
                var18_18 = var2_2.p;
                var25_25 = var16_16 - var18_18;
                var17_17 = var2_2.g;
                var3_3.drawPoint(var10_10, var25_25, (Paint)var17_17);
                var15_15 = this.getWidth() / 2;
                var16_16 = var2_2.p;
                var10_10 = var15_15 - var16_16;
                var25_25 = this.getHeight() / 2;
                var17_17 = var2_2.g;
                var3_3.drawPoint(var10_10, var25_25, (Paint)var17_17);
                var10_10 = this.getWidth();
                var25_25 = 2.0f;
                var10_10 /= var25_25;
                var19_19 = var2_2.p;
                var10_10 += var19_19;
                var19_19 = this.getHeight() / 2;
                var20_20 = var2_2.g;
                var3_3.drawPoint(var10_10, var19_19, (Paint)var20_20);
                var10_10 = (float)this.getWidth() / var25_25;
                var16_16 = this.getHeight() / 2;
                var18_18 = var2_2.p;
                var25_25 = var16_16 += var18_18;
                var17_17 = var2_2.g;
                var3_3.drawPoint(var10_10, var25_25, (Paint)var17_17);
                var36_32 = var2_2.p;
                var15_15 = (int)(var34_31 == var36_32 ? 0 : (var34_31 < var36_32 ? -1 : 1));
                var28_27 = 2.0;
                if (var15_15 <= 0) {
                    var30_28 = this.getWidth() / 2;
                    var40_35 = Math.pow(var2_2.p, var28_27);
                    var15_15 = var2_2.p;
                    var38_33 = var13_13;
                    var39_34 = var14_14;
                    var42_37 = Math.pow((double)var15_15 - var34_31, var28_27);
                    var42_37 = Math.sqrt(var40_35 - var42_37);
                    var10_10 = (float)(var30_28 - var42_37);
                    var42_37 = this.getHeight() / 2;
                    var21_21 = var2_2.p;
                    var30_28 = (double)var21_21 - var34_31;
                    var22_22 = (float)(var42_37 - var30_28);
                    var13_13 = this.getWidth() / 2;
                    var42_37 = var13_13;
                    var23_23 = var2_2.p;
                    var30_28 = Math.pow(var23_23, var28_27);
                    var44_39 = var2_2.p;
                    var40_35 = (double)var44_39 - var34_31;
                    var28_27 = Math.pow(var40_35, var28_27);
                    var28_27 = Math.sqrt(var30_28 - var28_27);
                    var25_25 = (float)(var42_37 + var28_27);
                    var42_37 = this.getHeight() / 2;
                    var18_18 = var2_2.p;
                    var30_28 = (double)var18_18 - var34_31;
                    var19_19 = (float)(var42_37 -= var30_28);
                    var45_41 = var2_2.h;
                    var4_4 = var1_1;
                    var6_6 = var10_10;
                    var10_10 = var22_22;
                    var20_20 = var45_41;
                    var1_1.drawLine(var6_6, var22_22, var25_25, var19_19, var45_41);
                } else {
                    var38_33 = var13_13;
                    var39_34 = var14_14;
                    var42_38 = this.getWidth() / 2;
                    var30_28 = Math.pow(var2_2.p, var28_27);
                    var15_15 = var2_2.p;
                    var40_36 = var15_15;
                    var40_36 = Math.pow(var34_31 - var40_36, var28_27);
                    var30_28 = Math.sqrt(var30_28 - var40_36);
                    var10_10 = (float)(var42_38 - var30_28);
                    var42_38 = this.getHeight() / 2;
                    var21_21 = var2_2.p;
                    var30_28 = (double)var21_21 - var34_31;
                    var22_22 = (float)(var42_38 - var30_28);
                    var13_13 = this.getWidth() / 2;
                    var42_38 = var13_13;
                    var23_23 = var2_2.p;
                    var30_28 = Math.pow(var23_23, var28_27);
                    var44_40 = var2_2.p;
                    var40_36 = var44_40;
                    var40_36 = var34_31 - var40_36;
                    var28_27 = Math.pow(var40_36, var28_27);
                    var28_27 = Math.sqrt(var30_28 - var28_27);
                    var25_25 = (float)(var42_38 + var28_27);
                    var42_38 = this.getHeight() / 2;
                    var18_18 = var2_2.p;
                    var30_28 = (double)var18_18 - var34_31;
                    var19_19 = (float)(var42_38 -= var30_28);
                    var45_42 = var2_2.h;
                    var4_4 = var1_1;
                    var6_6 = var10_10;
                    var10_10 = var22_22;
                    var20_20 = var45_42;
                    var1_1.drawLine(var6_6, var22_22, var25_25, var19_19, var45_42);
                }
                var34_31 = var2_2.ac;
                var36_32 = 0.05;
                var2_2.ac = var34_31 += var36_32;
            }
            var2_2.af = var7_7 = var2_2.af + -2;
        } else {
            var38_33 = var13_13;
            var39_34 = var14_14;
        }
        var7_7 = (int)var2_2.w;
        if (var7_7 != 0) {
            var7_7 = var2_2.af;
            if (var7_7 >= 0) {
                var32_29 = this.getWidth() / 2;
                var6_6 = this.getHeight() / 2;
                var10_10 = var2_2.af;
                var33_30 = var2_2.b;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                var7_7 = this.getWidth() / 2;
                var32_29 = var7_7;
                var8_8 = this.getHeight() / 2;
                var6_6 = var8_8;
                var15_15 = var2_2.q;
                var10_10 = var15_15;
                var33_30 = var2_2.d;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            } else {
                var32_29 = this.getWidth() / 2;
                var6_6 = this.getHeight() / 2;
                var10_10 = var11_11;
                var33_30 = var2_2.a;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                var7_7 = this.getWidth() / 2;
                var8_8 = var2_2.q;
                var32_29 = var7_7 - var8_8;
                var6_6 = this.getHeight() / 2;
                var33_30 = var2_2.a;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
                var7_7 = this.getWidth() / 2;
                var8_8 = var2_2.q;
                var32_29 = var7_7 += var8_8;
                var8_8 = this.getHeight() / 2;
                var6_6 = var8_8;
                var33_30 = var2_2.a;
                var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            }
            var2_2.af = var7_7 = var2_2.af + -5;
        }
        if ((var7_7 = (int)var2_2.x) != 0) {
            var4_4 = var2_2.j;
            var8_8 = var2_2.ai;
            var4_4.setAlpha(var8_8);
            var4_4 = var2_2.n;
            var8_8 = this.getWidth() / 2;
            var15_15 = var12_12 * 13 / 22;
            var6_6 = var8_8 - var15_15;
            var15_15 = this.getHeight() / 2;
            var16_16 = var12_12 * 2 / 22;
            var10_10 = var15_15 - var16_16;
            var4_4.moveTo(var6_6, var10_10);
            var4_4 = var2_2.n;
            var6_6 = this.getWidth() / 2 - var16_16;
            var15_15 = this.getHeight() / 2;
            var16_16 = var12_12 * 10 / 22;
            var10_10 = var15_15 + var16_16;
            var4_4.lineTo(var6_6, var10_10);
            var4_4 = var2_2.n;
            var8_8 = this.getWidth() / 2;
            var15_15 = var12_12 * 22 / 22;
            var6_6 = var8_8 + var15_15;
            var15_15 = this.getHeight() / 2;
            var16_16 = var12_12 * 16 / 22;
            var10_10 = var15_15 - var16_16;
            var4_4.lineTo(var6_6, var10_10);
            var4_4 = var2_2.n;
            var5_5 = var2_2.j;
            var3_3.drawPath((Path)var4_4, (Paint)var5_5);
            var32_29 = this.getWidth() / 2;
            var8_8 = this.getHeight() / 2;
            var6_6 = var8_8;
            var3_3.translate(var32_29, var6_6);
            var32_29 = -var12_12;
            var10_10 = var12_12;
            var5_5 = new RectF(var32_29, var32_29, var10_10, var10_10);
            var7_7 = -var2_2.ae;
            var25_25 = var7_7;
            var20_20 = var2_2.i;
            var15_15 = 1133903872;
            var10_10 = 300.0f;
            var18_18 = 0;
            var19_19 = 0.0f;
            var17_17 = null;
            var4_4 = var1_1;
            var1_1.drawArc((RectF)var5_5, var10_10, var25_25, false, (Paint)var20_20);
        }
        if ((var7_7 = (int)var2_2.aa) != 0) {
            var32_29 = this.getWidth() / 2;
            var8_8 = this.getHeight() / 2;
            var6_6 = var8_8;
            var15_15 = var38_33;
            var10_10 = var38_33;
            var33_30 = var2_2.k;
            var3_3.drawCircle(var32_29, var6_6, var10_10, var33_30);
            var6_6 = this.getWidth() / 2 - var39_34;
            var10_10 = this.getHeight() / 2;
            var25_25 = this.getWidth() / 2 + var39_34;
            var7_7 = this.getHeight() / 2;
            var19_19 = var7_7;
            var20_20 = var2_2.l;
            var4_4 = var1_1;
            var1_1.drawLine(var6_6, var10_10, var25_25, var19_19, (Paint)var20_20);
        }
    }

    public void setGtListener(GT3GeetestView$c gT3GeetestView$c) {
        this.o = gT3GeetestView$c;
    }
}

