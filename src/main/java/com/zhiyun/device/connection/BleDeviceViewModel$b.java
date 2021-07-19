/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.device.connection.BleConnection$j;
import com.zhiyun.device.connection.BleDeviceViewModel;
import com.zhiyun.device.connection.BleDeviceViewModel$ConnectStatus;
import com.zhiyun.device.connection.BleDeviceViewModel$OperationStatus;
import com.zhiyun.stabilizer.Stabilizer;

public class BleDeviceViewModel$b
implements BleConnection$j {
    public final /* synthetic */ BleDeviceViewModel a;

    public BleDeviceViewModel$b(BleDeviceViewModel bleDeviceViewModel) {
        this.a = bleDeviceViewModel;
    }

    public void a() {
        MutableLiveData mutableLiveData = BleDeviceViewModel.e(this.a);
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_FORCE_UPDATE;
        mutableLiveData.setValue((Object)bleDeviceViewModel$OperationStatus);
    }

    public void b(Stabilizer object) {
        BleDeviceViewModel.l(this.a).setValue(object);
        object = BleDeviceViewModel.n(this.a);
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_INITIATIVE_CONNECTED;
        ((MutableLiveData)object).setValue((Object)bleDeviceViewModel$ConnectStatus);
    }

    public void c(Throwable object, Stabilizer object2) {
        BleDeviceViewModel.l(this.a).setValue(object2);
        BleDeviceViewModel.m(this.a).setValue(null);
        object = BleDeviceViewModel.n(this.a);
        object2 = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_FAIL;
        ((MutableLiveData)object).setValue(object2);
    }

    public void d(Stabilizer object) {
        BleDeviceViewModel.l(this.a).setValue(object);
        BleDeviceViewModel.m(this.a).setValue(null);
        object = BleDeviceViewModel.n(this.a);
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_DISCONNECT;
        ((MutableLiveData)object).setValue((Object)bleDeviceViewModel$ConnectStatus);
        this.a.G();
    }

    public void e(Stabilizer object) {
        BleDeviceViewModel.l(this.a).setValue(object);
        BleDeviceViewModel.m(this.a).setValue(object);
        object = BleDeviceViewModel.n(this.a);
        BleDeviceViewModel$ConnectStatus bleDeviceViewModel$ConnectStatus = BleDeviceViewModel$ConnectStatus.CONNECT_STATUS_CONNECTED;
        ((MutableLiveData)object).setValue((Object)bleDeviceViewModel$ConnectStatus);
    }

    public void f(boolean bl2) {
        MutableLiveData mutableLiveData = BleDeviceViewModel.m(this.a);
        Object object = BleDeviceViewModel.l(this.a).getValue();
        mutableLiveData.setValue(object);
        mutableLiveData = BleDeviceViewModel.e(this.a);
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus = bl2 ? BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NET_ERROR : BleDeviceViewModel$OperationStatus.OPERATION_STATUS_RESTRICTIONS_NO_ERROR;
        mutableLiveData.setValue((Object)bleDeviceViewModel$OperationStatus);
    }

    public void g() {
        MutableLiveData mutableLiveData = BleDeviceViewModel.m(this.a);
        Object object = BleDeviceViewModel.l(this.a).getValue();
        mutableLiveData.setValue(object);
        mutableLiveData = BleDeviceViewModel.e(this.a);
        object = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_NORMAL;
        mutableLiveData.setValue(object);
    }

    public void h() {
        MutableLiveData mutableLiveData = BleDeviceViewModel.e(this.a);
        BleDeviceViewModel$OperationStatus bleDeviceViewModel$OperationStatus = BleDeviceViewModel$OperationStatus.OPERATION_STATUS_ACTIVE;
        mutableLiveData.setValue((Object)bleDeviceViewModel$OperationStatus);
    }
}

