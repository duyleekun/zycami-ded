/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.device.connection.BleConnection$g;
import d.v.p.a$c;
import e.a.b0;
import m.a.a;

public class BleConnection$g$a
implements a$c {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ BleConnection$g b;

    public BleConnection$g$a(BleConnection$g bleConnection$g, b0 b02) {
        this.b = bleConnection$g;
        this.a = b02;
    }

    public void a() {
        Object object = new Object[]{};
        m.a.a.b("---getLocationState fail---", (Object[])object);
        BleConnection.C(this.b.a).f(this);
        BleConnection.q(this.b.a);
        object = this.a;
        Boolean bl2 = Boolean.FALSE;
        object.onNext(bl2);
    }

    public void b(double d10, double d11) {
        Object object = new Object[]{};
        m.a.a.b("---getLocationState success---", object);
        object = this.b.a;
        Object object2 = String.valueOf(d11);
        BleConnection.p((BleConnection)object, (String)object2);
        object2 = this.b.a;
        Object object3 = String.valueOf(d10);
        BleConnection.m((BleConnection)object2, (String)object3);
        BleConnection.C(this.b.a).f(this);
        object3 = this.a;
        Boolean bl2 = Boolean.TRUE;
        object3.onNext(bl2);
    }
}

