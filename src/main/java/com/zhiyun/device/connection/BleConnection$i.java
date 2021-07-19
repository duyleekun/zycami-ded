/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.data.local.entity.ActivationData;
import com.zhiyun.net.BaseEntity;
import d.v.g.d.a;

public class BleConnection$i
extends a {
    public final /* synthetic */ ActivationData c;
    public final /* synthetic */ BleConnection d;

    public BleConnection$i(BleConnection bleConnection, ActivationData activationData) {
        this.d = bleConnection;
        this.c = activationData;
    }

    public void a(BaseEntity object) {
        object = BleConnection.r(this.d);
        ActivationData activationData = this.c;
        object.c(activationData);
        BleConnection.s(this.d);
    }

    public void onError(Throwable throwable, int n10, String string2) {
    }
}

