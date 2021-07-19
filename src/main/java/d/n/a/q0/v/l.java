/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.v;

import android.bluetooth.BluetoothDevice;

public class l {
    private final BluetoothDevice a;
    private final int b;
    private final byte[] c;

    public l(BluetoothDevice bluetoothDevice, int n10, byte[] byArray) {
        this.a = bluetoothDevice;
        this.b = n10;
        this.c = byArray;
    }

    public BluetoothDevice a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public byte[] c() {
        return this.c;
    }
}

