/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.BluetoothGatt
 */
package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import com.polidea.rxandroidble2.exceptions.BleException;
import d.n.a.o0.a;
import d.n.a.s0.b;

public class BleGattException
extends BleException {
    public static final int UNKNOWN_STATUS = 255;
    private final a bleGattOperationType;
    private final BluetoothGatt gatt;
    private final int status;

    public BleGattException(int n10, a a10) {
        String string2 = BleGattException.a(null, n10, a10);
        super(string2);
        this.gatt = null;
        this.status = n10;
        this.bleGattOperationType = a10;
    }

    public BleGattException(BluetoothGatt bluetoothGatt, int n10, a a10) {
        String string2 = BleGattException.a(bluetoothGatt, n10, a10);
        super(string2);
        this.gatt = bluetoothGatt;
        this.status = n10;
        this.bleGattOperationType = a10;
    }

    public BleGattException(BluetoothGatt bluetoothGatt, a a10) {
        this(bluetoothGatt, -1, a10);
    }

    private static String a(BluetoothGatt object, int n10, a a10) {
        int n11 = 2;
        int n12 = 1;
        int n13 = -1;
        if (n10 == n13) {
            Object[] objectArray = new Object[n11];
            object = BleGattException.b(object);
            objectArray[0] = object;
            objectArray[n12] = a10;
            return String.format("GATT exception from MAC address %s, with type %s", objectArray);
        }
        String string2 = b.a(n10);
        Object[] objectArray = new Object[6];
        object = d.n.a.q0.t.b.c(object);
        objectArray[0] = object;
        object = n10;
        objectArray[n12] = object;
        objectArray[n11] = string2;
        objectArray[3] = a10;
        Integer n14 = n10;
        objectArray[4] = n14;
        objectArray[5] = "https://android.googlesource.com/platform/external/bluetooth/bluedroid/+/android-5.1.0_r1/stack/include/gatt_api.h";
        return String.format("GATT exception from %s, status %d (%s), type %s. (Look up status 0x%02x here %s)", objectArray);
    }

    private static String b(BluetoothGatt object) {
        BluetoothDevice bluetoothDevice;
        object = object != null && (bluetoothDevice = object.getDevice()) != null ? object.getDevice().getAddress() : null;
        return object;
    }

    public a getBleGattOperationType() {
        return this.bleGattOperationType;
    }

    public String getMacAddress() {
        return BleGattException.b(this.gatt);
    }

    public int getStatus() {
        return this.status;
    }
}

