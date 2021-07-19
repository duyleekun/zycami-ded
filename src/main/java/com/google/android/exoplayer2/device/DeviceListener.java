/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.device;

import com.google.android.exoplayer2.device.DeviceInfo;

public interface DeviceListener {
    default public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
    }

    default public void onDeviceVolumeChanged(int n10, boolean bl2) {
    }
}

