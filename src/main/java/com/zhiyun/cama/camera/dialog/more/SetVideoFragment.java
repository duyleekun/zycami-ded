/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 *  android.widget.RadioButton
 *  android.widget.RadioGroup
 *  android.widget.RadioGroup$OnCheckedChangeListener
 *  android.widget.TextView
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.cama.camera.dialog.more.GestureModeFragment;
import com.zhiyun.cama.camera.dialog.more.SetVideoFragment$a;
import com.zhiyun.cama.camera.dialog.more.WhiteBalanceFragment;
import com.zhiyun.cama.data.database.model.CameraParam;
import d.v.c.s0.a7.o1.a0;
import d.v.c.s0.a7.o1.b0;
import d.v.c.s0.a7.o1.c0;
import d.v.c.s0.a7.o1.d0;
import d.v.c.s0.a7.o1.e0;
import d.v.c.s0.a7.o1.f0;
import d.v.c.s0.a7.o1.g0;
import d.v.c.s0.a7.o1.h0;
import d.v.c.s0.a7.o1.i0;
import d.v.c.s0.a7.o1.j0;
import d.v.c.s0.a7.o1.k0;
import d.v.c.s0.a7.o1.l0;
import d.v.c.s0.a7.o1.m0;
import d.v.c.s0.a7.o1.x;
import d.v.c.s0.a7.o1.y;
import d.v.c.s0.a7.o1.z;
import d.v.c.s0.s6;
import d.v.c.s0.u6;
import d.v.c.w0.b2;
import d.v.e.h.d;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.i0.b;

public class SetVideoFragment
extends a {
    private b2 b;
    private u6 c;
    private s6 d;
    private d.v.c.s0.f7.d e;

    private /* synthetic */ void B(CompoundButton compoundButton, boolean bl2) {
        this.c.m2(bl2);
    }

    private /* synthetic */ void D(CompoundButton compoundButton, boolean n10) {
        compoundButton = this.b.y;
        n10 = n10 != 0 ? 0 : 8;
        compoundButton.setVisibility(n10);
    }

    private /* synthetic */ void F(RadioGroup radioGroup, int n10) {
        radioGroup = (RadioButton)radioGroup.findViewById(n10);
        Object object = this.b.e;
        String string2 = radioGroup.getText().toString();
        object.setText((CharSequence)string2);
        object = this.c;
        int n11 = (Integer)radioGroup.getTag();
        ((u6)object).K1(n11);
    }

    private /* synthetic */ void H(CompoundButton compoundButton, boolean n10) {
        compoundButton = this.b.A;
        n10 = n10 != 0 ? 0 : 8;
        compoundButton.setVisibility(n10);
    }

    private /* synthetic */ void J(RadioGroup object, int n10) {
        object = (RadioButton)object.findViewById(n10);
        Object object2 = this.b.g;
        String string2 = object.getText().toString();
        object2.setText((CharSequence)string2);
        object2 = this.e.a;
        object = d.v.e.h.d.d((Integer)object.getTag(), 0);
        ((MutableLiveData)object2).setValue(object);
    }

    private /* synthetic */ void L(CompoundButton compoundButton, boolean n10) {
        compoundButton = this.b.z;
        n10 = n10 != 0 ? 0 : 8;
        compoundButton.setVisibility(n10);
    }

    private /* synthetic */ void N(RadioGroup radioGroup, int n10) {
        radioGroup = (RadioButton)radioGroup.findViewById(n10);
        Object object = this.b.f;
        String string2 = radioGroup.getText().toString();
        object.setText((CharSequence)string2);
        object = this.c;
        int n11 = (Integer)radioGroup.getTag();
        ((u6)object).M1(n11);
    }

    private /* synthetic */ void P(CameraParam object) {
        if (object != null) {
            TextView textView = this.b.D;
            Resources resources = this.getResources();
            int n10 = WhiteBalanceFragment.l(((CameraParam)object).getWhiteBalance());
            object = g.o(resources, n10);
            textView.setText((CharSequence)object);
        }
    }

    private /* synthetic */ void R(Integer object) {
        TextView textView = this.b.B;
        Resources resources = this.getResources();
        int n10 = GestureModeFragment.l((Integer)object);
        object = g.o(resources, n10);
        textView.setText((CharSequence)object);
    }

    public static /* synthetic */ s6 j(SetVideoFragment setVideoFragment) {
        return setVideoFragment.d;
    }

    private void k() {
        Object object = this.b;
        Object object2 = this.c;
        ((b2)object).D((u6)object2);
        object = this.b;
        object2 = this.e;
        ((b2)object).C((d.v.c.s0.f7.d)object2);
        object = this.e.b;
        object2 = this.getViewLifecycleOwner();
        Observer observer = new g0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
        object = this.e.c;
        object2 = this.getViewLifecycleOwner();
        observer = new c0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, observer);
    }

    private void l() {
        Object object = this.b.e;
        Object object2 = new i0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.y;
        object2 = new k0(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.g;
        object2 = new m0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.A;
        object2 = new x(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.f;
        object2 = new h0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.z;
        object2 = new b0(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.a;
        object2 = new a0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.x;
        object2 = new e0(this);
        object.setOnCheckedChangeListener((RadioGroup.OnCheckedChangeListener)object2);
        object = this.b.d;
        object2 = new f0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.c.u0();
        object2 = this.getViewLifecycleOwner();
        j0 j02 = new j0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, j02);
        object = this.b.b;
        object2 = new l0(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.c;
        object2 = new y(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
    }

    /*
     * WARNING - void declaration
     */
    private void m() {
        int n10;
        Object object = this.b.k;
        int n11 = 0;
        Object object2 = null;
        Object object3 = 0;
        object.setTag(object3);
        object = this.b.j;
        int n12 = 2;
        Integer n13 = n12;
        object.setTag((Object)n13);
        object = this.b.l;
        int n14 = 1;
        Integer n15 = n14;
        object.setTag((Object)n15);
        object = this.b.m;
        int n16 = 3;
        Integer n17 = n16;
        object.setTag((Object)n17);
        object = this.c;
        boolean n18 = ((u6)object).l1();
        int n19 = 8;
        if (n18) {
            void var11_15;
            object = this.c.n();
            n10 = object.contains(object3);
            boolean bl2 = object.contains(n13);
            boolean bl3 = object.contains(n15);
            boolean bl4 = object.contains(n17);
            n17 = this.b.k;
            n10 = n10 != 0 ? 0 : n19;
            n17.setVisibility(n10);
            n17 = this.b.j;
            n10 = bl2 ? 0 : n19;
            n17.setVisibility(n10);
            n17 = this.b.l;
            n10 = bl3 ? 0 : n19;
            n17.setVisibility(n10);
            n17 = this.b.m;
            if (bl4) {
                boolean bl5 = false;
                object = null;
            } else {
                int n20 = n19;
            }
            n17.setVisibility((int)var11_15);
            int n21 = d.v.e.h.d.c((Integer)this.c.A().getValue());
            n17 = this.b.y;
            object = n21;
            object = (RadioButton)n17.findViewWithTag(object);
            n17 = this.b.y;
            n10 = object.getId();
            n17.check(n10);
            n17 = this.b.e;
            object = object.getText().toString();
            n17.setText((CharSequence)object);
        }
        this.b.q.setTag(object3);
        this.b.r.setTag((Object)n15);
        this.b.s.setTag((Object)n13);
        int n22 = d.v.e.h.d.d((Integer)this.e.a.getValue(), 0);
        n17 = this.b.A;
        object = n22;
        object = (RadioButton)n17.findViewWithTag(object);
        n17 = this.b.A;
        n10 = object.getId();
        n17.check(n10);
        n17 = this.b.g;
        object = object.getText().toString();
        n17.setText((CharSequence)object);
        this.b.p.setTag(object3);
        this.b.n.setTag((Object)n15);
        this.b.o.setTag((Object)n13);
        int n23 = d.v.e.h.d.c((Integer)this.c.G().getValue());
        object3 = this.b.z;
        object = n23;
        object = (RadioButton)object3.findViewWithTag(object);
        object3 = this.b.z;
        n12 = object.getId();
        object3.check(n12);
        object3 = this.b.f;
        object = object.getText().toString();
        object3.setText((CharSequence)object);
        object = this.c.r0();
        object3 = "1.3333";
        n12 = (int)(object.contains(object3) ? 1 : 0);
        n15 = this.b.u;
        if (n12 != 0) {
            n12 = 0;
            n13 = null;
        } else {
            n12 = n19;
        }
        n15.setVisibility(n12);
        n13 = this.b.u;
        n13.setTag(object3);
        object3 = "1.7778";
        n12 = (int)(object.contains(object3) ? 1 : 0);
        n15 = this.b.w;
        if (n12 != 0) {
            n12 = 0;
            n13 = null;
        } else {
            n12 = n19;
        }
        n15.setVisibility(n12);
        n13 = this.b.w;
        n13.setTag(object3);
        object3 = "2.0000";
        n12 = (int)(object.contains(object3) ? 1 : 0);
        n15 = this.b.t;
        if (n12 != 0) {
            n12 = 0;
            n13 = null;
        } else {
            n12 = n19;
        }
        n15.setVisibility(n12);
        this.b.t.setTag(object3);
        object3 = "1.0000";
        boolean bl6 = object.contains(object3);
        n13 = this.b.v;
        if (!bl6) {
            n11 = n19;
        }
        n13.setVisibility(n11);
        this.b.v.setTag(object3);
        object = (String)this.c.F().getValue();
        object = (RadioButton)this.b.x.findViewWithTag(object);
        object2 = this.b.x;
        int n24 = object.getId();
        object2.check(n24);
        object2 = this.b.a;
        object = object.getText().toString();
        object2.setText((CharSequence)object);
        object = this.c.J();
        object2 = this.getViewLifecycleOwner();
        object3 = new d0(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
        object = this.c.g0();
        object2 = this.getViewLifecycleOwner();
        object3 = new z(this);
        ((LiveData)object).observe((LifecycleOwner)object2, (Observer)object3);
    }

    private /* synthetic */ void n(Boolean bl2) {
        float f10;
        RadioButton radioButton = this.b.r;
        boolean bl3 = bl2;
        radioButton.setEnabled(bl3);
        radioButton = this.b.r;
        int n10 = bl2.booleanValue();
        if (n10 != 0) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            n10 = 1053609165;
            f10 = 0.4f;
        }
        radioButton.setAlpha(f10);
    }

    private /* synthetic */ void p(Boolean bl2) {
        float f10;
        RadioButton radioButton = this.b.s;
        boolean bl3 = bl2;
        radioButton.setEnabled(bl3);
        radioButton = this.b.s;
        int n10 = bl2.booleanValue();
        if (n10 != 0) {
            n10 = 1065353216;
            f10 = 1.0f;
        } else {
            n10 = 1053609165;
            f10 = 0.4f;
        }
        radioButton.setAlpha(f10);
    }

    private /* synthetic */ void r(CompoundButton compoundButton, boolean n10) {
        compoundButton = this.b.x;
        n10 = n10 != 0 ? 0 : 8;
        compoundButton.setVisibility(n10);
    }

    private /* synthetic */ void t(RadioGroup object, int n10) {
        object = (RadioButton)object.findViewById(n10);
        Object object2 = this.b.a;
        String string2 = object.getText().toString();
        object2.setText((CharSequence)string2);
        object2 = this.c;
        object = object.getTag().toString();
        ((u6)object2).L1((String)object);
    }

    private /* synthetic */ void v(CompoundButton compoundButton, boolean bl2) {
        this.c.n2(bl2);
    }

    private /* synthetic */ void x(Integer n10) {
        int n11;
        String string2 = g.o(this.getResources(), 2131953250);
        int n12 = 3;
        int n13 = n10;
        if (n12 == n13 || (n13 = 1) == (n11 = n10.intValue())) {
            String string3 = "\n";
            string2 = string2.replace(" ", string3);
            n10 = this.b.C;
            n10.setText(string2);
        }
        this.b.C.setText((CharSequence)string2);
    }

    private /* synthetic */ void z(CompoundButton compoundButton, boolean bl2) {
        this.c.f2(bl2);
    }

    public /* synthetic */ void A(CompoundButton compoundButton, boolean bl2) {
        this.z(compoundButton, bl2);
    }

    public /* synthetic */ void C(CompoundButton compoundButton, boolean bl2) {
        this.B(compoundButton, bl2);
    }

    public /* synthetic */ void E(CompoundButton compoundButton, boolean bl2) {
        this.D(compoundButton, bl2);
    }

    public /* synthetic */ void G(RadioGroup radioGroup, int n10) {
        this.F(radioGroup, n10);
    }

    public /* synthetic */ void I(CompoundButton compoundButton, boolean bl2) {
        this.H(compoundButton, bl2);
    }

    public /* synthetic */ void K(RadioGroup radioGroup, int n10) {
        this.J(radioGroup, n10);
    }

    public /* synthetic */ void M(CompoundButton compoundButton, boolean bl2) {
        this.L(compoundButton, bl2);
    }

    public /* synthetic */ void O(RadioGroup radioGroup, int n10) {
        this.N(radioGroup, n10);
    }

    public /* synthetic */ void Q(CameraParam cameraParam) {
        this.P(cameraParam);
    }

    public /* synthetic */ void S(Integer n10) {
        this.R(n10);
    }

    public int h() {
        return 2131558480;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (b2)viewDataBinding;
        this.b = viewDataBinding;
        SetVideoFragment$a setVideoFragment$a = new SetVideoFragment$a(this);
        ((b2)viewDataBinding).B(setVideoFragment$a);
    }

    public /* synthetic */ void o(Boolean bl2) {
        this.n(bl2);
    }

    public void onAttach(Context object) {
        AndroidViewModel androidViewModel;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = androidViewModel = (u6)((ViewModelProvider)object).get(u6.class);
        androidViewModel = (s6)((ViewModelProvider)object).get(s6.class);
        this.d = androidViewModel;
        this.e = object = (d.v.c.s0.f7.d)((ViewModelProvider)object).get(d.v.c.s0.f7.d.class);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.m();
        this.l();
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

    public /* synthetic */ void y(Integer n10) {
        this.x(n10);
    }
}

