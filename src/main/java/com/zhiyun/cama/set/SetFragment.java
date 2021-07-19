/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.zhiyun.cama.set;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.DynamicZoomViewModel;
import com.zhiyun.cama.set.SetFragment$a;
import d.v.c.i1.r2;
import d.v.c.q1.g0;
import d.v.c.q1.p;
import d.v.c.q1.q;
import d.v.c.q1.r;
import d.v.c.q1.s;
import d.v.c.q1.t;
import d.v.c.q1.u;
import d.v.c.s0.u6;
import d.v.c.w0.og;
import d.v.e.l.n2;
import d.v.f.h.a;
import d.v.i0.b;

public class SetFragment
extends a {
    private og b;
    private g0 c;
    private u6 d;
    private DynamicZoomViewModel e;
    private r2 f;

    public static /* synthetic */ g0 j(SetFragment setFragment) {
        return setFragment.c;
    }

    public static /* synthetic */ u6 k(SetFragment setFragment) {
        return setFragment.d;
    }

    public static /* synthetic */ DynamicZoomViewModel l(SetFragment setFragment) {
        return setFragment.e;
    }

    private void m() {
        this.c.G();
        this.c.H();
        Object object = this.b;
        Object object2 = this.c;
        ((og)object).B((g0)object2);
        object = this.c.x();
        object2 = this.getViewLifecycleOwner();
        q q10 = new q(this);
        ((LiveData)object).observe((LifecycleOwner)object2, q10);
    }

    private void n() {
        CheckBox checkBox = this.b.b;
        Object object = new u(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.a;
        object = new p(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.d;
        object = new s(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.e;
        object = new r(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.c;
        object = new t(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
    }

    private /* synthetic */ void o(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            n2.e((String)object);
            object = this.c;
            bl2 = false;
            ((g0)object).S(null);
        }
    }

    private /* synthetic */ void q(CompoundButton object, boolean bl2) {
        object = this.c;
        Context context = this.requireContext();
        ((g0)object).Q(context, bl2);
    }

    private /* synthetic */ void s(CompoundButton compoundButton, boolean bl2) {
        this.c.P(bl2);
    }

    private /* synthetic */ void u(CompoundButton object, boolean bl2) {
        object = this.c;
        Context context = this.requireContext();
        ((g0)object).U(context, bl2);
    }

    private /* synthetic */ void w(CompoundButton object, boolean bl2) {
        object = this.c;
        Context context = this.requireContext();
        ((g0)object).W(context, bl2);
    }

    private /* synthetic */ void y(CompoundButton object, boolean bl2) {
        if (!bl2) {
            object = this.f;
            ((r2)object).j();
        }
        this.c.R(bl2);
    }

    public int h() {
        return 2131558755;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (og)viewDataBinding;
        this.b = viewDataBinding;
        SetFragment$a setFragment$a = new SetFragment$a(this);
        ((og)viewDataBinding).A(setFragment$a);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.e = viewModel = (DynamicZoomViewModel)((ViewModelProvider)object).get(DynamicZoomViewModel.class);
        viewModel = (u6)((ViewModelProvider)object).get(u6.class);
        this.d = viewModel;
        viewModel = (g0)((ViewModelProvider)object).get(g0.class);
        this.c = viewModel;
        this.f = object = (r2)((ViewModelProvider)object).get(r2.class);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m();
        this.n();
    }

    public /* synthetic */ void p(String string2) {
        this.o(string2);
    }

    public /* synthetic */ void r(CompoundButton compoundButton, boolean bl2) {
        this.q(compoundButton, bl2);
    }

    public /* synthetic */ void t(CompoundButton compoundButton, boolean bl2) {
        this.s(compoundButton, bl2);
    }

    public /* synthetic */ void v(CompoundButton compoundButton, boolean bl2) {
        this.u(compoundButton, bl2);
    }

    public /* synthetic */ void x(CompoundButton compoundButton, boolean bl2) {
        this.w(compoundButton, bl2);
    }

    public /* synthetic */ void z(CompoundButton compoundButton, boolean bl2) {
        this.y(compoundButton, bl2);
    }
}

