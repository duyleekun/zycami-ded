/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 *  android.widget.CheckedTextView
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.CheckedTextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavDirections;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.dialog.more.SetStabilizerFragment;
import d.v.c.s0.a7.o1.l;
import d.v.c.s0.a7.o1.m;
import d.v.c.s0.a7.o1.s0;
import d.v.f.f.a;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;

public class SetStabilizerFragment$c {
    public final /* synthetic */ SetStabilizerFragment a;

    public SetStabilizerFragment$c(SetStabilizerFragment setStabilizerFragment) {
        this.a = setStabilizerFragment;
    }

    public static /* synthetic */ void c(DialogFragment dialogFragment) {
    }

    private /* synthetic */ void d(DialogFragment object) {
        object = SetStabilizerFragment.k(this.a);
        int n10 = 1;
        ((BleViewModel)object).a1(n10 != 0);
        object = g.o(this.a.getResources(), 2131952373);
        MutableLiveData mutableLiveData = SetStabilizerFragment.m((SetStabilizerFragment)this.a).e;
        Integer n11 = 0;
        mutableLiveData.setValue(n11);
        SetStabilizerFragment.m((SetStabilizerFragment)this.a).b.setValue(n11);
        mutableLiveData = SetStabilizerFragment.m((SetStabilizerFragment)this.a).c;
        Resources resources = this.a.getResources();
        Object object2 = new Object[n10];
        object2[0] = n11;
        object2 = g.p(resources, 2131952372, object2);
        mutableLiveData.setValue(object2);
        SetStabilizerFragment.m((SetStabilizerFragment)this.a).d.setValue(object);
        object = SetStabilizerFragment.m((SetStabilizerFragment)this.a).a;
        object2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(object2);
        SetStabilizerFragment.l(this.a).d();
    }

    public void a(View object) {
        Object object2 = this.a.getContext();
        object = new k$b((Context)object2);
        object = (k$b)((k$b)((k$a)object).A(2131952725)).m(2131952727);
        object2 = m.a;
        object = (k$b)((k$a)object).p((a)object2);
        object2 = new l(this);
        object = (k$b)((k$b)((k$a)object).v(2131952728, (a)object2)).c();
        object2 = this.a.getChildFragmentManager();
        ((k$a)object).D((FragmentManager)object2);
    }

    public void b(View view) {
        view = (CheckedTextView)view;
        view.toggle();
        BleViewModel bleViewModel = SetStabilizerFragment.k(this.a);
        boolean bl2 = view.isChecked();
        bleViewModel.i1(bl2);
    }

    public /* synthetic */ void e(DialogFragment dialogFragment) {
        this.d(dialogFragment);
    }

    public void f(View view) {
        NavDirections navDirections = s0.a();
        d.v.c.x1.l.c(view, navDirections);
    }

    public void g(View object) {
        object = SetStabilizerFragment.l((SetStabilizerFragment)this.a).h;
        Boolean bl2 = Boolean.TRUE;
        ((MutableLiveData)object).setValue(bl2);
    }

    public void h(View view) {
        view = (CheckedTextView)view;
        view.toggle();
        BleViewModel bleViewModel = SetStabilizerFragment.k(this.a);
        boolean bl2 = view.isChecked();
        bleViewModel.s1(bl2);
    }
}

