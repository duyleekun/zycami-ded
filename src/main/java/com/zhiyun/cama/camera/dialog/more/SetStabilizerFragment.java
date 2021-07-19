/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.CheckedTextView
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.SeekBar$OnSeekBarChangeListener
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$a;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$b;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment$c;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.cama.camera.widget.CheckedGroup$d;
import com.zhiyun.protocol.constants.JoystickSpeed;
import com.zhiyun.protocol.constants.SceneMode;
import com.zhiyun.protocol.constants.WorkingMode;
import com.zhiyun.protocol.message.bl.keyfunc.KeyFunc;
import com.zhiyun.ui.ShadowSeekBar;
import d.v.c.s0.a7.j1;
import d.v.c.s0.a7.m1;
import d.v.c.s0.a7.o1.i;
import d.v.c.s0.a7.o1.j;
import d.v.c.s0.a7.o1.k;
import d.v.c.s0.a7.o1.n;
import d.v.c.s0.a7.o1.o;
import d.v.c.s0.a7.o1.p;
import d.v.c.s0.a7.o1.q;
import d.v.c.s0.a7.o1.r;
import d.v.c.s0.a7.o1.s;
import d.v.c.s0.a7.o1.t;
import d.v.c.s0.a7.o1.u;
import d.v.c.s0.a7.o1.v;
import d.v.c.s0.a7.o1.w;
import d.v.c.s0.q6;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.w0.z1;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.i0.b;

public class SetStabilizerFragment
extends a {
    private z1 b;
    private s6 c;
    private j1 d;
    private BleViewModel e;
    private u6 f;

    private /* synthetic */ void A(Boolean bl2) {
        CheckedTextView checkedTextView = this.b.g;
        boolean bl3 = bl2;
        checkedTextView.setChecked(bl3);
    }

    private /* synthetic */ void C(Boolean bl2) {
        CheckedTextView checkedTextView = this.b.f;
        boolean bl3 = bl2;
        checkedTextView.setChecked(bl3);
    }

    private /* synthetic */ void E(Integer n10) {
        ShadowSeekBar shadowSeekBar = this.b.m;
        int n11 = n10;
        shadowSeekBar.setProgress(n11);
    }

    private /* synthetic */ void G(CheckedGroup object, int n10) {
        object = (RadioButton)object.findViewById(n10);
        Object object2 = this.b.a;
        String string2 = object.getText().toString();
        object2.setText((CharSequence)string2);
        object = (String)object.getTag();
        object2 = this.e;
        object = KeyFunc.valueOf((String)object);
        ((BleViewModel)object2).m1((KeyFunc)((Object)object));
    }

    private /* synthetic */ void I(CheckedGroup object, int n10) {
        object = JoystickSpeed.valueOf((String)object.findViewById(n10).getTag());
        this.e.k1((JoystickSpeed)((Object)object));
    }

    private /* synthetic */ void K(RadioGroup object, int n10) {
        object = (String)object.findViewById(n10).getTag();
        this.e.j1((String)object);
    }

    private /* synthetic */ void M(CheckedGroup object, int n10) {
        object = SceneMode.valueOf((String)object.findViewById(n10).getTag());
        this.e.p1((SceneMode)((Object)object));
    }

    private /* synthetic */ void O(CompoundButton object, boolean n10) {
        object = this.b.b;
        n10 = n10 != 0 ? 0 : 8;
        object.setVisibility(n10);
    }

    public static /* synthetic */ u6 j(SetStabilizerFragment setStabilizerFragment) {
        return setStabilizerFragment.f;
    }

    public static /* synthetic */ BleViewModel k(SetStabilizerFragment setStabilizerFragment) {
        return setStabilizerFragment.e;
    }

    public static /* synthetic */ s6 l(SetStabilizerFragment setStabilizerFragment) {
        return setStabilizerFragment.c;
    }

    public static /* synthetic */ j1 m(SetStabilizerFragment setStabilizerFragment) {
        return setStabilizerFragment.d;
    }

    private void n() {
        this.b.e.g(2131363066);
        this.b.d.g(2131363036);
        this.b.c.check(2131363031);
        this.b.b.g(2131363020);
        Object object = this.b.a;
        Object object2 = g.o(this.getResources(), 2131952741);
        object.setText((CharSequence)object2);
        object = this.b;
        object2 = this.e;
        ((z1)object).B((BleViewModel)object2);
        object = this.b;
        object2 = this.f;
        ((z1)object).C((u6)object2);
        object = this.e.a;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new s(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.b;
        object2 = this.getViewLifecycleOwner();
        observer = new j(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.c;
        object2 = this.getViewLifecycleOwner();
        observer = new w(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.F;
        object2 = this.getViewLifecycleOwner();
        observer = new i(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.g;
        object2 = this.getViewLifecycleOwner();
        observer = new r(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.e;
        object2 = this.getViewLifecycleOwner();
        observer = new o(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.d;
        object2 = this.getViewLifecycleOwner();
        observer = new u(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.f.H0();
        object2 = this.getViewLifecycleOwner();
        observer = new v(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void o() {
        Object object = this.b.e;
        Object object2 = new n(this);
        object.setOnCheckedChangeListener((CheckedGroup$d)object2);
        object = this.b.a;
        object2 = new k(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.b;
        object2 = new p(this);
        object.setOnCheckedChangeListener((CheckedGroup$d)object2);
        object = this.b.d;
        object2 = new q(this);
        object.setOnCheckedChangeListener((CheckedGroup$d)object2);
        object = this.b.c;
        object2 = new t(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.m;
        object2 = new SetStabilizerFragment$a(this);
        object.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener)object2);
    }

    private void p() {
    }

    private /* synthetic */ void q(SceneMode object) {
        CheckedGroup checkedGroup = this.b.e;
        object = object.name();
        m1.b(checkedGroup, object);
    }

    private /* synthetic */ void s(WorkingMode object) {
        int n10 = q6.f(object);
        String string2 = g.o(this.getResources(), n10);
        object = this.e.I((WorkingMode)((Object)object), string2);
        this.b.n.setText((CharSequence)object);
    }

    private /* synthetic */ void u(JoystickSpeed object) {
        CheckedGroup checkedGroup = this.b.d;
        object = object.name();
        m1.b(checkedGroup, object);
    }

    private /* synthetic */ void w(String string2) {
        m1.a(this.b.c, string2);
    }

    private /* synthetic */ void y(KeyFunc object) {
        Object object2 = SetStabilizerFragment$b.a;
        int n10 = object.ordinal();
        int n11 = object2[n10];
        n11 = n11 != (n10 = 1) ? (n11 != (n10 = 2) ? 2131952741 : 2131952742) : 2131952743;
        CheckedGroup checkedGroup = this.b.b;
        object = object.name();
        m1.b(checkedGroup, object);
        object = this.b.a;
        object2 = g.o(this.getResources(), n11);
        object.setText((CharSequence)object2);
    }

    public /* synthetic */ void B(Boolean bl2) {
        this.A(bl2);
    }

    public /* synthetic */ void D(Boolean bl2) {
        this.C(bl2);
    }

    public /* synthetic */ void F(Integer n10) {
        this.E(n10);
    }

    public /* synthetic */ void H(CheckedGroup checkedGroup, int n10) {
        this.G(checkedGroup, n10);
    }

    public /* synthetic */ void J(CheckedGroup checkedGroup, int n10) {
        this.I(checkedGroup, n10);
    }

    public /* synthetic */ void L(RadioGroup radioGroup, int n10) {
        this.K(radioGroup, n10);
    }

    public /* synthetic */ void N(CheckedGroup checkedGroup, int n10) {
        this.M(checkedGroup, n10);
    }

    public /* synthetic */ void P(CompoundButton compoundButton, boolean bl2) {
        this.O(compoundButton, bl2);
    }

    public int h() {
        return 2131558479;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (z1)viewDataBinding;
        this.b = viewDataBinding;
        SetStabilizerFragment$c setStabilizerFragment$c = new SetStabilizerFragment$c(this);
        ((z1)viewDataBinding).D(setStabilizerFragment$c);
    }

    public void onAttach(Context object) {
        ViewModel viewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = viewModel = (s6)((ViewModelProvider)object).get(s6.class);
        viewModel = (j1)((ViewModelProvider)object).get(j1.class);
        this.d = viewModel;
        viewModel = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.e = viewModel;
        this.f = object = (u6)((ViewModelProvider)object).get(u6.class);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.n();
        this.p();
        this.o();
    }

    public /* synthetic */ void r(SceneMode sceneMode) {
        this.q(sceneMode);
    }

    public /* synthetic */ void t(WorkingMode workingMode) {
        this.s(workingMode);
    }

    public /* synthetic */ void v(JoystickSpeed joystickSpeed) {
        this.u(joystickSpeed);
    }

    public /* synthetic */ void x(String string2) {
        this.w(string2);
    }

    public /* synthetic */ void z(KeyFunc keyFunc) {
        this.y(keyFunc);
    }
}

