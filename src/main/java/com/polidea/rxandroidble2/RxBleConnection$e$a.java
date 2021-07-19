/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2;

import com.polidea.rxandroidble2.exceptions.BleGattException;

public class RxBleConnection$e$a {
    public final int a;
    public final BleGattException b;

    public RxBleConnection$e$a(int n10, BleGattException bleGattException) {
        this.a = n10;
        this.b = bleGattException;
    }

    public int a() {
        return this.a;
    }

    public BleGattException b() {
        return this.b;
    }
}

