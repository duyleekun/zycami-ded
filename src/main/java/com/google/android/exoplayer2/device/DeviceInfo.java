/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.device;

public final class DeviceInfo {
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final DeviceInfo UNKNOWN;
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;

    static {
        DeviceInfo deviceInfo;
        UNKNOWN = deviceInfo = new DeviceInfo(0, 0, 0);
    }

    public DeviceInfo(int n10, int n11, int n12) {
        this.playbackType = n10;
        this.minVolume = n11;
        this.maxVolume = n12;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof DeviceInfo;
        if (n11 == 0) {
            return false;
        }
        object = (DeviceInfo)object;
        n11 = this.playbackType;
        int n12 = ((DeviceInfo)object).playbackType;
        if (n11 != n12 || (n11 = this.minVolume) != (n12 = ((DeviceInfo)object).minVolume) || (n11 = this.maxVolume) != (n10 = ((DeviceInfo)object).maxVolume)) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.playbackType;
        int n11 = (527 + n10) * 31;
        n10 = this.minVolume;
        n11 = (n11 + n10) * 31;
        n10 = this.maxVolume;
        return n11 + n10;
    }
}

