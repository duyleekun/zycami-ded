/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.R$color;
import com.zhiyun.account.R$id;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.set.privacy.BindSuccessFragment$a;
import d.v.a.g.c0;
import d.v.a.j.c.a;
import d.v.a.j.c.b;
import d.v.a.j.c.c;
import d.v.a.j.c.d;
import d.v.a.j.c.e;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.i.g;
import d.v.g0.i;
import d.v.g0.i$c;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.o;
import d.v.g0.s;
import java.util.ArrayList;
import java.util.List;

public class BindSuccessFragment
extends d.v.f.h.a {
    private c0 b;
    private y c;
    private int d = 0;

    public static /* synthetic */ y j(BindSuccessFragment bindSuccessFragment) {
        return bindSuccessFragment.c;
    }

    public static /* synthetic */ int k(BindSuccessFragment bindSuccessFragment) {
        return bindSuccessFragment.d;
    }

    public static /* synthetic */ void l(BindSuccessFragment bindSuccessFragment, View view, boolean bl2) {
        bindSuccessFragment.x(view, bl2);
    }

    private void m() {
        Object object = this.b;
        Object object2 = this.c;
        ((c0)object).B((y)object2);
        object = this.c.y;
        object2 = this.getViewLifecycleOwner();
        c c10 = new c(this);
        ((LiveData)object).observe((LifecycleOwner)object2, c10);
    }

    private void n() {
        j j10 = this.c.o;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new b(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.r;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = d.v.a.j.c.j.a;
        j10.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void o(Integer n10) {
        int n11;
        this.d = n11 = n10.intValue();
    }

    private /* synthetic */ void q(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void s(boolean n10, View view, int n11) {
        if (n11 == 0) {
            this.y(n10 != 0);
        } else {
            n10 = 1;
            if (n10 == n11) {
                n10 = R$id.bindChangeFirstFragment;
                d.v.a.k.a.a(view, n10);
            }
        }
    }

    public static /* synthetic */ void u(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void v(boolean bl2, DialogFragment object) {
        object = this.c;
        Context context = this.getContext();
        ((y)object).v(context, bl2);
    }

    private void x(View object, boolean bl2) {
        Object object2 = new ArrayList();
        int n10 = R$string.set_remove_bind;
        String string2 = g.q((View)object, n10);
        int n11 = R$color.zyui_text_1;
        int n12 = g.d((View)object, n11);
        Object object3 = new o(string2, n12);
        object2.add(object3);
        n10 = R$string.device_replace;
        string2 = g.q((View)object, n10);
        n11 = g.d((View)object, n11);
        object3 = new o(string2, n11);
        object2.add(object3);
        object2 = i.w(false).B((List)object2);
        object3 = new d(this, bl2, (View)object);
        object = ((i)object2).D((i$c)object3);
        FragmentManager fragmentManager = this.getChildFragmentManager();
        object2 = i.class.getName();
        ((DialogFragment)object).show(fragmentManager, (String)object2);
    }

    private void y(boolean bl2) {
        Object object = this.getContext();
        Object object2 = new k$b((Context)object);
        int n10 = bl2 ? R$string.set_remove_bind_phone : R$string.set_remove_bind_email;
        object2 = (k$b)((k$a)object2).A(n10);
        object = a.a;
        object2 = (k$b)((k$a)object2).p((d.v.f.f.a)object);
        object = new e(this, bl2);
        k$b k$b = (k$b)((k$a)object2).w((d.v.f.f.a)object);
        object2 = this.getChildFragmentManager();
        k$b.D((FragmentManager)object2);
    }

    public int h() {
        return R$layout.set_private_bind_success_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (c0)viewDataBinding;
        this.b = viewDataBinding;
        BindSuccessFragment$a bindSuccessFragment$a = new BindSuccessFragment$a(this);
        ((c0)viewDataBinding).A(bindSuccessFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (y)d.v.i0.b.c(this.requireActivity()).get(y.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m();
        this.n();
    }

    public /* synthetic */ void p(Integer n10) {
        this.o(n10);
    }

    public /* synthetic */ void r(Boolean bl2) {
        this.q(bl2);
    }

    public /* synthetic */ void t(boolean bl2, View view, int n10) {
        this.s(bl2, view, n10);
    }

    public /* synthetic */ void w(boolean bl2, DialogFragment dialogFragment) {
        this.v(bl2, dialogFragment);
    }
}

