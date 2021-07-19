/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.ScanCallback
 *  android.bluetooth.le.ScanResult
 */
package com.baidu.location.indoor;

import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import com.baidu.location.indoor.d;
import java.util.HashMap;

public class f
extends ScanCallback {
    public final /* synthetic */ d a;

    public f(d d10) {
        this.a = d10;
    }

    public void onScanResult(int n10, ScanResult scanResult) {
        HashMap hashMap = d.a(this.a);
        if (hashMap != null) {
            hashMap = d.a(this.a);
            String string2 = scanResult.getDevice().getAddress();
            hashMap.put(string2, scanResult);
        }
    }
}

