/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.View
 *  android.widget.FrameLayout
 */
package com.zhiyun.cama.camera.dialog.more;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.dialog.more.GestureModeFragment$a;
import d.v.c.s0.u6;
import d.v.c.w0.x1;
import d.v.e.l.o1;
import d.v.f.h.a;
import d.v.i0.b;

public class GestureModeFragment
extends a {
    private x1 b;
    private u6 c;

    public static /* synthetic */ u6 j(GestureModeFragment gestureModeFragment) {
        return gestureModeFragment.c;
    }

    public static int l(Integer n10) {
        int n11;
        int n12 = 2131953251;
        if (n10 == null) {
            return n12;
        }
        int n13 = n10;
        if (n13 != 0 && n13 == (n11 = 1)) {
            n12 = 2131953254;
        }
        return n12;
    }

    private void m() {
        MutableLiveData mutableLiveData = this.c.g0();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        d.v.c.s0.a7.o1.a a10 = new d.v.c.s0.a7.o1.a(this);
        mutableLiveData.observe(lifecycleOwner, a10);
    }

    private void n() {
        FrameLayout frameLayout = this.b.a;
        Integer n10 = 0;
        frameLayout.setTag((Object)n10);
        frameLayout = this.b.b;
        n10 = 1;
        frameLayout.setTag((Object)n10);
    }

    private /* synthetic */ void o(Integer n10) {
        this.k(n10);
    }

    public int h() {
        return 2131558478;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (x1)viewDataBinding;
        this.b = viewDataBinding;
        GestureModeFragment$a gestureModeFragment$a = new GestureModeFragment$a(this);
        ((x1)viewDataBinding).z(gestureModeFragment$a);
    }

    public void k(Integer n10) {
        if (n10 == null) {
            return;
        }
        int n11 = n10;
        int n12 = 2131231601;
        int n13 = 2131232012;
        int n14 = 2131232234;
        if (n11 == 0) {
            this.b.a.setBackgroundResource(n13);
            n10 = this.b.c;
            Resources resources = this.getResources();
            Drawable drawable2 = o1.o(resources, n12);
            n10.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable2, null);
            this.b.b.setBackgroundResource(n14);
            n10 = this.b.d;
            n10.setCompoundDrawables(null, null, null, null);
        } else {
            this.b.a.setBackgroundResource(n14);
            this.b.c.setCompoundDrawables(null, null, null, null);
            this.b.b.setBackgroundResource(n13);
            n10 = this.b.d;
            Resources resources = this.getResources();
            Drawable drawable3 = o1.o(resources, n12);
            n10.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, drawable3, null);
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (u6)d.v.i0.b.c(this.requireActivity()).get(u6.class);
        this.c = object;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.n();
        this.m();
    }

    public /* synthetic */ void p(Integer n10) {
        this.o(n10);
    }
}

