/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.View$OnClickListener
 *  android.view.View$OnTouchListener
 *  android.widget.ImageButton
 *  android.widget.PopupWindow
 *  android.widget.PopupWindow$OnDismissListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.speed;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.zhiyun.cama.data.api.entity.speed.CurveTemp$CurveTempBean;
import com.zhiyun.cama.speed.CurveTempAdapter;
import com.zhiyun.cama.speed.EditorSpeedFragment$a;
import com.zhiyun.cama.speed.EditorSpeedFragment$b;
import com.zhiyun.cama.widget.CurveView;
import com.zhiyun.cama.widget.CurveView$a;
import d.v.c.i1.i2;
import d.v.c.k1.a.r;
import d.v.c.k1.a.s;
import d.v.c.s1.a;
import d.v.c.s1.c;
import d.v.c.s1.e;
import d.v.c.s1.f;
import d.v.c.s1.i;
import d.v.c.s1.k;
import d.v.c.s1.l;
import d.v.c.s1.m;
import d.v.c.s1.n;
import d.v.c.s1.o;
import d.v.c.s1.p;
import d.v.c.s1.t;
import d.v.c.s1.u;
import d.v.c.w0.t7;
import d.v.e.i.j;
import d.v.e.l.c2;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.h.e.d;
import d.v.i0.b;
import d.v.v.q.h;
import java.util.List;

public class EditorSpeedFragment
extends d.v.c.q0.d {
    private t7 j;
    private u k;
    private d.v.c.s1.r l;
    private PopupWindow m;
    private PopupWindow n;
    private PopupWindow o;
    private PopupWindow p;
    private List q;
    private CurveTempAdapter r;
    private View s;
    private d t;
    private int u;

    public static /* synthetic */ u A(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.k;
    }

    private void A0(long l10) {
        long l11 = this.t.J();
        l10 += l11;
        l10 = h.c(this.u, l10);
        l11 = h.a0(this.u) - 40000L;
        l10 = Math.min(l10, l11);
        this.g.a3(l10);
    }

    public static /* synthetic */ d.v.c.b1.t.g B(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    private void B0() {
        this.D0();
        this.C0();
    }

    public static /* synthetic */ d.v.c.b1.t.g C(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    private void C0() {
        long l10 = h.g0(this.u);
        long l11 = h.a0(this.u);
        TextView textView = this.j.f;
        Object object = Float.valueOf(c2.d((float)(l11 - l10) / 1000000.0f, 2));
        Object[] objectArray = new Object[]{object};
        object = String.format("%ss", objectArray);
        textView.setText((CharSequence)object);
    }

    public static /* synthetic */ void D(EditorSpeedFragment editorSpeedFragment, long l10) {
        editorSpeedFragment.w(l10);
    }

    public static /* synthetic */ d.v.c.b1.t.g E(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    private void E0() {
        int n10;
        Object object = this.k;
        int n11 = ((u)object).j();
        if (n11 == (n10 = 1)) {
            object = this.g.K0();
            d.v.c.b1.t.g g10 = this.g;
            double d10 = g10.W1();
            CurveView curveView = this.j.b;
            if (object == null) {
                object = "";
            }
            curveView.y((String)object, d10);
        } else {
            object = this.k;
            double d11 = this.g.W1();
            n11 = ((u)object).g(d11);
            Object object2 = this.t;
            n10 = (int)(((d)object2).R() ? 1 : 0);
            int n12 = -1;
            if (n10 != 0) {
                n11 = n12;
            }
            object2 = this.k.e();
            Integer n13 = n11;
            d.v.e.i.h.g((MutableLiveData)object2, n13);
            if (n11 != n12) {
                object2 = this.j.d;
                ((RecyclerView)object2).smoothScrollToPosition(n11);
            }
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g F(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    public static /* synthetic */ void G(EditorSpeedFragment editorSpeedFragment, double d10) {
        editorSpeedFragment.S(d10);
    }

    public static /* synthetic */ PopupWindow H(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.m;
    }

    public static /* synthetic */ PopupWindow I(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.n;
    }

    public static /* synthetic */ void J(EditorSpeedFragment editorSpeedFragment, long l10) {
        editorSpeedFragment.A0(l10);
    }

    public static /* synthetic */ View K(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.s;
    }

    public static /* synthetic */ int L(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.u;
    }

    public static /* synthetic */ d.v.c.b1.t.g M(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g N(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    public static /* synthetic */ PopupWindow O(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.o;
    }

    public static /* synthetic */ t7 P(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.j;
    }

    public static /* synthetic */ PopupWindow Q(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.p;
    }

    public static /* synthetic */ d.v.c.b1.t.g R(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    private void S(double d10) {
        d.v.c.b1.t.g g10 = this.g;
        boolean bl2 = g10.c0(d10);
        if (bl2) {
            this.E0();
        }
    }

    private void T() {
        Object object;
        int n10;
        int n11;
        Object object2 = this.k;
        long l10 = this.t.u();
        Object object3 = this.t;
        long l11 = ((d)object3).J();
        Object object4 = this.q = (object2 = ((u)object2).b(l10 -= l11));
        this.r = object2 = new CurveTempAdapter((List)object4);
        boolean bl2 = false;
        object2 = null;
        object4 = null;
        for (n11 = 0; n11 < (n10 = (object = this.g.C1()).size()); ++n11) {
            object = (d)this.g.C1().get(n11);
            object3 = this.k;
            double d10 = ((d)object).I();
            String string2 = ((d)object).t();
            n10 = (int)(((d)object).R() ? 1 : 0);
            d.v.c.s1.s s10 = new d.v.c.s1.s(d10, string2, n10 != 0);
            ((u)object3).r(n11, s10);
        }
        object4 = this.g;
        double d11 = ((i2)object4).B1();
        l11 = -4616189618054758400L;
        double d12 = -1.0;
        double d13 = d11 - d12;
        Object object5 = d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1);
        if (object5 == false) {
            return;
        }
        object4 = this.k.f(d11);
        object3 = this.k;
        this.l = object = new d.v.c.s1.r((LifecycleOwner)this, (u)object3);
        ((d.v.f.d.b)object).l((List)object4);
        object4 = this.j.d;
        object = this.l;
        ((RecyclerView)object4).setAdapter((RecyclerView$Adapter)object);
        object4 = this.t;
        n11 = (int)(((d)object4).R() ? 1 : 0);
        if (n11 == 0) {
            object4 = this.t;
            d11 = ((d)object4).I();
            l11 = h.n();
            int n12 = this.u;
            long l12 = h.g0(n12);
            d12 = (double)(l11 -= l12) * d11;
            l10 = (long)d12;
            object3 = this.k;
            ((u)object3).p(0);
        } else {
            long l13 = h.n();
            l10 = h.b(l13);
            object2 = this.k;
            object5 = true;
            ((u)object2).p((int)object5);
        }
        l11 = -1;
        d12 = 0.0 / 0.0;
        bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (bl2) {
            object2 = this.j.b;
            object3 = this.t;
            l11 = ((d)object3).J();
            ((CurveView)((Object)object2)).setInitPosition(l10 -= l11);
        }
        this.E0();
        this.B0();
    }

    private void U() {
        Object object = this.l;
        Object object2 = new n(this);
        ((d.v.f.d.b)object).n((d.v.f.f.b)object2);
        object = this.g.R0();
        object2 = new e(this);
        ((j)object).observe(this, (Observer)object2);
        object = this.g.c2();
        object2 = this.getViewLifecycleOwner();
        Observer observer = new d.v.c.s1.b(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.g.T0();
        object2 = this.getViewLifecycleOwner();
        observer = new d.v.c.s1.j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.k.i();
        object2 = this.getViewLifecycleOwner();
        observer = new a(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.j.b;
        object2 = new EditorSpeedFragment$a(this);
        ((CurveView)((Object)object)).setCurveSpeedCallback((CurveView$a)object2);
        object = this.r;
        object2 = new d.v.c.s1.d(this);
        ((BaseQuickAdapter)object).setOnItemClickListener((OnItemClickListener)object2);
    }

    private void V() {
        Object object;
        Object object2 = LayoutInflater.from((Context)this.requireContext()).inflate(2131558740, null);
        Object object3 = (TextView)object2.findViewById(2131363578);
        Object object4 = (TextView)object2.findViewById(2131363400);
        int bl2 = -2;
        this.m = object = new PopupWindow((View)object2, bl2, bl2);
        boolean bl3 = true;
        object.setFocusable(bl3);
        object = this.m;
        Object object5 = d.v.c.s1.g.a;
        object.setTouchInterceptor((View.OnTouchListener)object5);
        object = this.m;
        object5 = new ColorDrawable(0);
        object.setBackgroundDrawable((Drawable)object5);
        object = new p(this);
        object3.setOnClickListener((View.OnClickListener)object);
        object3 = new k(this);
        object4.setOnClickListener((View.OnClickListener)object3);
        int n10 = EditorSpeedFragment.z0(this.m.getWidth());
        int n11 = EditorSpeedFragment.z0(this.m.getHeight());
        object2.measure(n10, n11);
        object2 = LayoutInflater.from((Context)this.requireContext()).inflate(2131558738, null);
        this.s = object2;
        object2 = (RecyclerView)object2.findViewById(2131363142);
        object4 = this.s;
        int n12 = h2.b(268.0f);
        int n13 = h2.b(219.0f);
        object3 = new PopupWindow((View)object4, n12, n13);
        this.n = object3;
        object3.setFocusable(bl3);
        object3 = this.n;
        object4 = d.v.c.s1.c.a;
        object3.setTouchInterceptor((View.OnTouchListener)object4);
        object3 = this.n;
        object4 = new ColorDrawable(0);
        object3.setBackgroundDrawable((Drawable)object4);
        object4 = this.requireContext();
        object3 = new GridLayoutManager((Context)object4, 3);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object3);
        float f10 = 24.0f;
        int n14 = h2.b(f10);
        int n15 = h2.b(0.0f);
        int n16 = h2.b(f10);
        object3 = new r(3, n14, false, n15, n16);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object3);
        object3 = this.r;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object3);
        object2 = this.s;
        n10 = EditorSpeedFragment.z0(this.n.getWidth());
        n11 = EditorSpeedFragment.z0(this.n.getHeight());
        object2.measure(n10, n11);
        object2 = this.n;
        object3 = new d.v.c.s1.h(this);
        object2.setOnDismissListener((PopupWindow.OnDismissListener)object3);
        object2 = LayoutInflater.from((Context)this.getContext());
        n10 = 2131558739;
        object2 = object2.inflate(n10, null);
        n11 = 2131362770;
        object = (ImageButton)object2.findViewById(n11);
        object.setImageResource(2131231176);
        object5 = new i(this);
        object.setOnClickListener((View.OnClickListener)object5);
        float f11 = 40.0f;
        int n17 = h2.b(f11);
        float f12 = 36.0f;
        n14 = h2.b(f12);
        this.o = object = new PopupWindow((View)object2, n17, n14, bl3);
        object.setFocusable(bl3);
        object2 = this.o;
        object = d.v.c.s1.l.a;
        object2.setTouchInterceptor((View.OnTouchListener)object);
        object2 = this.o;
        object = new ColorDrawable(0);
        object2.setBackgroundDrawable((Drawable)object);
        object2 = this.o;
        object = new o(this);
        object2.setOnDismissListener((PopupWindow.OnDismissListener)object);
        object2 = LayoutInflater.from((Context)this.getContext()).inflate(n10, null);
        object3 = (ImageButton)object2.findViewById(n11);
        object3.setImageResource(2131231212);
        m m10 = new m(this);
        object3.setOnClickListener((View.OnClickListener)m10);
        int n18 = h2.b(f11);
        n11 = h2.b(f12);
        object3 = new PopupWindow((View)object2, n18, n11, bl3);
        this.p = object3;
        object3.setFocusable(bl3);
        object2 = this.p;
        object3 = d.v.c.s1.f.a;
        object2.setTouchInterceptor((View.OnTouchListener)object3);
        object2 = this.p;
        object3 = new ColorDrawable(0);
        object2.setBackgroundDrawable((Drawable)object3);
    }

    private void W() {
        this.j.c.a.setVisibility(8);
        RecyclerView recyclerView = this.j.d;
        Context context = this.requireContext();
        Object object = new LinearLayoutManager(context, 0, false);
        recyclerView.setLayoutManager((RecyclerView$LayoutManager)object);
        recyclerView = this.j.d;
        int n10 = h2.b(16.0f);
        float f10 = 20.0f;
        int n11 = h2.b(f10);
        int n12 = h2.b(f10);
        object = new s(n10, n11, n12);
        recyclerView.addItemDecoration((RecyclerView$ItemDecoration)object);
    }

    private /* synthetic */ void X(View view, int n10, t t10) {
        double d10 = t10.s();
        this.S(d10);
    }

    private /* synthetic */ void Z(Integer object) {
        double d10;
        int n10;
        if (object == null) {
            return;
        }
        this.u = n10 = ((Integer)object).intValue();
        object = this.g.C1();
        int n11 = this.u;
        this.t = object = (d)object.get(n11);
        object = this.g;
        double d11 = ((i2)object).B1();
        double d12 = d11 - (d10 = -1.0);
        n10 = (int)(d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1));
        if (n10 == 0) {
            return;
        }
        object = this.k.f(d11);
        this.l.m((List)object);
        this.E0();
        this.B0();
    }

    private /* synthetic */ void b0(Long l10) {
        long l11 = h.g0(this.u);
        long l12 = h.a0(this.u);
        l10 = this.j.f;
        Object object = Float.valueOf(c2.d((float)(l12 - l11) / 1000000.0f, 2));
        Object[] objectArray = new Object[]{object};
        object = String.format("%ss", objectArray);
        l10.setText((CharSequence)object);
    }

    private /* synthetic */ void d0(Long object) {
        Object object2;
        long l10;
        int n10 = this.u;
        long l11 = h.a0(n10);
        long l12 = (Long)object;
        long l13 = (l12 = Math.abs(l11 - l12)) - (l10 = 40000L);
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 < 0) {
            object = l11;
        }
        if ((n10 = (int)(((d)(object2 = this.t)).R() ? 1 : 0)) != 0) {
            n10 = this.u;
            long l14 = (Long)object;
            l11 = h.a(n10, l14);
            l12 = -1;
            double d10 = 0.0 / 0.0;
            Object object4 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (object4 != false) {
                object = this.j.b;
                d d11 = this.t;
                l12 = d11.J();
                ((CurveView)((Object)object)).B(l11 -= l12);
            }
        } else {
            object2 = this.g;
            double d12 = ((i2)object2).W1();
            l12 = (Long)object;
            int n11 = this.u;
            l10 = h.g0(n11);
            object = this.j.b;
            double d13 = (double)(l12 -= l10) * d12;
            l11 = (long)d13;
            ((CurveView)((Object)object)).setInitPosition(l11);
        }
    }

    private /* synthetic */ void f0(Integer object) {
        int n10;
        int n11 = (Integer)object;
        if (n11 == (n10 = 1)) {
            object = this.j.b;
            long l10 = this.t.u();
            long l11 = this.t.J();
            ((CurveView)((Object)object)).setDuration(l10 -= l11);
            object = this.g.K0();
            d.v.c.b1.t.g g10 = this.g;
            double d10 = g10.W1();
            CurveView curveView = this.j.b;
            if (object == null) {
                object = "";
            }
            curveView.y((String)object, d10);
        } else {
            int n12 = (Integer)object;
            if (n12 == 0) {
                object = this.k;
                double d11 = this.g.W1();
                n12 = ((u)object).g(d11);
                Object object2 = this.t;
                n11 = (int)(((d)object2).R() ? 1 : 0);
                n10 = -1;
                if (n11 != 0) {
                    n12 = n10;
                }
                object2 = this.k.e();
                Integer n13 = n12;
                d.v.e.i.h.g((MutableLiveData)object2, n13);
                if (n12 != n10) {
                    object2 = this.j.d;
                    ((RecyclerView)object2).smoothScrollToPosition(n12);
                }
            }
        }
    }

    private /* synthetic */ void h0(BaseQuickAdapter object, View view, int n10) {
        object = (CurveTemp$CurveTempBean)this.r.getData().get(n10);
        boolean bl2 = ((CurveTemp$CurveTempBean)object).isCanSelected();
        if (bl2) {
            view = this.j.b;
            object = ((CurveTemp$CurveTempBean)object).getCurveString();
            view.setSpeedPoint((String)object);
            this.r.b(n10);
            object = this.n;
            object.dismiss();
        }
    }

    public static /* synthetic */ boolean j0(View view, MotionEvent motionEvent) {
        return false;
    }

    private /* synthetic */ void k0(View view) {
        this.m.dismiss();
        this.k.p(0);
    }

    private /* synthetic */ void m0(View view) {
        this.m.dismiss();
        this.k.p(1);
    }

    public static /* synthetic */ boolean o0(View view, MotionEvent motionEvent) {
        return false;
    }

    private /* synthetic */ void p0() {
        this.j.e.setSelected(false);
    }

    private /* synthetic */ void r0(View view) {
        this.j.b.h();
        this.o.dismiss();
    }

    public static /* synthetic */ boolean t0(View view, MotionEvent motionEvent) {
        return false;
    }

    private /* synthetic */ void u0() {
        this.j.b.a();
    }

    private /* synthetic */ void w0(View view) {
        this.j.b.i();
        this.p.dismiss();
    }

    public static /* synthetic */ d.v.c.b1.t.g x(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    public static /* synthetic */ d y(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.t;
    }

    public static /* synthetic */ boolean y0(View view, MotionEvent motionEvent) {
        return false;
    }

    public static /* synthetic */ d.v.c.b1.t.g z(EditorSpeedFragment editorSpeedFragment) {
        return editorSpeedFragment.g;
    }

    private static int z0(int n10) {
        int n11 = -2;
        n11 = n10 == n11 ? 0 : 0x40000000;
        return View.MeasureSpec.makeMeasureSpec((int)View.MeasureSpec.getSize((int)n10), (int)n11);
    }

    public void D0() {
        long l10 = this.t.u();
        long l11 = this.t.J();
        float f10 = c2.d((float)(l10 - l11) / 1000000.0f, 2);
        TextView textView = this.j.g;
        Resources resources = this.getResources();
        Object object = Float.valueOf(f10);
        Object[] objectArray = new Object[]{object};
        object = d.v.f.i.g.p(resources, 2131952131, objectArray);
        textView.setText((CharSequence)object);
    }

    public /* synthetic */ void Y(View view, int n10, t t10) {
        this.X(view, n10, t10);
    }

    public /* synthetic */ void a0(Integer n10) {
        this.Z(n10);
    }

    public /* synthetic */ void c0(Long l10) {
        this.b0(l10);
    }

    public /* synthetic */ void e0(Long l10) {
        this.d0(l10);
    }

    public /* synthetic */ void g0(Integer n10) {
        this.f0(n10);
    }

    public int h() {
        return 2131558584;
    }

    public void i(ViewDataBinding object) {
        int n10;
        int n11;
        super.i((ViewDataBinding)object);
        object = (t7)object;
        this.j = object;
        this.k = object = (u)d.v.i0.b.a(this).get(u.class);
        object = this.j;
        Object object2 = new EditorSpeedFragment$b(this);
        ((t7)object).A((EditorSpeedFragment$b)object2);
        object = this.j;
        object2 = this.k;
        ((t7)object).B((u)object2);
        object = this.g;
        this.u = n11 = ((i2)object).S0();
        if (n11 >= 0 && n11 <= (n10 = (object2 = this.g.C1()).size() + -1)) {
            object = this.g.C1();
            n10 = this.u;
            this.t = object = (d)object.get(n10);
            this.W();
            this.T();
            this.V();
            this.U();
            return;
        }
        this.r();
    }

    public /* synthetic */ void i0(BaseQuickAdapter baseQuickAdapter, View view, int n10) {
        this.h0(baseQuickAdapter, view, n10);
    }

    public /* synthetic */ void l0(View view) {
        this.k0(view);
    }

    public /* synthetic */ void n0(View view) {
        this.m0(view);
    }

    public /* synthetic */ void q0() {
        this.p0();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return true;
    }

    public /* synthetic */ void s0(View view) {
        this.r0(view);
    }

    public /* synthetic */ void v0() {
        this.u0();
    }

    public /* synthetic */ void x0(View view) {
        this.w0(view);
    }
}

