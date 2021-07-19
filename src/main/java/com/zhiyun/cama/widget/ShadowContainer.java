/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.util.AttributeSet
 *  android.view.View$MeasureSpec
 *  android.widget.FrameLayout$LayoutParams
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.zhiyun.cama.R$styleable;
import d.v.f.i.g;
import l.a.q.i;

public class ShadowContainer
extends i {
    private final float b;
    private final float c;
    private final Paint d;
    private boolean e;
    private int f;
    private int g;
    private float h;
    private float i;
    private float j;

    public ShadowContainer(Context context) {
        this(context, null);
    }

    public ShadowContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShadowContainer(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        float f11;
        float f12;
        int bl2;
        Object object = R$styleable.ShadowContainer;
        context = context.obtainStyledAttributes(attributeSet, object);
        this.f = bl2 = context.getResourceId(2, 0);
        this.h = f12 = context.getDimension(3, 0.0f);
        boolean bl3 = true;
        this.b = f11 = context.getDimension((int)(bl3 ? 1 : 0), 0.0f);
        this.c = f10 = context.getDimension(0, 0.0f);
        this.i = f10 = context.getDimension(4, 0.0f);
        this.j = f10 = context.getDimension(5, 0.0f);
        n10 = (int)(context.getBoolean(6, bl3) ? 1 : 0);
        this.e = n10;
        context.recycle();
        this.getColor();
        super();
        this.d = context;
        object = Paint.Style.FILL;
        context.setStyle((Paint.Style)object);
        context.setAntiAlias(bl3);
    }

    private void getColor() {
        int n10;
        Context context = this.getContext();
        int n11 = this.f;
        this.g = n10 = d.v.f.i.g.c(context, n11);
    }

    public void dispatchDraw(Canvas canvas) {
        int n10 = this.e;
        if (n10 != 0) {
            Paint paint;
            n10 = this.getLayerType();
            int n11 = 1;
            float f10 = Float.MIN_VALUE;
            if (n10 != n11) {
                n10 = 0;
                paint = null;
                this.setLayerType(n11, null);
            }
            paint = this.d;
            n11 = this.g;
            paint.setColor(n11);
            paint = this.d;
            f10 = this.h;
            float f11 = this.i;
            float f12 = this.j;
            int n12 = this.g;
            paint.setShadowLayer(f10, f11, f12, n12);
            paint = this.getChildAt(0);
            n11 = paint.getLeft();
            int n13 = paint.getTop();
            int n14 = paint.getRight();
            n10 = paint.getBottom();
            float f13 = n11;
            float f14 = n13;
            float f15 = n14;
            float f16 = n10;
            float f17 = this.c;
            Paint paint2 = this.d;
            canvas.drawRoundRect(f13, f14, f15, f16, f17, f17, paint2);
        }
        super.dispatchDraw(canvas);
    }

    public void e() {
        super.e();
        this.getColor();
        this.postInvalidate();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
    }

    /*
     * Unable to fully structure code
     */
    public void onMeasure(int var1_1, int var2_2) {
        var3_3 = this;
        super.onMeasure(var1_1, var2_2);
        var4_4 = this.getChildCount();
        var5_5 = 1;
        if (var4_4 == var5_5) {
            var4_4 = this.getMeasuredWidth();
            var5_5 = this.getMeasuredHeight();
            var6_6 = View.MeasureSpec.getMode((int)var1_1);
            var7_7 = View.MeasureSpec.getMode((int)var2_2);
            var8_8 = 0;
            var9_9 = 0.0f;
            var10_10 = this.getChildAt(0);
            var11_11 = (FrameLayout.LayoutParams)var10_10.getLayoutParams();
            var12_12 = this.b;
            var13_13 = var11_11.bottomMargin;
            var12_12 = Math.max(var12_12, var13_13);
            var13_13 = 1.0f;
            var14_14 = (int)(var12_12 += var13_13);
            var15_15 = this.b;
            var16_16 = var11_11.leftMargin;
            var15_15 = Math.max(var15_15, var16_16) + var13_13;
            var17_17 = (int)var15_15;
            var16_16 = this.b;
            var18_18 = var11_11.rightMargin;
            var16_16 = Math.max(var16_16, var18_18) + var13_13;
            var19_19 = (int)var16_16;
            var18_18 = this.b;
            var20_20 = var11_11.topMargin;
            var21_21 = (int)(Math.max(var18_18, var20_20) + var13_13);
            var22_22 = -2;
            var18_18 = 0.0f / 0.0f;
            var23_23 = -1;
            var20_20 = 0.0f / 0.0f;
            var24_24 = -1 << -1;
            var25_25 = -0.0f;
            var26_26 = 0x40000000;
            var27_27 = 2.0f;
            if (var6_6 == 0) {
                var6_6 = View.MeasureSpec.getSize((int)var1_1);
            } else {
                var6_6 = var11_11.width;
                if (var6_6 == var23_23) {
                    var6_6 = var4_4 - var17_17 - var19_19;
                    while (true) {
                        var8_8 = var26_26;
                        var9_9 = var27_27;
                        break;
                    }
                } else {
                    if (var22_22 != var6_6) ** continue;
                    var6_6 = var4_4 - var17_17 - var19_19;
                    var8_8 = var24_24;
                    var9_9 = var25_25;
                }
            }
            if (var7_7 == 0) {
                var7_7 = View.MeasureSpec.getSize((int)var2_2);
                var26_26 = 0;
                var27_27 = 0.0f;
            } else {
                var7_7 = var11_11.height;
                if (var7_7 == var23_23) {
                    var7_7 = var5_5 - var14_14 - var21_21;
                } else if (var22_22 == var7_7) {
                    var7_7 = var5_5 - var14_14 - var21_21;
                    var26_26 = var24_24;
                    var27_27 = var25_25;
                }
            }
            var6_6 = View.MeasureSpec.makeMeasureSpec((int)var6_6, (int)var8_8);
            var7_7 = View.MeasureSpec.makeMeasureSpec((int)var7_7, (int)var26_26);
            var3_3.measureChild(var10_10, var6_6, var7_7);
            var6_6 = View.MeasureSpec.getMode((int)var1_1);
            var7_7 = View.MeasureSpec.getMode((int)var2_2);
            var8_8 = var10_10.getMeasuredHeight();
            var28_28 = var10_10.getMeasuredWidth();
            var21_21 = var7_7 == var24_24 ? var21_21 + var8_8 + var14_14 : var5_5;
            var19_19 = var6_6 == var24_24 ? var19_19 + var28_28 + var17_17 : var4_4;
            var29_29 = var19_19;
            var30_30 = var28_28;
            var31_31 = var3_3.b;
            var32_32 = 2.0f;
            var12_12 = var31_31 * var32_32 + var30_30;
            var6_6 = (int)(var29_29 == var12_12 ? 0 : (var29_29 < var12_12 ? -1 : 1));
            if (var6_6 < 0) {
                var29_29 = var31_31 * var32_32;
                var19_19 = (int)(var30_30 += var29_29);
            }
            if ((var6_6 = (int)((cfr_temp_0 = (var29_29 = (float)var21_21) - (var9_9 = var31_31 * var32_32 + (var30_30 = (float)var8_8))) == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1))) < 0) {
                var21_21 = (int)(var30_30 += (var31_31 *= var32_32));
            }
            if (var21_21 != var5_5 || var19_19 != var4_4) {
                var3_3.setMeasuredDimension(var19_19, var21_21);
            }
            return;
        }
        var33_33 = new IllegalStateException("\u5b50View\u53ea\u80fd\u6709\u4e00\u4e2a");
        throw var33_33;
    }

    public void setDrawShadow(boolean bl2) {
        boolean bl3 = this.e;
        if (bl3 == bl2) {
            return;
        }
        this.e = bl2;
        this.postInvalidate();
    }
}

