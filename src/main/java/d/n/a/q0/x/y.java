/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanSettings
 */
package d.n.a.q0.x;

import android.app.PendingIntent;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanSettings;
import d.n.a.q0.p;
import java.util.List;
import java.util.Set;

public class y {
    private final BluetoothAdapter a;

    public y(BluetoothAdapter bluetoothAdapter) {
        this.a = bluetoothAdapter;
    }

    public Set a() {
        return this.a.getBondedDevices();
    }

    public BluetoothDevice b(String string2) {
        return this.a.getRemoteDevice(string2);
    }

    public boolean c() {
        boolean bl2;
        BluetoothAdapter bluetoothAdapter = this.a;
        if (bluetoothAdapter != null) {
            bl2 = true;
        } else {
            bl2 = false;
            bluetoothAdapter = null;
        }
        return bl2;
    }

    public boolean d() {
        boolean bl2;
        BluetoothAdapter bluetoothAdapter = this.a;
        if (bluetoothAdapter != null && (bl2 = bluetoothAdapter.isEnabled())) {
            bl2 = true;
        } else {
            bl2 = false;
            bluetoothAdapter = null;
        }
        return bl2;
    }

    public int e(List list, ScanSettings scanSettings, PendingIntent pendingIntent) {
        return this.a.getBluetoothLeScanner().startScan(list, scanSettings, pendingIntent);
    }

    public void f(List list, ScanSettings scanSettings, ScanCallback scanCallback) {
        this.a.getBluetoothLeScanner().startScan(list, scanSettings, scanCallback);
    }

    public boolean g(BluetoothAdapter.LeScanCallback leScanCallback) {
        return this.a.startLeScan(leScanCallback);
    }

    public void h(PendingIntent pendingIntent) {
        this.a.getBluetoothLeScanner().stopScan(pendingIntent);
    }

    public void i(ScanCallback objectArray) {
        Object object = this.a;
        boolean bl2 = object.isEnabled();
        if (!bl2) {
            objectArray = new Object[]{};
            p.s("BluetoothAdapter is disabled, calling BluetoothLeScanner.stopScan(ScanCallback) may cause IllegalStateException", objectArray);
            return;
        }
        object = this.a.getBluetoothLeScanner();
        if (object == null) {
            objectArray = new Object[1];
            object = this.a.isEnabled();
            objectArray[0] = object;
            p.u("Cannot call BluetoothLeScanner.stopScan(ScanCallback) on 'null' reference; BluetoothAdapter.isEnabled() == %b", objectArray);
            return;
        }
        object.stopScan((ScanCallback)objectArray);
    }

    public void j(BluetoothAdapter.LeScanCallback leScanCallback) {
        this.a.stopLeScan(leScanCallback);
    }
}

