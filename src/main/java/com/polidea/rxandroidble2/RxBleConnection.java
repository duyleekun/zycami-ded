/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package com.polidea.rxandroidble2;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import com.polidea.rxandroidble2.NotificationSetupMode;
import com.polidea.rxandroidble2.RxBleConnection$c;
import d.n.a.i0;
import d.n.a.q0.j;
import e.a.a;
import e.a.z;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public interface RxBleConnection {
    public static final int a = 3;
    public static final int b = 1;
    public static final int c = 23;
    public static final int d = 517;

    public z A(i0 var1);

    public int a();

    public z b(UUID var1, NotificationSetupMode var2);

    public a c(UUID var1, UUID var2, UUID var3, byte[] var4);

    public e.a.i0 d(BluetoothGattCharacteristic var1);

    public z e(UUID var1, NotificationSetupMode var2);

    public z f(UUID var1);

    public z g(BluetoothGattCharacteristic var1, NotificationSetupMode var2);

    public z h(BluetoothGattCharacteristic var1, NotificationSetupMode var2);

    public z i(i0 var1, j var2);

    public e.a.i0 j(int var1);

    public e.a.i0 k(BluetoothGattCharacteristic var1, byte[] var2);

    public z l();

    public z m(BluetoothGattCharacteristic var1);

    public e.a.i0 n(BluetoothGattDescriptor var1);

    public e.a.i0 o(UUID var1, UUID var2, UUID var3);

    public e.a.i0 p();

    public z q(UUID var1);

    public RxBleConnection$c r();

    public e.a.i0 s(UUID var1);

    public a t(int var1, long var2, TimeUnit var4);

    public e.a.i0 u(long var1, TimeUnit var3);

    public e.a.i0 v(UUID var1, byte[] var2);

    public e.a.i0 w();

    public z x(BluetoothGattCharacteristic var1);

    public a y(BluetoothGattDescriptor var1, byte[] var2);

    public e.a.i0 z(UUID var1);
}

