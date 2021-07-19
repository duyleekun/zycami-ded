/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import d.v.e0.ie.l;
import d.v.e0.td;
import e.a.b0;

public class BleConnection$f
implements l {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ BleConnection b;

    public BleConnection$f(BleConnection bleConnection, b0 b02) {
        this.b = bleConnection;
        this.a = b02;
    }

    public void onFailed(Throwable object) {
        object = this.a;
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("get device info fail");
        object.onError(illegalArgumentException);
    }

    public void s(td object) {
        Object object2 = this.b;
        object = ((td)object).e;
        BleConnection.v((BleConnection)object2, (String)object);
        object = this.a;
        object2 = Boolean.TRUE;
        object.onNext(object2);
    }
}

