/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 */
package d.n.a.q0.u;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.polidea.rxandroidble2.exceptions.BleScanException;
import d.n.a.q0.p;
import d.n.a.q0.t.b;
import d.n.a.q0.u.x;
import d.n.a.q0.v.e;
import d.n.a.q0.v.g;
import d.n.a.q0.v.k;
import e.a.b0;
import java.util.List;

public class x$a
extends ScanCallback {
    public final /* synthetic */ b0 a;
    public final /* synthetic */ x b;

    public x$a(x x10, b0 b02) {
        this.b = x10;
        this.a = b02;
    }

    public void onBatchScanResults(List object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object object2 = (ScanResult)object.next();
            Object object3 = this.b.e;
            boolean bl3 = ((e)object3).b((k)(object2 = this.b.b.c((ScanResult)object2)));
            if (!bl3) continue;
            object3 = this.a;
            object3.onNext(object2);
        }
    }

    public void onScanFailed(int n10) {
        b0 b02 = this.a;
        n10 = x.h(n10);
        BleScanException bleScanException = new BleScanException(n10);
        b02.tryOnError(bleScanException);
    }

    public void onScanResult(int n10, ScanResult object) {
        k k10;
        boolean bl2;
        int n11;
        boolean bl3;
        Object object2 = this.b.e;
        boolean n112 = ((e)object2).a();
        if (!n112 && (bl3 = p.m(n11 = 3)) && (bl3 = p.i())) {
            Object object3;
            Object object4 = object.getScanRecord();
            int n12 = 4;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object3 = d.n.a.q0.t.b.d(object.getDevice().getAddress());
            objectArray[1] = object3 = object.getDevice().getName();
            int n13 = 2;
            int n14 = object.getRssi();
            objectArray[n13] = object3 = Integer.valueOf(n14);
            if (object4 != null) {
                object4 = object4.getBytes();
            } else {
                bl3 = false;
                object4 = null;
            }
            object4 = d.n.a.q0.t.b.a((byte[])object4);
            objectArray[n11] = object4;
            object2 = "%s, name=%s, rssi=%d, data=%s";
            p.b((String)object2, objectArray);
        }
        if (bl2 = ((e)(object = this.b.e)).b(k10 = ((g)(object2 = this.b.b)).a(n10, (ScanResult)object))) {
            object = this.a;
            object.onNext(k10);
        }
    }
}

