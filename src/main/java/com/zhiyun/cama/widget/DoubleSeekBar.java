/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$FontMetrics
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.widget.DoubleSeekBar$a;
import d.v.e.l.h2;
import d.v.e.l.o1;

public class DoubleSeekBar
extends View {
    private static final int A = h2.b(6.0f);
    private static final int B = h2.b(12.0f);
    private int a;
    private int b;
    private float c;
    private int d;
    private int e;
    private int f;
    private float g;
    private boolean h;
    private int i;
    private float j;
    private int k;
    private int l;
    private final boolean m;
    private final int n;
    private final float o;
    private float p;
    private float q;
    private Drawable r;
    private int s;
    private Float[] t;
    private int u;
    private float v;
    private boolean w;
    private boolean x;
    private Paint y;
    private DoubleSeekBar$a z;

    public DoubleSeekBar(Context context) {
        this(context, null);
    }

    public DoubleSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DoubleSeekBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        n10 = 0;
        this.u = 0;
        this.v = 0.0f;
        int n11 = 1;
        this.w = n11;
        this.x = n11;
        Object object = R$styleable.DoubleSeekBar;
        attributeSet = context.obtainStyledAttributes(attributeSet, object);
        object = context.getResources();
        int n12 = 2131099772;
        int n13 = o1.c((Resources)object, n12);
        this.a = n13 = attributeSet.getColor(7, n13);
        n13 = o1.c(context.getResources(), n12);
        int n14 = 11;
        float f11 = 1.5E-44f;
        this.b = n13 = attributeSet.getColor(n14, n13);
        n13 = 12;
        float f12 = 1.7E-44f;
        object = attributeSet.getDrawable(n13);
        this.r = (Drawable)object;
        if (object == null) {
            object = context.getResources();
            n14 = 2131231864;
            f11 = 1.8079821E38f;
            object = o1.o((Resources)object, n14);
            this.r = (Drawable)object;
        }
        f11 = h2.b(20.0f);
        this.s = n13 = (int)attributeSet.getDimension(8, f11);
        f12 = h2.b(1.0f);
        this.c = f12 = attributeSet.getDimension(0, f12);
        n13 = (int)(attributeSet.getBoolean(5, n11 != 0) ? 1 : 0);
        this.h = n13;
        n14 = o1.c(context.getResources(), n12);
        this.i = n13 = attributeSet.getColor(4, n14);
        this.j = f12 = attributeSet.getDimension(6, 0.0f);
        this.k = n13 = attributeSet.getInteger(9, 0);
        this.l = n10 = attributeSet.getInteger(10, 0);
        n10 = (int)(attributeSet.getBoolean(2, n11 != 0) ? 1 : 0);
        this.m = n10;
        int n15 = o1.c(context.getResources(), n12);
        this.n = n15 = attributeSet.getColor(n11, n15);
        this.o = f10 = attributeSet.getDimension(3, 0.0f);
        attributeSet.recycle();
        this.m();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void a() {
        var1_1 = this.k;
        var1_1 = var1_1 - var2_2 + 1;
        var3_3 /* !! */  = new Float[var1_1];
        this.t = var3_3 /* !! */ ;
        for (var2_2 = this.l; var2_2 <= (var1_1 = this.k); ++var2_2) {
            var4_4 = this.l;
            if (var2_2 == var4_4) {
                var1_1 = this.e;
lbl9:
                // 2 sources

                while (true) {
                    var5_5 = var1_1;
                    break;
                }
            } else {
                if (var2_2 == var1_1) {
                    var1_1 = this.f;
                    ** continue;
                }
                var1_1 = this.e;
                var5_5 = var1_1;
                var6_6 = this.g;
                var7_7 = var2_2 - var4_4;
                var8_8 = var7_7;
                var5_5 += (var6_6 *= var8_8);
            }
            var9_9 = this.t;
            var4_4 = var2_2 - var4_4;
            var9_9[var4_4] = var3_3 /* !! */  = Float.valueOf(var5_5);
        }
    }

    private int b(float f10, float f11) {
        block4: {
            Object object;
            int n10;
            f11 = this.e;
            float f12 = f10 - f11;
            Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return this.l;
            }
            f11 = this.f;
            float f13 = f10 - f11;
            object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 >= 0) {
                return this.k;
            }
            object2 = false;
            f11 = 0.0f;
            for (int i10 = 0; i10 < (n10 = ((Float[])(object = this.t)).length); ++i10) {
                float f14 = ((Float)(object = object[i10])).floatValue();
                float f15 = f10 - f14;
                Object object3 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object3 < 0) continue;
                object = this.t;
                n10 = i10 + 1;
                f14 = ((Float)(object = object[n10])).floatValue();
                float f16 = f10 - f14;
                object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                if (object3 >= 0) {
                    continue;
                }
                break block4;
            }
            f10 = 0.0f;
        }
        f11 = this.e;
        f10 -= f11;
        f11 = this.g;
        f10 /= f11;
        f11 = this.l;
        return (int)(f10 + f11);
    }

    private float c(float f10, float f11) {
        block4: {
            Object object;
            int n10;
            f11 = this.e;
            float f12 = f10 - f11;
            Object object2 = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object2 <= 0) {
                return this.l;
            }
            f11 = this.f;
            float f13 = f10 - f11;
            object2 = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object2 >= 0) {
                return this.k;
            }
            object2 = false;
            f11 = 0.0f;
            for (int i10 = 0; i10 < (n10 = ((Float[])(object = this.t)).length); ++i10) {
                float f14 = ((Float)(object = object[i10])).floatValue();
                float f15 = f10 - f14;
                Object object3 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object3 < 0) continue;
                object = this.t;
                n10 = i10 + 1;
                f14 = ((Float)(object = object[n10])).floatValue();
                float f16 = f10 - f14;
                object3 = f16 == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1);
                if (object3 >= 0) {
                    continue;
                }
                break block4;
            }
            f10 = 0.0f;
        }
        f11 = this.e;
        f10 -= f11;
        f11 = this.g;
        f10 /= f11;
        f11 = this.l;
        return f10 + f11;
    }

    private int d(int n10) {
        float f10;
        boolean bl2 = this.m;
        if (!bl2) {
            return n10;
        }
        Paint paint = this.y;
        float f11 = this.o;
        paint.setTextSize(f11);
        paint = this.y;
        CharSequence charSequence = new StringBuilder();
        int n11 = this.l;
        ((StringBuilder)charSequence).append(n11);
        String string2 = "";
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        this.p = f10 = paint.measureText((String)charSequence);
        paint = this.y;
        charSequence = new StringBuilder();
        int n12 = this.k;
        ((StringBuilder)charSequence).append(n12);
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        this.q = f10 = paint.measureText((String)charSequence);
        float f12 = n10;
        f11 = this.p;
        f12 = f12 - f11 - f10;
        f10 = B * 2;
        return (int)(f12 - f10);
    }

    private void e(Canvas canvas) {
        Paint paint = this.y;
        int n10 = this.a;
        paint.setColor(n10);
        paint = this.y;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint = this.y;
        float f10 = this.c;
        paint.setStrokeWidth(f10);
        paint = new RectF();
        n10 = B;
        float f11 = n10;
        float f12 = this.p;
        paint.left = f11 += f12;
        f10 = (float)n10 + f12;
        f11 = this.d;
        paint.right = f10 += f11;
        n10 = this.s;
        f11 = n10;
        f12 = 2.0f;
        f11 /= f12;
        float f13 = this.c;
        float f14 = f13 / f12;
        paint.top = f11 -= f14;
        f10 = (float)n10 / f12;
        f11 = f13 / f12;
        paint.bottom = f10 += f11;
        f10 = f13 / f12;
        Paint paint2 = this.y;
        canvas.drawRoundRect((RectF)paint, f10, f13 /= f12, paint2);
    }

    private void f(Canvas canvas) {
        Object object = this.y;
        float f10 = this.o;
        object.setTextSize(f10);
        object = this.y;
        int n10 = this.n;
        object.setColor(n10);
        object = this.y.getFontMetrics();
        f10 = ((Paint.FontMetrics)object).descent;
        float f11 = ((Paint.FontMetrics)object).ascent;
        f10 -= f11;
        float f12 = ((Paint.FontMetrics)object).top;
        object = new StringBuilder();
        int n11 = this.l;
        ((StringBuilder)object).append(n11);
        String string2 = "";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        float f13 = 2.0f;
        float f14 = this.s;
        float f15 = 1.0f;
        f14 = f14 * f15 / f13 + (f10 /= f13) - (f11 -= f12);
        Paint paint = this.y;
        canvas.drawText((String)object, 0.0f, f14, paint);
        object = new StringBuilder();
        int n12 = this.k;
        ((StringBuilder)object).append(n12);
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        float f16 = this.getWidth();
        f14 = this.q;
        f16 -= f14;
        f14 = (float)this.s * f15 / f13;
        f10 = f10 + f14 - f11;
        Paint paint2 = this.y;
        canvas.drawText((String)object, f16, f10, paint2);
    }

    private void g(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        float f13;
        Paint paint = this.y;
        int n10 = this.b;
        paint.setColor(n10);
        paint = this.y;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint = new RectF();
        n10 = this.u;
        if (n10 < 0) {
            int n11 = this.e;
            f13 = n11;
            f12 = this.g;
            int n12 = this.l;
            f11 = (float)(n10 -= n12) * f12;
            f13 += f11;
            f11 = n11;
            n11 = 0 - n12;
            f10 = n11;
            f11 += (f12 *= f10);
        } else {
            int n13 = this.e;
            f13 = n13;
            f12 = this.g;
            int n14 = this.l;
            int n15 = 0 - n14;
            float f14 = (float)n15 * f12;
            f13 += f14;
            f10 = n13;
            f11 = n10 -= n14;
            f12 *= f11;
            f11 = f10 + f12;
        }
        paint.left = f13;
        paint.right = f11;
        n10 = this.s;
        f10 = n10;
        f13 = 2.0f;
        f10 /= f13;
        f12 = this.c;
        float f15 = f12 / f13;
        paint.top = f10 -= f15;
        f11 = (float)n10 / f13;
        f10 = f12 / f13;
        paint.bottom = f11 += f10;
        f11 = f12 / f13;
        Paint paint2 = this.y;
        canvas.drawRoundRect((RectF)paint, f11, f12 /= f13, paint2);
    }

    private void h(Canvas canvas) {
        float f10;
        float f11;
        float f12;
        float f13;
        float f14;
        Paint paint = this.y;
        int n10 = this.b;
        paint.setColor(n10);
        paint = this.y;
        Paint.Cap cap = Paint.Cap.ROUND;
        paint.setStrokeCap(cap);
        paint = new RectF();
        n10 = this.u;
        if (n10 < 0) {
            n10 = this.e;
            f14 = n10;
            f13 = this.g;
            f12 = this.v;
            int n11 = this.l;
            float f15 = n11;
            f12 = (f12 - f15) * f13;
            f14 += f12;
            f11 = n10;
            int n12 = 0 - n11;
            f12 = n12;
            f13 *= f12;
        } else {
            n10 = this.e;
            f14 = n10;
            f13 = this.g;
            int n13 = this.l;
            int n14 = 0 - n13;
            f10 = (float)n14 * f13;
            f14 += f10;
            f11 = n10;
            f10 = this.v;
            f12 = n13;
            f13 *= (f10 -= f12);
        }
        paint.left = f14;
        paint.right = f11 += f13;
        n10 = this.s;
        f14 = n10;
        f13 = 2.0f;
        f14 /= f13;
        f12 = this.c;
        f10 = f12 / f13;
        paint.top = f14 -= f10;
        f11 = (float)n10 / f13;
        f14 = f12 / f13;
        paint.bottom = f11 += f14;
        f11 = f12 / f13;
        Paint paint2 = this.y;
        canvas.drawRoundRect((RectF)paint, f11, f12 /= f13, paint2);
    }

    /*
     * Unable to fully structure code
     */
    private void i(Canvas var1_1) {
        var2_2 = this.y;
        var3_3 = this.i;
        var2_2.setColor(var3_3);
        var4_4 = 1.0f;
        var5_5 = h2.b(var4_4);
        for (var3_3 = this.l; var3_3 <= (var6_6 = this.k); ++var3_3) {
            var7_7 = new RectF();
            var8_8 = this.l;
            if (var3_3 == var8_8) {
                var8_8 = this.e;
                var9_9 = var8_8;
lbl12:
                // 2 sources

                while (true) {
                    var10_10 = (float)var5_5 + var9_9;
                    break;
                }
            } else {
                var11_11 = this.k;
                if (var3_3 == var11_11) {
                    var8_8 = this.f;
                    var11_11 = var8_8 - var5_5;
                    var10_10 = var11_11;
                    var9_9 = var8_8;
                    var12_12 = var10_10;
                    var10_10 = var9_9;
                    var9_9 = var12_12;
                } else {
                    var11_11 = this.e;
                    var10_10 = var11_11;
                    var13_13 = this.g;
                    var8_8 = var3_3 - var8_8;
                    var9_9 = var8_8;
                    var13_13 *= var9_9;
                    var9_9 = var10_10 + var13_13;
                    ** continue;
                }
            }
            var7_7.left = var9_9;
            var7_7.right = var10_10;
            var7_7.top = 0.0f;
            var8_8 = this.s;
            var11_11 = DoubleSeekBar.A;
            var9_9 = var8_8 + var11_11;
            var10_10 = this.j;
            var8_8 = (int)(var9_9 + var10_10);
            var7_7.bottom = var9_9 = (float)var8_8;
            var14_14 = this.y;
            var1_1.drawRect(var7_7, var14_14);
        }
    }

    private void j(Canvas canvas) {
        float f10;
        int n10;
        Paint paint = this.y;
        int n11 = this.i;
        paint.setColor(n11);
        paint = this.y;
        float f11 = this.j;
        paint.setTextSize(f11);
        paint = this.y;
        Object object = Typeface.DEFAULT_BOLD;
        paint.setTypeface((Typeface)object);
        paint = this.y;
        f11 = this.c;
        paint.setStrokeWidth(f11);
        paint = this.y;
        object = new StringBuilder();
        int n12 = this.u;
        ((StringBuilder)object).append(n12);
        String string2 = "";
        ((StringBuilder)object).append(string2);
        object = ((StringBuilder)object).toString();
        float f12 = paint.measureText((String)object);
        n11 = this.u;
        int n13 = 0x40000000;
        float f13 = 2.0f;
        if (n11 < 0) {
            n10 = this.e;
            f10 = n10;
            float f14 = this.g;
            int n14 = this.l;
            f11 = n11 - n14;
            f10 += (f14 *= f11);
            object = this.r;
            n11 = object.getIntrinsicWidth() / 2;
            f11 = n11;
        } else {
            n10 = this.e;
            f10 = n10;
            float f15 = this.g;
            int n15 = this.l;
            f11 = n11 -= n15;
            f10 += (f15 *= f11);
            f11 = f12 / f13;
        }
        n11 = (int)(f10 -= f11);
        n10 = this.u;
        int n16 = this.l;
        if (n10 == n16) {
            n11 = this.e;
        }
        if (n10 == (n16 = this.k)) {
            n11 = this.f;
            Drawable drawable2 = this.r;
            n10 = drawable2.getIntrinsicWidth() / 2;
            f11 = n11 - n10;
            n11 = (int)(f11 -= (f12 /= f13));
        }
        int n17 = this.getHeight();
        n13 = A;
        StringBuilder stringBuilder = new StringBuilder();
        n10 = this.u;
        stringBuilder.append(n10);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        f11 = n11;
        f12 = n17 -= n13;
        stringBuilder = this.y;
        canvas.drawText(string2, f11, f12, (Paint)stringBuilder);
    }

    private void k(Canvas canvas) {
        float f10 = this.e;
        float f11 = this.g;
        int n10 = this.u;
        int n11 = this.l;
        float f12 = n10 - n11;
        f10 += (f11 *= f12);
        Drawable drawable2 = this.r;
        f11 = drawable2.getIntrinsicWidth() / 2;
        int n12 = (int)(f10 -= f11);
        f11 = this.e;
        f12 = this.g;
        n11 = this.u;
        int n13 = this.l;
        float f13 = n11 - n13;
        f11 += (f12 *= f13);
        Drawable drawable3 = this.r;
        f12 = drawable3.getIntrinsicWidth() / 2;
        int n14 = (int)(f11 += f12);
        n10 = this.u;
        n11 = this.l;
        if (n10 == n11) {
            n12 = this.e;
            drawable2 = this.r;
            n14 = drawable2.getIntrinsicWidth() + n12;
        }
        if ((n10 = this.u) == (n11 = this.k)) {
            n12 = this.f;
            drawable2 = this.r;
            n14 = drawable2.getIntrinsicWidth();
            n12 -= n14;
            n14 = this.f;
        }
        n11 = this.s;
        this.r.setBounds(n12, 0, n14, n11);
        this.r.draw(canvas);
    }

    private void l(Canvas canvas) {
        float f10;
        float f11 = this.e;
        float f12 = this.g;
        float f13 = this.v;
        float f14 = this.l;
        f11 += (f12 *= (f13 -= f14));
        Drawable drawable2 = this.r;
        f12 = drawable2.getIntrinsicWidth() / 2;
        int n10 = (int)(f11 -= f12);
        f12 = this.e;
        f13 = this.g;
        f14 = this.v;
        int n11 = this.l;
        float f15 = n11;
        f12 += (f13 *= (f14 -= f15));
        Drawable drawable3 = this.r;
        f13 = drawable3.getIntrinsicWidth() / 2;
        int n12 = (int)(f12 += f13);
        f13 = this.v;
        int n13 = this.l;
        f14 = n13;
        float f16 = f13 - f14;
        Object object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
        if (object == false) {
            n10 = this.e;
            drawable2 = this.r;
            n12 = drawable2.getIntrinsicWidth() + n10;
        }
        if ((object = (f10 = (f13 = this.v) - (f14 = (float)(n13 = this.k))) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) == false) {
            n10 = this.f;
            drawable2 = this.r;
            n12 = drawable2.getIntrinsicWidth();
            n10 -= n12;
            n12 = this.f;
        }
        n13 = this.s;
        this.r.setBounds(n10, 0, n12, n13);
        this.r.draw(canvas);
    }

    private void m() {
        Paint paint;
        this.y = paint = new Paint();
        paint.setAntiAlias(true);
        paint = this.y;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
    }

    public int getProgress() {
        return this.u;
    }

    public void onDraw(Canvas canvas) {
        float f10;
        float f11;
        super.onDraw(canvas);
        int n10 = this.m;
        if (n10 != 0) {
            this.f(canvas);
        }
        this.e(canvas);
        n10 = this.u;
        if (n10 != 0 && (n10 = (int)(this.x ? 1 : 0)) != 0) {
            this.g(canvas);
        }
        if ((n10 = (int)((f11 = (f10 = this.v) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) != 0) {
            this.h(canvas);
            this.l(canvas);
        }
        if ((n10 = (int)(this.w ? 1 : 0)) != 0) {
            this.k(canvas);
        }
        if ((n10 = (int)(this.h ? 1 : 0)) != 0) {
            this.j(canvas);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = View.MeasureSpec.getSize((int)n10);
        this.d = n10 = this.d(n10);
        float f10 = B;
        float f11 = this.p;
        this.e = n11 = (int)(f10 + f11);
        this.f = n11 += n10;
        float f12 = (float)n10 * 1.0f;
        n11 = this.k;
        int n12 = this.l;
        f10 = n11 - n12;
        this.g = f12 /= f10;
        this.a();
        n10 = this.s;
        n11 = A;
        f12 = n10 + n11;
        f10 = this.j;
        n10 = (int)(f12 + f10);
        n11 = this.d;
        this.setMeasuredDimension(n11, n10);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean bl2;
        block3: {
            block1: {
                block2: {
                    boolean bl3 = motionEvent.getAction();
                    bl2 = true;
                    if (!bl3) break block1;
                    if (bl3 == bl2) break block2;
                    boolean bl4 = 2 != 0;
                    if (bl3 == bl4) break block1;
                    break block3;
                }
                this.x = bl2;
                this.w = bl2;
                boolean bl5 = false;
                this.setProgressing(0.0f);
                float f10 = motionEvent.getX();
                float f11 = motionEvent.getY();
                int n10 = this.b(f10, f11);
                this.setProgress(n10);
                DoubleSeekBar$a doubleSeekBar$a = this.z;
                if (doubleSeekBar$a != null) {
                    doubleSeekBar$a.a(n10);
                }
                break block3;
            }
            boolean bl6 = false;
            Object var8_13 = null;
            this.x = false;
            this.w = false;
            float f12 = motionEvent.getX();
            float f13 = motionEvent.getY();
            f13 = this.c(f12, f13);
            this.setProgressing(f13);
        }
        return bl2;
    }

    public void setProgress(int n10) {
        int n11 = this.l;
        if (n10 >= n11 && n10 <= (n11 = this.k)) {
            this.u = n10;
            this.invalidate();
        }
    }

    public void setProgressing(float f10) {
        float f11;
        float f12 = this.l;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object >= 0 && (object = (f11 = f10 - (f12 = (float)this.k)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) <= 0) {
            this.v = f10;
            this.invalidate();
        }
    }

    public void setSeekChangeListener(DoubleSeekBar$a doubleSeekBar$a) {
        this.z = doubleSeekBar$a;
    }
}

