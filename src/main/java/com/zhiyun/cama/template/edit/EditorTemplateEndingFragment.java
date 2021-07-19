/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.widget.ImageView
 */
package com.zhiyun.cama.template.edit;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemDecoration;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment$a;
import com.zhiyun.cama.template.edit.EditorTemplateEndingFragment$b;
import com.zhiyun.cama.template.edit.TemplateEditViewModel;
import com.zhiyun.editortemplate.data.database.model.template.TemplatePOJO;
import com.zhiyun.editortemplate.data.resource.Status;
import d.v.c.d1.e;
import d.v.c.d1.f;
import d.v.c.d1.h;
import d.v.c.k1.a.s;
import d.v.c.q0.c;
import d.v.c.u1.m.g0;
import d.v.c.u1.m.h0;
import d.v.c.u1.m.i0;
import d.v.c.u1.m.j0;
import d.v.c.u1.m.k0;
import d.v.c.u1.m.l0;
import d.v.c.u1.m.m0;
import d.v.c.w0.x8;
import d.v.e.l.h2;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import d.v.j.e.h.k;
import d.v.j.g.z;
import java.util.List;
import m.a.a;

public class EditorTemplateEndingFragment
extends c {
    private x8 g;
    private h h;
    private TemplateEditViewModel i;
    private z j;
    private d.v.j.f.g k;
    private f l;

    private void A() {
        LiveData liveData = this.k.i();
        Object object = new l0(this);
        liveData.observe(this, (Observer)object);
        liveData = this.h.g();
        object = this.getViewLifecycleOwner();
        Observer observer = new g0(this);
        liveData.observe((LifecycleOwner)object, observer);
        liveData = this.h.f();
        object = this.getViewLifecycleOwner();
        observer = new k0(this);
        liveData.observe((LifecycleOwner)object, observer);
        liveData = this.h.l();
        object = this.getViewLifecycleOwner();
        observer = new j0(this);
        liveData.observe((LifecycleOwner)object, observer);
    }

    private void B() {
        Object object = this.h;
        Object object2 = new f((LifecycleOwner)this, (h)object);
        this.l = object2;
        object2 = this.g.b;
        Context context = this.requireContext();
        object = new LinearLayoutManager(context, 0, false);
        ((RecyclerView)object2).setLayoutManager((RecyclerView$LayoutManager)object);
        object2 = this.g.b;
        int n10 = h2.b(8.0f);
        float f10 = 20.0f;
        int n11 = h2.b(f10);
        int n12 = h2.b(f10);
        object = new s(n10, n11, n12);
        ((RecyclerView)object2).addItemDecoration((RecyclerView$ItemDecoration)object);
    }

    private /* synthetic */ void C(k object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("get templateDataList, state:");
        Status status = ((k)object).a;
        ((StringBuilder)object2).append((Object)status);
        ((StringBuilder)object2).append(object);
        object2 = ((StringBuilder)object2).toString();
        status = null;
        Object object3 = new Object[]{};
        a.b((String)object2, (Object[])object3);
        object2 = EditorTemplateEndingFragment$a.a;
        object3 = ((k)object).a;
        int n10 = ((Enum)object3).ordinal();
        Object object4 = object2[n10];
        n10 = 3;
        if (object4 == n10 || object4 == (n10 = 4)) {
            object2 = this.h;
            object = (List)((k)object).c;
            object = ((h)object2).b((List)object);
            this.h.w((List)object, false);
            object2 = this.l;
            ((d.v.f.d.b)object2).m((List)object);
            this.S(false);
        }
    }

    private /* synthetic */ void E(e object) {
        if (object == null) {
            return;
        }
        Object object2 = this.j;
        boolean bl2 = ((z)object2).f();
        if (bl2) {
            object2 = d.v.f.i.g.o(this.getResources(), 2131951893);
            Object object3 = this.getContext();
            Object object4 = new k$b((Context)object3);
            object2 = (k$b)((k$a)object4).n((String)object2);
            object4 = new h0(this);
            object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object4);
            int n10 = 2131951892;
            object3 = new m0(this, (e)object);
            object = ((k$b)((k$b)((k$a)object2).v(n10, (d.v.f.f.a)object3)).s()).b();
            object2 = this.getChildFragmentManager();
            object4 = this.getClass().getSimpleName();
            ((DialogFragment)object).show((FragmentManager)object2, (String)object4);
        } else {
            object2 = this.k;
            object = ((e)object).b();
            ((d.v.j.f.g)object2).d((TemplatePOJO)object);
        }
    }

    private /* synthetic */ void G(Integer object) {
        boolean bl2;
        if (object == null) {
            return;
        }
        ViewModel viewModel = this.h;
        int n10 = (Integer)object;
        viewModel = this.i;
        object = ((h)viewModel).i(n10);
        if ((n10 = (int)(((TemplateEditViewModel)viewModel).r((e)object, bl2 = true) ? 1 : 0)) != 0) {
            this.z();
            object = this.i;
            ((TemplateEditViewModel)object).z0();
        }
    }

    private /* synthetic */ void I(Integer n10) {
        if (n10 == null) {
            return;
        }
        RecyclerView recyclerView = this.g.b;
        i0 i02 = new i0(this, n10);
        recyclerView.post(i02);
    }

    private /* synthetic */ void K(DialogFragment dialogFragment) {
        this.j.i(false);
    }

    private /* synthetic */ void M(e object, DialogFragment object2) {
        this.j.i(true);
        object2 = this.k;
        object = ((e)object).b();
        ((d.v.j.f.g)object2).d((TemplatePOJO)object);
    }

    private /* synthetic */ void O(Integer n10) {
        RecyclerView recyclerView = this.g.b;
        int n11 = n10;
        recyclerView.smoothScrollToPosition(n11);
    }

    private void Q() {
        this.g.c.e();
        this.k.H(-998L, 1);
    }

    private void R() {
        h h10 = this.h;
        e e10 = this.i.N();
        h10.x(e10);
    }

    private void S(boolean bl2) {
        if (bl2) {
            StatusView statusView = this.g.c;
            statusView.d();
        } else {
            StatusView statusView = this.g.c;
            statusView.a();
        }
    }

    public static /* synthetic */ h u(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        return editorTemplateEndingFragment.h;
    }

    public static /* synthetic */ TemplateEditViewModel v(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        return editorTemplateEndingFragment.i;
    }

    public static /* synthetic */ void w(EditorTemplateEndingFragment editorTemplateEndingFragment) {
        editorTemplateEndingFragment.Q();
    }

    private void x() {
        this.B();
        this.y();
        this.A();
    }

    private void y() {
        f f10;
        this.R();
        h h10 = this.h;
        this.l = f10 = new f((LifecycleOwner)this, h10);
        this.g.b.setAdapter(f10);
        this.Q();
        this.z();
    }

    private void z() {
        e e10 = this.i.N();
        this.h.e(e10);
    }

    public /* synthetic */ void D(k k10) {
        this.C(k10);
    }

    public /* synthetic */ void F(e e10) {
        this.E(e10);
    }

    public /* synthetic */ void H(Integer n10) {
        this.G(n10);
    }

    public /* synthetic */ void J(Integer n10) {
        this.I(n10);
    }

    public /* synthetic */ void L(DialogFragment dialogFragment) {
        this.K(dialogFragment);
    }

    public /* synthetic */ void N(e e10, DialogFragment dialogFragment) {
        this.M(e10, dialogFragment);
    }

    public /* synthetic */ void P(Integer n10) {
        this.O(n10);
    }

    public int h() {
        return 2131558599;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (x8)object;
        this.g = object;
        ((ViewDataBinding)object).getRoot().setClickable(true);
        object = d.v.i0.b.a(this);
        Object object2 = (h)((ViewModelProvider)object).get(h.class);
        this.h = object2;
        this.k = object = (d.v.j.f.g)((ViewModelProvider)object).get(d.v.j.f.g.class);
        this.i = object = (TemplateEditViewModel)d.v.i0.b.c(this.requireActivity()).get(TemplateEditViewModel.class);
        object = this.g;
        object2 = this.h;
        ((x8)object).B((h)object2);
        object = this.g;
        object2 = new EditorTemplateEndingFragment$b(this);
        ((x8)object).A((EditorTemplateEndingFragment$b)object2);
        this.x();
    }

    public boolean s(int n10) {
        EditorTemplateEndingFragment$b editorTemplateEndingFragment$b = this.g.u();
        ImageView imageView = this.g.a.b;
        editorTemplateEndingFragment$b.b((View)imageView);
        return true;
    }
}

