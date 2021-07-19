/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.zhiyun.cama.R$styleable;
import com.zhiyun.cama.widget.AudioBarView$a;
import d.v.e.l.h2;
import d.v.e.l.o1;
import java.util.ArrayList;
import java.util.List;

public class AudioBarView
extends View {
    private int a;
    private int b;
    private int c;
    private int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private Rect i;
    private Paint j;
    private Rect k;
    private List l;
    private boolean m;
    private int n;
    private int o;
    private int p;
    private boolean q;
    private int r;
    private AudioBarView$a s;

    public AudioBarView(Context context) {
        this(context, null);
    }

    public AudioBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AudioBarView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        ArrayList arrayList;
        this.l = arrayList = new ArrayList();
        n10 = 1;
        this.m = n10;
        int[] nArray = R$styleable.AudioBarView;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        float f10 = 2.0f;
        int n11 = h2.b(f10);
        this.a = n11 = context.getDimensionPixelSize(5, n11);
        n11 = h2.b(f10);
        this.b = n11 = context.getDimensionPixelOffset(6, n11);
        int n12 = h2.b(f10);
        this.c = n12 = context.getDimensionPixelOffset(2, n12);
        f10 = 3.0f;
        n11 = h2.b(f10);
        this.d = n11 = context.getDimensionPixelSize(0, n11);
        n12 = h2.b(f10);
        this.e = n12 = context.getDimensionPixelSize(n10, n12);
        n12 = h2.b(50.0f);
        this.f = n12 = context.getDimensionPixelOffset(4, n12);
        n12 = h2.b(1.0f);
        this.g = n12 = context.getDimensionPixelSize(7, n12);
        n12 = o1.c(this.getResources(), 2131099772);
        this.h = n12 = context.getColor(3, n12);
        context.recycle();
        this.b();
        this.c();
    }

    private void b() {
        Rect rect;
        this.k = rect = new Rect();
        this.i = rect = new Rect();
    }

    private void c() {
        Paint paint;
        this.j = paint = new Paint();
        paint.setAntiAlias(true);
        paint = this.j;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.j;
        int n10 = this.h;
        paint.setColor(n10);
    }

    private void f() {
        this.invalidate();
    }

    public void a(float f10) {
        List list = this.l;
        Float f11 = Float.valueOf(f10);
        list.add(f11);
        this.invalidate();
    }

    public void d(int n10) {
        this.q = true;
        this.r = n10;
    }

    public boolean e() {
        return this.m;
    }

    public int getDrawHeight() {
        int n10 = this.getHeight();
        int n11 = this.b;
        n10 -= n11;
        n11 = this.c;
        return n10 - n11;
    }

    public int getDrawWidth() {
        return this.p;
    }

    public void onDraw(Canvas canvas) {
        int n10;
        super.onDraw(canvas);
        Object object = this.l;
        if (object != null && (n10 = object.size()) != 0) {
            List list;
            int n11;
            n10 = this.getDrawWidth();
            int n12 = this.d;
            n10 -= n12;
            n12 = this.e;
            n10 -= n12;
            n12 = this.getDrawHeight();
            int n13 = 0;
            while (n13 < n10 && n13 < (n11 = (list = this.l).size())) {
                float f10 = ((Float)this.l.get(n13)).floatValue();
                int n14 = this.b;
                float f11 = n12;
                float f12 = 1.0f - f10;
                n11 = (int)(f11 *= f12);
                list = this.k;
                int n15 = this.d;
                int n16 = n15 + n13;
                n15 += n13;
                int n17 = this.g;
                n15 += n17;
                n17 = this.c + n12;
                list.set(n16, n14 += n11, n15, n17);
                list = this.k;
                Paint paint = this.j;
                canvas.drawRect((Rect)list, paint);
                n11 = this.g;
                n13 += n11;
                n11 = this.a;
                n13 = n13 + n11 + -1 + 1;
            }
            int n18 = this.q;
            if (n18 != 0) {
                this.q = false;
                n18 = this.r;
                this.scrollBy(n18, 0);
                this.o = n18 = -this.r;
                object = this.s;
                if (object != null) {
                    object.c(n18);
                }
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public void onLayout(boolean bl2, int n10, int n11, int n12, int n13) {
        void var5_6;
        void var4_5;
        void var3_4;
        int n14;
        super.onLayout(bl2, n14, (int)var3_4, (int)var4_5, (int)var5_6);
        Rect rect = this.i;
        this.getGlobalVisibleRect(rect);
        rect = this.i;
        n14 = rect.right;
        int n15 = rect.left;
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        View.MeasureSpec.getMode((int)n10);
        n10 = View.MeasureSpec.getSize((int)n10);
        View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        this.setMeasuredDimension(n10, n11);
    }

    public boolean onTouchEvent(MotionEvent object) {
        int n10 = this.m;
        int n11 = 1;
        if (n10 == 0) {
            return n11 != 0;
        }
        n10 = object.getAction();
        if (n10 != 0) {
            if (n10 != n11) {
                int n12 = 2;
                if (n10 == n12) {
                    float f10 = object.getX();
                    int n13 = (int)f10;
                    n10 = this.n;
                    n10 = n13 - n10;
                    this.o = n12 = this.o + n10;
                    int n14 = this.getWidth();
                    int n15 = this.getDrawWidth();
                    if (n12 < (n14 -= n15)) {
                        n12 = this.getWidth();
                        n14 = this.getDrawWidth();
                        n12 -= n14;
                        n14 = this.o;
                        n12 -= n14;
                        n14 = this.getWidth();
                        n15 = this.getDrawWidth();
                        this.o = n14 -= n15;
                        n10 += n12;
                    }
                    n12 = this.o;
                    n14 = 0;
                    if (n12 > 0) {
                        n10 -= n12;
                        this.o = 0;
                    }
                    n10 = -n10;
                    this.scrollBy(n10, 0);
                    this.n = n13;
                    object = this.s;
                    if (object != null) {
                        n10 = this.o;
                        object.c(n10);
                    }
                }
            } else {
                this.performClick();
                object = this.s;
                if (object != null) {
                    object.a();
                }
            }
        } else {
            int n16;
            float f11 = object.getX();
            this.n = n16 = (int)f11;
            object = this.s;
            if (object != null) {
                object.b();
            }
        }
        return n11 != 0;
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setDataList(List list) {
        this.l = list;
        this.invalidate();
    }

    public void setDrawableWidth(int n10) {
        int n11 = this.d;
        n10 += n11;
        n11 = this.e;
        this.p = n10 += n11;
    }

    public void setEnableScroll(boolean bl2) {
        this.m = bl2;
    }

    public void setOnScrollListener(AudioBarView$a audioBarView$a) {
        this.s = audioBarView$a;
    }
}

