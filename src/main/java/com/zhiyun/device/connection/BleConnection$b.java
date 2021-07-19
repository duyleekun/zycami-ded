/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.device.connection;

import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.ie.b;

public class BleConnection$b
implements b {
    public final /* synthetic */ BleConnection a;

    public BleConnection$b(BleConnection bleConnection) {
        this.a = bleConnection;
    }

    public void b(Stabilizer stabilizer) {
        BleConnection.d(this.a, stabilizer);
        BleConnection.e(this.a, false);
        BleConnection bleConnection = this.a;
        boolean bl2 = true;
        BleConnection.D(bleConnection, bl2);
        BleConnection.E(this.a, false);
        BleConnection.f(this.a, bl2);
        BleConnection.F(this.a, stabilizer);
        BleConnection.g(this.a, stabilizer);
        this.a.M();
    }

    public void c(Throwable throwable, Stabilizer stabilizer) {
        BleConnection.D(this.a, false);
        BleConnection.E(this.a, false);
        BleConnection.F(this.a, null);
        BleConnection.G(this.a, throwable, stabilizer);
    }

    public void d(Stabilizer stabilizer) {
        BleConnection.D(this.a, false);
        BleConnection.E(this.a, false);
        BleConnection.F(this.a, null);
        BleConnection.b(this.a);
        BleConnection.c(this.a, stabilizer);
    }

    public void e(Stabilizer stabilizer) {
        BleConnection.D(this.a, true);
        BleConnection.F(this.a, stabilizer);
        BleConnection.H(this.a, stabilizer);
    }
}

