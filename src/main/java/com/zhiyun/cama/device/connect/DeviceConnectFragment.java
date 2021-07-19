/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.os.Bundle
 *  android.text.TextUtils
 *  android.view.View
 */
package com.zhiyun.cama.device.connect;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.app.ActivityCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import com.zhiyun.cama.device.connect.DeviceConnectFragment$a;
import com.zhiyun.cama.device.connect.DeviceConnectFragment$b;
import com.zhiyun.cama.device.connect.DeviceConnectFragment$c;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleDevice;
import com.zhiyun.device.connection.BleDevice$State;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$ScanFailType;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;
import com.zhiyun.permission.Permission;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.n0.c;
import d.v.c.w0.d6;
import d.v.c.y0.b.k;
import d.v.c.y0.b.l;
import d.v.c.y0.b.m;
import d.v.c.y0.b.n;
import d.v.c.y0.b.o;
import d.v.c.y0.b.p;
import d.v.c.y0.b.q;
import d.v.e.l.h2;
import d.v.f.h.a;
import d.v.f.i.g;
import d.v.g0.k$b;
import d.v.x.b;
import d.v.x.c$b;
import java.util.ArrayList;
import java.util.List;

public class DeviceConnectFragment
extends a {
    private static final int e = 1;
    private d6 b;
    private BleDeviceViewModel c;
    private d.v.c.y0.b.v.b d;

    private /* synthetic */ void B() {
        MutableLiveData mutableLiveData = this.c.y();
        String string2 = g.o(this.getResources(), 2131951986);
        mutableLiveData.setValue(string2);
        this.c.G();
    }

    private void D() {
        Object object = this.getContext();
        Object object2 = new LinearLayoutManager((Context)object);
        this.b.e.setLayoutManager((RecyclerView$LayoutManager)object2);
        object2 = this.b.e;
        object = new DefaultItemAnimator();
        ((RecyclerView)object2).setItemAnimator((RecyclerView$ItemAnimator)object);
        object2 = this.b.e;
        object = new DeviceConnectFragment$a(this);
        this.d = object;
        ((RecyclerView)object2).setAdapter((RecyclerView$Adapter)object);
        object2 = this.d;
        object = new ArrayList();
        ((c)object2).d((List)object);
    }

    private void E() {
        Object object = new d.v.c.z0.k$b();
        Object object2 = g.s(this, 2131951890);
        object = ((d.v.c.z0.k$b)object).J((String)object2);
        object2 = g.s(this, 2131951949);
        object = ((d.v.c.z0.k$b)object).y((String)object2).D(null, null);
        String string2 = g.s(this, 2131952621);
        object = ((d.v.c.z0.k$b)object).G(string2, null);
        int n10 = h2.b(300.0f);
        object = ((d.v.c.z0.k$b)object).O(n10);
        n10 = h2.b(187.0f);
        object = ((d.v.c.z0.k$b)object).C(n10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void F() {
        Object object = this.getContext();
        k$b k$b = new k$b((Context)object);
        object = this.c.z();
        k$b = (k$b)k$b.n((String)object);
        object = this.getChildFragmentManager();
        k$b.D((FragmentManager)object);
    }

    private void G() {
        Object object = new d.v.c.z0.k$b();
        Object object2 = g.s(this, 2131952619);
        object = ((d.v.c.z0.k$b)object).J((String)object2);
        object2 = g.s(this, 2131951947);
        object = ((d.v.c.z0.k$b)object).y((String)object2);
        object2 = g.s(this, 2131951833);
        object = ((d.v.c.z0.k$b)object).D((String)object2, null);
        object2 = g.s(this, 2131951991);
        p p10 = new p(this);
        object = ((d.v.c.z0.k$b)object).G((String)object2, p10);
        int n10 = h2.b(300.0f);
        object = ((d.v.c.z0.k$b)object).O(n10).v();
        object2 = this.getChildFragmentManager();
        ((d.v.f.g.b)object).q((FragmentManager)object2);
    }

    private void H() {
        String string2;
        Object object;
        Object object2 = BleConnection.W().Y();
        if (object2 == null) {
            object2 = "";
        } else {
            object = new StringBuilder();
            string2 = "(";
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append(")");
            object2 = ((StringBuilder)object).toString();
        }
        object = g.m(this.requireContext(), 2131952853);
        string2 = this.requireContext();
        Object[] objectArray = new Object[]{object, object2};
        object2 = g.n((Context)string2, 2131951948, objectArray);
        object = new d.v.c.z0.k$b();
        string2 = g.s(this, 2131952619);
        object2 = ((d.v.c.z0.k$b)object).J(string2).y((String)object2).D(null, null);
        string2 = g.s(this, 2131952621);
        object2 = ((d.v.c.z0.k$b)object2).G(string2, null);
        int n10 = h2.b(300.0f);
        object2 = ((d.v.c.z0.k$b)object2).O(n10).v();
        object = this.getChildFragmentManager();
        ((d.v.f.g.b)object2).q((FragmentManager)object);
    }

    private void I() {
        Object object = Permission.LOCATION;
        c$b c$b = new c$b((Permission)((Object)object));
        object = new o(this);
        c$b = c$b.a((b)object);
        object = this.getChildFragmentManager();
        c$b.b((FragmentManager)object);
    }

    private void J() {
        this.requireActivity().setResult(3);
        this.requireActivity().finish();
    }

    private void K() {
        this.requireActivity().setResult(1);
        this.requireActivity().finish();
    }

    private void L() {
        this.requireActivity().setResult(2);
        this.requireActivity().finish();
    }

    private void M(BleDevice$State bleDevice$State) {
        d.v.c.y0.b.v.b b10 = this.d;
        if (b10 != null) {
            Stabilizer stabilizer = this.c.v();
            b10.e(stabilizer, bleDevice$State);
        }
    }

    public static /* synthetic */ BleDeviceViewModel j(DeviceConnectFragment deviceConnectFragment) {
        return deviceConnectFragment.c;
    }

    public static /* synthetic */ void k(DeviceConnectFragment deviceConnectFragment) {
        deviceConnectFragment.n();
    }

    public static /* synthetic */ void l(DeviceConnectFragment deviceConnectFragment) {
        deviceConnectFragment.I();
    }

    private void m(BleDevice object) {
        Object object2 = this.d.getData();
        int n10 = object2.indexOf(object);
        if (n10 >= 0) {
            object2 = (BleDevice)object2.get(n10);
            BleDevice$State bleDevice$State = ((BleDevice)object2).b;
            object = ((BleDevice)object).b;
            if (bleDevice$State != object) {
                ((BleDevice)object2).b = object;
                object = this.d;
                ((RecyclerView$Adapter)object).notifyItemChanged(n10);
            }
        } else {
            object2.add(object);
            object = this.d;
            int n11 = object2.size();
            ((RecyclerView$Adapter)object).notifyItemChanged(n11);
        }
    }

    private void n() {
        ActivityCompat.finishAfterTransition(this.requireActivity());
    }

    private void o() {
        MutableLiveData mutableLiveData = this.c.x();
        LifecycleOwner lifecycleOwner = this.getViewLifecycleOwner();
        Observer observer = new n(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.F();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new q(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.s();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new l(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.A();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new m(this);
        mutableLiveData.observe(lifecycleOwner, observer);
        mutableLiveData = this.c.w();
        lifecycleOwner = this.getViewLifecycleOwner();
        observer = new k(this);
        mutableLiveData.observe(lifecycleOwner, observer);
    }

    private /* synthetic */ void p(BleDeviceViewModel$ScanFailType object) {
        Object object2 = DeviceConnectFragment$b.c;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 == n11) {
                        object = this.c.y();
                        object2 = this.getResources();
                        int n12 = 2131951984;
                        object2 = g.o((Resources)object2, n12);
                        ((MutableLiveData)object).setValue(object2);
                        this.F();
                    }
                } else {
                    object = this.c.y();
                    object2 = this.getResources();
                    int n13 = 2131951983;
                    object2 = g.o((Resources)object2, n13);
                    ((MutableLiveData)object).setValue(object2);
                    this.F();
                }
            } else {
                object = this.c.y();
                object2 = this.getResources();
                int n14 = 2131951981;
                object2 = g.o((Resources)object2, n14);
                ((MutableLiveData)object).setValue(object2);
            }
        } else {
            object = this.c.y();
            object2 = this.getResources();
            int n15 = 2131951982;
            object2 = g.o((Resources)object2, n15);
            ((MutableLiveData)object).setValue(object2);
            this.F();
        }
    }

    private /* synthetic */ void r(BleDeviceViewModel$ShowStatus object) {
        Object object2 = BleDeviceViewModel$ShowStatus.SHOW_STATE_NO_DEVICE;
        if (object == object2) {
            object = this.c.y();
            object2 = this.getResources();
            int n10 = 2131951987;
            object2 = g.o((Resources)object2, n10);
            ((MutableLiveData)object).setValue(object2);
        }
    }

    private /* synthetic */ void t(BleDeviceViewModel$ConnectStatus object) {
        Object object2 = DeviceConnectFragment$b.b;
        int n10 = ((Enum)object).ordinal();
        int n11 = 1;
        if ((n10 = object2[n10]) != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 5;
                    if (n10 == n11) {
                        object = this.c.s().getValue();
                        if (object == (object2 = (Object)((Object)BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_ING))) {
                            this.E();
                        } else {
                            object = BleDevice$State.UNCONNECTED;
                            this.M((BleDevice$State)((Object)object));
                        }
                        object = this.c;
                        ((BleDeviceViewModel)object).o();
                    }
                } else {
                    object = BleDevice$State.CONNECTING;
                    this.M((BleDevice$State)((Object)object));
                }
            } else {
                object = BleDevice$State.CONNECTED;
                this.M((BleDevice$State)((Object)object));
                object = this.c;
                ((BleDeviceViewModel)object).o();
            }
        } else {
            this.E();
            object = BleDevice$State.UNCONNECTED;
            this.M((BleDevice$State)((Object)object));
            object = this.c;
            ((BleDeviceViewModel)object).o();
        }
    }

    private /* synthetic */ void v(BleDevice bleDevice) {
        String string2;
        boolean bl2;
        if (bleDevice != null && !(bl2 = TextUtils.isEmpty((CharSequence)(string2 = bleDevice.a.b)))) {
            this.m(bleDevice);
        }
    }

    private /* synthetic */ void x(BleDeviceViewModel$OperationStatus enum_) {
        int[] nArray = DeviceConnectFragment$b.a;
        int n10 = enum_.ordinal();
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
                            enum_ = BleDevice$State.CONNECTED;
                            this.M((BleDevice$State)enum_);
                            this.G();
                        }
                    } else {
                        enum_ = BleDevice$State.CONNECTED;
                        this.M((BleDevice$State)enum_);
                        this.H();
                    }
                } else {
                    this.K();
                    enum_ = BleDevice$State.CONNECTED;
                    this.M((BleDevice$State)enum_);
                }
            } else {
                this.L();
            }
        } else {
            this.J();
        }
    }

    private /* synthetic */ void z(DialogFragment dialogFragment) {
        dialogFragment = new Intent("android.settings.WIFI_SETTINGS");
        this.startActivityForResult((Intent)dialogFragment, 1);
    }

    public /* synthetic */ void A(DialogFragment dialogFragment) {
        this.z(dialogFragment);
    }

    public /* synthetic */ void C() {
        this.B();
    }

    public int h() {
        return 2131558563;
    }

    public void i(ViewDataBinding viewDataBinding) {
        super.i(viewDataBinding);
        viewDataBinding = (d6)viewDataBinding;
        this.b = viewDataBinding;
        Object object = this.c;
        ((d6)viewDataBinding).B((BleDeviceViewModel)object);
        viewDataBinding = this.b;
        object = new DeviceConnectFragment$c(this);
        ((d6)viewDataBinding).A((DeviceConnectFragment$c)object);
    }

    public void onActivityResult(int n10, int n11, Intent intent) {
        super.onActivityResult(n10, n11, intent);
        n11 = 1;
        if (n10 == n11) {
            Object object = BleConnection.W();
            n10 = (int)(((BleConnection)object).c0() ? 1 : 0);
            if (n10 != 0) {
                object = BleConnection.W();
                ((BleConnection)object).M();
            } else {
                object = BleDevice$State.UNCONNECTED;
                this.M((BleDevice$State)((Object)object));
            }
        }
    }

    public void onAttach(Context object) {
        super.onAttach((Context)object);
        object = (BleDeviceViewModel)d.v.i0.b.a(this).get(BleDeviceViewModel.class);
        this.c = object;
    }

    public void onPause() {
        super.onPause();
        this.c.H();
    }

    public void onResume() {
        super.onResume();
        this.I();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.D();
        this.o();
    }

    public /* synthetic */ void q(BleDeviceViewModel$ScanFailType bleDeviceViewModel$ScanFailType) {
        this.p(bleDeviceViewModel$ScanFailType);
    }

    public /* synthetic */ void s(BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus) {
        this.r(bleDeviceViewModel$ShowStatus);
    }

    public /* synthetic */ void u(BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus) {
        this.t(bleDeviceViewModel$ConnectStatus);
    }

    public /* synthetic */ void w(BleDevice bleDevice) {
        this.v(bleDevice);
    }

    public /* synthetic */ void y(BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus) {
        this.x(bleDeviceViewModel$OperationStatus);
    }
}

