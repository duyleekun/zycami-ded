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
 *  android.widget.CheckBox
 *  android.widget.TextView
 */
package com.zhiyun.account.me.account;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$layout;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.SetPassFragment$a;
import com.zhiyun.account.me.account.widget.MePassView;
import d.v.a.g.m;
import d.v.a.i.a.c0;
import d.v.a.i.a.d0;
import d.v.a.i.a.e0;
import d.v.a.i.a.f0;
import d.v.a.i.a.g0;
import d.v.a.i.a.h;
import d.v.a.i.a.h0;
import d.v.a.i.a.i0;
import d.v.a.i.a.j0;
import d.v.a.i.a.k0;
import d.v.a.i.a.m0;
import d.v.a.i.a.r0;
import d.v.a.i.a.y0.e;
import d.v.a.k.a;
import d.v.e.i.j;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.i0.b;

public class SetPassFragment
extends d.v.f.h.a {
    private m b;
    private m0 c;
    private d.v.a.i.a.u0.a d;

    private /* synthetic */ void B(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2 && (object = this.getActivity()) != null) {
            object = this.requireActivity();
            int n10 = 2;
            object.setResult(n10);
            object = this.getActivity();
            ActivityCompat.finishAfterTransition((Activity)object);
        }
    }

    private /* synthetic */ void D(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.d;
            if (object == null) {
                this.d = object = d.v.a.i.a.u0.a.u();
            }
            object = this.d;
            FragmentManager fragmentManager = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q(fragmentManager);
        } else {
            object = this.d;
            if (object != null) {
                ((DialogFragment)object).dismissAllowingStateLoss();
            }
        }
    }

    private /* synthetic */ void F(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.m();
        }
    }

    private /* synthetic */ void H(DialogFragment dialogFragment) {
        this.m();
    }

    private void J(String object, String string2) {
        MutableLiveData mutableLiveData = this.c.j;
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

    public static /* synthetic */ void j(SetPassFragment setPassFragment) {
        setPassFragment.m();
    }

    public static /* synthetic */ m k(SetPassFragment setPassFragment) {
        return setPassFragment.b;
    }

    public static /* synthetic */ m0 l(SetPassFragment setPassFragment) {
        return setPassFragment.c;
    }

    private void m() {
        TextView textView = this.b.g;
        NavDirections navDirections = r0.a();
        a.c((View)textView, navDirections);
    }

    private void n() {
        m m10 = this.b;
        m0 m02 = this.c;
        m10.B(m02);
    }

    private void o() {
        MePassView mePassView = this.b.e;
        e e10 = new h0(this);
        mePassView.setOnTextChangedListener(e10);
        mePassView = this.b.f;
        e10 = new e0(this);
        mePassView.setOnTextChangedListener(e10);
    }

    private void p() {
        j j10 = this.c.v;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new j0(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.A;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = h.a;
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.y;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new g0(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.x;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new k0(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.C;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new i0(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.E;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new c0(this);
        j10.observe(lifecycleOwner, observer);
        j10 = this.c.w;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f0(this);
        j10.observe(lifecycleOwner, observer);
    }

    private void q() {
        CheckBox checkBox = this.b.a;
        MovementMethod movementMethod = LinkMovementMethod.getInstance();
        checkBox.setMovementMethod(movementMethod);
    }

    private /* synthetic */ void r(String string2) {
        string2 = this.b.e.getPass();
        String string3 = this.b.f.getPass();
        this.J(string2, string3);
    }

    private /* synthetic */ void t(String string2) {
        string2 = this.b.e.getPass();
        String string3 = this.b.f.getPass();
        this.J(string2, string3);
    }

    private /* synthetic */ void v(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.getActivity();
            s.t((FragmentActivity)object);
        } else {
            s.j();
        }
    }

    private /* synthetic */ void x(String object) {
        Object object2 = this.getContext();
        Object object3 = new k$b((Context)object2);
        object = (k$b)((k$a)object3).B((String)object);
        int n10 = R$string.me_login_now;
        object2 = new d0(this);
        object = (k$b)((k$a)object).v(n10, (d.v.f.f.a)object2);
        object3 = this.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object3);
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

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void E(Boolean bl2) {
        this.D(bl2);
    }

    public /* synthetic */ void G(Boolean bl2) {
        this.F(bl2);
    }

    public /* synthetic */ void I(DialogFragment dialogFragment) {
        this.H(dialogFragment);
    }

    public int h() {
        return R$layout.me_acoount_set_pass_frag;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (m)viewDataBinding;
        this.b = viewDataBinding;
        SetPassFragment$a setPassFragment$a = new SetPassFragment$a(this);
        ((m)viewDataBinding).A(setPassFragment$a);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (m0)d.v.i0.b.c(this.requireActivity()).get(m0.class);
        this.c = object;
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

    public /* synthetic */ void w(Boolean bl2) {
        this.v(bl2);
    }

    public /* synthetic */ void y(String string2) {
        this.x(string2);
    }
}

