/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.zhiyun.cama.transition;

import android.content.Context;
import android.os.Bundle;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.transition.EditorTransitionFragment$a;
import com.zhiyun.cama.widget.base.BaseResourceListView;
import com.zhiyun.cama.widget.base.BaseResourceListView$ResourceType;
import d.v.c.b1.t.g;
import d.v.c.i1.i2;
import d.v.c.m0;
import d.v.c.v1.a;
import d.v.c.v1.c;
import d.v.c.v1.d;
import d.v.c.v1.e;
import d.v.c.v1.f;
import d.v.c.v1.h;
import d.v.c.v1.l;
import d.v.c.v1.o;
import d.v.c.w0.n8;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import d.v.j.g.z;
import java.util.List;

public class EditorTransitionFragment
extends d.v.c.q0.d {
    private static final String n = "index";
    private n8 j;
    private o k;
    private z l;
    private int m;

    public static /* synthetic */ g A(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.g;
    }

    public static /* synthetic */ boolean B(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.L();
    }

    public static /* synthetic */ void C(EditorTransitionFragment editorTransitionFragment) {
        editorTransitionFragment.t();
    }

    public static /* synthetic */ void D(EditorTransitionFragment editorTransitionFragment, boolean bl2) {
        editorTransitionFragment.v(bl2);
    }

    public static /* synthetic */ void E(EditorTransitionFragment editorTransitionFragment, long l10) {
        editorTransitionFragment.w(l10);
    }

    public static /* synthetic */ n8 F(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.j;
    }

    public static Bundle G(int n10) {
        Bundle bundle = new Bundle();
        bundle.putInt(n, n10);
        return bundle;
    }

    private void H() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int n10;
            String string2 = n;
            this.m = n10 = bundle.getInt(string2, 0);
        } else {
            int n11;
            this.m = n11 = d.v.v.q.h.p();
        }
    }

    private void I() {
        Object object = this.k;
        int n10 = this.m;
        ((o)object).w(n10);
        this.j.h.e();
        this.k.A();
        object = this.g;
        n10 = this.m;
        object = ((i2)object).e2(n10);
        this.k.N((d.v.h.k.b)object);
    }

    private void J() {
        MutableLiveData mutableLiveData = this.k.f();
        Object object = this.getViewLifecycleOwner();
        Observer observer = new d.v.c.v1.g(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.g();
        object = this.getViewLifecycleOwner();
        observer = new d(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
        mutableLiveData = this.k.d();
        object = new f(this);
        mutableLiveData.observe(this, (Observer)object);
        mutableLiveData = this.k.y();
        object = new d.v.c.v1.b(this);
        mutableLiveData.observe(this, (Observer)object);
        mutableLiveData = this.k.F();
        object = this.getViewLifecycleOwner();
        observer = new c(this);
        mutableLiveData.observe((LifecycleOwner)object, observer);
    }

    private void K() {
        BaseResourceListView baseResourceListView = this.j.g;
        Context context = this.requireContext();
        Object object = new LinearLayoutManager(context, 0, false);
        baseResourceListView.setLayoutManager((RecyclerView$LayoutManager)object);
        baseResourceListView = this.j.g;
        object = this.k;
        baseResourceListView.b(this, (d.v.c.b2.v.b)object);
        baseResourceListView = this.j.g;
        object = BaseResourceListView$ResourceType.RESOURCE_TYPE_TRANSITION;
        baseResourceListView.setResourceType((BaseResourceListView$ResourceType)((Object)object));
    }

    private boolean L() {
        Object object = this.k;
        int n10 = ((d.v.c.b2.v.b)object).e();
        boolean bl2 = false;
        int n11 = -1;
        if (n10 == n11) {
            return false;
        }
        o o10 = this.k;
        object = o10.u(n10);
        if (object != null && (n10 = (int)(((d.v.c.b2.w.a)object).J() ? 1 : 0)) != 0 && (n10 = (int)(d.v.c.m1.b.a() ? 1 : 0)) == 0) {
            bl2 = true;
        }
        return bl2;
    }

    private /* synthetic */ void M(d.v.c.b2.w.a object) {
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
            object4 = new e(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new h(this, (d.v.c.b2.w.a)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            Context context = this.requireContext();
            ((o)object2).n(context, (d.v.c.b2.w.a)object);
        }
    }

    private /* synthetic */ void O(Integer n10) {
        int n11 = n10;
        if (n11 != 0) {
            BaseResourceListView baseResourceListView = this.j.g;
            a a10 = new a(this, n10);
            baseResourceListView.post(a10);
        }
    }

    private /* synthetic */ void Q(Integer object) {
        int n10;
        ViewModel viewModel;
        if (object == null) {
            return;
        }
        int n11 = (Integer)object;
        if (n11 == 0) {
            viewModel = this.g;
            int n12 = this.m;
            boolean bl2 = true;
            ((i2)viewModel).M2(n12, bl2);
        }
        if ((object = ((o)(viewModel = this.k)).u(n10 = ((Integer)object).intValue())) != null) {
            this.c0((l)object);
        }
    }

    private /* synthetic */ void S(Integer n10) {
        g g10 = this.g;
        int n11 = this.m;
        long[] lArray = m0.h;
        int n12 = n10;
        long l10 = lArray[n12];
        g10.e0(n11, l10, true);
    }

    private /* synthetic */ void U(List list) {
        if (list != null) {
            boolean bl2 = d.v.j.b.f(list);
            if (!bl2) {
                this.j.g.setData(list);
                Object object = this.g;
                int n10 = this.m;
                object = ((i2)object).e2(n10);
                o o10 = this.k;
                o10.r((d.v.h.k.b)object);
            }
            boolean bl3 = list.isEmpty();
            this.d0(bl3);
        }
    }

    private /* synthetic */ void W(DialogFragment dialogFragment) {
        this.l.i(false);
    }

    private /* synthetic */ void Y(d.v.c.b2.w.a a10, DialogFragment object) {
        this.l.i(true);
        object = this.k;
        Context context = this.requireContext();
        ((o)object).n(context, a10);
    }

    private /* synthetic */ void a0(Integer n10) {
        BaseResourceListView baseResourceListView = this.j.g;
        int n11 = n10;
        baseResourceListView.smoothScrollToPosition(n11);
    }

    private void c0(l object) {
        boolean bl2;
        ViewModel viewModel = this.g;
        int n10 = this.m;
        boolean bl3 = ((i2)viewModel).y(n10, (d.v.h.k.b)(object = this.k.m((l)object)), bl2 = true);
        if (bl3) {
            viewModel = this.k;
            ((o)viewModel).r((d.v.h.k.b)object);
        }
    }

    private void d0(boolean bl2) {
        if (bl2) {
            StatusView statusView = this.j.h;
            statusView.d();
        } else {
            StatusView statusView = this.j.h;
            statusView.a();
        }
    }

    public static /* synthetic */ o x(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.k;
    }

    public static /* synthetic */ int y(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.m;
    }

    public static /* synthetic */ g z(EditorTransitionFragment editorTransitionFragment) {
        return editorTransitionFragment.g;
    }

    public /* synthetic */ void N(d.v.c.b2.w.a a10) {
        this.M(a10);
    }

    public /* synthetic */ void P(Integer n10) {
        this.O(n10);
    }

    public /* synthetic */ void R(Integer n10) {
        this.Q(n10);
    }

    public /* synthetic */ void T(Integer n10) {
        this.S(n10);
    }

    public /* synthetic */ void V(List list) {
        this.U(list);
    }

    public /* synthetic */ void X(DialogFragment dialogFragment) {
        this.W(dialogFragment);
    }

    public /* synthetic */ void Z(d.v.c.b2.w.a a10, DialogFragment dialogFragment) {
        this.Y(a10, dialogFragment);
    }

    public /* synthetic */ void b0(Integer n10) {
        this.a0(n10);
    }

    public int h() {
        return 2131558594;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (n8)object;
        this.j = object;
        object = d.v.i0.b.a(this);
        Object object2 = (o)((ViewModelProvider)object).get(o.class);
        this.k = object2;
        this.l = object = (z)((ViewModelProvider)object).get(z.class);
        object = this.j;
        object2 = new EditorTransitionFragment$a(this);
        ((n8)object).A((EditorTransitionFragment$a)object2);
        object = this.j;
        object2 = this.k;
        ((n8)object).B((o)object2);
        this.H();
        this.K();
        this.I();
        this.J();
    }

    public void j() {
        this.v(true);
        this.w(128L);
        this.u();
    }

    public void k() {
        super.k();
        this.j.u().c();
    }

    public boolean s(int n10) {
        this.j.u().g(n10);
        return this.L() ^ true;
    }
}

