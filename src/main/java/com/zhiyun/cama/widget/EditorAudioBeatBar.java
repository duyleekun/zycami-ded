/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import d.v.c.b2.r;
import d.v.c.b2.w.k;
import d.v.e.l.h2;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EditorAudioBeatBar
extends r {
    private List f;
    private float g;
    private Paint h;
    private final float i;

    public EditorAudioBeatBar(Context object) {
        super((Context)object);
        float f10;
        super();
        this.f = object;
        this.i = f10 = (float)h2.b(1.5f);
        this.q();
    }

    public EditorAudioBeatBar(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        float f10;
        super();
        this.f = object;
        this.i = f10 = (float)h2.b(1.5f);
        this.q();
    }

    public EditorAudioBeatBar(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        float f10;
        super();
        this.f = object;
        this.i = f10 = (float)h2.b(1.5f);
        this.q();
    }

    private void p(Canvas canvas, long l10, long l11, long l12, HashMap object) {
        boolean bl2;
        object = ((HashMap)object).entrySet().iterator();
        while (bl2 = object.hasNext()) {
            long l13;
            long l14;
            Long l15 = (Long)((Map.Entry)object.next()).getValue();
            long l16 = l15;
            long l17 = l16 - l11;
            Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object2 < 0 || (object2 = (l14 = l16 - (l13 = l11 + l12)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) >= 0) continue;
            l16 = l16 + l10 - l11;
            float f10 = l16;
            float f11 = this.b();
            f10 *= f11;
            f11 = this.g;
            float f12 = this.i;
            Paint paint = this.h;
            canvas.drawCircle(f10, f11, f12, paint);
        }
    }

    private void q() {
        Paint paint;
        this.h = paint = new Paint();
        paint.setAntiAlias(true);
        paint = this.h;
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.h;
        int n10 = this.getResources().getColor(2131099798, null);
        paint.setColor(n10);
    }

    public void l(Canvas canvas) {
        boolean bl2;
        Iterator iterator2 = this.f.iterator();
        while (bl2 = iterator2.hasNext()) {
            k k10 = (k)iterator2.next();
            long l10 = k10.i();
            long l11 = k10.t();
            long l12 = k10.s();
            long l13 = k10.t();
            l13 = l12 - l13;
            HashMap hashMap = k10.r();
            this.p(canvas, l10, l11, l13, hashMap);
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        float f10;
        super.onSizeChanged(n10, n11, n12, n13);
        this.g = f10 = (float)n11 / 2.0f;
    }

    public void setUiData(List collection) {
        List list = this.f;
        list.clear();
        if (collection != null) {
            list = null;
            Object object = collection.get(0);
            if (object != null) {
                object = this.f;
                collection = (Collection)collection.get(0);
                object.addAll(collection);
            }
        }
        this.invalidate();
    }
}

