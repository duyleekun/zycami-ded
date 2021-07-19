/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.utils.BHelper$BScanCallback;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.DeviceHelper$BtScanCallback;
import java.util.ArrayList;

public class DeviceHelper$6
implements BHelper$BScanCallback {
    public final /* synthetic */ DeviceHelper this$0;
    public final /* synthetic */ DeviceHelper$BtScanCallback val$bScanCallback;

    public DeviceHelper$6(DeviceHelper deviceHelper, DeviceHelper$BtScanCallback deviceHelper$BtScanCallback) {
        this.this$0 = deviceHelper;
        this.val$bScanCallback = deviceHelper$BtScanCallback;
    }

    public void onScan(ArrayList arrayList) {
        DeviceHelper$BtScanCallback deviceHelper$BtScanCallback = this.val$bScanCallback;
        if (deviceHelper$BtScanCallback != null) {
            deviceHelper$BtScanCallback.onScan(arrayList);
        }
    }
}

