/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import d.v.e0.ie.l;
import e.a.k0;

public class BleConnection$d
implements l {
    public final /* synthetic */ k0 a;
    public final /* synthetic */ BleConnection b;

    public BleConnection$d(BleConnection bleConnection, k0 k02) {
        this.b = bleConnection;
        this.a = k02;
    }

    public void onFailed(Throwable throwable) {
        this.a.tryOnError(throwable);
    }

    public void s(Boolean bl2) {
        this.a.onSuccess(bl2);
    }
}

