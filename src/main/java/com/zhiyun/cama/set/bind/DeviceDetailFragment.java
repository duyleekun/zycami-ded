/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.set.bind;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.device.active.ActivationActivity;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.cama.set.bind.DeviceDetailFragment$a;
import com.zhiyun.cama.set.bind.DeviceDetailFragment$b;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.q1.h0.k;
import d.v.c.q1.h0.l;
import d.v.c.q1.h0.l0;
import d.v.c.q1.h0.l0$b;
import d.v.c.q1.h0.m;
import d.v.c.q1.h0.n;
import d.v.c.q1.h0.o;
import d.v.c.q1.h0.p;
import d.v.c.q1.h0.q;
import d.v.c.q1.h0.r;
import d.v.c.w0.qg;
import d.v.c.z0.k$b;
import d.v.e.h.a;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.f.h.c;
import d.v.f.i.g;
import d.v.g.g.c1;
import d.v.g0.s;
import d.v.i0.b;
import e.a.i0;
import java.util.Objects;

public class DeviceDetailFragment
extends c {
    private qg a;
    private DeviceBindViewModel b;
    private c1 c;
    private final BleConnection d;
    private e.a.s0.b e;
    private boolean f;
    private boolean g;
    private String h;

    public DeviceDetailFragment() {
        BleConnection bleConnection;
        this.d = bleConnection = BleConnection.W();
    }

    private /* synthetic */ void B(Boolean object) {
        boolean bl2;
        int n10 = this.g;
        if (n10 != 0 && object != null && !(bl2 = ((Boolean)object).booleanValue())) {
            object = this.getResources();
            n10 = 2131951945;
            object = d.v.f.i.g.o((Resources)object, n10);
            n2.e((String)object);
            d.v.c.x1.l.h(this);
        }
    }

    private /* synthetic */ void D(DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState) {
        Object object = DeviceDetailFragment$a.a;
        int n10 = deviceBindViewModel$BindOperateState.ordinal();
        int n11 = object[n10];
        switch (n11) {
            default: {
                break;
            }
            case 11: {
                this.p();
                break;
            }
            case 10: {
                this.o();
                break;
            }
            case 9: {
                object = this.getResources();
                n10 = 2131951944;
                n2.e(d.v.f.i.g.o((Resources)object, n10));
                this.J();
                object = this.b;
                n11 = (int)(((DeviceBindViewModel)object).A() ? 1 : 0);
                if (n11 != 0) break;
                d.v.c.x1.l.h(this);
                break;
            }
            case 8: {
                object = this.getResources();
                n10 = 2131953187;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
                break;
            }
            case 7: {
                object = this.getResources();
                n10 = 2131953189;
                n2.e(d.v.f.i.g.o((Resources)object, n10));
                this.J();
                object = this.b;
                n11 = (int)(((DeviceBindViewModel)object).A() ? 1 : 0);
                if (n11 != 0) break;
                d.v.c.x1.l.h(this);
                break;
            }
            case 6: {
                object = this.getResources();
                n10 = 2131951943;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
                break;
            }
            case 5: {
                object = this.getResources();
                n10 = 2131951942;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
                this.J();
                break;
            }
            case 3: 
            case 4: {
                object = this.getResources();
                n10 = 2131951780;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
                break;
            }
            case 2: {
                object = this.getResources();
                n10 = 2131952395;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
                this.J();
                break;
            }
            case 1: {
                object = this.requireActivity();
                s.o((FragmentActivity)object);
            }
        }
        object = (Object)DeviceBindViewModel$BindOperateState.BIND_OPERATE_STATE_START;
        if (deviceBindViewModel$BindOperateState != object) {
            s.j();
        }
    }

    private /* synthetic */ void F(String string2) {
        if (string2 != null) {
            this.h = string2;
        }
    }

    private /* synthetic */ void H(DialogFragment dialogFragment) {
        this.p();
    }

    private void J() {
        Object object = this.b.y();
        if (object != null) {
            DeviceBindViewModel deviceBindViewModel = this.b;
            String string2 = ((BindDeviceInfo)object).getActiveCode();
            object = ((BindDeviceInfo)object).getSn();
            deviceBindViewModel.Q(string2, (String)object);
        }
    }

    private void K() {
        Object object = new k$b();
        Object object2 = d.v.f.i.g.o(this.getResources(), 2131951976);
        object = ((k$b)object).J((String)object2);
        object2 = this.getResources();
        int n10 = 1;
        Object object3 = new Object[n10];
        String string2 = this.h;
        if (string2 == null) {
            string2 = "";
        }
        object3[0] = string2;
        object2 = d.v.f.i.g.p((Resources)object2, 2131951966, object3);
        object = ((k$b)object).y((String)object2);
        object2 = d.v.f.i.g.o(this.getResources(), 2131951833);
        object = ((k$b)object).D((String)object2, null);
        object2 = d.v.f.i.g.o(this.getResources(), 2131953200);
        object3 = new l(this);
        object = ((k$b)object).G((String)object2, (d.v.f.f.a)object3).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void L(int n10) {
        Object object = this.requireContext();
        int n11 = b2.m((Context)object);
        if (n11 != 0) {
            object = this.b;
            ((DeviceBindViewModel)object).Z(n10);
        } else {
            Object object2 = this.getResources();
            n11 = 2131953261;
            object2 = d.v.f.i.g.o(object2, n11);
            n2.e((String)object2);
        }
    }

    public static /* synthetic */ DeviceBindViewModel h(DeviceDetailFragment deviceDetailFragment) {
        return deviceDetailFragment.b;
    }

    public static /* synthetic */ e.a.s0.b i(DeviceDetailFragment deviceDetailFragment, e.a.s0.b b10) {
        deviceDetailFragment.e = b10;
        return b10;
    }

    public static /* synthetic */ BleConnection j(DeviceDetailFragment deviceDetailFragment) {
        return deviceDetailFragment.d;
    }

    public static /* synthetic */ void k(DeviceDetailFragment deviceDetailFragment) {
        deviceDetailFragment.n();
    }

    public static /* synthetic */ void l(DeviceDetailFragment deviceDetailFragment) {
        deviceDetailFragment.p();
    }

    public static /* synthetic */ void m(DeviceDetailFragment deviceDetailFragment, int n10) {
        deviceDetailFragment.L(n10);
    }

    private void n() {
        Object object = BleConnection.W().a0();
        p p10 = new p(this);
        m m10 = m.a;
        this.e = object = ((i0)object).c(p10, m10);
    }

    private void o() {
        Context context = this.requireContext();
        Intent intent = new Intent(context, ActivationActivity.class);
        this.startActivityForResult(intent, 711);
    }

    private void p() {
        l0$b l0$b = l0.a().b(false);
        d.v.c.x1.l.f(this, l0$b);
    }

    private void q() {
        boolean bl2;
        this.g = bl2 = this.b.A();
    }

    private void r() {
        LiveData liveData = this.b.f;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new o(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.c.a;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new d.v.c.q1.h0.g(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.c.c;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new k(this);
        ((j)liveData).observe(lifecycleOwner, observer);
        liveData = this.b.c;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new r(this);
        liveData.observe(lifecycleOwner, observer);
        liveData = this.b.s();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new q(this);
        ((j)liveData).observe(lifecycleOwner, observer);
        liveData = this.c.r();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new n(this);
        liveData.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void s(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.f = bl2 = true;
            object = this.c;
            Stabilizer stabilizer = BleConnection.W().T();
            ((c1)object).N(stabilizer, false, false);
        } else {
            this.o();
        }
    }

    public static /* synthetic */ void u(Throwable throwable) {
        BleConnection.W().R();
    }

    private /* synthetic */ void v(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            d.v.c.x1.l.h(this);
            object = this.b;
            ((DeviceBindViewModel)object).V(false);
        }
    }

    private /* synthetic */ void x(Boolean object) {
        int n10;
        if (object != null && (n10 = this.f) != 0) {
            boolean bl2 = (Boolean)object;
            if (bl2) {
                this.K();
            } else {
                object = this.getResources();
                n10 = 2131953198;
                object = d.v.f.i.g.o((Resources)object, n10);
                n2.e((String)object);
            }
            bl2 = false;
            object = null;
            this.f = false;
        }
    }

    private /* synthetic */ void z(Boolean bl2) {
        boolean bl3;
        if (bl2 != null && !(bl3 = bl2.booleanValue()) && (bl3 = this.f)) {
            bl2 = this.getResources();
            int n10 = 2131953261;
            n2.e(d.v.f.i.g.o((Resources)bl2, n10));
            bl3 = false;
            bl2 = null;
            this.f = false;
        }
    }

    public /* synthetic */ void A(Boolean bl2) {
        this.z(bl2);
    }

    public /* synthetic */ void C(Boolean bl2) {
        this.B(bl2);
    }

    public /* synthetic */ void E(DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState) {
        this.D(deviceBindViewModel$BindOperateState);
    }

    public /* synthetic */ void G(String string2) {
        this.F(string2);
    }

    public /* synthetic */ void I(DialogFragment dialogFragment) {
        this.H(dialogFragment);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        String string2;
        String string3;
        super.onActivityResult(n10, n11, intent);
        int n12 = -1;
        if (n12 == n11 && (n11 = 711) == n10 && intent != null && (n10 = (int)(Objects.equals(string3 = intent.getStringExtra("bind"), string2 = "success") ? 1 : 0)) != 0) {
            string3 = this.getResources();
            n11 = 2131952395;
            string3 = d.v.f.i.g.o((Resources)string3, n11);
            n2.e(string3);
            this.J();
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (DeviceBindViewModel)d.v.i0.b.c(this.requireActivity()).get(DeviceBindViewModel.class);
        this.b = object;
        object = (c1)d.v.i0.b.c(this.requireActivity()).get(c1.class);
        this.c = object;
        this.q();
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        object = (qg)DataBindingUtil.inflate((LayoutInflater)object, 2131558756, object2, false);
        this.a = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.a;
        object2 = new DeviceDetailFragment$b(this);
        ((qg)object).B((DeviceDetailFragment$b)object2);
        object = this.a;
        object2 = this.b;
        ((qg)object).A((DeviceBindViewModel)object2);
        return this.a.getRoot();
    }

    public void onDestroy() {
        boolean bl2;
        super.onDestroy();
        Object object = this.e;
        if (object != null && !(bl2 = object.isDisposed())) {
            object = this.e;
            object.dispose();
        }
        this.b.X();
        object = (Boolean)this.c.a.getValue();
        bl2 = d.v.e.h.a.c((Boolean)object);
        if (bl2) {
            this.c.R();
            object = this.c;
            Stabilizer stabilizer = BleConnection.W().T();
            ((c1)object).M(stabilizer, false);
        }
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.r();
    }

    public /* synthetic */ void t(Boolean bl2) {
        this.s(bl2);
    }

    public /* synthetic */ void w(Boolean bl2) {
        this.v(bl2);
    }

    public /* synthetic */ void y(Boolean bl2) {
        this.x(bl2);
    }
}

