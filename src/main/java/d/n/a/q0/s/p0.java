/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothGatt
 *  android.bluetooth.BluetoothGattCallback
 *  android.bluetooth.BluetoothGattCharacteristic
 *  android.bluetooth.BluetoothGattDescriptor
 */
package d.n.a.q0.s;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import d.n.a.b0;

public class p0 {
    private BluetoothGattCallback a;
    private b0 b;

    public void a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicChanged(bluetoothGatt, bluetoothGattCharacteristic);
        }
    }

    public void b(BluetoothGatt bluetoothGatt, int n10, int n11) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onConnectionStateChange(bluetoothGatt, n10, n11);
        }
    }

    public void c(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorRead(bluetoothGatt, bluetoothGattDescriptor, n10);
        }
    }

    public void d(BluetoothGatt bluetoothGatt, BluetoothGattDescriptor bluetoothGattDescriptor, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onDescriptorWrite(bluetoothGatt, bluetoothGattDescriptor, n10);
        }
    }

    public void e(BluetoothGatt bluetoothGatt, int n10, int n11) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onMtuChanged(bluetoothGatt, n10, n11);
        }
    }

    public void f(BluetoothGatt bluetoothGatt, int n10, int n11, int n12, int n13) {
        b0 b02 = this.b;
        if (b02 != null) {
            b02.a(bluetoothGatt, n10, n11, n12, n13);
        }
    }

    public void g(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicRead(bluetoothGatt, bluetoothGattCharacteristic, n10);
        }
    }

    public void h(BluetoothGatt bluetoothGatt, int n10, int n11) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReadRemoteRssi(bluetoothGatt, n10, n11);
        }
    }

    public void i(BluetoothGatt bluetoothGatt, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onReliableWriteCompleted(bluetoothGatt, n10);
        }
    }

    public void j(BluetoothGatt bluetoothGatt, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onServicesDiscovered(bluetoothGatt, n10);
        }
    }

    public void k(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int n10) {
        BluetoothGattCallback bluetoothGattCallback = this.a;
        if (bluetoothGattCallback != null) {
            bluetoothGattCallback.onCharacteristicWrite(bluetoothGatt, bluetoothGattCharacteristic, n10);
        }
    }

    public void l(BluetoothGattCallback bluetoothGattCallback) {
        this.a = bluetoothGattCallback;
    }

    public void m(b0 b02) {
        this.b = b02;
    }
}

