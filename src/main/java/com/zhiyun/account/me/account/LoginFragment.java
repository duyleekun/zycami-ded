/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.widget.CompoundButton
 *  android.widget.CompoundButton$OnCheckedChangeListener
 */
package com.zhiyun.account.me.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.CompoundButton;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.LoginFragment$a;
import com.zhiyun.account.me.account.widget.MeNameView;
import com.zhiyun.account.me.account.widget.MePassView;
import com.zhiyun.common.viewmodel.DeviceViewModel;
import d.v.a.g.e;
import d.v.a.i.a.i;
import d.v.a.i.a.j;
import d.v.a.i.a.k;
import d.v.a.i.a.l;
import d.v.a.i.a.m;
import d.v.a.i.a.m0;
import d.v.a.i.a.n;
import d.v.a.i.a.o;
import d.v.a.i.a.o0;
import d.v.a.i.a.p;
import d.v.a.i.a.q;
import d.v.a.i.a.r;
import d.v.a.i.a.t;
import d.v.a.k.a;
import d.v.e.h.d;
import d.v.e.l.n2;
import d.v.e.l.w1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class LoginFragment
extends d.v.f.h.a {
    private e b;
    private m0 c;
    private int d = 0;
    private int e = 0;

    private /* synthetic */ void B(String string2) {
        this.b.e.setCountryCode(string2);
    }

    private /* synthetic */ void D(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void F(String string2) {
        m0 m02 = this.c;
        int n10 = m02.m();
        if (n10 != 0) {
            n10 = this.e;
            n2.f(string2, n10);
        } else {
            n2.e(string2);
        }
    }

    private /* synthetic */ void H(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private /* synthetic */ void J(String object) {
        Object object2 = this.getContext();
        Object object3 = new k$b((Context)object2);
        object = (k$b)((k$a)object3).B((String)object);
        int n10 = R$string.me_register_now;
        object2 = new m(this);
        object = (k$b)((k$a)object).v(n10, (d.v.f.f.a)object2);
        object3 = l.a;
        object = (k$b)((k$a)object).p((d.v.f.f.a)object3);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
    }

    private /* synthetic */ void L(DialogFragment dialogFragment) {
        dialogFragment = this.b.j;
        this.O((View)dialogFragment);
    }

    public static /* synthetic */ void N(DialogFragment dialogFragment) {
    }

    private void O(View view) {
        NavDirections navDirections = o0.b();
        a.c(view, navDirections);
    }

    private void P(String object, String string2) {
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

    private void Q(int n10) {
        int n11;
        int n12 = this.d;
        this.d = n10 = d.v.f.f.e.g(n10, n12);
        n12 = 0;
        n10 = n10 != 0 && n10 != (n11 = 2) ? 0 : 1;
        if (n10 == 0) {
            n12 = 3;
        }
        this.e = n12;
    }

    public static /* synthetic */ void j(LoginFragment loginFragment, View view) {
        loginFragment.O(view);
    }

    public static /* synthetic */ e k(LoginFragment loginFragment) {
        return loginFragment.b;
    }

    public static /* synthetic */ m0 l(LoginFragment loginFragment) {
        return loginFragment.c;
    }

    private void m(boolean bl2) {
        this.b.b.setChecked(bl2);
        this.b.e.setShowCode(bl2);
    }

    private void n() {
        Object object = this.c;
        Object object2 = "zh_CN".toLowerCase();
        String string2 = w1.a();
        boolean bl2 = ((String)object2).equals(string2);
        ((m0)object).z(bl2);
        object = this.b;
        object2 = this.c;
        ((e)object).B((m0)object2);
    }

    private void o() {
        Object object = this.b.b;
        Object object2 = new k(this);
        object.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)object2);
        object = this.b.e;
        object2 = new i(this);
        ((MeNameView)((Object)object)).setOnTextChangedListener((d.v.a.i.a.y0.e)object2);
        object = this.b.f;
        object2 = new q(this);
        ((MePassView)((Object)object)).setOnTextChangedListener((d.v.a.i.a.y0.e)object2);
    }

    private void p() {
        MutableLiveData mutableLiveData = this.c.k;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new d.v.a.i.a.s(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.v;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new n(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new o(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.C;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new j(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.z;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new t(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new r(this);
        ((d.v.e.i.j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    private void q() {
        Object object = this.c;
        boolean bl2 = ((m0)object).m();
        if (!bl2) {
            return;
        }
        object = (DeviceViewModel)d.v.i0.b.c(this.requireActivity()).get(DeviceViewModel.class);
        int n10 = d.v.e.h.d.c((Integer)((DeviceViewModel)object).a.getValue());
        this.Q(n10);
        object = ((DeviceViewModel)object).a;
        FragmentActivity fragmentActivity = this.requireActivity();
        p p10 = new p(this);
        ((LiveData)object).observe(fragmentActivity, p10);
    }

    private void r() {
        Object object = this.b.a;
        MovementMethod movementMethod = LinkMovementMethod.getInstance();
        object.setMovementMethod(movementMethod);
        boolean bl2 = false;
        this.P(null, null);
        object = this.c.d.getValue();
        if (object != null) {
            object = (Boolean)this.c.d.getValue();
            bl2 = (Boolean)object;
            this.m(bl2);
        }
    }

    public static /* synthetic */ void s(LoginFragment loginFragment, int n10) {
        loginFragment.Q(n10);
    }

    private /* synthetic */ void t(CompoundButton object, boolean bl2) {
        this.c.z(bl2);
        this.b.e.setShowCode(bl2);
        object = this.b.e;
        String string2 = "";
        ((MeNameView)((Object)object)).setName(string2);
        this.b.f.setPass(string2);
    }

    private /* synthetic */ void v(String string2) {
        string2 = this.b.e.getName();
        String string3 = this.b.f.getPass();
        this.P(string2, string3);
    }

    private /* synthetic */ void x(String string2) {
        string2 = this.b.e.getName();
        String string3 = this.b.f.getPass();
        this.P(string2, string3);
    }

    private /* synthetic */ void z(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public /* synthetic */ void A(String string2) {
        this.z(string2);
    }

    public /* synthetic */ void C(String string2) {
        this.B(string2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public /* synthetic */ void G(String string2) {
        this.F(string2);
    }

    public /* synthetic */ void I(Boolean bl2) {
        this.H(bl2);
    }

    public /* synthetic */ void K(String string2) {
        this.J(string2);
    }

    public /* synthetic */ void M(DialogFragment dialogFragment) {
        this.L(dialogFragment);
    }

    public int h() {
        return R$layout.me_account_login_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (e)viewDataBinding;
        this.b = viewDataBinding;
        LoginFragment$a loginFragment$a = new LoginFragment$a(this);
        ((e)viewDataBinding).A(loginFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.n();
        this.r();
        this.o();
        this.p();
        this.q();
    }

    public /* synthetic */ void u(CompoundButton compoundButton, boolean bl2) {
        this.t(compoundButton, bl2);
    }

    public /* synthetic */ void w(String string2) {
        this.v(string2);
    }

    public /* synthetic */ void y(String string2) {
        this.x(string2);
    }
}

