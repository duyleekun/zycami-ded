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
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.graphics.Typeface
 *  android.text.TextPaint
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewConfiguration
 *  android.widget.Scroller
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Scroller;
import androidx.core.content.res.ResourcesCompat;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.widget.AudioBeatView$a;
import d.v.c.b2.a;
import d.v.e.h.e;
import d.v.e.l.c2;
import d.v.e.l.h2;
import d.v.e.l.o1;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AudioBeatView
extends View {
    public static final int H = 0;
    public static final int I = 1;
    public static final int J = 2;
    private static final long K = 100000L;
    private static final long L = 50000L;
    private int A;
    private long B;
    private boolean C;
    private long D;
    private long E;
    private boolean F;
    private boolean G;
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Paint i;
    private Paint j;
    private Paint k;
    private Paint l;
    private Rect m;
    private List n;
    private HashMap o;
    private List p;
    private boolean q;
    private int r;
    private int s;
    private float t;
    private float u;
    private VelocityTracker v;
    private Scroller w;
    private int x;
    private LinearGradient y;
    private AudioBeatView$a z;

    public AudioBeatView(Context context) {
        this(context, null);
    }

    public AudioBeatView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioBeatView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        this.f = n10 = h2.b(26.0f);
        ArrayList arrayList = new ArrayList();
        this.n = arrayList;
        super();
        this.o = arrayList;
        this.p = arrayList = new ArrayList();
        n10 = 1;
        this.q = n10;
        this.C = false;
        this.F = false;
        this.G = false;
        int[] nArray = R$styleable.AudioBarView;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        float f10 = 2.0f;
        int n12 = h2.b(f10);
        this.a = n12 = attributeSet.getDimensionPixelSize(5, n12);
        n12 = h2.b(f10);
        this.b = n12 = attributeSet.getDimensionPixelOffset(6, n12);
        int n13 = h2.b(f10);
        this.c = n13 = attributeSet.getDimensionPixelOffset(2, n13);
        f10 = 3.0f;
        n12 = h2.b(f10);
        this.d = n11 = attributeSet.getDimensionPixelSize(0, n12);
        n11 = h2.b(f10);
        this.e = n10 = attributeSet.getDimensionPixelSize(n10, n11);
        n10 = h2.b(1.0f);
        this.g = n10 = attributeSet.getDimensionPixelSize(7, n10);
        n10 = o1.c(this.getResources(), 2131099772);
        this.h = n10 = attributeSet.getColor(3, n10);
        attributeSet.recycle();
        this.n(context);
        this.o();
    }

    private boolean c(long l10) {
        float f10;
        long l11 = 100000L;
        float f11 = this.j(l10, l11);
        float f12 = f11 - (f10 = -1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object == false) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
        }
        return (boolean)object;
    }

    private void f(Canvas canvas) {
        float f10 = this.d;
        int n10 = this.s;
        int n11 = this.e;
        float f11 = n10 - n11;
        n10 = this.getMeasuredHeight();
        n11 = this.f;
        float f12 = n10 - n11;
        float f13 = 6.0f;
        float f14 = h2.b(f13);
        float f15 = h2.b(f13);
        Paint paint = this.k;
        canvas.drawRoundRect(f10, 0.0f, f11, f12, f14, f15, paint);
    }

    private void g(Canvas canvas) {
        boolean bl2;
        Iterator iterator2 = this.o.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            long l10;
            long l11;
            long l12;
            long l13;
            Long l14 = (Long)iterator2.next().getValue();
            long l15 = l14;
            long l16 = l15 - (l13 = this.D);
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object < 0 || (object = (l12 = l15 - (l11 = this.E + l13)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) continue;
            float f10 = 1.5f;
            int n10 = h2.b(f10);
            long l17 = this.B;
            long l18 = (l17 = Math.abs((l15 -= l13) - l17)) - (l10 = 50000L);
            Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object2 < 0) {
                f10 = 3.0f;
                n10 = h2.b(f10);
            }
            double d10 = l15;
            l17 = 4556014321273684781L;
            d10 *= 4.0E-4;
            double d11 = this.d;
            float f11 = (float)(d10 += d11);
            int n11 = this.getHeight();
            object2 = this.f;
            n11 -= object2;
            float f12 = 9.0f;
            object2 = h2.b(f12);
            float f13 = n11 += object2;
            f10 = n10;
            Paint paint = this.j;
            canvas.drawCircle(f11, f13, f10, paint);
        }
    }

    private void h(Canvas canvas) {
        int n10;
        List list = this.n;
        if (list != null && (n10 = list.size()) != 0) {
            n10 = this.getDrawWidth();
            int n11 = this.d;
            n10 -= n11;
            n11 = this.e;
            n10 -= n11;
            n11 = this.getDrawHeight();
            int n12 = 0;
            while (true) {
                List list2;
                int n13 = this.g;
                if (n12 >= (n13 = n10 - n13) || n12 >= (n13 = (list2 = this.n).size())) break;
                float f10 = ((Float)this.n.get(n12)).floatValue();
                int n14 = this.b;
                float f11 = n11;
                float f12 = 1.0f - f10;
                n13 = (int)(f11 *= f12);
                list2 = this.m;
                int n15 = this.d;
                int n16 = n15 + n12;
                n15 += n12;
                int n17 = this.g;
                n15 += n17;
                n17 = this.c + n11;
                list2.set(n16, n14 += n13, n15, n17);
                list2 = this.m;
                Paint paint = this.i;
                canvas.drawRect((Rect)list2, paint);
                n13 = this.g;
                n12 += n13;
                n13 = this.a;
                n12 = n12 + n13 + -1 + 1;
            }
        }
    }

    private void i(Canvas canvas) {
        Object object;
        int n10;
        int n11 = this.getMeasuredHeight();
        int n12 = h2.b(6.0f);
        float f10 = n11 -= n12;
        n12 = this.getMeasuredHeight();
        float f11 = n12;
        for (int i10 = 0; i10 < (n10 = (object = this.p).size()); ++i10) {
            float f12;
            Paint paint;
            n10 = i10 % 2;
            int n13 = 1120403456;
            float f13 = 100.0f;
            if (n10 == 0) {
                object = (String)this.p.get(i10);
                paint = this.l;
                f12 = paint.measureText((String)object);
                int n14 = this.d;
                float f14 = n14;
                float f15 = (float)i10 * f13;
                f14 += f15;
                n13 = 0x40000000;
                f13 = 2.0f;
                Paint paint2 = this.l;
                canvas.drawText((String)object, f14 -= (f12 /= f13), f11, paint2);
                continue;
            }
            n10 = this.d;
            float f16 = n10;
            f12 = (float)i10 * f13;
            n13 = h2.b(1.0f);
            f13 = n13;
            paint = this.l;
            canvas.drawCircle(f16 += f12, f10, f13, paint);
        }
    }

    private float j(long l10, long l11) {
        long l12;
        long l13;
        long l14;
        long l15;
        long l16;
        long l17;
        float f10 = (float)l10 / 1000000.0f;
        int n10 = 1;
        f10 = c2.d(f10, n10);
        int n11 = 0x3DCCCCCD;
        float f11 = 0.1f;
        float f12 = c2.d(f10 - f11, n10);
        float f13 = c2.d(f11 += f10, n10);
        Serializable serializable = this.o;
        Serializable serializable2 = Float.valueOf(f10);
        serializable = (Long)((HashMap)serializable).get(serializable2);
        serializable2 = this.o;
        Serializable serializable3 = Float.valueOf(f12);
        serializable2 = (Long)((HashMap)serializable2).get(serializable3);
        serializable3 = this.o;
        Float f14 = Float.valueOf(f13);
        serializable3 = (Long)((HashMap)serializable3).get(f14);
        if (serializable == null || (n11 = (int)((l17 = (l16 = Math.abs((Long)serializable - l10)) - l11) == 0L ? 0 : (l17 < 0L ? -1 : 1))) >= 0) {
            f10 = -1.0f;
        }
        if (serializable2 == null || (n11 = (int)((l15 = (l16 = Math.abs((Long)serializable2 - l10)) - l11) == 0L ? 0 : (l15 < 0L ? -1 : 1))) >= 0) {
            f12 = f10;
        }
        if (serializable3 == null || (l14 = (l13 = (l10 = Math.abs(l12 = (Long)serializable3 - l10)) - l11) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
            f13 = f12;
        }
        return f13;
    }

    private float k(long l10) {
        return this.j(l10, 50000L);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int l(long var1_1) {
        block6: {
            block5: {
                var3_2 = this.D;
                var5_3 = this.c(var1_1 += var3_2);
                var6_4 = this.p(var1_1);
                var7_5 = 0;
                this.F = false;
                this.G = false;
                var8_6 = 1;
                var9_7 = 1.4E-45f;
                if (!var6_4) break block5;
                var10_8 = this.k(var1_1);
                var11_9 /* !! */  = this.o;
                var12_10 = Float.valueOf(var10_8);
                var3_2 = d.v.e.h.e.c((Long)var11_9 /* !! */ .get(var12_10));
                var13_11 = 0x3DCCCCCD;
                var14_12 = 0.1f;
                var15_13 = c2.d(var10_8 - var14_12, var8_6);
                var10_8 = c2.d(var10_8 + var14_12, var8_6);
                var11_9 /* !! */  = this.o;
                var16_14 = Float.valueOf(var15_13);
                var11_9 /* !! */  = (Long)var11_9 /* !! */ .get(var16_14);
                var16_14 = this.o;
                var17_15 /* !! */  = Float.valueOf(var10_8);
                var17_15 /* !! */  = (Long)var16_14.get(var17_15 /* !! */ );
                var18_16 = 100000L;
                if (var11_9 /* !! */  != null) ** GOTO lbl-1000
                var20_17 = this.D;
                cfr_temp_0 = (var20_17 = var3_2 - var20_17) - var18_16;
                var13_11 = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var13_11 >= 0) {
                    var13_11 = var8_6;
                    var14_12 = var9_7;
                } else lbl-1000:
                // 2 sources

                {
                    var13_11 = 0;
                    var11_9 /* !! */  = null;
                    var14_12 = 0.0f;
                }
                this.F = var13_11;
                if (var17_15 /* !! */  == null) {
                    var1_1 = this.E;
                    var20_17 = this.D;
                    cfr_temp_1 = (var1_1 = var1_1 + var20_17 - var3_2) - var18_16;
                    var22_18 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                    if (var22_18 /* !! */  >= 0) {
                        var7_5 = var8_6;
                    }
                }
                this.G = var7_5;
                var7_5 = var8_6;
                break block6;
            }
            if (!var5_3) {
                var7_5 = 2;
            }
        }
        return var7_5;
    }

    private void n(Context object) {
        float f10;
        Rect rect;
        this.m = rect = new Rect();
        this.t = f10 = (float)ViewConfiguration.get((Context)object).getScaledMaximumFlingVelocity();
        this.u = f10 = (float)ViewConfiguration.get((Context)object).getScaledMinimumFlingVelocity();
        rect = new Scroller(object);
        this.w = rect;
        object = new a(this);
        this.setOnScrollChangeListener((View.OnScrollChangeListener)object);
    }

    private void o() {
        Paint paint;
        this.i = paint = new Paint();
        int n10 = 1;
        paint.setAntiAlias(n10 != 0);
        paint = this.i;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.i;
        int n11 = this.h;
        paint.setColor(n11);
        this.k = paint = new Paint();
        paint.setAntiAlias(n10 != 0);
        paint = this.k;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.j = paint = new Paint();
        paint.setAntiAlias(n10 != 0);
        paint = this.j;
        style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.j;
        n11 = this.getResources().getColor(2131099798, null);
        paint.setColor(n11);
        paint = ResourcesCompat.getFont(this.getContext(), 2131296257);
        style2 = new TextPaint();
        this.l = style2;
        style2.setAntiAlias(n10 != 0);
        Paint paint2 = this.l;
        style2 = Paint.Style.FILL;
        paint2.setStyle(style2);
        this.l.setTypeface((Typeface)paint);
        paint = this.l;
        n10 = this.getResources().getColor(2131099776, null);
        paint.setColor(n10);
        paint = this.l;
        float f10 = h2.g(10.0f);
        paint.setTextSize(f10);
    }

    private boolean p(long l10) {
        float f10;
        float f11 = this.k(l10);
        float f12 = f11 - (f10 = -1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            object = true;
            f11 = Float.MIN_VALUE;
        } else {
            object = false;
            f11 = 0.0f;
        }
        return (boolean)object;
    }

    private /* synthetic */ void q(View object, int n10, int n11, int n12, int n13) {
        long l10;
        object = null;
        int n14 = Math.max(n10, 0);
        double d10 = n14;
        double d11 = 4.0E-4;
        this.B = l10 = (long)(d10 /= d11);
        n10 = this.l(l10);
        AudioBeatView$a audioBeatView$a = this.z;
        if (audioBeatView$a != null) {
            n12 = (int)(this.C ? 1 : 0);
            audioBeatView$a.c(n14, n12 != 0);
            this.z.a(n10);
            object = this.z;
            n10 = (int)(this.F ? 1 : 0);
            n11 = (int)(this.G ? 1 : 0);
            object.b(n10 != 0, n11 != 0);
        }
    }

    public void a(long l10) {
        float f10 = c2.d((float)(this.D + l10) / 1000000.0f, 1);
        HashMap hashMap = this.o;
        Float f11 = Float.valueOf(f10);
        Long l11 = this.D + l10;
        hashMap.put(f11, l11);
        this.invalidate();
    }

    public void b(float f10) {
        List list = this.n;
        Float f11 = Float.valueOf(f10);
        list.add(f11);
        this.invalidate();
    }

    public void computeScroll() {
        super.computeScroll();
        Scroller scroller = this.w;
        int n10 = scroller.computeScrollOffset();
        if (n10 == 0) {
            return;
        }
        scroller = this.w;
        n10 = scroller.getCurrX();
        int n11 = this.A - n10;
        int n12 = 0;
        if (n11 != 0) {
            Scroller scroller2;
            int n13 = this.getScrollX() + n11;
            int n14 = this.s;
            int n15 = this.x;
            int n16 = n14 - n15;
            int n17 = 1;
            float f10 = Float.MIN_VALUE;
            if (n13 >= n16) {
                n11 = this.getScrollX();
                n11 = (n14 -= n15) - n11;
                n13 = n17;
            } else {
                n13 = 0;
            }
            n14 = this.getScrollX() + n11;
            if (n14 <= 0) {
                n11 = -this.getScrollX();
                n13 = n17;
            }
            if ((n14 = (int)((scroller2 = this.w).isFinished() ? 1 : 0)) == 0) {
                this.scrollBy(n11, 0);
                this.C = n17;
            }
            this.A = n10;
            n12 = n13;
        }
        if (n12 == 0) {
            this.invalidate();
        }
    }

    public void d(long l10) {
        int n10 = this.l(l10);
        AudioBeatView$a audioBeatView$a = this.z;
        if (audioBeatView$a != null) {
            audioBeatView$a.a(n10);
            AudioBeatView$a audioBeatView$a2 = this.z;
            boolean bl2 = this.F;
            boolean bl3 = this.G;
            audioBeatView$a2.b(bl2, bl3);
        }
    }

    public void e(long l10) {
        float f10;
        long l11 = this.D + l10;
        float f11 = this.k(l11);
        float f12 = f11 - (f10 = -1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            HashMap hashMap = this.o;
            Float f13 = Float.valueOf(f11);
            hashMap.remove(f13);
            this.invalidate();
        }
    }

    public HashMap getBeatData() {
        return this.o;
    }

    public int getDrawHeight() {
        int n10 = this.getHeight();
        int n11 = this.f;
        n10 -= n11;
        n11 = this.b;
        n10 -= n11;
        n11 = this.c;
        return n10 - n11;
    }

    public int getDrawWidth() {
        return this.s;
    }

    public long m(long l10) {
        float f10;
        long l11 = this.D + l10;
        float f11 = this.k(l11);
        float f12 = f11 - (f10 = -1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            HashMap hashMap = this.o;
            Number number = Float.valueOf(f11);
            number = d.v.e.h.e.c((Long)hashMap.get(number));
            l10 = (Long)number;
            l11 = this.D;
            l10 -= l11;
        } else {
            l10 = -1;
        }
        return l10;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f(canvas);
        this.h(canvas);
        this.g(canvas);
        this.i(canvas);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        this.x = n10;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10 = this.q;
        int n11 = 1;
        if (n10 == 0) {
            return n11 != 0;
        }
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker == null) {
            this.v = velocityTracker = VelocityTracker.obtain();
        }
        velocityTracker = this.v;
        velocityTracker.addMovement(motionEvent);
        n10 = motionEvent.getAction();
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                float f10 = 2.8E-45f;
                if (n10 == n12) {
                    int n13;
                    float f11 = motionEvent.getX();
                    f10 = this.r;
                    f11 -= f10;
                    n12 = this.getScrollX();
                    f10 = (float)n12 - f11;
                    Object object = 0;
                    float f12 = f11 - 0.0f;
                    float f13 = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
                    boolean bl2 = false;
                    if (f13 > 0) {
                        float f14 = f10 - 0.0f;
                        n12 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
                        if (n12 <= 0) {
                            this.scrollTo(0, 0);
                        } else {
                            f11 = -f11;
                            n10 = (int)f11;
                            this.scrollBy(n10, 0);
                        }
                        this.C = n11;
                    } else {
                        float f15 = f11 - 0.0f;
                        object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
                        if (object < 0) {
                            object = this.s;
                            f13 = this.x;
                            int n14 = object - f13;
                            float f16 = n14;
                            float f17 = f10 - f16;
                            n12 = (int)(f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1));
                            if (n12 >= 0) {
                                this.scrollTo((int)(object -= f13), 0);
                            } else {
                                f11 = -f11;
                                n10 = (int)f11;
                                this.scrollBy(n10, 0);
                            }
                            this.C = n11;
                        }
                    }
                    float f18 = motionEvent.getX();
                    this.r = n13 = (int)f18;
                }
            } else {
                motionEvent = this.v;
                n10 = 1000;
                float f19 = this.t;
                motionEvent.computeCurrentVelocity(n10, f19);
                motionEvent = this.v;
                int n15 = (int)motionEvent.getXVelocity();
                float f20 = Math.abs(n15);
                float f21 = this.u;
                float f22 = f20 == f21 ? 0 : (f20 > f21 ? 1 : -1);
                if (f22 > 0) {
                    f22 = this.getScrollX();
                    this.A = (int)f22;
                    f22 = this.s;
                    n10 = this.x;
                    float f23 = f22 - n10;
                    if (f23 > 0) {
                        motionEvent = this.w;
                        f22 = (float)motionEvent.isFinished();
                        if (f22 == false) {
                            motionEvent = this.w;
                            motionEvent.abortAnimation();
                        }
                        Scroller scroller = this.w;
                        int n16 = this.A;
                        boolean bl3 = false;
                        boolean bl4 = false;
                        float f24 = 0.0f;
                        scroller.fling(n16, 0, n15, 0, 0, (int)f23, 0, 0);
                        this.invalidate();
                    }
                }
                if ((motionEvent = this.v) != null) {
                    motionEvent.recycle();
                    f22 = 0.0f;
                    f20 = 0.0f;
                    motionEvent = null;
                    this.v = null;
                }
            }
        } else {
            int n17;
            velocityTracker = this.w;
            n10 = (int)(velocityTracker.isFinished() ? 1 : 0);
            if (n10 == 0) {
                velocityTracker = this.w;
                velocityTracker.abortAnimation();
            }
            float f25 = motionEvent.getX();
            this.r = n17 = (int)f25;
        }
        return n11 != 0;
    }

    public /* synthetic */ void r(View view, int n10, int n11, int n12, int n13) {
        this.q(view, n10, n11, n12, n13);
    }

    public void s(long l10, long l11) {
        float f10;
        long l12 = this.D + l10;
        float f11 = this.k(l12);
        float f12 = f11 - (f10 = -1.0f);
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            HashMap hashMap = this.o;
            Float f13 = Float.valueOf(f11);
            l12 = d.v.e.h.e.c((Long)hashMap.get(f13)) + l11;
            hashMap = this.o;
            Float f14 = Float.valueOf(f11);
            hashMap.remove(f14);
            f11 = (float)l12 / 1000000.0f;
            object = true;
            f10 = Float.MIN_VALUE;
            f11 = c2.d(f11, (int)object);
            hashMap = this.o;
            f14 = Float.valueOf(f11);
            Long l13 = l12;
            hashMap.put(f14, l13);
            this.invalidate();
            l10 = this.B;
            this.d(l10);
        }
    }

    public void setDataList(List list) {
        this.n = list;
        this.invalidate();
    }

    public void setDrawableWidth(int n10) {
        LinearGradient linearGradient;
        int n11 = this.d + n10;
        int n12 = this.e;
        this.s = n11 += n12;
        n12 = this.d;
        float f10 = n12;
        float f11 = n12 + n10;
        float f12 = this.getHeight();
        n10 = 255;
        int n13 = Color.rgb((int)n10, (int)190, (int)77);
        n12 = 145;
        int n14 = Color.rgb((int)n10, (int)n12, (int)72);
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        this.y = linearGradient = new LinearGradient(f10, 0.0f, f11, f12, n13, n14, tileMode);
        Paint paint = this.k;
        if (paint != null) {
            paint.setShader((Shader)linearGradient);
        }
        this.invalidate();
    }

    public void setFirstRectLeft(int n10) {
        this.d = n10;
    }

    public void setLastRectRight(int n10) {
        this.e = n10;
    }

    public void setMusicBeats(HashMap hashMap) {
        this.o = hashMap;
        this.invalidate();
    }

    public void setMusicStartTime(long l10) {
        this.D = l10;
    }

    public void setOnScrollListener(AudioBeatView$a audioBeatView$a) {
        this.z = audioBeatView$a;
    }

    public void t() {
        Object object;
        Iterator iterator2 = this.o.entrySet().iterator();
        while ((object = iterator2.hasNext()) != 0) {
            long l10;
            Map.Entry entry = iterator2.next();
            Long l11 = (Long)entry.getValue();
            long l12 = l11;
            long l13 = l12 - (l10 = this.D);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 < 0) continue;
            entry = (Long)entry.getValue();
            long l14 = (Long)((Object)entry);
            long l15 = this.D;
            long l16 = this.E;
            long l17 = l14 - (l15 += l16);
            object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object > 0) continue;
            iterator2.remove();
        }
        this.invalidate();
    }

    public void u(int n10) {
        this.C = false;
        this.scrollTo(n10, 0);
    }

    public void v(long l10, long l11) {
        ArrayList arrayList = this.p;
        if (arrayList == null) {
            this.p = arrayList = new ArrayList();
        }
        this.E = l11;
        this.p.clear();
        float f10 = (float)l10 / 1000000.0f;
        int n10 = 1;
        f10 = c2.d(f10, n10);
        float f11 = (float)l11 / 250000.0f;
        int n11 = (int)f11;
        arrayList = null;
        for (int i10 = 0; i10 <= n11; ++i10) {
            Object object;
            List list = this.p;
            Object object2 = new Object[n10];
            float f12 = i10;
            float f13 = 0.25f;
            f12 = f12 * f13 + f10;
            object2[0] = object = Float.valueOf(f12);
            object = "%s''";
            object2 = String.format((String)object, object2);
            list.add(object2);
        }
        this.invalidate();
    }
}

