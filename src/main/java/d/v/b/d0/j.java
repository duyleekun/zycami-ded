/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Canvas
 *  android.graphics.Paint
 *  android.graphics.Paint$Style
 *  android.graphics.drawable.Drawable
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.AttributeSet
 *  android.util.SparseArray
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewPropertyAnimator
 *  android.widget.FrameLayout
 *  android.widget.SeekBar
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package d.v.b.d0;

import android.animation.Animator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import androidx.core.content.ContextCompat;
import com.zhiyun.android.R$drawable;
import com.zhiyun.android.R$id;
import com.zhiyun.android.R$layout;
import d.v.b.c0.e$a;
import d.v.b.d0.b;
import d.v.b.d0.c;
import d.v.b.d0.d;
import d.v.b.d0.e;
import d.v.b.d0.f;
import d.v.b.d0.g;
import d.v.b.d0.h;
import d.v.b.d0.i;
import d.v.b.d0.j$a;
import d.v.b.d0.j$b;
import d.v.b.d0.j$d;
import d.v.b.d0.j$e;
import d.v.b.d0.k.k;
import d.v.b.d0.k.l;

public class j
extends FrameLayout
implements i {
    private View a;
    private View b;
    private ScaleGestureDetector c;
    private GestureDetector d;
    private SeekBar e;
    private Drawable f;
    private Drawable g;
    private Paint h;
    private final SparseArray i;
    private d.v.b.d0.k.i j;
    private d.v.b.d0.k.j k;
    private d.v.b.d0.k.h l;
    private d.v.b.d0.k.e m;
    private l n;
    private d.v.b.d0.k.g o;
    private k p;
    private final Handler q;
    private final Runnable r;
    private final Runnable s;

    public j(Context context) {
        this(context, null);
    }

    public j(Context context, AttributeSet object) {
        super(context, object);
        super();
        this.i = object;
        Looper looper = Looper.getMainLooper();
        super(looper);
        this.q = object;
        super(this);
        this.r = object;
        super(this);
        this.s = object;
        this.setWillNotDraw(false);
        this.x();
        this.u(context);
        this.v();
        this.n();
    }

    private /* synthetic */ void B(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gird color change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.h;
        int n12 = n10;
        stringBuilder.setColor(n12);
        this.postInvalidate();
    }

    private /* synthetic */ void D(Integer n10, int n11) {
        int n12 = n10;
        this.S(n12);
    }

    private /* synthetic */ void F(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mask value change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.e;
        n11 = stringBuilder.getMax();
        Integer n12 = (Integer)this.n.f();
        int n13 = n12;
        Integer n14 = (Integer)this.n.e();
        int n15 = n14;
        if (n11 != (n13 -= n15)) {
            this.w();
            return;
        }
        stringBuilder = this.e;
        int n16 = n10;
        n13 = (Integer)this.n.e();
        stringBuilder.setProgress(n16 -= n13);
    }

    private /* synthetic */ void H() {
        SeekBar seekBar = this.e;
        l l10 = this.n;
        int n10 = l10.j();
        if (n10 != 0) {
            n10 = 0;
            l10 = null;
        } else {
            n10 = 8;
        }
        seekBar.setVisibility(n10);
    }

    private /* synthetic */ void J(Drawable drawable2) {
        this.e.setProgressDrawable(drawable2);
    }

    private /* synthetic */ void L(int n10) {
        View view = this.b;
        float f10 = -n10 + -180;
        view.setRotation(f10);
        this.postInvalidate();
    }

    private void N() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("set seek bar show max=");
        int n10 = this.e.getMax();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",mMaskValue.isSupport()=");
        l l10 = this.n;
        n10 = (int)(l10.j() ? 1 : 0);
        ((StringBuilder)object).append(n10 != 0);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.n;
        boolean bl2 = ((d.v.b.c0.b)object).j();
        if (!bl2) {
            this.e.setVisibility(8);
            return;
        }
        this.e.setVisibility(0);
        object = this.e;
        n10 = (Integer)this.n.get();
        int n11 = (Integer)this.n.e();
        object.setProgress(n10 -= n11);
    }

    private void O(View view, float f10) {
        view.setAlpha(f10);
    }

    private void P(View view, int n10) {
        view.setVisibility(n10);
    }

    private void R(float f10, float f11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("show Focus mx=");
        stringBuilder.append(f10);
        d.v.d.h.f.a(stringBuilder.toString());
        stringBuilder = this.q;
        Runnable runnable = this.s;
        stringBuilder.removeCallbacks(runnable);
        stringBuilder = this.q;
        runnable = this.r;
        stringBuilder.removeCallbacks(runnable);
        int n10 = (Integer)this.o.get();
        this.S(n10);
        stringBuilder = this.a;
        this.O((View)stringBuilder, 1.0f);
        stringBuilder = this.a;
        this.P((View)stringBuilder, 0);
        this.setLineShow(false);
        this.N();
        float f12 = this.a.getWidth() / 2;
        int n11 = (int)(f10 - f12);
        f12 = this.a.getHeight() / 2;
        int n12 = (int)(f11 - f12);
        stringBuilder = this.a;
        f10 = n11;
        stringBuilder.setTranslationX(f10);
        View view = this.a;
        f11 = n12;
        view.setTranslationY(f11);
        this.t();
        this.o();
    }

    private void S(int n10) {
        Handler handler = this.q;
        g g10 = new g(this, n10);
        handler.post((Runnable)g10);
    }

    public static /* synthetic */ void b(j j10, float f10, float f11) {
        j10.R(f10, f11);
    }

    public static /* synthetic */ d.v.b.d0.k.e c(j j10) {
        return j10.m;
    }

    public static /* synthetic */ d.v.b.d0.k.j d(j j10) {
        return j10.k;
    }

    public static /* synthetic */ void e(j j10, boolean bl2) {
        j10.setLineShow(bl2);
    }

    public static /* synthetic */ Runnable f(j j10) {
        return j10.s;
    }

    public static /* synthetic */ Handler g(j j10) {
        return j10.q;
    }

    public static /* synthetic */ Runnable h(j j10) {
        return j10.r;
    }

    public static /* synthetic */ void i(j j10, float f10) {
        j10.setMaskAlpha(f10);
    }

    public static /* synthetic */ View j(j j10) {
        return j10.a;
    }

    public static /* synthetic */ l k(j j10) {
        return j10.n;
    }

    public static /* synthetic */ void l(j j10, View view, int n10) {
        j10.P(view, n10);
    }

    private void m(int n10, d.v.b.c0.b b10) {
        this.i.append(n10, (Object)b10);
    }

    private void n() {
        d.v.d.h.f.a("create Mask parameter and register listener");
        d.v.b.c0.b b10 = new d.v.b.d0.k.h();
        this.l = b10;
        this.m(1, b10);
        b10 = this.l;
        e$a e$a = new h(this);
        b10.h(e$a);
        b10 = new d.v.b.d0.k.f();
        this.m(2, b10);
        e$a = new f(this);
        b10.h(e$a);
        b10 = new d.v.b.d0.k.d((View)this);
        this.m(3, b10);
        b10 = new d.v.b.d0.k.g();
        this.o = b10;
        this.m(4, b10);
        b10 = this.o;
        e$a = new b(this);
        b10.h(e$a);
        b10 = new d.v.b.d0.k.i();
        this.j = b10;
        this.m(8, b10);
        b10 = new d.v.b.d0.k.j();
        this.k = b10;
        this.m(9, b10);
        b10 = new d.v.b.d0.k.e();
        this.m = b10;
        this.m(10, b10);
        b10 = new l();
        this.n = b10;
        this.m(11, b10);
        b10 = this.n;
        e$a = new d(this);
        b10.h(e$a);
        b10 = new k();
        this.p = b10;
        this.m(12, b10);
    }

    private void o() {
        ViewPropertyAnimator viewPropertyAnimator = this.a.animate().alpha(0.4f).setStartDelay(750L).setDuration(1500L);
        j$a j$a = new j$a(this);
        viewPropertyAnimator.setListener((Animator.AnimatorListener)j$a);
    }

    private void p(Canvas canvas) {
        float f10 = this.p.o();
        float f11 = 1.0f;
        float f12 = 3.0f;
        float f13 = (f10 *= f11) / f12;
        float f14 = this.p.p();
        float f15 = (float)this.p.o() * f11 / f12;
        Paint paint = this.h;
        canvas.drawLine(0.0f, f13, f14, f15, paint);
        f13 = (float)(this.p.o() * 2) * f11 / f12;
        f14 = this.p.p();
        f15 = (float)(this.p.o() * 2) * f11 / f12;
        paint = this.h;
        canvas.drawLine(0.0f, f13, f14, f15, paint);
        float f16 = (float)this.p.p() * f11 / f12;
        f14 = (float)this.p.p() * f11 / f12;
        f15 = this.p.o();
        paint = this.h;
        canvas.drawLine(f16, 0.0f, f14, f15, paint);
        f16 = (float)(this.p.p() * 2) * f11 / f12;
        f14 = (float)(this.p.p() * 2) * f11 / f12;
        f15 = this.p.o();
        paint = this.h;
        canvas.drawLine(f16, 0.0f, f14, f15, paint);
    }

    private void q(Canvas canvas) {
        float f10 = this.p.p();
        float f11 = 1.0f;
        f10 *= f11;
        float f12 = 2.0f;
        float f13 = (float)this.p.o() * f11 / f12;
        Paint paint = this.h;
        canvas.drawCircle(f10 /= f12, f13, 35.0f, paint);
    }

    private void r(Canvas canvas) {
        int n10;
        Integer n11 = (Integer)this.l.get();
        int n12 = n11;
        if (n12 != (n10 = 1)) {
            n10 = 2;
            if (n12 != n10) {
                n10 = 3;
                if (n12 != n10) {
                    n10 = 4;
                    if (n12 == n10) {
                        this.s(canvas);
                    }
                } else {
                    this.q(canvas);
                }
            } else {
                this.p(canvas);
                this.s(canvas);
            }
        } else {
            this.p(canvas);
        }
    }

    private void s(Canvas canvas) {
        float f10 = this.p.p();
        float f11 = this.p.o();
        Paint paint = this.h;
        canvas.drawLine(0.0f, 0.0f, f10, f11, paint);
        float f12 = this.p.p();
        f11 = this.p.o();
        paint = this.h;
        canvas.drawLine(f12, 0.0f, 0.0f, f11, paint);
    }

    private void setLineShow(boolean bl2) {
        Object object;
        Drawable drawable2 = bl2 ? this.f : this.g;
        boolean bl3 = drawable2.equals(object = this.e.getProgressDrawable());
        if (bl3) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("set line show =");
        ((StringBuilder)object).append(bl2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        Handler handler = this.q;
        object = new c(this, drawable2);
        handler.post((Runnable)object);
    }

    private void setMaskAlpha(float f10) {
        this.a.setAlpha(f10);
    }

    private void setViewScale(View view) {
        float f10 = 1.5f;
        view.setScaleX(f10);
        view.setScaleY(f10);
    }

    private void t() {
        View view = this.b;
        this.setViewScale(view);
        view = this.b;
        this.O(view, 0.6f);
        view = this.b.animate();
        float f10 = 1.0f;
        view.scaleX(f10).scaleY(f10).alpha(f10).setDuration(400L);
    }

    private void u(Context context) {
        GestureDetector gestureDetector;
        Object object = new j$e(this, null);
        this.d = gestureDetector = new GestureDetector(context, (GestureDetector.OnGestureListener)object);
        object = new j$d(this, null);
        gestureDetector = new ScaleGestureDetector(context, (ScaleGestureDetector.OnScaleGestureListener)object);
        this.c = gestureDetector;
        int n10 = R$drawable.ae_sun;
        gestureDetector = ContextCompat.getDrawable(context, n10);
        this.f = gestureDetector;
        n10 = R$drawable.ae_sun_tran;
        context = ContextCompat.getDrawable(context, n10);
        this.g = context;
    }

    private void v() {
        Paint paint;
        this.h = paint = new Paint();
        paint.setColor(-1);
        paint = this.h;
        Paint.Style style2 = Paint.Style.STROKE;
        paint.setStyle(style2);
        this.h.setStrokeWidth(3.0f);
        this.h.setAntiAlias(true);
    }

    private void w() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("init seek bar is support =");
        Object object2 = this.n.toString();
        ((StringBuilder)object).append((String)object2);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.e;
        object2 = new e(this);
        object.post((Runnable)object2);
        object = this.n;
        boolean bl2 = ((d.v.b.c0.b)object).j();
        if (!bl2) {
            return;
        }
        object = this.e;
        int n10 = (Integer)this.n.f();
        int n11 = (Integer)this.n.e();
        object.setMax(n10 -= n11);
        object = new StringBuilder();
        ((StringBuilder)object).append("init seek bar max =");
        n10 = this.e.getMax();
        ((StringBuilder)object).append(n10);
        d.v.d.h.f.a(((StringBuilder)object).toString());
        object = this.e;
        object2 = new j$b(this);
        object.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)object2);
    }

    private void x() {
        LayoutInflater layoutInflater = LayoutInflater.from((Context)this.getContext());
        int n10 = R$layout.layout_focus_marker;
        layoutInflater.inflate(n10, (ViewGroup)this);
        int n11 = R$id.focusContainer;
        layoutInflater = this.findViewById(n11);
        this.a = layoutInflater;
        n11 = R$id.focusLayout;
        layoutInflater = this.findViewById(n11);
        this.b = layoutInflater;
        n11 = R$id.aeSun;
        layoutInflater = (SeekBar)this.findViewById(n11);
        this.e = layoutInflater;
        this.setMaskAlpha(0.0f);
    }

    public static /* synthetic */ void y(j j10) {
        j10.o();
    }

    private /* synthetic */ void z(Integer n10, int n11) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gird change integer=");
        stringBuilder.append(n10);
        d.v.d.h.f.a(stringBuilder.toString());
        this.postInvalidate();
    }

    public /* synthetic */ void A(Integer n10, int n11) {
        this.z(n10, n11);
    }

    public /* synthetic */ void C(Integer n10, int n11) {
        this.B(n10, n11);
    }

    public /* synthetic */ void E(Integer n10, int n11) {
        this.D(n10, n11);
    }

    public /* synthetic */ void G(Integer n10, int n11) {
        this.F(n10, n11);
    }

    public /* synthetic */ void I() {
        this.H();
    }

    public /* synthetic */ void K(Drawable drawable2) {
        this.J(drawable2);
    }

    public /* synthetic */ void M(int n10) {
        this.L(n10);
    }

    public void Q() {
        Handler handler = this.q;
        Runnable runnable = this.s;
        handler.removeCallbacks(runnable);
        int n10 = (Integer)this.o.get();
        this.S(n10);
        handler = this.a;
        this.O((View)handler, 1.0f);
        handler = this.a;
        this.P((View)handler, 0);
        this.setLineShow(false);
        this.N();
        n10 = Resources.getSystem().getDisplayMetrics().widthPixels / 2;
        int n11 = this.a.getWidth() / 2;
        n10 -= n11;
        n11 = Resources.getSystem().getDisplayMetrics().heightPixels / 2;
        int n12 = this.a.getHeight() / 2;
        View view = this.a;
        float f10 = n10;
        view.setTranslationX(f10);
        handler = this.a;
        float f11 = n11 -= n12;
        handler.setTranslationY(f11);
        this.o();
    }

    public d.v.b.c0.e a(int n10) {
        return (d.v.b.c0.e)this.i.get(n10);
    }

    public View getView() {
        return this;
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.q.removeCallbacksAndMessages(null);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.r(canvas);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int n10;
        int n11 = motionEvent.getPointerCount();
        if (n11 > (n10 = 1)) {
            ScaleGestureDetector scaleGestureDetector = this.c;
            scaleGestureDetector.onTouchEvent(motionEvent);
        } else {
            GestureDetector gestureDetector = this.d;
            gestureDetector.onTouchEvent(motionEvent);
        }
        this.j.o(motionEvent);
        return n10 != 0;
    }

    public void release() {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = this.i).size()); ++i10) {
            object = (d.v.b.c0.e)this.i.valueAt(i10);
            object.b();
        }
    }
}

