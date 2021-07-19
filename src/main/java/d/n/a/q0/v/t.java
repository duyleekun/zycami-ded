/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanRecord
 *  android.os.ParcelUuid
 *  android.util.SparseArray
 */
package d.n.a.q0.v;

import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.util.SparseArray;
import d.n.a.r0.c;
import java.util.List;
import java.util.Map;

public class t
implements c {
    private final ScanRecord a;

    public t(ScanRecord scanRecord) {
        this.a = scanRecord;
    }

    public int a() {
        return this.a.getAdvertiseFlags();
    }

    public byte[] b(int n10) {
        return this.a.getManufacturerSpecificData(n10);
    }

    public SparseArray c() {
        return this.a.getManufacturerSpecificData();
    }

    public List d() {
        return this.a.getServiceUuids();
    }

    public Map e() {
        return this.a.getServiceData();
    }

    public int f() {
        return this.a.getTxPowerLevel();
    }

    public byte[] g() {
        return this.a.getBytes();
    }

    public String h() {
        return this.a.getDeviceName();
    }

    public byte[] i(ParcelUuid parcelUuid) {
        return this.a.getServiceData(parcelUuid);
    }
}

