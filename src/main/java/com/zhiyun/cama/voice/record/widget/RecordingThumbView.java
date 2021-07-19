/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.voice.record.widget;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.voice.record.widget.RecordingThumbView$b;
import d.v.c.k1.a.s;
import d.v.c.m0;
import d.v.c.y1.g.m.a;
import d.v.e.l.h2;
import d.v.h.e.d;
import java.util.List;

public class RecordingThumbView
extends RecyclerView {
    private List a;

    public RecordingThumbView(Context context) {
        this(context, null);
    }

    public RecordingThumbView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RecordingThumbView(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super();
        this.a = object;
        this.b();
    }

    public static /* synthetic */ List a(RecordingThumbView recordingThumbView) {
        return recordingThumbView.a;
    }

    private void b() {
        this.c();
    }

    private void c() {
        int n10 = h2.b(0.0f);
        int n11 = h2.b(0.0f);
        int n12 = h2.b(0.0f);
        Object object = new s(n10, n11, n12);
        this.addItemDecoration((RecyclerView$ItemDecoration)object);
        Context context = this.getContext();
        object = new LinearLayoutManager(context, 0, false);
        this.setLayoutManager((RecyclerView$LayoutManager)object);
    }

    public void setData(List object) {
        boolean bl2;
        RecordingThumbView recordingThumbView = this;
        this.a.clear();
        Object object2 = object.iterator();
        while (bl2 = object2.hasNext()) {
            long l10;
            long l11;
            long l12;
            d d10 = (d)object2.next();
            long l13 = d10.u();
            long l14 = d10.J();
            double d11 = l13 - l14;
            double d12 = d10.I();
            l13 = (long)(d11 /= d12);
            int n10 = m0.l * 2500;
            l14 = n10;
            long l15 = l13 / l14;
            long l16 = 0L;
            long l17 = (l13 %= l14) - l16;
            long l18 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            long l19 = 1L;
            if (l18 != false) {
                l15 += l19;
            }
            int n11 = 0;
            while ((l12 = (l11 = (l10 = (long)n11) - l15) == 0L ? 0 : (l11 < 0L ? -1 : 1)) < 0) {
                long l20;
                long l21;
                long l22;
                a a10 = new a();
                Object object3 = d10.e();
                object3 = a10.i((String)object3);
                int n12 = m0.l;
                object3 = ((a)object3).l(n12);
                object = object2;
                d d13 = d10;
                long l23 = l10 * l14;
                ((a)object3).j(l23);
                int n13 = 1;
                if (n11 == 0) {
                    a10.h(n13 != 0);
                }
                if (!(bl2 = (l22 = l10 - (l21 = l15 - (l20 = 1L))) == 0L ? 0 : (l22 < 0L ? -1 : 1))) {
                    a10.g(n13 != 0);
                    if (l18 != false) {
                        double d14 = l13;
                        l10 = 4556014321273684781L;
                        double d15 = 4.0E-4;
                        n13 = (int)(d14 *= d15);
                        a10.l(n13);
                    }
                }
                recordingThumbView.a.add(a10);
                ++n11;
                object2 = object;
                d10 = d13;
                l19 = l20;
            }
        }
        object2 = new RecordingThumbView$b(recordingThumbView, null);
        recordingThumbView.setAdapter((RecyclerView$Adapter)object2);
    }
}

