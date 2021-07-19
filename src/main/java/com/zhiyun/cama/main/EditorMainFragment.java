/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.os.Vibrator
 *  android.util.Size
 *  android.view.View
 *  android.view.View$OnScrollChangeListener
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewTreeObserver$OnGlobalLayoutListener
 *  android.widget.LinearLayout
 */
package com.zhiyun.cama.main;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Size;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.util.Pair;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider$Factory;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.main.EditorMainFragment$a;
import com.zhiyun.cama.main.EditorMainFragment$b;
import com.zhiyun.cama.main.EditorMainFragment$c;
import com.zhiyun.cama.main.EditorMainFragment$d;
import com.zhiyun.cama.main.EditorMainFragment$e;
import com.zhiyun.cama.main.EditorMainFragment$f;
import com.zhiyun.cama.main.EditorMainFragment$g;
import com.zhiyun.cama.widget.EditorHorizontalScrollView;
import com.zhiyun.cama.widget.EditorHorizontalScrollView$b;
import com.zhiyun.cama.widget.EditorThumbnail;
import com.zhiyun.cama.widget.EditorThumbnail$a;
import com.zhiyun.cama.widget.ScrollRecyclerViewImpl;
import com.zhiyun.common.util.Windows;
import com.zhiyun.editorinterface.decoration.DecorationType;
import com.zhiyun.editorsdk.MainUseCase;
import d.v.c.b2.w.d;
import d.v.c.b2.w.e;
import d.v.c.b2.w.f;
import d.v.c.i1.e0;
import d.v.c.i1.f0;
import d.v.c.i1.g0;
import d.v.c.i1.h0;
import d.v.c.i1.h2;
import d.v.c.i1.i0;
import d.v.c.i1.i2;
import d.v.c.i1.j0;
import d.v.c.i1.k0;
import d.v.c.i1.l0;
import d.v.c.i1.l2;
import d.v.c.i1.m0;
import d.v.c.i1.m2;
import d.v.c.i1.m2$a;
import d.v.c.i1.n;
import d.v.c.i1.p;
import d.v.c.i1.q;
import d.v.c.w0.t6;
import d.v.c.x1.m;
import d.v.e.i.j;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.f.i.g;
import d.v.i0.b;
import d.v.v.q.h;

public class EditorMainFragment
extends d.v.c.q0.d {
    private t6 j;
    private EditorMainFragment$g k;
    private LinearLayout l;
    private h2 m;
    private Size n;
    public Vibrator o;
    private l2 p;

    public static /* synthetic */ void A(EditorMainFragment editorMainFragment) {
        editorMainFragment.p1();
    }

    public static /* synthetic */ d.v.c.b1.t.g B(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void B0(ViewDataBinding object) {
        Object object2 = new Object[1];
        MainUseCase mainUseCase = this.g.a1();
        object2[0] = mainUseCase;
        object2 = d.v.c.x1.m.b((Object[])object2);
        this.m = object2 = (h2)d.v.i0.b.b(this, (ViewModelProvider$Factory)object2).get(h2.class);
        mainUseCase = Windows.l(this.requireContext());
        ((h2)object2).N1((Size)mainUseCase);
        object = (t6)object;
        this.j = object;
        this.k = object = new EditorMainFragment$g(this);
        this.j.B((EditorMainFragment$g)object);
        object = this.j;
        object2 = this.g;
        ((t6)object).D((i2)object2);
        object = this.j;
        object2 = this.m;
        ((t6)object).C((h2)object2);
    }

    public static /* synthetic */ d.v.c.b1.t.g C(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void C0() {
        Object object = this.m.R();
        Object object2 = (long)-1;
        d.v.e.i.h.e((MutableLiveData)object, object2);
        d.v.e.i.h.e(this.m.S(), null);
        object = this.getViewLifecycleOwner();
        object2 = this.m.C0();
        Observer observer = new l0(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.m.k0();
        observer = new k0(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.m.e0();
        observer = new m0(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.m.v0();
        observer = new n(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.g.z1();
        observer = new p(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.m.R();
        observer = new i0(this);
        ((j)object2).observe((LifecycleOwner)object, observer);
        object2 = this.g.x1();
        observer = new j0(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.g.Z0();
        observer = new q(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.m.S();
        observer = new f0(this);
        ((j)object2).observe((LifecycleOwner)object, observer);
        object2 = this.g.T0();
        observer = new g0(this);
        ((LiveData)object2).observe((LifecycleOwner)object, observer);
        object2 = this.g.Q1();
        observer = new h0(this);
        ((j)object2).observe((LifecycleOwner)object, observer);
    }

    public static /* synthetic */ d.v.c.b1.t.g D(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void D0() {
        Object object = this.j.i;
        this.l = object;
        object = this.getChildFragmentManager().beginTransaction();
        Object object2 = new d.v.c.b1.t.f();
        ((FragmentTransaction)object).replace(2131362500, (Fragment)object2).commit();
        object = this.j.l;
        object2 = new EditorMainFragment$b(this);
        ((EditorHorizontalScrollView)((Object)object)).setOnScaleGestureListener((EditorHorizontalScrollView$b)object2);
        object = this.j.k;
        Object object3 = this.requireContext();
        object2 = new LinearLayoutManager((Context)object3);
        ((LinearLayoutManager)object2).setOrientation(0);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        Object object4 = this.requireContext();
        object3 = new d.v.c.i1.n2((Context)object4);
        ((RecyclerView)object).setAdapter((RecyclerView$Adapter)object3);
        object4 = new EditorMainFragment$c(this, (LinearLayoutManager)object2, (d.v.c.i1.n2)object3);
        ((RecyclerView)object).addItemDecoration((RecyclerView$ItemDecoration)object4);
        object2 = new EditorMainFragment$d(this, (d.v.c.i1.n2)object3);
        object4 = new ItemTouchHelper((ItemTouchHelper$Callback)object2);
        ((ItemTouchHelper)object4).attachToRecyclerView((RecyclerView)object);
        Object object5 = new EditorMainFragment$e(this);
        ((m2)object2).c((m2$a)object5);
        object2 = this.j.m;
        object5 = new EditorMainFragment$f(this, (ScrollRecyclerViewImpl)object, (d.v.c.i1.n2)object3, (ItemTouchHelper)object4);
        ((EditorThumbnail)object2).setOnItemLongPressedListener((EditorThumbnail$a)object5);
        object = this.j.l;
        object2 = new e0(this);
        ((EditorHorizontalScrollView)((Object)object)).a((View.OnScrollChangeListener)object2);
    }

    public static /* synthetic */ d.v.c.b1.t.g E(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ void E0(EditorMainFragment editorMainFragment, e e10) {
        editorMainFragment.d1(e10);
    }

    public static /* synthetic */ d.v.c.b1.t.g F(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void F0(e e10) {
        boolean bl2;
        this.d1(e10);
        d.v.c.b1.t.g g10 = this.g;
        if (e10 != null && (bl2 = e10.d())) {
            bl2 = false;
            e10 = null;
        } else {
            bl2 = true;
        }
        g10.S3(bl2);
    }

    public static /* synthetic */ d.v.c.b1.t.g G(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g H(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void H0(Integer object) {
        block8: {
            block4: {
                int n10;
                block7: {
                    block5: {
                        int n11;
                        block6: {
                            n10 = (Integer)object;
                            if (n10 == (n11 = 1)) break block4;
                            n11 = 3;
                            if (n10 == n11) break block5;
                            n11 = 4;
                            if (n10 == n11) break block6;
                            n11 = 5;
                            if (n10 == n11) break block7;
                            break block8;
                        }
                        object = this.requireContext();
                        n11 = 2131952136;
                        n2.e(d.v.f.i.g.m((Context)object, n11));
                        object = this.p;
                        if (object != null && (n10 = (int)(((Fragment)object).isAdded() ? 1 : 0)) != 0) {
                            object = this.p;
                            ((DialogFragment)object).dismiss();
                        }
                        break block8;
                    }
                    object = this.p;
                    if (object != null) {
                        object = this.m;
                        ((h2)object).x2();
                    }
                }
                if ((object = this.p) != null && (n10 = (int)(((Fragment)object).isAdded() ? 1 : 0)) != 0) {
                    object = this.p;
                    ((DialogFragment)object).dismiss();
                }
                break block8;
            }
            object = this.p;
            if (object != null) {
                FragmentManager fragmentManager = this.getChildFragmentManager();
                ((d.v.f.g.b)object).q(fragmentManager);
            }
        }
    }

    public static /* synthetic */ void I(EditorMainFragment editorMainFragment, NavDirections navDirections) {
        editorMainFragment.p(navDirections);
    }

    public static /* synthetic */ void J(EditorMainFragment editorMainFragment) {
        editorMainFragment.t1();
    }

    private /* synthetic */ void J0(e e10) {
        boolean bl2;
        this.d1(e10);
        d.v.c.b1.t.g g10 = this.g;
        if (e10 != null && (bl2 = e10.d())) {
            bl2 = false;
            e10 = null;
        } else {
            bl2 = true;
        }
        g10.R3(bl2);
    }

    public static /* synthetic */ d.v.c.b1.t.g K(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g L(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void L0(e e10) {
        this.k1();
    }

    public static /* synthetic */ d.v.c.b1.t.g M(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g N(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void N0(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.A0();
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g O(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g P(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void P0(Long l10) {
        long l11;
        long l12 = l10;
        long l13 = l12 - (l11 = 0L);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return;
        }
        d.v.c.b1.t.g g10 = this.g;
        long l14 = l10;
        g10.b3(l14);
    }

    public static /* synthetic */ d.v.c.b1.t.g Q(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g R(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private /* synthetic */ void R0(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.A0();
        }
    }

    public static /* synthetic */ l2 S(EditorMainFragment editorMainFragment) {
        return editorMainFragment.p;
    }

    public static /* synthetic */ l2 T(EditorMainFragment editorMainFragment, l2 l22) {
        editorMainFragment.p = l22;
        return l22;
    }

    private /* synthetic */ void T0(Boolean object) {
        boolean bl2;
        if (object != null && (bl2 = ((Boolean)object).booleanValue())) {
            object = this.m;
            ((h2)object).I0();
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g U(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ void V(EditorMainFragment editorMainFragment, int n10) {
        editorMainFragment.v1(n10);
    }

    private /* synthetic */ void V0(Pair object) {
        if (object != null) {
            h2 h22 = this.m;
            Integer n10 = (Integer)object.first;
            int n11 = n10;
            object = (DecorationType)((Object)object.second);
            h22.p(n11, (DecorationType)((Object)object));
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g W(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    public static /* synthetic */ void X(EditorMainFragment editorMainFragment) {
        editorMainFragment.n1();
    }

    private /* synthetic */ void X0(Long l10) {
        Object[] objectArray = new Object[]{l10};
        this.b1("onPositionChange: %s", objectArray);
        long l11 = l10;
        this.u1(l11);
    }

    public static /* synthetic */ void Y(EditorMainFragment editorMainFragment) {
        editorMainFragment.h1();
    }

    public static /* synthetic */ void Z(EditorMainFragment editorMainFragment, NavDirections navDirections, Bundle bundle) {
        editorMainFragment.q(navDirections, bundle);
    }

    private /* synthetic */ void Z0(View view, int n10, int n11, int n12, int n13) {
        this.c1(n10);
    }

    public static /* synthetic */ void a0(EditorMainFragment editorMainFragment, NavDirections navDirections) {
        editorMainFragment.p(navDirections);
    }

    public static /* synthetic */ void b0(EditorMainFragment editorMainFragment) {
        editorMainFragment.f1();
    }

    private void b1(String string2, Object ... objectArray) {
    }

    public static /* synthetic */ void c0(EditorMainFragment editorMainFragment, NavDirections navDirections) {
        editorMainFragment.p(navDirections);
    }

    private void c1(int n10) {
        Object object;
        long l10;
        int n11 = 1;
        Object object2 = new Object[n11];
        Object object3 = n10;
        Long l11 = null;
        object2[0] = object3;
        object3 = "onScrollChange: %s";
        this.b1((String)object3, (Object[])object2);
        this.v1(n10);
        object2 = this.j.l;
        boolean n12 = ((EditorHorizontalScrollView)((Object)object2)).c();
        if (n12) {
            return;
        }
        object2 = this.m;
        object3 = this.j.l;
        long l12 = ((EditorHorizontalScrollView)((Object)object3)).getPosition();
        int n13 = ((h2)object2).c2(l12);
        if (n10 == n13) {
            return;
        }
        object2 = this.m;
        long l13 = ((h2)object2).d2(n10);
        long l14 = l13 - (l12 = 0L);
        if ((n10 = (int)(l14 == 0L ? 0 : (l14 < 0L ? -1 : 1))) >= 0 && (n10 = (int)((l10 = l13 - (l12 = ((i2)(object = this.g)).U0())) == 0L ? 0 : (l10 < 0L ? -1 : 1))) != 0) {
            n10 = 2;
            object = new Object[n10];
            l12 = this.j.l.getPosition();
            Long l15 = l12;
            object[0] = l15;
            l11 = l13;
            object[n11] = l11;
            String string2 = "onScrollChange, preTime: %s, seekTime: %s";
            this.b1(string2, (Object[])object);
            this.j.l.setPosition(l13);
            object = this.g;
            ((i2)object).a3(l13);
        }
    }

    public static /* synthetic */ void d0(EditorMainFragment editorMainFragment, int n10) {
        editorMainFragment.j1(n10);
    }

    private void d1(e object) {
        object = this.m.t0((e)object);
        long l10 = this.g.U0();
        this.y0((d)object, l10);
    }

    public static /* synthetic */ h2 e0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.m;
    }

    private void e1(e object, boolean bl2) {
        object = this.m.t0((e)object);
        this.z0((d)object, bl2);
    }

    public static /* synthetic */ void f0(EditorMainFragment editorMainFragment, NavDirections navDirections) {
        editorMainFragment.p(navDirections);
    }

    private void f1() {
        e e10 = this.m.f0();
        this.d1(e10);
    }

    public static /* synthetic */ void g0(EditorMainFragment editorMainFragment, boolean bl2) {
        editorMainFragment.o1(bl2);
    }

    private void g1(boolean bl2) {
        e e10 = this.m.f0();
        this.e1(e10, bl2);
    }

    public static /* synthetic */ void h0(EditorMainFragment editorMainFragment, int n10, long l10, boolean bl2) {
        editorMainFragment.y1(n10, l10, bl2);
    }

    private void h1() {
        e e10 = this.m.l0();
        this.d1(e10);
    }

    public static /* synthetic */ d.v.c.b1.t.g i0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void i1(boolean bl2) {
        e e10 = this.m.l0();
        this.e1(e10, bl2);
    }

    public static /* synthetic */ void j0(EditorMainFragment editorMainFragment, int n10, d.v.c.b2.w.g g10) {
        editorMainFragment.x1(n10, g10);
    }

    private void j1(int n10) {
        long l10 = h.a0(n10) - 1L;
        this.g.a3(l10);
    }

    public static /* synthetic */ void k0(EditorMainFragment editorMainFragment, boolean bl2) {
        editorMainFragment.i1(bl2);
    }

    private void k1() {
        Object object = this.m.w0();
        object = this.m.x0((e)object);
        long l10 = this.g.U0();
        this.y0((d)object, l10);
    }

    public static /* synthetic */ void l0(EditorMainFragment editorMainFragment, int n10, f f10) {
        editorMainFragment.w1(n10, f10);
    }

    private void l1(boolean bl2) {
        Object object = this.m.w0();
        object = this.m.x0((e)object);
        this.z0((d)object, bl2);
    }

    public static /* synthetic */ void m0(EditorMainFragment editorMainFragment, boolean bl2) {
        editorMainFragment.g1(bl2);
    }

    private void m1(int n10) {
        long l10 = h.g0(n10) + 1L;
        this.g.a3(l10);
    }

    public static /* synthetic */ void n0(EditorMainFragment editorMainFragment, boolean bl2) {
        editorMainFragment.l1(bl2);
    }

    private void n1() {
        e e10 = this.m.D0();
        this.d1(e10);
    }

    public static /* synthetic */ d.v.c.b1.t.g o0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void o1(boolean bl2) {
        e e10 = this.m.D0();
        this.e1(e10, bl2);
    }

    public static /* synthetic */ d.v.c.b1.t.g p0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void p1() {
        this.q1(true);
    }

    public static /* synthetic */ d.v.c.b1.t.g q0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void q1(boolean bl2) {
        this.g.g3(bl2);
    }

    public static /* synthetic */ LinearLayout r0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.l;
    }

    private void r1() {
        this.q1(false);
    }

    public static /* synthetic */ void s0(EditorMainFragment editorMainFragment, int n10) {
        editorMainFragment.l(n10);
    }

    public static /* synthetic */ void t0(EditorMainFragment editorMainFragment, NavDirections navDirections) {
        editorMainFragment.p(navDirections);
    }

    private void t1() {
        Object object;
        d.v.c.b1.t.g g10 = this.g;
        long l10 = g10.U0();
        EditorHorizontalScrollView editorHorizontalScrollView = this.j.l;
        h2 h22 = this.m;
        int n10 = h22.c2(l10);
        LinearLayout linearLayout = this.j.i;
        int n11 = linearLayout.getWidth();
        int n12 = this.n.getWidth();
        n11 -= n12;
        n12 = 2;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object = Integer.valueOf(n10);
        object = n11;
        int n13 = 1;
        objectArray[n13] = object;
        object = "updateScroll, scroll: %s, width: %s";
        this.b1((String)object, objectArray);
        if (n10 >= 0 && n10 <= n11 && (n11 = editorHorizontalScrollView.getScrollX()) != n10) {
            editorHorizontalScrollView.setPosition(l10);
            editorHorizontalScrollView.scrollTo(n10, 0);
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g u0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void u1(long l10) {
        long l11;
        long l12;
        Object object;
        EditorHorizontalScrollView editorHorizontalScrollView = this.j.l;
        h2 h22 = this.m;
        int n10 = h22.c2(l10);
        LinearLayout linearLayout = this.j.i;
        int n11 = linearLayout.getWidth();
        int n12 = this.n.getWidth();
        n11 -= n12;
        n12 = 3;
        Object[] objectArray = new Object[n12];
        objectArray[0] = object = Long.valueOf(l10);
        objectArray[1] = object = Integer.valueOf(n10);
        object = n11;
        int n13 = 2;
        objectArray[n13] = object;
        object = "updateScroll, position: %s, scroll: %s, width: %s";
        this.b1((String)object, objectArray);
        if (n10 >= 0 && n10 <= n11 && (n11 = (int)((l12 = (l11 = editorHorizontalScrollView.getPosition()) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
            editorHorizontalScrollView.setPosition(l10);
            editorHorizontalScrollView.scrollTo(n10, 0);
        }
    }

    public static /* synthetic */ void v0(EditorMainFragment editorMainFragment, int n10) {
        editorMainFragment.m1(n10);
    }

    private void v1(int n10) {
        View view = this.j.j;
        int n11 = d.v.e.l.h2.b(22.0f);
        Resources resources = this.getResources();
        float f10 = o1.j(resources, 2131165367);
        int n12 = (int)f10;
        Size size = this.n;
        int n13 = size.getWidth() / 2 - n12 - n11;
        n11 = 0;
        n10 = Math.max(0, n10);
        n10 = Math.min(n13, n10);
        if ((n13 -= n10) != (n10 = view.getWidth())) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = n13;
            view.setLayoutParams(layoutParams);
        }
    }

    public static /* synthetic */ d.v.c.b1.t.g w0(EditorMainFragment editorMainFragment) {
        return editorMainFragment.g;
    }

    private void w1(int n10, f f10) {
        if (f10 == null) {
            return;
        }
        d.v.c.b1.t.g g10 = this.g;
        long l10 = f10.i();
        long l11 = f10.g();
        g10.d4(n10, l10, l11);
    }

    public static /* synthetic */ t6 x(EditorMainFragment editorMainFragment) {
        return editorMainFragment.j;
    }

    public static /* synthetic */ void x0(EditorMainFragment editorMainFragment) {
        editorMainFragment.z1();
    }

    private void x1(int n10, d.v.c.b2.w.g g10) {
        if (g10 == null) {
            return;
        }
        d.v.c.b1.t.g g11 = this.g;
        DecorationType decorationType = ((d.v.h.d.d)g10.a()).g();
        long l10 = g10.i();
        long l11 = g10.g();
        g11.Y3(decorationType, n10, l10, l11);
    }

    public static /* synthetic */ void y(EditorMainFragment editorMainFragment) {
        editorMainFragment.C0();
    }

    private void y0(d d10, long l10) {
        if (d10 != null) {
            long l11 = d10.b();
            long l12 = d10.a();
            Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (object < 0 || (object = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) >= 0) {
                long l13;
                long l14;
                l14 = (l14 = (l13 = (l12 -= l10) - (l10 -= l11)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) > 0 ? (long)1 : (long)0;
                this.z0(d10, (boolean)l14);
            }
        }
    }

    private void y1(int n10, long l10, boolean bl2) {
        d.v.c.b1.t.g g10 = this.g;
        Long l11 = l10;
        g10.j4(n10, l11, bl2);
    }

    public static /* synthetic */ void z(EditorMainFragment editorMainFragment) {
        editorMainFragment.r1();
    }

    private void z0(d object, boolean bl2) {
        if (object != null) {
            long l10 = ((d)object).b();
            long l11 = ((d)object).a();
            object = this.g;
            if (!bl2) {
                l10 = l11 - 1L;
            }
            ((i2)object).a3(l10);
        }
    }

    private void z1() {
        Object[] objectArray = new Object[]{};
        this.b1("vibrator", objectArray);
        this.o.vibrate((long)100);
    }

    public void A0() {
        this.m.o();
    }

    public /* synthetic */ void G0(e e10) {
        this.F0(e10);
    }

    public /* synthetic */ void I0(Integer n10) {
        this.H0(n10);
    }

    public /* synthetic */ void K0(e e10) {
        this.J0(e10);
    }

    public /* synthetic */ void M0(e e10) {
        this.L0(e10);
    }

    public /* synthetic */ void O0(Boolean bl2) {
        this.N0(bl2);
    }

    public /* synthetic */ void Q0(Long l10) {
        this.P0(l10);
    }

    public /* synthetic */ void S0(Boolean bl2) {
        this.R0(bl2);
    }

    public /* synthetic */ void U0(Boolean bl2) {
        this.T0(bl2);
    }

    public /* synthetic */ void W0(Pair pair) {
        this.V0(pair);
    }

    public /* synthetic */ void Y0(Long l10) {
        this.X0(l10);
    }

    public /* synthetic */ void a1(View view, int n10, int n11, int n12, int n13) {
        this.Z0(view, n10, n11, n12, n13);
    }

    public int h() {
        return 2131558571;
    }

    public void i(ViewDataBinding viewDataBinding) {
        Object object;
        super.i(viewDataBinding);
        this.n = object = Windows.o(this.requireContext());
        object = (Vibrator)this.getActivity().getSystemService("vibrator");
        this.o = object;
        this.B0(viewDataBinding);
        this.D0();
        viewDataBinding = this.j.getRoot().getViewTreeObserver();
        object = new EditorMainFragment$a(this);
        viewDataBinding.addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)object);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (bundle == null) {
            view = null;
            this.v1(0);
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
    }

    /*
     * WARNING - void declaration
     */
    public void s1(boolean bl2) {
        void var1_4;
        ConstraintLayout constraintLayout = this.j.h;
        if (bl2) {
            int n10 = 8;
        } else {
            boolean bl3 = false;
        }
        constraintLayout.setVisibility((int)var1_4);
    }
}

