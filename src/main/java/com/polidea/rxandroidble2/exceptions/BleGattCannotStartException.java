/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.n.a.o0.a;

public class BleGattCannotStartException
extends BleGattException {
    public BleGattCannotStartException(BluetoothGatt bluetoothGatt, a a10) {
        super(bluetoothGatt, a10);
    }

    public BleGattCannotStartException(a a10) {
        super(null, a10);
    }
}

