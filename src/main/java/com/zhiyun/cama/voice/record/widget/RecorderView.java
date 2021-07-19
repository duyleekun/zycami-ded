/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.voice.record.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import com.zhiyun.common.util.Windows;
import d.v.c.y1.g.o.a;
import d.v.c.y1.g.o.b;
import d.v.c.y1.g.o.c;
import java.util.List;

public class RecorderView
extends ViewGroup {
    private List a;
    private Context b;
    private int c;

    public RecorderView(Context context) {
        this(context, null);
    }

    public RecorderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecorderView(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        int n11;
        this.b = context;
        this.c = n11 = Windows.l(context).getWidth() >> 1;
    }

    public static /* synthetic */ void c(d.v.c.b2.w.l.c c10, c c11, d.v.c.y1.g.m.b b10, String string2, List list) {
        List list2 = c10.m();
        long l10 = b10.d();
        long l11 = b10.a();
        c11.n(list2, l10, l11);
    }

    public static /* synthetic */ void d(d.v.c.b2.w.l.c c10, c c11, d.v.c.y1.g.m.b b10, String string2, List list) {
        List list2 = c10.m();
        long l10 = b10.d();
        long l11 = b10.a();
        c11.n(list2, l10, l11);
    }

    public void a(d.v.c.y1.g.m.b b10) {
        Object object = this.b;
        c c10 = new c((Context)object);
        object = b10.e();
        if (object != null) {
            b b11 = new b((d.v.c.b2.w.l.c)object, c10, b10);
            ((d.v.c.b2.w.l.c)object).n(b11);
            ((d.v.c.b2.w.l.c)object).m();
        }
        this.addView(c10);
        long l10 = b10.a();
        long l11 = b10.d();
        int n10 = this.c;
        double d10 = b10.c();
        double d11 = 4.0E-4;
        int n11 = (int)(d10 * d11);
        n10 += n11;
        n11 = (int)((double)(l10 -= l11) * d11) + n10;
        int n12 = this.getHeight();
        c10.layout(n10, 0, n11, n12);
    }

    public c b(long l10, long l11) {
        Context context = this.getContext();
        c c10 = new c(context);
        this.addView(c10);
        int n10 = this.c;
        double d10 = l10;
        double d11 = 4.0E-4;
        int n11 = (int)(d10 * d11);
        n10 += n11;
        n11 = (int)((double)l11 * d11) + n10;
        int n12 = this.getHeight();
        c10.layout(n10, 0, n11, n12);
        return c10;
    }

    public RecorderView e(List list) {
        this.a = list;
        this.requestLayout();
        this.invalidate();
        return this;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        List list = this.a;
        if (list == null) {
            return;
        }
        n10 = list.size();
        for (n11 = 0; n11 < n10; ++n11) {
            Object object = this.b;
            c c10 = new c((Context)object);
            object = (d.v.c.y1.g.m.b)this.a.get(n11);
            d.v.c.b2.w.l.c c11 = ((d.v.c.y1.g.m.b)object).e();
            a a10 = new a(c11, c10, (d.v.c.y1.g.m.b)object);
            c11.n(a10);
            c11.m();
            this.addView(c10);
            long l10 = ((d.v.c.y1.g.m.b)object).a();
            long l11 = ((d.v.c.y1.g.m.b)object).d();
            int n15 = this.c;
            long l12 = ((d.v.c.y1.g.m.b)object).c();
            double d10 = l12;
            double d11 = 4.0E-4;
            int n16 = (int)(d10 *= d11);
            n15 += n16;
            double d12 = (double)(l10 -= l11) * d11;
            n16 = (int)d12 + n15;
            c10.layout(n15, n12, n16, n14);
        }
    }
}

