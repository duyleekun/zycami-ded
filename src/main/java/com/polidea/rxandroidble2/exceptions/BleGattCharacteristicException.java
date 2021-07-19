/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.n.a.o0.a;

public class BleGattCharacteristicException
extends BleGattException {
    public final BluetoothGattCharacteristic characteristic;

    public BleGattCharacteristicException(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10, a a10) {
        super(bluetoothGatt, n10, a10);
        this.characteristic = bluetoothGattCharacteristic;
    }
}

