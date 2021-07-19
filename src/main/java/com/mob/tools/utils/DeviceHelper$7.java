/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.utils;

import com.mob.tools.utils.BHelper$BOperationCallback;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.DeviceHelper$BtWatcher;
import java.util.HashMap;

public class DeviceHelper$7
extends BHelper$BOperationCallback {
    public final /* synthetic */ DeviceHelper this$0;
    public final /* synthetic */ DeviceHelper$BtWatcher val$btWatcher;

    public DeviceHelper$7(DeviceHelper deviceHelper, DeviceHelper$BtWatcher deviceHelper$BtWatcher) {
        this.this$0 = deviceHelper;
        this.val$btWatcher = deviceHelper$BtWatcher;
    }

    public void onConnectionChanged(boolean bl2, HashMap hashMap) {
        this.val$btWatcher.onBtConnectionChanged(bl2, hashMap);
    }

    public void onDeviceConnected(HashMap hashMap) {
        this.val$btWatcher.onDeviceConnected(hashMap);
    }

    public void onDeviceDisconnected(HashMap hashMap) {
        this.val$btWatcher.onDeviceDisconnected(hashMap);
    }

    public void onDisabled() {
        this.val$btWatcher.onBtDisabled();
    }

    public void onEnabled() {
        this.val$btWatcher.onBtEnabled();
    }
}

