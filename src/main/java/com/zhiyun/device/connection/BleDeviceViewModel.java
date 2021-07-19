/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$ShowStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$a;
import com.zhiyun.device.connection.BleDeviceViewModel$b;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e.i.h;
import d.v.g.e.q;
import d.v.g.e.q$b;
import java.util.ArrayList;
import java.util.List;

public class BleDeviceViewModel
extends ViewModel {
    private static final int o = 10000;
    private MutableLiveData a;
    private MutableLiveData b;
    private MutableLiveData c;
    private MutableLiveData d;
    private MutableLiveData e;
    private MutableLiveData f;
    private MutableLiveData g;
    private MutableLiveData h;
    private List i;
    private q j;
    private BleConnection k;
    private boolean l;
    private q$b m;
    private BleConnection$j n;

    public BleDeviceViewModel() {
        Object object = new MutableLiveData();
        this.a = object;
        object = new MutableLiveData();
        this.b = object;
        object = new MutableLiveData();
        this.c = object;
        object = new MutableLiveData();
        this.d = object;
        object = new MutableLiveData();
        this.e = object;
        object = new MutableLiveData();
        this.f = object;
        object = new MutableLiveData();
        this.g = object;
        object = new MutableLiveData();
        this.h = object;
        object = new ArrayList();
        this.i = object;
        this.m = object = new BleDeviceViewModel$a(this);
        this.n = object = new BleDeviceViewModel$b(this);
        this.j = object = q.b();
        this.k = object = BleConnection.W();
        BleConnection$j bleConnection$j = this.n;
        ((BleConnection)object).J(bleConnection$j);
    }

    public static /* synthetic */ boolean b(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.l;
    }

    public static /* synthetic */ boolean c(BleDeviceViewModel bleDeviceViewModel, boolean bl2) {
        bleDeviceViewModel.l = bl2;
        return bl2;
    }

    public static /* synthetic */ MutableLiveData d(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.f;
    }

    public static /* synthetic */ MutableLiveData e(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.h;
    }

    public static /* synthetic */ List f(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.i;
    }

    public static /* synthetic */ MutableLiveData g(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.a;
    }

    public static /* synthetic */ q$b i(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.m;
    }

    public static /* synthetic */ q j(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.j;
    }

    public static /* synthetic */ MutableLiveData k(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.g;
    }

    public static /* synthetic */ MutableLiveData l(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.d;
    }

    public static /* synthetic */ MutableLiveData m(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.e;
    }

    public static /* synthetic */ MutableLiveData n(BleDeviceViewModel bleDeviceViewModel) {
        return bleDeviceViewModel.c;
    }

    public MutableLiveData A() {
        return this.a;
    }

    public MutableLiveData F() {
        return this.f;
    }

    public void G() {
        this.H();
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).c0();
        if (!bl2 && (bl2 = (object = this.i).isEmpty())) {
            object = this.f;
            BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus = BleDeviceViewModel$ShowStatus.SHOW_STATE_SCANNING;
            d.v.e.i.h.g((MutableLiveData)object, (Object)bleDeviceViewModel$ShowStatus);
        } else {
            object = this.f;
            BleDeviceViewModel$ShowStatus bleDeviceViewModel$ShowStatus = BleDeviceViewModel$ShowStatus.SHOW_STATE_DEVICE_LIST;
            d.v.e.i.h.g((MutableLiveData)object, (Object)bleDeviceViewModel$ShowStatus);
        }
        this.i.clear();
        object = this.j;
        q$b q$b = this.m;
        ((q)object).c(10000L, q$b);
    }

    public void H() {
        this.l = true;
        this.j.d();
    }

    public void o() {
        MutableLiveData mutableLiveData = this.c;
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_NONE;
        mutableLiveData.setValue((Object)bleDeviceViewModel$ConnectStatus);
    }

    public void onCleared() {
        super.onCleared();
        BleConnection bleConnection = this.k;
        if (bleConnection != null) {
            BleConnection$j bleConnection$j = this.n;
            bleConnection.N0(bleConnection$j);
        }
        this.j.d();
    }

    public void p() {
        MutableLiveData mutableLiveData = this.h;
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_NONE;
        mutableLiveData.setValue((Object)bleDeviceViewModel$OperationStatus);
    }

    public void r(Stabilizer object, String object2, String string2) {
        this.d.setValue(object);
        this.k.P((Stabilizer)object, (String)object2, string2);
        object = this.c;
        object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_ING;
        ((MutableLiveData)object).setValue(object2);
    }

    public MutableLiveData s() {
        return this.c;
    }

    public MutableLiveData t() {
        return this.e;
    }

    public Stabilizer u() {
        Object object = this.e;
        object = object == null ? null : (Stabilizer)((LiveData)object).getValue();
        return object;
    }

    public Stabilizer v() {
        Object object = this.d;
        object = object == null ? null : (Stabilizer)((LiveData)object).getValue();
        return object;
    }

    public MutableLiveData w() {
        return this.h;
    }

    public MutableLiveData x() {
        return this.g;
    }

    public MutableLiveData y() {
        return this.b;
    }

    public String z() {
        Object object = this.b;
        object = object != null && (object = ((LiveData)object).getValue()) != null ? (String)this.b.getValue() : "";
        return object;
    }
}

