/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.bluetooth.le.ScanRecord
 *  android.bluetooth.le.ScanResult
 */
package d.n.a.q0.v;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanRecord;
import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.scan.ScanCallbackType;
import d.n.a.q0.p;
import d.n.a.q0.v.k;
import d.n.a.q0.v.t;
import d.n.a.q0.x.a0;
import d.n.a.r0.c;

public class g {
    private final a0 a;

    public g(a0 a02) {
        this.a = a02;
    }

    private static ScanCallbackType d(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 4;
                if (n10 != n12) {
                    Object[] objectArray = new Object[n11];
                    Integer n13 = n10;
                    objectArray[0] = n13;
                    p.u("Unknown callback type %d -> check android.bluetooth.le.ScanSettings", objectArray);
                    return ScanCallbackType.CALLBACK_TYPE_UNKNOWN;
                }
                return ScanCallbackType.CALLBACK_TYPE_MATCH_LOST;
            }
            return ScanCallbackType.CALLBACK_TYPE_FIRST_MATCH;
        }
        return ScanCallbackType.CALLBACK_TYPE_ALL_MATCHES;
    }

    public k a(int n10, ScanResult scanResult) {
        k k10;
        Object object = scanResult.getScanRecord();
        t t10 = new t((ScanRecord)object);
        BluetoothDevice bluetoothDevice = scanResult.getDevice();
        int n11 = scanResult.getRssi();
        long l10 = scanResult.getTimestampNanos();
        ScanCallbackType scanCallbackType = g.d(n10);
        object = k10;
        k10 = new k(bluetoothDevice, n11, l10, t10, scanCallbackType);
        return k10;
    }

    public k b(BluetoothDevice bluetoothDevice, int n10, byte[] object) {
        c c10 = this.a.c((byte[])object);
        object = new k;
        long l10 = System.nanoTime();
        ScanCallbackType scanCallbackType = ScanCallbackType.CALLBACK_TYPE_UNSPECIFIED;
        object(bluetoothDevice, n10, l10, c10, scanCallbackType);
        return object;
    }

    public k c(ScanResult scanResult) {
        k k10;
        Object object = scanResult.getScanRecord();
        t t10 = new t((ScanRecord)object);
        BluetoothDevice bluetoothDevice = scanResult.getDevice();
        int n10 = scanResult.getRssi();
        long l10 = scanResult.getTimestampNanos();
        ScanCallbackType scanCallbackType = ScanCallbackType.CALLBACK_TYPE_BATCH;
        object = k10;
        k10 = new k(bluetoothDevice, n10, l10, t10, scanCallbackType);
        return k10;
    }
}

