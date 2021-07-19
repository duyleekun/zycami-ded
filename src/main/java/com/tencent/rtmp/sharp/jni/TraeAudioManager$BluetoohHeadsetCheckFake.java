/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 */
package com.tencent.rtmp.sharp.jni;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$BluetoohHeadsetCheckInterface;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;

public class TraeAudioManager$BluetoohHeadsetCheckFake
extends TraeAudioManager$BluetoohHeadsetCheckInterface {
    public final /* synthetic */ TraeAudioManager this$0;

    public TraeAudioManager$BluetoohHeadsetCheckFake(TraeAudioManager traeAudioManager) {
        this.this$0 = traeAudioManager;
        super(traeAudioManager);
    }

    public void _addAction(IntentFilter intentFilter) {
    }

    public void _onReceive(Context context, Intent intent) {
    }

    public boolean init(Context context, TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager) {
        return true;
    }

    public String interfaceDesc() {
        return "BluetoohHeadsetCheckFake";
    }

    public boolean isConnected() {
        return false;
    }

    public void release() {
    }
}

