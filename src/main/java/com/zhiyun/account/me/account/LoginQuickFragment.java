/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.Context
 *  android.content.res.Configuration
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.text.method.LinkMovementMethod
 *  android.text.method.MovementMethod
 *  android.view.View
 *  android.widget.Button
 *  android.widget.CheckBox
 *  android.widget.FrameLayout
 */
package com.zhiyun.account.me.account;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.LoginQuickFragment$a;
import com.zhiyun.account.me.account.LoginQuickFragment$b;
import com.zhiyun.account.me.account.widget.InputCodeView;
import com.zhiyun.account.me.account.widget.InputCodeView$c;
import com.zhiyun.account.me.account.widget.MeNameView;
import d.v.a.g.g;
import d.v.a.i.a.a0;
import d.v.a.i.a.h;
import d.v.a.i.a.m0;
import d.v.a.i.a.u;
import d.v.a.i.a.v;
import d.v.a.i.a.w;
import d.v.a.i.a.x;
import d.v.a.i.a.y;
import d.v.a.i.a.y0.c;
import d.v.a.i.a.y0.d;
import d.v.a.i.a.y0.d$b;
import d.v.a.i.a.y0.e;
import d.v.a.i.a.z;
import d.v.e.h.a;
import d.v.e.i.j;
import d.v.e.l.w1;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class LoginQuickFragment
extends d.v.f.h.a {
    private g b;
    private m0 c;
    private d d;
    private c e;

    private /* synthetic */ void B(String object) {
        Context context = this.getContext();
        Object object2 = new k$b(context);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    private /* synthetic */ void D(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.G();
        } else {
            object = this.b.d;
            String string2 = "";
            ((InputCodeView)((Object)object)).setCode(string2);
            this.H();
        }
    }

    private void F(String object) {
        Object object2 = (Boolean)this.c.g.getValue();
        boolean bl2 = a.c((Boolean)object2);
        int n10 = 1;
        if (!bl2) {
            object2 = this.c.f;
            boolean bl3 = TextUtils.isEmpty((CharSequence)object) ^ n10;
            object = bl3;
            ((MutableLiveData)object2).setValue(object);
        }
        object = this.c.h;
        object2 = this.requireContext();
        int n11 = R$string.account_get_code_text;
        Object[] objectArray = new Object[n10];
        CharSequence charSequence = new StringBuilder();
        charSequence.append("+");
        String string2 = this.b.g.getCountryCode();
        charSequence.append(string2);
        charSequence.append(" ");
        string2 = this.b.g.getName();
        charSequence.append(string2);
        charSequence = charSequence.toString();
        objectArray[0] = charSequence;
        object2 = d.v.f.i.g.n((Context)object2, n11, objectArray);
        ((MutableLiveData)object).setValue(object2);
    }

    public static /* synthetic */ g j(LoginQuickFragment loginQuickFragment) {
        return loginQuickFragment.b;
    }

    public static /* synthetic */ m0 k(LoginQuickFragment loginQuickFragment) {
        return loginQuickFragment.c;
    }

    public static /* synthetic */ void l(LoginQuickFragment loginQuickFragment, View view) {
        loginQuickFragment.m(view);
    }

    private void m(View object) {
        Object object2;
        object = this.d;
        if (object == null) {
            object2 = this.getContext();
            object = new d((Context)object2);
            this.d = object;
        }
        object = this.d;
        object2 = new LoginQuickFragment$a(this);
        ((d)object).g((d$b)object2);
    }

    private void n() {
        Object object = this.c;
        Object object2 = "zh_CN".toLowerCase();
        String string2 = w1.a();
        boolean bl2 = ((String)object2).equals(string2);
        ((m0)object).z(bl2);
        object = this.b;
        object2 = this.c;
        ((g)object).B((m0)object2);
    }

    private void o() {
        FrameLayout frameLayout = this.b.g;
        Object object = new x(this);
        frameLayout.setOnTextChangedListener((e)object);
        frameLayout = this.b.d;
        object = new v(this);
        frameLayout.setOnInputEndListener((InputCodeView$c)object);
    }

    private void p() {
        MutableLiveData mutableLiveData = this.c.k;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new u(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.v;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new y(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = h.a;
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.C;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new a0(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new w(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
        mutableLiveData = this.c.g;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new z(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private void q() {
        CheckBox checkBox = this.b.b;
        MovementMethod movementMethod = LinkMovementMethod.getInstance();
        checkBox.setMovementMethod(movementMethod);
        this.b.g.setShowCode(true);
    }

    private /* synthetic */ void r(String string2) {
        string2 = this.b.g.getName();
        this.F(string2);
    }

    private /* synthetic */ void t(String string2) {
        m0 m02 = this.c;
        MeNameView meNameView = this.b.g;
        String string3 = meNameView.getCountryCode();
        String string4 = this.b.g.getName();
        m02.s((View)meNameView, string3, string4, string2);
    }

    private /* synthetic */ void v(String string2) {
        this.b.g.setCountryCode(string2);
    }

    private /* synthetic */ void x(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void z(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    public /* synthetic */ void A(Boolean bl2) {
        this.z(bl2);
    }

    public /* synthetic */ void C(String string2) {
        this.B(string2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public void G() {
        c c10 = this.e;
        if (c10 == null) {
            Button button = this.b.a;
            int n10 = 60;
            this.e = c10 = new c(button, n10);
        }
        this.e.a();
    }

    public void H() {
        c c10 = this.e;
        if (c10 != null) {
            c10.b();
        }
    }

    public int h() {
        return R$layout.me_account_login_quick_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (g)viewDataBinding;
        this.b = viewDataBinding;
        LoginQuickFragment$b loginQuickFragment$b = new LoginQuickFragment$b(this);
        ((g)viewDataBinding).A(loginQuickFragment$b);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
    }

    public void onConfigurationChanged(Configuration object) {
        super.onConfigurationChanged((Configuration)object);
        object = this.d;
        if (object != null) {
            ((d)object).e();
        }
    }

    public void onDestroy() {
        d d10 = this.d;
        if (d10 != null) {
            d10.f();
        }
        super.onDestroy();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.n();
        this.q();
        this.o();
        this.p();
    }

    public /* synthetic */ void s(String string2) {
        this.r(string2);
    }

    public /* synthetic */ void u(String string2) {
        this.t(string2);
    }

    public /* synthetic */ void w(String string2) {
        this.v(string2);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

