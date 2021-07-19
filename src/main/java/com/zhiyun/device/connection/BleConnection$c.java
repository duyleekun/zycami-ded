/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import d.v.e0.ie.l;
import e.a.b0;

public class BleConnection$c
implements l {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ BleConnection b;

    public BleConnection$c(BleConnection bleConnection, b0 b02) {
        this.b = bleConnection;
        this.a = b02;
    }

    public void onFailed(Throwable object) {
        object = this.a;
        Boolean bl2 = Boolean.TRUE;
        object.onNext(bl2);
    }

    public void s(Boolean object) {
        boolean bl2 = (Boolean)object;
        if (bl2) {
            BleConnection.z(this.b);
            object = this.a;
            Boolean bl3 = Boolean.FALSE;
            object.onNext(bl3);
        } else {
            BleConnection.B(this.b, false);
            object = this.a;
            Boolean bl4 = Boolean.TRUE;
            object.onNext(bl4);
        }
    }
}

