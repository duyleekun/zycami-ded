/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 */
package com.mob.tools.utils;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.mob.tools.utils.BHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BHelper$6
extends ScanCallback {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ ArrayList val$scanResult;

    public BHelper$6(BHelper bHelper, ArrayList arrayList) {
        this.this$0 = bHelper;
        this.val$scanResult = arrayList;
    }

    public void onBatchScanResults(List list) {
        super.onBatchScanResults(list);
    }

    public void onScanFailed(int n10) {
        super.onScanFailed(n10);
    }

    public void onScanResult(int n10, ScanResult object) {
        super.onScanResult(n10, (ScanResult)object);
        if (object != null) {
            HashMap hashMap = new HashMap();
            Object object2 = object.getDevice();
            if (object2 != null) {
                hashMap = BHelper.access$100(this.this$0, object2);
            }
            int n11 = object.getRssi();
            object2 = n11;
            String string2 = "rssi";
            hashMap.put(string2, object2);
            object.getScanRecord();
            object = this.val$scanResult;
            ((ArrayList)object).add(hashMap);
        }
    }
}

