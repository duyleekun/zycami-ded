/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.RectF
 *  android.graphics.Shader
 *  android.util.AttributeSet
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import d.v.c.b2.q;
import d.v.c.b2.w.k;
import d.v.c.b2.x.d;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.e.l.o1;
import d.v.h.i.a.b;
import java.util.ArrayList;
import java.util.List;
import m.a.a;

public class EditorVoiceBar
extends q {
    private static final int B0 = 2131099775;
    private static final int C0 = h2.b(1.0f);
    private static final int D0 = h2.b(2.0f);
    private static final int E0;
    private static final int F0;
    public int A0;
    private Paint x0;
    private float y0;
    private d z0;

    static {
        float f10 = 5.0f;
        E0 = h2.b(f10);
        F0 = h2.b(f10);
    }

    public EditorVoiceBar(Context object) {
        super((Context)object);
        super(this);
        this.z0 = object;
        this.A0 = 0;
    }

    public EditorVoiceBar(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super(this);
        this.z0 = object;
        this.A0 = 0;
    }

    public EditorVoiceBar(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super(this);
        this.z0 = object;
        this.A0 = 0;
    }

    private void M0(Canvas canvas, float f10, float f11, float f12, float f13, k k10) {
        int n10;
        EditorVoiceBar editorVoiceBar = this;
        float f14 = f11;
        long l10 = k10.t();
        List list = k10.v();
        if (list != null && (n10 = list.size()) != 0) {
            float f15 = this.a();
            RectF rectF = this.c;
            float f16 = rectF.right;
            float f17 = rectF.left;
            float f18 = f16 - f17;
            int n11 = (int)f18;
            Object object = f12 == f17 ? 0 : (f12 < f17 ? -1 : 1);
            if (object < 0) {
                float f19 = l10;
                float f20 = (f17 - f12) * f15;
                l10 = (long)(f19 += f20);
            } else {
                f15 = n11;
                f18 = f12 - f17;
                n11 = (int)(f15 -= f18);
            }
            n10 = (int)(f13 == f16 ? 0 : (f13 < f16 ? -1 : 1));
            if (n10 < 0) {
                f15 = n11;
                n11 = (int)(f15 -= (f16 -= f13));
            }
            f15 = f14 - f10;
            n10 = (int)f15;
            int n12 = E0;
            n10 -= n12;
            n12 = F0;
            n10 -= n12;
            n12 = C0;
            object = D0;
            n12 += object;
            object = false;
            float f21 = 0.0f;
            Object object2 = f12 == f17 ? 0 : (f12 < f17 ? -1 : 1);
            if (object2 < 0) {
                f21 = f17 - f12;
                object = (int)f21 % n12;
                object = n12 - object;
            } else {
                f17 = f12;
            }
            RectF rectF2 = new RectF();
            while (object < n11) {
                object2 = editorVoiceBar.A0 + 1;
                editorVoiceBar.A0 = (int)object2;
                float f22 = l10;
                float f23 = object;
                float f24 = this.a() * f23;
                long l11 = (long)(f22 + f24);
                f22 = l11;
                f24 = editorVoiceBar.y0;
                object2 = (int)(f22 *= f24);
                int n13 = list.size();
                if (object2 >= n13) {
                    return;
                }
                f22 = ((Float)list.get((int)object2)).floatValue();
                f24 = n10;
                float f25 = 1.0f;
                f22 = f25 - f22;
                object2 = (int)(f24 * f22);
                int n14 = (int)(f23 + f17);
                f24 = n14;
                float f26 = E0;
                f26 = f10 + f26;
                f22 = object2;
                f26 += f22;
                f22 = (int)f26;
                int n15 = C0;
                f23 = n14 += n15;
                int n16 = (int)f14;
                int n17 = F0;
                float f27 = n16 -= n17;
                rectF2.set(f24, f22, f23, f27);
                Paint paint = editorVoiceBar.x0;
                canvas.drawRoundRect(rectF2, f25, f25, paint);
                object += n15;
                object2 = D0;
                object = object + object2 + -1 + true;
            }
        }
    }

    private /* synthetic */ void O0(String string2, List list) {
        this.postInvalidateOnAnimation();
    }

    private int Q0(List list, long l10, int n10, int n11) {
        long l11;
        Object object;
        long l12;
        long l13;
        int n12;
        int n13 = list.size();
        int n14 = -1;
        if (n13 != 0 && (n13 = list.size()) >= (n12 = n11 + -1) && (n13 = (int)((l13 = l10 - (l12 = ((b)(object = (b)list.get(n10))).b())) == 0L ? 0 : (l13 < 0L ? -1 : 1))) >= 0 && (n13 = (int)((l11 = l10 - (l12 = ((b)(object = (b)list.get(n11))).b())) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0 && n10 <= n11) {
            long l14;
            n13 = n10 & n11;
            n14 = (n10 ^ n11) >> 1;
            b b10 = (b)list.get(n13 += n14);
            long l15 = b10.b();
            if (n13 == n10) {
                l12 = l15;
            } else {
                int n15 = n13 + -1;
                b b11 = (b)list.get(n15);
                l12 = b11.b();
            }
            if (n13 == n11) {
                l14 = l15;
            } else {
                int n16 = n13 + 1;
                b b12 = (b)list.get(n16);
                l14 = b12.b();
            }
            n14 = (int)(l15 == l10 ? 0 : (l15 < l10 ? -1 : 1));
            if (n14 > 0 && (n12 = (int)(l12 == l10 ? 0 : (l12 < l10 ? -1 : 1))) > 0) {
                int n17 = n13 + -1;
                object = this;
                l15 = l10;
                int n18 = n10;
                return this.Q0(list, l10, n10, n17);
            }
            if (n14 < 0 && (n14 = (int)(l14 == l10 ? 0 : (l14 < l10 ? -1 : 1))) < 0) {
                int n19 = n13 + 1;
                object = this;
                l15 = l10;
                int n20 = n11;
                return this.Q0(list, l10, n19, n11);
            }
            long l16 = n13;
            long l17 = l16 - l10;
            n12 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
            if (n12 < 0) {
                long l18 = (l16 = l10 - l16) - (l14 -= l10);
                Object object2 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
                if (object2 > 0) {
                    ++n13;
                }
            } else {
                long l19 = l10 - l12;
                long l20 = (l16 -= l10) - l19;
                Object object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object3 > 0) {
                    n13 += -1;
                }
            }
            return Math.min(Math.max(n13, 0), n11);
        }
        return n14;
    }

    private void R0() {
        Resources resources = this.getResources();
        int n10 = o1.c(resources, 2131099799);
        Resources resources2 = this.getResources();
        int n11 = o1.c(resources2, 2131099797);
        Resources resources3 = this.getResources();
        int n12 = o1.c(resources3, 2131099803);
        Resources resources4 = this.getResources();
        int n13 = 2131099800;
        int n14 = o1.c(resources4, n13);
        Object object = this.getData();
        if (object != null) {
            boolean bl2;
            int n15 = 0;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                Object object2 = (List)object.next();
                if (object2 != null) {
                    boolean bl3;
                    object2 = object2.iterator();
                    while (bl3 = object2.hasNext()) {
                        k k10 = (k)object2.next();
                        if (n15 == 0) {
                            k10.q(n10);
                            k10.p(n11);
                            continue;
                        }
                        k10.q(n12);
                        k10.p(n14);
                    }
                }
                ++n15;
            }
        }
    }

    private void S0() {
        Object object = this.getData();
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                boolean bl3;
                Object object2 = (List)object.next();
                if (object2 == null) continue;
                object2 = object2.iterator();
                while (bl3 = object2.hasNext()) {
                    float f10;
                    k k10 = (k)object2.next();
                    long l10 = ((d.v.h.h.b)k10.a()).e();
                    this.y0 = f10 = this.b();
                    f10 = this.b();
                    float f11 = l10;
                    int n10 = (int)(f10 *= f11);
                    k10.y(n10);
                    d d10 = this.z0;
                    k10.E(d10);
                }
            }
        }
    }

    public void L0(Canvas canvas, float f10, float f11, float f12, float f13, k k10) {
        this.M0(canvas, f10, f11, f12, f13, k10);
        Paint paint = this.k;
        String string2 = ((d.v.h.h.b)k10.a()).j();
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
        paint2 = this.j;
        f14 = n10;
        f20 = f15 + f14;
        long l10 = k10.h();
        string3 = this.Q(l10);
        f16 = d2.b(paint2);
        f17 = (f17 + f16) / f18;
        f19 = f10 + f17;
        this.M(string3, f20, f19, paint2, canvas, f16);
    }

    public Shader N0(float f10, float f11, float f12, float f13, k k10) {
        return super.I0(f10, f11, f12, f13, k10);
    }

    public /* synthetic */ void P0(String string2, List list) {
        this.O0(string2, list);
    }

    public void V() {
        super.V();
        Paint paint = this.j;
        int n10 = this.f(2131099786);
        paint.setColor(n10);
        this.x0 = paint = new Paint();
        n10 = this.f(2131099775);
        paint.setColor(n10);
        this.x0.setAntiAlias(true);
    }

    public void draw(Canvas object) {
        this.A0 = 0;
        super.draw((Canvas)object);
        object = new StringBuilder();
        ((StringBuilder)object).append("drawBarWidget, for:");
        int n10 = this.A0;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        a.x((String)object, objectArray);
    }

    public void e0(int n10, int n11) {
        if (n10 == 0) {
            return;
        }
        k k10 = (k)this.getSelectedData();
        if (k10 == null) {
            return;
        }
        float f10 = n10;
        float f11 = this.b();
        long l10 = (long)(f10 /= f11);
        n10 = (int)(this.Y() ? 1 : 0);
        long l11 = 500000L;
        if (n10 != 0) {
            int n12;
            long l12 = k10.t() + l10;
            l10 = 0L;
            l12 = Math.max(l10, l12);
            l12 = Math.min(k10.s(), l12);
            long l13 = k10.t();
            l12 -= l13;
            l13 = k10.i() + l12;
            l12 = k10.g() - l11;
            l11 = Math.min(l12, l13);
            l10 = Math.max(l10, l11);
            n10 = this.getSelectedRowIndex();
            d.v.c.b2.w.b b10 = this.F0(n10, n12 = this.getSelectedColumnIndex() + -1);
            if (b10 != null) {
                l11 = b10.g();
                l10 = Math.max(l11, l10);
            }
            l11 = k10.i();
            l11 = l10 - l11;
            l12 = k10.t() + l11;
            k10.C(l12);
            k10.m(l10);
        } else {
            int n13;
            long l14 = k10.s() + l10;
            l10 = Math.max(k10.t(), l14);
            l10 = Math.min(k10.u(), l10);
            l14 = k10.s();
            l10 -= l14;
            l14 = k10.g() + l10;
            l10 = Math.max(k10.i() + l11, l14);
            l11 = this.getTotalTime();
            l10 = Math.min(l11, l10);
            n10 = this.getSelectedRowIndex();
            d.v.c.b2.w.b b11 = this.F0(n10, n13 = this.getSelectedColumnIndex() + 1);
            if (b11 != null) {
                l11 = b11.i();
                l10 = Math.min(l11, l10);
            }
            l11 = k10.g();
            l11 = l10 - l11;
            l14 = k10.s() + l11;
            k10.B(l14);
            k10.l(l10);
        }
        this.v0();
        this.postInvalidateOnAnimation();
        f10 = l11;
        float f12 = this.b();
        float f13 = n11;
        n10 = Math.round((f10 *= f12) * f13);
        this.l0(n10);
    }

    public void setUiData(List list) {
        ArrayList arrayList = this.getData();
        if (arrayList == null) {
            arrayList = new ArrayList();
        } else {
            arrayList.clear();
        }
        if (list != null) {
            arrayList.addAll(list);
        }
        this.setData(arrayList);
        this.R0();
        this.S0();
        this.invalidate();
    }

    public void setValue(d.v.c.q0.f.a a10) {
    }
}

