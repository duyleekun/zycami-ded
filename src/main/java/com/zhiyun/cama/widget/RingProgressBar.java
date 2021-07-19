/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.CornerPathEffect
 *  android.graphics.Paint
 *  android.graphics.Paint$Cap
 *  android.graphics.Paint$Join
 *  android.graphics.Paint$Style
 *  android.graphics.Path
 *  android.graphics.PathEffect
 *  android.graphics.PathMeasure
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.animation.AccelerateInterpolator
 */
package com.zhiyun.cama.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.widget.RingProgressBar$a;
import d.v.c.b2.l;
import d.v.e.l.h2;
import d.v.e.l.o1;

public class RingProgressBar
extends View {
    private static final String x = "RingProgressBar";
    public static final int y = 0;
    public static final int z = 1;
    private Paint a;
    private Paint b;
    private Paint c;
    private int d;
    private int e;
    private int f;
    private float g;
    private float h;
    private int i;
    private int j = -1;
    private boolean k;
    private int l;
    private Bitmap m;
    private int n;
    private int o;
    private int p;
    private int q;
    private RectF r;
    private PathMeasure s;
    private Path t;
    private float u;
    private boolean v;
    private RingProgressBar$a w;

    public RingProgressBar(Context context) {
        this(context, null);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RingProgressBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        float f10;
        int n10;
        int[] nArray = R$styleable.RingProgressBar;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        this.d = n10 = context.getColor(3, -7829368);
        int n11 = -16711936;
        this.e = n10 = context.getColor(4, n11);
        this.f = n10 = context.getColor(5, n11);
        this.g = f10 = context.getDimension(6, 16.0f);
        this.h = f10 = context.getDimension(7, 5.0f);
        n10 = 1;
        this.i = n11 = context.getInteger(n10, 100);
        this.k = n10 = context.getBoolean(9, n10 != 0);
        nArray = null;
        this.l = n10 = context.getInt(8, 0);
        n10 = -1;
        f10 = 0.0f / 0.0f;
        this.n = n11 = context.getColor(0, n10);
        n11 = context.getResourceId(2, n10);
        if (n11 != n10) {
            attributeSet = BitmapFactory.decodeResource((Resources)this.getResources(), (int)n11);
            this.m = attributeSet;
        }
        context.recycle();
    }

    private void b() {
        Paint paint;
        int n10 = 1;
        float f10 = 0.0f;
        this.setLayerType(n10, null);
        this.a = paint = new Paint();
        paint.setAntiAlias(n10 != 0);
        paint = this.a;
        int n11 = this.d;
        paint.setColor(n11);
        paint = this.a;
        Paint.Style style2 = Paint.Style.FILL_AND_STROKE;
        paint.setStyle(style2);
        paint = this.a;
        float f11 = this.h;
        paint.setStrokeWidth(f11);
        this.b = paint = new Paint();
        paint.setAntiAlias(n10 != 0);
        paint = this.b;
        n11 = this.e;
        paint.setColor(n11);
        paint = this.b;
        f11 = this.h;
        paint.setStrokeWidth(f11);
        paint = this.b;
        style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.b;
        style2 = Paint.Join.ROUND;
        paint.setStrokeJoin((Paint.Join)style2);
        paint = this.b;
        style2 = Paint.Cap.ROUND;
        paint.setStrokeCap((Paint.Cap)style2);
        paint = this.b;
        float f12 = this.h;
        style2 = new CornerPathEffect(f12);
        paint.setPathEffect((PathEffect)style2);
        int n12 = this.l;
        if (n12 != 0) {
            if (n12 == n10) {
                paint = this.b;
                style2 = Paint.Style.FILL_AND_STROKE;
                paint.setStyle(style2);
            }
        } else {
            paint = this.b;
            style2 = Paint.Style.STROKE;
            paint.setStyle(style2);
        }
        paint = new Path();
        n11 = this.o;
        f12 = 4.0f;
        int n13 = h2.b(f12);
        f11 = n11 - n13;
        float f13 = this.p;
        paint.moveTo(f11, f13);
        f11 = this.o;
        n13 = this.p;
        int n14 = h2.b(f12);
        f13 = n13 + n14;
        paint.lineTo(f11, f13);
        n11 = this.o;
        n13 = h2.b(8.0f);
        f11 = n11 + n13;
        n13 = this.p;
        int n15 = h2.b(f12);
        f12 = n13 - n15;
        paint.lineTo(f11, f12);
        style2 = new PathMeasure((Path)paint, false);
        this.s = style2;
        paint = new Path();
        this.t = paint;
        this.c = paint = new Paint();
        paint.setAntiAlias(n10 != 0);
        Paint paint2 = this.c;
        n12 = this.f;
        paint2.setColor(n12);
        paint2 = this.c;
        f10 = this.g;
        paint2.setTextSize(f10);
    }

    private /* synthetic */ void c(ValueAnimator object) {
        float f10;
        object = (Float)object.getAnimatedValue();
        this.u = f10 = ((Float)object).floatValue();
        this.invalidate();
        f10 = this.u;
        float f11 = 1.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (f12 == false && (object = this.w) != null) {
            object.a();
        }
    }

    public /* synthetic */ void d(ValueAnimator valueAnimator) {
        this.c(valueAnimator);
    }

    public int getMax() {
        synchronized (this) {
            int n10 = this.i;
            return n10;
        }
    }

    public int getProgress() {
        synchronized (this) {
            int n10 = this.j;
            return n10;
        }
    }

    public int getRingColor() {
        return this.d;
    }

    public int getRingProgressColor() {
        return this.e;
    }

    public float getRingWidth() {
        return this.h;
    }

    public int getTextColor() {
        return this.f;
    }

    public float getTextSize() {
        return this.g;
    }

    public void onDraw(Canvas canvas) {
        int n10;
        float f10;
        Paint paint;
        float f11;
        Bitmap bitmap;
        Object object;
        super.onDraw(canvas);
        Object object2 = this.a;
        if (object2 == null) {
            return;
        }
        float f12 = this.o;
        int n11 = this.p;
        float f13 = n11;
        int n12 = this.q;
        float f14 = n12;
        canvas.drawCircle(f12, f13, f14, object2);
        object2 = this.c;
        int n13 = this.f;
        object2.setColor(n13);
        int n14 = this.j;
        int n15 = 2;
        if (n14 <= 0 && (object2 = this.m) != null) {
            n14 = object2.getWidth();
            object = this.m;
            n13 = object.getHeight();
            bitmap = this.m;
            n12 = this.o;
            f11 = n12 - (n14 /= n15);
            n12 = this.p;
            f12 = n12 -= (n13 /= n15);
            paint = this.c;
            canvas.drawBitmap(bitmap, f11, f12, paint);
        }
        n14 = this.j;
        int n16 = 1;
        if (n14 > 0 && n14 <= (n13 = this.i) && !(n11 = (int)(this.v ? 1 : 0))) {
            n11 = this.l;
            if (n11) {
                if (n11 == n16) {
                    bitmap = this.r;
                    n12 = -1028390912;
                    n14 = n14 * 360 / n13;
                    f10 = n14;
                    int n17 = 1;
                    float f15 = Float.MIN_VALUE;
                    Paint paint2 = this.b;
                    object2 = canvas;
                    object = bitmap;
                    n11 = n12;
                    f13 = -90.0f;
                    f14 = f10;
                    n10 = n17;
                    f10 = f15;
                    canvas.drawArc((RectF)bitmap, f13, f14, n17 != 0, paint2);
                }
            } else {
                bitmap = this.r;
                n12 = -1028390912;
                n14 = n14 * 360 / n13;
                f10 = n14;
                boolean bl2 = false;
                float f16 = 0.0f;
                Paint paint3 = this.b;
                object2 = canvas;
                object = bitmap;
                n11 = n12;
                f13 = -90.0f;
                f14 = f10;
                n10 = 0;
                f10 = 0.0f;
                canvas.drawArc((RectF)bitmap, f13, f14, false, paint3);
            }
        }
        object2 = this.c;
        object = Typeface.DEFAULT_BOLD;
        object2.setTypeface((Typeface)object);
        object2 = new StringBuilder();
        n13 = this.j;
        object2.append(n13);
        object2.append("%");
        object2 = object2.toString();
        object = this.c;
        f13 = 0.0f;
        bitmap = null;
        n12 = object2.length();
        f12 = object.measureText((String)object2, 0, n12);
        n11 = (int)(this.k ? 1 : 0);
        if (n11 && (n11 = this.j) > 0 && n11 <= (n12 = this.i) && (n10 = this.l) == 0) {
            if (n11 >= n12) {
                bitmap = this.c;
                paint = this.getContext().getResources();
                n10 = 2131099771;
                f10 = 1.7811905E38f;
                n12 = o1.c((Resources)paint, n10);
                bitmap.setColor(n12);
            } else {
                bitmap = this.c;
                n12 = this.f;
                bitmap.setColor(n12);
            }
            n11 = this.o;
            f13 = n11;
            n12 = 0x40000000;
            f14 = 2.0f;
            n13 = this.p;
            f12 = n13;
            f10 = this.g / f14;
            paint = this.c;
            canvas.drawText((String)object2, f13 -= (f12 /= f14), f12 += f10, paint);
        } else {
            object2 = this.m;
            n14 = object2.getWidth();
            object = this.m;
            n13 = object.getHeight();
            bitmap = this.m;
            n12 = this.o;
            f11 = n12 - (n14 /= n15);
            n12 = this.p;
            f12 = n12 -= (n13 /= n15);
            paint = this.c;
            canvas.drawBitmap(bitmap, f11, f12, paint);
        }
        n14 = this.j;
        n13 = this.i;
        if (n14 >= n13) {
            n14 = (int)(this.v ? 1 : 0);
            if (n14 == 0) {
                this.v = n16;
                object2 = this.b;
                n13 = this.n;
                object2.setColor(n13);
                Object object3 = object2 = (Object)new float[n15];
                object3[0] = (Paint)0.0f;
                object3[1] = (Paint)1.0f;
                object2 = ValueAnimator.ofFloat((float[])object2);
                object = new l(this);
                object2.addUpdateListener((ValueAnimator.AnimatorUpdateListener)object);
                long l10 = 1000L;
                object2.setDuration(l10);
                object = new AccelerateInterpolator();
                object2.setInterpolator((TimeInterpolator)object);
                object2.start();
            } else {
                f11 = this.s.getLength();
                f12 = this.u;
                object = this.s;
                n11 = 0;
                f13 = 0.0f;
                bitmap = null;
                paint = this.t;
                object.getSegment(0.0f, f11 *= f12, (Path)paint, n16 != 0);
                object2 = this.t;
                object = this.b;
                canvas.drawPath((Path)object2, (Paint)object);
            }
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        RectF rectF;
        super.onSizeChanged(n10, n11, n12, n13);
        this.o = n10 = this.getMeasuredWidth() / 2;
        this.p = n10 = this.getMeasuredHeight() / 2;
        float f10 = this.o;
        float f11 = this.h / 2.0f;
        this.q = n10 = (int)(f10 - f11);
        n11 = this.o;
        n12 = this.q;
        float f12 = n11 - n12;
        int n14 = this.p;
        float f13 = n14 - n12;
        f11 = n11 + n12;
        float f14 = n14 + n12;
        this.r = rectF = new RectF(f12, f13, f11, f14);
        this.b();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setMax(int n10) {
        synchronized (this) {
            Throwable throwable2;
            if (n10 >= 0) {
                try {
                    this.i = n10;
                    return;
                }
                catch (Throwable throwable2) {}
            } else {
                String string2 = "max not less than 0";
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            throw throwable2;
        }
    }

    public void setOnCompletedAnimListener(RingProgressBar$a ringProgressBar$a) {
        this.w = ringProgressBar$a;
    }

    public void setProgress(int n10) {
        synchronized (this) {
            block5: {
                int n11 = this.i;
                if (n10 <= n11) break block5;
                return;
            }
            this.j = n10;
            n10 = 0;
            Object var3_3 = null;
            this.v = false;
            this.postInvalidate();
            return;
        }
    }

    public void setRingColor(int n10) {
        this.d = n10;
    }

    public void setRingProgressColor(int n10) {
        this.e = n10;
    }

    public void setRingWidth(float f10) {
        this.h = f10;
    }

    public void setTextColor(int n10) {
        this.f = n10;
    }

    public void setTextSize(float f10) {
        this.g = f10;
    }
}

