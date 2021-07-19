/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import d.v.c.b2.q;
import d.v.c.b2.w.f;
import d.v.c.b2.x.d;
import d.v.e.l.d2;
import d.v.e.l.o1;
import java.util.ArrayList;
import java.util.List;

public class EditorStickerBar
extends q {
    private List A0;
    private d B0;
    private List x0;
    private Bitmap y0;
    private List z0;

    public EditorStickerBar(Context object) {
        super((Context)object);
        super();
        this.z0 = object;
        super();
        this.A0 = object;
        super(this);
        this.B0 = object;
    }

    public EditorStickerBar(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super();
        this.z0 = object;
        super();
        this.A0 = object;
        super(this);
        this.B0 = object;
    }

    public EditorStickerBar(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super();
        this.z0 = object;
        super();
        this.A0 = object;
        super(this);
        this.B0 = object;
    }

    private /* synthetic */ void N0(String string2, Bitmap bitmap) {
        this.postInvalidateOnAnimation();
    }

    private void P0() {
        Object object;
        boolean bl2;
        Object object2 = this.z0.iterator();
        while (bl2 = object2.hasNext()) {
            object = (f)object2.next();
            ((f)object).r();
        }
        this.z0.clear();
        object2 = this.z0;
        object = this.A0;
        object2.addAll(object);
        this.A0.clear();
    }

    public void L0(Canvas canvas, float f10, float f11, float f12, float f13, f f14) {
        Paint paint;
        float f15;
        float f16;
        Paint paint2;
        int n10 = q.r0;
        float f17 = n10;
        f12 += f17;
        Object object = this.getContext();
        Object object2 = this.B0;
        if ((object = f14.s((Context)object, (d)object2)) != null) {
            int n11 = object.getWidth();
            int n12 = object.getHeight();
            paint2 = null;
            object2 = new Rect(0, 0, n11, n12);
            n11 = 6;
            f16 = n11;
            f10 += f16;
            f11 -= f16;
            f16 = f11 - f10;
            f15 = object.getHeight();
            f16 /= f15;
            n12 = object.getWidth();
            f15 = n12;
            f16 *= f15;
            RectF rectF = new RectF(f12, f10, f16 += f12, f11);
            paint = this.m;
            canvas.drawBitmap((Bitmap)object, (Rect)object2, rectF, paint);
            f12 = rectF.right;
            f17 = n10;
            f12 += f17;
        }
        float f18 = n10;
        f16 = f12 + f18;
        long l10 = f14.h();
        object2 = this.Q(l10);
        paint = this.j;
        float f19 = d2.b(paint);
        f11 = f11 - f10 + f19;
        f12 = 2.0f;
        f15 = f10 + (f11 /= f12);
        paint2 = this.j;
        object = this;
        this.M((String)object2, f16, f15, paint2, canvas, f19);
        boolean bl2 = f14.u();
        if (bl2) {
            int n13 = this.y0.getWidth();
            f11 = n13;
            f11 = f13 - f11;
            Bitmap bitmap = this.y0;
            n10 = bitmap.getHeight();
            f18 = n10;
            RectF rectF = new RectF(f11, 0.0f, f13, f18);
            Bitmap bitmap2 = this.y0;
            f12 = 0.0f;
            paint = null;
            Paint paint3 = this.m;
            canvas.drawBitmap(bitmap2, null, rectF, paint3);
        }
        this.A0.add(f14);
        this.z0.remove(f14);
    }

    public Shader M0(float f10, float f11, float f12, float f13, f f14) {
        int n10 = o1.c(this.getResources(), 2131099807);
        f14.q(n10);
        n10 = o1.c(this.getResources(), 2131099805);
        f14.p(n10);
        return super.I0(f10, f11, f12, f13, f14);
    }

    public /* synthetic */ void O0(String string2, Bitmap bitmap) {
        this.N0(string2, bitmap);
    }

    public void U() {
        Bitmap bitmap;
        super.U();
        this.y0 = bitmap = this.e(2131231204);
    }

    public void V() {
        super.V();
        Paint paint = this.j;
        int n10 = this.f(2131099784);
        paint.setColor(n10);
    }

    public List getUiData() {
        return this.x0;
    }

    public void l(Canvas canvas) {
        super.l(canvas);
        this.P0();
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

