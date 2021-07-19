/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattDescriptor
 */
package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.exceptions.BleGattException;
import d.n.a.o0.a;

public class BleGattDescriptorException
extends BleGattException {
    public final BluetoothGattDescriptor descriptor;

    public BleGattDescriptorException(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int n10, a a10) {
        super(bluetoothGatt, n10, a10);
        this.descriptor = bluetoothGattDescriptor;
    }
}

