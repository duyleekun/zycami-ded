/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.bluetooth.BluetoothDevice
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class BHelper$4
implements BluetoothAdapter.LeScanCallback {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ ArrayList val$scanResult;

    public BHelper$4(BHelper bHelper, ArrayList arrayList) {
        this.this$0 = bHelper;
        this.val$scanResult = arrayList;
    }

    public void onLeScan(BluetoothDevice object, int n10, byte[] object2) {
        object2 = this.this$0;
        object = BHelper.access$100((BHelper)object2, (BluetoothDevice)object);
        object2 = "rssi";
        Object object3 = n10;
        ((HashMap)object).put(object2, object3);
        object3 = this.val$scanResult;
        try {
            ((ArrayList)object3).add(object);
        }
        catch (Throwable throwable) {
            object3 = MobLog.getInstance();
            object2 = new StringBuilder;
            ((StringBuilder)object2)();
            Object[] objectArray = throwable.getMessage();
            ((StringBuilder)object2).append((String)objectArray);
            ((StringBuilder)object2).append("");
            object2 = ((StringBuilder)object2).toString();
            objectArray = new Object[]{};
            ((NLog)object3).d(throwable, object2, objectArray);
        }
    }
}

