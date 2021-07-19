/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.DrawFilter
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.PaintFlagsDrawFilter
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.PorterDuffXfermode
 *  android.graphics.Xfermode
 *  android.os.CountDownTimer
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DrawFilter;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.camera.widget.MutiNodeProgress$a;
import d.v.e.l.h2;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MutiNodeProgress
extends View {
    public static final int B = 300;
    public static final int C = 20;
    public static final int D = 20;
    public static final int E = 0;
    public static final int F = 0;
    public static final int G = 0;
    public static final int H = 0;
    public static final int I = 14;
    public static final int J = 10;
    public static final int K = 3;
    private PaintFlagsDrawFilter A;
    private Paint a;
    private Paint b;
    private Paint c;
    private Paint d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;
    private int q;
    private List r;
    private int s;
    private int t;
    private int u;
    private CountDownTimer v;
    private long w;
    private String x;
    private int y;
    private int z;

    static {
        int n10 = 255;
        E = Color.rgb((int)n10, (int)n10, (int)n10);
        F = Color.rgb((int)n10, (int)n10, (int)n10);
        G = Color.argb((int)99, (int)0, (int)0, (int)0);
        H = Color.parseColor((String)"#ff4253");
    }

    public MutiNodeProgress(Context object) {
        super(object);
        super();
        this.a = object;
        super();
        this.b = object;
        super();
        this.c = object;
        super();
        this.d = object;
        super();
        this.r = object;
    }

    public MutiNodeProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Object object;
        this.a = object = new Paint();
        this.b = object = new Paint();
        this.c = object = new Paint();
        this.d = object = new Paint();
        super();
        this.r = object;
        this.c(context, attributeSet);
    }

    public MutiNodeProgress(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        Object object;
        this.a = object = new Paint();
        this.b = object = new Paint();
        this.c = object = new Paint();
        this.d = object = new Paint();
        super();
        this.r = object;
        this.c(context, attributeSet);
    }

    public MutiNodeProgress(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        Object object;
        this.a = object = new Paint();
        this.b = object = new Paint();
        this.c = object = new Paint();
        this.d = object = new Paint();
        super();
        this.r = object;
        this.c(context, attributeSet);
    }

    public static /* synthetic */ int a(MutiNodeProgress mutiNodeProgress, int n10) {
        mutiNodeProgress.s = n10;
        return n10;
    }

    public static /* synthetic */ int b(MutiNodeProgress mutiNodeProgress) {
        int n10;
        int n11 = mutiNodeProgress.s;
        mutiNodeProgress.s = n10 = n11 + 1;
        return n11;
    }

    private void c(Context context, AttributeSet attributeSet) {
        int n10;
        int n11;
        int n12;
        int n13;
        Object object = R$styleable.MutiNodeProgress;
        context = context.obtainStyledAttributes(attributeSet, object);
        int n14 = 3;
        attributeSet = new PaintFlagsDrawFilter(0, n14);
        this.A = attributeSet;
        this.e = n13 = context.getDimensionPixelSize(6, 300);
        n13 = 1;
        int n15 = 20;
        this.f = n12 = context.getDimensionPixelSize(n13, n15);
        this.g = n12 = context.getDimensionPixelSize(5, 0);
        this.h = n15 = context.getDimensionPixelSize(4, n15);
        n15 = E;
        this.i = n15 = context.getColor(7, n15);
        n15 = F;
        this.j = n12 = context.getColor(8, n15);
        this.k = n15 = context.getColor(9, n15);
        this.l = n15 = context.getDimensionPixelSize(2, 14);
        n15 = G;
        this.m = n11 = context.getColor(0, n15);
        n11 = H;
        this.n = n11 = context.getColor(n14, n11);
        context.recycle();
        context = this.a;
        n11 = this.j;
        context.setColor(n11);
        context = this.a;
        float f10 = h2.g(this.l);
        context.setTextSize(f10);
        context = this.a;
        f10 = this.o;
        context.setStrokeWidth(f10);
        this.a.setAntiAlias(n13 != 0);
        context = this.a;
        attributeSet = Paint.Style.FILL;
        context.setStyle((Paint.Style)attributeSet);
        context = this.b;
        n13 = this.k;
        context.setColor(n13);
        context = this.b;
        attributeSet = Paint.Style.FILL;
        context.setStyle((Paint.Style)attributeSet);
        context = this.b;
        object = PorterDuff.Mode.SRC_IN;
        attributeSet = new PorterDuffXfermode((PorterDuff.Mode)object);
        context.setXfermode((Xfermode)attributeSet);
        context = this.d;
        n13 = this.m;
        context.setColor(n13);
        context = this.d;
        attributeSet = Paint.Style.FILL;
        context.setStyle((Paint.Style)attributeSet);
        context = this.d;
        object = PorterDuff.Mode.SRC;
        attributeSet = new PorterDuffXfermode((PorterDuff.Mode)object);
        context.setXfermode((Xfermode)attributeSet);
        context = this.d;
        float f11 = this.h;
        context.setStrokeWidth(f11);
        context = this.c;
        n13 = this.n;
        context.setColor(n13);
        context = this.c;
        attributeSet = Paint.Style.FILL;
        context.setStyle((Paint.Style)attributeSet);
        context = this.c;
        object = PorterDuff.Mode.SRC_IN;
        attributeSet = new PorterDuffXfermode((PorterDuff.Mode)object);
        context.setXfermode((Xfermode)attributeSet);
        this.q = n14;
        this.t = n10 = (int)this.a.measureText("A");
        float f12 = this.a.ascent();
        f11 = this.a.descent();
        this.u = n10 = Math.abs((int)(f12 + f11));
        this.p = n10 = h2.b(6.0f);
    }

    private void d() {
        CountDownTimer countDownTimer = this.v;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countDownTimer = null;
            this.v = null;
        }
    }

    private void g() {
        this.s = 0;
        this.invalidate();
        long l10 = this.w;
        long l11 = l10 / (long)100;
        MutiNodeProgress$a mutiNodeProgress$a = new MutiNodeProgress$a(this, l10, l11);
        mutiNodeProgress$a = mutiNodeProgress$a.start();
        this.v = mutiNodeProgress$a;
    }

    public MutiNodeProgress e(long l10) {
        this.w = l10;
        return this;
    }

    public void f() {
        this.setVisibility(0);
        this.d();
        this.g();
    }

    public void h() {
        this.d();
        this.setVisibility(8);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.d();
    }

    public void onDraw(Canvas canvas) {
        String string2;
        Object object;
        int n10;
        float f10;
        super.onDraw(canvas);
        float f11 = this.getWidth();
        float f12 = this.getHeight();
        Paint paint = this.a;
        Float f13 = null;
        int n11 = 0;
        float f14 = 0.0f;
        Paint paint2 = null;
        Object object2 = canvas;
        int n12 = canvas.saveLayer(0.0f, 0.0f, f11, f12, paint);
        object2 = this.A;
        canvas.setDrawFilter((DrawFilter)object2);
        int n13 = this.q;
        int n14 = 1;
        float f15 = Float.MIN_VALUE;
        if (n13 > n14) {
            n11 = this.f;
            f14 = n11;
        } else {
            n11 = 0;
            f14 = 0.0f;
            paint2 = null;
        }
        f12 = f14;
        n11 = this.f;
        int n15 = this.h;
        int n16 = n15 / 2;
        n16 = n11 - n16;
        float f16 = n16;
        n13 = n13 > n14 ? this.e - n11 : this.e;
        float f17 = f10 = (float)n13;
        float f18 = n11 + (n15 /= 2);
        n13 = this.g;
        float f19 = n13;
        float f20 = n13;
        Paint paint3 = this.d;
        canvas.drawRoundRect(f12, f16, f10, f18, f19, f20, paint3);
        n13 = this.q;
        n11 = 0;
        f14 = 0.0f;
        paint2 = null;
        if (n13 > n14) {
            n15 = this.e;
            n10 = this.f * 2;
            n15 -= n10;
            n15 /= (n13 -= n14);
            object2 = null;
            f10 = 0.0f;
            for (n13 = 0; n13 < (n10 = this.q); ++n13) {
                Paint paint4;
                object = this.r;
                if (object != null && (n10 = (int)(object.isEmpty() ? 1 : 0)) == 0) {
                    object = (Float)this.r.get(n13);
                    f12 = ((Float)object).floatValue();
                    n16 = this.f;
                    f17 = n16;
                    f16 = n16;
                    paint4 = this.d;
                    canvas.drawCircle(f12, f17, f16, paint4);
                    continue;
                }
                n10 = this.f;
                n16 = n13 * n15 + n10;
                f16 = n16;
                f17 = n10;
                f12 = n10;
                paint4 = this.d;
                canvas.drawCircle(f16, f17, f12, paint4);
            }
        } else {
            n15 = 0;
            f11 = 0.0f;
        }
        n16 = 0;
        f16 = 0.0f;
        paint = null;
        f17 = 0.0f;
        n13 = this.e;
        n10 = this.s;
        f18 = n13 * n10 / 100;
        n13 = this.f * 2;
        f19 = n13;
        Paint paint5 = this.c;
        object = canvas;
        canvas.drawRect(0.0f, 0.0f, f18, f19, paint5);
        canvas.restoreToCount(n12);
        n12 = this.q;
        if (n12 > n14) {
            n16 = 0;
            f16 = 0.0f;
            paint = null;
            f17 = 0.0f;
            f18 = this.getWidth();
            f19 = this.getHeight();
            paint5 = this.a;
            n12 = canvas.saveLayer(0.0f, 0.0f, f18, f19, paint5);
            while (n11 < (n13 = this.q)) {
                object2 = this.r;
                if (object2 != null && (n13 = (int)(object2.isEmpty() ? 1 : 0)) == 0) {
                    n13 = (char)(n11 + 65);
                    object2 = Character.toString((char)n13);
                    f13 = (Float)this.r.get(n11);
                    f15 = f13.floatValue();
                    f12 = this.t / 2;
                    f15 -= f12;
                    n10 = this.f;
                    n16 = this.u / 2;
                    f12 = n10 += n16;
                    paint = this.a;
                    canvas.drawText((String)object2, f15, f12, paint);
                } else {
                    n13 = (char)(n11 + 65);
                    object2 = Character.toString((char)n13);
                    n14 = this.f;
                    n10 = n11 * n15 + n14;
                    n16 = this.t / 2;
                    f12 = n10 -= n16;
                    n16 = this.u / 2;
                    f15 = n14 += n16;
                    paint = this.a;
                    canvas.drawText((String)object2, f12, f15, paint);
                }
                ++n11;
            }
            n16 = 0;
            f16 = 0.0f;
            paint = null;
            f17 = 0.0f;
            n13 = this.e;
            n14 = this.s;
            f18 = n13 * n14 / 100;
            n13 = this.f * 2;
            f19 = n13;
            paint5 = this.b;
            object = canvas;
            canvas.drawRect(0.0f, 0.0f, f18, f19, paint5);
            canvas.restoreToCount(n12);
        }
        if ((string2 = this.x) != null) {
            n13 = this.e;
            n14 = this.y;
            n13 = (n13 - n14) / 2;
            f10 = n13;
            n14 = this.getHeight();
            n11 = this.z / 2;
            f15 = n14 -= n11;
            paint2 = this.a;
            canvas.drawText(string2, f10, f15, paint2);
        }
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        String string2 = this.x;
        if (string2 == null) {
            n10 = this.e;
            n11 = this.f * 2;
            this.setMeasuredDimension(n10, n11);
        } else {
            n10 = this.e;
            n11 = this.f * 2;
            int n12 = this.p;
            n11 += n12;
            n12 = this.z;
            this.setMeasuredDimension(n10, n11 += n12);
        }
    }

    public void setNode(List object) {
        if (object != null) {
            int n10 = object.size();
            int n11 = 3;
            float f10 = 4.2E-45f;
            if (n10 >= n11) {
                float f11;
                float f12;
                Integer n12;
                int n13;
                int n14;
                Serializable serializable = new ArrayList();
                ArrayList<Object> arrayList = new ArrayList<Object>();
                int n15 = object.size();
                int n16 = this.e;
                int n17 = this.f;
                int n18 = 2;
                n16 -= (n17 *= n18);
                n17 = 0;
                float f13 = 0.0f;
                Float f14 = null;
                Float f15 = null;
                float f16 = 0.0f;
                int n19 = 0;
                float f17 = 0.0f;
                for (n14 = 0; n14 < n15; ++n14) {
                    n13 = (Integer)object.get(n14);
                    n12 = n19 += n13;
                    serializable.add(n12);
                }
                while (true) {
                    f12 = 1.0f;
                    if (n17 >= n15) break;
                    n14 = this.f;
                    f16 = n14;
                    n12 = (Integer)serializable.get(n17);
                    n13 = n12;
                    f11 = (float)n13 * f12;
                    f12 = n19;
                    f11 /= f12;
                    f12 = n16;
                    object = Float.valueOf(f16 += (f11 *= f12));
                    arrayList.add(object);
                    ++n17;
                }
                n10 = arrayList.size();
                n15 = 1;
                float f18 = Float.MIN_VALUE;
                if (n11 == n10) {
                    float f19;
                    float f20;
                    serializable = (Float)arrayList.get(n15);
                    f13 = ((Float)serializable).floatValue();
                    float f21 = f13 - (f16 = (float)(n14 = (n18 = this.f) * 3));
                    n17 = (int)(f21 == 0.0f ? 0 : (f21 < 0.0f ? -1 : 1));
                    if (n17 < 0) {
                        f10 = (float)(n18 *= n11) * f12;
                        Float f22 = Float.valueOf(f10);
                        arrayList.set(n15, f22);
                    }
                    if ((n10 = (int)((f20 = (f19 = ((Float)serializable).floatValue()) - (f13 = (float)(n17 = n16 - (n11 = this.f)))) == 0.0f ? 0 : (f20 > 0.0f ? 1 : -1))) > 0) {
                        f19 = n16;
                        f10 = (float)n11 * f12;
                        object = Float.valueOf(f19 -= f10);
                        arrayList.set(n15, object);
                    }
                } else {
                    n10 = 4;
                    float f23 = 5.6E-45f;
                    n17 = arrayList.size();
                    if (n10 == n17) {
                        float f24;
                        serializable = (Float)arrayList.get(n15);
                        f13 = ((Float)serializable).floatValue();
                        float f25 = f13 - (f17 = (float)(n19 = (n14 = this.f) * 3));
                        n17 = (int)(f25 == 0.0f ? 0 : (f25 < 0.0f ? -1 : 1));
                        if (n17 < 0) {
                            f13 = (float)(n14 *= n11) * f12;
                            f14 = Float.valueOf(f13);
                            arrayList.set(n15, f14);
                        }
                        f23 = ((Float)serializable).floatValue();
                        n17 = this.f;
                        n14 = n17 * 3;
                        f16 = n14 = n16 - n14;
                        float f26 = f23 - f16;
                        n10 = (int)(f26 == 0.0f ? 0 : (f26 > 0.0f ? 1 : -1));
                        if (n10 > 0) {
                            f23 = n16;
                            f10 = (float)(n17 *= n11) * f12;
                            serializable = Float.valueOf(f23 -= f10);
                            arrayList.set(n15, serializable);
                        }
                        serializable = (Float)arrayList.get(n18);
                        f10 = ((Float)serializable).floatValue();
                        f14 = (Float)arrayList.get(n15);
                        f13 = f14.floatValue();
                        n14 = this.f * n18;
                        f16 = n14;
                        float f27 = f10 - (f13 += f16);
                        n11 = (int)(f27 == 0.0f ? 0 : (f27 < 0.0f ? -1 : 1));
                        if (n11 < 0) {
                            f10 = ((Float)arrayList.get(n15)).floatValue();
                            n15 = this.f * n18;
                            f18 = n15;
                            Float f28 = Float.valueOf(f10 += f18);
                            arrayList.set(n18, f28);
                        }
                        if ((n10 = (int)((f24 = (f23 = ((Float)serializable).floatValue()) - (f18 = (float)(n15 = n16 - (n11 = this.f)))) == 0.0f ? 0 : (f24 > 0.0f ? 1 : -1))) > 0) {
                            f23 = n16;
                            f10 = (float)n11 * f12;
                            object = Float.valueOf(f23 -= f10);
                            arrayList.set(n18, object);
                        }
                    } else {
                        n10 = arrayList.size();
                        n17 = 5;
                        f13 = 7.0E-45f;
                        if (n17 == n10) {
                            float f29;
                            Float f30;
                            serializable = (Float)arrayList.get(n15);
                            f16 = ((Float)serializable).floatValue();
                            float f31 = f16 - (f11 = (float)(n13 = (n19 = this.f) * 3));
                            n14 = (int)(f31 == 0.0f ? 0 : (f31 < 0.0f ? -1 : 1));
                            if (n14 < 0) {
                                f16 = (float)(n19 *= n11) * f12;
                                f15 = Float.valueOf(f16);
                                arrayList.set(n15, f15);
                            }
                            f23 = ((Float)serializable).floatValue();
                            n14 = this.f;
                            n19 = n14 * 5;
                            f17 = n19 = n16 - n19;
                            float f32 = f23 - f17;
                            n10 = (int)(f32 == 0.0f ? 0 : (f32 > 0.0f ? 1 : -1));
                            if (n10 > 0) {
                                f23 = n16;
                                f13 = (float)(n14 *= n17) * f12;
                                serializable = Float.valueOf(f23 -= f13);
                                arrayList.set(n15, serializable);
                            }
                            serializable = (Float)arrayList.get(n18);
                            f13 = ((Float)serializable).floatValue();
                            f15 = (Float)arrayList.get(n15);
                            f16 = f15.floatValue();
                            n19 = this.f * n18;
                            f17 = n19;
                            float f33 = f13 - (f16 += f17);
                            n17 = (int)(f33 == 0.0f ? 0 : (f33 < 0.0f ? -1 : 1));
                            if (n17 < 0) {
                                f18 = ((Float)arrayList.get(n15)).floatValue();
                                n17 = this.f * n18;
                                f13 = n17;
                                f30 = Float.valueOf(f18 += f13);
                                arrayList.set(n18, f30);
                            }
                            f23 = ((Float)serializable).floatValue();
                            n15 = this.f;
                            n17 = n15 * 3;
                            f13 = n17 = n16 - n17;
                            float f34 = f23 - f13;
                            n10 = (int)(f34 == 0.0f ? 0 : (f34 > 0.0f ? 1 : -1));
                            if (n10 > 0) {
                                f23 = n16;
                                f18 = (float)(n15 *= n11) * f12;
                                serializable = Float.valueOf(f23 -= f18);
                                arrayList.set(n18, serializable);
                            }
                            serializable = (Float)arrayList.get(n11);
                            f18 = ((Float)serializable).floatValue();
                            f14 = (Float)arrayList.get(n18);
                            f13 = f14.floatValue();
                            n14 = this.f * n18;
                            f16 = n14;
                            float f35 = f18 - (f13 += f16);
                            n15 = (int)(f35 == 0.0f ? 0 : (f35 < 0.0f ? -1 : 1));
                            if (n15 < 0) {
                                f18 = ((Float)arrayList.get(n18)).floatValue();
                                n17 = this.f * n18;
                                f13 = n17;
                                f30 = Float.valueOf(f18 += f13);
                                arrayList.set(n11, f30);
                            }
                            if ((n10 = (int)((f29 = (f23 = ((Float)serializable).floatValue()) - (f13 = (float)(n17 = n16 - (n15 = this.f)))) == 0.0f ? 0 : (f29 > 0.0f ? 1 : -1))) > 0) {
                                f23 = n16;
                                f18 = (float)n15 * f12;
                                object = Float.valueOf(f23 -= f18);
                                arrayList.set(n11, object);
                            }
                        }
                    }
                }
                this.r = arrayList;
                return;
            }
        }
        this.r = null;
    }

    public void setNodeNum(int n10) {
        this.q = n10;
        this.invalidate();
    }

    public void setProgress(int n10) {
        this.s = n10;
        this.invalidate();
    }

    public void setTipText(String string2) {
        int n10;
        this.x = string2;
        this.y = n10 = (int)this.a.measureText(string2);
        float f10 = this.a.ascent();
        float f11 = this.a.descent();
        this.z = n10 = Math.abs((int)(f10 + f11));
        this.invalidate();
    }
}

