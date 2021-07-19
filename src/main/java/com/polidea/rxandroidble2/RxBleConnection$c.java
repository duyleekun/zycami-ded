/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 */
package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattCharacteristic;
import com.polidea.rxandroidble2.RxBleConnection$d;
import com.polidea.rxandroidble2.RxBleConnection$e;
import e.a.z;
import java.util.UUID;

public interface RxBleConnection$c {
    public RxBleConnection$c a(int var1);

    public RxBleConnection$c b(UUID var1);

    public z build();

    public RxBleConnection$c c(RxBleConnection$d var1);

    public RxBleConnection$c d(RxBleConnection.e var1);

    public RxBleConnection$c e(BluetoothGattCharacteristic var1);

    public RxBleConnection$c f(byte[] var1);
}

