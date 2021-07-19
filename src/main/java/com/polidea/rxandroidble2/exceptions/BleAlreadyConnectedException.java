/*
 * Decompiled with CFR 0.151.
 */
package com.polidea.rxandroidble2.exceptions;

import com.polidea.rxandroidble2.exceptions.BleException;

public class BleAlreadyConnectedException
extends BleException {
    public BleAlreadyConnectedException(String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Already connected to device with MAC address ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        super(string2);
    }
}

