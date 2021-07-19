/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.Intent
 */
package com.mob.tools.utils;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.BHelper;
import com.mob.tools.utils.BHelper$BOperationCallback;
import java.util.HashMap;
import java.util.Map;

public class BHelper$1
extends BroadcastReceiver {
    public final /* synthetic */ BHelper this$0;

    public BHelper$1(BHelper bHelper) {
        this.this$0 = bHelper;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onReceive(Context objectArray, Intent object) {
        objectArray = null;
        try {
            Object object2 = object.getAction();
            Object object3 = "android.bluetooth.adapter.action.STATE_CHANGED";
            int n10 = ((String)object2).equals(object3);
            if (n10 != 0) {
                object2 = "android.bluetooth.adapter.extra.STATE";
                int n11 = object.getIntExtra((String)object2, 0);
                object3 = "android.bluetooth.adapter.extra.PREVIOUS_STATE";
                object.getIntExtra((String)object3, 0);
                int n12 = 10;
                if (n11 != n12) {
                    n12 = 12;
                    if (n11 != n12) {
                        return;
                    }
                    object = this.this$0;
                    if ((object = BHelper.access$000((BHelper)object)) == null) return;
                    object = this.this$0;
                    n12 = (int)((object = BHelper.access$000((BHelper)object)).isEmpty() ? 1 : 0);
                    if (n12 != 0) return;
                    object = this.this$0;
                    object = BHelper.access$000((BHelper)object);
                    object = object.entrySet();
                    object = object.iterator();
                    while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                        object2 = object.next();
                        object2 = (Map.Entry)object2;
                        object2 = object2.getValue();
                        if ((object2 = (BHelper$BOperationCallback)object2) == null) continue;
                        ((BHelper$BOperationCallback)object2).onEnabled();
                    }
                    return;
                }
                object = this.this$0;
                if ((object = BHelper.access$000((BHelper)object)) == null) return;
                object = this.this$0;
                n12 = (int)((object = BHelper.access$000((BHelper)object)).isEmpty() ? 1 : 0);
                if (n12 != 0) return;
                object = this.this$0;
                object = BHelper.access$000((BHelper)object);
                object = object.entrySet();
                object = object.iterator();
                while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                    object2 = object.next();
                    object2 = (Map.Entry)object2;
                    object2 = object2.getValue();
                    if ((object2 = (BHelper$BOperationCallback)object2) == null) continue;
                    ((BHelper$BOperationCallback)object2).onDisabled();
                }
                return;
            }
            object3 = "android.bluetooth.adapter.action.CONNECTION_STATE_CHANGED";
            n10 = ((String)object2).equals(object3);
            String string2 = "android.bluetooth.device.extra.DEVICE";
            if (n10 != 0) {
                object2 = "android.bluetooth.adapter.extra.CONNECTION_STATE";
                int n13 = object.getIntExtra((String)object2, 0);
                object3 = "android.bluetooth.adapter.extra.PREVIOUS_CONNECTION_STATE";
                object.getIntExtra((String)object3, 0);
                object = object.getParcelableExtra(string2);
                object = (BluetoothDevice)object;
                object3 = this.this$0;
                object = BHelper.access$100((BHelper)object3, (BluetoothDevice)object);
                if (n13 != 0) {
                    n10 = 2;
                    if (n13 != n10) {
                        return;
                    }
                    object2 = this.this$0;
                    if ((object2 = BHelper.access$000((BHelper)object2)) == null) return;
                    object2 = this.this$0;
                    n13 = (int)((object2 = BHelper.access$000((BHelper)object2)).isEmpty() ? 1 : 0);
                    if (n13 != 0) return;
                    object2 = this.this$0;
                    object2 = BHelper.access$000(object2);
                    object2 = object2.entrySet();
                    object2 = object2.iterator();
                    while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                        object3 = object2.next();
                        object3 = (Map.Entry)object3;
                        object3 = object3.getValue();
                        if ((object3 = (BHelper$BOperationCallback)object3) == null) continue;
                        boolean bl2 = true;
                        ((BHelper$BOperationCallback)object3).onConnectionChanged(bl2, (HashMap)object);
                    }
                    return;
                }
                object2 = this.this$0;
                if ((object2 = BHelper.access$000((BHelper)object2)) == null) return;
                object2 = this.this$0;
                n13 = (int)((object2 = BHelper.access$000((BHelper)object2)).isEmpty() ? 1 : 0);
                if (n13 != 0) return;
                object2 = this.this$0;
                object2 = BHelper.access$000(object2);
                object2 = object2.entrySet();
                object2 = object2.iterator();
                while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object3 = object2.next();
                    object3 = (Map.Entry)object3;
                    object3 = object3.getValue();
                    if ((object3 = (BHelper$BOperationCallback)object3) == null) continue;
                    ((BHelper$BOperationCallback)object3).onConnectionChanged(false, (HashMap)object);
                }
                return;
            }
            object3 = "android.bluetooth.device.action.ACL_CONNECTED";
            n10 = ((String)object2).equals(object3);
            if (n10 != 0) {
                object = object.getParcelableExtra(string2);
                object = (BluetoothDevice)object;
                object2 = this.this$0;
                object = BHelper.access$100((BHelper)object2, (BluetoothDevice)object);
                object2 = this.this$0;
                if ((object2 = BHelper.access$000((BHelper)object2)) == null) return;
                object2 = this.this$0;
                boolean bl3 = (object2 = BHelper.access$000((BHelper)object2)).isEmpty();
                if (bl3) return;
                object2 = this.this$0;
                object2 = BHelper.access$000((BHelper)object2);
                object2 = object2.entrySet();
                object2 = object2.iterator();
                while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                    object3 = object2.next();
                    object3 = (Map.Entry)object3;
                    object3 = object3.getValue();
                    if ((object3 = (BHelper$BOperationCallback)object3) == null) continue;
                    ((BHelper$BOperationCallback)object3).onDeviceConnected((HashMap)object);
                }
                return;
            }
            object3 = "android.bluetooth.device.action.ACL_DISCONNECTED";
            boolean bl4 = ((String)object2).equals(object3);
            if (!bl4) return;
            object = object.getParcelableExtra(string2);
            object = (BluetoothDevice)object;
            object2 = this.this$0;
            object = BHelper.access$100((BHelper)object2, (BluetoothDevice)object);
            object2 = this.this$0;
            if ((object2 = BHelper.access$000((BHelper)object2)) == null) return;
            object2 = this.this$0;
            bl4 = (object2 = BHelper.access$000((BHelper)object2)).isEmpty();
            if (bl4) return;
            object2 = this.this$0;
            object2 = BHelper.access$000(object2);
            object2 = object2.entrySet();
            object2 = object2.iterator();
            while ((n10 = (int)(object2.hasNext() ? 1 : 0)) != 0) {
                object3 = object2.next();
                object3 = (Map.Entry)object3;
                object3 = object3.getValue();
                if ((object3 = (BHelper$BOperationCallback)object3) == null) continue;
                ((BHelper$BOperationCallback)object3).onDeviceDisconnected((HashMap)object);
            }
            return;
        }
        catch (Throwable throwable) {
            NLog nLog = MobLog.getInstance();
            CharSequence charSequence = new StringBuilder();
            String string3 = throwable.getMessage();
            charSequence.append(string3);
            string3 = "";
            charSequence.append(string3);
            charSequence = charSequence.toString();
            objectArray = new Object[]{};
            nLog.d(throwable, (Object)charSequence, objectArray);
        }
    }
}

