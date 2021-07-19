/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.le.BluetoothLeScanner
 *  android.bluetooth.le.ScanCallback
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.BHelper;
import com.mob.tools.utils.BHelper$BScanCallback;
import java.util.ArrayList;

public class BHelper$7
implements Handler.Callback {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ BHelper$BScanCallback val$bScanCallback;
    public final /* synthetic */ BluetoothLeScanner val$mBLEScanner;
    public final /* synthetic */ ScanCallback val$mScanCallback;
    public final /* synthetic */ ArrayList val$scanResult;

    public BHelper$7(BHelper bHelper, BluetoothLeScanner bluetoothLeScanner, ScanCallback scanCallback, BHelper$BScanCallback bHelper$BScanCallback, ArrayList arrayList) {
        this.this$0 = bHelper;
        this.val$mBLEScanner = bluetoothLeScanner;
        this.val$mScanCallback = scanCallback;
        this.val$bScanCallback = bHelper$BScanCallback;
        this.val$scanResult = arrayList;
    }

    public boolean handleMessage(Message object) {
        BHelper.access$202(this.this$0, false);
        object = this.val$mBLEScanner;
        Object object2 = this.val$mScanCallback;
        object.stopScan(object2);
        object = this.val$bScanCallback;
        object2 = this.val$scanResult;
        object.onScan((ArrayList)object2);
        return false;
    }
}

