/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.zhiyun.cama.template.edit;

import android.content.Context;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.template.edit.EditorTemplateFilterFragment$a;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;
import d.v.c.e1.q;
import d.v.c.e1.u;
import d.v.c.q0.c;
import d.v.c.q0.e;
import d.v.c.u1.m.n0;
import d.v.c.u1.m.o0;
import d.v.c.u1.m.p0;
import d.v.c.u1.m.q0;
import d.v.c.u1.m.r0;
import d.v.c.u1.m.s0;
import d.v.c.u1.m.t0;
import d.v.c.u1.m.u0;
import d.v.c.u1.m.v0;
import d.v.c.w0.z8;
import d.v.e.i.h;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.h.e.d;
import d.v.i0.b;
import d.v.j.g.z;
import java.util.List;

public class EditorTemplateFilterFragment
extends c {
    private z8 g;
    private u h;
    private z i;
    private TemplateEditViewModel j;

    public static /* synthetic */ boolean A(EditorTemplateFilterFragment editorTemplateFilterFragment, boolean bl2) {
        editorTemplateFilterFragment.c = bl2;
        return bl2;
    }

    public static /* synthetic */ z8 B(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        return editorTemplateFilterFragment.g;
    }

    private void C() {
        this.G();
        this.D();
        this.F();
    }

    private void D() {
        this.b0();
        Object object = this.g.b;
        Object object2 = this.h;
        ((BaseResourceListView)object).b(this, (d.v.c.b2.v.b)object2);
        object = this.g.b;
        object2 = BaseResourceListView$ResourceType.RESOURCE_TYPE_FILTER;
        ((BaseResourceListView)object).setResourceType((BaseResourceListView$ResourceType)((Object)object2));
        this.g.d.e();
        object = this.h;
        object2 = this.requireContext();
        ((u)object).u((Context)object2);
    }

    private void E() {
        d.v.h.f.a a10 = this.j.R();
        MutableLiveData mutableLiveData = this.h.x();
        Integer n10 = a10.k();
        d.v.e.i.h.g(mutableLiveData, n10);
        this.h.X(a10);
    }

    private void F() {
        MutableLiveData mutableLiveData = this.h.f();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new p0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.j.U();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new t0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.d();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new s0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.x();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new r0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.w();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new v0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.h.g();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new o0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void G() {
    }

    private boolean H() {
        Object object = this.h;
        int n10 = ((d.v.c.b2.v.b)object).e();
        boolean bl2 = false;
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        u u10 = this.h;
        object = u10.s(n10);
        if (object != null && (n10 = (int)(((d.v.c.b2.w.a)object).J() ? 1 : 0)) != 0 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void I(d.v.c.b2.w.a object) {
        if (object == null) {
            return;
        }
        Object object2 = this.i;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new u0(this);
            object2 = (k$b)((k$a)object2).p((a)object4);
            int n10 = 2131951892;
            object3 = new q0(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.h;
            Context context = this.requireContext();
            ((u)object2).n(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void K(Boolean object) {
        TemplateEditViewModel templateEditViewModel = this.j;
        boolean bl2 = templateEditViewModel.W();
        boolean bl3 = this.c;
        Object object2 = bl3 ? ((bl3 = ((Boolean)object).booleanValue()) ? this.j.G() : this.j.R()) : this.j.P();
        TemplateEditViewModel templateEditViewModel2 = this.j;
        templateEditViewModel2.J0((d.v.h.f.a)object2);
        object2 = this.j;
        boolean bl4 = (Boolean)object;
        ((TemplateEditViewModel)object2).T0(bl4);
        if (bl2) {
            object = this.j;
            ((TemplateEditViewModel)object).z0();
        }
    }

    private /* synthetic */ void M(Integer n10) {
        if (n10 == null) {
            return;
        }
        Object object = this.h;
        int n11 = n10;
        if ((object = ((u)object).s(n11)) != null) {
            int n12 = n10;
            this.a0(n12, (q)object);
        }
    }

    private /* synthetic */ void O(Integer n10) {
        int n11;
        Object object = this.j.P();
        int n12 = ((d.v.h.f.a)object).f();
        if (n12 == (n11 = -1)) {
            return;
        }
        object = this.j;
        int n13 = n10;
        ((TemplateEditViewModel)object).t(n13);
    }

    private /* synthetic */ void Q(List list) {
        if (list != null) {
            boolean bl2 = d.v.j.b.f(list);
            if (!bl2) {
                BaseResourceListView baseResourceListView = this.g.b;
                baseResourceListView.setData(list);
                this.E();
            }
            boolean bl3 = list.isEmpty();
            this.c0(bl3);
        }
    }

    private /* synthetic */ void S(Integer n10) {
        if (n10 == null) {
            return;
        }
        BaseResourceListView baseResourceListView = this.g.b;
        n0 n02 = new n0(this, n10);
        baseResourceListView.post(n02);
    }

    private /* synthetic */ void U(DialogFragment dialogFragment) {
        this.i.i(false);
    }

    private /* synthetic */ void W(d.v.c.b2.w.a a10, DialogFragment object) {
        this.i.i(true);
        object = this.h;
        Context context = this.requireContext();
        ((u)object).n(context, a10);
    }

    private /* synthetic */ void Y(Integer n10) {
        BaseResourceListView baseResourceListView = this.g.b;
        int n11 = n10;
        baseResourceListView.smoothScrollToPosition(n11);
    }

    private void a0(int n10, q object) {
        Object object2;
        int n11;
        d.v.h.f.a a10 = this.h.F(n10, (q)object);
        int n12 = a10.f();
        if (n12 == (n11 = ((d.v.h.f.a)(object2 = this.j.P())).f())) {
            return;
        }
        object = this.j;
        n12 = (int)(((TemplateEditViewModel)object).W() ? 1 : 0);
        n10 = (int)(this.j.K0(a10) ? 1 : 0);
        object2 = this.j;
        n11 = (int)(((TemplateEditViewModel)object2).s0() ? 1 : 0);
        if (n11 == 0) {
            object2 = this.j.U();
            Boolean bl2 = Boolean.TRUE;
            d.v.e.i.h.g((MutableLiveData)object2, bl2);
        }
        if (n12 != 0) {
            object = this.j;
            ((TemplateEditViewModel)object).z0();
        }
        if (n10 != 0) {
            this.E();
        }
    }

    private void b0() {
        Object object;
        int n10;
        e e10 = new e();
        int n11 = this.j.s0();
        e10 = e10.e(n11 != 0);
        d.v.h.f.a a10 = this.j.R().a();
        e10 = e10.f(a10);
        a10 = null;
        for (n11 = 0; n11 < (n10 = (object = this.j.Y()).size()); ++n11) {
            object = ((d)this.j.Y().get(n11)).w().a();
            e10.d(n11, object);
        }
        this.h.U(e10);
    }

    private void c0(boolean bl2) {
        if (bl2) {
            StatusView statusView = this.g.d;
            statusView.d();
        } else {
            StatusView statusView = this.g.d;
            statusView.a();
        }
    }

    public static /* synthetic */ u u(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        return editorTemplateFilterFragment.h;
    }

    public static /* synthetic */ int v(EditorTemplateFilterFragment editorTemplateFilterFragment, int n10) {
        editorTemplateFilterFragment.b = n10;
        return n10;
    }

    public static /* synthetic */ boolean w(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        return editorTemplateFilterFragment.H();
    }

    public static /* synthetic */ void x(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        editorTemplateFilterFragment.t();
    }

    public static /* synthetic */ void y(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        editorTemplateFilterFragment.r();
    }

    public static /* synthetic */ TemplateEditViewModel z(EditorTemplateFilterFragment editorTemplateFilterFragment) {
        return editorTemplateFilterFragment.j;
    }

    public /* synthetic */ void J(d.v.c.b2.w.a a10) {
        this.I(a10);
    }

    public /* synthetic */ void L(Boolean bl2) {
        this.K(bl2);
    }

    public /* synthetic */ void N(Integer n10) {
        this.M(n10);
    }

    public /* synthetic */ void P(Integer n10) {
        this.O(n10);
    }

    public /* synthetic */ void R(List list) {
        this.Q(list);
    }

    public /* synthetic */ void T(Integer n10) {
        this.S(n10);
    }

    public /* synthetic */ void V(DialogFragment dialogFragment) {
        this.U(dialogFragment);
    }

    public /* synthetic */ void X(d.v.c.b2.w.a a10, DialogFragment dialogFragment) {
        this.W(a10, dialogFragment);
    }

    public /* synthetic */ void Z(Integer n10) {
        this.Y(n10);
    }

    public int h() {
        return 2131558600;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (z8)object;
        this.g = object;
        ((ViewDataBinding)object).getRoot().setClickable(true);
        this.h = object = (u)d.v.i0.b.a(this).get(u.class);
        this.j = object = (TemplateEditViewModel)d.v.i0.b.c(this.requireActivity()).get(TemplateEditViewModel.class);
        this.i = object = (z)d.v.i0.b.a(this).get(z.class);
        object = this.g;
        Object object2 = this.h;
        ((z8)object).B((u)object2);
        object = this.g;
        object2 = new EditorTemplateFilterFragment$a(this);
        ((z8)object).A((EditorTemplateFilterFragment$a)object2);
        this.C();
    }

    public void j() {
        this.r();
    }

    public boolean s(int n10) {
        this.g.u().h(n10);
        return this.H() ^ true;
    }
}

