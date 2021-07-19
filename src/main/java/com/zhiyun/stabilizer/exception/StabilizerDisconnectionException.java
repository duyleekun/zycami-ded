/*
 * Decompiled with CFR 0.151.
 */
package com.zhiyun.stabilizer.exception;

import com.polidea.rxandroidble2.exceptions.BleDisconnectedException;

public class StabilizerDisconnectionException
extends BleDisconnectedException {
    public StabilizerDisconnectionException() {
        this("Stabilizer disconnected !!!");
    }

    public StabilizerDisconnectionException(String string2) {
        super(string2);
    }
}

