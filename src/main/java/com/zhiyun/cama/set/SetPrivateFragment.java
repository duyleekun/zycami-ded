/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.CheckBox
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.zhiyun.cama.set;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import androidx.databinding.ViewDataBinding;
import com.zhiyun.cama.set.SetPrivateFragment$a;
import d.v.c.q1.g0;
import d.v.c.q1.v;
import d.v.c.q1.w;
import d.v.c.q1.x;
import d.v.c.w0.sg;
import d.v.f.h.a;
import d.v.i0.b;

public class SetPrivateFragment
extends a {
    private sg b;
    private g0 c;

    private void j() {
        this.c.G();
        sg sg2 = this.b;
        g0 g02 = this.c;
        sg2.B(g02);
    }

    private void k() {
        CheckBox checkBox = this.b.c;
        Object object = new w(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.b;
        object = new v(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        checkBox = this.b.a;
        object = new x(this);
        checkBox.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
    }

    private /* synthetic */ void l(CompoundButton compoundButton, boolean bl2) {
        this.c.V(bl2);
    }

    private /* synthetic */ void n(CompoundButton compoundButton, boolean bl2) {
        this.c.T(bl2);
    }

    private /* synthetic */ void p(CompoundButton compoundButton, boolean bl2) {
        this.c.N(bl2);
    }

    public int h() {
        return 2131558762;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (sg)viewDataBinding;
        this.b = viewDataBinding;
        SetPrivateFragment$a setPrivateFragment$a = new SetPrivateFragment$a(this);
        ((sg)viewDataBinding).A(setPrivateFragment$a);
    }

    public /* synthetic */ void m(CompoundButton compoundButton, boolean bl2) {
        this.l(compoundButton, bl2);
    }

    public /* synthetic */ void o(CompoundButton compoundButton, boolean bl2) {
        this.n(compoundButton, bl2);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (g0)d.v.i0.b.c(this.requireActivity()).get(g0.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.j();
        this.k();
    }

    public /* synthetic */ void q(CompoundButton compoundButton, boolean bl2) {
        this.p(compoundButton, bl2);
    }
}

