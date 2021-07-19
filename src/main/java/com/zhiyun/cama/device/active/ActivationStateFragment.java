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
import androidx.activity.OnBackPressedCallback;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import com.zhiyun.cama.device.active.ActivationStateFragment$a;
import com.zhiyun.device.active.ActivationViewModel;
import d.v.c.w0.p5;
import d.v.c.y0.a.j;
import d.v.c.y0.a.k;
import d.v.c.z0.k$b;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.i0.b;

public class ActivationStateFragment
extends d.v.f.h.a {
    private p5 b;
    private ActivationViewModel c;

    public static /* synthetic */ void j(ActivationStateFragment activationStateFragment, int n10, int n11, int n12, a a10) {
        activationStateFragment.q(n10, n11, n12, a10);
    }

    private void k() {
        this.c.g0();
    }

    private void l() {
        MutableLiveData mutableLiveData = this.c.v();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new k(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.u();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = j.a;
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void m(Integer n10) {
        int n11;
        int n12 = n10;
        if (n12 != (n11 = -1) && (n12 = n10.intValue()) != (n11 = -2) && (n12 = n10.intValue()) != (n11 = -3)) {
            int n13 = n10;
            if (n13 == (n12 = 4)) {
                n13 = 2131361871;
                this.p(n13);
            }
        } else {
            int n14 = 2131361870;
            this.p(n14);
        }
    }

    public static /* synthetic */ void o(String string2) {
    }

    private void p(int n10) {
        int n11;
        int n12;
        Object object = NavHostFragment.findNavController(this);
        NavDestination navDestination = ((NavController)object).getCurrentDestination();
        if (navDestination != null && (n12 = ((NavDestination)(object = ((NavController)object).getCurrentDestination())).getId()) == (n11 = 2131361997)) {
            object = NavHostFragment.findNavController(this);
            ((NavController)object).navigate(n10);
        }
    }

    private void q(int n10, int n11, int n12, a a10) {
        k$b k$b = new k$b();
        Object object = g.s(this, n10);
        object = k$b.J((String)object);
        Object object2 = g.s(this, n11);
        object = ((k$b)object).y((String)object2);
        object2 = g.s(this, n12);
        object = ((k$b)object).G((String)object2, a10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    public int h() {
        return 2131558556;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (p5)viewDataBinding;
        this.b = viewDataBinding;
        ActivationViewModel activationViewModel = this.c;
        ((p5)viewDataBinding).z(activationViewModel);
    }

    public /* synthetic */ void n(Integer n10) {
        this.m(n10);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (ActivationViewModel)d.v.i0.b.c(this.requireActivity()).get(ActivationViewModel.class);
        this.c = object;
    }

    public void onCreate(Bundle object) {
        super.onCreate((Bundle)object);
        object = new ActivationStateFragment$a(this, true);
        this.requireActivity().getOnBackPressedDispatcher().addCallback(this, (OnBackPressedCallback)object);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.k();
        this.l();
    }
}

