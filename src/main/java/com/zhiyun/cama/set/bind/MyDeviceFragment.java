/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 *  android.os.Bundle
 *  android.view.LayoutInflater
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.zhiyun.cama.set.bind;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.account.widget.StatusView;
import com.zhiyun.cama.data.api.entity.BindDeviceInfo;
import com.zhiyun.cama.device.active.ActivationActivity;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$BindOperateState;
import com.zhiyun.cama.set.bind.DeviceBindViewModel$Status;
import com.zhiyun.cama.set.bind.MyDeviceFragment$a;
import com.zhiyun.cama.set.bind.MyDeviceFragment$b;
import com.zhiyun.cama.set.bind.MyDeviceFragment$c;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.permission.Permission;
import d.v.c.n0.c;
import d.v.c.q1.h0.a;
import d.v.c.q1.h0.a0;
import d.v.c.q1.h0.b0;
import d.v.c.q1.h0.c0;
import d.v.c.q1.h0.d0;
import d.v.c.q1.h0.e0;
import d.v.c.q1.h0.f0;
import d.v.c.q1.h0.g0;
import d.v.c.q1.h0.k0;
import d.v.c.q1.h0.k0$b;
import d.v.c.q1.h0.m0;
import d.v.c.q1.h0.m0$b;
import d.v.c.q1.h0.n0;
import d.v.c.q1.h0.t;
import d.v.c.q1.h0.u;
import d.v.c.q1.h0.v;
import d.v.c.q1.h0.w;
import d.v.c.q1.h0.x;
import d.v.c.q1.h0.y;
import d.v.c.q1.h0.z;
import d.v.c.w0.uf;
import d.v.c.x1.l;
import d.v.c.y0.b.s$e;
import d.v.e.i.j;
import d.v.e.l.b2;
import d.v.e.l.n2;
import d.v.e.l.o1;
import d.v.e0.ce;
import d.v.e0.td;
import d.v.f.i.g;
import d.v.g0.k$a;
import d.v.g0.k$b;
import d.v.g0.s;
import d.v.x.b;
import d.v.x.c$b;
import e.a.i0;
import java.util.List;
import java.util.Objects;

public class MyDeviceFragment
extends d.v.f.h.c {
    private static final int f = 1;
    private uf a;
    private DeviceBindViewModel b;
    private n0 c;
    private final BleConnection d;
    private e.a.s0.b e;

    public MyDeviceFragment() {
        BleConnection bleConnection;
        this.d = bleConnection = BleConnection.W();
    }

    public static /* synthetic */ void B(Throwable throwable) {
    }

    private /* synthetic */ void C(View object, int n10, BindDeviceInfo bindDeviceInfo) {
        object = this.b;
        BindDeviceInfo bindDeviceInfo2 = (BindDeviceInfo)this.c.getItem(n10);
        ((DeviceBindViewModel)object).U(bindDeviceInfo2);
        object = this.requireContext();
        boolean bl2 = b2.m((Context)object);
        if (bl2) {
            Object object2;
            bindDeviceInfo2 = this.requireContext();
            object = new k$b((Context)bindDeviceInfo2);
            bindDeviceInfo2 = this.getResources();
            int n11 = 2131953186;
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            Object object3 = ((BindDeviceInfo)this.c.getItem(n10)).getDeviceName();
            if (object3 == null) {
                object2 = "";
            } else {
                object3 = this.c;
                object2 = ((BindDeviceInfo)((c)object3).getItem(n10)).getDeviceName();
            }
            objectArray[0] = object2;
            object2 = g.p((Resources)bindDeviceInfo2, n11, objectArray);
            object = (k$b)((k$a)object).B((String)object2);
            object2 = d.v.c.q1.h0.a.a;
            object = (k$b)((k$a)object).p((d.v.f.f.a)object2);
            object2 = new d0(this, bindDeviceInfo);
            object = (k$b)((k$a)object).w((d.v.f.f.a)object2);
            object2 = this.getChildFragmentManager();
            ((k$a)object).D((FragmentManager)object2);
        } else {
            object = this.getResources();
            n10 = 2131953261;
            object = g.o((Resources)object, n10);
            n2.e((String)object);
        }
    }

    private /* synthetic */ void E(View view, int n10, BindDeviceInfo object) {
        object = this.c;
        BindDeviceInfo bindDeviceInfo = (BindDeviceInfo)((c)object).getItem(n10);
        if (bindDeviceInfo != null) {
            String string2;
            boolean bl2;
            String string3;
            object = (BindDeviceInfo)this.b.b.getValue();
            if (object != null && (string3 = ((BindDeviceInfo)object).getSn()) != null && (bl2 = (string3 = ((BindDeviceInfo)object).getSn()).equalsIgnoreCase(string2 = bindDeviceInfo.getSn()))) {
                string3 = ((BindDeviceInfo)object).getFirmwareVersion();
                bindDeviceInfo.setFirmwareVersion(string3);
                boolean bl3 = ((BindDeviceInfo)object).isFetchSuccess();
                bindDeviceInfo.setFetchSuccess(bl3);
            } else {
                boolean bl4 = false;
                object = null;
                bindDeviceInfo.setFirmwareVersion(null);
            }
            object = this.b;
            ((DeviceBindViewModel)object).U(bindDeviceInfo);
            n10 = 2131362269;
            l.a(view, n10);
        }
    }

    private /* synthetic */ void G(DeviceBindViewModel$Status object) {
        int[] nArray = MyDeviceFragment$b.b;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = nArray[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 == n11) {
                            this.b0();
                        }
                    } else {
                        this.c0();
                    }
                } else {
                    object = this.a.g;
                    ((StatusView)((Object)object)).c();
                }
            } else {
                object = this.a.g;
                ((StatusView)((Object)object)).a();
            }
        } else {
            object = this.a.g;
            ((StatusView)((Object)object)).e();
        }
    }

    private /* synthetic */ void I(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            this.q();
            object = this.b;
            ((DeviceBindViewModel)object).S(false);
        }
    }

    private /* synthetic */ void K(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            BindDeviceInfo bindDeviceInfo;
            object = this.c.getData();
            if (object != null) {
                object = this.c.getData();
                bindDeviceInfo = this.b.y();
                object.remove(bindDeviceInfo);
                object = this.c;
                ((RecyclerView$Adapter)object).notifyDataSetChanged();
            }
            object = this.b;
            bindDeviceInfo = null;
            ((DeviceBindViewModel)object).V(false);
        }
    }

    private /* synthetic */ void M(List object) {
        this.c.d((List)object);
        this.c.notifyDataSetChanged();
        object = this.a.e;
        n0 n02 = this.c;
        ((RecyclerView)object).setAdapter(n02);
    }

    private /* synthetic */ void O(DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState) {
        Object object = MyDeviceFragment$b.a;
        int bl2 = deviceBindViewModel$BindOperateState.ordinal();
        int n10 = object[bl2];
        boolean bl3 = true;
        int n11 = 0;
        switch (n10) {
            default: {
                break;
            }
            case 11: {
                this.s();
                break;
            }
            case 10: {
                this.r();
                break;
            }
            case 9: {
                this.Y(bl3);
                object = this.getResources();
                int n12 = 2131951944;
                object = g.o((Resources)object, n12);
                n2.e((String)object);
                break;
            }
            case 8: {
                object = this.getResources();
                int n13 = 2131953187;
                object = g.o((Resources)object, n13);
                n2.e((String)object);
                break;
            }
            case 7: {
                object = this.getResources();
                n11 = 2131953189;
                object = g.o((Resources)object, n11);
                n2.e((String)object);
                this.Y(bl3);
                break;
            }
            case 6: {
                object = this.getResources();
                int n14 = 2131951943;
                object = g.o((Resources)object, n14);
                n2.e((String)object);
                break;
            }
            case 5: {
                this.Y(false);
                object = this.getResources();
                int n15 = 2131951942;
                object = g.o((Resources)object, n15);
                n2.e((String)object);
                break;
            }
            case 3: 
            case 4: {
                object = this.getResources();
                int n16 = 2131951780;
                object = g.o((Resources)object, n16);
                n2.e((String)object);
                break;
            }
            case 2: {
                object = this.getResources();
                int n17 = 2131952395;
                object = g.o((Resources)object, n17);
                n2.e((String)object);
                this.Y(false);
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

    private /* synthetic */ void Q(BindDeviceInfo bindDeviceInfo, DialogFragment dialogFragment) {
        int n10 = bindDeviceInfo.getDeviceId();
        this.d0(n10);
    }

    private /* synthetic */ void S() {
        this.a0(false);
    }

    private /* synthetic */ void U(td object) {
        if (object != null) {
            boolean bl2 = this.isAdded();
            if (!bl2) {
                return;
            }
            object = k0.u((td)object);
            Object object2 = new e0(this);
            ((k0)object).w((k0$b)object2);
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        }
    }

    private /* synthetic */ void W(boolean bl2) {
        Object object = BluetoothAdapter.getDefaultAdapter();
        boolean bl3 = object.isEnabled();
        int n10 = 1;
        if (bl3) {
            object = new d.v.c.y0.b.s(n10 != 0, bl2);
            Object object2 = new MyDeviceFragment$a(this);
            ((d.v.c.y0.b.s)object).Y((s$e)object2);
            bl2 = false;
            ((d.v.c.y0.b.s)object).X(false);
            object2 = this.getChildFragmentManager();
            ((d.v.f.g.b)object).q((FragmentManager)object2);
        } else {
            object = "android.bluetooth.adapter.action.REQUEST_ENABLE";
            Intent intent = new Intent((String)object);
            this.startActivityForResult(intent, n10);
        }
    }

    private void Y(boolean bl2) {
        Object object;
        Object object2 = this.b.y();
        if (object2 == null) {
            return;
        }
        if (bl2 && (object = this.c.getData()) != null) {
            this.c.getData().remove(object2);
            object = this.c;
            ((RecyclerView$Adapter)object).notifyDataSetChanged();
        }
        object = this.b;
        String string2 = ((BindDeviceInfo)object2).getActiveCode();
        object2 = ((BindDeviceInfo)object2).getSn();
        ((DeviceBindViewModel)object).Q(string2, (String)object2);
    }

    private void Z() {
        ce ce2 = ce.E0();
        d.v.c.q1.h0.s s10 = new d.v.c.q1.h0.s(this);
        ce2.z0(s10);
    }

    private void a0(boolean bl2) {
        Object object = Permission.LOCATION;
        Object object2 = new c$b((Permission)((Object)object));
        object = new u(this, bl2);
        c$b c$b = ((c$b)object2).a((b)object);
        object2 = this.getChildFragmentManager();
        c$b.b((FragmentManager)object2);
    }

    private void b0() {
        StatusView statusView = this.a.g;
        Object object = o1.o(this.getResources(), 2131231806);
        statusView.setErrorImage((Drawable)object);
        statusView = this.a.g;
        object = g.o(this.getResources(), 2131953290);
        statusView.setErrorText((String)object);
        this.a.g.d();
    }

    private void c0() {
        StatusView statusView = this.a.g;
        Object object = o1.o(this.getResources(), 2131231809);
        statusView.setErrorImage((Drawable)object);
        statusView = this.a.g;
        object = g.o(this.getResources(), 2131952517);
        statusView.setErrorText((String)object);
        this.a.g.d();
    }

    private void d0(int n10) {
        Object object = this.requireContext();
        int n11 = b2.m((Context)object);
        if (n11 != 0) {
            object = this.b;
            ((DeviceBindViewModel)object).Z(n10);
        } else {
            Object object2 = this.getResources();
            n11 = 2131953261;
            object2 = g.o(object2, n11);
            n2.e((String)object2);
        }
    }

    public static /* synthetic */ void h(MyDeviceFragment myDeviceFragment) {
        myDeviceFragment.q();
    }

    public static /* synthetic */ DeviceBindViewModel i(MyDeviceFragment myDeviceFragment) {
        return myDeviceFragment.b;
    }

    public static /* synthetic */ void j(MyDeviceFragment myDeviceFragment, boolean bl2) {
        myDeviceFragment.a0(bl2);
    }

    public static /* synthetic */ void k(MyDeviceFragment myDeviceFragment) {
        myDeviceFragment.p();
    }

    public static /* synthetic */ void l(MyDeviceFragment myDeviceFragment) {
        myDeviceFragment.Z();
    }

    public static /* synthetic */ void m(MyDeviceFragment myDeviceFragment) {
        myDeviceFragment.r();
    }

    public static /* synthetic */ void n(MyDeviceFragment myDeviceFragment) {
        myDeviceFragment.s();
    }

    private void o() {
        Object object = this.d.a0();
        x x10 = new x(this);
        g0 g02 = g0.a;
        this.e = object = ((i0)object).c(x10, g02);
    }

    private void p() {
        Object object = this.d.V();
        w w10 = new w(this);
        a0 a02 = a0.a;
        this.e = object = ((e.a.z)object).c(w10, a02);
    }

    private void q() {
        Object object = this.requireContext();
        boolean bl2 = b2.m((Context)object);
        if (bl2) {
            object = this.b;
            ((DeviceBindViewModel)object).r();
        } else {
            object = this.b.d;
            DeviceBindViewModel$Status deviceBindViewModel$Status = DeviceBindViewModel$Status.NET_ERROR;
            ((MutableLiveData)object).postValue((Object)deviceBindViewModel$Status);
        }
    }

    private void r() {
        Context context = this.requireContext();
        Intent intent = new Intent(context, ActivationActivity.class);
        this.startActivityForResult(intent, 711);
    }

    private void s() {
        m0$b m0$b = m0.b().b(false);
        l.f(this, m0$b);
    }

    private void t() {
        Object object = new n0();
        this.c = object;
        Context context = this.requireContext();
        object = new LinearLayoutManager(context, 1, false);
        this.a.e.setLayoutManager((RecyclerView$LayoutManager)object);
        this.q();
    }

    private void u() {
        n0 n02 = this.c;
        d.v.f.f.b b10 = new v(this);
        n02.i(b10);
        n02 = this.c;
        b10 = new c0(this);
        n02.j(b10);
    }

    private void v() {
        MutableLiveData mutableLiveData = this.b.d;
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new t(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.b.e;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new b0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.b.f;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new f0(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.b.g;
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new y(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.b.s();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new z(this);
        ((j)mutableLiveData).observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void w(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.Z();
        } else {
            this.r();
        }
    }

    public static /* synthetic */ void y(Throwable throwable) {
        BleConnection.W().R();
    }

    private /* synthetic */ void z(Boolean bl2) {
        boolean bl3 = bl2;
        if (bl3) {
            this.o();
        } else {
            this.s();
        }
    }

    public /* synthetic */ void A(Boolean bl2) {
        this.z(bl2);
    }

    public /* synthetic */ void D(View view, int n10, BindDeviceInfo bindDeviceInfo) {
        this.C(view, n10, bindDeviceInfo);
    }

    public /* synthetic */ void F(View view, int n10, BindDeviceInfo bindDeviceInfo) {
        this.E(view, n10, bindDeviceInfo);
    }

    public /* synthetic */ void H(DeviceBindViewModel$Status deviceBindViewModel$Status) {
        this.G(deviceBindViewModel$Status);
    }

    public /* synthetic */ void J(Boolean bl2) {
        this.I(bl2);
    }

    public /* synthetic */ void L(Boolean bl2) {
        this.K(bl2);
    }

    public /* synthetic */ void N(List list) {
        this.M(list);
    }

    public /* synthetic */ void P(DeviceBindViewModel$BindOperateState deviceBindViewModel$BindOperateState) {
        this.O(deviceBindViewModel$BindOperateState);
    }

    public /* synthetic */ void R(BindDeviceInfo bindDeviceInfo, DialogFragment dialogFragment) {
        this.Q(bindDeviceInfo, dialogFragment);
    }

    public /* synthetic */ void T() {
        this.S();
    }

    public /* synthetic */ void V(td td2) {
        this.U(td2);
    }

    public /* synthetic */ void X(boolean bl2) {
        this.W(bl2);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        String string2;
        String string3;
        super.onActivityResult(n10, n11, intent);
        int n12 = -1;
        if (n12 == n11 && (n11 = 711) == n10 && intent != null && (n10 = (int)(Objects.equals(string3 = intent.getStringExtra("bind"), string2 = "success") ? 1 : 0)) != 0) {
            this.q();
            string3 = this.getResources();
            n11 = 2131952864;
            n2.e(g.o((Resources)string3, n11));
            n10 = 0;
            string3 = null;
            this.Y(false);
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (DeviceBindViewModel)d.v.i0.b.c(this.requireActivity()).get(DeviceBindViewModel.class);
        this.b = object;
        ((DeviceBindViewModel)object).j();
    }

    public View onCreateView(LayoutInflater object, ViewGroup object2, Bundle bundle) {
        object = (uf)DataBindingUtil.inflate((LayoutInflater)object, 2131558718, object2, false);
        this.a = object;
        ((ViewDataBinding)object).setLifecycleOwner(this);
        object = this.a;
        object2 = new MyDeviceFragment$c(this);
        ((uf)object).C((MyDeviceFragment$c)object2);
        object = this.a;
        object2 = this.b;
        ((uf)object).B((DeviceBindViewModel)object2);
        return this.a.getRoot();
    }

    public void onDestroy() {
        boolean bl2;
        super.onDestroy();
        e.a.s0.b b10 = this.e;
        if (b10 != null && !(bl2 = b10.isDisposed())) {
            b10 = this.e;
            b10.dispose();
        }
        this.b.R();
        this.b.X();
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.t();
        this.u();
        this.v();
    }

    public /* synthetic */ void x(Boolean bl2) {
        this.w(bl2);
    }
}

