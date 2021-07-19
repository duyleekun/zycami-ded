/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 */
package d.n.a.q0.v;

import android.bluetooth.BluetoothDevice;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import d.n.a.r0.c;

public class k {
    private final BluetoothDevice a;
    private final int b;
    private final long c;
    private final c d;
    private final ScanCallbackType e;

    public k(BluetoothDevice bluetoothDevice, int n10, long l10, c c10, ScanCallbackType scanCallbackType) {
        this.a = bluetoothDevice;
        this.b = n10;
        this.c = l10;
        this.d = c10;
        this.e = scanCallbackType;
    }

    public BluetoothDevice a() {
        return this.a;
    }

    public int b() {
        return this.b;
    }

    public ScanCallbackType c() {
        return this.e;
    }

    public c d() {
        return this.d;
    }

    public long e() {
        return this.c;
    }
}

