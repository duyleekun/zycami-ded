/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.util.AttributeSet
 *  android.view.View
 */
package d.v.c.y1.g.o;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import d.v.e.l.h2;
import d.v.e.l.o1;
import java.util.List;

public class c
extends View {
    private static short q = Short.MAX_VALUE;
    private Paint a;
    private Paint b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;
    private int l = 6;
    private int m = 40;
    private long n;
    private RectF o;
    private List p;

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context object, AttributeSet attributeSet, int n10) {
        super(object, attributeSet, n10);
        super();
        this.o = object;
        super();
        this.p = object;
        this.h(attributeSet, n10);
        this.i();
    }

    private void e(Canvas canvas) {
        int n10 = this.p.size();
        float f10 = n10;
        float f11 = this.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        float f12 = rectF.right;
        float f13 = rectF.top;
        int n11 = this.d;
        int n12 = this.e;
        Shader.TileMode tileMode = Shader.TileMode.MIRROR;
        LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f12, f13, n11, n12, tileMode);
        this.b.setShader((Shader)linearGradient);
        n10 = this.l;
        f11 = n10;
        f10 = n10;
        Paint paint = this.b;
        canvas.drawRoundRect(rectF, f11, f10, paint);
    }

    private void f(Canvas canvas) {
        int n10 = this.getHeight();
        int n11 = this.h;
        n10 -= n11;
        n11 = this.i;
        n10 -= n11;
        n11 = this.j;
        while (true) {
            List list = this.p;
            int n12 = list.size();
            int n13 = this.k;
            if (n11 >= (n12 -= n13)) break;
            float f10 = ((Float)this.p.get(n11)).floatValue();
            n13 = this.h;
            float f11 = n10;
            float f12 = 1.0f - f10;
            n12 = (int)(f11 *= f12) + n13;
            RectF rectF = this.o;
            f12 = n11;
            f10 = n12;
            int n14 = this.f + n11;
            float f13 = n14;
            float f14 = n13 += n10;
            rectF.set(f12, f10, f13, f14);
            list = this.o;
            Paint paint = this.a;
            canvas.drawRect((RectF)list, paint);
            n12 = this.f;
            n11 += n12;
            n12 = this.g;
            n11 = n11 + n12 + -1 + 1;
        }
    }

    private void h(AttributeSet attributeSet, int n10) {
        Context context = this.getContext();
        int[] nArray = R$styleable.RecordWaveView;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray, n10, 0);
        n10 = o1.c(this.getResources(), 2131099781);
        this.c = n10 = attributeSet.getColor(3, n10);
        n10 = o1.c(this.getResources(), 2131099804);
        this.d = n10 = attributeSet.getColor(1, n10);
        n10 = o1.c(this.getResources(), 2131099801);
        this.e = n10 = attributeSet.getColor(0, n10);
        n10 = h2.b(1.0f);
        this.f = n10 = attributeSet.getDimensionPixelOffset(8, n10);
        float f10 = 2.0f;
        int n11 = h2.b(f10);
        this.g = n11 = attributeSet.getDimensionPixelOffset(4, n11);
        n11 = h2.b(f10);
        this.h = n11 = attributeSet.getDimensionPixelOffset(7, n11);
        n10 = h2.b(f10);
        this.i = n10 = attributeSet.getDimensionPixelOffset(2, n10);
        f10 = 3.0f;
        n11 = h2.b(f10);
        this.j = n11 = attributeSet.getDimensionPixelOffset(5, n11);
        n10 = h2.b(f10);
        this.k = n10 = attributeSet.getDimensionPixelOffset(6, n10);
        attributeSet.recycle();
    }

    private void i() {
        Paint paint;
        this.a = paint = new Paint();
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        paint = this.a;
        int n10 = this.c;
        paint.setColor(n10);
        paint = this.a;
        float f10 = this.f;
        paint.setStrokeWidth(f10);
        paint = this.a;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        this.b = paint = new Paint();
        paint.setAntiAlias(bl2);
        this.b.setStrokeWidth(1.0f);
        paint = this.b;
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
    }

    public void a(float f10) {
        List list = this.p;
        Float f11 = Float.valueOf(f10);
        list.add(f11);
        long l10 = System.currentTimeMillis();
        long l11 = this.n;
        l10 -= l11;
        l11 = this.m;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            this.postInvalidate();
            this.n = l10 = System.currentTimeMillis();
        }
    }

    public void b(short s10) {
        if (s10 < 0) {
            s10 = -s10;
        }
        float f10 = s10;
        float f11 = q;
        this.a(f10 /= f11);
    }

    public void c() {
        this.p.clear();
        this.postInvalidate();
    }

    public void d() {
        int n10 = this.getLeft();
        int n11 = this.getTop();
        int n12 = this.getLeft();
        int n13 = this.p.size();
        n12 += n13;
        n13 = this.getBottom();
        this.layout(n10, n11, n12, n13);
    }

    public void g() {
    }

    public c j(int n10) {
        this.e = n10;
        return this;
    }

    public c k(int n10) {
        this.d = n10;
        return this;
    }

    public c l(int n10) {
        this.i = n10;
        return this;
    }

    public c m(int n10) {
        this.c = n10;
        return this;
    }

    public void n(List list, long l10, long l11) {
        List list2 = this.p;
        list2.clear();
        double d10 = l10;
        double d11 = 4.0E-4;
        int n10 = (int)(d10 *= d11);
        double d12 = (double)l11 * d11;
        int n11 = (int)d12;
        int n12 = list.size();
        if (n12 < (n11 -= n10)) {
            return;
        }
        for (n10 = 0; n10 < n11; ++n10) {
            List list3 = this.p;
            Object e10 = list.get(n10);
            list3.add(e10);
        }
        this.postInvalidate();
    }

    public c o(int n10) {
        this.g = n10;
        return this;
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.e(canvas);
        this.f(canvas);
    }

    public c p(int n10) {
        this.j = n10;
        return this;
    }

    public c q(int n10) {
        this.k = n10;
        return this;
    }

    public c r(int n10) {
        this.h = n10;
        return this;
    }

    public c s(int n10) {
        this.f = n10;
        return this;
    }

    public void setWaveDataList(List list) {
        this.p.clear();
        this.p.addAll(list);
        this.postInvalidate();
    }
}

