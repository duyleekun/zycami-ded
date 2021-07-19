/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.cama.device.active;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.OnBackPressedDispatcher;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider;
import com.zhiyun.account.data.database.model.UserInfo;
import com.zhiyun.cama.device.active.ActivationSuccessFragment$a;
import com.zhiyun.cama.device.active.ActivationSuccessFragment$b;
import d.v.c.m1.c;
import d.v.c.w0.r5;
import d.v.c.y0.a.l;
import d.v.c.y0.a.p;
import d.v.i0.b;
import m.a.a;

public class ActivationSuccessFragment
extends d.v.f.h.a {
    private r5 b;
    private p c;
    private c d;

    private void j() {
        MutableLiveData mutableLiveData = this.d.i();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        l l10 = new l(this);
        mutableLiveData.observe(lifecycleOwner, l10);
    }

    private void k() {
        Object object = d.v.a.f.c.b.N();
        boolean bl2 = ((d.v.a.f.c.b)object).j();
        if (bl2 && (object = d.v.a.f.c.b.N().i()) != null) {
            c c10 = this.d;
            object = ((UserInfo)object).getToken();
            c10.w((String)object);
        }
    }

    private boolean l() {
        Lifecycle$State lifecycle$State = this.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State2 = Lifecycle$State.RESUMED;
        return lifecycle$State.isAtLeast(lifecycle$State2);
    }

    private /* synthetic */ void m(Boolean object) {
        boolean bl2;
        boolean bl3;
        int n10 = 1;
        Object object2 = new Object[n10];
        object2[0] = object;
        String string2 = "----show---%s";
        a.b(string2, object2);
        boolean n11 = (Boolean)object;
        if (n11 && (bl3 = this.l()) && (bl2 = ((d.v.a.f.c.b)(object = d.v.a.f.c.b.N())).j())) {
            int n12 = d.v.c.m1.d.p.o;
            object = d.v.c.m1.d.p.L(n12, false);
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
            object = this.d;
            ((c)object).y();
        }
    }

    public int h() {
        return 2131558557;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (r5)viewDataBinding;
        this.b = viewDataBinding;
        Object object = new ActivationSuccessFragment$b(this);
        ((r5)viewDataBinding).A((ActivationSuccessFragment$b)object);
        viewDataBinding = this.b;
        object = this.c;
        ((r5)viewDataBinding).B((p)object);
    }

    public /* synthetic */ void n(Boolean bl2) {
        this.m(bl2);
    }

    public void onAttach(Context object) {
        p p10;
        super.onAttach((Context)object);
        object = d.v.i0.b.c(this.requireActivity());
        this.c = p10 = (p)((ViewModelProvider)object).get(p.class);
        this.d = object = (c)((ViewModelProvider)object).get(c.class);
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = this.requireActivity().getOnBackPressedDispatcher();
        ActivationSuccessFragment$a activationSuccessFragment$a = new ActivationSuccessFragment$a(this, true);
        ((OnBackPressedDispatcher)object).addCallback(this, activationSuccessFragment$a);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.j();
    }
}

