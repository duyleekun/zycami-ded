/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import java.util.concurrent.atomic.AtomicReference;

public class a {
    private final AtomicReference a;

    public a() {
        AtomicReference atomicReference;
        this.a = atomicReference = new AtomicReference();
    }

    public BluetoothGatt a() {
        return (BluetoothGatt)this.a.get();
    }

    public void b(BluetoothGatt bluetoothGatt) {
        this.a.compareAndSet(null, bluetoothGatt);
    }
}

