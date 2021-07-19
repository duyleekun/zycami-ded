/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
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

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.geetest.sdk.utils.g;
import com.geetest.sdk.views.GT3View$a;
import com.geetest.sdk.views.GT3View$b;

public class GT3View
extends View {
    private int a;
    private Paint b;
    private Paint c;
    private Path d;
    private int e;
    private Context f;
    private boolean g = false;
    private int h;
    private ValueAnimator i;
    private GT3View$b j;

    public GT3View(Context context) {
        super(context);
        this.a(context);
    }

    public GT3View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.a(context);
    }

    public GT3View(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.a(context);
    }

    public static /* synthetic */ int a(GT3View gT3View, int n10) {
        gT3View.a = n10;
        return n10;
    }

    private void a(Context context) {
        Path path;
        this.f = context;
        this.d = path = new Path();
        int n10 = 1536;
        path = new Paint(n10);
        this.b = path;
        boolean bl2 = true;
        path.setAntiAlias(bl2);
        path = this.b;
        int n11 = -8333653;
        path.setColor(n11);
        path = this.b;
        float f10 = com.geetest.sdk.utils.g.a(context, 2.0f);
        path.setStrokeWidth(f10);
        path = this.b;
        Paint.Style style2 = Paint.Style.STROKE;
        path.setStyle(style2);
        this.a = bl2;
        path = new Paint(n10);
        this.c = path;
        path.setAntiAlias(bl2);
        this.c.setColor(n11);
        path = this.c;
        float f11 = com.geetest.sdk.utils.g.a(context, 3.0f);
        path.setStrokeWidth(f11);
        context = this.c;
        path = Paint.Style.STROKE;
        context.setStyle((Paint.Style)path);
    }

    public void a() {
        Object object = new int[]{0, 255};
        object = ValueAnimator.ofInt((int[])object);
        this.i = (ValueAnimator)object;
        object.setDuration(700L);
        object = this.i;
        GT3View$a gT3View$a = new GT3View$a(this);
        object.addUpdateListener((ValueAnimator.AnimatorUpdateListener)gT3View$a);
        this.i.start();
        this.h = 0;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onDraw(Canvas object) {
        boolean bl2;
        int n10;
        Context context = this.f;
        this.e = n10 = com.geetest.sdk.utils.g.a(context, 12.0f);
        this.postInvalidate();
        super.onDraw((Canvas)object);
        n10 = this.h;
        int n11 = 100;
        float f10 = 1.4E-43f;
        if (n10 <= n11) {
            int n12;
            context = this.c;
            n11 = this.a;
            context.setAlpha(n11);
            context = this.d;
            n11 = this.getWidth() / 2;
            int n13 = this.e * 13 / 22;
            f10 = n11 - n13;
            n13 = this.getHeight() / 2;
            int n14 = this.e * 2 / 22;
            float f11 = n13 - n14;
            context.moveTo(f10, f11);
            context = this.d;
            n11 = this.getWidth() / 2;
            n13 = this.e * 2 / 22;
            f10 = n11 - n13;
            n13 = this.getHeight() / 2;
            n14 = this.e * 10 / 22;
            f11 = n13 + n14;
            context.lineTo(f10, f11);
            context = this.d;
            n11 = this.getWidth() / 2;
            n13 = this.e * 22 / 22;
            f10 = n11 + n13;
            n13 = this.getHeight() / 2;
            n14 = this.e * 16 / 22;
            f11 = n13 -= n14;
            context.lineTo(f10, f11);
            context = this.d;
            Paint paint = this.c;
            object.drawPath((Path)context, paint);
            float f12 = this.getWidth() / 2;
            f10 = this.getHeight() / 2;
            object.translate(f12, f10);
            n10 = this.e;
            n11 = -n10;
            f10 = n11;
            f12 = n10;
            RectF rectF = new RectF(f10, f10, f12, f12);
            n10 = -this.h;
            float f13 = n10;
            Paint paint2 = this.b;
            float f14 = 300.0f;
            object.drawArc(rectF, f14, f13, false, paint2);
            this.h = n12 = this.h + 20;
            return;
        }
        int n15 = 200;
        float f15 = 2.8E-43f;
        if (n10 > n11 && n10 <= n15) {
            int n16;
            context = this.c;
            n11 = this.a;
            context.setAlpha(n11);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 13 / 22;
            f10 = n11 - n15;
            n15 = this.getHeight() / 2;
            int n17 = this.e * 2 / 22;
            f15 = n15 - n17;
            context.moveTo(f10, f15);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 2 / 22;
            f10 = n11 - n15;
            n15 = this.getHeight() / 2;
            n17 = this.e * 10 / 22;
            f15 = n15 + n17;
            context.lineTo(f10, f15);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 22 / 22;
            f10 = n11 + n15;
            n15 = this.getHeight() / 2;
            n17 = this.e * 16 / 22;
            f15 = n15 -= n17;
            context.lineTo(f10, f15);
            context = this.d;
            Paint paint = this.c;
            object.drawPath((Path)context, paint);
            float f16 = this.getWidth() / 2;
            f10 = this.getHeight() / 2;
            object.translate(f16, f10);
            n10 = this.e;
            n11 = -n10;
            f10 = n11;
            f16 = n10;
            RectF rectF = new RectF(f10, f10, f16, f16);
            n10 = -this.h;
            float f17 = n10;
            Paint paint3 = this.b;
            float f18 = 300.0f;
            object.drawArc(rectF, f18, f17, false, paint3);
            this.h = n16 = this.h + 10;
            return;
        }
        n11 = 300;
        f10 = 4.2E-43f;
        if (n10 > n15 && n10 <= n11) {
            int n18;
            context = this.c;
            n11 = this.a;
            context.setAlpha(n11);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 13 / 22;
            f10 = n11 - n15;
            n15 = this.getHeight() / 2;
            int n19 = this.e * 2 / 22;
            f15 = n15 - n19;
            context.moveTo(f10, f15);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 2 / 22;
            f10 = n11 - n15;
            n15 = this.getHeight() / 2;
            n19 = this.e * 10 / 22;
            f15 = n15 + n19;
            context.lineTo(f10, f15);
            context = this.d;
            n11 = this.getWidth() / 2;
            n15 = this.e * 22 / 22;
            f10 = n11 + n15;
            n15 = this.getHeight() / 2;
            n19 = this.e * 16 / 22;
            f15 = n15 -= n19;
            context.lineTo(f10, f15);
            context = this.d;
            Paint paint = this.c;
            object.drawPath((Path)context, paint);
            float f19 = this.getWidth() / 2;
            f10 = this.getHeight() / 2;
            object.translate(f19, f10);
            n10 = this.e;
            n11 = -n10;
            f10 = n11;
            f19 = n10;
            RectF rectF = new RectF(f10, f10, f19, f19);
            n10 = -this.h;
            float f20 = n10;
            Paint paint4 = this.b;
            float f21 = 300.0f;
            object.drawArc(rectF, f21, f20, false, paint4);
            this.h = n18 = this.h + 20;
            return;
        }
        if (n10 > n11) {
            n11 = 800;
            f10 = 1.121E-42f;
            if (n10 < n11) {
                int n20;
                context = this.c;
                n11 = this.a;
                context.setAlpha(n11);
                context = this.d;
                n11 = this.getWidth() / 2;
                n15 = this.e * 13 / 22;
                f10 = n11 - n15;
                n15 = this.getHeight() / 2;
                int n21 = this.e * 2 / 22;
                f15 = n15 - n21;
                context.moveTo(f10, f15);
                context = this.d;
                n11 = this.getWidth() / 2;
                n15 = this.e * 2 / 22;
                f10 = n11 - n15;
                n15 = this.getHeight() / 2;
                n21 = this.e * 10 / 22;
                f15 = n15 + n21;
                context.lineTo(f10, f15);
                context = this.d;
                n11 = this.getWidth() / 2;
                n15 = this.e * 22 / 22;
                f10 = n11 + n15;
                n15 = this.getHeight() / 2;
                n21 = this.e * 16 / 22;
                f15 = n15 -= n21;
                context.lineTo(f10, f15);
                context = this.d;
                Paint paint = this.c;
                object.drawPath((Path)context, paint);
                float f22 = this.getWidth() / 2;
                f10 = this.getHeight() / 2;
                object.translate(f22, f10);
                n10 = this.e;
                n11 = -n10;
                f10 = n11;
                f22 = n10;
                RectF rectF = new RectF(f10, f10, f22, f22);
                Paint paint5 = this.b;
                float f23 = 300.0f;
                float f24 = -300.0f;
                object.drawArc(rectF, f23, f24, false, paint5);
                this.h = n20 = this.h + 10;
                return;
            }
        }
        context = this.d;
        n11 = this.getWidth() / 2;
        n15 = this.e * 13 / 22;
        f10 = n11 - n15;
        n15 = this.getHeight() / 2;
        int n22 = this.e * 2 / 22;
        f15 = n15 - n22;
        context.moveTo(f10, f15);
        context = this.d;
        n11 = this.getWidth() / 2;
        n15 = this.e * 2 / 22;
        f10 = n11 - n15;
        n15 = this.getHeight() / 2;
        n22 = this.e * 10 / 22;
        f15 = n15 + n22;
        context.lineTo(f10, f15);
        context = this.d;
        n11 = this.getWidth() / 2;
        n15 = this.e * 22 / 22;
        f10 = n11 + n15;
        n15 = this.getHeight() / 2;
        n22 = this.e * 16 / 22;
        f15 = n15 -= n22;
        context.lineTo(f10, f15);
        context = this.d;
        Paint paint = this.c;
        object.drawPath((Path)context, paint);
        float f25 = this.getWidth() / 2;
        f10 = this.getHeight() / 2;
        object.translate(f25, f10);
        n10 = this.e;
        n11 = -n10;
        f10 = n11;
        f25 = n10;
        RectF rectF = new RectF(f10, f10, f25, f25);
        Paint paint6 = this.b;
        float f26 = 300.0f;
        float f27 = -300.0f;
        object.drawArc(rectF, f26, f27, false, paint6);
        object = this.j;
        if (object == null) return;
        n10 = (int)(this.g ? 1 : 0);
        if (n10 != 0) return;
        object.a();
        this.g = bl2 = true;
    }

    public void setGtListener(GT3View$b gT3View$b) {
        this.j = gT3View$b;
    }
}

