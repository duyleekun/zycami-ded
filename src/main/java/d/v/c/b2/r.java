/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.Canvas
 *  android.graphics.RectF
 *  android.graphics.drawable.Drawable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewParent
 *  android.widget.HorizontalScrollView
 */
package d.v.c.b2;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import com.zhiyun.common.util.Windows;
import d.v.c.b2.w.i;
import d.v.c.b2.x.a;
import d.v.e.l.o1;

public abstract class r
extends View
implements a {
    public static final int[] e = new int[2];
    private i a;
    public float b;
    public RectF c;
    public RectF d;

    public r(Context context) {
        super(context);
        this.i();
    }

    public r(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i();
    }

    public r(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.i();
    }

    private void i() {
        float f10;
        Object object = Windows.l(this.getContext());
        this.b = f10 = (float)object.getWidth();
        int n10 = object.getWidth() / 2;
        int n11 = this.getPaddingTop();
        int n12 = this.getPaddingBottom();
        this.setPadding(n10, n11, n10, n12);
        object = new i(10000000L);
        this.setTimeAxisData((i)object);
    }

    private int j(int n10, int n11) {
        int n12 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        int n13 = -1 << -1;
        if (n12 != n13) {
            if (n12 != 0) {
                n13 = 0x40000000;
                if (n12 == n13) {
                    n10 = n11;
                }
            } else {
                n10 = Math.max(n10, n11);
            }
        } else {
            n10 = this.getPaddingTop();
            n11 = this.getPaddingBottom();
            n10 += n11;
        }
        return n10;
    }

    public void d(Canvas canvas) {
        this.l(canvas);
    }

    public Bitmap e(int n10) {
        return BitmapFactory.decodeResource((Resources)this.getResources(), (int)n10);
    }

    public int f(int n10) {
        return o1.c(this.getResources(), n10);
    }

    public Drawable g(int n10) {
        return o1.o(this.getResources(), n10);
    }

    public float getLengthMinimum() {
        float f10;
        i i10 = this.getTimeAxisData();
        if (i10 == null) {
            f10 = 0.0f;
            i10 = null;
        } else {
            i10 = this.getTimeAxisData();
            f10 = i10.getLengthMinimum();
        }
        return f10;
    }

    public HorizontalScrollView getParentScrollViewGroup() {
        return this.h(3);
    }

    public i getTimeAxisData() {
        return this.a;
    }

    public long getTimeMinimum() {
        long l10;
        i i10 = this.getTimeAxisData();
        if (i10 == null) {
            l10 = 0L;
        } else {
            i10 = this.getTimeAxisData();
            l10 = i10.getTimeMinimum();
        }
        return l10;
    }

    public long getTotalTime() {
        long l10;
        i i10 = this.getTimeAxisData();
        if (i10 == null) {
            l10 = 0L;
        } else {
            i10 = this.getTimeAxisData();
            l10 = i10.getTotalTime();
        }
        return l10;
    }

    public HorizontalScrollView h(int n10) {
        ViewParent viewParent = this.getParent();
        for (int i10 = 0; i10 < n10; ++i10) {
            boolean bl2 = viewParent instanceof HorizontalScrollView;
            if (bl2) {
                return (HorizontalScrollView)viewParent;
            }
            if (viewParent == null) break;
            viewParent = viewParent.getParent();
        }
        return null;
    }

    public boolean k() {
        return true;
    }

    public abstract void l(Canvas var1);

    public void m() {
        this.o();
        RectF rectF = this.d;
        int n10 = Math.round(rectF.left);
        int n11 = Math.round(rectF.top);
        int n12 = Math.round(rectF.right);
        int n13 = Math.round(rectF.bottom);
        this.postInvalidateOnAnimation(n10, n11, n12, n13);
    }

    public void n() {
        int[] nArray = e;
        this.getLocationOnScreen(nArray);
    }

    public void o() {
        this.n();
        int[] nArray = e;
        int n10 = 0;
        float f10 = 0.0f;
        int n11 = -nArray[0];
        RectF rectF = this.d;
        if (rectF == null) {
            this.d = rectF = new RectF();
        }
        rectF = this.d;
        float f11 = n11;
        float f12 = this.b + f11;
        int n12 = this.getHeight();
        float f13 = n12;
        rectF.set(f11, 0.0f, f12, f13);
        n10 = this.getPaddingLeft();
        n11 -= n10;
        n10 = 1;
        f10 = Float.MIN_VALUE;
        RectF rectF2 = this.c;
        if (rectF2 == null) {
            this.c = rectF2 = new RectF();
        }
        rectF2 = this.c;
        float f14 = n11;
        f12 = this.b;
        f10 = (float)n10 * f12;
        f10 = f14 - f10;
        f13 = 2;
        f12 = this.getHeight();
        rectF2.set(f10, 0.0f, f14 += (f12 *= f13), f12);
    }

    public void onDraw(Canvas canvas) {
        float f10 = this.getPaddingLeft();
        float f11 = this.getPaddingTop();
        canvas.translate(f10, f11);
        canvas.save();
        this.o();
        this.d(canvas);
        canvas.restore();
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        this.getSuggestedMinimumWidth();
        n10 = this.getSuggestedMinimumHeight();
        int n12 = this.c();
        int n13 = this.getPaddingLeft();
        n12 += n13;
        n13 = this.getPaddingRight();
        n10 = this.j(n10, n11);
        this.setMeasuredDimension(n12 += n13, n10);
    }

    public void postInvalidateOnAnimation() {
        this.m();
    }

    public void setTimeAxisData(i i10) {
        if (i10 != null) {
            this.a = i10;
            this.requestLayout();
        }
    }
}

