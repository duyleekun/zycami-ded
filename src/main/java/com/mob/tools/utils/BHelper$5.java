/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.bluetooth.BluetoothAdapter$LeScanCallback
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.BHelper;
import com.mob.tools.utils.BHelper$BScanCallback;
import java.util.ArrayList;

public class BHelper$5
implements Handler.Callback {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ BluetoothAdapter val$adapter;
    public final /* synthetic */ BHelper$BScanCallback val$bScanCallback;
    public final /* synthetic */ BluetoothAdapter.LeScanCallback val$leScanCallback;
    public final /* synthetic */ ArrayList val$scanResult;

    public BHelper$5(BHelper bHelper, BluetoothAdapter bluetoothAdapter, BluetoothAdapter.LeScanCallback leScanCallback, BHelper$BScanCallback bHelper$BScanCallback, ArrayList arrayList) {
        this.this$0 = bHelper;
        this.val$adapter = bluetoothAdapter;
        this.val$leScanCallback = leScanCallback;
        this.val$bScanCallback = bHelper$BScanCallback;
        this.val$scanResult = arrayList;
    }

    public boolean handleMessage(Message object) {
        BHelper.access$202(this.this$0, false);
        object = this.val$adapter;
        Object object2 = this.val$leScanCallback;
        object.stopLeScan(object2);
        object = this.val$bScanCallback;
        object2 = this.val$scanResult;
        object.onScan((ArrayList)object2);
        return false;
    }
}

