/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.filter;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.filter.EditorFilterFragment$a;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;
import d.v.c.e1.a;
import d.v.c.e1.c;
import d.v.c.e1.d;
import d.v.c.e1.e;
import d.v.c.e1.f;
import d.v.c.e1.h;
import d.v.c.e1.i;
import d.v.c.e1.j;
import d.v.c.e1.q;
import d.v.c.e1.u;
import d.v.c.i1.i2;
import d.v.c.w0.p6;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import d.v.j.g.z;
import java.util.List;

public class EditorFilterFragment
extends d.v.c.q0.d {
    private p6 j;
    private u k;
    private z l;

    public static /* synthetic */ void A(EditorFilterFragment editorFilterFragment, boolean bl2) {
        editorFilterFragment.v(bl2);
    }

    public static /* synthetic */ void B(EditorFilterFragment editorFilterFragment, long l10) {
        editorFilterFragment.w(l10);
    }

    public static /* synthetic */ p6 C(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.j;
    }

    public static /* synthetic */ void D(EditorFilterFragment editorFilterFragment) {
        editorFilterFragment.N();
    }

    public static /* synthetic */ d.v.c.b1.t.g E(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g F(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g G(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ d.v.c.b1.t.g H(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ boolean I(EditorFilterFragment editorFilterFragment, boolean bl2) {
        editorFilterFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ d.v.c.b1.t.g J(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ boolean K(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.Q();
    }

    private void L() {
        this.P();
        this.M();
        this.O();
    }

    private void M() {
        this.m0();
        Object object = this.j.c;
        Object object2 = this.k;
        ((BaseResourceListView)object).b(this, (d.v.c.b2.v.b)object2);
        object = this.j.c;
        object2 = BaseResourceListView$ResourceType.RESOURCE_TYPE_FILTER;
        ((BaseResourceListView)object).setResourceType((BaseResourceListView$ResourceType)((Object)object2));
        this.j.e.e();
        object = this.k;
        object2 = this.requireContext();
        ((u)object).u((Context)object2);
    }

    private void N() {
        d.v.h.f.a a10 = this.g.d1();
        MutableLiveData mutableLiveData = this.k.x();
        Integer n10 = a10.k();
        d.v.e.i.h.g(mutableLiveData, n10);
        this.k.X(a10);
    }

    private void O() {
        MutableLiveData mutableLiveData = this.k.f();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new a(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.g.m1();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.g.R0();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d.v.c.e1.b(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.k.d();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.x();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new h(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.w();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new e(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.k.g();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void P() {
    }

    private boolean Q() {
        Object object = this.k;
        int n10 = ((d.v.c.b2.v.b)object).e();
        boolean bl2 = false;
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        u u10 = this.k;
        object = u10.s(n10);
        if (object != null && (n10 = (int)(((d.v.c.b2.w.a)object).J() ? 1 : 0)) != 0 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void R(d.v.c.b2.w.a object) {
        if (object == null) {
            return;
        }
        Object object2 = this.l;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new d.v.c.e1.g(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new j(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            Context context = this.requireContext();
            ((u)object2).n(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void T(Boolean bl2) {
        boolean bl3;
        boolean bl4 = this.c;
        d.v.h.f.a a10 = bl4 ? ((bl4 = bl2.booleanValue()) ? this.g.M0() : this.g.h1()) : this.g.d1();
        bl4 = this.g.i3(a10);
        this.g.G3();
        Object object = this.j.b.a;
        boolean bl5 = true;
        bl3 = bl4 && (bl3 = bl2.booleanValue()) ? bl5 : false;
        object.setChecked(bl3);
        this.g.A2();
        object = this.g;
        boolean bl6 = bl2;
        if (!bl6 || !bl4) {
            bl5 = false;
        }
        ((i2)object).f3(bl5);
    }

    private /* synthetic */ void V(Integer n10) {
        this.N();
    }

    private /* synthetic */ void X(Integer n10) {
        if (n10 == null) {
            return;
        }
        Object object = this.k;
        int n11 = n10;
        if ((object = ((u)object).s(n11)) != null) {
            int n12 = n10;
            this.l0(n12, (q)object);
        }
    }

    private /* synthetic */ void Z(Integer n10) {
        int n11;
        Object object = this.g.d1();
        int n12 = ((d.v.h.f.a)object).f();
        if (n12 == (n11 = -1)) {
            return;
        }
        object = this.g;
        int n13 = n10;
        ((i2)object).M(n13);
    }

    private /* synthetic */ void b0(List list) {
        if (list != null) {
            boolean bl2 = d.v.j.b.f(list);
            if (!bl2) {
                BaseResourceListView baseResourceListView = this.j.c;
                baseResourceListView.setData(list);
                this.N();
            }
            boolean bl3 = list.isEmpty();
            this.n0(bl3);
        }
    }

    private /* synthetic */ void d0(Integer n10) {
        if (n10 == null) {
            return;
        }
        BaseResourceListView baseResourceListView = this.j.c;
        f f10 = new f(this, n10);
        baseResourceListView.post(f10);
    }

    private /* synthetic */ void f0(DialogFragment dialogFragment) {
        this.l.i(false);
    }

    private /* synthetic */ void h0(d.v.c.b2.w.a a10, DialogFragment object) {
        this.l.i(true);
        object = this.k;
        Context context = this.requireContext();
        ((u)object).n(context, a10);
    }

    private /* synthetic */ void j0(Integer n10) {
        BaseResourceListView baseResourceListView = this.j.c;
        int n11 = n10;
        baseResourceListView.smoothScrollToPosition(n11);
    }

    private void l0(int n10, q object) {
        d.v.h.f.a a10;
        int n11;
        d.v.h.f.a a11 = this.k.F(n10, (q)object);
        int n12 = a11.f();
        if (n12 == (n11 = (a10 = this.g.d1()).f())) {
            return;
        }
        object = this.g;
        n10 = (int)(((i2)object).i3(a11) ? 1 : 0);
        if (n10 != 0) {
            this.N();
        }
    }

    private void m0() {
        Object object;
        int n10;
        d.v.c.q0.e e10 = new d.v.c.q0.e();
        int n11 = this.g.n1();
        e10 = e10.e(n11 != 0);
        d.v.h.f.a a10 = this.g.h1().a();
        e10 = e10.f(a10);
        a10 = null;
        for (n11 = 0; n11 < (n10 = (object = this.g.C1()).size()); ++n11) {
            object = ((d.v.h.e.d)this.g.C1().get(n11)).w().a();
            e10.d(n11, object);
        }
        this.k.U(e10);
    }

    private void n0(boolean bl2) {
        if (bl2) {
            StatusView statusView = this.j.e;
            statusView.d();
        } else {
            StatusView statusView = this.j.e;
            statusView.a();
        }
    }

    public static /* synthetic */ u x(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.k;
    }

    public static /* synthetic */ d.v.c.b1.t.g y(EditorFilterFragment editorFilterFragment) {
        return editorFilterFragment.g;
    }

    public static /* synthetic */ void z(EditorFilterFragment editorFilterFragment) {
        editorFilterFragment.t();
    }

    public /* synthetic */ void S(d.v.c.b2.w.a a10) {
        this.R(a10);
    }

    public /* synthetic */ void U(Boolean bl2) {
        this.T(bl2);
    }

    public /* synthetic */ void W(Integer n10) {
        this.V(n10);
    }

    public /* synthetic */ void Y(Integer n10) {
        this.X(n10);
    }

    public /* synthetic */ void a0(Integer n10) {
        this.Z(n10);
    }

    public /* synthetic */ void c0(List list) {
        this.b0(list);
    }

    public /* synthetic */ void e0(Integer n10) {
        this.d0(n10);
    }

    public /* synthetic */ void g0(DialogFragment dialogFragment) {
        this.f0(dialogFragment);
    }

    public int h() {
        return 2131558569;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (p6)object;
        this.j = object;
        object = d.v.i0.b.a(this);
        Object object2 = (u)((ViewModelProvider)object).get(u.class);
        this.k = object2;
        this.l = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = this.k;
        ((p6)object).B((u)object2);
        object = this.j;
        object2 = new EditorFilterFragment$a(this);
        ((p6)object).A((EditorFilterFragment$a)object2);
        this.L();
    }

    public /* synthetic */ void i0(d.v.c.b2.w.a a10, DialogFragment dialogFragment) {
        this.h0(a10, dialogFragment);
    }

    public void j() {
        this.w(2);
        this.v(true);
        this.u();
    }

    public void k() {
        super.k();
        this.j.u().c();
    }

    public /* synthetic */ void k0(Integer n10) {
        this.j0(n10);
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return this.Q() ^ true;
    }
}

