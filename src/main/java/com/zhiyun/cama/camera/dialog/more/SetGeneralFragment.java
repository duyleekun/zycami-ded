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
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.data.CameraSet$Theme;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment$a;
import com.zhiyun.cama.camera.dialog.more.SetGeneralFragment$b;
import com.zhiyun.protocol.constants.Model;
import d.v.c.s0.a7.o1.c;
import d.v.c.s0.a7.o1.d;
import d.v.c.s0.a7.o1.e;
import d.v.c.s0.a7.o1.f;
import d.v.c.s0.a7.o1.g;
import d.v.c.s0.a7.o1.h;
import d.v.c.s0.v6;
import d.v.c.w0.v1;
import d.v.e0.ce;
import d.v.e0.td;
import d.v.f.h.a;
import d.v.i0.b;

public class SetGeneralFragment
extends a {
    private v1 b;
    private BleViewModel c;
    private v6 d;
    private int e = -1;
    private d.v.f.f.e f;

    private /* synthetic */ void B(Boolean bl2) {
        RadioGroup radioGroup = this.b.k;
        int n10 = bl2.booleanValue();
        n10 = n10 != 0 ? 2131363054 : 2131363053;
        radioGroup.check(n10);
    }

    public static /* synthetic */ int j(SetGeneralFragment setGeneralFragment) {
        return setGeneralFragment.e;
    }

    public static /* synthetic */ int k(SetGeneralFragment setGeneralFragment, int n10) {
        setGeneralFragment.e = n10;
        return n10;
    }

    public static /* synthetic */ BleViewModel l(SetGeneralFragment setGeneralFragment) {
        return setGeneralFragment.c;
    }

    private void m() {
        Object object = this.b;
        Object object2 = this.c;
        ((v1)object).C((BleViewModel)object2);
        object = this.b.e;
        int n10 = CameraSet$Theme.DEFAULT.getDrawableRes();
        object.setImageResource(n10);
        object = ce.E0().y0();
        object2 = Model.UNKNOWN;
        Object object3 = ((td)object).c;
        n10 = (int)(((Enum)object2).equals(object3) ? 1 : 0);
        if (n10 == 0) {
            object2 = this.b.p;
            object3 = ((td)object).a;
            object2.setText((CharSequence)object3);
            object2 = this.b.o;
            object3 = ((td)object).c.getName();
            object2.setText((CharSequence)object3);
            object2 = this.b.q;
            float f10 = ((td)object).f;
            object3 = String.valueOf(f10);
            object2.setText((CharSequence)object3);
            object2 = this.b.r;
            object = ((td)object).e;
            object2.setText((CharSequence)object);
        }
        object = this.c.B;
        object2 = this.getViewLifecycleOwner();
        object3 = new d(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
    }

    private void n() {
        Object object = this.getContext();
        SetGeneralFragment$a setGeneralFragment$a = new SetGeneralFragment$a(this, (Context)object);
        this.f = setGeneralFragment$a;
        setGeneralFragment$a = this.b.b;
        object = new e(this);
        setGeneralFragment$a.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        setGeneralFragment$a = this.b.l;
        object = new h(this);
        setGeneralFragment$a.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
        setGeneralFragment$a = this.b.a;
        object = new f(this);
        setGeneralFragment$a.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object);
        setGeneralFragment$a = this.b.k;
        object = new d.v.c.s0.a7.o1.b(this);
        setGeneralFragment$a.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object);
    }

    private void o() {
        LiveData liveData = this.c.v;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new c(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.d.y();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new g(this);
        liveData.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void p(Boolean bl2) {
        CheckedTextView checkedTextView = this.b.c;
        boolean bl3 = bl2;
        checkedTextView.setChecked(bl3);
    }

    private /* synthetic */ void r(CompoundButton compoundButton, boolean n10) {
        compoundButton = this.b.l;
        n10 = n10 != 0 ? 0 : 8;
        compoundButton.setVisibility(n10);
    }

    private /* synthetic */ void t(RadioGroup object, int n10) {
        Object object2 = (object = (RadioButton)object.findViewById(n10)).getTag();
        if (object2 != null && (n10 = (object2 = object.getTag()) instanceof Integer) != 0) {
            object = CameraSet$Theme.fromId((Integer)object.getTag());
            this.c.f1((CameraSet$Theme)((Object)object));
            object2 = this.b.e;
            int n11 = ((CameraSet$Theme)((Object)object)).getDrawableRes();
            object2.setImageResource(n11);
        }
    }

    private /* synthetic */ void v(CompoundButton compoundButton, boolean bl2) {
        compoundButton = this.requireContext();
        boolean bl3 = d.v.c.m1.b.b((Context)compoundButton);
        int n10 = 0;
        if (bl3) {
            compoundButton = this.b.k;
            if (!bl2) {
                n10 = 8;
            }
            compoundButton.setVisibility(n10);
        } else {
            compoundButton = this.b.a;
            compoundButton.setChecked(false);
        }
    }

    private /* synthetic */ void x(RadioGroup radioGroup, int n10) {
        int n11;
        int n12;
        radioGroup = (RadioButton)radioGroup.findViewById(n10);
        v6 v62 = this.d;
        if (radioGroup != null && (n12 = 2131363054) == (n11 = radioGroup.getId())) {
            n11 = 1;
        } else {
            n11 = 0;
            radioGroup = null;
        }
        v62.d0(n11 != 0);
    }

    private /* synthetic */ void z(CameraSet$Theme cameraSet$Theme) {
        if (cameraSet$Theme == null) {
            cameraSet$Theme = this.b.b;
            cameraSet$Theme.setChecked(false);
        }
    }

    public /* synthetic */ void A(CameraSet$Theme cameraSet$Theme) {
        this.z(cameraSet$Theme);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public int h() {
        return 2131558477;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (v1)viewDataBinding;
        this.b = viewDataBinding;
        SetGeneralFragment$b setGeneralFragment$b = new SetGeneralFragment$b(this, null);
        ((v1)viewDataBinding).E(setGeneralFragment$b);
    }

    public void onAttach(Context object) {
        BleViewModel bleViewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = bleViewModel = (BleViewModel)((ViewModelProvider)object).get(BleViewModel.class);
        this.d = object = (v6)((ViewModelProvider)object).get(v6.class);
    }

    public void onResume() {
        super.onResume();
        this.f.enable();
    }

    public void onStop() {
        super.onStop();
        this.f.disable();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.m();
        this.o();
        this.n();
    }

    public /* synthetic */ void q(Boolean bl2) {
        this.p(bl2);
    }

    public /* synthetic */ void s(CompoundButton compoundButton, boolean bl2) {
        this.r(compoundButton, bl2);
    }

    public /* synthetic */ void u(RadioGroup radioGroup, int n10) {
        this.t(radioGroup, n10);
    }

    public /* synthetic */ void w(CompoundButton compoundButton, boolean bl2) {
        this.v(compoundButton, bl2);
    }

    public /* synthetic */ void y(RadioGroup radioGroup, int n10) {
        this.x(radioGroup, n10);
    }
}

