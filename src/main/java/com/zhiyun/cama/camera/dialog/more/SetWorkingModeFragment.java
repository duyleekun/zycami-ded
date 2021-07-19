/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.RadioButton
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.widget.CheckedGroup;
import com.zhiyun.protocol.constants.WorkingMode;
import d.v.c.s0.a7.m1;
import d.v.c.s0.a7.o1.n0;
import d.v.c.s0.a7.o1.o0;
import d.v.c.s0.q6;
import d.v.c.w0.f2;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.i0.b;
import java.util.Iterator;

public class SetWorkingModeFragment
extends a {
    private f2 b;
    private BleViewModel c;

    private void j() {
        MutableLiveData mutableLiveData = this.c.b;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        n0 n02 = new n0(this);
        mutableLiveData.observe(lifecycleOwner, n02);
    }

    private void k() {
        CheckedGroup checkedGroup = this.b.a;
        o0 o02 = new o0(this);
        checkedGroup.setOnCheckedChangeListener(o02);
    }

    private void l() {
        boolean bl2;
        this.b.a.removeAllViews();
        Iterator iterator2 = this.c.A().iterator();
        while (bl2 = iterator2.hasNext()) {
            Object object = (WorkingMode)((Object)iterator2.next());
            int n10 = q6.f(object);
            Object object2 = g.o(this.getResources(), n10);
            object2 = this.c.I((WorkingMode)((Object)object), (String)object2);
            Context context = this.requireContext();
            CheckedGroup checkedGroup = this.b.a;
            object = object.name();
            object = m1.e(context, checkedGroup, object2, object);
            object2 = this.b.a;
            object2.addView((View)object);
        }
    }

    private /* synthetic */ void m(WorkingMode object) {
        CheckedGroup checkedGroup = this.b.a;
        object = object.name();
        m1.b(checkedGroup, object);
    }

    private /* synthetic */ void o(CheckedGroup object, int n10) {
        object = WorkingMode.valueOf((String)((RadioButton)object.findViewById(n10)).getTag());
        this.c.t1((WorkingMode)((Object)object));
    }

    public int h() {
        return 2131558482;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (f2)viewDataBinding;
        this.b = viewDataBinding;
    }

    public /* synthetic */ void n(WorkingMode workingMode) {
        this.m(workingMode);
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (BleViewModel)d.v.i0.b.c(this.requireActivity()).get(BleViewModel.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.j();
        this.l();
        this.k();
    }

    public /* synthetic */ void p(CheckedGroup checkedGroup, int n10) {
        this.o(checkedGroup, n10);
    }
}

