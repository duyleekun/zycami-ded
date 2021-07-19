/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.main;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.decoration.text.EditorTextMainFragment;
import com.zhiyun.cama.main.EditorMainFragment;
import com.zhiyun.cama.main.EditorMainFragment$g$a;
import com.zhiyun.cama.main.EditorMainFragment$g$b;
import com.zhiyun.cama.main.EditorMainFragment$g$c;
import com.zhiyun.cama.main.EditorMainFragment$g$d;
import com.zhiyun.cama.main.EditorMainFragment$g$e;
import com.zhiyun.cama.mediacontent.media.EditorAddVideoActivity;
import com.zhiyun.permission.Permission;
import d.v.c.b2.p$b;
import d.v.c.b2.w.e;
import d.v.c.b2.w.f;
import d.v.c.b2.w.g;
import d.v.c.i1.a0;
import d.v.c.i1.b0;
import d.v.c.i1.c0;
import d.v.c.i1.d0;
import d.v.c.i1.g2;
import d.v.c.i1.g2$b;
import d.v.c.i1.h2;
import d.v.c.i1.i2;
import d.v.c.i1.l2;
import d.v.c.i1.r;
import d.v.c.i1.v;
import d.v.c.i1.w;
import d.v.c.i1.x;
import d.v.c.i1.y;
import d.v.c.i1.z;
import d.v.c.y1.d;
import d.v.c.y1.d$b;
import d.v.c.y1.f.p;
import d.v.v.g.h;
import d.v.x.b;
import d.v.x.c$b;

public class EditorMainFragment$g {
    public final /* synthetic */ EditorMainFragment a;

    public EditorMainFragment$g(EditorMainFragment editorMainFragment) {
        this.a = editorMainFragment;
    }

    private void D() {
        EditorMainFragment.E(this.a).i0();
        d.v.c.b1.t.g g10 = EditorMainFragment.G(this.a);
        long l10 = EditorMainFragment.F(this.a).U0() - 1L;
        g10.a3(l10);
    }

    private void G() {
        int n10 = EditorMainFragment.e0(this.a).u0();
        this.d();
        EditorMainFragment.P(this.a).y0(n10);
    }

    private /* synthetic */ void M() {
        EditorMainFragment editorMainFragment = this.a;
        NavDirections navDirections = g2.e();
        EditorMainFragment.t0(editorMainFragment, navDirections);
    }

    private /* synthetic */ void O(View object) {
        object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).G0();
        if (bl2) {
            this.d();
        } else {
            this.g();
        }
    }

    private /* synthetic */ void Q(View object) {
        object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).G0();
        if (bl2) {
            this.d();
        } else {
            this.h();
        }
    }

    private /* synthetic */ void S(View object) {
        object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).G0();
        if (bl2) {
            this.d();
        } else {
            this.k();
        }
    }

    private /* synthetic */ void U(int n10, View view) {
        this.d();
        EditorMainFragment.s0(this.a, n10);
    }

    private /* synthetic */ void W(View view) {
        this.D();
    }

    private /* synthetic */ void Y(View view) {
        this.G();
    }

    public static /* synthetic */ void a(EditorMainFragment$g editorMainFragment$g) {
        editorMainFragment$g.e();
    }

    private /* synthetic */ void a0(View view) {
        this.u();
    }

    public static /* synthetic */ void b(EditorMainFragment$g editorMainFragment$g) {
        editorMainFragment$g.f();
    }

    private /* synthetic */ void c0(View view) {
        this.f0();
    }

    private void e() {
        Object object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).u();
        if (bl2) {
            this.d();
            object = p.A();
            FragmentManager fragmentManager = this.a.requireActivity().getSupportFragmentManager();
            String string2 = p.class.getName();
            ((DialogFragment)object).show(fragmentManager, string2);
        }
    }

    public static /* synthetic */ void e0(View view) {
    }

    private void f() {
        Object object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).w();
        if (bl2) {
            this.d();
            Object object2 = Permission.RECORD;
            object = new c$b((Permission)((Object)object2));
            object2 = new c0(this);
            object = ((c$b)object).a((b)object2);
            object2 = this.a.getChildFragmentManager();
            ((c$b)object).b((FragmentManager)object2);
        }
    }

    private void f0() {
        Fragment fragment = EditorMainFragment.S(this.a);
        if (fragment == null) {
            fragment = this.a;
            l2 l22 = new l2();
            EditorMainFragment.T((EditorMainFragment)fragment, l22);
        }
        EditorMainFragment.U(this.a).T2();
    }

    private void u() {
        ViewModel viewModel = EditorMainFragment.e0(this.a);
        int n10 = ((h2)viewModel).u0();
        this.d();
        d.v.c.b1.t.g g10 = EditorMainFragment.Q(this.a);
        n10 = (int)(g10.p0(n10) ? 1 : 0);
        if (n10 != 0) {
            viewModel = EditorMainFragment.R(this.a);
            ((i2)viewModel).w2();
        }
    }

    private d.v.f.f.d x(int n10) {
        y y10 = new y(this, n10);
        return y10;
    }

    private d.v.f.f.d y(int n10) {
        int n11 = -5;
        d.v.f.f.d d10 = n10 != n11 ? (n10 != (n11 = -4) ? (n10 != (n11 = -2) ? (n10 != (n11 = -1) ? v.a : new x(this)) : new a0(this)) : new r(this)) : new z(this);
        return d10;
    }

    public p$b A() {
        EditorMainFragment$g$c editorMainFragment$g$c = new EditorMainFragment$g$c(this);
        return editorMainFragment$g$c;
    }

    public p$b B() {
        EditorMainFragment$g$e editorMainFragment$g$e = new EditorMainFragment$g$e(this);
        return editorMainFragment$g$e;
    }

    public p$b C() {
        EditorMainFragment$g$b editorMainFragment$g$b = new EditorMainFragment$g$b(this);
        return editorMainFragment$g$b;
    }

    public void E() {
        EditorMainFragment.C(this.a).n0(true);
    }

    public void F() {
        EditorMainFragment.D(this.a).n0(false);
    }

    public void H() {
        int n10 = EditorMainFragment.e0(this.a).B0();
        this.d();
        EditorMainFragment.H(this.a).N2(n10, true);
    }

    public void I() {
        int n10 = EditorMainFragment.e0(this.a).B0();
        this.d();
        EditorMainFragment.K(this.a).N2(n10, false);
    }

    public void J() {
        int n10 = EditorMainFragment.e0(this.a).d0();
        this.d();
        EditorMainFragment.O(this.a).I2(n10);
    }

    public void K() {
        int n10 = EditorMainFragment.e0(this.a).j0();
        this.d();
        EditorMainFragment.M(this.a).K2(n10);
    }

    public boolean L() {
        EditorMainFragment.B(this.a).A2();
        return false;
    }

    public /* synthetic */ void N() {
        this.M();
    }

    public /* synthetic */ void P(View view) {
        this.O(view);
    }

    public /* synthetic */ void R(View view) {
        this.Q(view);
    }

    public /* synthetic */ void T(View view) {
        this.S(view);
    }

    public /* synthetic */ void V(int n10, View view) {
        this.U(n10, view);
    }

    public /* synthetic */ void X(View view) {
        this.W(view);
    }

    public /* synthetic */ void Z(View view) {
        this.Y(view);
    }

    public /* synthetic */ void b0(View view) {
        this.a0(view);
    }

    public void c(boolean bl2) {
        EditorMainFragment editorMainFragment = this.a;
        NavDirections navDirections = g2.p();
        EditorMainFragment.I(editorMainFragment, navDirections);
    }

    public void d() {
        this.a.A0();
    }

    public /* synthetic */ void d0(View view) {
        this.c0(view);
    }

    public void g() {
        Object object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).y();
        if (bl2) {
            this.d();
            object = this.a;
            NavDirections navDirections = g2.j();
            EditorMainFragment.a0((EditorMainFragment)object, navDirections);
        }
    }

    public void g0(e e10, View view) {
        int n10;
        if (e10 != null && (n10 = e10.d()) != 0) {
            Object object;
            int n11;
            e10 = null;
            for (n10 = 0; n10 < (n11 = (object = EditorMainFragment.r0(this.a)).getChildCount()); ++n10) {
                object = EditorMainFragment.r0(this.a).getChildAt(n10);
                boolean bl2 = object instanceof d.v.c.b2.p;
                if (!bl2 || (bl2 = object.equals(view))) continue;
                object = (d.v.c.b2.p)object;
                ((d.v.c.b2.p)object).E();
            }
        }
    }

    public void h() {
        h2 h22 = EditorMainFragment.e0(this.a);
        boolean bl2 = h22.A();
        if (bl2) {
            this.d();
            bl2 = false;
            h22 = null;
            this.t(0);
        }
    }

    public d.v.f.f.d h0(int n10) {
        Object object;
        switch (n10) {
            default: {
                n10 = -3;
                break;
            }
            case 11: {
                n10 = -5;
                break;
            }
            case 10: {
                object = g2.n();
                n10 = object.getActionId();
                break;
            }
            case 9: {
                n10 = -2;
                break;
            }
            case 8: {
                n10 = -4;
                break;
            }
            case 7: {
                object = g2.h();
                n10 = object.getActionId();
                break;
            }
            case 6: {
                object = g2.a();
                n10 = object.getActionId();
                break;
            }
            case 5: {
                object = g2.g();
                n10 = object.getActionId();
                break;
            }
            case 4: {
                object = g2.m();
                n10 = object.getActionId();
                break;
            }
            case 3: {
                object = g2.i();
                n10 = object.getActionId();
                break;
            }
            case 2: {
                n10 = -1;
                break;
            }
            case 1: {
                object = g2.o();
                n10 = object.getActionId();
                break;
            }
            case 0: {
                object = g2.d();
                n10 = object.getActionId();
            }
        }
        object = n10 > 0 ? this.x(n10) : this.y(n10);
        return object;
    }

    public void i(int n10) {
        EditorMainFragment.d0(this.a, n10);
        this.d();
        EditorMainFragment editorMainFragment = this.a;
        NavDirections navDirections = g2.l();
        EditorMainFragment.f0(editorMainFragment, navDirections);
    }

    public void j() {
        EditorAddVideoActivity.p(this.a.requireActivity(), "editor", 9);
    }

    public void k() {
        Object object = EditorMainFragment.e0(this.a);
        boolean bl2 = ((h2)object).G();
        if (bl2) {
            EditorMainFragment.W(this.a).A2();
            bl2 = EditorMainFragment.e0(this.a).u();
            int n10 = EditorMainFragment.e0(this.a).w();
            d d10 = d.x();
            object = d10.A(bl2).B(n10 != 0);
            n10 = EditorMainFragment.x((EditorMainFragment)this.a).n.getHeight();
            object = ((d)object).z(n10);
            Object object2 = new EditorMainFragment$g$a(this);
            object = ((d)object).C((d$b)object2);
            object2 = this.a.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        }
    }

    public void l() {
        EditorMainFragment.X(this.a);
        p p10 = p.A();
        FragmentManager fragmentManager = this.a.getChildFragmentManager();
        p10.q(fragmentManager);
    }

    public void m() {
        EditorMainFragment.b0(this.a);
        EditorMainFragment editorMainFragment = this.a;
        NavDirections navDirections = g2.j();
        EditorMainFragment.c0(editorMainFragment, navDirections);
    }

    public d.v.f.f.d n() {
        d0 d02 = new d0(this);
        return d02;
    }

    public d.v.f.f.d o() {
        b0 b02 = new b0(this);
        return b02;
    }

    public d.v.f.f.d p() {
        w w10 = new w(this);
        return w10;
    }

    public void q() {
        EditorMainFragment.X(this.a);
        g2$b g2$b = g2.c(true);
        NavHostFragment.findNavController(this.a).navigate(g2$b);
    }

    public void r() {
        EditorMainFragment.X(this.a);
        g2$b g2$b = g2.c(true);
        NavHostFragment.findNavController(this.a).navigate(g2$b);
    }

    public void s() {
        EditorMainFragment.X(this.a);
        NavDirections navDirections = g2.f();
        NavHostFragment.findNavController(this.a).navigate(navDirections);
    }

    public void t(int n10) {
        EditorMainFragment.Y(this.a);
        EditorMainFragment editorMainFragment = this.a;
        NavDirections navDirections = g2.k();
        Bundle bundle = EditorTextMainFragment.F(n10);
        EditorMainFragment.Z(editorMainFragment, navDirections, bundle);
    }

    public void v() {
        int n10 = EditorMainFragment.e0(this.a).d0();
        EditorMainFragment.N(this.a).q0(n10);
        Object object = h.k();
        long l10 = ((f)EditorMainFragment.e0(this.a).f0().a()).g();
        ((h)object).I(l10, 0);
        this.d();
        object = EditorMainFragment.e0(this.a);
        ((h2)object).F1(++n10);
    }

    public void w() {
        int n10 = EditorMainFragment.e0(this.a).j0();
        EditorMainFragment.L(this.a).r0(n10);
        Object object = h.k();
        long l10 = ((g)EditorMainFragment.e0(this.a).l0().a()).g();
        ((h)object).I(l10, 0);
        this.d();
        object = EditorMainFragment.e0(this.a);
        ((h2)object).E1(++n10);
    }

    public p$b z() {
        EditorMainFragment$g$d editorMainFragment$g$d = new EditorMainFragment$g$d(this);
        return editorMainFragment$g$d;
    }
}

