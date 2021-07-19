/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.zhiyun.cama.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.zhiyun.cama.widget.EditorThumbnail$a;
import com.zhiyun.cama.widget.EditorThumbnail$b;
import d.v.c.b2.h;
import d.v.c.b2.p;
import d.v.c.b2.w.e;
import d.v.c.b2.w.j;
import d.v.c.m0$a;
import d.v.c.x1.q.c;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$d;
import d.v.e.l.y1;
import d.v.h.e.d;
import java.util.List;
import m.a.a;

public class EditorThumbnail
extends p {
    public static final int A0 = 0;
    private static final int B0 = 0;
    private static final int C0 = 0;
    public static final long x0 = 500000L;
    public static final int y0 = 2131099744;
    private static final int z0;
    private Bitmap T;
    private Bitmap U;
    private Bitmap V;
    private List W;
    private int k0 = -1;
    private EditorThumbnail$b o0;
    private m2$d p0;
    private d.v.c.b2.x.d q0;
    private d.v.c.b2.x.d r0;
    private Paint s0;
    private Paint t0;
    private List u0;
    private List v0;
    private EditorThumbnail$a w0;

    static {
        int n10;
        float f10 = 2.0f;
        z0 = n10 = h2.b(f10);
        A0 = n10 * 2;
        B0 = h2.b(f10);
        C0 = h2.b(8.0f);
    }

    public EditorThumbnail(Context object) {
        super((Context)object);
        super(this);
        this.q0 = object;
        super(this);
        this.r0 = object;
        super();
        this.u0 = object;
        super();
        this.v0 = object;
    }

    public EditorThumbnail(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super(this);
        this.q0 = object;
        super(this);
        this.r0 = object;
        super();
        this.u0 = object;
        super();
        this.v0 = object;
    }

    public EditorThumbnail(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super(this);
        this.q0 = object;
        super(this);
        this.r0 = object;
        super();
        this.u0 = object;
        super();
        this.v0 = object;
    }

    private boolean A0(int n10) {
        j j10 = this.K0(n10);
        int n11 = 0;
        if (j10 != null) {
            long l10 = j10.h();
            float f10 = l10;
            float f11 = this.b();
            int n12 = d.v.c.b2.w.j.u;
            float f12 = (f10 *= f11) - (f11 = (float)n12);
            Object object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
            if (object >= 0) {
                object = this.getSelectedColumnIndex();
                List list = this.W;
                int n13 = 1;
                if (list != null && (object < 0 || n10 != object && n10 != (object -= n13)) && n10 < (object = (Object)(list.size() - n13))) {
                    n11 = n13;
                }
            }
        }
        return n11 != 0;
    }

    private void B0() {
        m2$d m2$d = this.p0;
        if (m2$d == null) {
            this.postInvalidateOnAnimation();
        }
        m2.a(this.p0);
        h h10 = new h(this);
        this.p0 = m2$d = m2.Y(100, h10);
    }

    private void C0(Canvas canvas, float f10, Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        int n10 = m0$a.c;
        int n11 = n10 / 2;
        float f11 = n11;
        int n12 = (int)(f10 - f11);
        int n13 = this.getHeight() / 2 - n11;
        RectF rectF = this.c;
        float f12 = n12;
        float f13 = n13;
        f10 = n12 + n10;
        float f14 = n13 += n10;
        RectF rectF2 = new RectF(f12, f13, f10, f14);
        if ((n12 = (int)(RectF.intersects((RectF)rectF, (RectF)rectF2) ? 1 : 0)) == 0) {
            return;
        }
        n10 = bitmap.getWidth();
        n13 = bitmap.getHeight();
        rectF = new Rect(0, 0, n10, n13);
        Paint paint = this.m;
        canvas.drawBitmap(bitmap, (Rect)rectF, rectF2, paint);
    }

    private void D0(Canvas canvas, long l10, float f10, boolean bl2) {
        String string2 = this.Q(l10);
        int n10 = C0;
        float f11 = n10;
        int n11 = this.getHeight() - n10;
        float f12 = n11;
        Paint paint = this.j;
        EditorThumbnail editorThumbnail = this;
        String string3 = string2;
        this.L(string2, f10 += f11, f12, paint, canvas);
        if (bl2) {
            float f13 = this.j.measureText(string2);
            f10 += f13;
            int n12 = this.getHeight();
            n10 = m0$a.e;
            n12 -= n10;
            n10 = m0$a.d;
            f13 = n12 -= n10;
            n11 = this.V.getWidth();
            string3 = this.V;
            int n13 = string3.getHeight();
            Rect rect = new Rect(0, 0, n11, n13);
            float f14 = (float)n10 + f10;
            float f15 = (float)n10 + f13;
            editorThumbnail = new RectF(f10, f13, f14, f15);
            string2 = this.V;
            Paint paint2 = this.m;
            canvas.drawBitmap((Bitmap)string2, rect, (RectF)editorThumbnail, paint2);
        }
    }

    private void E0(Canvas canvas, long l10, float f10) {
        String string2 = this.Q(l10);
        float f11 = d2.d(this.k, string2);
        int n10 = this.getHeight();
        float f12 = n10;
        Object object = this.k;
        float f13 = d2.b(object);
        f12 += f13;
        int n11 = 0x40000000;
        f13 = 2.0f;
        f12 /= f13;
        f11 /= f13;
        f13 = f10 - f11;
        f10 += f11;
        f11 = 0.0f;
        RectF rectF = new RectF(f13, 0.0f, f10, f12);
        RectF rectF2 = this.d;
        f10 = rectF2.left;
        f13 = rectF.left;
        float f14 = f10 - f13;
        Object object2 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object2 > 0) {
            rectF.offset(f10 -= f13, 0.0f);
        } else {
            f10 = rectF.right;
            f12 = rectF2.right;
            float f15 = f10 - f12;
            n11 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
            if (n11 > 0) {
                rectF.offset(f10 -= f12, 0.0f);
            }
        }
        f11 = rectF.left;
        float f16 = rectF.bottom;
        Paint paint = this.j;
        object = this;
        this.L(string2, f11, f16, paint, canvas);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void F0(Canvas var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = this.W;
        if (var4_4 == null) {
            return;
        }
        var5_5 = this.b();
        var6_6 = new RectF();
        var7_7 = 0;
        var4_4 = null;
        var8_8 = 0.0f;
        for (var9_9 = 0; var9_9 < (var11_11 = (var10_10 = var2_2.W).size()); ++var9_9) {
            var10_10 = (j)var2_2.W.get(var9_9);
            var12_12 = var10_10.h();
            var14_13 = (float)var12_12 * var5_5;
            var15_14 = var8_8 + var14_13;
            var14_13 = var2_2.H0(var8_8, var9_9);
            var17_16 = var2_2.I0(var15_14, var9_9);
            var18_17 = this.getHeight();
            var19_18 = var18_17;
            var16_15 = new RectF(var14_13, 0.0f, var17_16, var19_18);
            var14_13 = var16_15.left;
            var17_16 = var16_15.right;
            cfr_temp_0 = var14_13 - var17_16;
            var20_19 /* !! */  = (float)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 < 0.0f ? -1 : 1));
            if (var20_19 /* !! */  >= 0 || (var20_19 /* !! */  = (float)RectF.intersects((RectF)(var21_20 = var2_2.c), (RectF)var16_15)) == false) ** GOTO lbl-1000
            var21_20 = var2_2.m;
            var22_21 = var3_3.saveLayer(var16_15, (Paint)var21_20);
            var21_20 = var2_2.c;
            var14_13 = var21_20.left;
            var14_13 = Math.max(var8_8, var14_13);
            var23_22 = var2_2.c;
            var17_16 = var23_22.left;
            cfr_temp_1 = var8_8 - var17_16;
            var18_17 = (int)(cfr_temp_1 == 0.0f ? 0 : (cfr_temp_1 < 0.0f ? -1 : 1));
            if (var18_17 < 0) {
                var17_16 -= var8_8;
                var20_19 /* !! */  = d.v.c.b2.w.j.s;
                var19_18 = var20_19 /* !! */ ;
                var24_23 = (int)(var17_16 /= var19_18) * var20_19 /* !! */ ;
                var14_13 = (float)var24_23 + var8_8;
            }
            if ((var18_17 = (var23_22 = var10_10.u()).size()) > 0) {
                while ((var18_17 = (int)((cfr_temp_2 = var14_13 - (var19_18 = var16_15.right)) == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1))) < 0) {
                    var25_24 = var2_2.c;
                    var19_18 = var25_24.right;
                    cfr_temp_3 = var14_13 - var19_18;
                    var18_17 = (int)(cfr_temp_3 == 0.0f ? 0 : (cfr_temp_3 < 0.0f ? -1 : 1));
                    if (var18_17 >= 0) break;
                    var18_17 = (int)var10_10.A();
                    if (var18_17 != 0) {
                        var19_18 = this.a() * var14_13;
                        var26_25 = d.v.v.q.h.b((long)var19_18);
                        var28_26 = var26_25;
                    } else {
                        var26_25 = var10_10.i();
                        var19_18 = var26_25;
                        var30_27 = var14_13 - var8_8;
                        var31_28 = this.a();
                        var28_26 = var19_18 += (var30_27 *= var31_28);
                        var32_29 = var10_10.s();
                        var28_26 *= var32_29;
                    }
                    var32_29 = var10_10.r();
                    var26_25 = Math.round(var28_26 /= var32_29);
                    var18_17 = (int)var26_25;
                    var34_30 = d.v.c.b2.w.j.s;
                    var35_31 = (float)var34_30 + var14_13;
                    var36_32 = var8_8;
                    var8_8 = var34_30;
                    var6_6.set(var14_13, 0.0f, var35_31, var8_8);
                    var7_7 = var23_22.size() + -1;
                    var7_7 = Math.min(var18_17, var7_7);
                    var4_4 = (d.v.c.b2.w.h)var23_22.get(var7_7);
                    var2_2.v0.add(var4_4);
                    var2_2.u0.remove(var4_4);
                    var25_24 = this.getContext();
                    var37_33 = var2_2.q0;
                    var4_4 = var4_4.h((Context)var25_24, var37_33);
                    if (var4_4 != null) {
                        var25_24 = y1.d((Bitmap)var4_4, var6_6);
                        var37_33 = var2_2.m;
                        var3_3.drawBitmap((Bitmap)var4_4, (Rect)var25_24, var6_6, (Paint)var37_33);
                    }
                    var8_8 = var34_30;
                    var14_13 += var8_8;
                    var8_8 = var36_32;
                }
            }
            var12_12 = var10_10.h();
            var19_18 = var16_15.left;
            var34_30 = ((d)var10_10.a()).j();
            var4_4 = this;
            var10_10 = var1_1;
            this.D0(var1_1, var12_12, var19_18, (boolean)var34_30);
            var38_34 = var16_15.left;
            var20_19 /* !! */  = EditorThumbnail.A0;
            var17_16 = var20_19 /* !! */ ;
            var18_17 = 0x40000000;
            var19_18 = 2.0f;
            var17_16 = var16_15.top;
            var30_27 = (float)var20_19 /* !! */  / var19_18;
            var17_16 -= var30_27;
            var30_27 = var16_15.right;
            var35_31 = (float)var20_19 /* !! */  / var19_18;
            var30_27 += var35_31;
            var35_31 = var16_15.bottom;
            var14_13 = (float)var20_19 /* !! */  / var19_18;
            var4_4 = new RectF(var38_34 -= (var17_16 /= var19_18), var17_16, var30_27, var35_31 += var14_13);
            var11_11 = EditorThumbnail.z0;
            var20_19 /* !! */  = var11_11 * 2;
            var14_13 = var20_19 /* !! */ ;
            var38_34 = var11_11 *= 2;
            var23_22 = var2_2.s0;
            var3_3.drawRoundRect((RectF)var4_4, var14_13, var38_34, (Paint)var23_22);
            var3_3.restoreToCount(var22_21);
            var7_7 = (int)this.S();
            if (var7_7 == 0 && (var7_7 = var2_2.k0) == var9_9 && (var4_4 = var2_2.g) != null) {
                var38_34 = var16_15.left;
                var11_11 = (int)var38_34;
                var14_13 = var16_15.right;
                var20_19 /* !! */  = (int)var14_13;
                var24_23 = this.getHeight();
                var18_17 = 0;
                var19_18 = 0.0f;
                var25_24 = null;
                var4_4 = new Rect(var11_11, 0, (int)var20_19 /* !! */ , var24_23);
                var10_10 = var2_2.g;
                var10_10.setBounds((Rect)var4_4);
                var4_4 = var2_2.g;
                var4_4.draw(var3_3);
            } else lbl-1000:
            // 2 sources

            {
                var18_17 = 0;
                var19_18 = 0.0f;
                var25_24 = null;
            }
            var8_8 = var15_14;
        }
        this.S0();
    }

    private void G0(Canvas canvas) {
        Object object;
        int n10;
        List list = this.W;
        if (list == null) {
            return;
        }
        float f10 = 0.0f;
        list = null;
        float f11 = this.b();
        for (int i10 = 0; i10 < (n10 = (object = this.W).size()); ++i10) {
            object = (j)this.W.get(i10);
            long l10 = ((d.v.c.b2.w.c)object).h();
            float f12 = (float)l10 * f11;
            f10 += f12;
            boolean bl2 = this.A0(i10);
            if (!bl2) continue;
            bl2 = ((j)object).y();
            if (bl2) {
                Context context = this.getContext();
                d.v.c.b2.x.d d10 = this.r0;
                object = ((j)object).v(context, d10);
            } else {
                n10 = (int)(((j)object).z() ? 1 : 0);
                object = n10 != 0 ? this.T : this.U;
            }
            this.C0(canvas, f10, (Bitmap)object);
        }
    }

    private float H0(float f10, int n10) {
        if (n10 != 0) {
            n10 = B0;
            float f11 = n10;
            f10 += f11;
        }
        return f10;
    }

    private float I0(float f10, int n10) {
        List list = this.W;
        int n11 = list.size() + -1;
        if (n10 != n11) {
            n10 = B0;
            float f11 = n10;
            f10 -= f11;
        }
        return f10;
    }

    private long J0(j j10) {
        Object object = this.W;
        if (object != null) {
            boolean bl2;
            int n10 = 0;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                j j11 = (j)object.next();
                boolean bl3 = j11.equals(j10);
                if (bl3) {
                    return n10;
                }
                long l10 = n10;
                long l11 = j11.h();
                n10 = (int)(l10 += l11);
            }
        }
        return -1;
    }

    private j K0(int n10) {
        int n11;
        List list = this.getUiData();
        if (list != null && (n11 = list.isEmpty()) == 0 && (n11 = list.size()) > n10) {
            return (j)list.get(n10);
        }
        return null;
    }

    private /* synthetic */ void L0() {
        this.postInvalidateOnAnimation();
        this.p0 = null;
    }

    private /* synthetic */ void N0(c c10, Bitmap bitmap) {
        this.B0();
    }

    private /* synthetic */ void P0(String string2, Bitmap bitmap) {
        this.postInvalidateOnAnimation();
    }

    private void S0() {
        Object object;
        boolean bl2;
        Object object2 = this.u0.iterator();
        while (bl2 = object2.hasNext()) {
            object = (d.v.c.b2.w.h)object2.next();
            ((d.v.c.b2.w.h)object).a();
        }
        this.u0.clear();
        object2 = this.u0;
        object = this.v0;
        object2.addAll(object);
        this.v0.clear();
    }

    private long x0(double d10, long l10) {
        long l11 = (long)(500000.0 / d10);
        l10 = d.v.v.q.h.a(0, l10) - l11;
        return d.v.v.q.h.c(0, l10);
    }

    private long y0(double d10, long l10) {
        long l11 = (long)(500000.0 / d10);
        l10 = d.v.v.q.h.a(0, l10) + l11;
        return d.v.v.q.h.c(0, l10);
    }

    private void z0(int n10) {
        EditorThumbnail$b editorThumbnail$b = this.o0;
        if (editorThumbnail$b != null) {
            editorThumbnail$b.a(n10);
        }
    }

    public boolean A() {
        return true;
    }

    public e C(float f10, float f11) {
        List list = this.W;
        if (list != null) {
            Object object;
            int n10;
            f11 = this.b();
            f10 /= f11;
            Object object2 = 0;
            f11 = 0.0f;
            list = null;
            for (int i10 = 0; i10 < (n10 = (object = this.W).size()); ++i10) {
                object = (j)this.W.get(i10);
                long l10 = ((d.v.c.b2.w.c)object).h();
                float f12 = (float)l10 + f11;
                object2 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
                if (object2 >= 0 && (object2 = (Object)(f10 == f12 ? 0 : (f10 < f12 ? -1 : 1))) < 0) {
                    e e10 = new e(0, i10, object);
                    return e10;
                }
                f11 = f12;
            }
        }
        return null;
    }

    public Object D(float f10, float f11) {
        List list;
        float f12;
        Bitmap bitmap = this.T;
        int n10 = bitmap.getWidth() / 2;
        int n11 = this.getHeight();
        float f13 = n11;
        int n12 = 0x40000000;
        float f14 = 2.0f;
        float f15 = (f11 = Math.abs(f11 - (f13 /= f14))) - (f12 = (float)n10);
        Object object = f15 == 0.0f ? 0 : (f15 < 0.0f ? -1 : 1);
        if (object <= 0 && (list = this.W) != null) {
            Object object2;
            object = false;
            f11 = 0.0f;
            list = null;
            f13 = 0.0f;
            for (n11 = 0; n11 < (n12 = (object2 = this.W).size() + -1); ++n11) {
                float f16;
                object2 = (j)this.W.get(n11);
                long l10 = ((d.v.c.b2.w.c)object2).h();
                float f17 = l10;
                float f18 = this.b();
                int n13 = this.A0(n11);
                if (n13 == 0 || (n13 = (f16 = (f17 = Math.abs(f10 - (f11 += (f17 *= f18)))) - f12) == 0.0f ? 0 : (f16 < 0.0f ? -1 : 1)) > 0 || (n12 = (int)(((j)object2).z() ? 1 : 0)) == 0) continue;
                return n11;
            }
        }
        return null;
    }

    public void H() {
        Object object = new Object[]{};
        Object object2 = "\u957f\u6309item";
        a.e((String)object2, object);
        object = this.u;
        if (object != null && (object2 = this.w0) != null) {
            float f10 = this.w;
            float f11 = this.x;
            object2.a((e)object, f10, f11);
        }
    }

    public /* synthetic */ void M0() {
        this.L0();
    }

    public /* synthetic */ void O0(c c10, Bitmap bitmap) {
        this.N0(c10, bitmap);
    }

    public /* synthetic */ void Q0(String string2, Bitmap bitmap) {
        this.P0(string2, bitmap);
    }

    public Rect R0(j j10) {
        if (j10 != null) {
            long l10 = this.J0(j10);
            int n10 = this.getSelectedColumnIndex();
            long l11 = 0L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object >= 0) {
                float f10 = l10;
                float f11 = this.b();
                int n11 = (int)this.H0(f10 *= f11, n10);
                long l13 = j10.h();
                float f12 = l10 + l13;
                float f13 = this.b();
                int n12 = (int)this.I0(f12 *= f13, n10);
                int n13 = this.getHeight();
                Rect rect = new Rect(n11, 0, n12, n13);
                return rect;
            }
        }
        return null;
    }

    public void U() {
        Bitmap bitmap;
        super.U();
        this.T = bitmap = this.e(2131231032);
        this.U = bitmap = this.e(2131231033);
        this.V = bitmap = this.e(2131231203);
    }

    public void V() {
        super.V();
        Paint paint = this.j;
        float f10 = d.v.c.b2.p.R;
        paint.setTextSize(f10);
        paint = this.j;
        f10 = h2.b(2.0f);
        int n10 = this.f(2131099744);
        paint.setShadowLayer(f10, 0.0f, 0.0f, n10);
        this.s0 = paint = new Paint();
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        paint = this.s0;
        f10 = A0;
        paint.setStrokeWidth(f10);
        paint = this.s0;
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        paint = this.s0;
        n10 = this.f(2131099859);
        paint.setColor(n10);
        this.t0 = paint = new Paint();
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        this.t0.setAntiAlias(bl2);
        this.t0.setColor(-2013265920);
    }

    public void e0(int n10, int n11) {
        if (n10 == 0) {
            return;
        }
        j j10 = (j)this.getSelectedData();
        if (j10 == null) {
            return;
        }
        float f10 = n10;
        float f11 = this.b();
        long l10 = (long)(f10 /= f11);
        n10 = (int)(this.Y() ? 1 : 0);
        long l11 = 500000L;
        if (n10 != 0) {
            long l12 = j10.i() + l10;
            l10 = Math.min(j10.g() - l11, l12);
            l10 = Math.max(0L, l10);
            l11 = j10.i();
            l11 = l10 - l11;
            j10.m(l10);
        } else {
            long l13 = j10.g() + l10;
            l10 = Math.max(j10.i() + l11, l13);
            l10 = Math.min(j10.x(), l10);
            l11 = j10.g();
            l11 = l10 - l11;
            j10.l(l10);
        }
        this.v0();
        this.postInvalidateOnAnimation();
        f10 = l11;
        float f12 = this.b();
        float f13 = n11;
        n10 = Math.round((f10 *= f12) * f13);
        this.l0(n10);
    }

    public EditorThumbnail$b getOnTransitionBtnClickListener() {
        return this.o0;
    }

    public List getUiData() {
        return this.W;
    }

    public void l(Canvas canvas) {
        Object[] objectArray = new Object[2];
        RectF rectF = this.c;
        objectArray[0] = rectF;
        rectF = this.d;
        objectArray[1] = rectF;
        a.b("onDrawTask, mRectDrawScreen:%s, mRectCurScreen:%s", objectArray);
        this.F0(canvas);
        this.G0(canvas);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2.a(this.p0);
        this.postInvalidateOnAnimation();
        this.q0 = null;
        this.r0 = null;
    }

    public boolean onTouchEvent(MotionEvent object) {
        boolean bl2;
        Object[] objectArray;
        boolean bl3 = super.onTouchEvent((MotionEvent)object);
        boolean bl4 = this.r;
        if (bl4 && (objectArray = this.w0) != null) {
            objectArray.onTouchEvent((MotionEvent)object);
        }
        if (((bl4 = object.getAction()) == (bl2 = true) || bl4 == (bl2 = 3 != 0)) && (bl4 = (boolean)this.r) && (objectArray = this.w0) != null) {
            objectArray.onStop();
        }
        objectArray = new StringBuilder();
        objectArray.append("mLongClick:");
        bl2 = this.r;
        objectArray.append(bl2);
        objectArray.append(" event:");
        objectArray.append(object);
        object = objectArray.toString();
        objectArray = new Object[]{};
        a.b((String)object, objectArray);
        return bl3;
    }

    public void s(Object object) {
        boolean bl2 = object instanceof Integer;
        if (bl2) {
            object = (Integer)object;
            int n10 = (Integer)object;
            this.z0(n10);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void s0(float var1_1) {
        var2_2 = this.getPaddingLeft();
        var1_1 += var2_2;
        var3_3 = this.Z();
        var4_4 = 0;
        if (var3_3 == 0) ** GOTO lbl22
        var3_3 = this.b0(var1_1);
        if (var3_3 != 0) {
            var3_3 = this.Y();
            var4_4 = var3_3 ^ 1;
            var5_5 = -this.N(var1_1);
lbl11:
            // 2 sources

            while (true) {
                var6_6 = var4_4;
                var4_4 = var5_5;
                var5_5 = var6_6;
                break;
            }
        } else {
            var3_3 = this.c0(var1_1);
            if (var3_3 != 0) {
                var3_3 = this.Y();
                var4_4 = var3_3 ^ 1;
                var5_5 = this.N(var1_1);
                ** continue;
            }
lbl22:
            // 3 sources

            var5_5 = 0;
            var1_1 = 0.0f;
        }
        this.o0(var4_4, var5_5);
    }

    public void setCurPositionIndex(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setCurPositionIndex, curPositionIndex:");
        int n11 = this.k0;
        charSequence.append(n11);
        charSequence.append(" positionIndex:");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        n11 = 0;
        Object[] objectArray = new Object[]{};
        a.b((String)charSequence, objectArray);
        int n12 = this.k0;
        if (n12 != n10) {
            this.k0 = n10;
            this.postInvalidateOnAnimation();
        }
    }

    public void setOnItemLongPressedListener(EditorThumbnail$a editorThumbnail$a) {
        this.w0 = editorThumbnail$a;
    }

    public void setOnTransitionBtnClickListener(EditorThumbnail$b editorThumbnail$b) {
        this.o0 = editorThumbnail$b;
    }

    public void setUiData(List object) {
        this.W = object;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                j j10 = (j)object.next();
                float f10 = this.b();
                j10.N(f10);
            }
        }
        this.w0();
        this.postInvalidateOnAnimation();
    }

    public int u0(float f10, float f11) {
        int n10 = this.Z();
        int n11 = 0;
        if (n10 != 0 && (n10 = this.Y()) != 0) {
            n11 = n10 = -1;
        }
        return n11;
    }

    public void w0() {
        this.v0();
    }

    public boolean z() {
        return false;
    }
}

