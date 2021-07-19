/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Bundle
 *  android.view.View
 */
package com.zhiyun.account.me.account;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle$State;
import androidx.navigation.NavDirections;
import com.zhiyun.account.R$string;
import com.zhiyun.account.me.account.RegisterFragment$a;
import com.zhiyun.account.me.account.getcode.GetCodeStatus;
import com.zhiyun.account.me.account.visitor.VisitorBindActivity;
import d.v.a.c;
import d.v.a.f.b.a;
import d.v.a.f.c.b;
import d.v.a.i.a.b0;
import d.v.a.i.a.q0;
import d.v.a.i.a.v0.m;
import d.v.f.i.g;
import d.v.g0.k$b;

public class RegisterFragment
extends m {
    public static /* synthetic */ void P(RegisterFragment registerFragment) {
        registerFragment.T();
    }

    private boolean Q() {
        Lifecycle$State lifecycle$State = this.getLifecycle().getCurrentState();
        Lifecycle$State lifecycle$State2 = Lifecycle$State.RESUMED;
        return lifecycle$State.isAtLeast(lifecycle$State2);
    }

    private /* synthetic */ void R(DialogFragment dialogFragment) {
        VisitorBindActivity.h(this, 1);
    }

    private void T() {
        boolean bl2 = this.Q();
        if (!bl2) {
            return;
        }
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        object = this.requireContext();
        int n10 = R$string.account_perfect_information;
        object = g.m(object, n10);
        k$b = (k$b)k$b.B((String)object);
        object = this.requireContext();
        int n11 = R$string.account_perfect_information_tip;
        object = g.m(object, n11);
        k$b = (k$b)k$b.n((String)object);
        object = this.requireContext();
        n11 = R$string.cancel;
        object = g.m(object, n11);
        k$b = (k$b)k$b.q((String)object, null);
        object = g.m(this.requireContext(), n10);
        b0 b02 = new b0(this);
        k$b = (k$b)k$b.x((String)object, b02);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    public /* synthetic */ void S(DialogFragment dialogFragment) {
        this.R(dialogFragment);
    }

    public GetCodeStatus a() {
        return GetCodeStatus.REGISTER;
    }

    public void b(View view) {
        NavDirections navDirections = q0.b();
        d.v.a.k.a.c(view, navDirections);
    }

    public void o(View view) {
        NavDirections navDirections = q0.a();
        d.v.a.k.a.c(view, navDirections);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        Object object;
        super.onActivityResult(n10, n11, intent);
        int n12 = 1;
        if (n10 == n12 && n11 == (n10 = 2) && (n10 = (int)(((b)(object = b.N())).s() ? 1 : 0)) != 0) {
            object = this.requireActivity();
            object.finish();
        }
    }

    public void onViewCreated(View object, Bundle object2) {
        super.onViewCreated((View)object, (Bundle)object2);
        boolean bl2 = c.f();
        if (bl2) {
            object = b.N();
            object2 = new RegisterFragment$a(this);
            ((b)object).G((a)object2);
        }
    }
}

