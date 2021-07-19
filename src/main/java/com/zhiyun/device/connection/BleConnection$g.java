/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$g$a;
import d.v.p.a;
import d.v.p.a$c;
import e.a.b0;
import e.a.c0;

public class BleConnection$g
implements c0 {
    public final /* synthetic */ BleConnection a;

    public BleConnection$g(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public void subscribe(b0 b02) {
        Object object = new Object[]{};
        Object object2 = "----getLocationState----";
        m.a.a.b((String)object2, (Object[])object);
        object = BleConnection.l(this.a);
        if (object != null && (object = BleConnection.o(this.a)) != null) {
            object = Boolean.TRUE;
            b02.onNext(object);
        } else {
            object = BleConnection.C(this.a);
            object2 = new BleConnection$g$a(this, b02);
            ((a)object).e((a$c)object2);
        }
    }
}

