/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.cama.draft;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.draft.EditorDraftFragment$a;
import com.zhiyun.cama.publish.PublishActivity;
import com.zhiyun.common.util.Windows;
import d.v.c.b1.f;
import d.v.c.b1.g;
import d.v.c.b1.h;
import d.v.c.b1.i;
import d.v.c.b1.j;
import d.v.c.b1.k;
import d.v.c.b1.l;
import d.v.c.b1.m;
import d.v.c.b1.n;
import d.v.c.b1.o;
import d.v.c.b1.q;
import d.v.c.b1.r;
import d.v.c.b1.s;
import d.v.c.q0.d;
import d.v.c.w0.l6;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.g0.i$b;
import d.v.g0.i$c;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.i0.b;
import java.util.ArrayList;
import java.util.List;
import m.a.a;

public class EditorDraftFragment
extends d {
    private l6 j;
    private s k;
    private q l;

    private /* synthetic */ void A(List list) {
        list = this.k.e(list);
        this.l.l(list);
        this.S(list);
    }

    private /* synthetic */ void C(View objectArray, int n10, r r10) {
        long l10;
        long l11 = r10 == null ? l10 : r10.t();
        long l12 = l11 - (l10 = (long)-1);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            object = 0;
            objectArray = new Object[]{};
            String string2 = "\u8349\u7a3f\u4fe1\u606f\u5f02\u5e38.....";
            a.i(string2, objectArray);
        }
        PublishActivity.j(this, l11);
    }

    private /* synthetic */ void E(Integer object) {
        ObservableArrayList observableArrayList;
        int n10;
        ObservableArrayList observableArrayList2;
        int n11 = (Integer)object;
        if (n11 >= 0 && (n11 = (int)(d.v.j.b.f(observableArrayList2 = this.l.d()) ? 1 : 0)) == 0 && (n11 = ((Integer)object).intValue()) < (n10 = (observableArrayList = this.l.d()).size())) {
            n11 = (Integer)object;
            observableArrayList = this.l.d();
            int n12 = (Integer)object;
            object = (r)observableArrayList.get(n12);
            this.T(n11, (r)object);
        }
    }

    public static /* synthetic */ void G(r r10, String string2, DialogFragment dialogFragment) {
        r10.z(string2);
        dialogFragment.dismiss();
    }

    public static /* synthetic */ void H(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void I(r r10, DialogFragment object) {
        object = this.k;
        long l10 = r10.t();
        ((s)object).b(l10);
    }

    private /* synthetic */ void K(r r10, int n10) {
        if (n10 == 0) {
            this.U(r10);
        } else {
            int n11 = 1;
            if (n10 == n11) {
                this.R(r10);
            }
        }
    }

    public static /* synthetic */ void M() {
    }

    public static /* synthetic */ void N(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void O(r r10, DialogFragment dialogFragment) {
        Object object = dialogFragment;
        object = ((d.v.g0.k)dialogFragment).G();
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return;
        }
        s s10 = this.k;
        bl2 = s10.g((String)object);
        if (bl2) {
            n2.e(d.v.f.i.g.o(this.getResources(), 2131952039));
            return;
        }
        s10 = this.k;
        long l10 = r10.t();
        f f10 = new f(r10, (String)object, dialogFragment);
        s10.p(l10, (String)object, f10);
    }

    public static EditorDraftFragment Q() {
        EditorDraftFragment editorDraftFragment = new EditorDraftFragment();
        return editorDraftFragment;
    }

    private void R(r object) {
        Object object2 = this.requireContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$a)object3).A(2131952038);
        object2 = i.a;
        object3 = (k$b)((k$a)object3).p((d.v.f.f.a)object2);
        object2 = new k(this, (r)object);
        object = (k$b)((k$a)object3).w((d.v.f.f.a)object2);
        object3 = this.getParentFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private void S(List object) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.j.c.c();
            this.j.c.setEmptyText(2131952130);
            object = this.j.c;
            int n10 = 2131231804;
            ((StatusView)((Object)object)).setEmptyImage(n10);
        } else {
            object = this.j.c;
            ((StatusView)((Object)object)).a();
        }
    }

    private void T(int n10, r object) {
        Object object2 = new ArrayList();
        String string2 = d.v.f.i.g.m(this.requireContext(), 2131952603);
        int n11 = o1.a(this.requireContext(), 2131099772);
        Object object3 = new d.v.g0.o(string2, n11);
        object2.add(object3);
        string2 = d.v.f.i.g.m(this.requireContext(), 2131951903);
        n11 = o1.a(this.requireContext(), 2131099853);
        object3 = new d.v.g0.o(string2, n11);
        object2.add(object3);
        object2 = d.v.g0.i.v().B((List)object2);
        object3 = new g(this, (r)object);
        object2 = ((d.v.g0.i)object2).D((i$c)object3);
        object = d.v.c.b1.j.a;
        object2 = ((d.v.g0.i)object2).C((i$b)object);
        object = this.getChildFragmentManager();
        object3 = d.v.g0.i.class.getName();
        ((DialogFragment)object2).show((FragmentManager)object, (String)object3);
    }

    private void U(r object) {
        Object object2 = this.requireContext();
        Object object3 = new k$b((Context)object2);
        object3 = (k$b)((k$b)((k$a)object3).A(2131952015)).E(true);
        object2 = ((r)object).s();
        object3 = (k$b)((k$a)object3).k((String)object2);
        object2 = d.v.c.b1.l.a;
        object3 = (k$b)((k$a)object3).p((d.v.f.f.a)object2);
        object2 = new h(this, (r)object);
        object = (k$b)((k$a)object3).w((d.v.f.f.a)object2);
        object3 = this.getParentFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private void x() {
        LiveData liveData = this.k.d();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        m m10 = new m(this);
        liveData.observe(lifecycleOwner, m10);
    }

    private void y() {
        Object object = this.l;
        Object object2 = new n(this);
        ((d.v.f.d.b)object).n((d.v.f.f.b)object2);
        object = this.k.f();
        object2 = this.getViewLifecycleOwner();
        o o10 = new o(this);
        ((LiveData)object).observe((LifecycleOwner)object2, o10);
    }

    private void z() {
        Windows.a((View)this.j.a);
        Object object = this.j.b;
        Context context = this.requireContext();
        Object object2 = new LinearLayoutManager(context, 1, false);
        ((RecyclerView)object).setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = this.k;
        this.l = object = new q((LifecycleOwner)this, (s)object2);
        this.j.b.setAdapter((RecyclerView$Adapter)object);
    }

    public /* synthetic */ void B(List list) {
        this.A(list);
    }

    public /* synthetic */ void D(View view, int n10, r r10) {
        this.C(view, n10, r10);
    }

    public /* synthetic */ void F(Integer n10) {
        this.E(n10);
    }

    public /* synthetic */ void J(r r10, DialogFragment dialogFragment) {
        this.I(r10, dialogFragment);
    }

    public /* synthetic */ void L(r r10, int n10) {
        this.K(r10, n10);
    }

    public /* synthetic */ void P(r r10, DialogFragment dialogFragment) {
        this.O(r10, dialogFragment);
    }

    public int h() {
        return 2131558567;
    }

    public void i(ViewDataBinding object) {
        super.i((ViewDataBinding)object);
        object = (l6)object;
        this.j = object;
        EditorDraftFragment$a editorDraftFragment$a = new EditorDraftFragment$a(this);
        ((l6)object).z(editorDraftFragment$a);
        this.k = object = (s)d.v.i0.b.a(this).get(s.class);
        this.z();
        this.x();
        this.y();
    }
}

