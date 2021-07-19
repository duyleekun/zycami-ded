/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.graphics.Typeface
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.NinePatchDrawable
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewConfiguration
 *  android.view.ViewParent
 *  android.widget.HorizontalScrollView
 */
package d.v.c.b2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.InverseBindingListener;
import com.zhiyun.cama.R$styleable;
import d.v.c.b2.e;
import d.v.c.b2.p$a;
import d.v.c.b2.p$b;
import d.v.c.b2.p$c;
import d.v.c.b2.r;
import d.v.c.b2.w.c;
import d.v.e.l.h2;
import d.v.e.l.j1;
import d.v.e.l.l2;
import m.a.a;

public abstract class p
extends r {
    public static final int O = 0;
    public static final int P = 255;
    public static final int Q = 0;
    public static final int R = 0;
    private static final float S = 0.25f;
    public float A;
    private boolean B;
    private boolean C;
    private boolean D;
    private p$b E;
    private p$c F;
    private d.v.c.b2.x.c G;
    private d.v.c.b2.x.c H;
    private View.OnClickListener I;
    private boolean J = true;
    private int K;
    private int L;
    private p$a M;
    private double N = 0.0;
    public final int f;
    public NinePatchDrawable g;
    private Drawable h;
    private Drawable i;
    public Paint j;
    public Paint k;
    public Paint l;
    public Paint m;
    private Rect n;
    private Rect o;
    public Rect p;
    private d.v.c.b2.w.e q;
    public boolean r;
    private boolean s;
    private boolean t;
    public d.v.c.b2.w.e u;
    private long v;
    public float w;
    public float x;
    public int y;
    public float z;

    static {
        O = h2.b(4.0f);
        Q = h2.g(10.0f);
        R = h2.g(12.0f);
    }

    public p(Context context) {
        super(context);
        this.f = 2131099859;
        this.i();
    }

    public p(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = 2131099859;
        this.T(context, attributeSet);
        this.i();
    }

    public p(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.f = 2131099859;
        this.T(context, attributeSet);
        this.i();
    }

    private void B() {
        this.M.m();
    }

    private void G() {
        int n10 = this.K;
        if (n10 != 0) {
            n10 = (int)(this.Z() ? 1 : 0);
            if (n10 != 0) {
                n10 = this.K;
                int n11 = this.L;
                this.e0(n10, n11);
            } else {
                n10 = (int)(this.a0() ? 1 : 0);
                if (n10 != 0) {
                    n10 = this.K;
                    int n12 = this.L;
                    this.f0(n10, n12);
                }
            }
        }
    }

    private void I(Canvas canvas) {
        int n10 = this.getWidth();
        int n11 = this.getPaddingLeft();
        n10 -= n11;
        n11 = this.getPaddingRight();
        float f10 = n10 - n11;
        float f11 = this.getHeight();
        RectF rectF = new RectF(0.0f, 0.0f, f10, f11);
        RectF rectF2 = this.c;
        f11 = rectF2.left;
        int n12 = O;
        float f12 = n12;
        f11 -= f12;
        f12 = rectF2.top;
        float f13 = rectF2.right;
        float f14 = n12;
        f10 = rectF2.bottom;
        rectF.intersect(f11, f12, f13 += f14, f10);
        f10 = n12;
        f11 = n12;
        Paint paint = this.l;
        canvas.drawRoundRect(rectF, f10, f11, paint);
    }

    private void K(Canvas canvas) {
    }

    private float O(float f10) {
        float f11 = d.v.c.b2.r.e[0];
        return f10 + f11;
    }

    public static d.v.c.b2.w.e P(p p10) {
        return p10.q;
    }

    private boolean W() {
        return this.J;
    }

    private boolean X() {
        return this.M.c();
    }

    public static /* synthetic */ void d0(InverseBindingListener inverseBindingListener, d.v.c.b2.w.e e10, View view) {
        inverseBindingListener.onChange();
    }

    private void g0() {
        this.m0();
        this.r = true;
        this.H();
    }

    private void i() {
        int n10;
        p$a p$a;
        this.M = p$a = new p$a(this);
        this.y = n10 = ViewConfiguration.get((Context)this.getContext()).getScaledTouchSlop();
        this.V();
        this.U();
    }

    private void m0() {
        ViewParent viewParent = this.getParent();
        if (viewParent != null) {
            viewParent = this.getParent();
            boolean bl2 = true;
            viewParent.requestDisallowInterceptTouchEvent(bl2);
        }
    }

    public static void n0(p p10, InverseBindingListener inverseBindingListener) {
        if (inverseBindingListener != null) {
            e e10 = new e(inverseBindingListener);
            p10.setOnItemSelectedBindingListener(e10);
        }
    }

    public static /* synthetic */ void p(p p10) {
        p10.G();
    }

    public static void p0(p p10, d.v.c.b2.w.e e10, d.v.c.b2.w.e e11) {
        p10.setSelectedItem(e11);
    }

    public static /* synthetic */ void q(p p10) {
        p10.g0();
    }

    private void q0() {
        this.M.k();
    }

    private int r0(float f10, float f11) {
        double d10;
        double d11 = this.N;
        double d12 = f11;
        this.N = d11 += d12;
        d12 = -1.0;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object > 0 && (object = (d10 = d11 - (d12 = 1.0)) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1)) < 0) {
            return 0;
        }
        object = (int)Math.floor(d11);
        d11 = this.N;
        double d14 = object;
        this.N = d11 -= d14;
        return (int)object;
    }

    private void setOnItemSelectedBindingListener(d.v.c.b2.x.c c10) {
        this.G = c10;
    }

    private void setSelectedItem(d.v.c.b2.w.e e10) {
        Object object;
        boolean bl2;
        String string2;
        boolean bl3;
        boolean bl4 = true;
        Object[] objectArray = null;
        if (e10 != null && (bl3 = e10.d())) {
            bl3 = false;
            string2 = null;
        } else {
            bl3 = bl4;
        }
        d.v.c.b2.w.e e11 = this.q;
        if (e11 != null && (bl2 = e11.d())) {
            bl4 = false;
            object = null;
        }
        if (!bl4 && bl3) {
            bl2 = this.Z();
            if (bl2) {
                this.j0();
                this.x();
            }
            if (bl2 = this.a0()) {
                this.k0();
                this.y();
            }
        }
        if (bl3 && bl4) {
            return;
        }
        object = this.q;
        if (e10 != object) {
            object = new StringBuilder();
            ((StringBuilder)object).append("setSelectedItem:");
            ((StringBuilder)object).append(e10);
            string2 = "   /";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(this);
            object = ((StringBuilder)object).toString();
            objectArray = new Object[]{};
            a.i((String)object, objectArray);
            this.q = e10;
            this.w0();
            this.postInvalidateOnAnimation();
            object = this.G;
            if (object != null) {
                object.a(e10, this);
            }
            if ((object = this.H) != null) {
                object.a(e10, this);
            }
        }
    }

    private void setSelectedItemAndCall(d.v.c.b2.w.e object) {
        this.setSelectedItem((d.v.c.b2.w.e)object);
        object = this.F;
        if (object != null) {
            c c10 = this.getSelectedData();
            object.a(c10, this);
        }
    }

    private void t(float f10) {
        p$b p$b = null;
        float f11 = f10 - 0.0f;
        Object object = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
        if (object != false && (p$b = this.E) != null) {
            int n10 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            boolean bl2 = this.D;
            p$b.a(n10, c10, f10, bl2);
        }
    }

    private void u(float f10) {
        float f11;
        float f12;
        p$b p$b = this.E;
        if (p$b != null && (f12 = (f11 = f10 - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            f12 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            p$b.e((int)f12, c10, f10);
        }
    }

    private void v() {
        p$b p$b = this.E;
        if (p$b != null) {
            int n10 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            boolean bl2 = this.D;
            p$b.c(n10, c10, bl2);
        }
    }

    private void w() {
        p$b p$b = this.E;
        if (p$b != null) {
            int n10 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            p$b.d(n10, c10);
        }
    }

    private void x() {
        p$b p$b = this.E;
        if (p$b != null) {
            int n10 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            boolean bl2 = this.D;
            p$b.b(n10, c10, bl2);
        }
    }

    private void y() {
        p$b p$b = this.E;
        if (p$b != null) {
            int n10 = this.getSelectedColumnIndex();
            c c10 = this.getSelectedData();
            p$b.f(n10, c10);
        }
    }

    public boolean A() {
        return false;
    }

    public abstract d.v.c.b2.w.e C(float var1, float var2);

    public abstract Object D(float var1, float var2);

    public void E() {
        this.setSelectedItem(null);
    }

    public void F() {
        this.setSelectedItemAndCall(null);
    }

    public void H() {
        this.i0();
        this.w();
        float f10 = this.z;
        this.z = f10 = this.O(f10);
    }

    public void J(Canvas canvas) {
        NinePatchDrawable ninePatchDrawable;
        Rect rect = this.p;
        if (rect != null && (ninePatchDrawable = this.g) != null) {
            ninePatchDrawable.setBounds(rect);
            rect = this.g;
            rect.draw(canvas);
        }
        if ((rect = this.n) != null && (ninePatchDrawable = this.h) != null) {
            ninePatchDrawable.setBounds(rect);
            rect = this.h;
            rect.draw(canvas);
        }
        if ((rect = this.o) != null && (ninePatchDrawable = this.i) != null) {
            ninePatchDrawable.setBounds(rect);
            rect = this.i;
            rect.draw(canvas);
        }
    }

    public void L(String string2, float f10, float f11, Paint paint, Canvas canvas) {
        j1.a(string2, f10, f11, paint, canvas);
    }

    public void M(String string2, float f10, float f11, Paint paint, Canvas canvas, float f12) {
        j1.b(string2, f10, f11, paint, canvas, f12);
    }

    public int N(float f10) {
        f10 = Math.abs(this.getHalfScreenWidth() - f10);
        float f11 = this.getHalfScreenWidth();
        float f12 = this.getLimitRect();
        f10 -= (f11 -= f12);
        f11 = this.getLimitRect();
        f10 /= f11;
        f11 = this.getLimitOffsetMax();
        return (int)(f10 * f11);
    }

    public String Q(long l10) {
        return this.R(l10, 2);
    }

    public String R(long l10, int n10) {
        float f10 = l2.a(l10, n10);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(f10);
        stringBuilder.append("S");
        return stringBuilder.toString();
    }

    public boolean S() {
        boolean bl2;
        c c10 = this.getSelectedData();
        if (c10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            c10 = null;
        }
        return bl2;
    }

    public void T(Context context, AttributeSet attributeSet) {
        if (context != null && attributeSet != null) {
            int[] nArray = R$styleable.EditorBeDragView;
            context = context.obtainStyledAttributes(attributeSet, nArray);
            attributeSet = context.getDrawable(0);
            this.h = attributeSet;
            attributeSet = context.getDrawable(1);
            this.i = attributeSet;
            int n10 = 2;
            attributeSet = context.getDrawable(n10);
            boolean bl2 = attributeSet instanceof NinePatchDrawable;
            if (bl2) {
                attributeSet = (NinePatchDrawable)attributeSet;
                this.g = attributeSet;
            }
            context.recycle();
        }
    }

    public void U() {
    }

    public void V() {
        Paint paint;
        this.l = paint = new Paint();
        Paint.Style style2 = Paint.Style.FILL;
        paint.setStyle(style2);
        paint = this.l;
        boolean bl2 = true;
        paint.setAntiAlias(bl2);
        paint = this.l;
        int n10 = this.f(2131099859);
        paint.setColor(n10);
        this.m = paint = new Paint();
        Paint.Style style3 = Paint.Style.FILL;
        paint.setStyle(style3);
        this.m.setAntiAlias(bl2);
        paint = ResourcesCompat.getFont(this.getContext(), 2131296257);
        style3 = new Paint();
        this.j = style3;
        int n11 = -1;
        style3.setColor(n11);
        style3 = this.j;
        float f10 = Q;
        style3.setTextSize(f10);
        this.j.setTypeface((Typeface)paint);
        this.j.setAntiAlias(bl2);
        this.k = paint = new Paint();
        paint.setColor(n11);
        paint = this.k;
        float f11 = R;
        paint.setTextSize(f11);
        this.k.setAntiAlias(bl2);
    }

    public boolean Y() {
        return this.D;
    }

    public boolean Z() {
        return this.B;
    }

    public boolean a0() {
        return this.C;
    }

    public boolean b0(float f10) {
        float f11;
        int n10;
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0 && (n10 = (f11 = f10 - (f12 = this.getLimitRect())) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) <= 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public boolean c0(float f10) {
        float f11;
        float f12;
        int n10;
        float f13 = this.b;
        float f14 = f10 - f13;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object < 0 && (n10 = (f12 = f10 - (f13 -= (f11 = this.getLimitRect()))) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) >= 0) {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        } else {
            n10 = 0;
            f10 = 0.0f;
        }
        return n10 != 0;
    }

    public void d(Canvas canvas) {
        this.I(canvas);
        this.l(canvas);
        this.K(canvas);
        this.J(canvas);
    }

    public void e0(int n10, int n11) {
    }

    public void f0(int n10, int n11) {
    }

    public float getHalfScreenWidth() {
        return this.b / 2.0f;
    }

    public float getLimitOffsetMax() {
        return this.getLimitRect() / 2.0f;
    }

    public float getLimitRect() {
        return this.b * 0.25f;
    }

    public View.OnClickListener getOnClickEmptyListener() {
        return this.I;
    }

    public p$b getOnDragListener() {
        return this.E;
    }

    public p$c getOnItemClickListener() {
        return this.F;
    }

    public int getSelectedColumnIndex() {
        d.v.c.b2.w.e e10 = this.q;
        int n10 = e10 == null ? -1 : e10.b();
        return n10;
    }

    public c getSelectedData() {
        Object object = this.q;
        object = object == null ? null : (c)((d.v.c.b2.w.e)object).a();
        return object;
    }

    public int getSelectedRowIndex() {
        d.v.c.b2.w.e e10 = this.q;
        int n10 = e10 == null ? -1 : e10.c();
        return n10;
    }

    public void h0() {
        this.B = true;
        this.o0(0, 0);
    }

    public void i0() {
        this.C = true;
        this.o0(0, 0);
    }

    public void j0() {
        this.B = false;
        this.o0(0, 0);
    }

    public void k0() {
        this.C = false;
        this.o0(0, 0);
    }

    public void l0(int n10) {
        HorizontalScrollView horizontalScrollView;
        if (n10 != 0 && (horizontalScrollView = this.getParentScrollViewGroup()) != null) {
            horizontalScrollView.scrollBy(n10, 0);
        }
    }

    public void o0(int n10, int n11) {
        this.K = n10;
        this.L = n11;
        if (n10 != 0) {
            p$a p$a = this.M;
            p$a.l();
        } else {
            p$a p$a = this.M;
            p$a.n();
        }
    }

    public void onSizeChanged(int n10, int n11, int n12, int n13) {
        super.onSizeChanged(n10, n11, n12, n13);
        this.w0();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean onTouchEvent(MotionEvent var1_1) {
        block35: {
            block37: {
                block36: {
                    block34: {
                        this.n();
                        var2_2 = var1_1.getX();
                        var3_3 = this.getPaddingLeft();
                        var4_4 = var3_3;
                        var2_2 -= var4_4;
                        var4_4 = var1_1.getY();
                        var5_5 = this.getPaddingTop();
                        var4_4 -= var5_5;
                        var6_6 = var1_1.getAction();
                        var7_7 = 0;
                        var8_8 = 0.0f;
                        var9_9 = null;
                        var10_10 = 0;
                        var11_11 = 1;
                        var12_12 = 1.4E-45f;
                        if (var6_6 == 0) break block34;
                        if (var6_6 != var11_11) {
                            var7_7 = 2;
                            var8_8 = 2.8E-45f;
                            if (var6_6 != var7_7) {
                                var7_7 = 3;
                                var8_8 = 4.2E-45f;
                                if (var6_6 == var7_7) {
                                    this.B();
                                    this.s = false;
                                    this.t = false;
                                    this.u = null;
                                    var6_6 = (int)this.Z();
                                    if (var6_6 != 0) {
                                        this.j0();
                                        this.x();
                                    } else {
                                        var6_6 = (int)this.a0();
                                        if (var6_6 != 0) {
                                            this.k0();
                                            this.y();
                                        }
                                    }
                                }
                            } else {
                                var6_6 = (int)this.Z();
                                if (var6_6 != 0) {
                                    var2_2 = this.O(var2_2);
                                    this.s0(var2_2);
                                    var5_5 = this.z;
                                    var5_5 = var2_2 - var5_5;
                                    var6_6 = this.r0(var2_2, var5_5);
                                    if (var6_6 != 0) {
                                        var8_8 = var6_6;
                                        var10_10 = this.u0(var2_2, var8_8);
                                        this.e0(var6_6, var10_10);
                                        this.t(var8_8);
                                    }
                                } else {
                                    var6_6 = (int)this.a0();
                                    if (var6_6 != 0) {
                                        var2_2 = this.O(var2_2);
                                        this.s0(var2_2);
                                        var5_5 = this.z;
                                        var5_5 = var2_2 - var5_5;
                                        var6_6 = this.r0(var2_2, var5_5);
                                        if (var6_6 != 0) {
                                            var8_8 = var6_6;
                                            var10_10 = this.u0(var2_2, var8_8);
                                            this.f0(var6_6, var10_10);
                                            this.u(var8_8);
                                        }
                                    } else {
                                        var6_6 = (int)this.X();
                                        if (var6_6 != 0) {
                                            var5_5 = this.w;
                                            cfr_temp_0 = (var5_5 = Math.abs(var2_2 - var5_5)) - (var8_8 = (float)(var7_7 = this.y));
                                            var6_6 = (int)(cfr_temp_0 == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1));
                                            if (var6_6 > 0) {
                                                this.B();
                                            }
                                        }
                                    }
                                }
                            }
                        } else {
                            this.B();
                            this.s = false;
                            this.t = false;
                            this.u = null;
                            var6_6 = (int)this.Z();
                            if (var6_6 != 0) {
                                this.j0();
                                this.x();
                            } else {
                                var6_6 = (int)this.a0();
                                if (var6_6 != 0) {
                                    this.k0();
                                    this.y();
                                } else {
                                    var6_6 = (int)this.r;
                                    if (var6_6 == 0 && (var6_6 = (cfr_temp_1 = var2_2 - 0.0f) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1)) >= 0) {
                                        var6_6 = this.getWidth();
                                        var7_7 = this.getPaddingLeft();
                                        var6_6 -= var7_7;
                                        var7_7 = this.getPaddingRight();
                                        var5_5 = var6_6 - var7_7;
                                        cfr_temp_2 = var2_2 - var5_5;
                                        if ((var6_6 = (int)(cfr_temp_2 == 0.0f ? 0 : (cfr_temp_2 < 0.0f ? -1 : 1))) <= 0) {
                                            var13_13 /* !! */  = this.p;
                                            if (var13_13 /* !! */  != null && (var6_6 = (int)var13_13 /* !! */ .contains(var7_7 = (int)var2_2, var10_10 = (int)var4_4)) != 0) {
                                                this.F();
                                            } else {
                                                var13_13 /* !! */  = this.D(var2_2, var4_4);
                                                if (var13_13 /* !! */  != null) {
                                                    this.s(var13_13 /* !! */ );
                                                } else {
                                                    var13_13 /* !! */  = this.C(var2_2, var4_4);
                                                    if (var13_13 /* !! */  != null) {
                                                        this.setSelectedItemAndCall((d.v.c.b2.w.e)var13_13 /* !! */ );
                                                        var13_13 /* !! */  = new Object[]{};
                                                        var9_9 = "\u9009\u4e2d";
                                                        a.b(var9_9, (Object[])var13_13 /* !! */ );
                                                    } else {
                                                        var6_6 = (int)this.W();
                                                        if (var6_6 != 0) {
                                                            this.r();
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        ** GOTO lbl167
                    }
                    this.s = false;
                    this.t = false;
                    this.u = null;
                    this.r = false;
                    this.w = var2_2;
                    this.x = var4_4;
                    var6_6 = (int)this.Z();
                    if (var6_6 != 0 || (var6_6 = (int)this.a0()) != 0) ** GOTO lbl167
                    this.v = var14_15 = System.currentTimeMillis();
                    var6_6 = (int)this.S();
                    if (var6_6 == 0) break block35;
                    var13_14 /* !! */  = this.n;
                    if (var13_14 /* !! */  == null || (var6_6 = (int)var13_14 /* !! */ .contains(var10_10 = (int)var2_2, var16_16 = (int)var4_4)) == 0) break block36;
                    this.D = var11_11;
                    this.h0();
                    this.v();
                    this.m0();
                    var2_2 = this.O(var2_2);
                    ** GOTO lbl167
                }
                var13_14 /* !! */  = this.o;
                if (var13_14 /* !! */  == null || (var6_6 = (int)var13_14 /* !! */ .contains(var10_10 = (int)var2_2, var16_16 = (int)var4_4)) == 0) break block37;
                this.D = false;
                this.h0();
                this.v();
                this.m0();
                var2_2 = this.O(var2_2);
                ** GOTO lbl167
            }
            var13_14 /* !! */  = this.p;
            if (var13_14 /* !! */  == null || (var6_6 = (int)var13_14 /* !! */ .contains(var10_10 = (int)var2_2, var16_16 = (int)var4_4)) == 0 || (var6_6 = (int)this.z()) == 0) break block35;
            this.s = var11_11;
            this.q0();
            ** GOTO lbl167
        }
        if ((var6_6 = (int)((cfr_temp_3 = var2_2 - 0.0f) == 0.0f ? 0 : (cfr_temp_3 > 0.0f ? 1 : -1))) < 0) ** GOTO lbl172
        var6_6 = this.getWidth();
        var7_7 = this.getPaddingLeft();
        var6_6 -= var7_7;
        var7_7 = this.getPaddingRight();
        var5_5 = var6_6 - var7_7;
        cfr_temp_4 = var2_2 - var5_5;
        if ((var6_6 = (int)(cfr_temp_4 == 0.0f ? 0 : (cfr_temp_4 < 0.0f ? -1 : 1))) > 0) ** GOTO lbl172
        var13_14 /* !! */  = this.D(var2_2, var4_4);
        if (var13_14 /* !! */  != null) ** GOTO lbl167
        var13_14 /* !! */  = this.C(var2_2, var4_4);
        if (var13_14 /* !! */  != null) {
            this.t = var11_11;
            this.u = var13_14 /* !! */ ;
            var6_6 = (int)this.A();
            if (var6_6 != 0) {
                this.q0();
            }
lbl167:
            // 20 sources

            while (true) {
                var6_6 = var11_11;
                var5_5 = var12_12;
                break;
            }
        } else {
            if ((var6_6 = (int)this.W()) != 0) ** continue;
lbl172:
            // 3 sources

            var6_6 = 0;
            var13_14 /* !! */  = null;
            var5_5 = 0.0f;
        }
        this.z = var2_2;
        this.A = var4_4;
        if (var6_6 == 0 && !(var17_17 = super.onTouchEvent(var1_1))) {
            var11_11 = 0;
            var12_12 = 0.0f;
        }
        return (boolean)var11_11;
    }

    public void r() {
        View.OnClickListener onClickListener = this.I;
        if (onClickListener != null) {
            onClickListener.onClick((View)this);
        }
    }

    public abstract void s(Object var1);

    /*
     * Unable to fully structure code
     */
    public void s0(float var1_1) {
        var2_2 = this.getPaddingLeft();
        var1_1 += var2_2;
        var3_3 = this.Z();
        var4_4 = 1;
        var5_5 = 0;
        if (!var3_3 && !(var3_3 = this.a0())) ** GOTO lbl-1000
        var3_3 = this.b0(var1_1);
        if (var3_3) {
            var6_6 = this.N(var1_1);
            var5_5 = -var6_6;
        } else {
            var3_3 = this.c0(var1_1);
            if (var3_3) {
                var5_5 = this.N(var1_1);
            } else lbl-1000:
            // 2 sources

            {
                var4_4 = 0;
            }
        }
        this.o0(var5_5, var4_4);
    }

    public void setCanClickEmpty(boolean bl2) {
        this.J = bl2;
    }

    public void setOnClickEmptyListener(View.OnClickListener onClickListener) {
        this.I = onClickListener;
    }

    public void setOnDragListener(p$b p$b) {
        this.E = p$b;
    }

    public void setOnItemClickListener(p$c p$c) {
        this.F = p$c;
    }

    public void setOnItemSelectedListener(d.v.c.b2.x.c c10) {
        this.H = c10;
    }

    public Rect t0(c c10) {
        if (c10 == null) {
            boolean bl2 = false;
            float f10 = 0.0f;
            c10 = null;
        } else {
            long l10 = c10.i();
            float f11 = l10;
            float f12 = this.b();
            int n10 = (int)(f11 *= f12);
            f12 = 0.0f;
            long l11 = c10.g();
            float f13 = l11;
            float f14 = this.b();
            int n11 = (int)(f13 *= f14);
            int n12 = this.getHeight();
            Rect rect = new Rect(n10, 0, n11, n12);
            c10 = rect;
        }
        return c10;
    }

    public int u0(float f10, float f11) {
        return 0;
    }

    public void v0() {
        int n10 = this.S();
        if (n10 == 0) {
            n10 = 0;
            Object var2_2 = null;
            this.p = null;
            this.n = null;
            this.o = null;
        } else {
            c c10 = this.getSelectedData();
            c10 = this.t0(c10);
            this.p = c10;
            if (c10 != null) {
                Rect rect;
                n10 = this.h.getIntrinsicWidth();
                int n11 = this.h.getIntrinsicHeight();
                int n12 = (this.getHeight() - n11) / 2;
                int n13 = this.p.left;
                n10 = n13 - n10;
                this.n = rect = new Rect(n10, n12, n13, n11 += n12);
                c10 = this.i;
                n10 = c10.getIntrinsicWidth();
                Drawable drawable2 = this.i;
                n11 = drawable2.getIntrinsicHeight();
                n12 = (this.getHeight() - n11) / 2;
                Rect rect2 = this.p;
                n13 = rect2.right;
                this.o = rect = new Rect(n13, n12, n10 += n13, n11 += n12);
            }
        }
    }

    public abstract void w0();

    public boolean z() {
        return true;
    }
}

