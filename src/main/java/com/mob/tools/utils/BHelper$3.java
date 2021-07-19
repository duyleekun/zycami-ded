/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 *  android.os.Handler
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BHelper;
import com.mob.tools.utils.BHelper$BScanCallback;
import java.util.ArrayList;
import java.util.HashMap;

public class BHelper$3
extends BroadcastReceiver {
    public final /* synthetic */ BHelper this$0;
    public final /* synthetic */ BHelper$BScanCallback val$bScanCallback;
    public final /* synthetic */ Handler val$handler;
    public final /* synthetic */ ArrayList val$scanResult;

    public BHelper$3(BHelper bHelper, ArrayList arrayList, BHelper$BScanCallback bScanCallback, Handler handler) {
        this.this$0 = bHelper;
        this.val$scanResult = arrayList;
        this.val$bScanCallback = bScanCallback;
        this.val$handler = handler;
    }

    public void onReceive(Context objectArray, Intent object) {
        block26: {
            boolean bl2;
            Object[] objectArray2;
            Object object2;
            block25: {
                block24: {
                    objectArray = null;
                    object2 = object.getAction();
                    objectArray2 = "android.bluetooth.device.action.FOUND";
                    boolean bl3 = ((String)object2).equals(objectArray2);
                    if (!bl3) break block24;
                    object2 = "android.bluetooth.device.extra.DEVICE";
                    object2 = object.getParcelableExtra((String)object2);
                    object2 = (BluetoothDevice)object2;
                    objectArray2 = this.this$0;
                    object2 = BHelper.access$100((BHelper)objectArray2, (BluetoothDevice)object2);
                    objectArray2 = "android.bluetooth.device.extra.RSSI";
                    short s10 = object.getShortExtra((String)objectArray2, (short)0);
                    objectArray2 = "rssi";
                    object = s10;
                    ((HashMap)object2).put(objectArray2, object);
                    object = this.val$scanResult;
                    ((ArrayList)object).add(object2);
                }
                object = "android.bluetooth.adapter.action.DISCOVERY_STARTED";
                bl2 = ((String)object2).equals(object);
                if (!bl2) break block25;
                object = MobLog.getInstance();
                object2 = "started";
                objectArray2 = new Object[]{};
                ((NLog)object).d(object2, objectArray2);
            }
            object = "android.bluetooth.adapter.action.DISCOVERY_FINISHED";
            bl2 = ((String)object2).equals(object);
            if (!bl2) break block26;
            object = MobLog.getInstance();
            object2 = "done";
            objectArray2 = new Object[]{};
            ((NLog)object).d(object2, objectArray2);
            object = this.this$0;
            BHelper.access$202((BHelper)object, false);
            object = this.val$bScanCallback;
            object2 = this.val$scanResult;
            object.onScan((ArrayList)object2);
            object = this.val$handler;
            object.removeMessages(0);
            object = this.this$0;
            try {
                ((BHelper)object).unRegisterBScanReceiver();
            }
            catch (Throwable throwable) {
                object2 = MobLog.getInstance();
                objectArray2 = new StringBuilder();
                String string2 = throwable.getMessage();
                objectArray2.append(string2);
                string2 = "";
                objectArray2.append(string2);
                objectArray2 = objectArray2.toString();
                objectArray = new Object[]{};
                ((NLog)object2).d(throwable, (Object)objectArray2, objectArray);
            }
        }
    }
}

