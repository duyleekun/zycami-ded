/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanFilter
 *  android.bluetooth.le.ScanFilter$Builder
 *  android.bluetooth.le.ScanSettings
 *  android.bluetooth.le.ScanSettings$Builder
 *  android.os.ParcelUuid
 */
package d.n.a.q0.v;

import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanSettings;
import android.os.ParcelUuid;
import d.n.a.r0.b;
import d.n.a.r0.e;
import java.util.ArrayList;
import java.util.List;

public class a {
    private final int a;

    public a(int n10) {
        this.a = n10;
    }

    private static void a(e e10, ScanSettings.Builder builder) {
        int n10 = e10.d();
        builder = builder.setCallbackType(n10);
        n10 = e10.e();
        builder = builder.setMatchMode(n10);
        int n11 = e10.f();
        builder.setNumOfMatches(n11);
    }

    private static ScanFilter b(b b10) {
        byte[] byArray;
        byte[] byArray2;
        ScanFilter.Builder builder = new ScanFilter.Builder();
        Object object = b10.m();
        if (object != null) {
            object = b10.m();
            byArray2 = b10.k();
            byArray = b10.l();
            builder.setServiceData(object, byArray2, byArray);
        }
        object = b10.f();
        builder = builder.setDeviceAddress((String)object);
        object = b10.g();
        builder = builder.setDeviceName((String)object);
        int n10 = b10.j();
        byArray2 = b10.h();
        byArray = b10.i();
        builder = builder.setManufacturerData(n10, byArray2, byArray);
        object = b10.n();
        b10 = b10.o();
        return builder.setServiceUuid(object, (ParcelUuid)b10).build();
    }

    public List c(b ... bArray) {
        ArrayList<ScanFilter> arrayList;
        int n10;
        int n11 = 0;
        if (bArray != null && (n10 = bArray.length) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            arrayList = null;
        }
        if (n10 != 0) {
            int n12 = bArray.length;
            arrayList = new ArrayList<ScanFilter>(n12);
            n12 = bArray.length;
            while (n11 < n12) {
                ScanFilter scanFilter = d.n.a.q0.v.a.b(bArray[n11]);
                arrayList.add(scanFilter);
                ++n11;
            }
        } else {
            n10 = 0;
            arrayList = null;
        }
        return arrayList;
    }

    public ScanSettings d(e e10) {
        ScanSettings.Builder builder = new ScanSettings.Builder();
        int n10 = this.a;
        int n11 = 23;
        if (n10 >= n11) {
            d.n.a.q0.v.a.a(e10, builder);
        }
        long l10 = e10.g();
        builder = builder.setReportDelay(l10);
        int n12 = e10.h();
        return builder.setScanMode(n12).build();
    }
}

