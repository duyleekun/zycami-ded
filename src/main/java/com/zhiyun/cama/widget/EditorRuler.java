/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.core.content.res.ResourcesCompat;
import d.v.c.b2.r;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.e.l.l2;

public class EditorRuler
extends r {
    private static final int j = h2.b(10.0f);
    public float f;
    private Paint g;
    private int h;
    private float i;

    public EditorRuler(Context context) {
        super(context);
        float f10;
        this.f = f10 = (float)h2.b(1.0f);
        this.h = 2131099775;
        this.i();
    }

    public EditorRuler(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        this.f = f10 = (float)h2.b(1.0f);
        this.h = 2131099775;
        this.i();
    }

    public EditorRuler(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        float f10;
        this.f = f10 = (float)h2.b(1.0f);
        this.h = 2131099775;
        this.i();
    }

    private void i() {
        this.s();
        this.r();
    }

    private void p(Canvas canvas) {
        float f10 = this.c();
        float f11 = this.getLengthMinimum();
        double d10 = Math.floor(f10 /= f11);
        int n10 = (int)d10;
        RectF rectF = this.c;
        f11 = rectF.left;
        float f12 = this.getLengthMinimum();
        double d11 = Math.floor(f11 /= f12);
        int n11 = (int)d11;
        RectF rectF2 = this.c;
        f12 = rectF2.right;
        float f13 = this.getLengthMinimum();
        double d12 = Math.floor(f12 / f13);
        int n12 = (int)d12;
        n10 = Math.min(n10, n12);
        n12 = this.getHeight();
        f12 = n12;
        f13 = this.i;
        f12 += f13;
        f13 = 2.0f;
        f12 /= f13;
        for (n11 = Math.max(0, n11); n11 <= n10; ++n11) {
            float f14;
            float f15;
            int n13 = n11 % 2;
            if (n13 == 0) {
                long l10 = n11;
                long l11 = this.getTimeMinimum();
                String string2 = this.q(l10 *= l11);
                f15 = d2.d(this.g, string2);
                f14 = n11;
                float f16 = this.getLengthMinimum();
                f14 *= f16;
                Paint paint = this.g;
                canvas.drawText(string2, f14 -= (f15 /= f13), f12, paint);
                continue;
            }
            float f17 = n11;
            f15 = this.getLengthMinimum();
            f17 *= f15;
            int n14 = this.getHeight();
            f15 = (float)n14 / f13;
            f14 = this.f;
            Paint paint = this.g;
            canvas.drawCircle(f17, f15, f14, paint);
        }
    }

    private String q(long l10) {
        StringBuilder stringBuilder = new StringBuilder();
        float f10 = l2.a(l10, 2);
        stringBuilder.append(f10);
        stringBuilder.append("\"");
        return stringBuilder.toString();
    }

    private void r() {
    }

    private void s() {
        float f10;
        Paint paint;
        Typeface typeface = ResourcesCompat.getFont(this.getContext(), 2131296257);
        this.g = paint = new Paint();
        int n10 = this.h;
        n10 = this.f(n10);
        paint.setColor(n10);
        paint = this.g;
        float f11 = j;
        paint.setTextSize(f11);
        this.g.setTypeface(typeface);
        this.g.setAntiAlias(true);
        this.i = f10 = d2.b(this.g);
    }

    public void l(Canvas canvas) {
        this.p(canvas);
    }
}

