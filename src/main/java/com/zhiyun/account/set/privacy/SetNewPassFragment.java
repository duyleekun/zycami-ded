/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.account.set.privacy;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.me.account.widget.MePassView;
import com.zhiyun.account.set.privacy.SetNewPassFragment$a;
import d.v.a.g.k0;
import d.v.a.i.a.y0.e;
import d.v.a.j.c.m;
import d.v.a.j.c.n;
import d.v.a.j.c.o;
import d.v.a.j.c.p;
import d.v.a.j.c.q;
import d.v.a.j.c.y;
import d.v.e.i.j;
import d.v.f.h.a;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class SetNewPassFragment
extends a {
    private k0 b;
    private y c;

    public static /* synthetic */ k0 j(SetNewPassFragment setNewPassFragment) {
        return setNewPassFragment.b;
    }

    public static /* synthetic */ y k(SetNewPassFragment setNewPassFragment) {
        return setNewPassFragment.c;
    }

    private void l() {
        k0 k02 = this.b;
        y y10 = this.c;
        k02.B(y10);
    }

    private void m() {
        MePassView mePassView = this.b.b;
        e e10 = new o(this);
        mePassView.setOnTextChangedListener(e10);
        mePassView = this.b.c;
        e10 = new p(this);
        mePassView.setOnTextChangedListener(e10);
    }

    private void n() {
        j j10 = this.c.o;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new m(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.r;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = d.v.a.j.c.j.a;
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.t;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new n(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.q;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new q(this);
        j10.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void o(String string2) {
        string2 = this.b.b.getPass();
        String string3 = this.b.c.getPass();
        this.y(string2, string3);
    }

    private /* synthetic */ void q(String string2) {
        string2 = this.b.b.getPass();
        String string3 = this.b.c.getPass();
        this.y(string2, string3);
    }

    private /* synthetic */ void s(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void u(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private /* synthetic */ void w(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private void y(String object, String string2) {
        MutableLiveData mutableLiveData = this.c.c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        object = bl2;
        mutableLiveData.setValue(object);
    }

    public int h() {
        return R$layout.set_private_set_new_pass_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (k0)viewDataBinding;
        this.b = viewDataBinding;
        SetNewPassFragment$a setNewPassFragment$a = new SetNewPassFragment$a(this);
        ((k0)viewDataBinding).A(setNewPassFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (y)d.v.i0.b.c(this.requireActivity()).get(y.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.l();
        this.m();
        this.n();
    }

    public /* synthetic */ void p(String string2) {
        this.o(string2);
    }

    public /* synthetic */ void r(String string2) {
        this.q(string2);
    }

    public /* synthetic */ void t(Boolean bl2) {
        this.s(bl2);
    }

    public /* synthetic */ void v(Boolean bl2) {
        this.u(bl2);
    }

    public /* synthetic */ void x(String string2) {
        this.w(string2);
    }
}

