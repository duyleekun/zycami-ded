/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.LinearGradient
 *  android.graphics.Matrix
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.Shader
 *  android.graphics.Shader$TileMode
 *  android.text.TextUtils
 *  android.util.AttributeSet
 */
package d.v.c.b2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.zhiyun.cama.R$styleable;
import d.v.c.b2.p;
import d.v.c.b2.w.b;
import d.v.c.b2.w.c;
import d.v.c.b2.w.e;
import d.v.e.l.d2;
import d.v.e.l.h2;
import d.v.f.i.g;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import m.a.a;

public class q
extends p {
    public static final long q0 = 500000L;
    public static final int r0 = 0;
    public static final int s0 = 0;
    private static final int t0 = 0;
    private static final int u0 = 0;
    private static final int v0 = 0;
    private static final float w0 = 10.0f;
    private float T;
    private Paint U;
    public Paint V;
    private String W;
    private List k0;
    public Map o0;
    public Matrix p0;

    static {
        int n10;
        float f10 = 10.0f;
        r0 = h2.b(f10);
        s0 = h2.b(f10);
        t0 = n10 = h2.b(2.0f);
        u0 = -n10;
        v0 = h2.b(4.0f);
    }

    public q(Context object) {
        super((Context)object);
        super();
        this.o0 = object;
        super();
        this.p0 = object;
    }

    public q(Context object, AttributeSet attributeSet) {
        super((Context)object, attributeSet);
        super();
        this.o0 = object;
        super();
        this.p0 = object;
    }

    public q(Context object, AttributeSet attributeSet, int n10) {
        super((Context)object, attributeSet, n10);
        super();
        this.o0 = object;
        super();
        this.p0 = object;
    }

    private void B0(Canvas canvas) {
        c c10;
        c c11 = c10 = this.getSelectedData();
        c11 = (b)c10;
        if (c11 != null) {
            float f10 = this.b();
            long l10 = c11.i();
            float f11 = (float)l10 * f10;
            long l11 = c11.g();
            float f12 = (float)l11 * f10;
            int n10 = this.getHeight();
            float f13 = n10;
            float f14 = this.D0(f11, (b)c11);
            float f15 = this.E0(f12, (b)c11);
            boolean bl2 = true;
            this.y0(canvas, 0.0f, f13, f14, f15, (b)c11, bl2);
        }
    }

    private void C0(Canvas canvas) {
        String string2 = this.W;
        int n10 = TextUtils.isEmpty((CharSequence)string2);
        if (n10 == 0 && (n10 = this.J0()) != 0) {
            canvas.save();
            n10 = this.getWidth();
            int n11 = this.getPaddingLeft();
            n10 -= n11;
            n11 = this.getPaddingRight();
            n10 -= n11;
            n11 = this.getHeight();
            canvas.clipRect(0, 0, n10, n11);
            string2 = this.V;
            float f10 = d2.b((Paint)string2);
            float f11 = (float)this.getHeight() + f10;
            n11 = 0x40000000;
            float f12 = 2.0f;
            float f13 = f11 / f12;
            String string3 = this.W;
            n10 = s0;
            float f14 = n10;
            Paint paint = this.V;
            this.M(string3, f14, f13, paint, canvas, f10);
            canvas.restore();
        }
    }

    private float D0(float f10, b b10) {
        long l10;
        long l11 = b10.i();
        long l12 = l11 - (l10 = 500000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            object = t0;
            float f11 = object;
            f10 += f11;
        }
        return f10;
    }

    private float E0(float f10, b b10) {
        long l10 = this.getTotalTime();
        long l11 = b10.g();
        long l12 = (l10 -= l11) - (l11 = 500000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            object = u0;
            float f11 = object;
            f10 += f11;
        }
        return f10;
    }

    private LinearGradient G0(b object) {
        String string2 = this.H0((b)object);
        LinearGradient linearGradient = (LinearGradient)this.o0.get(string2);
        if (linearGradient == null) {
            float f10 = 1.0f;
            int n10 = ((b)object).o();
            int n11 = ((b)object).n();
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            linearGradient = new LinearGradient(0.0f, 0.0f, f10, 0.0f, n10, n11, tileMode);
            object = this.o0;
            object.put(string2, linearGradient);
        }
        return linearGradient;
    }

    private String H0(b b10) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = b10.o();
        stringBuilder.append(n10);
        stringBuilder.append("");
        int n11 = b10.n();
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }

    private boolean J0() {
        Object object = this.k0;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                List list = (List)object.next();
                bl2 = this.x0(list);
                if (bl2) continue;
                return false;
            }
        }
        return true;
    }

    private boolean x0(List list) {
        boolean bl2;
        if (list != null && !(bl2 = list.isEmpty())) {
            bl2 = false;
            list = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void z0(Canvas canvas) {
        int n10;
        List list = this.k0;
        if (list == null) {
            return;
        }
        float f10 = 0.0f;
        list = null;
        float f11 = this.T + 0.0f;
        float f12 = this.b();
        Iterator iterator2 = this.k0.iterator();
        while ((n10 = iterator2.hasNext()) != 0) {
            int n11;
            Object object = (List)iterator2.next();
            if (object == null || (n11 = object.isEmpty())) continue;
            Iterator iterator3 = object.iterator();
            while ((n10 = iterator3.hasNext()) != 0) {
                int n12;
                Object object2 = object = iterator3.next();
                object2 = (b)object;
                long l10 = ((c)object2).i();
                float f13 = (float)l10 * f12;
                long l11 = ((c)object2).g();
                float f14 = (float)l11 * f12;
                float f15 = this.D0(f13, (b)object2);
                float f16 = this.E0(f14, (b)object2);
                n10 = this.getPracticalDataSize();
                n11 = 1;
                f14 = Float.MIN_VALUE;
                if (n10 <= n11) {
                    n12 = n11;
                } else {
                    n10 = 0;
                    f13 = 0.0f;
                    object = null;
                    n12 = 0;
                }
                object = this;
                this.y0(canvas, f10, f11, f15, f16, (b)object2, n12 != 0);
            }
            f10 = this.T + (f11 += 10.0f);
            float f17 = f11;
            f11 = f10;
            f10 = f17;
        }
        this.B0(canvas);
    }

    public void A0(Canvas canvas, float f10, float f11, float f12, float f13, b b10) {
    }

    public e C(float f10, float f11) {
        List list;
        int n10;
        float f12 = this.b();
        f10 /= f12;
        f12 = this.T;
        float f13 = 0.0f;
        f12 += 0.0f;
        for (int i10 = 0; i10 < (n10 = (list = this.k0).size()); ++i10) {
            list = (List)this.k0.get(i10);
            Object object = this.x0(list);
            if (object != 0) continue;
            object = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1);
            if (object >= 0 && (object = (Object)(f11 == f12 ? 0 : (f11 < f12 ? -1 : 1))) < 0) {
                int n11;
                for (object = 0; object < (n11 = list.size()); ++object) {
                    float f14;
                    b b10 = (b)list.get((int)object);
                    long l10 = b10.i();
                    float f15 = l10;
                    float f16 = f10 - f15;
                    Object object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                    if (object2 < 0 || (object2 = (f14 = f10 - (f15 = (float)(l10 = b10.g()))) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1)) > 0) continue;
                    e e10 = new e(i10, (int)object, b10);
                    return e10;
                }
            }
            n10 = 1092616192;
            float f17 = 10.0f;
            f12 = this.T + (f13 += (f12 += f17));
        }
        return null;
    }

    public Object D(float f10, float f11) {
        return null;
    }

    public b F0(int n10, int n11) {
        Object object;
        int n12;
        List list = this.k0;
        if (list != null && n10 >= 0 && (n12 = list.size()) > n10 && (object = (List)(list = this.k0).get(n10)) != null && n11 >= 0 && (n12 = object.size()) > n11) {
            object = (b)object.get(n11);
        } else {
            n10 = 0;
            object = null;
        }
        return object;
    }

    public Shader I0(float f10, float f11, float f12, float f13, b b10) {
        LinearGradient linearGradient = this.G0(b10);
        this.p0.reset();
        Matrix matrix = this.p0;
        matrix.postScale(f13 -= f12, 1.0f);
        this.p0.postTranslate(f12, 0.0f);
        matrix = this.p0;
        linearGradient.setLocalMatrix(matrix);
        return linearGradient;
    }

    public Rect K0(b b10) {
        int n10;
        int n11;
        Rect rect = super.t0(b10);
        float f10 = rect.left;
        rect.left = n11 = (int)this.D0(f10, b10);
        f10 = rect.right;
        rect.right = n10 = (int)this.E0(f10, b10);
        return rect;
    }

    public void T(Context object, AttributeSet attributeSet) {
        super.T((Context)object, attributeSet);
        if (object != null && attributeSet != null) {
            int[] nArray = R$styleable.EditorColorBar;
            attributeSet = object.obtainStyledAttributes(attributeSet, nArray);
            nArray = null;
            int n10 = -1;
            int n11 = attributeSet.getResourceId(0, n10);
            object = d.v.f.i.g.m(object, n11);
            this.W = object;
            attributeSet.recycle();
        }
    }

    public void V() {
        Paint paint;
        super.V();
        this.U = paint = new Paint();
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.U;
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        this.V = paint = new Paint();
        int n10 = this.f(2131099776);
        paint.setColor(n10);
        paint = this.V;
        float f10 = d.v.c.b2.p.R;
        paint.setTextSize(f10);
        this.V.setAntiAlias(bl2);
    }

    public void e0(int n10, int n11) {
        if (n10 == 0) {
            return;
        }
        Object object = (b)this.getSelectedData();
        if (object == null) {
            return;
        }
        long l10 = n10;
        long l11 = this.getTimeMinimum();
        float f10 = l10 * l11;
        float f11 = this.getLengthMinimum();
        l10 = (long)(f10 /= f11);
        int n12 = this.Y();
        long l12 = 500000L;
        if (n12 != 0) {
            int n13;
            long l13 = ((c)object).i() + l10;
            l10 = Math.min(((c)object).g() - l12, l13);
            l11 = 0L;
            l10 = Math.max(l11, l10);
            n12 = this.getSelectedRowIndex();
            b b10 = this.F0(n12, n13 = this.getSelectedColumnIndex() + -1);
            if (b10 != null) {
                l11 = b10.g();
                l10 = Math.max(l11, l10);
            }
            l11 = ((c)object).i();
            l11 = l10 - l11;
            ((c)object).m(l10);
        } else {
            int n14;
            long l14 = ((c)object).g() + l10;
            l10 = Math.max(((c)object).i() + l12, l14);
            l11 = this.getTotalTime();
            l10 = Math.min(l11, l10);
            n12 = this.getSelectedRowIndex();
            b b11 = this.F0(n12, n14 = this.getSelectedColumnIndex() + 1);
            if (b11 != null) {
                l11 = b11.i();
                l10 = Math.min(l11, l10);
            }
            l11 = ((c)object).g();
            l11 = l10 - l11;
            ((c)object).l(l10);
        }
        this.v0();
        this.postInvalidateOnAnimation();
        float f12 = l11;
        f10 = this.b();
        float f13 = n11;
        n11 = Math.round((f12 *= f10) * f13);
        this.l0(n11);
        object = new StringBuilder();
        ((StringBuilder)object).append("onDrag, offset:");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" newTimeOffset:");
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append(" scroll:");
        ((StringBuilder)object).append(n11);
        String string2 = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        a.b(string2, objectArray);
    }

    public void f0(int n10, int n11) {
        if (n10 == 0) {
            return;
        }
        Object object = (b)this.getSelectedData();
        if (object == null) {
            return;
        }
        long l10 = n10;
        long l11 = this.getTimeMinimum();
        float f10 = l10 * l11;
        float f11 = this.getLengthMinimum();
        l10 = (long)(f10 /= f11);
        l11 = 0L;
        if (n10 < 0) {
            int n12;
            long l12 = ((c)object).i() + l10;
            l10 = Math.max(l11, l12);
            int n13 = this.getSelectedRowIndex();
            b b10 = this.F0(n13, n12 = this.getSelectedColumnIndex() + -1);
            if (b10 != null) {
                l11 = b10.g();
                l10 = Math.max(l11, l10);
            }
            l11 = ((c)object).i();
            l11 = l10 - l11;
            l12 = ((c)object).g() + l11;
            ((c)object).l(l12);
            ((c)object).m(l10);
        } else if (n10 > 0) {
            int n14;
            l11 = ((c)object).g() + l10;
            l10 = Math.min(this.getTotalTime(), l11);
            int n15 = this.getSelectedRowIndex();
            b b11 = this.F0(n15, n14 = this.getSelectedColumnIndex() + 1);
            if (b11 != null) {
                l11 = b11.i();
                l10 = Math.min(l11, l10);
            }
            l11 = ((c)object).g();
            l11 = l10 - l11;
            long l13 = ((c)object).i() + l11;
            ((c)object).m(l13);
            ((c)object).l(l10);
        }
        this.v0();
        this.postInvalidateOnAnimation();
        float f12 = l11;
        f10 = this.b();
        float f13 = n11;
        n11 = Math.round((f12 *= f10) * f13);
        this.l0(n11);
        object = new StringBuilder();
        ((StringBuilder)object).append("onDragAttach, offset:");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" newTimeOffset:");
        ((StringBuilder)object).append(l11);
        ((StringBuilder)object).append(" scroll:");
        ((StringBuilder)object).append(n11);
        String string2 = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        a.b(string2, objectArray);
    }

    public List getData() {
        return this.k0;
    }

    public int getPracticalDataSize() {
        Object object = this.k0;
        int n10 = 0;
        if (object != null) {
            boolean bl2;
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                List list = (List)object.next();
                bl2 = this.x0(list);
                if (bl2) continue;
                ++n10;
            }
        }
        return n10;
    }

    public void l(Canvas canvas) {
        this.C0(canvas);
        this.z0(canvas);
    }

    public void s(Object object) {
    }

    public void setData(List list) {
        this.k0 = list;
        this.w0();
    }

    public void w0() {
        List list = this.k0;
        if (list != null) {
            int n10 = this.getHeight();
            float f10 = n10;
            int n11 = this.getPracticalDataSize() + -1;
            float f11 = (float)n11 * 10.0f;
            f10 = (f10 - f11) * 1.0f;
            int n12 = this.getPracticalDataSize();
            float f12 = n12;
            this.T = f10 /= f12;
        }
        this.v0();
    }

    public void y0(Canvas canvas, float f10, float f11, float f12, float f13, b b10, boolean bl2) {
        int n10;
        float f14;
        float f15;
        Object object = f12 == f13 ? 0 : (f12 > f13 ? 1 : -1);
        if (object >= 0) {
            return;
        }
        Object object2 = this.m;
        Object object3 = canvas;
        float f16 = f12;
        int n11 = canvas.saveLayer(f12, f10, f13, f11, object2);
        Paint paint = this.U;
        object3 = this;
        f16 = f10;
        object2 = b10;
        object3 = this.I0(f10, f11, f12, f13, b10);
        paint.setShader((Shader)object3);
        object = v0;
        float f17 = object;
        float f18 = object;
        Paint paint2 = this.U;
        paint = canvas;
        canvas.drawRoundRect(f12, f10, f13, f11, f17, f18, paint2);
        if (bl2 && (object = (f15 = (f14 = f13 - f12) - (f16 = (float)(n10 = r0))) == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1)) >= 0) {
            this.A0(canvas, f10, f11, f12, f13, b10);
        }
        object3 = canvas;
        canvas.restoreToCount(n11);
    }
}

