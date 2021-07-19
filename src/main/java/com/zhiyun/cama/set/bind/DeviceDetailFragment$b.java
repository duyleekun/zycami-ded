/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.view.View
 */
package com.zhiyun.cama.set.bind;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.cama.set.bind.DeviceDetailFragment;
import d.v.c.q1.h0.a;
import d.v.c.q1.h0.h;
import d.v.c.q1.h0.i;
import d.v.c.q1.h0.j;
import d.v.c.x1.l;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import e.a.s0.b;
import e.a.z;

public class DeviceDetailFragment$b {
    public final /* synthetic */ DeviceDetailFragment a;

    public DeviceDetailFragment$b(DeviceDetailFragment deviceDetailFragment) {
        this.a = deviceDetailFragment;
    }

    private /* synthetic */ void d(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            object = this.a;
            DeviceDetailFragment.k((DeviceDetailFragment)object);
        } else {
            object = this.a;
            DeviceDetailFragment.l((DeviceDetailFragment)object);
        }
    }

    private /* synthetic */ void f(Throwable throwable) {
        DeviceDetailFragment.k(this.a);
    }

    private /* synthetic */ void h(int n10, DialogFragment dialogFragment) {
        DeviceDetailFragment.m(this.a, n10);
    }

    public void a() {
        DeviceDetailFragment.h(this.a).k();
    }

    public void b() {
        DeviceDetailFragment deviceDetailFragment = this.a;
        Object object = DeviceDetailFragment.j(deviceDetailFragment).V();
        i i10 = new i(this);
        j j10 = new j(this);
        object = ((z)object).c(i10, j10);
        DeviceDetailFragment.i(deviceDetailFragment, (b)object);
    }

    public void c(View view) {
        l.g(view);
    }

    public /* synthetic */ void e(Boolean bl2) {
        this.d(bl2);
    }

    public /* synthetic */ void g(Throwable throwable) {
        this.f(throwable);
    }

    public /* synthetic */ void i(int n10, DialogFragment dialogFragment) {
        this.h(n10, dialogFragment);
    }

    public void j() {
        int n10 = DeviceDetailFragment.h(this.a).y().getDeviceId();
        Object object = DeviceDetailFragment.h(this.a).y().getDeviceName();
        Context context = this.a.requireContext();
        Object object2 = new k$b(context);
        context = this.a.getResources();
        Object[] objectArray = new Object[]{object};
        object = g.p((Resources)context, 2131953186, objectArray);
        object = (k$b)((k$a)object2).B((String)object);
        object2 = d.v.c.q1.h0.a.a;
        object = (k$b)((k$a)object).p((d.v.f.f.a)object2);
        object2 = new h(this, n10);
        k$b k$b = (k$b)((k$a)object).w((d.v.f.f.a)object2);
        object = this.a.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }
}

