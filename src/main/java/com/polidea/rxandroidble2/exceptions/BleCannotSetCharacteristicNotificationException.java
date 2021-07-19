/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package com.polidea.rxandroidble2.exceptions;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.exceptions.BleException;

public class BleCannotSetCharacteristicNotificationException
extends BleException {
    public static final int CANNOT_FIND_CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR = 2;
    public static final int CANNOT_SET_LOCAL_NOTIFICATION = 1;
    public static final int CANNOT_WRITE_CLIENT_CHARACTERISTIC_CONFIG_DESCRIPTOR = 3;
    public static final int UNKNOWN = 255;
    private final BluetoothGattCharacteristic bluetoothGattCharacteristic;
    private final int reason;

    public BleCannotSetCharacteristicNotificationException(BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        int n10 = -1;
        String string2 = BleCannotSetCharacteristicNotificationException.a(bluetoothGattCharacteristic, n10);
        super(string2);
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic;
        this.reason = n10;
    }

    public BleCannotSetCharacteristicNotificationException(BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10, Throwable throwable) {
        String string2 = BleCannotSetCharacteristicNotificationException.a(bluetoothGattCharacteristic, n10);
        super(string2, throwable);
        this.bluetoothGattCharacteristic = bluetoothGattCharacteristic;
        this.reason = n10;
    }

    private static String a(BluetoothGattCharacteristic object, int n10) {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = BleCannotSetCharacteristicNotificationException.b(n10);
        stringBuilder.append(string2);
        stringBuilder.append(" (code ");
        stringBuilder.append(n10);
        stringBuilder.append(") with characteristic UUID ");
        object = object.getUuid();
        stringBuilder.append(object);
        return stringBuilder.toString();
    }

    private static String b(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return "Unknown error";
                }
                return "Cannot write client characteristic config descriptor";
            }
            return "Cannot find client characteristic config descriptor";
        }
        return "Cannot set local notification";
    }

    public BluetoothGattCharacteristic getBluetoothGattCharacteristic() {
        return this.bluetoothGattCharacteristic;
    }

    public int getReason() {
        return this.reason;
    }
}

