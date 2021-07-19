/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothAdapter;
import android.os.Handler;
import android.os.Message;
import com.mob.tools.utils.BHelper;

public class BHelper$2
implements Handler.Callback {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ BluetoothAdapter val$adapter;

    public BHelper$2(BHelper bHelper, BluetoothAdapter bluetoothAdapter) {
        this.this$0 = bHelper;
        this.val$adapter = bluetoothAdapter;
    }

    public boolean handleMessage(Message message) {
        this.val$adapter.cancelDiscovery();
        return false;
    }
}

