/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Align
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.os.Build$VERSION
 *  android.util.AttributeSet
 *  android.util.Range
 *  android.view.MotionEvent
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Range;
import android.view.MotionEvent;
import android.widget.SeekBar;
import androidx.core.content.res.ResourcesCompat;
import com.zhiyun.cama.camera.widget.PartitionSeekBar$a;
import d.v.e.l.d2;
import d.v.e.l.h2;
import java.math.BigDecimal;

public class PartitionSeekBar
extends SeekBar {
    private float a;
    private float b;
    private float c;
    private int d;
    private Paint e;
    private Paint f;
    private Paint g;
    private Paint h;
    private int i;
    private int j;
    private int k;
    private int l;
    private float m;
    private float n;
    private Typeface o;
    private float[] p;
    private Range q;
    private boolean r;
    private String s;
    private float t;
    private SeekBar.OnSeekBarChangeListener u;

    public PartitionSeekBar(Context context) {
        super(context);
        int n10;
        int n11;
        int n12;
        float f10;
        float f11 = 2.0f;
        this.a = f10 = h2.a(f11);
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0x66000000;
        this.i = n12 = h2.b(16.0f);
        this.j = n12 = h2.b(f11);
        f10 = 1.0f;
        this.k = n11 = h2.b(f10);
        this.l = n10 = h2.b(f11);
        this.m = f11 = (float)h2.b(f10);
        this.n = f11 = (float)h2.g(14.0f);
        this.r = true;
        this.f(context, null);
    }

    public PartitionSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        int n11;
        int n12;
        float f10;
        float f11 = 2.0f;
        this.a = f10 = h2.a(f11);
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0x66000000;
        this.i = n12 = h2.b(16.0f);
        this.j = n12 = h2.b(f11);
        f10 = 1.0f;
        this.k = n11 = h2.b(f10);
        this.l = n10 = h2.b(f11);
        this.m = f11 = (float)h2.b(f10);
        this.n = f11 = (float)h2.g(14.0f);
        this.r = true;
        this.f(context, attributeSet);
    }

    public PartitionSeekBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        int n12;
        float f10;
        float f11 = 2.0f;
        this.a = f10 = h2.a(f11);
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0x66000000;
        this.i = n12 = h2.b(16.0f);
        this.j = n12 = h2.b(f11);
        f10 = 1.0f;
        this.k = n11 = h2.b(f10);
        this.l = n10 = h2.b(f11);
        this.m = f11 = (float)h2.b(f10);
        this.n = f11 = (float)h2.g(14.0f);
        this.r = true;
        this.f(context, attributeSet);
    }

    public static /* synthetic */ Range a(PartitionSeekBar partitionSeekBar) {
        return partitionSeekBar.q;
    }

    public static /* synthetic */ SeekBar.OnSeekBarChangeListener b(PartitionSeekBar partitionSeekBar) {
        return partitionSeekBar.u;
    }

    private void c(Canvas canvas, RectF rectF) {
        Paint paint;
        float f10;
        Object object;
        Paint paint2;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        int n10 = this.r;
        if (n10 == 0) {
            return;
        }
        n10 = this.getPaddingLeft();
        float f16 = n10;
        int n11 = this.getWidth();
        int n12 = this.getPaddingRight();
        float f17 = n11 - n12;
        float f18 = this.getThumbPointY();
        n11 = this.l;
        n12 = this.k * 2;
        float f19 = n11 + n12;
        canvas.save();
        n11 = Build.VERSION.SDK_INT;
        n12 = 26;
        float f20 = 3.6E-44f;
        if (n11 >= n12) {
            canvas.clipOutRect(rectF);
        }
        if ((rectF = this.q) != null) {
            f15 = this.getThumbPointY();
            f14 = this.k;
            f13 = f15 - f14;
            f15 = f17 - f16;
            f14 = ((Float)this.q.getLower()).floatValue() * f15;
            f12 = f16 + f14;
            f14 = this.getThumbPointY();
            n12 = this.k;
            f20 = n12;
            f11 = f14 + f20;
            paint2 = this.f;
            object = canvas;
            f20 = f16;
            canvas.drawRect(f16, f13, f12, f11, paint2);
            object = (Float)this.q.getUpper();
            f14 = object.floatValue();
            f13 = f16 + (f15 *= f14);
            f15 = this.getThumbPointY();
            f14 = this.k;
            f12 = f15 - f14;
            f15 = this.getThumbPointY();
            n11 = this.k;
            f14 = n11;
            f10 = f15 + f14;
            Paint paint3 = this.f;
            paint = canvas;
            f11 = f17;
            canvas.drawRect(f13, f12, f17, f10, paint3);
        }
        int n13 = this.k;
        f15 = n13;
        f14 = f16;
        while ((n12 = (int)(f14 == f17 ? 0 : (f14 < f17 ? -1 : 1))) < 0) {
            paint = this.e;
            canvas.drawCircle(f14, f18, f15, paint);
            f14 += f19;
        }
        n13 = this.j;
        f15 = n13;
        object = this.p;
        if (object != null) {
            n12 = ((float[])object).length;
            f13 = 0.0f;
            f12 = 0.0f;
            for (int i10 = 0; i10 < n12; ++i10) {
                Float f21 = Float.valueOf(object[i10]);
                f10 = f17 - f16;
                f11 = f21.floatValue();
                f10 *= f11;
                f11 = f10 / f19;
                int n14 = (int)f11;
                float f22 = (float)n14 * f19;
                float f23 = (f10 -= f22) - (f22 = f19 / 2.0f);
                Object object2 = f23 == 0.0f ? 0 : (f23 < 0.0f ? -1 : 1);
                if (object2 <= 0) {
                    object2 = false;
                    paint2 = null;
                    f10 = 0.0f;
                } else {
                    object2 = true;
                    f10 = Float.MIN_VALUE;
                }
                f11 = (float)(n14 += object2) * f19 + f16;
                paint2 = this.e;
                canvas.drawCircle(f11, f18, f15, paint2);
            }
        }
        canvas.restore();
    }

    private void d(Canvas canvas, float f10, float f11, float f12) {
        Paint paint = this.g;
        canvas.drawCircle(f10, f11, f12, paint);
        String string2 = this.getShowProgress();
        float f13 = d2.b(this.h) / 2.0f;
        paint = this.h;
        canvas.drawText(string2, f10, f11 += f13, paint);
    }

    private RectF e(float f10) {
        float f11 = this.getThumbPointX();
        float f12 = this.getThumbPointY();
        float f13 = f11 - f10;
        float f14 = f12 - f10;
        RectF rectF = new RectF(f13, f14, f11 += f10, f12 += f10);
        return rectF;
    }

    private void f(Context context, AttributeSet attributeSet) {
        this.g(context, attributeSet);
        this.i();
        this.h();
    }

    private void g(Context context, AttributeSet attributeSet) {
    }

    private String getDefaultShowProgress() {
        float f10 = (float)this.getProgress() * 1.0f;
        float f11 = this.getMax();
        StringBuilder stringBuilder = new StringBuilder();
        double d10 = f10 /= f11;
        BigDecimal bigDecimal = new BigDecimal(d10);
        int n10 = 1;
        f10 = bigDecimal.setScale(n10, n10).floatValue();
        stringBuilder.append(f10);
        stringBuilder.append(" ");
        return stringBuilder.toString();
    }

    private float getNormalThumbPointX() {
        float f10 = this.getPaddingLeft();
        int n10 = this.getWidth();
        int n11 = this.getPaddingRight();
        n10 -= n11;
        n11 = this.getPaddingLeft();
        n10 -= n11;
        n11 = this.getProgress();
        float f11 = n10 * n11;
        float f12 = (float)this.getMax() * 1.0f;
        return f10 + (f11 /= f12);
    }

    private String getShowProgress() {
        String string2 = this.getProgressText();
        string2 = string2 == null ? this.getDefaultShowProgress() : this.getProgressText();
        return string2;
    }

    private float getThumbPointX() {
        float f10;
        int n10 = this.r;
        if (n10 != 0) {
            f10 = this.getNormalThumbPointX();
        } else {
            n10 = this.getWidth();
            f10 = n10;
            float f11 = 2.0f;
            f10 /= f11;
        }
        return f10;
    }

    private float getThumbPointY() {
        return (float)this.getHeight() / 2.0f;
    }

    private void h() {
        PartitionSeekBar$a partitionSeekBar$a = new PartitionSeekBar$a(this);
        super.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)partitionSeekBar$a);
    }

    private void i() {
        Paint paint;
        this.e = paint = new Paint();
        int n10 = -1;
        paint.setColor(n10);
        paint = this.e;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.e;
        boolean bl2 = true;
        float f10 = Float.MIN_VALUE;
        paint.setAntiAlias(bl2);
        paint = this.e;
        float f11 = this.a;
        float f12 = this.b;
        float f13 = this.c;
        int n11 = this.d;
        paint.setShadowLayer(f11, f12, f13, n11);
        this.f = paint = new Paint();
        paint.setColor(-65536);
        paint = this.f;
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        this.f.setAntiAlias(bl2);
        paint = this.f;
        int n12 = 127;
        paint.setAlpha(n12);
        this.g = paint = new Paint();
        paint.setColor(n10);
        paint = this.g;
        style3 = Paint.Style.STROKE;
        paint.setStyle(style3);
        paint = this.g;
        f11 = this.m;
        paint.setStrokeWidth(f11);
        this.g.setAntiAlias(bl2);
        paint = this.g;
        f11 = this.a;
        f12 = this.b;
        f13 = this.c;
        n11 = this.d;
        paint.setShadowLayer(f11, f12, f13, n11);
        this.h = paint = new Paint();
        paint.setColor(n10);
        paint = this.h;
        float f14 = this.n;
        paint.setTextSize(f14);
        paint = this.h;
        Paint.Style style4 = Paint.Style.FILL;
        paint.setStyle(style4);
        this.h.setAntiAlias(bl2);
        paint = this.h;
        style4 = Paint.Align.CENTER;
        paint.setTextAlign((Paint.Align)style4);
        paint = this.getContext();
        n10 = 2131296257;
        f14 = 1.8210426E38f;
        paint = ResourcesCompat.getFont((Context)paint, n10);
        this.o = paint;
        if (paint != null) {
            style4 = this.h;
            style4.setTypeface((Typeface)paint);
        }
        paint = this.h;
        f14 = this.a;
        f10 = this.b;
        f11 = this.c;
        int n13 = this.d;
        paint.setShadowLayer(f14, f10, f11, n13);
    }

    public String getProgressText() {
        return this.s;
    }

    public void onDraw(Canvas canvas) {
        synchronized (this) {
            int n10 = this.i;
            float f10 = n10;
            RectF rectF = this.e(f10);
            this.c(canvas, rectF);
            float f11 = rectF.centerX();
            f10 = rectF.centerY();
            int n11 = this.i;
            float f12 = n11;
            this.d(canvas, f11, f10, f12);
            return;
        }
    }

    public boolean onFilterTouchEventForSecurity(MotionEvent motionEvent) {
        float f10;
        float f11;
        float f12;
        RectF rectF;
        boolean bl2;
        int n10 = super.onFilterTouchEventForSecurity(motionEvent);
        if (n10 != 0 && ((n10 = this.r) != 0 || (n10 = motionEvent.getAction()) != 0 || (bl2 = (rectF = this.e(f12 = (float)(n10 = this.i))).contains(f11 = motionEvent.getX(), f10 = motionEvent.getY())))) {
            bl2 = true;
            f10 = Float.MIN_VALUE;
        } else {
            bl2 = false;
            f10 = 0.0f;
            motionEvent = null;
        }
        return bl2;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float f10;
        int n10 = motionEvent.getAction();
        if (n10 == 0) {
            f10 = this.getNormalThumbPointX();
            float f11 = motionEvent.getX();
            this.t = f10 -= f11;
        }
        f10 = this.t;
        motionEvent.offsetLocation(f10, 0.0f);
        return super.onTouchEvent(motionEvent);
    }

    public void setEnabled(boolean bl2) {
        boolean bl3 = this.isEnabled();
        if (bl2 != bl3 && !bl2) {
            long l10 = System.currentTimeMillis();
            int n10 = 3;
            MotionEvent motionEvent = MotionEvent.obtain((long)l10, (long)l10, (int)n10, (float)0.0f, (float)0.0f, (int)0);
            super.onTouchEvent(motionEvent);
        }
        super.setEnabled(bl2);
    }

    public void setNormalMode(boolean bl2) {
        synchronized (this) {
            this.r = bl2;
            this.invalidate();
            return;
        }
    }

    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.u = onSeekBarChangeListener;
    }

    public void setPercentProgressRange(Range range) {
        this.q = range;
        this.invalidate();
    }

    public void setPointPercentProgress(float[] fArray) {
        this.p = fArray;
        this.invalidate();
    }

    public void setProgressText(String string2) {
        this.s = string2;
        this.invalidate();
    }
}

