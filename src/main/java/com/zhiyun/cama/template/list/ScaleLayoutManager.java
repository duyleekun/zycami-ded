/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.zhiyun.cama.template.list;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;

public class ScaleLayoutManager
extends LinearLayoutManager {
    private float a = 0.0f;
    private float b;
    private float c;
    private float d;

    public ScaleLayoutManager(Context context) {
        super(context);
        float f10;
        this.b = f10 = 1.0f;
        this.c = 0.0f;
        this.d = f10;
    }

    public ScaleLayoutManager(Context context, int n10, boolean bl2) {
        super(context, n10, bl2);
        float f10;
        this.b = f10 = 1.0f;
        this.c = 0.0f;
        this.d = f10;
    }

    public ScaleLayoutManager(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        float f10;
        this.b = f10 = 1.0f;
        this.c = 0.0f;
        this.d = f10;
    }

    private void b(int n10) {
        float f10;
        float f11;
        float f12;
        float f13;
        int n11;
        int n12;
        int n13;
        int n14 = 0;
        int n15 = 1;
        float f14 = Float.MIN_VALUE;
        if (n10 == n15) {
            f14 = 0.0f;
            for (n15 = 0; n15 < (n13 = this.getChildCount()); ++n15) {
                float f15;
                float f16;
                View view = this.getChildAt(n15);
                if (view == null) continue;
                n12 = view.getTop();
                n11 = view.getHeight();
                double d10 = Math.abs(n12);
                double d11 = 1.0;
                d10 *= d11;
                double d12 = n11;
                double d13 = (d10 /= d12) - d11;
                n12 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
                if (n12 <= 0) {
                    d11 = d10;
                }
                d12 = 0.0;
                double d14 = d11 == d12 ? 0 : (d11 < d12 ? -1 : 1);
                if (d14 < 0) {
                    d11 = d12;
                }
                f13 = this.b;
                double d15 = f13;
                f12 = this.a;
                float f17 = f13 - f12;
                double d16 = (double)f17 * d11;
                f11 = (float)(d15 -= d16);
                f10 = this.d;
                d16 = f10;
                float f18 = this.c;
                double d17 = (double)(f10 - f18) * d11;
                f10 = (float)(d16 -= d17);
                Object object = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
                if (object >= 0 && (n12 = (int)(f11 == f13 ? 0 : (f11 < f13 ? -1 : 1))) <= 0) {
                    view.setPivotX(0.0f);
                    n12 = view.getHeight() / 2;
                    f13 = n12;
                    view.setPivotY(f13);
                    view.setScaleY(f11);
                    view.setScaleX(f11);
                }
                if ((n12 = (int)((f16 = f10 - (f13 = this.c)) == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1))) < 0 || (n12 = (int)((f15 = f10 - (f13 = this.d)) == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1))) > 0) continue;
                view.setAlpha(f10);
            }
        }
        if (n10 == 0) {
            while (n14 < (n10 = this.getChildCount())) {
                View view = this.getChildAt(n14);
                n15 = view.getLeft();
                n13 = view.getWidth();
                n15 = Math.abs(n15);
                f14 = n15;
                f13 = 1.0f;
                f14 *= f13;
                float f19 = n13;
                f14 /= f19;
                f14 = Math.max(0.0f, f14);
                f14 = Math.min(f13, f14);
                f19 = this.b;
                f13 = this.a;
                f11 = (f19 - f13) * f14;
                f11 = f19 - f11;
                f10 = this.d;
                f12 = this.c;
                f12 = (f10 - f12) * f14;
                f14 = Math.max(f13, f11);
                f14 = Math.min(f19, f14);
                f19 = this.d;
                f13 = Math.max(this.c, f10 -= f12);
                f19 = Math.min(f19, f13);
                view.setPivotX(0.0f);
                n12 = view.getHeight();
                f13 = n12;
                n11 = 0x40000000;
                f11 = 2.0f;
                view.setPivotY(f13 /= f11);
                view.setScaleY(f14);
                view.setScaleX(f14);
                view.setAlpha(f19);
                ++n14;
            }
        }
    }

    public void a() {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            View view = this.getChildAt(i10);
            if (view == null) continue;
            view.setPivotX(0.0f);
            int n11 = view.getHeight() / 2;
            float f10 = n11;
            view.setPivotY(f10);
            f10 = this.b;
            view.setScaleY(f10);
            f10 = this.b;
            view.setScaleX(f10);
            f10 = this.d;
            view.setAlpha(f10);
        }
    }

    public void c() {
        int n10 = this.getOrientation();
        this.b(n10);
    }

    public ScaleLayoutManager d(float f10) {
        float f11 = this.c;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = f11;
        }
        this.d = f10;
        return this;
    }

    public ScaleLayoutManager e(float f10) {
        float f11 = this.a;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = f11;
        }
        this.b = f10;
        return this;
    }

    public ScaleLayoutManager f(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = 0.0f;
        }
        this.c = f10;
        return this;
    }

    public ScaleLayoutManager g(float f10) {
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        if (object < 0) {
            f10 = 0.0f;
        }
        this.a = f10;
        return this;
    }

    public int scrollHorizontallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n11 = this.getOrientation();
        this.b(n11);
        n10 = n11 == 0 ? super.scrollHorizontallyBy(n10, recyclerView$Recycler, recyclerView$State) : 0;
        return n10;
    }

    public int scrollVerticallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n11 = this.getOrientation();
        this.b(n11);
        int n12 = 1;
        n10 = n11 == n12 ? super.scrollHorizontallyBy(n10, recyclerView$Recycler, recyclerView$State) : 0;
        return n10;
    }
}

