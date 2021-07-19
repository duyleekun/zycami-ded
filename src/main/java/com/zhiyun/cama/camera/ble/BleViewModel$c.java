/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.cama.camera.ble;

import androidx.lifecycle.MutableLiveData;
import com.zhiyun.cama.camera.ble.BleViewModel;
import com.zhiyun.cama.camera.ble.BleViewModel$MoveState;
import d.v.e0.ie.e;

public class BleViewModel$c
implements e {
    public final /* synthetic */ BleViewModel a;

    public BleViewModel$c(BleViewModel bleViewModel) {
        this.a = bleViewModel;
    }

    public void e() {
        MutableLiveData mutableLiveData = this.a.A;
        BleViewModel$MoveState bleViewModel$MoveState = BleViewModel$MoveState.STOPOVER;
        mutableLiveData.postValue((Object)bleViewModel$MoveState);
    }

    public void k() {
        MutableLiveData mutableLiveData = this.a.A;
        BleViewModel$MoveState bleViewModel$MoveState = BleViewModel$MoveState.STARTED;
        mutableLiveData.postValue((Object)bleViewModel$MoveState);
    }

    public void l() {
        MutableLiveData mutableLiveData = this.a.A;
        BleViewModel$MoveState bleViewModel$MoveState = BleViewModel$MoveState.CANCELLED;
        mutableLiveData.postValue((Object)bleViewModel$MoveState);
    }

    public void o() {
        MutableLiveData mutableLiveData = this.a.A;
        BleViewModel$MoveState bleViewModel$MoveState = BleViewModel$MoveState.COMPLETED;
        mutableLiveData.postValue((Object)bleViewModel$MoveState);
    }

    public void onFailed(Throwable object) {
        object = this.a.A;
        BleViewModel$MoveState bleViewModel$MoveState = BleViewModel$MoveState.ERROR;
        ((MutableLiveData)object).postValue((Object)bleViewModel$MoveState);
    }
}

