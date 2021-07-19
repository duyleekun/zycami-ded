/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Shader
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import d.v.c.b2.q;
import d.v.c.b2.w.g;
import d.v.e.l.d2;
import d.v.e.l.o1;
import d.v.h.d.d;
import java.util.ArrayList;
import java.util.List;

public class EditorTextBar
extends q {
    public List x0;

    public EditorTextBar(Context context) {
        super(context);
    }

    public EditorTextBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public EditorTextBar(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public void L0(Canvas canvas, float f10, float f11, float f12, float f13, g g10) {
        Paint paint = this.k;
        String string2 = ((d)g10.a()).y();
        int n10 = q.r0;
        float f14 = n10;
        float f15 = f12 + f14;
        float f16 = d2.b(paint);
        float f17 = f11 - f10;
        f14 = f17 + f16;
        float f18 = 2.0f;
        float f19 = f10 + (f14 /= f18);
        String string3 = string2;
        float f20 = f15;
        Paint paint2 = paint;
        this.M(string2, f15, f19, paint, canvas, f16);
        f14 = d2.d(paint, string2);
        f15 += f14;
        f14 = n10;
        f20 = f15 + f14;
        paint2 = this.j;
        long l10 = g10.h();
        string3 = this.Q(l10);
        f16 = d2.b(paint2);
        f17 = (f17 + f16) / f18;
        f19 = f10 + f17;
        this.M(string3, f20, f19, paint2, canvas, f16);
    }

    public Shader M0(float f10, float f11, float f12, float f13, g g10) {
        int n10 = o1.c(this.getResources(), 2131099810);
        g10.q(n10);
        n10 = o1.c(this.getResources(), 2131099808);
        g10.p(n10);
        return super.I0(f10, f11, f12, f13, g10);
    }

    public void V() {
        super.V();
        Paint paint = this.j;
        int n10 = this.f(2131099781);
        paint.setColor(n10);
        paint = this.k;
        n10 = this.f(2131099784);
        paint.setColor(n10);
    }

    public List getUiData() {
        return this.x0;
    }

    public void setUiData(List list) {
        this.x0 = list;
        ArrayList<List> arrayList = this.getData();
        if (arrayList == null) {
            arrayList = new ArrayList<List>();
        } else {
            arrayList.clear();
        }
        if (list != null) {
            list = this.x0;
            arrayList.add(list);
        }
        this.setData(arrayList);
        this.invalidate();
    }
}

