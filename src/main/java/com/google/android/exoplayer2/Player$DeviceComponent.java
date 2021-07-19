/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;

public interface Player$DeviceComponent {
    public void addDeviceListener(DeviceListener var1);

    public void decreaseDeviceVolume();

    public DeviceInfo getDeviceInfo();

    public int getDeviceVolume();

    public void increaseDeviceVolume();

    public boolean isDeviceMuted();

    public void removeDeviceListener(DeviceListener var1);

    public void setDeviceMuted(boolean var1);

    public void setDeviceVolume(int var1);
}

