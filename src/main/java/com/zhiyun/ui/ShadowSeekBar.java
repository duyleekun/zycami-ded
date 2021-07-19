/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Color
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Typeface
 *  android.text.TextUtils
 *  android.util.AttributeSet
 *  android.widget.SeekBar
 */
package com.zhiyun.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.SeekBar;
import com.zhiyun.ui.R$styleable;
import d.v.e.l.h2;

public class ShadowSeekBar
extends SeekBar {
    private Paint a;
    private Paint b;
    private String c;
    private boolean d = true;
    private int e = 6;
    private int f;
    private int g;
    private int h;
    private boolean i;
    private int j;
    private int k;

    public ShadowSeekBar(Context context) {
        super(context);
        int n10;
        this.f = n10 = Color.parseColor((String)"#88000000");
        this.g = 2;
        this.h = 8;
        this.i = false;
        this.j = n10 = Color.parseColor((String)"#FFFFFFFF");
        this.k = 14;
        this.b(context, null);
        this.c();
    }

    public ShadowSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int n10;
        this.f = n10 = Color.parseColor((String)"#88000000");
        this.g = 2;
        this.h = 8;
        this.i = false;
        this.j = n10 = Color.parseColor((String)"#FFFFFFFF");
        this.k = 14;
        this.b(context, attributeSet);
        this.c();
    }

    public ShadowSeekBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.f = n10 = Color.parseColor((String)"#88000000");
        this.g = 2;
        this.h = 8;
        this.i = false;
        this.j = n10 = Color.parseColor((String)"#FFFFFFFF");
        this.k = 14;
        this.b(context, attributeSet);
        this.c();
    }

    private void b(Context context, AttributeSet attributeSet) {
        int[] nArray = R$styleable.ShadowSeekBar;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.ShadowSeekBar_progressHintColor;
        int n11 = this.j;
        this.j = n10 = context.getInteger(n10, n11);
        n10 = R$styleable.ShadowSeekBar_progressHintSize;
        n11 = this.k;
        this.k = n10 = context.getInteger(n10, n11);
        n10 = R$styleable.ShadowSeekBar_progressHintVisible;
        n11 = (int)(this.i ? 1 : 0);
        n10 = (int)(context.getBoolean(n10, n11 != 0) ? 1 : 0);
        this.i = n10;
        n10 = R$styleable.ShadowSeekBar_shadowVisible;
        n11 = this.d;
        n10 = (int)(context.getBoolean(n10, n11 != 0) ? 1 : 0);
        this.d = n10;
        n10 = R$styleable.ShadowSeekBar_shadowRadius;
        n11 = this.e;
        this.e = n10 = context.getInteger(n10, n11);
        n10 = R$styleable.ShadowSeekBar_shadowColor;
        n11 = this.f;
        this.f = n10 = context.getColor(n10, n11);
        n10 = R$styleable.ShadowSeekBar_progressHeight;
        n11 = this.g;
        this.g = n10 = context.getInteger(n10, n11);
        n10 = R$styleable.ShadowSeekBar_thumbRadius;
        n11 = this.h;
        this.h = n10 = context.getInteger(n10, n11);
        context.recycle();
        int n12 = this.d;
        if (n12 != 0) {
            n12 = this.getPaddingLeft();
            n10 = this.getPaddingTop();
            float f10 = this.e;
            n11 = h2.b(f10);
            n10 += n11;
            n11 = this.getPaddingRight();
            int n13 = this.getPaddingBottom();
            float f11 = this.e;
            int n14 = h2.b(f11);
            this.setPadding(n12, n10, n11, n13 += n14);
        }
    }

    private void c() {
        Paint paint;
        this.a = paint = new Paint();
        int n10 = this.j;
        paint.setColor(n10);
        paint = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.a;
        float f10 = this.k;
        float f11 = this.getContext().getResources().getDisplayMetrics().scaledDensity;
        paint.setTextSize(f10 *= f11);
        paint = this.a;
        style2 = Typeface.SANS_SERIF;
        paint.setTypeface((Typeface)style2);
        paint = this.a;
        n10 = this.f;
        float f12 = 1.0f;
        paint.setShadowLayer(4.0f, f12, f12, n10);
        this.b = paint = new Paint();
        paint.setColor(0);
        paint = this.b;
        f10 = h2.b(this.e);
        int n11 = this.f;
        paint.setShadowLayer(f10, 0.0f, 0.0f, n11);
    }

    private String getProgressHint() {
        String string2 = this.getProgressText();
        if (string2 == null) {
            int n10 = this.getProgress();
            string2 = String.valueOf(n10);
        } else {
            string2 = this.getProgressText();
        }
        return string2;
    }

    public void a(Canvas canvas) {
        Object object = this.a;
        if (object != null) {
            String string2;
            int n10;
            int n11;
            float f10;
            float f11;
            canvas.save();
            int n12 = this.d;
            int n13 = 1065353216;
            float f12 = 1.0f;
            int n14 = 0x40000000;
            float f13 = 2.0f;
            if (n12 != 0) {
                f11 = this.getPaddingLeft();
                float f14 = (float)this.getHeight() / f13;
                f10 = (float)h2.b(this.g) / f13;
                float f15 = f14 - f10;
                n12 = this.getWidth();
                n11 = this.getPaddingRight();
                float f16 = n12 - n11;
                f14 = (float)this.getHeight() / f13;
                f10 = (float)h2.b(this.g) / f13;
                float f17 = f14 + f10;
                Paint paint = this.b;
                canvas.drawRect(f11, f15, f16, f17, paint);
                n12 = this.getPaddingLeft();
                f14 = n12;
                n11 = this.getWidth();
                n10 = this.getPaddingRight();
                n11 -= n10;
                n10 = this.getPaddingLeft();
                n11 -= n10;
                n10 = this.getProgress();
                f10 = n11 * n10;
                f11 = (float)this.getMax() * f12;
                f14 += (f10 /= f11);
                n11 = this.getHeight();
                f10 = (float)n11 / f13;
                n10 = h2.b(this.h);
                f11 = n10;
                string2 = this.b;
                canvas.drawCircle(f14, f10, f11, (Paint)string2);
            }
            if ((n12 = this.i) != 0 && (n12 = TextUtils.isEmpty((CharSequence)(object = this.getProgressHint()))) == 0) {
                object = this.getProgressHint();
                n11 = this.getPaddingLeft();
                f10 = n11;
                Paint paint = this.a;
                string2 = this.getProgressHint();
                f11 = paint.measureText(string2) / f13;
                f10 -= f11;
                n14 = this.getWidth();
                n10 = this.getPaddingLeft();
                n14 -= n10;
                n10 = this.getPaddingRight();
                n14 -= n10;
                n10 = this.getProgress();
                f13 = n14 *= n10;
                n10 = this.getMax();
                f11 = (float)n10 * f12;
                n13 = this.getHeight();
                f12 = n13;
                f13 = this.a.getFontMetrics().bottom;
                Paint paint2 = this.a;
                canvas.drawText((String)object, f10 += (f13 /= f11), f12 -= f13, paint2);
            }
            canvas.restore();
        }
    }

    public String getProgressText() {
        return this.c;
    }

    public void onDraw(Canvas canvas) {
        synchronized (this) {
            this.a(canvas);
            super.onDraw(canvas);
            return;
        }
    }

    public void setProgressText(String string2) {
        this.c = string2;
    }
}

