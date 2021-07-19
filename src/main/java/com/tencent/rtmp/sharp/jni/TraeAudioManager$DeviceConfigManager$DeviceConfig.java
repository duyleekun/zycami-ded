/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.rtmp.sharp.jni;

import com.tencent.rtmp.sharp.jni.TraeAudioManager;
import com.tencent.rtmp.sharp.jni.TraeAudioManager$DeviceConfigManager;

public class TraeAudioManager$DeviceConfigManager$DeviceConfig {
    public String deviceName = "DEVICE_NONE";
    public int priority = 0;
    public final /* synthetic */ TraeAudioManager$DeviceConfigManager this$1;
    public boolean visible = false;

    public TraeAudioManager$DeviceConfigManager$DeviceConfig(TraeAudioManager$DeviceConfigManager traeAudioManager$DeviceConfigManager) {
        this.this$1 = traeAudioManager$DeviceConfigManager;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public int getPriority() {
        return this.priority;
    }

    public boolean getVisible() {
        return this.visible;
    }

    public boolean init(String string2, int n10) {
        boolean bl2;
        if (string2 != null && (bl2 = string2.length()) > false) {
            boolean bl3;
            bl2 = TraeAudioManager.checkDevName(string2);
            if (bl2 != (bl3 = true)) {
                return false;
            }
            this.deviceName = string2;
            this.priority = n10;
            return bl3;
        }
        return false;
    }

    public void setVisible(boolean bl2) {
        this.visible = bl2;
    }
}

